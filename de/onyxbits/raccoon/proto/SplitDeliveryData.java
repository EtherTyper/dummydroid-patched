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

public final class SplitDeliveryData extends GeneratedMessageV3 implements SplitDeliveryDataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int ID_FIELD_NUMBER = 1;
   private volatile Object id_;
   public static final int DOWNLOADSIZE_FIELD_NUMBER = 2;
   private long downloadSize_;
   public static final int GZIPPEDDOWNLOADSIZE_FIELD_NUMBER = 3;
   private long gzippedDownloadSize_;
   public static final int DOWNLOADURL_FIELD_NUMBER = 5;
   private volatile Object downloadUrl_;
   public static final int GZIPPEDDOWNLOADURL_FIELD_NUMBER = 6;
   private volatile Object gzippedDownloadUrl_;
   public static final int PATCHDATA_FIELD_NUMBER = 7;
   private AndroidAppPatchData patchData_;
   private byte memoizedIsInitialized;
   private static final SplitDeliveryData DEFAULT_INSTANCE = new SplitDeliveryData();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public SplitDeliveryData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new SplitDeliveryData(input, extensionRegistry);
      }
   };

   private SplitDeliveryData(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private SplitDeliveryData() {
      this.memoizedIsInitialized = -1;
      this.id_ = "";
      this.downloadUrl_ = "";
      this.gzippedDownloadUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new SplitDeliveryData();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private SplitDeliveryData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.id_ = bs;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.downloadSize_ = input.readInt64();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.gzippedDownloadSize_ = input.readInt64();
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.downloadUrl_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.gzippedDownloadUrl_ = bs;
                  break;
               case 58:
                  AndroidAppPatchData.Builder subBuilder = null;
                  if ((this.bitField0_ & 32) != 0) {
                     subBuilder = this.patchData_.toBuilder();
                  }

                  this.patchData_ = (AndroidAppPatchData)input.readMessage(AndroidAppPatchData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.patchData_);
                     this.patchData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 32;
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
      return Mothership.internal_static_SplitDeliveryData_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_SplitDeliveryData_fieldAccessorTable.ensureFieldAccessorsInitialized(SplitDeliveryData.class, SplitDeliveryData.Builder.class);
   }

   public boolean hasId() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getId() {
      Object ref = this.id_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.id_ = s;
         }

         return s;
      }
   }

   public ByteString getIdBytes() {
      Object ref = this.id_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.id_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDownloadSize() {
      return (this.bitField0_ & 2) != 0;
   }

   public long getDownloadSize() {
      return this.downloadSize_;
   }

   public boolean hasGzippedDownloadSize() {
      return (this.bitField0_ & 4) != 0;
   }

   public long getGzippedDownloadSize() {
      return this.gzippedDownloadSize_;
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

   public boolean hasGzippedDownloadUrl() {
      return (this.bitField0_ & 16) != 0;
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

   public boolean hasPatchData() {
      return (this.bitField0_ & 32) != 0;
   }

   public AndroidAppPatchData getPatchData() {
      return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
   }

   public AndroidAppPatchDataOrBuilder getPatchDataOrBuilder() {
      return this.patchData_ == null ? AndroidAppPatchData.getDefaultInstance() : this.patchData_;
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
         GeneratedMessageV3.writeString(output, 1, this.id_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt64(2, this.downloadSize_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt64(3, this.gzippedDownloadSize_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.downloadUrl_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.gzippedDownloadUrl_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeMessage(7, this.getPatchData());
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
            size += GeneratedMessageV3.computeStringSize(1, this.id_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt64Size(2, this.downloadSize_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt64Size(3, this.gzippedDownloadSize_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.downloadUrl_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.gzippedDownloadUrl_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getPatchData());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof SplitDeliveryData)) {
         return super.equals(obj);
      } else {
         SplitDeliveryData other = (SplitDeliveryData)obj;
         if (this.hasId() != other.hasId()) {
            return false;
         } else if (this.hasId() && !this.getId().equals(other.getId())) {
            return false;
         } else if (this.hasDownloadSize() != other.hasDownloadSize()) {
            return false;
         } else if (this.hasDownloadSize() && this.getDownloadSize() != other.getDownloadSize()) {
            return false;
         } else if (this.hasGzippedDownloadSize() != other.hasGzippedDownloadSize()) {
            return false;
         } else if (this.hasGzippedDownloadSize() && this.getGzippedDownloadSize() != other.getGzippedDownloadSize()) {
            return false;
         } else if (this.hasDownloadUrl() != other.hasDownloadUrl()) {
            return false;
         } else if (this.hasDownloadUrl() && !this.getDownloadUrl().equals(other.getDownloadUrl())) {
            return false;
         } else if (this.hasGzippedDownloadUrl() != other.hasGzippedDownloadUrl()) {
            return false;
         } else if (this.hasGzippedDownloadUrl() && !this.getGzippedDownloadUrl().equals(other.getGzippedDownloadUrl())) {
            return false;
         } else if (this.hasPatchData() != other.hasPatchData()) {
            return false;
         } else if (this.hasPatchData() && !this.getPatchData().equals(other.getPatchData())) {
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
         if (this.hasId()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getId().hashCode();
         }

         if (this.hasDownloadSize()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getDownloadSize());
         }

         if (this.hasGzippedDownloadSize()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getGzippedDownloadSize());
         }

         if (this.hasDownloadUrl()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDownloadUrl().hashCode();
         }

         if (this.hasGzippedDownloadUrl()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getGzippedDownloadUrl().hashCode();
         }

         if (this.hasPatchData()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getPatchData().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static SplitDeliveryData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data);
   }

   public static SplitDeliveryData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SplitDeliveryData parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data);
   }

   public static SplitDeliveryData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SplitDeliveryData parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data);
   }

   public static SplitDeliveryData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (SplitDeliveryData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static SplitDeliveryData parseFrom(InputStream input) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SplitDeliveryData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static SplitDeliveryData parseDelimitedFrom(InputStream input) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static SplitDeliveryData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static SplitDeliveryData parseFrom(CodedInputStream input) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static SplitDeliveryData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (SplitDeliveryData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public SplitDeliveryData.Builder newBuilderForType() {
      return newBuilder();
   }

   public static SplitDeliveryData.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static SplitDeliveryData.Builder newBuilder(SplitDeliveryData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public SplitDeliveryData.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new SplitDeliveryData.Builder() : (new SplitDeliveryData.Builder()).mergeFrom(this);
   }

   protected SplitDeliveryData.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      SplitDeliveryData.Builder builder = new SplitDeliveryData.Builder(parent);
      return builder;
   }

   public static SplitDeliveryData getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public SplitDeliveryData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   SplitDeliveryData(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   SplitDeliveryData(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements SplitDeliveryDataOrBuilder {
      private int bitField0_;
      private Object id_;
      private long downloadSize_;
      private long gzippedDownloadSize_;
      private Object downloadUrl_;
      private Object gzippedDownloadUrl_;
      private AndroidAppPatchData patchData_;
      private SingleFieldBuilderV3 patchDataBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_SplitDeliveryData_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_SplitDeliveryData_fieldAccessorTable.ensureFieldAccessorsInitialized(SplitDeliveryData.class, SplitDeliveryData.Builder.class);
      }

      private Builder() {
         this.id_ = "";
         this.downloadUrl_ = "";
         this.gzippedDownloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.id_ = "";
         this.downloadUrl_ = "";
         this.gzippedDownloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (SplitDeliveryData.alwaysUseFieldBuilders) {
            this.getPatchDataFieldBuilder();
         }

      }

      public SplitDeliveryData.Builder clear() {
         super.clear();
         this.id_ = "";
         this.bitField0_ &= -2;
         this.downloadSize_ = 0L;
         this.bitField0_ &= -3;
         this.gzippedDownloadSize_ = 0L;
         this.bitField0_ &= -5;
         this.downloadUrl_ = "";
         this.bitField0_ &= -9;
         this.gzippedDownloadUrl_ = "";
         this.bitField0_ &= -17;
         if (this.patchDataBuilder_ == null) {
            this.patchData_ = null;
         } else {
            this.patchDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_SplitDeliveryData_descriptor;
      }

      public SplitDeliveryData getDefaultInstanceForType() {
         return SplitDeliveryData.getDefaultInstance();
      }

      public SplitDeliveryData build() {
         SplitDeliveryData result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public SplitDeliveryData buildPartial() {
         SplitDeliveryData result = new SplitDeliveryData(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.id_ = this.id_;
         if ((from_bitField0_ & 2) != 0) {
            result.downloadSize_ = this.downloadSize_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.gzippedDownloadSize_ = this.gzippedDownloadSize_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.downloadUrl_ = this.downloadUrl_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.gzippedDownloadUrl_ = this.gzippedDownloadUrl_;
         if ((from_bitField0_ & 32) != 0) {
            if (this.patchDataBuilder_ == null) {
               result.patchData_ = this.patchData_;
            } else {
               result.patchData_ = (AndroidAppPatchData)this.patchDataBuilder_.build();
            }

            to_bitField0_ |= 32;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public SplitDeliveryData.Builder clone() {
         return (SplitDeliveryData.Builder)super.clone();
      }

      public SplitDeliveryData.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (SplitDeliveryData.Builder)super.setField(field, value);
      }

      public SplitDeliveryData.Builder clearField(Descriptors.FieldDescriptor field) {
         return (SplitDeliveryData.Builder)super.clearField(field);
      }

      public SplitDeliveryData.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (SplitDeliveryData.Builder)super.clearOneof(oneof);
      }

      public SplitDeliveryData.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (SplitDeliveryData.Builder)super.setRepeatedField(field, index, value);
      }

      public SplitDeliveryData.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (SplitDeliveryData.Builder)super.addRepeatedField(field, value);
      }

      public SplitDeliveryData.Builder mergeFrom(Message other) {
         if (other instanceof SplitDeliveryData) {
            return this.mergeFrom((SplitDeliveryData)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public SplitDeliveryData.Builder mergeFrom(SplitDeliveryData other) {
         if (other == SplitDeliveryData.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasId()) {
               this.bitField0_ |= 1;
               this.id_ = other.id_;
               this.onChanged();
            }

            if (other.hasDownloadSize()) {
               this.setDownloadSize(other.getDownloadSize());
            }

            if (other.hasGzippedDownloadSize()) {
               this.setGzippedDownloadSize(other.getGzippedDownloadSize());
            }

            if (other.hasDownloadUrl()) {
               this.bitField0_ |= 8;
               this.downloadUrl_ = other.downloadUrl_;
               this.onChanged();
            }

            if (other.hasGzippedDownloadUrl()) {
               this.bitField0_ |= 16;
               this.gzippedDownloadUrl_ = other.gzippedDownloadUrl_;
               this.onChanged();
            }

            if (other.hasPatchData()) {
               this.mergePatchData(other.getPatchData());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public SplitDeliveryData.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         SplitDeliveryData parsedMessage = null;

         try {
            parsedMessage = (SplitDeliveryData)SplitDeliveryData.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (SplitDeliveryData)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasId() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getId() {
         Object ref = this.id_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.id_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getIdBytes() {
         Object ref = this.id_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.id_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public SplitDeliveryData.Builder setId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.id_ = value;
            this.onChanged();
            return this;
         }
      }

      public SplitDeliveryData.Builder clearId() {
         this.bitField0_ &= -2;
         this.id_ = SplitDeliveryData.getDefaultInstance().getId();
         this.onChanged();
         return this;
      }

      public SplitDeliveryData.Builder setIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.id_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDownloadSize() {
         return (this.bitField0_ & 2) != 0;
      }

      public long getDownloadSize() {
         return this.downloadSize_;
      }

      public SplitDeliveryData.Builder setDownloadSize(long value) {
         this.bitField0_ |= 2;
         this.downloadSize_ = value;
         this.onChanged();
         return this;
      }

      public SplitDeliveryData.Builder clearDownloadSize() {
         this.bitField0_ &= -3;
         this.downloadSize_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasGzippedDownloadSize() {
         return (this.bitField0_ & 4) != 0;
      }

      public long getGzippedDownloadSize() {
         return this.gzippedDownloadSize_;
      }

      public SplitDeliveryData.Builder setGzippedDownloadSize(long value) {
         this.bitField0_ |= 4;
         this.gzippedDownloadSize_ = value;
         this.onChanged();
         return this;
      }

      public SplitDeliveryData.Builder clearGzippedDownloadSize() {
         this.bitField0_ &= -5;
         this.gzippedDownloadSize_ = 0L;
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

      public SplitDeliveryData.Builder setDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public SplitDeliveryData.Builder clearDownloadUrl() {
         this.bitField0_ &= -9;
         this.downloadUrl_ = SplitDeliveryData.getDefaultInstance().getDownloadUrl();
         this.onChanged();
         return this;
      }

      public SplitDeliveryData.Builder setDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasGzippedDownloadUrl() {
         return (this.bitField0_ & 16) != 0;
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

      public SplitDeliveryData.Builder setGzippedDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.gzippedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public SplitDeliveryData.Builder clearGzippedDownloadUrl() {
         this.bitField0_ &= -17;
         this.gzippedDownloadUrl_ = SplitDeliveryData.getDefaultInstance().getGzippedDownloadUrl();
         this.onChanged();
         return this;
      }

      public SplitDeliveryData.Builder setGzippedDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.gzippedDownloadUrl_ = value;
            this.onChanged();
            return this;
         }
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

      public SplitDeliveryData.Builder setPatchData(AndroidAppPatchData value) {
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

      public SplitDeliveryData.Builder setPatchData(AndroidAppPatchData.Builder builderForValue) {
         if (this.patchDataBuilder_ == null) {
            this.patchData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.patchDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public SplitDeliveryData.Builder mergePatchData(AndroidAppPatchData value) {
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

      public SplitDeliveryData.Builder clearPatchData() {
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

      public final SplitDeliveryData.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (SplitDeliveryData.Builder)super.setUnknownFields(unknownFields);
      }

      public final SplitDeliveryData.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (SplitDeliveryData.Builder)super.mergeUnknownFields(unknownFields);
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
