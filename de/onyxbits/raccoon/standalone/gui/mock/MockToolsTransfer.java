package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.gui.IdleState;
import de.onyxbits.raccoon.standalone.gui.bridge.DirectoryManager;
import de.onyxbits.raccoon.standalone.transfer.ToolsTransfer;
import de.onyxbits.raccoon.util.TextTool;
import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.http.client.HttpClient;

class MockToolsTransfer extends ToolsTransfer implements Runnable {
   private static final String ID = MockToolsTransfer.class.getSimpleName();
   private IdleState idleState;
   private DirectoryManager manager;
   private Component parent;

   public MockToolsTransfer(HttpClient client, File dest, IdleState idleState, DirectoryManager manager, Component parent) {
      super(client, dest);
      this.idleState = idleState;
      this.manager = manager;
      this.parent = parent;
   }

   protected void onPostProcess() {
      super.onPostProcess();
      this.manager.isAvailable();
      SwingUtilities.invokeLater(this);
   }

   public void run() {
      if (this.idleState != null) {
         this.idleState.setIdle(true);
      }

      if (this.manager.getDirectory().ping()) {
         JOptionPane.showMessageDialog(this.parent, TextTool.wordwrap(50, Messages.t(ID + ".installed")));
      } else {
         JOptionPane.showMessageDialog(this.parent, TextTool.wordwrap(50, Messages.t(ID + ".error")));
      }

   }
}
