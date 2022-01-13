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

public final class AndroidCheckinResponse extends GeneratedMessageV3 implements AndroidCheckinResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int STATSOK_FIELD_NUMBER = 1;
   private boolean statsOk_;
   public static final int TIMEMSEC_FIELD_NUMBER = 3;
   private long timeMsec_;
   public static final int GSFID_FIELD_NUMBER = 7;
   private long gsfId_;
   public static final int SECURITYTOKEN_FIELD_NUMBER = 8;
   private long securityToken_;
   public static final int DEVICECHECKINCONSISTENCYTOKEN_FIELD_NUMBER = 12;
   private volatile Object deviceCheckinConsistencyToken_;
   private byte memoizedIsInitialized;
   private static final AndroidCheckinResponse DEFAULT_INSTANCE = new AndroidCheckinResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidCheckinResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidCheckinResponse(input, extensionRegistry);
      }
   };

   private AndroidCheckinResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidCheckinResponse() {
      this.memoizedIsInitialized = -1;
      this.deviceCheckinConsistencyToken_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidCheckinResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidCheckinResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.statsOk_ = input.readBool();
                  break;
               case 24:
                  this.bitField0_ |= 2;
                  this.timeMsec_ = input.readInt64();
                  break;
               case 57:
                  this.bitField0_ |= 4;
                  this.gsfId_ = input.readFixed64();
                  break;
               case 65:
                  this.bitField0_ |= 8;
                  this.securityToken_ = input.readFixed64();
                  break;
               case 98:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.deviceCheckinConsistencyToken_ = bs;
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
      return Mothership.internal_static_AndroidCheckinResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidCheckinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinResponse.class, AndroidCheckinResponse.Builder.class);
   }

   public boolean hasStatsOk() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getStatsOk() {
      return this.statsOk_;
   }

   public boolean hasTimeMsec() {
      return (this.bitField0_ & 2) != 0;
   }

   public long getTimeMsec() {
      return this.timeMsec_;
   }

   public boolean hasGsfId() {
      return (this.bitField0_ & 4) != 0;
   }

   public long getGsfId() {
      return this.gsfId_;
   }

   public boolean hasSecurityToken() {
      return (this.bitField0_ & 8) != 0;
   }

   public long getSecurityToken() {
      return this.securityToken_;
   }

   public boolean hasDeviceCheckinConsistencyToken() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getDeviceCheckinConsistencyToken() {
      Object ref = this.deviceCheckinConsistencyToken_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.deviceCheckinConsistencyToken_ = s;
         }

         return s;
      }
   }

   public ByteString getDeviceCheckinConsistencyTokenBytes() {
      Object ref = this.deviceCheckinConsistencyToken_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.deviceCheckinConsistencyToken_ = b;
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
         output.writeBool(1, this.statsOk_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt64(3, this.timeMsec_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeFixed64(7, this.gsfId_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeFixed64(8, this.securityToken_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 12, this.deviceCheckinConsistencyToken_);
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
            size += CodedOutputStream.computeBoolSize(1, this.statsOk_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt64Size(3, this.timeMsec_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeFixed64Size(7, this.gsfId_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeFixed64Size(8, this.securityToken_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(12, this.deviceCheckinConsistencyToken_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidCheckinResponse)) {
         return super.equals(obj);
      } else {
         AndroidCheckinResponse other = (AndroidCheckinResponse)obj;
         if (this.hasStatsOk() != other.hasStatsOk()) {
            return false;
         } else if (this.hasStatsOk() && this.getStatsOk() != other.getStatsOk()) {
            return false;
         } else if (this.hasTimeMsec() != other.hasTimeMsec()) {
            return false;
         } else if (this.hasTimeMsec() && this.getTimeMsec() != other.getTimeMsec()) {
            return false;
         } else if (this.hasGsfId() != other.hasGsfId()) {
            return false;
         } else if (this.hasGsfId() && this.getGsfId() != other.getGsfId()) {
            return false;
         } else if (this.hasSecurityToken() != other.hasSecurityToken()) {
            return false;
         } else if (this.hasSecurityToken() && this.getSecurityToken() != other.getSecurityToken()) {
            return false;
         } else if (this.hasDeviceCheckinConsistencyToken() != other.hasDeviceCheckinConsistencyToken()) {
            return false;
         } else if (this.hasDeviceCheckinConsistencyToken() && !this.getDeviceCheckinConsistencyToken().equals(other.getDeviceCheckinConsistencyToken())) {
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
         if (this.hasStatsOk()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getStatsOk());
         }

         if (this.hasTimeMsec()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getTimeMsec());
         }

         if (this.hasGsfId()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + Internal.hashLong(this.getGsfId());
         }

         if (this.hasSecurityToken()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + Internal.hashLong(this.getSecurityToken());
         }

         if (this.hasDeviceCheckinConsistencyToken()) {
            hash = 37 * hash + 12;
            hash = 53 * hash + this.getDeviceCheckinConsistencyToken().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidCheckinResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data);
   }

   public static AndroidCheckinResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data);
   }

   public static AndroidCheckinResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data);
   }

   public static AndroidCheckinResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinResponse parseFrom(InputStream input) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidCheckinResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinResponse parseFrom(CodedInputStream input) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidCheckinResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidCheckinResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidCheckinResponse.Builder newBuilder(AndroidCheckinResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidCheckinResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidCheckinResponse.Builder() : (new AndroidCheckinResponse.Builder()).mergeFrom(this);
   }

   protected AndroidCheckinResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidCheckinResponse.Builder builder = new AndroidCheckinResponse.Builder(parent);
      return builder;
   }

   public static AndroidCheckinResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidCheckinResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidCheckinResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidCheckinResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidCheckinResponseOrBuilder {
      private int bitField0_;
      private boolean statsOk_;
      private long timeMsec_;
      private long gsfId_;
      private long securityToken_;
      private Object deviceCheckinConsistencyToken_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidCheckinResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidCheckinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinResponse.class, AndroidCheckinResponse.Builder.class);
      }

      private Builder() {
         this.deviceCheckinConsistencyToken_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.deviceCheckinConsistencyToken_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidCheckinResponse.alwaysUseFieldBuilders) {
         }

      }

      public AndroidCheckinResponse.Builder clear() {
         super.clear();
         this.statsOk_ = false;
         this.bitField0_ &= -2;
         this.timeMsec_ = 0L;
         this.bitField0_ &= -3;
         this.gsfId_ = 0L;
         this.bitField0_ &= -5;
         this.securityToken_ = 0L;
         this.bitField0_ &= -9;
         this.deviceCheckinConsistencyToken_ = "";
         this.bitField0_ &= -17;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidCheckinResponse_descriptor;
      }

      public AndroidCheckinResponse getDefaultInstanceForType() {
         return AndroidCheckinResponse.getDefaultInstance();
      }

      public AndroidCheckinResponse build() {
         AndroidCheckinResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidCheckinResponse buildPartial() {
         AndroidCheckinResponse result = new AndroidCheckinResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.statsOk_ = this.statsOk_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.timeMsec_ = this.timeMsec_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.gsfId_ = this.gsfId_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.securityToken_ = this.securityToken_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.deviceCheckinConsistencyToken_ = this.deviceCheckinConsistencyToken_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidCheckinResponse.Builder clone() {
         return (AndroidCheckinResponse.Builder)super.clone();
      }

      public AndroidCheckinResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinResponse.Builder)super.setField(field, value);
      }

      public AndroidCheckinResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidCheckinResponse.Builder)super.clearField(field);
      }

      public AndroidCheckinResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidCheckinResponse.Builder)super.clearOneof(oneof);
      }

      public AndroidCheckinResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidCheckinResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidCheckinResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinResponse.Builder)super.addRepeatedField(field, value);
      }

      public AndroidCheckinResponse.Builder mergeFrom(Message other) {
         if (other instanceof AndroidCheckinResponse) {
            return this.mergeFrom((AndroidCheckinResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidCheckinResponse.Builder mergeFrom(AndroidCheckinResponse other) {
         if (other == AndroidCheckinResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasStatsOk()) {
               this.setStatsOk(other.getStatsOk());
            }

            if (other.hasTimeMsec()) {
               this.setTimeMsec(other.getTimeMsec());
            }

            if (other.hasGsfId()) {
               this.setGsfId(other.getGsfId());
            }

            if (other.hasSecurityToken()) {
               this.setSecurityToken(other.getSecurityToken());
            }

            if (other.hasDeviceCheckinConsistencyToken()) {
               this.bitField0_ |= 16;
               this.deviceCheckinConsistencyToken_ = other.deviceCheckinConsistencyToken_;
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

      public AndroidCheckinResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidCheckinResponse parsedMessage = null;

         try {
            parsedMessage = (AndroidCheckinResponse)AndroidCheckinResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidCheckinResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasStatsOk() {
         return (this.bitField0_ & 1) != 0;
      }

      public boolean getStatsOk() {
         return this.statsOk_;
      }

      public AndroidCheckinResponse.Builder setStatsOk(boolean value) {
         this.bitField0_ |= 1;
         this.statsOk_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinResponse.Builder clearStatsOk() {
         this.bitField0_ &= -2;
         this.statsOk_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasTimeMsec() {
         return (this.bitField0_ & 2) != 0;
      }

      public long getTimeMsec() {
         return this.timeMsec_;
      }

      public AndroidCheckinResponse.Builder setTimeMsec(long value) {
         this.bitField0_ |= 2;
         this.timeMsec_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinResponse.Builder clearTimeMsec() {
         this.bitField0_ &= -3;
         this.timeMsec_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasGsfId() {
         return (this.bitField0_ & 4) != 0;
      }

      public long getGsfId() {
         return this.gsfId_;
      }

      public AndroidCheckinResponse.Builder setGsfId(long value) {
         this.bitField0_ |= 4;
         this.gsfId_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinResponse.Builder clearGsfId() {
         this.bitField0_ &= -5;
         this.gsfId_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasSecurityToken() {
         return (this.bitField0_ & 8) != 0;
      }

      public long getSecurityToken() {
         return this.securityToken_;
      }

      public AndroidCheckinResponse.Builder setSecurityToken(long value) {
         this.bitField0_ |= 8;
         this.securityToken_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinResponse.Builder clearSecurityToken() {
         this.bitField0_ &= -9;
         this.securityToken_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasDeviceCheckinConsistencyToken() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getDeviceCheckinConsistencyToken() {
         Object ref = this.deviceCheckinConsistencyToken_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.deviceCheckinConsistencyToken_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeviceCheckinConsistencyTokenBytes() {
         Object ref = this.deviceCheckinConsistencyToken_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.deviceCheckinConsistencyToken_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinResponse.Builder setDeviceCheckinConsistencyToken(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.deviceCheckinConsistencyToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinResponse.Builder clearDeviceCheckinConsistencyToken() {
         this.bitField0_ &= -17;
         this.deviceCheckinConsistencyToken_ = AndroidCheckinResponse.getDefaultInstance().getDeviceCheckinConsistencyToken();
         this.onChanged();
         return this;
      }

      public AndroidCheckinResponse.Builder setDeviceCheckinConsistencyTokenBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.deviceCheckinConsistencyToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AndroidCheckinResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidCheckinResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinResponse.Builder)super.mergeUnknownFields(unknownFields);
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
