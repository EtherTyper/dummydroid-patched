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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LibraryReplicationRequest extends GeneratedMessageV3 implements LibraryReplicationRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LIBRARYSTATE_FIELD_NUMBER = 1;
   private List libraryState_;
   public static final int LIBRARYMUTATIONVERSION_FIELD_NUMBER = 2;
   private int libraryMutationVersion_;
   private byte memoizedIsInitialized;
   private static final LibraryReplicationRequest DEFAULT_INSTANCE = new LibraryReplicationRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public LibraryReplicationRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new LibraryReplicationRequest(input, extensionRegistry);
      }
   };

   private LibraryReplicationRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private LibraryReplicationRequest() {
      this.memoizedIsInitialized = -1;
      this.libraryState_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new LibraryReplicationRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private LibraryReplicationRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  if (!(mutable_bitField0_ & true)) {
                     this.libraryState_ = new ArrayList();
                     mutable_bitField0_ |= true;
                  }

                  this.libraryState_.add(input.readMessage(ClientLibraryState.PARSER, extensionRegistry));
                  break;
               case 16:
                  this.bitField0_ |= 1;
                  this.libraryMutationVersion_ = input.readInt32();
                  break;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
               }
            }
         } catch (InvalidProtocolBufferException var11) {
            throw var11.setUnfinishedMessage(this);
         } catch (IOException var12) {
            throw (new InvalidProtocolBufferException(var12)).setUnfinishedMessage(this);
         } finally {
            if (mutable_bitField0_ & true) {
               this.libraryState_ = Collections.unmodifiableList(this.libraryState_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_LibraryReplicationRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_LibraryReplicationRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryReplicationRequest.class, LibraryReplicationRequest.Builder.class);
   }

   public List getLibraryStateList() {
      return this.libraryState_;
   }

   public List getLibraryStateOrBuilderList() {
      return this.libraryState_;
   }

   public int getLibraryStateCount() {
      return this.libraryState_.size();
   }

   public ClientLibraryState getLibraryState(int index) {
      return (ClientLibraryState)this.libraryState_.get(index);
   }

   public ClientLibraryStateOrBuilder getLibraryStateOrBuilder(int index) {
      return (ClientLibraryStateOrBuilder)this.libraryState_.get(index);
   }

   public boolean hasLibraryMutationVersion() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getLibraryMutationVersion() {
      return this.libraryMutationVersion_;
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
      for(int i = 0; i < this.libraryState_.size(); ++i) {
         output.writeMessage(1, (MessageLite)this.libraryState_.get(i));
      }

      if ((this.bitField0_ & 1) != 0) {
         output.writeInt32(2, this.libraryMutationVersion_);
      }

      this.unknownFields.writeTo(output);
   }

   public int getSerializedSize() {
      int size = this.memoizedSize;
      if (size != -1) {
         return size;
      } else {
         size = 0;

         for(int i = 0; i < this.libraryState_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.libraryState_.get(i));
         }

         if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.libraryMutationVersion_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof LibraryReplicationRequest)) {
         return super.equals(obj);
      } else {
         LibraryReplicationRequest other = (LibraryReplicationRequest)obj;
         if (!this.getLibraryStateList().equals(other.getLibraryStateList())) {
            return false;
         } else if (this.hasLibraryMutationVersion() != other.hasLibraryMutationVersion()) {
            return false;
         } else if (this.hasLibraryMutationVersion() && this.getLibraryMutationVersion() != other.getLibraryMutationVersion()) {
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
         if (this.getLibraryStateCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getLibraryStateList().hashCode();
         }

         if (this.hasLibraryMutationVersion()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getLibraryMutationVersion();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static LibraryReplicationRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data);
   }

   public static LibraryReplicationRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryReplicationRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data);
   }

   public static LibraryReplicationRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryReplicationRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data);
   }

   public static LibraryReplicationRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryReplicationRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryReplicationRequest parseFrom(InputStream input) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryReplicationRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryReplicationRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static LibraryReplicationRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryReplicationRequest parseFrom(CodedInputStream input) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryReplicationRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryReplicationRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public LibraryReplicationRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static LibraryReplicationRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static LibraryReplicationRequest.Builder newBuilder(LibraryReplicationRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public LibraryReplicationRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new LibraryReplicationRequest.Builder() : (new LibraryReplicationRequest.Builder()).mergeFrom(this);
   }

   protected LibraryReplicationRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      LibraryReplicationRequest.Builder builder = new LibraryReplicationRequest.Builder(parent);
      return builder;
   }

   public static LibraryReplicationRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public LibraryReplicationRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   LibraryReplicationRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   LibraryReplicationRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements LibraryReplicationRequestOrBuilder {
      private int bitField0_;
      private List libraryState_;
      private RepeatedFieldBuilderV3 libraryStateBuilder_;
      private int libraryMutationVersion_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_LibraryReplicationRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_LibraryReplicationRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryReplicationRequest.class, LibraryReplicationRequest.Builder.class);
      }

      private Builder() {
         this.libraryState_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.libraryState_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (LibraryReplicationRequest.alwaysUseFieldBuilders) {
            this.getLibraryStateFieldBuilder();
         }

      }

      public LibraryReplicationRequest.Builder clear() {
         super.clear();
         if (this.libraryStateBuilder_ == null) {
            this.libraryState_ = Collections.emptyList();
            this.bitField0_ &= -2;
         } else {
            this.libraryStateBuilder_.clear();
         }

         this.libraryMutationVersion_ = 0;
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_LibraryReplicationRequest_descriptor;
      }

      public LibraryReplicationRequest getDefaultInstanceForType() {
         return LibraryReplicationRequest.getDefaultInstance();
      }

      public LibraryReplicationRequest build() {
         LibraryReplicationRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public LibraryReplicationRequest buildPartial() {
         LibraryReplicationRequest result = new LibraryReplicationRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if (this.libraryStateBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0) {
               this.libraryState_ = Collections.unmodifiableList(this.libraryState_);
               this.bitField0_ &= -2;
            }

            result.libraryState_ = this.libraryState_;
         } else {
            result.libraryState_ = this.libraryStateBuilder_.build();
         }

         if ((from_bitField0_ & 2) != 0) {
            result.libraryMutationVersion_ = this.libraryMutationVersion_;
            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public LibraryReplicationRequest.Builder clone() {
         return (LibraryReplicationRequest.Builder)super.clone();
      }

      public LibraryReplicationRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryReplicationRequest.Builder)super.setField(field, value);
      }

      public LibraryReplicationRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (LibraryReplicationRequest.Builder)super.clearField(field);
      }

      public LibraryReplicationRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (LibraryReplicationRequest.Builder)super.clearOneof(oneof);
      }

      public LibraryReplicationRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (LibraryReplicationRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public LibraryReplicationRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryReplicationRequest.Builder)super.addRepeatedField(field, value);
      }

      public LibraryReplicationRequest.Builder mergeFrom(Message other) {
         if (other instanceof LibraryReplicationRequest) {
            return this.mergeFrom((LibraryReplicationRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public LibraryReplicationRequest.Builder mergeFrom(LibraryReplicationRequest other) {
         if (other == LibraryReplicationRequest.getDefaultInstance()) {
            return this;
         } else {
            if (this.libraryStateBuilder_ == null) {
               if (!other.libraryState_.isEmpty()) {
                  if (this.libraryState_.isEmpty()) {
                     this.libraryState_ = other.libraryState_;
                     this.bitField0_ &= -2;
                  } else {
                     this.ensureLibraryStateIsMutable();
                     this.libraryState_.addAll(other.libraryState_);
                  }

                  this.onChanged();
               }
            } else if (!other.libraryState_.isEmpty()) {
               if (this.libraryStateBuilder_.isEmpty()) {
                  this.libraryStateBuilder_.dispose();
                  this.libraryStateBuilder_ = null;
                  this.libraryState_ = other.libraryState_;
                  this.bitField0_ &= -2;
                  this.libraryStateBuilder_ = LibraryReplicationRequest.alwaysUseFieldBuilders ? this.getLibraryStateFieldBuilder() : null;
               } else {
                  this.libraryStateBuilder_.addAllMessages(other.libraryState_);
               }
            }

            if (other.hasLibraryMutationVersion()) {
               this.setLibraryMutationVersion(other.getLibraryMutationVersion());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public LibraryReplicationRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         LibraryReplicationRequest parsedMessage = null;

         try {
            parsedMessage = (LibraryReplicationRequest)LibraryReplicationRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (LibraryReplicationRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      private void ensureLibraryStateIsMutable() {
         if ((this.bitField0_ & 1) == 0) {
            this.libraryState_ = new ArrayList(this.libraryState_);
            this.bitField0_ |= 1;
         }

      }

      public List getLibraryStateList() {
         return this.libraryStateBuilder_ == null ? Collections.unmodifiableList(this.libraryState_) : this.libraryStateBuilder_.getMessageList();
      }

      public int getLibraryStateCount() {
         return this.libraryStateBuilder_ == null ? this.libraryState_.size() : this.libraryStateBuilder_.getCount();
      }

      public ClientLibraryState getLibraryState(int index) {
         return this.libraryStateBuilder_ == null ? (ClientLibraryState)this.libraryState_.get(index) : (ClientLibraryState)this.libraryStateBuilder_.getMessage(index);
      }

      public LibraryReplicationRequest.Builder setLibraryState(int index, ClientLibraryState value) {
         if (this.libraryStateBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureLibraryStateIsMutable();
            this.libraryState_.set(index, value);
            this.onChanged();
         } else {
            this.libraryStateBuilder_.setMessage(index, value);
         }

         return this;
      }

      public LibraryReplicationRequest.Builder setLibraryState(int index, ClientLibraryState.Builder builderForValue) {
         if (this.libraryStateBuilder_ == null) {
            this.ensureLibraryStateIsMutable();
            this.libraryState_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.libraryStateBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public LibraryReplicationRequest.Builder addLibraryState(ClientLibraryState value) {
         if (this.libraryStateBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureLibraryStateIsMutable();
            this.libraryState_.add(value);
            this.onChanged();
         } else {
            this.libraryStateBuilder_.addMessage(value);
         }

         return this;
      }

      public LibraryReplicationRequest.Builder addLibraryState(int index, ClientLibraryState value) {
         if (this.libraryStateBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureLibraryStateIsMutable();
            this.libraryState_.add(index, value);
            this.onChanged();
         } else {
            this.libraryStateBuilder_.addMessage(index, value);
         }

         return this;
      }

      public LibraryReplicationRequest.Builder addLibraryState(ClientLibraryState.Builder builderForValue) {
         if (this.libraryStateBuilder_ == null) {
            this.ensureLibraryStateIsMutable();
            this.libraryState_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.libraryStateBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public LibraryReplicationRequest.Builder addLibraryState(int index, ClientLibraryState.Builder builderForValue) {
         if (this.libraryStateBuilder_ == null) {
            this.ensureLibraryStateIsMutable();
            this.libraryState_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.libraryStateBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public LibraryReplicationRequest.Builder addAllLibraryState(Iterable values) {
         if (this.libraryStateBuilder_ == null) {
            this.ensureLibraryStateIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.libraryState_);
            this.onChanged();
         } else {
            this.libraryStateBuilder_.addAllMessages(values);
         }

         return this;
      }

      public LibraryReplicationRequest.Builder clearLibraryState() {
         if (this.libraryStateBuilder_ == null) {
            this.libraryState_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
         } else {
            this.libraryStateBuilder_.clear();
         }

         return this;
      }

      public LibraryReplicationRequest.Builder removeLibraryState(int index) {
         if (this.libraryStateBuilder_ == null) {
            this.ensureLibraryStateIsMutable();
            this.libraryState_.remove(index);
            this.onChanged();
         } else {
            this.libraryStateBuilder_.remove(index);
         }

         return this;
      }

      public ClientLibraryState.Builder getLibraryStateBuilder(int index) {
         return (ClientLibraryState.Builder)this.getLibraryStateFieldBuilder().getBuilder(index);
      }

      public ClientLibraryStateOrBuilder getLibraryStateOrBuilder(int index) {
         return this.libraryStateBuilder_ == null ? (ClientLibraryStateOrBuilder)this.libraryState_.get(index) : (ClientLibraryStateOrBuilder)this.libraryStateBuilder_.getMessageOrBuilder(index);
      }

      public List getLibraryStateOrBuilderList() {
         return this.libraryStateBuilder_ != null ? this.libraryStateBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.libraryState_);
      }

      public ClientLibraryState.Builder addLibraryStateBuilder() {
         return (ClientLibraryState.Builder)this.getLibraryStateFieldBuilder().addBuilder(ClientLibraryState.getDefaultInstance());
      }

      public ClientLibraryState.Builder addLibraryStateBuilder(int index) {
         return (ClientLibraryState.Builder)this.getLibraryStateFieldBuilder().addBuilder(index, ClientLibraryState.getDefaultInstance());
      }

      public List getLibraryStateBuilderList() {
         return this.getLibraryStateFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getLibraryStateFieldBuilder() {
         if (this.libraryStateBuilder_ == null) {
            this.libraryStateBuilder_ = new RepeatedFieldBuilderV3(this.libraryState_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
            this.libraryState_ = null;
         }

         return this.libraryStateBuilder_;
      }

      public boolean hasLibraryMutationVersion() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getLibraryMutationVersion() {
         return this.libraryMutationVersion_;
      }

      public LibraryReplicationRequest.Builder setLibraryMutationVersion(int value) {
         this.bitField0_ |= 2;
         this.libraryMutationVersion_ = value;
         this.onChanged();
         return this;
      }

      public LibraryReplicationRequest.Builder clearLibraryMutationVersion() {
         this.bitField0_ &= -3;
         this.libraryMutationVersion_ = 0;
         this.onChanged();
         return this;
      }

      public final LibraryReplicationRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryReplicationRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final LibraryReplicationRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryReplicationRequest.Builder)super.mergeUnknownFields(unknownFields);
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
