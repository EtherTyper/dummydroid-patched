package de.onyxbits.raccoon.standalone.gui.mock;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

final class Messages {
   private static final ResourceBundle BNDL = ResourceBundle.getBundle(Messages.class.getName(), Locale.getDefault(), Messages.class.getClassLoader());
   private static final char[] PACKAGEPATH;

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

   public static Image i(String fname) {
      InputStream in = null;

      BufferedImage var3;
      try {
         int len = fname.length();
         char[] tmp = new char[PACKAGEPATH.length + len];
         System.arraycopy(PACKAGEPATH, 0, tmp, 0, PACKAGEPATH.length);
         fname.getChars(0, len, tmp, PACKAGEPATH.length);
         in = Messages.class.getResourceAsStream(new String(tmp));
         byte[] b = new byte[in.available()];
         in.read(b);
         Image var5 = Toolkit.getDefaultToolkit().createImage(b);
         return var5;
      } catch (Exception var15) {
         var15.printStackTrace();
         var3 = new BufferedImage(1, 1, 2);
      } finally {
         try {
            in.close();
         } catch (Exception var14) {
         }

      }

      return var3;
   }

   static {
      String path = Messages.class.getPackage().getName();
      int len = path.length();
      PACKAGEPATH = new char[len + 2];
      PACKAGEPATH[0] = '/';
      PACKAGEPATH[len + 1] = '/';
      path.getChars(0, len, PACKAGEPATH, 1);
      --len;

      for(int i = 1; i < len; ++i) {
         if (PACKAGEPATH[i] == '.') {
            PACKAGEPATH[i] = '/';
            ++i;
         }
      }

   }
}
