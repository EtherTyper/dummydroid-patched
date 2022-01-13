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

public final class AggregateRating extends GeneratedMessageV3 implements AggregateRatingOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int TYPE_FIELD_NUMBER = 1;
   private int type_;
   public static final int STARRATING_FIELD_NUMBER = 2;
   private float starRating_;
   public static final int RATINGSCOUNT_FIELD_NUMBER = 3;
   private long ratingsCount_;
   public static final int ONESTARRATINGS_FIELD_NUMBER = 4;
   private long oneStarRatings_;
   public static final int TWOSTARRATINGS_FIELD_NUMBER = 5;
   private long twoStarRatings_;
   public static final int THREESTARRATINGS_FIELD_NUMBER = 6;
   private long threeStarRatings_;
   public static final int FOURSTARRATINGS_FIELD_NUMBER = 7;
   private long fourStarRatings_;
   public static final int FIVESTARRATINGS_FIELD_NUMBER = 8;
   private long fiveStarRatings_;
   public static final int COMMENTCOUNT_FIELD_NUMBER = 11;
   private long commentCount_;
   public static final int LOCALIZEDAVERAGE_FIELD_NUMBER = 17;
   private volatile Object localizedAverage_;
   private byte memoizedIsInitialized;
   private static final AggregateRating DEFAULT_INSTANCE = new AggregateRating();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public AggregateRating parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new AggregateRating(input, extensionRegistry);
      }
   };

   private AggregateRating(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private AggregateRating() {
      this.memoizedIsInitialized = -1;
      this.localizedAverage_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new AggregateRating();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private AggregateRating(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.type_ = input.readInt32();
                  break;
               case 21:
                  this.bitField0_ |= 2;
                  this.starRating_ = input.readFloat();
                  break;
               case 24:
                  this.bitField0_ |= 4;
                  this.ratingsCount_ = input.readUInt64();
                  break;
               case 32:
                  this.bitField0_ |= 8;
                  this.oneStarRatings_ = input.readUInt64();
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.twoStarRatings_ = input.readUInt64();
                  break;
               case 48:
                  this.bitField0_ |= 32;
                  this.threeStarRatings_ = input.readUInt64();
                  break;
               case 56:
                  this.bitField0_ |= 64;
                  this.fourStarRatings_ = input.readUInt64();
                  break;
               case 64:
                  this.bitField0_ |= 128;
                  this.fiveStarRatings_ = input.readUInt64();
                  break;
               case 88:
                  this.bitField0_ |= 256;
                  this.commentCount_ = input.readUInt64();
                  break;
               case 138:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 512;
                  this.localizedAverage_ = bs;
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
      return Mothership.internal_static_AggregateRating_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_AggregateRating_fieldAccessorTable.ensureFieldAccessorsInitialized(AggregateRating.class, AggregateRating.Builder.class);
   }

   public boolean hasType() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getType() {
      return this.type_;
   }

   public boolean hasStarRating() {
      return (this.bitField0_ & 2) != 0;
   }

   public float getStarRating() {
      return this.starRating_;
   }

   public boolean hasRatingsCount() {
      return (this.bitField0_ & 4) != 0;
   }

   public long getRatingsCount() {
      return this.ratingsCount_;
   }

   public boolean hasOneStarRatings() {
      return (this.bitField0_ & 8) != 0;
   }

   public long getOneStarRatings() {
      return this.oneStarRatings_;
   }

   public boolean hasTwoStarRatings() {
      return (this.bitField0_ & 16) != 0;
   }

   public long getTwoStarRatings() {
      return this.twoStarRatings_;
   }

   public boolean hasThreeStarRatings() {
      return (this.bitField0_ & 32) != 0;
   }

   public long getThreeStarRatings() {
      return this.threeStarRatings_;
   }

   public boolean hasFourStarRatings() {
      return (this.bitField0_ & 64) != 0;
   }

   public long getFourStarRatings() {
      return this.fourStarRatings_;
   }

   public boolean hasFiveStarRatings() {
      return (this.bitField0_ & 128) != 0;
   }

   public long getFiveStarRatings() {
      return this.fiveStarRatings_;
   }

   public boolean hasCommentCount() {
      return (this.bitField0_ & 256) != 0;
   }

   public long getCommentCount() {
      return this.commentCount_;
   }

   public boolean hasLocalizedAverage() {
      return (this.bitField0_ & 512) != 0;
   }

   public String getLocalizedAverage() {
      Object ref = this.localizedAverage_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.localizedAverage_ = s;
         }

         return s;
      }
   }

   public ByteString getLocalizedAverageBytes() {
      Object ref = this.localizedAverage_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.localizedAverage_ = b;
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
         output.writeInt32(1, this.type_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeFloat(2, this.starRating_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeUInt64(3, this.ratingsCount_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeUInt64(4, this.oneStarRatings_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeUInt64(5, this.twoStarRatings_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeUInt64(6, this.threeStarRatings_);
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeUInt64(7, this.fourStarRatings_);
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeUInt64(8, this.fiveStarRatings_);
      }

      if ((this.bitField0_ & 256) != 0) {
         output.writeUInt64(11, this.commentCount_);
      }

      if ((this.bitField0_ & 512) != 0) {
         GeneratedMessageV3.writeString(output, 17, this.localizedAverage_);
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
            size += CodedOutputStream.computeInt32Size(1, this.type_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeFloatSize(2, this.starRating_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeUInt64Size(3, this.ratingsCount_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeUInt64Size(4, this.oneStarRatings_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeUInt64Size(5, this.twoStarRatings_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeUInt64Size(6, this.threeStarRatings_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeUInt64Size(7, this.fourStarRatings_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeUInt64Size(8, this.fiveStarRatings_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += CodedOutputStream.computeUInt64Size(11, this.commentCount_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += GeneratedMessageV3.computeStringSize(17, this.localizedAverage_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof AggregateRating)) {
         return super.equals(obj);
      } else {
         AggregateRating other = (AggregateRating)obj;
         if (this.hasType() != other.hasType()) {
            return false;
         } else if (this.hasType() && this.getType() != other.getType()) {
            return false;
         } else if (this.hasStarRating() != other.hasStarRating()) {
            return false;
         } else if (this.hasStarRating() && Float.floatToIntBits(this.getStarRating()) != Float.floatToIntBits(other.getStarRating())) {
            return false;
         } else if (this.hasRatingsCount() != other.hasRatingsCount()) {
            return false;
         } else if (this.hasRatingsCount() && this.getRatingsCount() != other.getRatingsCount()) {
            return false;
         } else if (this.hasOneStarRatings() != other.hasOneStarRatings()) {
            return false;
         } else if (this.hasOneStarRatings() && this.getOneStarRatings() != other.getOneStarRatings()) {
            return false;
         } else if (this.hasTwoStarRatings() != other.hasTwoStarRatings()) {
            return false;
         } else if (this.hasTwoStarRatings() && this.getTwoStarRatings() != other.getTwoStarRatings()) {
            return false;
         } else if (this.hasThreeStarRatings() != other.hasThreeStarRatings()) {
            return false;
         } else if (this.hasThreeStarRatings() && this.getThreeStarRatings() != other.getThreeStarRatings()) {
            return false;
         } else if (this.hasFourStarRatings() != other.hasFourStarRatings()) {
            return false;
         } else if (this.hasFourStarRatings() && this.getFourStarRatings() != other.getFourStarRatings()) {
            return false;
         } else if (this.hasFiveStarRatings() != other.hasFiveStarRatings()) {
            return false;
         } else if (this.hasFiveStarRatings() && this.getFiveStarRatings() != other.getFiveStarRatings()) {
            return false;
         } else if (this.hasCommentCount() != other.hasCommentCount()) {
            return false;
         } else if (this.hasCommentCount() && this.getCommentCount() != other.getCommentCount()) {
            return false;
         } else if (this.hasLocalizedAverage() != other.hasLocalizedAverage()) {
            return false;
         } else if (this.hasLocalizedAverage() && !this.getLocalizedAverage().equals(other.getLocalizedAverage())) {
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
         if (this.hasType()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getType();
         }

         if (this.hasStarRating()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + Float.floatToIntBits(this.getStarRating());
         }

         if (this.hasRatingsCount()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getRatingsCount());
         }

         if (this.hasOneStarRatings()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + Internal.hashLong(this.getOneStarRatings());
         }

         if (this.hasTwoStarRatings()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashLong(this.getTwoStarRatings());
         }

         if (this.hasThreeStarRatings()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + Internal.hashLong(this.getThreeStarRatings());
         }

         if (this.hasFourStarRatings()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + Internal.hashLong(this.getFourStarRatings());
         }

         if (this.hasFiveStarRatings()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + Internal.hashLong(this.getFiveStarRatings());
         }

         if (this.hasCommentCount()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + Internal.hashLong(this.getCommentCount());
         }

         if (this.hasLocalizedAverage()) {
            hash = 37 * hash + 17;
            hash = 53 * hash + this.getLocalizedAverage().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static AggregateRating parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data);
   }

   public static AggregateRating parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AggregateRating parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data);
   }

   public static AggregateRating parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AggregateRating parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data);
   }

   public static AggregateRating parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (AggregateRating)PARSER.parseFrom(data, extensionRegistry);
   }

   public static AggregateRating parseFrom(InputStream input) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AggregateRating parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static AggregateRating parseDelimitedFrom(InputStream input) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static AggregateRating parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static AggregateRating parseFrom(CodedInputStream input) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static AggregateRating parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (AggregateRating)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public AggregateRating.Builder newBuilderForType() {
      return newBuilder();
   }

   public static AggregateRating.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static AggregateRating.Builder newBuilder(AggregateRating prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public AggregateRating.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new AggregateRating.Builder() : (new AggregateRating.Builder()).mergeFrom(this);
   }

   protected AggregateRating.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      AggregateRating.Builder builder = new AggregateRating.Builder(parent);
      return builder;
   }

   public static AggregateRating getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public AggregateRating getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   AggregateRating(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   AggregateRating(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements AggregateRatingOrBuilder {
      private int bitField0_;
      private int type_;
      private float starRating_;
      private long ratingsCount_;
      private long oneStarRatings_;
      private long twoStarRatings_;
      private long threeStarRatings_;
      private long fourStarRatings_;
      private long fiveStarRatings_;
      private long commentCount_;
      private Object localizedAverage_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_AggregateRating_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_AggregateRating_fieldAccessorTable.ensureFieldAccessorsInitialized(AggregateRating.class, AggregateRating.Builder.class);
      }

      private Builder() {
         this.localizedAverage_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.localizedAverage_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (AggregateRating.alwaysUseFieldBuilders) {
         }

      }

      public AggregateRating.Builder clear() {
         super.clear();
         this.type_ = 0;
         this.bitField0_ &= -2;
         this.starRating_ = 0.0F;
         this.bitField0_ &= -3;
         this.ratingsCount_ = 0L;
         this.bitField0_ &= -5;
         this.oneStarRatings_ = 0L;
         this.bitField0_ &= -9;
         this.twoStarRatings_ = 0L;
         this.bitField0_ &= -17;
         this.threeStarRatings_ = 0L;
         this.bitField0_ &= -33;
         this.fourStarRatings_ = 0L;
         this.bitField0_ &= -65;
         this.fiveStarRatings_ = 0L;
         this.bitField0_ &= -129;
         this.commentCount_ = 0L;
         this.bitField0_ &= -257;
         this.localizedAverage_ = "";
         this.bitField0_ &= -513;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_AggregateRating_descriptor;
      }

      public AggregateRating getDefaultInstanceForType() {
         return AggregateRating.getDefaultInstance();
      }

      public AggregateRating build() {
         AggregateRating result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public AggregateRating buildPartial() {
         AggregateRating result = new AggregateRating(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.type_ = this.type_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.starRating_ = this.starRating_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            result.ratingsCount_ = this.ratingsCount_;
            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            result.oneStarRatings_ = this.oneStarRatings_;
            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 16) != 0) {
            result.twoStarRatings_ = this.twoStarRatings_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            result.threeStarRatings_ = this.threeStarRatings_;
            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            result.fourStarRatings_ = this.fourStarRatings_;
            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            result.fiveStarRatings_ = this.fiveStarRatings_;
            to_bitField0_ |= 128;
         }

         if ((from_bitField0_ & 256) != 0) {
            result.commentCount_ = this.commentCount_;
            to_bitField0_ |= 256;
         }

         if ((from_bitField0_ & 512) != 0) {
            to_bitField0_ |= 512;
         }

         result.localizedAverage_ = this.localizedAverage_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public AggregateRating.Builder clone() {
         return (AggregateRating.Builder)super.clone();
      }

      public AggregateRating.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (AggregateRating.Builder)super.setField(field, value);
      }

      public AggregateRating.Builder clearField(Descriptors.FieldDescriptor field) {
         return (AggregateRating.Builder)super.clearField(field);
      }

      public AggregateRating.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (AggregateRating.Builder)super.clearOneof(oneof);
      }

      public AggregateRating.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (AggregateRating.Builder)super.setRepeatedField(field, index, value);
      }

      public AggregateRating.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (AggregateRating.Builder)super.addRepeatedField(field, value);
      }

      public AggregateRating.Builder mergeFrom(Message other) {
         if (other instanceof AggregateRating) {
            return this.mergeFrom((AggregateRating)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public AggregateRating.Builder mergeFrom(AggregateRating other) {
         if (other == AggregateRating.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasType()) {
               this.setType(other.getType());
            }

            if (other.hasStarRating()) {
               this.setStarRating(other.getStarRating());
            }

            if (other.hasRatingsCount()) {
               this.setRatingsCount(other.getRatingsCount());
            }

            if (other.hasOneStarRatings()) {
               this.setOneStarRatings(other.getOneStarRatings());
            }

            if (other.hasTwoStarRatings()) {
               this.setTwoStarRatings(other.getTwoStarRatings());
            }

            if (other.hasThreeStarRatings()) {
               this.setThreeStarRatings(other.getThreeStarRatings());
            }

            if (other.hasFourStarRatings()) {
               this.setFourStarRatings(other.getFourStarRatings());
            }

            if (other.hasFiveStarRatings()) {
               this.setFiveStarRatings(other.getFiveStarRatings());
            }

            if (other.hasCommentCount()) {
               this.setCommentCount(other.getCommentCount());
            }

            if (other.hasLocalizedAverage()) {
               this.bitField0_ |= 512;
               this.localizedAverage_ = other.localizedAverage_;
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

      public AggregateRating.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         AggregateRating parsedMessage = null;

         try {
            parsedMessage = (AggregateRating)AggregateRating.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (AggregateRating)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasType() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getType() {
         return this.type_;
      }

      public AggregateRating.Builder setType(int value) {
         this.bitField0_ |= 1;
         this.type_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearType() {
         this.bitField0_ &= -2;
         this.type_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasStarRating() {
         return (this.bitField0_ & 2) != 0;
      }

      public float getStarRating() {
         return this.starRating_;
      }

      public AggregateRating.Builder setStarRating(float value) {
         this.bitField0_ |= 2;
         this.starRating_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearStarRating() {
         this.bitField0_ &= -3;
         this.starRating_ = 0.0F;
         this.onChanged();
         return this;
      }

      public boolean hasRatingsCount() {
         return (this.bitField0_ & 4) != 0;
      }

      public long getRatingsCount() {
         return this.ratingsCount_;
      }

      public AggregateRating.Builder setRatingsCount(long value) {
         this.bitField0_ |= 4;
         this.ratingsCount_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearRatingsCount() {
         this.bitField0_ &= -5;
         this.ratingsCount_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasOneStarRatings() {
         return (this.bitField0_ & 8) != 0;
      }

      public long getOneStarRatings() {
         return this.oneStarRatings_;
      }

      public AggregateRating.Builder setOneStarRatings(long value) {
         this.bitField0_ |= 8;
         this.oneStarRatings_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearOneStarRatings() {
         this.bitField0_ &= -9;
         this.oneStarRatings_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasTwoStarRatings() {
         return (this.bitField0_ & 16) != 0;
      }

      public long getTwoStarRatings() {
         return this.twoStarRatings_;
      }

      public AggregateRating.Builder setTwoStarRatings(long value) {
         this.bitField0_ |= 16;
         this.twoStarRatings_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearTwoStarRatings() {
         this.bitField0_ &= -17;
         this.twoStarRatings_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasThreeStarRatings() {
         return (this.bitField0_ & 32) != 0;
      }

      public long getThreeStarRatings() {
         return this.threeStarRatings_;
      }

      public AggregateRating.Builder setThreeStarRatings(long value) {
         this.bitField0_ |= 32;
         this.threeStarRatings_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearThreeStarRatings() {
         this.bitField0_ &= -33;
         this.threeStarRatings_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasFourStarRatings() {
         return (this.bitField0_ & 64) != 0;
      }

      public long getFourStarRatings() {
         return this.fourStarRatings_;
      }

      public AggregateRating.Builder setFourStarRatings(long value) {
         this.bitField0_ |= 64;
         this.fourStarRatings_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearFourStarRatings() {
         this.bitField0_ &= -65;
         this.fourStarRatings_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasFiveStarRatings() {
         return (this.bitField0_ & 128) != 0;
      }

      public long getFiveStarRatings() {
         return this.fiveStarRatings_;
      }

      public AggregateRating.Builder setFiveStarRatings(long value) {
         this.bitField0_ |= 128;
         this.fiveStarRatings_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearFiveStarRatings() {
         this.bitField0_ &= -129;
         this.fiveStarRatings_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasCommentCount() {
         return (this.bitField0_ & 256) != 0;
      }

      public long getCommentCount() {
         return this.commentCount_;
      }

      public AggregateRating.Builder setCommentCount(long value) {
         this.bitField0_ |= 256;
         this.commentCount_ = value;
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder clearCommentCount() {
         this.bitField0_ &= -257;
         this.commentCount_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasLocalizedAverage() {
         return (this.bitField0_ & 512) != 0;
      }

      public String getLocalizedAverage() {
         Object ref = this.localizedAverage_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.localizedAverage_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLocalizedAverageBytes() {
         Object ref = this.localizedAverage_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.localizedAverage_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public AggregateRating.Builder setLocalizedAverage(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.localizedAverage_ = value;
            this.onChanged();
            return this;
         }
      }

      public AggregateRating.Builder clearLocalizedAverage() {
         this.bitField0_ &= -513;
         this.localizedAverage_ = AggregateRating.getDefaultInstance().getLocalizedAverage();
         this.onChanged();
         return this;
      }

      public AggregateRating.Builder setLocalizedAverageBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.localizedAverage_ = value;
            this.onChanged();
            return this;
         }
      }

      public final AggregateRating.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (AggregateRating.Builder)super.setUnknownFields(unknownFields);
      }

      public final AggregateRating.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (AggregateRating.Builder)super.mergeUnknownFields(unknownFields);
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
