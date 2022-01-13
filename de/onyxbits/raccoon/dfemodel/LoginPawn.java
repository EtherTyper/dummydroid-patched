package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.AuthenticatedUser;
import de.onyxbits.raccoon.finsky.BadAuthenticationException;
import de.onyxbits.raccoon.finsky.Captcha;
import de.onyxbits.raccoon.finsky.CaptchaException;
import de.onyxbits.raccoon.finsky.ClientLoginDisabledException;
import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.finsky.HeaderProvider;
import de.onyxbits.raccoon.finsky.Headers;
import de.onyxbits.raccoon.finsky.LoginApi;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.mockup.PawnWrapper;
import java.io.IOException;
import org.apache.http.Header;

public class LoginPawn extends PawnWrapper implements HeaderProvider {
   private ClientProvider provider;

   public LoginPawn(Pawn pawn, ClientProvider provider) {
      super(pawn);
      if (provider == null) {
         throw new NullPointerException();
      } else {
         this.provider = provider;
      }
   }

   public Header headerFor(String name) {
      if ("User-Agent".equals(name) && this.getDevice() != null) {
         String agent = MockUtil.toLoginAgent(this.getDevice());
         return Headers.agent(agent);
      } else {
         return null;
      }
   }

   public AuthenticatedUser requestLogin() throws BadAuthenticationException, CaptchaException, ClientLoginDisabledException, IOException {
      return this.requestLogin((Captcha)null);
   }

   public AuthenticatedUser requestLogin(Captcha captcha) throws BadAuthenticationException, CaptchaException, ClientLoginDisabledException, IOException {
      LoginApi api = new LoginApi(this.provider, this);
      api.setLocale(this.getLocale());
      String epwd = this.getEncryptedPassword();
      if (epwd == null) {
         epwd = LoginApi.encryptPassword(this.getUsername(), this.getPassword().toCharArray());
      }

      AuthenticatedUser ret = api.requestSignIn(this.getUsername(), epwd, captcha, true);
      this.setAuth(ret.authToken);
      return ret;
   }
}
