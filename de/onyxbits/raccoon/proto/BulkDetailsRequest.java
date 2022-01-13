package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class BulkDetailsRequest extends GeneratedMessageV3 implements BulkDetailsRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOCID_FIELD_NUMBER = 1;
   private LazyStringList docid_;
   public static final int INCLUDECHILDDOCS_FIELD_NUMBER = 2;
   private boolean includeChildDocs_;
   public static final int INCLUDEDETAILS_FIELD_NUMBER = 3;
   private boolean includeDetails_;
   private byte memoizedIsInitialized;
   private static final BulkDetailsRequest DEFAULT_INSTANCE = new BulkDetailsRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public BulkDetailsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new BulkDetailsRequest(input, extensionRegistry);
      }
   };

   private BulkDetailsRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private BulkDetailsRequest() {
      this.memoizedIsInitialized = -1;
      this.docid_ = LazyStringArrayList.EMPTY;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new BulkDetailsRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BulkDetailsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  if (!(mutable_bitField0_ & true)) {
                     this.docid_ = new LazyStringArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.docid_.add(bs);
                  break;
               case 16:
                  this.bitField0_ |= 1;
                  this.includeChildDocs_ = input.readBool();
                  break;
               case 24:
                  this.bitField0_ |= 2;
                  this.includeDetails_ = input.readBool();
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
            if (mutable_bitField0_ & true) {
               this.docid_ = this.docid_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_BulkDetailsRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_BulkDetailsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsRequest.class, BulkDetailsRequest.Builder.class);
   }

   public ProtocolStringList getDocidList() {
      return this.docid_;
   }

   public int getDocidCount() {
      return this.docid_.size();
   }

   public String getDocid(int index) {
      return (String)this.docid_.get(index);
   }

   public ByteString getDocidBytes(int index) {
      return this.docid_.getByteString(index);
   }

   public boolean hasIncludeChildDocs() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getIncludeChildDocs() {
      return this.includeChildDocs_;
   }

   public boolean hasIncludeDetails() {
      return (this.bitField0_ & 2) != 0;
   }

   public boolean getIncludeDetails() {
      return this.includeDetails_;
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
      for(int i = 0; i < this.docid_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 1, this.docid_.getRaw(i));
      }

      if ((this.bitField0_ & 1) != 0) {
         output.writeBool(2, this.includeChildDocs_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBool(3, this.includeDetails_);
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         int size = 0;
         int dataSize = 0;

         for(int i = 0; i < this.docid_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.docid_.getRaw(i));
         }

         size = size + dataSize;
         size += 1 * this.getDocidList().size();
         if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeBoolSize(2, this.includeChildDocs_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBoolSize(3, this.includeDetails_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof BulkDetailsRequest)) {
         return super.equals(obj);
      } else {
         BulkDetailsRequest other = (BulkDetailsRequest)obj;
         if (!this.getDocidList().equals(other.getDocidList())) {
            return false;
         } else if (this.hasIncludeChildDocs() != other.hasIncludeChildDocs()) {
            return false;
         } else if (this.hasIncludeChildDocs() && this.getIncludeChildDocs() != other.getIncludeChildDocs()) {
            return false;
         } else if (this.hasIncludeDetails() != other.hasIncludeDetails()) {
            return false;
         } else if (this.hasIncludeDetails() && this.getIncludeDetails() != other.getIncludeDetails()) {
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
         if (this.getDocidCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDocidList().hashCode();
         }

         if (this.hasIncludeChildDocs()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashBoolean(this.getIncludeChildDocs());
         }

         if (this.hasIncludeDetails()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashBoolean(this.getIncludeDetails());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static BulkDetailsRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data);
   }

   public static BulkDetailsRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data);
   }

   public static BulkDetailsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data);
   }

   public static BulkDetailsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (BulkDetailsRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static BulkDetailsRequest parseFrom(InputStream input) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static BulkDetailsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static BulkDetailsRequest parseFrom(CodedInputStream input) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static BulkDetailsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (BulkDetailsRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public BulkDetailsRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static BulkDetailsRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BulkDetailsRequest.Builder newBuilder(BulkDetailsRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public BulkDetailsRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new BulkDetailsRequest.Builder() : (new BulkDetailsRequest.Builder()).mergeFrom(this);
   }

   protected BulkDetailsRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      BulkDetailsRequest.Builder builder = new BulkDetailsRequest.Builder(parent);
      return builder;
   }

   public static BulkDetailsRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BulkDetailsRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   BulkDetailsRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   BulkDetailsRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements BulkDetailsRequestOrBuilder {
      private int bitField0_;
      private LazyStringList docid_;
      private boolean includeChildDocs_;
      private boolean includeDetails_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_BulkDetailsRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_BulkDetailsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BulkDetailsRequest.class, BulkDetailsRequest.Builder.class);
      }

      private Builder() {
         this.docid_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.docid_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (BulkDetailsRequest.alwaysUseFieldBuilders) {
         }

      }

      public BulkDetailsRequest.Builder clear() {
         super.clear();
         this.docid_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -2;
         this.includeChildDocs_ = false;
         this.bitField0_ &= -3;
         this.includeDetails_ = false;
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_BulkDetailsRequest_descriptor;
      }

      public BulkDetailsRequest getDefaultInstanceForType() {
         return BulkDetailsRequest.getDefaultInstance();
      }

      public BulkDetailsRequest build() {
         BulkDetailsRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public BulkDetailsRequest buildPartial() {
         BulkDetailsRequest result = new BulkDetailsRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((this.bitField0_ & 1) != 0) {
            this.docid_ = this.docid_.getUnmodifiableView();
            this.bitField0_ &= -2;
         }

         result.docid_ = this.docid_;
         if ((from_bitField0_ & 2) != 0) {
            result.includeChildDocs_ = this.includeChildDocs_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.includeDetails_ = this.includeDetails_;
            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public BulkDetailsRequest.Builder clone() {
         return (BulkDetailsRequest.Builder)super.clone();
      }

      public BulkDetailsRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsRequest.Builder)super.setField(field, value);
      }

      public BulkDetailsRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (BulkDetailsRequest.Builder)super.clearField(field);
      }

      public BulkDetailsRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (BulkDetailsRequest.Builder)super.clearOneof(oneof);
      }

      public BulkDetailsRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (BulkDetailsRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public BulkDetailsRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (BulkDetailsRequest.Builder)super.addRepeatedField(field, value);
      }

      public BulkDetailsRequest.Builder mergeFrom(Message other) {
         if (other instanceof BulkDetailsRequest) {
            return this.mergeFrom((BulkDetailsRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public BulkDetailsRequest.Builder mergeFrom(BulkDetailsRequest other) {
         if (other == BulkDetailsRequest.getDefaultInstance()) {
            return this;
         } else {
            if (!other.docid_.isEmpty()) {
               if (this.docid_.isEmpty()) {
                  this.docid_ = other.docid_;
                  this.bitField0_ &= -2;
               } else {
                  this.ensureDocidIsMutable();
                  this.docid_.addAll(other.docid_);
               }

               this.onChanged();
            }

            if (other.hasIncludeChildDocs()) {
               this.setIncludeChildDocs(other.getIncludeChildDocs());
            }

            if (other.hasIncludeDetails()) {
               this.setIncludeDetails(other.getIncludeDetails());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public BulkDetailsRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         BulkDetailsRequest parsedMessage = null;

         try {
            parsedMessage = (BulkDetailsRequest)BulkDetailsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (BulkDetailsRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureDocidIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.docid_ = new LazyStringArrayList(this.docid_);
            this.bitField0_ |= 1;
         }

      }

      public ProtocolStringList getDocidList() {
         return this.docid_.getUnmodifiableView();
      }

      public int getDocidCount() {
         return this.docid_.size();
      }

      public String getDocid(int index) {
         return (String)this.docid_.get(index);
      }

      public ByteString getDocidBytes(int index) {
         return this.docid_.getByteString(index);
      }

      public BulkDetailsRequest.Builder setDocid(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureDocidIsMutable();
            this.docid_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public BulkDetailsRequest.Builder addDocid(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureDocidIsMutable();
            this.docid_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public BulkDetailsRequest.Builder addAllDocid(Iterable values) {
         this.ensureDocidIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.docid_);
         this.onChanged();
         return this;
      }

      public BulkDetailsRequest.Builder clearDocid() {
         this.docid_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -2;
         this.onChanged();
         return this;
      }

      public BulkDetailsRequest.Builder addDocidBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureDocidIsMutable();
            this.docid_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasIncludeChildDocs() {
         return (this.bitField0_ & 2) != 0;
      }

      public boolean getIncludeChildDocs() {
         return this.includeChildDocs_;
      }

      public BulkDetailsRequest.Builder setIncludeChildDocs(boolean value) {
         this.bitField0_ |= 2;
         this.includeChildDocs_ = value;
         this.onChanged();
         return this;
      }

      public BulkDetailsRequest.Builder clearIncludeChildDocs() {
         this.bitField0_ &= -3;
         this.includeChildDocs_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasIncludeDetails() {
         return (this.bitField0_ & 4) != 0;
      }

      public boolean getIncludeDetails() {
         return this.includeDetails_;
      }

      public BulkDetailsRequest.Builder setIncludeDetails(boolean value) {
         this.bitField0_ |= 4;
         this.includeDetails_ = value;
         this.onChanged();
         return this;
      }

      public BulkDetailsRequest.Builder clearIncludeDetails() {
         this.bitField0_ &= -5;
         this.includeDetails_ = false;
         this.onChanged();
         return this;
      }

      public final BulkDetailsRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final BulkDetailsRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (BulkDetailsRequest.Builder)super.mergeUnknownFields(unknownFields);
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
