package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsCrypto;

public interface TlsContext {
   TlsCrypto getCrypto();

   SecurityParameters getSecurityParameters();

   boolean isServer();

   ProtocolVersion getClientVersion();

   ProtocolVersion getServerVersion();

   TlsSession getResumableSession();

   TlsSession getSession();

   Object getUserObject();

   void setUserObject(Object var1);

   byte[] exportChannelBinding(int var1);

   byte[] exportKeyingMaterial(String var1, byte[] var2, int var3);
}
