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

public final class PreFetchData extends GeneratedMessageV3 implements PreFetchDataOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PREFETCHURI_FIELD_NUMBER = 1;
   private PreFetchUri preFetchUri_;
   private byte memoizedIsInitialized;
   private static final PreFetchData DEFAULT_INSTANCE = new PreFetchData();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public PreFetchData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new PreFetchData(input, extensionRegistry);
      }
   };

   private PreFetchData(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private PreFetchData() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new PreFetchData();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private PreFetchData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  PreFetchUri.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.preFetchUri_.toBuilder();
                  }

                  this.preFetchUri_ = (PreFetchUri)input.readMessage(PreFetchUri.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.preFetchUri_);
                     this.preFetchUri_ = subBuilder.buildPartial();
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
      return Mothership.internal_static_PreFetchData_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_PreFetchData_fieldAccessorTable.ensureFieldAccessorsInitialized(PreFetchData.class, PreFetchData.Builder.class);
   }

   public boolean hasPreFetchUri() {
      return (this.bitField0_ & 1) != 0;
   }

   public PreFetchUri getPreFetchUri() {
      return this.preFetchUri_ == null ? PreFetchUri.getDefaultInstance() : this.preFetchUri_;
   }

   public PreFetchUriOrBuilder getPreFetchUriOrBuilder() {
      return this.preFetchUri_ == null ? PreFetchUri.getDefaultInstance() : this.preFetchUri_;
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
         output.writeMessage(1, this.getPreFetchUri());
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
            size += CodedOutputStream.computeMessageSize(1, this.getPreFetchUri());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof PreFetchData)) {
         return super.equals(obj);
      } else {
         PreFetchData other = (PreFetchData)obj;
         if (this.hasPreFetchUri() != other.hasPreFetchUri()) {
            return false;
         } else if (this.hasPreFetchUri() && !this.getPreFetchUri().equals(other.getPreFetchUri())) {
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
         if (this.hasPreFetchUri()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPreFetchUri().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static PreFetchData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data);
   }

   public static PreFetchData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetchData parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data);
   }

   public static PreFetchData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetchData parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data);
   }

   public static PreFetchData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (PreFetchData)PARSER.parseFrom(data, extensionRegistry);
   }

   public static PreFetchData parseFrom(InputStream input) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static PreFetchData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static PreFetchData parseDelimitedFrom(InputStream input) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static PreFetchData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static PreFetchData parseFrom(CodedInputStream input) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static PreFetchData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (PreFetchData)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public PreFetchData.Builder newBuilderForType() {
      return newBuilder();
   }

   public static PreFetchData.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static PreFetchData.Builder newBuilder(PreFetchData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public PreFetchData.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new PreFetchData.Builder() : (new PreFetchData.Builder()).mergeFrom(this);
   }

   protected PreFetchData.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      PreFetchData.Builder builder = new PreFetchData.Builder(parent);
      return builder;
   }

   public static PreFetchData getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public PreFetchData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   PreFetchData(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   PreFetchData(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements PreFetchDataOrBuilder {
      private int bitField0_;
      private PreFetchUri preFetchUri_;
      private SingleFieldBuilderV3 preFetchUriBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_PreFetchData_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_PreFetchData_fieldAccessorTable.ensureFieldAccessorsInitialized(PreFetchData.class, PreFetchData.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (PreFetchData.alwaysUseFieldBuilders) {
            this.getPreFetchUriFieldBuilder();
         }

      }

      public PreFetchData.Builder clear() {
         super.clear();
         if (this.preFetchUriBuilder_ == null) {
            this.preFetchUri_ = null;
         } else {
            this.preFetchUriBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_PreFetchData_descriptor;
      }

      public PreFetchData getDefaultInstanceForType() {
         return PreFetchData.getDefaultInstance();
      }

      public PreFetchData build() {
         PreFetchData result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public PreFetchData buildPartial() {
         PreFetchData result = new PreFetchData(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.preFetchUriBuilder_ == null) {
               result.preFetchUri_ = this.preFetchUri_;
            } else {
               result.preFetchUri_ = (PreFetchUri)this.preFetchUriBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public PreFetchData.Builder clone() {
         return (PreFetchData.Builder)super.clone();
      }

      public PreFetchData.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (PreFetchData.Builder)super.setField(field, value);
      }

      public PreFetchData.Builder clearField(Descriptors.FieldDescriptor field) {
         return (PreFetchData.Builder)super.clearField(field);
      }

      public PreFetchData.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (PreFetchData.Builder)super.clearOneof(oneof);
      }

      public PreFetchData.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (PreFetchData.Builder)super.setRepeatedField(field, index, value);
      }

      public PreFetchData.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (PreFetchData.Builder)super.addRepeatedField(field, value);
      }

      public PreFetchData.Builder mergeFrom(Message other) {
         if (other instanceof PreFetchData) {
            return this.mergeFrom((PreFetchData)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public PreFetchData.Builder mergeFrom(PreFetchData other) {
         if (other == PreFetchData.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPreFetchUri()) {
               this.mergePreFetchUri(other.getPreFetchUri());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public PreFetchData.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         PreFetchData parsedMessage = null;

         try {
            parsedMessage = (PreFetchData)PreFetchData.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (PreFetchData)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasPreFetchUri() {
         return (this.bitField0_ & 1) != 0;
      }

      public PreFetchUri getPreFetchUri() {
         if (this.preFetchUriBuilder_ == null) {
            return this.preFetchUri_ == null ? PreFetchUri.getDefaultInstance() : this.preFetchUri_;
         } else {
            return (PreFetchUri)this.preFetchUriBuilder_.getMessage();
         }
      }

      public PreFetchData.Builder setPreFetchUri(PreFetchUri value) {
         if (this.preFetchUriBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.preFetchUri_ = value;
            this.onChanged();
         } else {
            this.preFetchUriBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public PreFetchData.Builder setPreFetchUri(PreFetchUri.Builder builderForValue) {
         if (this.preFetchUriBuilder_ == null) {
            this.preFetchUri_ = builderForValue.build();
            this.onChanged();
         } else {
            this.preFetchUriBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public PreFetchData.Builder mergePreFetchUri(PreFetchUri value) {
         if (this.preFetchUriBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.preFetchUri_ != null && this.preFetchUri_ != PreFetchUri.getDefaultInstance()) {
               this.preFetchUri_ = PreFetchUri.newBuilder(this.preFetchUri_).mergeFrom(value).buildPartial();
            } else {
               this.preFetchUri_ = value;
            }

            this.onChanged();
         } else {
            this.preFetchUriBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public PreFetchData.Builder clearPreFetchUri() {
         if (this.preFetchUriBuilder_ == null) {
            this.preFetchUri_ = null;
            this.onChanged();
         } else {
            this.preFetchUriBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public PreFetchUri.Builder getPreFetchUriBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (PreFetchUri.Builder)this.getPreFetchUriFieldBuilder().getBuilder();
      }

      public PreFetchUriOrBuilder getPreFetchUriOrBuilder() {
         if (this.preFetchUriBuilder_ != null) {
            return (PreFetchUriOrBuilder)this.preFetchUriBuilder_.getMessageOrBuilder();
         } else {
            return this.preFetchUri_ == null ? PreFetchUri.getDefaultInstance() : this.preFetchUri_;
         }
      }

      private SingleFieldBuilderV3 getPreFetchUriFieldBuilder() {
         if (this.preFetchUriBuilder_ == null) {
            this.preFetchUriBuilder_ = new SingleFieldBuilderV3(this.getPreFetchUri(), this.getParentForChildren(), this.isClean());
            this.preFetchUri_ = null;
         }

         return this.preFetchUriBuilder_;
      }

      public final PreFetchData.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (PreFetchData.Builder)super.setUnknownFields(unknownFields);
      }

      public final PreFetchData.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (PreFetchData.Builder)super.mergeUnknownFields(unknownFields);
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
