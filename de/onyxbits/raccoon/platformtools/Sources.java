package de.onyxbits.raccoon.platformtools;

public class Sources {
   public static final String WINDOWS = "https://dl.google.com/android/repository/platform-tools-latest-windows.zip";
   public static final String MACOS = "https://dl.google.com/android/repository/platform-tools-latest-darwin.zip";
   public static final String LINUX = "https://dl.google.com/android/repository/platform-tools-latest-linux.zip";

   public static final String getOsUrl() {
      String os = System.getProperty("os.name").toLowerCase();
      if (os.indexOf("win") >= 0) {
         return "https://dl.google.com/android/repository/platform-tools-latest-windows.zip";
      } else if (os.indexOf("mac") >= 0) {
         return "https://dl.google.com/android/repository/platform-tools-latest-darwin.zip";
      } else {
         return os.indexOf("nux") >= 0 ? "https://dl.google.com/android/repository/platform-tools-latest-linux.zip" : null;
      }
   }
}
