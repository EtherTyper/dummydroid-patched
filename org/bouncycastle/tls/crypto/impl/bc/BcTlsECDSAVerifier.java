package org.bouncycastle.tls.crypto.impl.bc;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;

public class BcTlsECDSAVerifier extends BcTlsDSSVerifier {
   public BcTlsECDSAVerifier(BcTlsCrypto var1, ECPublicKeyParameters var2) {
      super(var1, var2);
   }

   protected DSA createDSAImpl(short var1) {
      BcTlsCrypto var10004 = this.crypto;
      return new ECDSASigner(new HMacDSAKCalculator(BcTlsCrypto.createDigest(var1)));
   }

   protected short getSignatureAlgorithm() {
      return 3;
   }
}
