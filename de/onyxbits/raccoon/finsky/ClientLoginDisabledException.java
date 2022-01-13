package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpResponseException;

public class ClientLoginDisabledException extends HttpResponseException {
   private static final long serialVersionUID = 1L;

   public ClientLoginDisabledException(int sc, String reasonPhrase) {
      super(sc, reasonPhrase);
   }
}
