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

public final class TocResponse extends GeneratedMessageV3 implements TocResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int TOSVERSIONDEPRECATED_FIELD_NUMBER = 2;
   private int tosVersionDeprecated_;
   public static final int TOSCONTENT_FIELD_NUMBER = 3;
   private volatile Object tosContent_;
   public static final int TOSCHECKBOXTEXTMARKETINGEMAILS_FIELD_NUMBER = 6;
   private volatile Object tosCheckboxTextMarketingEmails_;
   public static final int TOSTOKEN_FIELD_NUMBER = 7;
   private volatile Object tosToken_;
   public static final int SELFUPDATECONFIG_FIELD_NUMBER = 10;
   private SelfUpdateConfig selfUpdateConfig_;
   public static final int REQUIRESUPLOADDEVICECONFIG_FIELD_NUMBER = 11;
   private boolean requiresUploadDeviceConfig_;
   public static final int COOKIE_FIELD_NUMBER = 22;
   private volatile Object cookie_;
   private byte memoizedIsInitialized;
   private static final TocResponse DEFAULT_INSTANCE = new TocResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public TocResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new TocResponse(input, extensionRegistry);
      }
   };

   private TocResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private TocResponse() {
      this.memoizedIsInitialized = -1;
      this.tosContent_ = "";
      this.tosCheckboxTextMarketingEmails_ = "";
      this.tosToken_ = "";
      this.cookie_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new TocResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private TocResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 16:
                  this.bitField0_ |= 1;
                  this.tosVersionDeprecated_ = input.readInt32();
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.tosContent_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.tosCheckboxTextMarketingEmails_ = bs;
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.tosToken_ = bs;
                  break;
               case 82:
                  SelfUpdateConfig.Builder subBuilder = null;
                  if ((this.bitField0_ & 16) != 0) {
                     subBuilder = this.selfUpdateConfig_.toBuilder();
                  }

                  this.selfUpdateConfig_ = (SelfUpdateConfig)input.readMessage(SelfUpdateConfig.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.selfUpdateConfig_);
                     this.selfUpdateConfig_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 16;
                  break;
               case 88:
                  this.bitField0_ |= 32;
                  this.requiresUploadDeviceConfig_ = input.readBool();
                  break;
               case 178:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.cookie_ = bs;
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
      return Mothership.internal_static_TocResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_TocResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TocResponse.class, TocResponse.Builder.class);
   }

   public boolean hasTosVersionDeprecated() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getTosVersionDeprecated() {
      return this.tosVersionDeprecated_;
   }

   public boolean hasTosContent() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getTosContent() {
      Object ref = this.tosContent_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.tosContent_ = s;
         }

         return s;
      }
   }

   public ByteString getTosContentBytes() {
      Object ref = this.tosContent_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.tosContent_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTosCheckboxTextMarketingEmails() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getTosCheckboxTextMarketingEmails() {
      Object ref = this.tosCheckboxTextMarketingEmails_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.tosCheckboxTextMarketingEmails_ = s;
         }

         return s;
      }
   }

   public ByteString getTosCheckboxTextMarketingEmailsBytes() {
      Object ref = this.tosCheckboxTextMarketingEmails_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.tosCheckboxTextMarketingEmails_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTosToken() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getTosToken() {
      Object ref = this.tosToken_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.tosToken_ = s;
         }

         return s;
      }
   }

   public ByteString getTosTokenBytes() {
      Object ref = this.tosToken_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.tosToken_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSelfUpdateConfig() {
      return (this.bitField0_ & 16) != 0;
   }

   public SelfUpdateConfig getSelfUpdateConfig() {
      return this.selfUpdateConfig_ == null ? SelfUpdateConfig.getDefaultInstance() : this.selfUpdateConfig_;
   }

   public SelfUpdateConfigOrBuilder getSelfUpdateConfigOrBuilder() {
      return this.selfUpdateConfig_ == null ? SelfUpdateConfig.getDefaultInstance() : this.selfUpdateConfig_;
   }

   public boolean hasRequiresUploadDeviceConfig() {
      return (this.bitField0_ & 32) != 0;
   }

   public boolean getRequiresUploadDeviceConfig() {
      return this.requiresUploadDeviceConfig_;
   }

   public boolean hasCookie() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getCookie() {
      Object ref = this.cookie_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.cookie_ = s;
         }

         return s;
      }
   }

   public ByteString getCookieBytes() {
      Object ref = this.cookie_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.cookie_ = b;
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
         output.writeInt32(2, this.tosVersionDeprecated_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.tosContent_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.tosCheckboxTextMarketingEmails_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.tosToken_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeMessage(10, this.getSelfUpdateConfig());
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeBool(11, this.requiresUploadDeviceConfig_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 22, this.cookie_);
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
            size += CodedOutputStream.computeInt32Size(2, this.tosVersionDeprecated_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.tosContent_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.tosCheckboxTextMarketingEmails_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.tosToken_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeMessageSize(10, this.getSelfUpdateConfig());
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeBoolSize(11, this.requiresUploadDeviceConfig_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(22, this.cookie_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof TocResponse)) {
         return super.equals(obj);
      } else {
         TocResponse other = (TocResponse)obj;
         if (this.hasTosVersionDeprecated() != other.hasTosVersionDeprecated()) {
            return false;
         } else if (this.hasTosVersionDeprecated() && this.getTosVersionDeprecated() != other.getTosVersionDeprecated()) {
            return false;
         } else if (this.hasTosContent() != other.hasTosContent()) {
            return false;
         } else if (this.hasTosContent() && !this.getTosContent().equals(other.getTosContent())) {
            return false;
         } else if (this.hasTosCheckboxTextMarketingEmails() != other.hasTosCheckboxTextMarketingEmails()) {
            return false;
         } else if (this.hasTosCheckboxTextMarketingEmails() && !this.getTosCheckboxTextMarketingEmails().equals(other.getTosCheckboxTextMarketingEmails())) {
            return false;
         } else if (this.hasTosToken() != other.hasTosToken()) {
            return false;
         } else if (this.hasTosToken() && !this.getTosToken().equals(other.getTosToken())) {
            return false;
         } else if (this.hasSelfUpdateConfig() != other.hasSelfUpdateConfig()) {
            return false;
         } else if (this.hasSelfUpdateConfig() && !this.getSelfUpdateConfig().equals(other.getSelfUpdateConfig())) {
            return false;
         } else if (this.hasRequiresUploadDeviceConfig() != other.hasRequiresUploadDeviceConfig()) {
            return false;
         } else if (this.hasRequiresUploadDeviceConfig() && this.getRequiresUploadDeviceConfig() != other.getRequiresUploadDeviceConfig()) {
            return false;
         } else if (this.hasCookie() != other.hasCookie()) {
            return false;
         } else if (this.hasCookie() && !this.getCookie().equals(other.getCookie())) {
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
         if (this.hasTosVersionDeprecated()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getTosVersionDeprecated();
         }

         if (this.hasTosContent()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getTosContent().hashCode();
         }

         if (this.hasTosCheckboxTextMarketingEmails()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getTosCheckboxTextMarketingEmails().hashCode();
         }

         if (this.hasTosToken()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getTosToken().hashCode();
         }

         if (this.hasSelfUpdateConfig()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getSelfUpdateConfig().hashCode();
         }

         if (this.hasRequiresUploadDeviceConfig()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + Internal.hashBoolean(this.getRequiresUploadDeviceConfig());
         }

         if (this.hasCookie()) {
            hash = 37 * hash + 22;
            hash = 53 * hash + this.getCookie().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static TocResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data);
   }

   public static TocResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TocResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data);
   }

   public static TocResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TocResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data);
   }

   public static TocResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TocResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TocResponse parseFrom(InputStream input) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TocResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static TocResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static TocResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static TocResponse parseFrom(CodedInputStream input) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TocResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TocResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public TocResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static TocResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static TocResponse.Builder newBuilder(TocResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public TocResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new TocResponse.Builder() : (new TocResponse.Builder()).mergeFrom(this);
   }

   protected TocResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      TocResponse.Builder builder = new TocResponse.Builder(parent);
      return builder;
   }

   public static TocResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public TocResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   TocResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   TocResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements TocResponseOrBuilder {
      private int bitField0_;
      private int tosVersionDeprecated_;
      private Object tosContent_;
      private Object tosCheckboxTextMarketingEmails_;
      private Object tosToken_;
      private SelfUpdateConfig selfUpdateConfig_;
      private SingleFieldBuilderV3 selfUpdateConfigBuilder_;
      private boolean requiresUploadDeviceConfig_;
      private Object cookie_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_TocResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_TocResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TocResponse.class, TocResponse.Builder.class);
      }

      private Builder() {
         this.tosContent_ = "";
         this.tosCheckboxTextMarketingEmails_ = "";
         this.tosToken_ = "";
         this.cookie_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.tosContent_ = "";
         this.tosCheckboxTextMarketingEmails_ = "";
         this.tosToken_ = "";
         this.cookie_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (TocResponse.alwaysUseFieldBuilders) {
            this.getSelfUpdateConfigFieldBuilder();
         }

      }

      public TocResponse.Builder clear() {
         super.clear();
         this.tosVersionDeprecated_ = 0;
         this.bitField0_ &= -2;
         this.tosContent_ = "";
         this.bitField0_ &= -3;
         this.tosCheckboxTextMarketingEmails_ = "";
         this.bitField0_ &= -5;
         this.tosToken_ = "";
         this.bitField0_ &= -9;
         if (this.selfUpdateConfigBuilder_ == null) {
            this.selfUpdateConfig_ = null;
         } else {
            this.selfUpdateConfigBuilder_.clear();
         }

         this.bitField0_ &= -17;
         this.requiresUploadDeviceConfig_ = false;
         this.bitField0_ &= -33;
         this.cookie_ = "";
         this.bitField0_ &= -65;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_TocResponse_descriptor;
      }

      public TocResponse getDefaultInstanceForType() {
         return TocResponse.getDefaultInstance();
      }

      public TocResponse build() {
         TocResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public TocResponse buildPartial() {
         TocResponse result = new TocResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.tosVersionDeprecated_ = this.tosVersionDeprecated_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.tosContent_ = this.tosContent_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.tosCheckboxTextMarketingEmails_ = this.tosCheckboxTextMarketingEmails_;
         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.tosToken_ = this.tosToken_;
         if ((from_bitField0_ & 16) != 0) {
            if (this.selfUpdateConfigBuilder_ == null) {
               result.selfUpdateConfig_ = this.selfUpdateConfig_;
            } else {
               result.selfUpdateConfig_ = (SelfUpdateConfig)this.selfUpdateConfigBuilder_.build();
            }

            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.requiresUploadDeviceConfig_ = this.requiresUploadDeviceConfig_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 64;
         }

         result.cookie_ = this.cookie_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public TocResponse.Builder clone() {
         return (TocResponse.Builder)super.clone();
      }

      public TocResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (TocResponse.Builder)super.setField(field, value);
      }

      public TocResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (TocResponse.Builder)super.clearField(field);
      }

      public TocResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (TocResponse.Builder)super.clearOneof(oneof);
      }

      public TocResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (TocResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public TocResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (TocResponse.Builder)super.addRepeatedField(field, value);
      }

      public TocResponse.Builder mergeFrom(Message other) {
         if (other instanceof TocResponse) {
            return this.mergeFrom((TocResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public TocResponse.Builder mergeFrom(TocResponse other) {
         if (other == TocResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasTosVersionDeprecated()) {
               this.setTosVersionDeprecated(other.getTosVersionDeprecated());
            }

            if (other.hasTosContent()) {
               this.bitField0_ |= 2;
               this.tosContent_ = other.tosContent_;
               this.onChanged();
            }

            if (other.hasTosCheckboxTextMarketingEmails()) {
               this.bitField0_ |= 4;
               this.tosCheckboxTextMarketingEmails_ = other.tosCheckboxTextMarketingEmails_;
               this.onChanged();
            }

            if (other.hasTosToken()) {
               this.bitField0_ |= 8;
               this.tosToken_ = other.tosToken_;
               this.onChanged();
            }

            if (other.hasSelfUpdateConfig()) {
               this.mergeSelfUpdateConfig(other.getSelfUpdateConfig());
            }

            if (other.hasRequiresUploadDeviceConfig()) {
               this.setRequiresUploadDeviceConfig(other.getRequiresUploadDeviceConfig());
            }

            if (other.hasCookie()) {
               this.bitField0_ |= 64;
               this.cookie_ = other.cookie_;
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

      public TocResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         TocResponse parsedMessage = null;

         try {
            parsedMessage = (TocResponse)TocResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (TocResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasTosVersionDeprecated() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getTosVersionDeprecated() {
         return this.tosVersionDeprecated_;
      }

      public TocResponse.Builder setTosVersionDeprecated(int value) {
         this.bitField0_ |= 1;
         this.tosVersionDeprecated_ = value;
         this.onChanged();
         return this;
      }

      public TocResponse.Builder clearTosVersionDeprecated() {
         this.bitField0_ &= -2;
         this.tosVersionDeprecated_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasTosContent() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getTosContent() {
         Object ref = this.tosContent_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.tosContent_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTosContentBytes() {
         Object ref = this.tosContent_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.tosContent_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TocResponse.Builder setTosContent(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.tosContent_ = value;
            this.onChanged();
            return this;
         }
      }

      public TocResponse.Builder clearTosContent() {
         this.bitField0_ &= -3;
         this.tosContent_ = TocResponse.getDefaultInstance().getTosContent();
         this.onChanged();
         return this;
      }

      public TocResponse.Builder setTosContentBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.tosContent_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTosCheckboxTextMarketingEmails() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getTosCheckboxTextMarketingEmails() {
         Object ref = this.tosCheckboxTextMarketingEmails_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.tosCheckboxTextMarketingEmails_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTosCheckboxTextMarketingEmailsBytes() {
         Object ref = this.tosCheckboxTextMarketingEmails_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.tosCheckboxTextMarketingEmails_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TocResponse.Builder setTosCheckboxTextMarketingEmails(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.tosCheckboxTextMarketingEmails_ = value;
            this.onChanged();
            return this;
         }
      }

      public TocResponse.Builder clearTosCheckboxTextMarketingEmails() {
         this.bitField0_ &= -5;
         this.tosCheckboxTextMarketingEmails_ = TocResponse.getDefaultInstance().getTosCheckboxTextMarketingEmails();
         this.onChanged();
         return this;
      }

      public TocResponse.Builder setTosCheckboxTextMarketingEmailsBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.tosCheckboxTextMarketingEmails_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTosToken() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getTosToken() {
         Object ref = this.tosToken_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.tosToken_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTosTokenBytes() {
         Object ref = this.tosToken_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.tosToken_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TocResponse.Builder setTosToken(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.tosToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public TocResponse.Builder clearTosToken() {
         this.bitField0_ &= -9;
         this.tosToken_ = TocResponse.getDefaultInstance().getTosToken();
         this.onChanged();
         return this;
      }

      public TocResponse.Builder setTosTokenBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.tosToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSelfUpdateConfig() {
         return (this.bitField0_ & 16) != 0;
      }

      public SelfUpdateConfig getSelfUpdateConfig() {
         if (this.selfUpdateConfigBuilder_ == null) {
            return this.selfUpdateConfig_ == null ? SelfUpdateConfig.getDefaultInstance() : this.selfUpdateConfig_;
         } else {
            return (SelfUpdateConfig)this.selfUpdateConfigBuilder_.getMessage();
         }
      }

      public TocResponse.Builder setSelfUpdateConfig(SelfUpdateConfig value) {
         if (this.selfUpdateConfigBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.selfUpdateConfig_ = value;
            this.onChanged();
         } else {
            this.selfUpdateConfigBuilder_.setMessage(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public TocResponse.Builder setSelfUpdateConfig(SelfUpdateConfig.Builder builderForValue) {
         if (this.selfUpdateConfigBuilder_ == null) {
            this.selfUpdateConfig_ = builderForValue.build();
            this.onChanged();
         } else {
            this.selfUpdateConfigBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 16;
         return this;
      }

      public TocResponse.Builder mergeSelfUpdateConfig(SelfUpdateConfig value) {
         if (this.selfUpdateConfigBuilder_ == null) {
            if ((this.bitField0_ & 16) != 0 && this.selfUpdateConfig_ != null && this.selfUpdateConfig_ != SelfUpdateConfig.getDefaultInstance()) {
               this.selfUpdateConfig_ = SelfUpdateConfig.newBuilder(this.selfUpdateConfig_).mergeFrom(value).buildPartial();
            } else {
               this.selfUpdateConfig_ = value;
            }

            this.onChanged();
         } else {
            this.selfUpdateConfigBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public TocResponse.Builder clearSelfUpdateConfig() {
         if (this.selfUpdateConfigBuilder_ == null) {
            this.selfUpdateConfig_ = null;
            this.onChanged();
         } else {
            this.selfUpdateConfigBuilder_.clear();
         }

         this.bitField0_ &= -17;
         return this;
      }

      public SelfUpdateConfig.Builder getSelfUpdateConfigBuilder() {
         this.bitField0_ |= 16;
         this.onChanged();
         return (SelfUpdateConfig.Builder)this.getSelfUpdateConfigFieldBuilder().getBuilder();
      }

      public SelfUpdateConfigOrBuilder getSelfUpdateConfigOrBuilder() {
         if (this.selfUpdateConfigBuilder_ != null) {
            return (SelfUpdateConfigOrBuilder)this.selfUpdateConfigBuilder_.getMessageOrBuilder();
         } else {
            return this.selfUpdateConfig_ == null ? SelfUpdateConfig.getDefaultInstance() : this.selfUpdateConfig_;
         }
      }

      private SingleFieldBuilderV3 getSelfUpdateConfigFieldBuilder() {
         if (this.selfUpdateConfigBuilder_ == null) {
            this.selfUpdateConfigBuilder_ = new SingleFieldBuilderV3(this.getSelfUpdateConfig(), this.getParentForChildren(), this.isClean());
            this.selfUpdateConfig_ = null;
         }

         return this.selfUpdateConfigBuilder_;
      }

      public boolean hasRequiresUploadDeviceConfig() {
         return (this.bitField0_ & 32) != 0;
      }

      public boolean getRequiresUploadDeviceConfig() {
         return this.requiresUploadDeviceConfig_;
      }

      public TocResponse.Builder setRequiresUploadDeviceConfig(boolean value) {
         this.bitField0_ |= 32;
         this.requiresUploadDeviceConfig_ = value;
         this.onChanged();
         return this;
      }

      public TocResponse.Builder clearRequiresUploadDeviceConfig() {
         this.bitField0_ &= -33;
         this.requiresUploadDeviceConfig_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasCookie() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getCookie() {
         Object ref = this.cookie_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.cookie_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCookieBytes() {
         Object ref = this.cookie_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.cookie_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TocResponse.Builder setCookie(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.cookie_ = value;
            this.onChanged();
            return this;
         }
      }

      public TocResponse.Builder clearCookie() {
         this.bitField0_ &= -65;
         this.cookie_ = TocResponse.getDefaultInstance().getCookie();
         this.onChanged();
         return this;
      }

      public TocResponse.Builder setCookieBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.cookie_ = value;
            this.onChanged();
            return this;
         }
      }

      public final TocResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (TocResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final TocResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (TocResponse.Builder)super.mergeUnknownFields(unknownFields);
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
