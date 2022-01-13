package de.onyxbits.raccoon.standalone.cli;

import de.onyxbits.raccoon.standalone.base.AppAdapter;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public final class HelpProcedure extends Procedure {
   private static final String ID = HelpProcedure.class.getSimpleName();
   private Options options;

   protected Option createOption() {
      return new Option("h", "help", false, this.getDescription());
   }

   public int exec(String[] args) {
      if (this.options == null) {
         throw new IllegalStateException("setOptions() must be called first");
      } else {
         (new HelpFormatter()).printHelp("raccoon", "\n" + Messages.t(ID + ".header") + "\n\n", this.options, "\n" + Messages.t(ID + ".footer", ((AppAdapter)this.fetch(AppAdapter.class)).pathOf()), true);
         return 0;
      }
   }

   public void setOptions(Options options) {
      if (options == null) {
         throw new NullPointerException();
      } else {
         this.options = options;
      }
   }
}
