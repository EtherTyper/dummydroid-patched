package de.onyxbits.raccoon.standalone;

import de.onyxbits.raccoon.finsky.ClientProvider;
import java.net.URI;
import org.apache.http.client.HttpClient;

class UplinkClientProvider implements ClientProvider {
   private Uplink uplink;
   private HttpClient client;
   private URI proxy;

   public UplinkClientProvider(Uplink uplink) {
      this.uplink = uplink;
   }

   public HttpClient getClient() {
      if (!this.isClientValid()) {
         this.client = null;
      }

      if (this.client == null) {
         this.client = this.uplink.createClient();
         this.proxy = this.uplink.getProxy();
      }

      return this.client;
   }

   private boolean isClientValid() {
      URI tmp = this.uplink.getProxy();
      if (tmp == null && this.proxy == null) {
         return true;
      } else if (tmp != null) {
         return tmp.equals(this.proxy);
      } else {
         return this.proxy != null ? this.proxy.equals(tmp) : false;
      }
   }
}
