package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AppModuleOrBuilder extends MessageOrBuilder {
   boolean hasSplitId();

   String getSplitId();

   ByteString getSplitIdBytes();

   boolean hasVersionCode();

   String getVersionCode();

   ByteString getVersionCodeBytes();

   boolean hasExistingVersionCode();

   String getExistingVersionCode();

   ByteString getExistingVersionCodeBytes();
}
