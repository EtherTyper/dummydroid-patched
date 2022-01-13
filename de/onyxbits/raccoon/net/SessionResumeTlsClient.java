package de.onyxbits.raccoon.net;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.bouncycastle.tls.DefaultTlsClient;
import org.bouncycastle.tls.TlsAuthentication;
import org.bouncycastle.tls.TlsDHConfigVerifier;
import org.bouncycastle.tls.TlsKeyExchangeFactory;
import org.bouncycastle.tls.TlsNoCloseNotifyException;
import org.bouncycastle.tls.TlsSession;
import org.bouncycastle.tls.crypto.TlsCrypto;

public abstract class SessionResumeTlsClient extends DefaultTlsClient {
   public SessionResumeTlsClient(TlsCrypto crypto) {
      super(crypto);
   }

   public SessionResumeTlsClient(TlsCrypto crypto, TlsKeyExchangeFactory keyExchangeFactory, TlsDHConfigVerifier dhConfigVerifier) {
      super(crypto, keyExchangeFactory, dhConfigVerifier);
   }

   public TlsAuthentication getAuthentication() throws IOException {
      return new DefaultTlsAuthentication(this.selectedCipherSuite);
   }

   public void notifySessionID(byte[] sessionID) {
      super.notifySessionID(sessionID);
   }

   public void notifyAlertRaised(short alertLevel, short alertDescription, String message, Throwable cause) {
      if (!(cause instanceof SocketTimeoutException)) {
         if (!(cause instanceof TlsNoCloseNotifyException)) {
            if (cause != null) {
               System.err.println("In " + SessionResumeTlsClient.class.getSimpleName() + ".notifyAlertRaised(): " + message);
               cause.printStackTrace();
            }

         }
      }
   }

   public TlsSession getSessionToResume() {
      return null;
   }
}
