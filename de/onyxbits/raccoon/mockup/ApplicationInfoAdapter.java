package de.onyxbits.raccoon.mockup;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class ApplicationInfoAdapter implements JsonDeserializer, JsonSerializer {
   public JsonElement serialize(ApplicationInfo src, Type typeOfSrc, JsonSerializationContext context) {
      return null;
   }

   public ApplicationInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      String packageName = "";
      String versionName = "";
      int versionCode = 0;
      JsonObject obj = json.getAsJsonObject();
      if (obj.has("packageName")) {
         packageName = obj.get("packageName").getAsString();
      }

      if (obj.has("versionName")) {
         versionName = obj.get("versionName").getAsString();
      }

      if (obj.has("versionCode")) {
         versionCode = obj.get("versionCode").getAsInt();
      }

      return new ApplicationInfo(packageName, versionName, versionCode);
   }
}
