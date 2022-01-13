package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.tls.NamedCurve;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.crypto.TlsAgreement;
import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.tls.crypto.TlsECDomain;
import org.bouncycastle.util.BigIntegers;

public class BcTlsECDomain implements TlsECDomain {
   protected BcTlsCrypto crypto;
   protected TlsECConfig ecConfig;
   protected ECDomainParameters ecDomain;

   public BcTlsECDomain(BcTlsCrypto var1, TlsECConfig var2) {
      this.crypto = var1;
      this.ecConfig = var2;
      this.ecDomain = this.getParameters(var2);
   }

   public byte[] calculateECDHAgreement(ECPublicKeyParameters var1, ECPrivateKeyParameters var2) {
      ECDHBasicAgreement var3 = new ECDHBasicAgreement();
      var3.init(var2);
      BigInteger var4 = var3.calculateAgreement(var1);
      return BigIntegers.asUnsignedByteArray(var3.getFieldSize(), var4);
   }

   public TlsAgreement createECDH() {
      return new BcTlsECDH(this);
   }

   public ECPoint decodePoint(byte[] var1) throws IOException {
      return this.ecDomain.getCurve().decodePoint(var1);
   }

   public ECPublicKeyParameters decodePublicKey(byte[] var1) throws IOException {
      try {
         ECPoint var2 = this.decodePoint(var1);
         return new ECPublicKeyParameters(var2, this.ecDomain);
      } catch (RuntimeException var3) {
         throw new TlsFatalAlert((short)47, var3);
      }
   }

   public byte[] encodePoint(ECPoint var1) throws IOException {
      return var1.getEncoded(this.ecConfig.getPointCompression());
   }

   public byte[] encodePublicKey(ECPublicKeyParameters var1) throws IOException {
      return this.encodePoint(var1.getQ());
   }

   public AsymmetricCipherKeyPair generateKeyPair() {
      ECKeyPairGenerator var1 = new ECKeyPairGenerator();
      var1.init(new ECKeyGenerationParameters(this.ecDomain, this.crypto.getSecureRandom()));
      return var1.generateKeyPair();
   }

   public BcTlsCrypto getCrypto() {
      return this.crypto;
   }

   public ECDomainParameters getParameters(TlsECConfig var1) {
      return this.getParametersForNamedCurve(var1.getNamedCurve());
   }

   public ECDomainParameters getParametersForNamedCurve(int var1) {
      String var2 = NamedCurve.getNameOfSpecificCurve(var1);
      if (var2 == null) {
         return null;
      } else {
         X9ECParameters var3 = CustomNamedCurves.getByName(var2);
         if (var3 == null) {
            var3 = ECNamedCurveTable.getByName(var2);
            if (var3 == null) {
               return null;
            }
         }

         return new ECDomainParameters(var3.getCurve(), var3.getG(), var3.getN(), var3.getH(), var3.getSeed());
      }
   }
}
