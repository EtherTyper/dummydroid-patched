package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpClientConnectionOperator;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolEntryCallback;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(
   threading = ThreadingBehavior.SAFE_CONDITIONAL
)
public class PoolingHttpClientConnectionManager implements HttpClientConnectionManager, ConnPoolControl, Closeable {
   private final Log log;
   private final PoolingHttpClientConnectionManager.ConfigData configData;
   private final CPool pool;
   private final HttpClientConnectionOperator connectionOperator;
   private final AtomicBoolean isShutDown;

   private static Registry getDefaultRegistry() {
      return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
   }

   public PoolingHttpClientConnectionManager() {
      this(getDefaultRegistry());
   }

   public PoolingHttpClientConnectionManager(long timeToLive, TimeUnit timeUnit) {
      this(getDefaultRegistry(), (HttpConnectionFactory)null, (SchemePortResolver)null, (DnsResolver)null, timeToLive, timeUnit);
   }

   public PoolingHttpClientConnectionManager(Registry socketFactoryRegistry) {
      this(socketFactoryRegistry, (HttpConnectionFactory)null, (DnsResolver)null);
   }

   public PoolingHttpClientConnectionManager(Registry socketFactoryRegistry, DnsResolver dnsResolver) {
      this(socketFactoryRegistry, (HttpConnectionFactory)null, dnsResolver);
   }

   public PoolingHttpClientConnectionManager(Registry socketFactoryRegistry, HttpConnectionFactory connFactory) {
      this(socketFactoryRegistry, connFactory, (DnsResolver)null);
   }

   public PoolingHttpClientConnectionManager(HttpConnectionFactory connFactory) {
      this(getDefaultRegistry(), connFactory, (DnsResolver)null);
   }

   public PoolingHttpClientConnectionManager(Registry socketFactoryRegistry, HttpConnectionFactory connFactory, DnsResolver dnsResolver) {
      this(socketFactoryRegistry, connFactory, (SchemePortResolver)null, dnsResolver, -1L, TimeUnit.MILLISECONDS);
   }

   public PoolingHttpClientConnectionManager(Registry socketFactoryRegistry, HttpConnectionFactory connFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver, long timeToLive, TimeUnit timeUnit) {
      this(new DefaultHttpClientConnectionOperator(socketFactoryRegistry, schemePortResolver, dnsResolver), connFactory, timeToLive, timeUnit);
   }

   public PoolingHttpClientConnectionManager(HttpClientConnectionOperator httpClientConnectionOperator, HttpConnectionFactory connFactory, long timeToLive, TimeUnit timeUnit) {
      this.log = LogFactory.getLog(this.getClass());
      this.configData = new PoolingHttpClientConnectionManager.ConfigData();
      this.pool = new CPool(new PoolingHttpClientConnectionManager.InternalConnectionFactory(this.configData, connFactory), 2, 20, timeToLive, timeUnit);
      this.pool.setValidateAfterInactivity(2000);
      this.connectionOperator = (HttpClientConnectionOperator)Args.notNull(httpClientConnectionOperator, "HttpClientConnectionOperator");
      this.isShutDown = new AtomicBoolean(false);
   }

   PoolingHttpClientConnectionManager(CPool pool, Lookup socketFactoryRegistry, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
      this.log = LogFactory.getLog(this.getClass());
      this.configData = new PoolingHttpClientConnectionManager.ConfigData();
      this.pool = pool;
      this.connectionOperator = new DefaultHttpClientConnectionOperator(socketFactoryRegistry, schemePortResolver, dnsResolver);
      this.isShutDown = new AtomicBoolean(false);
   }

   protected void finalize() throws Throwable {
      try {
         this.shutdown();
      } finally {
         super.finalize();
      }

   }

   public void close() {
      this.shutdown();
   }

   private String format(HttpRoute route, Object state) {
      StringBuilder buf = new StringBuilder();
      buf.append("[route: ").append(route).append("]");
      if (state != null) {
         buf.append("[state: ").append(state).append("]");
      }

      return buf.toString();
   }

