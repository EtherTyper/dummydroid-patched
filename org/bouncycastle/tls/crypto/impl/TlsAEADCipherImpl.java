package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;

public interface TlsAEADCipherImpl {
   void setKey(byte[] var1) throws IOException;

   void init(byte[] var1, int var2, byte[] var3) throws IOException;

   int getOutputSize(int var1);

   int doFinal(byte[] var1, int var2, int var3, byte[] var4, int var5) throws IOException;
}
