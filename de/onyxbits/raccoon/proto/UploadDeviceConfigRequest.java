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

public final class UploadDeviceConfigRequest extends GeneratedMessageV3 implements UploadDeviceConfigRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DEVICECONFIGURATION_FIELD_NUMBER = 1;
   private DeviceConfigurationProto deviceConfiguration_;
   public static final int MANUFACTURER_FIELD_NUMBER = 2;
   private volatile Object manufacturer_;
   public static final int GCMREGISTRATIONID_FIELD_NUMBER = 3;
   private volatile Object gcmRegistrationId_;
   private byte memoizedIsInitialized;
   private static final UploadDeviceConfigRequest DEFAULT_INSTANCE = new UploadDeviceConfigRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public UploadDeviceConfigRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new UploadDeviceConfigRequest(input, extensionRegistry);
      }
   };

   private UploadDeviceConfigRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private UploadDeviceConfigRequest() {
      this.memoizedIsInitialized = -1;
      this.manufacturer_ = "";
      this.gcmRegistrationId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new UploadDeviceConfigRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private UploadDeviceConfigRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.manufacturer_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.gcmRegistrationId_ = bs;
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
      return Mothership.internal_static_UploadDeviceConfigRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_UploadDeviceConfigRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UploadDeviceConfigRequest.class, UploadDeviceConfigRequest.Builder.class);
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

   public boolean hasManufacturer() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getManufacturer() {
      Object ref = this.manufacturer_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.manufacturer_ = s;
         }

         return s;
      }
   }

   public ByteString getManufacturerBytes() {
      Object ref = this.manufacturer_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.manufacturer_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasGcmRegistrationId() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getGcmRegistrationId() {
      Object ref = this.gcmRegistrationId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.gcmRegistrationId_ = s;
         }

         return s;
      }
   }

   public ByteString getGcmRegistrationIdBytes() {
      Object ref = this.gcmRegistrationId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.gcmRegistrationId_ = b;
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
      if ((this.bitField0_ & 1) != 0) {
         output.writeMessage(1, this.getDeviceConfiguration());
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.manufacturer_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.gcmRegistrationId_);
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

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.manufacturer_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.gcmRegistrationId_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof UploadDeviceConfigRequest)) {
         return super.equals(obj);
      } else {
         UploadDeviceConfigRequest other = (UploadDeviceConfigRequest)obj;
         if (this.hasDeviceConfiguration() != other.hasDeviceConfiguration()) {
            return false;
         } else if (this.hasDeviceConfiguration() && !this.getDeviceConfiguration().equals(other.getDeviceConfiguration())) {
            return false;
         } else if (this.hasManufacturer() != other.hasManufacturer()) {
            return false;
         } else if (this.hasManufacturer() && !this.getManufacturer().equals(other.getManufacturer())) {
            return false;
         } else if (this.hasGcmRegistrationId() != other.hasGcmRegistrationId()) {
            return false;
         } else if (this.hasGcmRegistrationId() && !this.getGcmRegistrationId().equals(other.getGcmRegistrationId())) {
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

         if (this.hasManufacturer()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getManufacturer().hashCode();
         }

         if (this.hasGcmRegistrationId()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getGcmRegistrationId().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static UploadDeviceConfigRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigRequest parseFrom(InputStream input) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static UploadDeviceConfigRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static UploadDeviceConfigRequest parseFrom(CodedInputStream input) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public UploadDeviceConfigRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static UploadDeviceConfigRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static UploadDeviceConfigRequest.Builder newBuilder(UploadDeviceConfigRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public UploadDeviceConfigRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new UploadDeviceConfigRequest.Builder() : (new UploadDeviceConfigRequest.Builder()).mergeFrom(this);
   }

   protected UploadDeviceConfigRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      UploadDeviceConfigRequest.Builder builder = new UploadDeviceConfigRequest.Builder(parent);
      return builder;
   }

   public static UploadDeviceConfigRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public UploadDeviceConfigRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   UploadDeviceConfigRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   UploadDeviceConfigRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements UploadDeviceConfigRequestOrBuilder {
      private int bitField0_;
      private DeviceConfigurationProto deviceConfiguration_;
      private SingleFieldBuilderV3 deviceConfigurationBuilder_;
      private Object manufacturer_;
      private Object gcmRegistrationId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_UploadDeviceConfigRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_UploadDeviceConfigRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UploadDeviceConfigRequest.class, UploadDeviceConfigRequest.Builder.class);
      }

      private Builder() {
         this.manufacturer_ = "";
         this.gcmRegistrationId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.manufacturer_ = "";
         this.gcmRegistrationId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (UploadDeviceConfigRequest.alwaysUseFieldBuilders) {
            this.getDeviceConfigurationFieldBuilder();
         }

      }

      public UploadDeviceConfigRequest.Builder clear() {
         super.clear();
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = null;
         } else {
            this.deviceConfigurationBuilder_.clear();
         }

         this.bitField0_ &= -2;
         this.manufacturer_ = "";
         this.bitField0_ &= -3;
         this.gcmRegistrationId_ = "";
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_UploadDeviceConfigRequest_descriptor;
      }

      public UploadDeviceConfigRequest getDefaultInstanceForType() {
         return UploadDeviceConfigRequest.getDefaultInstance();
      }

      public UploadDeviceConfigRequest build() {
         UploadDeviceConfigRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public UploadDeviceConfigRequest buildPartial() {
         UploadDeviceConfigRequest result = new UploadDeviceConfigRequest(this);
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

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.manufacturer_ = this.manufacturer_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.gcmRegistrationId_ = this.gcmRegistrationId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public UploadDeviceConfigRequest.Builder clone() {
         return (UploadDeviceConfigRequest.Builder)super.clone();
      }

      public UploadDeviceConfigRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (UploadDeviceConfigRequest.Builder)super.setField(field, value);
      }

      public UploadDeviceConfigRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (UploadDeviceConfigRequest.Builder)super.clearField(field);
      }

      public UploadDeviceConfigRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (UploadDeviceConfigRequest.Builder)super.clearOneof(oneof);
      }

      public UploadDeviceConfigRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (UploadDeviceConfigRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public UploadDeviceConfigRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (UploadDeviceConfigRequest.Builder)super.addRepeatedField(field, value);
      }

      public UploadDeviceConfigRequest.Builder mergeFrom(Message other) {
         if (other instanceof UploadDeviceConfigRequest) {
            return this.mergeFrom((UploadDeviceConfigRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public UploadDeviceConfigRequest.Builder mergeFrom(UploadDeviceConfigRequest other) {
         if (other == UploadDeviceConfigRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDeviceConfiguration()) {
               this.mergeDeviceConfiguration(other.getDeviceConfiguration());
            }

            if (other.hasManufacturer()) {
               this.bitField0_ |= 2;
               this.manufacturer_ = other.manufacturer_;
               this.onChanged();
            }

            if (other.hasGcmRegistrationId()) {
               this.bitField0_ |= 4;
               this.gcmRegistrationId_ = other.gcmRegistrationId_;
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

      public UploadDeviceConfigRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         UploadDeviceConfigRequest parsedMessage = null;

         try {
            parsedMessage = (UploadDeviceConfigRequest)UploadDeviceConfigRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (UploadDeviceConfigRequest)var8.getUnfinishedMessage();
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

      public UploadDeviceConfigRequest.Builder setDeviceConfiguration(DeviceConfigurationProto value) {
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

      public UploadDeviceConfigRequest.Builder setDeviceConfiguration(DeviceConfigurationProto.Builder builderForValue) {
         if (this.deviceConfigurationBuilder_ == null) {
            this.deviceConfiguration_ = builderForValue.build();
            this.onChanged();
         } else {
            this.deviceConfigurationBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public UploadDeviceConfigRequest.Builder mergeDeviceConfiguration(DeviceConfigurationProto value) {
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

      public UploadDeviceConfigRequest.Builder clearDeviceConfiguration() {
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

      public boolean hasManufacturer() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getManufacturer() {
         Object ref = this.manufacturer_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.manufacturer_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getManufacturerBytes() {
         Object ref = this.manufacturer_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.manufacturer_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public UploadDeviceConfigRequest.Builder setManufacturer(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.manufacturer_ = value;
            this.onChanged();
            return this;
         }
      }

      public UploadDeviceConfigRequest.Builder clearManufacturer() {
         this.bitField0_ &= -3;
         this.manufacturer_ = UploadDeviceConfigRequest.getDefaultInstance().getManufacturer();
         this.onChanged();
         return this;
      }

      public UploadDeviceConfigRequest.Builder setManufacturerBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.manufacturer_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasGcmRegistrationId() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getGcmRegistrationId() {
         Object ref = this.gcmRegistrationId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.gcmRegistrationId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getGcmRegistrationIdBytes() {
         Object ref = this.gcmRegistrationId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.gcmRegistrationId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public UploadDeviceConfigRequest.Builder setGcmRegistrationId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.gcmRegistrationId_ = value;
            this.onChanged();
            return this;
         }
      }

      public UploadDeviceConfigRequest.Builder clearGcmRegistrationId() {
         this.bitField0_ &= -5;
         this.gcmRegistrationId_ = UploadDeviceConfigRequest.getDefaultInstance().getGcmRegistrationId();
         this.onChanged();
         return this;
      }

      public UploadDeviceConfigRequest.Builder setGcmRegistrationIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.gcmRegistrationId_ = value;
            this.onChanged();
            return this;
         }
      }

      public final UploadDeviceConfigRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (UploadDeviceConfigRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final UploadDeviceConfigRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (UploadDeviceConfigRequest.Builder)super.mergeUnknownFields(unknownFields);
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
