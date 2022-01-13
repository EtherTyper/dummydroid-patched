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

public final class AppBundleModule extends GeneratedMessageV3 implements AppBundleModuleOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int MODULENAME_FIELD_NUMBER = 1;
   private volatile Object moduleName_;
   public static final int TITLERESOURCEID_FIELD_NUMBER = 2;
   private int titleResourceId_;
   private byte memoizedIsInitialized;
   private static final AppBundleModule DEFAULT_INSTANCE = new AppBundleModule();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AppBundleModule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AppBundleModule(input, extensionRegistry);
      }
   };

   private AppBundleModule(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AppBundleModule() {
      this.memoizedIsInitialized = -1;
      this.moduleName_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AppBundleModule();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AppBundleModule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.moduleName_ = bs;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.titleResourceId_ = input.readInt32();
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
      return Mothership.internal_static_AppBundleModule_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AppBundleModule_fieldAccessorTable.ensureFieldAccessorsInitialized(AppBundleModule.class, AppBundleModule.Builder.class);
   }

   public boolean hasModuleName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getModuleName() {
      Object ref = this.moduleName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.moduleName_ = s;
         }

         return s;
      }
   }

   public ByteString getModuleNameBytes() {
      Object ref = this.moduleName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.moduleName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTitleResourceId() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getTitleResourceId() {
      return this.titleResourceId_;
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
         GeneratedMessageV3.writeString(output, 1, this.moduleName_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.titleResourceId_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.moduleName_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.titleResourceId_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AppBundleModule)) {
         return super.equals(obj);
      } else {
         AppBundleModule other = (AppBundleModule)obj;
         if (this.hasModuleName() != other.hasModuleName()) {
            return false;
         } else if (this.hasModuleName() && !this.getModuleName().equals(other.getModuleName())) {
            return false;
         } else if (this.hasTitleResourceId() != other.hasTitleResourceId()) {
            return false;
         } else if (this.hasTitleResourceId() && this.getTitleResourceId() != other.getTitleResourceId()) {
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
         if (this.hasModuleName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getModuleName().hashCode();
         }

         if (this.hasTitleResourceId()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getTitleResourceId();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AppBundleModule parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data);
   }

   public static AppBundleModule parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppBundleModule parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data);
   }

   public static AppBundleModule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppBundleModule parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data);
   }

   public static AppBundleModule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppBundleModule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppBundleModule parseFrom(InputStream input) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppBundleModule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppBundleModule parseDelimitedFrom(InputStream input) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AppBundleModule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppBundleModule parseFrom(CodedInputStream input) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppBundleModule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppBundleModule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AppBundleModule.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AppBundleModule.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AppBundleModule.Builder newBuilder(AppBundleModule prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AppBundleModule.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AppBundleModule.Builder() : (new AppBundleModule.Builder()).mergeFrom(this);
   }

   protected AppBundleModule.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AppBundleModule.Builder builder = new AppBundleModule.Builder(parent);
      return builder;
   }

   public static AppBundleModule getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AppBundleModule getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AppBundleModule(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AppBundleModule(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AppBundleModuleOrBuilder {
      private int bitField0_;
      private Object moduleName_;
      private int titleResourceId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AppBundleModule_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AppBundleModule_fieldAccessorTable.ensureFieldAccessorsInitialized(AppBundleModule.class, AppBundleModule.Builder.class);
      }

      private Builder() {
         this.moduleName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.moduleName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AppBundleModule.alwaysUseFieldBuilders) {
         }

      }

      public AppBundleModule.Builder clear() {
         super.clear();
         this.moduleName_ = "";
         this.bitField0_ &= -2;
         this.titleResourceId_ = 0;
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AppBundleModule_descriptor;
      }

      public AppBundleModule getDefaultInstanceForType() {
         return AppBundleModule.getDefaultInstance();
      }

      public AppBundleModule build() {
         AppBundleModule result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AppBundleModule buildPartial() {
         AppBundleModule result = new AppBundleModule(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.moduleName_ = this.moduleName_;
         if ((from_bitField0_ & 2) != 0) {
            result.titleResourceId_ = this.titleResourceId_;
            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AppBundleModule.Builder clone() {
         return (AppBundleModule.Builder)super.clone();
      }

      public AppBundleModule.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AppBundleModule.Builder)super.setField(field, value);
      }

      public AppBundleModule.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AppBundleModule.Builder)super.clearField(field);
      }

      public AppBundleModule.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AppBundleModule.Builder)super.clearOneof(oneof);
      }

      public AppBundleModule.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AppBundleModule.Builder)super.setRepeatedField(field, index, value);
      }

      public AppBundleModule.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AppBundleModule.Builder)super.addRepeatedField(field, value);
      }

      public AppBundleModule.Builder mergeFrom(Message other) {
         if (other instanceof AppBundleModule) {
            return this.mergeFrom((AppBundleModule)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AppBundleModule.Builder mergeFrom(AppBundleModule other) {
         if (other == AppBundleModule.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasModuleName()) {
               this.bitField0_ |= 1;
               this.moduleName_ = other.moduleName_;
               this.onChanged();
            }

            if (other.hasTitleResourceId()) {
               this.setTitleResourceId(other.getTitleResourceId());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public AppBundleModule.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AppBundleModule parsedMessage = null;

         try {
            parsedMessage = (AppBundleModule)AppBundleModule.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AppBundleModule)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasModuleName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getModuleName() {
         Object ref = this.moduleName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.moduleName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getModuleNameBytes() {
         Object ref = this.moduleName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.moduleName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppBundleModule.Builder setModuleName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.moduleName_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppBundleModule.Builder clearModuleName() {
         this.bitField0_ &= -2;
         this.moduleName_ = AppBundleModule.getDefaultInstance().getModuleName();
         this.onChanged();
         return this;
      }

      public AppBundleModule.Builder setModuleNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.moduleName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTitleResourceId() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getTitleResourceId() {
         return this.titleResourceId_;
      }

      public AppBundleModule.Builder setTitleResourceId(int value) {
         this.bitField0_ |= 2;
         this.titleResourceId_ = value;
         this.onChanged();
         return this;
      }

      public AppBundleModule.Builder clearTitleResourceId() {
         this.bitField0_ &= -3;
         this.titleResourceId_ = 0;
         this.onChanged();
         return this;
      }

      public final AppBundleModule.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AppBundleModule.Builder)super.setUnknownFields(unknownFields);
      }

      public final AppBundleModule.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AppBundleModule.Builder)super.mergeUnknownFields(unknownFields);
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
