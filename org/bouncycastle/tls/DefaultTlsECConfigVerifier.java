package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.util.Arrays;

public class DefaultTlsECConfigVerifier implements TlsECConfigVerifier {
   protected int minimumCurveBits;
   protected int[] namedCurves;

   public DefaultTlsECConfigVerifier(int var1, int[] var2) {
      this.minimumCurveBits = var1;
      this.namedCurves = Arrays.clone(var2);
   }

   public boolean accept(TlsECConfig var1) {
      int var2 = var1.getNamedCurve();
      if (NamedCurve.getCurveBits(var2) < this.minimumCurveBits) {
         return false;
      } else {
         return this.namedCurves == null || Arrays.contains(this.namedCurves, var2);
      }
   }
}
