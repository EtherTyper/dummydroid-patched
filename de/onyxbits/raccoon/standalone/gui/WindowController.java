package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class WindowController extends ViewController implements WindowListener {
   private Window window;

   public WindowController(ModuleProvider provider) {
      super(provider);
   }

   public Window getWindow() {
      if (this.window == null) {
         this.window = this.createWindow();
         this.window.addWindowListener(this);
      }

      return this.window;
   }

   public abstract Window createWindow();

   public void windowOpened(WindowEvent e) {
   }

   public void windowClosing(WindowEvent e) {
   }

   public void windowClosed(WindowEvent e) {
   }

   public void windowIconified(WindowEvent e) {
   }

   public void windowDeiconified(WindowEvent e) {
   }

   public void windowActivated(WindowEvent e) {
   }

   public void windowDeactivated(WindowEvent e) {
   }
}
