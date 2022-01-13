package org.bouncycastle.tls.crypto;

import java.io.IOException;

public interface TlsCertificate {
   TlsVerifier createVerifier(short var1) throws IOException;

   short getClientCertificateType() throws IOException;

   byte[] getEncoded() throws IOException;

   TlsCertificate useInRole(int var1, int var2) throws IOException;
}
