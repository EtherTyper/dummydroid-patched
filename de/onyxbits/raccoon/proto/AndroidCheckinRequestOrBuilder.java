package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AndroidCheckinRequestOrBuilder extends MessageOrBuilder {
   boolean hasId();

   long getId();

   boolean hasDigest();

   String getDigest();

   ByteString getDigestBytes();

   boolean hasCheckin();

   AndroidCheckinProto getCheckin();

   AndroidCheckinProtoOrBuilder getCheckinOrBuilder();

   boolean hasDesiredBuild();

   String getDesiredBuild();

   ByteString getDesiredBuildBytes();

   boolean hasLocale();

   String getLocale();

   ByteString getLocaleBytes();

   boolean hasMarketCheckin();

   String getMarketCheckin();

   ByteString getMarketCheckinBytes();

   List getMacAddrList();

   int getMacAddrCount();

   String getMacAddr(int var1);

   ByteString getMacAddrBytes(int var1);

   boolean hasMeid();

   String getMeid();

   ByteString getMeidBytes();

   List getAccountCookieList();

   int getAccountCookieCount();

   String getAccountCookie(int var1);

   ByteString getAccountCookieBytes(int var1);

   boolean hasTimeZone();

   String getTimeZone();

   ByteString getTimeZoneBytes();

   boolean hasSecurityToken();

   long getSecurityToken();

   boolean hasVersion();

   int getVersion();

   List getOtaCertList();

   int getOtaCertCount();

   String getOtaCert(int var1);

   ByteString getOtaCertBytes(int var1);

   boolean hasSerialNumber();

   String getSerialNumber();

   ByteString getSerialNumberBytes();

   boolean hasEsn();

   String getEsn();

   ByteString getEsnBytes();

   boolean hasDeviceConfiguration();

   DeviceConfigurationProto getDeviceConfiguration();

   DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder();

   List getMacAddrTypeList();

   int getMacAddrTypeCount();

   String getMacAddrType(int var1);

   ByteString getMacAddrTypeBytes(int var1);

   boolean hasFragment();

   int getFragment();

   boolean hasUserName();

   String getUserName();

   ByteString getUserNameBytes();

   boolean hasUserSerialNumber();

   int getUserSerialNumber();
}
