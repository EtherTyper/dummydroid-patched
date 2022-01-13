package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.tls.TlsDHUtils;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsSecret;

public class BcTlsDH implements TlsAgreement {
   protected BcTlsDHDomain domain;
   protected AsymmetricCipherKeyPair localKeyPair;
   protected DHPublicKeyParameters peerPublicKey;

   public BcTlsDH(BcTlsDHDomain var1) {
      this.domain = var1;
   }

   public byte[] generateEphemeral() throws IOException {
      this.localKeyPair = this.domain.generateKeyPair();
      return this.domain.encodePublicKey((DHPublicKeyParameters)this.localKeyPair.getPublic());
   }

   public void receivePeerValue(byte[] var1) throws IOException {
      DHPublicKeyParameters var2 = this.domain.decodePublicKey(var1);
      TlsDHUtils.validateDHPublicValues(var2.getY(), var2.getParameters().getP());
      this.peerPublicKey = var2;
   }

   public TlsSecret calculateSecret() throws IOException {
      byte[] var1 = this.domain.calculateDHAgreement(this.peerPublicKey, (DHPrivateKeyParameters)this.localKeyPair.getPrivate());
      return this.domain.getCrypto().adoptLocalSecret(var1);
   }
}
