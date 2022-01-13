package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface LibraryUpdateOrBuilder extends MessageOrBuilder {
   boolean hasStatus();

   LibraryUpdate.Status getStatus();

   List getMutationList();

   LibraryMutation getMutation(int var1);

   int getMutationCount();

   List getMutationOrBuilderList();

   LibraryMutationOrBuilder getMutationOrBuilder(int var1);

   boolean hasHasMore();

   boolean getHasMore();

   boolean hasLibraryId();

   String getLibraryId();

   ByteString getLibraryIdBytes();
}
