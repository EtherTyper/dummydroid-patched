package org.bouncycastle.tls.crypto.impl.bc;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.signers.DSADigestSigner;
import org.bouncycastle.tls.DigitallySigned;
import org.bouncycastle.tls.SignatureAndHashAlgorithm;
import org.bouncycastle.tls.crypto.TlsStreamVerifier;
import org.bouncycastle.tls.crypto.TlsVerifier;

public abstract class BcTlsDSSVerifier implements TlsVerifier {
   protected final AsymmetricKeyParameter pubKey;
   protected final BcTlsCrypto crypto;

   protected BcTlsDSSVerifier(BcTlsCrypto var1, AsymmetricKeyParameter var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("'pubKey' cannot be null");
      } else if (var2.isPrivate()) {
         throw new IllegalArgumentException("'pubKey' must be a public key");
      } else {
         this.crypto = var1;
         this.pubKey = var2;
      }
   }

   protected abstract DSA createDSAImpl(short var1);

   protected abstract short getSignatureAlgorithm();

   public TlsStreamVerifier getStreamVerifier(DigitallySigned var1) {
      return null;
   }

   public boolean verifyRawSignature(DigitallySigned var1, byte[] var2) {
      SignatureAndHashAlgorithm var3 = var1.getAlgorithm();
      if (var3 != null && var3.getSignature() != this.getSignatureAlgorithm()) {
         throw new IllegalStateException();
      } else {
         short var4 = var3 == null ? 2 : var3.getHash();
         DSADigestSigner var5 = new DSADigestSigner(this.createDSAImpl(var4), new NullDigest());
         var5.init(false, this.pubKey);
         if (var3 == null) {
            var5.update(var2, 16, 20);
         } else {
            var5.update(var2, 0, var2.length);
         }

         return var5.verifySignature(var1.getSignature());
      }
   }
}
