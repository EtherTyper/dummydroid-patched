package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(
   threading = ThreadingBehavior.SAFE_CONDITIONAL
)
public abstract class AbstractConnPool implements ConnPool, ConnPoolControl {
   private final Lock lock;
   private final Condition condition;
   private final ConnFactory connFactory;
   private final Map routeToPool;
   private final Set leased;
   private final LinkedList available;
   private final LinkedList pending;
   private final Map maxPerRoute;
   private volatile boolean isShutDown;
   private volatile int defaultMaxPerRoute;
   private volatile int maxTotal;
   private volatile int validateAfterInactivity;

   public AbstractConnPool(ConnFactory connFactory, int defaultMaxPerRoute, int maxTotal) {
      this.connFactory = (ConnFactory)Args.notNull(connFactory, "Connection factory");
      this.defaultMaxPerRoute = Args.positive(defaultMaxPerRoute, "Max per route value");
      this.maxTotal = Args.positive(maxTotal, "Max total value");
      this.lock = new ReentrantLock();
      this.condition = this.lock.newCondition();
      this.routeToPool = new HashMap();
      this.leased = new HashSet();
      this.available = new LinkedList();
      this.pending = new LinkedList();
      this.maxPerRoute = new HashMap();
   }

   protected abstract PoolEntry createEntry(Object var1, Object var2);

   protected void onLease(PoolEntry entry) {
   }

   protected void onRelease(PoolEntry entry) {
   }

   protected void onReuse(PoolEntry entry) {
   }

   protected boolean validate(PoolEntry entry) {
      return true;
   }

   public boolean isShutdown() {
      return this.isShutDown;
   }

   public void shutdown() throws IOException {
      if (!this.isShutDown) {
         this.isShutDown = true;
         this.lock.lock();

         try {
            Iterator i$ = this.available.iterator();

            PoolEntry entry;
            while(i$.hasNext()) {
               entry = (PoolEntry)i$.next();
               entry.close();
            }

            i$ = this.leased.iterator();

            while(i$.hasNext()) {
               entry = (PoolEntry)i$.next();
               entry.close();
            }

            i$ = this.routeToPool.values().iterator();

            while(i$.hasNext()) {
               RouteSpecificPool pool = (RouteSpecificPool)i$.next();
               pool.shutdown();
            }

            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
         } finally {
            this.lock.unlock();
         }
      }
   }

   private RouteSpecificPool getPool(final Object route) {
      RouteSpecificPool pool = (RouteSpecificPool)this.routeToPool.get(route);
      if (pool == null) {
         pool = new RouteSpecificPool(route) {
            protected PoolEntry createEntry(Object conn) {
               return AbstractConnPool.this.createEntry(route, conn);
            }
         };
         this.routeToPool.put(route, pool);
      }

      return pool;
   }

   public Future lease(final Object route, final Object state, final FutureCallback callback) {
      Args.notNull(route, "Route");
      Asserts.check(!this.isShutDown, "Connection pool shut down");
      return new Future() {
         private final AtomicBoolean cancelled = new AtomicBoolean(false);
         private final AtomicBoolean done = new AtomicBoolean(false);
         private final AtomicReference entryRef = new AtomicReference((Object)null);

         public boolean cancel(boolean mayInterruptIfRunning) {
            if (this.cancelled.compareAndSet(false, true)) {
               this.done.set(true);
               AbstractConnPool.this.lock.lock();

               try {
                  AbstractConnPool.this.condition.signalAll();
               } finally {
                  AbstractConnPool.this.lock.unlock();
               }

               if (callback != null) {
                  callback.cancelled();
               }

               return true;
            } else {
               return false;
            }
         }

         public boolean isCancelled() {
            return this.cancelled.get();
         }

         public boolean isDone() {
            return this.done.get();
         }

         public PoolEntry get() throws InterruptedException, ExecutionException {
            try {
               return this.get(0L, TimeUnit.MILLISECONDS);
            } catch (TimeoutException var2) {
               throw new ExecutionException(var2);
            }
         }

         public PoolEntry get(long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            PoolEntry entry = (PoolEntry)this.entryRef.get();
            if (entry != null) {
               return entry;
            } else {
               synchronized(this) {
                  try {
                     while(true) {
                        PoolEntry leasedEntry = AbstractConnPool.this.getPoolEntryBlocking(route, state, timeout, timeUnit, this);
                        if (AbstractConnPool.this.validateAfterInactivity <= 0 || leasedEntry.getUpdated() + (long)AbstractConnPool.this.validateAfterInactivity > System.currentTimeMillis() || AbstractConnPool.this.validate(leasedEntry)) {
                           this.entryRef.set(leasedEntry);
                           this.done.set(true);
                           AbstractConnPool.this.onLease(leasedEntry);
                           if (callback != null) {
                              callback.completed(leasedEntry);
                           }

                           PoolEntry var10000 = leasedEntry;
                           return var10000;
                        }

                        leasedEntry.close();
                        AbstractConnPool.this.release(leasedEntry, false);
                     }
                  } catch (IOException var8) {
                     this.done.set(true);
                     if (callback != null) {
                        callback.failed(var8);
                     }

                     throw new ExecutionException(var8);
                  }
               }
            }
         }
      };
   }

