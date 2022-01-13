package de.onyxbits.raccoon.standalone.transfer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Worker implements Runnable {
   private List queue;
   private Class type;

   public Worker(List queue, Class type) {
      this.queue = queue;
      this.type = type;
   }

   public void run() {
      Thread self = Thread.currentThread();

      do {
         List todo = new ArrayList();
         synchronized(this.queue) {
            Iterator var4 = this.queue.iterator();

            while(true) {
               if (!var4.hasNext()) {
                  break;
               }

               Transfer t = (Transfer)var4.next();
               if (t.getState() == 0 && this.type.isInstance(t)) {
                  todo.add(t);
               }
            }
         }

         Iterator var3 = todo.iterator();

         while(var3.hasNext()) {
            Transfer transfer = (Transfer)var3.next();
            if (!self.isInterrupted()) {
               transfer.execute();
            }
         }

         try {
            synchronized(this.queue) {
               this.queue.wait();
            }
         } catch (InterruptedException var9) {
         }
      } while(!self.isInterrupted());

   }
}
