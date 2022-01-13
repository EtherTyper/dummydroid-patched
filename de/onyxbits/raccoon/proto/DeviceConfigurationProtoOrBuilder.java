package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DeviceConfigurationProtoOrBuilder extends MessageOrBuilder {
   boolean hasTouchScreen();

   int getTouchScreen();

   boolean hasKeyboard();

   int getKeyboard();

   boolean hasNavigation();

   int getNavigation();

   boolean hasScreenLayout();

   int getScreenLayout();

   boolean hasHasHardKeyboard();

   boolean getHasHardKeyboard();

   boolean hasHasFiveWayNavigation();

   boolean getHasFiveWayNavigation();

   boolean hasScreenDensity();

   int getScreenDensity();

   boolean hasGlEsVersion();

   int getGlEsVersion();

   List getSystemSharedLibraryList();

   int getSystemSharedLibraryCount();

   String getSystemSharedLibrary(int var1);

   ByteString getSystemSharedLibraryBytes(int var1);

   List getSystemAvailableFeatureList();

   int getSystemAvailableFeatureCount();

   String getSystemAvailableFeature(int var1);

   ByteString getSystemAvailableFeatureBytes(int var1);

   List getNativePlatformList();

   int getNativePlatformCount();

   String getNativePlatform(int var1);

   ByteString getNativePlatformBytes(int var1);

   boolean hasScreenWidth();

   int getScreenWidth();

   boolean hasScreenHeight();

   int getScreenHeight();

   List getSystemSupportedLocaleList();

   int getSystemSupportedLocaleCount();

   String getSystemSupportedLocale(int var1);

   ByteString getSystemSupportedLocaleBytes(int var1);

   List getGlExtensionList();

   int getGlExtensionCount();

   String getGlExtension(int var1);

   ByteString getGlExtensionBytes(int var1);

   boolean hasMaxApkDownloadSizeMb();

   int getMaxApkDownloadSizeMb();

   boolean hasSmallestScreenWidthDp();

   int getSmallestScreenWidthDp();

   boolean hasLowRamDevice();

   boolean getLowRamDevice();

   boolean hasTotalMemoryBytes();

   long getTotalMemoryBytes();

   boolean hasMaxNumOfCpuCores();

   int getMaxNumOfCpuCores();
}
