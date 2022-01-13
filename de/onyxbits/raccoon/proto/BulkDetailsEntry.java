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

public final class BulkDetailsEntry extends GeneratedMessageV3 implements BulkDetailsEntryOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOC_FIELD_NUMBER = 1;
   private DocV2 doc_;
   private byte memoizedIsInitialized;
   private static final BulkDetailsEntry DEFAULT_INSTANCE = new BulkDetailsEntry();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public BulkDetailsEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new BulkDetailsEntry(input, extensionRegistry);
      }
   };

   private BulkDetailsEntry(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private BulkDetailsEntry() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new BulkDetailsEntry();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BulkDetailsEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  DocV2.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.doc_.toBuilder();
                  }

                  this.doc_ = (DocV2)input.readMessage(DocV2.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.doc_);
                     this.doc_ = subBuilder.buildPartial();
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
      return Mothership.internal_static_BulkDetailsEntry_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_BulkDetailsEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsEntry.class, BulkDetailsEntry.Builder.class);
   }

   public boolean hasDoc() {
      return (this.bitField0_ & 1) != 0;
   }

   public DocV2 getDoc() {
      return this.doc_ == null ? DocV2.getDefaultInstance() : this.doc_;
   }

   public DocV2OrBuilder getDocOrBuilder() {
      return this.doc_ == null ? DocV2.getDefaultInstance() : this.doc_;
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
         output.writeMessage(1, this.getDoc());
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
            size += CodedOutputStream.computeMessageSize(1, this.getDoc());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof BulkDetailsEntry)) {
         return super.equals(obj);
      } else {
         BulkDetailsEntry other = (BulkDetailsEntry)obj;
         if (this.hasDoc() != other.hasDoc()) {
            return false;
         } else if (this.hasDoc() && !this.getDoc().equals(other.getDoc())) {
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
         if (this.hasDoc()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDoc().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static BulkDetailsEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data);
   }

   public static BulkDetailsEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data);
   }

   public static BulkDetailsEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data);
   }

   public static BulkDetailsEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsEntry)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsEntry parseFrom(InputStream input) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsEntry parseDelimitedFrom(InputStream input) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static BulkDetailsEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsEntry parseFrom(CodedInputStream input) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsEntry)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public BulkDetailsEntry.Builder newBuilderForType() {
      return newBuilder();
   }

   public static BulkDetailsEntry.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BulkDetailsEntry.Builder newBuilder(BulkDetailsEntry prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public BulkDetailsEntry.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new BulkDetailsEntry.Builder() : (new BulkDetailsEntry.Builder()).mergeFrom(this);
   }

   protected BulkDetailsEntry.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      BulkDetailsEntry.Builder builder = new BulkDetailsEntry.Builder(parent);
      return builder;
   }

   public static BulkDetailsEntry getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BulkDetailsEntry getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   BulkDetailsEntry(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   BulkDetailsEntry(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements BulkDetailsEntryOrBuilder {
      private int bitField0_;
      private DocV2 doc_;
      private SingleFieldBuilderV3 docBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_BulkDetailsEntry_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_BulkDetailsEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsEntry.class, BulkDetailsEntry.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (BulkDetailsEntry.alwaysUseFieldBuilders) {
            this.getDocFieldBuilder();
         }

      }

      public BulkDetailsEntry.Builder clear() {
         super.clear();
         if (this.docBuilder_ == null) {
            this.doc_ = null;
         } else {
            this.docBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_BulkDetailsEntry_descriptor;
      }

      public BulkDetailsEntry getDefaultInstanceForType() {
         return BulkDetailsEntry.getDefaultInstance();
      }

      public BulkDetailsEntry build() {
         BulkDetailsEntry result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public BulkDetailsEntry buildPartial() {
         BulkDetailsEntry result = new BulkDetailsEntry(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.docBuilder_ == null) {
               result.doc_ = this.doc_;
            } else {
               result.doc_ = (DocV2)this.docBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public BulkDetailsEntry.Builder clone() {
         return (BulkDetailsEntry.Builder)super.clone();
      }

      public BulkDetailsEntry.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsEntry.Builder)super.setField(field, value);
      }

      public BulkDetailsEntry.Builder clearField(Descriptors.FieldDescriptor field) {
         return (BulkDetailsEntry.Builder)super.clearField(field);
      }

      public BulkDetailsEntry.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (BulkDetailsEntry.Builder)super.clearOneof(oneof);
      }

      public BulkDetailsEntry.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (BulkDetailsEntry.Builder)super.setRepeatedField(field, index, value);
      }

      public BulkDetailsEntry.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsEntry.Builder)super.addRepeatedField(field, value);
      }

      public BulkDetailsEntry.Builder mergeFrom(Message other) {
         if (other instanceof BulkDetailsEntry) {
            return this.mergeFrom((BulkDetailsEntry)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public BulkDetailsEntry.Builder mergeFrom(BulkDetailsEntry other) {
         if (other == BulkDetailsEntry.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDoc()) {
               this.mergeDoc(other.getDoc());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public BulkDetailsEntry.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         BulkDetailsEntry parsedMessage = null;

         try {
            parsedMessage = (BulkDetailsEntry)BulkDetailsEntry.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (BulkDetailsEntry)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDoc() {
         return (this.bitField0_ & 1) != 0;
      }

      public DocV2 getDoc() {
         if (this.docBuilder_ == null) {
            return this.doc_ == null ? DocV2.getDefaultInstance() : this.doc_;
         } else {
            return (DocV2)this.docBuilder_.getMessage();
         }
      }

      public BulkDetailsEntry.Builder setDoc(DocV2 value) {
         if (this.docBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.doc_ = value;
            this.onChanged();
         } else {
            this.docBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public BulkDetailsEntry.Builder setDoc(DocV2.Builder builderForValue) {
         if (this.docBuilder_ == null) {
            this.doc_ = builderForValue.build();
            this.onChanged();
         } else {
            this.docBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public BulkDetailsEntry.Builder mergeDoc(DocV2 value) {
         if (this.docBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.doc_ != null && this.doc_ != DocV2.getDefaultInstance()) {
               this.doc_ = DocV2.newBuilder(this.doc_).mergeFrom(value).buildPartial();
            } else {
               this.doc_ = value;
            }

            this.onChanged();
         } else {
            this.docBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public BulkDetailsEntry.Builder clearDoc() {
         if (this.docBuilder_ == null) {
            this.doc_ = null;
            this.onChanged();
         } else {
            this.docBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public DocV2.Builder getDocBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (DocV2.Builder)this.getDocFieldBuilder().getBuilder();
      }

      public DocV2OrBuilder getDocOrBuilder() {
         if (this.docBuilder_ != null) {
            return (DocV2OrBuilder)this.docBuilder_.getMessageOrBuilder();
         } else {
            return this.doc_ == null ? DocV2.getDefaultInstance() : this.doc_;
         }
      }

      private SingleFieldBuilderV3 getDocFieldBuilder() {
         if (this.docBuilder_ == null) {
            this.docBuilder_ = new SingleFieldBuilderV3(this.getDoc(), this.getParentForChildren(), this.isClean());
            this.doc_ = null;
         }

         return this.docBuilder_;
      }

      public final BulkDetailsEntry.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsEntry.Builder)super.setUnknownFields(unknownFields);
      }

      public final BulkDetailsEntry.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsEntry.Builder)super.mergeUnknownFields(unknownFields);
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
