package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.platformtools.bridge.BridgeDirectory;
import de.onyxbits.raccoon.platformtools.bridge.SpecTool;
import de.onyxbits.raccoon.standalone.gui.BackgroundTask;
import de.onyxbits.raccoon.standalone.gui.IdleState;
import de.onyxbits.raccoon.standalone.gui.bridge.DirectoryManager;
import java.awt.Component;
import java.awt.Window;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

public class ProbeDeviceTask extends BackgroundTask {
   private MutableDevice model;
   private BridgeDirectory directory;
   private IdleState idleState;
   private static final String ID = ProbeDeviceTask.class.getSimpleName();

   public ProbeDeviceTask(MutableDevice model, IdleState idleState) {
      this.model = model;
      this.idleState = idleState;
   }

   protected Device runInBackground() throws Exception {
      this.directory = ((DirectoryManager)this.fetch(DirectoryManager.class)).getDirectory();
      SpecTool st = new SpecTool(this.directory.connect((String)null));
      st.install();
      return st.describe();
   }

   protected void runInForeground(Device result) {
      this.model.merge(result);
      this.idleState.setIdle(true);
      boolean error = false;

      try {
         int vc = 1;
         if (result.getApplicationInfo("com.android.vending") != null) {
            vc = result.getApplicationInfo("com.android.vending").versionCode;
         }

         error = error || result.getGlExtensions().size() == 0;
         error = error || result.getLocales().size() == 0;
         error = error || result.getSystemAvailableFeatures().size() == 0;
         error = error || result.getSystemSharedLibraries().size() == 0;
         error = error || result.getInstalledApps().size() == 0;
         error = error || result.getBuild().abi.size() == 0;
         error = error || vc == 1;
      } catch (Exception var6) {
         error = true;
      }

      if (error) {
         Component parent = Window.getWindows()[0];
         String title = Messages.t(ID + ".error.title");
         String message = Messages.t(ID + ".error.message");
         JOptionPane.showMessageDialog(parent, message, title, 2);
      }

   }

   protected void runInForeground(ExecutionException result) {
      this.idleState.setIdle(true);
   }
}
