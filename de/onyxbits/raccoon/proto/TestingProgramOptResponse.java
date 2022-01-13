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

public final class TestingProgramOptResponse extends GeneratedMessageV3 implements TestingProgramOptResponseOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int ERRORSTATUS_FIELD_NUMBER = 1;
   private int errorStatus_;
   public static final int LIBRARYUPDATE_FIELD_NUMBER = 2;
   private LibraryUpdate libraryUpdate_;
   private byte memoizedIsInitialized;
   private static final TestingProgramOptResponse DEFAULT_INSTANCE = new TestingProgramOptResponse();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public TestingProgramOptResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new TestingProgramOptResponse(input, extensionRegistry);
      }
   };

   private TestingProgramOptResponse(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private TestingProgramOptResponse() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new TestingProgramOptResponse();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private TestingProgramOptResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.errorStatus_ = input.readInt32();
                  break;
               case 18:
                  LibraryUpdate.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.libraryUpdate_.toBuilder();
                  }

                  this.libraryUpdate_ = (LibraryUpdate)input.readMessage(LibraryUpdate.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.libraryUpdate_);
                     this.libraryUpdate_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
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
      return Mothership.internal_static_TestingProgramOptResponse_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_TestingProgramOptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgramOptResponse.class, TestingProgramOptResponse.Builder.class);
   }

   public boolean hasErrorStatus() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getErrorStatus() {
      return this.errorStatus_;
   }

   public boolean hasLibraryUpdate() {
      return (this.bitField0_ & 2) != 0;
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
         output.writeInt32(1, this.errorStatus_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeMessage(2, this.getLibraryUpdate());
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
            size += CodedOutputStream.computeInt32Size(1, this.errorStatus_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getLibraryUpdate());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof TestingProgramOptResponse)) {
         return super.equals(obj);
      } else {
         TestingProgramOptResponse other = (TestingProgramOptResponse)obj;
         if (this.hasErrorStatus() != other.hasErrorStatus()) {
            return false;
         } else if (this.hasErrorStatus() && this.getErrorStatus() != other.getErrorStatus()) {
            return false;
         } else if (this.hasLibraryUpdate() != other.hasLibraryUpdate()) {
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
         if (this.hasErrorStatus()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getErrorStatus();
         }

         if (this.hasLibraryUpdate()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getLibraryUpdate().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static TestingProgramOptResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data);
   }

   public static TestingProgramOptResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data);
   }

   public static TestingProgramOptResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data);
   }

   public static TestingProgramOptResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptResponse)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptResponse parseFrom(InputStream input) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgramOptResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgramOptResponse parseDelimitedFrom(InputStream input) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static TestingProgramOptResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgramOptResponse parseFrom(CodedInputStream input) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgramOptResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptResponse)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public TestingProgramOptResponse.Builder newBuilderForType() {
      return newBuilder();
   }

   public static TestingProgramOptResponse.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static TestingProgramOptResponse.Builder newBuilder(TestingProgramOptResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public TestingProgramOptResponse.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new TestingProgramOptResponse.Builder() : (new TestingProgramOptResponse.Builder()).mergeFrom(this);
   }

   protected TestingProgramOptResponse.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      TestingProgramOptResponse.Builder builder = new TestingProgramOptResponse.Builder(parent);
      return builder;
   }

   public static TestingProgramOptResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public TestingProgramOptResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   TestingProgramOptResponse(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   TestingProgramOptResponse(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements TestingProgramOptResponseOrBuilder {
      private int bitField0_;
      private int errorStatus_;
      private LibraryUpdate libraryUpdate_;
      private SingleFieldBuilderV3 libraryUpdateBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_TestingProgramOptResponse_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_TestingProgramOptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgramOptResponse.class, TestingProgramOptResponse.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (TestingProgramOptResponse.alwaysUseFieldBuilders) {
            this.getLibraryUpdateFieldBuilder();
         }

      }

      public TestingProgramOptResponse.Builder clear() {
         super.clear();
         this.errorStatus_ = 0;
         this.bitField0_ &= -2;
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = null;
         } else {
            this.libraryUpdateBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_TestingProgramOptResponse_descriptor;
      }

      public TestingProgramOptResponse getDefaultInstanceForType() {
         return TestingProgramOptResponse.getDefaultInstance();
      }

      public TestingProgramOptResponse build() {
         TestingProgramOptResponse result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public TestingProgramOptResponse buildPartial() {
         TestingProgramOptResponse result = new TestingProgramOptResponse(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.errorStatus_ = this.errorStatus_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.libraryUpdateBuilder_ == null) {
               result.libraryUpdate_ = this.libraryUpdate_;
            } else {
               result.libraryUpdate_ = (LibraryUpdate)this.libraryUpdateBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public TestingProgramOptResponse.Builder clone() {
         return (TestingProgramOptResponse.Builder)super.clone();
      }

      public TestingProgramOptResponse.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgramOptResponse.Builder)super.setField(field, value);
      }

      public TestingProgramOptResponse.Builder clearField(Descriptors.FieldDescriptor field) {
         return (TestingProgramOptResponse.Builder)super.clearField(field);
      }

      public TestingProgramOptResponse.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (TestingProgramOptResponse.Builder)super.clearOneof(oneof);
      }

      public TestingProgramOptResponse.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (TestingProgramOptResponse.Builder)super.setRepeatedField(field, index, value);
      }

      public TestingProgramOptResponse.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgramOptResponse.Builder)super.addRepeatedField(field, value);
      }

      public TestingProgramOptResponse.Builder mergeFrom(Message other) {
         if (other instanceof TestingProgramOptResponse) {
            return this.mergeFrom((TestingProgramOptResponse)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public TestingProgramOptResponse.Builder mergeFrom(TestingProgramOptResponse other) {
         if (other == TestingProgramOptResponse.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasErrorStatus()) {
               this.setErrorStatus(other.getErrorStatus());
            }

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

      public TestingProgramOptResponse.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         TestingProgramOptResponse parsedMessage = null;

         try {
            parsedMessage = (TestingProgramOptResponse)TestingProgramOptResponse.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (TestingProgramOptResponse)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasErrorStatus() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getErrorStatus() {
         return this.errorStatus_;
      }

      public TestingProgramOptResponse.Builder setErrorStatus(int value) {
         this.bitField0_ |= 1;
         this.errorStatus_ = value;
         this.onChanged();
         return this;
      }

      public TestingProgramOptResponse.Builder clearErrorStatus() {
         this.bitField0_ &= -2;
         this.errorStatus_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasLibraryUpdate() {
         return (this.bitField0_ & 2) != 0;
      }

      public LibraryUpdate getLibraryUpdate() {
         if (this.libraryUpdateBuilder_ == null) {
            return this.libraryUpdate_ == null ? LibraryUpdate.getDefaultInstance() : this.libraryUpdate_;
         } else {
            return (LibraryUpdate)this.libraryUpdateBuilder_.getMessage();
         }
      }

      public TestingProgramOptResponse.Builder setLibraryUpdate(LibraryUpdate value) {
         if (this.libraryUpdateBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.libraryUpdate_ = value;
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public TestingProgramOptResponse.Builder setLibraryUpdate(LibraryUpdate.Builder builderForValue) {
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = builderForValue.build();
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public TestingProgramOptResponse.Builder mergeLibraryUpdate(LibraryUpdate value) {
         if (this.libraryUpdateBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.libraryUpdate_ != null && this.libraryUpdate_ != LibraryUpdate.getDefaultInstance()) {
               this.libraryUpdate_ = LibraryUpdate.newBuilder(this.libraryUpdate_).mergeFrom(value).buildPartial();
            } else {
               this.libraryUpdate_ = value;
            }

            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public TestingProgramOptResponse.Builder clearLibraryUpdate() {
         if (this.libraryUpdateBuilder_ == null) {
            this.libraryUpdate_ = null;
            this.onChanged();
         } else {
            this.libraryUpdateBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public LibraryUpdate.Builder getLibraryUpdateBuilder() {
         this.bitField0_ |= 2;
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

      public final TestingProgramOptResponse.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgramOptResponse.Builder)super.setUnknownFields(unknownFields);
      }

      public final TestingProgramOptResponse.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgramOptResponse.Builder)super.mergeUnknownFields(unknownFields);
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
