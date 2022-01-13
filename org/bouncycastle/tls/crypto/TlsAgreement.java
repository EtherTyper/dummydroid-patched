package org.bouncycastle.tls.crypto;

import java.io.IOException;

public interface TlsAgreement {
   byte[] generateEphemeral() throws IOException;

   void receivePeerValue(byte[] var1) throws IOException;

   TlsSecret calculateSecret() throws IOException;
}
