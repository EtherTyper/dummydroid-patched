package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface AvailabilityOrBuilder extends MessageOrBuilder {
   boolean hasRestriction();

   int getRestriction();

   boolean hasOfferType();

   int getOfferType();

   boolean hasRule();

   Rule getRule();

   RuleOrBuilder getRuleOrBuilder();

   boolean hasAvailableIfOwned();

   boolean getAvailableIfOwned();
}
