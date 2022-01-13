package de.onyxbits.raccoon.standalone.gui.about;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;

final class Messages {
   private static final ResourceBundle BNDL = ResourceBundle.getBundle(Messages.class.getName(), Locale.getDefault(), Messages.class.getClassLoader());
   private static final char[] PACKAGEPATCH;

   private Messages() {
   }

   public static String t(String key) {
      try {
         return (String)BNDL.getObject(key);
      } catch (MissingResourceException var2) {
         return '!' + key + '!';
      }
   }

   public static String t(String key, Object... args) {
      try {
         return (new MessageFormat((String)BNDL.getObject(key))).format(args);
      } catch (MissingResourceException var3) {
         return '!' + key + '!';
      }
   }

   public static InputStream open(String fname) {
      int len = fname.length();
      char[] tmp = new char[PACKAGEPATCH.length + len];
      System.arraycopy(PACKAGEPATCH, 0, tmp, 0, PACKAGEPATCH.length);
      fname.getChars(0, len, tmp, PACKAGEPATCH.length);
      return Messages.class.getResourceAsStream(new String(tmp));
   }

   public static Icon loadIcon(String fname) {
      InputStream in = null;

      ImageIcon var3;
      try {
         in = open(fname);
         byte[] b = new byte[in.available()];
         in.read(b);
         var3 = new ImageIcon(b);
         return var3;
      } catch (Exception var13) {
         var13.printStackTrace();
         var3 = new ImageIcon();
      } finally {
         try {
            in.close();
         } catch (Exception var12) {
         }

      }

      return var3;
   }

   static {
      String path = Messages.class.getPackage().getName();
      int len = path.length();
      PACKAGEPATCH = new char[len + 2];
      PACKAGEPATCH[0] = '/';
      PACKAGEPATCH[len + 1] = '/';
      path.getChars(0, len, PACKAGEPATCH, 1);
      --len;

      for(int i = 1; i < len; ++i) {
         if (PACKAGEPATCH[i] == '.') {
            PACKAGEPATCH[i] = '/';
            ++i;
         }
      }

   }
}
