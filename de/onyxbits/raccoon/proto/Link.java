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

public final class Link extends GeneratedMessageV3 implements LinkOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int URI_FIELD_NUMBER = 1;
   private volatile Object uri_;
   private byte memoizedIsInitialized;
   private static final Link DEFAULT_INSTANCE = new Link();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Link parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Link(input, extensionRegistry);
      }
   };

   private Link(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Link() {
      this.memoizedIsInitialized = -1;
      this.uri_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Link();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Link(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 10:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.uri_ = bs;
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
      return Mothership.internal_static_Link_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Link_fieldAccessorTable.ensureFieldAccessorsInitialized(Link.class, Link.Builder.class);
   }

   public boolean hasUri() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getUri() {
      Object ref = this.uri_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.uri_ = s;
         }

         return s;
      }
   }

   public ByteString getUriBytes() {
      Object ref = this.uri_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.uri_ = b;
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
         GeneratedMessageV3.writeString(output, 1, this.uri_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.uri_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Link)) {
         return super.equals(obj);
      } else {
         Link other = (Link)obj;
         if (this.hasUri() != other.hasUri()) {
            return false;
         } else if (this.hasUri() && !this.getUri().equals(other.getUri())) {
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
         if (this.hasUri()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getUri().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Link parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data);
   }

   public static Link parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Link parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data);
   }

   public static Link parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Link parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data);
   }

   public static Link parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Link parseFrom(InputStream input) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Link parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Link parseDelimitedFrom(InputStream input) throws IOException {
      return (Link)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Link parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Link)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Link parseFrom(CodedInputStream input) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Link parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Link.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Link.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Link.Builder newBuilder(Link prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Link.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Link.Builder() : (new Link.Builder()).mergeFrom(this);
   }

   protected Link.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Link.Builder builder = new Link.Builder(parent);
      return builder;
   }

   public static Link getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Link getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Link(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Link(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements LinkOrBuilder {
      private int bitField0_;
      private Object uri_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Link_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Link_fieldAccessorTable.ensureFieldAccessorsInitialized(Link.class, Link.Builder.class);
      }

      private Builder() {
         this.uri_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.uri_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Link.alwaysUseFieldBuilders) {
         }

      }

      public Link.Builder clear() {
         super.clear();
         this.uri_ = "";
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Link_descriptor;
      }

      public Link getDefaultInstanceForType() {
         return Link.getDefaultInstance();
      }

      public Link build() {
         Link result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Link buildPartial() {
         Link result = new Link(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.uri_ = this.uri_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Link.Builder clone() {
         return (Link.Builder)super.clone();
      }

      public Link.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Link.Builder)super.setField(field, value);
      }

      public Link.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Link.Builder)super.clearField(field);
      }

      public Link.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Link.Builder)super.clearOneof(oneof);
      }

      public Link.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Link.Builder)super.setRepeatedField(field, index, value);
      }

      public Link.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Link.Builder)super.addRepeatedField(field, value);
      }

      public Link.Builder mergeFrom(Message other) {
         if (other instanceof Link) {
            return this.mergeFrom((Link)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Link.Builder mergeFrom(Link other) {
         if (other == Link.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasUri()) {
               this.bitField0_ |= 1;
               this.uri_ = other.uri_;
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

      public Link.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Link parsedMessage = null;

         try {
            parsedMessage = (Link)Link.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Link)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasUri() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getUri() {
         Object ref = this.uri_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.uri_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUriBytes() {
         Object ref = this.uri_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.uri_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Link.Builder setUri(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.uri_ = value;
            this.onChanged();
            return this;
         }
      }

      public Link.Builder clearUri() {
         this.bitField0_ &= -2;
         this.uri_ = Link.getDefaultInstance().getUri();
         this.onChanged();
         return this;
      }

      public Link.Builder setUriBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.uri_ = value;
            this.onChanged();
            return this;
         }
      }

      public final Link.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Link.Builder)super.setUnknownFields(unknownFields);
      }

      public final Link.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Link.Builder)super.mergeUnknownFields(unknownFields);
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
