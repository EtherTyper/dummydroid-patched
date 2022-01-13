package org.bouncycastle.tls;

import org.bouncycastle.tls.crypto.TlsSRPConfig;

public interface TlsSRPConfigVerifier {
   boolean accept(TlsSRPConfig var1);
}
