package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface DependencyOrBuilder extends MessageOrBuilder {
   boolean hasPackageName();

   String getPackageName();

   ByteString getPackageNameBytes();

   boolean hasMinVersionCode();

   int getMinVersionCode();

   boolean hasVersionCodeMask();

   int getVersionCodeMask();
}