   public Future lease(Object route, Object state) {
      return this.lease(route, state, (FutureCallback)null);
   }

   private PoolEntry getPoolEntryBlocking(Object route, Object state, long timeout, TimeUnit timeUnit, Future future) throws IOException, InterruptedException, TimeoutException {
      Date deadline = null;
      if (timeout > 0L) {
         deadline = new Date(System.currentTimeMillis() + timeUnit.toMillis(timeout));
      }

      this.lock.lock();

      try {
         RouteSpecificPool pool = this.getPool(route);

         boolean success;
         do {
            Asserts.check(!this.isShutDown, "Connection pool shut down");

            PoolEntry entry;
            while(true) {
               entry = pool.getFree(state);
               if (entry == null) {
                  break;
               }

               if (entry.isExpired(System.currentTimeMillis())) {
                  entry.close();
               }

               if (!entry.isClosed()) {
                  break;
               }

               this.available.remove(entry);
               pool.free(entry, false);
            }

            if (entry != null) {
               this.available.remove(entry);
               this.leased.add(entry);
               this.onReuse(entry);
               PoolEntry var25 = entry;
               return var25;
            }

            int maxPerRoute = this.getMax(route);
            int excess = Math.max(0, pool.getAllocatedCount() + 1 - maxPerRoute);
            int totalUsed;
            if (excess > 0) {
               for(totalUsed = 0; totalUsed < excess; ++totalUsed) {
                  PoolEntry lastUsed = pool.getLastUsed();
                  if (lastUsed == null) {
                     break;
                  }

                  lastUsed.close();
                  this.available.remove(lastUsed);
                  pool.remove(lastUsed);
               }
            }

            if (pool.getAllocatedCount() < maxPerRoute) {
               totalUsed = this.leased.size();
               int freeCapacity = Math.max(this.maxTotal - totalUsed, 0);
               if (freeCapacity > 0) {
                  int totalAvailable = this.available.size();
                  if (totalAvailable > freeCapacity - 1 && !this.available.isEmpty()) {
                     PoolEntry lastUsed = (PoolEntry)this.available.removeLast();
                     lastUsed.close();
                     RouteSpecificPool otherpool = this.getPool(lastUsed.getRoute());
                     otherpool.remove(lastUsed);
                  }

                  Object conn = this.connFactory.create(route);
                  entry = pool.add(conn);
                  this.leased.add(entry);
                  PoolEntry var29 = entry;
                  return var29;
               }
            }

            success = false;

            try {
               if (future.isCancelled()) {
                  throw new InterruptedException("Operation interrupted");
               }

               pool.queue(future);
               this.pending.add(future);
               if (deadline != null) {
                  success = this.condition.awaitUntil(deadline);
               } else {
                  this.condition.await();
                  success = true;
               }

               if (future.isCancelled()) {
                  throw new InterruptedException("Operation interrupted");
               }
            } finally {
               pool.unqueue(future);
               this.pending.remove(future);
            }
         } while(success || deadline == null || deadline.getTime() > System.currentTimeMillis());

         throw new TimeoutException("Timeout waiting for connection");
      } finally {
         this.lock.unlock();
      }
   }

   public void release(PoolEntry entry, boolean reusable) {
      this.lock.lock();

      try {
         if (this.leased.remove(entry)) {
            RouteSpecificPool pool = this.getPool(entry.getRoute());
            pool.free(entry, reusable);
            if (reusable && !this.isShutDown) {
               this.available.addFirst(entry);
            } else {
               entry.close();
            }

            this.onRelease(entry);
            Future future = pool.nextPending();
            if (future != null) {
               this.pending.remove(future);
            } else {
               future = (Future)this.pending.poll();
            }

            if (future != null) {
               this.condition.signalAll();
            }
         }
      } finally {
         this.lock.unlock();
      }

   }

