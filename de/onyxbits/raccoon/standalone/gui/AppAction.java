package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.Module;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public abstract class AppAction extends AbstractAction implements ModuleProvider {
   public static final int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
   private static final long serialVersionUID = 1L;
   private ModuleProvider provider;

   public AppAction(ModuleProvider provider) {
      if (provider == null) {
         throw new NullPointerException();
      } else {
         this.provider = provider;
      }
   }

   public final Module fetch(Class clazz) {
      return this.provider.fetch(clazz);
   }

   public static Window windowOf(Component com) {
      Window w = SwingUtilities.getWindowAncestor(com);
      if (w == null && com.getParent() instanceof JPopupMenu) {
         w = SwingUtilities.windowForComponent(((JPopupMenu)com.getParent()).getInvoker());
      }

      return w;
   }
}
