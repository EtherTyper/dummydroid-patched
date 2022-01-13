package de.onyxbits.raccoon.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.Proxy.Type;
import org.apache.http.HttpHost;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;

public class PlainLayeredConnectionSocketFactory implements ConnectionSocketFactory {
   private Proxy proxy;

   public PlainLayeredConnectionSocketFactory() {
   }

   public PlainLayeredConnectionSocketFactory(InetSocketAddress socksProxy) {
      if (socksProxy != null) {
         this.proxy = new Proxy(Type.SOCKS, socksProxy);
      }

   }

   public Socket createSocket(HttpContext context) throws IOException {
      return this.proxy == null ? new Socket() : new Socket(this.proxy);
   }

   public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context) throws IOException {
      Socket sock = socket != null ? socket : this.createSocket(context);
      sock.connect(remoteAddress, connectTimeout);
      return sock;
   }
}