   private String formatStats(HttpRoute route) {
      StringBuilder buf = new StringBuilder();
      PoolStats totals = this.pool.getTotalStats();
      PoolStats stats = this.pool.getStats(route);
      buf.append("[total kept alive: ").append(totals.getAvailable()).append("; ");
      buf.append("route allocated: ").append(stats.getLeased() + stats.getAvailable());
      buf.append(" of ").append(stats.getMax()).append("; ");
      buf.append("total allocated: ").append(totals.getLeased() + totals.getAvailable());
      buf.append(" of ").append(totals.getMax()).append("]");
      return buf.toString();
   }

   private String format(CPoolEntry entry) {
      StringBuilder buf = new StringBuilder();
      buf.append("[id: ").append(entry.getId()).append("]");
      buf.append("[route: ").append(entry.getRoute()).append("]");
      Object state = entry.getState();
      if (state != null) {
         buf.append("[state: ").append(state).append("]");
      }

      return buf.toString();
   }

   private SocketConfig resolveSocketConfig(HttpHost host) {
      SocketConfig socketConfig = this.configData.getSocketConfig(host);
      if (socketConfig == null) {
         socketConfig = this.configData.getDefaultSocketConfig();
      }

      if (socketConfig == null) {
         socketConfig = SocketConfig.DEFAULT;
      }

      return socketConfig;
   }

   public ConnectionRequest requestConnection(final HttpRoute route, Object state) {
      Args.notNull(route, "HTTP route");
      if (this.log.isDebugEnabled()) {
         this.log.debug("Connection request: " + this.format(route, state) + this.formatStats(route));
      }

      final Future future = this.pool.lease(route, state, (FutureCallback)null);
      return new ConnectionRequest() {
         public boolean cancel() {
            return future.cancel(true);
         }

         public HttpClientConnection get(long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
            HttpClientConnection conn = PoolingHttpClientConnectionManager.this.leaseConnection(future, timeout, timeUnit);
            if (conn.isOpen()) {
               HttpHost host;
               if (route.getProxyHost() != null) {
                  host = route.getProxyHost();
               } else {
                  host = route.getTargetHost();
               }

               SocketConfig socketConfig = PoolingHttpClientConnectionManager.this.resolveSocketConfig(host);
               conn.setSocketTimeout(socketConfig.getSoTimeout());
            }

            return conn;
         }
      };
   }

   protected HttpClientConnection leaseConnection(Future future, long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
      try {
         CPoolEntry entry = (CPoolEntry)future.get(timeout, timeUnit);
         if (entry != null && !future.isCancelled()) {
            Asserts.check(entry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
               this.log.debug("Connection leased: " + this.format(entry) + this.formatStats((HttpRoute)entry.getRoute()));
            }

            return CPoolProxy.newProxy(entry);
         } else {
            throw new ExecutionException(new CancellationException("Operation cancelled"));
         }
      } catch (TimeoutException var7) {
         throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
      }
   }

   public void releaseConnection(HttpClientConnection managedConn, Object state, long keepalive, TimeUnit timeUnit) {
      Args.notNull(managedConn, "Managed connection");
      synchronized(managedConn) {
         CPoolEntry entry = CPoolProxy.detach(managedConn);
         if (entry != null) {
            ManagedHttpClientConnection conn = (ManagedHttpClientConnection)entry.getConnection();

            try {
               if (conn.isOpen()) {
                  TimeUnit effectiveUnit = timeUnit != null ? timeUnit : TimeUnit.MILLISECONDS;
                  entry.setState(state);
                  entry.updateExpiry(keepalive, effectiveUnit);
                  if (this.log.isDebugEnabled()) {
                     String s;
                     if (keepalive > 0L) {
                        s = "for " + (double)effectiveUnit.toMillis(keepalive) / 1000.0D + " seconds";
                     } else {
                        s = "indefinitely";
                     }

                     this.log.debug("Connection " + this.format(entry) + " can be kept alive " + s);
                  }

                  conn.setSocketTimeout(0);
               }
            } finally {
               this.pool.release(entry, conn.isOpen() && entry.isRouteComplete());
               if (this.log.isDebugEnabled()) {
                  this.log.debug("Connection released: " + this.format(entry) + this.formatStats((HttpRoute)entry.getRoute()));
               }

            }

         }
      }
   }

