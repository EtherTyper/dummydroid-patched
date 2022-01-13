package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public abstract class SecondaryWindowController extends WindowController {
   public static final KeyStroke CLOSE = KeyStroke.getKeyStroke(27, 0);
   private Window owner;
   private ShutdownAction shutdownAction;

   public SecondaryWindowController(ModuleProvider provider, Window owner) {
      super(provider);
      this.shutdownAction = new ShutdownAction(provider);
      this.owner = owner;
   }

   public final Window createWindow() {
      JDialog ret = this.createDialog(this.owner);
      ret.setContentPane(this.mount());
      JRootPane rootPane = ret.getRootPane();
      rootPane.registerKeyboardAction(new CloseWindowAction(), CLOSE, 2);
      rootPane.registerKeyboardAction(this.shutdownAction, ShutdownAction.ACCEL, 2);
      ret.pack();
      ret.setLocationRelativeTo(this.owner);
      return ret;
   }

   protected abstract JDialog createDialog(Window var1);
}
