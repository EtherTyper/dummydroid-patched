package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.event.ActionEvent;

public class NewAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = NewAction.class.getSimpleName();
   private PawnModel model;

   public NewAction(ModuleProvider provider, PawnModel pawn) {
      super(provider);
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.model = pawn;
   }

   public void actionPerformed(ActionEvent e) {
      this.model.clear();
   }
}
