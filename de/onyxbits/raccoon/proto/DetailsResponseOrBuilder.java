package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface DetailsResponseOrBuilder extends MessageOrBuilder {
   boolean hasDocV2();

   DocV2 getDocV2();

   DocV2OrBuilder getDocV2OrBuilder();
}
