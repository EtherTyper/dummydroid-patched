package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface AndroidAppDeliveryDataOrBuilder extends MessageOrBuilder {
   boolean hasDownloadSize();

   long getDownloadSize();

   boolean hasDownloadUrl();

   String getDownloadUrl();

   ByteString getDownloadUrlBytes();

   List getAdditionalFileList();

   AppFileMetadata getAdditionalFile(int var1);

   int getAdditionalFileCount();

   List getAdditionalFileOrBuilderList();

   AppFileMetadataOrBuilder getAdditionalFileOrBuilder(int var1);

   List getDownloadAuthCookieList();

   HttpCookie getDownloadAuthCookie(int var1);

   int getDownloadAuthCookieCount();

   List getDownloadAuthCookieOrBuilderList();

   HttpCookieOrBuilder getDownloadAuthCookieOrBuilder(int var1);

   boolean hasServerInitiated();

   boolean getServerInitiated();

   boolean hasPatchData();

   AndroidAppPatchData getPatchData();

   AndroidAppPatchDataOrBuilder getPatchDataOrBuilder();

   boolean hasEncryptionParams();

   EncryptionParams getEncryptionParams();

   EncryptionParamsOrBuilder getEncryptionParamsOrBuilder();

   boolean hasGzippedDownloadUrl();

   String getGzippedDownloadUrl();

   ByteString getGzippedDownloadUrlBytes();

   boolean hasGzippedDownloadSize();

   long getGzippedDownloadSize();

   List getSplitDeliveryDataList();

   SplitDeliveryData getSplitDeliveryData(int var1);

   int getSplitDeliveryDataCount();

   List getSplitDeliveryDataOrBuilderList();

   SplitDeliveryDataOrBuilder getSplitDeliveryDataOrBuilder(int var1);
}
