package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;

public abstract class BackgroundTask implements Runnable {
   private Object taskResult;
   private ExecutionException taskException;
   private ModuleProvider provider;

   protected final void onScheduled(ModuleProvider provider) {
      this.provider = provider;
   }

   protected final AbstractModule fetch(Class clazz) {
      return (AbstractModule)this.provider.fetch(clazz);
   }

   protected abstract Object runInBackground() throws Exception;

   protected abstract void runInForeground(Object var1);

   protected abstract void runInForeground(ExecutionException var1);

   public void run() {
      if (SwingUtilities.isEventDispatchThread()) {
         if (this.taskResult != null) {
            this.runInForeground(this.taskResult);
         }

         if (this.taskException != null) {
            this.runInForeground(this.taskException);
         }
      } else {
         try {
            this.taskResult = this.runInBackground();
         } catch (Exception var2) {
            this.taskException = new ExecutionException(var2);
         }

         SwingUtilities.invokeLater(this);
      }

   }
}
