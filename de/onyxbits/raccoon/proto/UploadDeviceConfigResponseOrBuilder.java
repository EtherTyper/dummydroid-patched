package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface UploadDeviceConfigResponseOrBuilder extends MessageOrBuilder {
   boolean hasUploadDeviceConfigToken();

   String getUploadDeviceConfigToken();

   ByteString getUploadDeviceConfigTokenBytes();
}
