package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface HttpCookieOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   boolean hasValue();

   String getValue();

   ByteString getValueBytes();
}
