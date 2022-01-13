package de.onyxbits.raccoon.proto;

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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LibraryMutation extends GeneratedMessageV3 implements LibraryMutationOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DELETED_FIELD_NUMBER = 4;
   private boolean deleted_;
   private byte memoizedIsInitialized;
   private static final LibraryMutation DEFAULT_INSTANCE = new LibraryMutation();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public LibraryMutation parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new LibraryMutation(input, extensionRegistry);
      }
   };

   private LibraryMutation(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private LibraryMutation() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new LibraryMutation();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private LibraryMutation(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 32:
                  this.bitField0_ |= 1;
                  this.deleted_ = input.readBool();
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
            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_LibraryMutation_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_LibraryMutation_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryMutation.class, LibraryMutation.Builder.class);
   }

   public boolean hasDeleted() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getDeleted() {
      return this.deleted_;
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
         output.writeBool(4, this.deleted_);
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
            size += CodedOutputStream.computeBoolSize(4, this.deleted_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof LibraryMutation)) {
         return super.equals(obj);
      } else {
         LibraryMutation other = (LibraryMutation)obj;
         if (this.hasDeleted() != other.hasDeleted()) {
            return false;
         } else if (this.hasDeleted() && this.getDeleted() != other.getDeleted()) {
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
         if (this.hasDeleted()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + Internal.hashBoolean(this.getDeleted());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static LibraryMutation parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data);
   }

   public static LibraryMutation parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryMutation parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data);
   }

   public static LibraryMutation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryMutation parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data);
   }

   public static LibraryMutation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (LibraryMutation)PARSER.parseFrom(data, extensionRegistry);
   }

   public static LibraryMutation parseFrom(InputStream input) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryMutation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryMutation parseDelimitedFrom(InputStream input) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static LibraryMutation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static LibraryMutation parseFrom(CodedInputStream input) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static LibraryMutation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (LibraryMutation)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public LibraryMutation.Builder newBuilderForType() {
      return newBuilder();
   }

   public static LibraryMutation.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static LibraryMutation.Builder newBuilder(LibraryMutation prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public LibraryMutation.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new LibraryMutation.Builder() : (new LibraryMutation.Builder()).mergeFrom(this);
   }

   protected LibraryMutation.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      LibraryMutation.Builder builder = new LibraryMutation.Builder(parent);
      return builder;
   }

   public static LibraryMutation getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public LibraryMutation getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   LibraryMutation(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   LibraryMutation(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements LibraryMutationOrBuilder {
      private int bitField0_;
      private boolean deleted_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_LibraryMutation_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_LibraryMutation_fieldAccessorTable.ensureFieldAccessorsInitialized(LibraryMutation.class, LibraryMutation.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (LibraryMutation.alwaysUseFieldBuilders) {
         }

      }

      public LibraryMutation.Builder clear() {
         super.clear();
         this.deleted_ = false;
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_LibraryMutation_descriptor;
      }

      public LibraryMutation getDefaultInstanceForType() {
         return LibraryMutation.getDefaultInstance();
      }

      public LibraryMutation build() {
         LibraryMutation result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public LibraryMutation buildPartial() {
         LibraryMutation result = new LibraryMutation(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.deleted_ = this.deleted_;
            to_bitField0_ |= 1;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public LibraryMutation.Builder clone() {
         return (LibraryMutation.Builder)super.clone();
      }

      public LibraryMutation.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryMutation.Builder)super.setField(field, value);
      }

      public LibraryMutation.Builder clearField(Descriptors.FieldDescriptor field) {
         return (LibraryMutation.Builder)super.clearField(field);
      }

      public LibraryMutation.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (LibraryMutation.Builder)super.clearOneof(oneof);
      }

      public LibraryMutation.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (LibraryMutation.Builder)super.setRepeatedField(field, index, value);
      }

      public LibraryMutation.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (LibraryMutation.Builder)super.addRepeatedField(field, value);
      }

      public LibraryMutation.Builder mergeFrom(Message other) {
         if (other instanceof LibraryMutation) {
            return this.mergeFrom((LibraryMutation)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public LibraryMutation.Builder mergeFrom(LibraryMutation other) {
         if (other == LibraryMutation.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDeleted()) {
               this.setDeleted(other.getDeleted());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public LibraryMutation.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         LibraryMutation parsedMessage = null;

         try {
            parsedMessage = (LibraryMutation)LibraryMutation.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (LibraryMutation)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDeleted() {
         return (this.bitField0_ & 1) != 0;
      }

      public boolean getDeleted() {
         return this.deleted_;
      }

      public LibraryMutation.Builder setDeleted(boolean value) {
         this.bitField0_ |= 1;
         this.deleted_ = value;
         this.onChanged();
         return this;
      }

      public LibraryMutation.Builder clearDeleted() {
         this.bitField0_ &= -2;
         this.deleted_ = false;
         this.onChanged();
         return this;
      }

      public final LibraryMutation.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryMutation.Builder)super.setUnknownFields(unknownFields);
      }

      public final LibraryMutation.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (LibraryMutation.Builder)super.mergeUnknownFields(unknownFields);
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
