package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.about.AboutAction;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public abstract class PrimaryWindowController extends WindowController implements ContextHelper {
   private AboutAction aboutAction;

   public PrimaryWindowController(ModuleProvider provider) {
      super(provider);
      this.aboutAction = new AboutAction(provider);
   }

   public String getContextHelpUrl() {
      return null;
   }

   public String getSupportUrl() {
      return null;
   }

   public final Window createWindow() {
      JFrame ret = this.createFrame();
      InputStream in = null;
      List icons = new ArrayList();
      Toolkit tk = Toolkit.getDefaultToolkit();

      try {
         in = Messages.open("appicon.png");
         byte[] b = new byte[in.available()];
         in.read(b);
         icons.add(tk.createImage(b));
      } catch (Exception var14) {
      } finally {
         try {
            in.close();
         } catch (Exception var13) {
         }

      }

      ret.setIconImages(icons);
      Container contentPane = ret.getContentPane();
      contentPane.setLayout(new BorderLayout());
      ret.setJMenuBar(this.createMenuBar());
      JToolBar toolBar = this.createToolBar();
      if (toolBar != null) {
         contentPane.add(toolBar, "North");
      }

      contentPane.add(this.mount(), "Center");
      if (ret.getWidth() == 0) {
         ret.setSize(1024, 768);
      }

      ret.setLocationRelativeTo((Component)null);
      ((WindowTracker)this.fetch(WindowTracker.class)).register(ret);
      return ret;
   }

   protected JMenuBar createMenuBar() {
      JMenuBar ret = new JMenuBar();
      MnemonicContext mc = new MnemonicContext();
      JMenu[] menus = new JMenu[]{this.createFileMenu(), this.createEditMenu(), this.createViewMenu(), this.createGoMenu(), this.createCustomMenu(), this.createHelpMenu()};
      JMenu[] var4 = menus;
      int var5 = menus.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         JMenu menu = var4[var6];
         if (menu != null) {
            mc.assign(menu);
            ret.add(menu);
         }
      }

      return ret;
   }

   protected JMenu createFileMenu() {
      return null;
   }

   protected JMenu createEditMenu() {
      return null;
   }

   protected JMenu createViewMenu() {
      return null;
   }

   protected JMenu createGoMenu() {
      return null;
   }

   protected JMenu createCustomMenu() {
      return null;
   }

   protected JMenu createHelpMenu() {
      ContextHelpAction contextHelpAction = new ContextHelpAction(this);
      SupportAction supportAction = new SupportAction(this);
      JMenu ret = new HelpMenu();
      MnemonicContext mc = new MnemonicContext();
      JMenuItem tmp = ret.add(contextHelpAction);
      tmp.setAccelerator(ContextHelpAction.ACCEL);
      mc.assign(tmp);
      mc.assign(ret.add(supportAction));
      ret.addSeparator();
      mc.assign(ret.add(this.aboutAction));
      return ret;
   }

   protected JToolBar createToolBar() {
      return null;
   }

   protected abstract JFrame createFrame();
}
