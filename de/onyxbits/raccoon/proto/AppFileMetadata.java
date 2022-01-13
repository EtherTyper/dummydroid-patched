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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AppFileMetadata extends GeneratedMessageV3 implements AppFileMetadataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int FILETYPE_FIELD_NUMBER = 1;
   private int fileType_;
   public static final int VERSIONCODE_FIELD_NUMBER = 2;
   private int versionCode_;
   public static final int SIZE_FIELD_NUMBER = 3;
   private long size_;
   public static final int DOWNLOADURL_FIELD_NUMBER = 4;
   private volatile Object downloadUrl_;
   public static final int ANDROIDAPPPATCHDATA_FIELD_NUMBER = 5;
   private AndroidAppPatchData androidAppPatchData_;
   public static final int COMPRESSEDSIZE_FIELD_NUMBER = 6;
   private long compressedSize_;
   public static final int COMPRESSEDDOWNLOADURL_FIELD_NUMBER = 7;
   private volatile Object compressedDownloadUrl_;
   private byte memoizedIsInitialized;
   private static final AppFileMetadata DEFAULT_INSTANCE = new AppFileMetadata();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AppFileMetadata parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AppFileMetadata(input, extensionRegistry);
      }
   };

   private AppFileMetadata(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AppFileMetadata() {
      this.memoizedIsInitialized = -1;
      this.downloadUrl_ = "";
      this.compressedDownloadUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AppFileMetadata();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AppFileMetadata(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.fileType_ = input.readInt32();
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.versionCode_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.size_ = input.readInt64();
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.downloadUrl_ = bs;
                  break;
               case 42:
                  AndroidAppPatchData.Builder subBuilder = null;
                  if ((this.bitField0_ & 16) != 0) {
                     subBuilder = this.androidAppPatchData_.toBuilder();
                  }

                  this.androidAppPatchData_ = (AndroidAppPatchData)input.readMessage(AndroidAppPatchData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.androidAppPatchData_);
                     this.androidAppPatchData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 16;
                  break;
               case 48:
                  this.bitField0_ |= 32;
                  this.compressedSize_ = input.readInt64();
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.compressedDownloadUrl_ = bs;
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
      return Mothership.internal_static_AppFileMetadata_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AppFileMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(AppFileMetadata.class, AppFileMetadata.Builder.class);
   }

   public boolean hasFileType() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getFileType() {
      return this.fileType_;
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getVersionCode() {
      return this.versionCode_;
   }

   public boolean hasSize() {
      return (this.bitField0_ & 4) != 0;
   }

   public long getSize() {
      return this.size_;
   }

   public boolean hasDownloadUrl() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDownloadUrl() {
      Object ref = this.downloadUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.downloadUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getDownloadUrlBytes() {
      Object ref = this.downloadUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.downloadUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasAndroidAppPatchData() {
      return (this.bitField0_ & 16) != 0;
   }

   public AndroidAppPatchData getAndroidAppPatchData() {
      return this.androidAppPatchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.androidAppPatchData_;
   }

   public AndroidAppPatchDataOrBuilder getAndroidAppPatchDataOrBuilder() {
      return this.androidAppPatchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.androidAppPatchData_;
   }

   public boolean hasCompressedSize() {
      return (this.bitField0_ & 32) != 0;
   }

   public long getCompressedSize() {
      return this.compressedSize_;
   }

   public boolean hasCompressedDownloadUrl() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getCompressedDownloadUrl() {
      Object ref = this.compressedDownloadUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.compressedDownloadUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getCompressedDownloadUrlBytes() {
      Object ref = this.compressedDownloadUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.compressedDownloadUrl_ = b;
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
         output.writeInt32(1, this.fileType_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.versionCode_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt64(3, this.size_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.downloadUrl_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeMessage(5, this.getAndroidAppPatchData());
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeInt64(6, this.compressedSize_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.compressedDownloadUrl_);
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
            size += CodedOutputStream.computeInt32Size(1, this.fileType_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.versionCode_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt64Size(3, this.size_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.downloadUrl_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeMessageSize(5, this.getAndroidAppPatchData());
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeInt64Size(6, this.compressedSize_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.compressedDownloadUrl_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AppFileMetadata)) {
         return super.equals(obj);
      } else {
         AppFileMetadata other = (AppFileMetadata)obj;
         if (this.hasFileType() != other.hasFileType()) {
            return false;
         } else if (this.hasFileType() && this.getFileType() != other.getFileType()) {
            return false;
         } else if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && this.getVersionCode() != other.getVersionCode()) {
            return false;
         } else if (this.hasSize() != other.hasSize()) {
            return false;
         } else if (this.hasSize() && this.getSize() != other.getSize()) {
            return false;
         } else if (this.hasDownloadUrl() != other.hasDownloadUrl()) {
            return false;
         } else if (this.hasDownloadUrl() && !this.getDownloadUrl().equals(other.getDownloadUrl())) {
            return false;
         } else if (this.hasAndroidAppPatchData() != other.hasAndroidAppPatchData()) {
            return false;
         } else if (this.hasAndroidAppPatchData() && !this.getAndroidAppPatchData().equals(other.getAndroidAppPatchData())) {
            return false;
         } else if (this.hasCompressedSize() != other.hasCompressedSize()) {
            return false;
         } else if (this.hasCompressedSize() && this.getCompressedSize() != other.getCompressedSize()) {
            return false;
         } else if (this.hasCompressedDownloadUrl() != other.hasCompressedDownloadUrl()) {
            return false;
         } else if (this.hasCompressedDownloadUrl() && !this.getCompressedDownloadUrl().equals(other.getCompressedDownloadUrl())) {
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
         if (this.hasFileType()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getFileType();
         }

         if (this.hasVersionCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getVersionCode();
         }

         if (this.hasSize()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getSize());
         }

         if (this.hasDownloadUrl()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDownloadUrl().hashCode();
         }

         if (this.hasAndroidAppPatchData()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getAndroidAppPatchData().hashCode();
         }

         if (this.hasCompressedSize()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + Internal.hashLong(this.getCompressedSize());
         }

         if (this.hasCompressedDownloadUrl()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getCompressedDownloadUrl().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AppFileMetadata parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data);
   }

   public static AppFileMetadata parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppFileMetadata parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data);
   }

   public static AppFileMetadata parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppFileMetadata parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data);
   }

   public static AppFileMetadata parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AppFileMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AppFileMetadata parseFrom(InputStream input) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppFileMetadata parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppFileMetadata parseDelimitedFrom(InputStream input) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AppFileMetadata parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AppFileMetadata parseFrom(CodedInputStream input) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AppFileMetadata parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AppFileMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AppFileMetadata.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AppFileMetadata.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AppFileMetadata.Builder newBuilder(AppFileMetadata prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AppFileMetadata.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AppFileMetadata.Builder() : (new AppFileMetadata.Builder()).mergeFrom(this);
   }

   protected AppFileMetadata.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AppFileMetadata.Builder builder = new AppFileMetadata.Builder(parent);
      return builder;
   }

   public static AppFileMetadata getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AppFileMetadata getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AppFileMetadata(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AppFileMetadata(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AppFileMetadataOrBuilder {
      private int bitField0_;
      private int fileType_;
      private int versionCode_;
      private long size_;
      private Object downloadUrl_;
      private AndroidAppPatchData androidAppPatchData_;
      private SingleFieldBuilderV3 androidAppPatchDataBuilder_;
      private long compressedSize_;
      private Object compressedDownloadUrl_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AppFileMetadata_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AppFileMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(AppFileMetadata.class, AppFileMetadata.Builder.class);
      }

      private Builder() {
         this.downloadUrl_ = "";
         this.compressedDownloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.downloadUrl_ = "";
         this.compressedDownloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AppFileMetadata.alwaysUseFieldBuilders) {
            this.getAndroidAppPatchDataFieldBuilder();
         }

      }

      public AppFileMetadata.Builder clear() {
         super.clear();
         this.fileType_ = 0;
         this.bitField0_ &= -2;
         this.versionCode_ = 0;
         this.bitField0_ &= -3;
         this.size_ = 0L;
         this.bitField0_ &= -5;
         this.downloadUrl_ = "";
         this.bitField0_ &= -9;
         if (this.androidAppPatchDataBuilder_ == null) {
            this.androidAppPatchData_ = null;
         } else {
            this.androidAppPatchDataBuilder_.clear();
         }

         this.bitField0_ &= -17;
         this.compressedSize_ = 0L;
         this.bitField0_ &= -33;
         this.compressedDownloadUrl_ = "";
         this.bitField0_ &= -65;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AppFileMetadata_descriptor;
      }

      public AppFileMetadata getDefaultInstanceForType() {
         return AppFileMetadata.getDefaultInstance();
      }

      public AppFileMetadata build() {
         AppFileMetadata result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AppFileMetadata buildPartial() {
         AppFileMetadata result = new AppFileMetadata(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.fileType_ = this.fileType_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.versionCode_ = this.versionCode_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.size_ = this.size_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.downloadUrl_ = this.downloadUrl_;
         if ((from_bitField0_ & 16) != 0) {
            if (this.androidAppPatchDataBuilder_ == null) {
               result.androidAppPatchData_ = this.androidAppPatchData_;
            } else {
               result.androidAppPatchData_ = (AndroidAppPatchData)this.androidAppPatchDataBuilder_.build();
            }

            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.compressedSize_ = this.compressedSize_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 64;
         }

         result.compressedDownloadUrl_ = this.compressedDownloadUrl_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AppFileMetadata.Builder clone() {
         return (AppFileMetadata.Builder)super.clone();
      }

      public AppFileMetadata.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AppFileMetadata.Builder)super.setField(field, value);
      }

      public AppFileMetadata.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AppFileMetadata.Builder)super.clearField(field);
      }

      public AppFileMetadata.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AppFileMetadata.Builder)super.clearOneof(oneof);
      }

      public AppFileMetadata.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AppFileMetadata.Builder)super.setRepeatedField(field, index, value);
      }

      public AppFileMetadata.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AppFileMetadata.Builder)super.addRepeatedField(field, value);
      }

      public AppFileMetadata.Builder mergeFrom(Message other) {
         if (other instanceof AppFileMetadata) {
            return this.mergeFrom((AppFileMetadata)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AppFileMetadata.Builder mergeFrom(AppFileMetadata other) {
         if (other == AppFileMetadata.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasFileType()) {
               this.setFileType(other.getFileType());
            }

            if (other.hasVersionCode()) {
               this.setVersionCode(other.getVersionCode());
            }

            if (other.hasSize()) {
               this.setSize(other.getSize());
            }

            if (other.hasDownloadUrl()) {
               this.bitField0_ |= 8;
               this.downloadUrl_ = other.downloadUrl_;
               this.onChanged();
            }

            if (other.hasAndroidAppPatchData()) {
               this.mergeAndroidAppPatchData(other.getAndroidAppPatchData());
            }

            if (other.hasCompressedSize()) {
               this.setCompressedSize(other.getCompressedSize());
            }

            if (other.hasCompressedDownloadUrl()) {
               this.bitField0_ |= 64;
               this.compressedDownloadUrl_ = other.compressedDownloadUrl_;
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

      public AppFileMetadata.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AppFileMetadata parsedMessage = null;

         try {
            parsedMessage = (AppFileMetadata)AppFileMetadata.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AppFileMetadata)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasFileType() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getFileType() {
         return this.fileType_;
      }

      public AppFileMetadata.Builder setFileType(int value) {
         this.bitField0_ |= 1;
         this.fileType_ = value;
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder clearFileType() {
         this.bitField0_ &= -2;
         this.fileType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getVersionCode() {
         return this.versionCode_;
      }

      public AppFileMetadata.Builder setVersionCode(int value) {
         this.bitField0_ |= 2;
         this.versionCode_ = value;
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder clearVersionCode() {
         this.bitField0_ &= -3;
         this.versionCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasSize() {
         return (this.bitField0_ & 4) != 0;
      }

      public long getSize() {
         return this.size_;
      }

      public AppFileMetadata.Builder setSize(long value) {
         this.bitField0_ |= 4;
         this.size_ = value;
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder clearSize() {
         this.bitField0_ &= -5;
         this.size_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasDownloadUrl() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDownloadUrl() {
         Object ref = this.downloadUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.downloadUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDownloadUrlBytes() {
         Object ref = this.downloadUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.downloadUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppFileMetadata.Builder setDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppFileMetadata.Builder clearDownloadUrl() {
         this.bitField0_ &= -9;
         this.downloadUrl_ = AppFileMetadata.getDefaultInstance().getDownloadUrl();
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder setDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasAndroidAppPatchData() {
         return (this.bitField0_ & 16) != 0;
      }

      public AndroidAppPatchData getAndroidAppPatchData() {
         if (this.androidAppPatchDataBuilder_ == null) {
            return this.androidAppPatchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.androidAppPatchData_;
         } else {
            return (AndroidAppPatchData)this.androidAppPatchDataBuilder_.getMessage();
         }
      }

      public AppFileMetadata.Builder setAndroidAppPatchData(AndroidAppPatchData value) {
         if (this.androidAppPatchDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.androidAppPatchData_ = value;
            this.onChanged();
         } else {
            this.androidAppPatchDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public AppFileMetadata.Builder setAndroidAppPatchData(AndroidAppPatchData.Builder builderForValue) {
         if (this.androidAppPatchDataBuilder_ == null) {
            this.androidAppPatchData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.androidAppPatchDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 16;
         return this;
      }

      public AppFileMetadata.Builder mergeAndroidAppPatchData(AndroidAppPatchData value) {
         if (this.androidAppPatchDataBuilder_ == null) {
            if ((this.bitField0_ & 16) != 0 && this.androidAppPatchData_ != null && this.androidAppPatchData_ != AndroidAppPatchData.getDefaultInstance()) {
               this.androidAppPatchData_ = AndroidAppPatchData.newBuilder(this.androidAppPatchData_).mergeFrom(value).buildPartial();
            } else {
               this.androidAppPatchData_ = value;
            }

            this.onChanged();
         } else {
            this.androidAppPatchDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public AppFileMetadata.Builder clearAndroidAppPatchData() {
         if (this.androidAppPatchDataBuilder_ == null) {
            this.androidAppPatchData_ = null;
            this.onChanged();
         } else {
            this.androidAppPatchDataBuilder_.clear();
         }

         this.bitField0_ &= -17;
         return this;
      }

      public AndroidAppPatchData.Builder getAndroidAppPatchDataBuilder() {
         this.bitField0_ |= 16;
         this.onChanged();
         return (AndroidAppPatchData.Builder)this.getAndroidAppPatchDataFieldBuilder().getBuilder();
      }

      public AndroidAppPatchDataOrBuilder getAndroidAppPatchDataOrBuilder() {
         if (this.androidAppPatchDataBuilder_ != null) {
            return (AndroidAppPatchDataOrBuilder)this.androidAppPatchDataBuilder_.getMessageOrBuilder();
         } else {
            return this.androidAppPatchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.androidAppPatchData_;
         }
      }

      private SingleFieldBuilderV3 getAndroidAppPatchDataFieldBuilder() {
         if (this.androidAppPatchDataBuilder_ == null) {
            this.androidAppPatchDataBuilder_ = new SingleFieldBuilderV3(this.getAndroidAppPatchData(), this.getParentForChildren(), this.isClean());
            this.androidAppPatchData_ = null;
         }

         return this.androidAppPatchDataBuilder_;
      }

      public boolean hasCompressedSize() {
         return (this.bitField0_ & 32) != 0;
      }

      public long getCompressedSize() {
         return this.compressedSize_;
      }

      public AppFileMetadata.Builder setCompressedSize(long value) {
         this.bitField0_ |= 32;
         this.compressedSize_ = value;
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder clearCompressedSize() {
         this.bitField0_ &= -33;
         this.compressedSize_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasCompressedDownloadUrl() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getCompressedDownloadUrl() {
         Object ref = this.compressedDownloadUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.compressedDownloadUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCompressedDownloadUrlBytes() {
         Object ref = this.compressedDownloadUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.compressedDownloadUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AppFileMetadata.Builder setCompressedDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.compressedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public AppFileMetadata.Builder clearCompressedDownloadUrl() {
         this.bitField0_ &= -65;
         this.compressedDownloadUrl_ = AppFileMetadata.getDefaultInstance().getCompressedDownloadUrl();
         this.onChanged();
         return this;
      }

      public AppFileMetadata.Builder setCompressedDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.compressedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AppFileMetadata.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AppFileMetadata.Builder)super.setUnknownFields(unknownFields);
      }

      public final AppFileMetadata.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AppFileMetadata.Builder)super.mergeUnknownFields(unknownFields);
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
