package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface LinkOrBuilder extends MessageOrBuilder {
   boolean hasUri();

   String getUri();

   ByteString getUriBytes();
}
