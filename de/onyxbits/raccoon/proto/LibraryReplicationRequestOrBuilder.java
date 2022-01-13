package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface LibraryReplicationRequestOrBuilder extends MessageOrBuilder {
   List getLibraryStateList();

   ClientLibraryState getLibraryState(int var1);

   int getLibraryStateCount();

   List getLibraryStateOrBuilderList();

   ClientLibraryStateOrBuilder getLibraryStateOrBuilder(int var1);

   boolean hasLibraryMutationVersion();

   int getLibraryMutationVersion();
}
