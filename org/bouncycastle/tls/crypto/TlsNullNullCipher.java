package org.bouncycastle.tls.crypto;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class TlsNullNullCipher implements TlsCipher {
   public int getPlaintextLimit(int var1) {
      return var1;
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      return Arrays.copyOfRange(var4, var5, var5 + var6);
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      return Arrays.copyOfRange(var4, var5, var5 + var6);
   }
}
