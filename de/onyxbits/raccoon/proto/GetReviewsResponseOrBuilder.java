package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface GetReviewsResponseOrBuilder extends MessageOrBuilder {
   List getReviewList();

   Review getReview(int var1);

   int getReviewCount();

   List getReviewOrBuilderList();

   ReviewOrBuilder getReviewOrBuilder(int var1);

   boolean hasMatchingCount();

   long getMatchingCount();
}
