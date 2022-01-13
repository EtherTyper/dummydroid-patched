package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import de.onyxbits.raccoon.util.TextTool;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class PasteAction extends AbstractAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = PasteAction.class.getSimpleName();
   private PawnModel model;

   public PasteAction(PawnModel model) {
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.model = model;
   }

   public void actionPerformed(ActionEvent e) {
      try {
         String json = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
         MutableDevice d = (MutableDevice)this.model.getDevice();
         d.merge(MockUtil.decodeDevice(json));
      } catch (Exception var6) {
         Component c = AppAction.windowOf((Component)e.getSource());
         String message = TextTool.wordwrap(50, Messages.t(ID + ".err.message"));
         String title = Messages.t(ID + ".err.title");
         JOptionPane.showMessageDialog(c, message, title, 0);
      }

   }
}
