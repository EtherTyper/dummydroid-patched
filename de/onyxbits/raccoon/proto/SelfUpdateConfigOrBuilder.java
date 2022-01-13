package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface SelfUpdateConfigOrBuilder extends MessageOrBuilder {
   boolean hasLatestClientVersionCode();

   int getLatestClientVersionCode();
}
