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

public final class EarlyUpdateRequest extends GeneratedMessageV3 implements EarlyUpdateRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DEVICECONFIGURATION_FIELD_NUMBER = 1;
   private DeviceConfigurationProto deviceConfiguration_;
   private byte memoizedIsInitialized;
   private static final EarlyUpdateRequest DEFAULT_INSTANCE = new EarlyUpdateRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public EarlyUpdateRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new EarlyUpdateRequest(input, extensionRegistry);
      }
   };

   private EarlyUpdateRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private EarlyUpdateRequest() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new EarlyUpdateRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private EarlyUpdateRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  DeviceConfigurationProto.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.deviceConfiguration_.toBuilder();
                  }

                  this.deviceConfiguration_ = (DeviceConfigurationProto)input.readMessage(DeviceConfigurationProto.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.deviceConfiguration_);
                     this.deviceConfiguration_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
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
      return Mothership.internal_static_EarlyUpdateRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_EarlyUpdateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyUpdateRequest.class, EarlyUpdateRequest.Builder.class);
   }

   public boolean hasDeviceConfiguration() {
      return (this.bitField0_ & 1) != 0;
   }

   public DeviceConfigurationProto getDeviceConfiguration() {
      return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
   }

   public DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder() {
      return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
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
         output.writeMessage(1, this.getDeviceConfiguration());
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
            size += CodedOutputStream.computeMessageSize(1, this.getDeviceConfiguration());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof EarlyUpdateRequest)) {
         return super.equals(obj);
      } else {
         EarlyUpdateRequest other = (EarlyUpdateRequest)obj;
         if (this.hasDeviceConfiguration() != other.hasDeviceConfiguration()) {
            return false;
         } else if (this.hasDeviceConfiguration() && !this.getDeviceConfiguration().equals(other.getDeviceConfiguration())) {
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
         if (this.hasDeviceConfiguration()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDeviceConfiguration().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static EarlyUpdateRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data);
   }

   public static EarlyUpdateRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data);
   }

   public static EarlyUpdateRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data);
   }

   public static EarlyUpdateRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyUpdateRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyUpdateRequest parseFrom(InputStream input) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyUpdateRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyUpdateRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static EarlyUpdateRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyUpdateRequest parseFrom(CodedInputStream input) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyUpdateRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyUpdateRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public EarlyUpdateRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static EarlyUpdateRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static EarlyUpdateRequest.Builder newBuilder(EarlyUpdateRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public EarlyUpdateRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new EarlyUpdateRequest.Builder() : (new EarlyUpdateRequest.Builder()).mergeFrom(this);
   }

   protected EarlyUpdateRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      EarlyUpdateRequest.Builder builder = new EarlyUpdateRequest.Builder(parent);
      return builder;
   }

   public static EarlyUpdateRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public EarlyUpdateRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   EarlyUpdateRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   EarlyUpdateRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements EarlyUpdateRequestOrBuilder {
      private int bitField0_;
      private DeviceConfigurationProto deviceConfiguration_;
      private SingleFieldBuilderV3 deviceConfigurationBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_EarlyUpdateRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_EarlyUpdateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyUpdateRequest.class, EarlyUpdateRequest.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (EarlyUpdateRequest.alwaysUseFieldBuilders) {
            this.getDeviceConfigurationFieldBuilder();
         }

      }

      public EarlyUpdateRequest.Builder clear() {
         super.clear();
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = null;
         } else {
            this.deviceConfigurationBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_EarlyUpdateRequest_descriptor;
      }

      public EarlyUpdateRequest getDefaultInstanceForType() {
         return EarlyUpdateRequest.getDefaultInstance();
      }

      public EarlyUpdateRequest build() {
         EarlyUpdateRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public EarlyUpdateRequest buildPartial() {
         EarlyUpdateRequest result = new EarlyUpdateRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.deviceConfigurationBuilder_ == null) {
               result.deviceConfiguration_ = this.deviceConfiguration_;
            } else {
               result.deviceConfiguration_ = (DeviceConfigurationProto)this.deviceConfigurationBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public EarlyUpdateRequest.Builder clone() {
         return (EarlyUpdateRequest.Builder)super.clone();
      }

      public EarlyUpdateRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyUpdateRequest.Builder)super.setField(field, value);
      }

      public EarlyUpdateRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (EarlyUpdateRequest.Builder)super.clearField(field);
      }

      public EarlyUpdateRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (EarlyUpdateRequest.Builder)super.clearOneof(oneof);
      }

      public EarlyUpdateRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (EarlyUpdateRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public EarlyUpdateRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyUpdateRequest.Builder)super.addRepeatedField(field, value);
      }

      public EarlyUpdateRequest.Builder mergeFrom(Message other) {
         if (other instanceof EarlyUpdateRequest) {
            return this.mergeFrom((EarlyUpdateRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public EarlyUpdateRequest.Builder mergeFrom(EarlyUpdateRequest other) {
         if (other == EarlyUpdateRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDeviceConfiguration()) {
               this.mergeDeviceConfiguration(other.getDeviceConfiguration());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public EarlyUpdateRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         EarlyUpdateRequest parsedMessage = null;

         try {
            parsedMessage = (EarlyUpdateRequest)EarlyUpdateRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (EarlyUpdateRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDeviceConfiguration() {
         return (this.bitField0_ & 1) != 0;
      }

      public DeviceConfigurationProto getDeviceConfiguration() {
         if (this.deviceConfigurationBuilder_ == null) {
            return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
         } else {
            return (DeviceConfigurationProto)this.deviceConfigurationBuilder_.getMessage();
         }
      }

      public EarlyUpdateRequest.Builder setDeviceConfiguration(DeviceConfigurationProto value) {
         if (this.deviceConfigurationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.deviceConfiguration_ = value;
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyUpdateRequest.Builder setDeviceConfiguration(DeviceConfigurationProto.Builder builderForValue) {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = builderForValue.build();
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyUpdateRequest.Builder mergeDeviceConfiguration(DeviceConfigurationProto value) {
         if (this.deviceConfigurationBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.deviceConfiguration_ != null && this.deviceConfiguration_ != DeviceConfigurationProto.getDefaultInstance()) {
               this.deviceConfiguration_ = DeviceConfigurationProto.newBuilder(this.deviceConfiguration_).mergeFrom(value).buildPartial();
            } else {
               this.deviceConfiguration_ = value;
            }

            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyUpdateRequest.Builder clearDeviceConfiguration() {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = null;
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public DeviceConfigurationProto.Builder getDeviceConfigurationBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (DeviceConfigurationProto.Builder)this.getDeviceConfigurationFieldBuilder().getBuilder();
      }

      public DeviceConfigurationProtoOrBuilder getDeviceConfigurationOrBuilder() {
         if (this.deviceConfigurationBuilder_ != null) {
            return (DeviceConfigurationProtoOrBuilder)this.deviceConfigurationBuilder_.getMessageOrBuilder();
         } else {
            return this.deviceConfiguration_ == null ? DeviceConfigurationProto.getDefaultInstance() : this.deviceConfiguration_;
         }
      }

      private SingleFieldBuilderV3 getDeviceConfigurationFieldBuilder() {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfigurationBuilder_ = new SingleFieldBuilderV3(this.getDeviceConfiguration(), this.getParentForChildren(), this.isClean());
            this.deviceConfiguration_ = null;
         }

         return this.deviceConfigurationBuilder_;
      }

      public final EarlyUpdateRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyUpdateRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final EarlyUpdateRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyUpdateRequest.Builder)super.mergeUnknownFields(unknownFields);
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
