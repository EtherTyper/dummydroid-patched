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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AndroidAppDeliveryData extends GeneratedMessageV3 implements AndroidAppDeliveryDataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOWNLOADSIZE_FIELD_NUMBER = 1;
   private long downloadSize_;
   public static final int DOWNLOADURL_FIELD_NUMBER = 3;
   private volatile Object downloadUrl_;
   public static final int ADDITIONALFILE_FIELD_NUMBER = 4;
   private List additionalFile_;
   public static final int DOWNLOADAUTHCOOKIE_FIELD_NUMBER = 5;
   private List downloadAuthCookie_;
   public static final int SERVERINITIATED_FIELD_NUMBER = 8;
   private boolean serverInitiated_;
   public static final int PATCHDATA_FIELD_NUMBER = 11;
   private AndroidAppPatchData patchData_;
   public static final int ENCRYPTIONPARAMS_FIELD_NUMBER = 12;
   private EncryptionParams encryptionParams_;
   public static final int GZIPPEDDOWNLOADURL_FIELD_NUMBER = 13;
   private volatile Object gzippedDownloadUrl_;
   public static final int GZIPPEDDOWNLOADSIZE_FIELD_NUMBER = 14;
   private long gzippedDownloadSize_;
   public static final int SPLITDELIVERYDATA_FIELD_NUMBER = 15;
   private List splitDeliveryData_;
   private byte memoizedIsInitialized;
   private static final AndroidAppDeliveryData DEFAULT_INSTANCE = new AndroidAppDeliveryData();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidAppDeliveryData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidAppDeliveryData(input, extensionRegistry);
      }
   };

   private AndroidAppDeliveryData(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidAppDeliveryData() {
      this.memoizedIsInitialized = -1;
      this.downloadUrl_ = "";
      this.additionalFile_ = Collections.emptyList();
      this.downloadAuthCookie_ = Collections.emptyList();
      this.gzippedDownloadUrl_ = "";
      this.splitDeliveryData_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidAppDeliveryData();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidAppDeliveryData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               ByteString bs;
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 8:
                  this.bitField0_ |= 1;
                  this.downloadSize_ = input.readInt64();
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.downloadUrl_ = bs;
                  break;
               case 34:
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.additionalFile_ = new ArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.additionalFile_.add(input.readMessage(AppFileMetadata.PARSER, extensionRegistry));
                  break;
               case 42:
                  if ((mutable_bitField0_ & 8) == 0) {
                     this.downloadAuthCookie_ = new ArrayList();
                     mutable_bitField0_ |= 8;
                  }

                  this.downloadAuthCookie_.add(input.readMessage(HttpCookie.PARSER, extensionRegistry));
                  break;
               case 64:
                  this.bitField0_ |= 4;
                  this.serverInitiated_ = input.readBool();
                  break;
               case 90:
                  AndroidAppPatchData.Builder subBuilder = null;
                  if ((this.bitField0_ & 8) != 0) {
                     subBuilder = this.patchData_.toBuilder();
                  }

                  this.patchData_ = (AndroidAppPatchData)input.readMessage(AndroidAppPatchData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.patchData_);
                     this.patchData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 8;
                  break;
               case 98:
                  EncryptionParams.Builder subBuilder = null;
                  if ((this.bitField0_ & 16) != 0) {
                     subBuilder = this.encryptionParams_.toBuilder();
                  }

                  this.encryptionParams_ = (EncryptionParams)input.readMessage(EncryptionParams.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.encryptionParams_);
                     this.encryptionParams_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 16;
                  break;
               case 106:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.gzippedDownloadUrl_ = bs;
                  break;
               case 112:
                  this.bitField0_ |= 64;
                  this.gzippedDownloadSize_ = input.readInt64();
                  break;
               case 122:
                  if ((mutable_bitField0_ & 512) == 0) {
                     this.splitDeliveryData_ = new ArrayList();
                     mutable_bitField0_ |= 512;
                  }

                  this.splitDeliveryData_.add(input.readMessage(SplitDeliveryData.PARSER, extensionRegistry));
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
            if ((mutable_bitField0_ & 4) != 0) {
               this.additionalFile_ = Collections.unmodifiableList(this.additionalFile_);
            }

            if ((mutable_bitField0_ & 8) != 0) {
               this.downloadAuthCookie_ = Collections.unmodifiableList(this.downloadAuthCookie_);
            }

            if ((mutable_bitField0_ & 512) != 0) {
               this.splitDeliveryData_ = Collections.unmodifiableList(this.splitDeliveryData_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_AndroidAppDeliveryData_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidAppDeliveryData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppDeliveryData.class, AndroidAppDeliveryData.Builder.class);
   }

   public boolean hasDownloadSize() {
      return (this.bitField0_ & 1) != 0;
   }

   public long getDownloadSize() {
      return this.downloadSize_;
   }

   public boolean hasDownloadUrl() {
      return (this.bitField0_ & 2) != 0;
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

   public List getAdditionalFileList() {
      return this.additionalFile_;
   }

   public List getAdditionalFileOrBuilderList() {
      return this.additionalFile_;
   }

   public int getAdditionalFileCount() {
      return this.additionalFile_.size();
   }

   public AppFileMetadata getAdditionalFile(int index) {
      return (AppFileMetadata)this.additionalFile_.get(index);
   }

   public AppFileMetadataOrBuilder getAdditionalFileOrBuilder(int index) {
      return (AppFileMetadataOrBuilder)this.additionalFile_.get(index);
   }

   public List getDownloadAuthCookieList() {
      return this.downloadAuthCookie_;
   }

   public List getDownloadAuthCookieOrBuilderList() {
      return this.downloadAuthCookie_;
   }

   public int getDownloadAuthCookieCount() {
      return this.downloadAuthCookie_.size();
   }

   public HttpCookie getDownloadAuthCookie(int index) {
      return (HttpCookie)this.downloadAuthCookie_.get(index);
   }

   public HttpCookieOrBuilder getDownloadAuthCookieOrBuilder(int index) {
      return (HttpCookieOrBuilder)this.downloadAuthCookie_.get(index);
   }

   public boolean hasServerInitiated() {
      return (this.bitField0_ & 4) != 0;
   }

   public boolean getServerInitiated() {
      return this.serverInitiated_;
   }

   public boolean hasPatchData() {
      return (this.bitField0_ & 8) != 0;
   }

   public AndroidAppPatchData getPatchData() {
      return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
   }

   public AndroidAppPatchDataOrBuilder getPatchDataOrBuilder() {
      return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
   }

   public boolean hasEncryptionParams() {
      return (this.bitField0_ & 16) != 0;
   }

   public EncryptionParams getEncryptionParams() {
      return this.encryptionParams_ == null ? EncryptionParams.getDefaultInstance() : this.encryptionParams_;
   }

   public EncryptionParamsOrBuilder getEncryptionParamsOrBuilder() {
      return this.encryptionParams_ == null ? EncryptionParams.getDefaultInstance() : this.encryptionParams_;
   }

   public boolean hasGzippedDownloadUrl() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getGzippedDownloadUrl() {
      Object ref = this.gzippedDownloadUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.gzippedDownloadUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getGzippedDownloadUrlBytes() {
      Object ref = this.gzippedDownloadUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.gzippedDownloadUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasGzippedDownloadSize() {
      return (this.bitField0_ & 64) != 0;
   }

   public long getGzippedDownloadSize() {
      return this.gzippedDownloadSize_;
   }

   public List getSplitDeliveryDataList() {
      return this.splitDeliveryData_;
   }

   public List getSplitDeliveryDataOrBuilderList() {
      return this.splitDeliveryData_;
   }

   public int getSplitDeliveryDataCount() {
      return this.splitDeliveryData_.size();
   }

   public SplitDeliveryData getSplitDeliveryData(int index) {
      return (SplitDeliveryData)this.splitDeliveryData_.get(index);
   }

   public SplitDeliveryDataOrBuilder getSplitDeliveryDataOrBuilder(int index) {
      return (SplitDeliveryDataOrBuilder)this.splitDeliveryData_.get(index);
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
         output.writeInt64(1, this.downloadSize_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.downloadUrl_);
      }

      int i;
      for(i = 0; i < this.additionalFile_.size(); ++i) {
         output.writeMessage(4, (MessageLite)this.additionalFile_.get(i));
      }

      for(i = 0; i < this.downloadAuthCookie_.size(); ++i) {
         output.writeMessage(5, (MessageLite)this.downloadAuthCookie_.get(i));
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeBool(8, this.serverInitiated_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeMessage(11, this.getPatchData());
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeMessage(12, this.getEncryptionParams());
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 13, this.gzippedDownloadUrl_);
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeInt64(14, this.gzippedDownloadSize_);
      }

      for(i = 0; i < this.splitDeliveryData_.size(); ++i) {
         output.writeMessage(15, (MessageLite)this.splitDeliveryData_.get(i));
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
            size += CodedOutputStream.computeInt64Size(1, this.downloadSize_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.downloadUrl_);
         }

         int i;
         for(i = 0; i < this.additionalFile_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.additionalFile_.get(i));
         }

         for(i = 0; i < this.downloadAuthCookie_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.downloadAuthCookie_.get(i));
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeBoolSize(8, this.serverInitiated_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(11, this.getPatchData());
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeMessageSize(12, this.getEncryptionParams());
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(13, this.gzippedDownloadUrl_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeInt64Size(14, this.gzippedDownloadSize_);
         }

         for(i = 0; i < this.splitDeliveryData_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(15, (MessageLite)this.splitDeliveryData_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidAppDeliveryData)) {
         return super.equals(obj);
      } else {
         AndroidAppDeliveryData other = (AndroidAppDeliveryData)obj;
         if (this.hasDownloadSize() != other.hasDownloadSize()) {
            return false;
         } else if (this.hasDownloadSize() && this.getDownloadSize() != other.getDownloadSize()) {
            return false;
         } else if (this.hasDownloadUrl() != other.hasDownloadUrl()) {
            return false;
         } else if (this.hasDownloadUrl() && !this.getDownloadUrl().equals(other.getDownloadUrl())) {
            return false;
         } else if (!this.getAdditionalFileList().equals(other.getAdditionalFileList())) {
            return false;
         } else if (!this.getDownloadAuthCookieList().equals(other.getDownloadAuthCookieList())) {
            return false;
         } else if (this.hasServerInitiated() != other.hasServerInitiated()) {
            return false;
         } else if (this.hasServerInitiated() && this.getServerInitiated() != other.getServerInitiated()) {
            return false;
         } else if (this.hasPatchData() != other.hasPatchData()) {
            return false;
         } else if (this.hasPatchData() && !this.getPatchData().equals(other.getPatchData())) {
            return false;
         } else if (this.hasEncryptionParams() != other.hasEncryptionParams()) {
            return false;
         } else if (this.hasEncryptionParams() && !this.getEncryptionParams().equals(other.getEncryptionParams())) {
            return false;
         } else if (this.hasGzippedDownloadUrl() != other.hasGzippedDownloadUrl()) {
            return false;
         } else if (this.hasGzippedDownloadUrl() && !this.getGzippedDownloadUrl().equals(other.getGzippedDownloadUrl())) {
            return false;
         } else if (this.hasGzippedDownloadSize() != other.hasGzippedDownloadSize()) {
            return false;
         } else if (this.hasGzippedDownloadSize() && this.getGzippedDownloadSize() != other.getGzippedDownloadSize()) {
            return false;
         } else if (!this.getSplitDeliveryDataList().equals(other.getSplitDeliveryDataList())) {
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
         if (this.hasDownloadSize()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getDownloadSize());
         }

         if (this.hasDownloadUrl()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDownloadUrl().hashCode();
         }

         if (this.getAdditionalFileCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getAdditionalFileList().hashCode();
         }

         if (this.getDownloadAuthCookieCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDownloadAuthCookieList().hashCode();
         }

         if (this.hasServerInitiated()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + Internal.hashBoolean(this.getServerInitiated());
         }

         if (this.hasPatchData()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getPatchData().hashCode();
         }

         if (this.hasEncryptionParams()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getEncryptionParams().hashCode();
         }

         if (this.hasGzippedDownloadUrl()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getGzippedDownloadUrl().hashCode();
         }

         if (this.hasGzippedDownloadSize()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + Internal.hashLong(this.getGzippedDownloadSize());
         }

         if (this.getSplitDeliveryDataCount() > 0) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getSplitDeliveryDataList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidAppDeliveryData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data);
   }

   public static AndroidAppDeliveryData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppDeliveryData parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data);
   }

   public static AndroidAppDeliveryData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppDeliveryData parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data);
   }

   public static AndroidAppDeliveryData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppDeliveryData parseFrom(InputStream input) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppDeliveryData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppDeliveryData parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidAppDeliveryData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppDeliveryData parseFrom(CodedInputStream input) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppDeliveryData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidAppDeliveryData.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidAppDeliveryData.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidAppDeliveryData.Builder newBuilder(AndroidAppDeliveryData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidAppDeliveryData.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidAppDeliveryData.Builder() : (new AndroidAppDeliveryData.Builder()).mergeFrom(this);
   }

   protected AndroidAppDeliveryData.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidAppDeliveryData.Builder builder = new AndroidAppDeliveryData.Builder(parent);
      return builder;
   }

   public static AndroidAppDeliveryData getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidAppDeliveryData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidAppDeliveryData(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidAppDeliveryData(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidAppDeliveryDataOrBuilder {
      private int bitField0_;
      private long downloadSize_;
      private Object downloadUrl_;
      private List additionalFile_;
      private RepeatedFieldBuilderV3 additionalFileBuilder_;
      private List downloadAuthCookie_;
      private RepeatedFieldBuilderV3 downloadAuthCookieBuilder_;
      private boolean serverInitiated_;
      private AndroidAppPatchData patchData_;
      private SingleFieldBuilderV3 patchDataBuilder_;
      private EncryptionParams encryptionParams_;
      private SingleFieldBuilderV3 encryptionParamsBuilder_;
      private Object gzippedDownloadUrl_;
      private long gzippedDownloadSize_;
      private List splitDeliveryData_;
      private RepeatedFieldBuilderV3 splitDeliveryDataBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidAppDeliveryData_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidAppDeliveryData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppDeliveryData.class, AndroidAppDeliveryData.Builder.class);
      }

      private Builder() {
         this.downloadUrl_ = "";
         this.additionalFile_ = Collections.emptyList();
         this.downloadAuthCookie_ = Collections.emptyList();
         this.gzippedDownloadUrl_ = "";
         this.splitDeliveryData_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.downloadUrl_ = "";
         this.additionalFile_ = Collections.emptyList();
         this.downloadAuthCookie_ = Collections.emptyList();
         this.gzippedDownloadUrl_ = "";
         this.splitDeliveryData_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidAppDeliveryData.alwaysUseFieldBuilders) {
            this.getAdditionalFileFieldBuilder();
            this.getDownloadAuthCookieFieldBuilder();
            this.getPatchDataFieldBuilder();
            this.getEncryptionParamsFieldBuilder();
            this.getSplitDeliveryDataFieldBuilder();
         }

      }

      public AndroidAppDeliveryData.Builder clear() {
         super.clear();
         this.downloadSize_ = 0L;
         this.bitField0_ &= -2;
         this.downloadUrl_ = "";
         this.bitField0_ &= -3;
         if (this.additionalFileBuilder_ == null) {
            this.additionalFile_ = Collections.emptyList();
            this.bitField0_ &= -5;
         } else {
            this.additionalFileBuilder_.clear();
         }

         if (this.downloadAuthCookieBuilder_ == null) {
            this.downloadAuthCookie_ = Collections.emptyList();
            this.bitField0_ &= -9;
         } else {
            this.downloadAuthCookieBuilder_.clear();
         }

         this.serverInitiated_ = false;
         this.bitField0_ &= -17;
         if (this.patchDataBuilder_ == null) {
            this.patchData_ = null;
         } else {
            this.patchDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         if (this.encryptionParamsBuilder_ == null) {
            this.encryptionParams_ = null;
         } else {
            this.encryptionParamsBuilder_.clear();
         }

         this.bitField0_ &= -65;
         this.gzippedDownloadUrl_ = "";
         this.bitField0_ &= -129;
         this.gzippedDownloadSize_ = 0L;
         this.bitField0_ &= -257;
         if (this.splitDeliveryDataBuilder_ == null) {
            this.splitDeliveryData_ = Collections.emptyList();
            this.bitField0_ &= -513;
         } else {
            this.splitDeliveryDataBuilder_.clear();
         }

         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidAppDeliveryData_descriptor;
      }

      public AndroidAppDeliveryData getDefaultInstanceForType() {
         return AndroidAppDeliveryData.getDefaultInstance();
      }

      public AndroidAppDeliveryData build() {
         AndroidAppDeliveryData result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidAppDeliveryData buildPartial() {
         AndroidAppDeliveryData result = new AndroidAppDeliveryData(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.downloadSize_ = this.downloadSize_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.downloadUrl_ = this.downloadUrl_;
         if (this.additionalFileBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0) {
               this.additionalFile_ = Collections.unmodifiableList(this.additionalFile_);
               this.bitField0_ &= -5;
            }

            result.additionalFile_ = this.additionalFile_;
         } else {
            result.additionalFile_ = this.additionalFileBuilder_.build();
         }

         if (this.downloadAuthCookieBuilder_ == null) {
            if ((this.bitField0_ & 8) != 0) {
               this.downloadAuthCookie_ = Collections.unmodifiableList(this.downloadAuthCookie_);
               this.bitField0_ &= -9;
            }

            result.downloadAuthCookie_ = this.downloadAuthCookie_;
         } else {
            result.downloadAuthCookie_ = this.downloadAuthCookieBuilder_.build();
         }

         if ((from_bitField0_ & 16) != 0) {
            result.serverInitiated_ = this.serverInitiated_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 32) != 0) {
            if (this.patchDataBuilder_ == null) {
               result.patchData_ = this.patchData_;
            } else {
               result.patchData_ = (AndroidAppPatchData)this.patchDataBuilder_.build();
            }

            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 64) != 0) {
            if (this.encryptionParamsBuilder_ == null) {
               result.encryptionParams_ = this.encryptionParams_;
            } else {
               result.encryptionParams_ = (EncryptionParams)this.encryptionParamsBuilder_.build();
            }

            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 32;
         }

         result.gzippedDownloadUrl_ = this.gzippedDownloadUrl_;
         if ((from_bitField0_ & 256) != 0) {
            result.gzippedDownloadSize_ = this.gzippedDownloadSize_;
            to_bitField0_ |= 64;
         }

         if (this.splitDeliveryDataBuilder_ == null) {
            if ((this.bitField0_ & 512) != 0) {
               this.splitDeliveryData_ = Collections.unmodifiableList(this.splitDeliveryData_);
               this.bitField0_ &= -513;
            }

            result.splitDeliveryData_ = this.splitDeliveryData_;
         } else {
            result.splitDeliveryData_ = this.splitDeliveryDataBuilder_.build();
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidAppDeliveryData.Builder clone() {
         return (AndroidAppDeliveryData.Builder)super.clone();
      }

      public AndroidAppDeliveryData.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppDeliveryData.Builder)super.setField(field, value);
      }

      public AndroidAppDeliveryData.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidAppDeliveryData.Builder)super.clearField(field);
      }

      public AndroidAppDeliveryData.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidAppDeliveryData.Builder)super.clearOneof(oneof);
      }

      public AndroidAppDeliveryData.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidAppDeliveryData.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidAppDeliveryData.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppDeliveryData.Builder)super.addRepeatedField(field, value);
      }

      public AndroidAppDeliveryData.Builder mergeFrom(Message other) {
         if (other instanceof AndroidAppDeliveryData) {
            return this.mergeFrom((AndroidAppDeliveryData)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidAppDeliveryData.Builder mergeFrom(AndroidAppDeliveryData other) {
         if (other == AndroidAppDeliveryData.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDownloadSize()) {
               this.setDownloadSize(other.getDownloadSize());
            }

            if (other.hasDownloadUrl()) {
               this.bitField0_ |= 2;
               this.downloadUrl_ = other.downloadUrl_;
               this.onChanged();
            }

            if (this.additionalFileBuilder_ == null) {
               if (!other.additionalFile_.isEmpty()) {
                  if (this.additionalFile_.isEmpty()) {
                     this.additionalFile_ = other.additionalFile_;
                     this.bitField0_ &= -5;
                  } else {
                     this.ensureAdditionalFileIsMutable();
                     this.additionalFile_.addAll(other.additionalFile_);
                  }

                  this.onChanged();
               }
            } else if (!other.additionalFile_.isEmpty()) {
               if (this.additionalFileBuilder_.isEmpty()) {
                  this.additionalFileBuilder_.dispose();
                  this.additionalFileBuilder_ = null;
                  this.additionalFile_ = other.additionalFile_;
                  this.bitField0_ &= -5;
                  this.additionalFileBuilder_ = AndroidAppDeliveryData.alwaysUseFieldBuilders ? this.getAdditionalFileFieldBuilder() : null;
               } else {
                  this.additionalFileBuilder_.addAllMessages(other.additionalFile_);
               }
            }

            if (this.downloadAuthCookieBuilder_ == null) {
               if (!other.downloadAuthCookie_.isEmpty()) {
                  if (this.downloadAuthCookie_.isEmpty()) {
                     this.downloadAuthCookie_ = other.downloadAuthCookie_;
                     this.bitField0_ &= -9;
                  } else {
                     this.ensureDownloadAuthCookieIsMutable();
                     this.downloadAuthCookie_.addAll(other.downloadAuthCookie_);
                  }

                  this.onChanged();
               }
            } else if (!other.downloadAuthCookie_.isEmpty()) {
               if (this.downloadAuthCookieBuilder_.isEmpty()) {
                  this.downloadAuthCookieBuilder_.dispose();
                  this.downloadAuthCookieBuilder_ = null;
                  this.downloadAuthCookie_ = other.downloadAuthCookie_;
                  this.bitField0_ &= -9;
                  this.downloadAuthCookieBuilder_ = AndroidAppDeliveryData.alwaysUseFieldBuilders ? this.getDownloadAuthCookieFieldBuilder() : null;
               } else {
                  this.downloadAuthCookieBuilder_.addAllMessages(other.downloadAuthCookie_);
               }
            }

            if (other.hasServerInitiated()) {
               this.setServerInitiated(other.getServerInitiated());
            }

            if (other.hasPatchData()) {
               this.mergePatchData(other.getPatchData());
            }

            if (other.hasEncryptionParams()) {
               this.mergeEncryptionParams(other.getEncryptionParams());
            }

            if (other.hasGzippedDownloadUrl()) {
               this.bitField0_ |= 128;
               this.gzippedDownloadUrl_ = other.gzippedDownloadUrl_;
               this.onChanged();
            }

            if (other.hasGzippedDownloadSize()) {
               this.setGzippedDownloadSize(other.getGzippedDownloadSize());
            }

            if (this.splitDeliveryDataBuilder_ == null) {
               if (!other.splitDeliveryData_.isEmpty()) {
                  if (this.splitDeliveryData_.isEmpty()) {
                     this.splitDeliveryData_ = other.splitDeliveryData_;
                     this.bitField0_ &= -513;
                  } else {
                     this.ensureSplitDeliveryDataIsMutable();
                     this.splitDeliveryData_.addAll(other.splitDeliveryData_);
                  }

                  this.onChanged();
               }
            } else if (!other.splitDeliveryData_.isEmpty()) {
               if (this.splitDeliveryDataBuilder_.isEmpty()) {
                  this.splitDeliveryDataBuilder_.dispose();
                  this.splitDeliveryDataBuilder_ = null;
                  this.splitDeliveryData_ = other.splitDeliveryData_;
                  this.bitField0_ &= -513;
                  this.splitDeliveryDataBuilder_ = AndroidAppDeliveryData.alwaysUseFieldBuilders ? this.getSplitDeliveryDataFieldBuilder() : null;
               } else {
                  this.splitDeliveryDataBuilder_.addAllMessages(other.splitDeliveryData_);
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

      public AndroidAppDeliveryData.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidAppDeliveryData parsedMessage = null;

         try {
            parsedMessage = (AndroidAppDeliveryData)AndroidAppDeliveryData.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidAppDeliveryData)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDownloadSize() {
         return (this.bitField0_ & 1) != 0;
      }

      public long getDownloadSize() {
         return this.downloadSize_;
      }

      public AndroidAppDeliveryData.Builder setDownloadSize(long value) {
         this.bitField0_ |= 1;
         this.downloadSize_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppDeliveryData.Builder clearDownloadSize() {
         this.bitField0_ &= -2;
         this.downloadSize_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasDownloadUrl() {
         return (this.bitField0_ & 2) != 0;
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

      public AndroidAppDeliveryData.Builder setDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidAppDeliveryData.Builder clearDownloadUrl() {
         this.bitField0_ &= -3;
         this.downloadUrl_ = AndroidAppDeliveryData.getDefaultInstance().getDownloadUrl();
         this.onChanged();
         return this;
      }

      public AndroidAppDeliveryData.Builder setDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureAdditionalFileIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.additionalFile_ = new ArrayList(this.additionalFile_);
            this.bitField0_ |= 4;
         }

      }

      public List getAdditionalFileList() {
         return this.additionalFileBuilder_ == null ? Collections.unmodifiableList(this.additionalFile_) : this.additionalFileBuilder_.getMessageList();
      }

      public int getAdditionalFileCount() {
         return this.additionalFileBuilder_ == null ? this.additionalFile_.size() : this.additionalFileBuilder_.getCount();
      }

      public AppFileMetadata getAdditionalFile(int index) {
         return this.additionalFileBuilder_ == null ? (AppFileMetadata)this.additionalFile_.get(index) : (AppFileMetadata)this.additionalFileBuilder_.getMessage(index);
      }

      public AndroidAppDeliveryData.Builder setAdditionalFile(int index, AppFileMetadata value) {
         if (this.additionalFileBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.set(index, value);
            this.onChanged();
         } else {
            this.additionalFileBuilder_.setMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder setAdditionalFile(int index, AppFileMetadata.Builder builderForValue) {
         if (this.additionalFileBuilder_ == null) {
            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.additionalFileBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAdditionalFile(AppFileMetadata value) {
         if (this.additionalFileBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.add(value);
            this.onChanged();
         } else {
            this.additionalFileBuilder_.addMessage(value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAdditionalFile(int index, AppFileMetadata value) {
         if (this.additionalFileBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.add(index, value);
            this.onChanged();
         } else {
            this.additionalFileBuilder_.addMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAdditionalFile(AppFileMetadata.Builder builderForValue) {
         if (this.additionalFileBuilder_ == null) {
            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.additionalFileBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAdditionalFile(int index, AppFileMetadata.Builder builderForValue) {
         if (this.additionalFileBuilder_ == null) {
            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.additionalFileBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAllAdditionalFile(Iterable values) {
         if (this.additionalFileBuilder_ == null) {
            this.ensureAdditionalFileIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.additionalFile_);
            this.onChanged();
         } else {
            this.additionalFileBuilder_.addAllMessages(values);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder clearAdditionalFile() {
         if (this.additionalFileBuilder_ == null) {
            this.additionalFile_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
         } else {
            this.additionalFileBuilder_.clear();
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder removeAdditionalFile(int index) {
         if (this.additionalFileBuilder_ == null) {
            this.ensureAdditionalFileIsMutable();
            this.additionalFile_.remove(index);
            this.onChanged();
         } else {
            this.additionalFileBuilder_.remove(index);
         }

         return this;
      }

      public AppFileMetadata.Builder getAdditionalFileBuilder(int index) {
         return (AppFileMetadata.Builder)this.getAdditionalFileFieldBuilder().getBuilder(index);
      }

      public AppFileMetadataOrBuilder getAdditionalFileOrBuilder(int index) {
         return this.additionalFileBuilder_ == null ? (AppFileMetadataOrBuilder)this.additionalFile_.get(index) : (AppFileMetadataOrBuilder)this.additionalFileBuilder_.getMessageOrBuilder(index);
      }

      public List getAdditionalFileOrBuilderList() {
         return this.additionalFileBuilder_ != null ? this.additionalFileBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.additionalFile_);
      }

      public AppFileMetadata.Builder addAdditionalFileBuilder() {
         return (AppFileMetadata.Builder)this.getAdditionalFileFieldBuilder().addBuilder(AppFileMetadata.getDefaultInstance());
      }

      public AppFileMetadata.Builder addAdditionalFileBuilder(int index) {
         return (AppFileMetadata.Builder)this.getAdditionalFileFieldBuilder().addBuilder(index, AppFileMetadata.getDefaultInstance());
      }

      public List getAdditionalFileBuilderList() {
         return this.getAdditionalFileFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getAdditionalFileFieldBuilder() {
         if (this.additionalFileBuilder_ == null) {
            this.additionalFileBuilder_ = new RepeatedFieldBuilderV3(this.additionalFile_, (this.bitField0_ & 4) != 0, this.getParentForChildren(), this.isClean());
            this.additionalFile_ = null;
         }

         return this.additionalFileBuilder_;
      }

      private void ensureDownloadAuthCookieIsMutable() {
         if ((this.bitField0_ & 8) == 0) {
            this.downloadAuthCookie_ = new ArrayList(this.downloadAuthCookie_);
            this.bitField0_ |= 8;
         }

      }

      public List getDownloadAuthCookieList() {
         return this.downloadAuthCookieBuilder_ == null ? Collections.unmodifiableList(this.downloadAuthCookie_) : this.downloadAuthCookieBuilder_.getMessageList();
      }

      public int getDownloadAuthCookieCount() {
         return this.downloadAuthCookieBuilder_ == null ? this.downloadAuthCookie_.size() : this.downloadAuthCookieBuilder_.getCount();
      }

      public HttpCookie getDownloadAuthCookie(int index) {
         return this.downloadAuthCookieBuilder_ == null ? (HttpCookie)this.downloadAuthCookie_.get(index) : (HttpCookie)this.downloadAuthCookieBuilder_.getMessage(index);
      }

      public AndroidAppDeliveryData.Builder setDownloadAuthCookie(int index, HttpCookie value) {
         if (this.downloadAuthCookieBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.set(index, value);
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.setMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder setDownloadAuthCookie(int index, HttpCookie.Builder builderForValue) {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addDownloadAuthCookie(HttpCookie value) {
         if (this.downloadAuthCookieBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.add(value);
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.addMessage(value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addDownloadAuthCookie(int index, HttpCookie value) {
         if (this.downloadAuthCookieBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.add(index, value);
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.addMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addDownloadAuthCookie(HttpCookie.Builder builderForValue) {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addDownloadAuthCookie(int index, HttpCookie.Builder builderForValue) {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAllDownloadAuthCookie(Iterable values) {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.ensureDownloadAuthCookieIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.downloadAuthCookie_);
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.addAllMessages(values);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder clearDownloadAuthCookie() {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.downloadAuthCookie_ = Collections.emptyList();
            this.bitField0_ &= -9;
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.clear();
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder removeDownloadAuthCookie(int index) {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.ensureDownloadAuthCookieIsMutable();
            this.downloadAuthCookie_.remove(index);
            this.onChanged();
         } else {
            this.downloadAuthCookieBuilder_.remove(index);
         }

         return this;
      }

      public HttpCookie.Builder getDownloadAuthCookieBuilder(int index) {
         return (HttpCookie.Builder)this.getDownloadAuthCookieFieldBuilder().getBuilder(index);
      }

      public HttpCookieOrBuilder getDownloadAuthCookieOrBuilder(int index) {
         return this.downloadAuthCookieBuilder_ == null ? (HttpCookieOrBuilder)this.downloadAuthCookie_.get(index) : (HttpCookieOrBuilder)this.downloadAuthCookieBuilder_.getMessageOrBuilder(index);
      }

      public List getDownloadAuthCookieOrBuilderList() {
         return this.downloadAuthCookieBuilder_ != null ? this.downloadAuthCookieBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.downloadAuthCookie_);
      }

      public HttpCookie.Builder addDownloadAuthCookieBuilder() {
         return (HttpCookie.Builder)this.getDownloadAuthCookieFieldBuilder().addBuilder(HttpCookie.getDefaultInstance());
      }

      public HttpCookie.Builder addDownloadAuthCookieBuilder(int index) {
         return (HttpCookie.Builder)this.getDownloadAuthCookieFieldBuilder().addBuilder(index, HttpCookie.getDefaultInstance());
      }

      public List getDownloadAuthCookieBuilderList() {
         return this.getDownloadAuthCookieFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getDownloadAuthCookieFieldBuilder() {
         if (this.downloadAuthCookieBuilder_ == null) {
            this.downloadAuthCookieBuilder_ = new RepeatedFieldBuilderV3(this.downloadAuthCookie_, (this.bitField0_ & 8) != 0, this.getParentForChildren(), this.isClean());
            this.downloadAuthCookie_ = null;
         }

         return this.downloadAuthCookieBuilder_;
      }

      public boolean hasServerInitiated() {
         return (this.bitField0_ & 16) != 0;
      }

      public boolean getServerInitiated() {
         return this.serverInitiated_;
      }

      public AndroidAppDeliveryData.Builder setServerInitiated(boolean value) {
         this.bitField0_ |= 16;
         this.serverInitiated_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppDeliveryData.Builder clearServerInitiated() {
         this.bitField0_ &= -17;
         this.serverInitiated_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasPatchData() {
         return (this.bitField0_ & 32) != 0;
      }

      public AndroidAppPatchData getPatchData() {
         if (this.patchDataBuilder_ == null) {
            return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
         } else {
            return (AndroidAppPatchData)this.patchDataBuilder_.getMessage();
         }
      }

      public AndroidAppDeliveryData.Builder setPatchData(AndroidAppPatchData value) {
         if (this.patchDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.patchData_ = value;
            this.onChanged();
         } else {
            this.patchDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public AndroidAppDeliveryData.Builder setPatchData(AndroidAppPatchData.Builder builderForValue) {
         if (this.patchDataBuilder_ == null) {
            this.patchData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.patchDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public AndroidAppDeliveryData.Builder mergePatchData(AndroidAppPatchData value) {
         if (this.patchDataBuilder_ == null) {
            if ((this.bitField0_ & 32) != 0 && this.patchData_ != null && this.patchData_ != AndroidAppPatchData.getDefaultInstance()) {
               this.patchData_ = AndroidAppPatchData.newBuilder(this.patchData_).mergeFrom(value).buildPartial();
            } else {
               this.patchData_ = value;
            }

            this.onChanged();
         } else {
            this.patchDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public AndroidAppDeliveryData.Builder clearPatchData() {
         if (this.patchDataBuilder_ == null) {
            this.patchData_ = null;
            this.onChanged();
         } else {
            this.patchDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public AndroidAppPatchData.Builder getPatchDataBuilder() {
         this.bitField0_ |= 32;
         this.onChanged();
         return (AndroidAppPatchData.Builder)this.getPatchDataFieldBuilder().getBuilder();
      }

      public AndroidAppPatchDataOrBuilder getPatchDataOrBuilder() {
         if (this.patchDataBuilder_ != null) {
            return (AndroidAppPatchDataOrBuilder)this.patchDataBuilder_.getMessageOrBuilder();
         } else {
            return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
         }
      }

      private SingleFieldBuilderV3 getPatchDataFieldBuilder() {
         if (this.patchDataBuilder_ == null) {
            this.patchDataBuilder_ = new SingleFieldBuilderV3(this.getPatchData(), this.getParentForChildren(), this.isClean());
            this.patchData_ = null;
         }

         return this.patchDataBuilder_;
      }

      public boolean hasEncryptionParams() {
         return (this.bitField0_ & 64) != 0;
      }

      public EncryptionParams getEncryptionParams() {
         if (this.encryptionParamsBuilder_ == null) {
            return this.encryptionParams_ == null ? EncryptionParams.getDefaultInstance() : this.encryptionParams_;
         } else {
            return (EncryptionParams)this.encryptionParamsBuilder_.getMessage();
         }
      }

      public AndroidAppDeliveryData.Builder setEncryptionParams(EncryptionParams value) {
         if (this.encryptionParamsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.encryptionParams_ = value;
            this.onChanged();
         } else {
            this.encryptionParamsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public AndroidAppDeliveryData.Builder setEncryptionParams(EncryptionParams.Builder builderForValue) {
         if (this.encryptionParamsBuilder_ == null) {
            this.encryptionParams_ = builderForValue.build();
            this.onChanged();
         } else {
            this.encryptionParamsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 64;
         return this;
      }

      public AndroidAppDeliveryData.Builder mergeEncryptionParams(EncryptionParams value) {
         if (this.encryptionParamsBuilder_ == null) {
            if ((this.bitField0_ & 64) != 0 && this.encryptionParams_ != null && this.encryptionParams_ != EncryptionParams.getDefaultInstance()) {
               this.encryptionParams_ = EncryptionParams.newBuilder(this.encryptionParams_).mergeFrom(value).buildPartial();
            } else {
               this.encryptionParams_ = value;
            }

            this.onChanged();
         } else {
            this.encryptionParamsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public AndroidAppDeliveryData.Builder clearEncryptionParams() {
         if (this.encryptionParamsBuilder_ == null) {
            this.encryptionParams_ = null;
            this.onChanged();
         } else {
            this.encryptionParamsBuilder_.clear();
         }

         this.bitField0_ &= -65;
         return this;
      }

      public EncryptionParams.Builder getEncryptionParamsBuilder() {
         this.bitField0_ |= 64;
         this.onChanged();
         return (EncryptionParams.Builder)this.getEncryptionParamsFieldBuilder().getBuilder();
      }

      public EncryptionParamsOrBuilder getEncryptionParamsOrBuilder() {
         if (this.encryptionParamsBuilder_ != null) {
            return (EncryptionParamsOrBuilder)this.encryptionParamsBuilder_.getMessageOrBuilder();
         } else {
            return this.encryptionParams_ == null ? EncryptionParams.getDefaultInstance() : this.encryptionParams_;
         }
      }

      private SingleFieldBuilderV3 getEncryptionParamsFieldBuilder() {
         if (this.encryptionParamsBuilder_ == null) {
            this.encryptionParamsBuilder_ = new SingleFieldBuilderV3(this.getEncryptionParams(), this.getParentForChildren(), this.isClean());
            this.encryptionParams_ = null;
         }

         return this.encryptionParamsBuilder_;
      }

      public boolean hasGzippedDownloadUrl() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getGzippedDownloadUrl() {
         Object ref = this.gzippedDownloadUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.gzippedDownloadUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getGzippedDownloadUrlBytes() {
         Object ref = this.gzippedDownloadUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.gzippedDownloadUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidAppDeliveryData.Builder setGzippedDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.gzippedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidAppDeliveryData.Builder clearGzippedDownloadUrl() {
         this.bitField0_ &= -129;
         this.gzippedDownloadUrl_ = AndroidAppDeliveryData.getDefaultInstance().getGzippedDownloadUrl();
         this.onChanged();
         return this;
      }

      public AndroidAppDeliveryData.Builder setGzippedDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.gzippedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasGzippedDownloadSize() {
         return (this.bitField0_ & 256) != 0;
      }

      public long getGzippedDownloadSize() {
         return this.gzippedDownloadSize_;
      }

      public AndroidAppDeliveryData.Builder setGzippedDownloadSize(long value) {
         this.bitField0_ |= 256;
         this.gzippedDownloadSize_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppDeliveryData.Builder clearGzippedDownloadSize() {
         this.bitField0_ &= -257;
         this.gzippedDownloadSize_ = 0L;
         this.onChanged();
         return this;
      }

      private void ensureSplitDeliveryDataIsMutable() {
         if ((this.bitField0_ & 512) == 0) {
            this.splitDeliveryData_ = new ArrayList(this.splitDeliveryData_);
            this.bitField0_ |= 512;
         }

      }

      public List getSplitDeliveryDataList() {
         return this.splitDeliveryDataBuilder_ == null ? Collections.unmodifiableList(this.splitDeliveryData_) : this.splitDeliveryDataBuilder_.getMessageList();
      }

      public int getSplitDeliveryDataCount() {
         return this.splitDeliveryDataBuilder_ == null ? this.splitDeliveryData_.size() : this.splitDeliveryDataBuilder_.getCount();
      }

      public SplitDeliveryData getSplitDeliveryData(int index) {
         return this.splitDeliveryDataBuilder_ == null ? (SplitDeliveryData)this.splitDeliveryData_.get(index) : (SplitDeliveryData)this.splitDeliveryDataBuilder_.getMessage(index);
      }

      public AndroidAppDeliveryData.Builder setSplitDeliveryData(int index, SplitDeliveryData value) {
         if (this.splitDeliveryDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.set(index, value);
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.setMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder setSplitDeliveryData(int index, SplitDeliveryData.Builder builderForValue) {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addSplitDeliveryData(SplitDeliveryData value) {
         if (this.splitDeliveryDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.add(value);
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.addMessage(value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addSplitDeliveryData(int index, SplitDeliveryData value) {
         if (this.splitDeliveryDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.add(index, value);
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.addMessage(index, value);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addSplitDeliveryData(SplitDeliveryData.Builder builderForValue) {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addSplitDeliveryData(int index, SplitDeliveryData.Builder builderForValue) {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder addAllSplitDeliveryData(Iterable values) {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.ensureSplitDeliveryDataIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.splitDeliveryData_);
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.addAllMessages(values);
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder clearSplitDeliveryData() {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.splitDeliveryData_ = Collections.emptyList();
            this.bitField0_ &= -513;
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.clear();
         }

         return this;
      }

      public AndroidAppDeliveryData.Builder removeSplitDeliveryData(int index) {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.ensureSplitDeliveryDataIsMutable();
            this.splitDeliveryData_.remove(index);
            this.onChanged();
         } else {
            this.splitDeliveryDataBuilder_.remove(index);
         }

         return this;
      }

      public SplitDeliveryData.Builder getSplitDeliveryDataBuilder(int index) {
         return (SplitDeliveryData.Builder)this.getSplitDeliveryDataFieldBuilder().getBuilder(index);
      }

      public SplitDeliveryDataOrBuilder getSplitDeliveryDataOrBuilder(int index) {
         return this.splitDeliveryDataBuilder_ == null ? (SplitDeliveryDataOrBuilder)this.splitDeliveryData_.get(index) : (SplitDeliveryDataOrBuilder)this.splitDeliveryDataBuilder_.getMessageOrBuilder(index);
      }

      public List getSplitDeliveryDataOrBuilderList() {
         return this.splitDeliveryDataBuilder_ != null ? this.splitDeliveryDataBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.splitDeliveryData_);
      }

      public SplitDeliveryData.Builder addSplitDeliveryDataBuilder() {
         return (SplitDeliveryData.Builder)this.getSplitDeliveryDataFieldBuilder().addBuilder(SplitDeliveryData.getDefaultInstance());
      }

      public SplitDeliveryData.Builder addSplitDeliveryDataBuilder(int index) {
         return (SplitDeliveryData.Builder)this.getSplitDeliveryDataFieldBuilder().addBuilder(index, SplitDeliveryData.getDefaultInstance());
      }

      public List getSplitDeliveryDataBuilderList() {
         return this.getSplitDeliveryDataFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getSplitDeliveryDataFieldBuilder() {
         if (this.splitDeliveryDataBuilder_ == null) {
            this.splitDeliveryDataBuilder_ = new RepeatedFieldBuilderV3(this.splitDeliveryData_, (this.bitField0_ & 512) != 0, this.getParentForChildren(), this.isClean());
            this.splitDeliveryData_ = null;
         }

         return this.splitDeliveryDataBuilder_;
      }

      public final AndroidAppDeliveryData.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppDeliveryData.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidAppDeliveryData.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppDeliveryData.Builder)super.mergeUnknownFields(unknownFields);
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
