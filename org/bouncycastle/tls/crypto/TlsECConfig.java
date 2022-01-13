package org.bouncycastle.tls.crypto;

public class TlsECConfig {
   protected int namedCurve;
   protected boolean pointCompression;

   public int getNamedCurve() {
      return this.namedCurve;
   }

   public void setNamedCurve(int var1) {
      this.namedCurve = var1;
   }

   public boolean getPointCompression() {
      return this.pointCompression;
   }

   public void setPointCompression(boolean var1) {
      this.pointCompression = var1;
   }
}
