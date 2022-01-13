package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpResponseException;

public class CaptchaException extends HttpResponseException {
   private static final long serialVersionUID = 1L;
   public final Captcha captcha;

   public CaptchaException(int sc, String reasonPhrase, Captcha captcha) {
      super(sc, reasonPhrase);
      this.captcha = captcha;
   }
}
