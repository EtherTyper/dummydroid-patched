package de.onyxbits.raccoon.util;

public class TextTool {
   public static final char BLACK = '░';

   public static String fit(String txt, int maxlen, char pad, String cont) {
      int len = txt.length();
      if (len >= maxlen) {
         if (len > maxlen) {
            String tmp = cont == null ? "" : cont;
            return txt.substring(0, maxlen - tmp.length()) + tmp;
         } else {
            return txt;
         }
      } else {
         StringBuilder sb = new StringBuilder(txt);

         for(int i = 0; i < maxlen - len; ++i) {
            sb.append(pad);
         }

         return sb.toString();
      }
   }

   public static String redact(String in, char rep, boolean keepWhiteSpace, int beginIndex, int endIndex) {
      char[] ret = in.toCharArray();

      for(int i = beginIndex; i < ret.length; ++i) {
         if (i >= beginIndex && i < endIndex) {
            switch(ret[i]) {
            case '\t':
            case '\n':
            case ' ':
               if (keepWhiteSpace) {
                  break;
               }
            default:
               ret[i] = rep;
            }
         }
      }

      return new String(ret);
   }

   public static String redact(String in, char rep, boolean keepWhiteSpace) {
      return redact(in, rep, keepWhiteSpace, 0, in.length());
   }

   public static String redact(String in, char rep) {
      return redact(in, rep, false, 0, in.length());
   }

   public static String redact(String in) {
      return redact(in, '░');
   }

   public static String capitalize(String in) {
      char[] ret = in.toCharArray();
      ret[0] = Character.toUpperCase(ret[0]);

      for(int i = 1; i < ret.length; ++i) {
         ret[i] = Character.toLowerCase(ret[i]);
      }

      return new String(ret);
   }

   public static String wordwrap(int lineWidth, String txt) {
      StringBuilder ret = new StringBuilder();
      String[] words = txt.split(" ");
      int spaceLeft = lineWidth - words[0].length();
      String[] var5 = words;
      int var6 = words.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String word = var5[var7];
         if (word.length() + 1 > spaceLeft) {
            spaceLeft = lineWidth - word.length();
            ret.append('\n');
         } else {
            spaceLeft -= word.length() + 1;
            if (ret.length() != 0) {
               ret.append(' ');
            }
         }

         ret.append(word);
      }

      return ret.toString();
   }

   public static String byteCount(long bytes, boolean si) {
      int unit = si ? 1000 : 1024;
      if (bytes < (long)unit) {
         return bytes + " B";
      } else {
         int exp = (int)(Math.log((double)bytes) / Math.log((double)unit));
         String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
         return String.format("%.1f %sB", (double)bytes / Math.pow((double)unit, (double)exp), pre);
      }
   }
}
