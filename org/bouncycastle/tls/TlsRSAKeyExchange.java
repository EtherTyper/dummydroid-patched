package org.bouncycastle.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.util.io.Streams;

public class TlsRSAKeyExchange extends AbstractTlsKeyExchange {
   protected TlsCredentialedDecryptor serverCredentials = null;
   protected TlsCertificate serverCertificate;
   protected TlsSecret preMasterSecret;

   public TlsRSAKeyExchange(Vector var1) {
      super(1, var1);
   }

   public void skipServerCredentials() throws IOException {
      throw new TlsFatalAlert((short)80);
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (!(var1 instanceof TlsCredentialedDecryptor)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.serverCredentials = (TlsCredentialedDecryptor)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (var1.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         this.checkServerCertSigAlg(var1);
         this.serverCertificate = var1.getCertificateAt(0).useInRole(0, this.keyExchange);
      }
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

   public void generateClientKeyExchange(OutputStream var1) throws IOException {
      this.preMasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.serverCertificate, var1);
   }

   public void processClientKeyExchange(InputStream var1) throws IOException {
      byte[] var2;
      if (TlsUtils.isSSL(this.context)) {
         var2 = Streams.readAll(var1);
      } else {
         var2 = TlsUtils.readOpaque16(var1);
      }

      this.preMasterSecret = this.serverCredentials.decrypt(new TlsCryptoParameters(this.context), var2);
   }

   public TlsSecret generatePreMasterSecret() throws IOException {
      TlsSecret var1 = this.preMasterSecret;
      this.preMasterSecret = null;
      return var1;
   }
}
