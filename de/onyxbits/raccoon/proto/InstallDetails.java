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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class InstallDetails extends GeneratedMessageV3 implements InstallDetailsOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int TOTALAPKSIZE_FIELD_NUMBER = 2;
   private long totalApkSize_;
   public static final int DEPENDENCY_FIELD_NUMBER = 3;
   private List dependency_;
   public static final int TARGETSDKVERSION_FIELD_NUMBER = 4;
   private int targetSdkVersion_;
   public static final int DERIVEDAPKID_FIELD_NUMBER = 5;
   private int derivedApkId_;
   public static final int REQUESTEDPERMISSIONS_FIELD_NUMBER = 6;
   private LazyStringList requestedPermissions_;
   public static final int SPLITID_FIELD_NUMBER = 11;
   private LazyStringList splitId_;
   private byte memoizedIsInitialized;
   private static final InstallDetails DEFAULT_INSTANCE = new InstallDetails();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public InstallDetails parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new InstallDetails(input, extensionRegistry);
      }
   };

   private InstallDetails(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private InstallDetails() {
      this.memoizedIsInitialized = -1;
      this.dependency_ = Collections.emptyList();
      this.requestedPermissions_ = LazyStringArrayList.EMPTY;
      this.splitId_ = LazyStringArrayList.EMPTY;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new InstallDetails();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private InstallDetails(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 16:
                  this.bitField0_ |= 1;
                  this.totalApkSize_ = input.readInt64();
                  break;
               case 26:
                  if ((mutable_bitField0_ & 2) == 0) {
                     this.dependency_ = new ArrayList();
                     mutable_bitField0_ |= 2;
                  }

                  this.dependency_.add(input.readMessage(Dependency.PARSER, extensionRegistry));
                  break;
               case 32:
                  this.bitField0_ |= 2;
                  this.targetSdkVersion_ = input.readInt32();
                  break;
               case 40:
                  this.bitField0_ |= 4;
                  this.derivedApkId_ = input.readInt32();
                  break;
               case 50:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 16) == 0) {
                     this.requestedPermissions_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 16;
                  }

                  this.requestedPermissions_.add(bs);
                  break;
               case 90:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 32) == 0) {
                     this.splitId_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 32;
                  }

                  this.splitId_.add(bs);
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
               this.dependency_ = Collections.unmodifiableList(this.dependency_);
            }

            if ((mutable_bitField0_ & 16) != 0) {
               this.requestedPermissions_ = this.requestedPermissions_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 32) != 0) {
               this.splitId_ = this.splitId_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_InstallDetails_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_InstallDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(InstallDetails.class, InstallDetails.Builder.class);
   }

   public boolean hasTotalApkSize() {
      return (this.bitField0_ & 1) != 0;
   }

   public long getTotalApkSize() {
      return this.totalApkSize_;
   }

   public List getDependencyList() {
      return this.dependency_;
   }

   public List getDependencyOrBuilderList() {
      return this.dependency_;
   }

   public int getDependencyCount() {
      return this.dependency_.size();
   }

   public Dependency getDependency(int index) {
      return (Dependency)this.dependency_.get(index);
   }

   public DependencyOrBuilder getDependencyOrBuilder(int index) {
      return (DependencyOrBuilder)this.dependency_.get(index);
   }

   public boolean hasTargetSdkVersion() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getTargetSdkVersion() {
      return this.targetSdkVersion_;
   }

   public boolean hasDerivedApkId() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getDerivedApkId() {
      return this.derivedApkId_;
   }

   public ProtocolStringList getRequestedPermissionsList() {
      return this.requestedPermissions_;
   }

   public int getRequestedPermissionsCount() {
      return this.requestedPermissions_.size();
   }

   public String getRequestedPermissions(int index) {
      return (String)this.requestedPermissions_.get(index);
   }

   public ByteString getRequestedPermissionsBytes(int index) {
      return this.requestedPermissions_.getByteString(index);
   }

   public ProtocolStringList getSplitIdList() {
      return this.splitId_;
   }

   public int getSplitIdCount() {
      return this.splitId_.size();
   }

   public String getSplitId(int index) {
      return (String)this.splitId_.get(index);
   }

   public ByteString getSplitIdBytes(int index) {
      return this.splitId_.getByteString(index);
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
         output.writeInt64(2, this.totalApkSize_);
      }

      int i;
      for(i = 0; i < this.dependency_.size(); ++i) {
         output.writeMessage(3, (MessageLite)this.dependency_.get(i));
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(4, this.targetSdkVersion_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(5, this.derivedApkId_);
      }

      for(i = 0; i < this.requestedPermissions_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 6, this.requestedPermissions_.getRaw(i));
      }

      for(i = 0; i < this.splitId_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 11, this.splitId_.getRaw(i));
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
            size += CodedOutputStream.computeInt64Size(2, this.totalApkSize_);
         }

         int dataSize;
         for(dataSize = 0; dataSize < this.dependency_.size(); ++dataSize) {
            size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.dependency_.get(dataSize));
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.targetSdkVersion_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(5, this.derivedApkId_);
         }

         dataSize = 0;

         int i;
         for(i = 0; i < this.requestedPermissions_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.requestedPermissions_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getRequestedPermissionsList().size();
         dataSize = 0;

         for(i = 0; i < this.splitId_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.splitId_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getSplitIdList().size();
         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof InstallDetails)) {
         return super.equals(obj);
      } else {
         InstallDetails other = (InstallDetails)obj;
         if (this.hasTotalApkSize() != other.hasTotalApkSize()) {
            return false;
         } else if (this.hasTotalApkSize() && this.getTotalApkSize() != other.getTotalApkSize()) {
            return false;
         } else if (!this.getDependencyList().equals(other.getDependencyList())) {
            return false;
         } else if (this.hasTargetSdkVersion() != other.hasTargetSdkVersion()) {
            return false;
         } else if (this.hasTargetSdkVersion() && this.getTargetSdkVersion() != other.getTargetSdkVersion()) {
            return false;
         } else if (this.hasDerivedApkId() != other.hasDerivedApkId()) {
            return false;
         } else if (this.hasDerivedApkId() && this.getDerivedApkId() != other.getDerivedApkId()) {
            return false;
         } else if (!this.getRequestedPermissionsList().equals(other.getRequestedPermissionsList())) {
            return false;
         } else if (!this.getSplitIdList().equals(other.getSplitIdList())) {
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
         if (this.hasTotalApkSize()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getTotalApkSize());
         }

         if (this.getDependencyCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDependencyList().hashCode();
         }

         if (this.hasTargetSdkVersion()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getTargetSdkVersion();
         }

         if (this.hasDerivedApkId()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDerivedApkId();
         }

         if (this.getRequestedPermissionsCount() > 0) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getRequestedPermissionsList().hashCode();
         }

         if (this.getSplitIdCount() > 0) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getSplitIdList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static InstallDetails parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data);
   }

   public static InstallDetails parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static InstallDetails parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data);
   }

   public static InstallDetails parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static InstallDetails parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data);
   }

   public static InstallDetails parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (InstallDetails)PARSER.parseFrom(data, extensionRegistry);
   }

   public static InstallDetails parseFrom(InputStream input) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static InstallDetails parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static InstallDetails parseDelimitedFrom(InputStream input) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static InstallDetails parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static InstallDetails parseFrom(CodedInputStream input) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static InstallDetails parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (InstallDetails)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public InstallDetails.Builder newBuilderForType() {
      return newBuilder();
   }

   public static InstallDetails.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static InstallDetails.Builder newBuilder(InstallDetails prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public InstallDetails.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new InstallDetails.Builder() : (new InstallDetails.Builder()).mergeFrom(this);
   }

   protected InstallDetails.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      InstallDetails.Builder builder = new InstallDetails.Builder(parent);
      return builder;
   }

   public static InstallDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public InstallDetails getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   InstallDetails(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   InstallDetails(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements InstallDetailsOrBuilder {
      private int bitField0_;
      private long totalApkSize_;
      private List dependency_;
      private RepeatedFieldBuilderV3 dependencyBuilder_;
      private int targetSdkVersion_;
      private int derivedApkId_;
      private LazyStringList requestedPermissions_;
      private LazyStringList splitId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_InstallDetails_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_InstallDetails_fieldAccessorTable.ensureFieldAccessorsInitialized(InstallDetails.class, InstallDetails.Builder.class);
      }

      private Builder() {
         this.dependency_ = Collections.emptyList();
         this.requestedPermissions_ = LazyStringArrayList.EMPTY;
         this.splitId_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.dependency_ = Collections.emptyList();
         this.requestedPermissions_ = LazyStringArrayList.EMPTY;
         this.splitId_ = LazyStringArrayList.EMPTY;
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (InstallDetails.alwaysUseFieldBuilders) {
            this.getDependencyFieldBuilder();
         }

      }

      public InstallDetails.Builder clear() {
         super.clear();
         this.totalApkSize_ = 0L;
         this.bitField0_ &= -2;
         if (this.dependencyBuilder_ == null) {
            this.dependency_ = Collections.emptyList();
            this.bitField0_ &= -3;
         } else {
            this.dependencyBuilder_.clear();
         }

         this.targetSdkVersion_ = 0;
         this.bitField0_ &= -5;
         this.derivedApkId_ = 0;
         this.bitField0_ &= -9;
         this.requestedPermissions_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -17;
         this.splitId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_InstallDetails_descriptor;
      }

      public InstallDetails getDefaultInstanceForType() {
         return InstallDetails.getDefaultInstance();
      }

      public InstallDetails build() {
         InstallDetails result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public InstallDetails buildPartial() {
         InstallDetails result = new InstallDetails(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.totalApkSize_ = this.totalApkSize_;
            to_bitField0_ |= 1;
         }

         if (this.dependencyBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0) {
               this.dependency_ = Collections.unmodifiableList(this.dependency_);
               this.bitField0_ &= -3;
            }

            result.dependency_ = this.dependency_;
         } else {
            result.dependency_ = this.dependencyBuilder_.build();
         }

         if ((from_bitField0_ & 4) != 0) {
            result.targetSdkVersion_ = this.targetSdkVersion_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.derivedApkId_ = this.derivedApkId_;
            to_bitField0_ |= 4;
         }

         if ((this.bitField0_ & 16) != 0) {
            this.requestedPermissions_ = this.requestedPermissions_.getUnmodifiableView();
            this.bitField0_ &= -17;
         }

         result.requestedPermissions_ = this.requestedPermissions_;
         if ((this.bitField0_ & 32) != 0) {
            this.splitId_ = this.splitId_.getUnmodifiableView();
            this.bitField0_ &= -33;
         }

         result.splitId_ = this.splitId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public InstallDetails.Builder clone() {
         return (InstallDetails.Builder)super.clone();
      }

      public InstallDetails.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (InstallDetails.Builder)super.setField(field, value);
      }

      public InstallDetails.Builder clearField(Descriptors.FieldDescriptor field) {
         return (InstallDetails.Builder)super.clearField(field);
      }

      public InstallDetails.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (InstallDetails.Builder)super.clearOneof(oneof);
      }

      public InstallDetails.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (InstallDetails.Builder)super.setRepeatedField(field, index, value);
      }

      public InstallDetails.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (InstallDetails.Builder)super.addRepeatedField(field, value);
      }

      public InstallDetails.Builder mergeFrom(Message other) {
         if (other instanceof InstallDetails) {
            return this.mergeFrom((InstallDetails)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public InstallDetails.Builder mergeFrom(InstallDetails other) {
         if (other == InstallDetails.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasTotalApkSize()) {
               this.setTotalApkSize(other.getTotalApkSize());
            }

            if (this.dependencyBuilder_ == null) {
               if (!other.dependency_.isEmpty()) {
                  if (this.dependency_.isEmpty()) {
                     this.dependency_ = other.dependency_;
                     this.bitField0_ &= -3;
                  } else {
                     this.ensureDependencyIsMutable();
                     this.dependency_.addAll(other.dependency_);
                  }

                  this.onChanged();
               }
            } else if (!other.dependency_.isEmpty()) {
               if (this.dependencyBuilder_.isEmpty()) {
                  this.dependencyBuilder_.dispose();
                  this.dependencyBuilder_ = null;
                  this.dependency_ = other.dependency_;
                  this.bitField0_ &= -3;
                  this.dependencyBuilder_ = InstallDetails.alwaysUseFieldBuilders ? this.getDependencyFieldBuilder() : null;
               } else {
                  this.dependencyBuilder_.addAllMessages(other.dependency_);
               }
            }

            if (other.hasTargetSdkVersion()) {
               this.setTargetSdkVersion(other.getTargetSdkVersion());
            }

            if (other.hasDerivedApkId()) {
               this.setDerivedApkId(other.getDerivedApkId());
            }

            if (!other.requestedPermissions_.isEmpty()) {
               if (this.requestedPermissions_.isEmpty()) {
                  this.requestedPermissions_ = other.requestedPermissions_;
                  this.bitField0_ &= -17;
               } else {
                  this.ensureRequestedPermissionsIsMutable();
                  this.requestedPermissions_.addAll(other.requestedPermissions_);
               }

               this.onChanged();
            }

            if (!other.splitId_.isEmpty()) {
               if (this.splitId_.isEmpty()) {
                  this.splitId_ = other.splitId_;
                  this.bitField0_ &= -33;
               } else {
                  this.ensureSplitIdIsMutable();
                  this.splitId_.addAll(other.splitId_);
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

      public InstallDetails.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         InstallDetails parsedMessage = null;

         try {
            parsedMessage = (InstallDetails)InstallDetails.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (InstallDetails)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasTotalApkSize() {
         return (this.bitField0_ & 1) != 0;
      }

      public long getTotalApkSize() {
         return this.totalApkSize_;
      }

      public InstallDetails.Builder setTotalApkSize(long value) {
         this.bitField0_ |= 1;
         this.totalApkSize_ = value;
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder clearTotalApkSize() {
         this.bitField0_ &= -2;
         this.totalApkSize_ = 0L;
         this.onChanged();
         return this;
      }

      private void ensureDependencyIsMutable() {
         if ((this.bitField0_ & 2) == 0) {
            this.dependency_ = new ArrayList(this.dependency_);
            this.bitField0_ |= 2;
         }

      }

      public List getDependencyList() {
         return this.dependencyBuilder_ == null ? Collections.unmodifiableList(this.dependency_) : this.dependencyBuilder_.getMessageList();
      }

      public int getDependencyCount() {
         return this.dependencyBuilder_ == null ? this.dependency_.size() : this.dependencyBuilder_.getCount();
      }

      public Dependency getDependency(int index) {
         return this.dependencyBuilder_ == null ? (Dependency)this.dependency_.get(index) : (Dependency)this.dependencyBuilder_.getMessage(index);
      }

      public InstallDetails.Builder setDependency(int index, Dependency value) {
         if (this.dependencyBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDependencyIsMutable();
            this.dependency_.set(index, value);
            this.onChanged();
         } else {
            this.dependencyBuilder_.setMessage(index, value);
         }

         return this;
      }

      public InstallDetails.Builder setDependency(int index, Dependency.Builder builderForValue) {
         if (this.dependencyBuilder_ == null) {
            this.ensureDependencyIsMutable();
            this.dependency_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.dependencyBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public InstallDetails.Builder addDependency(Dependency value) {
         if (this.dependencyBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDependencyIsMutable();
            this.dependency_.add(value);
            this.onChanged();
         } else {
            this.dependencyBuilder_.addMessage(value);
         }

         return this;
      }

      public InstallDetails.Builder addDependency(int index, Dependency value) {
         if (this.dependencyBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureDependencyIsMutable();
            this.dependency_.add(index, value);
            this.onChanged();
         } else {
            this.dependencyBuilder_.addMessage(index, value);
         }

         return this;
      }

      public InstallDetails.Builder addDependency(Dependency.Builder builderForValue) {
         if (this.dependencyBuilder_ == null) {
            this.ensureDependencyIsMutable();
            this.dependency_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.dependencyBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public InstallDetails.Builder addDependency(int index, Dependency.Builder builderForValue) {
         if (this.dependencyBuilder_ == null) {
            this.ensureDependencyIsMutable();
            this.dependency_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.dependencyBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public InstallDetails.Builder addAllDependency(Iterable values) {
         if (this.dependencyBuilder_ == null) {
            this.ensureDependencyIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.dependency_);
            this.onChanged();
         } else {
            this.dependencyBuilder_.addAllMessages(values);
         }

         return this;
      }

      public InstallDetails.Builder clearDependency() {
         if (this.dependencyBuilder_ == null) {
            this.dependency_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
         } else {
            this.dependencyBuilder_.clear();
         }

         return this;
      }

      public InstallDetails.Builder removeDependency(int index) {
         if (this.dependencyBuilder_ == null) {
            this.ensureDependencyIsMutable();
            this.dependency_.remove(index);
            this.onChanged();
         } else {
            this.dependencyBuilder_.remove(index);
         }

         return this;
      }

      public Dependency.Builder getDependencyBuilder(int index) {
         return (Dependency.Builder)this.getDependencyFieldBuilder().getBuilder(index);
      }

      public DependencyOrBuilder getDependencyOrBuilder(int index) {
         return this.dependencyBuilder_ == null ? (DependencyOrBuilder)this.dependency_.get(index) : (DependencyOrBuilder)this.dependencyBuilder_.getMessageOrBuilder(index);
      }

      public List getDependencyOrBuilderList() {
         return this.dependencyBuilder_ != null ? this.dependencyBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.dependency_);
      }

      public Dependency.Builder addDependencyBuilder() {
         return (Dependency.Builder)this.getDependencyFieldBuilder().addBuilder(Dependency.getDefaultInstance());
      }

      public Dependency.Builder addDependencyBuilder(int index) {
         return (Dependency.Builder)this.getDependencyFieldBuilder().addBuilder(index, Dependency.getDefaultInstance());
      }

      public List getDependencyBuilderList() {
         return this.getDependencyFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getDependencyFieldBuilder() {
         if (this.dependencyBuilder_ == null) {
            this.dependencyBuilder_ = new RepeatedFieldBuilderV3(this.dependency_, (this.bitField0_ & 2) != 0, this.getParentForChildren(), this.isClean());
            this.dependency_ = null;
         }

         return this.dependencyBuilder_;
      }

      public boolean hasTargetSdkVersion() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getTargetSdkVersion() {
         return this.targetSdkVersion_;
      }

      public InstallDetails.Builder setTargetSdkVersion(int value) {
         this.bitField0_ |= 4;
         this.targetSdkVersion_ = value;
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder clearTargetSdkVersion() {
         this.bitField0_ &= -5;
         this.targetSdkVersion_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasDerivedApkId() {
         return (this.bitField0_ & 8) != 0;
      }

      public int getDerivedApkId() {
         return this.derivedApkId_;
      }

      public InstallDetails.Builder setDerivedApkId(int value) {
         this.bitField0_ |= 8;
         this.derivedApkId_ = value;
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder clearDerivedApkId() {
         this.bitField0_ &= -9;
         this.derivedApkId_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureRequestedPermissionsIsMutable() {
         if ((this.bitField0_ & 16) == 0) {
            this.requestedPermissions_ = new LazyStringArrayList(this.requestedPermissions_);
            this.bitField0_ |= 16;
         }

      }

      public ProtocolStringList getRequestedPermissionsList() {
         return this.requestedPermissions_.getUnmodifiableView();
      }

      public int getRequestedPermissionsCount() {
         return this.requestedPermissions_.size();
      }

      public String getRequestedPermissions(int index) {
         return (String)this.requestedPermissions_.get(index);
      }

      public ByteString getRequestedPermissionsBytes(int index) {
         return this.requestedPermissions_.getByteString(index);
      }

      public InstallDetails.Builder setRequestedPermissions(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedPermissionsIsMutable();
            this.requestedPermissions_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public InstallDetails.Builder addRequestedPermissions(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedPermissionsIsMutable();
            this.requestedPermissions_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public InstallDetails.Builder addAllRequestedPermissions(Iterable values) {
         this.ensureRequestedPermissionsIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.requestedPermissions_);
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder clearRequestedPermissions() {
         this.requestedPermissions_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -17;
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder addRequestedPermissionsBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedPermissionsIsMutable();
            this.requestedPermissions_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureSplitIdIsMutable() {
         if ((this.bitField0_ & 32) == 0) {
            this.splitId_ = new LazyStringArrayList(this.splitId_);
            this.bitField0_ |= 32;
         }

      }

      public ProtocolStringList getSplitIdList() {
         return this.splitId_.getUnmodifiableView();
      }

      public int getSplitIdCount() {
         return this.splitId_.size();
      }

      public String getSplitId(int index) {
         return (String)this.splitId_.get(index);
      }

      public ByteString getSplitIdBytes(int index) {
         return this.splitId_.getByteString(index);
      }

      public InstallDetails.Builder setSplitId(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSplitIdIsMutable();
            this.splitId_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public InstallDetails.Builder addSplitId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSplitIdIsMutable();
            this.splitId_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public InstallDetails.Builder addAllSplitId(Iterable values) {
         this.ensureSplitIdIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.splitId_);
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder clearSplitId() {
         this.splitId_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -33;
         this.onChanged();
         return this;
      }

      public InstallDetails.Builder addSplitIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureSplitIdIsMutable();
            this.splitId_.add(value);
            this.onChanged();
            return this;
         }
      }

      public final InstallDetails.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (InstallDetails.Builder)super.setUnknownFields(unknownFields);
      }

      public final InstallDetails.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (InstallDetails.Builder)super.mergeUnknownFields(unknownFields);
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
