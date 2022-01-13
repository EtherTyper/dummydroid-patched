package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class CarrierAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = CarrierAction.class.getSimpleName();
   private PawnModel pawn;

   public CarrierAction(ModuleProvider provider, PawnModel pawn) {
      super(provider);
      this.pawn = pawn;
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
   }

   public void actionPerformed(ActionEvent e) {
      String carrier = this.pawn.getMccMnc();
      Object o = JOptionPane.showInputDialog(windowOf((Component)e.getSource()), Messages.t(ID + ".message"), Messages.t(ID + ".windowtitle"), 1, (Icon)null, (Object[])null, carrier);
      if (o != null) {
         String tmp = o.toString();
         if (tmp.length() > 0) {
            try {
               Integer.parseInt(tmp);
               this.pawn.setMccMnc(tmp);
            } catch (NumberFormatException var6) {
               this.pawn.setMccMnc((String)null);
            }
         } else {
            this.pawn.setMccMnc((String)null);
         }
      }

   }
}
