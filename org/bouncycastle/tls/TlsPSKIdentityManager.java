package org.bouncycastle.tls;

public interface TlsPSKIdentityManager {
   byte[] getHint();

   byte[] getPSK(byte[] var1);
}
