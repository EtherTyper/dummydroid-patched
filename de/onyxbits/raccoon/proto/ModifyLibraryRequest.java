package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

public final class ModifyLibraryRequest extends GeneratedMessageV3 implements ModifyLibraryRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LIBRARYID_FIELD_NUMBER = 1;
   private volatile Object libraryId_;
   public static final int ADDDOCID_FIELD_NUMBER = 2;
   private LazyStringList addDocId_;
   public static final int REMOVALDOCID_FIELD_NUMBER = 3;
   private LazyStringList removalDocId_;
   public static final int ARCHIVEDOCID_FIELD_NUMBER = 4;
   private LazyStringList archiveDocId_;
   private byte memoizedIsInitialized;
   private static final ModifyLibraryRequest DEFAULT_INSTANCE = new ModifyLibraryRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ModifyLibraryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ModifyLibraryRequest(input, extensionRegistry);
      }
   };

   private ModifyLibraryRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ModifyLibraryRequest() {
      this.memoizedIsInitialized = -1;
      this.libraryId_ = "";
      this.addDocId_ = LazyStringArrayList.EMPTY;
      this.removalDocId_ = LazyStringArrayList.EMPTY;
      this.archiveDocId_ = LazyStringArrayList.EMPTY;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ModifyLibraryRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ModifyLibraryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
         throw new NullPointerException();
      } else {
         int mutable_bitField0_ = 0;
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
                  this.libraryId_ = bs;
                  break;
               case 18:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 2) == 0) {
                     this.addDocId_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 2;
                  }

                  this.addDocId_.add(bs);
                  break;
               case 26:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.removalDocId_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.removalDocId_.add(bs);
                  break;
               case 34:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 8) == 0) {
                     this.archiveDocId_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 8;
                  }

                  this.archiveDocId_.add(bs);
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
            if ((mutable_bitField0_ & 2) != 0) {
               this.addDocId_ = this.addDocId_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 4) != 0) {
               this.removalDocId_ = this.removalDocId_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 8) != 0) {
               this.archiveDocId_ = this.archiveDocId_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_ModifyLibraryRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ModifyLibraryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifyLibraryRequest.class, ModifyLibraryRequest.Builder.class);
   }

   public boolean hasLibraryId() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getLibraryId() {
      Object ref = this.libraryId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.libraryId_ = s;
         }

         return s;
      }
   }

   public ByteString getLibraryIdBytes() {
      Object ref = this.libraryId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.libraryId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public ProtocolStringList getAddDocIdList() {
      return this.addDocId_;
   }

   public int getAddDocIdCount() {
      return this.addDocId_.size();
   }

   public String getAddDocId(int index) {
      return (String)this.addDocId_.get(index);
   }

   public ByteString getAddDocIdBytes(int index) {
      return this.addDocId_.getByteString(index);
   }

   public ProtocolStringList getRemovalDocIdList() {
      return this.removalDocId_;
   }

   public int getRemovalDocIdCount() {
      return this.removalDocId_.size();
   }

   public String getRemovalDocId(int index) {
      return (String)this.removalDocId_.get(index);
   }

   public ByteString getRemovalDocIdBytes(int index) {
      return this.removalDocId_.getByteString(index);
   }

   public ProtocolStringList getArchiveDocIdList() {
      return this.archiveDocId_;
   }

   public int getArchiveDocIdCount() {
      return this.archiveDocId_.size();
   }

   public String getArchiveDocId(int index) {
      return (String)this.archiveDocId_.get(index);
   }

   public ByteString getArchiveDocIdBytes(int index) {
      return this.archiveDocId_.getByteString(index);
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
         GeneratedMessageV3.writeString(output, 1, this.libraryId_);
      }

      int i;
      for(i = 0; i < this.addDocId_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 2, this.addDocId_.getRaw(i));
      }

      for(i = 0; i < this.removalDocId_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 3, this.removalDocId_.getRaw(i));
      }

      for(i = 0; i < this.archiveDocId_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 4, this.archiveDocId_.getRaw(i));
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
            size += GeneratedMessageV3.computeStringSize(1, this.libraryId_);
         }

         int dataSize = 0;

         int i;
         for(i = 0; i < this.addDocId_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.addDocId_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getAddDocIdList().size();
         dataSize = 0;

         for(i = 0; i < this.removalDocId_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.removalDocId_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getRemovalDocIdList().size();
         dataSize = 0;

         for(i = 0; i < this.archiveDocId_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.archiveDocId_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getArchiveDocIdList().size();
         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ModifyLibraryRequest)) {
         return super.equals(obj);
      } else {
         ModifyLibraryRequest other = (ModifyLibraryRequest)obj;
         if (this.hasLibraryId() != other.hasLibraryId()) {
            return false;
         } else if (this.hasLibraryId() && !this.getLibraryId().equals(other.getLibraryId())) {
            return false;
         } else if (!this.getAddDocIdList().equals(other.getAddDocIdList())) {
            return false;
         } else if (!this.getRemovalDocIdList().equals(other.getRemovalDocIdList())) {
            return false;
         } else if (!this.getArchiveDocIdList().equals(other.getArchiveDocIdList())) {
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
         if (this.hasLibraryId()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getLibraryId().hashCode();
         }

         if (this.getAddDocIdCount() > 0) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getAddDocIdList().hashCode();
         }

         if (this.getRemovalDocIdCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getRemovalDocIdList().hashCode();
         }

         if (this.getArchiveDocIdCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getArchiveDocIdList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ModifyLibraryRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data);
   }

   public static ModifyLibraryRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data);
   }

   public static ModifyLibraryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data);
   }

   public static ModifyLibraryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryRequest parseFrom(InputStream input) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModifyLibraryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModifyLibraryRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ModifyLibraryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModifyLibraryRequest parseFrom(CodedInputStream input) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModifyLibraryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ModifyLibraryRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ModifyLibraryRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ModifyLibraryRequest.Builder newBuilder(ModifyLibraryRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ModifyLibraryRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ModifyLibraryRequest.Builder() : (new ModifyLibraryRequest.Builder()).mergeFrom(this);
   }

   protected ModifyLibraryRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ModifyLibraryRequest.Builder builder = new ModifyLibraryRequest.Builder(parent);
      return builder;
   }

   public static ModifyLibraryRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ModifyLibraryRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ModifyLibraryRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ModifyLibraryRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ModifyLibraryRequestOrBuilder {
      private int bitField0_;
      private Object libraryId_;
      private LazyStringList addDocId_;
      private LazyStringList removalDocId_;
      private LazyStringList archiveDocId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ModifyLibraryRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ModifyLibraryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifyLibraryRequest.class, ModifyLibraryRequest.Builder.class);
      }

      private Builder() {
         this.libraryId_ = "";
         this.addDocId_ = LazyStringArrayList.EMPTY;
         this.removalDocId_ = LazyStringArrayList.EMPTY;
         this.archiveDocId_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.libraryId_ = "";
         this.addDocId_ = LazyStringArrayList.EMPTY;
         this.removalDocId_ = LazyStringArrayList.EMPTY;
         this.archiveDocId_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ModifyLibraryRequest.alwaysUseFieldBuilders) {
         }

      }

      public ModifyLibraryRequest.Builder clear() {
         super.clear();
         this.libraryId_ = "";
         this.bitField0_ &= -2;
         this.addDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -3;
         this.removalDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -5;
         this.archiveDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -9;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ModifyLibraryRequest_descriptor;
      }

      public ModifyLibraryRequest getDefaultInstanceForType() {
         return ModifyLibraryRequest.getDefaultInstance();
      }

      public ModifyLibraryRequest build() {
         ModifyLibraryRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ModifyLibraryRequest buildPartial() {
         ModifyLibraryRequest result = new ModifyLibraryRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.libraryId_ = this.libraryId_;
         if ((this.bitField0_ & 2) != 0) {
            this.addDocId_ = this.addDocId_.getUnmodifiableView();
            this.bitField0_ &= -3;
         }

         result.addDocId_ = this.addDocId_;
         if ((this.bitField0_ & 4) != 0) {
            this.removalDocId_ = this.removalDocId_.getUnmodifiableView();
            this.bitField0_ &= -5;
         }

         result.removalDocId_ = this.removalDocId_;
         if ((this.bitField0_ & 8) != 0) {
            this.archiveDocId_ = this.archiveDocId_.getUnmodifiableView();
            this.bitField0_ &= -9;
         }

         result.archiveDocId_ = this.archiveDocId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ModifyLibraryRequest.Builder clone() {
         return (ModifyLibraryRequest.Builder)super.clone();
      }

      public ModifyLibraryRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ModifyLibraryRequest.Builder)super.setField(field, value);
      }

      public ModifyLibraryRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ModifyLibraryRequest.Builder)super.clearField(field);
      }

      public ModifyLibraryRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ModifyLibraryRequest.Builder)super.clearOneof(oneof);
      }

      public ModifyLibraryRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ModifyLibraryRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public ModifyLibraryRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ModifyLibraryRequest.Builder)super.addRepeatedField(field, value);
      }

      public ModifyLibraryRequest.Builder mergeFrom(Message other) {
         if (other instanceof ModifyLibraryRequest) {
            return this.mergeFrom((ModifyLibraryRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ModifyLibraryRequest.Builder mergeFrom(ModifyLibraryRequest other) {
         if (other == ModifyLibraryRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasLibraryId()) {
               this.bitField0_ |= 1;
               this.libraryId_ = other.libraryId_;
               this.onChanged();
            }

            if (!other.addDocId_.isEmpty()) {
               if (this.addDocId_.isEmpty()) {
                  this.addDocId_ = other.addDocId_;
                  this.bitField0_ &= -3;
               } else {
                  this.ensureAddDocIdIsMutable();
                  this.addDocId_.addAll(other.addDocId_);
               }

               this.onChanged();
            }

            if (!other.removalDocId_.isEmpty()) {
               if (this.removalDocId_.isEmpty()) {
                  this.removalDocId_ = other.removalDocId_;
                  this.bitField0_ &= -5;
               } else {
                  this.ensureRemovalDocIdIsMutable();
                  this.removalDocId_.addAll(other.removalDocId_);
               }

               this.onChanged();
            }

            if (!other.archiveDocId_.isEmpty()) {
               if (this.archiveDocId_.isEmpty()) {
                  this.archiveDocId_ = other.archiveDocId_;
                  this.bitField0_ &= -9;
               } else {
                  this.ensureArchiveDocIdIsMutable();
                  this.archiveDocId_.addAll(other.archiveDocId_);
               }

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

      public ModifyLibraryRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ModifyLibraryRequest parsedMessage = null;

         try {
            parsedMessage = (ModifyLibraryRequest)ModifyLibraryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ModifyLibraryRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasLibraryId() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getLibraryId() {
         Object ref = this.libraryId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.libraryId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLibraryIdBytes() {
         Object ref = this.libraryId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.libraryId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ModifyLibraryRequest.Builder setLibraryId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder clearLibraryId() {
         this.bitField0_ &= -2;
         this.libraryId_ = ModifyLibraryRequest.getDefaultInstance().getLibraryId();
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder setLibraryIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureAddDocIdIsMutable() {
         if ((this.bitField0_ & 2) == 0) {
            this.addDocId_ = new LazyStringArrayList(this.addDocId_);
            this.bitField0_ |= 2;
         }

      }

      public ProtocolStringList getAddDocIdList() {
         return this.addDocId_.getUnmodifiableView();
      }

      public int getAddDocIdCount() {
         return this.addDocId_.size();
      }

      public String getAddDocId(int index) {
         return (String)this.addDocId_.get(index);
      }

      public ByteString getAddDocIdBytes(int index) {
         return this.addDocId_.getByteString(index);
      }

      public ModifyLibraryRequest.Builder setAddDocId(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAddDocIdIsMutable();
            this.addDocId_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addAddDocId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAddDocIdIsMutable();
            this.addDocId_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addAllAddDocId(Iterable values) {
         this.ensureAddDocIdIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.addDocId_);
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder clearAddDocId() {
         this.addDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -3;
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder addAddDocIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureAddDocIdIsMutable();
            this.addDocId_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureRemovalDocIdIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.removalDocId_ = new LazyStringArrayList(this.removalDocId_);
            this.bitField0_ |= 4;
         }

      }

      public ProtocolStringList getRemovalDocIdList() {
         return this.removalDocId_.getUnmodifiableView();
      }

      public int getRemovalDocIdCount() {
         return this.removalDocId_.size();
      }

      public String getRemovalDocId(int index) {
         return (String)this.removalDocId_.get(index);
      }

      public ByteString getRemovalDocIdBytes(int index) {
         return this.removalDocId_.getByteString(index);
      }

      public ModifyLibraryRequest.Builder setRemovalDocId(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRemovalDocIdIsMutable();
            this.removalDocId_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addRemovalDocId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRemovalDocIdIsMutable();
            this.removalDocId_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addAllRemovalDocId(Iterable values) {
         this.ensureRemovalDocIdIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.removalDocId_);
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder clearRemovalDocId() {
         this.removalDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -5;
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder addRemovalDocIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRemovalDocIdIsMutable();
            this.removalDocId_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureArchiveDocIdIsMutable() {
         if ((this.bitField0_ & 8) == 0) {
            this.archiveDocId_ = new LazyStringArrayList(this.archiveDocId_);
            this.bitField0_ |= 8;
         }

      }

      public ProtocolStringList getArchiveDocIdList() {
         return this.archiveDocId_.getUnmodifiableView();
      }

      public int getArchiveDocIdCount() {
         return this.archiveDocId_.size();
      }

      public String getArchiveDocId(int index) {
         return (String)this.archiveDocId_.get(index);
      }

      public ByteString getArchiveDocIdBytes(int index) {
         return this.archiveDocId_.getByteString(index);
      }

      public ModifyLibraryRequest.Builder setArchiveDocId(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureArchiveDocIdIsMutable();
            this.archiveDocId_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addArchiveDocId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureArchiveDocIdIsMutable();
            this.archiveDocId_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public ModifyLibraryRequest.Builder addAllArchiveDocId(Iterable values) {
         this.ensureArchiveDocIdIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.archiveDocId_);
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder clearArchiveDocId() {
         this.archiveDocId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -9;
         this.onChanged();
         return this;
      }

      public ModifyLibraryRequest.Builder addArchiveDocIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureArchiveDocIdIsMutable();
            this.archiveDocId_.add(value);
            this.onChanged();
            return this;
         }
      }

      public final ModifyLibraryRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ModifyLibraryRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final ModifyLibraryRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ModifyLibraryRequest.Builder)super.mergeUnknownFields(unknownFields);
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
