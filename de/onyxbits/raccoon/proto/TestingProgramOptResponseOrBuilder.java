package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface TestingProgramOptResponseOrBuilder extends MessageOrBuilder {
   boolean hasErrorStatus();

   int getErrorStatus();

   boolean hasLibraryUpdate();

   LibraryUpdate getLibraryUpdate();

   LibraryUpdateOrBuilder getLibraryUpdateOrBuilder();
}
