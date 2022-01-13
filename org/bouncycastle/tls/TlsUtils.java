package org.bouncycastle.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.TlsHash;
import org.bouncycastle.tls.crypto.TlsSecret;
import org.bouncycastle.tls.crypto.TlsStreamSigner;
import org.bouncycastle.tls.crypto.TlsStreamVerifier;
import org.bouncycastle.tls.crypto.TlsVerifier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class TlsUtils {
   public static final byte[] EMPTY_BYTES = new byte[0];
   public static final short[] EMPTY_SHORTS = new short[0];
   public static final int[] EMPTY_INTS = new int[0];
   public static final long[] EMPTY_LONGS = new long[0];
   public static final Integer EXT_signature_algorithms = Integers.valueOf(13);
   protected static short MINIMUM_HASH_STRICT = 2;
   protected static short MINIMUM_HASH_PREFERRED = 4;
   static final byte[] SSL_CLIENT = new byte[]{67, 76, 78, 84};
   static final byte[] SSL_SERVER = new byte[]{83, 82, 86, 82};

   public static void checkUint8(short var0) throws IOException {
      if (!isValidUint8(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint8(int var0) throws IOException {
      if (!isValidUint8(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint8(long var0) throws IOException {
      if (!isValidUint8(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint16(int var0) throws IOException {
      if (!isValidUint16(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint16(long var0) throws IOException {
      if (!isValidUint16(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint24(int var0) throws IOException {
      if (!isValidUint24(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint24(long var0) throws IOException {
      if (!isValidUint24(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint32(long var0) throws IOException {
      if (!isValidUint32(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint48(long var0) throws IOException {
      if (!isValidUint48(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static void checkUint64(long var0) throws IOException {
      if (!isValidUint64(var0)) {
         throw new TlsFatalAlert((short)80);
      }
   }

   public static boolean isValidUint8(short var0) {
      return (var0 & 255) == var0;
   }

   public static boolean isValidUint8(int var0) {
      return (var0 & 255) == var0;
   }

   public static boolean isValidUint8(long var0) {
      return (var0 & 255L) == var0;
   }

   public static boolean isValidUint16(int var0) {
      return (var0 & '\uffff') == var0;
   }

   public static boolean isValidUint16(long var0) {
      return (var0 & 65535L) == var0;
   }

   public static boolean isValidUint24(int var0) {
      return (var0 & 16777215) == var0;
   }

   public static boolean isValidUint24(long var0) {
      return (var0 & 16777215L) == var0;
   }

   public static boolean isValidUint32(long var0) {
      return (var0 & 4294967295L) == var0;
   }

   public static boolean isValidUint48(long var0) {
      return (var0 & 281474976710655L) == var0;
   }

   public static boolean isValidUint64(long var0) {
      return true;
   }

   public static boolean isSSL(TlsContext var0) {
      return var0.getServerVersion().isSSL();
   }

   public static boolean isTLSv11(ProtocolVersion var0) {
      return ProtocolVersion.TLSv11.isEqualOrEarlierVersionOf(var0.getEquivalentTLSVersion());
   }

   public static boolean isTLSv11(TlsContext var0) {
      return isTLSv11(var0.getServerVersion());
   }

   public static boolean isTLSv12(ProtocolVersion var0) {
      return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(var0.getEquivalentTLSVersion());
   }

   public static boolean isTLSv12(TlsContext var0) {
      return isTLSv12(var0.getServerVersion());
   }

   public static void writeUint8(short var0, OutputStream var1) throws IOException {
      var1.write(var0);
   }

   public static void writeUint8(int var0, OutputStream var1) throws IOException {
      var1.write(var0);
   }

   public static void writeUint8(short var0, byte[] var1, int var2) {
      var1[var2] = (byte)var0;
   }

   public static void writeUint8(int var0, byte[] var1, int var2) {
      var1[var2] = (byte)var0;
   }

   public static void writeUint16(int var0, OutputStream var1) throws IOException {
      var1.write(var0 >>> 8);
      var1.write(var0);
   }

   public static void writeUint16(int var0, byte[] var1, int var2) {
      var1[var2] = (byte)(var0 >>> 8);
      var1[var2 + 1] = (byte)var0;
   }

   public static void writeUint24(int var0, OutputStream var1) throws IOException {
      var1.write((byte)(var0 >>> 16));
      var1.write((byte)(var0 >>> 8));
      var1.write((byte)var0);
   }

   public static void writeUint24(int var0, byte[] var1, int var2) {
      var1[var2] = (byte)(var0 >>> 16);
      var1[var2 + 1] = (byte)(var0 >>> 8);
      var1[var2 + 2] = (byte)var0;
   }

   public static void writeUint32(long var0, OutputStream var2) throws IOException {
      var2.write((byte)((int)(var0 >>> 24)));
      var2.write((byte)((int)(var0 >>> 16)));
      var2.write((byte)((int)(var0 >>> 8)));
      var2.write((byte)((int)var0));
   }

   public static void writeUint32(long var0, byte[] var2, int var3) {
      var2[var3] = (byte)((int)(var0 >>> 24));
      var2[var3 + 1] = (byte)((int)(var0 >>> 16));
      var2[var3 + 2] = (byte)((int)(var0 >>> 8));
      var2[var3 + 3] = (byte)((int)var0);
   }

   public static void writeUint48(long var0, OutputStream var2) throws IOException {
      var2.write((byte)((int)(var0 >>> 40)));
      var2.write((byte)((int)(var0 >>> 32)));
      var2.write((byte)((int)(var0 >>> 24)));
      var2.write((byte)((int)(var0 >>> 16)));
      var2.write((byte)((int)(var0 >>> 8)));
      var2.write((byte)((int)var0));
   }

   public static void writeUint48(long var0, byte[] var2, int var3) {
      var2[var3] = (byte)((int)(var0 >>> 40));
      var2[var3 + 1] = (byte)((int)(var0 >>> 32));
      var2[var3 + 2] = (byte)((int)(var0 >>> 24));
      var2[var3 + 3] = (byte)((int)(var0 >>> 16));
      var2[var3 + 4] = (byte)((int)(var0 >>> 8));
      var2[var3 + 5] = (byte)((int)var0);
   }

   public static void writeUint64(long var0, OutputStream var2) throws IOException {
      var2.write((byte)((int)(var0 >>> 56)));
      var2.write((byte)((int)(var0 >>> 48)));
      var2.write((byte)((int)(var0 >>> 40)));
      var2.write((byte)((int)(var0 >>> 32)));
      var2.write((byte)((int)(var0 >>> 24)));
      var2.write((byte)((int)(var0 >>> 16)));
      var2.write((byte)((int)(var0 >>> 8)));
      var2.write((byte)((int)var0));
   }

   public static void writeUint64(long var0, byte[] var2, int var3) {
      var2[var3] = (byte)((int)(var0 >>> 56));
      var2[var3 + 1] = (byte)((int)(var0 >>> 48));
      var2[var3 + 2] = (byte)((int)(var0 >>> 40));
      var2[var3 + 3] = (byte)((int)(var0 >>> 32));
      var2[var3 + 4] = (byte)((int)(var0 >>> 24));
      var2[var3 + 5] = (byte)((int)(var0 >>> 16));
      var2[var3 + 6] = (byte)((int)(var0 >>> 8));
      var2[var3 + 7] = (byte)((int)var0);
   }

   public static void writeOpaque8(byte[] var0, OutputStream var1) throws IOException {
      checkUint8(var0.length);
      writeUint8(var0.length, var1);
      var1.write(var0);
   }

   public static void writeOpaque16(byte[] var0, OutputStream var1) throws IOException {
      checkUint16(var0.length);
      writeUint16(var0.length, var1);
      var1.write(var0);
   }

   public static void writeOpaque24(byte[] var0, OutputStream var1) throws IOException {
      checkUint24(var0.length);
      writeUint24(var0.length, var1);
      var1.write(var0);
   }

   public static void writeUint8Array(short[] var0, OutputStream var1) throws IOException {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         writeUint8(var0[var2], var1);
      }

   }

   public static void writeUint8Array(short[] var0, byte[] var1, int var2) throws IOException {
      for(int var3 = 0; var3 < var0.length; ++var3) {
         writeUint8(var0[var3], var1, var2);
         ++var2;
      }

   }

   public static void writeUint8ArrayWithUint8Length(short[] var0, OutputStream var1) throws IOException {
      checkUint8(var0.length);
      writeUint8(var0.length, var1);
      writeUint8Array(var0, var1);
   }

   public static void writeUint8ArrayWithUint8Length(short[] var0, byte[] var1, int var2) throws IOException {
      checkUint8(var0.length);
      writeUint8(var0.length, var1, var2);
      writeUint8Array(var0, var1, var2 + 1);
   }

   public static void writeUint16Array(int[] var0, OutputStream var1) throws IOException {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         writeUint16(var0[var2], var1);
      }

   }

   public static void writeUint16Array(int[] var0, byte[] var1, int var2) throws IOException {
      for(int var3 = 0; var3 < var0.length; ++var3) {
         writeUint16(var0[var3], var1, var2);
         var2 += 2;
      }

   }

   public static void writeUint16ArrayWithUint16Length(int[] var0, OutputStream var1) throws IOException {
      int var2 = 2 * var0.length;
      checkUint16(var2);
      writeUint16(var2, var1);
      writeUint16Array(var0, var1);
   }

   public static void writeUint16ArrayWithUint16Length(int[] var0, byte[] var1, int var2) throws IOException {
      int var3 = 2 * var0.length;
      checkUint16(var3);
      writeUint16(var3, var1, var2);
      writeUint16Array(var0, var1, var2 + 2);
   }

   public static byte[] encodeOpaque8(byte[] var0) throws IOException {
      checkUint8(var0.length);
      return Arrays.prepend(var0, (byte)var0.length);
   }

   public static byte[] encodeUint8ArrayWithUint8Length(short[] var0) throws IOException {
      byte[] var1 = new byte[1 + var0.length];
      writeUint8ArrayWithUint8Length(var0, var1, 0);
      return var1;
   }

   public static byte[] encodeUint16ArrayWithUint16Length(int[] var0) throws IOException {
      int var1 = 2 * var0.length;
      byte[] var2 = new byte[2 + var1];
      writeUint16ArrayWithUint16Length(var0, var2, 0);
      return var2;
   }

   public static short readUint8(InputStream var0) throws IOException {
      int var1 = var0.read();
      if (var1 < 0) {
         throw new EOFException();
      } else {
         return (short)var1;
      }
   }

   public static short readUint8(byte[] var0, int var1) {
      return (short)(var0[var1] & 255);
   }

   public static int readUint16(InputStream var0) throws IOException {
      int var1 = var0.read();
      int var2 = var0.read();
      if (var2 < 0) {
         throw new EOFException();
      } else {
         return var1 << 8 | var2;
      }
   }

   public static int readUint16(byte[] var0, int var1) {
      int var2 = (var0[var1] & 255) << 8;
      ++var1;
      var2 |= var0[var1] & 255;
      return var2;
   }

   public static int readUint24(InputStream var0) throws IOException {
      int var1 = var0.read();
      int var2 = var0.read();
      int var3 = var0.read();
      if (var3 < 0) {
         throw new EOFException();
      } else {
         return var1 << 16 | var2 << 8 | var3;
      }
   }

   public static int readUint24(byte[] var0, int var1) {
      int var2 = (var0[var1] & 255) << 16;
      ++var1;
      var2 |= (var0[var1] & 255) << 8;
      ++var1;
      var2 |= var0[var1] & 255;
      return var2;
   }

   public static long readUint32(InputStream var0) throws IOException {
      int var1 = var0.read();
      int var2 = var0.read();
      int var3 = var0.read();
      int var4 = var0.read();
      if (var4 < 0) {
         throw new EOFException();
      } else {
         return (long)(var1 << 24 | var2 << 16 | var3 << 8 | var4) & 4294967295L;
      }
   }

   public static long readUint32(byte[] var0, int var1) {
      int var2 = (var0[var1] & 255) << 24;
      ++var1;
      var2 |= (var0[var1] & 255) << 16;
      ++var1;
      var2 |= (var0[var1] & 255) << 8;
      ++var1;
      var2 |= var0[var1] & 255;
      return (long)var2 & 4294967295L;
   }

   public static long readUint48(InputStream var0) throws IOException {
      int var1 = readUint24(var0);
      int var2 = readUint24(var0);
      return ((long)var1 & 4294967295L) << 24 | (long)var2 & 4294967295L;
   }

   public static long readUint48(byte[] var0, int var1) {
      int var2 = readUint24(var0, var1);
      int var3 = readUint24(var0, var1 + 3);
      return ((long)var2 & 4294967295L) << 24 | (long)var3 & 4294967295L;
   }

   public static byte[] readAllOrNothing(int var0, InputStream var1) throws IOException {
      if (var0 < 1) {
         return EMPTY_BYTES;
      } else {
         byte[] var2 = new byte[var0];
         int var3 = Streams.readFully(var1, var2);
         if (var3 == 0) {
            return null;
         } else if (var3 != var0) {
            throw new EOFException();
         } else {
            return var2;
         }
      }
   }

   public static byte[] readFully(int var0, InputStream var1) throws IOException {
      if (var0 < 1) {
         return EMPTY_BYTES;
      } else {
         byte[] var2 = new byte[var0];
         if (var0 != Streams.readFully(var1, var2)) {
            throw new EOFException();
         } else {
            return var2;
         }
      }
   }

   public static void readFully(byte[] var0, InputStream var1) throws IOException {
      int var2 = var0.length;
      if (var2 > 0 && var2 != Streams.readFully(var1, var0)) {
         throw new EOFException();
      }
   }

   public static byte[] readOpaque8(InputStream var0) throws IOException {
      short var1 = readUint8(var0);
      return readFully(var1, var0);
   }

   public static byte[] readOpaque16(InputStream var0) throws IOException {
      int var1 = readUint16(var0);
      return readFully(var1, var0);
   }

   public static byte[] readOpaque24(InputStream var0) throws IOException {
      int var1 = readUint24(var0);
      return readFully(var1, var0);
   }

   public static short[] readUint8Array(int var0, InputStream var1) throws IOException {
      short[] var2 = new short[var0];

      for(int var3 = 0; var3 < var0; ++var3) {
         var2[var3] = readUint8(var1);
      }

      return var2;
   }

   public static int[] readUint16Array(int var0, InputStream var1) throws IOException {
      int[] var2 = new int[var0];

      for(int var3 = 0; var3 < var0; ++var3) {
         var2[var3] = readUint16(var1);
      }

      return var2;
   }

   public static ProtocolVersion readVersion(byte[] var0, int var1) throws IOException {
      return ProtocolVersion.get(var0[var1] & 255, var0[var1 + 1] & 255);
   }

   public static ProtocolVersion readVersion(InputStream var0) throws IOException {
      int var1 = var0.read();
      int var2 = var0.read();
      if (var2 < 0) {
         throw new EOFException();
      } else {
         return ProtocolVersion.get(var1, var2);
      }
   }

   public static int readVersionRaw(byte[] var0, int var1) throws IOException {
      return var0[var1] << 8 | var0[var1 + 1];
   }

   public static int readVersionRaw(InputStream var0) throws IOException {
      int var1 = var0.read();
      int var2 = var0.read();
      if (var2 < 0) {
         throw new EOFException();
      } else {
         return var1 << 8 | var2;
      }
   }

   public static ASN1Primitive readASN1Object(byte[] var0) throws IOException {
      ASN1InputStream var1 = new ASN1InputStream(var0);
      ASN1Primitive var2 = var1.readObject();
      if (null == var2) {
         throw new TlsFatalAlert((short)50);
      } else if (null != var1.readObject()) {
         throw new TlsFatalAlert((short)50);
      } else {
         return var2;
      }
   }

   public static ASN1Primitive readDERObject(byte[] var0) throws IOException {
      ASN1Primitive var1 = readASN1Object(var0);
      byte[] var2 = var1.getEncoded("DER");
      if (!Arrays.areEqual(var2, var0)) {
         throw new TlsFatalAlert((short)50);
      } else {
         return var1;
      }
   }

   public static void writeGMTUnixTime(byte[] var0, int var1) {
      int var2 = (int)(System.currentTimeMillis() / 1000L);
      var0[var1] = (byte)(var2 >>> 24);
      var0[var1 + 1] = (byte)(var2 >>> 16);
      var0[var1 + 2] = (byte)(var2 >>> 8);
      var0[var1 + 3] = (byte)var2;
   }

   public static void writeVersion(ProtocolVersion var0, OutputStream var1) throws IOException {
      var1.write(var0.getMajorVersion());
      var1.write(var0.getMinorVersion());
   }

   public static void writeVersion(ProtocolVersion var0, byte[] var1, int var2) {
      var1[var2] = (byte)var0.getMajorVersion();
      var1[var2 + 1] = (byte)var0.getMinorVersion();
   }

   public static Vector getAllSignatureAlgorithms() {
      Vector var0 = new Vector(4);
      var0.addElement(Short.valueOf((short)0));
      var0.addElement(Short.valueOf((short)1));
      var0.addElement(Short.valueOf((short)2));
      var0.addElement(Short.valueOf((short)3));
      return var0;
   }

   public static Vector getDefaultDSSSignatureAlgorithms() {
      return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)2));
   }

   public static Vector getDefaultECDSASignatureAlgorithms() {
      return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)3));
   }

   public static Vector getDefaultRSASignatureAlgorithms() {
      return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)1));
   }

   public static Vector getDefaultSignatureAlgorithms(short var0) {
      switch(var0) {
      case 1:
         return getDefaultRSASignatureAlgorithms();
      case 2:
         return getDefaultDSSSignatureAlgorithms();
      case 3:
         return getDefaultECDSASignatureAlgorithms();
      default:
         throw new IllegalArgumentException("unknown SignatureAlgorithm");
      }
   }

   public static Vector getDefaultSupportedSignatureAlgorithms(TlsContext var0) {
      TlsCrypto var1 = var0.getCrypto();
      short[] var2 = new short[]{2, 3, 4, 5, 6};
      short[] var3 = new short[]{1, 2, 3};
      Vector var4 = new Vector();

      for(int var5 = 0; var5 < var3.length; ++var5) {
         for(int var6 = 0; var6 < var2.length; ++var6) {
            SignatureAndHashAlgorithm var7 = new SignatureAndHashAlgorithm(var2[var6], var3[var5]);
            if (var1.hasSignatureAndHashAlgorithm(var7)) {
               var4.addElement(var7);
            }
         }
      }

      return var4;
   }

   public static SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(TlsContext var0, TlsCredentialedSigner var1) throws IOException {
      SignatureAndHashAlgorithm var2 = null;
      if (isTLSv12(var0)) {
         var2 = var1.getSignatureAndHashAlgorithm();
         if (var2 == null) {
            throw new TlsFatalAlert((short)80);
         }
      }

      return var2;
   }

   public static byte[] getExtensionData(Hashtable var0, Integer var1) {
      return var0 == null ? null : (byte[])((byte[])var0.get(var1));
   }

   public static boolean hasExpectedEmptyExtensionData(Hashtable var0, Integer var1, short var2) throws IOException {
      byte[] var3 = getExtensionData(var0, var1);
      if (var3 == null) {
         return false;
      } else if (var3.length != 0) {
         throw new TlsFatalAlert(var2);
      } else {
         return true;
      }
   }

   public static TlsSession importSession(byte[] var0, SessionParameters var1) {
      return new TlsSessionImpl(var0, var1);
   }

   public static boolean isSignatureAlgorithmsExtensionAllowed(ProtocolVersion var0) {
      return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(var0.getEquivalentTLSVersion());
   }

   public static void addSignatureAlgorithmsExtension(Hashtable var0, Vector var1) throws IOException {
      var0.put(EXT_signature_algorithms, createSignatureAlgorithmsExtension(var1));
   }

   public static short getSignatureAlgorithm(int var0) {
      switch(var0) {
      case 3:
      case 4:
      case 7:
      case 8:
      case 22:
         return 2;
      case 5:
      case 6:
      case 9:
      case 10:
      case 18:
      case 19:
      case 23:
         return 1;
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 20:
      case 21:
      default:
         return -1;
      case 16:
      case 17:
         return 3;
      }
   }

   public static short getSignatureAlgorithmClient(short var0) {
      switch(var0) {
      case 1:
         return 1;
      case 2:
         return 2;
      case 64:
         return 3;
      default:
         return -1;
      }
   }

   public static Vector getSignatureAlgorithmsExtension(Hashtable var0) throws IOException {
      byte[] var1 = getExtensionData(var0, EXT_signature_algorithms);
      return var1 == null ? null : readSignatureAlgorithmsExtension(var1);
   }

   public static byte[] createSignatureAlgorithmsExtension(Vector var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      encodeSupportedSignatureAlgorithms(var0, false, var1);
      return var1.toByteArray();
   }

   public static Vector readSignatureAlgorithmsExtension(byte[] var0) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("'extensionData' cannot be null");
      } else {
         ByteArrayInputStream var1 = new ByteArrayInputStream(var0);
         Vector var2 = parseSupportedSignatureAlgorithms(false, var1);
         TlsProtocol.assertEmpty(var1);
         return var2;
      }
   }

   public static void encodeSupportedSignatureAlgorithms(Vector var0, boolean var1, OutputStream var2) throws IOException {
      if (var0 != null && var0.size() >= 1 && var0.size() < 32768) {
         int var3 = 2 * var0.size();
         checkUint16(var3);
         writeUint16(var3, var2);

         for(int var4 = 0; var4 < var0.size(); ++var4) {
            SignatureAndHashAlgorithm var5 = (SignatureAndHashAlgorithm)var0.elementAt(var4);
            if (!var1 && var5.getSignature() == 0) {
               throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
            }

            var5.encode(var2);
         }

      } else {
         throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
      }
   }

   public static Vector parseSupportedSignatureAlgorithms(boolean var0, InputStream var1) throws IOException {
      int var2 = readUint16(var1);
      if (var2 >= 2 && (var2 & 1) == 0) {
         int var3 = var2 / 2;
         Vector var4 = new Vector(var3);

         for(int var5 = 0; var5 < var3; ++var5) {
            SignatureAndHashAlgorithm var6 = SignatureAndHashAlgorithm.parse(var1);
            if (!var0 && var6.getSignature() == 0) {
               throw new TlsFatalAlert((short)47);
            }

            var4.addElement(var6);
         }

         return var4;
      } else {
         throw new TlsFatalAlert((short)50);
      }
   }

   public static void verifySupportedSignatureAlgorithm(Vector var0, SignatureAndHashAlgorithm var1) throws IOException {
      if (var0 != null && var0.size() >= 1 && var0.size() < 32768) {
         if (var1 == null) {
            throw new IllegalArgumentException("'signatureAlgorithm' cannot be null");
         } else {
            if (var1.getSignature() != 0) {
               for(int var2 = 0; var2 < var0.size(); ++var2) {
                  SignatureAndHashAlgorithm var3 = (SignatureAndHashAlgorithm)var0.elementAt(var2);
                  if (var3.getHash() == var1.getHash() && var3.getSignature() == var1.getSignature()) {
                     return;
                  }
               }
            }

            throw new TlsFatalAlert((short)47);
         }
      } else {
         throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
      }
   }

   public static TlsSecret PRF(TlsContext var0, TlsSecret var1, String var2, byte[] var3, int var4) {
      ProtocolVersion var5 = var0.getServerVersion();
      if (var5.isSSL()) {
         throw new IllegalStateException("No PRF available for SSLv3 session");
      } else {
         byte[] var6 = Strings.toByteArray(var2);
         byte[] var7 = concat(var6, var3);
         int var8 = var0.getSecurityParameters().getPrfAlgorithm();
         return var1.deriveUsingPRF(var8, var7, var4);
      }
   }

   static byte[] concat(byte[] var0, byte[] var1) {
      byte[] var2 = new byte[var0.length + var1.length];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      System.arraycopy(var1, 0, var2, var0.length, var1.length);
      return var2;
   }

   static TlsSecret calculateMasterSecret(TlsContext var0, TlsSecret var1) {
      SecurityParameters var2 = var0.getSecurityParameters();
      byte[] var3;
      if (var2.isExtendedMasterSecret()) {
         var3 = var2.getSessionHash();
      } else {
         var3 = concat(var2.getClientRandom(), var2.getServerRandom());
      }

      if (isSSL(var0)) {
         return var1.deriveSSLMasterSecret(var3);
      } else {
         String var4 = var2.isExtendedMasterSecret() ? "extended master secret" : "master secret";
         return PRF(var0, var1, var4, var3, 48);
      }
   }

   static byte[] calculateTLSVerifyData(TlsContext var0, TlsHandshakeHash var1, boolean var2) {
      String var3 = var2 ? "server finished" : "client finished";
      byte[] var4 = getCurrentPRFHash(var1);
      return calculateTLSVerifyData(var0, var3, var4);
   }

   static byte[] calculateTLSVerifyData(TlsContext var0, String var1, byte[] var2) {
      SecurityParameters var3 = var0.getSecurityParameters();
      TlsSecret var4 = var3.getMasterSecret();
      int var5 = var3.getVerifyDataLength();
      return PRF(var0, var4, var1, var2, var5).extract();
   }

   public static short getHashAlgorithmForPRFAlgorithm(int var0) {
      switch(var0) {
      case 0:
         throw new IllegalArgumentException("legacy PRF not a valid algorithm");
      case 1:
         return 4;
      case 2:
         return 5;
      default:
         throw new IllegalArgumentException("unknown PRFAlgorithm");
      }
   }

   public static ASN1ObjectIdentifier getOIDForHashAlgorithm(short var0) {
      switch(var0) {
      case 1:
         return PKCSObjectIdentifiers.md5;
      case 2:
         return X509ObjectIdentifiers.id_SHA1;
      case 3:
         return NISTObjectIdentifiers.id_sha224;
      case 4:
         return NISTObjectIdentifiers.id_sha256;
      case 5:
         return NISTObjectIdentifiers.id_sha384;
      case 6:
         return NISTObjectIdentifiers.id_sha512;
      default:
         throw new IllegalArgumentException("unknown HashAlgorithm");
      }
   }

   static byte[] calculateSignatureHash(TlsContext var0, SignatureAndHashAlgorithm var1, DigestInputBuffer var2) {
      TlsHash var3 = var0.getCrypto().createHash(var1);
      SecurityParameters var4 = var0.getSecurityParameters();
      var3.update(var4.clientRandom, 0, var4.clientRandom.length);
      var3.update(var4.serverRandom, 0, var4.serverRandom.length);
      var2.updateDigest(var3);
      return var3.calculateHash();
   }

   static void sendSignatureInput(TlsContext var0, DigestInputBuffer var1, OutputStream var2) throws IOException {
      SecurityParameters var3 = var0.getSecurityParameters();
      var2.write(Arrays.concatenate(var3.clientRandom, var3.serverRandom));
      var1.copyTo(var2);
      var2.close();
   }

   static DigitallySigned generateCertificateVerify(TlsContext var0, TlsCredentialedSigner var1, TlsStreamSigner var2, TlsHandshakeHash var3) throws IOException {
      SignatureAndHashAlgorithm var4 = getSignatureAndHashAlgorithm(var0, var1);
      byte[] var5;
      if (var2 != null) {
         var3.copyBufferTo(var2.getOutputStream());
         var5 = var2.getSignature();
      } else {
         byte[] var6;
         if (var4 == null) {
            var6 = var0.getSecurityParameters().getSessionHash();
         } else {
            var6 = var3.getFinalHash(var4.getHash());
         }

         var5 = var1.generateRawSignature(var6);
      }

      return new DigitallySigned(var4, var5);
   }

   static void verifyCertificateVerify(TlsContext var0, CertificateRequest var1, Certificate var2, short var3, DigitallySigned var4, TlsHandshakeHash var5) throws IOException {
      try {
         TlsVerifier var6 = var2.getCertificateAt(0).createVerifier(getSignatureAlgorithmClient(var3));
         TlsStreamVerifier var7 = var6.getStreamVerifier(var4);
         boolean var8;
         if (var7 != null) {
            var5.copyBufferTo(var7.getOutputStream());
            var8 = var7.isVerified();
         } else {
            SignatureAndHashAlgorithm var9 = var4.getAlgorithm();
            byte[] var10;
            if (isTLSv12(var0)) {
               verifySupportedSignatureAlgorithm(var1.getSupportedSignatureAlgorithms(), var9);
               var10 = var5.getFinalHash(var9.getHash());
            } else {
               var10 = var0.getSecurityParameters().getSessionHash();
            }

            var8 = var6.verifyRawSignature(var4, var10);
         }

         if (!var8) {
            throw new TlsFatalAlert((short)51);
         }
      } catch (TlsFatalAlert var11) {
         throw var11;
      } catch (Exception var12) {
         throw new TlsFatalAlert((short)51, var12);
      }
   }

   static DigitallySigned generateServerKeyExchangeSignature(TlsContext var0, TlsCredentialedSigner var1, DigestInputBuffer var2) throws IOException {
      SignatureAndHashAlgorithm var3 = getSignatureAndHashAlgorithm(var0, var1);
      TlsStreamSigner var4 = var1.getStreamSigner();
      byte[] var5;
      if (var4 != null) {
         sendSignatureInput(var0, var2, var4.getOutputStream());
         var5 = var4.getSignature();
      } else {
         byte[] var6 = calculateSignatureHash(var0, var3, var2);
         var5 = var1.generateRawSignature(var6);
      }

      return new DigitallySigned(var3, var5);
   }

   static void verifyServerKeyExchangeSignature(TlsContext var0, TlsVerifier var1, DigestInputBuffer var2, DigitallySigned var3) throws IOException {
      TlsStreamVerifier var4 = var1.getStreamVerifier(var3);
      boolean var5;
      if (var4 != null) {
         sendSignatureInput(var0, var2, var4.getOutputStream());
         var5 = var4.isVerified();
      } else {
         byte[] var6 = calculateSignatureHash(var0, var3.getAlgorithm(), var2);
         var5 = var1.verifyRawSignature(var3, var6);
      }

      if (!var5) {
         throw new TlsFatalAlert((short)51);
      }
   }

   static void trackHashAlgorithms(TlsHandshakeHash var0, Vector var1) {
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            SignatureAndHashAlgorithm var3 = (SignatureAndHashAlgorithm)var1.elementAt(var2);
            short var4 = var3.getHash();
            if (!HashAlgorithm.isPrivate(var4)) {
               var0.trackHashAlgorithm(var4);
            }
         }
      }

   }

   public static boolean hasSigningCapability(short var0) {
      switch(var0) {
      case 1:
      case 2:
      case 64:
         return true;
      default:
         return false;
      }
   }

   private static Vector vectorOfOne(Object var0) {
      Vector var1 = new Vector(1);
      var1.addElement(var0);
      return var1;
   }

   public static int getCipherType(int var0) {
      switch(getEncryptionAlgorithm(var0)) {
      case 0:
      case 1:
      case 2:
         return 0;
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 12:
      case 13:
      case 14:
      case 22:
      case 23:
         return 1;
      case 10:
      case 11:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 24:
      case 25:
      case 103:
      case 104:
         return 2;
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
         return -1;
      }
   }

   public static int getEncryptionAlgorithm(int var0) {
      switch(var0) {
      case 1:
         return 0;
      case 2:
      case 44:
      case 45:
      case 46:
      case 49153:
      case 49158:
      case 49163:
      case 49168:
      case 49173:
      case 49209:
         return 0;
      case 4:
      case 24:
         return 2;
      case 5:
      case 138:
      case 142:
      case 146:
      case 49154:
      case 49159:
      case 49164:
      case 49169:
      case 49174:
      case 49203:
         return 2;
      case 10:
      case 13:
      case 16:
      case 19:
      case 22:
      case 27:
      case 139:
      case 143:
      case 147:
      case 49155:
      case 49160:
      case 49165:
      case 49170:
      case 49175:
      case 49178:
      case 49179:
      case 49180:
      case 49204:
         return 7;
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 60:
      case 62:
      case 63:
      case 64:
      case 103:
      case 108:
      case 140:
      case 144:
      case 148:
      case 174:
      case 178:
      case 182:
      case 49156:
      case 49161:
      case 49166:
      case 49171:
      case 49176:
      case 49181:
      case 49182:
      case 49183:
      case 49187:
      case 49189:
      case 49191:
      case 49193:
      case 49205:
      case 49207:
         return 8;
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 61:
      case 104:
      case 105:
      case 106:
      case 107:
      case 109:
      case 141:
      case 145:
      case 149:
      case 175:
      case 179:
      case 183:
      case 49157:
      case 49162:
      case 49167:
      case 49172:
      case 49177:
      case 49184:
      case 49185:
      case 49186:
      case 49188:
      case 49190:
      case 49192:
      case 49194:
      case 49206:
      case 49208:
         return 9;
      case 59:
      case 176:
      case 180:
      case 184:
      case 49210:
         return 0;
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 186:
      case 187:
      case 188:
      case 189:
      case 190:
      case 191:
      case 49266:
      case 49268:
      case 49270:
      case 49272:
      case 49300:
      case 49302:
      case 49304:
      case 49306:
         return 12;
      case 132:
      case 133:
      case 134:
      case 135:
      case 136:
      case 137:
      case 192:
      case 193:
      case 194:
      case 195:
      case 196:
      case 197:
      case 49267:
      case 49269:
      case 49271:
      case 49273:
      case 49301:
      case 49303:
      case 49305:
      case 49307:
         return 13;
      case 150:
      case 151:
      case 152:
      case 153:
      case 154:
      case 155:
         return 14;
      case 156:
      case 158:
      case 160:
      case 162:
      case 164:
      case 166:
      case 168:
      case 170:
      case 172:
      case 49195:
      case 49197:
      case 49199:
      case 49201:
      case 65024:
         return 10;
      case 157:
      case 159:
      case 161:
      case 163:
      case 165:
      case 167:
      case 169:
      case 171:
      case 173:
      case 49196:
      case 49198:
      case 49200:
      case 49202:
      case 65025:
         return 11;
      case 177:
      case 181:
      case 185:
      case 49211:
         return 0;
      case 49212:
      case 49214:
      case 49216:
      case 49218:
      case 49220:
      case 49222:
      case 49224:
      case 49226:
      case 49228:
      case 49230:
      case 49252:
      case 49254:
      case 49256:
      case 49264:
         return 22;
      case 49213:
      case 49215:
      case 49217:
      case 49219:
      case 49221:
      case 49223:
      case 49225:
      case 49227:
      case 49229:
      case 49231:
      case 49253:
      case 49255:
      case 49257:
      case 49265:
         return 23;
      case 49232:
      case 49234:
      case 49236:
      case 49238:
      case 49240:
      case 49242:
      case 49244:
      case 49246:
      case 49248:
      case 49250:
      case 49258:
      case 49260:
      case 49262:
         return 24;
      case 49233:
      case 49235:
      case 49237:
      case 49239:
      case 49241:
      case 49243:
      case 49245:
      case 49247:
      case 49249:
      case 49251:
      case 49259:
      case 49261:
      case 49263:
         return 25;
      case 49274:
      case 49276:
      case 49278:
      case 49280:
      case 49282:
      case 49284:
      case 49286:
      case 49288:
      case 49290:
      case 49292:
      case 49294:
      case 49296:
      case 49298:
         return 19;
      case 49275:
      case 49277:
      case 49279:
      case 49281:
      case 49283:
      case 49285:
      case 49287:
      case 49289:
      case 49291:
      case 49293:
      case 49295:
      case 49297:
      case 49299:
         return 20;
      case 49308:
      case 49310:
      case 49316:
      case 49318:
      case 49324:
      case 65028:
         return 15;
      case 49309:
      case 49311:
      case 49317:
      case 49319:
      case 49325:
      case 65029:
         return 17;
      case 49312:
      case 49314:
      case 49320:
      case 49322:
      case 49326:
      case 65026:
         return 16;
      case 49313:
      case 49315:
      case 49321:
      case 49323:
      case 49327:
      case 65027:
         return 18;
      case 52392:
      case 52393:
      case 52394:
      case 52395:
      case 52396:
      case 52397:
      case 52398:
         return 21;
      case 65280:
      case 65282:
      case 65284:
      case 65296:
      case 65298:
      case 65300:
         return 103;
      case 65281:
      case 65283:
      case 65285:
      case 65297:
      case 65299:
      case 65301:
         return 104;
      default:
         return -1;
      }
   }

   public static int getKeyExchangeAlgorithm(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 4:
      case 5:
      case 10:
      case 47:
      case 53:
      case 59:
      case 60:
      case 61:
      case 65:
      case 132:
      case 150:
      case 156:
      case 157:
      case 186:
      case 192:
      case 49212:
      case 49213:
      case 49232:
      case 49233:
      case 49274:
      case 49275:
      case 49308:
      case 49309:
      case 49312:
      case 49313:
         return 1;
      case 13:
      case 48:
      case 54:
      case 62:
      case 66:
      case 104:
      case 133:
      case 151:
      case 164:
      case 165:
      case 187:
      case 193:
      case 49214:
      case 49215:
      case 49240:
      case 49241:
      case 49282:
      case 49283:
         return 7;
      case 16:
      case 49:
      case 55:
      case 63:
      case 67:
      case 105:
      case 134:
      case 152:
      case 160:
      case 161:
      case 188:
      case 194:
      case 49216:
      case 49217:
      case 49236:
      case 49237:
      case 49278:
      case 49279:
         return 9;
      case 19:
      case 50:
      case 56:
      case 64:
      case 68:
      case 106:
      case 135:
      case 153:
      case 162:
      case 163:
      case 189:
      case 195:
      case 49218:
      case 49219:
      case 49238:
      case 49239:
      case 49280:
      case 49281:
         return 3;
      case 22:
      case 51:
      case 57:
      case 69:
      case 103:
      case 107:
      case 136:
      case 154:
      case 158:
      case 159:
      case 190:
      case 196:
      case 49220:
      case 49221:
      case 49234:
      case 49235:
      case 49276:
      case 49277:
      case 49310:
      case 49311:
      case 49314:
      case 49315:
      case 52394:
      case 65280:
      case 65281:
         return 5;
      case 24:
      case 27:
      case 52:
      case 58:
      case 70:
      case 108:
      case 109:
      case 137:
      case 155:
      case 166:
      case 167:
      case 191:
      case 197:
      case 49222:
      case 49223:
      case 49242:
      case 49243:
      case 49284:
      case 49285:
         return 11;
      case 44:
      case 138:
      case 139:
      case 140:
      case 141:
      case 168:
      case 169:
      case 174:
      case 175:
      case 176:
      case 177:
      case 49252:
      case 49253:
      case 49258:
      case 49259:
      case 49294:
      case 49295:
      case 49300:
      case 49301:
      case 49316:
      case 49317:
      case 49320:
      case 49321:
      case 52395:
      case 65296:
      case 65297:
         return 13;
      case 45:
      case 142:
      case 143:
      case 144:
      case 145:
      case 170:
      case 171:
      case 178:
      case 179:
      case 180:
      case 181:
      case 49254:
      case 49255:
      case 49260:
      case 49261:
      case 49296:
      case 49297:
      case 49302:
      case 49303:
      case 49318:
      case 49319:
      case 49322:
      case 49323:
      case 52397:
      case 65298:
      case 65299:
         return 14;
      case 46:
      case 146:
      case 147:
      case 148:
      case 149:
      case 172:
      case 173:
      case 182:
      case 183:
      case 184:
      case 185:
      case 49256:
      case 49257:
      case 49262:
      case 49263:
      case 49298:
      case 49299:
      case 49304:
      case 49305:
      case 52398:
         return 15;
      case 49153:
      case 49154:
      case 49155:
      case 49156:
      case 49157:
      case 49189:
      case 49190:
      case 49197:
      case 49198:
      case 49226:
      case 49227:
      case 49246:
      case 49247:
      case 49268:
      case 49269:
      case 49288:
      case 49289:
         return 16;
      case 49158:
      case 49159:
      case 49160:
      case 49161:
      case 49162:
      case 49187:
      case 49188:
      case 49195:
      case 49196:
      case 49224:
      case 49225:
      case 49244:
      case 49245:
      case 49266:
      case 49267:
      case 49286:
      case 49287:
      case 49324:
      case 49325:
      case 49326:
      case 49327:
      case 52393:
      case 65284:
      case 65285:
         return 17;
      case 49163:
      case 49164:
      case 49165:
      case 49166:
      case 49167:
      case 49193:
      case 49194:
      case 49201:
      case 49202:
      case 49230:
      case 49231:
      case 49250:
      case 49251:
      case 49272:
      case 49273:
      case 49292:
      case 49293:
         return 18;
      case 49168:
      case 49169:
      case 49170:
      case 49171:
      case 49172:
      case 49191:
      case 49192:
      case 49199:
      case 49200:
      case 49228:
      case 49229:
      case 49248:
      case 49249:
      case 49270:
      case 49271:
      case 49290:
      case 49291:
      case 52392:
      case 65282:
      case 65283:
         return 19;
      case 49173:
      case 49174:
      case 49175:
      case 49176:
      case 49177:
         return 20;
      case 49178:
      case 49181:
      case 49184:
         return 21;
      case 49179:
      case 49182:
      case 49185:
         return 23;
      case 49180:
      case 49183:
      case 49186:
         return 22;
      case 49203:
      case 49204:
      case 49205:
      case 49206:
      case 49207:
      case 49208:
      case 49209:
      case 49210:
      case 49211:
      case 49264:
      case 49265:
      case 49306:
      case 49307:
      case 52396:
      case 65024:
      case 65025:
      case 65026:
      case 65027:
      case 65028:
      case 65029:
      case 65300:
      case 65301:
         return 24;
      default:
         return -1;
      }
   }

   public static int getMACAlgorithm(int var0) {
      switch(var0) {
      case 1:
      case 4:
      case 24:
         return 1;
      case 2:
      case 5:
      case 10:
      case 13:
      case 16:
      case 19:
      case 22:
      case 27:
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
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 132:
      case 133:
      case 134:
      case 135:
      case 136:
      case 137:
      case 138:
      case 139:
      case 140:
      case 141:
      case 142:
      case 143:
      case 144:
      case 145:
      case 146:
      case 147:
      case 148:
      case 149:
      case 150:
      case 151:
      case 152:
      case 153:
      case 154:
      case 155:
      case 49153:
      case 49154:
      case 49155:
      case 49156:
      case 49157:
      case 49158:
      case 49159:
      case 49160:
      case 49161:
      case 49162:
      case 49163:
      case 49164:
      case 49165:
      case 49166:
      case 49167:
      case 49168:
      case 49169:
      case 49170:
      case 49171:
      case 49172:
      case 49173:
      case 49174:
      case 49175:
      case 49176:
      case 49177:
      case 49178:
      case 49179:
      case 49180:
      case 49181:
      case 49182:
      case 49183:
      case 49184:
      case 49185:
      case 49186:
      case 49203:
      case 49204:
      case 49205:
      case 49206:
      case 49209:
         return 2;
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 103:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 174:
      case 176:
      case 178:
      case 180:
      case 182:
      case 184:
      case 186:
      case 187:
      case 188:
      case 189:
      case 190:
      case 191:
      case 192:
      case 193:
      case 194:
      case 195:
      case 196:
      case 197:
      case 49187:
      case 49189:
      case 49191:
      case 49193:
      case 49207:
      case 49210:
      case 49212:
      case 49214:
      case 49216:
      case 49218:
      case 49220:
      case 49222:
      case 49224:
      case 49226:
      case 49228:
      case 49230:
      case 49252:
      case 49254:
      case 49256:
      case 49264:
      case 49266:
      case 49268:
      case 49270:
      case 49272:
      case 49300:
      case 49302:
      case 49304:
      case 49306:
         return 3;
      case 156:
      case 157:
      case 158:
      case 159:
      case 160:
      case 161:
      case 162:
      case 163:
      case 164:
      case 165:
      case 166:
      case 167:
      case 168:
      case 169:
      case 170:
      case 171:
      case 172:
      case 173:
      case 49195:
      case 49196:
      case 49197:
      case 49198:
      case 49199:
      case 49200:
      case 49201:
      case 49202:
      case 49232:
      case 49233:
      case 49234:
      case 49235:
      case 49236:
      case 49237:
      case 49238:
      case 49239:
      case 49240:
      case 49241:
      case 49242:
      case 49243:
      case 49244:
      case 49245:
      case 49246:
      case 49247:
      case 49248:
      case 49249:
      case 49250:
      case 49251:
      case 49258:
      case 49259:
      case 49260:
      case 49261:
      case 49262:
      case 49263:
      case 49274:
      case 49275:
      case 49276:
      case 49277:
      case 49278:
      case 49279:
      case 49280:
      case 49281:
      case 49282:
      case 49283:
      case 49284:
      case 49285:
      case 49286:
      case 49287:
      case 49288:
      case 49289:
      case 49290:
      case 49291:
      case 49292:
      case 49293:
      case 49294:
      case 49295:
      case 49296:
      case 49297:
      case 49298:
      case 49299:
      case 49308:
      case 49309:
      case 49310:
      case 49311:
      case 49312:
      case 49313:
      case 49314:
      case 49315:
      case 49316:
      case 49317:
      case 49318:
      case 49319:
      case 49320:
      case 49321:
      case 49322:
      case 49323:
      case 49324:
      case 49325:
      case 49326:
      case 49327:
      case 52392:
      case 52393:
      case 52394:
      case 52395:
      case 52396:
      case 52397:
      case 52398:
      case 65024:
      case 65025:
      case 65026:
      case 65027:
      case 65028:
      case 65029:
      case 65280:
      case 65281:
      case 65282:
      case 65283:
      case 65284:
      case 65285:
      case 65296:
      case 65297:
      case 65298:
      case 65299:
      case 65300:
      case 65301:
         return 0;
      case 175:
      case 177:
      case 179:
      case 181:
      case 183:
      case 185:
      case 49188:
      case 49190:
      case 49192:
      case 49194:
      case 49208:
      case 49211:
      case 49213:
      case 49215:
      case 49217:
      case 49219:
      case 49221:
      case 49223:
      case 49225:
      case 49227:
      case 49229:
      case 49231:
      case 49253:
      case 49255:
      case 49257:
      case 49265:
      case 49267:
      case 49269:
      case 49271:
      case 49273:
      case 49301:
      case 49303:
      case 49305:
      case 49307:
         return 4;
      default:
         return -1;
      }
   }

   public static ProtocolVersion getMinimumVersion(int var0) {
      switch(var0) {
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 103:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 156:
      case 157:
      case 158:
      case 159:
      case 160:
      case 161:
      case 162:
      case 163:
      case 164:
      case 165:
      case 166:
      case 167:
      case 168:
      case 169:
      case 170:
      case 171:
      case 172:
      case 173:
      case 186:
      case 187:
      case 188:
      case 189:
      case 190:
      case 191:
      case 192:
      case 193:
      case 194:
      case 195:
      case 196:
      case 197:
      case 49187:
      case 49188:
      case 49189:
      case 49190:
      case 49191:
      case 49192:
      case 49193:
      case 49194:
      case 49195:
      case 49196:
      case 49197:
      case 49198:
      case 49199:
      case 49200:
      case 49201:
      case 49202:
      case 49212:
      case 49213:
      case 49214:
      case 49215:
      case 49216:
      case 49217:
      case 49218:
      case 49219:
      case 49220:
      case 49221:
      case 49222:
      case 49223:
      case 49224:
      case 49225:
      case 49226:
      case 49227:
      case 49228:
      case 49229:
      case 49230:
      case 49231:
      case 49232:
      case 49233:
      case 49234:
      case 49235:
      case 49236:
      case 49237:
      case 49238:
      case 49239:
      case 49240:
      case 49241:
      case 49242:
      case 49243:
      case 49244:
      case 49245:
      case 49246:
      case 49247:
      case 49248:
      case 49249:
      case 49250:
      case 49251:
      case 49252:
      case 49253:
      case 49254:
      case 49255:
      case 49256:
      case 49257:
      case 49258:
      case 49259:
      case 49260:
      case 49261:
      case 49262:
      case 49263:
      case 49264:
      case 49265:
      case 49266:
      case 49267:
      case 49268:
      case 49269:
      case 49270:
      case 49271:
      case 49272:
      case 49273:
      case 49274:
      case 49275:
      case 49276:
      case 49277:
      case 49278:
      case 49279:
      case 49280:
      case 49281:
      case 49282:
      case 49283:
      case 49284:
      case 49285:
      case 49286:
      case 49287:
      case 49288:
      case 49289:
      case 49290:
      case 49291:
      case 49292:
      case 49293:
      case 49294:
      case 49295:
      case 49296:
      case 49297:
      case 49298:
      case 49299:
      case 49308:
      case 49309:
      case 49310:
      case 49311:
      case 49312:
      case 49313:
      case 49314:
      case 49315:
      case 49316:
      case 49317:
      case 49318:
      case 49319:
      case 49320:
      case 49321:
      case 49322:
      case 49323:
      case 49324:
      case 49325:
      case 49326:
      case 49327:
      case 52392:
      case 52393:
      case 52394:
      case 52395:
      case 52396:
      case 52397:
      case 52398:
      case 65024:
      case 65025:
      case 65026:
      case 65027:
      case 65028:
      case 65029:
      case 65280:
      case 65281:
      case 65282:
      case 65283:
      case 65284:
      case 65285:
      case 65296:
      case 65297:
      case 65298:
      case 65299:
      case 65300:
      case 65301:
         return ProtocolVersion.TLSv12;
      default:
         return ProtocolVersion.SSLv3;
      }
   }

   public static boolean isAEADCipherSuite(int var0) throws IOException {
      return 2 == getCipherType(var0);
   }

   public static boolean isBlockCipherSuite(int var0) throws IOException {
      return 1 == getCipherType(var0);
   }

   public static boolean isStreamCipherSuite(int var0) throws IOException {
      return 0 == getCipherType(var0);
   }

   public static boolean isValidCipherSuiteForSignatureAlgorithms(int var0, Vector var1) {
      int var2 = getKeyExchangeAlgorithm(var0);
      switch(var2) {
      case 3:
      case 4:
      case 22:
         return var1.contains(Short.valueOf((short)2));
      case 5:
      case 6:
      case 19:
      case 23:
         return var1.contains(Short.valueOf((short)1));
      case 7:
      case 8:
      case 9:
      case 10:
      case 13:
      case 14:
      case 15:
      case 16:
      case 18:
      case 21:
      default:
         return true;
      case 11:
      case 12:
      case 20:
         return var1.contains(Short.valueOf((short)0));
      case 17:
         return var1.contains(Short.valueOf((short)3));
      }
   }

   public static boolean isValidCipherSuiteForVersion(int var0, ProtocolVersion var1) {
      return getMinimumVersion(var0).isEqualOrEarlierVersionOf(var1.getEquivalentTLSVersion());
   }

   public static SignatureAndHashAlgorithm chooseSignatureAndHashAlgorithm(TlsContext var0, Vector var1, short var2) throws IOException {
      if (!isTLSv12(var0)) {
         return null;
      } else {
         if (var1 == null) {
            var1 = getDefaultSignatureAlgorithms(var2);
         }

         SignatureAndHashAlgorithm var3 = null;

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            SignatureAndHashAlgorithm var5 = (SignatureAndHashAlgorithm)var1.elementAt(var4);
            if (var5.getSignature() == var2) {
               short var6 = var5.getHash();
               if (var6 >= MINIMUM_HASH_STRICT) {
                  if (var3 == null) {
                     var3 = var5;
                  } else {
                     short var7 = var3.getHash();
                     if (var7 < MINIMUM_HASH_PREFERRED) {
                        if (var6 > var7) {
                           var3 = var5;
                        }
                     } else if (var6 < var7) {
                        var3 = var5;
                     }
                  }
               }
            }
         }

         if (var3 == null) {
            throw new TlsFatalAlert((short)80);
         } else {
            return var3;
         }
      }
   }

   public static Vector getUsableSignatureAlgorithms(Vector var0) {
      if (var0 == null) {
         return getAllSignatureAlgorithms();
      } else {
         Vector var1 = new Vector(4);
         var1.addElement(Short.valueOf((short)0));

         for(int var2 = 0; var2 < var0.size(); ++var2) {
            SignatureAndHashAlgorithm var3 = (SignatureAndHashAlgorithm)var0.elementAt(var2);
            if (var3.getHash() >= MINIMUM_HASH_STRICT) {
               short var4 = var3.getSignature();
               if (!var1.contains(var4)) {
                  var1.addElement(var4);
               }
            }
         }

         return var1;
      }
   }

   public static int[] getSupportedCipherSuites(TlsCrypto var0, int[] var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 != var1.length; ++var3) {
         if (isSupportedCipherSuite(var0, var1[var3])) {
            var2.add(var1[var3]);
         }
      }

      int[] var5 = new int[var2.size()];

      for(int var4 = 0; var4 != var5.length; ++var4) {
         var5[var4] = (Integer)var2.get(var4);
      }

      return var5;
   }

   public static boolean isSupportedCipherSuite(TlsCrypto var0, int var1) {
      return isSupportedKeyExchange(var0, getKeyExchangeAlgorithm(var1)) && var0.hasEncryptionAlgorithm(getEncryptionAlgorithm(var1)) && var0.hasMacAlgorithm(getMACAlgorithm(var1));
   }

   public static boolean isSupportedKeyExchange(TlsCrypto var0, int var1) {
      switch(var1) {
      case 0:
      case 13:
         return true;
      case 1:
      case 2:
      case 15:
         return var0.hasRSAEncryption();
      case 3:
      case 4:
         return var0.hasDHAgreement() && var0.hasSignatureAlgorithm(2);
      case 5:
      case 6:
         return var0.hasDHAgreement() && var0.hasSignatureAlgorithm(1);
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 14:
         return var0.hasDHAgreement();
      case 16:
      case 18:
      case 20:
      case 24:
         return var0.hasECDHAgreement();
      case 17:
         return var0.hasECDHAgreement() && var0.hasSignatureAlgorithm(3);
      case 19:
         return var0.hasECDHAgreement() && var0.hasSignatureAlgorithm(1);
      case 21:
         return var0.hasSRPAuthentication();
      case 22:
         return var0.hasSRPAuthentication() && var0.hasSignatureAlgorithm(2);
      case 23:
         return var0.hasSRPAuthentication() && var0.hasSignatureAlgorithm(1);
      default:
         return false;
      }
   }

   static byte[] getCurrentPRFHash(TlsHandshakeHash var0) {
      return var0.forkPRFHash().calculateHash();
   }

   static void sealHandshakeHash(TlsContext var0, TlsHandshakeHash var1, boolean var2) {
      if (var2 || !var0.getCrypto().hasAllRawSignatureAlgorithms()) {
         var1.forceBuffering();
      }

      var1.sealHashAlgorithms();
   }
}
