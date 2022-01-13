package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsMAC;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class ChaCha20Poly1305Cipher implements TlsCipher {
   private static final byte[] ZEROES = new byte[15];
   protected TlsCryptoParameters context;
   protected TlsMAC writeMac;
   protected TlsMAC readMac;
   protected TlsStreamCipherImpl encryptCipher;
   protected TlsStreamCipherImpl decryptCipher;
   protected byte[] encryptIV;
   protected byte[] decryptIV;

   public ChaCha20Poly1305Cipher(TlsCryptoParameters var1, TlsStreamCipherImpl var2, TlsStreamCipherImpl var3, TlsMAC var4, TlsMAC var5) throws IOException {
      if (!TlsImplUtils.isTLSv12(var1)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.context = var1;
         byte var6 = 32;
         byte var7 = 12;
         int var8 = 2 * var6 + 2 * var7;
         byte[] var9 = TlsImplUtils.calculateKeyBlock(var1, var8);
         byte var10 = 0;
         byte[] var11 = Arrays.copyOfRange((byte[])var9, var10, var10 + var6);
         int var17 = var10 + var6;
         byte[] var12 = Arrays.copyOfRange(var9, var17, var17 + var6);
         var17 += var6;
         byte[] var13 = Arrays.copyOfRange(var9, var17, var17 + var7);
         var17 += var7;
         byte[] var14 = Arrays.copyOfRange(var9, var17, var17 + var7);
         var17 += var7;
         if (var17 != var8) {
            throw new TlsFatalAlert((short)80);
         } else {
            this.writeMac = var4;
            this.readMac = var5;
            this.encryptCipher = var2;
            this.decryptCipher = var3;
            byte[] var15;
            byte[] var16;
            if (var1.isServer()) {
               var15 = var12;
               var16 = var11;
               this.encryptIV = var14;
               this.decryptIV = var13;
            } else {
               var15 = var11;
               var16 = var12;
               this.encryptIV = var13;
               this.decryptIV = var14;
            }

            this.encryptCipher.setKey(var15);
            this.encryptCipher.init(this.encryptIV);
            this.decryptCipher.setKey(var16);
            this.decryptCipher.init(this.decryptIV);
         }
      }
   }

   public int getPlaintextLimit(int var1) {
      return var1 - 16;
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      this.initRecord(this.encryptCipher, var1, this.encryptIV);
      byte[] var7 = new byte[64 + var6];
      System.arraycopy(var4, var5, var7, 64, var6);
      this.encryptCipher.doFinal(var7, 0, var7.length, var7, 0);
      byte[] var8 = new byte[var6 + 16];
      byte[] var9 = Arrays.copyOfRange((byte[])var7, 0, 32);
      System.arraycopy(var7, 64, var8, 0, var6);
      Arrays.fill((byte[])var7, (byte)0);
      this.writeMac.setKey(var9);
      byte[] var10 = this.getAdditionalData(var1, var3, var6);
      byte[] var11 = this.calculateRecordMAC(this.writeMac, var10, var8, 0, var6);
      System.arraycopy(var11, 0, var8, var6, var11.length);
      return var8;
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      if (this.getPlaintextLimit(var6) < 0) {
         throw new TlsFatalAlert((short)50);
      } else {
         this.initRecord(this.decryptCipher, var1, this.decryptIV);
         int var7 = var6 - 16;
         byte[] var8 = new byte[64 + var7];
         System.arraycopy(var4, var5, var8, 64, var7);
         this.decryptCipher.doFinal(var8, 0, var8.length, var8, 0);
         byte[] var9 = Arrays.copyOfRange((byte[])var8, 0, 32);
         this.readMac.setKey(var9);
         byte[] var10 = this.getAdditionalData(var1, var3, var7);
         byte[] var11 = this.calculateRecordMAC(this.readMac, var10, var4, var5, var7);
         byte[] var12 = Arrays.copyOfRange(var4, var5 + var7, var5 + var6);
         byte[] var13 = new byte[var7];
         System.arraycopy(var8, 64, var13, 0, var7);
         Arrays.fill((byte[])var8, (byte)0);
         if (!Arrays.constantTimeAreEqual(var11, var12)) {
            throw new TlsFatalAlert((short)20);
         } else {
            return var13;
         }
      }
   }

   protected void initRecord(TlsStreamCipherImpl var1, long var2, byte[] var4) throws IOException {
      byte[] var5 = this.calculateNonce(var2, var4);
      var1.init(var5);
   }

   protected byte[] calculateNonce(long var1, byte[] var3) {
      byte[] var4 = new byte[12];
      TlsUtils.writeUint64(var1, var4, 4);

      for(int var5 = 0; var5 < 12; ++var5) {
         var4[var5] ^= var3[var5];
      }

      return var4;
   }

   protected byte[] calculateRecordMAC(TlsMAC var1, byte[] var2, byte[] var3, int var4, int var5) {
      this.updateRecordMACText(var1, var2, 0, var2.length);
      this.updateRecordMACText(var1, var3, var4, var5);
      this.updateRecordMACLength(var1, var2.length);
      this.updateRecordMACLength(var1, var5);
      return var1.calculateMAC();
   }

   protected void updateRecordMACLength(TlsMAC var1, int var2) {
      byte[] var3 = Pack.longToLittleEndian((long)var2 & 4294967295L);
      var1.update(var3, 0, var3.length);
   }

   protected void updateRecordMACText(TlsMAC var1, byte[] var2, int var3, int var4) {
      var1.update(var2, var3, var4);
      int var5 = var4 % 16;
      if (var5 != 0) {
         var1.update(ZEROES, 0, 16 - var5);
      }

   }

   protected byte[] getAdditionalData(long var1, short var3, int var4) throws IOException {
      byte[] var5 = new byte[13];
      TlsUtils.writeUint64(var1, var5, 0);
      TlsUtils.writeUint8((short)var3, var5, 8);
      TlsUtils.writeVersion(this.context.getServerVersion(), var5, 9);
      TlsUtils.writeUint16(var4, var5, 11);
      return var5;
   }
}
