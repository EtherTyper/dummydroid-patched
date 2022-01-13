package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ReviewResponseOrBuilder extends MessageOrBuilder {
   boolean hasResponse();

   GetReviewsResponse getResponse();

   GetReviewsResponseOrBuilder getResponseOrBuilder();

   boolean hasNextPageUrl();

   String getNextPageUrl();

   ByteString getNextPageUrlBytes();

   boolean hasUpdatedReview();

   Review getUpdatedReview();

   ReviewOrBuilder getUpdatedReviewOrBuilder();
}
