package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Payload extends GeneratedMessageV3 implements PayloadOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LISTRESPONSE_FIELD_NUMBER = 1;
   private ListResponse listResponse_;
   public static final int DETAILSRESPONSE_FIELD_NUMBER = 2;
   private DetailsResponse detailsResponse_;
   public static final int REVIEWRESPONSE_FIELD_NUMBER = 3;
   private ReviewResponse reviewResponse_;
   public static final int SEARCHRESPONSE_FIELD_NUMBER = 5;
   private SearchResponse searchResponse_;
   public static final int TOCRESPONSE_FIELD_NUMBER = 6;
   private TocResponse tocResponse_;
   public static final int BULKDETAILSRESPONSE_FIELD_NUMBER = 19;
   private BulkDetailsResponse bulkDetailsResponse_;
   public static final int DELIVERYRESPONSE_FIELD_NUMBER = 21;
   private DeliveryResponse deliveryResponse_;
   public static final int ANDROIDCHECKINRESPONSE_FIELD_NUMBER = 26;
   private AndroidCheckinResponse androidCheckinResponse_;
   public static final int MODIFYLIBRARYRESPONSE_FIELD_NUMBER = 27;
   private ModifyLibraryResponse modifyLibraryResponse_;
   public static final int UPLOADDEVICECONFIGRESPONSE_FIELD_NUMBER = 28;
   private UploadDeviceConfigResponse uploadDeviceConfigResponse_;
   public static final int SELFUPDATERESPONSE_FIELD_NUMBER = 39;
   private SelfUpdateResponse selfUpdateResponse_;
   public static final int EARLYUPDATERESPONSE_FIELD_NUMBER = 48;
   private EarlyUpdateResponse earlyUpdateResponse_;
   public static final int CONTENTFILTERRESPONSE_FIELD_NUMBER = 49;
   private ContentFilterSettingsResponse contentFilterResponse_;
   public static final int TESTINGPROGRAMOPTRESPONSE_FIELD_NUMBER = 80;
   private TestingProgramOptResponse testingProgramOptResponse_;
   private byte memoizedIsInitialized;
   private static final Payload DEFAULT_INSTANCE = new Payload();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Payload parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Payload(input, extensionRegistry);
      }
   };

   private Payload(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Payload() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Payload();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Payload(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = false;
         UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();

         try {
            boolean done = false;

            while(!done) {
               int tag = input.readTag();
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  ListResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.listResponse_.toBuilder();
                  }

                  this.listResponse_ = (ListResponse)input.readMessage(ListResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.listResponse_);
                     this.listResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
                  break;
               case 18:
                  DetailsResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.detailsResponse_.toBuilder();
                  }

                  this.detailsResponse_ = (DetailsResponse)input.readMessage(DetailsResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.detailsResponse_);
                     this.detailsResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
                  break;
               case 26:
                  ReviewResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 4) != 0) {
                     subBuilder = this.reviewResponse_.toBuilder();
                  }

                  this.reviewResponse_ = (ReviewResponse)input.readMessage(ReviewResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.reviewResponse_);
                     this.reviewResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4;
                  break;
               case 42:
                  SearchResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 8) != 0) {
                     subBuilder = this.searchResponse_.toBuilder();
                  }

                  this.searchResponse_ = (SearchResponse)input.readMessage(SearchResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.searchResponse_);
                     this.searchResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 8;
                  break;
               case 50:
                  TocResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 16) != 0) {
                     subBuilder = this.tocResponse_.toBuilder();
                  }

                  this.tocResponse_ = (TocResponse)input.readMessage(TocResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.tocResponse_);
                     this.tocResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 16;
                  break;
               case 154:
                  BulkDetailsResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 32) != 0) {
                     subBuilder = this.bulkDetailsResponse_.toBuilder();
                  }

                  this.bulkDetailsResponse_ = (BulkDetailsResponse)input.readMessage(BulkDetailsResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.bulkDetailsResponse_);
                     this.bulkDetailsResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 32;
                  break;
               case 170:
                  DeliveryResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 64) != 0) {
                     subBuilder = this.deliveryResponse_.toBuilder();
                  }

                  this.deliveryResponse_ = (DeliveryResponse)input.readMessage(DeliveryResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.deliveryResponse_);
                     this.deliveryResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 64;
                  break;
               case 210:
                  AndroidCheckinResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 128) != 0) {
                     subBuilder = this.androidCheckinResponse_.toBuilder();
                  }

                  this.androidCheckinResponse_ = (AndroidCheckinResponse)input.readMessage(AndroidCheckinResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.androidCheckinResponse_);
                     this.androidCheckinResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 128;
                  break;
               case 218:
                  ModifyLibraryResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 256) != 0) {
                     subBuilder = this.modifyLibraryResponse_.toBuilder();
                  }

                  this.modifyLibraryResponse_ = (ModifyLibraryResponse)input.readMessage(ModifyLibraryResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.modifyLibraryResponse_);
                     this.modifyLibraryResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 256;
                  break;
               case 226:
                  UploadDeviceConfigResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 512) != 0) {
                     subBuilder = this.uploadDeviceConfigResponse_.toBuilder();
                  }

                  this.uploadDeviceConfigResponse_ = (UploadDeviceConfigResponse)input.readMessage(UploadDeviceConfigResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.uploadDeviceConfigResponse_);
                     this.uploadDeviceConfigResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 512;
                  break;
               case 314:
                  SelfUpdateResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 1024) != 0) {
                     subBuilder = this.selfUpdateResponse_.toBuilder();
                  }

                  this.selfUpdateResponse_ = (SelfUpdateResponse)input.readMessage(SelfUpdateResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.selfUpdateResponse_);
                     this.selfUpdateResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1024;
                  break;
               case 386:
                  EarlyUpdateResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 2048) != 0) {
                     subBuilder = this.earlyUpdateResponse_.toBuilder();
                  }

                  this.earlyUpdateResponse_ = (EarlyUpdateResponse)input.readMessage(EarlyUpdateResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.earlyUpdateResponse_);
                     this.earlyUpdateResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2048;
                  break;
               case 394:
                  ContentFilterSettingsResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 4096) != 0) {
                     subBuilder = this.contentFilterResponse_.toBuilder();
                  }

                  this.contentFilterResponse_ = (ContentFilterSettingsResponse)input.readMessage(ContentFilterSettingsResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.contentFilterResponse_);
                     this.contentFilterResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4096;
                  break;
               case 642:
                  TestingProgramOptResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 8192) != 0) {
                     subBuilder = this.testingProgramOptResponse_.toBuilder();
                  }

                  this.testingProgramOptResponse_ = (TestingProgramOptResponse)input.readMessage(TestingProgramOptResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.testingProgramOptResponse_);
                     this.testingProgramOptResponse_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 8192;
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var12) {
            throw var12.setUnfinishedMessage(this);
         } catch (IOException var13) {
            throw (new InvalidProtocolBufferException(var13)).setUnfinishedMessage(this);
         } finally {
            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_Payload_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Payload_fieldAccessorTable.ensureFieldAccessorsInitialized(Payload.class, Payload.Builder.class);
   }

   public boolean hasListResponse() {
      return (this.bitField0_ & 1) != 0;
   }

   public ListResponse getListResponse() {
      return this.listResponse_ == null ? ListResponse.getDefaultInstance() : this.listResponse_;
   }

   public ListResponseOrBuilder getListResponseOrBuilder() {
      return this.listResponse_ == null ? ListResponse.getDefaultInstance() : this.listResponse_;
   }

   public boolean hasDetailsResponse() {
      return (this.bitField0_ & 2) != 0;
   }

   public DetailsResponse getDetailsResponse() {
      return this.detailsResponse_ == null ? DetailsResponse.getDefaultInstance() : this.detailsResponse_;
   }

   public DetailsResponseOrBuilder getDetailsResponseOrBuilder() {
      return this.detailsResponse_ == null ? DetailsResponse.getDefaultInstance() : this.detailsResponse_;
   }

   public boolean hasReviewResponse() {
      return (this.bitField0_ & 4) != 0;
   }

   public ReviewResponse getReviewResponse() {
      return this.reviewResponse_ == null ? ReviewResponse.getDefaultInstance() : this.reviewResponse_;
   }

   public ReviewResponseOrBuilder getReviewResponseOrBuilder() {
      return this.reviewResponse_ == null ? ReviewResponse.getDefaultInstance() : this.reviewResponse_;
   }

   public boolean hasSearchResponse() {
      return (this.bitField0_ & 8) != 0;
   }

   public SearchResponse getSearchResponse() {
      return this.searchResponse_ == null ? SearchResponse.getDefaultInstance() : this.searchResponse_;
   }

   public SearchResponseOrBuilder getSearchResponseOrBuilder() {
      return this.searchResponse_ == null ? SearchResponse.getDefaultInstance() : this.searchResponse_;
   }

   public boolean hasTocResponse() {
      return (this.bitField0_ & 16) != 0;
   }

   public TocResponse getTocResponse() {
      return this.tocResponse_ == null ? TocResponse.getDefaultInstance() : this.tocResponse_;
   }

   public TocResponseOrBuilder getTocResponseOrBuilder() {
      return this.tocResponse_ == null ? TocResponse.getDefaultInstance() : this.tocResponse_;
   }

   public boolean hasBulkDetailsResponse() {
      return (this.bitField0_ & 32) != 0;
   }

   public BulkDetailsResponse getBulkDetailsResponse() {
      return this.bulkDetailsResponse_ == null ? BulkDetailsResponse.getDefaultInstance() : this.bulkDetailsResponse_;
   }

   public BulkDetailsResponseOrBuilder getBulkDetailsResponseOrBuilder() {
      return this.bulkDetailsResponse_ == null ? BulkDetailsResponse.getDefaultInstance() : this.bulkDetailsResponse_;
   }

   public boolean hasDeliveryResponse() {
      return (this.bitField0_ & 64) != 0;
   }

   public DeliveryResponse getDeliveryResponse() {
      return this.deliveryResponse_ == null ? DeliveryResponse.getDefaultInstance() : this.deliveryResponse_;
   }

   public DeliveryResponseOrBuilder getDeliveryResponseOrBuilder() {
      return this.deliveryResponse_ == null ? DeliveryResponse.getDefaultInstance() : this.deliveryResponse_;
   }

   public boolean hasAndroidCheckinResponse() {
      return (this.bitField0_ & 128) != 0;
   }

   public AndroidCheckinResponse getAndroidCheckinResponse() {
      return this.androidCheckinResponse_ == null ? AndroidCheckinResponse.getDefaultInstance() : this.androidCheckinResponse_;
   }

   public AndroidCheckinResponseOrBuilder getAndroidCheckinResponseOrBuilder() {
      return this.androidCheckinResponse_ == null ? AndroidCheckinResponse.getDefaultInstance() : this.androidCheckinResponse_;
   }

   public boolean hasModifyLibraryResponse() {
      return (this.bitField0_ & 256) != 0;
   }

   public ModifyLibraryResponse getModifyLibraryResponse() {
      return this.modifyLibraryResponse_ == null ? ModifyLibraryResponse.getDefaultInstance() : this.modifyLibraryResponse_;
   }

   public ModifyLibraryResponseOrBuilder getModifyLibraryResponseOrBuilder() {
      return this.modifyLibraryResponse_ == null ? ModifyLibraryResponse.getDefaultInstance() : this.modifyLibraryResponse_;
   }

   public boolean hasUploadDeviceConfigResponse() {
      return (this.bitField0_ & 512) != 0;
   }

   public UploadDeviceConfigResponse getUploadDeviceConfigResponse() {
      return this.uploadDeviceConfigResponse_ == null ? UploadDeviceConfigResponse.getDefaultInstance() : this.uploadDeviceConfigResponse_;
   }

   public UploadDeviceConfigResponseOrBuilder getUploadDeviceConfigResponseOrBuilder() {
      return this.uploadDeviceConfigResponse_ == null ? UploadDeviceConfigResponse.getDefaultInstance() : this.uploadDeviceConfigResponse_;
   }

   public boolean hasSelfUpdateResponse() {
      return (this.bitField0_ & 1024) != 0;
   }

   public SelfUpdateResponse getSelfUpdateResponse() {
      return this.selfUpdateResponse_ == null ? SelfUpdateResponse.getDefaultInstance() : this.selfUpdateResponse_;
   }

   public SelfUpdateResponseOrBuilder getSelfUpdateResponseOrBuilder() {
      return this.selfUpdateResponse_ == null ? SelfUpdateResponse.getDefaultInstance() : this.selfUpdateResponse_;
   }

   public boolean hasEarlyUpdateResponse() {
      return (this.bitField0_ & 2048) != 0;
   }

   public EarlyUpdateResponse getEarlyUpdateResponse() {
      return this.earlyUpdateResponse_ == null ? EarlyUpdateResponse.getDefaultInstance() : this.earlyUpdateResponse_;
   }

   public EarlyUpdateResponseOrBuilder getEarlyUpdateResponseOrBuilder() {
      return this.earlyUpdateResponse_ == null ? EarlyUpdateResponse.getDefaultInstance() : this.earlyUpdateResponse_;
   }

   public boolean hasContentFilterResponse() {
      return (this.bitField0_ & 4096) != 0;
   }

   public ContentFilterSettingsResponse getContentFilterResponse() {
      return this.contentFilterResponse_ == null ? ContentFilterSettingsResponse.getDefaultInstance() : this.contentFilterResponse_;
   }

   public ContentFilterSettingsResponseOrBuilder getContentFilterResponseOrBuilder() {
      return this.contentFilterResponse_ == null ? ContentFilterSettingsResponse.getDefaultInstance() : this.contentFilterResponse_;
   }

   public boolean hasTestingProgramOptResponse() {
      return (this.bitField0_ & 8192) != 0;
   }

   public TestingProgramOptResponse getTestingProgramOptResponse() {
      return this.testingProgramOptResponse_ == null ? TestingProgramOptResponse.getDefaultInstance() : this.testingProgramOptResponse_;
   }

   public TestingProgramOptResponseOrBuilder getTestingProgramOptResponseOrBuilder() {
      return this.testingProgramOptResponse_ == null ? TestingProgramOptResponse.getDefaultInstance() : this.testingProgramOptResponse_;
   }

   public final boolean isInitialized() {
      byte isInitialized = this.memoizedIsInitialized;
      if (isInitialized == 1) {
         return true;
      } else if (isInitialized == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream output) throws IOException {
      if ((this.bitField0_ & 1) != 0) {
         output.writeMessage(1, this.getListResponse());
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeMessage(2, this.getDetailsResponse());
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeMessage(3, this.getReviewResponse());
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeMessage(5, this.getSearchResponse());
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeMessage(6, this.getTocResponse());
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeMessage(19, this.getBulkDetailsResponse());
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeMessage(21, this.getDeliveryResponse());
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeMessage(26, this.getAndroidCheckinResponse());
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeMessage(27, this.getModifyLibraryResponse());
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeMessage(28, this.getUploadDeviceConfigResponse());
      }

      if ((this.bitField0_ & 1024) != 0) {
         output.writeMessage(39, this.getSelfUpdateResponse());
      }

      if ((this.bitField0_ & 2048) != 0) {
         output.writeMessage(48, this.getEarlyUpdateResponse());
      }

      if ((this.bitField0_ & 4096) != 0) {
         output.writeMessage(49, this.getContentFilterResponse());
      }

      if ((this.bitField0_ & 8192) != 0) {
         output.writeMessage(80, this.getTestingProgramOptResponse());
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;
         if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(1, this.getListResponse());
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getDetailsResponse());
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(3, this.getReviewResponse());
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(5, this.getSearchResponse());
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeMessageSize(6, this.getTocResponse());
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeMessageSize(19, this.getBulkDetailsResponse());
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeMessageSize(21, this.getDeliveryResponse());
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeMessageSize(26, this.getAndroidCheckinResponse());
         }

         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeMessageSize(27, this.getModifyLibraryResponse());
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeMessageSize(28, this.getUploadDeviceConfigResponse());
         }

         if ((this.bitField0_ & 1024) != 0) {
            size += CodedOutputStream.computeMessageSize(39, this.getSelfUpdateResponse());
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += CodedOutputStream.computeMessageSize(48, this.getEarlyUpdateResponse());
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += CodedOutputStream.computeMessageSize(49, this.getContentFilterResponse());
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += CodedOutputStream.computeMessageSize(80, this.getTestingProgramOptResponse());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Payload)) {
         return super.equals(obj);
      } else {
         Payload other = (Payload)obj;
         if (this.hasListResponse() != other.hasListResponse()) {
            return false;
         } else if (this.hasListResponse() && !this.getListResponse().equals(other.getListResponse())) {
            return false;
         } else if (this.hasDetailsResponse() != other.hasDetailsResponse()) {
            return false;
         } else if (this.hasDetailsResponse() && !this.getDetailsResponse().equals(other.getDetailsResponse())) {
            return false;
         } else if (this.hasReviewResponse() != other.hasReviewResponse()) {
            return false;
         } else if (this.hasReviewResponse() && !this.getReviewResponse().equals(other.getReviewResponse())) {
            return false;
         } else if (this.hasSearchResponse() != other.hasSearchResponse()) {
            return false;
         } else if (this.hasSearchResponse() && !this.getSearchResponse().equals(other.getSearchResponse())) {
            return false;
         } else if (this.hasTocResponse() != other.hasTocResponse()) {
            return false;
         } else if (this.hasTocResponse() && !this.getTocResponse().equals(other.getTocResponse())) {
            return false;
         } else if (this.hasBulkDetailsResponse() != other.hasBulkDetailsResponse()) {
            return false;
         } else if (this.hasBulkDetailsResponse() && !this.getBulkDetailsResponse().equals(other.getBulkDetailsResponse())) {
            return false;
         } else if (this.hasDeliveryResponse() != other.hasDeliveryResponse()) {
            return false;
         } else if (this.hasDeliveryResponse() && !this.getDeliveryResponse().equals(other.getDeliveryResponse())) {
            return false;
         } else if (this.hasAndroidCheckinResponse() != other.hasAndroidCheckinResponse()) {
            return false;
         } else if (this.hasAndroidCheckinResponse() && !this.getAndroidCheckinResponse().equals(other.getAndroidCheckinResponse())) {
            return false;
         } else if (this.hasModifyLibraryResponse() != other.hasModifyLibraryResponse()) {
            return false;
         } else if (this.hasModifyLibraryResponse() && !this.getModifyLibraryResponse().equals(other.getModifyLibraryResponse())) {
            return false;
         } else if (this.hasUploadDeviceConfigResponse() != other.hasUploadDeviceConfigResponse()) {
            return false;
         } else if (this.hasUploadDeviceConfigResponse() && !this.getUploadDeviceConfigResponse().equals(other.getUploadDeviceConfigResponse())) {
            return false;
         } else if (this.hasSelfUpdateResponse() != other.hasSelfUpdateResponse()) {
            return false;
         } else if (this.hasSelfUpdateResponse() && !this.getSelfUpdateResponse().equals(other.getSelfUpdateResponse())) {
            return false;
         } else if (this.hasEarlyUpdateResponse() != other.hasEarlyUpdateResponse()) {
            return false;
         } else if (this.hasEarlyUpdateResponse() && !this.getEarlyUpdateResponse().equals(other.getEarlyUpdateResponse())) {
            return false;
         } else if (this.hasContentFilterResponse() != other.hasContentFilterResponse()) {
            return false;
         } else if (this.hasContentFilterResponse() && !this.getContentFilterResponse().equals(other.getContentFilterResponse())) {
            return false;
         } else if (this.hasTestingProgramOptResponse() != other.hasTestingProgramOptResponse()) {
            return false;
         } else if (this.hasTestingProgramOptResponse() && !this.getTestingProgramOptResponse().equals(other.getTestingProgramOptResponse())) {
            return false;
         } else {
            return this.unknownFields.equals(other.unknownFields);
         }
      }
   }

   public int hashCode() {
      if (this.memoizedHashCode != 0) {
         return this.memoizedHashCode;
      } else {
         int hash = 41;
         int hash = 19 * hash + getDescriptor().hashCode();
         if (this.hasListResponse()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getListResponse().hashCode();
         }

         if (this.hasDetailsResponse()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getDetailsResponse().hashCode();
         }

         if (this.hasReviewResponse()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getReviewResponse().hashCode();
         }

         if (this.hasSearchResponse()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getSearchResponse().hashCode();
         }

         if (this.hasTocResponse()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getTocResponse().hashCode();
         }

         if (this.hasBulkDetailsResponse()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getBulkDetailsResponse().hashCode();
         }

         if (this.hasDeliveryResponse()) {
            hash = 37 * hash + 21;
            hash = 53 * hash + this.getDeliveryResponse().hashCode();
         }

         if (this.hasAndroidCheckinResponse()) {
            hash = 37 * hash + 26;
            hash = 53 * hash + this.getAndroidCheckinResponse().hashCode();
         }

         if (this.hasModifyLibraryResponse()) {
            hash = 37 * hash + 27;
            hash = 53 * hash + this.getModifyLibraryResponse().hashCode();
         }

         if (this.hasUploadDeviceConfigResponse()) {
            hash = 37 * hash + 28;
            hash = 53 * hash + this.getUploadDeviceConfigResponse().hashCode();
         }

         if (this.hasSelfUpdateResponse()) {
            hash = 37 * hash + 39;
            hash = 53 * hash + this.getSelfUpdateResponse().hashCode();
         }

         if (this.hasEarlyUpdateResponse()) {
            hash = 37 * hash + 48;
            hash = 53 * hash + this.getEarlyUpdateResponse().hashCode();
         }

         if (this.hasContentFilterResponse()) {
            hash = 37 * hash + 49;
            hash = 53 * hash + this.getContentFilterResponse().hashCode();
         }

         if (this.hasTestingProgramOptResponse()) {
            hash = 37 * hash + 80;
            hash = 53 * hash + this.getTestingProgramOptResponse().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Payload parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data);
   }

   public static Payload parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Payload parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data);
   }

   public static Payload parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Payload parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data);
   }

   public static Payload parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Payload)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Payload parseFrom(InputStream input) throws IOException {
      return (Payload)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Payload parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Payload)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Payload parseDelimitedFrom(InputStream input) throws IOException {
      return (Payload)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Payload parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Payload)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Payload parseFrom(CodedInputStream input) throws IOException {
      return (Payload)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Payload parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Payload)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Payload.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Payload.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Payload.Builder newBuilder(Payload prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Payload.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Payload.Builder() : (new Payload.Builder()).mergeFrom(this);
   }

   protected Payload.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Payload.Builder builder = new Payload.Builder(parent);
      return builder;
   }

   public static Payload getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Payload getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Payload(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Payload(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements PayloadOrBuilder {
      private int bitField0_;
      private ListResponse listResponse_;
      private SingleFieldBuilderV3 listResponseBuilder_;
      private DetailsResponse detailsResponse_;
      private SingleFieldBuilderV3 detailsResponseBuilder_;
      private ReviewResponse reviewResponse_;
      private SingleFieldBuilderV3 reviewResponseBuilder_;
      private SearchResponse searchResponse_;
      private SingleFieldBuilderV3 searchResponseBuilder_;
      private TocResponse tocResponse_;
      private SingleFieldBuilderV3 tocResponseBuilder_;
      private BulkDetailsResponse bulkDetailsResponse_;
      private SingleFieldBuilderV3 bulkDetailsResponseBuilder_;
      private DeliveryResponse deliveryResponse_;
      private SingleFieldBuilderV3 deliveryResponseBuilder_;
      private AndroidCheckinResponse androidCheckinResponse_;
      private SingleFieldBuilderV3 androidCheckinResponseBuilder_;
      private ModifyLibraryResponse modifyLibraryResponse_;
      private SingleFieldBuilderV3 modifyLibraryResponseBuilder_;
      private UploadDeviceConfigResponse uploadDeviceConfigResponse_;
      private SingleFieldBuilderV3 uploadDeviceConfigResponseBuilder_;
      private SelfUpdateResponse selfUpdateResponse_;
      private SingleFieldBuilderV3 selfUpdateResponseBuilder_;
      private EarlyUpdateResponse earlyUpdateResponse_;
      private SingleFieldBuilderV3 earlyUpdateResponseBuilder_;
      private ContentFilterSettingsResponse contentFilterResponse_;
      private SingleFieldBuilderV3 contentFilterResponseBuilder_;
      private TestingProgramOptResponse testingProgramOptResponse_;
      private SingleFieldBuilderV3 testingProgramOptResponseBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Payload_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Payload_fieldAccessorTable.ensureFieldAccessorsInitialized(Payload.class, Payload.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Payload.alwaysUseFieldBuilders) {
            this.getListResponseFieldBuilder();
            this.getDetailsResponseFieldBuilder();
            this.getReviewResponseFieldBuilder();
            this.getSearchResponseFieldBuilder();
            this.getTocResponseFieldBuilder();
            this.getBulkDetailsResponseFieldBuilder();
            this.getDeliveryResponseFieldBuilder();
            this.getAndroidCheckinResponseFieldBuilder();
            this.getModifyLibraryResponseFieldBuilder();
            this.getUploadDeviceConfigResponseFieldBuilder();
            this.getSelfUpdateResponseFieldBuilder();
            this.getEarlyUpdateResponseFieldBuilder();
            this.getContentFilterResponseFieldBuilder();
            this.getTestingProgramOptResponseFieldBuilder();
         }

      }

      public Payload.Builder clear() {
         super.clear();
         if (this.listResponseBuilder_ == null) {
            this.listResponse_ = null;
         } else {
            this.listResponseBuilder_.clear();
         }

         this.bitField0_ &= -2;
         if (this.detailsResponseBuilder_ == null) {
            this.detailsResponse_ = null;
         } else {
            this.detailsResponseBuilder_.clear();
         }

         this.bitField0_ &= -3;
         if (this.reviewResponseBuilder_ == null) {
            this.reviewResponse_ = null;
         } else {
            this.reviewResponseBuilder_.clear();
         }

         this.bitField0_ &= -5;
         if (this.searchResponseBuilder_ == null) {
            this.searchResponse_ = null;
         } else {
            this.searchResponseBuilder_.clear();
         }

         this.bitField0_ &= -9;
         if (this.tocResponseBuilder_ == null) {
            this.tocResponse_ = null;
         } else {
            this.tocResponseBuilder_.clear();
         }

         this.bitField0_ &= -17;
         if (this.bulkDetailsResponseBuilder_ == null) {
            this.bulkDetailsResponse_ = null;
         } else {
            this.bulkDetailsResponseBuilder_.clear();
         }

         this.bitField0_ &= -33;
         if (this.deliveryResponseBuilder_ == null) {
            this.deliveryResponse_ = null;
         } else {
            this.deliveryResponseBuilder_.clear();
         }

         this.bitField0_ &= -65;
         if (this.androidCheckinResponseBuilder_ == null) {
            this.androidCheckinResponse_ = null;
         } else {
            this.androidCheckinResponseBuilder_.clear();
         }

         this.bitField0_ &= -129;
         if (this.modifyLibraryResponseBuilder_ == null) {
            this.modifyLibraryResponse_ = null;
         } else {
            this.modifyLibraryResponseBuilder_.clear();
         }

         this.bitField0_ &= -257;
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            this.uploadDeviceConfigResponse_ = null;
         } else {
            this.uploadDeviceConfigResponseBuilder_.clear();
         }

         this.bitField0_ &= -513;
         if (this.selfUpdateResponseBuilder_ == null) {
            this.selfUpdateResponse_ = null;
         } else {
            this.selfUpdateResponseBuilder_.clear();
         }

         this.bitField0_ &= -1025;
         if (this.earlyUpdateResponseBuilder_ == null) {
            this.earlyUpdateResponse_ = null;
         } else {
            this.earlyUpdateResponseBuilder_.clear();
         }

         this.bitField0_ &= -2049;
         if (this.contentFilterResponseBuilder_ == null) {
            this.contentFilterResponse_ = null;
         } else {
            this.contentFilterResponseBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         if (this.testingProgramOptResponseBuilder_ == null) {
            this.testingProgramOptResponse_ = null;
         } else {
            this.testingProgramOptResponseBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Payload_descriptor;
      }

      public Payload getDefaultInstanceForType() {
         return Payload.getDefaultInstance();
      }

      public Payload build() {
         Payload result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Payload buildPartial() {
         Payload result = new Payload(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.listResponseBuilder_ == null) {
               result.listResponse_ = this.listResponse_;
            } else {
               result.listResponse_ = (ListResponse)this.listResponseBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.detailsResponseBuilder_ == null) {
               result.detailsResponse_ = this.detailsResponse_;
            } else {
               result.detailsResponse_ = (DetailsResponse)this.detailsResponseBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            if (this.reviewResponseBuilder_ == null) {
               result.reviewResponse_ = this.reviewResponse_;
            } else {
               result.reviewResponse_ = (ReviewResponse)this.reviewResponseBuilder_.build();
            }

            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            if (this.searchResponseBuilder_ == null) {
               result.searchResponse_ = this.searchResponse_;
            } else {
               result.searchResponse_ = (SearchResponse)this.searchResponseBuilder_.build();
            }

            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            if (this.tocResponseBuilder_ == null) {
               result.tocResponse_ = this.tocResponse_;
            } else {
               result.tocResponse_ = (TocResponse)this.tocResponseBuilder_.build();
            }

            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            if (this.bulkDetailsResponseBuilder_ == null) {
               result.bulkDetailsResponse_ = this.bulkDetailsResponse_;
            } else {
               result.bulkDetailsResponse_ = (BulkDetailsResponse)this.bulkDetailsResponseBuilder_.build();
            }

            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            if (this.deliveryResponseBuilder_ == null) {
               result.deliveryResponse_ = this.deliveryResponse_;
            } else {
               result.deliveryResponse_ = (DeliveryResponse)this.deliveryResponseBuilder_.build();
            }

            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            if (this.androidCheckinResponseBuilder_ == null) {
               result.androidCheckinResponse_ = this.androidCheckinResponse_;
            } else {
               result.androidCheckinResponse_ = (AndroidCheckinResponse)this.androidCheckinResponseBuilder_.build();
            }

            to_bitField0_ |= 128;
         }

         if ((from_bitField0_ & 256) != 0) {
            if (this.modifyLibraryResponseBuilder_ == null) {
               result.modifyLibraryResponse_ = this.modifyLibraryResponse_;
            } else {
               result.modifyLibraryResponse_ = (ModifyLibraryResponse)this.modifyLibraryResponseBuilder_.build();
            }

            to_bitField0_ |= 256;
         }

         if ((from_bitField0_ & 512) != 0) {
            if (this.uploadDeviceConfigResponseBuilder_ == null) {
               result.uploadDeviceConfigResponse_ = this.uploadDeviceConfigResponse_;
            } else {
               result.uploadDeviceConfigResponse_ = (UploadDeviceConfigResponse)this.uploadDeviceConfigResponseBuilder_.build();
            }

            to_bitField0_ |= 512;
         }

         if ((from_bitField0_ & 1024) != 0) {
            if (this.selfUpdateResponseBuilder_ == null) {
               result.selfUpdateResponse_ = this.selfUpdateResponse_;
            } else {
               result.selfUpdateResponse_ = (SelfUpdateResponse)this.selfUpdateResponseBuilder_.build();
            }

            to_bitField0_ |= 1024;
         }

         if ((from_bitField0_ & 2048) != 0) {
            if (this.earlyUpdateResponseBuilder_ == null) {
               result.earlyUpdateResponse_ = this.earlyUpdateResponse_;
            } else {
               result.earlyUpdateResponse_ = (EarlyUpdateResponse)this.earlyUpdateResponseBuilder_.build();
            }

            to_bitField0_ |= 2048;
         }

         if ((from_bitField0_ & 4096) != 0) {
            if (this.contentFilterResponseBuilder_ == null) {
               result.contentFilterResponse_ = this.contentFilterResponse_;
            } else {
               result.contentFilterResponse_ = (ContentFilterSettingsResponse)this.contentFilterResponseBuilder_.build();
            }

            to_bitField0_ |= 4096;
         }

         if ((from_bitField0_ & 8192) != 0) {
            if (this.testingProgramOptResponseBuilder_ == null) {
               result.testingProgramOptResponse_ = this.testingProgramOptResponse_;
            } else {
               result.testingProgramOptResponse_ = (TestingProgramOptResponse)this.testingProgramOptResponseBuilder_.build();
            }

            to_bitField0_ |= 8192;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Payload.Builder clone() {
         return (Payload.Builder)super.clone();
      }

      public Payload.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Payload.Builder)super.setField(field, value);
      }

      public Payload.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Payload.Builder)super.clearField(field);
      }

      public Payload.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Payload.Builder)super.clearOneof(oneof);
      }

      public Payload.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Payload.Builder)super.setRepeatedField(field, index, value);
      }

      public Payload.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Payload.Builder)super.addRepeatedField(field, value);
      }

      public Payload.Builder mergeFrom(Message other) {
         if (other instanceof Payload) {
            return this.mergeFrom((Payload)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Payload.Builder mergeFrom(Payload other) {
         if (other == Payload.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasListResponse()) {
               this.mergeListResponse(other.getListResponse());
            }

            if (other.hasDetailsResponse()) {
               this.mergeDetailsResponse(other.getDetailsResponse());
            }

            if (other.hasReviewResponse()) {
               this.mergeReviewResponse(other.getReviewResponse());
            }

            if (other.hasSearchResponse()) {
               this.mergeSearchResponse(other.getSearchResponse());
            }

            if (other.hasTocResponse()) {
               this.mergeTocResponse(other.getTocResponse());
            }

            if (other.hasBulkDetailsResponse()) {
               this.mergeBulkDetailsResponse(other.getBulkDetailsResponse());
            }

            if (other.hasDeliveryResponse()) {
               this.mergeDeliveryResponse(other.getDeliveryResponse());
            }

            if (other.hasAndroidCheckinResponse()) {
               this.mergeAndroidCheckinResponse(other.getAndroidCheckinResponse());
            }

            if (other.hasModifyLibraryResponse()) {
               this.mergeModifyLibraryResponse(other.getModifyLibraryResponse());
            }

            if (other.hasUploadDeviceConfigResponse()) {
               this.mergeUploadDeviceConfigResponse(other.getUploadDeviceConfigResponse());
            }

            if (other.hasSelfUpdateResponse()) {
               this.mergeSelfUpdateResponse(other.getSelfUpdateResponse());
            }

            if (other.hasEarlyUpdateResponse()) {
               this.mergeEarlyUpdateResponse(other.getEarlyUpdateResponse());
            }

            if (other.hasContentFilterResponse()) {
               this.mergeContentFilterResponse(other.getContentFilterResponse());
            }

            if (other.hasTestingProgramOptResponse()) {
               this.mergeTestingProgramOptResponse(other.getTestingProgramOptResponse());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Payload.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Payload parsedMessage = null;

         try {
            parsedMessage = (Payload)Payload.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Payload)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasListResponse() {
         return (this.bitField0_ & 1) != 0;
      }

      public ListResponse getListResponse() {
         if (this.listResponseBuilder_ == null) {
            return this.listResponse_ == null ? ListResponse.getDefaultInstance() : this.listResponse_;
         } else {
            return (ListResponse)this.listResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setListResponse(ListResponse value) {
         if (this.listResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.listResponse_ = value;
            this.onChanged();
         } else {
            this.listResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public Payload.Builder setListResponse(ListResponse.Builder builderForValue) {
         if (this.listResponseBuilder_ == null) {
            this.listResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.listResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public Payload.Builder mergeListResponse(ListResponse value) {
         if (this.listResponseBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.listResponse_ != null && this.listResponse_ != ListResponse.getDefaultInstance()) {
               this.listResponse_ = ListResponse.newBuilder(this.listResponse_).mergeFrom(value).buildPartial();
            } else {
               this.listResponse_ = value;
            }

            this.onChanged();
         } else {
            this.listResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public Payload.Builder clearListResponse() {
         if (this.listResponseBuilder_ == null) {
            this.listResponse_ = null;
            this.onChanged();
         } else {
            this.listResponseBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public ListResponse.Builder getListResponseBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (ListResponse.Builder)this.getListResponseFieldBuilder().getBuilder();
      }

      public ListResponseOrBuilder getListResponseOrBuilder() {
         if (this.listResponseBuilder_ != null) {
            return (ListResponseOrBuilder)this.listResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.listResponse_ == null ? ListResponse.getDefaultInstance() : this.listResponse_;
         }
      }

      private SingleFieldBuilderV3 getListResponseFieldBuilder() {
         if (this.listResponseBuilder_ == null) {
            this.listResponseBuilder_ = new SingleFieldBuilderV3(this.getListResponse(), this.getParentForChildren(), this.isClean());
            this.listResponse_ = null;
         }

         return this.listResponseBuilder_;
      }

      public boolean hasDetailsResponse() {
         return (this.bitField0_ & 2) != 0;
      }

      public DetailsResponse getDetailsResponse() {
         if (this.detailsResponseBuilder_ == null) {
            return this.detailsResponse_ == null ? DetailsResponse.getDefaultInstance() : this.detailsResponse_;
         } else {
            return (DetailsResponse)this.detailsResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setDetailsResponse(DetailsResponse value) {
         if (this.detailsResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.detailsResponse_ = value;
            this.onChanged();
         } else {
            this.detailsResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Payload.Builder setDetailsResponse(DetailsResponse.Builder builderForValue) {
         if (this.detailsResponseBuilder_ == null) {
            this.detailsResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.detailsResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Payload.Builder mergeDetailsResponse(DetailsResponse value) {
         if (this.detailsResponseBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.detailsResponse_ != null && this.detailsResponse_ != DetailsResponse.getDefaultInstance()) {
               this.detailsResponse_ = DetailsResponse.newBuilder(this.detailsResponse_).mergeFrom(value).buildPartial();
            } else {
               this.detailsResponse_ = value;
            }

            this.onChanged();
         } else {
            this.detailsResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Payload.Builder clearDetailsResponse() {
         if (this.detailsResponseBuilder_ == null) {
            this.detailsResponse_ = null;
            this.onChanged();
         } else {
            this.detailsResponseBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public DetailsResponse.Builder getDetailsResponseBuilder() {
         this.bitField0_ |= 2;
         this.onChanged();
         return (DetailsResponse.Builder)this.getDetailsResponseFieldBuilder().getBuilder();
      }

      public DetailsResponseOrBuilder getDetailsResponseOrBuilder() {
         if (this.detailsResponseBuilder_ != null) {
            return (DetailsResponseOrBuilder)this.detailsResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.detailsResponse_ == null ? DetailsResponse.getDefaultInstance() : this.detailsResponse_;
         }
      }

      private SingleFieldBuilderV3 getDetailsResponseFieldBuilder() {
         if (this.detailsResponseBuilder_ == null) {
            this.detailsResponseBuilder_ = new SingleFieldBuilderV3(this.getDetailsResponse(), this.getParentForChildren(), this.isClean());
            this.detailsResponse_ = null;
         }

         return this.detailsResponseBuilder_;
      }

      public boolean hasReviewResponse() {
         return (this.bitField0_ & 4) != 0;
      }

      public ReviewResponse getReviewResponse() {
         if (this.reviewResponseBuilder_ == null) {
            return this.reviewResponse_ == null ? ReviewResponse.getDefaultInstance() : this.reviewResponse_;
         } else {
            return (ReviewResponse)this.reviewResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setReviewResponse(ReviewResponse value) {
         if (this.reviewResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.reviewResponse_ = value;
            this.onChanged();
         } else {
            this.reviewResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Payload.Builder setReviewResponse(ReviewResponse.Builder builderForValue) {
         if (this.reviewResponseBuilder_ == null) {
            this.reviewResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.reviewResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Payload.Builder mergeReviewResponse(ReviewResponse value) {
         if (this.reviewResponseBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0 && this.reviewResponse_ != null && this.reviewResponse_ != ReviewResponse.getDefaultInstance()) {
               this.reviewResponse_ = ReviewResponse.newBuilder(this.reviewResponse_).mergeFrom(value).buildPartial();
            } else {
               this.reviewResponse_ = value;
            }

            this.onChanged();
         } else {
            this.reviewResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Payload.Builder clearReviewResponse() {
         if (this.reviewResponseBuilder_ == null) {
            this.reviewResponse_ = null;
            this.onChanged();
         } else {
            this.reviewResponseBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public ReviewResponse.Builder getReviewResponseBuilder() {
         this.bitField0_ |= 4;
         this.onChanged();
         return (ReviewResponse.Builder)this.getReviewResponseFieldBuilder().getBuilder();
      }

      public ReviewResponseOrBuilder getReviewResponseOrBuilder() {
         if (this.reviewResponseBuilder_ != null) {
            return (ReviewResponseOrBuilder)this.reviewResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.reviewResponse_ == null ? ReviewResponse.getDefaultInstance() : this.reviewResponse_;
         }
      }

      private SingleFieldBuilderV3 getReviewResponseFieldBuilder() {
         if (this.reviewResponseBuilder_ == null) {
            this.reviewResponseBuilder_ = new SingleFieldBuilderV3(this.getReviewResponse(), this.getParentForChildren(), this.isClean());
            this.reviewResponse_ = null;
         }

         return this.reviewResponseBuilder_;
      }

      public boolean hasSearchResponse() {
         return (this.bitField0_ & 8) != 0;
      }

      public SearchResponse getSearchResponse() {
         if (this.searchResponseBuilder_ == null) {
            return this.searchResponse_ == null ? SearchResponse.getDefaultInstance() : this.searchResponse_;
         } else {
            return (SearchResponse)this.searchResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setSearchResponse(SearchResponse value) {
         if (this.searchResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.searchResponse_ = value;
            this.onChanged();
         } else {
            this.searchResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 8;
         return this;
      }

      public Payload.Builder setSearchResponse(SearchResponse.Builder builderForValue) {
         if (this.searchResponseBuilder_ == null) {
            this.searchResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.searchResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 8;
         return this;
      }

      public Payload.Builder mergeSearchResponse(SearchResponse value) {
         if (this.searchResponseBuilder_ == null) {
            if ((this.bitField0_ & 8) != 0 && this.searchResponse_ != null && this.searchResponse_ != SearchResponse.getDefaultInstance()) {
               this.searchResponse_ = SearchResponse.newBuilder(this.searchResponse_).mergeFrom(value).buildPartial();
            } else {
               this.searchResponse_ = value;
            }

            this.onChanged();
         } else {
            this.searchResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 8;
         return this;
      }

      public Payload.Builder clearSearchResponse() {
         if (this.searchResponseBuilder_ == null) {
            this.searchResponse_ = null;
            this.onChanged();
         } else {
            this.searchResponseBuilder_.clear();
         }

         this.bitField0_ &= -9;
         return this;
      }

      public SearchResponse.Builder getSearchResponseBuilder() {
         this.bitField0_ |= 8;
         this.onChanged();
         return (SearchResponse.Builder)this.getSearchResponseFieldBuilder().getBuilder();
      }

      public SearchResponseOrBuilder getSearchResponseOrBuilder() {
         if (this.searchResponseBuilder_ != null) {
            return (SearchResponseOrBuilder)this.searchResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.searchResponse_ == null ? SearchResponse.getDefaultInstance() : this.searchResponse_;
         }
      }

      private SingleFieldBuilderV3 getSearchResponseFieldBuilder() {
         if (this.searchResponseBuilder_ == null) {
            this.searchResponseBuilder_ = new SingleFieldBuilderV3(this.getSearchResponse(), this.getParentForChildren(), this.isClean());
            this.searchResponse_ = null;
         }

         return this.searchResponseBuilder_;
      }

      public boolean hasTocResponse() {
         return (this.bitField0_ & 16) != 0;
      }

      public TocResponse getTocResponse() {
         if (this.tocResponseBuilder_ == null) {
            return this.tocResponse_ == null ? TocResponse.getDefaultInstance() : this.tocResponse_;
         } else {
            return (TocResponse)this.tocResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setTocResponse(TocResponse value) {
         if (this.tocResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.tocResponse_ = value;
            this.onChanged();
         } else {
            this.tocResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public Payload.Builder setTocResponse(TocResponse.Builder builderForValue) {
         if (this.tocResponseBuilder_ == null) {
            this.tocResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.tocResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 16;
         return this;
      }

      public Payload.Builder mergeTocResponse(TocResponse value) {
         if (this.tocResponseBuilder_ == null) {
            if ((this.bitField0_ & 16) != 0 && this.tocResponse_ != null && this.tocResponse_ != TocResponse.getDefaultInstance()) {
               this.tocResponse_ = TocResponse.newBuilder(this.tocResponse_).mergeFrom(value).buildPartial();
            } else {
               this.tocResponse_ = value;
            }

            this.onChanged();
         } else {
            this.tocResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public Payload.Builder clearTocResponse() {
         if (this.tocResponseBuilder_ == null) {
            this.tocResponse_ = null;
            this.onChanged();
         } else {
            this.tocResponseBuilder_.clear();
         }

         this.bitField0_ &= -17;
         return this;
      }

      public TocResponse.Builder getTocResponseBuilder() {
         this.bitField0_ |= 16;
         this.onChanged();
         return (TocResponse.Builder)this.getTocResponseFieldBuilder().getBuilder();
      }

      public TocResponseOrBuilder getTocResponseOrBuilder() {
         if (this.tocResponseBuilder_ != null) {
            return (TocResponseOrBuilder)this.tocResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.tocResponse_ == null ? TocResponse.getDefaultInstance() : this.tocResponse_;
         }
      }

      private SingleFieldBuilderV3 getTocResponseFieldBuilder() {
         if (this.tocResponseBuilder_ == null) {
            this.tocResponseBuilder_ = new SingleFieldBuilderV3(this.getTocResponse(), this.getParentForChildren(), this.isClean());
            this.tocResponse_ = null;
         }

         return this.tocResponseBuilder_;
      }

      public boolean hasBulkDetailsResponse() {
         return (this.bitField0_ & 32) != 0;
      }

      public BulkDetailsResponse getBulkDetailsResponse() {
         if (this.bulkDetailsResponseBuilder_ == null) {
            return this.bulkDetailsResponse_ == null ? BulkDetailsResponse.getDefaultInstance() : this.bulkDetailsResponse_;
         } else {
            return (BulkDetailsResponse)this.bulkDetailsResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setBulkDetailsResponse(BulkDetailsResponse value) {
         if (this.bulkDetailsResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.bulkDetailsResponse_ = value;
            this.onChanged();
         } else {
            this.bulkDetailsResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Payload.Builder setBulkDetailsResponse(BulkDetailsResponse.Builder builderForValue) {
         if (this.bulkDetailsResponseBuilder_ == null) {
            this.bulkDetailsResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.bulkDetailsResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Payload.Builder mergeBulkDetailsResponse(BulkDetailsResponse value) {
         if (this.bulkDetailsResponseBuilder_ == null) {
            if ((this.bitField0_ & 32) != 0 && this.bulkDetailsResponse_ != null && this.bulkDetailsResponse_ != BulkDetailsResponse.getDefaultInstance()) {
               this.bulkDetailsResponse_ = BulkDetailsResponse.newBuilder(this.bulkDetailsResponse_).mergeFrom(value).buildPartial();
            } else {
               this.bulkDetailsResponse_ = value;
            }

            this.onChanged();
         } else {
            this.bulkDetailsResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Payload.Builder clearBulkDetailsResponse() {
         if (this.bulkDetailsResponseBuilder_ == null) {
            this.bulkDetailsResponse_ = null;
            this.onChanged();
         } else {
            this.bulkDetailsResponseBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public BulkDetailsResponse.Builder getBulkDetailsResponseBuilder() {
         this.bitField0_ |= 32;
         this.onChanged();
         return (BulkDetailsResponse.Builder)this.getBulkDetailsResponseFieldBuilder().getBuilder();
      }

      public BulkDetailsResponseOrBuilder getBulkDetailsResponseOrBuilder() {
         if (this.bulkDetailsResponseBuilder_ != null) {
            return (BulkDetailsResponseOrBuilder)this.bulkDetailsResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.bulkDetailsResponse_ == null ? BulkDetailsResponse.getDefaultInstance() : this.bulkDetailsResponse_;
         }
      }

      private SingleFieldBuilderV3 getBulkDetailsResponseFieldBuilder() {
         if (this.bulkDetailsResponseBuilder_ == null) {
            this.bulkDetailsResponseBuilder_ = new SingleFieldBuilderV3(this.getBulkDetailsResponse(), this.getParentForChildren(), this.isClean());
            this.bulkDetailsResponse_ = null;
         }

         return this.bulkDetailsResponseBuilder_;
      }

      public boolean hasDeliveryResponse() {
         return (this.bitField0_ & 64) != 0;
      }

      public DeliveryResponse getDeliveryResponse() {
         if (this.deliveryResponseBuilder_ == null) {
            return this.deliveryResponse_ == null ? DeliveryResponse.getDefaultInstance() : this.deliveryResponse_;
         } else {
            return (DeliveryResponse)this.deliveryResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setDeliveryResponse(DeliveryResponse value) {
         if (this.deliveryResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.deliveryResponse_ = value;
            this.onChanged();
         } else {
            this.deliveryResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Payload.Builder setDeliveryResponse(DeliveryResponse.Builder builderForValue) {
         if (this.deliveryResponseBuilder_ == null) {
            this.deliveryResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.deliveryResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Payload.Builder mergeDeliveryResponse(DeliveryResponse value) {
         if (this.deliveryResponseBuilder_ == null) {
            if ((this.bitField0_ & 64) != 0 && this.deliveryResponse_ != null && this.deliveryResponse_ != DeliveryResponse.getDefaultInstance()) {
               this.deliveryResponse_ = DeliveryResponse.newBuilder(this.deliveryResponse_).mergeFrom(value).buildPartial();
            } else {
               this.deliveryResponse_ = value;
            }

            this.onChanged();
         } else {
            this.deliveryResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Payload.Builder clearDeliveryResponse() {
         if (this.deliveryResponseBuilder_ == null) {
            this.deliveryResponse_ = null;
            this.onChanged();
         } else {
            this.deliveryResponseBuilder_.clear();
         }

         this.bitField0_ &= -65;
         return this;
      }

      public DeliveryResponse.Builder getDeliveryResponseBuilder() {
         this.bitField0_ |= 64;
         this.onChanged();
         return (DeliveryResponse.Builder)this.getDeliveryResponseFieldBuilder().getBuilder();
      }

      public DeliveryResponseOrBuilder getDeliveryResponseOrBuilder() {
         if (this.deliveryResponseBuilder_ != null) {
            return (DeliveryResponseOrBuilder)this.deliveryResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.deliveryResponse_ == null ? DeliveryResponse.getDefaultInstance() : this.deliveryResponse_;
         }
      }

      private SingleFieldBuilderV3 getDeliveryResponseFieldBuilder() {
         if (this.deliveryResponseBuilder_ == null) {
            this.deliveryResponseBuilder_ = new SingleFieldBuilderV3(this.getDeliveryResponse(), this.getParentForChildren(), this.isClean());
            this.deliveryResponse_ = null;
         }

         return this.deliveryResponseBuilder_;
      }

      public boolean hasAndroidCheckinResponse() {
         return (this.bitField0_ & 128) != 0;
      }

      public AndroidCheckinResponse getAndroidCheckinResponse() {
         if (this.androidCheckinResponseBuilder_ == null) {
            return this.androidCheckinResponse_ == null ? AndroidCheckinResponse.getDefaultInstance() : this.androidCheckinResponse_;
         } else {
            return (AndroidCheckinResponse)this.androidCheckinResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setAndroidCheckinResponse(AndroidCheckinResponse value) {
         if (this.androidCheckinResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.androidCheckinResponse_ = value;
            this.onChanged();
         } else {
            this.androidCheckinResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 128;
         return this;
      }

      public Payload.Builder setAndroidCheckinResponse(AndroidCheckinResponse.Builder builderForValue) {
         if (this.androidCheckinResponseBuilder_ == null) {
            this.androidCheckinResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.androidCheckinResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 128;
         return this;
      }

      public Payload.Builder mergeAndroidCheckinResponse(AndroidCheckinResponse value) {
         if (this.androidCheckinResponseBuilder_ == null) {
            if ((this.bitField0_ & 128) != 0 && this.androidCheckinResponse_ != null && this.androidCheckinResponse_ != AndroidCheckinResponse.getDefaultInstance()) {
               this.androidCheckinResponse_ = AndroidCheckinResponse.newBuilder(this.androidCheckinResponse_).mergeFrom(value).buildPartial();
            } else {
               this.androidCheckinResponse_ = value;
            }

            this.onChanged();
         } else {
            this.androidCheckinResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 128;
         return this;
      }

      public Payload.Builder clearAndroidCheckinResponse() {
         if (this.androidCheckinResponseBuilder_ == null) {
            this.androidCheckinResponse_ = null;
            this.onChanged();
         } else {
            this.androidCheckinResponseBuilder_.clear();
         }

         this.bitField0_ &= -129;
         return this;
      }

      public AndroidCheckinResponse.Builder getAndroidCheckinResponseBuilder() {
         this.bitField0_ |= 128;
         this.onChanged();
         return (AndroidCheckinResponse.Builder)this.getAndroidCheckinResponseFieldBuilder().getBuilder();
      }

      public AndroidCheckinResponseOrBuilder getAndroidCheckinResponseOrBuilder() {
         if (this.androidCheckinResponseBuilder_ != null) {
            return (AndroidCheckinResponseOrBuilder)this.androidCheckinResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.androidCheckinResponse_ == null ? AndroidCheckinResponse.getDefaultInstance() : this.androidCheckinResponse_;
         }
      }

      private SingleFieldBuilderV3 getAndroidCheckinResponseFieldBuilder() {
         if (this.androidCheckinResponseBuilder_ == null) {
            this.androidCheckinResponseBuilder_ = new SingleFieldBuilderV3(this.getAndroidCheckinResponse(), this.getParentForChildren(), this.isClean());
            this.androidCheckinResponse_ = null;
         }

         return this.androidCheckinResponseBuilder_;
      }

      public boolean hasModifyLibraryResponse() {
         return (this.bitField0_ & 256) != 0;
      }

      public ModifyLibraryResponse getModifyLibraryResponse() {
         if (this.modifyLibraryResponseBuilder_ == null) {
            return this.modifyLibraryResponse_ == null ? ModifyLibraryResponse.getDefaultInstance() : this.modifyLibraryResponse_;
         } else {
            return (ModifyLibraryResponse)this.modifyLibraryResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setModifyLibraryResponse(ModifyLibraryResponse value) {
         if (this.modifyLibraryResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.modifyLibraryResponse_ = value;
            this.onChanged();
         } else {
            this.modifyLibraryResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 256;
         return this;
      }

      public Payload.Builder setModifyLibraryResponse(ModifyLibraryResponse.Builder builderForValue) {
         if (this.modifyLibraryResponseBuilder_ == null) {
            this.modifyLibraryResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.modifyLibraryResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 256;
         return this;
      }

      public Payload.Builder mergeModifyLibraryResponse(ModifyLibraryResponse value) {
         if (this.modifyLibraryResponseBuilder_ == null) {
            if ((this.bitField0_ & 256) != 0 && this.modifyLibraryResponse_ != null && this.modifyLibraryResponse_ != ModifyLibraryResponse.getDefaultInstance()) {
               this.modifyLibraryResponse_ = ModifyLibraryResponse.newBuilder(this.modifyLibraryResponse_).mergeFrom(value).buildPartial();
            } else {
               this.modifyLibraryResponse_ = value;
            }

            this.onChanged();
         } else {
            this.modifyLibraryResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 256;
         return this;
      }

      public Payload.Builder clearModifyLibraryResponse() {
         if (this.modifyLibraryResponseBuilder_ == null) {
            this.modifyLibraryResponse_ = null;
            this.onChanged();
         } else {
            this.modifyLibraryResponseBuilder_.clear();
         }

         this.bitField0_ &= -257;
         return this;
      }

      public ModifyLibraryResponse.Builder getModifyLibraryResponseBuilder() {
         this.bitField0_ |= 256;
         this.onChanged();
         return (ModifyLibraryResponse.Builder)this.getModifyLibraryResponseFieldBuilder().getBuilder();
      }

      public ModifyLibraryResponseOrBuilder getModifyLibraryResponseOrBuilder() {
         if (this.modifyLibraryResponseBuilder_ != null) {
            return (ModifyLibraryResponseOrBuilder)this.modifyLibraryResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.modifyLibraryResponse_ == null ? ModifyLibraryResponse.getDefaultInstance() : this.modifyLibraryResponse_;
         }
      }

      private SingleFieldBuilderV3 getModifyLibraryResponseFieldBuilder() {
         if (this.modifyLibraryResponseBuilder_ == null) {
            this.modifyLibraryResponseBuilder_ = new SingleFieldBuilderV3(this.getModifyLibraryResponse(), this.getParentForChildren(), this.isClean());
            this.modifyLibraryResponse_ = null;
         }

         return this.modifyLibraryResponseBuilder_;
      }

      public boolean hasUploadDeviceConfigResponse() {
         return (this.bitField0_ & 512) != 0;
      }

      public UploadDeviceConfigResponse getUploadDeviceConfigResponse() {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            return this.uploadDeviceConfigResponse_ == null ? UploadDeviceConfigResponse.getDefaultInstance() : this.uploadDeviceConfigResponse_;
         } else {
            return (UploadDeviceConfigResponse)this.uploadDeviceConfigResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setUploadDeviceConfigResponse(UploadDeviceConfigResponse value) {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.uploadDeviceConfigResponse_ = value;
            this.onChanged();
         } else {
            this.uploadDeviceConfigResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 512;
         return this;
      }

      public Payload.Builder setUploadDeviceConfigResponse(UploadDeviceConfigResponse.Builder builderForValue) {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            this.uploadDeviceConfigResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.uploadDeviceConfigResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 512;
         return this;
      }

      public Payload.Builder mergeUploadDeviceConfigResponse(UploadDeviceConfigResponse value) {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            if ((this.bitField0_ & 512) != 0 && this.uploadDeviceConfigResponse_ != null && this.uploadDeviceConfigResponse_ != UploadDeviceConfigResponse.getDefaultInstance()) {
               this.uploadDeviceConfigResponse_ = UploadDeviceConfigResponse.newBuilder(this.uploadDeviceConfigResponse_).mergeFrom(value).buildPartial();
            } else {
               this.uploadDeviceConfigResponse_ = value;
            }

            this.onChanged();
         } else {
            this.uploadDeviceConfigResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 512;
         return this;
      }

      public Payload.Builder clearUploadDeviceConfigResponse() {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            this.uploadDeviceConfigResponse_ = null;
            this.onChanged();
         } else {
            this.uploadDeviceConfigResponseBuilder_.clear();
         }

         this.bitField0_ &= -513;
         return this;
      }

      public UploadDeviceConfigResponse.Builder getUploadDeviceConfigResponseBuilder() {
         this.bitField0_ |= 512;
         this.onChanged();
         return (UploadDeviceConfigResponse.Builder)this.getUploadDeviceConfigResponseFieldBuilder().getBuilder();
      }

      public UploadDeviceConfigResponseOrBuilder getUploadDeviceConfigResponseOrBuilder() {
         if (this.uploadDeviceConfigResponseBuilder_ != null) {
            return (UploadDeviceConfigResponseOrBuilder)this.uploadDeviceConfigResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.uploadDeviceConfigResponse_ == null ? UploadDeviceConfigResponse.getDefaultInstance() : this.uploadDeviceConfigResponse_;
         }
      }

      private SingleFieldBuilderV3 getUploadDeviceConfigResponseFieldBuilder() {
         if (this.uploadDeviceConfigResponseBuilder_ == null) {
            this.uploadDeviceConfigResponseBuilder_ = new SingleFieldBuilderV3(this.getUploadDeviceConfigResponse(), this.getParentForChildren(), this.isClean());
            this.uploadDeviceConfigResponse_ = null;
         }

         return this.uploadDeviceConfigResponseBuilder_;
      }

      public boolean hasSelfUpdateResponse() {
         return (this.bitField0_ & 1024) != 0;
      }

      public SelfUpdateResponse getSelfUpdateResponse() {
         if (this.selfUpdateResponseBuilder_ == null) {
            return this.selfUpdateResponse_ == null ? SelfUpdateResponse.getDefaultInstance() : this.selfUpdateResponse_;
         } else {
            return (SelfUpdateResponse)this.selfUpdateResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setSelfUpdateResponse(SelfUpdateResponse value) {
         if (this.selfUpdateResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.selfUpdateResponse_ = value;
            this.onChanged();
         } else {
            this.selfUpdateResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1024;
         return this;
      }

      public Payload.Builder setSelfUpdateResponse(SelfUpdateResponse.Builder builderForValue) {
         if (this.selfUpdateResponseBuilder_ == null) {
            this.selfUpdateResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.selfUpdateResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1024;
         return this;
      }

      public Payload.Builder mergeSelfUpdateResponse(SelfUpdateResponse value) {
         if (this.selfUpdateResponseBuilder_ == null) {
            if ((this.bitField0_ & 1024) != 0 && this.selfUpdateResponse_ != null && this.selfUpdateResponse_ != SelfUpdateResponse.getDefaultInstance()) {
               this.selfUpdateResponse_ = SelfUpdateResponse.newBuilder(this.selfUpdateResponse_).mergeFrom(value).buildPartial();
            } else {
               this.selfUpdateResponse_ = value;
            }

            this.onChanged();
         } else {
            this.selfUpdateResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1024;
         return this;
      }

      public Payload.Builder clearSelfUpdateResponse() {
         if (this.selfUpdateResponseBuilder_ == null) {
            this.selfUpdateResponse_ = null;
            this.onChanged();
         } else {
            this.selfUpdateResponseBuilder_.clear();
         }

         this.bitField0_ &= -1025;
         return this;
      }

      public SelfUpdateResponse.Builder getSelfUpdateResponseBuilder() {
         this.bitField0_ |= 1024;
         this.onChanged();
         return (SelfUpdateResponse.Builder)this.getSelfUpdateResponseFieldBuilder().getBuilder();
      }

      public SelfUpdateResponseOrBuilder getSelfUpdateResponseOrBuilder() {
         if (this.selfUpdateResponseBuilder_ != null) {
            return (SelfUpdateResponseOrBuilder)this.selfUpdateResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.selfUpdateResponse_ == null ? SelfUpdateResponse.getDefaultInstance() : this.selfUpdateResponse_;
         }
      }

      private SingleFieldBuilderV3 getSelfUpdateResponseFieldBuilder() {
         if (this.selfUpdateResponseBuilder_ == null) {
            this.selfUpdateResponseBuilder_ = new SingleFieldBuilderV3(this.getSelfUpdateResponse(), this.getParentForChildren(), this.isClean());
            this.selfUpdateResponse_ = null;
         }

         return this.selfUpdateResponseBuilder_;
      }

      public boolean hasEarlyUpdateResponse() {
         return (this.bitField0_ & 2048) != 0;
      }

      public EarlyUpdateResponse getEarlyUpdateResponse() {
         if (this.earlyUpdateResponseBuilder_ == null) {
            return this.earlyUpdateResponse_ == null ? EarlyUpdateResponse.getDefaultInstance() : this.earlyUpdateResponse_;
         } else {
            return (EarlyUpdateResponse)this.earlyUpdateResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setEarlyUpdateResponse(EarlyUpdateResponse value) {
         if (this.earlyUpdateResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.earlyUpdateResponse_ = value;
            this.onChanged();
         } else {
            this.earlyUpdateResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public Payload.Builder setEarlyUpdateResponse(EarlyUpdateResponse.Builder builderForValue) {
         if (this.earlyUpdateResponseBuilder_ == null) {
            this.earlyUpdateResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.earlyUpdateResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public Payload.Builder mergeEarlyUpdateResponse(EarlyUpdateResponse value) {
         if (this.earlyUpdateResponseBuilder_ == null) {
            if ((this.bitField0_ & 2048) != 0 && this.earlyUpdateResponse_ != null && this.earlyUpdateResponse_ != EarlyUpdateResponse.getDefaultInstance()) {
               this.earlyUpdateResponse_ = EarlyUpdateResponse.newBuilder(this.earlyUpdateResponse_).mergeFrom(value).buildPartial();
            } else {
               this.earlyUpdateResponse_ = value;
            }

            this.onChanged();
         } else {
            this.earlyUpdateResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public Payload.Builder clearEarlyUpdateResponse() {
         if (this.earlyUpdateResponseBuilder_ == null) {
            this.earlyUpdateResponse_ = null;
            this.onChanged();
         } else {
            this.earlyUpdateResponseBuilder_.clear();
         }

         this.bitField0_ &= -2049;
         return this;
      }

      public EarlyUpdateResponse.Builder getEarlyUpdateResponseBuilder() {
         this.bitField0_ |= 2048;
         this.onChanged();
         return (EarlyUpdateResponse.Builder)this.getEarlyUpdateResponseFieldBuilder().getBuilder();
      }

      public EarlyUpdateResponseOrBuilder getEarlyUpdateResponseOrBuilder() {
         if (this.earlyUpdateResponseBuilder_ != null) {
            return (EarlyUpdateResponseOrBuilder)this.earlyUpdateResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.earlyUpdateResponse_ == null ? EarlyUpdateResponse.getDefaultInstance() : this.earlyUpdateResponse_;
         }
      }

      private SingleFieldBuilderV3 getEarlyUpdateResponseFieldBuilder() {
         if (this.earlyUpdateResponseBuilder_ == null) {
            this.earlyUpdateResponseBuilder_ = new SingleFieldBuilderV3(this.getEarlyUpdateResponse(), this.getParentForChildren(), this.isClean());
            this.earlyUpdateResponse_ = null;
         }

         return this.earlyUpdateResponseBuilder_;
      }

      public boolean hasContentFilterResponse() {
         return (this.bitField0_ & 4096) != 0;
      }

      public ContentFilterSettingsResponse getContentFilterResponse() {
         if (this.contentFilterResponseBuilder_ == null) {
            return this.contentFilterResponse_ == null ? ContentFilterSettingsResponse.getDefaultInstance() : this.contentFilterResponse_;
         } else {
            return (ContentFilterSettingsResponse)this.contentFilterResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setContentFilterResponse(ContentFilterSettingsResponse value) {
         if (this.contentFilterResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.contentFilterResponse_ = value;
            this.onChanged();
         } else {
            this.contentFilterResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Payload.Builder setContentFilterResponse(ContentFilterSettingsResponse.Builder builderForValue) {
         if (this.contentFilterResponseBuilder_ == null) {
            this.contentFilterResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.contentFilterResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Payload.Builder mergeContentFilterResponse(ContentFilterSettingsResponse value) {
         if (this.contentFilterResponseBuilder_ == null) {
            if ((this.bitField0_ & 4096) != 0 && this.contentFilterResponse_ != null && this.contentFilterResponse_ != ContentFilterSettingsResponse.getDefaultInstance()) {
               this.contentFilterResponse_ = ContentFilterSettingsResponse.newBuilder(this.contentFilterResponse_).mergeFrom(value).buildPartial();
            } else {
               this.contentFilterResponse_ = value;
            }

            this.onChanged();
         } else {
            this.contentFilterResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public Payload.Builder clearContentFilterResponse() {
         if (this.contentFilterResponseBuilder_ == null) {
            this.contentFilterResponse_ = null;
            this.onChanged();
         } else {
            this.contentFilterResponseBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         return this;
      }

      public ContentFilterSettingsResponse.Builder getContentFilterResponseBuilder() {
         this.bitField0_ |= 4096;
         this.onChanged();
         return (ContentFilterSettingsResponse.Builder)this.getContentFilterResponseFieldBuilder().getBuilder();
      }

      public ContentFilterSettingsResponseOrBuilder getContentFilterResponseOrBuilder() {
         if (this.contentFilterResponseBuilder_ != null) {
            return (ContentFilterSettingsResponseOrBuilder)this.contentFilterResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.contentFilterResponse_ == null ? ContentFilterSettingsResponse.getDefaultInstance() : this.contentFilterResponse_;
         }
      }

      private SingleFieldBuilderV3 getContentFilterResponseFieldBuilder() {
         if (this.contentFilterResponseBuilder_ == null) {
            this.contentFilterResponseBuilder_ = new SingleFieldBuilderV3(this.getContentFilterResponse(), this.getParentForChildren(), this.isClean());
            this.contentFilterResponse_ = null;
         }

         return this.contentFilterResponseBuilder_;
      }

      public boolean hasTestingProgramOptResponse() {
         return (this.bitField0_ & 8192) != 0;
      }

      public TestingProgramOptResponse getTestingProgramOptResponse() {
         if (this.testingProgramOptResponseBuilder_ == null) {
            return this.testingProgramOptResponse_ == null ? TestingProgramOptResponse.getDefaultInstance() : this.testingProgramOptResponse_;
         } else {
            return (TestingProgramOptResponse)this.testingProgramOptResponseBuilder_.getMessage();
         }
      }

      public Payload.Builder setTestingProgramOptResponse(TestingProgramOptResponse value) {
         if (this.testingProgramOptResponseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.testingProgramOptResponse_ = value;
            this.onChanged();
         } else {
            this.testingProgramOptResponseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Payload.Builder setTestingProgramOptResponse(TestingProgramOptResponse.Builder builderForValue) {
         if (this.testingProgramOptResponseBuilder_ == null) {
            this.testingProgramOptResponse_ = builderForValue.build();
            this.onChanged();
         } else {
            this.testingProgramOptResponseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Payload.Builder mergeTestingProgramOptResponse(TestingProgramOptResponse value) {
         if (this.testingProgramOptResponseBuilder_ == null) {
            if ((this.bitField0_ & 8192) != 0 && this.testingProgramOptResponse_ != null && this.testingProgramOptResponse_ != TestingProgramOptResponse.getDefaultInstance()) {
               this.testingProgramOptResponse_ = TestingProgramOptResponse.newBuilder(this.testingProgramOptResponse_).mergeFrom(value).buildPartial();
            } else {
               this.testingProgramOptResponse_ = value;
            }

            this.onChanged();
         } else {
            this.testingProgramOptResponseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public Payload.Builder clearTestingProgramOptResponse() {
         if (this.testingProgramOptResponseBuilder_ == null) {
            this.testingProgramOptResponse_ = null;
            this.onChanged();
         } else {
            this.testingProgramOptResponseBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         return this;
      }

      public TestingProgramOptResponse.Builder getTestingProgramOptResponseBuilder() {
         this.bitField0_ |= 8192;
         this.onChanged();
         return (TestingProgramOptResponse.Builder)this.getTestingProgramOptResponseFieldBuilder().getBuilder();
      }

      public TestingProgramOptResponseOrBuilder getTestingProgramOptResponseOrBuilder() {
         if (this.testingProgramOptResponseBuilder_ != null) {
            return (TestingProgramOptResponseOrBuilder)this.testingProgramOptResponseBuilder_.getMessageOrBuilder();
         } else {
            return this.testingProgramOptResponse_ == null ? TestingProgramOptResponse.getDefaultInstance() : this.testingProgramOptResponse_;
         }
      }

      private SingleFieldBuilderV3 getTestingProgramOptResponseFieldBuilder() {
         if (this.testingProgramOptResponseBuilder_ == null) {
            this.testingProgramOptResponseBuilder_ = new SingleFieldBuilderV3(this.getTestingProgramOptResponse(), this.getParentForChildren(), this.isClean());
            this.testingProgramOptResponse_ = null;
         }

         return this.testingProgramOptResponseBuilder_;
      }

      public final Payload.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Payload.Builder)super.setUnknownFields(unknownFields);
      }

      public final Payload.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Payload.Builder)super.mergeUnknownFields(unknownFields);
      }

      // $FF: synthetic method
      Builder(Object x0) {
         this();
      }

      // $FF: synthetic method
      Builder(GeneratedMessageV3.BuilderParent x0, Object x1) {
         this(x0);
      }
   }
}
