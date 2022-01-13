package de.onyxbits.raccoon.standalone.gui;

import javax.swing.JMenu;

public class ViewMenu extends JMenu {
   private static final long serialVersionUID = 1L;

   public ViewMenu() {
      this.setText(Messages.t(ViewMenu.class.getSimpleName().concat(".name")));
   }
}
