package org.bouncycastle.tls.crypto.impl.bc;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;

public class BcTlsDSAVerifier extends BcTlsDSSVerifier {
   public BcTlsDSAVerifier(BcTlsCrypto var1, DSAPublicKeyParameters var2) {
      super(var1, var2);
   }

   protected DSA createDSAImpl(short var1) {
      BcTlsCrypto var10004 = this.crypto;
      return new DSASigner(new HMacDSAKCalculator(BcTlsCrypto.createDigest(var1)));
   }

   protected short getSignatureAlgorithm() {
      return 2;
   }
}