   private int getMax(Object route) {
      Integer v = (Integer)this.maxPerRoute.get(route);
      return v != null ? v : this.defaultMaxPerRoute;
   }

   public void setMaxTotal(int max) {
      Args.positive(max, "Max value");
      this.lock.lock();

      try {
         this.maxTotal = max;
      } finally {
         this.lock.unlock();
      }

   }

   public int getMaxTotal() {
      this.lock.lock();

      int var1;
      try {
         var1 = this.maxTotal;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public void setDefaultMaxPerRoute(int max) {
      Args.positive(max, "Max per route value");
      this.lock.lock();

      try {
         this.defaultMaxPerRoute = max;
      } finally {
         this.lock.unlock();
      }

   }

   public int getDefaultMaxPerRoute() {
      this.lock.lock();

      int var1;
      try {
         var1 = this.defaultMaxPerRoute;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public void setMaxPerRoute(Object route, int max) {
      Args.notNull(route, "Route");
      this.lock.lock();

      try {
         if (max > -1) {
            this.maxPerRoute.put(route, max);
         } else {
            this.maxPerRoute.remove(route);
         }
      } finally {
         this.lock.unlock();
      }

   }

   public int getMaxPerRoute(Object route) {
      Args.notNull(route, "Route");
      this.lock.lock();

      int var2;
      try {
         var2 = this.getMax(route);
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public PoolStats getTotalStats() {
      this.lock.lock();

      PoolStats var1;
      try {
         var1 = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public PoolStats getStats(Object route) {
      Args.notNull(route, "Route");
      this.lock.lock();

      PoolStats var3;
      try {
         RouteSpecificPool pool = this.getPool(route);
         var3 = new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), this.getMax(route));
      } finally {
         this.lock.unlock();
      }

      return var3;
   }

   public Set getRoutes() {
      this.lock.lock();

      HashSet var1;
      try {
         var1 = new HashSet(this.routeToPool.keySet());
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   protected void enumAvailable(PoolEntryCallback callback) {
      this.lock.lock();

      try {
         Iterator it = this.available.iterator();

         while(it.hasNext()) {
            PoolEntry entry = (PoolEntry)it.next();
            callback.process(entry);
            if (entry.isClosed()) {
               RouteSpecificPool pool = this.getPool(entry.getRoute());
               pool.remove(entry);
               it.remove();
            }
         }

         this.purgePoolMap();
      } finally {
         this.lock.unlock();
      }
   }

   protected void enumLeased(PoolEntryCallback callback) {
      this.lock.lock();

      try {
         Iterator it = this.leased.iterator();

         while(it.hasNext()) {
            PoolEntry entry = (PoolEntry)it.next();
            callback.process(entry);
         }
      } finally {
         this.lock.unlock();
      }

   }

   private void purgePoolMap() {
      Iterator it = this.routeToPool.entrySet().iterator();

      while(it.hasNext()) {
         Entry entry = (Entry)it.next();
         RouteSpecificPool pool = (RouteSpecificPool)entry.getValue();
         if (pool.getPendingCount() + pool.getAllocatedCount() == 0) {
            it.remove();
         }
      }

   }

   public void closeIdle(long idletime, TimeUnit timeUnit) {
      Args.notNull(timeUnit, "Time unit");
      long time = timeUnit.toMillis(idletime);
      if (time < 0L) {
         time = 0L;
      }

      final long deadline = System.currentTimeMillis() - time;
      this.enumAvailable(new PoolEntryCallback() {
         public void process(PoolEntry entry) {
            if (entry.getUpdated() <= deadline) {
               entry.close();
            }

         }
      });
   }

   public void closeExpired() {
      final long now = System.currentTimeMillis();
      this.enumAvailable(new PoolEntryCallback() {
         public void process(PoolEntry entry) {
            if (entry.isExpired(now)) {
               entry.close();
            }

         }
      });
   }

   public int getValidateAfterInactivity() {
      return this.validateAfterInactivity;
   }

   public void setValidateAfterInactivity(int ms) {
      this.validateAfterInactivity = ms;
   }

   public String toString() {
      this.lock.lock();

      String var2;
      try {
         StringBuilder buffer = new StringBuilder();
         buffer.append("[leased: ");
         buffer.append(this.leased);
         buffer.append("][available: ");
         buffer.append(this.available);
         buffer.append("][pending: ");
         buffer.append(this.pending);
         buffer.append("]");
         var2 = buffer.toString();
      } finally {
         this.lock.unlock();
      }

      return var2;
   }
}
