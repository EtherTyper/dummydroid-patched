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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TestingProgram extends GeneratedMessageV3 implements TestingProgramOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int TESTERCAPREACHED_FIELD_NUMBER = 1;
   private boolean testerCapReached_;
   public static final int ISTESTINGPROGRAMDOC_FIELD_NUMBER = 2;
   private boolean isTestingProgramDoc_;
   public static final int ISTESTAPK_FIELD_NUMBER = 3;
   private boolean isTestApk_;
   public static final int DEVELOPERFEEDBACKURL_FIELD_NUMBER = 4;
   private volatile Object developerFeedbackUrl_;
   public static final int DEVELOPERFEEDBACKEMAILADDRESS_FIELD_NUMBER = 5;
   private volatile Object developerFeedbackEmailAddress_;
   public static final int TESTINGPROGRAMICON_FIELD_NUMBER = 6;
   private Image testingProgramIcon_;
   private byte memoizedIsInitialized;
   private static final TestingProgram DEFAULT_INSTANCE = new TestingProgram();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public TestingProgram parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new TestingProgram(input, extensionRegistry);
      }
   };

   private TestingProgram(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private TestingProgram() {
      this.memoizedIsInitialized = -1;
      this.developerFeedbackUrl_ = "";
      this.developerFeedbackEmailAddress_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new TestingProgram();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private TestingProgram(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               ByteString bs;
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 8:
                  this.bitField0_ |= 1;
                  this.testerCapReached_ = input.readBool();
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.isTestingProgramDoc_ = input.readBool();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.isTestApk_ = input.readBool();
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.developerFeedbackUrl_ = bs;
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.developerFeedbackEmailAddress_ = bs;
                  break;
               case 50:
                  Image.Builder subBuilder = null;
                  if ((this.bitField0_ & 32) != 0) {
                     subBuilder = this.testingProgramIcon_.toBuilder();
                  }

                  this.testingProgramIcon_ = (Image)input.readMessage(Image.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.testingProgramIcon_);
                     this.testingProgramIcon_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 32;
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
      return Mothership.internal_static_TestingProgram_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_TestingProgram_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgram.class, TestingProgram.Builder.class);
   }

   public boolean hasTesterCapReached() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getTesterCapReached() {
      return this.testerCapReached_;
   }

   public boolean hasIsTestingProgramDoc() {
      return (this.bitField0_ & 2) != 0;
   }

   public boolean getIsTestingProgramDoc() {
      return this.isTestingProgramDoc_;
   }

   public boolean hasIsTestApk() {
      return (this.bitField0_ & 4) != 0;
   }

   public boolean getIsTestApk() {
      return this.isTestApk_;
   }

   public boolean hasDeveloperFeedbackUrl() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDeveloperFeedbackUrl() {
      Object ref = this.developerFeedbackUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerFeedbackUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperFeedbackUrlBytes() {
      Object ref = this.developerFeedbackUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerFeedbackUrl_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDeveloperFeedbackEmailAddress() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getDeveloperFeedbackEmailAddress() {
      Object ref = this.developerFeedbackEmailAddress_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.developerFeedbackEmailAddress_ = s;
         }

         return s;
      }
   }

   public ByteString getDeveloperFeedbackEmailAddressBytes() {
      Object ref = this.developerFeedbackEmailAddress_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.developerFeedbackEmailAddress_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTestingProgramIcon() {
      return (this.bitField0_ & 32) != 0;
   }

   public Image getTestingProgramIcon() {
      return this.testingProgramIcon_ == null ? Image.getDefaultInstance() : this.testingProgramIcon_;
   }

   public ImageOrBuilder getTestingProgramIconOrBuilder() {
      return this.testingProgramIcon_ == null ? Image.getDefaultInstance() : this.testingProgramIcon_;
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
         output.writeBool(1, this.testerCapReached_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeBool(2, this.isTestingProgramDoc_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeBool(3, this.isTestApk_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.developerFeedbackUrl_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.developerFeedbackEmailAddress_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeMessage(6, this.getTestingProgramIcon());
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
            size += CodedOutputStream.computeBoolSize(1, this.testerCapReached_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeBoolSize(2, this.isTestingProgramDoc_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeBoolSize(3, this.isTestApk_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.developerFeedbackUrl_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.developerFeedbackEmailAddress_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeMessageSize(6, this.getTestingProgramIcon());
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof TestingProgram)) {
         return super.equals(obj);
      } else {
         TestingProgram other = (TestingProgram)obj;
         if (this.hasTesterCapReached() != other.hasTesterCapReached()) {
            return false;
         } else if (this.hasTesterCapReached() && this.getTesterCapReached() != other.getTesterCapReached()) {
            return false;
         } else if (this.hasIsTestingProgramDoc() != other.hasIsTestingProgramDoc()) {
            return false;
         } else if (this.hasIsTestingProgramDoc() && this.getIsTestingProgramDoc() != other.getIsTestingProgramDoc()) {
            return false;
         } else if (this.hasIsTestApk() != other.hasIsTestApk()) {
            return false;
         } else if (this.hasIsTestApk() && this.getIsTestApk() != other.getIsTestApk()) {
            return false;
         } else if (this.hasDeveloperFeedbackUrl() != other.hasDeveloperFeedbackUrl()) {
            return false;
         } else if (this.hasDeveloperFeedbackUrl() && !this.getDeveloperFeedbackUrl().equals(other.getDeveloperFeedbackUrl())) {
            return false;
         } else if (this.hasDeveloperFeedbackEmailAddress() != other.hasDeveloperFeedbackEmailAddress()) {
            return false;
         } else if (this.hasDeveloperFeedbackEmailAddress() && !this.getDeveloperFeedbackEmailAddress().equals(other.getDeveloperFeedbackEmailAddress())) {
            return false;
         } else if (this.hasTestingProgramIcon() != other.hasTestingProgramIcon()) {
            return false;
         } else if (this.hasTestingProgramIcon() && !this.getTestingProgramIcon().equals(other.getTestingProgramIcon())) {
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
         if (this.hasTesterCapReached()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getTesterCapReached());
         }

         if (this.hasIsTestingProgramDoc()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashBoolean(this.getIsTestingProgramDoc());
         }

         if (this.hasIsTestApk()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashBoolean(this.getIsTestApk());
         }

         if (this.hasDeveloperFeedbackUrl()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDeveloperFeedbackUrl().hashCode();
         }

         if (this.hasDeveloperFeedbackEmailAddress()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDeveloperFeedbackEmailAddress().hashCode();
         }

         if (this.hasTestingProgramIcon()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getTestingProgramIcon().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static TestingProgram parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data);
   }

   public static TestingProgram parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgram parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data);
   }

   public static TestingProgram parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgram parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data);
   }

   public static TestingProgram parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (TestingProgram)PARSER.parseFrom(data, extensionRegistry);
   }

   public static TestingProgram parseFrom(InputStream input) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgram parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgram parseDelimitedFrom(InputStream input) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static TestingProgram parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static TestingProgram parseFrom(CodedInputStream input) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static TestingProgram parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (TestingProgram)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public TestingProgram.Builder newBuilderForType() {
      return newBuilder();
   }

   public static TestingProgram.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static TestingProgram.Builder newBuilder(TestingProgram prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public TestingProgram.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new TestingProgram.Builder() : (new TestingProgram.Builder()).mergeFrom(this);
   }

   protected TestingProgram.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      TestingProgram.Builder builder = new TestingProgram.Builder(parent);
      return builder;
   }

   public static TestingProgram getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public TestingProgram getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   TestingProgram(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   TestingProgram(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements TestingProgramOrBuilder {
      private int bitField0_;
      private boolean testerCapReached_;
      private boolean isTestingProgramDoc_;
      private boolean isTestApk_;
      private Object developerFeedbackUrl_;
      private Object developerFeedbackEmailAddress_;
      private Image testingProgramIcon_;
      private SingleFieldBuilderV3 testingProgramIconBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_TestingProgram_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_TestingProgram_fieldAccessorTable.ensureFieldAccessorsInitialized(TestingProgram.class, TestingProgram.Builder.class);
      }

      private Builder() {
         this.developerFeedbackUrl_ = "";
         this.developerFeedbackEmailAddress_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.developerFeedbackUrl_ = "";
         this.developerFeedbackEmailAddress_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (TestingProgram.alwaysUseFieldBuilders) {
            this.getTestingProgramIconFieldBuilder();
         }

      }

      public TestingProgram.Builder clear() {
         super.clear();
         this.testerCapReached_ = false;
         this.bitField0_ &= -2;
         this.isTestingProgramDoc_ = false;
         this.bitField0_ &= -3;
         this.isTestApk_ = false;
         this.bitField0_ &= -5;
         this.developerFeedbackUrl_ = "";
         this.bitField0_ &= -9;
         this.developerFeedbackEmailAddress_ = "";
         this.bitField0_ &= -17;
         if (this.testingProgramIconBuilder_ == null) {
            this.testingProgramIcon_ = null;
         } else {
            this.testingProgramIconBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_TestingProgram_descriptor;
      }

      public TestingProgram getDefaultInstanceForType() {
         return TestingProgram.getDefaultInstance();
      }

      public TestingProgram build() {
         TestingProgram result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public TestingProgram buildPartial() {
         TestingProgram result = new TestingProgram(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.testerCapReached_ = this.testerCapReached_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.isTestingProgramDoc_ = this.isTestingProgramDoc_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.isTestApk_ = this.isTestApk_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.developerFeedbackUrl_ = this.developerFeedbackUrl_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.developerFeedbackEmailAddress_ = this.developerFeedbackEmailAddress_;
         if ((from_bitField0_ & 32) != 0) {
            if (this.testingProgramIconBuilder_ == null) {
               result.testingProgramIcon_ = this.testingProgramIcon_;
            } else {
               result.testingProgramIcon_ = (Image)this.testingProgramIconBuilder_.build();
            }

            to_bitField0_ |= 32;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public TestingProgram.Builder clone() {
         return (TestingProgram.Builder)super.clone();
      }

      public TestingProgram.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgram.Builder)super.setField(field, value);
      }

      public TestingProgram.Builder clearField(Descriptors.FieldDescriptor field) {
         return (TestingProgram.Builder)super.clearField(field);
      }

      public TestingProgram.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (TestingProgram.Builder)super.clearOneof(oneof);
      }

      public TestingProgram.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (TestingProgram.Builder)super.setRepeatedField(field, index, value);
      }

      public TestingProgram.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (TestingProgram.Builder)super.addRepeatedField(field, value);
      }

      public TestingProgram.Builder mergeFrom(Message other) {
         if (other instanceof TestingProgram) {
            return this.mergeFrom((TestingProgram)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public TestingProgram.Builder mergeFrom(TestingProgram other) {
         if (other == TestingProgram.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasTesterCapReached()) {
               this.setTesterCapReached(other.getTesterCapReached());
            }

            if (other.hasIsTestingProgramDoc()) {
               this.setIsTestingProgramDoc(other.getIsTestingProgramDoc());
            }

            if (other.hasIsTestApk()) {
               this.setIsTestApk(other.getIsTestApk());
            }

            if (other.hasDeveloperFeedbackUrl()) {
               this.bitField0_ |= 8;
               this.developerFeedbackUrl_ = other.developerFeedbackUrl_;
               this.onChanged();
            }

            if (other.hasDeveloperFeedbackEmailAddress()) {
               this.bitField0_ |= 16;
               this.developerFeedbackEmailAddress_ = other.developerFeedbackEmailAddress_;
               this.onChanged();
            }

            if (other.hasTestingProgramIcon()) {
               this.mergeTestingProgramIcon(other.getTestingProgramIcon());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public TestingProgram.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         TestingProgram parsedMessage = null;

         try {
            parsedMessage = (TestingProgram)TestingProgram.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (TestingProgram)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasTesterCapReached() {
         return (this.bitField0_ & 1) != 0;
      }

      public boolean getTesterCapReached() {
         return this.testerCapReached_;
      }

      public TestingProgram.Builder setTesterCapReached(boolean value) {
         this.bitField0_ |= 1;
         this.testerCapReached_ = value;
         this.onChanged();
         return this;
      }

      public TestingProgram.Builder clearTesterCapReached() {
         this.bitField0_ &= -2;
         this.testerCapReached_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasIsTestingProgramDoc() {
         return (this.bitField0_ & 2) != 0;
      }

      public boolean getIsTestingProgramDoc() {
         return this.isTestingProgramDoc_;
      }

      public TestingProgram.Builder setIsTestingProgramDoc(boolean value) {
         this.bitField0_ |= 2;
         this.isTestingProgramDoc_ = value;
         this.onChanged();
         return this;
      }

      public TestingProgram.Builder clearIsTestingProgramDoc() {
         this.bitField0_ &= -3;
         this.isTestingProgramDoc_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasIsTestApk() {
         return (this.bitField0_ & 4) != 0;
      }

      public boolean getIsTestApk() {
         return this.isTestApk_;
      }

      public TestingProgram.Builder setIsTestApk(boolean value) {
         this.bitField0_ |= 4;
         this.isTestApk_ = value;
         this.onChanged();
         return this;
      }

      public TestingProgram.Builder clearIsTestApk() {
         this.bitField0_ &= -5;
         this.isTestApk_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasDeveloperFeedbackUrl() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDeveloperFeedbackUrl() {
         Object ref = this.developerFeedbackUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerFeedbackUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperFeedbackUrlBytes() {
         Object ref = this.developerFeedbackUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerFeedbackUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TestingProgram.Builder setDeveloperFeedbackUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.developerFeedbackUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public TestingProgram.Builder clearDeveloperFeedbackUrl() {
         this.bitField0_ &= -9;
         this.developerFeedbackUrl_ = TestingProgram.getDefaultInstance().getDeveloperFeedbackUrl();
         this.onChanged();
         return this;
      }

      public TestingProgram.Builder setDeveloperFeedbackUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.developerFeedbackUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDeveloperFeedbackEmailAddress() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getDeveloperFeedbackEmailAddress() {
         Object ref = this.developerFeedbackEmailAddress_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.developerFeedbackEmailAddress_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDeveloperFeedbackEmailAddressBytes() {
         Object ref = this.developerFeedbackEmailAddress_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.developerFeedbackEmailAddress_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public TestingProgram.Builder setDeveloperFeedbackEmailAddress(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.developerFeedbackEmailAddress_ = value;
            this.onChanged();
            return this;
         }
      }

      public TestingProgram.Builder clearDeveloperFeedbackEmailAddress() {
         this.bitField0_ &= -17;
         this.developerFeedbackEmailAddress_ = TestingProgram.getDefaultInstance().getDeveloperFeedbackEmailAddress();
         this.onChanged();
         return this;
      }

      public TestingProgram.Builder setDeveloperFeedbackEmailAddressBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.developerFeedbackEmailAddress_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTestingProgramIcon() {
         return (this.bitField0_ & 32) != 0;
      }

      public Image getTestingProgramIcon() {
         if (this.testingProgramIconBuilder_ == null) {
            return this.testingProgramIcon_ == null ? Image.getDefaultInstance() : this.testingProgramIcon_;
         } else {
            return (Image)this.testingProgramIconBuilder_.getMessage();
         }
      }

      public TestingProgram.Builder setTestingProgramIcon(Image value) {
         if (this.testingProgramIconBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.testingProgramIcon_ = value;
            this.onChanged();
         } else {
            this.testingProgramIconBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public TestingProgram.Builder setTestingProgramIcon(Image.Builder builderForValue) {
         if (this.testingProgramIconBuilder_ == null) {
            this.testingProgramIcon_ = builderForValue.build();
            this.onChanged();
         } else {
            this.testingProgramIconBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public TestingProgram.Builder mergeTestingProgramIcon(Image value) {
         if (this.testingProgramIconBuilder_ == null) {
            if ((this.bitField0_ & 32) != 0 && this.testingProgramIcon_ != null && this.testingProgramIcon_ != Image.getDefaultInstance()) {
               this.testingProgramIcon_ = Image.newBuilder(this.testingProgramIcon_).mergeFrom(value).buildPartial();
            } else {
               this.testingProgramIcon_ = value;
            }

            this.onChanged();
         } else {
            this.testingProgramIconBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public TestingProgram.Builder clearTestingProgramIcon() {
         if (this.testingProgramIconBuilder_ == null) {
            this.testingProgramIcon_ = null;
            this.onChanged();
         } else {
            this.testingProgramIconBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public Image.Builder getTestingProgramIconBuilder() {
         this.bitField0_ |= 32;
         this.onChanged();
         return (Image.Builder)this.getTestingProgramIconFieldBuilder().getBuilder();
      }

      public ImageOrBuilder getTestingProgramIconOrBuilder() {
         if (this.testingProgramIconBuilder_ != null) {
            return (ImageOrBuilder)this.testingProgramIconBuilder_.getMessageOrBuilder();
         } else {
            return this.testingProgramIcon_ == null ? Image.getDefaultInstance() : this.testingProgramIcon_;
         }
      }

      private SingleFieldBuilderV3 getTestingProgramIconFieldBuilder() {
         if (this.testingProgramIconBuilder_ == null) {
            this.testingProgramIconBuilder_ = new SingleFieldBuilderV3(this.getTestingProgramIcon(), this.getParentForChildren(), this.isClean());
            this.testingProgramIcon_ = null;
         }

         return this.testingProgramIconBuilder_;
      }

      public final TestingProgram.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgram.Builder)super.setUnknownFields(unknownFields);
      }

      public final TestingProgram.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (TestingProgram.Builder)super.mergeUnknownFields(unknownFields);
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
