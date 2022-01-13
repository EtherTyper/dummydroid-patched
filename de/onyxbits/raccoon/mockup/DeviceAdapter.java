package de.onyxbits.raccoon.mockup;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

class DeviceAdapter implements JsonDeserializer, JsonSerializer {
   public JsonElement serialize(Device src, Type typeOfSrc, JsonSerializationContext context) {
      JsonObject ret = new JsonObject();
      ret.addProperty("glesVersion", (Number)src.getGlEsVersion());
      ret.addProperty("hasFiveWayNavigation", src.getHasFiveWayNavigation());
      ret.addProperty("hasHardwareKeyboard", src.getHasHardwareKeyboard());
      ret.addProperty("keyboard", (Number)src.getKeyboard());
      ret.addProperty("navigation", (Number)src.getNavigation());
      ret.addProperty("screenDensity", (Number)src.getScreenDensity());
      ret.addProperty("screenHeight", (Number)src.getScreenHeight());
      ret.addProperty("screenWidth", (Number)src.getScreenWidth());
      ret.addProperty("touchscreen", (Number)src.getTouchscreen());
      ret.addProperty("screenLayout", (Number)src.getScreenLayout());
      ret.addProperty("otaInstalled", src.isOtaInstalled());
      if (src.getInstalledApps() != null) {
         ret.add("installedApps", context.serialize(src.getInstalledApps()));
      }

      if (src.getLocales() != null) {
         ret.add("locales", context.serialize(src.getLocales()));
      }

      if (src.getGlExtensions() != null) {
         ret.add("glesExtensions", context.serialize(src.getGlExtensions()));
      }

      if (src.getSystemAvailableFeatures() != null) {
         ret.add("systemAvailableFeatures", context.serialize(src.getSystemAvailableFeatures()));
      }

      if (src.getSystemSharedLibraries() != null) {
         ret.add("systemSharedLibraries", context.serialize(src.getSystemSharedLibraries()));
      }

      if (src.getBuild() != null) {
         ret.add("build", context.serialize(src.getBuild()));
      }

      return ret;
   }

   public Device deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      return (Device)context.deserialize(json, InternalDevice.class);
   }
}
