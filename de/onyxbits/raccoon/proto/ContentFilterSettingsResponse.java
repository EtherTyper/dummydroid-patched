package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

public final class ContentFilterSettingsResponse extends GeneratedMessageV3 implements ContentFilterSettingsResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int FILTERRANGE_FIELD_NUMBER = 1;
   private List filterRange_;
   public static final int INTOTITLE_FIELD_NUMBER = 4;
   private volatile Object intoTitle_;
   public static final int INFOTEXT_FIELD_NUMBER = 5;
   private volatile Object infoText_;
   private byte memoizedIsInitialized;
   private static final ContentFilterSettingsResponse DEFAULT_INSTANCE = new ContentFilterSettingsResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ContentFilterSettingsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ContentFilterSettingsResponse(input, extensionRegistry);
      }
   };

   private ContentFilterSettingsResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ContentFilterSettingsResponse() {
      this.memoizedIsInitialized = -1;
      this.filterRange_ = Collections.emptyList();
      this.intoTitle_ = "";
      this.infoText_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ContentFilterSettingsResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ContentFilterSettingsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               ByteString bs;
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  if (!(mutable_bitField0_ & true)) {
                     this.filterRange_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.filterRange_.add(input.readMessage(FilterRange.PARSER, extensionRegistry));
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.intoTitle_ = bs;
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.infoText_ = bs;
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
            if (mutable_bitField0_ & true) {
               this.filterRange_ = Collections.unmodifiableList(this.filterRange_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_ContentFilterSettingsResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ContentFilterSettingsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ContentFilterSettingsResponse.class, ContentFilterSettingsResponse.Builder.class);
   }

   public List getFilterRangeList() {
      return this.filterRange_;
   }

   public List getFilterRangeOrBuilderList() {
      return this.filterRange_;
   }

   public int getFilterRangeCount() {
      return this.filterRange_.size();
   }

   public FilterRange getFilterRange(int index) {
      return (FilterRange)this.filterRange_.get(index);
   }

   public FilterRangeOrBuilder getFilterRangeOrBuilder(int index) {
      return (FilterRangeOrBuilder)this.filterRange_.get(index);
   }

   public boolean hasIntoTitle() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getIntoTitle() {
      Object ref = this.intoTitle_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.intoTitle_ = s;
         }

         return s;
      }
   }

   public ByteString getIntoTitleBytes() {
      Object ref = this.intoTitle_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.intoTitle_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasInfoText() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getInfoText() {
      Object ref = this.infoText_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.infoText_ = s;
         }

         return s;
      }
   }

   public ByteString getInfoTextBytes() {
      Object ref = this.infoText_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.infoText_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
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
      for(int i = 0; i < this.filterRange_.size(); ++i) {
         output.writeMessage(1, (MessageLite)this.filterRange_.get(i));
      }

      if ((this.bitField0_ & 1) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.intoTitle_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.infoText_);
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.filterRange_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.filterRange_.get(i));
         }

         if ((this.bitField0_ & 1) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.intoTitle_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.infoText_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ContentFilterSettingsResponse)) {
         return super.equals(obj);
      } else {
         ContentFilterSettingsResponse other = (ContentFilterSettingsResponse)obj;
         if (!this.getFilterRangeList().equals(other.getFilterRangeList())) {
            return false;
         } else if (this.hasIntoTitle() != other.hasIntoTitle()) {
            return false;
         } else if (this.hasIntoTitle() && !this.getIntoTitle().equals(other.getIntoTitle())) {
            return false;
         } else if (this.hasInfoText() != other.hasInfoText()) {
            return false;
         } else if (this.hasInfoText() && !this.getInfoText().equals(other.getInfoText())) {
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
         if (this.getFilterRangeCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getFilterRangeList().hashCode();
         }

         if (this.hasIntoTitle()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getIntoTitle().hashCode();
         }

         if (this.hasInfoText()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getInfoText().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ContentFilterSettingsResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data);
   }

   public static ContentFilterSettingsResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContentFilterSettingsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data);
   }

   public static ContentFilterSettingsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContentFilterSettingsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data);
   }

   public static ContentFilterSettingsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContentFilterSettingsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContentFilterSettingsResponse parseFrom(InputStream input) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ContentFilterSettingsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ContentFilterSettingsResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ContentFilterSettingsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ContentFilterSettingsResponse parseFrom(CodedInputStream input) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ContentFilterSettingsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContentFilterSettingsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ContentFilterSettingsResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ContentFilterSettingsResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ContentFilterSettingsResponse.Builder newBuilder(ContentFilterSettingsResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ContentFilterSettingsResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ContentFilterSettingsResponse.Builder() : (new ContentFilterSettingsResponse.Builder()).mergeFrom(this);
   }

   protected ContentFilterSettingsResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ContentFilterSettingsResponse.Builder builder = new ContentFilterSettingsResponse.Builder(parent);
      return builder;
   }

   public static ContentFilterSettingsResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ContentFilterSettingsResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ContentFilterSettingsResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ContentFilterSettingsResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ContentFilterSettingsResponseOrBuilder {
      private int bitField0_;
      private List filterRange_;
      private RepeatedFieldBuilderV3 filterRangeBuilder_;
      private Object intoTitle_;
      private Object infoText_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ContentFilterSettingsResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ContentFilterSettingsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ContentFilterSettingsResponse.class, ContentFilterSettingsResponse.Builder.class);
      }

      private Builder() {
         this.filterRange_ = Collections.emptyList();
         this.intoTitle_ = "";
         this.infoText_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.filterRange_ = Collections.emptyList();
         this.intoTitle_ = "";
         this.infoText_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ContentFilterSettingsResponse.alwaysUseFieldBuilders) {
            this.getFilterRangeFieldBuilder();
         }

      }

      public ContentFilterSettingsResponse.Builder clear() {
         super.clear();
         if (this.filterRangeBuilder_ == null) {
            this.filterRange_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.filterRangeBuilder_.clear();
         }

         this.intoTitle_ = "";
         this.bitField0_ &= -3;
         this.infoText_ = "";
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ContentFilterSettingsResponse_descriptor;
      }

      public ContentFilterSettingsResponse getDefaultInstanceForType() {
         return ContentFilterSettingsResponse.getDefaultInstance();
      }

      public ContentFilterSettingsResponse build() {
         ContentFilterSettingsResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ContentFilterSettingsResponse buildPartial() {
         ContentFilterSettingsResponse result = new ContentFilterSettingsResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if (this.filterRangeBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.filterRange_ = Collections.unmodifiableList(this.filterRange_);
               this.bitField0_ &= -2;
            }

            result.filterRange_ = this.filterRange_;
         } else {
            result.filterRange_ = this.filterRangeBuilder_.build();
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 1;
         }

         result.intoTitle_ = this.intoTitle_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 2;
         }

         result.infoText_ = this.infoText_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ContentFilterSettingsResponse.Builder clone() {
         return (ContentFilterSettingsResponse.Builder)super.clone();
      }

      public ContentFilterSettingsResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ContentFilterSettingsResponse.Builder)super.setField(field, value);
      }

      public ContentFilterSettingsResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ContentFilterSettingsResponse.Builder)super.clearField(field);
      }

      public ContentFilterSettingsResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ContentFilterSettingsResponse.Builder)super.clearOneof(oneof);
      }

      public ContentFilterSettingsResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ContentFilterSettingsResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public ContentFilterSettingsResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ContentFilterSettingsResponse.Builder)super.addRepeatedField(field, value);
      }

      public ContentFilterSettingsResponse.Builder mergeFrom(Message other) {
         if (other instanceof ContentFilterSettingsResponse) {
            return this.mergeFrom((ContentFilterSettingsResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ContentFilterSettingsResponse.Builder mergeFrom(ContentFilterSettingsResponse other) {
         if (other == ContentFilterSettingsResponse.getDefaultInstance()) {
            return this;
         } else {
            if (this.filterRangeBuilder_ == null) {
               if (!other.filterRange_.isEmpty()) {
                  if (this.filterRange_.isEmpty()) {
                     this.filterRange_ = other.filterRange_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureFilterRangeIsMutable();
                     this.filterRange_.addAll(other.filterRange_);
                  }

                  this.onChanged();
               }
            } else if (!other.filterRange_.isEmpty()) {
               if (this.filterRangeBuilder_.isEmpty()) {
                  this.filterRangeBuilder_.dispose();
                  this.filterRangeBuilder_ = null;
                  this.filterRange_ = other.filterRange_;
                  this.bitField0_ &= -2;
                  this.filterRangeBuilder_ = ContentFilterSettingsResponse.alwaysUseFieldBuilders ? this.getFilterRangeFieldBuilder() : null;
               } else {
                  this.filterRangeBuilder_.addAllMessages(other.filterRange_);
               }
            }

            if (other.hasIntoTitle()) {
               this.bitField0_ |= 2;
               this.intoTitle_ = other.intoTitle_;
               this.onChanged();
            }

            if (other.hasInfoText()) {
               this.bitField0_ |= 4;
               this.infoText_ = other.infoText_;
               this.onChanged();
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public ContentFilterSettingsResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ContentFilterSettingsResponse parsedMessage = null;

         try {
            parsedMessage = (ContentFilterSettingsResponse)ContentFilterSettingsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ContentFilterSettingsResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureFilterRangeIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.filterRange_ = new ArrayList(this.filterRange_);
            this.bitField0_ |= 1;
         }

      }

      public List getFilterRangeList() {
         return this.filterRangeBuilder_ == null ? Collections.unmodifiableList(this.filterRange_) : this.filterRangeBuilder_.getMessageList();
      }

      public int getFilterRangeCount() {
         return this.filterRangeBuilder_ == null ? this.filterRange_.size() : this.filterRangeBuilder_.getCount();
      }

      public FilterRange getFilterRange(int index) {
         return this.filterRangeBuilder_ == null ? (FilterRange)this.filterRange_.get(index) : (FilterRange)this.filterRangeBuilder_.getMessage(index);
      }

      public ContentFilterSettingsResponse.Builder setFilterRange(int index, FilterRange value) {
         if (this.filterRangeBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterRangeIsMutable();
            this.filterRange_.set(index, value);
            this.onChanged();
         } else {
            this.filterRangeBuilder_.setMessage(index, value);
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder setFilterRange(int index, FilterRange.Builder builderForValue) {
         if (this.filterRangeBuilder_ == null) {
            this.ensureFilterRangeIsMutable();
            this.filterRange_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.filterRangeBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder addFilterRange(FilterRange value) {
         if (this.filterRangeBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterRangeIsMutable();
            this.filterRange_.add(value);
            this.onChanged();
         } else {
            this.filterRangeBuilder_.addMessage(value);
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder addFilterRange(int index, FilterRange value) {
         if (this.filterRangeBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterRangeIsMutable();
            this.filterRange_.add(index, value);
            this.onChanged();
         } else {
            this.filterRangeBuilder_.addMessage(index, value);
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder addFilterRange(FilterRange.Builder builderForValue) {
         if (this.filterRangeBuilder_ == null) {
            this.ensureFilterRangeIsMutable();
            this.filterRange_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.filterRangeBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder addFilterRange(int index, FilterRange.Builder builderForValue) {
         if (this.filterRangeBuilder_ == null) {
            this.ensureFilterRangeIsMutable();
            this.filterRange_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.filterRangeBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder addAllFilterRange(Iterable values) {
         if (this.filterRangeBuilder_ == null) {
            this.ensureFilterRangeIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.filterRange_);
            this.onChanged();
         } else {
            this.filterRangeBuilder_.addAllMessages(values);
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder clearFilterRange() {
         if (this.filterRangeBuilder_ == null) {
            this.filterRange_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.filterRangeBuilder_.clear();
         }

         return this;
      }

      public ContentFilterSettingsResponse.Builder removeFilterRange(int index) {
         if (this.filterRangeBuilder_ == null) {
            this.ensureFilterRangeIsMutable();
            this.filterRange_.remove(index);
            this.onChanged();
         } else {
            this.filterRangeBuilder_.remove(index);
         }

         return this;
      }

      public FilterRange.Builder getFilterRangeBuilder(int index) {
         return (FilterRange.Builder)this.getFilterRangeFieldBuilder().getBuilder(index);
      }

      public FilterRangeOrBuilder getFilterRangeOrBuilder(int index) {
         return this.filterRangeBuilder_ == null ? (FilterRangeOrBuilder)this.filterRange_.get(index) : (FilterRangeOrBuilder)this.filterRangeBuilder_.getMessageOrBuilder(index);
      }

      public List getFilterRangeOrBuilderList() {
         return this.filterRangeBuilder_ != null ? this.filterRangeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.filterRange_);
      }

      public FilterRange.Builder addFilterRangeBuilder() {
         return (FilterRange.Builder)this.getFilterRangeFieldBuilder().addBuilder(FilterRange.getDefaultInstance());
      }

      public FilterRange.Builder addFilterRangeBuilder(int index) {
         return (FilterRange.Builder)this.getFilterRangeFieldBuilder().addBuilder(index, FilterRange.getDefaultInstance());
      }

      public List getFilterRangeBuilderList() {
         return this.getFilterRangeFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getFilterRangeFieldBuilder() {
         if (this.filterRangeBuilder_ == null) {
            this.filterRangeBuilder_ = new RepeatedFieldBuilderV3(this.filterRange_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.filterRange_ = null;
         }

         return this.filterRangeBuilder_;
      }

      public boolean hasIntoTitle() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getIntoTitle() {
         Object ref = this.intoTitle_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.intoTitle_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getIntoTitleBytes() {
         Object ref = this.intoTitle_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.intoTitle_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ContentFilterSettingsResponse.Builder setIntoTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.intoTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public ContentFilterSettingsResponse.Builder clearIntoTitle() {
         this.bitField0_ &= -3;
         this.intoTitle_ = ContentFilterSettingsResponse.getDefaultInstance().getIntoTitle();
         this.onChanged();
         return this;
      }

      public ContentFilterSettingsResponse.Builder setIntoTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.intoTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasInfoText() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getInfoText() {
         Object ref = this.infoText_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.infoText_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getInfoTextBytes() {
         Object ref = this.infoText_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.infoText_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ContentFilterSettingsResponse.Builder setInfoText(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.infoText_ = value;
            this.onChanged();
            return this;
         }
      }

      public ContentFilterSettingsResponse.Builder clearInfoText() {
         this.bitField0_ &= -5;
         this.infoText_ = ContentFilterSettingsResponse.getDefaultInstance().getInfoText();
         this.onChanged();
         return this;
      }

      public ContentFilterSettingsResponse.Builder setInfoTextBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.infoText_ = value;
            this.onChanged();
            return this;
         }
      }

      public final ContentFilterSettingsResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ContentFilterSettingsResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final ContentFilterSettingsResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ContentFilterSettingsResponse.Builder)super.mergeUnknownFields(unknownFields);
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
