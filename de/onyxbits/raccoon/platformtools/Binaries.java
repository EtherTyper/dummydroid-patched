package de.onyxbits.raccoon.platformtools;

import java.io.File;

public class Binaries {
   private File base;

   public Binaries(File base) {
      this.base = base;
   }

   public File pathOfAdb() {
      return this.pathOf("adb");
   }

   public File pathOfFastBoot() {
      return this.pathOf("fastboot");
   }

   public File pathOfSqlite() {
      return this.pathOf("sqlite3");
   }

   private File pathOf(String fname) {
      File ret = new File(this.base, fname.concat(".exe"));
      if (ret.exists() && ret.canExecute()) {
         return ret;
      } else {
         ret = new File(this.base, fname);
         return ret.exists() && ret.canExecute() ? ret : null;
      }
   }
}
