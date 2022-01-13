package de.onyxbits.raccoon.proto;

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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SelfUpdateResponse extends GeneratedMessageV3 implements SelfUpdateResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int REQUIRESUPLOADDEVICECONFIG_FIELD_NUMBER = 1;
   private boolean requiresUploadDeviceConfig_;
   public static final int LATESTCLIENTVERSIONCODE_FIELD_NUMBER = 2;
   private int latestClientVersionCode_;
   private byte memoizedIsInitialized;
   private static final SelfUpdateResponse DEFAULT_INSTANCE = new SelfUpdateResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public SelfUpdateResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new SelfUpdateResponse(input, extensionRegistry);
      }
   };

   private SelfUpdateResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private SelfUpdateResponse() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new SelfUpdateResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private SelfUpdateResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.requiresUploadDeviceConfig_ = input.readBool();
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.latestClientVersionCode_ = input.readInt32();
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
            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_SelfUpdateResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_SelfUpdateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SelfUpdateResponse.class, SelfUpdateResponse.Builder.class);
   }

   public boolean hasRequiresUploadDeviceConfig() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getRequiresUploadDeviceConfig() {
      return this.requiresUploadDeviceConfig_;
   }

   public boolean hasLatestClientVersionCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getLatestClientVersionCode() {
      return this.latestClientVersionCode_;
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
         output.writeBool(1, this.requiresUploadDeviceConfig_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.latestClientVersionCode_);
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
            size += CodedOutputStream.computeBoolSize(1, this.requiresUploadDeviceConfig_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.latestClientVersionCode_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof SelfUpdateResponse)) {
         return super.equals(obj);
      } else {
         SelfUpdateResponse other = (SelfUpdateResponse)obj;
         if (this.hasRequiresUploadDeviceConfig() != other.hasRequiresUploadDeviceConfig()) {
            return false;
         } else if (this.hasRequiresUploadDeviceConfig() && this.getRequiresUploadDeviceConfig() != other.getRequiresUploadDeviceConfig()) {
            return false;
         } else if (this.hasLatestClientVersionCode() != other.hasLatestClientVersionCode()) {
            return false;
         } else if (this.hasLatestClientVersionCode() && this.getLatestClientVersionCode() != other.getLatestClientVersionCode()) {
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
         if (this.hasRequiresUploadDeviceConfig()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getRequiresUploadDeviceConfig());
         }

         if (this.hasLatestClientVersionCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getLatestClientVersionCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static SelfUpdateResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data);
   }

   public static SelfUpdateResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data);
   }

   public static SelfUpdateResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data);
   }

   public static SelfUpdateResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateResponse parseFrom(InputStream input) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SelfUpdateResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static SelfUpdateResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static SelfUpdateResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static SelfUpdateResponse parseFrom(CodedInputStream input) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SelfUpdateResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public SelfUpdateResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static SelfUpdateResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static SelfUpdateResponse.Builder newBuilder(SelfUpdateResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public SelfUpdateResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new SelfUpdateResponse.Builder() : (new SelfUpdateResponse.Builder()).mergeFrom(this);
   }

   protected SelfUpdateResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      SelfUpdateResponse.Builder builder = new SelfUpdateResponse.Builder(parent);
      return builder;
   }

   public static SelfUpdateResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public SelfUpdateResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   SelfUpdateResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   SelfUpdateResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements SelfUpdateResponseOrBuilder {
      private int bitField0_;
      private boolean requiresUploadDeviceConfig_;
      private int latestClientVersionCode_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_SelfUpdateResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_SelfUpdateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SelfUpdateResponse.class, SelfUpdateResponse.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (SelfUpdateResponse.alwaysUseFieldBuilders) {
         }

      }

      public SelfUpdateResponse.Builder clear() {
         super.clear();
         this.requiresUploadDeviceConfig_ = false;
         this.bitField0_ &= -2;
         this.latestClientVersionCode_ = 0;
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_SelfUpdateResponse_descriptor;
      }

      public SelfUpdateResponse getDefaultInstanceForType() {
         return SelfUpdateResponse.getDefaultInstance();
      }

      public SelfUpdateResponse build() {
         SelfUpdateResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public SelfUpdateResponse buildPartial() {
         SelfUpdateResponse result = new SelfUpdateResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.requiresUploadDeviceConfig_ = this.requiresUploadDeviceConfig_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.latestClientVersionCode_ = this.latestClientVersionCode_;
            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public SelfUpdateResponse.Builder clone() {
         return (SelfUpdateResponse.Builder)super.clone();
      }

      public SelfUpdateResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (SelfUpdateResponse.Builder)super.setField(field, value);
      }

      public SelfUpdateResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (SelfUpdateResponse.Builder)super.clearField(field);
      }

      public SelfUpdateResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (SelfUpdateResponse.Builder)super.clearOneof(oneof);
      }

      public SelfUpdateResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (SelfUpdateResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public SelfUpdateResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (SelfUpdateResponse.Builder)super.addRepeatedField(field, value);
      }

      public SelfUpdateResponse.Builder mergeFrom(Message other) {
         if (other instanceof SelfUpdateResponse) {
            return this.mergeFrom((SelfUpdateResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public SelfUpdateResponse.Builder mergeFrom(SelfUpdateResponse other) {
         if (other == SelfUpdateResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasRequiresUploadDeviceConfig()) {
               this.setRequiresUploadDeviceConfig(other.getRequiresUploadDeviceConfig());
            }

            if (other.hasLatestClientVersionCode()) {
               this.setLatestClientVersionCode(other.getLatestClientVersionCode());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public SelfUpdateResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         SelfUpdateResponse parsedMessage = null;

         try {
            parsedMessage = (SelfUpdateResponse)SelfUpdateResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (SelfUpdateResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasRequiresUploadDeviceConfig() {
         return (this.bitField0_ & 1) != 0;
      }

      public boolean getRequiresUploadDeviceConfig() {
         return this.requiresUploadDeviceConfig_;
      }

      public SelfUpdateResponse.Builder setRequiresUploadDeviceConfig(boolean value) {
         this.bitField0_ |= 1;
         this.requiresUploadDeviceConfig_ = value;
         this.onChanged();
         return this;
      }

      public SelfUpdateResponse.Builder clearRequiresUploadDeviceConfig() {
         this.bitField0_ &= -2;
         this.requiresUploadDeviceConfig_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasLatestClientVersionCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getLatestClientVersionCode() {
         return this.latestClientVersionCode_;
      }

      public SelfUpdateResponse.Builder setLatestClientVersionCode(int value) {
         this.bitField0_ |= 2;
         this.latestClientVersionCode_ = value;
         this.onChanged();
         return this;
      }

      public SelfUpdateResponse.Builder clearLatestClientVersionCode() {
         this.bitField0_ &= -3;
         this.latestClientVersionCode_ = 0;
         this.onChanged();
         return this;
      }

      public final SelfUpdateResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (SelfUpdateResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final SelfUpdateResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (SelfUpdateResponse.Builder)super.mergeUnknownFields(unknownFields);
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
