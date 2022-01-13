package de.onyxbits.raccoon.standalone.gui.unlock;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UnlockAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = UnlockAction.class.getSimpleName();
   private ModuleProvider provider;
   private String message;
   private String title;

   public UnlockAction(ModuleProvider provider, String title, String message) {
      super(provider);
      this.provider = provider;
      this.title = title;
      this.message = message;
      this.putValue("Name", Messages.t(ID.concat(".name")));
      this.putValue("ShortDescription", Messages.t(ID.concat(".short_description")));
      this.putValue("SwingLargeIconKey", new ImageIcon(Messages.i(ID.concat("_lg.png")), (String)null));
      this.putValue("SmallIcon", new ImageIcon(Messages.i(ID.concat("_sm.png")), (String)null));
   }

   public void actionPerformed(ActionEvent e) {
      showDialog(windowOf((Component)e.getSource()), this.provider, this.title, this.message);
   }

   public static void showDialog(Window parent, ModuleProvider provider, String title, String message) {
      (new ManualController(provider, parent, title, message)).createWindow().setVisible(true);
   }
}
