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

public final class ModifyLibraryResponse extends GeneratedMessageV3 implements ModifyLibraryResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LIBRARYUPDATE_FIELD_NUMBER = 1;
   private LibraryUpdate libraryUpdate_;
   private byte memoizedIsInitialized;
   private static final ModifyLibraryResponse DEFAULT_INSTANCE = new ModifyLibraryResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ModifyLibraryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ModifyLibraryResponse(input, extensionRegistry);
      }
   };

   private ModifyLibraryResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ModifyLibraryResponse() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ModifyLibraryResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ModifyLibraryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  LibraryUpdate.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.libraryUpdate_.toBuilder();
                  }

                  this.libraryUpdate_ = (LibraryUpdate)input.readMessage(LibraryUpdate.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.libraryUpdate_);
                     this.libraryUpdate_ = subBuilder.buildPartial();
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
      return Mothership.internal_static_ModifyLibraryResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ModifyLibraryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifyLibraryResponse.class, ModifyLibraryResponse.Builder.class);
   }

   public boolean hasLibraryUpdate() {
      return (this.bitField0_ & 1) != 0;
   }

   public LibraryUpdate getLibraryUpdate() {
      return this.libraryUpdate_ == null ? LibraryUpdate.getDefaultInstance() : this.libraryUpdate_;
   }

   public LibraryUpdateOrBuilder getLibraryUpdateOrBuilder() {
      return this.libraryUpdate_ == null ? LibraryUpdate.getDefaultInstance() : this.libraryUpdate_;
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
         output.writeMessage(1, this.getLibraryUpdate());
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
            size += CodedOutputStream.computeMessageSize(1, this.getLibraryUpdate());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ModifyLibraryResponse)) {
         return super.equals(obj);
      } else {
         ModifyLibraryResponse other = (ModifyLibraryResponse)obj;
         if (this.hasLibraryUpdate() != other.hasLibraryUpdate()) {
            return false;
         } else if (this.hasLibraryUpdate() && !this.getLibraryUpdate().equals(other.getLibraryUpdate())) {
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
         if (this.hasLibraryUpdate()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getLibraryUpdate().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ModifyLibraryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data);
   }

   public static ModifyLibraryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data);
   }

   public static ModifyLibraryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data);
   }

   public static ModifyLibraryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ModifyLibraryResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ModifyLibraryResponse parseFrom(InputStream input) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModifyLibraryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModifyLibraryResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ModifyLibraryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ModifyLibraryResponse parseFrom(CodedInputStream input) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ModifyLibraryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ModifyLibraryResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ModifyLibraryResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ModifyLibraryResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ModifyLibraryResponse.Builder newBuilder(ModifyLibraryResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ModifyLibraryResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ModifyLibraryResponse.Builder() : (new ModifyLibraryResponse.Builder()).mergeFrom(this);
   }

   protected ModifyLibraryResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ModifyLibraryResponse.Builder builder = new ModifyLibraryResponse.Builder(parent);
      return builder;
   }

   public static ModifyLibraryResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ModifyLibraryResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ModifyLibraryResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ModifyLibraryResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ModifyLibraryResponseOrBuilder {
      private int bitField0_;
      private LibraryUpdate libraryUpdate_;
      private SingleFieldBuilderV3 libraryUpdateBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ModifyLibraryResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ModifyLibraryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifyLibraryResponse.class, ModifyLibraryResponse.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ModifyLibraryResponse.alwaysUseFieldBuilders) {
            this.getLibraryUpdateFieldBuilder();
         }

      }

      public ModifyLibraryResponse.Builder clear() {
         super.clear();
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = null;
         } else {
            this.libraryUpdateBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ModifyLibraryResponse_descriptor;
      }

      public ModifyLibraryResponse getDefaultInstanceForType() {
         return ModifyLibraryResponse.getDefaultInstance();
      }

      public ModifyLibraryResponse build() {
         ModifyLibraryResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ModifyLibraryResponse buildPartial() {
         ModifyLibraryResponse result = new ModifyLibraryResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.libraryUpdateBuilder_ == null) {
               result.libraryUpdate_ = this.libraryUpdate_;
            } else {
               result.libraryUpdate_ = (LibraryUpdate)this.libraryUpdateBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ModifyLibraryResponse.Builder clone() {
         return (ModifyLibraryResponse.Builder)super.clone();
      }

      public ModifyLibraryResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ModifyLibraryResponse.Builder)super.setField(field, value);
      }

      public ModifyLibraryResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ModifyLibraryResponse.Builder)super.clearField(field);
      }

      public ModifyLibraryResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ModifyLibraryResponse.Builder)super.clearOneof(oneof);
      }

      public ModifyLibraryResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ModifyLibraryResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public ModifyLibraryResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ModifyLibraryResponse.Builder)super.addRepeatedField(field, value);
      }

      public ModifyLibraryResponse.Builder mergeFrom(Message other) {
         if (other instanceof ModifyLibraryResponse) {
            return this.mergeFrom((ModifyLibraryResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ModifyLibraryResponse.Builder mergeFrom(ModifyLibraryResponse other) {
         if (other == ModifyLibraryResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasLibraryUpdate()) {
               this.mergeLibraryUpdate(other.getLibraryUpdate());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public ModifyLibraryResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ModifyLibraryResponse parsedMessage = null;

         try {
            parsedMessage = (ModifyLibraryResponse)ModifyLibraryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ModifyLibraryResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasLibraryUpdate() {
         return (this.bitField0_ & 1) != 0;
      }

      public LibraryUpdate getLibraryUpdate() {
         if (this.libraryUpdateBuilder_ == null) {
            return this.libraryUpdate_ == null ? LibraryUpdate.getDefaultInstance() : this.libraryUpdate_;
         } else {
            return (LibraryUpdate)this.libraryUpdateBuilder_.getMessage();
         }
      }

      public ModifyLibraryResponse.Builder setLibraryUpdate(LibraryUpdate value) {
         if (this.libraryUpdateBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.libraryUpdate_ = value;
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ModifyLibraryResponse.Builder setLibraryUpdate(LibraryUpdate.Builder builderForValue) {
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = builderForValue.build();
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ModifyLibraryResponse.Builder mergeLibraryUpdate(LibraryUpdate value) {
         if (this.libraryUpdateBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.libraryUpdate_ != null && this.libraryUpdate_ != LibraryUpdate.getDefaultInstance()) {
               this.libraryUpdate_ = LibraryUpdate.newBuilder(this.libraryUpdate_).mergeFrom(value).buildPartial();
            } else {
               this.libraryUpdate_ = value;
            }

            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ModifyLibraryResponse.Builder clearLibraryUpdate() {
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = null;
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public LibraryUpdate.Builder getLibraryUpdateBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (LibraryUpdate.Builder)this.getLibraryUpdateFieldBuilder().getBuilder();
      }

      public LibraryUpdateOrBuilder getLibraryUpdateOrBuilder() {
         if (this.libraryUpdateBuilder_ != null) {
            return (LibraryUpdateOrBuilder)this.libraryUpdateBuilder_.getMessageOrBuilder();
         } else {
            return this.libraryUpdate_ == null ? LibraryUpdate.getDefaultInstance() : this.libraryUpdate_;
         }
      }

      private SingleFieldBuilderV3 getLibraryUpdateFieldBuilder() {
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdateBuilder_ = new SingleFieldBuilderV3(this.getLibraryUpdate(), this.getParentForChildren(), this.isClean());
            this.libraryUpdate_ = null;
         }

         return this.libraryUpdateBuilder_;
      }

      public final ModifyLibraryResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ModifyLibraryResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final ModifyLibraryResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ModifyLibraryResponse.Builder)super.mergeUnknownFields(unknownFields);
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
