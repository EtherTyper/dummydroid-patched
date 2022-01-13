package org.bouncycastle.tls.crypto;

import java.math.BigInteger;

public class DHGroup {
   private final BigInteger p;
   private final BigInteger q;
   private final BigInteger g;

   public DHGroup(BigInteger var1, BigInteger var2) {
      this(var1, (BigInteger)null, var2);
   }

   public DHGroup(BigInteger var1, BigInteger var2, BigInteger var3) {
      this.p = var1;
      this.g = var3;
      this.q = var2;
   }

   public BigInteger getG() {
      return this.g;
   }

   public BigInteger getP() {
      return this.p;
   }

   public BigInteger getQ() {
      return this.q;
   }
}
