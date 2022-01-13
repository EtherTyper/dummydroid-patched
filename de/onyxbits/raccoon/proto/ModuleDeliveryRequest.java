package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ModuleDeliveryRequest extends GeneratedMessageV3 implements ModuleDeliveryRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PACKAGENAME_FIELD_NUMBER = 1;
   private volatile Object packageName_;
   public static final int VERSIONCODE_FIELD_NUMBER = 2;
   private int versionCode_;
   public static final int APPMODULE_FIELD_NUMBER = 3;
   private List appModule_;
   public static final int PATCHFORMAT_FIELD_NUMBER = 4;
   private Internal.IntList patchFormat_;
   public static final int COMPRESSIONFORMAT_FIELD_NUMBER = 5;
   private List compressionFormat_;
   private static final Internal.ListAdapter.Converter compressionFormat_converter_ = new Internal.ListAdapter.Converter() {
      public ModuleDeliveryRequest.CompressionFormat convert(Integer from) {
         ModuleDeliveryRequest.CompressionFormat result = ModuleDeliveryRequest.CompressionFormat.valueOf(from);
         return result == null ? ModuleDeliveryRequest.CompressionFormat.UNSPECIFIED : result;
      }
   };
   private byte memoizedIsInitialized;
   private static final ModuleDeliveryRequest DEFAULT_INSTANCE = new ModuleDeliveryRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ModuleDeliveryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ModuleDeliveryRequest(input, extensionRegistry);
      }
   };

   private ModuleDeliveryRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ModuleDeliveryRequest() {
      this.memoizedIsInitialized = -1;
      this.packageName_ = "";
      this.appModule_ = Collections.emptyList();
      this.patchFormat_ = emptyIntList();
      this.compressionFormat_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ModuleDeliveryRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ModuleDeliveryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = 0;
         UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();

         try {
            boolean done = false;

            while(!done) {
               int tag = input.readTag();
               int rawValue;
               int limit;
               switch(tag) {
               case 0:
                  done = true;
                  continue;
               case 10:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.packageName_ = bs;
                  continue;
               case 16:
                  this.bitField0_ |= 2;
                  this.versionCode_ = input.readInt32();
                  continue;
               case 26:
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.appModule_ = new ArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.appModule_.add(input.readMessage(AppModule.PARSER, extensionRegistry));
                  continue;
               case 32:
                  if ((mutable_bitField0_ & 8) == 0) {
                     this.patchFormat_ = newIntList();
                     mutable_bitField0_ |= 8;
                  }

                  this.patchFormat_.addInt(input.readInt32());
                  continue;
               case 34:
                  rawValue = input.readRawVarint32();
                  limit = input.pushLimit(rawValue);
                  if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                     this.patchFormat_ = newIntList();
                     mutable_bitField0_ |= 8;
                  }
                  break;
               case 40:
                  rawValue = input.readEnum();
                  ModuleDeliveryRequest.CompressionFormat value = ModuleDeliveryRequest.CompressionFormat.valueOf(rawValue);
                  if (value == null) {
                     unknownFields.mergeVarintField(5, rawValue);
                  } else {
                     if ((mutable_bitField0_ & 16) == 0) {
                        this.compressionFormat_ = new ArrayList();
                        mutable_bitField0_ |= 16;
                     }

                     this.compressionFormat_.add(rawValue);
                  }
                  continue;
               case 42:
                  rawValue = input.readRawVarint32();
                  limit = input.pushLimit(rawValue);

                  while(input.getBytesUntilLimit() > 0) {
                     int rawValue = input.readEnum();
                     ModuleDeliveryRequest.CompressionFormat value = ModuleDeliveryRequest.CompressionFormat.valueOf(rawValue);
                     if (value == null) {
                        unknownFields.mergeVarintField(5, rawValue);
                     } else {
                        if ((mutable_bitField0_ & 16) == 0) {
                           this.compressionFormat_ = new ArrayList();
                           mutable_bitField0_ |= 16;
                        }

                        this.compressionFormat_.add(rawValue);
                     }
                  }

                  input.popLimit(limit);
                  continue;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
                  continue;
               }

               while(input.getBytesUntilLimit() > 0) {
                  this.patchFormat_.addInt(input.readInt32());
               }

               input.popLimit(limit);
            }
         } catch (InvalidProtocolBufferException var15) {
            throw var15.setUnfinishedMessage(this);
         } catch (IOException var16) {
            throw (new InvalidProtocolBufferException(var16)).setUnfinishedMessage(this);
         } finally {
            if ((mutable_bitField0_ & 4) != 0) {
               this.appModule_ = Collections.unmodifiableList(this.appModule_);
            }

            if ((mutable_bitField0_ & 8) != 0) {
               this.patchFormat_.makeImmutable();
            }

            if ((mutable_bitField0_ & 16) != 0) {
               this.compressionFormat_ = Collections.unmodifiableList(this.compressionFormat_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_ModuleDeliveryRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ModuleDeliveryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ModuleDeliveryRequest.class, ModuleDeliveryRequest.Builder.class);
   }

   public boolean hasPackageName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getPackageName() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.packageName_ = s;
         }

         return s;
      }
   }

   public ByteString getPackageNameBytes() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.packageName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getVersionCode() {
      return this.versionCode_;
   }

   public List getAppModuleList() {
      return this.appModule_;
   }

   public List getAppModuleOrBuilderList() {
      return this.appModule_;
   }

   public int getAppModuleCount() {
      return this.appModule_.size();
   }

   public AppModule getAppModule(int index) {
      return (AppModule)this.appModule_.get(index);
   }

   public AppModuleOrBuilder getAppModuleOrBuilder(int index) {
      return (AppModuleOrBuilder)this.appModule_.get(index);
   }

   public List getPatchFormatList() {
      return this.patchFormat_;
   }

   public int getPatchFormatCount() {
      return this.patchFormat_.size();
   }

   public int getPatchFormat(int index) {
      return this.patchFormat_.getInt(index);
   }

   public List getCompressionFormatList() {
      return new Internal.ListAdapter(this.compressionFormat_, compressionFormat_converter_);
   }

   public int getCompressionFormatCount() {
      return this.compressionFormat_.size();
   }

   public ModuleDeliveryRequest.CompressionFormat getCompressionFormat(int index) {
      return (ModuleDeliveryRequest.CompressionFormat)compressionFormat_converter_.convert(this.compressionFormat_.get(index));
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
         GeneratedMessageV3.writeString(output, 1, this.packageName_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.versionCode_);
      }

      int i;
      for(i = 0; i < this.appModule_.size(); ++i) {
         output.writeMessage(3, (MessageLite)this.appModule_.get(i));
      }

      for(i = 0; i < this.patchFormat_.size(); ++i) {
         output.writeInt32(4, this.patchFormat_.getInt(i));
      }

      for(i = 0; i < this.compressionFormat_.size(); ++i) {
         output.writeEnum(5, (Integer)this.compressionFormat_.get(i));
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
            size += GeneratedMessageV3.computeStringSize(1, this.packageName_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.versionCode_);
         }

         int dataSize;
         for(dataSize = 0; dataSize < this.appModule_.size(); ++dataSize) {
            size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.appModule_.get(dataSize));
         }

         dataSize = 0;

         int i;
         for(i = 0; i < this.patchFormat_.size(); ++i) {
            dataSize += CodedOutputStream.computeInt32SizeNoTag(this.patchFormat_.getInt(i));
         }

         size += dataSize;
         size += 1 * this.getPatchFormatList().size();
         dataSize = 0;

         for(i = 0; i < this.compressionFormat_.size(); ++i) {
            dataSize += CodedOutputStream.computeEnumSizeNoTag((Integer)this.compressionFormat_.get(i));
         }

         size += dataSize;
         size += 1 * this.compressionFormat_.size();
         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ModuleDeliveryRequest)) {
         return super.equals(obj);
      } else {
         ModuleDeliveryRequest other = (ModuleDeliveryRequest)obj;
         if (this.hasPackageName() != other.hasPackageName()) {
            return false;
         } else if (this.hasPackageName() && !this.getPackageName().equals(other.getPackageName())) {
            return false;
         } else if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && this.getVersionCode() != other.getVersionCode()) {
            return false;
         } else if (!this.getAppModuleList().equals(other.getAppModuleList())) {
            return false;
         } else if (!this.getPatchFormatList().equals(other.getPatchFormatList())) {
            return false;
         } else if (!this.compressionFormat_.equals(other.compressionFormat_)) {
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
         if (this.hasPackageName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPackageName().hashCode();
         }

         if (this.hasVersionCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getVersionCode();
         }

         if (this.getAppModuleCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getAppModuleList().hashCode();
         }

         if (this.getPatchFormatCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getPatchFormatList().hashCode();
         }

         if (this.getCompressionFormatCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.compressionFormat_.hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ModuleDeliveryRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data);
   }

   public static ModuleDeliveryRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModuleDeliveryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data);
   }

   public static ModuleDeliveryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModuleDeliveryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data);
   }

   public static ModuleDeliveryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModuleDeliveryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModuleDeliveryRequest parseFrom(InputStream input) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModuleDeliveryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModuleDeliveryRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ModuleDeliveryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModuleDeliveryRequest parseFrom(CodedInputStream input) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModuleDeliveryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModuleDeliveryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ModuleDeliveryRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ModuleDeliveryRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ModuleDeliveryRequest.Builder newBuilder(ModuleDeliveryRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ModuleDeliveryRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ModuleDeliveryRequest.Builder() : (new ModuleDeliveryRequest.Builder()).mergeFrom(this);
   }

   protected ModuleDeliveryRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ModuleDeliveryRequest.Builder builder = new ModuleDeliveryRequest.Builder(parent);
      return builder;
   }

   public static ModuleDeliveryRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ModuleDeliveryRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ModuleDeliveryRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ModuleDeliveryRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ModuleDeliveryRequestOrBuilder {
      private int bitField0_;
      private Object packageName_;
      private int versionCode_;
      private List appModule_;
      private RepeatedFieldBuilderV3 appModuleBuilder_;
      private Internal.IntList patchFormat_;
      private List compressionFormat_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ModuleDeliveryRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ModuleDeliveryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ModuleDeliveryRequest.class, ModuleDeliveryRequest.Builder.class);
      }

      private Builder() {
         this.packageName_ = "";
         this.appModule_ = Collections.emptyList();
         this.patchFormat_ = ModuleDeliveryRequest.emptyIntList();
         this.compressionFormat_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.packageName_ = "";
         this.appModule_ = Collections.emptyList();
         this.patchFormat_ = ModuleDeliveryRequest.emptyIntList();
         this.compressionFormat_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ModuleDeliveryRequest.alwaysUseFieldBuilders) {
            this.getAppModuleFieldBuilder();
         }

      }

      public ModuleDeliveryRequest.Builder clear() {
         super.clear();
         this.packageName_ = "";
         this.bitField0_ &= -2;
         this.versionCode_ = 0;
         this.bitField0_ &= -3;
         if (this.appModuleBuilder_ == null) {
            this.appModule_ = Collections.emptyList();
            this.bitField0_ &= -5;
         } else {
            this.appModuleBuilder_.clear();
         }

         this.patchFormat_ = ModuleDeliveryRequest.emptyIntList();
         this.bitField0_ &= -9;
         this.compressionFormat_ = Collections.emptyList();
         this.bitField0_ &= -17;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ModuleDeliveryRequest_descriptor;
      }

      public ModuleDeliveryRequest getDefaultInstanceForType() {
         return ModuleDeliveryRequest.getDefaultInstance();
      }

      public ModuleDeliveryRequest build() {
         ModuleDeliveryRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ModuleDeliveryRequest buildPartial() {
         ModuleDeliveryRequest result = new ModuleDeliveryRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.packageName_ = this.packageName_;
         if ((from_bitField0_ & 2) != 0) {
            result.versionCode_ = this.versionCode_;
            to_bitField0_ |= 2;
         }

         if (this.appModuleBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0) {
               this.appModule_ = Collections.unmodifiableList(this.appModule_);
               this.bitField0_ &= -5;
            }

            result.appModule_ = this.appModule_;
         } else {
            result.appModule_ = this.appModuleBuilder_.build();
         }

         if ((this.bitField0_ & 8) != 0) {
            this.patchFormat_.makeImmutable();
            this.bitField0_ &= -9;
         }

         result.patchFormat_ = this.patchFormat_;
         if ((this.bitField0_ & 16) != 0) {
            this.compressionFormat_ = Collections.unmodifiableList(this.compressionFormat_);
            this.bitField0_ &= -17;
         }

         result.compressionFormat_ = this.compressionFormat_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ModuleDeliveryRequest.Builder clone() {
         return (ModuleDeliveryRequest.Builder)super.clone();
      }

      public ModuleDeliveryRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ModuleDeliveryRequest.Builder)super.setField(field, value);
      }

      public ModuleDeliveryRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ModuleDeliveryRequest.Builder)super.clearField(field);
      }

      public ModuleDeliveryRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ModuleDeliveryRequest.Builder)super.clearOneof(oneof);
      }

      public ModuleDeliveryRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ModuleDeliveryRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public ModuleDeliveryRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ModuleDeliveryRequest.Builder)super.addRepeatedField(field, value);
      }

      public ModuleDeliveryRequest.Builder mergeFrom(Message other) {
         if (other instanceof ModuleDeliveryRequest) {
            return this.mergeFrom((ModuleDeliveryRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ModuleDeliveryRequest.Builder mergeFrom(ModuleDeliveryRequest other) {
         if (other == ModuleDeliveryRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPackageName()) {
               this.bitField0_ |= 1;
               this.packageName_ = other.packageName_;
               this.onChanged();
            }

            if (other.hasVersionCode()) {
               this.setVersionCode(other.getVersionCode());
            }

            if (this.appModuleBuilder_ == null) {
               if (!other.appModule_.isEmpty()) {
                  if (this.appModule_.isEmpty()) {
                     this.appModule_ = other.appModule_;
                     this.bitField0_ &= -5;
                  } else {
                     this.ensureAppModuleIsMutable();
                     this.appModule_.addAll(other.appModule_);
                  }

                  this.onChanged();
               }
            } else if (!other.appModule_.isEmpty()) {
               if (this.appModuleBuilder_.isEmpty()) {
                  this.appModuleBuilder_.dispose();
                  this.appModuleBuilder_ = null;
                  this.appModule_ = other.appModule_;
                  this.bitField0_ &= -5;
                  this.appModuleBuilder_ = ModuleDeliveryRequest.alwaysUseFieldBuilders ? this.getAppModuleFieldBuilder() : null;
               } else {
                  this.appModuleBuilder_.addAllMessages(other.appModule_);
               }
            }

            if (!other.patchFormat_.isEmpty()) {
               if (this.patchFormat_.isEmpty()) {
                  this.patchFormat_ = other.patchFormat_;
                  this.bitField0_ &= -9;
               } else {
                  this.ensurePatchFormatIsMutable();
                  this.patchFormat_.addAll(other.patchFormat_);
               }

               this.onChanged();
            }

            if (!other.compressionFormat_.isEmpty()) {
               if (this.compressionFormat_.isEmpty()) {
                  this.compressionFormat_ = other.compressionFormat_;
                  this.bitField0_ &= -17;
               } else {
                  this.ensureCompressionFormatIsMutable();
                  this.compressionFormat_.addAll(other.compressionFormat_);
               }

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

      public ModuleDeliveryRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ModuleDeliveryRequest parsedMessage = null;

         try {
            parsedMessage = (ModuleDeliveryRequest)ModuleDeliveryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ModuleDeliveryRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasPackageName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getPackageName() {
         Object ref = this.packageName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.packageName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getPackageNameBytes() {
         Object ref = this.packageName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.packageName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ModuleDeliveryRequest.Builder setPackageName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public ModuleDeliveryRequest.Builder clearPackageName() {
         this.bitField0_ &= -2;
         this.packageName_ = ModuleDeliveryRequest.getDefaultInstance().getPackageName();
         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder setPackageNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getVersionCode() {
         return this.versionCode_;
      }

      public ModuleDeliveryRequest.Builder setVersionCode(int value) {
         this.bitField0_ |= 2;
         this.versionCode_ = value;
         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder clearVersionCode() {
         this.bitField0_ &= -3;
         this.versionCode_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureAppModuleIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.appModule_ = new ArrayList(this.appModule_);
            this.bitField0_ |= 4;
         }

      }

      public List getAppModuleList() {
         return this.appModuleBuilder_ == null ? Collections.unmodifiableList(this.appModule_) : this.appModuleBuilder_.getMessageList();
      }

      public int getAppModuleCount() {
         return this.appModuleBuilder_ == null ? this.appModule_.size() : this.appModuleBuilder_.getCount();
      }

      public AppModule getAppModule(int index) {
         return this.appModuleBuilder_ == null ? (AppModule)this.appModule_.get(index) : (AppModule)this.appModuleBuilder_.getMessage(index);
      }

      public ModuleDeliveryRequest.Builder setAppModule(int index, AppModule value) {
         if (this.appModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAppModuleIsMutable();
            this.appModule_.set(index, value);
            this.onChanged();
         } else {
            this.appModuleBuilder_.setMessage(index, value);
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder setAppModule(int index, AppModule.Builder builderForValue) {
         if (this.appModuleBuilder_ == null) {
            this.ensureAppModuleIsMutable();
            this.appModule_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.appModuleBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder addAppModule(AppModule value) {
         if (this.appModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAppModuleIsMutable();
            this.appModule_.add(value);
            this.onChanged();
         } else {
            this.appModuleBuilder_.addMessage(value);
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder addAppModule(int index, AppModule value) {
         if (this.appModuleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAppModuleIsMutable();
            this.appModule_.add(index, value);
            this.onChanged();
         } else {
            this.appModuleBuilder_.addMessage(index, value);
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder addAppModule(AppModule.Builder builderForValue) {
         if (this.appModuleBuilder_ == null) {
            this.ensureAppModuleIsMutable();
            this.appModule_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.appModuleBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder addAppModule(int index, AppModule.Builder builderForValue) {
         if (this.appModuleBuilder_ == null) {
            this.ensureAppModuleIsMutable();
            this.appModule_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.appModuleBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder addAllAppModule(Iterable values) {
         if (this.appModuleBuilder_ == null) {
            this.ensureAppModuleIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.appModule_);
            this.onChanged();
         } else {
            this.appModuleBuilder_.addAllMessages(values);
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder clearAppModule() {
         if (this.appModuleBuilder_ == null) {
            this.appModule_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
         } else {
            this.appModuleBuilder_.clear();
         }

         return this;
      }

      public ModuleDeliveryRequest.Builder removeAppModule(int index) {
         if (this.appModuleBuilder_ == null) {
            this.ensureAppModuleIsMutable();
            this.appModule_.remove(index);
            this.onChanged();
         } else {
            this.appModuleBuilder_.remove(index);
         }

         return this;
      }

      public AppModule.Builder getAppModuleBuilder(int index) {
         return (AppModule.Builder)this.getAppModuleFieldBuilder().getBuilder(index);
      }

      public AppModuleOrBuilder getAppModuleOrBuilder(int index) {
         return this.appModuleBuilder_ == null ? (AppModuleOrBuilder)this.appModule_.get(index) : (AppModuleOrBuilder)this.appModuleBuilder_.getMessageOrBuilder(index);
      }

      public List getAppModuleOrBuilderList() {
         return this.appModuleBuilder_ != null ? this.appModuleBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.appModule_);
      }

      public AppModule.Builder addAppModuleBuilder() {
         return (AppModule.Builder)this.getAppModuleFieldBuilder().addBuilder(AppModule.getDefaultInstance());
      }

      public AppModule.Builder addAppModuleBuilder(int index) {
         return (AppModule.Builder)this.getAppModuleFieldBuilder().addBuilder(index, AppModule.getDefaultInstance());
      }

      public List getAppModuleBuilderList() {
         return this.getAppModuleFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getAppModuleFieldBuilder() {
         if (this.appModuleBuilder_ == null) {
            this.appModuleBuilder_ = new RepeatedFieldBuilderV3(this.appModule_, (this.bitField0_ & 4) != 0, this.getParentForChildren(), this.isClean());
            this.appModule_ = null;
         }

         return this.appModuleBuilder_;
      }

      private void ensurePatchFormatIsMutable() {
         if ((this.bitField0_ & 8) == 0) {
            this.patchFormat_ = ModuleDeliveryRequest.mutableCopy(this.patchFormat_);
            this.bitField0_ |= 8;
         }

      }

      public List getPatchFormatList() {
         return (List)((this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.patchFormat_) : this.patchFormat_);
      }

      public int getPatchFormatCount() {
         return this.patchFormat_.size();
      }

      public int getPatchFormat(int index) {
         return this.patchFormat_.getInt(index);
      }

      public ModuleDeliveryRequest.Builder setPatchFormat(int index, int value) {
         this.ensurePatchFormatIsMutable();
         this.patchFormat_.setInt(index, value);
         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder addPatchFormat(int value) {
         this.ensurePatchFormatIsMutable();
         this.patchFormat_.addInt(value);
         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder addAllPatchFormat(Iterable values) {
         this.ensurePatchFormatIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.patchFormat_);
         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder clearPatchFormat() {
         this.patchFormat_ = ModuleDeliveryRequest.emptyIntList();
         this.bitField0_ &= -9;
         this.onChanged();
         return this;
      }

      private void ensureCompressionFormatIsMutable() {
         if ((this.bitField0_ & 16) == 0) {
            this.compressionFormat_ = new ArrayList(this.compressionFormat_);
            this.bitField0_ |= 16;
         }

      }

      public List getCompressionFormatList() {
         return new Internal.ListAdapter(this.compressionFormat_, ModuleDeliveryRequest.compressionFormat_converter_);
      }

      public int getCompressionFormatCount() {
         return this.compressionFormat_.size();
      }

      public ModuleDeliveryRequest.CompressionFormat getCompressionFormat(int index) {
         return (ModuleDeliveryRequest.CompressionFormat)ModuleDeliveryRequest.compressionFormat_converter_.convert(this.compressionFormat_.get(index));
      }

      public ModuleDeliveryRequest.Builder setCompressionFormat(int index, ModuleDeliveryRequest.CompressionFormat value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureCompressionFormatIsMutable();
            this.compressionFormat_.set(index, value.getNumber());
            this.onChanged();
            return this;
         }
      }

      public ModuleDeliveryRequest.Builder addCompressionFormat(ModuleDeliveryRequest.CompressionFormat value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureCompressionFormatIsMutable();
            this.compressionFormat_.add(value.getNumber());
            this.onChanged();
            return this;
         }
      }

      public ModuleDeliveryRequest.Builder addAllCompressionFormat(Iterable values) {
         this.ensureCompressionFormatIsMutable();
         Iterator var2 = values.iterator();

         while(var2.hasNext()) {
            ModuleDeliveryRequest.CompressionFormat value = (ModuleDeliveryRequest.CompressionFormat)var2.next();
            this.compressionFormat_.add(value.getNumber());
         }

         this.onChanged();
         return this;
      }

      public ModuleDeliveryRequest.Builder clearCompressionFormat() {
         this.compressionFormat_ = Collections.emptyList();
         this.bitField0_ &= -17;
         this.onChanged();
         return this;
      }

      public final ModuleDeliveryRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ModuleDeliveryRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final ModuleDeliveryRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ModuleDeliveryRequest.Builder)super.mergeUnknownFields(unknownFields);
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

   public static enum CompressionFormat implements ProtocolMessageEnum {
      UNSPECIFIED(0),
      BROTLI(1),
      GZIP(2);

      public static final int UNSPECIFIED_VALUE = 0;
      public static final int BROTLI_VALUE = 1;
      public static final int GZIP_VALUE = 2;
      private static final Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {
         public ModuleDeliveryRequest.CompressionFormat findValueByNumber(int number) {
            return ModuleDeliveryRequest.CompressionFormat.forNumber(number);
         }
      };
      private static final ModuleDeliveryRequest.CompressionFormat[] VALUES = values();
      private final int value;

      public final int getNumber() {
         return this.value;
      }

      /** @deprecated */
      @Deprecated
      public static ModuleDeliveryRequest.CompressionFormat valueOf(int value) {
         return forNumber(value);
      }

      public static ModuleDeliveryRequest.CompressionFormat forNumber(int value) {
         switch(value) {
         case 0:
            return UNSPECIFIED;
         case 1:
            return BROTLI;
         case 2:
            return GZIP;
         default:
            return null;
         }
      }

      public static Internal.EnumLiteMap internalGetValueMap() {
         return internalValueMap;
      }

      public final Descriptors.EnumValueDescriptor getValueDescriptor() {
         return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.ordinal());
      }

      public final Descriptors.EnumDescriptor getDescriptorForType() {
         return getDescriptor();
      }

      public static final Descriptors.EnumDescriptor getDescriptor() {
         return (Descriptors.EnumDescriptor)ModuleDeliveryRequest.getDescriptor().getEnumTypes().get(0);
      }

      public static ModuleDeliveryRequest.CompressionFormat valueOf(Descriptors.EnumValueDescriptor desc) {
         if (desc.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
         } else {
            return VALUES[desc.getIndex()];
         }
      }

      private CompressionFormat(int value) {
         this.value = value;
      }
   }
}
