package de.onyxbits.raccoon.standalone.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PawnFileFilter extends FileFilter {
   private static final String ID = PawnFileFilter.class.getSimpleName();

   public boolean accept(File pathname) {
      return pathname.isFile() && pathname.getName().toLowerCase().endsWith("prf");
   }

   public String getDescription() {
      return Messages.t(ID + ".description");
   }
}
