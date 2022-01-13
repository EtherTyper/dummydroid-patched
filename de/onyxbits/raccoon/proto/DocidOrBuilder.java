package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface DocidOrBuilder extends MessageOrBuilder {
   boolean hasBackendDocId();

   String getBackendDocId();

   ByteString getBackendDocIdBytes();

   boolean hasType();

   int getType();

   boolean hasBackend();

   int getBackend();
}
