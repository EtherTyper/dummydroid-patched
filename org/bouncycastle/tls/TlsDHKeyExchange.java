package org.bouncycastle.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsSecret;

public class TlsDHKeyExchange extends AbstractTlsKeyExchange {
   protected TlsDHConfigVerifier dhConfigVerifier;
   protected TlsCredentialedAgreement agreementCredentials;
   protected TlsCertificate dhPeerCertificate;
   protected TlsDHConfig dhConfig;
   protected TlsAgreement agreement;

   private static int checkKeyExchange(int var0) {
      switch(var0) {
      case 3:
      case 5:
      case 7:
      case 9:
      case 11:
         return var0;
      case 4:
      case 6:
      case 8:
      case 10:
      default:
         throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
   }

   public TlsDHKeyExchange(int var1, Vector var2, TlsDHConfigVerifier var3) {
      this(var1, var2, var3, (TlsDHConfig)null);
   }

   public TlsDHKeyExchange(int var1, Vector var2, TlsDHConfig var3) {
      this(var1, var2, (TlsDHConfigVerifier)null, var3);
   }

   private TlsDHKeyExchange(int var1, Vector var2, TlsDHConfigVerifier var3, TlsDHConfig var4) {
      super(checkKeyExchange(var1), var2);
      this.dhConfigVerifier = var3;
      this.dhConfig = var4;
   }

   public void skipServerCredentials() throws IOException {
      if (this.keyExchange != 11) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange == 11) {
         throw new TlsFatalAlert((short)80);
      } else if (!(var1 instanceof TlsCredentialedAgreement)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.agreementCredentials = (TlsCredentialedAgreement)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (this.keyExchange == 11) {
         throw new TlsFatalAlert((short)10);
      } else {
         this.checkServerCertSigAlg(var1);
         this.dhPeerCertificate = this.validatePeerCertificate(0, var1);
      }
   }

   public boolean requiresServerKeyExchange() {
      switch(this.keyExchange) {
      case 3:
      case 5:
      case 11:
         return true;
      default:
         return false;
      }
   }

   public byte[] generateServerKeyExchange() throws IOException {
      if (!this.requiresServerKeyExchange()) {
         return null;
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         TlsDHUtils.writeDHConfig(this.dhConfig, var1);
         this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
         this.generateEphemeral(var1);
         return var1.toByteArray();
      }
   }

   public void processServerKeyExchange(InputStream var1) throws IOException {
      if (!this.requiresServerKeyExchange()) {
         throw new TlsFatalAlert((short)10);
      } else {
         this.dhConfig = TlsDHUtils.receiveDHConfig(this.dhConfigVerifier, var1);
         byte[] var2 = TlsUtils.readOpaque16(var1);
         this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
         this.processEphemeral(var2);
      }
   }

   public void validateCertificateRequest(CertificateRequest var1) throws IOException {
      if (this.keyExchange == 11) {
         throw new TlsFatalAlert((short)40);
      } else {
         short[] var2 = var1.getCertificateTypes();
         int var3 = 0;

         while(var3 < var2.length) {
            switch(var2[var3]) {
            case 3:
            case 4:
               ++var3;
               break;
            default:
               throw new TlsFatalAlert((short)47);
            }
         }

      }
   }

   public void processClientCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange == 11) {
         throw new TlsFatalAlert((short)80);
      } else if (var1 instanceof TlsCredentialedAgreement) {
         this.agreementCredentials = (TlsCredentialedAgreement)var1;
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void generateClientKeyExchange(OutputStream var1) throws IOException {
      if (this.agreementCredentials == null) {
         this.generateEphemeral(var1);
      }

   }

   public void processClientCertificate(Certificate var1) throws IOException {
      if (this.keyExchange == 11) {
         throw new TlsFatalAlert((short)10);
      } else {
         if (this.agreementCredentials != null) {
            this.dhPeerCertificate = this.validatePeerCertificate(1, var1);
         }

      }
   }

   public void processClientKeyExchange(InputStream var1) throws IOException {
      if (this.dhPeerCertificate == null) {
         byte[] var2 = TlsUtils.readOpaque16(var1);
         this.processEphemeral(var2);
      }
   }

   public TlsSecret generatePreMasterSecret() throws IOException {
      if (this.agreementCredentials != null) {
         return this.agreementCredentials.generateAgreement(this.dhPeerCertificate);
      } else if (this.agreement != null) {
         return this.agreement.calculateSecret();
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   protected void generateEphemeral(OutputStream var1) throws IOException {
      byte[] var2 = this.agreement.generateEphemeral();
      TlsUtils.writeOpaque16(var2, var1);
   }

   protected void processEphemeral(byte[] var1) throws IOException {
      this.agreement.receivePeerValue(var1);
   }

   protected TlsCertificate validatePeerCertificate(int var1, Certificate var2) throws IOException {
      if (var2.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         return var2.getCertificateAt(0).useInRole(var1, this.keyExchange);
      }
   }
}
