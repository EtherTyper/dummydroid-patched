package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface UploadDeviceConfigRequestOrBuilder extends MessageOrBuilder {
   boolean hasDeviceConfiguration();

   DeviceConfigurationProto getDeviceConfiguration();

   DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder();

   boolean hasManufacturer();

   String getManufacturer();

   ByteString getManufacturerBytes();

   boolean hasGcmRegistrationId();

   String getGcmRegistrationId();

   ByteString getGcmRegistrationIdBytes();
}
