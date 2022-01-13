package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface ModifyLibraryResponseOrBuilder extends MessageOrBuilder {
   boolean hasLibraryUpdate();

   LibraryUpdate getLibraryUpdate();

   LibraryUpdateOrBuilder getLibraryUpdateOrBuilder();
}
