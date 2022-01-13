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

public final class PreFetch extends GeneratedMessageV3 implements PreFetchOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int URL_FIELD_NUMBER = 1;
   private volatile Object url_;
   public static final int RESPONSE_FIELD_NUMBER = 2;
   private ByteString response_;
   public static final int ETAG_FIELD_NUMBER = 3;
   private volatile Object etag_;
   public static final int TTL_FIELD_NUMBER = 4;
   private long ttl_;
   public static final int SOFTTTL_FIELD_NUMBER = 5;
   private long softTtl_;
   public static final int PREFETCHDATA_FIELD_NUMBER = 8;
   private PreFetchData preFetchData_;
   private byte memoizedIsInitialized;
   private static final PreFetch DEFAULT_INSTANCE = new PreFetch();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public PreFetch parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new PreFetch(input, extensionRegistry);
      }
   };

   private PreFetch(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private PreFetch() {
      this.memoizedIsInitialized = -1;
      this.url_ = "";
      this.response_ = ByteString.EMPTY;
      this.etag_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new PreFetch();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private PreFetch(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.url_ = bs;
                  break;
               case 18:
                  this.bitField0_ |= 2;
                  this.response_ = input.readBytes();
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.etag_ = bs;
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.ttl_ = input.readInt64();
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.softTtl_ = input.readInt64();
                  break;
               case 66:
                  PreFetchData.Builder subBuilder = null;
                  if ((this.bitField0_ & 32) != 0) {
                     subBuilder = this.preFetchData_.toBuilder();
                  }

                  this.preFetchData_ = (PreFetchData)input.readMessage(PreFetchData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.preFetchData_);
                     this.preFetchData_ = subBuilder.buildPartial();
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
      return Mothership.internal_static_PreFetch_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_PreFetch_fieldAccessorTable.ensureFieldAccessorsInitialized(PreFetch.class, PreFetch.Builder.class);
   }

   public boolean hasUrl() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getUrl() {
      Object ref = this.url_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.url_ = s;
         }

         return s;
      }
   }

   public ByteString getUrlBytes() {
      Object ref = this.url_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.url_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasResponse() {
      return (this.bitField0_ & 2) != 0;
   }

   public ByteString getResponse() {
      return this.response_;
   }

   public boolean hasEtag() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getEtag() {
      Object ref = this.etag_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.etag_ = s;
         }

         return s;
      }
   }

   public ByteString getEtagBytes() {
      Object ref = this.etag_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.etag_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTtl() {
      return (this.bitField0_ & 8) != 0;
   }

   public long getTtl() {
      return this.ttl_;
   }

   public boolean hasSoftTtl() {
      return (this.bitField0_ & 16) != 0;
   }

   public long getSoftTtl() {
      return this.softTtl_;
   }

   public boolean hasPreFetchData() {
      return (this.bitField0_ & 32) != 0;
   }

   public PreFetchData getPreFetchData() {
      return this.preFetchData_ == null ? PreFetchData.getDefaultInstance() : this.preFetchData_;
   }

   public PreFetchDataOrBuilder getPreFetchDataOrBuilder() {
      return this.preFetchData_ == null ? PreFetchData.getDefaultInstance() : this.preFetchData_;
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
         GeneratedMessageV3.writeString(output, 1, this.url_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBytes(2, this.response_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.etag_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeInt64(4, this.ttl_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeInt64(5, this.softTtl_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeMessage(8, this.getPreFetchData());
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
            size += GeneratedMessageV3.computeStringSize(1, this.url_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBytesSize(2, this.response_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.etag_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeInt64Size(4, this.ttl_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeInt64Size(5, this.softTtl_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeMessageSize(8, this.getPreFetchData());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof PreFetch)) {
         return super.equals(obj);
      } else {
         PreFetch other = (PreFetch)obj;
         if (this.hasUrl() != other.hasUrl()) {
            return false;
         } else if (this.hasUrl() && !this.getUrl().equals(other.getUrl())) {
            return false;
         } else if (this.hasResponse() != other.hasResponse()) {
            return false;
         } else if (this.hasResponse() && !this.getResponse().equals(other.getResponse())) {
            return false;
         } else if (this.hasEtag() != other.hasEtag()) {
            return false;
         } else if (this.hasEtag() && !this.getEtag().equals(other.getEtag())) {
            return false;
         } else if (this.hasTtl() != other.hasTtl()) {
            return false;
         } else if (this.hasTtl() && this.getTtl() != other.getTtl()) {
            return false;
         } else if (this.hasSoftTtl() != other.hasSoftTtl()) {
            return false;
         } else if (this.hasSoftTtl() && this.getSoftTtl() != other.getSoftTtl()) {
            return false;
         } else if (this.hasPreFetchData() != other.hasPreFetchData()) {
            return false;
         } else if (this.hasPreFetchData() && !this.getPreFetchData().equals(other.getPreFetchData())) {
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
         if (this.hasUrl()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getUrl().hashCode();
         }

         if (this.hasResponse()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getResponse().hashCode();
         }

         if (this.hasEtag()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getEtag().hashCode();
         }

         if (this.hasTtl()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + Internal.hashLong(this.getTtl());
         }

         if (this.hasSoftTtl()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashLong(this.getSoftTtl());
         }

         if (this.hasPreFetchData()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getPreFetchData().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static PreFetch parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data);
   }

   public static PreFetch parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetch parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data);
   }

   public static PreFetch parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetch parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data);
   }

   public static PreFetch parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetch)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetch parseFrom(InputStream input) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static PreFetch parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static PreFetch parseDelimitedFrom(InputStream input) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static PreFetch parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static PreFetch parseFrom(CodedInputStream input) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static PreFetch parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetch)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public PreFetch.Builder newBuilderForType() {
      return newBuilder();
   }

   public static PreFetch.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static PreFetch.Builder newBuilder(PreFetch prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public PreFetch.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new PreFetch.Builder() : (new PreFetch.Builder()).mergeFrom(this);
   }

   protected PreFetch.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      PreFetch.Builder builder = new PreFetch.Builder(parent);
      return builder;
   }

   public static PreFetch getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public PreFetch getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   PreFetch(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   PreFetch(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements PreFetchOrBuilder {
      private int bitField0_;
      private Object url_;
      private ByteString response_;
      private Object etag_;
      private long ttl_;
      private long softTtl_;
      private PreFetchData preFetchData_;
      private SingleFieldBuilderV3 preFetchDataBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_PreFetch_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_PreFetch_fieldAccessorTable.ensureFieldAccessorsInitialized(PreFetch.class, PreFetch.Builder.class);
      }

      private Builder() {
         this.url_ = "";
         this.response_ = ByteString.EMPTY;
         this.etag_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.url_ = "";
         this.response_ = ByteString.EMPTY;
         this.etag_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (PreFetch.alwaysUseFieldBuilders) {
            this.getPreFetchDataFieldBuilder();
         }

      }

      public PreFetch.Builder clear() {
         super.clear();
         this.url_ = "";
         this.bitField0_ &= -2;
         this.response_ = ByteString.EMPTY;
         this.bitField0_ &= -3;
         this.etag_ = "";
         this.bitField0_ &= -5;
         this.ttl_ = 0L;
         this.bitField0_ &= -9;
         this.softTtl_ = 0L;
         this.bitField0_ &= -17;
         if (this.preFetchDataBuilder_ == null) {
            this.preFetchData_ = null;
         } else {
            this.preFetchDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_PreFetch_descriptor;
      }

      public PreFetch getDefaultInstanceForType() {
         return PreFetch.getDefaultInstance();
      }

      public PreFetch build() {
         PreFetch result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public PreFetch buildPartial() {
         PreFetch result = new PreFetch(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.url_ = this.url_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.response_ = this.response_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.etag_ = this.etag_;
         if ((from_bitField0_ & 8) != 0) {
            result.ttl_ = this.ttl_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            result.softTtl_ = this.softTtl_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            if (this.preFetchDataBuilder_ == null) {
               result.preFetchData_ = this.preFetchData_;
            } else {
               result.preFetchData_ = (PreFetchData)this.preFetchDataBuilder_.build();
            }

            to_bitField0_ |= 32;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public PreFetch.Builder clone() {
         return (PreFetch.Builder)super.clone();
      }

      public PreFetch.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (PreFetch.Builder)super.setField(field, value);
      }

      public PreFetch.Builder clearField(Descriptors.FieldDescriptor field) {
         return (PreFetch.Builder)super.clearField(field);
      }

      public PreFetch.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (PreFetch.Builder)super.clearOneof(oneof);
      }

      public PreFetch.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (PreFetch.Builder)super.setRepeatedField(field, index, value);
      }

      public PreFetch.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (PreFetch.Builder)super.addRepeatedField(field, value);
      }

      public PreFetch.Builder mergeFrom(Message other) {
         if (other instanceof PreFetch) {
            return this.mergeFrom((PreFetch)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public PreFetch.Builder mergeFrom(PreFetch other) {
         if (other == PreFetch.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasUrl()) {
               this.bitField0_ |= 1;
               this.url_ = other.url_;
               this.onChanged();
            }

            if (other.hasResponse()) {
               this.setResponse(other.getResponse());
            }

            if (other.hasEtag()) {
               this.bitField0_ |= 4;
               this.etag_ = other.etag_;
               this.onChanged();
            }

            if (other.hasTtl()) {
               this.setTtl(other.getTtl());
            }

            if (other.hasSoftTtl()) {
               this.setSoftTtl(other.getSoftTtl());
            }

            if (other.hasPreFetchData()) {
               this.mergePreFetchData(other.getPreFetchData());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public PreFetch.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         PreFetch parsedMessage = null;

         try {
            parsedMessage = (PreFetch)PreFetch.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (PreFetch)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasUrl() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getUrl() {
         Object ref = this.url_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.url_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUrlBytes() {
         Object ref = this.url_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.url_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public PreFetch.Builder setUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.url_ = value;
            this.onChanged();
            return this;
         }
      }

      public PreFetch.Builder clearUrl() {
         this.bitField0_ &= -2;
         this.url_ = PreFetch.getDefaultInstance().getUrl();
         this.onChanged();
         return this;
      }

      public PreFetch.Builder setUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.url_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasResponse() {
         return (this.bitField0_ & 2) != 0;
      }

      public ByteString getResponse() {
         return this.response_;
      }

      public PreFetch.Builder setResponse(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.response_ = value;
            this.onChanged();
            return this;
         }
      }

      public PreFetch.Builder clearResponse() {
         this.bitField0_ &= -3;
         this.response_ = PreFetch.getDefaultInstance().getResponse();
         this.onChanged();
         return this;
      }

      public boolean hasEtag() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getEtag() {
         Object ref = this.etag_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.etag_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getEtagBytes() {
         Object ref = this.etag_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.etag_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public PreFetch.Builder setEtag(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.etag_ = value;
            this.onChanged();
            return this;
         }
      }

      public PreFetch.Builder clearEtag() {
         this.bitField0_ &= -5;
         this.etag_ = PreFetch.getDefaultInstance().getEtag();
         this.onChanged();
         return this;
      }

      public PreFetch.Builder setEtagBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.etag_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTtl() {
         return (this.bitField0_ & 8) != 0;
      }

      public long getTtl() {
         return this.ttl_;
      }

      public PreFetch.Builder setTtl(long value) {
         this.bitField0_ |= 8;
         this.ttl_ = value;
         this.onChanged();
         return this;
      }

      public PreFetch.Builder clearTtl() {
         this.bitField0_ &= -9;
         this.ttl_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasSoftTtl() {
         return (this.bitField0_ & 16) != 0;
      }

      public long getSoftTtl() {
         return this.softTtl_;
      }

      public PreFetch.Builder setSoftTtl(long value) {
         this.bitField0_ |= 16;
         this.softTtl_ = value;
         this.onChanged();
         return this;
      }

      public PreFetch.Builder clearSoftTtl() {
         this.bitField0_ &= -17;
         this.softTtl_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasPreFetchData() {
         return (this.bitField0_ & 32) != 0;
      }

      public PreFetchData getPreFetchData() {
         if (this.preFetchDataBuilder_ == null) {
            return this.preFetchData_ == null ? PreFetchData.getDefaultInstance() : this.preFetchData_;
         } else {
            return (PreFetchData)this.preFetchDataBuilder_.getMessage();
         }
      }

      public PreFetch.Builder setPreFetchData(PreFetchData value) {
         if (this.preFetchDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.preFetchData_ = value;
            this.onChanged();
         } else {
            this.preFetchDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public PreFetch.Builder setPreFetchData(PreFetchData.Builder builderForValue) {
         if (this.preFetchDataBuilder_ == null) {
            this.preFetchData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.preFetchDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public PreFetch.Builder mergePreFetchData(PreFetchData value) {
         if (this.preFetchDataBuilder_ == null) {
            if ((this.bitField0_ & 32) != 0 && this.preFetchData_ != null && this.preFetchData_ != PreFetchData.getDefaultInstance()) {
               this.preFetchData_ = PreFetchData.newBuilder(this.preFetchData_).mergeFrom(value).buildPartial();
            } else {
               this.preFetchData_ = value;
            }

            this.onChanged();
         } else {
            this.preFetchDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public PreFetch.Builder clearPreFetchData() {
         if (this.preFetchDataBuilder_ == null) {
            this.preFetchData_ = null;
            this.onChanged();
         } else {
            this.preFetchDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public PreFetchData.Builder getPreFetchDataBuilder() {
         this.bitField0_ |= 32;
         this.onChanged();
         return (PreFetchData.Builder)this.getPreFetchDataFieldBuilder().getBuilder();
      }

      public PreFetchDataOrBuilder getPreFetchDataOrBuilder() {
         if (this.preFetchDataBuilder_ != null) {
            return (PreFetchDataOrBuilder)this.preFetchDataBuilder_.getMessageOrBuilder();
         } else {
            return this.preFetchData_ == null ? PreFetchData.getDefaultInstance() : this.preFetchData_;
         }
      }

      private SingleFieldBuilderV3 getPreFetchDataFieldBuilder() {
         if (this.preFetchDataBuilder_ == null) {
            this.preFetchDataBuilder_ = new SingleFieldBuilderV3(this.getPreFetchData(), this.getParentForChildren(), this.isClean());
            this.preFetchData_ = null;
         }

         return this.preFetchDataBuilder_;
      }

      public final PreFetch.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (PreFetch.Builder)super.setUnknownFields(unknownFields);
      }

      public final PreFetch.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (PreFetch.Builder)super.mergeUnknownFields(unknownFields);
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
