package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ContainerMetadataOrBuilder extends MessageOrBuilder {
   boolean hasNextPageUrl();

   String getNextPageUrl();

   ByteString getNextPageUrlBytes();
}
