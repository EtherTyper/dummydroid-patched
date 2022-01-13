package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.TlsHash;
import org.bouncycastle.util.Arrays;

public class CombinedHash implements TlsHash {
   protected TlsContext context;
   protected TlsCrypto crypto;
   protected TlsHash md5;
   protected TlsHash sha1;

   CombinedHash(TlsContext var1, TlsHash var2, TlsHash var3) {
      this.context = var1;
      this.crypto = var1.getCrypto();
      this.md5 = var2;
      this.sha1 = var3;
   }

   public CombinedHash(TlsCrypto var1) {
      this.crypto = var1;
      this.md5 = var1.createHash((short)1);
      this.sha1 = var1.createHash((short)2);
   }

   public CombinedHash(CombinedHash var1) {
      this.context = var1.context;
      this.crypto = var1.crypto;
      this.md5 = (TlsHash)var1.md5.clone();
      this.sha1 = (TlsHash)var1.sha1.clone();
   }

   public void update(byte[] var1, int var2, int var3) {
      this.md5.update(var1, var2, var3);
      this.sha1.update(var1, var2, var3);
   }

   public byte[] calculateHash() {
      if (this.context != null && TlsUtils.isSSL(this.context)) {
         byte[] var1 = SSL3Constants.getInputPad();
         byte[] var2 = SSL3Constants.getOutputPad();
         this.ssl3Complete(this.md5, var1, var2, 48);
         this.ssl3Complete(this.sha1, var1, var2, 40);
      }

      return Arrays.concatenate(this.md5.calculateHash(), this.sha1.calculateHash());
   }

   public Object clone() {
      return new CombinedHash(this);
   }

   public void reset() {
      this.md5.reset();
      this.sha1.reset();
   }

   protected void ssl3Complete(TlsHash var1, byte[] var2, byte[] var3, int var4) {
      byte[] var5 = this.crypto.adoptSecret(this.context.getSecurityParameters().getMasterSecret()).extract();
      var1.update(var5, 0, var5.length);
      var1.update(var2, 0, var4);
      byte[] var6 = var1.calculateHash();
      var1.update(var5, 0, var5.length);
      var1.update(var3, 0, var4);
      var1.update(var6, 0, var6.length);
   }
}
