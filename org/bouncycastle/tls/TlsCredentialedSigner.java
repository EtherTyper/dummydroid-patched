package org.bouncycastle.tls;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsStreamSigner;

public interface TlsCredentialedSigner extends TlsCredentials {
   byte[] generateRawSignature(byte[] var1) throws IOException;

   SignatureAndHashAlgorithm getSignatureAndHashAlgorithm();

   TlsStreamSigner getStreamSigner() throws IOException;
}
