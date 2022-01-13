package org.apache.http.conn.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Contract(
   threading = ThreadingBehavior.SAFE
)
public class SSLConnectionSocketFactory implements LayeredConnectionSocketFactory {
   public static final String TLS = "TLS";
   public static final String SSL = "SSL";
   public static final String SSLV2 = "SSLv2";
   /** @deprecated */
   @Deprecated
   public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER;
   /** @deprecated */
   @Deprecated
   public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
   /** @deprecated */
   @Deprecated
   public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER;
   private final Log log;
   private final SSLSocketFactory socketfactory;
   private final HostnameVerifier hostnameVerifier;
   private final String[] supportedProtocols;
   private final String[] supportedCipherSuites;

   public static HostnameVerifier getDefaultHostnameVerifier() {
      return new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault());
   }

   public static SSLConnectionSocketFactory getSocketFactory() throws SSLInitializationException {
      return new SSLConnectionSocketFactory(SSLContexts.createDefault(), getDefaultHostnameVerifier());
   }

   private static String[] split(String s) {
      return TextUtils.isBlank(s) ? null : s.split(" *, *");
   }

   public static SSLConnectionSocketFactory getSystemSocketFactory() throws SSLInitializationException {
      return new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), getDefaultHostnameVerifier());
   }

   public SSLConnectionSocketFactory(SSLContext sslContext) {
      this(sslContext, getDefaultHostnameVerifier());
   }

   /** @deprecated */
   @Deprecated
   public SSLConnectionSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier) {
      this((SSLSocketFactory)((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), (String[])null, (String[])null, (X509HostnameVerifier)hostnameVerifier);
   }

   /** @deprecated */
   @Deprecated
   public SSLConnectionSocketFactory(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier) {
      this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), supportedProtocols, supportedCipherSuites, hostnameVerifier);
   }

   /** @deprecated */
   @Deprecated
   public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, X509HostnameVerifier hostnameVerifier) {
      this((SSLSocketFactory)socketfactory, (String[])null, (String[])null, (X509HostnameVerifier)hostnameVerifier);
   }

   /** @deprecated */
   @Deprecated
   public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier) {
      this((SSLSocketFactory)socketfactory, supportedProtocols, supportedCipherSuites, (HostnameVerifier)hostnameVerifier);
   }

   public SSLConnectionSocketFactory(SSLContext sslContext, HostnameVerifier hostnameVerifier) {
      this((SSLSocketFactory)((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), (String[])null, (String[])null, (HostnameVerifier)hostnameVerifier);
   }

   public SSLConnectionSocketFactory(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier) {
      this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), supportedProtocols, supportedCipherSuites, hostnameVerifier);
   }

   public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, HostnameVerifier hostnameVerifier) {
      this((SSLSocketFactory)socketfactory, (String[])null, (String[])null, (HostnameVerifier)hostnameVerifier);
   }

   public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier) {
      this.log = LogFactory.getLog(this.getClass());
      this.socketfactory = (SSLSocketFactory)Args.notNull(socketfactory, "SSL socket factory");
      this.supportedProtocols = supportedProtocols;
      this.supportedCipherSuites = supportedCipherSuites;
      this.hostnameVerifier = hostnameVerifier != null ? hostnameVerifier : getDefaultHostnameVerifier();
   }

   protected void prepareSocket(SSLSocket socket) throws IOException {
   }

   public Socket createSocket(HttpContext context) throws IOException {
      return SocketFactory.getDefault().createSocket();
   }

   public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context) throws IOException {
      Args.notNull(host, "HTTP host");
      Args.notNull(remoteAddress, "Remote address");
      Socket sock = socket != null ? socket : this.createSocket(context);
      if (localAddress != null) {
         sock.bind(localAddress);
      }

      try {
         if (connectTimeout > 0 && sock.getSoTimeout() == 0) {
            sock.setSoTimeout(connectTimeout);
         }

         if (this.log.isDebugEnabled()) {
            this.log.debug("Connecting socket to " + remoteAddress + " with timeout " + connectTimeout);
         }

         sock.connect(remoteAddress, connectTimeout);
      } catch (IOException var11) {
         try {
            sock.close();
         } catch (IOException var10) {
         }

         throw var11;
      }

      if (sock instanceof SSLSocket) {
         SSLSocket sslsock = (SSLSocket)sock;
         this.log.debug("Starting handshake");
         sslsock.startHandshake();
         this.verifyHostname(sslsock, host.getHostName());
         return sock;
      } else {
         return this.createLayeredSocket(sock, host.getHostName(), remoteAddress.getPort(), context);
      }
   }

   public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context) throws IOException {
      SSLSocket sslsock = (SSLSocket)this.socketfactory.createSocket(socket, target, port, true);
      if (this.supportedProtocols != null) {
         sslsock.setEnabledProtocols(this.supportedProtocols);
      } else {
         String[] allProtocols = sslsock.getEnabledProtocols();
         List enabledProtocols = new ArrayList(allProtocols.length);
         String[] arr$ = allProtocols;
         int len$ = allProtocols.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            String protocol = arr$[i$];
            if (!protocol.startsWith("SSL")) {
               enabledProtocols.add(protocol);
            }
         }

         if (!enabledProtocols.isEmpty()) {
            sslsock.setEnabledProtocols((String[])enabledProtocols.toArray(new String[enabledProtocols.size()]));
         }
      }

      if (this.supportedCipherSuites != null) {
         sslsock.setEnabledCipherSuites(this.supportedCipherSuites);
      }

      if (this.log.isDebugEnabled()) {
         this.log.debug("Enabled protocols: " + Arrays.asList(sslsock.getEnabledProtocols()));
         this.log.debug("Enabled cipher suites:" + Arrays.asList(sslsock.getEnabledCipherSuites()));
      }

      this.prepareSocket(sslsock);
      this.log.debug("Starting handshake");
      sslsock.startHandshake();
      this.verifyHostname(sslsock, target);
      return sslsock;
   }

   private void verifyHostname(SSLSocket sslsock, String hostname) throws IOException {
      try {
         SSLSession session = sslsock.getSession();
         if (session == null) {
            InputStream in = sslsock.getInputStream();
            in.available();
            session = sslsock.getSession();
            if (session == null) {
               sslsock.startHandshake();
               session = sslsock.getSession();
            }
         }

         if (session == null) {
            throw new SSLHandshakeException("SSL session not available");
         } else {
            X509Certificate x509;
            Certificate[] certs;
            if (this.log.isDebugEnabled()) {
               this.log.debug("Secure session established");
               this.log.debug(" negotiated protocol: " + session.getProtocol());
               this.log.debug(" negotiated cipher suite: " + session.getCipherSuite());

               try {
                  certs = session.getPeerCertificates();
                  x509 = (X509Certificate)certs[0];
                  X500Principal peer = x509.getSubjectX500Principal();
                  this.log.debug(" peer principal: " + peer.toString());
                  Collection altNames1 = x509.getSubjectAlternativeNames();
                  if (altNames1 != null) {
                     List altNames = new ArrayList();
                     Iterator i$ = altNames1.iterator();

                     while(i$.hasNext()) {
                        List aC = (List)i$.next();
                        if (!aC.isEmpty()) {
                           altNames.add((String)aC.get(1));
                        }
                     }

                     this.log.debug(" peer alternative names: " + altNames);
                  }

                  X500Principal issuer = x509.getIssuerX500Principal();
                  this.log.debug(" issuer principal: " + issuer.toString());
                  Collection altNames2 = x509.getIssuerAlternativeNames();
                  if (altNames2 != null) {
                     List altNames = new ArrayList();
                     Iterator i$ = altNames2.iterator();

                     while(i$.hasNext()) {
                        List aC = (List)i$.next();
                        if (!aC.isEmpty()) {
                           altNames.add((String)aC.get(1));
                        }
                     }

                     this.log.debug(" issuer alternative names: " + altNames);
                  }
               } catch (Exception var14) {
               }
            }

            if (!this.hostnameVerifier.verify(hostname, session)) {
               certs = session.getPeerCertificates();
               x509 = (X509Certificate)certs[0];
               List subjectAlts = DefaultHostnameVerifier.getSubjectAltNames(x509);
               throw new SSLPeerUnverifiedException("Certificate for <" + hostname + "> doesn't match any " + "of the subject alternative names: " + subjectAlts);
            }
         }
      } catch (IOException var15) {
         try {
            sslsock.close();
         } catch (Exception var13) {
         }

         throw var15;
      }
   }

   static {
      ALLOW_ALL_HOSTNAME_VERIFIER = AllowAllHostnameVerifier.INSTANCE;
      BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = BrowserCompatHostnameVerifier.INSTANCE;
      STRICT_HOSTNAME_VERIFIER = StrictHostnameVerifier.INSTANCE;
   }
}
