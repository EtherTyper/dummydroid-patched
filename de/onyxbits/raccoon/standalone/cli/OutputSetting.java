package de.onyxbits.raccoon.standalone.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.commons.cli.Option;

public class OutputSetting extends Setting {
   private File output;

   protected Option createOption() {
      Option ret = new Option("o", "output", true, this.getDescription());
      ret.setArgName("path");
      return ret;
   }

   public File getOutput() {
      return this.output;
   }

   public File getOutput(File def) {
      return this.output == null ? def : this.output;
   }

   public OutputStream openStream() throws FileNotFoundException {
      return new FileOutputStream(this.getOutput());
   }

   public int exec(String[] args) {
      this.output = new File(args[0]);
      return 0;
   }
}
