package org.bouncycastle.tls.crypto.impl.bc;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.bouncycastle.crypto.agreement.srp.SRP6Server;
import org.bouncycastle.crypto.agreement.srp.SRP6VerifierGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.ARIAEngine;
import org.bouncycastle.crypto.engines.CamelliaEngine;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.engines.SEEDEngine;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.SRP6GroupParameters;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.tls.CombinedHash;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.SignatureAndHashAlgorithm;
import org.bouncycastle.tls.TlsFatalAlert;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCertificate;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;
import org.bouncycastle.tls.crypto.TlsDHConfig;
import org.bouncycastle.tls.crypto.TlsDHDomain;
import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.tls.crypto.TlsECDomain;
import org.bouncycastle.tls.crypto.TlsHMAC;
import org.bouncycastle.tls.crypto.TlsHash;
import org.bouncycastle.tls.crypto.TlsMAC;
import org.bouncycastle.tls.crypto.TlsSRP6Client;
import org.bouncycastle.tls.crypto.TlsSRP6Server;
import org.bouncycastle.tls.crypto.TlsSRP6VerifierGenerator;
import org.bouncycastle.tls.crypto.TlsSRPConfig;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.tls.crypto.impl.AbstractTlsCrypto;
import org.bouncycastle.tls.crypto.impl.ChaCha20Poly1305Cipher;
import org.bouncycastle.tls.crypto.impl.TlsAEADCipher;
import org.bouncycastle.tls.crypto.impl.TlsAEADCipherImpl;
import org.bouncycastle.tls.crypto.impl.TlsBlockCipher;
import org.bouncycastle.tls.crypto.impl.TlsBlockCipherImpl;
import org.bouncycastle.tls.crypto.impl.TlsEncryptor;
import org.bouncycastle.tls.crypto.impl.TlsImplUtils;
import org.bouncycastle.tls.crypto.impl.TlsNullCipher;
import org.bouncycastle.tls.crypto.impl.TlsStreamCipher;
import org.bouncycastle.tls.crypto.impl.TlsStreamCipherImpl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Times;

public class BcTlsCrypto extends AbstractTlsCrypto {
   private final DigestRandomGenerator nonceGen;
   private final SecureRandom entropySource;
   private static long counter = Times.nanoTime();

   public BcTlsCrypto(SecureRandom var1) {
      this.entropySource = var1;
      Digest var2 = createDigest((short)4);
      this.nonceGen = new DigestRandomGenerator(var2);
      this.nonceGen.addSeedMaterial(nextCounterValue());
      this.nonceGen.addSeedMaterial(Times.nanoTime());
      byte[] var3 = new byte[var2.getDigestSize()];
      var1.nextBytes(var3);
      this.nonceGen.addSeedMaterial(var3);
   }

   BcTlsSecret adoptLocalSecret(byte[] var1) {
      return new BcTlsSecret(this, var1);
   }

   public byte[] createNonce(int var1) {
      byte[] var2 = new byte[var1];
      this.nonceGen.nextBytes(var2);
      return var2;
   }

   public SecureRandom getSecureRandom() {
      return this.entropySource;
   }

   public TlsCertificate createCertificate(byte[] var1) throws IOException {
      return new BcTlsCertificate(this, var1);
   }

