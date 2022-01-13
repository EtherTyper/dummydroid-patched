package de.onyxbits.raccoon.mockup;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BuildAdapter implements JsonDeserializer, JsonSerializer {
   public JsonElement serialize(Build src, Type typeOfSrc, JsonSerializationContext context) {
      return null;
   }

   public Build deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      JsonObject obj = json.getAsJsonObject();
      String manufacturer = null;
      String brand = null;
      String device = null;
      String hardware = null;
      String product = null;
      String model = null;
      String id = null;
      String fingerprint = null;
      String releaseVersion = null;
      String bootloader = null;
      int sdkVersion = 0;
      long time = 0L;
      List abi = new ArrayList();
      if (obj.has("model")) {
         model = obj.get("model").getAsString();
      }

      if (obj.has("manufacturer")) {
         manufacturer = obj.get("manufacturer").getAsString();
      }

      if (obj.has("brand")) {
         brand = obj.get("brand").getAsString();
      }

      if (obj.has("device")) {
         device = obj.get("device").getAsString();
      }

      if (obj.has("hardware")) {
         hardware = obj.get("hardware").getAsString();
      }

      if (obj.has("product")) {
         product = obj.get("product").getAsString();
      }

      if (obj.has("id")) {
         id = obj.get("id").getAsString();
      }

      if (obj.has("fingerprint")) {
         fingerprint = obj.get("fingerprint").getAsString();
      }

      if (obj.has("releaseVersion")) {
         releaseVersion = obj.get("releaseVersion").getAsString();
      }

      if (obj.has("bootloader")) {
         bootloader = obj.get("bootloader").getAsString();
      }

      if (obj.has("sdkVersion")) {
         sdkVersion = obj.get("sdkVersion").getAsInt();
      }

      if (obj.has("abi")) {
         Iterator it = obj.get("abi").getAsJsonArray().iterator();

         while(it.hasNext()) {
            abi.add(((JsonElement)it.next()).getAsString());
         }
      }

      if (obj.has("time")) {
         time = obj.get("time").getAsLong();
      }

      return new Build(manufacturer, brand, device, hardware, product, model, id, releaseVersion, bootloader, sdkVersion, time, abi, fingerprint);
   }
}
