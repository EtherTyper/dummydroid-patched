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

public final class Offer extends GeneratedMessageV3 implements OfferOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int MICROS_FIELD_NUMBER = 1;
   private long micros_;
   public static final int CURRENCYCODE_FIELD_NUMBER = 2;
   private volatile Object currencyCode_;
   public static final int FORMATTEDAMOUNT_FIELD_NUMBER = 3;
   private volatile Object formattedAmount_;
   public static final int CHECKOUTFLOWREQUIRED_FIELD_NUMBER = 5;
   private boolean checkoutFlowRequired_;
   public static final int FULLPRICEMICROS_FIELD_NUMBER = 6;
   private long fullPriceMicros_;
   public static final int OFFERTYPE_FIELD_NUMBER = 8;
   private int offerType_;
   public static final int PREORDER_FIELD_NUMBER = 15;
   private boolean preorder_;
   public static final int OFFERID_FIELD_NUMBER = 19;
   private volatile Object offerId_;
   public static final int TEMPORARILYFREE_FIELD_NUMBER = 22;
   private boolean temporarilyFree_;
   private byte memoizedIsInitialized;
   private static final Offer DEFAULT_INSTANCE = new Offer();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Offer parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Offer(input, extensionRegistry);
      }
   };

   private Offer(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Offer() {
      this.memoizedIsInitialized = -1;
      this.currencyCode_ = "";
      this.formattedAmount_ = "";
      this.offerId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Offer();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Offer(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.micros_ = input.readInt64();
                  break;
               case 18:
                  bs = input.readBytes();
                  this.bitField0_ |= 2;
                  this.currencyCode_ = bs;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.formattedAmount_ = bs;
                  break;
               case 40:
                  this.bitField0_ |= 8;
                  this.checkoutFlowRequired_ = input.readBool();
                  break;
               case 48:
                  this.bitField0_ |= 16;
                  this.fullPriceMicros_ = input.readInt64();
                  break;
               case 64:
                  this.bitField0_ |= 32;
                  this.offerType_ = input.readInt32();
                  break;
               case 120:
                  this.bitField0_ |= 64;
                  this.preorder_ = input.readBool();
                  break;
               case 154:
                  bs = input.readBytes();
                  this.bitField0_ |= 128;
                  this.offerId_ = bs;
                  break;
               case 176:
                  this.bitField0_ |= 256;
                  this.temporarilyFree_ = input.readBool();
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
      return Mothership.internal_static_Offer_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Offer_fieldAccessorTable.ensureFieldAccessorsInitialized(Offer.class, Offer.Builder.class);
   }

   public boolean hasMicros() {
      return (this.bitField0_ & 1) != 0;
   }

   public long getMicros() {
      return this.micros_;
   }

   public boolean hasCurrencyCode() {
      return (this.bitField0_ & 2) != 0;
   }

   public String getCurrencyCode() {
      Object ref = this.currencyCode_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.currencyCode_ = s;
         }

         return s;
      }
   }

   public ByteString getCurrencyCodeBytes() {
      Object ref = this.currencyCode_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.currencyCode_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasFormattedAmount() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getFormattedAmount() {
      Object ref = this.formattedAmount_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.formattedAmount_ = s;
         }

         return s;
      }
   }

   public ByteString getFormattedAmountBytes() {
      Object ref = this.formattedAmount_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.formattedAmount_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasCheckoutFlowRequired() {
      return (this.bitField0_ & 8) != 0;
   }

   public boolean getCheckoutFlowRequired() {
      return this.checkoutFlowRequired_;
   }

   public boolean hasFullPriceMicros() {
      return (this.bitField0_ & 16) != 0;
   }

   public long getFullPriceMicros() {
      return this.fullPriceMicros_;
   }

   public boolean hasOfferType() {
      return (this.bitField0_ & 32) != 0;
   }

   public int getOfferType() {
      return this.offerType_;
   }

   public boolean hasPreorder() {
      return (this.bitField0_ & 64) != 0;
   }

   public boolean getPreorder() {
      return this.preorder_;
   }

   public boolean hasOfferId() {
      return (this.bitField0_ & 128) != 0;
   }

   public String getOfferId() {
      Object ref = this.offerId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.offerId_ = s;
         }

         return s;
      }
   }

   public ByteString getOfferIdBytes() {
      Object ref = this.offerId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.offerId_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasTemporarilyFree() {
      return (this.bitField0_ & 256) != 0;
   }

   public boolean getTemporarilyFree() {
      return this.temporarilyFree_;
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
         output.writeInt64(1, this.micros_);
      }

      if ((this.bitField0_ & 2) != 0) {
         GeneratedMessageV3.writeString(output, 2, this.currencyCode_);
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.formattedAmount_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeBool(5, this.checkoutFlowRequired_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeInt64(6, this.fullPriceMicros_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeInt32(8, this.offerType_);
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeBool(15, this.preorder_);
      }

      if ((this.bitField0_ & 128) != 0) {
         GeneratedMessageV3.writeString(output, 19, this.offerId_);
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeBool(22, this.temporarilyFree_);
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
            size += CodedOutputStream.computeInt64Size(1, this.micros_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += GeneratedMessageV3.computeStringSize(2, this.currencyCode_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.formattedAmount_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeBoolSize(5, this.checkoutFlowRequired_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeInt64Size(6, this.fullPriceMicros_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.offerType_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeBoolSize(15, this.preorder_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += GeneratedMessageV3.computeStringSize(19, this.offerId_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeBoolSize(22, this.temporarilyFree_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Offer)) {
         return super.equals(obj);
      } else {
         Offer other = (Offer)obj;
         if (this.hasMicros() != other.hasMicros()) {
            return false;
         } else if (this.hasMicros() && this.getMicros() != other.getMicros()) {
            return false;
         } else if (this.hasCurrencyCode() != other.hasCurrencyCode()) {
            return false;
         } else if (this.hasCurrencyCode() && !this.getCurrencyCode().equals(other.getCurrencyCode())) {
            return false;
         } else if (this.hasFormattedAmount() != other.hasFormattedAmount()) {
            return false;
         } else if (this.hasFormattedAmount() && !this.getFormattedAmount().equals(other.getFormattedAmount())) {
            return false;
         } else if (this.hasCheckoutFlowRequired() != other.hasCheckoutFlowRequired()) {
            return false;
         } else if (this.hasCheckoutFlowRequired() && this.getCheckoutFlowRequired() != other.getCheckoutFlowRequired()) {
            return false;
         } else if (this.hasFullPriceMicros() != other.hasFullPriceMicros()) {
            return false;
         } else if (this.hasFullPriceMicros() && this.getFullPriceMicros() != other.getFullPriceMicros()) {
            return false;
         } else if (this.hasOfferType() != other.hasOfferType()) {
            return false;
         } else if (this.hasOfferType() && this.getOfferType() != other.getOfferType()) {
            return false;
         } else if (this.hasPreorder() != other.hasPreorder()) {
            return false;
         } else if (this.hasPreorder() && this.getPreorder() != other.getPreorder()) {
            return false;
         } else if (this.hasOfferId() != other.hasOfferId()) {
            return false;
         } else if (this.hasOfferId() && !this.getOfferId().equals(other.getOfferId())) {
            return false;
         } else if (this.hasTemporarilyFree() != other.hasTemporarilyFree()) {
            return false;
         } else if (this.hasTemporarilyFree() && this.getTemporarilyFree() != other.getTemporarilyFree()) {
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
         if (this.hasMicros()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getMicros());
         }

         if (this.hasCurrencyCode()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getCurrencyCode().hashCode();
         }

         if (this.hasFormattedAmount()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getFormattedAmount().hashCode();
         }

         if (this.hasCheckoutFlowRequired()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashBoolean(this.getCheckoutFlowRequired());
         }

         if (this.hasFullPriceMicros()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + Internal.hashLong(this.getFullPriceMicros());
         }

         if (this.hasOfferType()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getOfferType();
         }

         if (this.hasPreorder()) {
            hash = 37 * hash + 15;
            hash = 53 * hash + Internal.hashBoolean(this.getPreorder());
         }

         if (this.hasOfferId()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getOfferId().hashCode();
         }

         if (this.hasTemporarilyFree()) {
            hash = 37 * hash + 22;
            hash = 53 * hash + Internal.hashBoolean(this.getTemporarilyFree());
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Offer parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data);
   }

   public static Offer parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Offer parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data);
   }

   public static Offer parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Offer parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data);
   }

   public static Offer parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Offer)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Offer parseFrom(InputStream input) throws IOException {
      return (Offer)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Offer parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Offer)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Offer parseDelimitedFrom(InputStream input) throws IOException {
      return (Offer)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Offer parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Offer)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Offer parseFrom(CodedInputStream input) throws IOException {
      return (Offer)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Offer parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Offer)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Offer.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Offer.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Offer.Builder newBuilder(Offer prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Offer.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Offer.Builder() : (new Offer.Builder()).mergeFrom(this);
   }

   protected Offer.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Offer.Builder builder = new Offer.Builder(parent);
      return builder;
   }

   public static Offer getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Offer getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Offer(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Offer(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements OfferOrBuilder {
      private int bitField0_;
      private long micros_;
      private Object currencyCode_;
      private Object formattedAmount_;
      private boolean checkoutFlowRequired_;
      private long fullPriceMicros_;
      private int offerType_;
      private boolean preorder_;
      private Object offerId_;
      private boolean temporarilyFree_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Offer_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Offer_fieldAccessorTable.ensureFieldAccessorsInitialized(Offer.class, Offer.Builder.class);
      }

      private Builder() {
         this.currencyCode_ = "";
         this.formattedAmount_ = "";
         this.offerId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.currencyCode_ = "";
         this.formattedAmount_ = "";
         this.offerId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Offer.alwaysUseFieldBuilders) {
         }

      }

      public Offer.Builder clear() {
         super.clear();
         this.micros_ = 0L;
         this.bitField0_ &= -2;
         this.currencyCode_ = "";
         this.bitField0_ &= -3;
         this.formattedAmount_ = "";
         this.bitField0_ &= -5;
         this.checkoutFlowRequired_ = false;
         this.bitField0_ &= -9;
         this.fullPriceMicros_ = 0L;
         this.bitField0_ &= -17;
         this.offerType_ = 0;
         this.bitField0_ &= -33;
         this.preorder_ = false;
         this.bitField0_ &= -65;
         this.offerId_ = "";
         this.bitField0_ &= -129;
         this.temporarilyFree_ = false;
         this.bitField0_ &= -257;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Offer_descriptor;
      }

      public Offer getDefaultInstanceForType() {
         return Offer.getDefaultInstance();
      }

      public Offer build() {
         Offer result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Offer buildPartial() {
         Offer result = new Offer(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.micros_ = this.micros_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            to_bitField0_ |= 2;
         }

         result.currencyCode_ = this.currencyCode_;
         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.formattedAmount_ = this.formattedAmount_;
         if ((from_bitField0_ & 8) != 0) {
            result.checkoutFlowRequired_ = this.checkoutFlowRequired_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            result.fullPriceMicros_ = this.fullPriceMicros_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.offerType_ = this.offerType_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            result.preorder_ = this.preorder_;
            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 128;
         }

         result.offerId_ = this.offerId_;
         if ((from_bitField0_ & 256) != 0) {
            result.temporarilyFree_ = this.temporarilyFree_;
            to_bitField0_ |= 256;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Offer.Builder clone() {
         return (Offer.Builder)super.clone();
      }

      public Offer.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Offer.Builder)super.setField(field, value);
      }

      public Offer.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Offer.Builder)super.clearField(field);
      }

      public Offer.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Offer.Builder)super.clearOneof(oneof);
      }

      public Offer.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Offer.Builder)super.setRepeatedField(field, index, value);
      }

      public Offer.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Offer.Builder)super.addRepeatedField(field, value);
      }

      public Offer.Builder mergeFrom(Message other) {
         if (other instanceof Offer) {
            return this.mergeFrom((Offer)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Offer.Builder mergeFrom(Offer other) {
         if (other == Offer.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasMicros()) {
               this.setMicros(other.getMicros());
            }

            if (other.hasCurrencyCode()) {
               this.bitField0_ |= 2;
               this.currencyCode_ = other.currencyCode_;
               this.onChanged();
            }

            if (other.hasFormattedAmount()) {
               this.bitField0_ |= 4;
               this.formattedAmount_ = other.formattedAmount_;
               this.onChanged();
            }

            if (other.hasCheckoutFlowRequired()) {
               this.setCheckoutFlowRequired(other.getCheckoutFlowRequired());
            }

            if (other.hasFullPriceMicros()) {
               this.setFullPriceMicros(other.getFullPriceMicros());
            }

            if (other.hasOfferType()) {
               this.setOfferType(other.getOfferType());
            }

            if (other.hasPreorder()) {
               this.setPreorder(other.getPreorder());
            }

            if (other.hasOfferId()) {
               this.bitField0_ |= 128;
               this.offerId_ = other.offerId_;
               this.onChanged();
            }

            if (other.hasTemporarilyFree()) {
               this.setTemporarilyFree(other.getTemporarilyFree());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public Offer.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Offer parsedMessage = null;

         try {
            parsedMessage = (Offer)Offer.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Offer)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasMicros() {
         return (this.bitField0_ & 1) != 0;
      }

      public long getMicros() {
         return this.micros_;
      }

      public Offer.Builder setMicros(long value) {
         this.bitField0_ |= 1;
         this.micros_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearMicros() {
         this.bitField0_ &= -2;
         this.micros_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasCurrencyCode() {
         return (this.bitField0_ & 2) != 0;
      }

      public String getCurrencyCode() {
         Object ref = this.currencyCode_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.currencyCode_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getCurrencyCodeBytes() {
         Object ref = this.currencyCode_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.currencyCode_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Offer.Builder setCurrencyCode(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.currencyCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public Offer.Builder clearCurrencyCode() {
         this.bitField0_ &= -3;
         this.currencyCode_ = Offer.getDefaultInstance().getCurrencyCode();
         this.onChanged();
         return this;
      }

      public Offer.Builder setCurrencyCodeBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 2;
            this.currencyCode_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasFormattedAmount() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getFormattedAmount() {
         Object ref = this.formattedAmount_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.formattedAmount_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getFormattedAmountBytes() {
         Object ref = this.formattedAmount_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.formattedAmount_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Offer.Builder setFormattedAmount(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.formattedAmount_ = value;
            this.onChanged();
            return this;
         }
      }

      public Offer.Builder clearFormattedAmount() {
         this.bitField0_ &= -5;
         this.formattedAmount_ = Offer.getDefaultInstance().getFormattedAmount();
         this.onChanged();
         return this;
      }

      public Offer.Builder setFormattedAmountBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.formattedAmount_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasCheckoutFlowRequired() {
         return (this.bitField0_ & 8) != 0;
      }

      public boolean getCheckoutFlowRequired() {
         return this.checkoutFlowRequired_;
      }

      public Offer.Builder setCheckoutFlowRequired(boolean value) {
         this.bitField0_ |= 8;
         this.checkoutFlowRequired_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearCheckoutFlowRequired() {
         this.bitField0_ &= -9;
         this.checkoutFlowRequired_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasFullPriceMicros() {
         return (this.bitField0_ & 16) != 0;
      }

      public long getFullPriceMicros() {
         return this.fullPriceMicros_;
      }

      public Offer.Builder setFullPriceMicros(long value) {
         this.bitField0_ |= 16;
         this.fullPriceMicros_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearFullPriceMicros() {
         this.bitField0_ &= -17;
         this.fullPriceMicros_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasOfferType() {
         return (this.bitField0_ & 32) != 0;
      }

      public int getOfferType() {
         return this.offerType_;
      }

      public Offer.Builder setOfferType(int value) {
         this.bitField0_ |= 32;
         this.offerType_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearOfferType() {
         this.bitField0_ &= -33;
         this.offerType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasPreorder() {
         return (this.bitField0_ & 64) != 0;
      }

      public boolean getPreorder() {
         return this.preorder_;
      }

      public Offer.Builder setPreorder(boolean value) {
         this.bitField0_ |= 64;
         this.preorder_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearPreorder() {
         this.bitField0_ &= -65;
         this.preorder_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasOfferId() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getOfferId() {
         Object ref = this.offerId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.offerId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getOfferIdBytes() {
         Object ref = this.offerId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.offerId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Offer.Builder setOfferId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.offerId_ = value;
            this.onChanged();
            return this;
         }
      }

      public Offer.Builder clearOfferId() {
         this.bitField0_ &= -129;
         this.offerId_ = Offer.getDefaultInstance().getOfferId();
         this.onChanged();
         return this;
      }

      public Offer.Builder setOfferIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.offerId_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasTemporarilyFree() {
         return (this.bitField0_ & 256) != 0;
      }

      public boolean getTemporarilyFree() {
         return this.temporarilyFree_;
      }

      public Offer.Builder setTemporarilyFree(boolean value) {
         this.bitField0_ |= 256;
         this.temporarilyFree_ = value;
         this.onChanged();
         return this;
      }

      public Offer.Builder clearTemporarilyFree() {
         this.bitField0_ &= -257;
         this.temporarilyFree_ = false;
         this.onChanged();
         return this;
      }

      public final Offer.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Offer.Builder)super.setUnknownFields(unknownFields);
      }

      public final Offer.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Offer.Builder)super.mergeUnknownFields(unknownFields);
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
