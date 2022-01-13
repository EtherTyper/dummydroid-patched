package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AndroidAppPatchDataOrBuilder extends MessageOrBuilder {
   boolean hasBaseVersionCode();

   int getBaseVersionCode();

   boolean hasDownloadUrl();

   String getDownloadUrl();

   ByteString getDownloadUrlBytes();

   boolean hasPatchFormat();

   int getPatchFormat();
}
