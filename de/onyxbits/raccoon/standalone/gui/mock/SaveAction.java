package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.Uplink;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SaveAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = SaveAction.class.getSimpleName();
   private PawnModel model;

   public SaveAction(ModuleProvider provider, PawnModel pawn) {
      super(provider);
      this.model = pawn;
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.setEnabled(!((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly());
   }

   public void actionPerformed(ActionEvent e) {
      if (this.model.getAlias() != null) {
         try {
            ((Uplink)this.fetch(Uplink.class)).savePawn(this.model);
         } catch (IOException var4) {
            Component parent = windowOf((Component)e.getSource());
            JOptionPane.showMessageDialog(windowOf(parent), var4.getMessage(), Messages.t(ID + ".title"), 0);
         }
      } else {
         (new SaveAsAction(this, this.model)).actionPerformed(e);
      }

   }
}
