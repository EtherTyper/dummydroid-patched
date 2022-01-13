package de.onyxbits.raccoon.mockup;

public class ApplicationInfo {
   public static final String FINSKY = "com.android.vending";
   public static final String DOWNLOADMANAGER = "com.android.providers.downloads";
   public static final String GSF = "com.google.android.gsf";
   public static final String GMS = "com.google.android.gms";
   public final String packageName;
   public final String versionName;
   public final int versionCode;

   public ApplicationInfo(String packageName, String versionName, int versionCode) {
      this.packageName = packageName;
      this.versionName = versionName;
      this.versionCode = versionCode;
   }

   public String toString() {
      return this.packageName + "\t" + this.versionCode + "\t" + this.versionName;
   }
}
