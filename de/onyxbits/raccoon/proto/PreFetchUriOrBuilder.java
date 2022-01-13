package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface PreFetchUriOrBuilder extends MessageOrBuilder {
   boolean hasUri();

   String getUri();

   ByteString getUriBytes();
}
