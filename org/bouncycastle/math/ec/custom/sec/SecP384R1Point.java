package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;

public class SecP384R1Point extends ECPoint.AbstractFp {
   /** @deprecated */
   public SecP384R1Point(ECCurve var1, ECFieldElement var2, ECFieldElement var3) {
      this(var1, var2, var3, false);
   }

   /** @deprecated */
   public SecP384R1Point(ECCurve var1, ECFieldElement var2, ECFieldElement var3, boolean var4) {
      super(var1, var2, var3);
      if (var2 == null != (var3 == null)) {
         throw new IllegalArgumentException("Exactly one of the field elements is null");
      } else {
         this.withCompression = var4;
      }
   }

   SecP384R1Point(ECCurve var1, ECFieldElement var2, ECFieldElement var3, ECFieldElement[] var4, boolean var5) {
      super(var1, var2, var3, var4);
      this.withCompression = var5;
   }

   protected ECPoint detach() {
      return new SecP384R1Point((ECCurve)null, this.getAffineXCoord(), this.getAffineYCoord());
   }

   public ECPoint add(ECPoint var1) {
      if (this.isInfinity()) {
         return var1;
      } else if (var1.isInfinity()) {
         return this;
      } else if (this == var1) {
         return this.twice();
      } else {
         ECCurve var2 = this.getCurve();
         SecP384R1FieldElement var3 = (SecP384R1FieldElement)this.x;
         SecP384R1FieldElement var4 = (SecP384R1FieldElement)this.y;
         SecP384R1FieldElement var5 = (SecP384R1FieldElement)var1.getXCoord();
         SecP384R1FieldElement var6 = (SecP384R1FieldElement)var1.getYCoord();
         SecP384R1FieldElement var7 = (SecP384R1FieldElement)this.zs[0];
         SecP384R1FieldElement var8 = (SecP384R1FieldElement)var1.getZCoord(0);
         int[] var10 = Nat.create(24);
         int[] var11 = Nat.create(24);
         int[] var12 = Nat.create(12);
         int[] var13 = Nat.create(12);
         boolean var14 = var7.isOne();
         int[] var15;
         int[] var16;
         if (var14) {
            var15 = var5.x;
            var16 = var6.x;
         } else {
            var16 = var12;
            SecP384R1Field.square(var7.x, var12);
            var15 = var11;
            SecP384R1Field.multiply(var12, var5.x, var11);
            SecP384R1Field.multiply(var12, var7.x, var12);
            SecP384R1Field.multiply(var12, var6.x, var12);
         }

         boolean var17 = var8.isOne();
         int[] var18;
         int[] var19;
         if (var17) {
            var18 = var3.x;
            var19 = var4.x;
         } else {
            var19 = var13;
            SecP384R1Field.square(var8.x, var13);
            var18 = var10;
            SecP384R1Field.multiply(var13, var3.x, var10);
            SecP384R1Field.multiply(var13, var8.x, var13);
            SecP384R1Field.multiply(var13, var4.x, var13);
         }

         int[] var20 = Nat.create(12);
         SecP384R1Field.subtract(var18, var15, var20);
         int[] var21 = Nat.create(12);
         SecP384R1Field.subtract(var19, var16, var21);
         if (Nat.isZero(12, var20)) {
            return Nat.isZero(12, var21) ? this.twice() : var2.getInfinity();
         } else {
            SecP384R1Field.square(var20, var12);
            int[] var23 = Nat.create(12);
            SecP384R1Field.multiply(var12, var20, var23);
            SecP384R1Field.multiply(var12, var18, var12);
            SecP384R1Field.negate(var23, var23);
            Nat384.mul(var19, var23, var10);
            int var9 = Nat.addBothTo(12, var12, var12, var23);
            SecP384R1Field.reduce32(var9, var23);
            SecP384R1FieldElement var25 = new SecP384R1FieldElement(var13);
            SecP384R1Field.square(var21, var25.x);
            SecP384R1Field.subtract(var25.x, var23, var25.x);
            SecP384R1FieldElement var26 = new SecP384R1FieldElement(var23);
            SecP384R1Field.subtract(var12, var25.x, var26.x);
            Nat384.mul(var26.x, var21, var11);
            SecP384R1Field.addExt(var10, var11, var10);
            SecP384R1Field.reduce(var10, var26.x);
            SecP384R1FieldElement var27 = new SecP384R1FieldElement(var20);
            if (!var14) {
               SecP384R1Field.multiply(var27.x, var7.x, var27.x);
            }

            if (!var17) {
               SecP384R1Field.multiply(var27.x, var8.x, var27.x);
            }

            ECFieldElement[] var28 = new ECFieldElement[]{var27};
            return new SecP384R1Point(var2, var25, var26, var28, this.withCompression);
         }
      }
   }

