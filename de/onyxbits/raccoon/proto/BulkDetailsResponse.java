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

public final class BulkDetailsResponse extends GeneratedMessageV3 implements BulkDetailsResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   public static final int ENTRY_FIELD_NUMBER = 1;
   private List entry_;
   private byte memoizedIsInitialized;
   private static final BulkDetailsResponse DEFAULT_INSTANCE = new BulkDetailsResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public BulkDetailsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new BulkDetailsResponse(input, extensionRegistry);
      }
   };

   private BulkDetailsResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private BulkDetailsResponse() {
      this.memoizedIsInitialized = -1;
      this.entry_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new BulkDetailsResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BulkDetailsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                     this.entry_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.entry_.add(input.readMessage(BulkDetailsEntry.PARSER, extensionRegistry));
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
               this.entry_ = Collections.unmodifiableList(this.entry_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_BulkDetailsResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_BulkDetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsResponse.class, BulkDetailsResponse.Builder.class);
   }

   public List getEntryList() {
      return this.entry_;
   }

   public List getEntryOrBuilderList() {
      return this.entry_;
   }

   public int getEntryCount() {
      return this.entry_.size();
   }

   public BulkDetailsEntry getEntry(int index) {
      return (BulkDetailsEntry)this.entry_.get(index);
   }

   public BulkDetailsEntryOrBuilder getEntryOrBuilder(int index) {
      return (BulkDetailsEntryOrBuilder)this.entry_.get(index);
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
      for(int i = 0; i < this.entry_.size(); ++i) {
         output.writeMessage(1, (MessageLite)this.entry_.get(i));
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.entry_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.entry_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof BulkDetailsResponse)) {
         return super.equals(obj);
      } else {
         BulkDetailsResponse other = (BulkDetailsResponse)obj;
         if (!this.getEntryList().equals(other.getEntryList())) {
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
         if (this.getEntryCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getEntryList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static BulkDetailsResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data);
   }

   public static BulkDetailsResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data);
   }

   public static BulkDetailsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data);
   }

   public static BulkDetailsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsResponse parseFrom(InputStream input) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static BulkDetailsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsResponse parseFrom(CodedInputStream input) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public BulkDetailsResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static BulkDetailsResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BulkDetailsResponse.Builder newBuilder(BulkDetailsResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public BulkDetailsResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new BulkDetailsResponse.Builder() : (new BulkDetailsResponse.Builder()).mergeFrom(this);
   }

   protected BulkDetailsResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      BulkDetailsResponse.Builder builder = new BulkDetailsResponse.Builder(parent);
      return builder;
   }

   public static BulkDetailsResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BulkDetailsResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   BulkDetailsResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   BulkDetailsResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements BulkDetailsResponseOrBuilder {
      private int bitField0_;
      private List entry_;
      private RepeatedFieldBuilderV3 entryBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_BulkDetailsResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_BulkDetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsResponse.class, BulkDetailsResponse.Builder.class);
      }

      private Builder() {
         this.entry_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.entry_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (BulkDetailsResponse.alwaysUseFieldBuilders) {
            this.getEntryFieldBuilder();
         }

      }

      public BulkDetailsResponse.Builder clear() {
         super.clear();
         if (this.entryBuilder_ == null) {
            this.entry_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.entryBuilder_.clear();
         }

         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_BulkDetailsResponse_descriptor;
      }

      public BulkDetailsResponse getDefaultInstanceForType() {
         return BulkDetailsResponse.getDefaultInstance();
      }

      public BulkDetailsResponse build() {
         BulkDetailsResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public BulkDetailsResponse buildPartial() {
         BulkDetailsResponse result = new BulkDetailsResponse(this);
         int from_bitField0_ = this.bitField0_;
         if (this.entryBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.entry_ = Collections.unmodifiableList(this.entry_);
               this.bitField0_ &= -2;
            }

            result.entry_ = this.entry_;
         } else {
            result.entry_ = this.entryBuilder_.build();
         }

         this.onBuilt();
         return result;
      }

      public BulkDetailsResponse.Builder clone() {
         return (BulkDetailsResponse.Builder)super.clone();
      }

      public BulkDetailsResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsResponse.Builder)super.setField(field, value);
      }

      public BulkDetailsResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (BulkDetailsResponse.Builder)super.clearField(field);
      }

      public BulkDetailsResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (BulkDetailsResponse.Builder)super.clearOneof(oneof);
      }

      public BulkDetailsResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (BulkDetailsResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public BulkDetailsResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsResponse.Builder)super.addRepeatedField(field, value);
      }

      public BulkDetailsResponse.Builder mergeFrom(Message other) {
         if (other instanceof BulkDetailsResponse) {
            return this.mergeFrom((BulkDetailsResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public BulkDetailsResponse.Builder mergeFrom(BulkDetailsResponse other) {
         if (other == BulkDetailsResponse.getDefaultInstance()) {
            return this;
         } else {
            if (this.entryBuilder_ == null) {
               if (!other.entry_.isEmpty()) {
                  if (this.entry_.isEmpty()) {
                     this.entry_ = other.entry_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureEntryIsMutable();
                     this.entry_.addAll(other.entry_);
                  }

                  this.onChanged();
               }
            } else if (!other.entry_.isEmpty()) {
               if (this.entryBuilder_.isEmpty()) {
                  this.entryBuilder_.dispose();
                  this.entryBuilder_ = null;
                  this.entry_ = other.entry_;
                  this.bitField0_ &= -2;
                  this.entryBuilder_ = BulkDetailsResponse.alwaysUseFieldBuilders ? this.getEntryFieldBuilder() : null;
               } else {
                  this.entryBuilder_.addAllMessages(other.entry_);
               }
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public BulkDetailsResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         BulkDetailsResponse parsedMessage = null;

         try {
            parsedMessage = (BulkDetailsResponse)BulkDetailsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (BulkDetailsResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureEntryIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.entry_ = new ArrayList(this.entry_);
            this.bitField0_ |= 1;
         }

      }

      public List getEntryList() {
         return this.entryBuilder_ == null ? Collections.unmodifiableList(this.entry_) : this.entryBuilder_.getMessageList();
      }

      public int getEntryCount() {
         return this.entryBuilder_ == null ? this.entry_.size() : this.entryBuilder_.getCount();
      }

      public BulkDetailsEntry getEntry(int index) {
         return this.entryBuilder_ == null ? (BulkDetailsEntry)this.entry_.get(index) : (BulkDetailsEntry)this.entryBuilder_.getMessage(index);
      }

      public BulkDetailsResponse.Builder setEntry(int index, BulkDetailsEntry value) {
         if (this.entryBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEntryIsMutable();
            this.entry_.set(index, value);
            this.onChanged();
         } else {
            this.entryBuilder_.setMessage(index, value);
         }

         return this;
      }

      public BulkDetailsResponse.Builder setEntry(int index, BulkDetailsEntry.Builder builderForValue) {
         if (this.entryBuilder_ == null) {
            this.ensureEntryIsMutable();
            this.entry_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.entryBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public BulkDetailsResponse.Builder addEntry(BulkDetailsEntry value) {
         if (this.entryBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEntryIsMutable();
            this.entry_.add(value);
            this.onChanged();
         } else {
            this.entryBuilder_.addMessage(value);
         }

         return this;
      }

      public BulkDetailsResponse.Builder addEntry(int index, BulkDetailsEntry value) {
         if (this.entryBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEntryIsMutable();
            this.entry_.add(index, value);
            this.onChanged();
         } else {
            this.entryBuilder_.addMessage(index, value);
         }

         return this;
      }

      public BulkDetailsResponse.Builder addEntry(BulkDetailsEntry.Builder builderForValue) {
         if (this.entryBuilder_ == null) {
            this.ensureEntryIsMutable();
            this.entry_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.entryBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public BulkDetailsResponse.Builder addEntry(int index, BulkDetailsEntry.Builder builderForValue) {
         if (this.entryBuilder_ == null) {
            this.ensureEntryIsMutable();
            this.entry_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.entryBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public BulkDetailsResponse.Builder addAllEntry(Iterable values) {
         if (this.entryBuilder_ == null) {
            this.ensureEntryIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.entry_);
            this.onChanged();
         } else {
            this.entryBuilder_.addAllMessages(values);
         }

         return this;
      }

      public BulkDetailsResponse.Builder clearEntry() {
         if (this.entryBuilder_ == null) {
            this.entry_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.entryBuilder_.clear();
         }

         return this;
      }

      public BulkDetailsResponse.Builder removeEntry(int index) {
         if (this.entryBuilder_ == null) {
            this.ensureEntryIsMutable();
            this.entry_.remove(index);
            this.onChanged();
         } else {
            this.entryBuilder_.remove(index);
         }

         return this;
      }

      public BulkDetailsEntry.Builder getEntryBuilder(int index) {
         return (BulkDetailsEntry.Builder)this.getEntryFieldBuilder().getBuilder(index);
      }

      public BulkDetailsEntryOrBuilder getEntryOrBuilder(int index) {
         return this.entryBuilder_ == null ? (BulkDetailsEntryOrBuilder)this.entry_.get(index) : (BulkDetailsEntryOrBuilder)this.entryBuilder_.getMessageOrBuilder(index);
      }

      public List getEntryOrBuilderList() {
         return this.entryBuilder_ != null ? this.entryBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.entry_);
      }

      public BulkDetailsEntry.Builder addEntryBuilder() {
         return (BulkDetailsEntry.Builder)this.getEntryFieldBuilder().addBuilder(BulkDetailsEntry.getDefaultInstance());
      }

      public BulkDetailsEntry.Builder addEntryBuilder(int index) {
         return (BulkDetailsEntry.Builder)this.getEntryFieldBuilder().addBuilder(index, BulkDetailsEntry.getDefaultInstance());
      }

      public List getEntryBuilderList() {
         return this.getEntryFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getEntryFieldBuilder() {
         if (this.entryBuilder_ == null) {
            this.entryBuilder_ = new RepeatedFieldBuilderV3(this.entry_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.entry_ = null;
         }

         return this.entryBuilder_;
      }

      public final BulkDetailsResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final BulkDetailsResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsResponse.Builder)super.mergeUnknownFields(unknownFields);
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