   public void connect(HttpClientConnection managedConn, HttpRoute route, int connectTimeout, HttpContext context) throws IOException {
      Args.notNull(managedConn, "Managed Connection");
      Args.notNull(route, "HTTP route");
      ManagedHttpClientConnection conn;
      synchronized(managedConn) {
         CPoolEntry entry = CPoolProxy.getPoolEntry(managedConn);
         conn = (ManagedHttpClientConnection)entry.getConnection();
      }

      HttpHost host;
      if (route.getProxyHost() != null) {
         host = route.getProxyHost();
      } else {
         host = route.getTargetHost();
      }

      this.connectionOperator.connect(conn, host, route.getLocalSocketAddress(), connectTimeout, this.resolveSocketConfig(host), context);
   }

   public void upgrade(HttpClientConnection managedConn, HttpRoute route, HttpContext context) throws IOException {
      Args.notNull(managedConn, "Managed Connection");
      Args.notNull(route, "HTTP route");
      ManagedHttpClientConnection conn;
      synchronized(managedConn) {
         CPoolEntry entry = CPoolProxy.getPoolEntry(managedConn);
         conn = (ManagedHttpClientConnection)entry.getConnection();
      }

      this.connectionOperator.upgrade(conn, route.getTargetHost(), context);
   }

   public void routeComplete(HttpClientConnection managedConn, HttpRoute route, HttpContext context) throws IOException {
      Args.notNull(managedConn, "Managed Connection");
      Args.notNull(route, "HTTP route");
      synchronized(managedConn) {
         CPoolEntry entry = CPoolProxy.getPoolEntry(managedConn);
         entry.markRouteComplete();
      }
   }

   public void shutdown() {
      if (this.isShutDown.compareAndSet(false, true)) {
         this.log.debug("Connection manager is shutting down");

         try {
            this.pool.shutdown();
         } catch (IOException var2) {
            this.log.debug("I/O exception shutting down connection manager", var2);
         }

         this.log.debug("Connection manager shut down");
      }

   }

   public void closeIdleConnections(long idleTimeout, TimeUnit timeUnit) {
      if (this.log.isDebugEnabled()) {
         this.log.debug("Closing connections idle longer than " + idleTimeout + " " + timeUnit);
      }

      this.pool.closeIdle(idleTimeout, timeUnit);
   }

   public void closeExpiredConnections() {
      this.log.debug("Closing expired connections");
      this.pool.closeExpired();
   }

   protected void enumAvailable(PoolEntryCallback callback) {
      this.pool.enumAvailable(callback);
   }

   protected void enumLeased(PoolEntryCallback callback) {
      this.pool.enumLeased(callback);
   }

   public int getMaxTotal() {
      return this.pool.getMaxTotal();
   }

   public void setMaxTotal(int max) {
      this.pool.setMaxTotal(max);
   }

   public int getDefaultMaxPerRoute() {
      return this.pool.getDefaultMaxPerRoute();
   }

   public void setDefaultMaxPerRoute(int max) {
      this.pool.setDefaultMaxPerRoute(max);
   }

   public int getMaxPerRoute(HttpRoute route) {
      return this.pool.getMaxPerRoute(route);
   }

   public void setMaxPerRoute(HttpRoute route, int max) {
      this.pool.setMaxPerRoute(route, max);
   }

   public PoolStats getTotalStats() {
      return this.pool.getTotalStats();
   }

   public PoolStats getStats(HttpRoute route) {
      return this.pool.getStats(route);
   }

