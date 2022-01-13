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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class AndroidCheckinProto extends GeneratedMessageV3 implements AndroidCheckinProtoOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int BUILD_FIELD_NUMBER = 1;
   private AndroidBuildProto build_;
   public static final int LASTCHECKINMSEC_FIELD_NUMBER = 2;
   private long lastCheckinMsec_;
   public static final int REQUESTEDGROUP_FIELD_NUMBER = 5;
   private LazyStringList requestedGroup_;
   public static final int CELLOPERATOR_FIELD_NUMBER = 6;
   private volatile Object cellOperator_;
   public static final int SIMOPERATOR_FIELD_NUMBER = 7;
   private volatile Object simOperator_;
   public static final int ROAMING_FIELD_NUMBER = 8;
   private volatile Object roaming_;
   private byte memoizedIsInitialized;
   private static final AndroidCheckinProto DEFAULT_INSTANCE = new AndroidCheckinProto();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AndroidCheckinProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AndroidCheckinProto(input, extensionRegistry);
      }
   };

   private AndroidCheckinProto(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AndroidCheckinProto() {
      this.memoizedIsInitialized = -1;
      this.requestedGroup_ = LazyStringArrayList.EMPTY;
      this.cellOperator_ = "";
      this.simOperator_ = "";
      this.roaming_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AndroidCheckinProto();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AndroidCheckinProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  AndroidBuildProto.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.build_.toBuilder();
                  }

                  this.build_ = (AndroidBuildProto)input.readMessage(AndroidBuildProto.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.build_);
                     this.build_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.lastCheckinMsec_ = input.readInt64();
                  break;
               case 42:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.requestedGroup_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.requestedGroup_.add(bs);
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.cellOperator_ = bs;
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.simOperator_ = bs;
                  break;
               case 66:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.roaming_ = bs;
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
            if ((mutable_bitField0_ & 4) != 0) {
               this.requestedGroup_ = this.requestedGroup_.getUnmodifiableView();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_AndroidCheckinProto_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AndroidCheckinProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinProto.class, AndroidCheckinProto.Builder.class);
   }

   public boolean hasBuild() {
      return (this.bitField0_ & 1) != 0;
   }

   public AndroidBuildProto getBuild() {
      return this.build_ == null ? AndroidBuildProto.getDefaultInstance() : this.build_;
   }

   public AndroidBuildProtoOrBuilder getBuildOrBuilder() {
      return this.build_ == null ? AndroidBuildProto.getDefaultInstance() : this.build_;
   }

   public boolean hasLastCheckinMsec() {
      return (this.bitField0_ & 2) != 0;
   }

   public long getLastCheckinMsec() {
      return this.lastCheckinMsec_;
   }

   public ProtocolStringList getRequestedGroupList() {
      return this.requestedGroup_;
   }

   public int getRequestedGroupCount() {
      return this.requestedGroup_.size();
   }

   public String getRequestedGroup(int index) {
      return (String)this.requestedGroup_.get(index);
   }

   public ByteString getRequestedGroupBytes(int index) {
      return this.requestedGroup_.getByteString(index);
   }

   public boolean hasCellOperator() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getCellOperator() {
      Object ref = this.cellOperator_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.cellOperator_ = s;
         }

         return s;
      }
   }

   public ByteString getCellOperatorBytes() {
      Object ref = this.cellOperator_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.cellOperator_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSimOperator() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getSimOperator() {
      Object ref = this.simOperator_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.simOperator_ = s;
         }

         return s;
      }
   }

   public ByteString getSimOperatorBytes() {
      Object ref = this.simOperator_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.simOperator_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasRoaming() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getRoaming() {
      Object ref = this.roaming_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.roaming_ = s;
         }

         return s;
      }
   }

   public ByteString getRoamingBytes() {
      Object ref = this.roaming_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.roaming_ = b;
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
         output.writeMessage(1, this.getBuild());
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt64(2, this.lastCheckinMsec_);
      }

      for(int i = 0; i < this.requestedGroup_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 5, this.requestedGroup_.getRaw(i));
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.cellOperator_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.simOperator_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 8, this.roaming_);
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
            size += CodedOutputStream.computeMessageSize(1, this.getBuild());
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt64Size(2, this.lastCheckinMsec_);
         }

         int dataSize = 0;

         for(int i = 0; i < this.requestedGroup_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.requestedGroup_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getRequestedGroupList().size();
         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.cellOperator_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.simOperator_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(8, this.roaming_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AndroidCheckinProto)) {
         return super.equals(obj);
      } else {
         AndroidCheckinProto other = (AndroidCheckinProto)obj;
         if (this.hasBuild() != other.hasBuild()) {
            return false;
         } else if (this.hasBuild() && !this.getBuild().equals(other.getBuild())) {
            return false;
         } else if (this.hasLastCheckinMsec() != other.hasLastCheckinMsec()) {
            return false;
         } else if (this.hasLastCheckinMsec() && this.getLastCheckinMsec() != other.getLastCheckinMsec()) {
            return false;
         } else if (!this.getRequestedGroupList().equals(other.getRequestedGroupList())) {
            return false;
         } else if (this.hasCellOperator() != other.hasCellOperator()) {
            return false;
         } else if (this.hasCellOperator() && !this.getCellOperator().equals(other.getCellOperator())) {
            return false;
         } else if (this.hasSimOperator() != other.hasSimOperator()) {
            return false;
         } else if (this.hasSimOperator() && !this.getSimOperator().equals(other.getSimOperator())) {
            return false;
         } else if (this.hasRoaming() != other.hasRoaming()) {
            return false;
         } else if (this.hasRoaming() && !this.getRoaming().equals(other.getRoaming())) {
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
         if (this.hasBuild()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getBuild().hashCode();
         }

         if (this.hasLastCheckinMsec()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getLastCheckinMsec());
         }

         if (this.getRequestedGroupCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getRequestedGroupList().hashCode();
         }

         if (this.hasCellOperator()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getCellOperator().hashCode();
         }

         if (this.hasSimOperator()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getSimOperator().hashCode();
         }

         if (this.hasRoaming()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getRoaming().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AndroidCheckinProto parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data);
   }

   public static AndroidCheckinProto parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data);
   }

   public static AndroidCheckinProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data);
   }

   public static AndroidCheckinProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AndroidCheckinProto)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AndroidCheckinProto parseFrom(InputStream input) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinProto parseDelimitedFrom(InputStream input) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AndroidCheckinProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AndroidCheckinProto parseFrom(CodedInputStream input) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AndroidCheckinProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AndroidCheckinProto)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AndroidCheckinProto.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AndroidCheckinProto.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AndroidCheckinProto.Builder newBuilder(AndroidCheckinProto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AndroidCheckinProto.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AndroidCheckinProto.Builder() : (new AndroidCheckinProto.Builder()).mergeFrom(this);
   }

   protected AndroidCheckinProto.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AndroidCheckinProto.Builder builder = new AndroidCheckinProto.Builder(parent);
      return builder;
   }

   public static AndroidCheckinProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AndroidCheckinProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AndroidCheckinProto(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AndroidCheckinProto(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AndroidCheckinProtoOrBuilder {
      private int bitField0_;
      private AndroidBuildProto build_;
      private SingleFieldBuilderV3 buildBuilder_;
      private long lastCheckinMsec_;
      private LazyStringList requestedGroup_;
      private Object cellOperator_;
      private Object simOperator_;
      private Object roaming_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AndroidCheckinProto_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AndroidCheckinProto_fieldAccessorTable.ensureFieldAccessorsInitialized(AndroidCheckinProto.class, AndroidCheckinProto.Builder.class);
      }

      private Builder() {
         this.requestedGroup_ = LazyStringArrayList.EMPTY;
         this.cellOperator_ = "";
         this.simOperator_ = "";
         this.roaming_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.requestedGroup_ = LazyStringArrayList.EMPTY;
         this.cellOperator_ = "";
         this.simOperator_ = "";
         this.roaming_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AndroidCheckinProto.alwaysUseFieldBuilders) {
            this.getBuildFieldBuilder();
         }

      }

      public AndroidCheckinProto.Builder clear() {
         super.clear();
         if (this.buildBuilder_ == null) {
            this.build_ = null;
         } else {
            this.buildBuilder_.clear();
         }

         this.bitField0_ &= -2;
         this.lastCheckinMsec_ = 0L;
         this.bitField0_ &= -3;
         this.requestedGroup_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -5;
         this.cellOperator_ = "";
         this.bitField0_ &= -9;
         this.simOperator_ = "";
         this.bitField0_ &= -17;
         this.roaming_ = "";
         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AndroidCheckinProto_descriptor;
      }

      public AndroidCheckinProto getDefaultInstanceForType() {
         return AndroidCheckinProto.getDefaultInstance();
      }

      public AndroidCheckinProto build() {
         AndroidCheckinProto result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AndroidCheckinProto buildPartial() {
         AndroidCheckinProto result = new AndroidCheckinProto(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.buildBuilder_ == null) {
               result.build_ = this.build_;
            } else {
               result.build_ = (AndroidBuildProto)this.buildBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.lastCheckinMsec_ = this.lastCheckinMsec_;
            to_bitField0_ |= 2;
         }

         if ((this.bitField0_ & 4) != 0) {
            this.requestedGroup_ = this.requestedGroup_.getUnmodifiableView();
            this.bitField0_ &= -5;
         }

         result.requestedGroup_ = this.requestedGroup_;
         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 4;
         }

         result.cellOperator_ = this.cellOperator_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 8;
         }

         result.simOperator_ = this.simOperator_;
         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 16;
         }

         result.roaming_ = this.roaming_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AndroidCheckinProto.Builder clone() {
         return (AndroidCheckinProto.Builder)super.clone();
      }

      public AndroidCheckinProto.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinProto.Builder)super.setField(field, value);
      }

      public AndroidCheckinProto.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AndroidCheckinProto.Builder)super.clearField(field);
      }

      public AndroidCheckinProto.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AndroidCheckinProto.Builder)super.clearOneof(oneof);
      }

      public AndroidCheckinProto.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AndroidCheckinProto.Builder)super.setRepeatedField(field, index, value);
      }

      public AndroidCheckinProto.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AndroidCheckinProto.Builder)super.addRepeatedField(field, value);
      }

      public AndroidCheckinProto.Builder mergeFrom(Message other) {
         if (other instanceof AndroidCheckinProto) {
            return this.mergeFrom((AndroidCheckinProto)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AndroidCheckinProto.Builder mergeFrom(AndroidCheckinProto other) {
         if (other == AndroidCheckinProto.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasBuild()) {
               this.mergeBuild(other.getBuild());
            }

            if (other.hasLastCheckinMsec()) {
               this.setLastCheckinMsec(other.getLastCheckinMsec());
            }

            if (!other.requestedGroup_.isEmpty()) {
               if (this.requestedGroup_.isEmpty()) {
                  this.requestedGroup_ = other.requestedGroup_;
                  this.bitField0_ &= -5;
               } else {
                  this.ensureRequestedGroupIsMutable();
                  this.requestedGroup_.addAll(other.requestedGroup_);
               }

               this.onChanged();
            }

            if (other.hasCellOperator()) {
               this.bitField0_ |= 8;
               this.cellOperator_ = other.cellOperator_;
               this.onChanged();
            }

            if (other.hasSimOperator()) {
               this.bitField0_ |= 16;
               this.simOperator_ = other.simOperator_;
               this.onChanged();
            }

            if (other.hasRoaming()) {
               this.bitField0_ |= 32;
               this.roaming_ = other.roaming_;
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

      public AndroidCheckinProto.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AndroidCheckinProto parsedMessage = null;

         try {
            parsedMessage = (AndroidCheckinProto)AndroidCheckinProto.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AndroidCheckinProto)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasBuild() {
         return (this.bitField0_ & 1) != 0;
      }

      public AndroidBuildProto getBuild() {
         if (this.buildBuilder_ == null) {
            return this.build_ == null ? AndroidBuildProto.getDefaultInstance() : this.build_;
         } else {
            return (AndroidBuildProto)this.buildBuilder_.getMessage();
         }
      }

      public AndroidCheckinProto.Builder setBuild(AndroidBuildProto value) {
         if (this.buildBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.build_ = value;
            this.onChanged();
         } else {
            this.buildBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public AndroidCheckinProto.Builder setBuild(AndroidBuildProto.Builder builderForValue) {
         if (this.buildBuilder_ == null) {
            this.build_ = builderForValue.build();
            this.onChanged();
         } else {
            this.buildBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public AndroidCheckinProto.Builder mergeBuild(AndroidBuildProto value) {
         if (this.buildBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.build_ != null && this.build_ != AndroidBuildProto.getDefaultInstance()) {
               this.build_ = AndroidBuildProto.newBuilder(this.build_).mergeFrom(value).buildPartial();
            } else {
               this.build_ = value;
            }

            this.onChanged();
         } else {
            this.buildBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public AndroidCheckinProto.Builder clearBuild() {
         if (this.buildBuilder_ == null) {
            this.build_ = null;
            this.onChanged();
         } else {
            this.buildBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public AndroidBuildProto.Builder getBuildBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (AndroidBuildProto.Builder)this.getBuildFieldBuilder().getBuilder();
      }

      public AndroidBuildProtoOrBuilder getBuildOrBuilder() {
         if (this.buildBuilder_ != null) {
            return (AndroidBuildProtoOrBuilder)this.buildBuilder_.getMessageOrBuilder();
         } else {
            return this.build_ == null ? AndroidBuildProto.getDefaultInstance() : this.build_;
         }
      }

      private SingleFieldBuilderV3 getBuildFieldBuilder() {
         if (this.buildBuilder_ == null) {
            this.buildBuilder_ = new SingleFieldBuilderV3(this.getBuild(), this.getParentForChildren(), this.isClean());
            this.build_ = null;
         }

         return this.buildBuilder_;
      }

      public boolean hasLastCheckinMsec() {
         return (this.bitField0_ & 2) != 0;
      }

      public long getLastCheckinMsec() {
         return this.lastCheckinMsec_;
      }

      public AndroidCheckinProto.Builder setLastCheckinMsec(long value) {
         this.bitField0_ |= 2;
         this.lastCheckinMsec_ = value;
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder clearLastCheckinMsec() {
         this.bitField0_ &= -3;
         this.lastCheckinMsec_ = 0L;
         this.onChanged();
         return this;
      }

      private void ensureRequestedGroupIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.requestedGroup_ = new LazyStringArrayList(this.requestedGroup_);
            this.bitField0_ |= 4;
         }

      }

      public ProtocolStringList getRequestedGroupList() {
         return this.requestedGroup_.getUnmodifiableView();
      }

      public int getRequestedGroupCount() {
         return this.requestedGroup_.size();
      }

      public String getRequestedGroup(int index) {
         return (String)this.requestedGroup_.get(index);
      }

      public ByteString getRequestedGroupBytes(int index) {
         return this.requestedGroup_.getByteString(index);
      }

      public AndroidCheckinProto.Builder setRequestedGroup(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedGroupIsMutable();
            this.requestedGroup_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinProto.Builder addRequestedGroup(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedGroupIsMutable();
            this.requestedGroup_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinProto.Builder addAllRequestedGroup(Iterable values) {
         this.ensureRequestedGroupIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.requestedGroup_);
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder clearRequestedGroup() {
         this.requestedGroup_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -5;
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder addRequestedGroupBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureRequestedGroupIsMutable();
            this.requestedGroup_.add(value);
            this.onChanged();
            return this;
         }
      }

      public boolean hasCellOperator() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getCellOperator() {
         Object ref = this.cellOperator_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.cellOperator_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCellOperatorBytes() {
         Object ref = this.cellOperator_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.cellOperator_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinProto.Builder setCellOperator(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.cellOperator_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinProto.Builder clearCellOperator() {
         this.bitField0_ &= -9;
         this.cellOperator_ = AndroidCheckinProto.getDefaultInstance().getCellOperator();
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder setCellOperatorBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.cellOperator_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSimOperator() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getSimOperator() {
         Object ref = this.simOperator_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.simOperator_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSimOperatorBytes() {
         Object ref = this.simOperator_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.simOperator_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinProto.Builder setSimOperator(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.simOperator_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinProto.Builder clearSimOperator() {
         this.bitField0_ &= -17;
         this.simOperator_ = AndroidCheckinProto.getDefaultInstance().getSimOperator();
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder setSimOperatorBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.simOperator_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasRoaming() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getRoaming() {
         Object ref = this.roaming_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.roaming_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getRoamingBytes() {
         Object ref = this.roaming_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.roaming_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AndroidCheckinProto.Builder setRoaming(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.roaming_ = value;
            this.onChanged();
            return this;
         }
      }

      public AndroidCheckinProto.Builder clearRoaming() {
         this.bitField0_ &= -33;
         this.roaming_ = AndroidCheckinProto.getDefaultInstance().getRoaming();
         this.onChanged();
         return this;
      }

      public AndroidCheckinProto.Builder setRoamingBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.roaming_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AndroidCheckinProto.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinProto.Builder)super.setUnknownFields(unknownFields);
      }

      public final AndroidCheckinProto.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AndroidCheckinProto.Builder)super.mergeUnknownFields(unknownFields);
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
