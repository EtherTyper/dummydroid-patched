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

public final class DeliveryResponse extends GeneratedMessageV3 implements DeliveryResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int STATUS_FIELD_NUMBER = 1;
   private int status_;
   public static final int APPDELIVERYDATA_FIELD_NUMBER = 2;
   private AndroidAppDeliveryData appDeliveryData_;
   private byte memoizedIsInitialized;
   private static final DeliveryResponse DEFAULT_INSTANCE = new DeliveryResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public DeliveryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new DeliveryResponse(input, extensionRegistry);
      }
   };

   private DeliveryResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private DeliveryResponse() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new DeliveryResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DeliveryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.status_ = input.readInt32();
                  break;
               case 18:
                  AndroidAppDeliveryData.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.appDeliveryData_.toBuilder();
                  }

                  this.appDeliveryData_ = (AndroidAppDeliveryData)input.readMessage(AndroidAppDeliveryData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.appDeliveryData_);
                     this.appDeliveryData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
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
      return Mothership.internal_static_DeliveryResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_DeliveryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryResponse.class, DeliveryResponse.Builder.class);
   }

   public boolean hasStatus() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getStatus() {
      return this.status_;
   }

   public boolean hasAppDeliveryData() {
      return (this.bitField0_ & 2) != 0;
   }

   public AndroidAppDeliveryData getAppDeliveryData() {
      return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
   }

   public AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder() {
      return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
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
         output.writeInt32(1, this.status_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeMessage(2, this.getAppDeliveryData());
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
            size += CodedOutputStream.computeInt32Size(1, this.status_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getAppDeliveryData());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DeliveryResponse)) {
         return super.equals(obj);
      } else {
         DeliveryResponse other = (DeliveryResponse)obj;
         if (this.hasStatus() != other.hasStatus()) {
            return false;
         } else if (this.hasStatus() && this.getStatus() != other.getStatus()) {
            return false;
         } else if (this.hasAppDeliveryData() != other.hasAppDeliveryData()) {
            return false;
         } else if (this.hasAppDeliveryData() && !this.getAppDeliveryData().equals(other.getAppDeliveryData())) {
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
         if (this.hasStatus()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getStatus();
         }

         if (this.hasAppDeliveryData()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getAppDeliveryData().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static DeliveryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data);
   }

   public static DeliveryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeliveryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data);
   }

   public static DeliveryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeliveryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data);
   }

   public static DeliveryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DeliveryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DeliveryResponse parseFrom(InputStream input) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DeliveryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static DeliveryResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static DeliveryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static DeliveryResponse parseFrom(CodedInputStream input) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DeliveryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DeliveryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public DeliveryResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static DeliveryResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DeliveryResponse.Builder newBuilder(DeliveryResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public DeliveryResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new DeliveryResponse.Builder() : (new DeliveryResponse.Builder()).mergeFrom(this);
   }

   protected DeliveryResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      DeliveryResponse.Builder builder = new DeliveryResponse.Builder(parent);
      return builder;
   }

   public static DeliveryResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DeliveryResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DeliveryResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   DeliveryResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DeliveryResponseOrBuilder {
      private int bitField0_;
      private int status_;
      private AndroidAppDeliveryData appDeliveryData_;
      private SingleFieldBuilderV3 appDeliveryDataBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_DeliveryResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_DeliveryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryResponse.class, DeliveryResponse.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (DeliveryResponse.alwaysUseFieldBuilders) {
            this.getAppDeliveryDataFieldBuilder();
         }

      }

      public DeliveryResponse.Builder clear() {
         super.clear();
         this.status_ = 0;
         this.bitField0_ &= -2;
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = null;
         } else {
            this.appDeliveryDataBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_DeliveryResponse_descriptor;
      }

      public DeliveryResponse getDefaultInstanceForType() {
         return DeliveryResponse.getDefaultInstance();
      }

      public DeliveryResponse build() {
         DeliveryResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public DeliveryResponse buildPartial() {
         DeliveryResponse result = new DeliveryResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.status_ = this.status_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.appDeliveryDataBuilder_ == null) {
               result.appDeliveryData_ = this.appDeliveryData_;
            } else {
               result.appDeliveryData_ = (AndroidAppDeliveryData)this.appDeliveryDataBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public DeliveryResponse.Builder clone() {
         return (DeliveryResponse.Builder)super.clone();
      }

      public DeliveryResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (DeliveryResponse.Builder)super.setField(field, value);
      }

      public DeliveryResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (DeliveryResponse.Builder)super.clearField(field);
      }

      public DeliveryResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (DeliveryResponse.Builder)super.clearOneof(oneof);
      }

      public DeliveryResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (DeliveryResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public DeliveryResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (DeliveryResponse.Builder)super.addRepeatedField(field, value);
      }

      public DeliveryResponse.Builder mergeFrom(Message other) {
         if (other instanceof DeliveryResponse) {
            return this.mergeFrom((DeliveryResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public DeliveryResponse.Builder mergeFrom(DeliveryResponse other) {
         if (other == DeliveryResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasStatus()) {
               this.setStatus(other.getStatus());
            }

            if (other.hasAppDeliveryData()) {
               this.mergeAppDeliveryData(other.getAppDeliveryData());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public DeliveryResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         DeliveryResponse parsedMessage = null;

         try {
            parsedMessage = (DeliveryResponse)DeliveryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (DeliveryResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasStatus() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getStatus() {
         return this.status_;
      }

      public DeliveryResponse.Builder setStatus(int value) {
         this.bitField0_ |= 1;
         this.status_ = value;
         this.onChanged();
         return this;
      }

      public DeliveryResponse.Builder clearStatus() {
         this.bitField0_ &= -2;
         this.status_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasAppDeliveryData() {
         return (this.bitField0_ & 2) != 0;
      }

      public AndroidAppDeliveryData getAppDeliveryData() {
         if (this.appDeliveryDataBuilder_ == null) {
            return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
         } else {
            return (AndroidAppDeliveryData)this.appDeliveryDataBuilder_.getMessage();
         }
      }

      public DeliveryResponse.Builder setAppDeliveryData(AndroidAppDeliveryData value) {
         if (this.appDeliveryDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.appDeliveryData_ = value;
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public DeliveryResponse.Builder setAppDeliveryData(AndroidAppDeliveryData.Builder builderForValue) {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public DeliveryResponse.Builder mergeAppDeliveryData(AndroidAppDeliveryData value) {
         if (this.appDeliveryDataBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.appDeliveryData_ != null && this.appDeliveryData_ != AndroidAppDeliveryData.getDefaultInstance()) {
               this.appDeliveryData_ = AndroidAppDeliveryData.newBuilder(this.appDeliveryData_).mergeFrom(value).buildPartial();
            } else {
               this.appDeliveryData_ = value;
            }

            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public DeliveryResponse.Builder clearAppDeliveryData() {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = null;
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public AndroidAppDeliveryData.Builder getAppDeliveryDataBuilder() {
         this.bitField0_ |= 2;
         this.onChanged();
         return (AndroidAppDeliveryData.Builder)this.getAppDeliveryDataFieldBuilder().getBuilder();
      }

      public AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder() {
         if (this.appDeliveryDataBuilder_ != null) {
            return (AndroidAppDeliveryDataOrBuilder)this.appDeliveryDataBuilder_.getMessageOrBuilder();
         } else {
            return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
         }
      }

      private SingleFieldBuilderV3 getAppDeliveryDataFieldBuilder() {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryDataBuilder_ = new SingleFieldBuilderV3(this.getAppDeliveryData(), this.getParentForChildren(), this.isClean());
            this.appDeliveryData_ = null;
         }

         return this.appDeliveryDataBuilder_;
      }

      public final DeliveryResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (DeliveryResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final DeliveryResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (DeliveryResponse.Builder)super.mergeUnknownFields(unknownFields);
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
