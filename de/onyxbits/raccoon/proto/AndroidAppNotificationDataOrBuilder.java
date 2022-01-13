package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AndroidAppNotificationDataOrBuilder extends MessageOrBuilder {
   boolean hasVersionCode();

   int getVersionCode();

   boolean hasAssetId();

   String getAssetId();

   ByteString getAssetIdBytes();

   boolean hasInstallReferrer();

   String getInstallReferrer();

   ByteString getInstallReferrerBytes();
}
