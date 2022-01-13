package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface EarlyUpdateRequestOrBuilder extends MessageOrBuilder {
   boolean hasDeviceConfiguration();

   DeviceConfigurationProto getDeviceConfiguration();

   DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder();
}
