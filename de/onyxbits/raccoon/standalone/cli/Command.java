package de.onyxbits.raccoon.standalone.cli;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import java.io.PrintStream;
import org.apache.commons.cli.Option;

public abstract class Command extends AbstractModule implements ExitStatus {
   private Option option;

   public PrintStream stdOut() {
      return ((PrintModule)this.fetch(PrintModule.class)).out;
   }

   public PrintStream stdOut(String s) {
      PrintStream ret = ((PrintModule)this.fetch(PrintModule.class)).out;
      ret.println(s);
      return ret;
   }

   public PrintStream stdErr() {
      return ((PrintModule)this.fetch(PrintModule.class)).err;
   }

   public PrintStream stdErr(String s) {
      PrintStream ret = ((PrintModule)this.fetch(PrintModule.class)).err;
      ret.println(s);
      return ret;
   }

   public PrintStream stdErr(Throwable t) {
      return this.stdErr(t.getMessage());
   }

   protected String getDescription() {
      return Messages.t(this.getClass().getSimpleName().concat(".description"));
   }

   public final Option getOption() {
      if (this.option == null) {
         this.option = this.createOption();
      }

      return this.option;
   }

   protected abstract Option createOption();

   public abstract int exec(String[] var1);
}
