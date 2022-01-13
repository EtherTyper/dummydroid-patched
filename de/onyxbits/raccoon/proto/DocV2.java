package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DocV2 extends GeneratedMessageV3 implements DocV2OrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOCID_FIELD_NUMBER = 1;
   private volatile Object docid_;
   public static final int BACKENDDOCID_FIELD_NUMBER = 2;
   private volatile Object backendDocid_;
   public static final int DOCTYPE_FIELD_NUMBER = 3;
   private int docType_;
   public static final int BACKENDID_FIELD_NUMBER = 4;
   private int backendId_;
   public static final int TITLE_FIELD_NUMBER = 5;
   private volatile Object title_;
   public static final int CREATOR_FIELD_NUMBER = 6;
   private volatile Object creator_;
   public static final int DESCRIPTIONHTML_FIELD_NUMBER = 7;
   private volatile Object descriptionHtml_;
   public static final int OFFER_FIELD_NUMBER = 8;
   private List offer_;
   public static final int AVAILABILITY_FIELD_NUMBER = 9;
   private Availability availability_;
   public static final int IMAGE_FIELD_NUMBER = 10;
   private List image_;
   public static final int CHILD_FIELD_NUMBER = 11;
   private List child_;
   public static final int CONTAINERMETADATA_FIELD_NUMBER = 12;
   private ContainerMetadata containerMetadata_;
   public static final int DETAILS_FIELD_NUMBER = 13;
   private DocumentDetails details_;
   public static final int AGGREGATERATING_FIELD_NUMBER = 14;
   private AggregateRating aggregateRating_;
   public static final int ANNOTATIONS_FIELD_NUMBER = 15;
   private Annotations annotations_;
   public static final int REVIEWSURL_FIELD_NUMBER = 18;
   private volatile Object reviewsUrl_;
   public static final int BACKENDURL_FIELD_NUMBER = 19;
   private volatile Object backendUrl_;
   public static final int TRANSLATEDDESCRIPTIONHTML_FIELD_NUMBER = 23;
   private volatile Object translatedDescriptionHtml_;
   public static final int PROMOTIONALDESCRIPTION_FIELD_NUMBER = 27;
   private volatile Object promotionalDescription_;
   public static final int AVAILABLEFORPREREGISTRATION_FIELD_NUMBER = 29;
   private boolean availableForPreregistration_;
   public static final int AUTOTRANSLATEDPROMOTIONALDESCRIPTION_FIELD_NUMBER = 36;
   private volatile Object autoTranslatedPromotionalDescription_;
   public static final int DESCRIPTIONTITLE_FIELD_NUMBER = 44;
   private volatile Object descriptionTitle_;
   public static final int ITEMTYPE_FIELD_NUMBER = 45;
   private int itemType_;
   private byte memoizedIsInitialized;
   private static final DocV2 DEFAULT_INSTANCE = new DocV2();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public DocV2 parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new DocV2(input, extensionRegistry);
      }
   };

   private DocV2(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private DocV2() {
      this.memoizedIsInitialized = -1;
      this.docid_ = "";
      this.backendDocid_ = "";
      this.title_ = "";
      this.creator_ = "";
      this.descriptionHtml_ = "";
      this.offer_ = Collections.emptyList();
      this.image_ = Collections.emptyList();
      this.child_ = Collections.emptyList();
      this.reviewsUrl_ = "";
      this.backendUrl_ = "";
      this.translatedDescriptionHtml_ = "";
      this.promotionalDescription_ = "";
      this.autoTranslatedPromotionalDescription_ = "";
      this.descriptionTitle_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new DocV2();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DocV2(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = 0;
         UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();

         try {
            boolean done = false;

            while(!done) {
               int tag = input.readTag();
               ByteString bs;
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.docid_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.backendDocid_ = bs;
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.docType_ = input.readInt32();
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.backendId_ = input.readInt32();
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.title_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.creator_ = bs;
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.descriptionHtml_ = bs;
                  break;
               case 66:
                  if ((mutable_bitField0_ & 128) == 0) {
                     this.offer_ = new ArrayList();
                     mutable_bitField0_ |= 128;
                  }

                  this.offer_.add(input.readMessage(Offer.PARSER, extensionRegistry));
                  break;
               case 74:
                  Availability.Builder subBuilder = null;
                  if ((this.bitField0_ & 128) != 0) {
                     subBuilder = this.availability_.toBuilder();
                  }

                  this.availability_ = (Availability)input.readMessage(Availability.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.availability_);
                     this.availability_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 128;
                  break;
               case 82:
                  if ((mutable_bitField0_ & 512) == 0) {
                     this.image_ = new ArrayList();
                     mutable_bitField0_ |= 512;
                  }

                  this.image_.add(input.readMessage(Image.PARSER, extensionRegistry));
                  break;
               case 90:
                  if ((mutable_bitField0_ & 1024) == 0) {
                     this.child_ = new ArrayList();
                     mutable_bitField0_ |= 1024;
                  }

                  this.child_.add(input.readMessage(PARSER, extensionRegistry));
                  break;
               case 98:
                  ContainerMetadata.Builder subBuilder = null;
                  if ((this.bitField0_ & 256) != 0) {
                     subBuilder = this.containerMetadata_.toBuilder();
                  }

                  this.containerMetadata_ = (ContainerMetadata)input.readMessage(ContainerMetadata.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.containerMetadata_);
                     this.containerMetadata_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 256;
                  break;
               case 106:
                  DocumentDetails.Builder subBuilder = null;
                  if ((this.bitField0_ & 512) != 0) {
                     subBuilder = this.details_.toBuilder();
                  }

                  this.details_ = (DocumentDetails)input.readMessage(DocumentDetails.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.details_);
                     this.details_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 512;
                  break;
               case 114:
                  AggregateRating.Builder subBuilder = null;
                  if ((this.bitField0_ & 1024) != 0) {
                     subBuilder = this.aggregateRating_.toBuilder();
                  }

                  this.aggregateRating_ = (AggregateRating)input.readMessage(AggregateRating.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.aggregateRating_);
                     this.aggregateRating_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1024;
                  break;
               case 122:
                  Annotations.Builder subBuilder = null;
                  if ((this.bitField0_ & 2048) != 0) {
                     subBuilder = this.annotations_.toBuilder();
                  }

                  this.annotations_ = (Annotations)input.readMessage(Annotations.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.annotations_);
                     this.annotations_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2048;
                  break;
               case 146:
                  bs = input.readBytes();
                  this.bitField0_ |= 4096;
                  this.reviewsUrl_ = bs;
                  break;
               case 154:
                  bs = input.readBytes();
                  this.bitField0_ |= 8192;
                  this.backendUrl_ = bs;
                  break;
               case 186:
                  bs = input.readBytes();
                  this.bitField0_ |= 16384;
                  this.translatedDescriptionHtml_ = bs;
                  break;
               case 218:
                  bs = input.readBytes();
                  this.bitField0_ |= 32768;
                  this.promotionalDescription_ = bs;
                  break;
               case 232:
                  this.bitField0_ |= 65536;
                  this.availableForPreregistration_ = input.readBool();
                  break;
               case 290:
                  bs = input.readBytes();
                  this.bitField0_ |= 131072;
                  this.autoTranslatedPromotionalDescription_ = bs;
                  break;
               case 354:
                  bs = input.readBytes();
                  this.bitField0_ |= 262144;
                  this.descriptionTitle_ = bs;
                  break;
               case 360:
                  this.bitField0_ |= 524288;
                  this.itemType_ = input.readInt32();
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
            if ((mutable_bitField0_ & 128) != 0) {
               this.offer_ = Collections.unmodifiableList(this.offer_);
            }

            if ((mutable_bitField0_ & 512) != 0) {
               this.image_ = Collections.unmodifiableList(this.image_);
            }

            if ((mutable_bitField0_ & 1024) != 0) {
               this.child_ = Collections.unmodifiableList(this.child_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_DocV2_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_DocV2_fieldAccessorTable.ensureFieldAccessorsInitialized(DocV2.class, DocV2.Builder.class);
   }

   public boolean hasDocid() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getDocid() {
      Object ref = this.docid_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.docid_ = s;
         }

         return s;
      }
   }

   public ByteString getDocidBytes() {
      Object ref = this.docid_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.docid_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasBackendDocid() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getBackendDocid() {
      Object ref = this.backendDocid_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.backendDocid_ = s;
         }

         return s;
      }
   }

   public ByteString getBackendDocidBytes() {
      Object ref = this.backendDocid_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.backendDocid_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDocType() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getDocType() {
      return this.docType_;
   }

   public boolean hasBackendId() {
      return (this.bitField0_ & 8) != 0;
   }

   public int getBackendId() {
      return this.backendId_;
   }

   public boolean hasTitle() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getTitle() {
      Object ref = this.title_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.title_ = s;
         }

         return s;
      }
   }

   public ByteString getTitleBytes() {
      Object ref = this.title_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.title_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasCreator() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getCreator() {
      Object ref = this.creator_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.creator_ = s;
         }

         return s;
      }
   }

   public ByteString getCreatorBytes() {
      Object ref = this.creator_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.creator_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDescriptionHtml() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getDescriptionHtml() {
      Object ref = this.descriptionHtml_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.descriptionHtml_ = s;
         }

         return s;
      }
   }

   public ByteString getDescriptionHtmlBytes() {
      Object ref = this.descriptionHtml_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.descriptionHtml_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public List getOfferList() {
      return this.offer_;
   }

   public List getOfferOrBuilderList() {
      return this.offer_;
   }

   public int getOfferCount() {
      return this.offer_.size();
   }

   public Offer getOffer(int index) {
      return (Offer)this.offer_.get(index);
   }

   public OfferOrBuilder getOfferOrBuilder(int index) {
      return (OfferOrBuilder)this.offer_.get(index);
   }

   public boolean hasAvailability() {
      return (this.bitField0_ & 128) != 0;
   }

   public Availability getAvailability() {
      return this.availability_ == null ? Availability.getDefaultInstance() : this.availability_;
   }

   public AvailabilityOrBuilder getAvailabilityOrBuilder() {
      return this.availability_ == null ? Availability.getDefaultInstance() : this.availability_;
   }

   public List getImageList() {
      return this.image_;
   }

   public List getImageOrBuilderList() {
      return this.image_;
   }

   public int getImageCount() {
      return this.image_.size();
   }

   public Image getImage(int index) {
      return (Image)this.image_.get(index);
   }

   public ImageOrBuilder getImageOrBuilder(int index) {
      return (ImageOrBuilder)this.image_.get(index);
   }

   public List getChildList() {
      return this.child_;
   }

   public List getChildOrBuilderList() {
      return this.child_;
   }

   public int getChildCount() {
      return this.child_.size();
   }

   public DocV2 getChild(int index) {
      return (DocV2)this.child_.get(index);
   }

   public DocV2OrBuilder getChildOrBuilder(int index) {
      return (DocV2OrBuilder)this.child_.get(index);
   }

   public boolean hasContainerMetadata() {
      return (this.bitField0_ & 256) != 0;
   }

   public ContainerMetadata getContainerMetadata() {
      return this.containerMetadata_ == null ? ContainerMetadata.getDefaultInstance() : this.containerMetadata_;
   }

   public ContainerMetadataOrBuilder getContainerMetadataOrBuilder() {
      return this.containerMetadata_ == null ? ContainerMetadata.getDefaultInstance() : this.containerMetadata_;
   }

   public boolean hasDetails() {
      return (this.bitField0_ & 512) != 0;
   }

   public DocumentDetails getDetails() {
      return this.details_ == null ? DocumentDetails.getDefaultInstance() : this.details_;
   }

   public DocumentDetailsOrBuilder getDetailsOrBuilder() {
      return this.details_ == null ? DocumentDetails.getDefaultInstance() : this.details_;
   }

   public boolean hasAggregateRating() {
      return (this.bitField0_ & 1024) != 0;
   }

   public AggregateRating getAggregateRating() {
      return this.aggregateRating_ == null ? AggregateRating.getDefaultInstance() : this.aggregateRating_;
   }

   public AggregateRatingOrBuilder getAggregateRatingOrBuilder() {
      return this.aggregateRating_ == null ? AggregateRating.getDefaultInstance() : this.aggregateRating_;
   }

   public boolean hasAnnotations() {
      return (this.bitField0_ & 2048) != 0;
   }

   public Annotations getAnnotations() {
      return this.annotations_ == null ? Annotations.getDefaultInstance() : this.annotations_;
   }

   public AnnotationsOrBuilder getAnnotationsOrBuilder() {
      return this.annotations_ == null ? Annotations.getDefaultInstance() : this.annotations_;
   }

   public boolean hasReviewsUrl() {
      return (this.bitField0_ & 4096) != 0;
   }

   public String getReviewsUrl() {
      Object ref = this.reviewsUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.reviewsUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getReviewsUrlBytes() {
      Object ref = this.reviewsUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.reviewsUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasBackendUrl() {
      return (this.bitField0_ & 8192) != 0;
   }

   public String getBackendUrl() {
      Object ref = this.backendUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.backendUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getBackendUrlBytes() {
      Object ref = this.backendUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.backendUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTranslatedDescriptionHtml() {
      return (this.bitField0_ & 16384) != 0;
   }

   public String getTranslatedDescriptionHtml() {
      Object ref = this.translatedDescriptionHtml_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.translatedDescriptionHtml_ = s;
         }

         return s;
      }
   }

   public ByteString getTranslatedDescriptionHtmlBytes() {
      Object ref = this.translatedDescriptionHtml_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.translatedDescriptionHtml_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasPromotionalDescription() {
      return (this.bitField0_ & '耀') != 0;
   }

   public String getPromotionalDescription() {
      Object ref = this.promotionalDescription_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.promotionalDescription_ = s;
         }

         return s;
      }
   }

   public ByteString getPromotionalDescriptionBytes() {
      Object ref = this.promotionalDescription_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.promotionalDescription_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasAvailableForPreregistration() {
      return (this.bitField0_ & 65536) != 0;
   }

   public boolean getAvailableForPreregistration() {
      return this.availableForPreregistration_;
   }

   public boolean hasAutoTranslatedPromotionalDescription() {
      return (this.bitField0_ & 131072) != 0;
   }

   public String getAutoTranslatedPromotionalDescription() {
      Object ref = this.autoTranslatedPromotionalDescription_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.autoTranslatedPromotionalDescription_ = s;
         }

         return s;
      }
   }

   public ByteString getAutoTranslatedPromotionalDescriptionBytes() {
      Object ref = this.autoTranslatedPromotionalDescription_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.autoTranslatedPromotionalDescription_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDescriptionTitle() {
      return (this.bitField0_ & 262144) != 0;
   }

   public String getDescriptionTitle() {
      Object ref = this.descriptionTitle_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.descriptionTitle_ = s;
         }

         return s;
      }
   }

   public ByteString getDescriptionTitleBytes() {
      Object ref = this.descriptionTitle_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.descriptionTitle_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasItemType() {
      return (this.bitField0_ & 524288) != 0;
   }

   public int getItemType() {
      return this.itemType_;
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
         GeneratedMessageV3.writeString(output, 1, this.docid_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.backendDocid_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.docType_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeInt32(4, this.backendId_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.title_);
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.creator_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.descriptionHtml_);
      }

      int i;
      for(i = 0; i < this.offer_.size(); ++i) {
         output.writeMessage(8, (MessageLite)this.offer_.get(i));
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeMessage(9, this.getAvailability());
      }

      for(i = 0; i < this.image_.size(); ++i) {
         output.writeMessage(10, (MessageLite)this.image_.get(i));
      }

      for(i = 0; i < this.child_.size(); ++i) {
         output.writeMessage(11, (MessageLite)this.child_.get(i));
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeMessage(12, this.getContainerMetadata());
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeMessage(13, this.getDetails());
      }

      if ((this.bitField0_ & 1024) != 0) {
         output.writeMessage(14, this.getAggregateRating());
      }

      if ((this.bitField0_ & 2048) != 0) {
         output.writeMessage(15, this.getAnnotations());
      }

      if ((this.bitField0_ & 4096) != 0) {
         GeneratedMessageV3.writeString(output, 18, this.reviewsUrl_);
      }

      if ((this.bitField0_ & 8192) != 0) {
         GeneratedMessageV3.writeString(output, 19, this.backendUrl_);
      }

      if ((this.bitField0_ & 16384) != 0) {
         GeneratedMessageV3.writeString(output, 23, this.translatedDescriptionHtml_);
      }

      if ((this.bitField0_ & '耀') != 0) {
         GeneratedMessageV3.writeString(output, 27, this.promotionalDescription_);
      }

      if ((this.bitField0_ & 65536) != 0) {
         output.writeBool(29, this.availableForPreregistration_);
      }

      if ((this.bitField0_ & 131072) != 0) {
         GeneratedMessageV3.writeString(output, 36, this.autoTranslatedPromotionalDescription_);
      }

      if ((this.bitField0_ & 262144) != 0) {
         GeneratedMessageV3.writeString(output, 44, this.descriptionTitle_);
      }

      if ((this.bitField0_ & 524288) != 0) {
         output.writeInt32(45, this.itemType_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.docid_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.backendDocid_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.docType_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.backendId_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.title_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.creator_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.descriptionHtml_);
         }

         int i;
         for(i = 0; i < this.offer_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(8, (MessageLite)this.offer_.get(i));
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeMessageSize(9, this.getAvailability());
         }

         for(i = 0; i < this.image_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(10, (MessageLite)this.image_.get(i));
         }

         for(i = 0; i < this.child_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(11, (MessageLite)this.child_.get(i));
         }

         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeMessageSize(12, this.getContainerMetadata());
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeMessageSize(13, this.getDetails());
         }

         if ((this.bitField0_ & 1024) != 0) {
            size += CodedOutputStream.computeMessageSize(14, this.getAggregateRating());
         }

         if ((this.bitField0_ & 2048) != 0) {
            size += CodedOutputStream.computeMessageSize(15, this.getAnnotations());
         }

         if ((this.bitField0_ & 4096) != 0) {
            size += GeneratedMessageV3.computeStringSize(18, this.reviewsUrl_);
         }

         if ((this.bitField0_ & 8192) != 0) {
            size += GeneratedMessageV3.computeStringSize(19, this.backendUrl_);
         }

         if ((this.bitField0_ & 16384) != 0) {
            size += GeneratedMessageV3.computeStringSize(23, this.translatedDescriptionHtml_);
         }

         if ((this.bitField0_ & '耀') != 0) {
            size += GeneratedMessageV3.computeStringSize(27, this.promotionalDescription_);
         }

         if ((this.bitField0_ & 65536) != 0) {
            size += CodedOutputStream.computeBoolSize(29, this.availableForPreregistration_);
         }

         if ((this.bitField0_ & 131072) != 0) {
            size += GeneratedMessageV3.computeStringSize(36, this.autoTranslatedPromotionalDescription_);
         }

         if ((this.bitField0_ & 262144) != 0) {
            size += GeneratedMessageV3.computeStringSize(44, this.descriptionTitle_);
         }

         if ((this.bitField0_ & 524288) != 0) {
            size += CodedOutputStream.computeInt32Size(45, this.itemType_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DocV2)) {
         return super.equals(obj);
      } else {
         DocV2 other = (DocV2)obj;
         if (this.hasDocid() != other.hasDocid()) {
            return false;
         } else if (this.hasDocid() && !this.getDocid().equals(other.getDocid())) {
            return false;
         } else if (this.hasBackendDocid() != other.hasBackendDocid()) {
            return false;
         } else if (this.hasBackendDocid() && !this.getBackendDocid().equals(other.getBackendDocid())) {
            return false;
         } else if (this.hasDocType() != other.hasDocType()) {
            return false;
         } else if (this.hasDocType() && this.getDocType() != other.getDocType()) {
            return false;
         } else if (this.hasBackendId() != other.hasBackendId()) {
            return false;
         } else if (this.hasBackendId() && this.getBackendId() != other.getBackendId()) {
            return false;
         } else if (this.hasTitle() != other.hasTitle()) {
            return false;
         } else if (this.hasTitle() && !this.getTitle().equals(other.getTitle())) {
            return false;
         } else if (this.hasCreator() != other.hasCreator()) {
            return false;
         } else if (this.hasCreator() && !this.getCreator().equals(other.getCreator())) {
            return false;
         } else if (this.hasDescriptionHtml() != other.hasDescriptionHtml()) {
            return false;
         } else if (this.hasDescriptionHtml() && !this.getDescriptionHtml().equals(other.getDescriptionHtml())) {
            return false;
         } else if (!this.getOfferList().equals(other.getOfferList())) {
            return false;
         } else if (this.hasAvailability() != other.hasAvailability()) {
            return false;
         } else if (this.hasAvailability() && !this.getAvailability().equals(other.getAvailability())) {
            return false;
         } else if (!this.getImageList().equals(other.getImageList())) {
            return false;
         } else if (!this.getChildList().equals(other.getChildList())) {
            return false;
         } else if (this.hasContainerMetadata() != other.hasContainerMetadata()) {
            return false;
         } else if (this.hasContainerMetadata() && !this.getContainerMetadata().equals(other.getContainerMetadata())) {
            return false;
         } else if (this.hasDetails() != other.hasDetails()) {
            return false;
         } else if (this.hasDetails() && !this.getDetails().equals(other.getDetails())) {
            return false;
         } else if (this.hasAggregateRating() != other.hasAggregateRating()) {
            return false;
         } else if (this.hasAggregateRating() && !this.getAggregateRating().equals(other.getAggregateRating())) {
            return false;
         } else if (this.hasAnnotations() != other.hasAnnotations()) {
            return false;
         } else if (this.hasAnnotations() && !this.getAnnotations().equals(other.getAnnotations())) {
            return false;
         } else if (this.hasReviewsUrl() != other.hasReviewsUrl()) {
            return false;
         } else if (this.hasReviewsUrl() && !this.getReviewsUrl().equals(other.getReviewsUrl())) {
            return false;
         } else if (this.hasBackendUrl() != other.hasBackendUrl()) {
            return false;
         } else if (this.hasBackendUrl() && !this.getBackendUrl().equals(other.getBackendUrl())) {
            return false;
         } else if (this.hasTranslatedDescriptionHtml() != other.hasTranslatedDescriptionHtml()) {
            return false;
         } else if (this.hasTranslatedDescriptionHtml() && !this.getTranslatedDescriptionHtml().equals(other.getTranslatedDescriptionHtml())) {
            return false;
         } else if (this.hasPromotionalDescription() != other.hasPromotionalDescription()) {
            return false;
         } else if (this.hasPromotionalDescription() && !this.getPromotionalDescription().equals(other.getPromotionalDescription())) {
            return false;
         } else if (this.hasAvailableForPreregistration() != other.hasAvailableForPreregistration()) {
            return false;
         } else if (this.hasAvailableForPreregistration() && this.getAvailableForPreregistration() != other.getAvailableForPreregistration()) {
            return false;
         } else if (this.hasAutoTranslatedPromotionalDescription() != other.hasAutoTranslatedPromotionalDescription()) {
            return false;
         } else if (this.hasAutoTranslatedPromotionalDescription() && !this.getAutoTranslatedPromotionalDescription().equals(other.getAutoTranslatedPromotionalDescription())) {
            return false;
         } else if (this.hasDescriptionTitle() != other.hasDescriptionTitle()) {
            return false;
         } else if (this.hasDescriptionTitle() && !this.getDescriptionTitle().equals(other.getDescriptionTitle())) {
            return false;
         } else if (this.hasItemType() != other.hasItemType()) {
            return false;
         } else if (this.hasItemType() && this.getItemType() != other.getItemType()) {
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
         if (this.hasDocid()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDocid().hashCode();
         }

         if (this.hasBackendDocid()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getBackendDocid().hashCode();
         }

         if (this.hasDocType()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDocType();
         }

         if (this.hasBackendId()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getBackendId();
         }

         if (this.hasTitle()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getTitle().hashCode();
         }

         if (this.hasCreator()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getCreator().hashCode();
         }

         if (this.hasDescriptionHtml()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getDescriptionHtml().hashCode();
         }

         if (this.getOfferCount() > 0) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getOfferList().hashCode();
         }

         if (this.hasAvailability()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getAvailability().hashCode();
         }

         if (this.getImageCount() > 0) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getImageList().hashCode();
         }

         if (this.getChildCount() > 0) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getChildList().hashCode();
         }

         if (this.hasContainerMetadata()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getContainerMetadata().hashCode();
         }

         if (this.hasDetails()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getDetails().hashCode();
         }

         if (this.hasAggregateRating()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getAggregateRating().hashCode();
         }

         if (this.hasAnnotations()) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getAnnotations().hashCode();
         }

         if (this.hasReviewsUrl()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getReviewsUrl().hashCode();
         }

         if (this.hasBackendUrl()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getBackendUrl().hashCode();
         }

         if (this.hasTranslatedDescriptionHtml()) {
            hash = 37 * hash + 23;
            hash = 53 * hash + this.getTranslatedDescriptionHtml().hashCode();
         }

         if (this.hasPromotionalDescription()) {
            hash = 37 * hash + 27;
            hash = 53 * hash + this.getPromotionalDescription().hashCode();
         }

         if (this.hasAvailableForPreregistration()) {
            hash = 37 * hash + 29;
            hash = 53 * hash + Internal.hashBoolean(this.getAvailableForPreregistration());
         }

         if (this.hasAutoTranslatedPromotionalDescription()) {
            hash = 37 * hash + 36;
            hash = 53 * hash + this.getAutoTranslatedPromotionalDescription().hashCode();
         }

         if (this.hasDescriptionTitle()) {
            hash = 37 * hash + 44;
            hash = 53 * hash + this.getDescriptionTitle().hashCode();
         }

         if (this.hasItemType()) {
            hash = 37 * hash + 45;
            hash = 53 * hash + this.getItemType();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static DocV2 parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data);
   }

   public static DocV2 parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocV2 parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data);
   }

   public static DocV2 parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocV2 parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data);
   }

   public static DocV2 parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocV2)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocV2 parseFrom(InputStream input) throws IOException {
      return (DocV2)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DocV2 parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocV2)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static DocV2 parseDelimitedFrom(InputStream input) throws IOException {
      return (DocV2)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static DocV2 parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocV2)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static DocV2 parseFrom(CodedInputStream input) throws IOException {
      return (DocV2)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DocV2 parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocV2)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public DocV2.Builder newBuilderForType() {
      return newBuilder();
   }

   public static DocV2.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DocV2.Builder newBuilder(DocV2 prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public DocV2.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new DocV2.Builder() : (new DocV2.Builder()).mergeFrom(this);
   }

   protected DocV2.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      DocV2.Builder builder = new DocV2.Builder(parent);
      return builder;
   }

   public static DocV2 getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DocV2 getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DocV2(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   DocV2(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DocV2OrBuilder {
      private int bitField0_;
      private Object docid_;
      private Object backendDocid_;
      private int docType_;
      private int backendId_;
      private Object title_;
      private Object creator_;
      private Object descriptionHtml_;
      private List offer_;
      private RepeatedFieldBuilderV3 offerBuilder_;
      private Availability availability_;
      private SingleFieldBuilderV3 availabilityBuilder_;
      private List image_;
      private RepeatedFieldBuilderV3 imageBuilder_;
      private List child_;
      private RepeatedFieldBuilderV3 childBuilder_;
      private ContainerMetadata containerMetadata_;
      private SingleFieldBuilderV3 containerMetadataBuilder_;
      private DocumentDetails details_;
      private SingleFieldBuilderV3 detailsBuilder_;
      private AggregateRating aggregateRating_;
      private SingleFieldBuilderV3 aggregateRatingBuilder_;
      private Annotations annotations_;
      private SingleFieldBuilderV3 annotationsBuilder_;
      private Object reviewsUrl_;
      private Object backendUrl_;
      private Object translatedDescriptionHtml_;
      private Object promotionalDescription_;
      private boolean availableForPreregistration_;
      private Object autoTranslatedPromotionalDescription_;
      private Object descriptionTitle_;
      private int itemType_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_DocV2_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_DocV2_fieldAccessorTable.ensureFieldAccessorsInitialized(DocV2.class, DocV2.Builder.class);
      }

      private Builder() {
         this.docid_ = "";
         this.backendDocid_ = "";
         this.title_ = "";
         this.creator_ = "";
         this.descriptionHtml_ = "";
         this.offer_ = Collections.emptyList();
         this.image_ = Collections.emptyList();
         this.child_ = Collections.emptyList();
         this.reviewsUrl_ = "";
         this.backendUrl_ = "";
         this.translatedDescriptionHtml_ = "";
         this.promotionalDescription_ = "";
         this.autoTranslatedPromotionalDescription_ = "";
         this.descriptionTitle_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.docid_ = "";
         this.backendDocid_ = "";
         this.title_ = "";
         this.creator_ = "";
         this.descriptionHtml_ = "";
         this.offer_ = Collections.emptyList();
         this.image_ = Collections.emptyList();
         this.child_ = Collections.emptyList();
         this.reviewsUrl_ = "";
         this.backendUrl_ = "";
         this.translatedDescriptionHtml_ = "";
         this.promotionalDescription_ = "";
         this.autoTranslatedPromotionalDescription_ = "";
         this.descriptionTitle_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (DocV2.alwaysUseFieldBuilders) {
            this.getOfferFieldBuilder();
            this.getAvailabilityFieldBuilder();
            this.getImageFieldBuilder();
            this.getChildFieldBuilder();
            this.getContainerMetadataFieldBuilder();
            this.getDetailsFieldBuilder();
            this.getAggregateRatingFieldBuilder();
            this.getAnnotationsFieldBuilder();
         }

      }

      public DocV2.Builder clear() {
         super.clear();
         this.docid_ = "";
         this.bitField0_ &= -2;
         this.backendDocid_ = "";
         this.bitField0_ &= -3;
         this.docType_ = 0;
         this.bitField0_ &= -5;
         this.backendId_ = 0;
         this.bitField0_ &= -9;
         this.title_ = "";
         this.bitField0_ &= -17;
         this.creator_ = "";
         this.bitField0_ &= -33;
         this.descriptionHtml_ = "";
         this.bitField0_ &= -65;
         if (this.offerBuilder_ == null) {
            this.offer_ = Collections.emptyList();
            this.bitField0_ &= -129;
         } else {
            this.offerBuilder_.clear();
         }

         if (this.availabilityBuilder_ == null) {
            this.availability_ = null;
         } else {
            this.availabilityBuilder_.clear();
         }

         this.bitField0_ &= -257;
         if (this.imageBuilder_ == null) {
            this.image_ = Collections.emptyList();
            this.bitField0_ &= -513;
         } else {
            this.imageBuilder_.clear();
         }

         if (this.childBuilder_ == null) {
            this.child_ = Collections.emptyList();
            this.bitField0_ &= -1025;
         } else {
            this.childBuilder_.clear();
         }

         if (this.containerMetadataBuilder_ == null) {
            this.containerMetadata_ = null;
         } else {
            this.containerMetadataBuilder_.clear();
         }

         this.bitField0_ &= -2049;
         if (this.detailsBuilder_ == null) {
            this.details_ = null;
         } else {
            this.detailsBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         if (this.aggregateRatingBuilder_ == null) {
            this.aggregateRating_ = null;
         } else {
            this.aggregateRatingBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         if (this.annotationsBuilder_ == null) {
            this.annotations_ = null;
         } else {
            this.annotationsBuilder_.clear();
         }

         this.bitField0_ &= -16385;
         this.reviewsUrl_ = "";
         this.bitField0_ &= -32769;
         this.backendUrl_ = "";
         this.bitField0_ &= -65537;
         this.translatedDescriptionHtml_ = "";
         this.bitField0_ &= -131073;
         this.promotionalDescription_ = "";
         this.bitField0_ &= -262145;
         this.availableForPreregistration_ = false;
         this.bitField0_ &= -524289;
         this.autoTranslatedPromotionalDescription_ = "";
         this.bitField0_ &= -1048577;
         this.descriptionTitle_ = "";
         this.bitField0_ &= -2097153;
         this.itemType_ = 0;
         this.bitField0_ &= -4194305;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_DocV2_descriptor;
      }

      public DocV2 getDefaultInstanceForType() {
         return DocV2.getDefaultInstance();
      }

      public DocV2 build() {
         DocV2 result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public DocV2 buildPartial() {
         DocV2 result = new DocV2(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.docid_ = this.docid_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.backendDocid_ = this.backendDocid_;
         if ((from_bitField0_ & 4) != 0) {
            result.docType_ = this.docType_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.backendId_ = this.backendId_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.title_ = this.title_;
         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 32;
         }

         result.creator_ = this.creator_;
         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 64;
         }

         result.descriptionHtml_ = this.descriptionHtml_;
         if (this.offerBuilder_ == null) {
            if ((this.bitField0_ & 128) != 0) {
               this.offer_ = Collections.unmodifiableList(this.offer_);
               this.bitField0_ &= -129;
            }

            result.offer_ = this.offer_;
         } else {
            result.offer_ = this.offerBuilder_.build();
         }

         if ((from_bitField0_ & 256) != 0) {
            if (this.availabilityBuilder_ == null) {
               result.availability_ = this.availability_;
            } else {
               result.availability_ = (Availability)this.availabilityBuilder_.build();
            }

            to_bitField0_ |= 128;
         }

         if (this.imageBuilder_ == null) {
            if ((this.bitField0_ & 512) != 0) {
               this.image_ = Collections.unmodifiableList(this.image_);
               this.bitField0_ &= -513;
            }

            result.image_ = this.image_;
         } else {
            result.image_ = this.imageBuilder_.build();
         }

         if (this.childBuilder_ == null) {
            if ((this.bitField0_ & 1024) != 0) {
               this.child_ = Collections.unmodifiableList(this.child_);
               this.bitField0_ &= -1025;
            }

            result.child_ = this.child_;
         } else {
            result.child_ = this.childBuilder_.build();
         }

         if ((from_bitField0_ & 2048) != 0) {
            if (this.containerMetadataBuilder_ == null) {
               result.containerMetadata_ = this.containerMetadata_;
            } else {
               result.containerMetadata_ = (ContainerMetadata)this.containerMetadataBuilder_.build();
            }

            to_bitField0_ |= 256;
         }

         if ((from_bitField0_ & 4096) != 0) {
            if (this.detailsBuilder_ == null) {
               result.details_ = this.details_;
            } else {
               result.details_ = (DocumentDetails)this.detailsBuilder_.build();
            }

            to_bitField0_ |= 512;
         }

         if ((from_bitField0_ & 8192) != 0) {
            if (this.aggregateRatingBuilder_ == null) {
               result.aggregateRating_ = this.aggregateRating_;
            } else {
               result.aggregateRating_ = (AggregateRating)this.aggregateRatingBuilder_.build();
            }

            to_bitField0_ |= 1024;
         }

         if ((from_bitField0_ & 16384) != 0) {
            if (this.annotationsBuilder_ == null) {
               result.annotations_ = this.annotations_;
            } else {
               result.annotations_ = (Annotations)this.annotationsBuilder_.build();
            }

            to_bitField0_ |= 2048;
         }

         if ((from_bitField0_ & '耀') != 0) {
            to_bitField0_ |= 4096;
         }

         result.reviewsUrl_ = this.reviewsUrl_;
         if ((from_bitField0_ & 65536) != 0) {
            to_bitField0_ |= 8192;
         }

         result.backendUrl_ = this.backendUrl_;
         if ((from_bitField0_ & 131072) != 0) {
            to_bitField0_ |= 16384;
         }

         result.translatedDescriptionHtml_ = this.translatedDescriptionHtml_;
         if ((from_bitField0_ & 262144) != 0) {
            to_bitField0_ |= 32768;
         }

         result.promotionalDescription_ = this.promotionalDescription_;
         if ((from_bitField0_ & 524288) != 0) {
            result.availableForPreregistration_ = this.availableForPreregistration_;
            to_bitField0_ |= 65536;
         }

         if ((from_bitField0_ & 1048576) != 0) {
            to_bitField0_ |= 131072;
         }

         result.autoTranslatedPromotionalDescription_ = this.autoTranslatedPromotionalDescription_;
         if ((from_bitField0_ & 2097152) != 0) {
            to_bitField0_ |= 262144;
         }

         result.descriptionTitle_ = this.descriptionTitle_;
         if ((from_bitField0_ & 4194304) != 0) {
            result.itemType_ = this.itemType_;
            to_bitField0_ |= 524288;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public DocV2.Builder clone() {
         return (DocV2.Builder)super.clone();
      }

      public DocV2.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (DocV2.Builder)super.setField(field, value);
      }

      public DocV2.Builder clearField(Descriptors.FieldDescriptor field) {
         return (DocV2.Builder)super.clearField(field);
      }

      public DocV2.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (DocV2.Builder)super.clearOneof(oneof);
      }

      public DocV2.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (DocV2.Builder)super.setRepeatedField(field, index, value);
      }

      public DocV2.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (DocV2.Builder)super.addRepeatedField(field, value);
      }

      public DocV2.Builder mergeFrom(Message other) {
         if (other instanceof DocV2) {
            return this.mergeFrom((DocV2)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public DocV2.Builder mergeFrom(DocV2 other) {
         if (other == DocV2.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDocid()) {
               this.bitField0_ |= 1;
               this.docid_ = other.docid_;
               this.onChanged();
            }

            if (other.hasBackendDocid()) {
               this.bitField0_ |= 2;
               this.backendDocid_ = other.backendDocid_;
               this.onChanged();
            }

            if (other.hasDocType()) {
               this.setDocType(other.getDocType());
            }

            if (other.hasBackendId()) {
               this.setBackendId(other.getBackendId());
            }

            if (other.hasTitle()) {
               this.bitField0_ |= 16;
               this.title_ = other.title_;
               this.onChanged();
            }

            if (other.hasCreator()) {
               this.bitField0_ |= 32;
               this.creator_ = other.creator_;
               this.onChanged();
            }

            if (other.hasDescriptionHtml()) {
               this.bitField0_ |= 64;
               this.descriptionHtml_ = other.descriptionHtml_;
               this.onChanged();
            }

            if (this.offerBuilder_ == null) {
               if (!other.offer_.isEmpty()) {
                  if (this.offer_.isEmpty()) {
                     this.offer_ = other.offer_;
                     this.bitField0_ &= -129;
                  } else {
                     this.ensureOfferIsMutable();
                     this.offer_.addAll(other.offer_);
                  }

                  this.onChanged();
               }
            } else if (!other.offer_.isEmpty()) {
               if (this.offerBuilder_.isEmpty()) {
                  this.offerBuilder_.dispose();
                  this.offerBuilder_ = null;
                  this.offer_ = other.offer_;
                  this.bitField0_ &= -129;
                  this.offerBuilder_ = DocV2.alwaysUseFieldBuilders ? this.getOfferFieldBuilder() : null;
               } else {
                  this.offerBuilder_.addAllMessages(other.offer_);
               }
            }

            if (other.hasAvailability()) {
               this.mergeAvailability(other.getAvailability());
            }

            if (this.imageBuilder_ == null) {
               if (!other.image_.isEmpty()) {
                  if (this.image_.isEmpty()) {
                     this.image_ = other.image_;
                     this.bitField0_ &= -513;
                  } else {
                     this.ensureImageIsMutable();
                     this.image_.addAll(other.image_);
                  }

                  this.onChanged();
               }
            } else if (!other.image_.isEmpty()) {
               if (this.imageBuilder_.isEmpty()) {
                  this.imageBuilder_.dispose();
                  this.imageBuilder_ = null;
                  this.image_ = other.image_;
                  this.bitField0_ &= -513;
                  this.imageBuilder_ = DocV2.alwaysUseFieldBuilders ? this.getImageFieldBuilder() : null;
               } else {
                  this.imageBuilder_.addAllMessages(other.image_);
               }
            }

            if (this.childBuilder_ == null) {
               if (!other.child_.isEmpty()) {
                  if (this.child_.isEmpty()) {
                     this.child_ = other.child_;
                     this.bitField0_ &= -1025;
                  } else {
                     this.ensureChildIsMutable();
                     this.child_.addAll(other.child_);
                  }

                  this.onChanged();
               }
            } else if (!other.child_.isEmpty()) {
               if (this.childBuilder_.isEmpty()) {
                  this.childBuilder_.dispose();
                  this.childBuilder_ = null;
                  this.child_ = other.child_;
                  this.bitField0_ &= -1025;
                  this.childBuilder_ = DocV2.alwaysUseFieldBuilders ? this.getChildFieldBuilder() : null;
               } else {
                  this.childBuilder_.addAllMessages(other.child_);
               }
            }

            if (other.hasContainerMetadata()) {
               this.mergeContainerMetadata(other.getContainerMetadata());
            }

            if (other.hasDetails()) {
               this.mergeDetails(other.getDetails());
            }

            if (other.hasAggregateRating()) {
               this.mergeAggregateRating(other.getAggregateRating());
            }

            if (other.hasAnnotations()) {
               this.mergeAnnotations(other.getAnnotations());
            }

            if (other.hasReviewsUrl()) {
               this.bitField0_ |= 32768;
               this.reviewsUrl_ = other.reviewsUrl_;
               this.onChanged();
            }

            if (other.hasBackendUrl()) {
               this.bitField0_ |= 65536;
               this.backendUrl_ = other.backendUrl_;
               this.onChanged();
            }

            if (other.hasTranslatedDescriptionHtml()) {
               this.bitField0_ |= 131072;
               this.translatedDescriptionHtml_ = other.translatedDescriptionHtml_;
               this.onChanged();
            }

            if (other.hasPromotionalDescription()) {
               this.bitField0_ |= 262144;
               this.promotionalDescription_ = other.promotionalDescription_;
               this.onChanged();
            }

            if (other.hasAvailableForPreregistration()) {
               this.setAvailableForPreregistration(other.getAvailableForPreregistration());
            }

            if (other.hasAutoTranslatedPromotionalDescription()) {
               this.bitField0_ |= 1048576;
               this.autoTranslatedPromotionalDescription_ = other.autoTranslatedPromotionalDescription_;
               this.onChanged();
            }

            if (other.hasDescriptionTitle()) {
               this.bitField0_ |= 2097152;
               this.descriptionTitle_ = other.descriptionTitle_;
               this.onChanged();
            }

            if (other.hasItemType()) {
               this.setItemType(other.getItemType());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public DocV2.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         DocV2 parsedMessage = null;

         try {
            parsedMessage = (DocV2)DocV2.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (DocV2)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDocid() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getDocid() {
         Object ref = this.docid_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.docid_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDocidBytes() {
         Object ref = this.docid_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.docid_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setDocid(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.docid_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearDocid() {
         this.bitField0_ &= -2;
         this.docid_ = DocV2.getDefaultInstance().getDocid();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setDocidBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.docid_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasBackendDocid() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getBackendDocid() {
         Object ref = this.backendDocid_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.backendDocid_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getBackendDocidBytes() {
         Object ref = this.backendDocid_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.backendDocid_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setBackendDocid(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.backendDocid_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearBackendDocid() {
         this.bitField0_ &= -3;
         this.backendDocid_ = DocV2.getDefaultInstance().getBackendDocid();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setBackendDocidBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.backendDocid_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDocType() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getDocType() {
         return this.docType_;
      }

      public DocV2.Builder setDocType(int value) {
         this.bitField0_ |= 4;
         this.docType_ = value;
         this.onChanged();
         return this;
      }

      public DocV2.Builder clearDocType() {
         this.bitField0_ &= -5;
         this.docType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasBackendId() {
         return (this.bitField0_ & 8) != 0;
      }

      public int getBackendId() {
         return this.backendId_;
      }

      public DocV2.Builder setBackendId(int value) {
         this.bitField0_ |= 8;
         this.backendId_ = value;
         this.onChanged();
         return this;
      }

      public DocV2.Builder clearBackendId() {
         this.bitField0_ &= -9;
         this.backendId_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasTitle() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getTitle() {
         Object ref = this.title_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.title_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTitleBytes() {
         Object ref = this.title_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.title_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearTitle() {
         this.bitField0_ &= -17;
         this.title_ = DocV2.getDefaultInstance().getTitle();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasCreator() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getCreator() {
         Object ref = this.creator_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.creator_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCreatorBytes() {
         Object ref = this.creator_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.creator_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setCreator(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.creator_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearCreator() {
         this.bitField0_ &= -33;
         this.creator_ = DocV2.getDefaultInstance().getCreator();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setCreatorBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.creator_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDescriptionHtml() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getDescriptionHtml() {
         Object ref = this.descriptionHtml_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.descriptionHtml_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDescriptionHtmlBytes() {
         Object ref = this.descriptionHtml_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.descriptionHtml_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setDescriptionHtml(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.descriptionHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearDescriptionHtml() {
         this.bitField0_ &= -65;
         this.descriptionHtml_ = DocV2.getDefaultInstance().getDescriptionHtml();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setDescriptionHtmlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.descriptionHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureOfferIsMutable() {
         if ((this.bitField0_ & 128) == 0) {
            this.offer_ = new ArrayList(this.offer_);
            this.bitField0_ |= 128;
         }

      }

      public List getOfferList() {
         return this.offerBuilder_ == null ? Collections.unmodifiableList(this.offer_) : this.offerBuilder_.getMessageList();
      }

      public int getOfferCount() {
         return this.offerBuilder_ == null ? this.offer_.size() : this.offerBuilder_.getCount();
      }

      public Offer getOffer(int index) {
         return this.offerBuilder_ == null ? (Offer)this.offer_.get(index) : (Offer)this.offerBuilder_.getMessage(index);
      }

      public DocV2.Builder setOffer(int index, Offer value) {
         if (this.offerBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureOfferIsMutable();
            this.offer_.set(index, value);
            this.onChanged();
         } else {
            this.offerBuilder_.setMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder setOffer(int index, Offer.Builder builderForValue) {
         if (this.offerBuilder_ == null) {
            this.ensureOfferIsMutable();
            this.offer_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.offerBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addOffer(Offer value) {
         if (this.offerBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureOfferIsMutable();
            this.offer_.add(value);
            this.onChanged();
         } else {
            this.offerBuilder_.addMessage(value);
         }

         return this;
      }

      public DocV2.Builder addOffer(int index, Offer value) {
         if (this.offerBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureOfferIsMutable();
            this.offer_.add(index, value);
            this.onChanged();
         } else {
            this.offerBuilder_.addMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder addOffer(Offer.Builder builderForValue) {
         if (this.offerBuilder_ == null) {
            this.ensureOfferIsMutable();
            this.offer_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.offerBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addOffer(int index, Offer.Builder builderForValue) {
         if (this.offerBuilder_ == null) {
            this.ensureOfferIsMutable();
            this.offer_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.offerBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addAllOffer(Iterable values) {
         if (this.offerBuilder_ == null) {
            this.ensureOfferIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.offer_);
            this.onChanged();
         } else {
            this.offerBuilder_.addAllMessages(values);
         }

         return this;
      }

      public DocV2.Builder clearOffer() {
         if (this.offerBuilder_ == null) {
            this.offer_ = Collections.emptyList();
            this.bitField0_ &= -129;
            this.onChanged();
         } else {
            this.offerBuilder_.clear();
         }

         return this;
      }

      public DocV2.Builder removeOffer(int index) {
         if (this.offerBuilder_ == null) {
            this.ensureOfferIsMutable();
            this.offer_.remove(index);
            this.onChanged();
         } else {
            this.offerBuilder_.remove(index);
         }

         return this;
      }

      public Offer.Builder getOfferBuilder(int index) {
         return (Offer.Builder)this.getOfferFieldBuilder().getBuilder(index);
      }

      public OfferOrBuilder getOfferOrBuilder(int index) {
         return this.offerBuilder_ == null ? (OfferOrBuilder)this.offer_.get(index) : (OfferOrBuilder)this.offerBuilder_.getMessageOrBuilder(index);
      }

      public List getOfferOrBuilderList() {
         return this.offerBuilder_ != null ? this.offerBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.offer_);
      }

      public Offer.Builder addOfferBuilder() {
         return (Offer.Builder)this.getOfferFieldBuilder().addBuilder(Offer.getDefaultInstance());
      }

      public Offer.Builder addOfferBuilder(int index) {
         return (Offer.Builder)this.getOfferFieldBuilder().addBuilder(index, Offer.getDefaultInstance());
      }

      public List getOfferBuilderList() {
         return this.getOfferFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getOfferFieldBuilder() {
         if (this.offerBuilder_ == null) {
            this.offerBuilder_ = new RepeatedFieldBuilderV3(this.offer_, (this.bitField0_ & 128) != 0, this.getParentForChildren(), this.isClean());
            this.offer_ = null;
         }

         return this.offerBuilder_;
      }

      public boolean hasAvailability() {
         return (this.bitField0_ & 256) != 0;
      }

      public Availability getAvailability() {
         if (this.availabilityBuilder_ == null) {
            return this.availability_ == null ? Availability.getDefaultInstance() : this.availability_;
         } else {
            return (Availability)this.availabilityBuilder_.getMessage();
         }
      }

      public DocV2.Builder setAvailability(Availability value) {
         if (this.availabilityBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.availability_ = value;
            this.onChanged();
         } else {
            this.availabilityBuilder_.setMessage(value);
         }

         this.bitField0_ |= 256;
         return this;
      }

      public DocV2.Builder setAvailability(Availability.Builder builderForValue) {
         if (this.availabilityBuilder_ == null) {
            this.availability_ = builderForValue.build();
            this.onChanged();
         } else {
            this.availabilityBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 256;
         return this;
      }

      public DocV2.Builder mergeAvailability(Availability value) {
         if (this.availabilityBuilder_ == null) {
            if ((this.bitField0_ & 256) != 0 && this.availability_ != null && this.availability_ != Availability.getDefaultInstance()) {
               this.availability_ = Availability.newBuilder(this.availability_).mergeFrom(value).buildPartial();
            } else {
               this.availability_ = value;
            }

            this.onChanged();
         } else {
            this.availabilityBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 256;
         return this;
      }

      public DocV2.Builder clearAvailability() {
         if (this.availabilityBuilder_ == null) {
            this.availability_ = null;
            this.onChanged();
         } else {
            this.availabilityBuilder_.clear();
         }

         this.bitField0_ &= -257;
         return this;
      }

      public Availability.Builder getAvailabilityBuilder() {
         this.bitField0_ |= 256;
         this.onChanged();
         return (Availability.Builder)this.getAvailabilityFieldBuilder().getBuilder();
      }

      public AvailabilityOrBuilder getAvailabilityOrBuilder() {
         if (this.availabilityBuilder_ != null) {
            return (AvailabilityOrBuilder)this.availabilityBuilder_.getMessageOrBuilder();
         } else {
            return this.availability_ == null ? Availability.getDefaultInstance() : this.availability_;
         }
      }

      private SingleFieldBuilderV3 getAvailabilityFieldBuilder() {
         if (this.availabilityBuilder_ == null) {
            this.availabilityBuilder_ = new SingleFieldBuilderV3(this.getAvailability(), this.getParentForChildren(), this.isClean());
            this.availability_ = null;
         }

         return this.availabilityBuilder_;
      }

      private void ensureImageIsMutable() {
         if ((this.bitField0_ & 512) == 0) {
            this.image_ = new ArrayList(this.image_);
            this.bitField0_ |= 512;
         }

      }

      public List getImageList() {
         return this.imageBuilder_ == null ? Collections.unmodifiableList(this.image_) : this.imageBuilder_.getMessageList();
      }

      public int getImageCount() {
         return this.imageBuilder_ == null ? this.image_.size() : this.imageBuilder_.getCount();
      }

      public Image getImage(int index) {
         return this.imageBuilder_ == null ? (Image)this.image_.get(index) : (Image)this.imageBuilder_.getMessage(index);
      }

      public DocV2.Builder setImage(int index, Image value) {
         if (this.imageBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureImageIsMutable();
            this.image_.set(index, value);
            this.onChanged();
         } else {
            this.imageBuilder_.setMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder setImage(int index, Image.Builder builderForValue) {
         if (this.imageBuilder_ == null) {
            this.ensureImageIsMutable();
            this.image_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.imageBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addImage(Image value) {
         if (this.imageBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureImageIsMutable();
            this.image_.add(value);
            this.onChanged();
         } else {
            this.imageBuilder_.addMessage(value);
         }

         return this;
      }

      public DocV2.Builder addImage(int index, Image value) {
         if (this.imageBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureImageIsMutable();
            this.image_.add(index, value);
            this.onChanged();
         } else {
            this.imageBuilder_.addMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder addImage(Image.Builder builderForValue) {
         if (this.imageBuilder_ == null) {
            this.ensureImageIsMutable();
            this.image_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.imageBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addImage(int index, Image.Builder builderForValue) {
         if (this.imageBuilder_ == null) {
            this.ensureImageIsMutable();
            this.image_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.imageBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addAllImage(Iterable values) {
         if (this.imageBuilder_ == null) {
            this.ensureImageIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.image_);
            this.onChanged();
         } else {
            this.imageBuilder_.addAllMessages(values);
         }

         return this;
      }

      public DocV2.Builder clearImage() {
         if (this.imageBuilder_ == null) {
            this.image_ = Collections.emptyList();
            this.bitField0_ &= -513;
            this.onChanged();
         } else {
            this.imageBuilder_.clear();
         }

         return this;
      }

      public DocV2.Builder removeImage(int index) {
         if (this.imageBuilder_ == null) {
            this.ensureImageIsMutable();
            this.image_.remove(index);
            this.onChanged();
         } else {
            this.imageBuilder_.remove(index);
         }

         return this;
      }

      public Image.Builder getImageBuilder(int index) {
         return (Image.Builder)this.getImageFieldBuilder().getBuilder(index);
      }

      public ImageOrBuilder getImageOrBuilder(int index) {
         return this.imageBuilder_ == null ? (ImageOrBuilder)this.image_.get(index) : (ImageOrBuilder)this.imageBuilder_.getMessageOrBuilder(index);
      }

      public List getImageOrBuilderList() {
         return this.imageBuilder_ != null ? this.imageBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.image_);
      }

      public Image.Builder addImageBuilder() {
         return (Image.Builder)this.getImageFieldBuilder().addBuilder(Image.getDefaultInstance());
      }

      public Image.Builder addImageBuilder(int index) {
         return (Image.Builder)this.getImageFieldBuilder().addBuilder(index, Image.getDefaultInstance());
      }

      public List getImageBuilderList() {
         return this.getImageFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getImageFieldBuilder() {
         if (this.imageBuilder_ == null) {
            this.imageBuilder_ = new RepeatedFieldBuilderV3(this.image_, (this.bitField0_ & 512) != 0, this.getParentForChildren(), this.isClean());
            this.image_ = null;
         }

         return this.imageBuilder_;
      }

      private void ensureChildIsMutable() {
         if ((this.bitField0_ & 1024) == 0) {
            this.child_ = new ArrayList(this.child_);
            this.bitField0_ |= 1024;
         }

      }

      public List getChildList() {
         return this.childBuilder_ == null ? Collections.unmodifiableList(this.child_) : this.childBuilder_.getMessageList();
      }

      public int getChildCount() {
         return this.childBuilder_ == null ? this.child_.size() : this.childBuilder_.getCount();
      }

      public DocV2 getChild(int index) {
         return this.childBuilder_ == null ? (DocV2)this.child_.get(index) : (DocV2)this.childBuilder_.getMessage(index);
      }

      public DocV2.Builder setChild(int index, DocV2 value) {
         if (this.childBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureChildIsMutable();
            this.child_.set(index, value);
            this.onChanged();
         } else {
            this.childBuilder_.setMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder setChild(int index, DocV2.Builder builderForValue) {
         if (this.childBuilder_ == null) {
            this.ensureChildIsMutable();
            this.child_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.childBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addChild(DocV2 value) {
         if (this.childBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureChildIsMutable();
            this.child_.add(value);
            this.onChanged();
         } else {
            this.childBuilder_.addMessage(value);
         }

         return this;
      }

      public DocV2.Builder addChild(int index, DocV2 value) {
         if (this.childBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureChildIsMutable();
            this.child_.add(index, value);
            this.onChanged();
         } else {
            this.childBuilder_.addMessage(index, value);
         }

         return this;
      }

      public DocV2.Builder addChild(DocV2.Builder builderForValue) {
         if (this.childBuilder_ == null) {
            this.ensureChildIsMutable();
            this.child_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.childBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addChild(int index, DocV2.Builder builderForValue) {
         if (this.childBuilder_ == null) {
            this.ensureChildIsMutable();
            this.child_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.childBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public DocV2.Builder addAllChild(Iterable values) {
         if (this.childBuilder_ == null) {
            this.ensureChildIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.child_);
            this.onChanged();
         } else {
            this.childBuilder_.addAllMessages(values);
         }

         return this;
      }

      public DocV2.Builder clearChild() {
         if (this.childBuilder_ == null) {
            this.child_ = Collections.emptyList();
            this.bitField0_ &= -1025;
            this.onChanged();
         } else {
            this.childBuilder_.clear();
         }

         return this;
      }

      public DocV2.Builder removeChild(int index) {
         if (this.childBuilder_ == null) {
            this.ensureChildIsMutable();
            this.child_.remove(index);
            this.onChanged();
         } else {
            this.childBuilder_.remove(index);
         }

         return this;
      }

      public DocV2.Builder getChildBuilder(int index) {
         return (DocV2.Builder)this.getChildFieldBuilder().getBuilder(index);
      }

      public DocV2OrBuilder getChildOrBuilder(int index) {
         return this.childBuilder_ == null ? (DocV2OrBuilder)this.child_.get(index) : (DocV2OrBuilder)this.childBuilder_.getMessageOrBuilder(index);
      }

      public List getChildOrBuilderList() {
         return this.childBuilder_ != null ? this.childBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.child_);
      }

      public DocV2.Builder addChildBuilder() {
         return (DocV2.Builder)this.getChildFieldBuilder().addBuilder(DocV2.getDefaultInstance());
      }

      public DocV2.Builder addChildBuilder(int index) {
         return (DocV2.Builder)this.getChildFieldBuilder().addBuilder(index, DocV2.getDefaultInstance());
      }

      public List getChildBuilderList() {
         return this.getChildFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getChildFieldBuilder() {
         if (this.childBuilder_ == null) {
            this.childBuilder_ = new RepeatedFieldBuilderV3(this.child_, (this.bitField0_ & 1024) != 0, this.getParentForChildren(), this.isClean());
            this.child_ = null;
         }

         return this.childBuilder_;
      }

      public boolean hasContainerMetadata() {
         return (this.bitField0_ & 2048) != 0;
      }

      public ContainerMetadata getContainerMetadata() {
         if (this.containerMetadataBuilder_ == null) {
            return this.containerMetadata_ == null ? ContainerMetadata.getDefaultInstance() : this.containerMetadata_;
         } else {
            return (ContainerMetadata)this.containerMetadataBuilder_.getMessage();
         }
      }

      public DocV2.Builder setContainerMetadata(ContainerMetadata value) {
         if (this.containerMetadataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.containerMetadata_ = value;
            this.onChanged();
         } else {
            this.containerMetadataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public DocV2.Builder setContainerMetadata(ContainerMetadata.Builder builderForValue) {
         if (this.containerMetadataBuilder_ == null) {
            this.containerMetadata_ = builderForValue.build();
            this.onChanged();
         } else {
            this.containerMetadataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public DocV2.Builder mergeContainerMetadata(ContainerMetadata value) {
         if (this.containerMetadataBuilder_ == null) {
            if ((this.bitField0_ & 2048) != 0 && this.containerMetadata_ != null && this.containerMetadata_ != ContainerMetadata.getDefaultInstance()) {
               this.containerMetadata_ = ContainerMetadata.newBuilder(this.containerMetadata_).mergeFrom(value).buildPartial();
            } else {
               this.containerMetadata_ = value;
            }

            this.onChanged();
         } else {
            this.containerMetadataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2048;
         return this;
      }

      public DocV2.Builder clearContainerMetadata() {
         if (this.containerMetadataBuilder_ == null) {
            this.containerMetadata_ = null;
            this.onChanged();
         } else {
            this.containerMetadataBuilder_.clear();
         }

         this.bitField0_ &= -2049;
         return this;
      }

      public ContainerMetadata.Builder getContainerMetadataBuilder() {
         this.bitField0_ |= 2048;
         this.onChanged();
         return (ContainerMetadata.Builder)this.getContainerMetadataFieldBuilder().getBuilder();
      }

      public ContainerMetadataOrBuilder getContainerMetadataOrBuilder() {
         if (this.containerMetadataBuilder_ != null) {
            return (ContainerMetadataOrBuilder)this.containerMetadataBuilder_.getMessageOrBuilder();
         } else {
            return this.containerMetadata_ == null ? ContainerMetadata.getDefaultInstance() : this.containerMetadata_;
         }
      }

      private SingleFieldBuilderV3 getContainerMetadataFieldBuilder() {
         if (this.containerMetadataBuilder_ == null) {
            this.containerMetadataBuilder_ = new SingleFieldBuilderV3(this.getContainerMetadata(), this.getParentForChildren(), this.isClean());
            this.containerMetadata_ = null;
         }

         return this.containerMetadataBuilder_;
      }

      public boolean hasDetails() {
         return (this.bitField0_ & 4096) != 0;
      }

      public DocumentDetails getDetails() {
         if (this.detailsBuilder_ == null) {
            return this.details_ == null ? DocumentDetails.getDefaultInstance() : this.details_;
         } else {
            return (DocumentDetails)this.detailsBuilder_.getMessage();
         }
      }

      public DocV2.Builder setDetails(DocumentDetails value) {
         if (this.detailsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.details_ = value;
            this.onChanged();
         } else {
            this.detailsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public DocV2.Builder setDetails(DocumentDetails.Builder builderForValue) {
         if (this.detailsBuilder_ == null) {
            this.details_ = builderForValue.build();
            this.onChanged();
         } else {
            this.detailsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public DocV2.Builder mergeDetails(DocumentDetails value) {
         if (this.detailsBuilder_ == null) {
            if ((this.bitField0_ & 4096) != 0 && this.details_ != null && this.details_ != DocumentDetails.getDefaultInstance()) {
               this.details_ = DocumentDetails.newBuilder(this.details_).mergeFrom(value).buildPartial();
            } else {
               this.details_ = value;
            }

            this.onChanged();
         } else {
            this.detailsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4096;
         return this;
      }

      public DocV2.Builder clearDetails() {
         if (this.detailsBuilder_ == null) {
            this.details_ = null;
            this.onChanged();
         } else {
            this.detailsBuilder_.clear();
         }

         this.bitField0_ &= -4097;
         return this;
      }

      public DocumentDetails.Builder getDetailsBuilder() {
         this.bitField0_ |= 4096;
         this.onChanged();
         return (DocumentDetails.Builder)this.getDetailsFieldBuilder().getBuilder();
      }

      public DocumentDetailsOrBuilder getDetailsOrBuilder() {
         if (this.detailsBuilder_ != null) {
            return (DocumentDetailsOrBuilder)this.detailsBuilder_.getMessageOrBuilder();
         } else {
            return this.details_ == null ? DocumentDetails.getDefaultInstance() : this.details_;
         }
      }

      private SingleFieldBuilderV3 getDetailsFieldBuilder() {
         if (this.detailsBuilder_ == null) {
            this.detailsBuilder_ = new SingleFieldBuilderV3(this.getDetails(), this.getParentForChildren(), this.isClean());
            this.details_ = null;
         }

         return this.detailsBuilder_;
      }

      public boolean hasAggregateRating() {
         return (this.bitField0_ & 8192) != 0;
      }

      public AggregateRating getAggregateRating() {
         if (this.aggregateRatingBuilder_ == null) {
            return this.aggregateRating_ == null ? AggregateRating.getDefaultInstance() : this.aggregateRating_;
         } else {
            return (AggregateRating)this.aggregateRatingBuilder_.getMessage();
         }
      }

      public DocV2.Builder setAggregateRating(AggregateRating value) {
         if (this.aggregateRatingBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.aggregateRating_ = value;
            this.onChanged();
         } else {
            this.aggregateRatingBuilder_.setMessage(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public DocV2.Builder setAggregateRating(AggregateRating.Builder builderForValue) {
         if (this.aggregateRatingBuilder_ == null) {
            this.aggregateRating_ = builderForValue.build();
            this.onChanged();
         } else {
            this.aggregateRatingBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public DocV2.Builder mergeAggregateRating(AggregateRating value) {
         if (this.aggregateRatingBuilder_ == null) {
            if ((this.bitField0_ & 8192) != 0 && this.aggregateRating_ != null && this.aggregateRating_ != AggregateRating.getDefaultInstance()) {
               this.aggregateRating_ = AggregateRating.newBuilder(this.aggregateRating_).mergeFrom(value).buildPartial();
            } else {
               this.aggregateRating_ = value;
            }

            this.onChanged();
         } else {
            this.aggregateRatingBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 8192;
         return this;
      }

      public DocV2.Builder clearAggregateRating() {
         if (this.aggregateRatingBuilder_ == null) {
            this.aggregateRating_ = null;
            this.onChanged();
         } else {
            this.aggregateRatingBuilder_.clear();
         }

         this.bitField0_ &= -8193;
         return this;
      }

      public AggregateRating.Builder getAggregateRatingBuilder() {
         this.bitField0_ |= 8192;
         this.onChanged();
         return (AggregateRating.Builder)this.getAggregateRatingFieldBuilder().getBuilder();
      }

      public AggregateRatingOrBuilder getAggregateRatingOrBuilder() {
         if (this.aggregateRatingBuilder_ != null) {
            return (AggregateRatingOrBuilder)this.aggregateRatingBuilder_.getMessageOrBuilder();
         } else {
            return this.aggregateRating_ == null ? AggregateRating.getDefaultInstance() : this.aggregateRating_;
         }
      }

      private SingleFieldBuilderV3 getAggregateRatingFieldBuilder() {
         if (this.aggregateRatingBuilder_ == null) {
            this.aggregateRatingBuilder_ = new SingleFieldBuilderV3(this.getAggregateRating(), this.getParentForChildren(), this.isClean());
            this.aggregateRating_ = null;
         }

         return this.aggregateRatingBuilder_;
      }

      public boolean hasAnnotations() {
         return (this.bitField0_ & 16384) != 0;
      }

      public Annotations getAnnotations() {
         if (this.annotationsBuilder_ == null) {
            return this.annotations_ == null ? Annotations.getDefaultInstance() : this.annotations_;
         } else {
            return (Annotations)this.annotationsBuilder_.getMessage();
         }
      }

      public DocV2.Builder setAnnotations(Annotations value) {
         if (this.annotationsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.annotations_ = value;
            this.onChanged();
         } else {
            this.annotationsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 16384;
         return this;
      }

      public DocV2.Builder setAnnotations(Annotations.Builder builderForValue) {
         if (this.annotationsBuilder_ == null) {
            this.annotations_ = builderForValue.build();
            this.onChanged();
         } else {
            this.annotationsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 16384;
         return this;
      }

      public DocV2.Builder mergeAnnotations(Annotations value) {
         if (this.annotationsBuilder_ == null) {
            if ((this.bitField0_ & 16384) != 0 && this.annotations_ != null && this.annotations_ != Annotations.getDefaultInstance()) {
               this.annotations_ = Annotations.newBuilder(this.annotations_).mergeFrom(value).buildPartial();
            } else {
               this.annotations_ = value;
            }

            this.onChanged();
         } else {
            this.annotationsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 16384;
         return this;
      }

      public DocV2.Builder clearAnnotations() {
         if (this.annotationsBuilder_ == null) {
            this.annotations_ = null;
            this.onChanged();
         } else {
            this.annotationsBuilder_.clear();
         }

         this.bitField0_ &= -16385;
         return this;
      }

      public Annotations.Builder getAnnotationsBuilder() {
         this.bitField0_ |= 16384;
         this.onChanged();
         return (Annotations.Builder)this.getAnnotationsFieldBuilder().getBuilder();
      }

      public AnnotationsOrBuilder getAnnotationsOrBuilder() {
         if (this.annotationsBuilder_ != null) {
            return (AnnotationsOrBuilder)this.annotationsBuilder_.getMessageOrBuilder();
         } else {
            return this.annotations_ == null ? Annotations.getDefaultInstance() : this.annotations_;
         }
      }

      private SingleFieldBuilderV3 getAnnotationsFieldBuilder() {
         if (this.annotationsBuilder_ == null) {
            this.annotationsBuilder_ = new SingleFieldBuilderV3(this.getAnnotations(), this.getParentForChildren(), this.isClean());
            this.annotations_ = null;
         }

         return this.annotationsBuilder_;
      }

      public boolean hasReviewsUrl() {
         return (this.bitField0_ & '耀') != 0;
      }

      public String getReviewsUrl() {
         Object ref = this.reviewsUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.reviewsUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getReviewsUrlBytes() {
         Object ref = this.reviewsUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.reviewsUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setReviewsUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32768;
            this.reviewsUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearReviewsUrl() {
         this.bitField0_ &= -32769;
         this.reviewsUrl_ = DocV2.getDefaultInstance().getReviewsUrl();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setReviewsUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32768;
            this.reviewsUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasBackendUrl() {
         return (this.bitField0_ & 65536) != 0;
      }

      public String getBackendUrl() {
         Object ref = this.backendUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.backendUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getBackendUrlBytes() {
         Object ref = this.backendUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.backendUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setBackendUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 65536;
            this.backendUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearBackendUrl() {
         this.bitField0_ &= -65537;
         this.backendUrl_ = DocV2.getDefaultInstance().getBackendUrl();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setBackendUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 65536;
            this.backendUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTranslatedDescriptionHtml() {
         return (this.bitField0_ & 131072) != 0;
      }

      public String getTranslatedDescriptionHtml() {
         Object ref = this.translatedDescriptionHtml_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.translatedDescriptionHtml_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTranslatedDescriptionHtmlBytes() {
         Object ref = this.translatedDescriptionHtml_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.translatedDescriptionHtml_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setTranslatedDescriptionHtml(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 131072;
            this.translatedDescriptionHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearTranslatedDescriptionHtml() {
         this.bitField0_ &= -131073;
         this.translatedDescriptionHtml_ = DocV2.getDefaultInstance().getTranslatedDescriptionHtml();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setTranslatedDescriptionHtmlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 131072;
            this.translatedDescriptionHtml_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasPromotionalDescription() {
         return (this.bitField0_ & 262144) != 0;
      }

      public String getPromotionalDescription() {
         Object ref = this.promotionalDescription_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.promotionalDescription_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getPromotionalDescriptionBytes() {
         Object ref = this.promotionalDescription_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.promotionalDescription_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setPromotionalDescription(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.promotionalDescription_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearPromotionalDescription() {
         this.bitField0_ &= -262145;
         this.promotionalDescription_ = DocV2.getDefaultInstance().getPromotionalDescription();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setPromotionalDescriptionBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 262144;
            this.promotionalDescription_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasAvailableForPreregistration() {
         return (this.bitField0_ & 524288) != 0;
      }

      public boolean getAvailableForPreregistration() {
         return this.availableForPreregistration_;
      }

      public DocV2.Builder setAvailableForPreregistration(boolean value) {
         this.bitField0_ |= 524288;
         this.availableForPreregistration_ = value;
         this.onChanged();
         return this;
      }

      public DocV2.Builder clearAvailableForPreregistration() {
         this.bitField0_ &= -524289;
         this.availableForPreregistration_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasAutoTranslatedPromotionalDescription() {
         return (this.bitField0_ & 1048576) != 0;
      }

      public String getAutoTranslatedPromotionalDescription() {
         Object ref = this.autoTranslatedPromotionalDescription_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.autoTranslatedPromotionalDescription_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getAutoTranslatedPromotionalDescriptionBytes() {
         Object ref = this.autoTranslatedPromotionalDescription_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.autoTranslatedPromotionalDescription_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setAutoTranslatedPromotionalDescription(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1048576;
            this.autoTranslatedPromotionalDescription_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearAutoTranslatedPromotionalDescription() {
         this.bitField0_ &= -1048577;
         this.autoTranslatedPromotionalDescription_ = DocV2.getDefaultInstance().getAutoTranslatedPromotionalDescription();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setAutoTranslatedPromotionalDescriptionBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1048576;
            this.autoTranslatedPromotionalDescription_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDescriptionTitle() {
         return (this.bitField0_ & 2097152) != 0;
      }

      public String getDescriptionTitle() {
         Object ref = this.descriptionTitle_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.descriptionTitle_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDescriptionTitleBytes() {
         Object ref = this.descriptionTitle_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.descriptionTitle_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public DocV2.Builder setDescriptionTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2097152;
            this.descriptionTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public DocV2.Builder clearDescriptionTitle() {
         this.bitField0_ &= -2097153;
         this.descriptionTitle_ = DocV2.getDefaultInstance().getDescriptionTitle();
         this.onChanged();
         return this;
      }

      public DocV2.Builder setDescriptionTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2097152;
            this.descriptionTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasItemType() {
         return (this.bitField0_ & 4194304) != 0;
      }

      public int getItemType() {
         return this.itemType_;
      }

      public DocV2.Builder setItemType(int value) {
         this.bitField0_ |= 4194304;
         this.itemType_ = value;
         this.onChanged();
         return this;
      }

      public DocV2.Builder clearItemType() {
         this.bitField0_ &= -4194305;
         this.itemType_ = 0;
         this.onChanged();
         return this;
      }

      public final DocV2.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (DocV2.Builder)super.setUnknownFields(unknownFields);
      }

      public final DocV2.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (DocV2.Builder)super.mergeUnknownFields(unknownFields);
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
