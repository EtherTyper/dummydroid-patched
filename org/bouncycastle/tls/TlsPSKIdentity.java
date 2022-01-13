package org.bouncycastle.tls;

public interface TlsPSKIdentity {
   void skipIdentityHint();

   void notifyIdentityHint(byte[] var1);

   byte[] getPSKIdentity();

   byte[] getPSK();
}
