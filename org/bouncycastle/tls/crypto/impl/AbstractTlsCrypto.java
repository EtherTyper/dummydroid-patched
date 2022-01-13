package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsSecret;

public abstract class AbstractTlsCrypto implements TlsCrypto {
   public TlsSecret adoptSecret(TlsSecret var1) {
      if (var1 instanceof AbstractTlsSecret) {
         AbstractTlsSecret var2 = (AbstractTlsSecret)var1;
         return this.createSecret(var2.copyData());
      } else {
         throw new IllegalArgumentException("unrecognized TlsSecret - cannot copy data: " + var1.getClass().getName());
      }
   }

   protected abstract TlsCipher createCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException;

   protected abstract TlsEncryptor createEncryptor(TlsCertificate var1) throws IOException;
}
