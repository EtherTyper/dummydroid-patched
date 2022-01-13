package org.bouncycastle.tls;

import java.math.BigInteger;
import org.bouncycastle.tls.crypto.TlsSRPConfig;

public class TlsSRPLoginParameters {
   protected TlsSRPConfig srpConfig;
   protected BigInteger verifier;
   protected byte[] salt;

   public TlsSRPLoginParameters(TlsSRPConfig var1, BigInteger var2, byte[] var3) {
      this.srpConfig = var1;
      this.verifier = var2;
      this.salt = var3;
   }

   public TlsSRPConfig getConfig() {
      return this.srpConfig;
   }

   public byte[] getSalt() {
      return this.salt;
   }

   public BigInteger getVerifier() {
      return this.verifier;
   }
}
