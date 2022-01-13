package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpResponseException;

public class NeedsBrowserException extends HttpResponseException {
   private static final long serialVersionUID = 1L;
   public final String url;
   public final String detail;

   public NeedsBrowserException(int sc, String reasonPhrase, String detail, String url) {
      super(sc, reasonPhrase);
      this.url = url;
      this.detail = detail;
   }
}
