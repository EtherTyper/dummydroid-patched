package de.onyxbits.raccoon.standalone.cli;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

class Messages {
   private static final ResourceBundle BNDL = ResourceBundle.getBundle(Messages.class.getName(), Locale.getDefault(), Messages.class.getClassLoader());

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
         return MessageFormat.format((String)BNDL.getObject(key), args);
      } catch (MissingResourceException var3) {
         return '!' + key + '!';
      }
   }
}