   public Set getRoutes() {
      return this.pool.getRoutes();
   }

   public SocketConfig getDefaultSocketConfig() {
      return this.configData.getDefaultSocketConfig();
   }

   public void setDefaultSocketConfig(SocketConfig defaultSocketConfig) {
      this.configData.setDefaultSocketConfig(defaultSocketConfig);
   }

   public ConnectionConfig getDefaultConnectionConfig() {
      return this.configData.getDefaultConnectionConfig();
   }

   public void setDefaultConnectionConfig(ConnectionConfig defaultConnectionConfig) {
      this.configData.setDefaultConnectionConfig(defaultConnectionConfig);
   }

   public SocketConfig getSocketConfig(HttpHost host) {
      return this.configData.getSocketConfig(host);
   }

   public void setSocketConfig(HttpHost host, SocketConfig socketConfig) {
      this.configData.setSocketConfig(host, socketConfig);
   }

   public ConnectionConfig getConnectionConfig(HttpHost host) {
      return this.configData.getConnectionConfig(host);
   }

   public void setConnectionConfig(HttpHost host, ConnectionConfig connectionConfig) {
      this.configData.setConnectionConfig(host, connectionConfig);
   }

   public int getValidateAfterInactivity() {
      return this.pool.getValidateAfterInactivity();
   }

   public void setValidateAfterInactivity(int ms) {
      this.pool.setValidateAfterInactivity(ms);
   }

   static class InternalConnectionFactory implements ConnFactory {
      private final PoolingHttpClientConnectionManager.ConfigData configData;
      private final HttpConnectionFactory connFactory;

      InternalConnectionFactory(PoolingHttpClientConnectionManager.ConfigData configData, HttpConnectionFactory connFactory) {
         this.configData = configData != null ? configData : new PoolingHttpClientConnectionManager.ConfigData();
         this.connFactory = (HttpConnectionFactory)(connFactory != null ? connFactory : ManagedHttpClientConnectionFactory.INSTANCE);
      }

      public ManagedHttpClientConnection create(HttpRoute route) throws IOException {
         ConnectionConfig config = null;
         if (route.getProxyHost() != null) {
            config = this.configData.getConnectionConfig(route.getProxyHost());
         }

         if (config == null) {
            config = this.configData.getConnectionConfig(route.getTargetHost());
         }

         if (config == null) {
            config = this.configData.getDefaultConnectionConfig();
         }

         if (config == null) {
            config = ConnectionConfig.DEFAULT;
         }

         return (ManagedHttpClientConnection)this.connFactory.create(route, config);
      }
   }

   static class ConfigData {
      private final Map socketConfigMap = new ConcurrentHashMap();
      private final Map connectionConfigMap = new ConcurrentHashMap();
      private volatile SocketConfig defaultSocketConfig;
      private volatile ConnectionConfig defaultConnectionConfig;

      public SocketConfig getDefaultSocketConfig() {
         return this.defaultSocketConfig;
      }

      public void setDefaultSocketConfig(SocketConfig defaultSocketConfig) {
         this.defaultSocketConfig = defaultSocketConfig;
      }

      public ConnectionConfig getDefaultConnectionConfig() {
         return this.defaultConnectionConfig;
      }

      public void setDefaultConnectionConfig(ConnectionConfig defaultConnectionConfig) {
         this.defaultConnectionConfig = defaultConnectionConfig;
      }

      public SocketConfig getSocketConfig(HttpHost host) {
         return (SocketConfig)this.socketConfigMap.get(host);
      }

      public void setSocketConfig(HttpHost host, SocketConfig socketConfig) {
         this.socketConfigMap.put(host, socketConfig);
      }

      public ConnectionConfig getConnectionConfig(HttpHost host) {
         return (ConnectionConfig)this.connectionConfigMap.get(host);
      }

      public void setConnectionConfig(HttpHost host, ConnectionConfig connectionConfig) {
         this.connectionConfigMap.put(host, connectionConfig);
      }
   }
}
