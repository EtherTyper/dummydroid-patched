package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.Uplink;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import de.onyxbits.raccoon.standalone.gui.IdleListener;
import de.onyxbits.raccoon.standalone.gui.IdleState;
import de.onyxbits.raccoon.standalone.gui.IdleStateEvent;
import de.onyxbits.raccoon.standalone.gui.Scheduler;
import de.onyxbits.raccoon.standalone.gui.bridge.DirectoryListener;
import de.onyxbits.raccoon.standalone.gui.bridge.DirectoryManager;
import de.onyxbits.raccoon.standalone.gui.bridge.HotplugEvent;
import de.onyxbits.raccoon.standalone.transfer.TransferManager;
import de.onyxbits.raccoon.util.TextTool;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.http.client.HttpClient;

class ProbeDeviceAction extends AppAction implements DirectoryListener, IdleListener {
   private static final long serialVersionUID = 1L;
   private static final String ID = ProbeDeviceAction.class.getSimpleName();
   private MutableDevice model;
   private IdleState idleState;

   public ProbeDeviceAction(ModuleProvider provider, MutableDevice model, IdleState idleState) {
      super(provider);
      this.model = model;
      this.idleState = idleState;
      this.putValue("Name", Messages.t(ID.concat(".name")));
      this.putValue("ShortDescription", Messages.t(ID.concat(".short_description")));
      this.putValue("SwingLargeIconKey", new ImageIcon(Messages.i(ID.concat("_lg.png")), (String)null));
      this.putValue("SmallIcon", new ImageIcon(Messages.i(ID.concat("_sm.png")), (String)null));
      this.setEnabled(this.figureEnabledState());
   }

   private boolean figureEnabledState() {
      if (!((DirectoryManager)this.fetch(DirectoryManager.class)).isAvailable()) {
         return true;
      } else {
         boolean idle = this.idleState.isIdle();
         int count = ((DirectoryManager)this.fetch(DirectoryManager.class)).getDirectory().list().size();
         return idle && count > 0;
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (((DirectoryManager)this.fetch(DirectoryManager.class)).isAvailable()) {
         this.idleState.setIdle(false);
         ProbeDeviceTask task = new ProbeDeviceTask(this.model, this.idleState);
         ((Scheduler)this.fetch(Scheduler.class)).schedule(task);
      } else {
         Window parent = AppAction.windowOf((Component)e.getSource());
         String mes = TextTool.wordwrap(50, Messages.t(ID + ".missing.message"));
         int res = JOptionPane.showOptionDialog(parent, mes, Messages.t(ID + ".missing.title"), 0, 0, (Icon)null, (Object[])null, (Object)null);
         if (res == 0) {
            this.idleState.setIdle(false);
            HttpClient client = ((Uplink)this.fetch(Uplink.class)).createClient();
            File dest = ((DirectoryManager)this.fetch(DirectoryManager.class)).pathOf();
            ((TransferManager)this.fetch(TransferManager.class)).schedule(new MockToolsTransfer(client, dest, this.idleState, (DirectoryManager)this.fetch(DirectoryManager.class), parent));
         }
      }

   }

   public void onHotPlug(HotplugEvent event) {
      this.setEnabled(this.figureEnabledState());
   }

   public void onIdleStateChange(IdleStateEvent event) {
      this.setEnabled(this.figureEnabledState());
   }
}
