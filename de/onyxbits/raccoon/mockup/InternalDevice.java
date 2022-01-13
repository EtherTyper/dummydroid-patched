package de.onyxbits.raccoon.mockup;

import java.util.Iterator;
import java.util.List;

class InternalDevice implements Device {
   protected int touchscreen;
   protected int screenLayout;
   protected int navigation;
   protected int keyboard;
   protected int glesVersion;
   protected Build build;
   protected int screenWidth;
   protected int screenHeight;
   protected int screenDensity;
   protected List systemAvailableFeatures;
   protected List systemSharedLibraries;
   protected List locales;
   protected List glesExtensions;
   protected List installedApps;
   protected boolean otaInstalled;
   protected boolean hasHardwareKeyboard;
   protected boolean hasFiveWayNavigation;

   public int getTouchscreen() {
      return this.touchscreen;
   }

   public int getScreenLayout() {
      return this.screenLayout;
   }

   public int getNavigation() {
      return this.navigation;
   }

   public int getKeyboard() {
      return this.keyboard;
   }

   public int getGlEsVersion() {
      return this.glesVersion;
   }

   public Build getBuild() {
      return this.build;
   }

   public int getScreenWidth() {
      return this.screenWidth;
   }

   public int getScreenHeight() {
      return this.screenHeight;
   }

   public int getScreenDensity() {
      return this.screenDensity;
   }

   public List getSystemAvailableFeatures() {
      return this.systemAvailableFeatures;
   }

   public List getSystemSharedLibraries() {
      return this.systemSharedLibraries;
   }

   public List getLocales() {
      return this.locales;
   }

   public List getGlExtensions() {
      return this.glesExtensions;
   }

   public List getInstalledApps() {
      return this.installedApps;
   }

   public boolean isOtaInstalled() {
      return this.otaInstalled;
   }

   public boolean getHasHardwareKeyboard() {
      return this.hasHardwareKeyboard;
   }

   public boolean getHasFiveWayNavigation() {
      return this.hasFiveWayNavigation;
   }

   public ApplicationInfo getApplicationInfo(String pn) {
      if (this.installedApps != null) {
         Iterator var2 = this.installedApps.iterator();

         while(var2.hasNext()) {
            ApplicationInfo ai = (ApplicationInfo)var2.next();
            if (ai != null && pn.equals(ai.packageName)) {
               return ai;
            }
         }
      }

      return null;
   }
}
