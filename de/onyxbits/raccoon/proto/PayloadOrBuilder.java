package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;

public interface PayloadOrBuilder extends MessageOrBuilder {
   boolean hasListResponse();

   ListResponse getListResponse();

   ListResponseOrBuilder getListResponseOrBuilder();

   boolean hasDetailsResponse();

   DetailsResponse getDetailsResponse();

   DetailsResponseOrBuilder getDetailsResponseOrBuilder();

   boolean hasReviewResponse();

   ReviewResponse getReviewResponse();

   ReviewResponseOrBuilder getReviewResponseOrBuilder();

   boolean hasSearchResponse();

   SearchResponse getSearchResponse();

   SearchResponseOrBuilder getSearchResponseOrBuilder();

   boolean hasTocResponse();

   TocResponse getTocResponse();

   TocResponseOrBuilder getTocResponseOrBuilder();

   boolean hasBulkDetailsResponse();

   BulkDetailsResponse getBulkDetailsResponse();

   BulkDetailsResponseOrBuilder getBulkDetailsResponseOrBuilder();

   boolean hasDeliveryResponse();

   DeliveryResponse getDeliveryResponse();

   DeliveryResponseOrBuilder getDeliveryResponseOrBuilder();

   boolean hasAndroidCheckinResponse();

   AndroidCheckinResponse getAndroidCheckinResponse();

   AndroidCheckinResponseOrBuilder getAndroidCheckinResponseOrBuilder();

   boolean hasModifyLibraryResponse();

   ModifyLibraryResponse getModifyLibraryResponse();

   ModifyLibraryResponseOrBuilder getModifyLibraryResponseOrBuilder();

   boolean hasUploadDeviceConfigResponse();

   UploadDeviceConfigResponse getUploadDeviceConfigResponse();

   UploadDeviceConfigResponseOrBuilder getUploadDeviceConfigResponseOrBuilder();

   boolean hasSelfUpdateResponse();

   SelfUpdateResponse getSelfUpdateResponse();

   SelfUpdateResponseOrBuilder getSelfUpdateResponseOrBuilder();

   boolean hasEarlyUpdateResponse();

   EarlyUpdateResponse getEarlyUpdateResponse();

   EarlyUpdateResponseOrBuilder getEarlyUpdateResponseOrBuilder();

   boolean hasContentFilterResponse();

   ContentFilterSettingsResponse getContentFilterResponse();

   ContentFilterSettingsResponseOrBuilder getContentFilterResponseOrBuilder();

   boolean hasTestingProgramOptResponse();

   TestingProgramOptResponse getTestingProgramOptResponse();

   TestingProgramOptResponseOrBuilder getTestingProgramOptResponseOrBuilder();
}
