package org.bouncycastle.tls;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.tls.crypto.TlsHash;

public interface TlsHandshakeHash extends TlsHash {
   void copyBufferTo(OutputStream var1) throws IOException;

   void forceBuffering();

   TlsHandshakeHash notifyPRFDetermined();

   void trackHashAlgorithm(short var1);

   void sealHashAlgorithms();

   TlsHandshakeHash stopTracking();

   TlsHash forkPRFHash();

   byte[] getFinalHash(short var1);
}
