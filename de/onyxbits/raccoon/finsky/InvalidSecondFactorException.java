package de.onyxbits.raccoon.finsky;

public class InvalidSecondFactorException extends BadAuthenticationException {
   private static final long serialVersionUID = 1L;

   public InvalidSecondFactorException(int statusCode, String reasonPhrase) {
      super(statusCode, reasonPhrase);
   }
}
