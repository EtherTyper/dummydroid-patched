package de.onyxbits.raccoon.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.Proxy.Type;
import org.apache.http.HttpHost;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;

class DroidConnectionSocketFactory implements LayeredConnectionSocketFactory {
   private Proxy proxy;

   public DroidConnectionSocketFactory() {
   }

   public DroidConnectionSocketFactory(InetSocketAddress socksProxy) {
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
      return this.createLayeredSocket(sock, host.getHostName(), remoteAddress.getPort(), context);
   }

   public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context) throws IOException, UnknownHostException {
      return new DroidSocket(socket);
   }
}
