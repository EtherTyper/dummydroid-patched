package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.finsky.LoginApi;
import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.util.TextTool;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.ButtonModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class PawnModel implements Pawn {
   protected PlainDocument uid = new PlainDocument();
   protected PlainDocument pwd = new PlainDocument();
   private String alias;
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
   private ButtonModel loginModel;
   private ButtonModel registerGsfModel;

   public PawnModel() {
   }

   public String getAlias() {
      return this.alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public String getUsername() {
      try {
         return this.uid.getText(0, this.uid.getLength());
      } catch (BadLocationException var2) {
         return "";
      }
   }

   public void setUsername(String username) {
      try {
         this.uid.remove(0, this.uid.getLength());
         this.uid.insertString(0, username, (AttributeSet)null);
      } catch (BadLocationException var3) {
      }

   }

   public String getPassword() {
      try {
         return this.pwd.getText(0, this.pwd.getLength());
      } catch (BadLocationException var2) {
         return "";
      }
   }

   public void setPassword(String password) {
      try {
         this.pwd.remove(0, this.pwd.getLength());
         this.pwd.insertString(0, password, (AttributeSet)null);
      } catch (BadLocationException var3) {
      }

   }

   public String getEncryptedPassword() {
      return LoginApi.encryptPassword(this.getUsername(), this.getPassword().toCharArray());
   }

   public void setEncryptedPassword(String encryptedPassword) {
   }

   public Device getDevice() {
      return this.device;
   }

   public void setDevice(Device device) {
      if (!(device instanceof MutableDevice)) {
         throw new IllegalArgumentException("Wrong type!");
      } else {
         this.device = device;
      }
   }

   public long getGsfId() {
      return this.gsfId;
   }

   public void setGsfId(long gsfId) {
      this.registerGsfModel.setSelected(gsfId == 0L || this.registerGsfModel == null);
      this.gsfId = gsfId;
   }

   public long getSecurityToken() {
      return this.securityToken;
   }

   public void setSecurityToken(long securityToken) {
      this.securityToken = securityToken;
   }

   public TimeZone getTimezone() {
      return this.timezone;
   }

   public void setTimezone(TimeZone timezone) {
      this.timezone = timezone;
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
      this.loginModel.setSelected(this.loginModel == null || auth == null);
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

   public void setLastCheckin(long timestamp) {
      this.lastCheckin = timestamp;
   }

   public long getLastCheckin() {
      return this.lastCheckin;
   }

   public void setDeviceCheckinConsistencyToken(String deviceCheckinConsistencyToken) {
      this.deviceCheckinConsistencyToken = deviceCheckinConsistencyToken;
   }

   public void setTosToken(String tosToken) {
      this.tosToken = tosToken;
   }

   public String getTosToken() {
      return this.tosToken;
   }

   protected void merge(Pawn p) {
      this.cpy(p.getUsername(), this.uid);
      this.cpy(p.getPassword(), this.pwd);
      this.setAlias(p.getAlias());
      this.setAuth(p.getAuth());
      this.setBearer(p.getBearer());
      this.setDeviceCheckinConsistencyToken(p.getDeviceCheckinConsistencyToken());
      this.setDeviceConfigToken(p.getDeviceConfigToken());
      this.setDfeCookie(p.getDfeCookie());
      this.setEncryptedPassword(p.getEncryptedPassword());
      this.setGsfId(p.getGsfId());
      this.setLastCheckin(p.getLastCheckin());
      this.setLocale(p.getLocale());
      this.setMccMnc(p.getMccMnc());
      this.setPassword(p.getPassword());
      this.setSecurityToken(p.getSecurityToken());
      this.setTimezone(p.getTimezone());
      this.setTosToken(p.getTosToken());
      this.setUsername(p.getUsername());
      if (p.getDevice() != null) {
         ((MutableDevice)this.getDevice()).merge(p.getDevice());
      }

   }

   protected void clear() {
      this.cpy("", this.uid);
      this.cpy("", this.pwd);
      this.setAlias((String)null);
      this.setAuth((String)null);
      this.setBearer((String)null);
      this.setDeviceCheckinConsistencyToken((String)null);
      this.setSecurityToken(0L);
      this.setDeviceConfigToken((String)null);
      this.setDfeCookie((String)null);
      this.setEncryptedPassword((String)null);
      this.setGsfId(0L);
      this.setLastCheckin(0L);
      this.setLocale((Locale)null);
      this.setMccMnc((String)null);
      this.setPassword((String)null);
      this.setEncryptedPassword((String)null);
      this.setTimezone((TimeZone)null);
      this.setTosToken((String)null);
      this.setUsername((String)null);
      ((MutableDevice)this.getDevice()).clear();
   }

   private void cpy(String s, PlainDocument p) {
      try {
         p.remove(0, p.getLength());
         p.insertString(0, s, (AttributeSet)null);
      } catch (BadLocationException var4) {
      }

   }

   public String getRedactedGsfId() {
      String s = this.getHexGsfId();
      int end = s.length();
      int start = Math.max(0, end - (int)((float)end * 0.33F));
      return TextTool.redact(s, '░', false, start, end);
   }

   public String getHexGsfId() {
      return Long.toString(this.getGsfId(), 16);
   }

   public String getRedactedAuth() {
      String s = this.getAuth() == null ? "" : this.getAuth();
      int end = s.length();
      int start = Math.max(0, end - (int)((float)end * 0.33F));
      return TextTool.redact(s, '░', false, start, end);
   }

   public void setLoginModel(ButtonModel model) {
      this.loginModel = model;
   }

   public void setRegisterGsfModel(ButtonModel model) {
      this.registerGsfModel = model;
   }
}
