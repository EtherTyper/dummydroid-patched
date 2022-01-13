package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface DeliveryResponseOrBuilder extends MessageOrBuilder {
   boolean hasStatus();

   int getStatus();

   boolean hasAppDeliveryData();

   AndroidAppDeliveryData getAppDeliveryData();

   AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder();
}
