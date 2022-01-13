package org.bouncycastle.tls.crypto.impl;

import java.io.IOException;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsHMAC;
import org.bouncycastle.util.Arrays;

class TlsSuiteHMac implements TlsSuiteMac {
   protected TlsCryptoParameters cryptoParams;
   protected byte[] secret;
   protected TlsHMAC mac;
   protected int digestBlockSize;
   protected int digestOverhead;
   protected int macLength;

   public TlsSuiteHMac(TlsCryptoParameters var1, TlsHMAC var2) {
      this.cryptoParams = var1;
      this.digestBlockSize = var2.getInternalBlockSize();
      this.digestOverhead = this.digestBlockSize / 8;
      if (TlsImplUtils.isSSL(var1) && var2.getMacLength() == 20) {
         this.digestOverhead = 4;
      }

      this.mac = var2;
   }

   public void setKey(byte[] var1) throws IOException {
      this.secret = Arrays.clone(var1);
      this.mac.setKey(this.secret);
      this.macLength = this.mac.getMacLength();
      if (this.cryptoParams.getSecurityParameters().isTruncatedHMac()) {
         this.macLength = Math.min(this.macLength, 10);
      }

   }

   public byte[] getMACSecret() {
      return this.secret;
   }

   public int getSize() {
      return this.macLength;
   }

   public byte[] calculateMac(long var1, short var3, byte[] var4, int var5, int var6) {
      ProtocolVersion var7 = this.cryptoParams.getServerVersion();
      boolean var8 = var7.isSSL();
      byte[] var9 = new byte[var8 ? 11 : 13];
      TlsUtils.writeUint64(var1, var9, 0);
      TlsUtils.writeUint8((short)var3, var9, 8);
      if (!var8) {
         TlsUtils.writeVersion(var7, var9, 9);
      }

      TlsUtils.writeUint16(var6, var9, var9.length - 2);
      this.mac.update(var9, 0, var9.length);
      this.mac.update(var4, var5, var6);
      return this.truncate(this.mac.calculateMAC());
   }

   public byte[] calculateMacConstantTime(long var1, short var3, byte[] var4, int var5, int var6, int var7, byte[] var8) {
      byte[] var9 = this.calculateMac(var1, var3, var4, var5, var6);
      int var10 = TlsImplUtils.isSSL(this.cryptoParams) ? 11 : 13;
      int var11 = this.getDigestBlockCount(var10 + var7) - this.getDigestBlockCount(var10 + var6);

      while(true) {
         --var11;
         if (var11 < 0) {
            this.mac.update(var8, 0, 1);
            this.mac.reset();
            return var9;
         }

         this.mac.update(var8, 0, this.digestBlockSize);
      }
   }

   protected int getDigestBlockCount(int var1) {
      return (var1 + this.digestOverhead) / this.digestBlockSize;
   }

   protected byte[] truncate(byte[] var1) {
      return var1.length <= this.macLength ? var1 : Arrays.copyOf(var1, this.macLength);
   }
}
