package de.onyxbits.raccoon.standalone.gui;

import javax.swing.JMenu;

public class HelpMenu extends JMenu {
   private static final long serialVersionUID = 1L;

   public HelpMenu() {
      this.setText(Messages.t(HelpMenu.class.getSimpleName().concat(".name")));
   }
}
