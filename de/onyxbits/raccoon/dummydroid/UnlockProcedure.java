package de.onyxbits.raccoon.dummydroid;

import de.onyxbits.raccoon.finsky.Base64G;
import de.onyxbits.raccoon.standalone.RegistrationAdapter;
import de.onyxbits.raccoon.standalone.cli.Procedure;
import java.io.IOException;
import org.apache.commons.cli.Option;

public class UnlockProcedure extends Procedure {
   private static final String ID = UnlockProcedure.class.getSimpleName();

   public int exec(String[] args) {
      RegistrationAdapter reg = (RegistrationAdapter)this.fetch(RegistrationAdapter.class);
      this.stdOut(reg.getRegistrationId());
      String key = args[0];

      try {
         if (reg.updateRegistration(Base64G.decode((String)key, 0))) {
            this.stdOut(Messages.t(ID + ".success"));
            return 0;
         } else {
            this.stdOut(Messages.t(ID + ".failure"));
            return 1;
         }
      } catch (IOException var5) {
         this.stdErr(var5.getMessage());
         return 1;
      }
   }

   protected Option createOption() {
      Option ret = new Option((String)null, "unlock", true, this.getDescription());
      ret.setArgName("pin");
      ret.setOptionalArg(false);
      return ret;
   }

   protected String getDescription() {
      return Messages.t(this.getClass().getSimpleName().concat(".description"));
   }
}
