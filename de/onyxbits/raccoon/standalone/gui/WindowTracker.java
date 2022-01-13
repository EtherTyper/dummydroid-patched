package de.onyxbits.raccoon.standalone.gui;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import de.onyxbits.raccoon.standalone.base.AppAdapter;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;

public class WindowTracker extends AbstractModule implements WindowListener {
   private ArrayList stage = new ArrayList();

   public void register(Window w) {
      if (w instanceof JFrame) {
         ((JFrame)w).setDefaultCloseOperation(0);
      }

      w.addWindowListener(this);
      if (!this.stage.contains(w) && w.isVisible()) {
         this.stage.add(w);
      }

   }

   public void shutdown() {
      Iterator var1 = this.stage.iterator();

      while(var1.hasNext()) {
         Window w = (Window)var1.next();
         w.setVisible(false);
         w.dispose();
      }

   }

   public void windowOpened(WindowEvent e) {
      Window w = e.getWindow();
      if (!this.stage.contains(w)) {
         this.stage.add(w);
      }

   }

   public void windowClosing(WindowEvent e) {
      Window w = e.getWindow();
      w.setVisible(false);
      w.dispose();
      this.stage.remove(w);
      if (this.stage.isEmpty()) {
         ((AppAdapter)this.fetch(AppAdapter.class)).exit();
      }

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
