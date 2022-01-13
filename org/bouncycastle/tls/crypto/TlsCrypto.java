package org.bouncycastle.tls.crypto;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.SignatureAndHashAlgorithm;

public interface TlsCrypto {
   boolean hasAllRawSignatureAlgorithms();

   boolean hasDHAgreement();

   boolean hasECDHAgreement();

   boolean hasEncryptionAlgorithm(int var1);

   boolean hasHashAlgorithm(short var1);

   boolean hasMacAlgorithm(int var1);

   boolean hasNamedCurve(int var1);

   boolean hasRSAEncryption();

   boolean hasSignatureAlgorithm(int var1);

   boolean hasSignatureAndHashAlgorithm(SignatureAndHashAlgorithm var1);

   boolean hasSRPAuthentication();

   TlsSecret createSecret(byte[] var1);

   TlsSecret generateRSAPreMasterSecret(ProtocolVersion var1);

   SecureRandom getSecureRandom();

   TlsCertificate createCertificate(byte[] var1) throws IOException;

   TlsDHDomain createDHDomain(TlsDHConfig var1);

   TlsECDomain createECDomain(TlsECConfig var1);

   TlsSecret adoptSecret(TlsSecret var1);

   TlsHash createHash(SignatureAndHashAlgorithm var1);

   TlsHash createHash(short var1);

   TlsHMAC createHMAC(int var1) throws IOException;

   byte[] createNonce(int var1);

   TlsSRP6Client createSRP6Client(TlsSRPConfig var1);

   TlsSRP6Server createSRP6Server(TlsSRPConfig var1, BigInteger var2);

   TlsSRP6VerifierGenerator createSRP6VerifierGenerator(TlsSRPConfig var1);
}
