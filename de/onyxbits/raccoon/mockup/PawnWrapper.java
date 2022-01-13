package de.onyxbits.raccoon.mockup;

import java.util.Locale;
import java.util.TimeZone;

public abstract class PawnWrapper implements Pawn {
   private Pawn pawn;

   public PawnWrapper(Pawn pawn) {
      if (pawn == null) {
         throw new NullPointerException();
      } else {
         this.pawn = pawn;
      }
   }

   public String getAlias() {
      return this.pawn.getAlias();
   }

   public void setAlias(String alias) {
      this.pawn.setAlias(alias);
   }

   public String getUsername() {
      return this.pawn.getUsername();
   }

   public void setUsername(String username) {
      this.pawn.setUsername(username);
   }

   public String getPassword() {
      return this.pawn.getPassword();
   }

   public void setPassword(String password) {
      this.pawn.setPassword(password);
   }

   public String getEncryptedPassword() {
      return this.pawn.getEncryptedPassword();
   }

   public void setEncryptedPassword(String encryptedPassword) {
      this.pawn.setEncryptedPassword(encryptedPassword);
   }

   public Device getDevice() {
      return this.pawn.getDevice();
   }

   public void setDevice(Device device) {
      this.pawn.setDevice(device);
   }

   public long getGsfId() {
      return this.pawn.getGsfId();
   }

   public void setGsfId(long gsfId) {
      this.pawn.setGsfId(gsfId);
   }

   public long getSecurityToken() {
      return this.pawn.getSecurityToken();
   }

   public void setSecurityToken(long securityToken) {
      this.pawn.setSecurityToken(securityToken);
   }

   public TimeZone getTimezone() {
      return this.pawn.getTimezone();
   }

   public void setTimezone(TimeZone timezone) {
      this.pawn.setTimezone(timezone);
   }

   public Locale getLocale() {
      return this.pawn.getLocale();
   }

   public void setLocale(Locale locale) {
      this.pawn.setLocale(locale);
   }

   public String getAuth() {
      return this.pawn.getAuth();
   }

   public void setAuth(String auth) {
      this.pawn.setAuth(auth);
   }

   public String getBearer() {
      return this.pawn.getBearer();
   }

   public void setBearer(String bearer) {
      this.pawn.setBearer(bearer);
   }

   public String getDfeCookie() {
      return this.pawn.getDfeCookie();
   }

   public void setDfeCookie(String dfeCookie) {
      this.pawn.setDfeCookie(dfeCookie);
   }

   public String getMccMnc() {
      return this.pawn.getMccMnc();
   }

   public void setMccMnc(String mccMnc) {
      this.pawn.setMccMnc(mccMnc);
   }

   public String getDeviceConfigToken() {
      return this.pawn.getDeviceConfigToken();
   }

   public void setDeviceConfigToken(String deviceConfigToken) {
      this.pawn.setDeviceConfigToken(deviceConfigToken);
   }

   public String getDeviceCheckinConsistencyToken() {
      return this.pawn.getDeviceCheckinConsistencyToken();
   }

   public void setLastCheckin(long timestamp) {
      this.pawn.setLastCheckin(timestamp);
   }

   public long getLastCheckin() {
      return this.pawn.getLastCheckin();
   }

   public void setDeviceCheckinConsistencyToken(String deviceCheckinConsistencyToken) {
      this.pawn.setDeviceCheckinConsistencyToken(deviceCheckinConsistencyToken);
   }

   public void setTosToken(String tosToken) {
      this.pawn.setTosToken(tosToken);
   }

   public String getTosToken() {
      return this.pawn.getTosToken();
   }

   public String toString() {
      return MockUtil.encodePawn(this.pawn);
   }
}
