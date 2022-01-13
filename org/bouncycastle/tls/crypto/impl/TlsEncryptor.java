package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;

public interface TlsEncryptor {
   byte[] encrypt(byte[] var1, int var2, int var3) throws IOException;
}
