package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AndroidBuildProtoOrBuilder extends MessageOrBuilder {
   boolean hasId();

   String getId();

   ByteString getIdBytes();

   boolean hasProduct();

   String getProduct();

   ByteString getProductBytes();

   boolean hasCarrier();

   String getCarrier();

   ByteString getCarrierBytes();

   boolean hasRadio();

   String getRadio();

   ByteString getRadioBytes();

   boolean hasBootloader();

   String getBootloader();

   ByteString getBootloaderBytes();

   boolean hasClient();

   String getClient();

   ByteString getClientBytes();

   boolean hasTimestamp();

   long getTimestamp();

   boolean hasGoogleServices();

   int getGoogleServices();

   boolean hasDevice();

   String getDevice();

   ByteString getDeviceBytes();

   boolean hasSdkVersion();

   int getSdkVersion();

   boolean hasModel();

   String getModel();

   ByteString getModelBytes();

   boolean hasManufacturer();

   String getManufacturer();

   ByteString getManufacturerBytes();

   boolean hasBuildProduct();

   String getBuildProduct();

   ByteString getBuildProductBytes();

   boolean hasOtaInstalled();

   boolean getOtaInstalled();
}
