package de.onyxbits.raccoon.net;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.TlsECCUtils;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.util.Arrays;

class JellyBeanTlsClient extends SessionResumeTlsClient {
   private static final int[] SUITES = new int[]{4, 5, 47, 53, 49154, 49156, 49157, 49164, 49166, 49167, 49159, 49161, 49162, 49169, 49171, 49172, 51, 57, 50, 56, 10, 49155, 49165, 49160, 49170, 22, 19, 9, 21, 18, 3, 8, 20, 17, 255};

   public JellyBeanTlsClient(TlsCrypto crypto) {
      super(crypto);
   }

   public ProtocolVersion getClientVersion() {
      return ProtocolVersion.TLSv10;
   }

   public Hashtable getClientExtensions() throws IOException {
      OrderedHashtable ret = new OrderedHashtable();
      ProtocolVersion clientVersion = this.context.getClientVersion();
      if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(clientVersion)) {
         this.supportedSignatureAlgorithms = this.getSupportedSignatureAlgorithms();
         TlsUtils.addSignatureAlgorithmsExtension(ret, this.supportedSignatureAlgorithms);
      }

      if (TlsECCUtils.containsECCipherSuites(this.getCipherSuites())) {
         this.namedCurves = new int[]{14, 13, 25, 11, 12, 24, 9, 10, 22, 23, 8, 6, 7, 20, 21, 4, 5, 18, 19, 1, 2, 3, 15, 16, 17};
         this.clientECPointFormats = new short[]{0, 1, 2};
         TlsECCUtils.addSupportedPointFormatsExtension(ret, this.clientECPointFormats);
         TlsECCUtils.addSupportedEllipticCurvesExtension(ret, this.namedCurves);
      }

      return ret;
   }

   public int[] getCipherSuites() {
      return Arrays.clone(SUITES);
   }
}
