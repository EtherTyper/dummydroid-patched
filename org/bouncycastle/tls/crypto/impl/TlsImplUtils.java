package org.bouncycastle.tls.crypto.impl;

import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.SecurityParameters;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class TlsImplUtils {
   public static boolean isSSL(TlsCryptoParameters var0) {
      return var0.getServerVersion().isSSL();
   }

   public static boolean isTLSv11(ProtocolVersion var0) {
      return ProtocolVersion.TLSv11.isEqualOrEarlierVersionOf(var0.getEquivalentTLSVersion());
   }

   public static boolean isTLSv11(TlsCryptoParameters var0) {
      return isTLSv11(var0.getServerVersion());
   }

   public static boolean isTLSv12(ProtocolVersion var0) {
      return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(var0.getEquivalentTLSVersion());
   }

   public static boolean isTLSv12(TlsCryptoParameters var0) {
      return isTLSv12(var0.getServerVersion());
   }

   public static byte[] calculateKeyBlock(TlsCryptoParameters var0, int var1) {
      SecurityParameters var2 = var0.getSecurityParameters();
      TlsSecret var3 = var2.getMasterSecret();
      byte[] var4 = Arrays.concatenate(var2.getServerRandom(), var2.getClientRandom());
      return isSSL(var0) ? var3.deriveSSLKeyBlock(var4, var1).extract() : PRF(var0, var3, "key expansion", var4, var1).extract();
   }

   public static TlsSecret PRF(TlsCryptoParameters var0, TlsSecret var1, String var2, byte[] var3, int var4) {
      ProtocolVersion var5 = var0.getServerVersion();
      if (var5.isSSL()) {
         throw new IllegalStateException("No PRF available for SSLv3 session");
      } else {
         byte[] var6 = Strings.toByteArray(var2);
         byte[] var7 = Arrays.concatenate(var6, var3);
         int var8 = var0.getSecurityParameters().getPrfAlgorithm();
         return var1.deriveUsingPRF(var8, var7, var4);
      }
   }
}
