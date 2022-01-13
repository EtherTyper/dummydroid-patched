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

public final class TestingProgramOptRequest extends GeneratedMessageV3 implements TestingProgramOptRequestOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PACKAGENAME_FIELD_NUMBER = 1;
   private volatile Object packageName_;
   public static final int SUBSCRIBE_FIELD_NUMBER = 2;
   private boolean subscribe_;
   private byte memoizedIsInitialized;
   private static final TestingProgramOptRequest DEFAULT_INSTANCE = new TestingProgramOptRequest();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public TestingProgramOptRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new TestingProgramOptRequest(input, extensionRegistry);
      }
   };

   private TestingProgramOptRequest(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private TestingProgramOptRequest() {
      this.memoizedIsInitialized = -1;
      this.packageName_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new TestingProgramOptRequest();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private TestingProgramOptRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.bitField0_ |= 1;
                  this.packageName_ = bs;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.subscribe_ = input.readBool();
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
      return Mothership.internal_static_TestingProgramOptRequest_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_TestingProgramOptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgramOptRequest.class, TestingProgramOptRequest.Builder.class);
   }

   public boolean hasPackageName() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getPackageName() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.packageName_ = s;
         }

         return s;
      }
   }

   public ByteString getPackageNameBytes() {
      Object ref = this.packageName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.packageName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSubscribe() {
      return (this.bitField0_ & 2) != 0;
   }

   public boolean getSubscribe() {
      return this.subscribe_;
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
         GeneratedMessageV3.writeString(output, 1, this.packageName_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBool(2, this.subscribe_);
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
            size += GeneratedMessageV3.computeStringSize(1, this.packageName_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBoolSize(2, this.subscribe_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof TestingProgramOptRequest)) {
         return super.equals(obj);
      } else {
         TestingProgramOptRequest other = (TestingProgramOptRequest)obj;
         if (this.hasPackageName() != other.hasPackageName()) {
            return false;
         } else if (this.hasPackageName() && !this.getPackageName().equals(other.getPackageName())) {
            return false;
         } else if (this.hasSubscribe() != other.hasSubscribe()) {
            return false;
         } else if (this.hasSubscribe() && this.getSubscribe() != other.getSubscribe()) {
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
         if (this.hasPackageName()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPackageName().hashCode();
         }

         if (this.hasSubscribe()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashBoolean(this.getSubscribe());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static TestingProgramOptRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data);
   }

   public static TestingProgramOptRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data);
   }

   public static TestingProgramOptRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data);
   }

   public static TestingProgramOptRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgramOptRequest)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgramOptRequest parseFrom(InputStream input) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgramOptRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgramOptRequest parseDelimitedFrom(InputStream input) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static TestingProgramOptRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgramOptRequest parseFrom(CodedInputStream input) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgramOptRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgramOptRequest)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public TestingProgramOptRequest.Builder newBuilderForType() {
      return newBuilder();
   }

   public static TestingProgramOptRequest.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static TestingProgramOptRequest.Builder newBuilder(TestingProgramOptRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public TestingProgramOptRequest.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new TestingProgramOptRequest.Builder() : (new TestingProgramOptRequest.Builder()).mergeFrom(this);
   }

   protected TestingProgramOptRequest.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      TestingProgramOptRequest.Builder builder = new TestingProgramOptRequest.Builder(parent);
      return builder;
   }

   public static TestingProgramOptRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public TestingProgramOptRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   TestingProgramOptRequest(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   TestingProgramOptRequest(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements TestingProgramOptRequestOrBuilder {
      private int bitField0_;
      private Object packageName_;
      private boolean subscribe_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_TestingProgramOptRequest_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_TestingProgramOptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgramOptRequest.class, TestingProgramOptRequest.Builder.class);
      }

      private Builder() {
         this.packageName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.packageName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (TestingProgramOptRequest.alwaysUseFieldBuilders) {
         }

      }

      public TestingProgramOptRequest.Builder clear() {
         super.clear();
         this.packageName_ = "";
         this.bitField0_ &= -2;
         this.subscribe_ = false;
         this.bitField0_ &= -3;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_TestingProgramOptRequest_descriptor;
      }

      public TestingProgramOptRequest getDefaultInstanceForType() {
         return TestingProgramOptRequest.getDefaultInstance();
      }

      public TestingProgramOptRequest build() {
         TestingProgramOptRequest result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public TestingProgramOptRequest buildPartial() {
         TestingProgramOptRequest result = new TestingProgramOptRequest(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.packageName_ = this.packageName_;
         if ((from_bitField0_ & 2) != 0) {
            result.subscribe_ = this.subscribe_;
            to_bitField0_ |= 2;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public TestingProgramOptRequest.Builder clone() {
         return (TestingProgramOptRequest.Builder)super.clone();
      }

      public TestingProgramOptRequest.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgramOptRequest.Builder)super.setField(field, value);
      }

      public TestingProgramOptRequest.Builder clearField(Descriptors.FieldDescriptor field) {
         return (TestingProgramOptRequest.Builder)super.clearField(field);
      }

      public TestingProgramOptRequest.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (TestingProgramOptRequest.Builder)super.clearOneof(oneof);
      }

      public TestingProgramOptRequest.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (TestingProgramOptRequest.Builder)super.setRepeatedField(field, index, value);
      }

      public TestingProgramOptRequest.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgramOptRequest.Builder)super.addRepeatedField(field, value);
      }

      public TestingProgramOptRequest.Builder mergeFrom(Message other) {
         if (other instanceof TestingProgramOptRequest) {
            return this.mergeFrom((TestingProgramOptRequest)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public TestingProgramOptRequest.Builder mergeFrom(TestingProgramOptRequest other) {
         if (other == TestingProgramOptRequest.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPackageName()) {
               this.bitField0_ |= 1;
               this.packageName_ = other.packageName_;
               this.onChanged();
            }

            if (other.hasSubscribe()) {
               this.setSubscribe(other.getSubscribe());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public TestingProgramOptRequest.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         TestingProgramOptRequest parsedMessage = null;

         try {
            parsedMessage = (TestingProgramOptRequest)TestingProgramOptRequest.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (TestingProgramOptRequest)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasPackageName() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getPackageName() {
         Object ref = this.packageName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.packageName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getPackageNameBytes() {
         Object ref = this.packageName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.packageName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TestingProgramOptRequest.Builder setPackageName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public TestingProgramOptRequest.Builder clearPackageName() {
         this.bitField0_ &= -2;
         this.packageName_ = TestingProgramOptRequest.getDefaultInstance().getPackageName();
         this.onChanged();
         return this;
      }

      public TestingProgramOptRequest.Builder setPackageNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSubscribe() {
         return (this.bitField0_ & 2) != 0;
      }

      public boolean getSubscribe() {
         return this.subscribe_;
      }

      public TestingProgramOptRequest.Builder setSubscribe(boolean value) {
         this.bitField0_ |= 2;
         this.subscribe_ = value;
         this.onChanged();
         return this;
      }

      public TestingProgramOptRequest.Builder clearSubscribe() {
         this.bitField0_ &= -3;
         this.subscribe_ = false;
         this.onChanged();
         return this;
      }

      public final TestingProgramOptRequest.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgramOptRequest.Builder)super.setUnknownFields(unknownFields);
      }

      public final TestingProgramOptRequest.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgramOptRequest.Builder)super.mergeUnknownFields(unknownFields);
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