   public ECPoint twice() {
      if (this.isInfinity()) {
         return this;
      } else {
         ECCurve var1 = this.getCurve();
         SecP384R1FieldElement var2 = (SecP384R1FieldElement)this.y;
         if (var2.isZero()) {
            return var1.getInfinity();
         } else {
            SecP384R1FieldElement var3 = (SecP384R1FieldElement)this.x;
            SecP384R1FieldElement var4 = (SecP384R1FieldElement)this.zs[0];
            int[] var6 = Nat.create(12);
            int[] var7 = Nat.create(12);
            int[] var8 = Nat.create(12);
            SecP384R1Field.square(var2.x, var8);
            int[] var9 = Nat.create(12);
            SecP384R1Field.square(var8, var9);
            boolean var10 = var4.isOne();
            int[] var11 = var4.x;
            if (!var10) {
               var11 = var7;
               SecP384R1Field.square(var4.x, var7);
            }

            SecP384R1Field.subtract(var3.x, var11, var6);
            SecP384R1Field.add(var3.x, var11, var7);
            SecP384R1Field.multiply(var7, var6, var7);
            int var5 = Nat.addBothTo(12, var7, var7, var7);
            SecP384R1Field.reduce32(var5, var7);
            SecP384R1Field.multiply(var8, var3.x, var8);
            var5 = Nat.shiftUpBits(12, var8, 2, 0);
            SecP384R1Field.reduce32(var5, var8);
            var5 = Nat.shiftUpBits(12, var9, 3, 0, var6);
            SecP384R1Field.reduce32(var5, var6);
            SecP384R1FieldElement var14 = new SecP384R1FieldElement(var9);
            SecP384R1Field.square(var7, var14.x);
            SecP384R1Field.subtract(var14.x, var8, var14.x);
            SecP384R1Field.subtract(var14.x, var8, var14.x);
            SecP384R1FieldElement var15 = new SecP384R1FieldElement(var8);
            SecP384R1Field.subtract(var8, var14.x, var15.x);
            SecP384R1Field.multiply(var15.x, var7, var15.x);
            SecP384R1Field.subtract(var15.x, var6, var15.x);
            SecP384R1FieldElement var16 = new SecP384R1FieldElement(var7);
            SecP384R1Field.twice(var2.x, var16.x);
            if (!var10) {
               SecP384R1Field.multiply(var16.x, var4.x, var16.x);
            }

            return new SecP384R1Point(var1, var14, var15, new ECFieldElement[]{var16}, this.withCompression);
         }
      }
   }

   public ECPoint twicePlus(ECPoint var1) {
      if (this == var1) {
         return this.threeTimes();
      } else if (this.isInfinity()) {
         return var1;
      } else if (var1.isInfinity()) {
         return this.twice();
      } else {
         ECFieldElement var2 = this.y;
         return var2.isZero() ? var1 : this.twice().add(var1);
      }
   }

   public ECPoint threeTimes() {
      return (ECPoint)(!this.isInfinity() && !this.y.isZero() ? this.twice().add(this) : this);
   }

   public ECPoint negate() {
      return this.isInfinity() ? this : new SecP384R1Point(this.curve, this.x, this.y.negate(), this.zs, this.withCompression);
   }
}
