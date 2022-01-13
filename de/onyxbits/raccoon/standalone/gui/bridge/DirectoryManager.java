package de.onyxbits.raccoon.standalone.gui.bridge;

import de.onyxbits.raccoon.platformtools.Binaries;
import de.onyxbits.raccoon.platformtools.bridge.BridgeDirectory;
import de.onyxbits.raccoon.standalone.SystemProperties;
import de.onyxbits.raccoon.standalone.base.AbstractModule;
import de.onyxbits.raccoon.standalone.base.AppAdapter;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.event.EventListenerList;

public class DirectoryManager extends AbstractModule implements SystemProperties {
   private Thread thread;
   private EventListenerList listeners;
   private Directory directory;

   private void ensureRunning() {
      if (this.directory == null || !this.directory.ping()) {
         InetAddress addr = InetAddress.getLoopbackAddress();
         int port = 0;

         try {
            port = Integer.parseInt(System.getProperty("adb.port", "5037"));
         } catch (NumberFormatException var5) {
         }

         try {
            if (System.getProperty("adb.host") != null) {
               addr = InetAddress.getByName(System.getProperty("adb.host"));
            }
         } catch (UnknownHostException var4) {
         }

         Binaries bin = new Binaries(this.pathOf());
         this.listeners = new EventListenerList();
         this.directory = new Directory(bin.pathOfAdb(), addr, port, this.listeners);
         this.thread = new Thread(this.directory);
         this.thread.start();
      }

   }

   public File pathOf() {
      return new File(((AppAdapter)this.fetch(AppAdapter.class)).pathOf(), "platform-tools");
   }

   public BridgeDirectory getDirectory() {
      this.ensureRunning();
      return this.directory;
   }

   public void addDirectoryListener(DirectoryListener listener) {
      this.ensureRunning();
      this.listeners.add(DirectoryListener.class, listener);
   }

   public void removeDirectoryListener(DirectoryListener listener) {
      this.ensureRunning();
      this.listeners.remove(DirectoryListener.class, listener);
   }

   public boolean isAvailable() {
      this.ensureRunning();
      if (this.directory.ping()) {
         return true;
      } else {
         File f = (new Binaries(this.pathOf())).pathOfAdb();
         return f != null && f.exists() && f.canExecute();
      }
   }

   public void shutdown() {
      if (this.directory != null) {
         this.directory.kill();
      }

   }
}
