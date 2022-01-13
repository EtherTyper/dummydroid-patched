package org.bouncycastle.tls.crypto;

import java.io.IOException;
import java.math.BigInteger;

public interface TlsSRP6Client {
   BigInteger calculateSecret(BigInteger var1) throws IOException;

   BigInteger generateClientCredentials(byte[] var1, byte[] var2, byte[] var3);
}
