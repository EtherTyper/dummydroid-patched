package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;

public interface TlsBlockCipherImpl {
   void setKey(byte[] var1) throws IOException;

   void init(byte[] var1) throws IOException;

   int doFinal(byte[] var1, int var2, int var3, byte[] var4, int var5) throws IOException;

   int getBlockSize();
}
