package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsHMAC;
import org.bouncycastle.util.Arrays;

public class TlsBlockCipher implements TlsCipher {
   protected TlsCryptoParameters cryptoParams;
   private final TlsCrypto crypto;
   protected byte[] randomData;
   protected boolean useExplicitIV;
   protected boolean encryptThenMAC;
   protected TlsBlockCipherImpl encryptCipher;
   protected TlsBlockCipherImpl decryptCipher;
   protected TlsSuiteMac writeMac;
   protected TlsSuiteMac readMac;

   public TlsBlockCipher(TlsCrypto var1, TlsCryptoParameters var2, TlsBlockCipherImpl var3, TlsBlockCipherImpl var4, TlsHMAC var5, TlsHMAC var6, int var7) throws IOException {
      this.cryptoParams = var2;
      this.crypto = var1;
      this.randomData = var1.createNonce(256);
      this.useExplicitIV = TlsImplUtils.isTLSv11(var2);
      this.encryptThenMAC = var2.getSecurityParameters().isEncryptThenMAC();
      int var8 = 2 * var7 + var5.getMacLength() + var6.getMacLength();
      if (!this.useExplicitIV) {
         var8 += var3.getBlockSize() + var4.getBlockSize();
      }

      byte[] var9 = TlsImplUtils.calculateKeyBlock(var2, var8);
      byte var10 = 0;
      byte[] var11 = Arrays.copyOfRange((byte[])var9, var10, var10 + var5.getMacLength());
      int var17 = var10 + var11.length;
      byte[] var12 = Arrays.copyOfRange(var9, var17, var17 + var5.getMacLength());
      var17 += var12.length;
      byte[] var13 = Arrays.copyOfRange(var9, var17, var17 + var7);
      var17 += var7;
      byte[] var14 = Arrays.copyOfRange(var9, var17, var17 + var7);
      var17 += var7;
      byte[] var15;
      byte[] var16;
      if (this.useExplicitIV) {
         var16 = new byte[var3.getBlockSize()];
         var15 = new byte[var3.getBlockSize()];
      } else {
         var16 = Arrays.copyOfRange(var9, var17, var17 + var3.getBlockSize());
         var17 += var3.getBlockSize();
         var15 = Arrays.copyOfRange(var9, var17, var17 + var3.getBlockSize());
         var17 += var3.getBlockSize();
      }

      if (var17 != var8) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.readMac = new TlsSuiteHMac(var2, var6);
         this.writeMac = new TlsSuiteHMac(var2, var5);
         this.encryptCipher = var3;
         this.decryptCipher = var4;
         if (var2.isServer()) {
            this.writeMac.setKey(var12);
            this.readMac.setKey(var11);
            this.encryptCipher.setKey(var14);
            this.decryptCipher.setKey(var13);
            this.encryptCipher.init(var15);
            this.decryptCipher.init(var16);
         } else {
            this.writeMac.setKey(var11);
            this.readMac.setKey(var12);
            this.encryptCipher.setKey(var13);
            this.decryptCipher.setKey(var14);
            this.encryptCipher.init(var16);
            this.decryptCipher.init(var15);
         }

      }
   }

   public int getPlaintextLimit(int var1) {
      int var2 = this.encryptCipher.getBlockSize();
      int var3 = this.writeMac.getSize();
      int var4 = var1;
      if (this.useExplicitIV) {
         var4 = var1 - var2;
      }

      if (this.encryptThenMAC) {
         var4 -= var3;
         var4 -= var4 % var2;
      } else {
         var4 -= var4 % var2;
         var4 -= var3;
      }

      --var4;
      return var4;
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      int var7 = this.encryptCipher.getBlockSize();
      int var8 = this.writeMac.getSize();
      ProtocolVersion var9 = this.cryptoParams.getServerVersion();
      int var10 = var6;
      if (!this.encryptThenMAC) {
         var10 = var6 + var8;
      }

      int var11 = var7 - 1 - var10 % var7;
      int var12;
      if (!var9.isDTLS() && !var9.isSSL()) {
         var12 = (255 - var11) / var7;
         int var13 = this.chooseExtraPadBlocks(this.crypto.getSecureRandom(), var12);
         var11 += var13 * var7;
      }

      var12 = var6 + var8 + var11 + 1;
      if (this.useExplicitIV) {
         var12 += var7;
      }

      byte[] var17 = new byte[var12];
      int var14 = 0;
      if (this.useExplicitIV) {
         byte[] var15 = this.crypto.createNonce(var7);
         this.encryptCipher.init(var15);
         System.arraycopy(var15, 0, var17, var14, var7);
         var14 += var7;
      }

      int var18 = var14;
      System.arraycopy(var4, var5, var17, var14, var6);
      var14 += var6;
      byte[] var16;
      if (!this.encryptThenMAC) {
         var16 = this.writeMac.calculateMac(var1, var3, var4, var5, var6);
         System.arraycopy(var16, 0, var17, var14, var16.length);
         var14 += var16.length;
      }

      for(int var19 = 0; var19 <= var11; ++var19) {
         var17[var14++] = (byte)var11;
      }

      this.encryptCipher.doFinal(var17, var18, var14 - var18, var17, var18);
      if (this.encryptThenMAC) {
         var16 = this.writeMac.calculateMac(var1, var3, var17, 0, var14);
         System.arraycopy(var16, 0, var17, var14, var16.length);
         int var10000 = var14 + var16.length;
      }

      return var17;
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      int var7 = this.decryptCipher.getBlockSize();
      int var8 = this.readMac.getSize();
      int var9;
      if (this.encryptThenMAC) {
         var9 = var7 + var8;
      } else {
         var9 = Math.max(var7, var8 + 1);
      }

      if (this.useExplicitIV) {
         var9 += var7;
      }

      if (var6 < var9) {
         throw new TlsFatalAlert((short)50);
      } else {
         int var10 = var6;
         if (this.encryptThenMAC) {
            var10 = var6 - var8;
         }

         if (var10 % var7 != 0) {
            throw new TlsFatalAlert((short)21);
         } else {
            int var11;
            if (this.encryptThenMAC) {
               var11 = var5 + var6;
               byte[] var12 = Arrays.copyOfRange(var4, var11 - var8, var11);
               byte[] var13 = this.readMac.calculateMac(var1, var3, var4, var5, var6 - var8);
               boolean var14 = !Arrays.constantTimeAreEqual(var13, var12);
               if (var14) {
                  throw new TlsFatalAlert((short)20);
               }
            }

            if (this.useExplicitIV) {
               this.decryptCipher.init(Arrays.copyOfRange(var4, var5, var5 + var7));
               var5 += var7;
               var10 -= var7;
            }

            this.decryptCipher.doFinal(var4, var5, var10, var4, var5);
            var11 = this.checkPaddingConstantTime(var4, var5, var10, var7, this.encryptThenMAC ? 0 : var8);
            boolean var18 = var11 == 0;
            int var19 = var10 - var11;
            if (!this.encryptThenMAC) {
               var19 -= var8;
               int var15 = var5 + var19;
               byte[] var16 = Arrays.copyOfRange(var4, var15, var15 + var8);
               byte[] var17 = this.readMac.calculateMacConstantTime(var1, var3, var4, var5, var19, var10 - var8, this.randomData);
               var18 |= !Arrays.constantTimeAreEqual(var17, var16);
            }

            if (var18) {
               throw new TlsFatalAlert((short)20);
            } else {
               return Arrays.copyOfRange(var4, var5, var5 + var19);
            }
         }
      }
   }

   protected int checkPaddingConstantTime(byte[] var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 + var3;
      byte var7 = var1[var6 - 1];
      int var8 = var7 & 255;
      int var9 = var8 + 1;
      int var10 = 0;
      byte var11 = 0;
      if ((!TlsImplUtils.isSSL(this.cryptoParams) || var9 <= var4) && var5 + var9 <= var3) {
         int var12 = var6 - var9;

         do {
            var11 = (byte)(var11 | var1[var12++] ^ var7);
         } while(var12 < var6);

         var10 = var9;
         if (var11 != 0) {
            var9 = 0;
         }
      } else {
         var9 = 0;
      }

      byte[] var13;
      for(var13 = this.randomData; var10 < 256; var11 = (byte)(var11 | var13[var10++] ^ var7)) {
      }

      var13[0] ^= var11;
      return var9;
   }

   protected int chooseExtraPadBlocks(SecureRandom var1, int var2) {
      int var3 = var1.nextInt();
      int var4 = this.lowestBitSet(var3);
      return Math.min(var4, var2);
   }

   protected int lowestBitSet(int var1) {
      if (var1 == 0) {
         return 32;
      } else {
         int var2;
         for(var2 = 0; (var1 & 1) == 0; var1 >>= 1) {
            ++var2;
         }

         return var2;
      }
   }
}
