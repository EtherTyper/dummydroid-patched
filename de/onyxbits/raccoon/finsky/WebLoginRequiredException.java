package de.onyxbits.raccoon.finsky;

public class WebLoginRequiredException extends BadAuthenticationException {
   private static final long serialVersionUID = 1L;
   public final String url;

   public WebLoginRequiredException(int statusCode, String reasonPhrase, String url) {
      super(statusCode, reasonPhrase);
      this.url = url;
   }
}
