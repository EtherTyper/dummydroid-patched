package org.bouncycastle.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.tls.crypto.TlsCipher;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.TlsCryptoParameters;

public abstract class AbstractTlsClient extends AbstractTlsPeer implements TlsClient {
   protected TlsKeyExchangeFactory keyExchangeFactory;
   protected TlsClientContext context;
   protected Vector supportedSignatureAlgorithms;
   protected int[] namedCurves;
   protected short[] clientECPointFormats;
   protected short[] serverECPointFormats;
   protected int selectedCipherSuite;
   protected short selectedCompressionMethod;

   public AbstractTlsClient(TlsCrypto var1) {
      this(var1, new DefaultTlsKeyExchangeFactory());
   }

   public AbstractTlsClient(TlsCrypto var1, TlsKeyExchangeFactory var2) {
      super(var1);
      this.keyExchangeFactory = var2;
   }

   protected boolean allowUnexpectedServerExtension(Integer var1, byte[] var2) throws IOException {
      switch(var1) {
      case 10:
         TlsECCUtils.readSupportedEllipticCurvesExtension(var2);
         return true;
      default:
         return false;
      }
   }

   protected void checkForUnexpectedServerExtension(Hashtable var1, Integer var2) throws IOException {
      byte[] var3 = TlsUtils.getExtensionData(var1, var2);
      if (var3 != null && !this.allowUnexpectedServerExtension(var2, var3)) {
         throw new TlsFatalAlert((short)47);
      }
   }

   protected TlsECConfigVerifier createECConfigVerifier() {
      int var1 = TlsECCUtils.getMinimumCurveBits(this.selectedCipherSuite);
      return new DefaultTlsECConfigVerifier(var1, this.namedCurves);
   }

   protected Vector getSupportedSignatureAlgorithms() {
      return TlsUtils.getDefaultSupportedSignatureAlgorithms(this.context);
   }

   public void init(TlsClientContext var1) {
      this.context = var1;
   }

   public TlsSession getSessionToResume() {
      return null;
   }

   public ProtocolVersion getClientHelloRecordLayerVersion() {
      return this.getClientVersion();
   }

   public ProtocolVersion getClientVersion() {
      return ProtocolVersion.TLSv12;
   }

   public boolean isFallback() {
      return false;
   }

   public Hashtable getClientExtensions() throws IOException {
      Hashtable var1 = null;
      ProtocolVersion var2 = this.context.getClientVersion();
      if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(var2)) {
         this.supportedSignatureAlgorithms = this.getSupportedSignatureAlgorithms();
         var1 = TlsExtensionsUtils.ensureExtensionsInitialised(var1);
         TlsUtils.addSignatureAlgorithmsExtension(var1, this.supportedSignatureAlgorithms);
      }

      if (TlsECCUtils.containsECCipherSuites(this.getCipherSuites())) {
         this.namedCurves = new int[]{23, 24};
         this.clientECPointFormats = new short[]{0, 1, 2};
         var1 = TlsExtensionsUtils.ensureExtensionsInitialised(var1);
         TlsECCUtils.addSupportedEllipticCurvesExtension(var1, this.namedCurves);
         TlsECCUtils.addSupportedPointFormatsExtension(var1, this.clientECPointFormats);
      }

      return var1;
   }

   public ProtocolVersion getMinimumVersion() {
      return ProtocolVersion.TLSv10;
   }

   public void notifyServerVersion(ProtocolVersion var1) throws IOException {
      if (!this.getMinimumVersion().isEqualOrEarlierVersionOf(var1)) {
         throw new TlsFatalAlert((short)70);
      }
   }

   public short[] getCompressionMethods() {
      return new short[]{0};
   }

   public void notifySessionID(byte[] var1) {
   }

   public void notifySelectedCipherSuite(int var1) {
      this.selectedCipherSuite = var1;
   }

   public void notifySelectedCompressionMethod(short var1) {
      this.selectedCompressionMethod = var1;
   }

   public void processServerExtensions(Hashtable var1) throws IOException {
      if (var1 != null) {
         this.checkForUnexpectedServerExtension(var1, TlsUtils.EXT_signature_algorithms);
         this.checkForUnexpectedServerExtension(var1, TlsECCUtils.EXT_elliptic_curves);
         if (TlsECCUtils.isECCipherSuite(this.selectedCipherSuite)) {
            this.serverECPointFormats = TlsECCUtils.getSupportedPointFormatsExtension(var1);
         } else {
            this.checkForUnexpectedServerExtension(var1, TlsECCUtils.EXT_ec_point_formats);
         }

         this.checkForUnexpectedServerExtension(var1, TlsExtensionsUtils.EXT_padding);
      }

   }

   public void processServerSupplementalData(Vector var1) throws IOException {
      if (var1 != null) {
         throw new TlsFatalAlert((short)10);
      }
   }

   public Vector getClientSupplementalData() throws IOException {
      return null;
   }

   public TlsCompression getCompression() throws IOException {
      switch(this.selectedCompressionMethod) {
      case 0:
         return new TlsNullCompression();
      default:
         throw new TlsFatalAlert((short)80);
      }
   }

   public TlsCipher getCipher() throws IOException {
      int var1 = TlsUtils.getEncryptionAlgorithm(this.selectedCipherSuite);
      int var2 = TlsUtils.getMACAlgorithm(this.selectedCipherSuite);
      if (var1 >= 0 && var2 >= 0) {
         return this.context.getSecurityParameters().getMasterSecret().createCipher(new TlsCryptoParameters(this.context), var1, var2);
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   public void notifyNewSessionTicket(NewSessionTicket var1) throws IOException {
   }
}
