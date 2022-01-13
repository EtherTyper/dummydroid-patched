package org.bouncycastle.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.tls.crypto.TlsSecret;

public class TlsECDHKeyExchange extends AbstractTlsKeyExchange {
   protected TlsECConfigVerifier ecConfigVerifier;
   protected short[] clientECPointFormats;
   protected short[] serverECPointFormats;
   protected TlsCredentialedAgreement agreementCredentials;
   protected TlsCertificate ecdhPeerCertificate;
   protected TlsECConfig ecConfig;
   protected TlsAgreement agreement;

   private static int checkKeyExchange(int var0) {
      switch(var0) {
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
         return var0;
      default:
         throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
   }

   public TlsECDHKeyExchange(int var1, Vector var2, TlsECConfigVerifier var3, short[] var4, short[] var5) {
      this(var1, var2, var3, (TlsECConfig)null, var4, var5);
   }

   public TlsECDHKeyExchange(int var1, Vector var2, TlsECConfig var3, short[] var4) {
      this(var1, var2, (TlsECConfigVerifier)null, var3, (short[])null, var4);
   }

   private TlsECDHKeyExchange(int var1, Vector var2, TlsECConfigVerifier var3, TlsECConfig var4, short[] var5, short[] var6) {
      super(checkKeyExchange(var1), var2);
      this.ecConfigVerifier = var3;
      this.ecConfig = var4;
      this.clientECPointFormats = var5;
      this.serverECPointFormats = var6;
   }

   public void skipServerCredentials() throws IOException {
      if (this.keyExchange != 20) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange == 20) {
         throw new TlsFatalAlert((short)80);
      } else if (!(var1 instanceof TlsCredentialedAgreement)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.agreementCredentials = (TlsCredentialedAgreement)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (this.keyExchange == 20) {
         throw new TlsFatalAlert((short)10);
      } else {
         this.checkServerCertSigAlg(var1);
         this.ecdhPeerCertificate = this.validatePeerCertificate(0, var1);
      }
   }

   public boolean requiresServerKeyExchange() {
      switch(this.keyExchange) {
      case 17:
      case 19:
      case 20:
         return true;
      case 18:
      default:
         return false;
      }
   }

   public byte[] generateServerKeyExchange() throws IOException {
      if (!this.requiresServerKeyExchange()) {
         return null;
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         TlsECCUtils.writeECConfig(this.ecConfig, var1);
         this.agreement = this.context.getCrypto().createECDomain(this.ecConfig).createECDH();
         this.generateEphemeral(var1);
         return var1.toByteArray();
      }
   }

   public void processServerKeyExchange(InputStream var1) throws IOException {
      if (!this.requiresServerKeyExchange()) {
         throw new TlsFatalAlert((short)10);
      } else {
         this.ecConfig = TlsECCUtils.receiveECConfig(this.ecConfigVerifier, this.serverECPointFormats, var1);
         byte[] var2 = TlsUtils.readOpaque8(var1);
         this.agreement = this.context.getCrypto().createECDomain(this.ecConfig).createECDH();
         this.processEphemeral(this.clientECPointFormats, var2);
      }
   }

   public void validateCertificateRequest(CertificateRequest var1) throws IOException {
      if (this.keyExchange == 20) {
         throw new TlsFatalAlert((short)40);
      } else {
         short[] var2 = var1.getCertificateTypes();
         int var3 = 0;

         while(var3 < var2.length) {
            switch(var2[var3]) {
            case 65:
            case 66:
               ++var3;
               break;
            default:
               throw new TlsFatalAlert((short)47);
            }
         }

      }
   }

   public void processClientCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange == 20) {
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
      if (this.keyExchange == 20) {
         throw new TlsFatalAlert((short)10);
      } else {
         if (this.agreementCredentials != null) {
            this.ecdhPeerCertificate = this.validatePeerCertificate(1, var1);
         }

      }
   }

   public void processClientKeyExchange(InputStream var1) throws IOException {
      if (this.ecdhPeerCertificate == null) {
         byte[] var2 = TlsUtils.readOpaque8(var1);
         this.processEphemeral(this.serverECPointFormats, var2);
      }
   }

   public TlsSecret generatePreMasterSecret() throws IOException {
      if (this.agreementCredentials != null) {
         return this.agreementCredentials.generateAgreement(this.ecdhPeerCertificate);
      } else if (this.agreement != null) {
         return this.agreement.calculateSecret();
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   protected void generateEphemeral(OutputStream var1) throws IOException {
      byte[] var2 = this.agreement.generateEphemeral();
      TlsUtils.writeOpaque8(var2, var1);
   }

   protected void processEphemeral(short[] var1, byte[] var2) throws IOException {
      TlsECCUtils.checkPointEncoding(var1, this.ecConfig.getNamedCurve(), var2);
      this.agreement.receivePeerValue(var2);
   }

   protected TlsCertificate validatePeerCertificate(int var1, Certificate var2) throws IOException {
      if (var2.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         return var2.getCertificateAt(0).useInRole(var1, this.keyExchange);
      }
   }
}
