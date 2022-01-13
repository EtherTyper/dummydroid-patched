package de.onyxbits.raccoon.standalone.transfer;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TransferManager extends AbstractModule {
   private ArrayList scheduled = new ArrayList();
   private HashMap workers = new HashMap();

   public void schedule(Transfer transfer) {
      synchronized(this.scheduled) {
         Thread t = (Thread)this.workers.get(transfer.getClass());
         if (t == null) {
            t = new Thread(new Worker(this.scheduled, transfer.getClass()));
            t.start();
            this.workers.put(transfer.getClass(), t);
         }

         this.scheduled.add(transfer);
         this.scheduled.notifyAll();
      }
   }

   public List getQueue() {
      return this.scheduled;
   }

   public void shutdown() {
      Iterator var1 = this.workers.keySet().iterator();

      while(var1.hasNext()) {
         Class c = (Class)var1.next();
         ((Thread)this.workers.get(c)).interrupt();
      }

      synchronized(this.scheduled) {
         this.scheduled.notifyAll();
      }
   }
}
