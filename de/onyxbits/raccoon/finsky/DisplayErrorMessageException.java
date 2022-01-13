package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpResponseException;

public class DisplayErrorMessageException extends HttpResponseException {
   private static final long serialVersionUID = 1L;

   public DisplayErrorMessageException(int statusCode, String reasonPhrase) {
      super(statusCode, reasonPhrase);
   }

   public String getErrorMessage() {
      return this.getReasonPhrase();
   }
}
