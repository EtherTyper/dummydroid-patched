package org.bouncycastle.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import org.bouncycastle.tls.crypto.TlsECConfig;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

public class TlsECCUtils {
   public static final Integer EXT_elliptic_curves = Integers.valueOf(10);
   public static final Integer EXT_ec_point_formats = Integers.valueOf(11);

   public static void addSupportedEllipticCurvesExtension(Hashtable var0, int[] var1) throws IOException {
      var0.put(EXT_elliptic_curves, createSupportedEllipticCurvesExtension(var1));
   }

   public static void addSupportedPointFormatsExtension(Hashtable var0, short[] var1) throws IOException {
      var0.put(EXT_ec_point_formats, createSupportedPointFormatsExtension(var1));
   }

   public static int[] getSupportedEllipticCurvesExtension(Hashtable var0) throws IOException {
      byte[] var1 = TlsUtils.getExtensionData(var0, EXT_elliptic_curves);
      return var1 == null ? null : readSupportedEllipticCurvesExtension(var1);
   }

   public static short[] getSupportedPointFormatsExtension(Hashtable var0) throws IOException {
      byte[] var1 = TlsUtils.getExtensionData(var0, EXT_ec_point_formats);
      return var1 == null ? null : readSupportedPointFormatsExtension(var1);
   }

   public static byte[] createSupportedEllipticCurvesExtension(int[] var0) throws IOException {
      if (var0 != null && var0.length >= 1) {
         return TlsUtils.encodeUint16ArrayWithUint16Length(var0);
      } else {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static byte[] createSupportedPointFormatsExtension(short[] var0) throws IOException {
      if (var0 == null || !Arrays.contains((short[])var0, (short)0)) {
         var0 = Arrays.append((short[])var0, (short)0);
      }

      return TlsUtils.encodeUint8ArrayWithUint8Length(var0);
   }

   public static int[] readSupportedEllipticCurvesExtension(byte[] var0) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("'extensionData' cannot be null");
      } else {
         ByteArrayInputStream var1 = new ByteArrayInputStream(var0);
         int var2 = TlsUtils.readUint16(var1);
         if (var2 >= 2 && (var2 & 1) == 0) {
            int[] var3 = TlsUtils.readUint16Array(var2 / 2, var1);
            TlsProtocol.assertEmpty(var1);
            return var3;
         } else {
            throw new TlsFatalAlert((short)50);
         }
      }
   }

   public static short[] readSupportedPointFormatsExtension(byte[] var0) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("'extensionData' cannot be null");
      } else {
         ByteArrayInputStream var1 = new ByteArrayInputStream(var0);
         short var2 = TlsUtils.readUint8(var1);
         if (var2 < 1) {
            throw new TlsFatalAlert((short)50);
         } else {
            short[] var3 = TlsUtils.readUint8Array(var2, var1);
            TlsProtocol.assertEmpty(var1);
            if (!Arrays.contains((short[])var3, (short)0)) {
               throw new TlsFatalAlert((short)47);
            } else {
               return var3;
            }
         }
      }
   }

   public static boolean containsECCipherSuites(int[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         if (isECCipherSuite(var0[var1])) {
            return true;
         }
      }

      return false;
   }

   public static int getMinimumCurveBits(int var0) {
      switch(var0) {
      case 65024:
      case 65026:
      case 65028:
         return 255;
      case 65025:
      case 65027:
      case 65029:
         return 384;
      default:
         return !isECCipherSuite(var0) ? 0 : 1;
      }
   }

   public static boolean isECCipherSuite(int var0) {
      switch(TlsUtils.getKeyExchangeAlgorithm(var0)) {
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 24:
         return true;
      case 21:
      case 22:
      case 23:
      default:
         return false;
      }
   }

   public static short getCompressionFormat(int var0) throws IOException {
      if (NamedCurve.isPrime(var0)) {
         return 1;
      } else if (NamedCurve.isChar2(var0)) {
         return 2;
      } else {
         throw new TlsFatalAlert((short)47);
      }
   }

   public static boolean isCompressionPreferred(short[] var0, int var1) throws IOException {
      return isCompressionPreferred(var0, getCompressionFormat(var1));
   }

   public static boolean isCompressionPreferred(short[] var0, short var1) {
      if (var0 != null && var1 != 0) {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            short var3 = var0[var2];
            if (var3 == 0) {
               return false;
            }

            if (var3 == var1) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static void checkPointEncoding(short[] var0, int var1, byte[] var2) throws IOException {
      if (var2 != null && var2.length >= 1) {
         short var3 = getActualFormat(var1, var2);
         checkActualFormat(var0, var3);
      } else {
         throw new TlsFatalAlert((short)47);
      }
   }

   public static void checkActualFormat(short[] var0, short var1) throws IOException {
      if (var1 != 0 && (var0 == null || !Arrays.contains(var0, var1))) {
         throw new TlsFatalAlert((short)47);
      }
   }

   public static short getActualFormat(int var0, byte[] var1) throws IOException {
      switch(var1[0]) {
      case 0:
      case 1:
      case 5:
      case 6:
      case 7:
      default:
         throw new TlsFatalAlert((short)47);
      case 2:
      case 3:
         return getCompressionFormat(var0);
      case 4:
         return 0;
      }
   }

   public static TlsECConfig readECConfig(short[] var0, InputStream var1) throws IOException {
      short var2 = TlsUtils.readUint8(var1);
      if (var2 != 3) {
         throw new TlsFatalAlert((short)40);
      } else {
         int var3 = TlsUtils.readUint16(var1);
         if (!NamedCurve.refersToASpecificNamedCurve(var3)) {
            throw new TlsFatalAlert((short)47);
         } else {
            boolean var4 = isCompressionPreferred(var0, var3);
            TlsECConfig var5 = new TlsECConfig();
            var5.setNamedCurve(var3);
            var5.setPointCompression(var4);
            return var5;
         }
      }
   }

   public static TlsECConfig receiveECConfig(TlsECConfigVerifier var0, short[] var1, InputStream var2) throws IOException {
      TlsECConfig var3 = readECConfig(var1, var2);
      if (!var0.accept(var3)) {
         throw new TlsFatalAlert((short)47);
      } else {
         return var3;
      }
   }

   public static void writeECConfig(TlsECConfig var0, OutputStream var1) throws IOException {
      writeNamedECParameters(var0.getNamedCurve(), var1);
   }

   public static void writeNamedECParameters(int var0, OutputStream var1) throws IOException {
      if (!NamedCurve.refersToASpecificNamedCurve(var0)) {
         throw new TlsFatalAlert((short)80);
      } else {
         TlsUtils.writeUint8((short)3, var1);
         TlsUtils.checkUint16(var0);
         TlsUtils.writeUint16(var0, var1);
      }
   }
}
