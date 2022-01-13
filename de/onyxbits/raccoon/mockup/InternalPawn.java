package de.onyxbits.raccoon.mockup;

import java.util.Locale;
import java.util.TimeZone;

class InternalPawn implements Pawn {
   private String alias;
   private String username;
   private String password;
   private String encryptedPassword;
   private Device device;
   private long gsfId;
   private long securityToken;
   private TimeZone timezone;
   private Locale locale;
   private String auth;
   private String bearer;
   private String dfeCookie;
   private String tosToken;
   private String mccMnc;
   private String deviceConfigToken;
   private String deviceCheckinConsistencyToken;
   private long lastCheckin;

   public String getAlias() {
      return this.alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public String getUsername() {
      return this.username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEncryptedPassword() {
      return this.encryptedPassword;
   }

   public void setEncryptedPassword(String encryptedPassword) {
      this.encryptedPassword = encryptedPassword;
   }

   public Device getDevice() {
      return this.device;
   }

   public void setDevice(Device device) {
      this.device = device;
   }

   public long getGsfId() {
      return this.gsfId;
   }

   public void setGsfId(long gsfId) {
      this.gsfId = gsfId;
   }

   public long getSecurityToken() {
      return this.securityToken;
   }

   public void setSecurityToken(long securityToken) {
      this.securityToken = securityToken;
   }

   public Locale getLocale() {
      return this.locale;
   }

   public void setLocale(Locale locale) {
      this.locale = locale;
   }

   public String getAuth() {
      return this.auth;
   }

   public void setAuth(String auth) {
      this.auth = auth;
   }

   public String getBearer() {
      return this.bearer;
   }

   public void setBearer(String bearer) {
      this.bearer = bearer;
   }

   public String getDfeCookie() {
      return this.dfeCookie;
   }

   public void setDfeCookie(String dfeCookie) {
      this.dfeCookie = dfeCookie;
   }

   public String getTosToken() {
      return this.tosToken;
   }

   public void setTosToken(String tosToken) {
      this.tosToken = tosToken;
   }

   public String getMccMnc() {
      return this.mccMnc;
   }

   public void setMccMnc(String mccMnc) {
      this.mccMnc = mccMnc;
   }

   public String getDeviceConfigToken() {
      return this.deviceConfigToken;
   }

   public void setDeviceConfigToken(String deviceConfigToken) {
      this.deviceConfigToken = deviceConfigToken;
   }

   public String getDeviceCheckinConsistencyToken() {
      return this.deviceCheckinConsistencyToken;
   }

   public void setDeviceCheckinConsistencyToken(String deviceCheckinConsistencyToken) {
      this.deviceCheckinConsistencyToken = deviceCheckinConsistencyToken;
   }

   public long getLastCheckin() {
      return this.lastCheckin;
   }

   public void setLastCheckin(long lastCheckin) {
      this.lastCheckin = lastCheckin;
   }

   public TimeZone getTimezone() {
      return this.timezone;
   }

   public void setTimezone(TimeZone timezone) {
      this.timezone = timezone;
   }
}
