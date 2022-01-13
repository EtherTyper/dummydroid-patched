package de.onyxbits.raccoon.mockup;

import com.google.gson.GsonBuilder;
import de.onyxbits.raccoon.proto.AndroidBuildProto;
import de.onyxbits.raccoon.proto.DeviceConfigurationProto;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Locale;

public class MockUtil {
   public static AndroidBuildProto toAndroidBuildProto(Device d) {
      Build b = d.getBuild();
      AndroidBuildProto.Builder builder = AndroidBuildProto.newBuilder().setTimestamp(b.time / 1000L).setSdkVersion(b.sdkVersion);
      if (b.bootloader != null) {
         builder.setBootloader(b.bootloader);
      }

      if (b.hardware != null) {
         builder.setProduct(b.hardware);
      }

      if (b.device != null) {
         builder.setDevice(b.device);
      }

      if (b.model != null) {
         builder.setModel(b.model);
      }

      if (b.manufacturer != null) {
         builder.setManufacturer(b.manufacturer);
      }

      if (b.product != null) {
         builder.setBuildProduct(b.product);
         builder.setProduct(b.product);
      }

      if (b.fingerprint != null) {
         builder.setId(b.fingerprint);
      }

      ApplicationInfo ia = d.getApplicationInfo("com.google.android.gsf");
      if (ia != null) {
         builder.setGoogleServices(ia.versionCode);
      }

      builder.setOtaInstalled(d.isOtaInstalled());
      builder.setClient("android-google");
      return builder.build();
   }

   public static DeviceConfigurationProto toDeviceConfigurationProto(Device d) {
      return DeviceConfigurationProto.newBuilder().setTouchScreen(d.getTouchscreen()).setKeyboard(d.getKeyboard()).setNavigation(d.getNavigation()).setScreenLayout(d.getScreenLayout()).setHasHardKeyboard(d.getHasHardwareKeyboard()).setHasFiveWayNavigation(d.getHasFiveWayNavigation()).setScreenWidth(d.getScreenWidth()).setScreenHeight(d.getScreenHeight()).setScreenDensity(d.getScreenDensity()).addAllNativePlatform(d.getBuild().abi).addAllSystemSharedLibrary(d.getSystemSharedLibraries()).addAllSystemAvailableFeature(d.getSystemAvailableFeatures()).addAllSystemSupportedLocale(d.getLocales()).setGlEsVersion(d.getGlEsVersion()).addAllGlExtension(d.getGlExtensions()).build();
   }

   public static String toFinskyAgent(Device d) {
      Build b = d.getBuild();
      ApplicationInfo finsky = d.getApplicationInfo("com.android.vending");
      if (finsky == null) {
         finsky = new ApplicationInfo("com.android.vending", "", 0);
      }

      Object[] args = new Object[]{finsky.versionName.split(" ")[0], "3", finsky.versionCode, b.sdkVersion, b.device, b.hardware, b.product, b.releaseVersion, b.model, b.id};
      return String.format(Locale.US, "Android-Finsky/%s (api=%s,versionCode=%d,sdk=%d,device=%s,hardware=%s,product=%s,platformVersionRelease=%s,model=%s,buildId=%s)", args);
   }

   public static String toCheckinAgent(Device d) {
      Build b = d.getBuild();
      String name = "Android-Checkin";
      String version = "2.0";
      String device = b.device;
      String id = b.id;
      return MessageFormat.format("{0}/{1} ({2} {3}); gzip", name, version, device, id);
   }

   public static String toDownloadAgent(Device d) {
      return "AndroidDownloadManager/4.3 (Linux; U; Android 4.3; ME302C Build/JSS15Q)";
   }

   public static String toLoginAgent(Device d) {
      String name = "GoogleLoginService";
      String version = "1.3";
      String device = "grouper";
      String id = "JDQ39";
      if (d != null) {
         Build b = d.getBuild();
         device = b.device;
         id = b.id;
         if (b.sdkVersion > 17) {
            name = "GoogleAuth";
            version = "1.4";
         }
      }

      return MessageFormat.format("{0}/{1} ({2} {3})", name, version, device, id);
   }

   public static int encodeGlVersion(int major, int minor) {
      int ret = major << 16;
      ret += minor;
      return ret;
   }

   public static int decodeMajorGlVersion(int encoded) {
      return encoded >> 16 & '\uffff';
   }

   public static int decodeMinorGlVersion(int encoded) {
      return encoded & '\uffff';
   }

   public static String encodePawn(Pawn pawn) {
      return (new GsonBuilder()).setPrettyPrinting().registerTypeAdapter(Pawn.class, new PawnAdapter()).registerTypeAdapter(Device.class, new DeviceAdapter()).create().toJson((Object)pawn, (Type)Pawn.class);
   }

   public static Pawn decodePawn(String json) {
      return (Pawn)(new GsonBuilder()).registerTypeAdapter(Pawn.class, new PawnAdapter()).registerTypeAdapter(Build.class, new BuildAdapter()).registerTypeAdapter(ApplicationInfo.class, new ApplicationInfoAdapter()).registerTypeAdapter(Device.class, new DeviceAdapter()).create().fromJson(json, Pawn.class);
   }

   public static Pawn decodePawn(Reader json) {
      return (Pawn)(new GsonBuilder()).registerTypeAdapter(Pawn.class, new PawnAdapter()).registerTypeAdapter(Build.class, new BuildAdapter()).registerTypeAdapter(ApplicationInfo.class, new ApplicationInfoAdapter()).registerTypeAdapter(Device.class, new DeviceAdapter()).create().fromJson(json, Pawn.class);
   }

   public static String encodeDevice(Device device) {
      return (new GsonBuilder()).setPrettyPrinting().registerTypeAdapter(Device.class, new DeviceAdapter()).create().toJson((Object)device, (Type)Device.class);
   }

   public static Device decodeDevice(String json) {
      return (Device)(new GsonBuilder()).registerTypeAdapter(Build.class, new BuildAdapter()).registerTypeAdapter(ApplicationInfo.class, new ApplicationInfoAdapter()).registerTypeAdapter(Device.class, new DeviceAdapter()).create().fromJson(json, Device.class);
   }

   public static Device decodeDevice(Reader json) {
      return (Device)(new GsonBuilder()).registerTypeAdapter(Build.class, new BuildAdapter()).registerTypeAdapter(ApplicationInfo.class, new ApplicationInfoAdapter()).registerTypeAdapter(Device.class, new DeviceAdapter()).create().fromJson(json, Device.class);
   }
}
