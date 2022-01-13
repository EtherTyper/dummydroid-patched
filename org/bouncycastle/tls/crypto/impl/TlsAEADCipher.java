package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.util.Arrays;

public class TlsAEADCipher implements TlsCipher {
   public static final int NONCE_RFC5288 = 1;
   public static final int NONCE_RFC7905 = 2;
   protected TlsCryptoParameters context;
   protected int macSize;
   protected int record_iv_length;
   protected TlsAEADCipherImpl encryptor;
   protected TlsAEADCipherImpl decryptor;
   protected byte[] encryptImplicitNonce;
   protected byte[] decryptImplicitNonce;
   protected int nonceMode;

   public TlsAEADCipher(TlsCryptoParameters var1, TlsAEADCipherImpl var2, TlsAEADCipherImpl var3, int var4, int var5) throws IOException {
      this(var1, var2, var3, var4, var5, 1);
   }

   public TlsAEADCipher(TlsCryptoParameters var1, TlsAEADCipherImpl var2, TlsAEADCipherImpl var3, int var4, int var5, int var6) throws IOException {
      if (!TlsImplUtils.isTLSv12(var1)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.nonceMode = var6;
         byte var7;
         switch(var6) {
         case 1:
            var7 = 4;
            this.record_iv_length = 8;
            break;
         case 2:
            var7 = 12;
            this.record_iv_length = 0;
            break;
         default:
            throw new TlsFatalAlert((short)80);
         }

         this.context = var1;
         this.macSize = var5;
         int var8 = 2 * var4 + 2 * var7;
         byte[] var9 = TlsImplUtils.calculateKeyBlock(var1, var8);
         byte var10 = 0;
         byte[] var11 = Arrays.copyOfRange((byte[])var9, var10, var10 + var4);
         int var16 = var10 + var4;
         byte[] var12 = Arrays.copyOfRange(var9, var16, var16 + var4);
         var16 += var4;
         byte[] var13 = Arrays.copyOfRange(var9, var16, var16 + var7);
         var16 += var7;
         byte[] var14 = Arrays.copyOfRange(var9, var16, var16 + var7);
         var16 += var7;
         if (var16 != var8) {
            throw new TlsFatalAlert((short)80);
         } else {
            this.encryptor = var2;
            this.decryptor = var3;
            if (var1.isServer()) {
               this.encryptImplicitNonce = var14;
               this.decryptImplicitNonce = var13;
               var2.setKey(var12);
               var3.setKey(var11);
            } else {
               this.encryptImplicitNonce = var13;
               this.decryptImplicitNonce = var14;
               var2.setKey(var11);
               var3.setKey(var12);
            }

            byte[] var15 = new byte[var7 + this.record_iv_length];
            this.encryptor.init(var15, var5, (byte[])null);
            this.decryptor.init(var15, var5, (byte[])null);
         }
      }
   }

   public int getPlaintextLimit(int var1) {
      return var1 - this.macSize - this.record_iv_length;
   }

   public byte[] encodePlaintext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      byte[] var7;
      int var8;
      var7 = new byte[this.encryptImplicitNonce.length + this.record_iv_length];
      label34:
      switch(this.nonceMode) {
      case 1:
         System.arraycopy(this.encryptImplicitNonce, 0, var7, 0, this.encryptImplicitNonce.length);
         TlsUtils.writeUint64(var1, var7, this.encryptImplicitNonce.length);
         break;
      case 2:
         TlsUtils.writeUint64(var1, var7, var7.length - 8);
         var8 = 0;

         while(true) {
            if (var8 >= this.encryptImplicitNonce.length) {
               break label34;
            }

            var7[var8] ^= this.encryptImplicitNonce[var8];
            ++var8;
         }
      default:
         throw new TlsFatalAlert((short)80);
      }

      var8 = var5;
      int var9 = var6;
      int var10 = this.encryptor.getOutputSize(var6);
      byte[] var11 = new byte[this.record_iv_length + var10];
      if (this.record_iv_length != 0) {
         System.arraycopy(var7, var7.length - this.record_iv_length, var11, 0, this.record_iv_length);
      }

      int var12 = this.record_iv_length;
      byte[] var13 = this.getAdditionalData(var1, var3, var6);

      try {
         this.encryptor.init(var7, this.macSize, var13);
         var12 += this.encryptor.doFinal(var4, var8, var9, var11, var12);
      } catch (Exception var15) {
         throw new TlsFatalAlert((short)80, var15);
      }

      if (var12 != var11.length) {
         throw new TlsFatalAlert((short)80);
      } else {
         return var11;
      }
   }

   public byte[] decodeCiphertext(long var1, short var3, byte[] var4, int var5, int var6) throws IOException {
      if (this.getPlaintextLimit(var6) < 0) {
         throw new TlsFatalAlert((short)50);
      } else {
         byte[] var7;
         int var8;
         var7 = new byte[this.decryptImplicitNonce.length + this.record_iv_length];
         label33:
         switch(this.nonceMode) {
         case 1:
            System.arraycopy(this.decryptImplicitNonce, 0, var7, 0, this.decryptImplicitNonce.length);
            System.arraycopy(var4, var5, var7, var7.length - this.record_iv_length, this.record_iv_length);
            break;
         case 2:
            TlsUtils.writeUint64(var1, var7, var7.length - 8);
            var8 = 0;

            while(true) {
               if (var8 >= this.decryptImplicitNonce.length) {
                  break label33;
               }

               var7[var8] ^= this.decryptImplicitNonce[var8];
               ++var8;
            }
         default:
            throw new TlsFatalAlert((short)80);
         }

         var8 = var5 + this.record_iv_length;
         int var9 = var6 - this.record_iv_length;
         int var10 = this.decryptor.getOutputSize(var9);
         byte[] var11 = new byte[var10];
         byte var12 = 0;
         byte[] var13 = this.getAdditionalData(var1, var3, var10);

         int var16;
         try {
            this.decryptor.init(var7, this.macSize, var13);
            var16 = var12 + this.decryptor.doFinal(var4, var8, var9, var11, var12);
         } catch (Exception var15) {
            throw new TlsFatalAlert((short)20, var15);
         }

         if (var16 != var11.length) {
            throw new TlsFatalAlert((short)80);
         } else {
            return var11;
         }
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
