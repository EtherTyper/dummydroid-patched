package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface BulkDetailsEntryOrBuilder extends MessageOrBuilder {
   boolean hasDoc();

   DocV2 getDoc();

   DocV2OrBuilder getDocOrBuilder();
}
