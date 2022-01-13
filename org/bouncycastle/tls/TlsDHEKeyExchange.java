package org.bouncycastle.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsVerifier;
import org.bouncycastle.util.io.TeeInputStream;

public class TlsDHEKeyExchange extends TlsDHKeyExchange {
   protected TlsCredentialedSigner serverCredentials = null;
   protected TlsVerifier verifier = null;

   private static int checkKeyExchange(int var0) {
      switch(var0) {
      case 3:
      case 5:
         return var0;
      default:
         throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
   }

   public TlsDHEKeyExchange(int var1, Vector var2, TlsDHConfigVerifier var3) {
      super(checkKeyExchange(var1), var2, var3);
   }

   public TlsDHEKeyExchange(int var1, Vector var2, TlsDHConfig var3) {
      super(checkKeyExchange(var1), var2, var3);
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (!(var1 instanceof TlsCredentialedSigner)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.serverCredentials = (TlsCredentialedSigner)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (var1.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         this.checkServerCertSigAlg(var1);
         this.verifier = var1.getCertificateAt(0).createVerifier(TlsUtils.getSignatureAlgorithm(this.keyExchange));
      }
   }

   public byte[] generateServerKeyExchange() throws IOException {
      if (this.dhConfig == null) {
         throw new TlsFatalAlert((short)80);
      } else {
         DigestInputBuffer var1 = new DigestInputBuffer();
         TlsDHUtils.writeDHConfig(this.dhConfig, var1);
         this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
         this.generateEphemeral(var1);
         DigitallySigned var2 = TlsUtils.generateServerKeyExchangeSignature(this.context, this.serverCredentials, var1);
         var2.encode(var1);
         return var1.toByteArray();
      }
   }

   public void processServerKeyExchange(InputStream var1) throws IOException {
      DigestInputBuffer var2 = new DigestInputBuffer();
      TeeInputStream var3 = new TeeInputStream(var1, var2);
      this.dhConfig = TlsDHUtils.receiveDHConfig(this.dhConfigVerifier, var3);
      byte[] var4 = TlsUtils.readOpaque16(var3);
      DigitallySigned var5 = this.parseSignature(var1);
      TlsUtils.verifyServerKeyExchangeSignature(this.context, this.verifier, var2, var5);
      this.agreement = this.context.getCrypto().createDHDomain(this.dhConfig).createDH();
      this.processEphemeral(var4);
   }

   public void validateCertificateRequest(CertificateRequest var1) throws IOException {
      short[] var2 = var1.getCertificateTypes();
      int var3 = 0;

      while(var3 < var2.length) {
         switch(var2[var3]) {
         case 1:
         case 2:
         case 64:
            ++var3;
            break;
         default:
            throw new TlsFatalAlert((short)47);
         }
      }

   }

   public void processClientCredentials(TlsCredentials var1) throws IOException {
      if (!(var1 instanceof TlsCredentialedSigner)) {
         throw new TlsFatalAlert((short)80);
      }
   }
}
