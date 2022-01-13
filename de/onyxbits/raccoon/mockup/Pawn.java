package de.onyxbits.raccoon.mockup;

import java.util.Locale;
import java.util.TimeZone;

public interface Pawn {
   String getAlias();

   void setAlias(String var1);

   String getUsername();

   void setUsername(String var1);

   String getPassword();

   void setPassword(String var1);

   String getEncryptedPassword();

   void setEncryptedPassword(String var1);

   Device getDevice();

   void setDevice(Device var1);

   long getGsfId();

   void setGsfId(long var1);

   long getSecurityToken();

   void setSecurityToken(long var1);

   TimeZone getTimezone();

   void setTimezone(TimeZone var1);

   Locale getLocale();

   void setLocale(Locale var1);

   String getAuth();

   void setAuth(String var1);

   String getBearer();

   void setBearer(String var1);

   String getDfeCookie();

   void setDfeCookie(String var1);

   String getMccMnc();

   void setMccMnc(String var1);

   String getDeviceConfigToken();

   void setDeviceConfigToken(String var1);

   String getDeviceCheckinConsistencyToken();

   void setLastCheckin(long var1);

   long getLastCheckin();

   void setDeviceCheckinConsistencyToken(String var1);

   void setTosToken(String var1);

   String getTosToken();
}
