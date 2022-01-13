package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.util.Arrays;

public abstract class AbstractTlsSecret implements TlsSecret {
   protected static final int MD5_SIZE = 16;
   protected static final byte[][] SSL3_CONST = generateSSL3Constants();
   protected byte[] data;

   private static byte[][] generateSSL3Constants() {
      byte var0 = 10;
      byte[][] var1 = new byte[var0][];

      for(int var2 = 0; var2 < var0; ++var2) {
         byte[] var3 = new byte[var2 + 1];
         Arrays.fill(var3, (byte)(65 + var2));
         var1[var2] = var3;
      }

      return var1;
   }

   protected AbstractTlsSecret(byte[] var1) {
      this.data = var1;
   }

   public synchronized byte[] encrypt(TlsCertificate var1) throws IOException {
      this.checkAlive();
      return this.getCrypto().createEncryptor(var1).encrypt(this.data, 0, this.data.length);
   }

   public synchronized void destroy() {
      if (this.data != null) {
         Arrays.fill((byte[])this.data, (byte)0);
         this.data = null;
      }

   }

   public synchronized byte[] extract() {
      this.checkAlive();
      byte[] var1 = this.data;
      this.data = null;
      return var1;
   }

   public TlsCipher createCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return this.getCrypto().createCipher(var1, var2, var3);
   }

   byte[] copyData() {
      return Arrays.clone(this.data);
   }

   protected void checkAlive() {
      if (this.data == null) {
         throw new IllegalStateException("Secret has already been extracted or destroyed");
      }
   }

   protected abstract AbstractTlsCrypto getCrypto();
}
