package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface PreFetchDataOrBuilder extends MessageOrBuilder {
   boolean hasPreFetchUri();

   PreFetchUri getPreFetchUri();

   PreFetchUriOrBuilder getPreFetchUriOrBuilder();
}
