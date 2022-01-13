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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GetReviewsResponse extends GeneratedMessageV3 implements GetReviewsResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int REVIEW_FIELD_NUMBER = 1;
   private List review_;
   public static final int MATCHINGCOUNT_FIELD_NUMBER = 2;
   private long matchingCount_;
   private byte memoizedIsInitialized;
   private static final GetReviewsResponse DEFAULT_INSTANCE = new GetReviewsResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public GetReviewsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new GetReviewsResponse(input, extensionRegistry);
      }
   };

   private GetReviewsResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private GetReviewsResponse() {
      this.memoizedIsInitialized = -1;
      this.review_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new GetReviewsResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private GetReviewsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  if (!(mutable_bitField0_ & true)) {
                     this.review_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.review_.add(input.readMessage(Review.PARSER, extensionRegistry));
                  break;
               case 16:
                  this.bitField0_ |= 1;
                  this.matchingCount_ = input.readInt64();
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var11) {
            throw var11.setUnfinishedMessage(this);
         } catch (IOException var12) {
            throw (new InvalidProtocolBufferException(var12)).setUnfinishedMessage(this);
         } finally {
            if (mutable_bitField0_ & true) {
               this.review_ = Collections.unmodifiableList(this.review_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_GetReviewsResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_GetReviewsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetReviewsResponse.class, GetReviewsResponse.Builder.class);
   }

   public List getReviewList() {
      return this.review_;
   }

   public List getReviewOrBuilderList() {
      return this.review_;
   }

   public int getReviewCount() {
      return this.review_.size();
   }

   public Review getReview(int index) {
      return (Review)this.review_.get(index);
   }

   public ReviewOrBuilder getReviewOrBuilder(int index) {
      return (ReviewOrBuilder)this.review_.get(index);
   }

   public boolean hasMatchingCount() {
      return (this.bitField0_ & 1) != 0;
   }

   public long getMatchingCount() {
      return this.matchingCount_;
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
      for(int i = 0; i < this.review_.size(); ++i) {
         output.writeMessage(1, (MessageLite)this.review_.get(i));
      }

      if ((this.bitField0_ & 1) != 0) {
         output.writeInt64(2, this.matchingCount_);
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.review_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.review_.get(i));
         }

         if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeInt64Size(2, this.matchingCount_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof GetReviewsResponse)) {
         return super.equals(obj);
      } else {
         GetReviewsResponse other = (GetReviewsResponse)obj;
         if (!this.getReviewList().equals(other.getReviewList())) {
            return false;
         } else if (this.hasMatchingCount() != other.hasMatchingCount()) {
            return false;
         } else if (this.hasMatchingCount() && this.getMatchingCount() != other.getMatchingCount()) {
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
         if (this.getReviewCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getReviewList().hashCode();
         }

         if (this.hasMatchingCount()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getMatchingCount());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static GetReviewsResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data);
   }

   public static GetReviewsResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static GetReviewsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data);
   }

   public static GetReviewsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static GetReviewsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data);
   }

   public static GetReviewsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (GetReviewsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static GetReviewsResponse parseFrom(InputStream input) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static GetReviewsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static GetReviewsResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static GetReviewsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static GetReviewsResponse parseFrom(CodedInputStream input) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static GetReviewsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (GetReviewsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public GetReviewsResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static GetReviewsResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static GetReviewsResponse.Builder newBuilder(GetReviewsResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public GetReviewsResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new GetReviewsResponse.Builder() : (new GetReviewsResponse.Builder()).mergeFrom(this);
   }

   protected GetReviewsResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      GetReviewsResponse.Builder builder = new GetReviewsResponse.Builder(parent);
      return builder;
   }

   public static GetReviewsResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public GetReviewsResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   GetReviewsResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   GetReviewsResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements GetReviewsResponseOrBuilder {
      private int bitField0_;
      private List review_;
      private RepeatedFieldBuilderV3 reviewBuilder_;
      private long matchingCount_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_GetReviewsResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_GetReviewsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetReviewsResponse.class, GetReviewsResponse.Builder.class);
      }

      private Builder() {
         this.review_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.review_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (GetReviewsResponse.alwaysUseFieldBuilders) {
            this.getReviewFieldBuilder();
         }

      }

      public GetReviewsResponse.Builder clear() {
         super.clear();
         if (this.reviewBuilder_ == null) {
            this.review_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.reviewBuilder_.clear();
         }

         this.matchingCount_ = 0L;
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_GetReviewsResponse_descriptor;
      }

      public GetReviewsResponse getDefaultInstanceForType() {
         return GetReviewsResponse.getDefaultInstance();
      }

      public GetReviewsResponse build() {
         GetReviewsResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public GetReviewsResponse buildPartial() {
         GetReviewsResponse result = new GetReviewsResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if (this.reviewBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.review_ = Collections.unmodifiableList(this.review_);
               this.bitField0_ &= -2;
            }

            result.review_ = this.review_;
         } else {
            result.review_ = this.reviewBuilder_.build();
         }

         if ((from_bitField0_ & 2) != 0) {
            result.matchingCount_ = this.matchingCount_;
            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public GetReviewsResponse.Builder clone() {
         return (GetReviewsResponse.Builder)super.clone();
      }

      public GetReviewsResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (GetReviewsResponse.Builder)super.setField(field, value);
      }

      public GetReviewsResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (GetReviewsResponse.Builder)super.clearField(field);
      }

      public GetReviewsResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (GetReviewsResponse.Builder)super.clearOneof(oneof);
      }

      public GetReviewsResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (GetReviewsResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public GetReviewsResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (GetReviewsResponse.Builder)super.addRepeatedField(field, value);
      }

      public GetReviewsResponse.Builder mergeFrom(Message other) {
         if (other instanceof GetReviewsResponse) {
            return this.mergeFrom((GetReviewsResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public GetReviewsResponse.Builder mergeFrom(GetReviewsResponse other) {
         if (other == GetReviewsResponse.getDefaultInstance()) {
            return this;
         } else {
            if (this.reviewBuilder_ == null) {
               if (!other.review_.isEmpty()) {
                  if (this.review_.isEmpty()) {
                     this.review_ = other.review_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureReviewIsMutable();
                     this.review_.addAll(other.review_);
                  }

                  this.onChanged();
               }
            } else if (!other.review_.isEmpty()) {
               if (this.reviewBuilder_.isEmpty()) {
                  this.reviewBuilder_.dispose();
                  this.reviewBuilder_ = null;
                  this.review_ = other.review_;
                  this.bitField0_ &= -2;
                  this.reviewBuilder_ = GetReviewsResponse.alwaysUseFieldBuilders ? this.getReviewFieldBuilder() : null;
               } else {
                  this.reviewBuilder_.addAllMessages(other.review_);
               }
            }

            if (other.hasMatchingCount()) {
               this.setMatchingCount(other.getMatchingCount());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public GetReviewsResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         GetReviewsResponse parsedMessage = null;

         try {
            parsedMessage = (GetReviewsResponse)GetReviewsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (GetReviewsResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureReviewIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.review_ = new ArrayList(this.review_);
            this.bitField0_ |= 1;
         }

      }

      public List getReviewList() {
         return this.reviewBuilder_ == null ? Collections.unmodifiableList(this.review_) : this.reviewBuilder_.getMessageList();
      }

      public int getReviewCount() {
         return this.reviewBuilder_ == null ? this.review_.size() : this.reviewBuilder_.getCount();
      }

      public Review getReview(int index) {
         return this.reviewBuilder_ == null ? (Review)this.review_.get(index) : (Review)this.reviewBuilder_.getMessage(index);
      }

      public GetReviewsResponse.Builder setReview(int index, Review value) {
         if (this.reviewBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureReviewIsMutable();
            this.review_.set(index, value);
            this.onChanged();
         } else {
            this.reviewBuilder_.setMessage(index, value);
         }

         return this;
      }

      public GetReviewsResponse.Builder setReview(int index, Review.Builder builderForValue) {
         if (this.reviewBuilder_ == null) {
            this.ensureReviewIsMutable();
            this.review_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.reviewBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public GetReviewsResponse.Builder addReview(Review value) {
         if (this.reviewBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureReviewIsMutable();
            this.review_.add(value);
            this.onChanged();
         } else {
            this.reviewBuilder_.addMessage(value);
         }

         return this;
      }

      public GetReviewsResponse.Builder addReview(int index, Review value) {
         if (this.reviewBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureReviewIsMutable();
            this.review_.add(index, value);
            this.onChanged();
         } else {
            this.reviewBuilder_.addMessage(index, value);
         }

         return this;
      }

      public GetReviewsResponse.Builder addReview(Review.Builder builderForValue) {
         if (this.reviewBuilder_ == null) {
            this.ensureReviewIsMutable();
            this.review_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.reviewBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public GetReviewsResponse.Builder addReview(int index, Review.Builder builderForValue) {
         if (this.reviewBuilder_ == null) {
            this.ensureReviewIsMutable();
            this.review_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.reviewBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public GetReviewsResponse.Builder addAllReview(Iterable values) {
         if (this.reviewBuilder_ == null) {
            this.ensureReviewIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.review_);
            this.onChanged();
         } else {
            this.reviewBuilder_.addAllMessages(values);
         }

         return this;
      }

      public GetReviewsResponse.Builder clearReview() {
         if (this.reviewBuilder_ == null) {
            this.review_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.reviewBuilder_.clear();
         }

         return this;
      }

      public GetReviewsResponse.Builder removeReview(int index) {
         if (this.reviewBuilder_ == null) {
            this.ensureReviewIsMutable();
            this.review_.remove(index);
            this.onChanged();
         } else {
            this.reviewBuilder_.remove(index);
         }

         return this;
      }

      public Review.Builder getReviewBuilder(int index) {
         return (Review.Builder)this.getReviewFieldBuilder().getBuilder(index);
      }

      public ReviewOrBuilder getReviewOrBuilder(int index) {
         return this.reviewBuilder_ == null ? (ReviewOrBuilder)this.review_.get(index) : (ReviewOrBuilder)this.reviewBuilder_.getMessageOrBuilder(index);
      }

      public List getReviewOrBuilderList() {
         return this.reviewBuilder_ != null ? this.reviewBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.review_);
      }

      public Review.Builder addReviewBuilder() {
         return (Review.Builder)this.getReviewFieldBuilder().addBuilder(Review.getDefaultInstance());
      }

      public Review.Builder addReviewBuilder(int index) {
         return (Review.Builder)this.getReviewFieldBuilder().addBuilder(index, Review.getDefaultInstance());
      }

      public List getReviewBuilderList() {
         return this.getReviewFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getReviewFieldBuilder() {
         if (this.reviewBuilder_ == null) {
            this.reviewBuilder_ = new RepeatedFieldBuilderV3(this.review_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.review_ = null;
         }

         return this.reviewBuilder_;
      }

      public boolean hasMatchingCount() {
         return (this.bitField0_ & 2) != 0;
      }

      public long getMatchingCount() {
         return this.matchingCount_;
      }

      public GetReviewsResponse.Builder setMatchingCount(long value) {
         this.bitField0_ |= 2;
         this.matchingCount_ = value;
         this.onChanged();
         return this;
      }

      public GetReviewsResponse.Builder clearMatchingCount() {
         this.bitField0_ &= -3;
         this.matchingCount_ = 0L;
         this.onChanged();
         return this;
      }

      public final GetReviewsResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (GetReviewsResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final GetReviewsResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (GetReviewsResponse.Builder)super.mergeUnknownFields(unknownFields);
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
