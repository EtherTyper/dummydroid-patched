package de.onyxbits.raccoon.standalone.cli;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import java.io.PrintStream;

public class PrintModule extends AbstractModule {
   public PrintStream err;
   public PrintStream out;

   public PrintModule() {
      this.err = System.err;
      this.out = System.out;
   }
}
