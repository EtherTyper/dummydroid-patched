package de.onyxbits.raccoon.mockup;

import java.util.List;

public interface Device {
   int getScreenWidth();

   int getScreenHeight();

   int getScreenDensity();

   Build getBuild();

   List getSystemAvailableFeatures();

   List getSystemSharedLibraries();

   boolean isOtaInstalled();

   List getLocales();

   int getGlEsVersion();

   List getGlExtensions();

   ApplicationInfo getApplicationInfo(String var1);

   List getInstalledApps();

   boolean getHasFiveWayNavigation();

   boolean getHasHardwareKeyboard();

   int getKeyboard();

   int getTouchscreen();

   int getNavigation();

   int getScreenLayout();
}
