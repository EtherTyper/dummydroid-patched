package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsHMAC;
import org.bouncycastle.util.Arrays;

public class TlsNullCipher implements TlsCipher {
   protected TlsCryptoParameters cryptoParameters;
   protected TlsSuiteHMac writeMac;
   protected TlsSuiteHMac readMac;

   public TlsNullCipher(TlsCryptoParameters var1, TlsHMAC var2, TlsHMAC var3) throws IOException {
      this.cryptoParameters = var1;
      int var4 = var2.getMacLength() + var3.getMacLength();
      byte[] var5 = TlsImplUtils.calculateKeyBlock(var1, var4);
      byte var6 = 0;
      byte[] var7 = Arrays.copyOfRange((byte[])var5, var6, var6 + var2.getMacLength());
      int var9 = var6 + var7.length;
      byte[] var8 = Arrays.copyOfRange(var5, var9, var9 + var3.getMacLength());
      var9 += var8.length;
      if (var9 != var4) {
         throw new TlsFatalAlert((short)80);
      } else {
         if (var1.isServer()) {
            this.writeMac = new TlsSuiteHMac(var1, var3);
            this.readMac = new TlsSuiteHMac(var1, var2);
            this.writeMac.setKey(var8);
            this.readMac.setKey(var7);
         } else {
            this.writeMac = new TlsSuiteHMac(var1, var2);
            this.readMac = new TlsSuiteHMac(var1, var3);
            this.writeMac.setKey(var7);
            this.readMac.setKey(var8);
         }

      }
   }

   public int getPlaintextLimit(int var1) {
      return var1 - this.writeMac.getSize();
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      byte[] var7 = this.writeMac.calculateMac(var1, var3, var4, var5, var6);
      byte[] var8 = new byte[var6 + var7.length];
      System.arraycopy(var4, var5, var8, 0, var6);
      System.arraycopy(var7, 0, var8, var6, var7.length);
      return var8;
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      int var7 = this.readMac.getSize();
      if (var6 < var7) {
         throw new TlsFatalAlert((short)50);
      } else {
         int var8 = var6 - var7;
         byte[] var9 = Arrays.copyOfRange(var4, var5 + var8, var5 + var6);
         byte[] var10 = this.readMac.calculateMac(var1, var3, var4, var5, var8);
         if (!Arrays.constantTimeAreEqual(var9, var10)) {
            throw new TlsFatalAlert((short)20);
         } else {
            return Arrays.copyOfRange(var4, var5, var5 + var8);
         }
      }
   }
}
