package de.onyxbits.raccoon.finsky;

import org.apache.http.client.ClientProtocolException;

public class TwoFactorException extends ClientProtocolException {
   private static final long serialVersionUID = 1L;

   public TwoFactorException() {
      super("Two factor authentication required");
   }
}
