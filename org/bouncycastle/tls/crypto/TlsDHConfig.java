package org.bouncycastle.tls.crypto;

import java.math.BigInteger;

public class TlsDHConfig {
   protected BigInteger[] explicitPG;

   public BigInteger[] getExplicitPG() {
      return (BigInteger[])this.explicitPG.clone();
   }

   public void setExplicitPG(BigInteger[] var1) {
      this.explicitPG = (BigInteger[])var1.clone();
   }
}
