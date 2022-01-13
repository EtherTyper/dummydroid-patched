package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsDHDomain;
import org.bouncycastle.util.BigIntegers;

public class BcTlsDHDomain implements TlsDHDomain {
   protected BcTlsCrypto crypto;
   protected TlsDHConfig dhConfig;
   protected DHParameters dhDomain;

   public BcTlsDHDomain(BcTlsCrypto var1, TlsDHConfig var2) {
      this.crypto = var1;
      this.dhConfig = var2;
      this.dhDomain = this.getParameters(var2);
   }

   public byte[] calculateDHAgreement(DHPublicKeyParameters var1, DHPrivateKeyParameters var2) {
      DHBasicAgreement var3 = new DHBasicAgreement();
      var3.init(var2);
      BigInteger var4 = var3.calculateAgreement(var1);
      return BigIntegers.asUnsignedByteArray(var4);
   }

   public TlsAgreement createDH() {
      return new BcTlsDH(this);
   }

   public static BigInteger decodeParameter(byte[] var0) throws IOException {
      return new BigInteger(1, var0);
   }

   public DHPublicKeyParameters decodePublicKey(byte[] var1) throws IOException {
      try {
         BigInteger var2 = decodeParameter(var1);
         return new DHPublicKeyParameters(var2, this.dhDomain);
      } catch (RuntimeException var3) {
         throw new TlsFatalAlert((short)47, var3);
      }
   }

   public byte[] encodeParameter(BigInteger var1) throws IOException {
      return BigIntegers.asUnsignedByteArray(var1);
   }

   public byte[] encodePublicKey(DHPublicKeyParameters var1) throws IOException {
      return this.encodeParameter(var1.getY());
   }

   public AsymmetricCipherKeyPair generateKeyPair() {
      DHBasicKeyPairGenerator var1 = new DHBasicKeyPairGenerator();
      var1.init(new DHKeyGenerationParameters(this.crypto.getSecureRandom(), this.dhDomain));
      return var1.generateKeyPair();
   }

   public BcTlsCrypto getCrypto() {
      return this.crypto;
   }

   public DHParameters getParameters(TlsDHConfig var1) {
      BigInteger[] var2 = var1.getExplicitPG();
      if (var2 != null) {
         return new DHParameters(var2[0], var2[1]);
      } else {
         throw new IllegalStateException("No DH configuration provided");
      }
   }
}
