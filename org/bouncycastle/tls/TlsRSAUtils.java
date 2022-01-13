package org.bouncycastle.tls;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsSecret;

public abstract class TlsRSAUtils {
   private TlsRSAUtils() {
   }

   public static TlsSecret generateEncryptedPreMasterSecret(TlsContext var0, TlsCertificate var1, OutputStream var2) throws IOException {
      TlsSecret var3 = var0.getCrypto().generateRSAPreMasterSecret(var0.getClientVersion());
      byte[] var4 = var3.encrypt(var1);
      if (TlsUtils.isSSL(var0)) {
         var2.write(var4);
      } else {
         TlsUtils.writeOpaque16(var4, var2);
      }

      return var3;
   }
}
