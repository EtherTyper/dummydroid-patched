package de.onyxbits.raccoon.net;

import java.net.InetSocketAddress;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class ClientFactory {
   public static final int DIRECT = 0;
   public static final int HTTP = 1;
   public static final int SOCKS = 2;
   private PoolingHttpClientConnectionManager connManager;
   private HttpHost httpProxy;
   private int timeout;

   public ClientFactory(int proxyType, InetSocketAddress proxy, int maxRoute, int maxTotal, int timeout) {
      this.timeout = timeout;
      switch(proxyType) {
      case 1:
         this.httpProxy = new HttpHost(proxy.getAddress(), proxy.getPort());
      case 0:
         this.connManager = createConnectionManager((InetSocketAddress)null, maxRoute, maxTotal);
         break;
      case 2:
         this.connManager = createConnectionManager(proxy, maxRoute, maxTotal);
         break;
      default:
         throw new IllegalArgumentException("Unknown type: " + proxyType);
      }

   }

   public ClientFactory(int maxRoute, int maxTotal, int timeout) {
      this(0, (InetSocketAddress)null, maxRoute, maxTotal, timeout);
   }

   public HttpClient createClient() {
      if (this.connManager == null) {
         throw new IllegalStateException("Factory has been shut down");
      } else {
         RequestConfig config = RequestConfig.custom().setProxy(this.httpProxy).setConnectTimeout(this.timeout).setConnectionRequestTimeout(2000).setSocketTimeout(this.timeout).build();
         return HttpClientBuilder.create().setDefaultRequestConfig(config).setConnectionManager(this.connManager).build();
      }
   }

   public void shutdown() {
      this.connManager.shutdown();
      this.connManager = null;
   }

   public static PoolingHttpClientConnectionManager createConnectionManager(InetSocketAddress socksProxy, int maxRoute, int maxTotal) {
      RegistryBuilder rb = RegistryBuilder.create();
      rb.register("https", new DroidConnectionSocketFactory(socksProxy));
      rb.register("http", new PlainLayeredConnectionSocketFactory(socksProxy));
      PoolingHttpClientConnectionManager ret = new PoolingHttpClientConnectionManager(rb.build());
      ret.setDefaultMaxPerRoute(maxRoute);
      ret.setMaxTotal(maxTotal);
      return ret;
   }
}
