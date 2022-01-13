package org.bouncycastle.tls;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCrypto;

public interface TlsPeer {
   TlsCrypto getCrypto();

   boolean shouldUseGMTUnixTime();

   void notifySecureRenegotiation(boolean var1) throws IOException;

   TlsCompression getCompression() throws IOException;

   TlsCipher getCipher() throws IOException;

   void notifyAlertRaised(short var1, short var2, String var3, Throwable var4);

   void notifyAlertReceived(short var1, short var2);

   void notifyHandshakeComplete() throws IOException;
}
