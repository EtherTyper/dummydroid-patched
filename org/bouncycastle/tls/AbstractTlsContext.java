package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.util.Arrays;

abstract class AbstractTlsContext implements TlsContext {
   private TlsCrypto crypto;
   private SecurityParameters securityParameters;
   private ProtocolVersion clientVersion = null;
   private ProtocolVersion serverVersion = null;
   private TlsSession session = null;
   private Object userObject = null;

   AbstractTlsContext(TlsCrypto var1, SecurityParameters var2) {
      this.crypto = var1;
      this.securityParameters = var2;
   }

   public TlsCrypto getCrypto() {
      return this.crypto;
   }

   public SecurityParameters getSecurityParameters() {
      return this.securityParameters;
   }

   public ProtocolVersion getClientVersion() {
      return this.clientVersion;
   }

   void setClientVersion(ProtocolVersion var1) {
      this.clientVersion = var1;
   }

   public ProtocolVersion getServerVersion() {
      return this.serverVersion;
   }

   void setServerVersion(ProtocolVersion var1) {
      this.serverVersion = var1;
   }

   public TlsSession getResumableSession() {
      TlsSession var1 = this.getSession();
      return var1 != null && var1.isResumable() ? var1 : null;
   }

   public TlsSession getSession() {
      return this.session;
   }

   void setSession(TlsSession var1) {
      this.session = var1;
   }

   public Object getUserObject() {
      return this.userObject;
   }

   public void setUserObject(Object var1) {
      this.userObject = var1;
   }

   public byte[] exportChannelBinding(int var1) {
      switch(var1) {
      case 0:
      case 2:
      default:
         throw new UnsupportedOperationException();
      case 1:
         byte[] var2 = this.getSecurityParameters().getTLSUnique();
         if (var2 == null) {
            throw new IllegalStateException("'tls-unique' channel binding unavailable before handshake completion");
         } else {
            return Arrays.clone(var2);
         }
      }
   }

   public byte[] exportKeyingMaterial(String var1, byte[] var2, int var3) {
      if (var2 != null && !TlsUtils.isValidUint16(var2.length)) {
         throw new IllegalArgumentException("'context_value' must have length less than 2^16 (or be null)");
      } else {
         SecurityParameters var4 = this.getSecurityParameters();
         byte[] var5 = var4.getClientRandom();
         byte[] var6 = var4.getServerRandom();
         int var7 = var5.length + var6.length;
         if (var2 != null) {
            var7 += 2 + var2.length;
         }

         byte[] var8 = new byte[var7];
         byte var9 = 0;
         System.arraycopy(var5, 0, var8, var9, var5.length);
         int var10 = var9 + var5.length;
         System.arraycopy(var6, 0, var8, var10, var6.length);
         var10 += var6.length;
         if (var2 != null) {
            TlsUtils.writeUint16(var2.length, var8, var10);
            var10 += 2;
            System.arraycopy(var2, 0, var8, var10, var2.length);
            var10 += var2.length;
         }

         if (var10 != var7) {
            throw new IllegalStateException("error in calculation of seed for export");
         } else {
            return TlsUtils.PRF(this, var4.getMasterSecret(), var1, var8, var3).extract();
         }
      }
   }
}
