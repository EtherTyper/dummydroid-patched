package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.tls.TlsDHUtils;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsVerifier;

public class BcTlsCertificate implements TlsCertificate {
   private final BcTlsCrypto crypto;
   protected final Certificate certificate;
   protected DHPublicKeyParameters pubKeyDH = null;
   protected ECPublicKeyParameters pubKeyEC = null;
   protected RSAKeyParameters pubKeyRSA = null;

   public static BcTlsCertificate convert(BcTlsCrypto var0, TlsCertificate var1) throws IOException {
      return var1 instanceof BcTlsCertificate ? (BcTlsCertificate)var1 : new BcTlsCertificate(var0, var1.getEncoded());
   }

   public BcTlsCertificate(BcTlsCrypto var1, byte[] var2) throws IOException {
      this.crypto = var1;

      try {
         this.certificate = Certificate.getInstance(var2);
      } catch (IllegalArgumentException var4) {
         throw new IOException("unable to decode certificate: " + var4.getMessage(), var4);
      }
   }

   public TlsVerifier createVerifier(short var1) throws IOException {
      this.validateKeyUsage(128);
      switch(var1) {
      case 1:
         return new BcTlsRSAVerifier(this.getPubKeyRSA());
      case 2:
         return new BcTlsDSAVerifier(this.crypto, this.getPubKeyDSS());
      case 3:
         return new BcTlsECDSAVerifier(this.crypto, this.getPubKeyEC());
      default:
         throw new TlsFatalAlert((short)46);
      }
   }

   public short getClientCertificateType() throws IOException {
      AsymmetricKeyParameter var1 = this.getPublicKey();
      if (var1.isPrivate()) {
         throw new TlsFatalAlert((short)80);
      } else {
         try {
            if (var1 instanceof RSAKeyParameters) {
               this.validateKeyUsage(128);
               return 1;
            }

            if (var1 instanceof DSAPublicKeyParameters) {
               this.validateKeyUsage(128);
               return 2;
            }

            if (var1 instanceof ECPublicKeyParameters) {
               this.validateKeyUsage(128);
               return 64;
            }
         } catch (IOException var3) {
            throw var3;
         } catch (Exception var4) {
            throw new TlsFatalAlert((short)43, var4);
         }

         throw new TlsFatalAlert((short)43);
      }
   }

   public byte[] getEncoded() throws IOException {
      return this.certificate.getEncoded("DER");
   }

   protected DHPublicKeyParameters getPubKeyDH() throws IOException {
      DHPublicKeyParameters var1;
      try {
         var1 = (DHPublicKeyParameters)this.getPublicKey();
      } catch (ClassCastException var3) {
         throw new TlsFatalAlert((short)46, var3);
      }

      return this.validatePubKeyDH(var1);
   }

   public DSAPublicKeyParameters getPubKeyDSS() throws IOException {
      DSAPublicKeyParameters var1;
      try {
         var1 = (DSAPublicKeyParameters)this.getPublicKey();
      } catch (ClassCastException var3) {
         throw new TlsFatalAlert((short)46, var3);
      }

      return this.validatePubKeyDSS(var1);
   }

   public ECPublicKeyParameters getPubKeyEC() throws IOException {
      ECPublicKeyParameters var1;
      try {
         var1 = (ECPublicKeyParameters)this.getPublicKey();
      } catch (ClassCastException var3) {
         throw new TlsFatalAlert((short)46, var3);
      }

      return this.validatePubKeyEC(var1);
   }

   public RSAKeyParameters getPubKeyRSA() throws IOException {
      RSAKeyParameters var1;
      try {
         var1 = (RSAKeyParameters)this.getPublicKey();
      } catch (ClassCastException var3) {
         throw new TlsFatalAlert((short)46, var3);
      }

      return this.validatePubKeyRSA(var1);
   }

   public TlsCertificate useInRole(int var1, int var2) throws IOException {
      switch(var2) {
      case 7:
      case 9:
         this.validateKeyUsage(8);
         this.pubKeyDH = this.getPubKeyDH();
         return this;
      case 16:
      case 18:
         this.validateKeyUsage(8);
         this.pubKeyEC = this.getPubKeyEC();
         return this;
      default:
         if (var1 == 0) {
            switch(var2) {
            case 1:
            case 15:
               this.validateKeyUsage(32);
               this.pubKeyRSA = this.getPubKeyRSA();
               return this;
            }
         }

         throw new TlsFatalAlert((short)46);
      }
   }

   protected AsymmetricKeyParameter getPublicKey() throws IOException {
      SubjectPublicKeyInfo var1 = this.certificate.getSubjectPublicKeyInfo();

      try {
         return PublicKeyFactory.createKey(var1);
      } catch (RuntimeException var3) {
         throw new TlsFatalAlert((short)43, var3);
      }
   }

   protected void validateKeyUsage(int var1) throws IOException {
      Extensions var2 = this.certificate.getTBSCertificate().getExtensions();
      if (var2 != null) {
         KeyUsage var3 = KeyUsage.fromExtensions(var2);
         if (var3 != null) {
            int var4 = var3.getBytes()[0] & 255;
            if ((var4 & var1) != var1) {
               throw new TlsFatalAlert((short)46);
            }
         }
      }

   }

   protected DHPublicKeyParameters validatePubKeyDH(DHPublicKeyParameters var1) throws IOException {
      TlsDHUtils.validateDHPublicValues(var1.getY(), var1.getParameters().getP());
      return var1;
   }

   protected DSAPublicKeyParameters validatePubKeyDSS(DSAPublicKeyParameters var1) throws IOException {
      return var1;
   }

   protected ECPublicKeyParameters validatePubKeyEC(ECPublicKeyParameters var1) throws IOException {
      return var1;
   }

   protected RSAKeyParameters validatePubKeyRSA(RSAKeyParameters var1) throws IOException {
      return var1;
   }
}
