package de.onyxbits.raccoon.standalone.gui.about;

import de.onyxbits.raccoon.standalone.base.AppAdapter;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

public class HomeAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = HomeAction.class.getSimpleName();

   public HomeAction(ModuleProvider provider) {
      super(provider);
      this.putValue("Name", Messages.t(ID.concat(".name")));
   }

   public void actionPerformed(ActionEvent e) {
      Desktop desktop = Desktop.getDesktop();
      if (desktop.isSupported(Action.BROWSE)) {
         try {
            desktop.open(((AppAdapter)this.fetch(AppAdapter.class)).pathOf());
         } catch (Exception var4) {
         }
      }

   }
}
