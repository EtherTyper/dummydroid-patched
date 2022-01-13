package org.bouncycastle.tls.crypto;

public interface TlsMAC {
   void setKey(byte[] var1);

   void update(byte[] var1, int var2, int var3);

   byte[] calculateMAC();

   int getMacLength();

   void reset();
}
