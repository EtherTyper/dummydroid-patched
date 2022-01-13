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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Dependency extends GeneratedMessageV3 implements DependencyOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PACKAGENAME_FIELD_NUMBER = 1;
   private volatile Object packageName_;
   public static final int MINVERSIONCODE_FIELD_NUMBER = 2;
   private int minVersionCode_;
   public static final int VERSIONCODEMASK_FIELD_NUMBER = 3;
   private int versionCodeMask_;
   private byte memoizedIsInitialized;
   private static final Dependency DEFAULT_INSTANCE = new Dependency();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Dependency parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Dependency(input, extensionRegistry);
      }
   };

   private Dependency(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Dependency() {
      this.memoizedIsInitialized = -1;
      this.packageName_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Dependency();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Dependency(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.minVersionCode_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.versionCodeMask_ = input.readInt32();
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
      return Mothership.internal_static_Dependency_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Dependency_fieldAccessorTable.ensureFieldAccessorsInitialized(Dependency.class, Dependency.Builder.class);
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

   public boolean hasMinVersionCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getMinVersionCode() {
      return this.minVersionCode_;
   }

   public boolean hasVersionCodeMask() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getVersionCodeMask() {
      return this.versionCodeMask_;
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
         output.writeInt32(2, this.minVersionCode_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.versionCodeMask_);
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
            size += CodedOutputStream.computeInt32Size(2, this.minVersionCode_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.versionCodeMask_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Dependency)) {
         return super.equals(obj);
      } else {
         Dependency other = (Dependency)obj;
         if (this.hasPackageName() != other.hasPackageName()) {
            return false;
         } else if (this.hasPackageName() && !this.getPackageName().equals(other.getPackageName())) {
            return false;
         } else if (this.hasMinVersionCode() != other.hasMinVersionCode()) {
            return false;
         } else if (this.hasMinVersionCode() && this.getMinVersionCode() != other.getMinVersionCode()) {
            return false;
         } else if (this.hasVersionCodeMask() != other.hasVersionCodeMask()) {
            return false;
         } else if (this.hasVersionCodeMask() && this.getVersionCodeMask() != other.getVersionCodeMask()) {
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

         if (this.hasMinVersionCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getMinVersionCode();
         }

         if (this.hasVersionCodeMask()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getVersionCodeMask();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Dependency parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data);
   }

   public static Dependency parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Dependency parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data);
   }

   public static Dependency parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Dependency parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data);
   }

   public static Dependency parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Dependency)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Dependency parseFrom(InputStream input) throws IOException {
      return (Dependency)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Dependency parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Dependency)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Dependency parseDelimitedFrom(InputStream input) throws IOException {
      return (Dependency)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Dependency parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Dependency)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Dependency parseFrom(CodedInputStream input) throws IOException {
      return (Dependency)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Dependency parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Dependency)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Dependency.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Dependency.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Dependency.Builder newBuilder(Dependency prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Dependency.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Dependency.Builder() : (new Dependency.Builder()).mergeFrom(this);
   }

   protected Dependency.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Dependency.Builder builder = new Dependency.Builder(parent);
      return builder;
   }

   public static Dependency getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Dependency getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Dependency(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Dependency(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements DependencyOrBuilder {
      private int bitField0_;
      private Object packageName_;
      private int minVersionCode_;
      private int versionCodeMask_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Dependency_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Dependency_fieldAccessorTable.ensureFieldAccessorsInitialized(Dependency.class, Dependency.Builder.class);
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
         if (Dependency.alwaysUseFieldBuilders) {
         }

      }

      public Dependency.Builder clear() {
         super.clear();
         this.packageName_ = "";
         this.bitField0_ &= -2;
         this.minVersionCode_ = 0;
         this.bitField0_ &= -3;
         this.versionCodeMask_ = 0;
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Dependency_descriptor;
      }

      public Dependency getDefaultInstanceForType() {
         return Dependency.getDefaultInstance();
      }

      public Dependency build() {
         Dependency result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Dependency buildPartial() {
         Dependency result = new Dependency(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.packageName_ = this.packageName_;
         if ((from_bitField0_ & 2) != 0) {
            result.minVersionCode_ = this.minVersionCode_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.versionCodeMask_ = this.versionCodeMask_;
            to_bitField0_ |= 4;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Dependency.Builder clone() {
         return (Dependency.Builder)super.clone();
      }

      public Dependency.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Dependency.Builder)super.setField(field, value);
      }

      public Dependency.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Dependency.Builder)super.clearField(field);
      }

      public Dependency.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Dependency.Builder)super.clearOneof(oneof);
      }

      public Dependency.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Dependency.Builder)super.setRepeatedField(field, index, value);
      }

      public Dependency.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Dependency.Builder)super.addRepeatedField(field, value);
      }

      public Dependency.Builder mergeFrom(Message other) {
         if (other instanceof Dependency) {
            return this.mergeFrom((Dependency)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Dependency.Builder mergeFrom(Dependency other) {
         if (other == Dependency.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPackageName()) {
               this.bitField0_ |= 1;
               this.packageName_ = other.packageName_;
               this.onChanged();
            }

            if (other.hasMinVersionCode()) {
               this.setMinVersionCode(other.getMinVersionCode());
            }

            if (other.hasVersionCodeMask()) {
               this.setVersionCodeMask(other.getVersionCodeMask());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Dependency.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Dependency parsedMessage = null;

         try {
            parsedMessage = (Dependency)Dependency.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Dependency)var8.getUnfinishedMessage();
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

      public Dependency.Builder setPackageName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public Dependency.Builder clearPackageName() {
         this.bitField0_ &= -2;
         this.packageName_ = Dependency.getDefaultInstance().getPackageName();
         this.onChanged();
         return this;
      }

      public Dependency.Builder setPackageNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.packageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasMinVersionCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getMinVersionCode() {
         return this.minVersionCode_;
      }

      public Dependency.Builder setMinVersionCode(int value) {
         this.bitField0_ |= 2;
         this.minVersionCode_ = value;
         this.onChanged();
         return this;
      }

      public Dependency.Builder clearMinVersionCode() {
         this.bitField0_ &= -3;
         this.minVersionCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasVersionCodeMask() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getVersionCodeMask() {
         return this.versionCodeMask_;
      }

      public Dependency.Builder setVersionCodeMask(int value) {
         this.bitField0_ |= 4;
         this.versionCodeMask_ = value;
         this.onChanged();
         return this;
      }

      public Dependency.Builder clearVersionCodeMask() {
         this.bitField0_ &= -5;
         this.versionCodeMask_ = 0;
         this.onChanged();
         return this;
      }

      public final Dependency.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Dependency.Builder)super.setUnknownFields(unknownFields);
      }

      public final Dependency.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Dependency.Builder)super.mergeUnknownFields(unknownFields);
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
