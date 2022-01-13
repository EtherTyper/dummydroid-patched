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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LibraryUpdate extends GeneratedMessageV3 implements LibraryUpdateOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int STATUS_FIELD_NUMBER = 1;
   private int status_;
   public static final int MUTATION_FIELD_NUMBER = 4;
   private List mutation_;
   public static final int HASMORE_FIELD_NUMBER = 5;
   private boolean hasMore_;
   public static final int LIBRARYID_FIELD_NUMBER = 6;
   private volatile Object libraryId_;
   private byte memoizedIsInitialized;
   private static final LibraryUpdate DEFAULT_INSTANCE = new LibraryUpdate();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public LibraryUpdate parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new LibraryUpdate(input, extensionRegistry);
      }
   };

   private LibraryUpdate(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private LibraryUpdate() {
      this.memoizedIsInitialized = -1;
      this.status_ = 1;
      this.mutation_ = Collections.emptyList();
      this.libraryId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new LibraryUpdate();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private LibraryUpdate(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 8:
                  int rawValue = input.readEnum();
                  LibraryUpdate.Status value = LibraryUpdate.Status.valueOf(rawValue);
                  if (value == null) {
                     unknownFields.mergeVarintField(1, rawValue);
                  } else {
                     this.bitField0_ |= 1;
                     this.status_ = rawValue;
                  }
                  break;
               case 34:
                  if ((mutable_bitField0_ & 2) == 0) {
                     this.mutation_ = new ArrayList();
                     mutable_bitField0_ |= 2;
                  }

                  this.mutation_.add(input.readMessage(LibraryMutation.PARSER, extensionRegistry));
                  break;
               case 40:
                  this.bitField0_ |= 2;
                  this.hasMore_ = input.readBool();
                  break;
               case 50:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.libraryId_ = bs;
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var13) {
            throw var13.setUnfinishedMessage(this);
         } catch (IOException var14) {
            throw (new InvalidProtocolBufferException(var14)).setUnfinishedMessage(this);
         } finally {
            if ((mutable_bitField0_ & 2) != 0) {
               this.mutation_ = Collections.unmodifiableList(this.mutation_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_LibraryUpdate_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_LibraryUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryUpdate.class, LibraryUpdate.Builder.class);
   }

   public boolean hasStatus() {
      return (this.bitField0_ & 1) != 0;
   }

   public LibraryUpdate.Status getStatus() {
      LibraryUpdate.Status result = LibraryUpdate.Status.valueOf(this.status_);
      return result == null ? LibraryUpdate.Status.NOT_MODIFIED : result;
   }

   public List getMutationList() {
      return this.mutation_;
   }

   public List getMutationOrBuilderList() {
      return this.mutation_;
   }

   public int getMutationCount() {
      return this.mutation_.size();
   }

   public LibraryMutation getMutation(int index) {
      return (LibraryMutation)this.mutation_.get(index);
   }

   public LibraryMutationOrBuilder getMutationOrBuilder(int index) {
      return (LibraryMutationOrBuilder)this.mutation_.get(index);
   }

   public boolean hasHasMore() {
      return (this.bitField0_ & 2) != 0;
   }

   public boolean getHasMore() {
      return this.hasMore_;
   }

   public boolean hasLibraryId() {
      return (this.bitField0_ & 4) != 0;
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
         output.writeEnum(1, this.status_);
      }

      for(int i = 0; i < this.mutation_.size(); ++i) {
         output.writeMessage(4, (MessageLite)this.mutation_.get(i));
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBool(5, this.hasMore_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.libraryId_);
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
            size += CodedOutputStream.computeEnumSize(1, this.status_);
         }

         for(int i = 0; i < this.mutation_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.mutation_.get(i));
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBoolSize(5, this.hasMore_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.libraryId_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof LibraryUpdate)) {
         return super.equals(obj);
      } else {
         LibraryUpdate other = (LibraryUpdate)obj;
         if (this.hasStatus() != other.hasStatus()) {
            return false;
         } else if (this.hasStatus() && this.status_ != other.status_) {
            return false;
         } else if (!this.getMutationList().equals(other.getMutationList())) {
            return false;
         } else if (this.hasHasMore() != other.hasHasMore()) {
            return false;
         } else if (this.hasHasMore() && this.getHasMore() != other.getHasMore()) {
            return false;
         } else if (this.hasLibraryId() != other.hasLibraryId()) {
            return false;
         } else if (this.hasLibraryId() && !this.getLibraryId().equals(other.getLibraryId())) {
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
         if (this.hasStatus()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.status_;
         }

         if (this.getMutationCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getMutationList().hashCode();
         }

         if (this.hasHasMore()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashBoolean(this.getHasMore());
         }

         if (this.hasLibraryId()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getLibraryId().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static LibraryUpdate parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data);
   }

   public static LibraryUpdate parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryUpdate parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data);
   }

   public static LibraryUpdate parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryUpdate parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data);
   }

   public static LibraryUpdate parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryUpdate)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryUpdate parseFrom(InputStream input) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryUpdate parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryUpdate parseDelimitedFrom(InputStream input) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static LibraryUpdate parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryUpdate parseFrom(CodedInputStream input) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryUpdate parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryUpdate)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public LibraryUpdate.Builder newBuilderForType() {
      return newBuilder();
   }

   public static LibraryUpdate.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static LibraryUpdate.Builder newBuilder(LibraryUpdate prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public LibraryUpdate.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new LibraryUpdate.Builder() : (new LibraryUpdate.Builder()).mergeFrom(this);
   }

   protected LibraryUpdate.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      LibraryUpdate.Builder builder = new LibraryUpdate.Builder(parent);
      return builder;
   }

   public static LibraryUpdate getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public LibraryUpdate getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   LibraryUpdate(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   LibraryUpdate(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements LibraryUpdateOrBuilder {
      private int bitField0_;
      private int status_;
      private List mutation_;
      private RepeatedFieldBuilderV3 mutationBuilder_;
      private boolean hasMore_;
      private Object libraryId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_LibraryUpdate_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_LibraryUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryUpdate.class, LibraryUpdate.Builder.class);
      }

      private Builder() {
         this.status_ = 1;
         this.mutation_ = Collections.emptyList();
         this.libraryId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.status_ = 1;
         this.mutation_ = Collections.emptyList();
         this.libraryId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (LibraryUpdate.alwaysUseFieldBuilders) {
            this.getMutationFieldBuilder();
         }

      }

      public LibraryUpdate.Builder clear() {
         super.clear();
         this.status_ = 1;
         this.bitField0_ &= -2;
         if (this.mutationBuilder_ == null) {
            this.mutation_ = Collections.emptyList();
            this.bitField0_ &= -3;
         } else {
            this.mutationBuilder_.clear();
         }

         this.hasMore_ = false;
         this.bitField0_ &= -5;
         this.libraryId_ = "";
         this.bitField0_ &= -9;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_LibraryUpdate_descriptor;
      }

      public LibraryUpdate getDefaultInstanceForType() {
         return LibraryUpdate.getDefaultInstance();
      }

      public LibraryUpdate build() {
         LibraryUpdate result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public LibraryUpdate buildPartial() {
         LibraryUpdate result = new LibraryUpdate(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.status_ = this.status_;
         if (this.mutationBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0) {
               this.mutation_ = Collections.unmodifiableList(this.mutation_);
               this.bitField0_ &= -3;
            }

            result.mutation_ = this.mutation_;
         } else {
            result.mutation_ = this.mutationBuilder_.build();
         }

         if ((from_bitField0_ & 4) != 0) {
            result.hasMore_ = this.hasMore_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 4;
         }

         result.libraryId_ = this.libraryId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public LibraryUpdate.Builder clone() {
         return (LibraryUpdate.Builder)super.clone();
      }

      public LibraryUpdate.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryUpdate.Builder)super.setField(field, value);
      }

      public LibraryUpdate.Builder clearField(Descriptors.FieldDescriptor field) {
         return (LibraryUpdate.Builder)super.clearField(field);
      }

      public LibraryUpdate.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (LibraryUpdate.Builder)super.clearOneof(oneof);
      }

      public LibraryUpdate.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (LibraryUpdate.Builder)super.setRepeatedField(field, index, value);
      }

      public LibraryUpdate.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryUpdate.Builder)super.addRepeatedField(field, value);
      }

      public LibraryUpdate.Builder mergeFrom(Message other) {
         if (other instanceof LibraryUpdate) {
            return this.mergeFrom((LibraryUpdate)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public LibraryUpdate.Builder mergeFrom(LibraryUpdate other) {
         if (other == LibraryUpdate.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasStatus()) {
               this.setStatus(other.getStatus());
            }

            if (this.mutationBuilder_ == null) {
               if (!other.mutation_.isEmpty()) {
                  if (this.mutation_.isEmpty()) {
                     this.mutation_ = other.mutation_;
                     this.bitField0_ &= -3;
                  } else {
                     this.ensureMutationIsMutable();
                     this.mutation_.addAll(other.mutation_);
                  }

                  this.onChanged();
               }
            } else if (!other.mutation_.isEmpty()) {
               if (this.mutationBuilder_.isEmpty()) {
                  this.mutationBuilder_.dispose();
                  this.mutationBuilder_ = null;
                  this.mutation_ = other.mutation_;
                  this.bitField0_ &= -3;
                  this.mutationBuilder_ = LibraryUpdate.alwaysUseFieldBuilders ? this.getMutationFieldBuilder() : null;
               } else {
                  this.mutationBuilder_.addAllMessages(other.mutation_);
               }
            }

            if (other.hasHasMore()) {
               this.setHasMore(other.getHasMore());
            }

            if (other.hasLibraryId()) {
               this.bitField0_ |= 8;
               this.libraryId_ = other.libraryId_;
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

      public LibraryUpdate.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         LibraryUpdate parsedMessage = null;

         try {
            parsedMessage = (LibraryUpdate)LibraryUpdate.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (LibraryUpdate)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasStatus() {
         return (this.bitField0_ & 1) != 0;
      }

      public LibraryUpdate.Status getStatus() {
         LibraryUpdate.Status result = LibraryUpdate.Status.valueOf(this.status_);
         return result == null ? LibraryUpdate.Status.NOT_MODIFIED : result;
      }

      public LibraryUpdate.Builder setStatus(LibraryUpdate.Status value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.status_ = value.getNumber();
            this.onChanged();
            return this;
         }
      }

      public LibraryUpdate.Builder clearStatus() {
         this.bitField0_ &= -2;
         this.status_ = 1;
         this.onChanged();
         return this;
      }

      private void ensureMutationIsMutable() {
         if ((this.bitField0_ & 2) == 0) {
            this.mutation_ = new ArrayList(this.mutation_);
            this.bitField0_ |= 2;
         }

      }

      public List getMutationList() {
         return this.mutationBuilder_ == null ? Collections.unmodifiableList(this.mutation_) : this.mutationBuilder_.getMessageList();
      }

      public int getMutationCount() {
         return this.mutationBuilder_ == null ? this.mutation_.size() : this.mutationBuilder_.getCount();
      }

      public LibraryMutation getMutation(int index) {
         return this.mutationBuilder_ == null ? (LibraryMutation)this.mutation_.get(index) : (LibraryMutation)this.mutationBuilder_.getMessage(index);
      }

      public LibraryUpdate.Builder setMutation(int index, LibraryMutation value) {
         if (this.mutationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureMutationIsMutable();
            this.mutation_.set(index, value);
            this.onChanged();
         } else {
            this.mutationBuilder_.setMessage(index, value);
         }

         return this;
      }

      public LibraryUpdate.Builder setMutation(int index, LibraryMutation.Builder builderForValue) {
         if (this.mutationBuilder_ == null) {
            this.ensureMutationIsMutable();
            this.mutation_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.mutationBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public LibraryUpdate.Builder addMutation(LibraryMutation value) {
         if (this.mutationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureMutationIsMutable();
            this.mutation_.add(value);
            this.onChanged();
         } else {
            this.mutationBuilder_.addMessage(value);
         }

         return this;
      }

      public LibraryUpdate.Builder addMutation(int index, LibraryMutation value) {
         if (this.mutationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureMutationIsMutable();
            this.mutation_.add(index, value);
            this.onChanged();
         } else {
            this.mutationBuilder_.addMessage(index, value);
         }

         return this;
      }

      public LibraryUpdate.Builder addMutation(LibraryMutation.Builder builderForValue) {
         if (this.mutationBuilder_ == null) {
            this.ensureMutationIsMutable();
            this.mutation_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.mutationBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public LibraryUpdate.Builder addMutation(int index, LibraryMutation.Builder builderForValue) {
         if (this.mutationBuilder_ == null) {
            this.ensureMutationIsMutable();
            this.mutation_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.mutationBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public LibraryUpdate.Builder addAllMutation(Iterable values) {
         if (this.mutationBuilder_ == null) {
            this.ensureMutationIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.mutation_);
            this.onChanged();
         } else {
            this.mutationBuilder_.addAllMessages(values);
         }

         return this;
      }

      public LibraryUpdate.Builder clearMutation() {
         if (this.mutationBuilder_ == null) {
            this.mutation_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
         } else {
            this.mutationBuilder_.clear();
         }

         return this;
      }

      public LibraryUpdate.Builder removeMutation(int index) {
         if (this.mutationBuilder_ == null) {
            this.ensureMutationIsMutable();
            this.mutation_.remove(index);
            this.onChanged();
         } else {
            this.mutationBuilder_.remove(index);
         }

         return this;
      }

      public LibraryMutation.Builder getMutationBuilder(int index) {
         return (LibraryMutation.Builder)this.getMutationFieldBuilder().getBuilder(index);
      }

      public LibraryMutationOrBuilder getMutationOrBuilder(int index) {
         return this.mutationBuilder_ == null ? (LibraryMutationOrBuilder)this.mutation_.get(index) : (LibraryMutationOrBuilder)this.mutationBuilder_.getMessageOrBuilder(index);
      }

      public List getMutationOrBuilderList() {
         return this.mutationBuilder_ != null ? this.mutationBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.mutation_);
      }

      public LibraryMutation.Builder addMutationBuilder() {
         return (LibraryMutation.Builder)this.getMutationFieldBuilder().addBuilder(LibraryMutation.getDefaultInstance());
      }

      public LibraryMutation.Builder addMutationBuilder(int index) {
         return (LibraryMutation.Builder)this.getMutationFieldBuilder().addBuilder(index, LibraryMutation.getDefaultInstance());
      }

      public List getMutationBuilderList() {
         return this.getMutationFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getMutationFieldBuilder() {
         if (this.mutationBuilder_ == null) {
            this.mutationBuilder_ = new RepeatedFieldBuilderV3(this.mutation_, (this.bitField0_ & 2) != 0, this.getParentForChildren(), this.isClean());
            this.mutation_ = null;
         }

         return this.mutationBuilder_;
      }

      public boolean hasHasMore() {
         return (this.bitField0_ & 4) != 0;
      }

      public boolean getHasMore() {
         return this.hasMore_;
      }

      public LibraryUpdate.Builder setHasMore(boolean value) {
         this.bitField0_ |= 4;
         this.hasMore_ = value;
         this.onChanged();
         return this;
      }

      public LibraryUpdate.Builder clearHasMore() {
         this.bitField0_ &= -5;
         this.hasMore_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasLibraryId() {
         return (this.bitField0_ & 8) != 0;
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

      public LibraryUpdate.Builder setLibraryId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      public LibraryUpdate.Builder clearLibraryId() {
         this.bitField0_ &= -9;
         this.libraryId_ = LibraryUpdate.getDefaultInstance().getLibraryId();
         this.onChanged();
         return this;
      }

      public LibraryUpdate.Builder setLibraryIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.libraryId_ = value;
            this.onChanged();
            return this;
         }
      }

      public final LibraryUpdate.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryUpdate.Builder)super.setUnknownFields(unknownFields);
      }

      public final LibraryUpdate.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryUpdate.Builder)super.mergeUnknownFields(unknownFields);
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

   public static enum Status implements ProtocolMessageEnum {
      NOT_MODIFIED(1),
      PARTIAL_DATA_OK(2),
      COMPLETE_DATA_OK(3);

      public static final int NOT_MODIFIED_VALUE = 1;
      public static final int PARTIAL_DATA_OK_VALUE = 2;
      public static final int COMPLETE_DATA_OK_VALUE = 3;
      private static final Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {
         public LibraryUpdate.Status findValueByNumber(int number) {
            return LibraryUpdate.Status.forNumber(number);
         }
      };
      private static final LibraryUpdate.Status[] VALUES = values();
      private final int value;

      public final int getNumber() {
         return this.value;
      }

      /** @deprecated */
      @Deprecated
      public static LibraryUpdate.Status valueOf(int value) {
         return forNumber(value);
      }

      public static LibraryUpdate.Status forNumber(int value) {
         switch(value) {
         case 1:
            return NOT_MODIFIED;
         case 2:
            return PARTIAL_DATA_OK;
         case 3:
            return COMPLETE_DATA_OK;
         default:
            return null;
         }
      }

      public static Internal.EnumLiteMap internalGetValueMap() {
         return internalValueMap;
      }

      public final Descriptors.EnumValueDescriptor getValueDescriptor() {
         return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.ordinal());
      }

      public final Descriptors.EnumDescriptor getDescriptorForType() {
         return getDescriptor();
      }

      public static final Descriptors.EnumDescriptor getDescriptor() {
         return (Descriptors.EnumDescriptor)LibraryUpdate.getDescriptor().getEnumTypes().get(0);
      }

      public static LibraryUpdate.Status valueOf(Descriptors.EnumValueDescriptor desc) {
         if (desc.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
         } else {
            return VALUES[desc.getIndex()];
         }
      }

      private Status(int value) {
         this.value = value;
      }
   }
}
