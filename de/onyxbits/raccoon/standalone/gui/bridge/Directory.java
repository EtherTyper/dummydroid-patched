package de.onyxbits.raccoon.standalone.gui.bridge;

import de.onyxbits.raccoon.platformtools.bridge.BridgeDirectory;
import java.io.File;
import java.net.InetAddress;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;

class Directory extends BridgeDirectory {
   private EventListenerList listeners;
   private File bin;

   public Directory(File bin, InetAddress addr, int port, EventListenerList listeners) {
      super(addr, port);
      this.listeners = listeners;
      this.bin = bin;
   }

   protected void onHotPlug(List connected, List removed, List added) {
      HotplugEvent event = new HotplugEvent(this, connected, removed, added);
      EventRunner runner = new EventRunner(this.listeners, event);
      SwingUtilities.invokeLater(runner);
   }

   public void run() {
      if (!this.ping()) {
         Runtime rt = Runtime.getRuntime();

         try {
            rt.exec(this.bin.getAbsolutePath() + " start-server").waitFor();
         } catch (Exception var3) {
            return;
         }
      }

      super.run();
   }
}
