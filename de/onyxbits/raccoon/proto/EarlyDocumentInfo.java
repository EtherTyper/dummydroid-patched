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

public final class EarlyDocumentInfo extends GeneratedMessageV3 implements EarlyDocumentInfoOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOCID_FIELD_NUMBER = 1;
   private Docid docid_;
   public static final int TITLE_FIELD_NUMBER = 2;
   private volatile Object title_;
   public static final int VERSIONCODE_FIELD_NUMBER = 3;
   private int versionCode_;
   public static final int BACKGROUND_FIELD_NUMBER = 4;
   private boolean background_;
   public static final int CRITICAL_FIELD_NUMBER = 5;
   private boolean critical_;
   private byte memoizedIsInitialized;
   private static final EarlyDocumentInfo DEFAULT_INSTANCE = new EarlyDocumentInfo();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public EarlyDocumentInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new EarlyDocumentInfo(input, extensionRegistry);
      }
   };

   private EarlyDocumentInfo(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private EarlyDocumentInfo() {
      this.memoizedIsInitialized = -1;
      this.title_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new EarlyDocumentInfo();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private EarlyDocumentInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  Docid.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.docid_.toBuilder();
                  }

                  this.docid_ = (Docid)input.readMessage(Docid.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.docid_);
                     this.docid_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
                  break;
               case 18:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.title_ = bs;
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.versionCode_ = input.readInt32();
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.background_ = input.readBool();
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.critical_ = input.readBool();
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
      return Mothership.internal_static_EarlyDocumentInfo_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_EarlyDocumentInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyDocumentInfo.class, EarlyDocumentInfo.Builder.class);
   }

   public boolean hasDocid() {
      return (this.bitField0_ & 1) != 0;
   }

   public Docid getDocid() {
      return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
   }

   public DocidOrBuilder getDocidOrBuilder() {
      return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
   }

   public boolean hasTitle() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getTitle() {
      Object ref = this.title_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.title_ = s;
         }

         return s;
      }
   }

   public ByteString getTitleBytes() {
      Object ref = this.title_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.title_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasVersionCode() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getVersionCode() {
      return this.versionCode_;
   }

   public boolean hasBackground() {
      return (this.bitField0_ & 8) != 0;
   }

   public boolean getBackground() {
      return this.background_;
   }

   public boolean hasCritical() {
      return (this.bitField0_ & 16) != 0;
   }

   public boolean getCritical() {
      return this.critical_;
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
         output.writeMessage(1, this.getDocid());
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.title_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.versionCode_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeBool(4, this.background_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeBool(5, this.critical_);
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
            size += CodedOutputStream.computeMessageSize(1, this.getDocid());
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.title_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.versionCode_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeBoolSize(4, this.background_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeBoolSize(5, this.critical_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof EarlyDocumentInfo)) {
         return super.equals(obj);
      } else {
         EarlyDocumentInfo other = (EarlyDocumentInfo)obj;
         if (this.hasDocid() != other.hasDocid()) {
            return false;
         } else if (this.hasDocid() && !this.getDocid().equals(other.getDocid())) {
            return false;
         } else if (this.hasTitle() != other.hasTitle()) {
            return false;
         } else if (this.hasTitle() && !this.getTitle().equals(other.getTitle())) {
            return false;
         } else if (this.hasVersionCode() != other.hasVersionCode()) {
            return false;
         } else if (this.hasVersionCode() && this.getVersionCode() != other.getVersionCode()) {
            return false;
         } else if (this.hasBackground() != other.hasBackground()) {
            return false;
         } else if (this.hasBackground() && this.getBackground() != other.getBackground()) {
            return false;
         } else if (this.hasCritical() != other.hasCritical()) {
            return false;
         } else if (this.hasCritical() && this.getCritical() != other.getCritical()) {
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
         if (this.hasDocid()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDocid().hashCode();
         }

         if (this.hasTitle()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getTitle().hashCode();
         }

         if (this.hasVersionCode()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getVersionCode();
         }

         if (this.hasBackground()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + Internal.hashBoolean(this.getBackground());
         }

         if (this.hasCritical()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashBoolean(this.getCritical());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static EarlyDocumentInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data);
   }

   public static EarlyDocumentInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyDocumentInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data);
   }

   public static EarlyDocumentInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyDocumentInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data);
   }

   public static EarlyDocumentInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (EarlyDocumentInfo)PARSER.parseFrom(data, extensionRegistry);
   }

   public static EarlyDocumentInfo parseFrom(InputStream input) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyDocumentInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyDocumentInfo parseDelimitedFrom(InputStream input) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static EarlyDocumentInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static EarlyDocumentInfo parseFrom(CodedInputStream input) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static EarlyDocumentInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (EarlyDocumentInfo)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public EarlyDocumentInfo.Builder newBuilderForType() {
      return newBuilder();
   }

   public static EarlyDocumentInfo.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static EarlyDocumentInfo.Builder newBuilder(EarlyDocumentInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public EarlyDocumentInfo.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new EarlyDocumentInfo.Builder() : (new EarlyDocumentInfo.Builder()).mergeFrom(this);
   }

   protected EarlyDocumentInfo.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      EarlyDocumentInfo.Builder builder = new EarlyDocumentInfo.Builder(parent);
      return builder;
   }

   public static EarlyDocumentInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public EarlyDocumentInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   EarlyDocumentInfo(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   EarlyDocumentInfo(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements EarlyDocumentInfoOrBuilder {
      private int bitField0_;
      private Docid docid_;
      private SingleFieldBuilderV3 docidBuilder_;
      private Object title_;
      private int versionCode_;
      private boolean background_;
      private boolean critical_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_EarlyDocumentInfo_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_EarlyDocumentInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EarlyDocumentInfo.class, EarlyDocumentInfo.Builder.class);
      }

      private Builder() {
         this.title_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.title_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (EarlyDocumentInfo.alwaysUseFieldBuilders) {
            this.getDocidFieldBuilder();
         }

      }

      public EarlyDocumentInfo.Builder clear() {
         super.clear();
         if (this.docidBuilder_ == null) {
            this.docid_ = null;
         } else {
            this.docidBuilder_.clear();
         }

         this.bitField0_ &= -2;
         this.title_ = "";
         this.bitField0_ &= -3;
         this.versionCode_ = 0;
         this.bitField0_ &= -5;
         this.background_ = false;
         this.bitField0_ &= -9;
         this.critical_ = false;
         this.bitField0_ &= -17;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_EarlyDocumentInfo_descriptor;
      }

      public EarlyDocumentInfo getDefaultInstanceForType() {
         return EarlyDocumentInfo.getDefaultInstance();
      }

      public EarlyDocumentInfo build() {
         EarlyDocumentInfo result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public EarlyDocumentInfo buildPartial() {
         EarlyDocumentInfo result = new EarlyDocumentInfo(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.docidBuilder_ == null) {
               result.docid_ = this.docid_;
            } else {
               result.docid_ = (Docid)this.docidBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.title_ = this.title_;
         if ((from_bitField0_ & 4) != 0) {
            result.versionCode_ = this.versionCode_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.background_ = this.background_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            result.critical_ = this.critical_;
            to_bitField0_ |= 16;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public EarlyDocumentInfo.Builder clone() {
         return (EarlyDocumentInfo.Builder)super.clone();
      }

      public EarlyDocumentInfo.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyDocumentInfo.Builder)super.setField(field, value);
      }

      public EarlyDocumentInfo.Builder clearField(Descriptors.FieldDescriptor field) {
         return (EarlyDocumentInfo.Builder)super.clearField(field);
      }

      public EarlyDocumentInfo.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (EarlyDocumentInfo.Builder)super.clearOneof(oneof);
      }

      public EarlyDocumentInfo.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (EarlyDocumentInfo.Builder)super.setRepeatedField(field, index, value);
      }

      public EarlyDocumentInfo.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (EarlyDocumentInfo.Builder)super.addRepeatedField(field, value);
      }

      public EarlyDocumentInfo.Builder mergeFrom(Message other) {
         if (other instanceof EarlyDocumentInfo) {
            return this.mergeFrom((EarlyDocumentInfo)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public EarlyDocumentInfo.Builder mergeFrom(EarlyDocumentInfo other) {
         if (other == EarlyDocumentInfo.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDocid()) {
               this.mergeDocid(other.getDocid());
            }

            if (other.hasTitle()) {
               this.bitField0_ |= 2;
               this.title_ = other.title_;
               this.onChanged();
            }

            if (other.hasVersionCode()) {
               this.setVersionCode(other.getVersionCode());
            }

            if (other.hasBackground()) {
               this.setBackground(other.getBackground());
            }

            if (other.hasCritical()) {
               this.setCritical(other.getCritical());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public EarlyDocumentInfo.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         EarlyDocumentInfo parsedMessage = null;

         try {
            parsedMessage = (EarlyDocumentInfo)EarlyDocumentInfo.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (EarlyDocumentInfo)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDocid() {
         return (this.bitField0_ & 1) != 0;
      }

      public Docid getDocid() {
         if (this.docidBuilder_ == null) {
            return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
         } else {
            return (Docid)this.docidBuilder_.getMessage();
         }
      }

      public EarlyDocumentInfo.Builder setDocid(Docid value) {
         if (this.docidBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.docid_ = value;
            this.onChanged();
         } else {
            this.docidBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyDocumentInfo.Builder setDocid(Docid.Builder builderForValue) {
         if (this.docidBuilder_ == null) {
            this.docid_ = builderForValue.build();
            this.onChanged();
         } else {
            this.docidBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyDocumentInfo.Builder mergeDocid(Docid value) {
         if (this.docidBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.docid_ != null && this.docid_ != Docid.getDefaultInstance()) {
               this.docid_ = Docid.newBuilder(this.docid_).mergeFrom(value).buildPartial();
            } else {
               this.docid_ = value;
            }

            this.onChanged();
         } else {
            this.docidBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public EarlyDocumentInfo.Builder clearDocid() {
         if (this.docidBuilder_ == null) {
            this.docid_ = null;
            this.onChanged();
         } else {
            this.docidBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Docid.Builder getDocidBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (Docid.Builder)this.getDocidFieldBuilder().getBuilder();
      }

      public DocidOrBuilder getDocidOrBuilder() {
         if (this.docidBuilder_ != null) {
            return (DocidOrBuilder)this.docidBuilder_.getMessageOrBuilder();
         } else {
            return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
         }
      }

      private SingleFieldBuilderV3 getDocidFieldBuilder() {
         if (this.docidBuilder_ == null) {
            this.docidBuilder_ = new SingleFieldBuilderV3(this.getDocid(), this.getParentForChildren(), this.isClean());
            this.docid_ = null;
         }

         return this.docidBuilder_;
      }

      public boolean hasTitle() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getTitle() {
         Object ref = this.title_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.title_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getTitleBytes() {
         Object ref = this.title_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.title_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public EarlyDocumentInfo.Builder setTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public EarlyDocumentInfo.Builder clearTitle() {
         this.bitField0_ &= -3;
         this.title_ = EarlyDocumentInfo.getDefaultInstance().getTitle();
         this.onChanged();
         return this;
      }

      public EarlyDocumentInfo.Builder setTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.title_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasVersionCode() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getVersionCode() {
         return this.versionCode_;
      }

      public EarlyDocumentInfo.Builder setVersionCode(int value) {
         this.bitField0_ |= 4;
         this.versionCode_ = value;
         this.onChanged();
         return this;
      }

      public EarlyDocumentInfo.Builder clearVersionCode() {
         this.bitField0_ &= -5;
         this.versionCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasBackground() {
         return (this.bitField0_ & 8) != 0;
      }

      public boolean getBackground() {
         return this.background_;
      }

      public EarlyDocumentInfo.Builder setBackground(boolean value) {
         this.bitField0_ |= 8;
         this.background_ = value;
         this.onChanged();
         return this;
      }

      public EarlyDocumentInfo.Builder clearBackground() {
         this.bitField0_ &= -9;
         this.background_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasCritical() {
         return (this.bitField0_ & 16) != 0;
      }

      public boolean getCritical() {
         return this.critical_;
      }

      public EarlyDocumentInfo.Builder setCritical(boolean value) {
         this.bitField0_ |= 16;
         this.critical_ = value;
         this.onChanged();
         return this;
      }

      public EarlyDocumentInfo.Builder clearCritical() {
         this.bitField0_ &= -17;
         this.critical_ = false;
         this.onChanged();
         return this;
      }

      public final EarlyDocumentInfo.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyDocumentInfo.Builder)super.setUnknownFields(unknownFields);
      }

      public final EarlyDocumentInfo.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (EarlyDocumentInfo.Builder)super.mergeUnknownFields(unknownFields);
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
