package org.bouncycastle.tls.crypto;

import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.SecurityParameters;
import org.bouncycastle.tls.TlsContext;

public class TlsCryptoParameters {
   private final TlsContext context;

   public TlsCryptoParameters(TlsContext var1) {
      this.context = var1;
   }

   public SecurityParameters getSecurityParameters() {
      return this.context.getSecurityParameters();
   }

   public ProtocolVersion getClientVersion() {
      return this.context.getClientVersion();
   }

   public ProtocolVersion getServerVersion() {
      return this.context.getServerVersion();
   }

   public boolean isServer() {
      return this.context.isServer();
   }
}
