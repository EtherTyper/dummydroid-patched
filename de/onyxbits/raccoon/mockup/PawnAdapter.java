package de.onyxbits.raccoon.mockup;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

class PawnAdapter implements JsonDeserializer, JsonSerializer {
   public JsonElement serialize(Pawn src, Type typeOfSrc, JsonSerializationContext context) {
      JsonObject ret = new JsonObject();
      if (src.getAlias() != null) {
         ret.addProperty("alias", src.getAlias());
      }

      if (src.getAuth() != null) {
         ret.addProperty("auth", src.getAuth());
      }

      if (src.getBearer() != null) {
         ret.addProperty("bearer", src.getBearer());
      }

      if (src.getDevice() != null) {
         ret.add("device", context.serialize(src.getDevice(), Device.class));
      }

      if (src.getDeviceCheckinConsistencyToken() != null) {
         ret.addProperty("deviceCheckinConsistencyToken", src.getDeviceCheckinConsistencyToken());
      }

      if (src.getDeviceConfigToken() != null) {
         ret.addProperty("deviceConfigToken", src.getDeviceConfigToken());
      }

      if (src.getDfeCookie() != null) {
         ret.addProperty("dfeCookie", src.getDfeCookie());
      }

      if (src.getEncryptedPassword() != null) {
         ret.addProperty("encryptedPassword", src.getEncryptedPassword());
      }

      if (src.getLocale() != null) {
         ret.addProperty("locale", src.getLocale().toString());
      }

      if (src.getMccMnc() != null) {
         ret.addProperty("mccMnc", src.getMccMnc());
      }

      if (src.getPassword() != null) {
         ret.addProperty("password", src.getPassword());
      }

      if (src.getTimezone() != null) {
         ret.addProperty("timezone", src.getTimezone().getID());
      }

      if (src.getTosToken() != null) {
         ret.addProperty("tosToken", src.getTosToken());
      }

      if (src.getUsername() != null) {
         ret.addProperty("username", src.getUsername());
      }

      ret.addProperty("gsfId", (Number)src.getGsfId());
      ret.addProperty("lastCheckin", (Number)src.getLastCheckin());
      ret.addProperty("securityToken", (Number)src.getSecurityToken());
      return ret;
   }

   public Pawn deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      InternalPawn ret = new InternalPawn();
      JsonObject obj = json.getAsJsonObject();
      if (obj.has("alias")) {
         ret.setAlias(obj.get("alias").getAsString());
      }

      if (obj.has("auth")) {
         ret.setAuth(obj.get("auth").getAsString());
      }

      if (obj.has("bearer")) {
         ret.setBearer(obj.get("bearer").getAsString());
      }

      if (obj.has("device")) {
         Device device = (Device)context.deserialize(obj.get("device"), InternalDevice.class);
         ret.setDevice(device);
      }

      if (obj.has("deviceCheckinConsistencyToken")) {
         ret.setDeviceCheckinConsistencyToken(obj.get("deviceCheckinConsistencyToken").getAsString());
      }

      if (obj.has("deviceConfigToken")) {
         ret.setDeviceConfigToken(obj.get("deviceConfigToken").getAsString());
      }

      if (obj.has("dfeCookie")) {
         ret.setDfeCookie(obj.get("dfeCookie").getAsString());
      }

      if (obj.has("encryptedPassword")) {
         ret.setEncryptedPassword(obj.get("encryptedPassword").getAsString());
      }

      if (obj.has("gsfId")) {
         ret.setGsfId(obj.get("gsfId").getAsLong());
      }

      if (obj.has("lastCheckin")) {
         ret.setLastCheckin(obj.get("lastCheckin").getAsLong());
      }

      if (obj.has("locale")) {
         ret.setLocale(new Locale(obj.get("locale").getAsString()));
      }

      if (obj.has("mccMnc")) {
         ret.setMccMnc(obj.get("mccMnc").getAsString());
      }

      if (obj.has("password")) {
         ret.setPassword(obj.get("password").getAsString());
      }

      if (obj.has("securityToken")) {
         ret.setSecurityToken(obj.get("securityToken").getAsLong());
      }

      if (obj.has("timezone")) {
         ret.setTimezone(TimeZone.getTimeZone(obj.get("timezone").getAsString()));
      }

      if (obj.has("tosToken")) {
         ret.setTosToken(obj.get("tosToken").getAsString());
      }

      if (obj.has("username")) {
         ret.setUsername(obj.get("username").getAsString());
      }

      return ret;
   }
}
