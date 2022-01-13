package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsCrypto;

class TlsClientContextImpl extends AbstractTlsContext implements TlsClientContext {
   TlsClientContextImpl(TlsCrypto var1, SecurityParameters var2) {
      super(var1, var2);
   }

   public boolean isServer() {
      return false;
   }
}
