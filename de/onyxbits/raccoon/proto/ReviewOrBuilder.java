package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface ReviewOrBuilder extends MessageOrBuilder {
   boolean hasAuthorName();

   String getAuthorName();

   ByteString getAuthorNameBytes();

   boolean hasUrl();

   String getUrl();

   ByteString getUrlBytes();

   boolean hasSource();

   String getSource();

   ByteString getSourceBytes();

   boolean hasDocumentVersion();

   String getDocumentVersion();

   ByteString getDocumentVersionBytes();

   boolean hasTimestampMsec();

   long getTimestampMsec();

   boolean hasStarRating();

   int getStarRating();

   boolean hasTitle();

   String getTitle();

   ByteString getTitleBytes();

   boolean hasComment();

   String getComment();

   ByteString getCommentBytes();

   boolean hasCommentId();

   String getCommentId();

   ByteString getCommentIdBytes();

   boolean hasDeviceName();

   String getDeviceName();

   ByteString getDeviceNameBytes();

   boolean hasReplyText();

   String getReplyText();

   ByteString getReplyTextBytes();

   boolean hasReplyTimestampMsec();

   long getReplyTimestampMsec();

   boolean hasAuthor();

   DocV2 getAuthor();

   DocV2OrBuilder getAuthorOrBuilder();

   boolean hasSentiment();

   Image getSentiment();

   ImageOrBuilder getSentimentOrBuilder();

   boolean hasHelpfulContent();

   int getHelpfulContent();

   boolean hasThumbsUpCount();

   long getThumbsUpCount();
}
