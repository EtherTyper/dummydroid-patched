package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.MockUtil;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyAction extends AbstractAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = CopyAction.class.getSimpleName();
   private PawnModel model;

   public CopyAction(PawnModel model) {
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.model = model;
   }

   public void actionPerformed(ActionEvent e) {
      String json = MockUtil.encodeDevice(this.model.getDevice());
      StringSelection selection = new StringSelection(json);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(selection, selection);
   }
}
