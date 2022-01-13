package de.onyxbits.raccoon.standalone.gui.bridge;

import javax.swing.event.EventListenerList;

class EventRunner implements Runnable {
   private EventListenerList ell;
   private HotplugEvent event;

   public EventRunner(EventListenerList ell, HotplugEvent event) {
      this.ell = ell;
      this.event = event;
   }

   public void run() {
      DirectoryListener[] var1 = (DirectoryListener[])this.ell.getListeners(DirectoryListener.class);
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         DirectoryListener l = var1[var3];
         l.onHotPlug(this.event);
      }

   }
}
