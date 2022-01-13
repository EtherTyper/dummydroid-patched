package org.bouncycastle.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsSRP6Client;
import org.bouncycastle.tls.crypto.TlsSRP6Server;
import org.bouncycastle.tls.crypto.TlsSRPConfig;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.tls.crypto.TlsVerifier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.io.TeeInputStream;

public class TlsSRPKeyExchange extends AbstractTlsKeyExchange {
   protected TlsSRPConfigVerifier srpConfigVerifier;
   protected byte[] identity;
   protected byte[] password;
   protected TlsSRPConfig srpConfig = null;
   protected TlsSRP6Client srpClient = null;
   protected TlsSRP6Server srpServer = null;
   protected BigInteger srpPeerCredentials = null;
   protected BigInteger srpVerifier = null;
   protected byte[] srpSalt = null;
   protected TlsCredentialedSigner serverCredentials = null;
   protected TlsVerifier verifier = null;

   private static int checkKeyExchange(int var0) {
      switch(var0) {
      case 21:
      case 22:
      case 23:
         return var0;
      default:
         throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
   }

   public TlsSRPKeyExchange(int var1, Vector var2, TlsSRPConfigVerifier var3, byte[] var4, byte[] var5) {
      super(checkKeyExchange(var1), var2);
      this.srpConfigVerifier = var3;
      this.identity = var4;
      this.password = var5;
   }

   public TlsSRPKeyExchange(int var1, Vector var2, byte[] var3, TlsSRPLoginParameters var4) {
      super(checkKeyExchange(var1), var2);
      this.identity = var3;
      this.srpConfig = var4.getConfig();
      this.srpVerifier = var4.getVerifier();
      this.srpSalt = var4.getSalt();
   }

   public void skipServerCredentials() throws IOException {
      if (this.keyExchange != 21) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void processServerCredentials(TlsCredentials var1) throws IOException {
      if (this.keyExchange == 21) {
         throw new TlsFatalAlert((short)80);
      } else if (!(var1 instanceof TlsCredentialedSigner)) {
         throw new TlsFatalAlert((short)80);
      } else {
         this.serverCredentials = (TlsCredentialedSigner)var1;
      }
   }

   public void processServerCertificate(Certificate var1) throws IOException {
      if (this.keyExchange == 21) {
         throw new TlsFatalAlert((short)80);
      } else if (var1.isEmpty()) {
         throw new TlsFatalAlert((short)42);
      } else {
         this.checkServerCertSigAlg(var1);
         this.verifier = var1.getCertificateAt(0).createVerifier(TlsUtils.getSignatureAlgorithm(this.keyExchange));
      }
   }

   public boolean requiresServerKeyExchange() {
      return true;
   }

   public byte[] generateServerKeyExchange() throws IOException {
      this.srpServer = this.context.getCrypto().createSRP6Server(this.srpConfig, this.srpVerifier);
      BigInteger var1 = this.srpServer.generateServerCredentials();
      BigInteger[] var2 = this.srpConfig.getExplicitNG();
      ServerSRPParams var3 = new ServerSRPParams(var2[0], var2[1], this.srpSalt, var1);
      DigestInputBuffer var4 = new DigestInputBuffer();
      var3.encode(var4);
      if (this.serverCredentials != null) {
         DigitallySigned var5 = TlsUtils.generateServerKeyExchangeSignature(this.context, this.serverCredentials, var4);
         var5.encode(var4);
      }

      return var4.toByteArray();
   }

   public void processServerKeyExchange(InputStream var1) throws IOException {
      DigestInputBuffer var2 = null;
      Object var3 = var1;
      if (this.keyExchange != 21) {
         var2 = new DigestInputBuffer();
         var3 = new TeeInputStream(var1, var2);
      }

      ServerSRPParams var4 = ServerSRPParams.parse((InputStream)var3);
      if (var2 != null) {
         DigitallySigned var5 = this.parseSignature(var1);
         TlsUtils.verifyServerKeyExchangeSignature(this.context, this.verifier, var2, var5);
      }

      this.srpConfig = new TlsSRPConfig();
      this.srpConfig.setExplicitNG(new BigInteger[]{var4.getN(), var4.getG()});
      if (!this.srpConfigVerifier.accept(this.srpConfig)) {
         throw new TlsFatalAlert((short)71);
      } else {
         this.srpSalt = var4.getS();
         this.srpPeerCredentials = validatePublicValue(var4.getN(), var4.getB());
         this.srpClient = this.context.getCrypto().createSRP6Client(this.srpConfig);
      }
   }

   public void validateCertificateRequest(CertificateRequest var1) throws IOException {
      throw new TlsFatalAlert((short)10);
   }

   public void processClientCredentials(TlsCredentials var1) throws IOException {
      throw new TlsFatalAlert((short)80);
   }

   public void generateClientKeyExchange(OutputStream var1) throws IOException {
      BigInteger var2 = this.srpClient.generateClientCredentials(this.srpSalt, this.identity, this.password);
      TlsSRPUtils.writeSRPParameter(var2, var1);
      this.context.getSecurityParameters().srpIdentity = Arrays.clone(this.identity);
   }

   public void processClientKeyExchange(InputStream var1) throws IOException {
      this.srpPeerCredentials = validatePublicValue(this.srpConfig.getExplicitNG()[0], TlsSRPUtils.readSRPParameter(var1));
      this.context.getSecurityParameters().srpIdentity = Arrays.clone(this.identity);
   }

   public TlsSecret generatePreMasterSecret() throws IOException {
      BigInteger var1 = this.srpServer != null ? this.srpServer.calculateSecret(this.srpPeerCredentials) : this.srpClient.calculateSecret(this.srpPeerCredentials);
      return this.context.getCrypto().createSecret(BigIntegers.asUnsignedByteArray(var1));
   }

   public static BigInteger validatePublicValue(BigInteger var0, BigInteger var1) throws IOException {
      var1 = var1.mod(var0);
      if (var1.equals(BigInteger.ZERO)) {
         throw new TlsFatalAlert((short)47, new IllegalArgumentException("Invalid public value: 0"));
      } else {
         return var1;
      }
   }
}
