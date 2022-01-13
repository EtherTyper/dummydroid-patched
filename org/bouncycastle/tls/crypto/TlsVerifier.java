package org.bouncycastle.tls.crypto;

import java.io.IOException;
import org.bouncycastle.tls.DigitallySigned;

public interface TlsVerifier {
   TlsStreamVerifier getStreamVerifier(DigitallySigned var1) throws IOException;

   boolean verifyRawSignature(DigitallySigned var1, byte[] var2) throws IOException;
}
