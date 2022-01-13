package org.bouncycastle.tls;

import java.io.IOException;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.util.Arrays;

public abstract class DefaultTlsClient extends AbstractTlsClient {
   protected static final int[] BASE_CIPHER_SUITES = new int[]{52393, 49195, 49187, 49161, 52392, 49199, 49191, 49171, 52394, 158, 103, 51, 156, 60, 47};
   protected TlsDHConfigVerifier dhConfigVerifier;
   protected int[] supportedCipherSuites;

   public DefaultTlsClient(TlsCrypto var1) {
      this(var1, new DefaultTlsKeyExchangeFactory(), new DefaultTlsDHConfigVerifier());
   }

   public DefaultTlsClient(TlsCrypto var1, TlsKeyExchangeFactory var2, TlsDHConfigVerifier var3) {
      super(var1, var2);
      this.dhConfigVerifier = var3;
      this.supportedCipherSuites = TlsUtils.getSupportedCipherSuites(var1, BASE_CIPHER_SUITES);
   }

   public int[] getCipherSuites() {
      return Arrays.clone(this.supportedCipherSuites);
   }

   public TlsKeyExchange getKeyExchange() throws IOException {
      int var1 = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
      switch(var1) {
      case 1:
         return this.createRSAKeyExchange();
      case 2:
      case 4:
      case 6:
      case 8:
      case 10:
      case 12:
      case 13:
      case 14:
      case 15:
      default:
         throw new TlsFatalAlert((short)80);
      case 3:
      case 5:
         return this.createDHEKeyExchange(var1);
      case 7:
      case 9:
      case 11:
         return this.createDHKeyExchange(var1);
      case 16:
      case 18:
      case 20:
         return this.createECDHKeyExchange(var1);
      case 17:
      case 19:
         return this.createECDHEKeyExchange(var1);
      }
   }

   protected TlsKeyExchange createDHKeyExchange(int var1) throws IOException {
      return this.keyExchangeFactory.createDHKeyExchangeClient(var1, this.supportedSignatureAlgorithms, this.dhConfigVerifier);
   }

   protected TlsKeyExchange createDHEKeyExchange(int var1) throws IOException {
      return this.keyExchangeFactory.createDHEKeyExchangeClient(var1, this.supportedSignatureAlgorithms, this.dhConfigVerifier);
   }

   protected TlsKeyExchange createECDHKeyExchange(int var1) throws IOException {
      return this.keyExchangeFactory.createECDHKeyExchangeClient(var1, this.supportedSignatureAlgorithms, this.createECConfigVerifier(), this.clientECPointFormats, this.serverECPointFormats);
   }

   protected TlsKeyExchange createECDHEKeyExchange(int var1) throws IOException {
      return this.keyExchangeFactory.createECDHEKeyExchangeClient(var1, this.supportedSignatureAlgorithms, this.createECConfigVerifier(), this.clientECPointFormats, this.serverECPointFormats);
   }

   protected TlsKeyExchange createRSAKeyExchange() throws IOException {
      return this.keyExchangeFactory.createRSAKeyExchange(this.supportedSignatureAlgorithms);
   }
}
