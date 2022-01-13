package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface SplitDeliveryDataOrBuilder extends MessageOrBuilder {
   boolean hasId();

   String getId();

   ByteString getIdBytes();

   boolean hasDownloadSize();

   long getDownloadSize();

   boolean hasGzippedDownloadSize();

   long getGzippedDownloadSize();

   boolean hasDownloadUrl();

   String getDownloadUrl();

   ByteString getDownloadUrlBytes();

   boolean hasGzippedDownloadUrl();

   String getGzippedDownloadUrl();

   ByteString getGzippedDownloadUrlBytes();

   boolean hasPatchData();

   AndroidAppPatchData getPatchData();

   AndroidAppPatchDataOrBuilder getPatchDataOrBuilder();
}
