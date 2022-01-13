package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AndroidCheckinResponseOrBuilder extends MessageOrBuilder {
   boolean hasStatsOk();

   boolean getStatsOk();

   boolean hasTimeMsec();

   long getTimeMsec();

   boolean hasGsfId();

   long getGsfId();

   boolean hasSecurityToken();

   long getSecurityToken();

   boolean hasDeviceCheckinConsistencyToken();

   String getDeviceCheckinConsistencyToken();

   ByteString getDeviceCheckinConsistencyTokenBytes();
}
