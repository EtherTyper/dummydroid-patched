package org.bouncycastle.tls.crypto;

public interface TlsHash {
   void update(byte[] var1, int var2, int var3);

   byte[] calculateHash();

   Object clone();

   void reset();
}
