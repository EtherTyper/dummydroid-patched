package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpClient;

public class DefaultClientProvider implements ClientProvider {
   private HttpClient client;

   public DefaultClientProvider(HttpClient client) {
      this.client = client;
   }

   public HttpClient getClient() {
      return this.client;
   }
}
