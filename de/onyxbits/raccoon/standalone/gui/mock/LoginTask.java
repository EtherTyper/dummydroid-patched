package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.dfemodel.LoginPawn;
import de.onyxbits.raccoon.finsky.AuthenticatedUser;
import de.onyxbits.raccoon.finsky.BadAuthenticationException;
import de.onyxbits.raccoon.finsky.DefaultClientProvider;
import de.onyxbits.raccoon.finsky.InvalidSecondFactorException;
import de.onyxbits.raccoon.finsky.LoginApi;
import de.onyxbits.raccoon.finsky.NeedsBrowserException;
import de.onyxbits.raccoon.finsky.TwoFactorException;
import de.onyxbits.raccoon.finsky.WebLoginRequiredException;
import de.onyxbits.raccoon.util.TextTool;
import java.util.concurrent.ExecutionException;

class LoginTask extends MockTask {
   private static final String ID = LoginTask.class.getSimpleName();

   public LoginTask(MockDeviceController ctrl) {
      super(ctrl);
      this.log(Messages.t(ID + ".init"));
   }

   protected AuthenticatedUser runInBackground() throws Exception {
      String uid = this.pawnCopy.getUsername();
      String epwd = this.pawnCopy.getEncryptedPassword();
      if (this.pawnCopy.getPassword() != null) {
         epwd = LoginApi.encryptPassword(uid, this.pawnCopy.getPassword().toCharArray());
      }

      if (uid != null && uid.length() != 0 && epwd != null && epwd.length() != 0) {
         LoginPawn lp = new LoginPawn(this.pawnCopy, new DefaultClientProvider(this.ctrl.createClient()));
         return lp.requestLogin();
      } else {
         throw new BadAuthenticationException(403, "Credentials required");
      }
   }

   protected void runInForeground(AuthenticatedUser result) {
      this.log(this.labled(ID + ".identity", new Object[]{result.firstName, result.lastName, result.email}));
      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < result.services.size(); ++i) {
         if (i > 0) {
            sb.append(", ");
         }

         sb.append((String)result.services.get(i));
      }

      this.log(this.labled(ID + ".services", new Object[]{sb.toString()}));
      String token = result.authToken;
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         int end = token.length();
         int start = Math.max(0, end - (int)((float)end * 0.33F));
         token = TextTool.redact(token, '░', true, start, end);
      }

      this.log(this.labled(ID + ".auth", new Object[]{token}));
      this.log(" ");
      this.pawn.setAuth(result.authToken);
      this.ctrl.next();
   }

   protected void runInForeground(ExecutionException result) {
      Throwable cause = result.getCause();
      this.log(Messages.t(ID + ".failure"));
      String tmp = result.getMessage();
      if (cause instanceof BadAuthenticationException) {
         tmp = Messages.t(ID + ".badauth");
      }

      if (cause instanceof InvalidSecondFactorException) {
         tmp = Messages.t(ID + ".invalidsecondfactor");
      }

      if (cause instanceof NeedsBrowserException) {
         NeedsBrowserException e = (NeedsBrowserException)cause;
         tmp = Messages.t(ID + ".needsbrowser", e.detail, e.url);
      }

      if (cause instanceof WebLoginRequiredException) {
         WebLoginRequiredException e = (WebLoginRequiredException)cause;
         tmp = Messages.t(ID + ".webloginrequired", e.url);
      }

      if (cause instanceof TwoFactorException) {
         tmp = Messages.t(ID + ".twofactor");
      }

      this.log(tmp);
      this.ctrl.reset();
   }
}
