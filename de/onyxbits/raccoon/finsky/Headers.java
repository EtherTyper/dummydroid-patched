package de.onyxbits.raccoon.finsky;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class Headers implements DfeHeaders {
   private static final Header CTYPE_URLENC = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
   private static final Header CTYPE_PROTO = new BasicHeader("Content-Type", "application/protobuf");

   public static Header agent(String value) {
      return new BasicHeader("User-Agent", value);
   }

   public static Header auth(String token) {
      return new BasicHeader("Authorization", "GoogleLogin auth=" + token);
   }

   public static Header bearer(String token) {
      return new BasicHeader("Authorization", "Bearer " + token);
   }

   public static Header dfeCookie(String value) {
      return new BasicHeader("X-DFE-Cookie", value);
   }

   public static Header gsfId(String id) {
      return new BasicHeader("X-DFE-Device-Id", id);
   }

   public static Header gsfId(long id) {
      return gsfId(Long.toString(id, 16));
   }

   public static Header lang(Locale l) {
      String val = l.getLanguage() + "-" + l.getCountry();
      return new BasicHeader("Accept-Language", val);
   }

   public static Header lang() {
      return lang(Locale.getDefault());
   }

   public static Header protobuf() {
      return CTYPE_PROTO;
   }

   public static Header urlEnc() {
      return CTYPE_URLENC;
   }

   public static Header cookie(String val) {
      return new BasicHeader("Cookie", val);
   }

   public static Header host(String h) {
      return new BasicHeader("Host", h);
   }

   public static Header checkinConsistency(String token) {
      return new BasicHeader("X-DFE-Device-Checkin-Consistency-Token", token);
   }

   public static Header mccMnc(String mccMnc) {
      return new BasicHeader("X-DFE-MCCMNC", mccMnc);
   }

   public static Header noPrefetch(boolean b) {
      return b ? new BasicHeader("X-DFE-No-Prefetch", "true") : new BasicHeader("X-DFE-No-Prefetch", "false");
   }
}
