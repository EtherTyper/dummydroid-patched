package de.onyxbits.raccoon.standalone.gui;

import javax.swing.JMenu;

public class FileMenu extends JMenu {
   private static final long serialVersionUID = 1L;

   public FileMenu() {
      this.setText(Messages.t(FileMenu.class.getSimpleName().concat(".name")));
   }
}
