package org.bouncycastle.tls.crypto;

import java.math.BigInteger;

public class TlsSRPConfig {
   protected BigInteger[] explicitNG;

   public BigInteger[] getExplicitNG() {
      return (BigInteger[])this.explicitNG.clone();
   }

   public void setExplicitNG(BigInteger[] var1) {
      this.explicitNG = (BigInteger[])var1.clone();
   }
}
