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

public final class AppModule extends GeneratedMessageV3 implements AppModuleOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int SPLITID_FIELD_NUMBER = 1;
   private volatile Object splitId_;
   public static final int VERSIONCODE_FIELD_NUMBER = 2;
   private volatile Object versionCode_;
   public static final int EXISTINGVERSIONCODE_FIELD_NUMBER = 3;
   private volatile Object existingVersionCode_;
   private byte memoizedIsInitialized;
   private static final AppModule DEFAULT_INSTANCE = new AppModule();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AppModule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AppModule(input, extensionRegistry);
      }
   };

   private AppModule(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AppModule() {
      this.memoizedIsInitialized = -1;
      this.splitId_ = "";
      this.versionCode_ = "";
      this.existingVersionCode_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AppModule();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AppModule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.splitId_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.versionCode_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.existingVersionCode_ = bs;
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
      return Mothership.internal_static_AppModule_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AppModule_fieldAccessorTable.ensureFieldAccessorsInitialized(AppModule.class, AppModule.Builder.class);
   }

   public boolean hasSplitId() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getSplitId() {
      Object ref = this.splitId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.splitId_ = s;
         }

         return s;
      }
   }

   public ByteString getSplitIdBytes() {
      Object ref = this.splitId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.splitId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getVersionCode() {
      Object ref = this.versionCode_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.versionCode_ = s;
         }

         return s;
      }
   }

   public ByteString getVersionCodeBytes() {
      Object ref = this.versionCode_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.versionCode_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasExistingVersionCode() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getExistingVersionCode() {
      Object ref = this.existingVersionCode_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.existingVersionCode_ = s;
         }

         return s;
      }
   }

   public ByteString getExistingVersionCodeBytes() {
      Object ref = this.existingVersionCode_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.existingVersionCode_ = b;
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
         GeneratedMessageV3.writeString(output, 1, this.splitId_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.versionCode_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.existingVersionCode_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.splitId_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.versionCode_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.existingVersionCode_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AppModule)) {
         return super.equals(obj);
      } else {
         AppModule other = (AppModule)obj;
         if (this.hasSplitId() != other.hasSplitId()) {
            return false;
         } else if (this.hasSplitId() && !this.getSplitId().equals(other.getSplitId())) {
            return false;
         } else if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && !this.getVersionCode().equals(other.getVersionCode())) {
            return false;
         } else if (this.hasExistingVersionCode() != other.hasExistingVersionCode()) {
            return false;
         } else if (this.hasExistingVersionCode() && !this.getExistingVersionCode().equals(other.getExistingVersionCode())) {
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
         if (this.hasSplitId()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getSplitId().hashCode();
         }

         if (this.hasVersionCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getVersionCode().hashCode();
         }

         if (this.hasExistingVersionCode()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getExistingVersionCode().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AppModule parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data);
   }

   public static AppModule parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppModule parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data);
   }

   public static AppModule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppModule parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data);
   }

   public static AppModule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppModule parseFrom(InputStream input) throws IOException {
      return (AppModule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppModule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppModule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppModule parseDelimitedFrom(InputStream input) throws IOException {
      return (AppModule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AppModule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppModule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppModule parseFrom(CodedInputStream input) throws IOException {
      return (AppModule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppModule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppModule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AppModule.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AppModule.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AppModule.Builder newBuilder(AppModule prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AppModule.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AppModule.Builder() : (new AppModule.Builder()).mergeFrom(this);
   }

   protected AppModule.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AppModule.Builder builder = new AppModule.Builder(parent);
      return builder;
   }

   public static AppModule getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AppModule getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AppModule(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AppModule(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AppModuleOrBuilder {
      private int bitField0_;
      private Object splitId_;
      private Object versionCode_;
      private Object existingVersionCode_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AppModule_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AppModule_fieldAccessorTable.ensureFieldAccessorsInitialized(AppModule.class, AppModule.Builder.class);
      }

      private Builder() {
         this.splitId_ = "";
         this.versionCode_ = "";
         this.existingVersionCode_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.splitId_ = "";
         this.versionCode_ = "";
         this.existingVersionCode_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AppModule.alwaysUseFieldBuilders) {
         }

      }

      public AppModule.Builder clear() {
         super.clear();
         this.splitId_ = "";
         this.bitField0_ &= -2;
         this.versionCode_ = "";
         this.bitField0_ &= -3;
         this.existingVersionCode_ = "";
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AppModule_descriptor;
      }

      public AppModule getDefaultInstanceForType() {
         return AppModule.getDefaultInstance();
      }

      public AppModule build() {
         AppModule result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AppModule buildPartial() {
         AppModule result = new AppModule(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.splitId_ = this.splitId_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.versionCode_ = this.versionCode_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.existingVersionCode_ = this.existingVersionCode_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AppModule.Builder clone() {
         return (AppModule.Builder)super.clone();
      }

      public AppModule.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AppModule.Builder)super.setField(field, value);
      }

      public AppModule.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AppModule.Builder)super.clearField(field);
      }

      public AppModule.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AppModule.Builder)super.clearOneof(oneof);
      }

      public AppModule.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AppModule.Builder)super.setRepeatedField(field, index, value);
      }

      public AppModule.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AppModule.Builder)super.addRepeatedField(field, value);
      }

      public AppModule.Builder mergeFrom(Message other) {
         if (other instanceof AppModule) {
            return this.mergeFrom((AppModule)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AppModule.Builder mergeFrom(AppModule other) {
         if (other == AppModule.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasSplitId()) {
               this.bitField0_ |= 1;
               this.splitId_ = other.splitId_;
               this.onChanged();
            }

            if (other.hasVersionCode()) {
               this.bitField0_ |= 2;
               this.versionCode_ = other.versionCode_;
               this.onChanged();
            }

            if (other.hasExistingVersionCode()) {
               this.bitField0_ |= 4;
               this.existingVersionCode_ = other.existingVersionCode_;
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

      public AppModule.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AppModule parsedMessage = null;

         try {
            parsedMessage = (AppModule)AppModule.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AppModule)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasSplitId() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getSplitId() {
         Object ref = this.splitId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.splitId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSplitIdBytes() {
         Object ref = this.splitId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.splitId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppModule.Builder setSplitId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.splitId_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppModule.Builder clearSplitId() {
         this.bitField0_ &= -2;
         this.splitId_ = AppModule.getDefaultInstance().getSplitId();
         this.onChanged();
         return this;
      }

      public AppModule.Builder setSplitIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.splitId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getVersionCode() {
         Object ref = this.versionCode_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.versionCode_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getVersionCodeBytes() {
         Object ref = this.versionCode_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.versionCode_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppModule.Builder setVersionCode(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.versionCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppModule.Builder clearVersionCode() {
         this.bitField0_ &= -3;
         this.versionCode_ = AppModule.getDefaultInstance().getVersionCode();
         this.onChanged();
         return this;
      }

      public AppModule.Builder setVersionCodeBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.versionCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasExistingVersionCode() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getExistingVersionCode() {
         Object ref = this.existingVersionCode_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.existingVersionCode_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getExistingVersionCodeBytes() {
         Object ref = this.existingVersionCode_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.existingVersionCode_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppModule.Builder setExistingVersionCode(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.existingVersionCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppModule.Builder clearExistingVersionCode() {
         this.bitField0_ &= -5;
         this.existingVersionCode_ = AppModule.getDefaultInstance().getExistingVersionCode();
         this.onChanged();
         return this;
      }

      public AppModule.Builder setExistingVersionCodeBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.existingVersionCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AppModule.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AppModule.Builder)super.setUnknownFields(unknownFields);
      }

      public final AppModule.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AppModule.Builder)super.mergeUnknownFields(unknownFields);
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
