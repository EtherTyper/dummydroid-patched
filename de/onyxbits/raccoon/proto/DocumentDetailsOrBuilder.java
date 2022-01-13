package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface DocumentDetailsOrBuilder extends MessageOrBuilder {
   boolean hasAppDetails();

   AppDetails getAppDetails();

   AppDetailsOrBuilder getAppDetailsOrBuilder();
}
