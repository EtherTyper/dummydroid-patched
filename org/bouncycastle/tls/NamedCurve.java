package org.bouncycastle.tls;

public class NamedCurve {
   private static final String[] CURVE_NAMES = new String[]{"sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1"};
   public static final int sect163k1 = 1;
   public static final int sect163r1 = 2;
   public static final int sect163r2 = 3;
   public static final int sect193r1 = 4;
   public static final int sect193r2 = 5;
   public static final int sect233k1 = 6;
   public static final int sect233r1 = 7;
   public static final int sect239k1 = 8;
   public static final int sect283k1 = 9;
   public static final int sect283r1 = 10;
   public static final int sect409k1 = 11;
   public static final int sect409r1 = 12;
   public static final int sect571k1 = 13;
   public static final int sect571r1 = 14;
   public static final int secp160k1 = 15;
   public static final int secp160r1 = 16;
   public static final int secp160r2 = 17;
   public static final int secp192k1 = 18;
   public static final int secp192r1 = 19;
   public static final int secp224k1 = 20;
   public static final int secp224r1 = 21;
   public static final int secp256k1 = 22;
   public static final int secp256r1 = 23;
   public static final int secp384r1 = 24;
   public static final int secp521r1 = 25;
   public static final int brainpoolP256r1 = 26;
   public static final int brainpoolP384r1 = 27;
   public static final int brainpoolP512r1 = 28;
   public static final int arbitrary_explicit_prime_curves = 65281;
   public static final int arbitrary_explicit_char2_curves = 65282;

   public static int getCurveBits(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
         return 163;
      case 4:
      case 5:
         return 193;
      case 6:
      case 7:
         return 233;
      case 8:
         return 239;
      case 9:
      case 10:
         return 283;
      case 11:
      case 12:
         return 409;
      case 13:
      case 14:
         return 571;
      case 15:
      case 16:
      case 17:
         return 160;
      case 18:
      case 19:
         return 192;
      case 20:
      case 21:
         return 224;
      case 22:
      case 23:
      case 26:
         return 256;
      case 24:
      case 27:
         return 384;
      case 25:
         return 521;
      case 28:
         return 512;
      default:
         return 0;
      }
   }

   public static int getMaximumCurveBits() {
      return 571;
   }

   public static String getName(int var0) {
      if (!isValid(var0)) {
         return null;
      } else {
         switch(var0) {
         case 65281:
            return "arbitrary_explicit_prime_curves";
         case 65282:
            return "arbitrary_explicit_char2_curves";
         default:
            return CURVE_NAMES[var0 - 1];
         }
      }
   }

   public static String getNameOfSpecificCurve(int var0) {
      return !refersToASpecificNamedCurve(var0) ? null : CURVE_NAMES[var0 - 1];
   }

   public static boolean isChar2(int var0) {
      return var0 >= 1 && var0 <= 14;
   }

   public static boolean isPrime(int var0) {
      return var0 >= 15 && var0 <= 28;
   }

   public static boolean isValid(int var0) {
      return var0 >= 1 && var0 <= 28 || var0 >= 65281 && var0 <= 65282;
   }

   public static boolean refersToASpecificNamedCurve(int var0) {
      switch(var0) {
      case 65281:
      case 65282:
         return false;
      default:
         return true;
      }
   }
}
