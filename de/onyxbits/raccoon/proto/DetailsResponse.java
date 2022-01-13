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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DetailsResponse extends GeneratedMessageV3 implements DetailsResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOCV2_FIELD_NUMBER = 4;
   private DocV2 docV2_;
   private byte memoizedIsInitialized;
   private static final DetailsResponse DEFAULT_INSTANCE = new DetailsResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public DetailsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new DetailsResponse(input, extensionRegistry);
      }
   };

   private DetailsResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private DetailsResponse() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new DetailsResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DetailsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 34:
                  DocV2.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.docV2_.toBuilder();
                  }

                  this.docV2_ = (DocV2)input.readMessage(DocV2.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.docV2_);
                     this.docV2_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
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
      return Mothership.internal_static_DetailsResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_DetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DetailsResponse.class, DetailsResponse.Builder.class);
   }

   public boolean hasDocV2() {
      return (this.bitField0_ & 1) != 0;
   }

   public DocV2 getDocV2() {
      return this.docV2_ == null ? DocV2.getDefaultInstance() : this.docV2_;
   }

   public DocV2OrBuilder getDocV2OrBuilder() {
      return this.docV2_ == null ? DocV2.getDefaultInstance() : this.docV2_;
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
         output.writeMessage(4, this.getDocV2());
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
            size += CodedOutputStream.computeMessageSize(4, this.getDocV2());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DetailsResponse)) {
         return super.equals(obj);
      } else {
         DetailsResponse other = (DetailsResponse)obj;
         if (this.hasDocV2() != other.hasDocV2()) {
            return false;
         } else if (this.hasDocV2() && !this.getDocV2().equals(other.getDocV2())) {
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
         if (this.hasDocV2()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDocV2().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static DetailsResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data);
   }

   public static DetailsResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DetailsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data);
   }

   public static DetailsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DetailsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data);
   }

   public static DetailsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DetailsResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DetailsResponse parseFrom(InputStream input) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DetailsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static DetailsResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static DetailsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static DetailsResponse parseFrom(CodedInputStream input) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DetailsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DetailsResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public DetailsResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static DetailsResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DetailsResponse.Builder newBuilder(DetailsResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public DetailsResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new DetailsResponse.Builder() : (new DetailsResponse.Builder()).mergeFrom(this);
   }

   protected DetailsResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      DetailsResponse.Builder builder = new DetailsResponse.Builder(parent);
      return builder;
   }

   public static DetailsResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DetailsResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DetailsResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   DetailsResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DetailsResponseOrBuilder {
      private int bitField0_;
      private DocV2 docV2_;
      private SingleFieldBuilderV3 docV2Builder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_DetailsResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_DetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DetailsResponse.class, DetailsResponse.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (DetailsResponse.alwaysUseFieldBuilders) {
            this.getDocV2FieldBuilder();
         }

      }

      public DetailsResponse.Builder clear() {
         super.clear();
         if (this.docV2Builder_ == null) {
            this.docV2_ = null;
         } else {
            this.docV2Builder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_DetailsResponse_descriptor;
      }

      public DetailsResponse getDefaultInstanceForType() {
         return DetailsResponse.getDefaultInstance();
      }

      public DetailsResponse build() {
         DetailsResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public DetailsResponse buildPartial() {
         DetailsResponse result = new DetailsResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.docV2Builder_ == null) {
               result.docV2_ = this.docV2_;
            } else {
               result.docV2_ = (DocV2)this.docV2Builder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public DetailsResponse.Builder clone() {
         return (DetailsResponse.Builder)super.clone();
      }

      public DetailsResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (DetailsResponse.Builder)super.setField(field, value);
      }

      public DetailsResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (DetailsResponse.Builder)super.clearField(field);
      }

      public DetailsResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (DetailsResponse.Builder)super.clearOneof(oneof);
      }

      public DetailsResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (DetailsResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public DetailsResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (DetailsResponse.Builder)super.addRepeatedField(field, value);
      }

      public DetailsResponse.Builder mergeFrom(Message other) {
         if (other instanceof DetailsResponse) {
            return this.mergeFrom((DetailsResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public DetailsResponse.Builder mergeFrom(DetailsResponse other) {
         if (other == DetailsResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDocV2()) {
               this.mergeDocV2(other.getDocV2());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public DetailsResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         DetailsResponse parsedMessage = null;

         try {
            parsedMessage = (DetailsResponse)DetailsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (DetailsResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDocV2() {
         return (this.bitField0_ & 1) != 0;
      }

      public DocV2 getDocV2() {
         if (this.docV2Builder_ == null) {
            return this.docV2_ == null ? DocV2.getDefaultInstance() : this.docV2_;
         } else {
            return (DocV2)this.docV2Builder_.getMessage();
         }
      }

      public DetailsResponse.Builder setDocV2(DocV2 value) {
         if (this.docV2Builder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.docV2_ = value;
            this.onChanged();
         } else {
            this.docV2Builder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DetailsResponse.Builder setDocV2(DocV2.Builder builderForValue) {
         if (this.docV2Builder_ == null) {
            this.docV2_ = builderForValue.build();
            this.onChanged();
         } else {
            this.docV2Builder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DetailsResponse.Builder mergeDocV2(DocV2 value) {
         if (this.docV2Builder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.docV2_ != null && this.docV2_ != DocV2.getDefaultInstance()) {
               this.docV2_ = DocV2.newBuilder(this.docV2_).mergeFrom(value).buildPartial();
            } else {
               this.docV2_ = value;
            }

            this.onChanged();
         } else {
            this.docV2Builder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DetailsResponse.Builder clearDocV2() {
         if (this.docV2Builder_ == null) {
            this.docV2_ = null;
            this.onChanged();
         } else {
            this.docV2Builder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public DocV2.Builder getDocV2Builder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (DocV2.Builder)this.getDocV2FieldBuilder().getBuilder();
      }

      public DocV2OrBuilder getDocV2OrBuilder() {
         if (this.docV2Builder_ != null) {
            return (DocV2OrBuilder)this.docV2Builder_.getMessageOrBuilder();
         } else {
            return this.docV2_ == null ? DocV2.getDefaultInstance() : this.docV2_;
         }
      }

      private SingleFieldBuilderV3 getDocV2FieldBuilder() {
         if (this.docV2Builder_ == null) {
            this.docV2Builder_ = new SingleFieldBuilderV3(this.getDocV2(), this.getParentForChildren(), this.isClean());
            this.docV2_ = null;
         }

         return this.docV2Builder_;
      }

      public final DetailsResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (DetailsResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final DetailsResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (DetailsResponse.Builder)super.mergeUnknownFields(unknownFields);
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
