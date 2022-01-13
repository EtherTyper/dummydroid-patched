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

public final class DocumentDetails extends GeneratedMessageV3 implements DocumentDetailsOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int APPDETAILS_FIELD_NUMBER = 1;
   private AppDetails appDetails_;
   private byte memoizedIsInitialized;
   private static final DocumentDetails DEFAULT_INSTANCE = new DocumentDetails();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public DocumentDetails parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new DocumentDetails(input, extensionRegistry);
      }
   };

   private DocumentDetails(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private DocumentDetails() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new DocumentDetails();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DocumentDetails(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  AppDetails.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.appDetails_.toBuilder();
                  }

                  this.appDetails_ = (AppDetails)input.readMessage(AppDetails.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.appDetails_);
                     this.appDetails_ = subBuilder.buildPartial();
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
      return Mothership.internal_static_DocumentDetails_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_DocumentDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(DocumentDetails.class, DocumentDetails.Builder.class);
   }

   public boolean hasAppDetails() {
      return (this.bitField0_ & 1) != 0;
   }

   public AppDetails getAppDetails() {
      return this.appDetails_ == null ? AppDetails.getDefaultInstance() : this.appDetails_;
   }

   public AppDetailsOrBuilder getAppDetailsOrBuilder() {
      return this.appDetails_ == null ? AppDetails.getDefaultInstance() : this.appDetails_;
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
         output.writeMessage(1, this.getAppDetails());
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
            size += CodedOutputStream.computeMessageSize(1, this.getAppDetails());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DocumentDetails)) {
         return super.equals(obj);
      } else {
         DocumentDetails other = (DocumentDetails)obj;
         if (this.hasAppDetails() != other.hasAppDetails()) {
            return false;
         } else if (this.hasAppDetails() && !this.getAppDetails().equals(other.getAppDetails())) {
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
         if (this.hasAppDetails()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getAppDetails().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static DocumentDetails parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data);
   }

   public static DocumentDetails parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocumentDetails parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data);
   }

   public static DocumentDetails parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocumentDetails parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data);
   }

   public static DocumentDetails parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (DocumentDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static DocumentDetails parseFrom(InputStream input) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DocumentDetails parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static DocumentDetails parseDelimitedFrom(InputStream input) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static DocumentDetails parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static DocumentDetails parseFrom(CodedInputStream input) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static DocumentDetails parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (DocumentDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public DocumentDetails.Builder newBuilderForType() {
      return newBuilder();
   }

   public static DocumentDetails.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DocumentDetails.Builder newBuilder(DocumentDetails prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public DocumentDetails.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new DocumentDetails.Builder() : (new DocumentDetails.Builder()).mergeFrom(this);
   }

   protected DocumentDetails.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      DocumentDetails.Builder builder = new DocumentDetails.Builder(parent);
      return builder;
   }

   public static DocumentDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DocumentDetails getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DocumentDetails(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   DocumentDetails(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DocumentDetailsOrBuilder {
      private int bitField0_;
      private AppDetails appDetails_;
      private SingleFieldBuilderV3 appDetailsBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_DocumentDetails_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_DocumentDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(DocumentDetails.class, DocumentDetails.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (DocumentDetails.alwaysUseFieldBuilders) {
            this.getAppDetailsFieldBuilder();
         }

      }

      public DocumentDetails.Builder clear() {
         super.clear();
         if (this.appDetailsBuilder_ == null) {
            this.appDetails_ = null;
         } else {
            this.appDetailsBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_DocumentDetails_descriptor;
      }

      public DocumentDetails getDefaultInstanceForType() {
         return DocumentDetails.getDefaultInstance();
      }

      public DocumentDetails build() {
         DocumentDetails result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public DocumentDetails buildPartial() {
         DocumentDetails result = new DocumentDetails(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.appDetailsBuilder_ == null) {
               result.appDetails_ = this.appDetails_;
            } else {
               result.appDetails_ = (AppDetails)this.appDetailsBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public DocumentDetails.Builder clone() {
         return (DocumentDetails.Builder)super.clone();
      }

      public DocumentDetails.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (DocumentDetails.Builder)super.setField(field, value);
      }

      public DocumentDetails.Builder clearField(Descriptors.FieldDescriptor field) {
         return (DocumentDetails.Builder)super.clearField(field);
      }

      public DocumentDetails.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (DocumentDetails.Builder)super.clearOneof(oneof);
      }

      public DocumentDetails.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (DocumentDetails.Builder)super.setRepeatedField(field, index, value);
      }

      public DocumentDetails.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (DocumentDetails.Builder)super.addRepeatedField(field, value);
      }

      public DocumentDetails.Builder mergeFrom(Message other) {
         if (other instanceof DocumentDetails) {
            return this.mergeFrom((DocumentDetails)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public DocumentDetails.Builder mergeFrom(DocumentDetails other) {
         if (other == DocumentDetails.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasAppDetails()) {
               this.mergeAppDetails(other.getAppDetails());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public DocumentDetails.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         DocumentDetails parsedMessage = null;

         try {
            parsedMessage = (DocumentDetails)DocumentDetails.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (DocumentDetails)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasAppDetails() {
         return (this.bitField0_ & 1) != 0;
      }

      public AppDetails getAppDetails() {
         if (this.appDetailsBuilder_ == null) {
            return this.appDetails_ == null ? AppDetails.getDefaultInstance() : this.appDetails_;
         } else {
            return (AppDetails)this.appDetailsBuilder_.getMessage();
         }
      }

      public DocumentDetails.Builder setAppDetails(AppDetails value) {
         if (this.appDetailsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.appDetails_ = value;
            this.onChanged();
         } else {
            this.appDetailsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DocumentDetails.Builder setAppDetails(AppDetails.Builder builderForValue) {
         if (this.appDetailsBuilder_ == null) {
            this.appDetails_ = builderForValue.build();
            this.onChanged();
         } else {
            this.appDetailsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DocumentDetails.Builder mergeAppDetails(AppDetails value) {
         if (this.appDetailsBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.appDetails_ != null && this.appDetails_ != AppDetails.getDefaultInstance()) {
               this.appDetails_ = AppDetails.newBuilder(this.appDetails_).mergeFrom(value).buildPartial();
            } else {
               this.appDetails_ = value;
            }

            this.onChanged();
         } else {
            this.appDetailsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public DocumentDetails.Builder clearAppDetails() {
         if (this.appDetailsBuilder_ == null) {
            this.appDetails_ = null;
            this.onChanged();
         } else {
            this.appDetailsBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public AppDetails.Builder getAppDetailsBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (AppDetails.Builder)this.getAppDetailsFieldBuilder().getBuilder();
      }

      public AppDetailsOrBuilder getAppDetailsOrBuilder() {
         if (this.appDetailsBuilder_ != null) {
            return (AppDetailsOrBuilder)this.appDetailsBuilder_.getMessageOrBuilder();
         } else {
            return this.appDetails_ == null ? AppDetails.getDefaultInstance() : this.appDetails_;
         }
      }

      private SingleFieldBuilderV3 getAppDetailsFieldBuilder() {
         if (this.appDetailsBuilder_ == null) {
            this.appDetailsBuilder_ = new SingleFieldBuilderV3(this.getAppDetails(), this.getParentForChildren(), this.isClean());
            this.appDetails_ = null;
         }

         return this.appDetailsBuilder_;
      }

      public final DocumentDetails.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (DocumentDetails.Builder)super.setUnknownFields(unknownFields);
      }

      public final DocumentDetails.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (DocumentDetails.Builder)super.mergeUnknownFields(unknownFields);
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
