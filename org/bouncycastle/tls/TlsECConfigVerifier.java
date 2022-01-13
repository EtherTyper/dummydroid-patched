package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsECConfig;

public interface TlsECConfigVerifier {
   boolean accept(TlsECConfig var1);
}
