package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpResponseException;

public class BadAuthenticationException extends HttpResponseException {
   private static final long serialVersionUID = 1L;

   public BadAuthenticationException(int statusCode, String reasonPhrase) {
      super(statusCode, reasonPhrase);
   }
}
