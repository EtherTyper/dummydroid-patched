package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class GsfIdAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = GsfIdAction.class.getSimpleName();
   private PawnModel pawn;

   public GsfIdAction(ModuleProvider provider, PawnModel pawn) {
      super(provider);
      this.pawn = pawn;
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
   }

   public void actionPerformed(ActionEvent e) {
      String gsf = this.pawn.getHexGsfId();
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         gsf = this.pawn.getRedactedGsfId();
      }

      JOptionPane.showInputDialog(windowOf((Component)e.getSource()), Messages.t(ID + ".message"), Messages.t(ID + ".windowtitle"), 1, (Icon)null, (Object[])null, gsf);
   }
}
