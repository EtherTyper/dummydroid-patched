package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;

public interface TlsSuiteMac {
   void setKey(byte[] var1) throws IOException;

   int getSize();

   byte[] calculateMac(long var1, short var3, byte[] var4, int var5, int var6);

   byte[] calculateMacConstantTime(long var1, short var3, byte[] var4, int var5, int var6, int var7, byte[] var8);
}
