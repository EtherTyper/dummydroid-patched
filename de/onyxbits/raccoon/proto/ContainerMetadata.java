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

public final class ContainerMetadata extends GeneratedMessageV3 implements ContainerMetadataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int NEXTPAGEURL_FIELD_NUMBER = 2;
   private volatile Object nextPageUrl_;
   private byte memoizedIsInitialized;
   private static final ContainerMetadata DEFAULT_INSTANCE = new ContainerMetadata();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ContainerMetadata parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ContainerMetadata(input, extensionRegistry);
      }
   };

   private ContainerMetadata(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ContainerMetadata() {
      this.memoizedIsInitialized = -1;
      this.nextPageUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ContainerMetadata();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ContainerMetadata(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 18:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.nextPageUrl_ = bs;
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
      return Mothership.internal_static_ContainerMetadata_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ContainerMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(ContainerMetadata.class, ContainerMetadata.Builder.class);
   }

   public boolean hasNextPageUrl() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getNextPageUrl() {
      Object ref = this.nextPageUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.nextPageUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getNextPageUrlBytes() {
      Object ref = this.nextPageUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.nextPageUrl_ = b;
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
         GeneratedMessageV3.writeString(output, 2, this.nextPageUrl_);
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
            size += GeneratedMessageV3.computeStringSize(2, this.nextPageUrl_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ContainerMetadata)) {
         return super.equals(obj);
      } else {
         ContainerMetadata other = (ContainerMetadata)obj;
         if (this.hasNextPageUrl() != other.hasNextPageUrl()) {
            return false;
         } else if (this.hasNextPageUrl() && !this.getNextPageUrl().equals(other.getNextPageUrl())) {
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
         if (this.hasNextPageUrl()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getNextPageUrl().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ContainerMetadata parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data);
   }

   public static ContainerMetadata parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContainerMetadata parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data);
   }

   public static ContainerMetadata parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContainerMetadata parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data);
   }

   public static ContainerMetadata parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ContainerMetadata)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ContainerMetadata parseFrom(InputStream input) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ContainerMetadata parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ContainerMetadata parseDelimitedFrom(InputStream input) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ContainerMetadata parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ContainerMetadata parseFrom(CodedInputStream input) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ContainerMetadata parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ContainerMetadata)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ContainerMetadata.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ContainerMetadata.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ContainerMetadata.Builder newBuilder(ContainerMetadata prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ContainerMetadata.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ContainerMetadata.Builder() : (new ContainerMetadata.Builder()).mergeFrom(this);
   }

   protected ContainerMetadata.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ContainerMetadata.Builder builder = new ContainerMetadata.Builder(parent);
      return builder;
   }

   public static ContainerMetadata getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ContainerMetadata getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ContainerMetadata(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ContainerMetadata(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ContainerMetadataOrBuilder {
      private int bitField0_;
      private Object nextPageUrl_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ContainerMetadata_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ContainerMetadata_fieldAccessorTable.ensureFieldAccessorsInitialized(ContainerMetadata.class, ContainerMetadata.Builder.class);
      }

      private Builder() {
         this.nextPageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.nextPageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ContainerMetadata.alwaysUseFieldBuilders) {
         }

      }

      public ContainerMetadata.Builder clear() {
         super.clear();
         this.nextPageUrl_ = "";
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ContainerMetadata_descriptor;
      }

      public ContainerMetadata getDefaultInstanceForType() {
         return ContainerMetadata.getDefaultInstance();
      }

      public ContainerMetadata build() {
         ContainerMetadata result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ContainerMetadata buildPartial() {
         ContainerMetadata result = new ContainerMetadata(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.nextPageUrl_ = this.nextPageUrl_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ContainerMetadata.Builder clone() {
         return (ContainerMetadata.Builder)super.clone();
      }

      public ContainerMetadata.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ContainerMetadata.Builder)super.setField(field, value);
      }

      public ContainerMetadata.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ContainerMetadata.Builder)super.clearField(field);
      }

      public ContainerMetadata.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ContainerMetadata.Builder)super.clearOneof(oneof);
      }

      public ContainerMetadata.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ContainerMetadata.Builder)super.setRepeatedField(field, index, value);
      }

      public ContainerMetadata.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ContainerMetadata.Builder)super.addRepeatedField(field, value);
      }

      public ContainerMetadata.Builder mergeFrom(Message other) {
         if (other instanceof ContainerMetadata) {
            return this.mergeFrom((ContainerMetadata)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ContainerMetadata.Builder mergeFrom(ContainerMetadata other) {
         if (other == ContainerMetadata.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasNextPageUrl()) {
               this.bitField0_ |= 1;
               this.nextPageUrl_ = other.nextPageUrl_;
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

      public ContainerMetadata.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ContainerMetadata parsedMessage = null;

         try {
            parsedMessage = (ContainerMetadata)ContainerMetadata.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ContainerMetadata)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasNextPageUrl() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getNextPageUrl() {
         Object ref = this.nextPageUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.nextPageUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getNextPageUrlBytes() {
         Object ref = this.nextPageUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.nextPageUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ContainerMetadata.Builder setNextPageUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.nextPageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public ContainerMetadata.Builder clearNextPageUrl() {
         this.bitField0_ &= -2;
         this.nextPageUrl_ = ContainerMetadata.getDefaultInstance().getNextPageUrl();
         this.onChanged();
         return this;
      }

      public ContainerMetadata.Builder setNextPageUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.nextPageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public final ContainerMetadata.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ContainerMetadata.Builder)super.setUnknownFields(unknownFields);
      }

      public final ContainerMetadata.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ContainerMetadata.Builder)super.mergeUnknownFields(unknownFields);
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
