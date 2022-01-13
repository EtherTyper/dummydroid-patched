package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface SelfUpdateResponseOrBuilder extends MessageOrBuilder {
   boolean hasRequiresUploadDeviceConfig();

   boolean getRequiresUploadDeviceConfig();

   boolean hasLatestClientVersionCode();

   int getLatestClientVersionCode();
}
