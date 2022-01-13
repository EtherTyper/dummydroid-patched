package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsSecret;

public class BcTlsECDH implements TlsAgreement {
   protected BcTlsECDomain domain;
   protected AsymmetricCipherKeyPair localKeyPair;
   protected ECPublicKeyParameters peerPublicKey;

   public BcTlsECDH(BcTlsECDomain var1) {
      this.domain = var1;
   }

   public byte[] generateEphemeral() throws IOException {
      this.localKeyPair = this.domain.generateKeyPair();
      return this.domain.encodePublicKey((ECPublicKeyParameters)this.localKeyPair.getPublic());
   }

   public void receivePeerValue(byte[] var1) throws IOException {
      this.peerPublicKey = this.domain.decodePublicKey(var1);
   }

   public TlsSecret calculateSecret() throws IOException {
      byte[] var1 = this.domain.calculateECDHAgreement(this.peerPublicKey, (ECPrivateKeyParameters)this.localKeyPair.getPrivate());
      return this.domain.getCrypto().adoptLocalSecret(var1);
   }
}
