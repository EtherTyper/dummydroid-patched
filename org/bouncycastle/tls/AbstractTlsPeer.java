package org.bouncycastle.tls;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsCrypto;

public abstract class AbstractTlsPeer implements TlsPeer {
   private final TlsCrypto crypto;

   protected AbstractTlsPeer(TlsCrypto var1) {
      this.crypto = var1;
   }

   public TlsCrypto getCrypto() {
      return this.crypto;
   }

   public boolean shouldUseGMTUnixTime() {
      return false;
   }

   public void notifySecureRenegotiation(boolean var1) throws IOException {
      if (!var1) {
         throw new TlsFatalAlert((short)40);
      }
   }

   public void notifyAlertRaised(short var1, short var2, String var3, Throwable var4) {
   }

   public void notifyAlertReceived(short var1, short var2) {
   }

   public void notifyHandshakeComplete() throws IOException {
   }
}
