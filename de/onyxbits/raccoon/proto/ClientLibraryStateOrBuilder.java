package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ClientLibraryStateOrBuilder extends MessageOrBuilder {
   boolean hasCorpus();

   int getCorpus();

   boolean hasServerToken();

   ByteString getServerToken();

   boolean hasHashcodesum();

   long getHashcodesum();

   boolean hasLibrarySize();

   int getLibrarySize();

   boolean hasLibraryId();

   String getLibraryId();

   ByteString getLibraryIdBytes();
}
