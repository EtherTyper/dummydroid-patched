package org.bouncycastle.tls;

import org.bouncycastle.util.Arrays;

public class SSL3Constants {
   private static final byte IPAD_BYTE = 54;
   private static final byte OPAD_BYTE = 92;
   private static final byte[] IPAD = genPad((byte)54, 48);
   private static final byte[] OPAD = genPad((byte)92, 48);

   private static byte[] genPad(byte var0, int var1) {
      byte[] var2 = new byte[var1];
      Arrays.fill(var2, var0);
      return var2;
   }

   public static byte[] getInputPad() {
      return (byte[])IPAD.clone();
   }

   public static byte[] getOutputPad() {
      return (byte[])OPAD.clone();
   }
}