   protected TlsCipher createCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      switch(var2) {
      case 0:
         return this.createNullCipher(var1, var3);
      case 1:
      case 3:
      case 4:
      case 5:
      case 6:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
      case 80:
      case 81:
      case 82:
      case 83:
      case 84:
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
      case 90:
      case 91:
      case 92:
      case 93:
      case 94:
      case 95:
      case 96:
      case 97:
      case 98:
      case 99:
      case 100:
      case 101:
      case 102:
      default:
         throw new TlsFatalAlert((short)80);
      case 2:
         return this.createRC4Cipher(var1, 16, var3);
      case 7:
         return this.createDESedeCipher(var1, var3);
      case 8:
         return this.createAESCipher(var1, 16, var3);
      case 9:
         return this.createAESCipher(var1, 32, var3);
      case 10:
         return this.createCipher_AES_GCM(var1, 16, 16);
      case 11:
         return this.createCipher_AES_GCM(var1, 32, 16);
      case 12:
         return this.createCamelliaCipher(var1, 16, var3);
      case 13:
         return this.createCamelliaCipher(var1, 32, var3);
      case 14:
         return this.createSEEDCipher(var1, var3);
      case 15:
         return this.createCipher_AES_CCM(var1, 16, 16);
      case 16:
         return this.createCipher_AES_CCM(var1, 16, 8);
      case 17:
         return this.createCipher_AES_CCM(var1, 32, 16);
      case 18:
         return this.createCipher_AES_CCM(var1, 32, 8);
      case 19:
         return this.createCipher_Camellia_GCM(var1, 16, 16);
      case 20:
         return this.createCipher_Camellia_GCM(var1, 32, 16);
      case 21:
         return this.createChaCha20Poly1305(var1);
      case 22:
         return this.createARIACipher(var1, 16, var3);
      case 23:
         return this.createARIACipher(var1, 32, var3);
      case 24:
         return this.createCipher_ARIA_GCM(var1, 16, 16);
      case 25:
         return this.createCipher_ARIA_GCM(var1, 32, 16);
      case 103:
         return this.createCipher_AES_OCB(var1, 16, 12);
      case 104:
         return this.createCipher_AES_OCB(var1, 32, 12);
      }
   }

   public TlsDHDomain createDHDomain(TlsDHConfig var1) {
      return new BcTlsDHDomain(this, var1);
   }

   public TlsECDomain createECDomain(TlsECConfig var1) {
      return new BcTlsECDomain(this, var1);
   }

   protected TlsEncryptor createEncryptor(TlsCertificate var1) throws IOException {
      BcTlsCertificate var2 = BcTlsCertificate.convert(this, var1);
      var2.validateKeyUsage(32);
      final RSAKeyParameters var3 = var2.getPubKeyRSA();
      return new TlsEncryptor() {
         public byte[] encrypt(byte[] var1, int var2, int var3x) throws IOException {
            try {
               PKCS1Encoding var4 = new PKCS1Encoding(new RSABlindedEngine());
               var4.init(true, new ParametersWithRandom(var3, BcTlsCrypto.this.getSecureRandom()));
               return var4.processBlock(var1, var2, var3x);
            } catch (InvalidCipherTextException var5) {
               throw new TlsFatalAlert((short)80, var5);
            }
         }
      };
   }

   public boolean hasAllRawSignatureAlgorithms() {
      return true;
   }

   public boolean hasDHAgreement() {
      return true;
   }

   public boolean hasECDHAgreement() {
      return true;
   }

   public boolean hasEncryptionAlgorithm(int var1) {
      return true;
   }

   public boolean hasHashAlgorithm(short var1) {
      return true;
   }

   public boolean hasMacAlgorithm(int var1) {
      return true;
   }

   public boolean hasNamedCurve(int var1) {
      return true;
   }

   public boolean hasRSAEncryption() {
      return true;
   }

   public boolean hasSignatureAlgorithm(int var1) {
      return true;
   }

   public boolean hasSignatureAndHashAlgorithm(SignatureAndHashAlgorithm var1) {
      return true;
   }

   public boolean hasSRPAuthentication() {
      return true;
   }

   public TlsSecret createSecret(byte[] var1) {
      try {
         BcTlsSecret var2 = this.adoptLocalSecret(Arrays.clone(var1));
         return var2;
      } finally {
         ;
      }
   }

   public TlsSecret generateRSAPreMasterSecret(ProtocolVersion var1) {
      byte[] var2 = new byte[48];
      this.entropySource.nextBytes(var2);
      TlsUtils.writeVersion(var1, var2, 0);
      return this.adoptLocalSecret(var2);
   }

   static Digest createDigest(short var0) {
      switch(var0) {
      case 1:
         return new MD5Digest();
      case 2:
         return new SHA1Digest();
      case 3:
         return new SHA224Digest();
      case 4:
         return new SHA256Digest();
      case 5:
         return new SHA384Digest();
      case 6:
         return new SHA512Digest();
      default:
         throw new IllegalArgumentException("unknown HashAlgorithm");
      }
   }

   public TlsHash createHash(SignatureAndHashAlgorithm var1) {
      return (TlsHash)(var1 == null ? new CombinedHash(this) : new BcTlsCrypto.BcTlsHash(var1.getHash(), createDigest(var1.getHash())));
   }

   public TlsHash createHash(short var1) {
      return new BcTlsCrypto.BcTlsHash(var1, createDigest(var1));
   }

   public static Digest cloneDigest(short var0, Digest var1) {
      switch(var0) {
      case 1:
         return new MD5Digest((MD5Digest)var1);
      case 2:
         return new SHA1Digest((SHA1Digest)var1);
      case 3:
         return new SHA224Digest((SHA224Digest)var1);
      case 4:
         return new SHA256Digest((SHA256Digest)var1);
      case 5:
         return new SHA384Digest((SHA384Digest)var1);
      case 6:
         return new SHA512Digest((SHA512Digest)var1);
      default:
         throw new IllegalArgumentException("unknown HashAlgorithm");
      }
   }

   public Digest createPRFHash(int var1) {
      switch(var1) {
      case 0:
         return new BcTlsCrypto.CombinedPRF();
      default:
         return createDigest(TlsUtils.getHashAlgorithmForPRFAlgorithm(var1));
      }
   }

   protected TlsCipher createAESCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsBlockCipher(this, var1, new BcTlsCrypto.BlockOperator(this.createAESBlockCipher(), true), new BcTlsCrypto.BlockOperator(this.createAESBlockCipher(), false), this.createMac(var1, var3), this.createMac(var1, var3), var2);
   }

   protected TlsCipher createARIACipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsBlockCipher(this, var1, new BcTlsCrypto.BlockOperator(this.createARIABlockCipher(), true), new BcTlsCrypto.BlockOperator(this.createARIABlockCipher(), false), this.createMac(var1, var3), this.createMac(var1, var3), var2);
   }

   protected TlsCipher createCamelliaCipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsBlockCipher(this, var1, new BcTlsCrypto.BlockOperator(this.createCamelliaBlockCipher(), true), new BcTlsCrypto.BlockOperator(this.createCamelliaBlockCipher(), false), this.createMac(var1, var3), this.createMac(var1, var3), var2);
   }

   protected TlsCipher createChaCha20Poly1305(TlsCryptoParameters var1) throws IOException {
      return new ChaCha20Poly1305Cipher(var1, new BcTlsCrypto.StreamOperator(new ChaCha7539Engine(), true), new BcTlsCrypto.StreamOperator(new ChaCha7539Engine(), false), new BcTlsCrypto.MacOperator(new Poly1305()), new BcTlsCrypto.MacOperator(new Poly1305()));
   }

   protected TlsAEADCipher createCipher_AES_CCM(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsAEADCipher(var1, new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_CCM(), true), new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_CCM(), false), var2, var3);
   }

   protected TlsAEADCipher createCipher_AES_GCM(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsAEADCipher(var1, new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_GCM(), true), new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_GCM(), false), var2, var3);
   }

   protected TlsAEADCipher createCipher_AES_OCB(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsAEADCipher(var1, new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_OCB(), true), new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_AES_OCB(), false), var2, var3, 2);
   }

   protected TlsAEADCipher createCipher_ARIA_GCM(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsAEADCipher(var1, new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_ARIA_GCM(), true), new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_ARIA_GCM(), false), var2, var3);
   }

   protected TlsAEADCipher createCipher_Camellia_GCM(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsAEADCipher(var1, new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_Camellia_GCM(), true), new BcTlsCrypto.AeadOperator(this.createAEADBlockCipher_Camellia_GCM(), false), var2, var3);
   }

   protected TlsBlockCipher createDESedeCipher(TlsCryptoParameters var1, int var2) throws IOException {
      return new TlsBlockCipher(this, var1, new BcTlsCrypto.BlockOperator(this.createDESedeBlockCipher(), true), new BcTlsCrypto.BlockOperator(this.createDESedeBlockCipher(), false), this.createMac(var1, var2), this.createMac(var1, var2), 24);
   }

   protected TlsNullCipher createNullCipher(TlsCryptoParameters var1, int var2) throws IOException {
      return new TlsNullCipher(var1, this.createMac(var1, var2), this.createMac(var1, var2));
   }

   protected TlsStreamCipher createRC4Cipher(TlsCryptoParameters var1, int var2, int var3) throws IOException {
      return new TlsStreamCipher(var1, new BcTlsCrypto.StreamOperator(this.createRC4StreamCipher(), true), new BcTlsCrypto.StreamOperator(this.createRC4StreamCipher(), false), this.createMac(var1, var3), this.createMac(var1, var3), var2, false);
   }

   protected TlsBlockCipher createSEEDCipher(TlsCryptoParameters var1, int var2) throws IOException {
      return new TlsBlockCipher(this, var1, new BcTlsCrypto.BlockOperator(this.createSEEDBlockCipher(), true), new BcTlsCrypto.BlockOperator(this.createSEEDBlockCipher(), false), this.createMac(var1, var2), this.createMac(var1, var2), 16);
   }

   protected BlockCipher createAESEngine() {
      return new AESEngine();
   }

   protected BlockCipher createARIAEngine() {
      return new ARIAEngine();
   }

   protected BlockCipher createCamelliaEngine() {
      return new CamelliaEngine();
   }

   protected BlockCipher createAESBlockCipher() {
      return new CBCBlockCipher(this.createAESEngine());
   }

   protected BlockCipher createARIABlockCipher() {
      return new CBCBlockCipher(this.createARIAEngine());
   }

   protected AEADBlockCipher createAEADBlockCipher_AES_CCM() {
      return new CCMBlockCipher(this.createAESEngine());
   }

   protected AEADBlockCipher createAEADBlockCipher_AES_GCM() {
      return new GCMBlockCipher(this.createAESEngine());
   }

   protected AEADBlockCipher createAEADBlockCipher_AES_OCB() {
      return new OCBBlockCipher(this.createAESEngine(), this.createAESEngine());
   }

   protected AEADBlockCipher createAEADBlockCipher_ARIA_GCM() {
      return new GCMBlockCipher(this.createARIAEngine());
   }

   protected AEADBlockCipher createAEADBlockCipher_Camellia_GCM() {
      return new GCMBlockCipher(this.createCamelliaEngine());
   }

   protected BlockCipher createCamelliaBlockCipher() {
      return new CBCBlockCipher(this.createCamelliaEngine());
   }

   protected BlockCipher createDESedeBlockCipher() {
      return new CBCBlockCipher(new DESedeEngine());
   }

   protected StreamCipher createRC4StreamCipher() {
      return new RC4Engine();
   }

   protected BlockCipher createSEEDBlockCipher() {
      return new CBCBlockCipher(new SEEDEngine());
   }

   private TlsHMAC createMac(TlsCryptoParameters var1, int var2) throws IOException {
      return TlsImplUtils.isSSL(var1) ? this.createSSl3HMAC((short)var2) : this.createHMAC((short)var2);
   }

   protected Digest createHMACDigest(int var1) throws IOException {
      switch(var1) {
      case 0:
         return null;
      case 1:
         return createDigest((short)1);
      case 2:
         return createDigest((short)2);
      case 3:
         return createDigest((short)4);
      case 4:
         return createDigest((short)5);
      case 5:
         return createDigest((short)6);
      default:
         throw new TlsFatalAlert((short)80);
      }
   }

   public TlsHMAC createHMAC(int var1) {
      switch(var1) {
      case 1:
         return new BcTlsCrypto.HMacOperator(createDigest((short)1));
      case 2:
         return new BcTlsCrypto.HMacOperator(createDigest((short)2));
      case 3:
         return new BcTlsCrypto.HMacOperator(createDigest((short)4));
      case 4:
         return new BcTlsCrypto.HMacOperator(createDigest((short)5));
      case 5:
         return new BcTlsCrypto.HMacOperator(createDigest((short)6));
      default:
         throw new IllegalArgumentException("unknown HashAlgorithm");
      }
   }

   public TlsSRP6Client createSRP6Client(TlsSRPConfig var1) {
      final SRP6Client var2 = new SRP6Client();
      BigInteger[] var3 = var1.getExplicitNG();
      SRP6GroupParameters var4 = new SRP6GroupParameters(var3[0], var3[1]);
      var2.init(var4, new SHA1Digest(), this.getSecureRandom());
      return new TlsSRP6Client() {
         public BigInteger calculateSecret(BigInteger var1) throws TlsFatalAlert {
            try {
               return var2.calculateSecret(var1);
            } catch (CryptoException var3) {
               throw new TlsFatalAlert((short)47, var3);
            }
         }

         public BigInteger generateClientCredentials(byte[] var1, byte[] var2x, byte[] var3) {
            return var2.generateClientCredentials(var1, var2x, var3);
         }
      };
   }

   public TlsSRP6Server createSRP6Server(TlsSRPConfig var1, BigInteger var2) {
      final SRP6Server var3 = new SRP6Server();
      BigInteger[] var4 = var1.getExplicitNG();
      SRP6GroupParameters var5 = new SRP6GroupParameters(var4[0], var4[1]);
      var3.init(var5, var2, new SHA1Digest(), this.getSecureRandom());
      return new TlsSRP6Server() {
         public BigInteger generateServerCredentials() {
            return var3.generateServerCredentials();
         }

         public BigInteger calculateSecret(BigInteger var1) throws IOException {
            try {
               return var3.calculateSecret(var1);
            } catch (CryptoException var3x) {
               throw new TlsFatalAlert((short)47, var3x);
            }
         }
      };
   }

   public TlsSRP6VerifierGenerator createSRP6VerifierGenerator(TlsSRPConfig var1) {
      BigInteger[] var2 = var1.getExplicitNG();
      final SRP6VerifierGenerator var3 = new SRP6VerifierGenerator();
      var3.init(var2[0], var2[1], new SHA1Digest());
      return new TlsSRP6VerifierGenerator() {
         public BigInteger generateVerifier(byte[] var1, byte[] var2, byte[] var3x) {
            return var3.generateVerifier(var1, var2, var3x);
         }
      };
   }

   protected TlsHMAC createSSl3HMAC(int var1) throws IOException {
      switch(var1) {
      case 0:
         return null;
      case 1:
         return new SSL3Mac(createDigest((short)1));
      case 2:
         return new SSL3Mac(createDigest((short)2));
      case 3:
         return new SSL3Mac(createDigest((short)4));
      case 4:
         return new SSL3Mac(createDigest((short)5));
      case 5:
         return new SSL3Mac(createDigest((short)6));
      default:
         throw new TlsFatalAlert((short)80);
      }
   }

   private static synchronized long nextCounterValue() {
      return ++counter;
   }

   public class AeadOperator implements TlsAEADCipherImpl {
      private final boolean isEncrypting;
      private final AEADBlockCipher cipher;
      private KeyParameter key;

      public AeadOperator(AEADBlockCipher var2, boolean var3) {
         this.cipher = var2;
         this.isEncrypting = var3;
      }

      public void setKey(byte[] var1) {
         this.key = new KeyParameter(var1);
      }

      public void init(byte[] var1, int var2, byte[] var3) {
         this.cipher.init(this.isEncrypting, new AEADParameters(this.key, var2 * 8, var1, var3));
      }

      public int getOutputSize(int var1) {
         return this.cipher.getOutputSize(var1);
      }

      public int doFinal(byte[] var1, int var2, int var3, byte[] var4, int var5) {
         int var6 = this.cipher.processBytes(var1, var2, var3, var4, var5);

         try {
            return var6 + this.cipher.doFinal(var4, var5 + var6);
         } catch (InvalidCipherTextException var8) {
            var8.printStackTrace();
            throw new RuntimeCryptoException(var8.toString());
         }
      }
   }

   private static class BcTlsHash implements TlsHash {
      private final short hashAlgorithm;
      private final Digest digest;

      BcTlsHash(short var1, Digest var2) {
         this.hashAlgorithm = var1;
         this.digest = var2;
      }

      public void update(byte[] var1, int var2, int var3) {
         this.digest.update(var1, var2, var3);
      }

      public byte[] calculateHash() {
         byte[] var1 = new byte[this.digest.getDigestSize()];
         this.digest.doFinal(var1, 0);
         return var1;
      }

      public Object clone() {
         return new BcTlsCrypto.BcTlsHash(this.hashAlgorithm, BcTlsCrypto.cloneDigest(this.hashAlgorithm, this.digest));
      }

      public void reset() {
         this.digest.reset();
      }
   }

   private class BlockOperator implements TlsBlockCipherImpl {
      private final boolean isEncrypting;
      private final BlockCipher cipher;
      private KeyParameter key;

      BlockOperator(BlockCipher var2, boolean var3) {
         this.cipher = var2;
         this.isEncrypting = var3;
      }

      public void setKey(byte[] var1) {
         this.key = new KeyParameter(var1);
         this.cipher.init(this.isEncrypting, new ParametersWithIV(this.key, new byte[this.cipher.getBlockSize()]));
      }

      public void init(byte[] var1) {
         this.cipher.init(this.isEncrypting, new ParametersWithIV((CipherParameters)null, var1));
      }

      public int doFinal(byte[] var1, int var2, int var3, byte[] var4, int var5) {
         int var6 = this.cipher.getBlockSize();

         for(int var7 = 0; var7 < var3; var7 += var6) {
            this.cipher.processBlock(var1, var2 + var7, var4, var5 + var7);
         }

         return var3;
      }

      public int getBlockSize() {
         return this.cipher.getBlockSize();
      }
   }

   public class CombinedPRF implements Digest {
      private final MD5Digest md5 = new MD5Digest();
      private final SHA1Digest sha1 = new SHA1Digest();

      CombinedPRF() {
      }

      public String getAlgorithmName() {
         return this.md5.getAlgorithmName() + " and " + this.sha1.getAlgorithmName();
      }

      public int getDigestSize() {
         return this.md5.getDigestSize() + this.sha1.getDigestSize();
      }

      public void update(byte var1) {
         this.md5.update(var1);
         this.sha1.update(var1);
      }

      public void update(byte[] var1, int var2, int var3) {
         this.md5.update(var1, var2, var3);
         this.sha1.update(var1, var2, var3);
      }

      public int doFinal(byte[] var1, int var2) {
         int var3 = this.md5.doFinal(var1, var2);
         int var4 = this.sha1.doFinal(var1, var2 + var3);
         return var3 + var4;
      }

      public void reset() {
         this.md5.reset();
         this.sha1.reset();
      }
   }

   private class HMacOperator implements TlsHMAC {
      private final HMac hmac;

      HMacOperator(Digest var2) {
         this.hmac = new HMac(var2);
      }

      public void setKey(byte[] var1) {
         this.hmac.init(new KeyParameter(var1));
      }

      public void update(byte[] var1, int var2, int var3) {
         this.hmac.update(var1, var2, var3);
      }

      public byte[] calculateMAC() {
         byte[] var1 = new byte[this.hmac.getMacSize()];
         this.hmac.doFinal(var1, 0);
         return var1;
      }

      public int getInternalBlockSize() {
         return ((ExtendedDigest)this.hmac.getUnderlyingDigest()).getByteLength();
      }

      public int getMacLength() {
         return this.hmac.getMacSize();
      }

      public void reset() {
         this.hmac.reset();
      }
   }

   private class MacOperator implements TlsMAC {
      private final Mac mac;

      MacOperator(Mac var2) {
         this.mac = var2;
      }

      public void setKey(byte[] var1) {
         this.mac.init(new KeyParameter(var1));
      }

      public void update(byte[] var1, int var2, int var3) {
         this.mac.update(var1, var2, var3);
      }

      public byte[] calculateMAC() {
         byte[] var1 = new byte[this.mac.getMacSize()];
         this.mac.doFinal(var1, 0);
         return var1;
      }

      public int getMacLength() {
         return this.mac.getMacSize();
      }

      public void reset() {
         this.mac.reset();
      }
   }

   private class StreamOperator implements TlsStreamCipherImpl {
      private final boolean isEncrypting;
      private final StreamCipher cipher;
      private KeyParameter key;

      StreamOperator(StreamCipher var2, boolean var3) {
         this.cipher = var2;
         this.isEncrypting = var3;
      }

      public void setKey(byte[] var1) {
         this.key = new KeyParameter(var1);
      }

      public void init(byte[] var1) {
         if (var1 != null) {
            this.cipher.init(this.isEncrypting, new ParametersWithIV(this.key, var1));
         } else {
            this.cipher.init(this.isEncrypting, this.key);
         }

      }

      public int doFinal(byte[] var1, int var2, int var3, byte[] var4, int var5) {
         return this.cipher.processBytes(var1, var2, var3, var4, var5);
      }
   }
}
