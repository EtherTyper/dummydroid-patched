package de.onyxbits.raccoon.net;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.tls.Certificate;
import org.bouncycastle.tls.ServerOnlyTlsAuthentication;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCertificate;

public class DefaultTlsAuthentication extends ServerOnlyTlsAuthentication {
   private TrustManager[] trustManagers;
   private CertificateFactory certificateFactory;
   private String authType;

   public DefaultTlsAuthentication(int selectedCipherSuite) {
      try {
         TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         trustManagerFactory.init((KeyStore)null);
         this.trustManagers = trustManagerFactory.getTrustManagers();
         this.certificateFactory = CertificateFactory.getInstance("X.509");
         int keyExchangeAlgorithm = TlsUtils.getKeyExchangeAlgorithm(selectedCipherSuite);
         this.authType = this.getAuthTypeServer(keyExchangeAlgorithm);
      } catch (Exception var4) {
      }

   }

   public void notifyServerCertificate(Certificate serverCertificate) throws IOException {
      if (serverCertificate != null && !serverCertificate.isEmpty()) {
         if (this.trustManagers != null && this.certificateFactory != null) {
            if (this.authType == null) {
               throw new TlsFatalAlert((short)80);
            } else {
               TlsCertificate[] certificates = serverCertificate.getCertificateList();
               X509Certificate[] chain = new X509Certificate[certificates.length];
               ByteArrayInputStream bis = null;

               for(int i = 0; i < chain.length; ++i) {
                  bis = new ByteArrayInputStream(certificates[i].getEncoded());

                  try {
                     chain[i] = (X509Certificate)this.certificateFactory.generateCertificate(bis);
                     chain[i].checkValidity();
                  } catch (CertificateExpiredException var12) {
                     throw new TlsFatalAlert((short)45);
                  } catch (CertificateNotYetValidException var13) {
                     throw new TlsFatalAlert((short)45);
                  } catch (CertificateException var14) {
                     throw new TlsFatalAlert((short)50, var14);
                  }
               }

               TrustManager[] var15 = this.trustManagers;
               int var6 = var15.length;

               for(int var7 = 0; var7 < var6; ++var7) {
                  TrustManager trustManager = var15[var7];
                  if (trustManager instanceof X509TrustManager) {
                     X509TrustManager x509TrustManager = (X509TrustManager)trustManager;

                     try {
                        x509TrustManager.checkServerTrusted(chain, this.authType);
                     } catch (Exception var11) {
                        throw new IOException(var11.getCause());
                     }
                  }
               }

            }
         } else {
            throw new TlsFatalAlert((short)48);
         }
      } else {
         throw new TlsFatalAlert((short)40);
      }
   }

   private String getAuthTypeServer(int keyExchangeAlgorithm) {
      switch(keyExchangeAlgorithm) {
      case 1:
         return "RSA";
      case 2:
      case 4:
      case 6:
      case 8:
      case 10:
      case 12:
      case 13:
      default:
         return null;
      case 3:
         return "DHE_DSS";
      case 5:
         return "DHE_RSA";
      case 7:
         return "DH_DSS";
      case 9:
         return "DH_RSA";
      case 11:
         return "DH_anon";
      case 14:
         return "DHE_PSK";
      case 15:
         return "RSA_PSK";
      case 16:
         return "ECDH_ECDSA";
      case 17:
         return "ECDHE_ECDSA";
      case 18:
         return "ECDH_RSA";
      case 19:
         return "ECDHE_RSA";
      case 20:
         return "ECDH_anon";
      case 21:
         return "SRP";
      case 22:
         return "SRP_DSS";
      case 23:
         return "SRP_RSA";
      case 24:
         return "ECDHE_PSK";
      }
   }
}
