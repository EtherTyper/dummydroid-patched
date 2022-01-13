package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler extends AbstractModule {
   private ExecutorService executorService;

   public void schedule(BackgroundTask task) {
      if (this.executorService == null) {
         this.executorService = Executors.newSingleThreadExecutor();
      }

      task.onScheduled(this);
      this.executorService.submit(task);
   }

   public void shutdown() {
      if (this.executorService != null) {
         this.executorService.shutdown();
      }

   }
}
