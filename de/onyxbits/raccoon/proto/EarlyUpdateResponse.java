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

public final class EarlyUpdateResponse extends GeneratedMessageV3 implements EarlyUpdateResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   public static final int EARLYDOCUMENTINFO_FIELD_NUMBER = 1;
   private List earlyDocumentInfo_;
   private byte memoizedIsInitialized;
   private static final EarlyUpdateResponse DEFAULT_INSTANCE = new EarlyUpdateResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public EarlyUpdateResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new EarlyUpdateResponse(input, extensionRegistry);
      }
   };

   private EarlyUpdateResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private EarlyUpdateResponse() {
      this.memoizedIsInitialized = -1;
      this.earlyDocumentInfo_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new EarlyUpdateResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private EarlyUpdateResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                     this.earlyDocumentInfo_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.earlyDocumentInfo_.add(input.readMessage(EarlyDocumentInfo.PARSER, extensionRegistry));
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
               this.earlyDocumentInfo_ = Collections.unmodifiableList(this.earlyDocumentInfo_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_EarlyUpdateResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_EarlyUpdateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyUpdateResponse.class, EarlyUpdateResponse.Builder.class);
   }

   public List getEarlyDocumentInfoList() {
      return this.earlyDocumentInfo_;
   }

   public List getEarlyDocumentInfoOrBuilderList() {
      return this.earlyDocumentInfo_;
   }

   public int getEarlyDocumentInfoCount() {
      return this.earlyDocumentInfo_.size();
   }

   public EarlyDocumentInfo getEarlyDocumentInfo(int index) {
      return (EarlyDocumentInfo)this.earlyDocumentInfo_.get(index);
   }

   public EarlyDocumentInfoOrBuilder getEarlyDocumentInfoOrBuilder(int index) {
      return (EarlyDocumentInfoOrBuilder)this.earlyDocumentInfo_.get(index);
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
      for(int i = 0; i < this.earlyDocumentInfo_.size(); ++i) {
         output.writeMessage(1, (MessageLite)this.earlyDocumentInfo_.get(i));
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.earlyDocumentInfo_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.earlyDocumentInfo_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof EarlyUpdateResponse)) {
         return super.equals(obj);
      } else {
         EarlyUpdateResponse other = (EarlyUpdateResponse)obj;
         if (!this.getEarlyDocumentInfoList().equals(other.getEarlyDocumentInfoList())) {
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
         if (this.getEarlyDocumentInfoCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getEarlyDocumentInfoList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static EarlyUpdateResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data);
   }

   public static EarlyUpdateResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data);
   }

   public static EarlyUpdateResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data);
   }

   public static EarlyUpdateResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateResponse parseFrom(InputStream input) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyUpdateResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyUpdateResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static EarlyUpdateResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyUpdateResponse parseFrom(CodedInputStream input) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyUpdateResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public EarlyUpdateResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static EarlyUpdateResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static EarlyUpdateResponse.Builder newBuilder(EarlyUpdateResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public EarlyUpdateResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new EarlyUpdateResponse.Builder() : (new EarlyUpdateResponse.Builder()).mergeFrom(this);
   }

   protected EarlyUpdateResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      EarlyUpdateResponse.Builder builder = new EarlyUpdateResponse.Builder(parent);
      return builder;
   }

   public static EarlyUpdateResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public EarlyUpdateResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   EarlyUpdateResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   EarlyUpdateResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements EarlyUpdateResponseOrBuilder {
      private int bitField0_;
      private List earlyDocumentInfo_;
      private RepeatedFieldBuilderV3 earlyDocumentInfoBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_EarlyUpdateResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_EarlyUpdateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyUpdateResponse.class, EarlyUpdateResponse.Builder.class);
      }

      private Builder() {
         this.earlyDocumentInfo_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.earlyDocumentInfo_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (EarlyUpdateResponse.alwaysUseFieldBuilders) {
            this.getEarlyDocumentInfoFieldBuilder();
         }

      }

      public EarlyUpdateResponse.Builder clear() {
         super.clear();
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.earlyDocumentInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.earlyDocumentInfoBuilder_.clear();
         }

         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_EarlyUpdateResponse_descriptor;
      }

      public EarlyUpdateResponse getDefaultInstanceForType() {
         return EarlyUpdateResponse.getDefaultInstance();
      }

      public EarlyUpdateResponse build() {
         EarlyUpdateResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public EarlyUpdateResponse buildPartial() {
         EarlyUpdateResponse result = new EarlyUpdateResponse(this);
         int from_bitField0_ = this.bitField0_;
         if (this.earlyDocumentInfoBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.earlyDocumentInfo_ = Collections.unmodifiableList(this.earlyDocumentInfo_);
               this.bitField0_ &= -2;
            }

            result.earlyDocumentInfo_ = this.earlyDocumentInfo_;
         } else {
            result.earlyDocumentInfo_ = this.earlyDocumentInfoBuilder_.build();
         }

         this.onBuilt();
         return result;
      }

      public EarlyUpdateResponse.Builder clone() {
         return (EarlyUpdateResponse.Builder)super.clone();
      }

      public EarlyUpdateResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyUpdateResponse.Builder)super.setField(field, value);
      }

      public EarlyUpdateResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (EarlyUpdateResponse.Builder)super.clearField(field);
      }

      public EarlyUpdateResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (EarlyUpdateResponse.Builder)super.clearOneof(oneof);
      }

      public EarlyUpdateResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (EarlyUpdateResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public EarlyUpdateResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyUpdateResponse.Builder)super.addRepeatedField(field, value);
      }

      public EarlyUpdateResponse.Builder mergeFrom(Message other) {
         if (other instanceof EarlyUpdateResponse) {
            return this.mergeFrom((EarlyUpdateResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public EarlyUpdateResponse.Builder mergeFrom(EarlyUpdateResponse other) {
         if (other == EarlyUpdateResponse.getDefaultInstance()) {
            return this;
         } else {
            if (this.earlyDocumentInfoBuilder_ == null) {
               if (!other.earlyDocumentInfo_.isEmpty()) {
                  if (this.earlyDocumentInfo_.isEmpty()) {
                     this.earlyDocumentInfo_ = other.earlyDocumentInfo_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureEarlyDocumentInfoIsMutable();
                     this.earlyDocumentInfo_.addAll(other.earlyDocumentInfo_);
                  }

                  this.onChanged();
               }
            } else if (!other.earlyDocumentInfo_.isEmpty()) {
               if (this.earlyDocumentInfoBuilder_.isEmpty()) {
                  this.earlyDocumentInfoBuilder_.dispose();
                  this.earlyDocumentInfoBuilder_ = null;
                  this.earlyDocumentInfo_ = other.earlyDocumentInfo_;
                  this.bitField0_ &= -2;
                  this.earlyDocumentInfoBuilder_ = EarlyUpdateResponse.alwaysUseFieldBuilders ? this.getEarlyDocumentInfoFieldBuilder() : null;
               } else {
                  this.earlyDocumentInfoBuilder_.addAllMessages(other.earlyDocumentInfo_);
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

      public EarlyUpdateResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         EarlyUpdateResponse parsedMessage = null;

         try {
            parsedMessage = (EarlyUpdateResponse)EarlyUpdateResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (EarlyUpdateResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureEarlyDocumentInfoIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.earlyDocumentInfo_ = new ArrayList(this.earlyDocumentInfo_);
            this.bitField0_ |= 1;
         }

      }

      public List getEarlyDocumentInfoList() {
         return this.earlyDocumentInfoBuilder_ == null ? Collections.unmodifiableList(this.earlyDocumentInfo_) : this.earlyDocumentInfoBuilder_.getMessageList();
      }

      public int getEarlyDocumentInfoCount() {
         return this.earlyDocumentInfoBuilder_ == null ? this.earlyDocumentInfo_.size() : this.earlyDocumentInfoBuilder_.getCount();
      }

      public EarlyDocumentInfo getEarlyDocumentInfo(int index) {
         return this.earlyDocumentInfoBuilder_ == null ? (EarlyDocumentInfo)this.earlyDocumentInfo_.get(index) : (EarlyDocumentInfo)this.earlyDocumentInfoBuilder_.getMessage(index);
      }

      public EarlyUpdateResponse.Builder setEarlyDocumentInfo(int index, EarlyDocumentInfo value) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.set(index, value);
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.setMessage(index, value);
         }

         return this;
      }

      public EarlyUpdateResponse.Builder setEarlyDocumentInfo(int index, EarlyDocumentInfo.Builder builderForValue) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public EarlyUpdateResponse.Builder addEarlyDocumentInfo(EarlyDocumentInfo value) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.add(value);
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.addMessage(value);
         }

         return this;
      }

      public EarlyUpdateResponse.Builder addEarlyDocumentInfo(int index, EarlyDocumentInfo value) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.add(index, value);
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.addMessage(index, value);
         }

         return this;
      }

      public EarlyUpdateResponse.Builder addEarlyDocumentInfo(EarlyDocumentInfo.Builder builderForValue) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public EarlyUpdateResponse.Builder addEarlyDocumentInfo(int index, EarlyDocumentInfo.Builder builderForValue) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public EarlyUpdateResponse.Builder addAllEarlyDocumentInfo(Iterable values) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.ensureEarlyDocumentInfoIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.earlyDocumentInfo_);
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.addAllMessages(values);
         }

         return this;
      }

      public EarlyUpdateResponse.Builder clearEarlyDocumentInfo() {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.earlyDocumentInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.clear();
         }

         return this;
      }

      public EarlyUpdateResponse.Builder removeEarlyDocumentInfo(int index) {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.ensureEarlyDocumentInfoIsMutable();
            this.earlyDocumentInfo_.remove(index);
            this.onChanged();
         } else {
            this.earlyDocumentInfoBuilder_.remove(index);
         }

         return this;
      }

      public EarlyDocumentInfo.Builder getEarlyDocumentInfoBuilder(int index) {
         return (EarlyDocumentInfo.Builder)this.getEarlyDocumentInfoFieldBuilder().getBuilder(index);
      }

      public EarlyDocumentInfoOrBuilder getEarlyDocumentInfoOrBuilder(int index) {
         return this.earlyDocumentInfoBuilder_ == null ? (EarlyDocumentInfoOrBuilder)this.earlyDocumentInfo_.get(index) : (EarlyDocumentInfoOrBuilder)this.earlyDocumentInfoBuilder_.getMessageOrBuilder(index);
      }

      public List getEarlyDocumentInfoOrBuilderList() {
         return this.earlyDocumentInfoBuilder_ != null ? this.earlyDocumentInfoBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.earlyDocumentInfo_);
      }

      public EarlyDocumentInfo.Builder addEarlyDocumentInfoBuilder() {
         return (EarlyDocumentInfo.Builder)this.getEarlyDocumentInfoFieldBuilder().addBuilder(EarlyDocumentInfo.getDefaultInstance());
      }

      public EarlyDocumentInfo.Builder addEarlyDocumentInfoBuilder(int index) {
         return (EarlyDocumentInfo.Builder)this.getEarlyDocumentInfoFieldBuilder().addBuilder(index, EarlyDocumentInfo.getDefaultInstance());
      }

      public List getEarlyDocumentInfoBuilderList() {
         return this.getEarlyDocumentInfoFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getEarlyDocumentInfoFieldBuilder() {
         if (this.earlyDocumentInfoBuilder_ == null) {
            this.earlyDocumentInfoBuilder_ = new RepeatedFieldBuilderV3(this.earlyDocumentInfo_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.earlyDocumentInfo_ = null;
         }

         return this.earlyDocumentInfoBuilder_;
      }

      public final EarlyUpdateResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyUpdateResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final EarlyUpdateResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyUpdateResponse.Builder)super.mergeUnknownFields(unknownFields);
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
