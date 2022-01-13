package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DocV2OrBuilder extends MessageOrBuilder {
   boolean hasDocid();

   String getDocid();

   ByteString getDocidBytes();

   boolean hasBackendDocid();

   String getBackendDocid();

   ByteString getBackendDocidBytes();

   boolean hasDocType();

   int getDocType();

   boolean hasBackendId();

   int getBackendId();

   boolean hasTitle();

   String getTitle();

   ByteString getTitleBytes();

   boolean hasCreator();

   String getCreator();

   ByteString getCreatorBytes();

   boolean hasDescriptionHtml();

   String getDescriptionHtml();

   ByteString getDescriptionHtmlBytes();

   List getOfferList();

   Offer getOffer(int var1);

   int getOfferCount();

   List getOfferOrBuilderList();

   OfferOrBuilder getOfferOrBuilder(int var1);

   boolean hasAvailability();

   Availability getAvailability();

   AvailabilityOrBuilder getAvailabilityOrBuilder();

   List getImageList();

   Image getImage(int var1);

   int getImageCount();

   List getImageOrBuilderList();

   ImageOrBuilder getImageOrBuilder(int var1);

   List getChildList();

   DocV2 getChild(int var1);

   int getChildCount();

   List getChildOrBuilderList();

   DocV2OrBuilder getChildOrBuilder(int var1);

   boolean hasContainerMetadata();

   ContainerMetadata getContainerMetadata();

   ContainerMetadataOrBuilder getContainerMetadataOrBuilder();

   boolean hasDetails();

   DocumentDetails getDetails();

   DocumentDetailsOrBuilder getDetailsOrBuilder();

   boolean hasAggregateRating();

   AggregateRating getAggregateRating();

   AggregateRatingOrBuilder getAggregateRatingOrBuilder();

   boolean hasAnnotations();

   Annotations getAnnotations();

   AnnotationsOrBuilder getAnnotationsOrBuilder();

   boolean hasReviewsUrl();

   String getReviewsUrl();

   ByteString getReviewsUrlBytes();

   boolean hasBackendUrl();

   String getBackendUrl();

   ByteString getBackendUrlBytes();

   boolean hasTranslatedDescriptionHtml();

   String getTranslatedDescriptionHtml();

   ByteString getTranslatedDescriptionHtmlBytes();

   boolean hasPromotionalDescription();

   String getPromotionalDescription();

   ByteString getPromotionalDescriptionBytes();

   boolean hasAvailableForPreregistration();

   boolean getAvailableForPreregistration();

   boolean hasAutoTranslatedPromotionalDescription();

   String getAutoTranslatedPromotionalDescription();

   ByteString getAutoTranslatedPromotionalDescriptionBytes();

   boolean hasDescriptionTitle();

   String getDescriptionTitle();

   ByteString getDescriptionTitleBytes();

   boolean hasItemType();

   int getItemType();
}
