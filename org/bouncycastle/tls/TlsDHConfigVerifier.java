package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsDHConfig;

public interface TlsDHConfigVerifier {
   boolean accept(TlsDHConfig var1);
}
