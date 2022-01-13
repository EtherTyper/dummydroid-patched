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

public final class HttpCookie extends GeneratedMessageV3 implements HttpCookieOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int VALUE_FIELD_NUMBER = 2;
   private volatile Object value_;
   private byte memoizedIsInitialized;
   private static final HttpCookie DEFAULT_INSTANCE = new HttpCookie();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public HttpCookie parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new HttpCookie(input, extensionRegistry);
      }
   };

   private HttpCookie(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private HttpCookie() {
      this.memoizedIsInitialized = -1;
      this.name_ = "";
      this.value_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new HttpCookie();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private HttpCookie(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.name_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.value_ = bs;
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
      return Mothership.internal_static_HttpCookie_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_HttpCookie_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpCookie.class, HttpCookie.Builder.class);
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getName() {
      Object ref = this.name_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.name_ = s;
         }

         return s;
      }
   }

   public ByteString getNameBytes() {
      Object ref = this.name_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.name_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasValue() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getValue() {
      Object ref = this.value_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.value_ = s;
         }

         return s;
      }
   }

   public ByteString getValueBytes() {
      Object ref = this.value_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.value_ = b;
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
         GeneratedMessageV3.writeString(output, 1, this.name_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.value_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.name_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.value_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof HttpCookie)) {
         return super.equals(obj);
      } else {
         HttpCookie other = (HttpCookie)obj;
         if (this.hasName() != other.hasName()) {
            return false;
         } else if (this.hasName() && !this.getName().equals(other.getName())) {
            return false;
         } else if (this.hasValue() != other.hasValue()) {
            return false;
         } else if (this.hasValue() && !this.getValue().equals(other.getValue())) {
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
         if (this.hasName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getName().hashCode();
         }

         if (this.hasValue()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getValue().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static HttpCookie parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data);
   }

   public static HttpCookie parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data, extensionRegistry);
   }

   public static HttpCookie parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data);
   }

   public static HttpCookie parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data, extensionRegistry);
   }

   public static HttpCookie parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data);
   }

   public static HttpCookie parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (HttpCookie)PARSER.parseFrom(data, extensionRegistry);
   }

   public static HttpCookie parseFrom(InputStream input) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static HttpCookie parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static HttpCookie parseDelimitedFrom(InputStream input) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static HttpCookie parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static HttpCookie parseFrom(CodedInputStream input) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static HttpCookie parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (HttpCookie)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public HttpCookie.Builder newBuilderForType() {
      return newBuilder();
   }

   public static HttpCookie.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static HttpCookie.Builder newBuilder(HttpCookie prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public HttpCookie.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new HttpCookie.Builder() : (new HttpCookie.Builder()).mergeFrom(this);
   }

   protected HttpCookie.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      HttpCookie.Builder builder = new HttpCookie.Builder(parent);
      return builder;
   }

   public static HttpCookie getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public HttpCookie getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   HttpCookie(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   HttpCookie(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements HttpCookieOrBuilder {
      private int bitField0_;
      private Object name_;
      private Object value_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_HttpCookie_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_HttpCookie_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpCookie.class, HttpCookie.Builder.class);
      }

      private Builder() {
         this.name_ = "";
         this.value_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.name_ = "";
         this.value_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (HttpCookie.alwaysUseFieldBuilders) {
         }

      }

      public HttpCookie.Builder clear() {
         super.clear();
         this.name_ = "";
         this.bitField0_ &= -2;
         this.value_ = "";
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_HttpCookie_descriptor;
      }

      public HttpCookie getDefaultInstanceForType() {
         return HttpCookie.getDefaultInstance();
      }

      public HttpCookie build() {
         HttpCookie result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public HttpCookie buildPartial() {
         HttpCookie result = new HttpCookie(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.name_ = this.name_;
         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.value_ = this.value_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public HttpCookie.Builder clone() {
         return (HttpCookie.Builder)super.clone();
      }

      public HttpCookie.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (HttpCookie.Builder)super.setField(field, value);
      }

      public HttpCookie.Builder clearField(Descriptors.FieldDescriptor field) {
         return (HttpCookie.Builder)super.clearField(field);
      }

      public HttpCookie.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (HttpCookie.Builder)super.clearOneof(oneof);
      }

      public HttpCookie.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (HttpCookie.Builder)super.setRepeatedField(field, index, value);
      }

      public HttpCookie.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (HttpCookie.Builder)super.addRepeatedField(field, value);
      }

      public HttpCookie.Builder mergeFrom(Message other) {
         if (other instanceof HttpCookie) {
            return this.mergeFrom((HttpCookie)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public HttpCookie.Builder mergeFrom(HttpCookie other) {
         if (other == HttpCookie.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasName()) {
               this.bitField0_ |= 1;
               this.name_ = other.name_;
               this.onChanged();
            }

            if (other.hasValue()) {
               this.bitField0_ |= 2;
               this.value_ = other.value_;
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

      public HttpCookie.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         HttpCookie parsedMessage = null;

         try {
            parsedMessage = (HttpCookie)HttpCookie.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (HttpCookie)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getName() {
         Object ref = this.name_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.name_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getNameBytes() {
         Object ref = this.name_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.name_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public HttpCookie.Builder setName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.name_ = value;
            this.onChanged();
            return this;
         }
      }

      public HttpCookie.Builder clearName() {
         this.bitField0_ &= -2;
         this.name_ = HttpCookie.getDefaultInstance().getName();
         this.onChanged();
         return this;
      }

      public HttpCookie.Builder setNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.name_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasValue() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getValue() {
         Object ref = this.value_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.value_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getValueBytes() {
         Object ref = this.value_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.value_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public HttpCookie.Builder setValue(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.value_ = value;
            this.onChanged();
            return this;
         }
      }

      public HttpCookie.Builder clearValue() {
         this.bitField0_ &= -3;
         this.value_ = HttpCookie.getDefaultInstance().getValue();
         this.onChanged();
         return this;
      }

      public HttpCookie.Builder setValueBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.value_ = value;
            this.onChanged();
            return this;
         }
      }

      public final HttpCookie.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (HttpCookie.Builder)super.setUnknownFields(unknownFields);
      }

      public final HttpCookie.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (HttpCookie.Builder)super.mergeUnknownFields(unknownFields);
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
