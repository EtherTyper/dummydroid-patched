package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AggregateRatingOrBuilder extends MessageOrBuilder {
   boolean hasType();

   int getType();

   boolean hasStarRating();

   float getStarRating();

   boolean hasRatingsCount();

   long getRatingsCount();

   boolean hasOneStarRatings();

   long getOneStarRatings();

   boolean hasTwoStarRatings();

   long getTwoStarRatings();

   boolean hasThreeStarRatings();

   long getThreeStarRatings();

   boolean hasFourStarRatings();

   long getFourStarRatings();

   boolean hasFiveStarRatings();

   long getFiveStarRatings();

   boolean hasCommentCount();

   long getCommentCount();

   boolean hasLocalizedAverage();

   String getLocalizedAverage();

   ByteString getLocalizedAverageBytes();
}
