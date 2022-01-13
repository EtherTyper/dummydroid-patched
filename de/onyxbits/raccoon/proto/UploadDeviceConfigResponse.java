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

public final class UploadDeviceConfigResponse extends GeneratedMessageV3 implements UploadDeviceConfigResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int UPLOADDEVICECONFIGTOKEN_FIELD_NUMBER = 1;
   private volatile Object uploadDeviceConfigToken_;
   private byte memoizedIsInitialized;
   private static final UploadDeviceConfigResponse DEFAULT_INSTANCE = new UploadDeviceConfigResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public UploadDeviceConfigResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new UploadDeviceConfigResponse(input, extensionRegistry);
      }
   };

   private UploadDeviceConfigResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private UploadDeviceConfigResponse() {
      this.memoizedIsInitialized = -1;
      this.uploadDeviceConfigToken_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new UploadDeviceConfigResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private UploadDeviceConfigResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.uploadDeviceConfigToken_ = bs;
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
      return Mothership.internal_static_UploadDeviceConfigResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_UploadDeviceConfigResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UploadDeviceConfigResponse.class, UploadDeviceConfigResponse.Builder.class);
   }

   public boolean hasUploadDeviceConfigToken() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getUploadDeviceConfigToken() {
      Object ref = this.uploadDeviceConfigToken_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.uploadDeviceConfigToken_ = s;
         }

         return s;
      }
   }

   public ByteString getUploadDeviceConfigTokenBytes() {
      Object ref = this.uploadDeviceConfigToken_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.uploadDeviceConfigToken_ = b;
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
         GeneratedMessageV3.writeString(output, 1, this.uploadDeviceConfigToken_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.uploadDeviceConfigToken_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof UploadDeviceConfigResponse)) {
         return super.equals(obj);
      } else {
         UploadDeviceConfigResponse other = (UploadDeviceConfigResponse)obj;
         if (this.hasUploadDeviceConfigToken() != other.hasUploadDeviceConfigToken()) {
            return false;
         } else if (this.hasUploadDeviceConfigToken() && !this.getUploadDeviceConfigToken().equals(other.getUploadDeviceConfigToken())) {
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
         if (this.hasUploadDeviceConfigToken()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getUploadDeviceConfigToken().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static UploadDeviceConfigResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data);
   }

   public static UploadDeviceConfigResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (UploadDeviceConfigResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static UploadDeviceConfigResponse parseFrom(InputStream input) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static UploadDeviceConfigResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static UploadDeviceConfigResponse parseFrom(CodedInputStream input) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static UploadDeviceConfigResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (UploadDeviceConfigResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public UploadDeviceConfigResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static UploadDeviceConfigResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static UploadDeviceConfigResponse.Builder newBuilder(UploadDeviceConfigResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public UploadDeviceConfigResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new UploadDeviceConfigResponse.Builder() : (new UploadDeviceConfigResponse.Builder()).mergeFrom(this);
   }

   protected UploadDeviceConfigResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      UploadDeviceConfigResponse.Builder builder = new UploadDeviceConfigResponse.Builder(parent);
      return builder;
   }

   public static UploadDeviceConfigResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public UploadDeviceConfigResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   UploadDeviceConfigResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   UploadDeviceConfigResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements UploadDeviceConfigResponseOrBuilder {
      private int bitField0_;
      private Object uploadDeviceConfigToken_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_UploadDeviceConfigResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_UploadDeviceConfigResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UploadDeviceConfigResponse.class, UploadDeviceConfigResponse.Builder.class);
      }

      private Builder() {
         this.uploadDeviceConfigToken_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.uploadDeviceConfigToken_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (UploadDeviceConfigResponse.alwaysUseFieldBuilders) {
         }

      }

      public UploadDeviceConfigResponse.Builder clear() {
         super.clear();
         this.uploadDeviceConfigToken_ = "";
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_UploadDeviceConfigResponse_descriptor;
      }

      public UploadDeviceConfigResponse getDefaultInstanceForType() {
         return UploadDeviceConfigResponse.getDefaultInstance();
      }

      public UploadDeviceConfigResponse build() {
         UploadDeviceConfigResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public UploadDeviceConfigResponse buildPartial() {
         UploadDeviceConfigResponse result = new UploadDeviceConfigResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.uploadDeviceConfigToken_ = this.uploadDeviceConfigToken_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public UploadDeviceConfigResponse.Builder clone() {
         return (UploadDeviceConfigResponse.Builder)super.clone();
      }

      public UploadDeviceConfigResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (UploadDeviceConfigResponse.Builder)super.setField(field, value);
      }

      public UploadDeviceConfigResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (UploadDeviceConfigResponse.Builder)super.clearField(field);
      }

      public UploadDeviceConfigResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (UploadDeviceConfigResponse.Builder)super.clearOneof(oneof);
      }

      public UploadDeviceConfigResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (UploadDeviceConfigResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public UploadDeviceConfigResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (UploadDeviceConfigResponse.Builder)super.addRepeatedField(field, value);
      }

      public UploadDeviceConfigResponse.Builder mergeFrom(Message other) {
         if (other instanceof UploadDeviceConfigResponse) {
            return this.mergeFrom((UploadDeviceConfigResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public UploadDeviceConfigResponse.Builder mergeFrom(UploadDeviceConfigResponse other) {
         if (other == UploadDeviceConfigResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasUploadDeviceConfigToken()) {
               this.bitField0_ |= 1;
               this.uploadDeviceConfigToken_ = other.uploadDeviceConfigToken_;
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

      public UploadDeviceConfigResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         UploadDeviceConfigResponse parsedMessage = null;

         try {
            parsedMessage = (UploadDeviceConfigResponse)UploadDeviceConfigResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (UploadDeviceConfigResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasUploadDeviceConfigToken() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getUploadDeviceConfigToken() {
         Object ref = this.uploadDeviceConfigToken_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.uploadDeviceConfigToken_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUploadDeviceConfigTokenBytes() {
         Object ref = this.uploadDeviceConfigToken_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.uploadDeviceConfigToken_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public UploadDeviceConfigResponse.Builder setUploadDeviceConfigToken(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.uploadDeviceConfigToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public UploadDeviceConfigResponse.Builder clearUploadDeviceConfigToken() {
         this.bitField0_ &= -2;
         this.uploadDeviceConfigToken_ = UploadDeviceConfigResponse.getDefaultInstance().getUploadDeviceConfigToken();
         this.onChanged();
         return this;
      }

      public UploadDeviceConfigResponse.Builder setUploadDeviceConfigTokenBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.uploadDeviceConfigToken_ = value;
            this.onChanged();
            return this;
         }
      }

      public final UploadDeviceConfigResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (UploadDeviceConfigResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final UploadDeviceConfigResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (UploadDeviceConfigResponse.Builder)super.mergeUnknownFields(unknownFields);
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
