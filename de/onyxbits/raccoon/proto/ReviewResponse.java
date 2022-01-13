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

public final class ReviewResponse extends GeneratedMessageV3 implements ReviewResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int RESPONSE_FIELD_NUMBER = 1;
   private GetReviewsResponse response_;
   public static final int NEXTPAGEURL_FIELD_NUMBER = 2;
   private volatile Object nextPageUrl_;
   public static final int UPDATEDREVIEW_FIELD_NUMBER = 3;
   private Review updatedReview_;
   private byte memoizedIsInitialized;
   private static final ReviewResponse DEFAULT_INSTANCE = new ReviewResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ReviewResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ReviewResponse(input, extensionRegistry);
      }
   };

   private ReviewResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ReviewResponse() {
      this.memoizedIsInitialized = -1;
      this.nextPageUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ReviewResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ReviewResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  GetReviewsResponse.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.response_.toBuilder();
                  }

                  this.response_ = (GetReviewsResponse)input.readMessage(GetReviewsResponse.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.response_);
                     this.response_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
                  break;
               case 18:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.nextPageUrl_ = bs;
                  break;
               case 26:
                  Review.Builder subBuilder = null;
                  if ((this.bitField0_ & 4) != 0) {
                     subBuilder = this.updatedReview_.toBuilder();
                  }

                  this.updatedReview_ = (Review)input.readMessage(Review.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.updatedReview_);
                     this.updatedReview_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4;
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
      return Mothership.internal_static_ReviewResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ReviewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReviewResponse.class, ReviewResponse.Builder.class);
   }

   public boolean hasResponse() {
      return (this.bitField0_ & 1) != 0;
   }

   public GetReviewsResponse getResponse() {
      return this.response_ == null ? GetReviewsResponse.getDefaultInstance() : this.response_;
   }

   public GetReviewsResponseOrBuilder getResponseOrBuilder() {
      return this.response_ == null ? GetReviewsResponse.getDefaultInstance() : this.response_;
   }

   public boolean hasNextPageUrl() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getNextPageUrl() {
      Object ref = this.nextPageUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.nextPageUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getNextPageUrlBytes() {
      Object ref = this.nextPageUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.nextPageUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasUpdatedReview() {
      return (this.bitField0_ & 4) != 0;
   }

   public Review getUpdatedReview() {
      return this.updatedReview_ == null ? Review.getDefaultInstance() : this.updatedReview_;
   }

   public ReviewOrBuilder getUpdatedReviewOrBuilder() {
      return this.updatedReview_ == null ? Review.getDefaultInstance() : this.updatedReview_;
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
         output.writeMessage(1, this.getResponse());
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.nextPageUrl_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeMessage(3, this.getUpdatedReview());
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
            size += CodedOutputStream.computeMessageSize(1, this.getResponse());
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.nextPageUrl_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(3, this.getUpdatedReview());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ReviewResponse)) {
         return super.equals(obj);
      } else {
         ReviewResponse other = (ReviewResponse)obj;
         if (this.hasResponse() != other.hasResponse()) {
            return false;
         } else if (this.hasResponse() && !this.getResponse().equals(other.getResponse())) {
            return false;
         } else if (this.hasNextPageUrl() != other.hasNextPageUrl()) {
            return false;
         } else if (this.hasNextPageUrl() && !this.getNextPageUrl().equals(other.getNextPageUrl())) {
            return false;
         } else if (this.hasUpdatedReview() != other.hasUpdatedReview()) {
            return false;
         } else if (this.hasUpdatedReview() && !this.getUpdatedReview().equals(other.getUpdatedReview())) {
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
         if (this.hasResponse()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getResponse().hashCode();
         }

         if (this.hasNextPageUrl()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getNextPageUrl().hashCode();
         }

         if (this.hasUpdatedReview()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getUpdatedReview().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ReviewResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data);
   }

   public static ReviewResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ReviewResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data);
   }

   public static ReviewResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ReviewResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data);
   }

   public static ReviewResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ReviewResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ReviewResponse parseFrom(InputStream input) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ReviewResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ReviewResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ReviewResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ReviewResponse parseFrom(CodedInputStream input) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ReviewResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ReviewResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ReviewResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ReviewResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ReviewResponse.Builder newBuilder(ReviewResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ReviewResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ReviewResponse.Builder() : (new ReviewResponse.Builder()).mergeFrom(this);
   }

   protected ReviewResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ReviewResponse.Builder builder = new ReviewResponse.Builder(parent);
      return builder;
   }

   public static ReviewResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ReviewResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ReviewResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ReviewResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ReviewResponseOrBuilder {
      private int bitField0_;
      private GetReviewsResponse response_;
      private SingleFieldBuilderV3 responseBuilder_;
      private Object nextPageUrl_;
      private Review updatedReview_;
      private SingleFieldBuilderV3 updatedReviewBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ReviewResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ReviewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReviewResponse.class, ReviewResponse.Builder.class);
      }

      private Builder() {
         this.nextPageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.nextPageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ReviewResponse.alwaysUseFieldBuilders) {
            this.getResponseFieldBuilder();
            this.getUpdatedReviewFieldBuilder();
         }

      }

      public ReviewResponse.Builder clear() {
         super.clear();
         if (this.responseBuilder_ == null) {
            this.response_ = null;
         } else {
            this.responseBuilder_.clear();
         }

         this.bitField0_ &= -2;
         this.nextPageUrl_ = "";
         this.bitField0_ &= -3;
         if (this.updatedReviewBuilder_ == null) {
            this.updatedReview_ = null;
         } else {
            this.updatedReviewBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ReviewResponse_descriptor;
      }

      public ReviewResponse getDefaultInstanceForType() {
         return ReviewResponse.getDefaultInstance();
      }

      public ReviewResponse build() {
         ReviewResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ReviewResponse buildPartial() {
         ReviewResponse result = new ReviewResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.responseBuilder_ == null) {
               result.response_ = this.response_;
            } else {
               result.response_ = (GetReviewsResponse)this.responseBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.nextPageUrl_ = this.nextPageUrl_;
         if ((from_bitField0_ & 4) != 0) {
            if (this.updatedReviewBuilder_ == null) {
               result.updatedReview_ = this.updatedReview_;
            } else {
               result.updatedReview_ = (Review)this.updatedReviewBuilder_.build();
            }

            to_bitField0_ |= 4;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ReviewResponse.Builder clone() {
         return (ReviewResponse.Builder)super.clone();
      }

      public ReviewResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ReviewResponse.Builder)super.setField(field, value);
      }

      public ReviewResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ReviewResponse.Builder)super.clearField(field);
      }

      public ReviewResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ReviewResponse.Builder)super.clearOneof(oneof);
      }

      public ReviewResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ReviewResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public ReviewResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ReviewResponse.Builder)super.addRepeatedField(field, value);
      }

      public ReviewResponse.Builder mergeFrom(Message other) {
         if (other instanceof ReviewResponse) {
            return this.mergeFrom((ReviewResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ReviewResponse.Builder mergeFrom(ReviewResponse other) {
         if (other == ReviewResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasResponse()) {
               this.mergeResponse(other.getResponse());
            }

            if (other.hasNextPageUrl()) {
               this.bitField0_ |= 2;
               this.nextPageUrl_ = other.nextPageUrl_;
               this.onChanged();
            }

            if (other.hasUpdatedReview()) {
               this.mergeUpdatedReview(other.getUpdatedReview());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public ReviewResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ReviewResponse parsedMessage = null;

         try {
            parsedMessage = (ReviewResponse)ReviewResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ReviewResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasResponse() {
         return (this.bitField0_ & 1) != 0;
      }

      public GetReviewsResponse getResponse() {
         if (this.responseBuilder_ == null) {
            return this.response_ == null ? GetReviewsResponse.getDefaultInstance() : this.response_;
         } else {
            return (GetReviewsResponse)this.responseBuilder_.getMessage();
         }
      }

      public ReviewResponse.Builder setResponse(GetReviewsResponse value) {
         if (this.responseBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.response_ = value;
            this.onChanged();
         } else {
            this.responseBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ReviewResponse.Builder setResponse(GetReviewsResponse.Builder builderForValue) {
         if (this.responseBuilder_ == null) {
            this.response_ = builderForValue.build();
            this.onChanged();
         } else {
            this.responseBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ReviewResponse.Builder mergeResponse(GetReviewsResponse value) {
         if (this.responseBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.response_ != null && this.response_ != GetReviewsResponse.getDefaultInstance()) {
               this.response_ = GetReviewsResponse.newBuilder(this.response_).mergeFrom(value).buildPartial();
            } else {
               this.response_ = value;
            }

            this.onChanged();
         } else {
            this.responseBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ReviewResponse.Builder clearResponse() {
         if (this.responseBuilder_ == null) {
            this.response_ = null;
            this.onChanged();
         } else {
            this.responseBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public GetReviewsResponse.Builder getResponseBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (GetReviewsResponse.Builder)this.getResponseFieldBuilder().getBuilder();
      }

      public GetReviewsResponseOrBuilder getResponseOrBuilder() {
         if (this.responseBuilder_ != null) {
            return (GetReviewsResponseOrBuilder)this.responseBuilder_.getMessageOrBuilder();
         } else {
            return this.response_ == null ? GetReviewsResponse.getDefaultInstance() : this.response_;
         }
      }

      private SingleFieldBuilderV3 getResponseFieldBuilder() {
         if (this.responseBuilder_ == null) {
            this.responseBuilder_ = new SingleFieldBuilderV3(this.getResponse(), this.getParentForChildren(), this.isClean());
            this.response_ = null;
         }

         return this.responseBuilder_;
      }

      public boolean hasNextPageUrl() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getNextPageUrl() {
         Object ref = this.nextPageUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.nextPageUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getNextPageUrlBytes() {
         Object ref = this.nextPageUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.nextPageUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ReviewResponse.Builder setNextPageUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.nextPageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public ReviewResponse.Builder clearNextPageUrl() {
         this.bitField0_ &= -3;
         this.nextPageUrl_ = ReviewResponse.getDefaultInstance().getNextPageUrl();
         this.onChanged();
         return this;
      }

      public ReviewResponse.Builder setNextPageUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.nextPageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasUpdatedReview() {
         return (this.bitField0_ & 4) != 0;
      }

      public Review getUpdatedReview() {
         if (this.updatedReviewBuilder_ == null) {
            return this.updatedReview_ == null ? Review.getDefaultInstance() : this.updatedReview_;
         } else {
            return (Review)this.updatedReviewBuilder_.getMessage();
         }
      }

      public ReviewResponse.Builder setUpdatedReview(Review value) {
         if (this.updatedReviewBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.updatedReview_ = value;
            this.onChanged();
         } else {
            this.updatedReviewBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public ReviewResponse.Builder setUpdatedReview(Review.Builder builderForValue) {
         if (this.updatedReviewBuilder_ == null) {
            this.updatedReview_ = builderForValue.build();
            this.onChanged();
         } else {
            this.updatedReviewBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4;
         return this;
      }

      public ReviewResponse.Builder mergeUpdatedReview(Review value) {
         if (this.updatedReviewBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0 && this.updatedReview_ != null && this.updatedReview_ != Review.getDefaultInstance()) {
               this.updatedReview_ = Review.newBuilder(this.updatedReview_).mergeFrom(value).buildPartial();
            } else {
               this.updatedReview_ = value;
            }

            this.onChanged();
         } else {
            this.updatedReviewBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public ReviewResponse.Builder clearUpdatedReview() {
         if (this.updatedReviewBuilder_ == null) {
            this.updatedReview_ = null;
            this.onChanged();
         } else {
            this.updatedReviewBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public Review.Builder getUpdatedReviewBuilder() {
         this.bitField0_ |= 4;
         this.onChanged();
         return (Review.Builder)this.getUpdatedReviewFieldBuilder().getBuilder();
      }

      public ReviewOrBuilder getUpdatedReviewOrBuilder() {
         if (this.updatedReviewBuilder_ != null) {
            return (ReviewOrBuilder)this.updatedReviewBuilder_.getMessageOrBuilder();
         } else {
            return this.updatedReview_ == null ? Review.getDefaultInstance() : this.updatedReview_;
         }
      }

      private SingleFieldBuilderV3 getUpdatedReviewFieldBuilder() {
         if (this.updatedReviewBuilder_ == null) {
            this.updatedReviewBuilder_ = new SingleFieldBuilderV3(this.getUpdatedReview(), this.getParentForChildren(), this.isClean());
            this.updatedReview_ = null;
         }

         return this.updatedReviewBuilder_;
      }

      public final ReviewResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ReviewResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final ReviewResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ReviewResponse.Builder)super.mergeUnknownFields(unknownFields);
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
