package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface FilterChoiceOrBuilder extends MessageOrBuilder {
   boolean hasLevel();

   int getLevel();

   boolean hasImageFife();

   Image getImageFife();

   ImageOrBuilder getImageFifeOrBuilder();

   boolean hasLabel();

   String getLabel();

   ByteString getLabelBytes();

   boolean hasDfeHeaderValue();

   String getDfeHeaderValue();

   ByteString getDfeHeaderValueBytes();

   boolean hasSelected();

   boolean getSelected();

   boolean hasLabelSummary();

   String getLabelSummary();

   ByteString getLabelSummaryBytes();
}
