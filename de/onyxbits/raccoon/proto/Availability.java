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

public final class Availability extends GeneratedMessageV3 implements AvailabilityOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int RESTRICTION_FIELD_NUMBER = 5;
   private int restriction_;
   public static final int OFFERTYPE_FIELD_NUMBER = 6;
   private int offerType_;
   public static final int RULE_FIELD_NUMBER = 7;
   private Rule rule_;
   public static final int AVAILABLEIFOWNED_FIELD_NUMBER = 13;
   private boolean availableIfOwned_;
   private byte memoizedIsInitialized;
   private static final Availability DEFAULT_INSTANCE = new Availability();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Availability parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Availability(input, extensionRegistry);
      }
   };

   private Availability(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Availability() {
      this.memoizedIsInitialized = -1;
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Availability();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Availability(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 40:
                  this.bitField0_ |= 1;
                  this.restriction_ = input.readInt32();
                  break;
               case 48:
                  this.bitField0_ |= 2;
                  this.offerType_ = input.readInt32();
                  break;
               case 58:
                  Rule.Builder subBuilder = null;
                  if ((this.bitField0_ & 4) != 0) {
                     subBuilder = this.rule_.toBuilder();
                  }

                  this.rule_ = (Rule)input.readMessage(Rule.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.rule_);
                     this.rule_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4;
                  break;
               case 104:
                  this.bitField0_ |= 8;
                  this.availableIfOwned_ = input.readBool();
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
      return Mothership.internal_static_Availability_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Availability_fieldAccessorTable.ensureFieldAccessorsInitialized(Availability.class, Availability.Builder.class);
   }

   public boolean hasRestriction() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getRestriction() {
      return this.restriction_;
   }

   public boolean hasOfferType() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getOfferType() {
      return this.offerType_;
   }

   public boolean hasRule() {
      return (this.bitField0_ & 4) != 0;
   }

   public Rule getRule() {
      return this.rule_ == null ? Rule.getDefaultInstance() : this.rule_;
   }

   public RuleOrBuilder getRuleOrBuilder() {
      return this.rule_ == null ? Rule.getDefaultInstance() : this.rule_;
   }

   public boolean hasAvailableIfOwned() {
      return (this.bitField0_ & 8) != 0;
   }

   public boolean getAvailableIfOwned() {
      return this.availableIfOwned_;
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
         output.writeInt32(5, this.restriction_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(6, this.offerType_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeMessage(7, this.getRule());
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeBool(13, this.availableIfOwned_);
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
            size += CodedOutputStream.computeInt32Size(5, this.restriction_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(6, this.offerType_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getRule());
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeBoolSize(13, this.availableIfOwned_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Availability)) {
         return super.equals(obj);
      } else {
         Availability other = (Availability)obj;
         if (this.hasRestriction() != other.hasRestriction()) {
            return false;
         } else if (this.hasRestriction() && this.getRestriction() != other.getRestriction()) {
            return false;
         } else if (this.hasOfferType() != other.hasOfferType()) {
            return false;
         } else if (this.hasOfferType() && this.getOfferType() != other.getOfferType()) {
            return false;
         } else if (this.hasRule() != other.hasRule()) {
            return false;
         } else if (this.hasRule() && !this.getRule().equals(other.getRule())) {
            return false;
         } else if (this.hasAvailableIfOwned() != other.hasAvailableIfOwned()) {
            return false;
         } else if (this.hasAvailableIfOwned() && this.getAvailableIfOwned() != other.getAvailableIfOwned()) {
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
         if (this.hasRestriction()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getRestriction();
         }

         if (this.hasOfferType()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getOfferType();
         }

         if (this.hasRule()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getRule().hashCode();
         }

         if (this.hasAvailableIfOwned()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + Internal.hashBoolean(this.getAvailableIfOwned());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Availability parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data);
   }

   public static Availability parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Availability parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data);
   }

   public static Availability parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Availability parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data);
   }

   public static Availability parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Availability)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Availability parseFrom(InputStream input) throws IOException {
      return (Availability)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Availability parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Availability)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Availability parseDelimitedFrom(InputStream input) throws IOException {
      return (Availability)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Availability parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Availability)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Availability parseFrom(CodedInputStream input) throws IOException {
      return (Availability)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Availability parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Availability)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Availability.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Availability.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Availability.Builder newBuilder(Availability prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Availability.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Availability.Builder() : (new Availability.Builder()).mergeFrom(this);
   }

   protected Availability.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Availability.Builder builder = new Availability.Builder(parent);
      return builder;
   }

   public static Availability getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Availability getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Availability(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Availability(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AvailabilityOrBuilder {
      private int bitField0_;
      private int restriction_;
      private int offerType_;
      private Rule rule_;
      private SingleFieldBuilderV3 ruleBuilder_;
      private boolean availableIfOwned_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Availability_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Availability_fieldAccessorTable.ensureFieldAccessorsInitialized(Availability.class, Availability.Builder.class);
      }

      private Builder() {
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Availability.alwaysUseFieldBuilders) {
            this.getRuleFieldBuilder();
         }

      }

      public Availability.Builder clear() {
         super.clear();
         this.restriction_ = 0;
         this.bitField0_ &= -2;
         this.offerType_ = 0;
         this.bitField0_ &= -3;
         if (this.ruleBuilder_ == null) {
            this.rule_ = null;
         } else {
            this.ruleBuilder_.clear();
         }

         this.bitField0_ &= -5;
         this.availableIfOwned_ = false;
         this.bitField0_ &= -9;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Availability_descriptor;
      }

      public Availability getDefaultInstanceForType() {
         return Availability.getDefaultInstance();
      }

      public Availability build() {
         Availability result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Availability buildPartial() {
         Availability result = new Availability(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.restriction_ = this.restriction_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.offerType_ = this.offerType_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            if (this.ruleBuilder_ == null) {
               result.rule_ = this.rule_;
            } else {
               result.rule_ = (Rule)this.ruleBuilder_.build();
            }

            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.availableIfOwned_ = this.availableIfOwned_;
            to_bitField0_ |= 8;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Availability.Builder clone() {
         return (Availability.Builder)super.clone();
      }

      public Availability.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Availability.Builder)super.setField(field, value);
      }

      public Availability.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Availability.Builder)super.clearField(field);
      }

      public Availability.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Availability.Builder)super.clearOneof(oneof);
      }

      public Availability.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Availability.Builder)super.setRepeatedField(field, index, value);
      }

      public Availability.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Availability.Builder)super.addRepeatedField(field, value);
      }

      public Availability.Builder mergeFrom(Message other) {
         if (other instanceof Availability) {
            return this.mergeFrom((Availability)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Availability.Builder mergeFrom(Availability other) {
         if (other == Availability.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasRestriction()) {
               this.setRestriction(other.getRestriction());
            }

            if (other.hasOfferType()) {
               this.setOfferType(other.getOfferType());
            }

            if (other.hasRule()) {
               this.mergeRule(other.getRule());
            }

            if (other.hasAvailableIfOwned()) {
               this.setAvailableIfOwned(other.getAvailableIfOwned());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Availability.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Availability parsedMessage = null;

         try {
            parsedMessage = (Availability)Availability.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Availability)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasRestriction() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getRestriction() {
         return this.restriction_;
      }

      public Availability.Builder setRestriction(int value) {
         this.bitField0_ |= 1;
         this.restriction_ = value;
         this.onChanged();
         return this;
      }

      public Availability.Builder clearRestriction() {
         this.bitField0_ &= -2;
         this.restriction_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasOfferType() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getOfferType() {
         return this.offerType_;
      }

      public Availability.Builder setOfferType(int value) {
         this.bitField0_ |= 2;
         this.offerType_ = value;
         this.onChanged();
         return this;
      }

      public Availability.Builder clearOfferType() {
         this.bitField0_ &= -3;
         this.offerType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasRule() {
         return (this.bitField0_ & 4) != 0;
      }

      public Rule getRule() {
         if (this.ruleBuilder_ == null) {
            return this.rule_ == null ? Rule.getDefaultInstance() : this.rule_;
         } else {
            return (Rule)this.ruleBuilder_.getMessage();
         }
      }

      public Availability.Builder setRule(Rule value) {
         if (this.ruleBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.rule_ = value;
            this.onChanged();
         } else {
            this.ruleBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Availability.Builder setRule(Rule.Builder builderForValue) {
         if (this.ruleBuilder_ == null) {
            this.rule_ = builderForValue.build();
            this.onChanged();
         } else {
            this.ruleBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Availability.Builder mergeRule(Rule value) {
         if (this.ruleBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0 && this.rule_ != null && this.rule_ != Rule.getDefaultInstance()) {
               this.rule_ = Rule.newBuilder(this.rule_).mergeFrom(value).buildPartial();
            } else {
               this.rule_ = value;
            }

            this.onChanged();
         } else {
            this.ruleBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Availability.Builder clearRule() {
         if (this.ruleBuilder_ == null) {
            this.rule_ = null;
            this.onChanged();
         } else {
            this.ruleBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public Rule.Builder getRuleBuilder() {
         this.bitField0_ |= 4;
         this.onChanged();
         return (Rule.Builder)this.getRuleFieldBuilder().getBuilder();
      }

      public RuleOrBuilder getRuleOrBuilder() {
         if (this.ruleBuilder_ != null) {
            return (RuleOrBuilder)this.ruleBuilder_.getMessageOrBuilder();
         } else {
            return this.rule_ == null ? Rule.getDefaultInstance() : this.rule_;
         }
      }

      private SingleFieldBuilderV3 getRuleFieldBuilder() {
         if (this.ruleBuilder_ == null) {
            this.ruleBuilder_ = new SingleFieldBuilderV3(this.getRule(), this.getParentForChildren(), this.isClean());
            this.rule_ = null;
         }

         return this.ruleBuilder_;
      }

      public boolean hasAvailableIfOwned() {
         return (this.bitField0_ & 8) != 0;
      }

      public boolean getAvailableIfOwned() {
         return this.availableIfOwned_;
      }

      public Availability.Builder setAvailableIfOwned(boolean value) {
         this.bitField0_ |= 8;
         this.availableIfOwned_ = value;
         this.onChanged();
         return this;
      }

      public Availability.Builder clearAvailableIfOwned() {
         this.bitField0_ &= -9;
         this.availableIfOwned_ = false;
         this.onChanged();
         return this;
      }

      public final Availability.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Availability.Builder)super.setUnknownFields(unknownFields);
      }

      public final Availability.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Availability.Builder)super.mergeUnknownFields(unknownFields);
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
