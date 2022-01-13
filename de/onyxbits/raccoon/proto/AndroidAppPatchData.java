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

public final class AndroidAppPatchData extends GeneratedMessageV3 implements AndroidAppPatchDataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int BASEVERSIONCODE_FIELD_NUMBER = 1;
   private int baseVersionCode_;
   public static final int DOWNLOADURL_FIELD_NUMBER = 3;
   private volatile Object downloadUrl_;
   public static final int PATCHFORMAT_FIELD_NUMBER = 4;
   private int patchFormat_;
   private byte memoizedIsInitialized;
   private static final AndroidAppPatchData DEFAULT_INSTANCE = new AndroidAppPatchData();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidAppPatchData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidAppPatchData(input, extensionRegistry);
      }
   };

   private AndroidAppPatchData(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidAppPatchData() {
      this.memoizedIsInitialized = -1;
      this.downloadUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidAppPatchData();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidAppPatchData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.baseVersionCode_ = input.readInt32();
                  break;
               case 26:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.downloadUrl_ = bs;
                  break;
               case 32:
                  this.bitField0_ |= 4;
                  this.patchFormat_ = input.readInt32();
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
      return Mothership.internal_static_AndroidAppPatchData_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidAppPatchData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppPatchData.class, AndroidAppPatchData.Builder.class);
   }

   public boolean hasBaseVersionCode() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getBaseVersionCode() {
      return this.baseVersionCode_;
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

   public boolean hasPatchFormat() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getPatchFormat() {
      return this.patchFormat_;
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
         output.writeInt32(1, this.baseVersionCode_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.downloadUrl_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(4, this.patchFormat_);
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
            size += CodedOutputStream.computeInt32Size(1, this.baseVersionCode_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.downloadUrl_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.patchFormat_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidAppPatchData)) {
         return super.equals(obj);
      } else {
         AndroidAppPatchData other = (AndroidAppPatchData)obj;
         if (this.hasBaseVersionCode() != other.hasBaseVersionCode()) {
            return false;
         } else if (this.hasBaseVersionCode() && this.getBaseVersionCode() != other.getBaseVersionCode()) {
            return false;
         } else if (this.hasDownloadUrl() != other.hasDownloadUrl()) {
            return false;
         } else if (this.hasDownloadUrl() && !this.getDownloadUrl().equals(other.getDownloadUrl())) {
            return false;
         } else if (this.hasPatchFormat() != other.hasPatchFormat()) {
            return false;
         } else if (this.hasPatchFormat() && this.getPatchFormat() != other.getPatchFormat()) {
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
         if (this.hasBaseVersionCode()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getBaseVersionCode();
         }

         if (this.hasDownloadUrl()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDownloadUrl().hashCode();
         }

         if (this.hasPatchFormat()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getPatchFormat();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidAppPatchData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data);
   }

   public static AndroidAppPatchData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppPatchData parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data);
   }

   public static AndroidAppPatchData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppPatchData parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data);
   }

   public static AndroidAppPatchData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppPatchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppPatchData parseFrom(InputStream input) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppPatchData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppPatchData parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidAppPatchData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppPatchData parseFrom(CodedInputStream input) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppPatchData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppPatchData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidAppPatchData.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidAppPatchData.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidAppPatchData.Builder newBuilder(AndroidAppPatchData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidAppPatchData.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidAppPatchData.Builder() : (new AndroidAppPatchData.Builder()).mergeFrom(this);
   }

   protected AndroidAppPatchData.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidAppPatchData.Builder builder = new AndroidAppPatchData.Builder(parent);
      return builder;
   }

   public static AndroidAppPatchData getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidAppPatchData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidAppPatchData(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidAppPatchData(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidAppPatchDataOrBuilder {
      private int bitField0_;
      private int baseVersionCode_;
      private Object downloadUrl_;
      private int patchFormat_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidAppPatchData_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidAppPatchData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppPatchData.class, AndroidAppPatchData.Builder.class);
      }

      private Builder() {
         this.downloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.downloadUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidAppPatchData.alwaysUseFieldBuilders) {
         }

      }

      public AndroidAppPatchData.Builder clear() {
         super.clear();
         this.baseVersionCode_ = 0;
         this.bitField0_ &= -2;
         this.downloadUrl_ = "";
         this.bitField0_ &= -3;
         this.patchFormat_ = 0;
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidAppPatchData_descriptor;
      }

      public AndroidAppPatchData getDefaultInstanceForType() {
         return AndroidAppPatchData.getDefaultInstance();
      }

      public AndroidAppPatchData build() {
         AndroidAppPatchData result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidAppPatchData buildPartial() {
         AndroidAppPatchData result = new AndroidAppPatchData(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.baseVersionCode_ = this.baseVersionCode_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.downloadUrl_ = this.downloadUrl_;
         if ((from_bitField0_ & 4) != 0) {
            result.patchFormat_ = this.patchFormat_;
            to_bitField0_ |= 4;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidAppPatchData.Builder clone() {
         return (AndroidAppPatchData.Builder)super.clone();
      }

      public AndroidAppPatchData.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppPatchData.Builder)super.setField(field, value);
      }

      public AndroidAppPatchData.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidAppPatchData.Builder)super.clearField(field);
      }

      public AndroidAppPatchData.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidAppPatchData.Builder)super.clearOneof(oneof);
      }

      public AndroidAppPatchData.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidAppPatchData.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidAppPatchData.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppPatchData.Builder)super.addRepeatedField(field, value);
      }

      public AndroidAppPatchData.Builder mergeFrom(Message other) {
         if (other instanceof AndroidAppPatchData) {
            return this.mergeFrom((AndroidAppPatchData)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidAppPatchData.Builder mergeFrom(AndroidAppPatchData other) {
         if (other == AndroidAppPatchData.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasBaseVersionCode()) {
               this.setBaseVersionCode(other.getBaseVersionCode());
            }

            if (other.hasDownloadUrl()) {
               this.bitField0_ |= 2;
               this.downloadUrl_ = other.downloadUrl_;
               this.onChanged();
            }

            if (other.hasPatchFormat()) {
               this.setPatchFormat(other.getPatchFormat());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public AndroidAppPatchData.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidAppPatchData parsedMessage = null;

         try {
            parsedMessage = (AndroidAppPatchData)AndroidAppPatchData.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidAppPatchData)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasBaseVersionCode() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getBaseVersionCode() {
         return this.baseVersionCode_;
      }

      public AndroidAppPatchData.Builder setBaseVersionCode(int value) {
         this.bitField0_ |= 1;
         this.baseVersionCode_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppPatchData.Builder clearBaseVersionCode() {
         this.bitField0_ &= -2;
         this.baseVersionCode_ = 0;
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

      public AndroidAppPatchData.Builder setDownloadUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidAppPatchData.Builder clearDownloadUrl() {
         this.bitField0_ &= -3;
         this.downloadUrl_ = AndroidAppPatchData.getDefaultInstance().getDownloadUrl();
         this.onChanged();
         return this;
      }

      public AndroidAppPatchData.Builder setDownloadUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.downloadUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasPatchFormat() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getPatchFormat() {
         return this.patchFormat_;
      }

      public AndroidAppPatchData.Builder setPatchFormat(int value) {
         this.bitField0_ |= 4;
         this.patchFormat_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppPatchData.Builder clearPatchFormat() {
         this.bitField0_ &= -5;
         this.patchFormat_ = 0;
         this.onChanged();
         return this;
      }

      public final AndroidAppPatchData.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppPatchData.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidAppPatchData.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppPatchData.Builder)super.mergeUnknownFields(unknownFields);
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
