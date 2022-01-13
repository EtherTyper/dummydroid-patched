package de.onyxbits.raccoon.standalone.gui;

import javax.swing.JMenu;

public class EditMenu extends JMenu {
   private static final long serialVersionUID = 1L;

   public EditMenu() {
      this.setText(Messages.t(EditMenu.class.getSimpleName().concat(".name")));
   }
}
