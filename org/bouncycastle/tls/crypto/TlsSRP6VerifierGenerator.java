package org.bouncycastle.tls.crypto;

import java.math.BigInteger;

public interface TlsSRP6VerifierGenerator {
   BigInteger generateVerifier(byte[] var1, byte[] var2, byte[] var3);
}
