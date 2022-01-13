package org.bouncycastle.tls.crypto.impl.bc;

import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.GenericSigner;
import org.bouncycastle.crypto.signers.RSADigestSigner;
import org.bouncycastle.tls.DigitallySigned;
import org.bouncycastle.tls.SignatureAndHashAlgorithm;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsStreamVerifier;
import org.bouncycastle.tls.crypto.TlsVerifier;

public class BcTlsRSAVerifier implements TlsVerifier {
   protected RSAKeyParameters pubKeyRSA;

   public BcTlsRSAVerifier(RSAKeyParameters var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("'pubKeyRSA' cannot be null");
      } else if (var1.isPrivate()) {
         throw new IllegalArgumentException("'pubKeyRSA' must be a public key");
      } else {
         this.pubKeyRSA = var1;
      }
   }

   public TlsStreamVerifier getStreamVerifier(DigitallySigned var1) {
      return null;
   }

   public boolean verifyRawSignature(DigitallySigned var1, byte[] var2) {
      SignatureAndHashAlgorithm var3 = var1.getAlgorithm();
      Object var4;
      if (var3 != null) {
         if (var3.getSignature() != 1) {
            throw new IllegalStateException();
         }

         var4 = new RSADigestSigner(new NullDigest(), TlsUtils.getOIDForHashAlgorithm(var3.getHash()));
      } else {
         var4 = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
      }

      ((Signer)var4).init(false, this.pubKeyRSA);
      ((Signer)var4).update(var2, 0, var2.length);
      return ((Signer)var4).verifySignature(var1.getSignature());
   }
}
