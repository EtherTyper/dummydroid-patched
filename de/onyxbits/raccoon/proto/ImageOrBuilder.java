package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ImageOrBuilder extends MessageOrBuilder {
   boolean hasImageType();

   int getImageType();

   boolean hasDimension();

   Image.Dimension getDimension();

   Image.DimensionOrBuilder getDimensionOrBuilder();

   boolean hasImageUrl();

   String getImageUrl();

   ByteString getImageUrlBytes();
}
