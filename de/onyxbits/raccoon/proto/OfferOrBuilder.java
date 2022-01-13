package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface OfferOrBuilder extends MessageOrBuilder {
   boolean hasMicros();

   long getMicros();

   boolean hasCurrencyCode();

   String getCurrencyCode();

   ByteString getCurrencyCodeBytes();

   boolean hasFormattedAmount();

   String getFormattedAmount();

   ByteString getFormattedAmountBytes();

   boolean hasCheckoutFlowRequired();

   boolean getCheckoutFlowRequired();

   boolean hasFullPriceMicros();

   long getFullPriceMicros();

   boolean hasOfferType();

   int getOfferType();

   boolean hasPreorder();

   boolean getPreorder();

   boolean hasOfferId();

   String getOfferId();

   ByteString getOfferIdBytes();

   boolean hasTemporarilyFree();

   boolean getTemporarilyFree();
}
