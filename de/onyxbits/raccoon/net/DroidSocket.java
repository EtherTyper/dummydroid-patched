package de.onyxbits.raccoon.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.security.SecureRandom;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.tls.TlsClient;
import org.bouncycastle.tls.TlsClientProtocol;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.impl.bc.BcTlsCrypto;

class DroidSocket extends SSLSocket {
   private TlsClient client;
   private Socket base;
   private TlsClientProtocol protocol;

   public DroidSocket(Socket base) {
      this.base = base;
   }

   public void startHandshake() throws IOException {
      if (this.protocol == null) {
         this.protocol = new TlsClientProtocol(this.base.getInputStream(), this.base.getOutputStream());
         TlsCrypto crypto = new BcTlsCrypto(new SecureRandom());
         this.client = new JellyBeanTlsClient(crypto);

         try {
            this.protocol.connect(this.client);
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

   }

   public void close() throws IOException {
      if (this.protocol != null) {
         this.protocol.close();
         InputStream in = this.protocol.getInputStream();
         if (in != null) {
            in.close();
         }

         OutputStream out = this.getOutputStream();
         if (out != null) {
            out.close();
         }
      }

      this.base.close();
   }

   public boolean isClosed() {
      return this.base.isClosed();
   }

   public InputStream getInputStream() throws IOException {
      if (this.protocol == null) {
         this.startHandshake();
      }

      return this.protocol.getInputStream();
   }

   public OutputStream getOutputStream() throws IOException {
      if (this.protocol == null) {
         this.startHandshake();
      }

      return this.protocol.getOutputStream();
   }

   public void setSoTimeout(int timeout) throws SocketException {
      this.base.setSoTimeout(timeout);
   }

   public int getSoTimeout() throws SocketException {
      return this.base.getSoTimeout();
   }

   public String[] getSupportedCipherSuites() {
      return new String[]{"SSL_RSA_WITH_RC4_128_MD5", "SSL_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "SSL_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_DES_CBC_SHA", "SSL_DHE_RSA_WITH_DES_CBC_SHA", "SSL_DHE_DSS_WITH_DES_CBC_SHA", "SSL_RSA_EXPORT_WITH_RC4_40_MD5", "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
   }

   public String[] getEnabledCipherSuites() {
      return this.getSupportedCipherSuites();
   }

   public void setEnabledCipherSuites(String[] suites) {
      throw new UnsupportedOperationException("This would change the SSL fingerprint");
   }

   public String[] getSupportedProtocols() {
      return new String[]{"SSLv3"};
   }

   public String[] getEnabledProtocols() {
      return this.getSupportedProtocols();
   }

   public void setEnabledProtocols(String[] protocols) {
      throw new UnsupportedOperationException("This would change the SSL fingerprint");
   }

   public SSLSession getSession() {
      return null;
   }

   public void addHandshakeCompletedListener(HandshakeCompletedListener listener) {
      throw new UnsupportedOperationException("Do we need this?");
   }

   public void removeHandshakeCompletedListener(HandshakeCompletedListener listener) {
      throw new UnsupportedOperationException("Do we need this?");
   }

   public void setUseClientMode(boolean mode) {
      if (!mode) {
         throw new UnsupportedOperationException("This socket is client mode only");
      }
   }

   public boolean getUseClientMode() {
      return true;
   }

   public void setNeedClientAuth(boolean need) {
      if (need) {
         throw new UnsupportedOperationException("Nope!");
      }
   }

   public boolean getNeedClientAuth() {
      return false;
   }

   public void setWantClientAuth(boolean want) {
      if (want) {
         throw new UnsupportedOperationException("Don't care");
      }
   }

   public boolean getWantClientAuth() {
      return false;
   }

   public void setEnableSessionCreation(boolean flag) {
   }

   public boolean getEnableSessionCreation() {
      return false;
   }
}
