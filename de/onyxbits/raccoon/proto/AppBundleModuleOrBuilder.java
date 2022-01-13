package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AppBundleModuleOrBuilder extends MessageOrBuilder {
   boolean hasModuleName();

   String getModuleName();

   ByteString getModuleNameBytes();

   boolean hasTitleResourceId();

   int getTitleResourceId();
}
