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

public final class Rule extends GeneratedMessageV3 implements RuleOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int NEGATE_FIELD_NUMBER = 1;
   private boolean negate_;
   public static final int OPERATOR_FIELD_NUMBER = 2;
   private int operator_;
   public static final int KEY_FIELD_NUMBER = 3;
   private int key_;
   public static final int STRINGARG_FIELD_NUMBER = 4;
   private LazyStringList stringArg_;
   public static final int LONGARG_FIELD_NUMBER = 5;
   private Internal.LongList longArg_;
   public static final int DOUBLEARG_FIELD_NUMBER = 6;
   private Internal.DoubleList doubleArg_;
   public static final int SUBRULE_FIELD_NUMBER = 7;
   private List subrule_;
   public static final int RESPONSECODE_FIELD_NUMBER = 8;
   private int responseCode_;
   public static final int COMMENT_FIELD_NUMBER = 9;
   private volatile Object comment_;
   public static final int STRINGARGHASH_FIELD_NUMBER = 10;
   private Internal.LongList stringArgHash_;
   public static final int CONSTARG_FIELD_NUMBER = 11;
   private Internal.IntList constArg_;
   private byte memoizedIsInitialized;
   private static final Rule DEFAULT_INSTANCE = new Rule();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Rule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Rule(input, extensionRegistry);
      }
   };

   private Rule(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Rule() {
      this.memoizedIsInitialized = -1;
      this.stringArg_ = LazyStringArrayList.EMPTY;
      this.longArg_ = emptyLongList();
      this.doubleArg_ = emptyDoubleList();
      this.subrule_ = Collections.emptyList();
      this.comment_ = "";
      this.stringArgHash_ = emptyLongList();
      this.constArg_ = emptyIntList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Rule();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Rule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               int length;
               int limit;
               switch(tag) {
               case 0:
                  done = true;
                  continue;
               case 8:
                  this.bitField0_ |= 1;
                  this.negate_ = input.readBool();
                  continue;
               case 16:
                  this.bitField0_ |= 2;
                  this.operator_ = input.readInt32();
                  continue;
               case 24:
                  this.bitField0_ |= 4;
                  this.key_ = input.readInt32();
                  continue;
               case 34:
                  bs = input.readBytes();
                  if ((mutable_bitField0_ & 8) == 0) {
                     this.stringArg_ = new LazyStringArrayList();
                     mutable_bitField0_ |= 8;
                  }

                  this.stringArg_.add(bs);
                  continue;
               case 40:
                  if ((mutable_bitField0_ & 16) == 0) {
                     this.longArg_ = newLongList();
                     mutable_bitField0_ |= 16;
                  }

                  this.longArg_.addLong(input.readInt64());
                  continue;
               case 42:
                  length = input.readRawVarint32();
                  limit = input.pushLimit(length);
                  if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                     this.longArg_ = newLongList();
                     mutable_bitField0_ |= 16;
                  }
                  break;
               case 49:
                  if ((mutable_bitField0_ & 32) == 0) {
                     this.doubleArg_ = newDoubleList();
                     mutable_bitField0_ |= 32;
                  }

                  this.doubleArg_.addDouble(input.readDouble());
                  continue;
               case 50:
                  length = input.readRawVarint32();
                  limit = input.pushLimit(length);
                  if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                     this.doubleArg_ = newDoubleList();
                     mutable_bitField0_ |= 32;
                  }

                  while(input.getBytesUntilLimit() > 0) {
                     this.doubleArg_.addDouble(input.readDouble());
                  }

                  input.popLimit(limit);
                  continue;
               case 58:
                  if ((mutable_bitField0_ & 64) == 0) {
                     this.subrule_ = new ArrayList();
                     mutable_bitField0_ |= 64;
                  }

                  this.subrule_.add(input.readMessage(PARSER, extensionRegistry));
                  continue;
               case 64:
                  this.bitField0_ |= 8;
                  this.responseCode_ = input.readInt32();
                  continue;
               case 74:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.comment_ = bs;
                  continue;
               case 81:
                  if ((mutable_bitField0_ & 512) == 0) {
                     this.stringArgHash_ = newLongList();
                     mutable_bitField0_ |= 512;
                  }

                  this.stringArgHash_.addLong(input.readFixed64());
                  continue;
               case 82:
                  length = input.readRawVarint32();
                  limit = input.pushLimit(length);
                  if ((mutable_bitField0_ & 512) == 0 && input.getBytesUntilLimit() > 0) {
                     this.stringArgHash_ = newLongList();
                     mutable_bitField0_ |= 512;
                  }

                  while(input.getBytesUntilLimit() > 0) {
                     this.stringArgHash_.addLong(input.readFixed64());
                  }

                  input.popLimit(limit);
                  continue;
               case 88:
                  if ((mutable_bitField0_ & 1024) == 0) {
                     this.constArg_ = newIntList();
                     mutable_bitField0_ |= 1024;
                  }

                  this.constArg_.addInt(input.readInt32());
                  continue;
               case 90:
                  length = input.readRawVarint32();
                  limit = input.pushLimit(length);
                  if ((mutable_bitField0_ & 1024) == 0 && input.getBytesUntilLimit() > 0) {
                     this.constArg_ = newIntList();
                     mutable_bitField0_ |= 1024;
                  }

                  while(input.getBytesUntilLimit() > 0) {
                     this.constArg_.addInt(input.readInt32());
                  }

                  input.popLimit(limit);
                  continue;
               default:
                  if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                     done = true;
                  }
                  continue;
               }

               while(input.getBytesUntilLimit() > 0) {
                  this.longArg_.addLong(input.readInt64());
               }

               input.popLimit(limit);
            }
         } catch (InvalidProtocolBufferException var13) {
            throw var13.setUnfinishedMessage(this);
         } catch (IOException var14) {
            throw (new InvalidProtocolBufferException(var14)).setUnfinishedMessage(this);
         } finally {
            if ((mutable_bitField0_ & 8) != 0) {
               this.stringArg_ = this.stringArg_.getUnmodifiableView();
            }

            if ((mutable_bitField0_ & 16) != 0) {
               this.longArg_.makeImmutable();
            }

            if ((mutable_bitField0_ & 32) != 0) {
               this.doubleArg_.makeImmutable();
            }

            if ((mutable_bitField0_ & 64) != 0) {
               this.subrule_ = Collections.unmodifiableList(this.subrule_);
            }

            if ((mutable_bitField0_ & 512) != 0) {
               this.stringArgHash_.makeImmutable();
            }

            if ((mutable_bitField0_ & 1024) != 0) {
               this.constArg_.makeImmutable();
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_Rule_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Rule_fieldAccessorTable.ensureFieldAccessorsInitialized(Rule.class, Rule.Builder.class);
   }

   public boolean hasNegate() {
      return (this.bitField0_ & 1) != 0;
   }

   public boolean getNegate() {
      return this.negate_;
   }

   public boolean hasOperator() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getOperator() {
      return this.operator_;
   }

   public boolean hasKey() {
      return (this.bitField0_ & 4) != 0;
   }

   public int getKey() {
      return this.key_;
   }

   public ProtocolStringList getStringArgList() {
      return this.stringArg_;
   }

   public int getStringArgCount() {
      return this.stringArg_.size();
   }

   public String getStringArg(int index) {
      return (String)this.stringArg_.get(index);
   }

   public ByteString getStringArgBytes(int index) {
      return this.stringArg_.getByteString(index);
   }

   public List getLongArgList() {
      return this.longArg_;
   }

   public int getLongArgCount() {
      return this.longArg_.size();
   }

   public long getLongArg(int index) {
      return this.longArg_.getLong(index);
   }

   public List getDoubleArgList() {
      return this.doubleArg_;
   }

   public int getDoubleArgCount() {
      return this.doubleArg_.size();
   }

   public double getDoubleArg(int index) {
      return this.doubleArg_.getDouble(index);
   }

   public List getSubruleList() {
      return this.subrule_;
   }

   public List getSubruleOrBuilderList() {
      return this.subrule_;
   }

   public int getSubruleCount() {
      return this.subrule_.size();
   }

   public Rule getSubrule(int index) {
      return (Rule)this.subrule_.get(index);
   }

   public RuleOrBuilder getSubruleOrBuilder(int index) {
      return (RuleOrBuilder)this.subrule_.get(index);
   }

   public boolean hasResponseCode() {
      return (this.bitField0_ & 8) != 0;
   }

   public int getResponseCode() {
      return this.responseCode_;
   }

   public boolean hasComment() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getComment() {
      Object ref = this.comment_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.comment_ = s;
         }

         return s;
      }
   }

   public ByteString getCommentBytes() {
      Object ref = this.comment_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.comment_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public List getStringArgHashList() {
      return this.stringArgHash_;
   }

   public int getStringArgHashCount() {
      return this.stringArgHash_.size();
   }

   public long getStringArgHash(int index) {
      return this.stringArgHash_.getLong(index);
   }

   public List getConstArgList() {
      return this.constArg_;
   }

   public int getConstArgCount() {
      return this.constArg_.size();
   }

   public int getConstArg(int index) {
      return this.constArg_.getInt(index);
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
         output.writeBool(1, this.negate_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.operator_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeInt32(3, this.key_);
      }

      int i;
      for(i = 0; i < this.stringArg_.size(); ++i) {
         GeneratedMessageV3.writeString(output, 4, this.stringArg_.getRaw(i));
      }

      for(i = 0; i < this.longArg_.size(); ++i) {
         output.writeInt64(5, this.longArg_.getLong(i));
      }

      for(i = 0; i < this.doubleArg_.size(); ++i) {
         output.writeDouble(6, this.doubleArg_.getDouble(i));
      }

      for(i = 0; i < this.subrule_.size(); ++i) {
         output.writeMessage(7, (MessageLite)this.subrule_.get(i));
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeInt32(8, this.responseCode_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 9, this.comment_);
      }

      for(i = 0; i < this.stringArgHash_.size(); ++i) {
         output.writeFixed64(10, this.stringArgHash_.getLong(i));
      }

      for(i = 0; i < this.constArg_.size(); ++i) {
         output.writeInt32(11, this.constArg_.getInt(i));
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
            size += CodedOutputStream.computeBoolSize(1, this.negate_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.operator_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.key_);
         }

         int dataSize = 0;

         int i;
         for(i = 0; i < this.stringArg_.size(); ++i) {
            dataSize += computeStringSizeNoTag(this.stringArg_.getRaw(i));
         }

         size += dataSize;
         size += 1 * this.getStringArgList().size();
         dataSize = 0;

         for(i = 0; i < this.longArg_.size(); ++i) {
            dataSize += CodedOutputStream.computeInt64SizeNoTag(this.longArg_.getLong(i));
         }

         size += dataSize;
         size += 1 * this.getLongArgList().size();
         int dataSize = false;
         dataSize = 8 * this.getDoubleArgList().size();
         size += dataSize;
         size += 1 * this.getDoubleArgList().size();

         for(dataSize = 0; dataSize < this.subrule_.size(); ++dataSize) {
            size += CodedOutputStream.computeMessageSize(7, (MessageLite)this.subrule_.get(dataSize));
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.responseCode_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(9, this.comment_);
         }

         dataSize = false;
         dataSize = 8 * this.getStringArgHashList().size();
         size += dataSize;
         size += 1 * this.getStringArgHashList().size();
         dataSize = 0;

         for(i = 0; i < this.constArg_.size(); ++i) {
            dataSize += CodedOutputStream.computeInt32SizeNoTag(this.constArg_.getInt(i));
         }

         size += dataSize;
         size += 1 * this.getConstArgList().size();
         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Rule)) {
         return super.equals(obj);
      } else {
         Rule other = (Rule)obj;
         if (this.hasNegate() != other.hasNegate()) {
            return false;
         } else if (this.hasNegate() && this.getNegate() != other.getNegate()) {
            return false;
         } else if (this.hasOperator() != other.hasOperator()) {
            return false;
         } else if (this.hasOperator() && this.getOperator() != other.getOperator()) {
            return false;
         } else if (this.hasKey() != other.hasKey()) {
            return false;
         } else if (this.hasKey() && this.getKey() != other.getKey()) {
            return false;
         } else if (!this.getStringArgList().equals(other.getStringArgList())) {
            return false;
         } else if (!this.getLongArgList().equals(other.getLongArgList())) {
            return false;
         } else if (!this.getDoubleArgList().equals(other.getDoubleArgList())) {
            return false;
         } else if (!this.getSubruleList().equals(other.getSubruleList())) {
            return false;
         } else if (this.hasResponseCode() != other.hasResponseCode()) {
            return false;
         } else if (this.hasResponseCode() && this.getResponseCode() != other.getResponseCode()) {
            return false;
         } else if (this.hasComment() != other.hasComment()) {
            return false;
         } else if (this.hasComment() && !this.getComment().equals(other.getComment())) {
            return false;
         } else if (!this.getStringArgHashList().equals(other.getStringArgHashList())) {
            return false;
         } else if (!this.getConstArgList().equals(other.getConstArgList())) {
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
         if (this.hasNegate()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getNegate());
         }

         if (this.hasOperator()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getOperator();
         }

         if (this.hasKey()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getKey();
         }

         if (this.getStringArgCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getStringArgList().hashCode();
         }

         if (this.getLongArgCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getLongArgList().hashCode();
         }

         if (this.getDoubleArgCount() > 0) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getDoubleArgList().hashCode();
         }

         if (this.getSubruleCount() > 0) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getSubruleList().hashCode();
         }

         if (this.hasResponseCode()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getResponseCode();
         }

         if (this.hasComment()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getComment().hashCode();
         }

         if (this.getStringArgHashCount() > 0) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getStringArgHashList().hashCode();
         }

         if (this.getConstArgCount() > 0) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getConstArgList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Rule parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data);
   }

   public static Rule parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Rule parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data);
   }

   public static Rule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Rule parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data);
   }

   public static Rule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Rule)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Rule parseFrom(InputStream input) throws IOException {
      return (Rule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Rule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Rule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Rule parseDelimitedFrom(InputStream input) throws IOException {
      return (Rule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Rule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Rule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Rule parseFrom(CodedInputStream input) throws IOException {
      return (Rule)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Rule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Rule)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Rule.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Rule.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Rule.Builder newBuilder(Rule prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Rule.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Rule.Builder() : (new Rule.Builder()).mergeFrom(this);
   }

   protected Rule.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Rule.Builder builder = new Rule.Builder(parent);
      return builder;
   }

   public static Rule getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Rule getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Rule(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Rule(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements RuleOrBuilder {
      private int bitField0_;
      private boolean negate_;
      private int operator_;
      private int key_;
      private LazyStringList stringArg_;
      private Internal.LongList longArg_;
      private Internal.DoubleList doubleArg_;
      private List subrule_;
      private RepeatedFieldBuilderV3 subruleBuilder_;
      private int responseCode_;
      private Object comment_;
      private Internal.LongList stringArgHash_;
      private Internal.IntList constArg_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Rule_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Rule_fieldAccessorTable.ensureFieldAccessorsInitialized(Rule.class, Rule.Builder.class);
      }

      private Builder() {
         this.stringArg_ = LazyStringArrayList.EMPTY;
         this.longArg_ = Rule.emptyLongList();
         this.doubleArg_ = Rule.emptyDoubleList();
         this.subrule_ = Collections.emptyList();
         this.comment_ = "";
         this.stringArgHash_ = Rule.emptyLongList();
         this.constArg_ = Rule.emptyIntList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.stringArg_ = LazyStringArrayList.EMPTY;
         this.longArg_ = Rule.emptyLongList();
         this.doubleArg_ = Rule.emptyDoubleList();
         this.subrule_ = Collections.emptyList();
         this.comment_ = "";
         this.stringArgHash_ = Rule.emptyLongList();
         this.constArg_ = Rule.emptyIntList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Rule.alwaysUseFieldBuilders) {
            this.getSubruleFieldBuilder();
         }

      }

      public Rule.Builder clear() {
         super.clear();
         this.negate_ = false;
         this.bitField0_ &= -2;
         this.operator_ = 0;
         this.bitField0_ &= -3;
         this.key_ = 0;
         this.bitField0_ &= -5;
         this.stringArg_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -9;
         this.longArg_ = Rule.emptyLongList();
         this.bitField0_ &= -17;
         this.doubleArg_ = Rule.emptyDoubleList();
         this.bitField0_ &= -33;
         if (this.subruleBuilder_ == null) {
            this.subrule_ = Collections.emptyList();
            this.bitField0_ &= -65;
         } else {
            this.subruleBuilder_.clear();
         }

         this.responseCode_ = 0;
         this.bitField0_ &= -129;
         this.comment_ = "";
         this.bitField0_ &= -257;
         this.stringArgHash_ = Rule.emptyLongList();
         this.bitField0_ &= -513;
         this.constArg_ = Rule.emptyIntList();
         this.bitField0_ &= -1025;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Rule_descriptor;
      }

      public Rule getDefaultInstanceForType() {
         return Rule.getDefaultInstance();
      }

      public Rule build() {
         Rule result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Rule buildPartial() {
         Rule result = new Rule(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.negate_ = this.negate_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.operator_ = this.operator_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.key_ = this.key_;
            to_bitField0_ |= 4;
         }

         if ((this.bitField0_ & 8) != 0) {
            this.stringArg_ = this.stringArg_.getUnmodifiableView();
            this.bitField0_ &= -9;
         }

         result.stringArg_ = this.stringArg_;
         if ((this.bitField0_ & 16) != 0) {
            this.longArg_.makeImmutable();
            this.bitField0_ &= -17;
         }

         result.longArg_ = this.longArg_;
         if ((this.bitField0_ & 32) != 0) {
            this.doubleArg_.makeImmutable();
            this.bitField0_ &= -33;
         }

         result.doubleArg_ = this.doubleArg_;
         if (this.subruleBuilder_ == null) {
            if ((this.bitField0_ & 64) != 0) {
               this.subrule_ = Collections.unmodifiableList(this.subrule_);
               this.bitField0_ &= -65;
            }

            result.subrule_ = this.subrule_;
         } else {
            result.subrule_ = this.subruleBuilder_.build();
         }

         if ((from_bitField0_ & 128) != 0) {
            result.responseCode_ = this.responseCode_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 256) != 0) {
            to_bitField0_ |= 16;
         }

         result.comment_ = this.comment_;
         if ((this.bitField0_ & 512) != 0) {
            this.stringArgHash_.makeImmutable();
            this.bitField0_ &= -513;
         }

         result.stringArgHash_ = this.stringArgHash_;
         if ((this.bitField0_ & 1024) != 0) {
            this.constArg_.makeImmutable();
            this.bitField0_ &= -1025;
         }

         result.constArg_ = this.constArg_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Rule.Builder clone() {
         return (Rule.Builder)super.clone();
      }

      public Rule.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Rule.Builder)super.setField(field, value);
      }

      public Rule.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Rule.Builder)super.clearField(field);
      }

      public Rule.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Rule.Builder)super.clearOneof(oneof);
      }

      public Rule.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Rule.Builder)super.setRepeatedField(field, index, value);
      }

      public Rule.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Rule.Builder)super.addRepeatedField(field, value);
      }

      public Rule.Builder mergeFrom(Message other) {
         if (other instanceof Rule) {
            return this.mergeFrom((Rule)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Rule.Builder mergeFrom(Rule other) {
         if (other == Rule.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasNegate()) {
               this.setNegate(other.getNegate());
            }

            if (other.hasOperator()) {
               this.setOperator(other.getOperator());
            }

            if (other.hasKey()) {
               this.setKey(other.getKey());
            }

            if (!other.stringArg_.isEmpty()) {
               if (this.stringArg_.isEmpty()) {
                  this.stringArg_ = other.stringArg_;
                  this.bitField0_ &= -9;
               } else {
                  this.ensureStringArgIsMutable();
                  this.stringArg_.addAll(other.stringArg_);
               }

               this.onChanged();
            }

            if (!other.longArg_.isEmpty()) {
               if (this.longArg_.isEmpty()) {
                  this.longArg_ = other.longArg_;
                  this.bitField0_ &= -17;
               } else {
                  this.ensureLongArgIsMutable();
                  this.longArg_.addAll(other.longArg_);
               }

               this.onChanged();
            }

            if (!other.doubleArg_.isEmpty()) {
               if (this.doubleArg_.isEmpty()) {
                  this.doubleArg_ = other.doubleArg_;
                  this.bitField0_ &= -33;
               } else {
                  this.ensureDoubleArgIsMutable();
                  this.doubleArg_.addAll(other.doubleArg_);
               }

               this.onChanged();
            }

            if (this.subruleBuilder_ == null) {
               if (!other.subrule_.isEmpty()) {
                  if (this.subrule_.isEmpty()) {
                     this.subrule_ = other.subrule_;
                     this.bitField0_ &= -65;
                  } else {
                     this.ensureSubruleIsMutable();
                     this.subrule_.addAll(other.subrule_);
                  }

                  this.onChanged();
               }
            } else if (!other.subrule_.isEmpty()) {
               if (this.subruleBuilder_.isEmpty()) {
                  this.subruleBuilder_.dispose();
                  this.subruleBuilder_ = null;
                  this.subrule_ = other.subrule_;
                  this.bitField0_ &= -65;
                  this.subruleBuilder_ = Rule.alwaysUseFieldBuilders ? this.getSubruleFieldBuilder() : null;
               } else {
                  this.subruleBuilder_.addAllMessages(other.subrule_);
               }
            }

            if (other.hasResponseCode()) {
               this.setResponseCode(other.getResponseCode());
            }

            if (other.hasComment()) {
               this.bitField0_ |= 256;
               this.comment_ = other.comment_;
               this.onChanged();
            }

            if (!other.stringArgHash_.isEmpty()) {
               if (this.stringArgHash_.isEmpty()) {
                  this.stringArgHash_ = other.stringArgHash_;
                  this.bitField0_ &= -513;
               } else {
                  this.ensureStringArgHashIsMutable();
                  this.stringArgHash_.addAll(other.stringArgHash_);
               }

               this.onChanged();
            }

            if (!other.constArg_.isEmpty()) {
               if (this.constArg_.isEmpty()) {
                  this.constArg_ = other.constArg_;
                  this.bitField0_ &= -1025;
               } else {
                  this.ensureConstArgIsMutable();
                  this.constArg_.addAll(other.constArg_);
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

      public Rule.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Rule parsedMessage = null;

         try {
            parsedMessage = (Rule)Rule.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Rule)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasNegate() {
         return (this.bitField0_ & 1) != 0;
      }

      public boolean getNegate() {
         return this.negate_;
      }

      public Rule.Builder setNegate(boolean value) {
         this.bitField0_ |= 1;
         this.negate_ = value;
         this.onChanged();
         return this;
      }

      public Rule.Builder clearNegate() {
         this.bitField0_ &= -2;
         this.negate_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasOperator() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getOperator() {
         return this.operator_;
      }

      public Rule.Builder setOperator(int value) {
         this.bitField0_ |= 2;
         this.operator_ = value;
         this.onChanged();
         return this;
      }

      public Rule.Builder clearOperator() {
         this.bitField0_ &= -3;
         this.operator_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasKey() {
         return (this.bitField0_ & 4) != 0;
      }

      public int getKey() {
         return this.key_;
      }

      public Rule.Builder setKey(int value) {
         this.bitField0_ |= 4;
         this.key_ = value;
         this.onChanged();
         return this;
      }

      public Rule.Builder clearKey() {
         this.bitField0_ &= -5;
         this.key_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureStringArgIsMutable() {
         if ((this.bitField0_ & 8) == 0) {
            this.stringArg_ = new LazyStringArrayList(this.stringArg_);
            this.bitField0_ |= 8;
         }

      }

      public ProtocolStringList getStringArgList() {
         return this.stringArg_.getUnmodifiableView();
      }

      public int getStringArgCount() {
         return this.stringArg_.size();
      }

      public String getStringArg(int index) {
         return (String)this.stringArg_.get(index);
      }

      public ByteString getStringArgBytes(int index) {
         return this.stringArg_.getByteString(index);
      }

      public Rule.Builder setStringArg(int index, String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureStringArgIsMutable();
            this.stringArg_.set(index, (Object)value);
            this.onChanged();
            return this;
         }
      }

      public Rule.Builder addStringArg(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureStringArgIsMutable();
            this.stringArg_.add((Object)value);
            this.onChanged();
            return this;
         }
      }

      public Rule.Builder addAllStringArg(Iterable values) {
         this.ensureStringArgIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.stringArg_);
         this.onChanged();
         return this;
      }

      public Rule.Builder clearStringArg() {
         this.stringArg_ = LazyStringArrayList.EMPTY;
         this.bitField0_ &= -9;
         this.onChanged();
         return this;
      }

      public Rule.Builder addStringArgBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.ensureStringArgIsMutable();
            this.stringArg_.add(value);
            this.onChanged();
            return this;
         }
      }

      private void ensureLongArgIsMutable() {
         if ((this.bitField0_ & 16) == 0) {
            this.longArg_ = Rule.mutableCopy(this.longArg_);
            this.bitField0_ |= 16;
         }

      }

      public List getLongArgList() {
         return (List)((this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.longArg_) : this.longArg_);
      }

      public int getLongArgCount() {
         return this.longArg_.size();
      }

      public long getLongArg(int index) {
         return this.longArg_.getLong(index);
      }

      public Rule.Builder setLongArg(int index, long value) {
         this.ensureLongArgIsMutable();
         this.longArg_.setLong(index, value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addLongArg(long value) {
         this.ensureLongArgIsMutable();
         this.longArg_.addLong(value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addAllLongArg(Iterable values) {
         this.ensureLongArgIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.longArg_);
         this.onChanged();
         return this;
      }

      public Rule.Builder clearLongArg() {
         this.longArg_ = Rule.emptyLongList();
         this.bitField0_ &= -17;
         this.onChanged();
         return this;
      }

      private void ensureDoubleArgIsMutable() {
         if ((this.bitField0_ & 32) == 0) {
            this.doubleArg_ = Rule.mutableCopy(this.doubleArg_);
            this.bitField0_ |= 32;
         }

      }

      public List getDoubleArgList() {
         return (List)((this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.doubleArg_) : this.doubleArg_);
      }

      public int getDoubleArgCount() {
         return this.doubleArg_.size();
      }

      public double getDoubleArg(int index) {
         return this.doubleArg_.getDouble(index);
      }

      public Rule.Builder setDoubleArg(int index, double value) {
         this.ensureDoubleArgIsMutable();
         this.doubleArg_.setDouble(index, value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addDoubleArg(double value) {
         this.ensureDoubleArgIsMutable();
         this.doubleArg_.addDouble(value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addAllDoubleArg(Iterable values) {
         this.ensureDoubleArgIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.doubleArg_);
         this.onChanged();
         return this;
      }

      public Rule.Builder clearDoubleArg() {
         this.doubleArg_ = Rule.emptyDoubleList();
         this.bitField0_ &= -33;
         this.onChanged();
         return this;
      }

      private void ensureSubruleIsMutable() {
         if ((this.bitField0_ & 64) == 0) {
            this.subrule_ = new ArrayList(this.subrule_);
            this.bitField0_ |= 64;
         }

      }

      public List getSubruleList() {
         return this.subruleBuilder_ == null ? Collections.unmodifiableList(this.subrule_) : this.subruleBuilder_.getMessageList();
      }

      public int getSubruleCount() {
         return this.subruleBuilder_ == null ? this.subrule_.size() : this.subruleBuilder_.getCount();
      }

      public Rule getSubrule(int index) {
         return this.subruleBuilder_ == null ? (Rule)this.subrule_.get(index) : (Rule)this.subruleBuilder_.getMessage(index);
      }

      public Rule.Builder setSubrule(int index, Rule value) {
         if (this.subruleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSubruleIsMutable();
            this.subrule_.set(index, value);
            this.onChanged();
         } else {
            this.subruleBuilder_.setMessage(index, value);
         }

         return this;
      }

      public Rule.Builder setSubrule(int index, Rule.Builder builderForValue) {
         if (this.subruleBuilder_ == null) {
            this.ensureSubruleIsMutable();
            this.subrule_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.subruleBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public Rule.Builder addSubrule(Rule value) {
         if (this.subruleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSubruleIsMutable();
            this.subrule_.add(value);
            this.onChanged();
         } else {
            this.subruleBuilder_.addMessage(value);
         }

         return this;
      }

      public Rule.Builder addSubrule(int index, Rule value) {
         if (this.subruleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureSubruleIsMutable();
            this.subrule_.add(index, value);
            this.onChanged();
         } else {
            this.subruleBuilder_.addMessage(index, value);
         }

         return this;
      }

      public Rule.Builder addSubrule(Rule.Builder builderForValue) {
         if (this.subruleBuilder_ == null) {
            this.ensureSubruleIsMutable();
            this.subrule_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.subruleBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public Rule.Builder addSubrule(int index, Rule.Builder builderForValue) {
         if (this.subruleBuilder_ == null) {
            this.ensureSubruleIsMutable();
            this.subrule_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.subruleBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public Rule.Builder addAllSubrule(Iterable values) {
         if (this.subruleBuilder_ == null) {
            this.ensureSubruleIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.subrule_);
            this.onChanged();
         } else {
            this.subruleBuilder_.addAllMessages(values);
         }

         return this;
      }

      public Rule.Builder clearSubrule() {
         if (this.subruleBuilder_ == null) {
            this.subrule_ = Collections.emptyList();
            this.bitField0_ &= -65;
            this.onChanged();
         } else {
            this.subruleBuilder_.clear();
         }

         return this;
      }

      public Rule.Builder removeSubrule(int index) {
         if (this.subruleBuilder_ == null) {
            this.ensureSubruleIsMutable();
            this.subrule_.remove(index);
            this.onChanged();
         } else {
            this.subruleBuilder_.remove(index);
         }

         return this;
      }

      public Rule.Builder getSubruleBuilder(int index) {
         return (Rule.Builder)this.getSubruleFieldBuilder().getBuilder(index);
      }

      public RuleOrBuilder getSubruleOrBuilder(int index) {
         return this.subruleBuilder_ == null ? (RuleOrBuilder)this.subrule_.get(index) : (RuleOrBuilder)this.subruleBuilder_.getMessageOrBuilder(index);
      }

      public List getSubruleOrBuilderList() {
         return this.subruleBuilder_ != null ? this.subruleBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.subrule_);
      }

      public Rule.Builder addSubruleBuilder() {
         return (Rule.Builder)this.getSubruleFieldBuilder().addBuilder(Rule.getDefaultInstance());
      }

      public Rule.Builder addSubruleBuilder(int index) {
         return (Rule.Builder)this.getSubruleFieldBuilder().addBuilder(index, Rule.getDefaultInstance());
      }

      public List getSubruleBuilderList() {
         return this.getSubruleFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getSubruleFieldBuilder() {
         if (this.subruleBuilder_ == null) {
            this.subruleBuilder_ = new RepeatedFieldBuilderV3(this.subrule_, (this.bitField0_ & 64) != 0, this.getParentForChildren(), this.isClean());
            this.subrule_ = null;
         }

         return this.subruleBuilder_;
      }

      public boolean hasResponseCode() {
         return (this.bitField0_ & 128) != 0;
      }

      public int getResponseCode() {
         return this.responseCode_;
      }

      public Rule.Builder setResponseCode(int value) {
         this.bitField0_ |= 128;
         this.responseCode_ = value;
         this.onChanged();
         return this;
      }

      public Rule.Builder clearResponseCode() {
         this.bitField0_ &= -129;
         this.responseCode_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasComment() {
         return (this.bitField0_ & 256) != 0;
      }

      public String getComment() {
         Object ref = this.comment_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.comment_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCommentBytes() {
         Object ref = this.comment_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.comment_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Rule.Builder setComment(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.comment_ = value;
            this.onChanged();
            return this;
         }
      }

      public Rule.Builder clearComment() {
         this.bitField0_ &= -257;
         this.comment_ = Rule.getDefaultInstance().getComment();
         this.onChanged();
         return this;
      }

      public Rule.Builder setCommentBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 256;
            this.comment_ = value;
            this.onChanged();
            return this;
         }
      }

      private void ensureStringArgHashIsMutable() {
         if ((this.bitField0_ & 512) == 0) {
            this.stringArgHash_ = Rule.mutableCopy(this.stringArgHash_);
            this.bitField0_ |= 512;
         }

      }

      public List getStringArgHashList() {
         return (List)((this.bitField0_ & 512) != 0 ? Collections.unmodifiableList(this.stringArgHash_) : this.stringArgHash_);
      }

      public int getStringArgHashCount() {
         return this.stringArgHash_.size();
      }

      public long getStringArgHash(int index) {
         return this.stringArgHash_.getLong(index);
      }

      public Rule.Builder setStringArgHash(int index, long value) {
         this.ensureStringArgHashIsMutable();
         this.stringArgHash_.setLong(index, value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addStringArgHash(long value) {
         this.ensureStringArgHashIsMutable();
         this.stringArgHash_.addLong(value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addAllStringArgHash(Iterable values) {
         this.ensureStringArgHashIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.stringArgHash_);
         this.onChanged();
         return this;
      }

      public Rule.Builder clearStringArgHash() {
         this.stringArgHash_ = Rule.emptyLongList();
         this.bitField0_ &= -513;
         this.onChanged();
         return this;
      }

      private void ensureConstArgIsMutable() {
         if ((this.bitField0_ & 1024) == 0) {
            this.constArg_ = Rule.mutableCopy(this.constArg_);
            this.bitField0_ |= 1024;
         }

      }

      public List getConstArgList() {
         return (List)((this.bitField0_ & 1024) != 0 ? Collections.unmodifiableList(this.constArg_) : this.constArg_);
      }

      public int getConstArgCount() {
         return this.constArg_.size();
      }

      public int getConstArg(int index) {
         return this.constArg_.getInt(index);
      }

      public Rule.Builder setConstArg(int index, int value) {
         this.ensureConstArgIsMutable();
         this.constArg_.setInt(index, value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addConstArg(int value) {
         this.ensureConstArgIsMutable();
         this.constArg_.addInt(value);
         this.onChanged();
         return this;
      }

      public Rule.Builder addAllConstArg(Iterable values) {
         this.ensureConstArgIsMutable();
         AbstractMessageLite.Builder.addAll(values, (List)this.constArg_);
         this.onChanged();
         return this;
      }

      public Rule.Builder clearConstArg() {
         this.constArg_ = Rule.emptyIntList();
         this.bitField0_ &= -1025;
         this.onChanged();
         return this;
      }

      public final Rule.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Rule.Builder)super.setUnknownFields(unknownFields);
      }

      public final Rule.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Rule.Builder)super.mergeUnknownFields(unknownFields);
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
