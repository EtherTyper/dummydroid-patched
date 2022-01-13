package de.onyxbits.raccoon.standalone.gui.about;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;

public class AboutAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = AboutAction.class.getSimpleName();
   private ModuleProvider provider;

   public AboutAction(ModuleProvider provider) {
      super(provider);
      this.provider = provider;
      this.putValue("Name", Messages.t(ID.concat(".name")));
   }

   public void actionPerformed(ActionEvent e) {
      Window w = windowOf((Component)e.getSource());
      AboutController ctrl = new AboutController(this.provider, w);
      ctrl.getWindow().setVisible(true);
   }
}
