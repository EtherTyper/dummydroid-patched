package de.onyxbits.raccoon.finsky;

import org.apache.http.Header;

public class DefaultHeaderProvider implements HeaderProvider {
   private Header[] headers;

   public DefaultHeaderProvider(Header... headers) {
      this.headers = headers;
      if (this.headers == null) {
         this.headers = new Header[0];
      }

   }

   public Header headerFor(String name) {
      Header[] var2 = this.headers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Header h = var2[var4];
         if (name.equals(h.getName())) {
            return h;
         }
      }

      return null;
   }
}
