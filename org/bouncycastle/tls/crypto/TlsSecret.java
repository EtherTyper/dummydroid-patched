package org.bouncycastle.tls.crypto;

import java.io.IOException;

public interface TlsSecret {
   TlsSecret deriveSSLKeyBlock(byte[] var1, int var2);

   TlsSecret deriveSSLMasterSecret(byte[] var1);

   TlsSecret deriveUsingPRF(int var1, byte[] var2, int var3);

   TlsCipher createCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException;

   void destroy();

   byte[] encrypt(TlsCertificate var1) throws IOException;

   byte[] extract();
}
