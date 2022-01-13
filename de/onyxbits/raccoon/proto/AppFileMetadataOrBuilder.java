package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AppFileMetadataOrBuilder extends MessageOrBuilder {
   boolean hasFileType();

   int getFileType();

   boolean hasVersionCode();

   int getVersionCode();

   boolean hasSize();

   long getSize();

   boolean hasDownloadUrl();

   String getDownloadUrl();

   ByteString getDownloadUrlBytes();

   boolean hasAndroidAppPatchData();

   AndroidAppPatchData getAndroidAppPatchData();

   AndroidAppPatchDataOrBuilder getAndroidAppPatchDataOrBuilder();

   boolean hasCompressedSize();

   long getCompressedSize();

   boolean hasCompressedDownloadUrl();

   String getCompressedDownloadUrl();

   ByteString getCompressedDownloadUrlBytes();
}
