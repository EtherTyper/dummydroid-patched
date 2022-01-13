package de.onyxbits.raccoon.standalone.base;

class ShutdownHook implements Runnable {
   private AbstractApplication app;
   private boolean running;

   public ShutdownHook(AbstractApplication app) {
      this.app = app;
      this.running = true;
   }

   public void run() {
      if (this.running) {
         this.running = false;
         this.app.shutdown();
      }

   }
}
