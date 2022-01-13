package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.AppAdapter;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

public class ShutdownAction extends AppAction {
   private static final String ID = ShutdownAction.class.getSimpleName();
   public static final KeyStroke ACCEL;
   private static final long serialVersionUID = 1L;

   public ShutdownAction(ModuleProvider provider) {
      super(provider);
      this.putValue("Name", Messages.t(ID + ".name"));
   }

   public void actionPerformed(ActionEvent e) {
      ((AppAdapter)this.fetch(AppAdapter.class)).exit();
   }

   static {
      ACCEL = KeyStroke.getKeyStroke(81, AppAction.MASK);
   }
}
