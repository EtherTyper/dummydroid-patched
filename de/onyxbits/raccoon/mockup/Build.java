package de.onyxbits.raccoon.mockup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Build {
   public final String manufacturer;
   public final String brand;
   public final String device;
   public final String hardware;
   public final String product;
   public final String model;
   public final String id;
   public final String fingerprint;
   public final String releaseVersion;
   public final String bootloader;
   public final int sdkVersion;
   public final long time;
   public final List abi;

   public Build(String manufacturer, String brand, String device, String hardware, String product, String model, String id, String releaseVersion, String bootloader, int sdkVersion, long time, List abi, String fingerprint) {
      this.manufacturer = manufacturer;
      this.brand = brand;
      this.device = device;
      this.hardware = hardware;
      this.product = product;
      this.model = model;
      this.id = id;
      this.releaseVersion = releaseVersion;
      this.bootloader = bootloader;
      this.sdkVersion = sdkVersion;
      this.time = time;
      this.abi = Collections.unmodifiableList(abi);
      this.fingerprint = fingerprint;
   }

   public Build(Properties p) {
      this.manufacturer = p.getProperty("ro.product.manufacturer", (String)null);
      this.brand = p.getProperty("ro.product.brand", (String)null);
      this.model = p.getProperty("ro.product.model", (String)null);
      this.bootloader = p.getProperty("ro.bootloader", (String)null);
      this.hardware = p.getProperty("ro.hardware", (String)null);
      this.releaseVersion = p.getProperty("ro.build.version.release", (String)null);
      this.device = p.getProperty("ro.product.device", (String)null);
      this.product = p.getProperty("ro.product.name", (String)null);
      this.id = p.getProperty("ro.build.id", (String)null);
      int tmpSdkVersion = 1;
      long tmpTime = 0L;

      try {
         tmpSdkVersion = Integer.parseInt(p.getProperty("ro.build.version.sdk"));
         tmpTime = Long.parseLong(p.getProperty("ro.build.date.utc")) * 1000L;
      } catch (Exception var6) {
      }

      this.sdkVersion = tmpSdkVersion;
      this.time = tmpTime;
      ArrayList tmpabi = new ArrayList();
      addAllTo(tmpabi, p.getProperty("ro.product.cpu.abilist64"));
      addAllTo(tmpabi, p.getProperty("ro.product.cpu.abilist32"));
      addAllTo(tmpabi, p.getProperty("ro.product.cpu.abilist"));
      addAllTo(tmpabi, p.getProperty("ro.product.cpu.abi2"));
      addAllTo(tmpabi, p.getProperty("ro.product.cpu.abi"));
      this.abi = Collections.unmodifiableList(tmpabi);
      this.fingerprint = deriveFingerprint(p);
   }

   private static void addAllTo(ArrayList lst, String value) {
      if (value != null) {
         String[] tmp = value.split(" *, *");
         String[] var3 = tmp;
         int var4 = tmp.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            if (!lst.contains(s) && s.length() > 0) {
               lst.add(s);
            }
         }
      }

   }

   private static String deriveFingerprint(Properties p) {
      return p.contains("ro.build.fingerprint") ? p.getProperty("ro.build.fingerprint") : p.getProperty("ro.product.brand") + '/' + p.getProperty("ro.product.name") + '/' + p.getProperty("ro.product.device") + ':' + p.getProperty("ro.build.version.release") + '/' + p.getProperty("ro.build.id") + '/' + p.getProperty("ro.build.version.incremental") + ':' + p.getProperty("ro.build.type") + '/' + p.getProperty("ro.build.tags");
   }
}
