package org.bouncycastle.tls.crypto.impl.bc;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.tls.crypto.impl.AbstractTlsCrypto;
import org.bouncycastle.tls.crypto.impl.AbstractTlsSecret;
import org.bouncycastle.util.Arrays;

public class BcTlsSecret extends AbstractTlsSecret {
   protected final BcTlsCrypto crypto;

   public BcTlsSecret(BcTlsCrypto var1, byte[] var2) {
      super(var2);
      this.crypto = var1;
   }

   protected AbstractTlsCrypto getCrypto() {
      return this.crypto;
   }

   public synchronized TlsSecret deriveSSLKeyBlock(byte[] var1, int var2) {
      this.checkAlive();
      int var3 = (var2 + 16 - 1) / 16;
      byte[] var4 = this.prf_SSL(var1, var3);
      BcTlsSecret var5 = this.crypto.adoptLocalSecret(Arrays.copyOfRange((byte[])var4, 0, var2));
      Arrays.fill((byte[])var4, (byte)0);
      return var5;
   }

   public synchronized TlsSecret deriveSSLMasterSecret(byte[] var1) {
      this.checkAlive();
      return this.crypto.adoptLocalSecret(this.prf_SSL(var1, 3));
   }

   public synchronized TlsSecret deriveUsingPRF(int var1, byte[] var2, int var3) {
      this.checkAlive();
      byte[] var4 = var1 == 0 ? this.prf_1_0(this.data, var2, var3) : this.prf_1_2(this.crypto.createPRFHash(var1), this.data, var2, var3);
      return this.crypto.adoptLocalSecret(var4);
   }

   protected void hmacHash(Digest var1, byte[] var2, byte[] var3, byte[] var4) {
      HMac var5 = new HMac(var1);
      var5.init(new KeyParameter(var2));
      byte[] var6 = var3;
      int var7 = var1.getDigestSize();
      int var8 = (var4.length + var7 - 1) / var7;
      byte[] var9 = new byte[var5.getMacSize()];
      byte[] var10 = new byte[var5.getMacSize()];

      for(int var11 = 0; var11 < var8; ++var11) {
         var5.update(var6, 0, var6.length);
         var5.doFinal(var9, 0);
         var6 = var9;
         var5.update(var9, 0, var9.length);
         var5.update(var3, 0, var3.length);
         var5.doFinal(var10, 0);
         System.arraycopy(var10, 0, var4, var7 * var11, Math.min(var7, var4.length - var7 * var11));
      }

   }

   protected byte[] prf_SSL(byte[] var1, int var2) {
      BcTlsCrypto var10000 = this.crypto;
      Digest var3 = BcTlsCrypto.createDigest((short)1);
      var10000 = this.crypto;
      Digest var4 = BcTlsCrypto.createDigest((short)2);
      int var5 = var3.getDigestSize();
      byte[] var6 = new byte[var5 * var2];
      int var7 = 0;
      byte[] var8 = new byte[var4.getDigestSize()];

      for(int var9 = 0; var9 < var2; ++var9) {
         byte[] var10 = SSL3_CONST[var9];
         var4.update(var10, 0, var10.length);
         var4.update(this.data, 0, this.data.length);
         var4.update(var1, 0, var1.length);
         var4.doFinal(var8, 0);
         var3.update(this.data, 0, this.data.length);
         var3.update(var8, 0, var8.length);
         var3.doFinal(var6, var7);
         var7 += var5;
      }

      return var6;
   }

   protected byte[] prf_1_0(byte[] var1, byte[] var2, int var3) {
      int var4 = (var1.length + 1) / 2;
      byte[] var5 = new byte[var4];
      byte[] var6 = new byte[var4];
      System.arraycopy(var1, 0, var5, 0, var4);
      System.arraycopy(var1, var1.length - var4, var6, 0, var4);
      byte[] var7 = new byte[var3];
      byte[] var8 = new byte[var3];
      BcTlsCrypto var10001 = this.crypto;
      this.hmacHash(BcTlsCrypto.createDigest((short)1), var5, var2, var7);
      var10001 = this.crypto;
      this.hmacHash(BcTlsCrypto.createDigest((short)2), var6, var2, var8);

      for(int var9 = 0; var9 < var3; ++var9) {
         var7[var9] ^= var8[var9];
      }

      return var7;
   }

   protected byte[] prf_1_2(Digest var1, byte[] var2, byte[] var3, int var4) {
      byte[] var5 = new byte[var4];
      this.hmacHash(var1, var2, var3, var5);
      return var5;
   }
}
