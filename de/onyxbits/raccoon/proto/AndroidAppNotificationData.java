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

public final class AndroidAppNotificationData extends GeneratedMessageV3 implements AndroidAppNotificationDataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int VERSIONCODE_FIELD_NUMBER = 1;
   private int versionCode_;
   public static final int ASSETID_FIELD_NUMBER = 2;
   private volatile Object assetId_;
   public static final int INSTALLREFERRER_FIELD_NUMBER = 3;
   private volatile Object installReferrer_;
   private byte memoizedIsInitialized;
   private static final AndroidAppNotificationData DEFAULT_INSTANCE = new AndroidAppNotificationData();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidAppNotificationData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidAppNotificationData(input, extensionRegistry);
      }
   };

   private AndroidAppNotificationData(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidAppNotificationData() {
      this.memoizedIsInitialized = -1;
      this.assetId_ = "";
      this.installReferrer_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidAppNotificationData();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidAppNotificationData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.versionCode_ = input.readInt32();
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.assetId_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.installReferrer_ = bs;
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
      return Mothership.internal_static_AndroidAppNotificationData_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidAppNotificationData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppNotificationData.class, AndroidAppNotificationData.Builder.class);
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getVersionCode() {
      return this.versionCode_;
   }

   public boolean hasAssetId() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getAssetId() {
      Object ref = this.assetId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.assetId_ = s;
         }

         return s;
      }
   }

   public ByteString getAssetIdBytes() {
      Object ref = this.assetId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.assetId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasInstallReferrer() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getInstallReferrer() {
      Object ref = this.installReferrer_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.installReferrer_ = s;
         }

         return s;
      }
   }

   public ByteString getInstallReferrerBytes() {
      Object ref = this.installReferrer_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.installReferrer_ = b;
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
         output.writeInt32(1, this.versionCode_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.assetId_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.installReferrer_);
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
            size += CodedOutputStream.computeInt32Size(1, this.versionCode_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.assetId_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.installReferrer_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidAppNotificationData)) {
         return super.equals(obj);
      } else {
         AndroidAppNotificationData other = (AndroidAppNotificationData)obj;
         if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && this.getVersionCode() != other.getVersionCode()) {
            return false;
         } else if (this.hasAssetId() != other.hasAssetId()) {
            return false;
         } else if (this.hasAssetId() && !this.getAssetId().equals(other.getAssetId())) {
            return false;
         } else if (this.hasInstallReferrer() != other.hasInstallReferrer()) {
            return false;
         } else if (this.hasInstallReferrer() && !this.getInstallReferrer().equals(other.getInstallReferrer())) {
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
         if (this.hasVersionCode()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getVersionCode();
         }

         if (this.hasAssetId()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getAssetId().hashCode();
         }

         if (this.hasInstallReferrer()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getInstallReferrer().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidAppNotificationData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data);
   }

   public static AndroidAppNotificationData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppNotificationData parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data);
   }

   public static AndroidAppNotificationData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppNotificationData parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data);
   }

   public static AndroidAppNotificationData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidAppNotificationData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidAppNotificationData parseFrom(InputStream input) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppNotificationData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppNotificationData parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidAppNotificationData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidAppNotificationData parseFrom(CodedInputStream input) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidAppNotificationData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidAppNotificationData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidAppNotificationData.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidAppNotificationData.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidAppNotificationData.Builder newBuilder(AndroidAppNotificationData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidAppNotificationData.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidAppNotificationData.Builder() : (new AndroidAppNotificationData.Builder()).mergeFrom(this);
   }

   protected AndroidAppNotificationData.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidAppNotificationData.Builder builder = new AndroidAppNotificationData.Builder(parent);
      return builder;
   }

   public static AndroidAppNotificationData getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidAppNotificationData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidAppNotificationData(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidAppNotificationData(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidAppNotificationDataOrBuilder {
      private int bitField0_;
      private int versionCode_;
      private Object assetId_;
      private Object installReferrer_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidAppNotificationData_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidAppNotificationData_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidAppNotificationData.class, AndroidAppNotificationData.Builder.class);
      }

      private Builder() {
         this.assetId_ = "";
         this.installReferrer_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.assetId_ = "";
         this.installReferrer_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidAppNotificationData.alwaysUseFieldBuilders) {
         }

      }

      public AndroidAppNotificationData.Builder clear() {
         super.clear();
         this.versionCode_ = 0;
         this.bitField0_ &= -2;
         this.assetId_ = "";
         this.bitField0_ &= -3;
         this.installReferrer_ = "";
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidAppNotificationData_descriptor;
      }

      public AndroidAppNotificationData getDefaultInstanceForType() {
         return AndroidAppNotificationData.getDefaultInstance();
      }

      public AndroidAppNotificationData build() {
         AndroidAppNotificationData result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidAppNotificationData buildPartial() {
         AndroidAppNotificationData result = new AndroidAppNotificationData(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.versionCode_ = this.versionCode_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.assetId_ = this.assetId_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.installReferrer_ = this.installReferrer_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidAppNotificationData.Builder clone() {
         return (AndroidAppNotificationData.Builder)super.clone();
      }

      public AndroidAppNotificationData.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppNotificationData.Builder)super.setField(field, value);
      }

      public AndroidAppNotificationData.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidAppNotificationData.Builder)super.clearField(field);
      }

      public AndroidAppNotificationData.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidAppNotificationData.Builder)super.clearOneof(oneof);
      }

      public AndroidAppNotificationData.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidAppNotificationData.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidAppNotificationData.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidAppNotificationData.Builder)super.addRepeatedField(field, value);
      }

      public AndroidAppNotificationData.Builder mergeFrom(Message other) {
         if (other instanceof AndroidAppNotificationData) {
            return this.mergeFrom((AndroidAppNotificationData)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidAppNotificationData.Builder mergeFrom(AndroidAppNotificationData other) {
         if (other == AndroidAppNotificationData.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasVersionCode()) {
               this.setVersionCode(other.getVersionCode());
            }

            if (other.hasAssetId()) {
               this.bitField0_ |= 2;
               this.assetId_ = other.assetId_;
               this.onChanged();
            }

            if (other.hasInstallReferrer()) {
               this.bitField0_ |= 4;
               this.installReferrer_ = other.installReferrer_;
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

      public AndroidAppNotificationData.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidAppNotificationData parsedMessage = null;

         try {
            parsedMessage = (AndroidAppNotificationData)AndroidAppNotificationData.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidAppNotificationData)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getVersionCode() {
         return this.versionCode_;
      }

      public AndroidAppNotificationData.Builder setVersionCode(int value) {
         this.bitField0_ |= 1;
         this.versionCode_ = value;
         this.onChanged();
         return this;
      }

      public AndroidAppNotificationData.Builder clearVersionCode() {
         this.bitField0_ &= -2;
         this.versionCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasAssetId() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getAssetId() {
         Object ref = this.assetId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.assetId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getAssetIdBytes() {
         Object ref = this.assetId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.assetId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidAppNotificationData.Builder setAssetId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.assetId_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidAppNotificationData.Builder clearAssetId() {
         this.bitField0_ &= -3;
         this.assetId_ = AndroidAppNotificationData.getDefaultInstance().getAssetId();
         this.onChanged();
         return this;
      }

      public AndroidAppNotificationData.Builder setAssetIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.assetId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasInstallReferrer() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getInstallReferrer() {
         Object ref = this.installReferrer_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.installReferrer_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getInstallReferrerBytes() {
         Object ref = this.installReferrer_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.installReferrer_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidAppNotificationData.Builder setInstallReferrer(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.installReferrer_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidAppNotificationData.Builder clearInstallReferrer() {
         this.bitField0_ &= -5;
         this.installReferrer_ = AndroidAppNotificationData.getDefaultInstance().getInstallReferrer();
         this.onChanged();
         return this;
      }

      public AndroidAppNotificationData.Builder setInstallReferrerBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.installReferrer_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AndroidAppNotificationData.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppNotificationData.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidAppNotificationData.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidAppNotificationData.Builder)super.mergeUnknownFields(unknownFields);
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
