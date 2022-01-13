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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SelfUpdateConfig extends GeneratedMessageV3 implements SelfUpdateConfigOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LATESTCLIENTVERSIONCODE_FIELD_NUMBER = 1;
   private int latestClientVersionCode_;
   private byte memoizedIsInitialized;
   private static final SelfUpdateConfig DEFAULT_INSTANCE = new SelfUpdateConfig();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public SelfUpdateConfig parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new SelfUpdateConfig(input, extensionRegistry);
      }
   };

   private SelfUpdateConfig(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private SelfUpdateConfig() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new SelfUpdateConfig();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private SelfUpdateConfig(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
      return Mothership.internal_static_SelfUpdateConfig_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_SelfUpdateConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(SelfUpdateConfig.class, SelfUpdateConfig.Builder.class);
   }

   public boolean hasLatestClientVersionCode() {
      return (this.bitField0_ & 1) != 0;
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
         output.writeInt32(1, this.latestClientVersionCode_);
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
            size += CodedOutputStream.computeInt32Size(1, this.latestClientVersionCode_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof SelfUpdateConfig)) {
         return super.equals(obj);
      } else {
         SelfUpdateConfig other = (SelfUpdateConfig)obj;
         if (this.hasLatestClientVersionCode() != other.hasLatestClientVersionCode()) {
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
         if (this.hasLatestClientVersionCode()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getLatestClientVersionCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static SelfUpdateConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data);
   }

   public static SelfUpdateConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data);
   }

   public static SelfUpdateConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data);
   }

   public static SelfUpdateConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SelfUpdateConfig)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SelfUpdateConfig parseFrom(InputStream input) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SelfUpdateConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static SelfUpdateConfig parseDelimitedFrom(InputStream input) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static SelfUpdateConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static SelfUpdateConfig parseFrom(CodedInputStream input) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SelfUpdateConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SelfUpdateConfig)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public SelfUpdateConfig.Builder newBuilderForType() {
      return newBuilder();
   }

   public static SelfUpdateConfig.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static SelfUpdateConfig.Builder newBuilder(SelfUpdateConfig prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public SelfUpdateConfig.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new SelfUpdateConfig.Builder() : (new SelfUpdateConfig.Builder()).mergeFrom(this);
   }

   protected SelfUpdateConfig.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      SelfUpdateConfig.Builder builder = new SelfUpdateConfig.Builder(parent);
      return builder;
   }

   public static SelfUpdateConfig getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public SelfUpdateConfig getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   SelfUpdateConfig(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   SelfUpdateConfig(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements SelfUpdateConfigOrBuilder {
      private int bitField0_;
      private int latestClientVersionCode_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_SelfUpdateConfig_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_SelfUpdateConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(SelfUpdateConfig.class, SelfUpdateConfig.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (SelfUpdateConfig.alwaysUseFieldBuilders) {
         }

      }

      public SelfUpdateConfig.Builder clear() {
         super.clear();
         this.latestClientVersionCode_ = 0;
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_SelfUpdateConfig_descriptor;
      }

      public SelfUpdateConfig getDefaultInstanceForType() {
         return SelfUpdateConfig.getDefaultInstance();
      }

      public SelfUpdateConfig build() {
         SelfUpdateConfig result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public SelfUpdateConfig buildPartial() {
         SelfUpdateConfig result = new SelfUpdateConfig(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.latestClientVersionCode_ = this.latestClientVersionCode_;
            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public SelfUpdateConfig.Builder clone() {
         return (SelfUpdateConfig.Builder)super.clone();
      }

      public SelfUpdateConfig.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (SelfUpdateConfig.Builder)super.setField(field, value);
      }

      public SelfUpdateConfig.Builder clearField(Descriptors.FieldDescriptor field) {
         return (SelfUpdateConfig.Builder)super.clearField(field);
      }

      public SelfUpdateConfig.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (SelfUpdateConfig.Builder)super.clearOneof(oneof);
      }

      public SelfUpdateConfig.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (SelfUpdateConfig.Builder)super.setRepeatedField(field, index, value);
      }

      public SelfUpdateConfig.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (SelfUpdateConfig.Builder)super.addRepeatedField(field, value);
      }

      public SelfUpdateConfig.Builder mergeFrom(Message other) {
         if (other instanceof SelfUpdateConfig) {
            return this.mergeFrom((SelfUpdateConfig)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public SelfUpdateConfig.Builder mergeFrom(SelfUpdateConfig other) {
         if (other == SelfUpdateConfig.getDefaultInstance()) {
            return this;
         } else {
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

      public SelfUpdateConfig.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         SelfUpdateConfig parsedMessage = null;

         try {
            parsedMessage = (SelfUpdateConfig)SelfUpdateConfig.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (SelfUpdateConfig)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasLatestClientVersionCode() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getLatestClientVersionCode() {
         return this.latestClientVersionCode_;
      }

      public SelfUpdateConfig.Builder setLatestClientVersionCode(int value) {
         this.bitField0_ |= 1;
         this.latestClientVersionCode_ = value;
         this.onChanged();
         return this;
      }

      public SelfUpdateConfig.Builder clearLatestClientVersionCode() {
         this.bitField0_ &= -2;
         this.latestClientVersionCode_ = 0;
         this.onChanged();
         return this;
      }

      public final SelfUpdateConfig.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (SelfUpdateConfig.Builder)super.setUnknownFields(unknownFields);
      }

      public final SelfUpdateConfig.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (SelfUpdateConfig.Builder)super.mergeUnknownFields(unknownFields);
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
