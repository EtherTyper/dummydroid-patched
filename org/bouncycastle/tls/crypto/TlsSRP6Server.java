package org.bouncycastle.tls.crypto;

import java.io.IOException;
import java.math.BigInteger;

public interface TlsSRP6Server {
   BigInteger generateServerCredentials();

   BigInteger calculateSecret(BigInteger var1) throws IOException;
}
