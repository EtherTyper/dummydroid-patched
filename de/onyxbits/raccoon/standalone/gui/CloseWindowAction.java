package de.onyxbits.raccoon.standalone.gui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class CloseWindowAction extends AbstractAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = CloseWindowAction.class.getSimpleName();
   public static final KeyStroke ACCEL;

   public CloseWindowAction() {
      this.putValue("Name", Messages.t(ID + ".name"));
   }

   public void actionPerformed(ActionEvent e) {
      Window w = AppAction.windowOf((Component)e.getSource());
      WindowEvent we = new WindowEvent(w, 201);
      w.getToolkit().getSystemEventQueue().postEvent(we);
   }

   static {
      ACCEL = KeyStroke.getKeyStroke(87, AppAction.MASK);
   }
}
