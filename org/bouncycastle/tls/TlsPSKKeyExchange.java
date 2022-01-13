package org.bouncycastle.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public class TlsPSKKeyExchange extends AbstractTlsKeyExchange {
   protected TlsPSKIdentity pskIdentity;
   protected TlsPSKIdentityManager pskIdentityManager;
   protected TlsDHConfigVerifier dhConfigVerifier;
   protected TlsECConfigVerifier ecConfigVerifier;
   protected short[] clientECPointFormats;
   protected short[] serverECPointFormats;
   protected byte[] psk_identity_hint;
   protected byte[] psk;
   protected TlsDHConfig dhConfig;
   protected TlsECConfig ecConfig;
   protected TlsAgreement agreement;
   protected TlsCredentialedDecryptor serverCredentials;
   protected TlsCertificate serverCertificate;
   protected TlsSecret preMasterSecret;

   public TlsPSKKeyExchange(int var1, Vector var2, TlsPSKIdentity var3, TlsDHConfigVerifier var4, TlsECConfigVerifier var5, short[] var6, short[] var7) {
      this(var1, var2, var3, (TlsPSKIdentityManager)null, var4, (TlsDHConfig)null, var5, (TlsECConfig)null, var6, var7);
   }

   public TlsPSKKeyExchange(int var1, Vector var2, TlsPSKIdentity var3, TlsPSKIdentityManager var4, TlsDHConfig var5, TlsECConfig var6, short[] var7) {
      this(var1, var2, var3, var4, (TlsDHConfigVerifier)null, var5, (TlsECConfigVerifier)null, var6, (short[])null, var7);
   }

   private TlsPSKKeyExchange(int var1, Vector var2, TlsPSKIdentity var3, TlsPSKIdentityManager var4, TlsDHConfigVerifier var5, TlsDHConfig var6, TlsECConfigVerifier var7, TlsECConfig var8, short[] var9, short[] var10) {
      super(var1, var2);
      this.psk_identity_hint = null;
      this.psk = null;
      this.serverCredentials = null;
      switch(var1) {
      case 13:
      case 14:
      case 15:
      case 24:
         this.pskIdentity = var3;
         this.pskIdentityManager = var4;
         this.dhConfigVerifier = var5;
         this.dhConfig = var6;
         this.ecConfigVerifier = var7;
         this.ecConfig = var8;
         this.clientECPointFormats = var9;
         this.serverECPointFormats = var10;
         return;
      default:
         throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
   }

   public void skipServerCredentials() throws IOException {
      if (this.keyExchange == 15) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange != 15) {
         throw new TlsFatalAlert((short)80);
      } else if (!(var1 instanceof TlsCredentialedDecryptor)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.serverCredentials = (TlsCredentialedDecryptor)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (this.keyExchange != 15) {
         throw new TlsFatalAlert((short)10);
      } else if (var1.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         this.checkServerCertSigAlg(var1);
         this.serverCertificate = var1.getCertificateAt(0).useInRole(0, this.keyExchange);
      }
   }

   public byte[] generateServerKeyExchange() throws IOException {
      this.psk_identity_hint = this.pskIdentityManager.getHint();
      if (this.psk_identity_hint == null && !this.requiresServerKeyExchange()) {
         return null;
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         if (this.psk_identity_hint == null) {
            TlsUtils.writeOpaque16(TlsUtils.EMPTY_BYTES, var1);
         } else {
            TlsUtils.writeOpaque16(this.psk_identity_hint, var1);
         }

         if (this.keyExchange == 14) {
            if (this.dhConfig == null) {
               throw new TlsFatalAlert((short)80);
            }

            TlsDHUtils.writeDHConfig(this.dhConfig, var1);
            this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
            this.generateEphemeralDH(var1);
         } else if (this.keyExchange == 24) {
            if (this.ecConfig == null) {
               throw new TlsFatalAlert((short)80);
            }

            TlsECCUtils.writeECConfig(this.ecConfig, var1);
            this.agreement = this.context.getCrypto().createECDomain(this.ecConfig).createECDH();
            this.generateEphemeralECDH(var1);
         }

         return var1.toByteArray();
      }
   }

   public boolean requiresServerKeyExchange() {
      switch(this.keyExchange) {
      case 14:
      case 24:
         return true;
      default:
         return false;
      }
   }

   public void processServerKeyExchange(InputStream var1) throws IOException {
      this.psk_identity_hint = TlsUtils.readOpaque16(var1);
      byte[] var2;
      if (this.keyExchange == 14) {
         this.dhConfig = TlsDHUtils.receiveDHConfig(this.dhConfigVerifier, var1);
         var2 = TlsUtils.readOpaque16(var1);
         this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
         this.processEphemeralDH(var2);
      } else if (this.keyExchange == 24) {
         this.ecConfig = TlsECCUtils.receiveECConfig(this.ecConfigVerifier, this.serverECPointFormats, var1);
         var2 = TlsUtils.readOpaque8(var1);
         this.agreement = this.context.getCrypto().createECDomain(this.ecConfig).createECDH();
         this.processEphemeralECDH(this.clientECPointFormats, var2);
      }

   }

   public void validateCertificateRequest(CertificateRequest var1) throws IOException {
      throw new TlsFatalAlert((short)10);
   }

   public void processClientCredentials(TlsCredentials var1) throws IOException {
      throw new TlsFatalAlert((short)80);
   }

   public void generateClientKeyExchange(OutputStream var1) throws IOException {
      if (this.psk_identity_hint == null) {
         this.pskIdentity.skipIdentityHint();
      } else {
         this.pskIdentity.notifyIdentityHint(this.psk_identity_hint);
      }

      byte[] var2 = this.pskIdentity.getPSKIdentity();
      if (var2 == null) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.psk = this.pskIdentity.getPSK();
         if (this.psk == null) {
            throw new TlsFatalAlert((short)80);
         } else {
            TlsUtils.writeOpaque16(var2, var1);
            this.context.getSecurityParameters().pskIdentity = Arrays.clone(var2);
            if (this.keyExchange == 14) {
               this.generateEphemeralDH(var1);
            } else if (this.keyExchange == 24) {
               this.generateEphemeralECDH(var1);
            } else if (this.keyExchange == 15) {
               this.preMasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.serverCertificate, var1);
            }

         }
      }
   }

   public void processClientKeyExchange(InputStream var1) throws IOException {
      byte[] var2 = TlsUtils.readOpaque16(var1);
      this.psk = this.pskIdentityManager.getPSK(var2);
      if (this.psk == null) {
         throw new TlsFatalAlert((short)115);
      } else {
         this.context.getSecurityParameters().pskIdentity = var2;
         byte[] var3;
         if (this.keyExchange == 14) {
            var3 = TlsUtils.readOpaque16(var1);
            this.processEphemeralDH(var3);
         } else if (this.keyExchange == 24) {
            var3 = TlsUtils.readOpaque8(var1);
            this.processEphemeralECDH(this.serverECPointFormats, var3);
         } else if (this.keyExchange == 15) {
            if (TlsUtils.isSSL(this.context)) {
               var3 = Streams.readAll(var1);
            } else {
               var3 = TlsUtils.readOpaque16(var1);
            }

            this.preMasterSecret = this.serverCredentials.decrypt(new TlsCryptoParameters(this.context), var3);
         }

      }
   }

   public TlsSecret generatePreMasterSecret() throws IOException {
      byte[] var1 = this.generateOtherSecret(this.psk.length);
      ByteArrayOutputStream var2 = new ByteArrayOutputStream(4 + var1.length + this.psk.length);
      TlsUtils.writeOpaque16(var1, var2);
      TlsUtils.writeOpaque16(this.psk, var2);
      Arrays.fill((byte[])this.psk, (byte)0);
      this.psk = null;
      return this.context.getCrypto().createSecret(var2.toByteArray());
   }

   protected void generateEphemeralDH(OutputStream var1) throws IOException {
      byte[] var2 = this.agreement.generateEphemeral();
      TlsUtils.writeOpaque16(var2, var1);
   }

   protected void generateEphemeralECDH(OutputStream var1) throws IOException {
      byte[] var2 = this.agreement.generateEphemeral();
      TlsUtils.writeOpaque8(var2, var1);
   }

   protected byte[] generateOtherSecret(int var1) throws IOException {
      if (this.keyExchange == 13) {
         return new byte[var1];
      } else if ((this.keyExchange == 14 || this.keyExchange == 24) && this.agreement != null) {
         return this.agreement.calculateSecret().extract();
      } else if (this.keyExchange == 15 && this.preMasterSecret != null) {
         return this.preMasterSecret.extract();
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   protected void processEphemeralDH(byte[] var1) throws IOException {
      this.agreement.receivePeerValue(var1);
   }

   protected void processEphemeralECDH(short[] var1, byte[] var2) throws IOException {
      TlsECCUtils.checkPointEncoding(var1, this.ecConfig.getNamedCurve(), var2);
      this.agreement.receivePeerValue(var2);
   }
}
