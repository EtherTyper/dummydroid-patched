package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsHMAC;
import org.bouncycastle.util.Arrays;

public class TlsStreamCipher implements TlsCipher {
   protected TlsCryptoParameters cryptoParams;
   protected TlsStreamCipherImpl encryptCipher;
   protected TlsStreamCipherImpl decryptCipher;
   protected TlsSuiteMac writeMac;
   protected TlsSuiteMac readMac;
   protected boolean usesNonce;

   public TlsStreamCipher(TlsCryptoParameters var1, TlsStreamCipherImpl var2, TlsStreamCipherImpl var3, TlsHMAC var4, TlsHMAC var5, int var6, boolean var7) throws IOException {
      boolean var8 = var1.isServer();
      this.cryptoParams = var1;
      this.usesNonce = var7;
      this.encryptCipher = var2;
      this.decryptCipher = var3;
      int var9 = 2 * var6 + var4.getMacLength() + var5.getMacLength();
      byte[] var10 = TlsImplUtils.calculateKeyBlock(var1, var9);
      byte var11 = 0;
      TlsSuiteHMac var12 = new TlsSuiteHMac(var1, var4);
      var12.setKey(Arrays.copyOfRange((byte[])var10, var11, var11 + var4.getMacLength()));
      int var19 = var11 + var4.getMacLength();
      TlsSuiteHMac var13 = new TlsSuiteHMac(var1, var5);
      var13.setKey(Arrays.copyOfRange(var10, var19, var19 + var5.getMacLength()));
      var19 += var5.getMacLength();
      byte[] var14 = Arrays.copyOfRange(var10, var19, var19 + var6);
      var19 += var6;
      byte[] var15 = Arrays.copyOfRange(var10, var19, var19 + var6);
      var19 += var6;
      if (var19 != var9) {
         throw new TlsFatalAlert((short)80);
      } else {
         byte[] var16;
         byte[] var17;
         if (var8) {
            this.writeMac = var13;
            this.readMac = var12;
            var16 = var15;
            var17 = var14;
         } else {
            this.writeMac = var12;
            this.readMac = var13;
            var16 = var14;
            var17 = var15;
         }

         this.encryptCipher.setKey(var16);
         this.decryptCipher.setKey(var17);
         if (var7) {
            byte[] var18 = new byte[8];
            this.encryptCipher.init(var18);
            this.decryptCipher.init(var18);
         } else {
            this.encryptCipher.init((byte[])null);
            this.decryptCipher.init((byte[])null);
         }

      }
   }

   public int getPlaintextLimit(int var1) {
      return var1 - this.writeMac.getSize();
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      if (this.usesNonce) {
         this.updateIV(this.encryptCipher, true, var1);
      }

      byte[] var7 = new byte[var6 + this.writeMac.getSize()];
      byte[] var8 = this.writeMac.calculateMac(var1, var3, var4, var5, var6);
      System.arraycopy(var4, var5, var7, 0, var6);
      System.arraycopy(var8, 0, var7, var6, var8.length);
      this.encryptCipher.doFinal(var7, 0, var7.length, var7, 0);
      return var7;
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      if (this.usesNonce) {
         this.updateIV(this.decryptCipher, false, var1);
      }

      int var7 = this.readMac.getSize();
      if (var6 < var7) {
         throw new TlsFatalAlert((short)50);
      } else {
         int var8 = var6 - var7;
         byte[] var9 = new byte[var6];
         this.decryptCipher.doFinal(var4, var5, var6, var9, 0);
         this.checkMAC(var1, var3, var9, var8, var6, var9, 0, var8);
         return Arrays.copyOfRange((byte[])var9, 0, var8);
      }
   }

   protected void checkMAC(long var1, short var3, byte[] var4, int var5, int var6, byte[] var7, int var8, int var9) throws IOException {
      byte[] var10 = Arrays.copyOfRange(var4, var5, var6);
      byte[] var11 = this.readMac.calculateMac(var1, var3, var7, var8, var9);
      if (!Arrays.constantTimeAreEqual(var10, var11)) {
         throw new TlsFatalAlert((short)20);
      }
   }

   protected void updateIV(TlsStreamCipherImpl var1, boolean var2, long var3) throws IOException {
      byte[] var5 = new byte[8];
      TlsUtils.writeUint64(var3, var5, 0);
      var1.init(var5);
   }
}
