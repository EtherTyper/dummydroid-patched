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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Image extends GeneratedMessageV3 implements ImageOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int IMAGETYPE_FIELD_NUMBER = 1;
   private int imageType_;
   public static final int DIMENSION_FIELD_NUMBER = 2;
   private Image.Dimension dimension_;
   public static final int IMAGEURL_FIELD_NUMBER = 5;
   private volatile Object imageUrl_;
   private byte memoizedIsInitialized;
   private static final Image DEFAULT_INSTANCE = new Image();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Image parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Image(input, extensionRegistry);
      }
   };

   private Image(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Image() {
      this.memoizedIsInitialized = -1;
      this.imageUrl_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Image();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Image(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.imageType_ = input.readInt32();
                  break;
               case 19:
                  Image.Dimension.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.dimension_.toBuilder();
                  }

                  this.dimension_ = (Image.Dimension)input.readGroup(2, (Parser)Image.Dimension.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.dimension_);
                     this.dimension_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
                  break;
               case 42:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.imageUrl_ = bs;
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
      return Mothership.internal_static_Image_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Image_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.class, Image.Builder.class);
   }

   public boolean hasImageType() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getImageType() {
      return this.imageType_;
   }

   public boolean hasDimension() {
      return (this.bitField0_ & 2) != 0;
   }

   public Image.Dimension getDimension() {
      return this.dimension_ == null ? Image.Dimension.getDefaultInstance() : this.dimension_;
   }

   public Image.DimensionOrBuilder getDimensionOrBuilder() {
      return this.dimension_ == null ? Image.Dimension.getDefaultInstance() : this.dimension_;
   }

   public boolean hasImageUrl() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getImageUrl() {
      Object ref = this.imageUrl_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.imageUrl_ = s;
         }

         return s;
      }
   }

   public ByteString getImageUrlBytes() {
      Object ref = this.imageUrl_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.imageUrl_ = b;
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
         output.writeInt32(1, this.imageType_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeGroup(2, this.getDimension());
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.imageUrl_);
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
            size += CodedOutputStream.computeInt32Size(1, this.imageType_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeGroupSize(2, this.getDimension());
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.imageUrl_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Image)) {
         return super.equals(obj);
      } else {
         Image other = (Image)obj;
         if (this.hasImageType() != other.hasImageType()) {
            return false;
         } else if (this.hasImageType() && this.getImageType() != other.getImageType()) {
            return false;
         } else if (this.hasDimension() != other.hasDimension()) {
            return false;
         } else if (this.hasDimension() && !this.getDimension().equals(other.getDimension())) {
            return false;
         } else if (this.hasImageUrl() != other.hasImageUrl()) {
            return false;
         } else if (this.hasImageUrl() && !this.getImageUrl().equals(other.getImageUrl())) {
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
         if (this.hasImageType()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getImageType();
         }

         if (this.hasDimension()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getDimension().hashCode();
         }

         if (this.hasImageUrl()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getImageUrl().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Image parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data);
   }

   public static Image parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Image parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data);
   }

   public static Image parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Image parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data);
   }

   public static Image parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Image)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Image parseFrom(InputStream input) throws IOException {
      return (Image)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Image parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Image)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Image parseDelimitedFrom(InputStream input) throws IOException {
      return (Image)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Image parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Image)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Image parseFrom(CodedInputStream input) throws IOException {
      return (Image)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Image parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Image)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Image.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Image.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Image.Builder newBuilder(Image prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Image.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Image.Builder() : (new Image.Builder()).mergeFrom(this);
   }

   protected Image.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Image.Builder builder = new Image.Builder(parent);
      return builder;
   }

   public static Image getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Image getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Image(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Image(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ImageOrBuilder {
      private int bitField0_;
      private int imageType_;
      private Image.Dimension dimension_;
      private SingleFieldBuilderV3 dimensionBuilder_;
      private Object imageUrl_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Image_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Image_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.class, Image.Builder.class);
      }

      private Builder() {
         this.imageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.imageUrl_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Image.alwaysUseFieldBuilders) {
            this.getDimensionFieldBuilder();
         }

      }

      public Image.Builder clear() {
         super.clear();
         this.imageType_ = 0;
         this.bitField0_ &= -2;
         if (this.dimensionBuilder_ == null) {
            this.dimension_ = null;
         } else {
            this.dimensionBuilder_.clear();
         }

         this.bitField0_ &= -3;
         this.imageUrl_ = "";
         this.bitField0_ &= -5;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Image_descriptor;
      }

      public Image getDefaultInstanceForType() {
         return Image.getDefaultInstance();
      }

      public Image build() {
         Image result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Image buildPartial() {
         Image result = new Image(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.imageType_ = this.imageType_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.dimensionBuilder_ == null) {
               result.dimension_ = this.dimension_;
            } else {
               result.dimension_ = (Image.Dimension)this.dimensionBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.imageUrl_ = this.imageUrl_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Image.Builder clone() {
         return (Image.Builder)super.clone();
      }

      public Image.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Image.Builder)super.setField(field, value);
      }

      public Image.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Image.Builder)super.clearField(field);
      }

      public Image.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Image.Builder)super.clearOneof(oneof);
      }

      public Image.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Image.Builder)super.setRepeatedField(field, index, value);
      }

      public Image.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Image.Builder)super.addRepeatedField(field, value);
      }

      public Image.Builder mergeFrom(Message other) {
         if (other instanceof Image) {
            return this.mergeFrom((Image)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Image.Builder mergeFrom(Image other) {
         if (other == Image.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasImageType()) {
               this.setImageType(other.getImageType());
            }

            if (other.hasDimension()) {
               this.mergeDimension(other.getDimension());
            }

            if (other.hasImageUrl()) {
               this.bitField0_ |= 4;
               this.imageUrl_ = other.imageUrl_;
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

      public Image.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Image parsedMessage = null;

         try {
            parsedMessage = (Image)Image.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Image)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasImageType() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getImageType() {
         return this.imageType_;
      }

      public Image.Builder setImageType(int value) {
         this.bitField0_ |= 1;
         this.imageType_ = value;
         this.onChanged();
         return this;
      }

      public Image.Builder clearImageType() {
         this.bitField0_ &= -2;
         this.imageType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasDimension() {
         return (this.bitField0_ & 2) != 0;
      }

      public Image.Dimension getDimension() {
         if (this.dimensionBuilder_ == null) {
            return this.dimension_ == null ? Image.Dimension.getDefaultInstance() : this.dimension_;
         } else {
            return (Image.Dimension)this.dimensionBuilder_.getMessage();
         }
      }

      public Image.Builder setDimension(Image.Dimension value) {
         if (this.dimensionBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.dimension_ = value;
            this.onChanged();
         } else {
            this.dimensionBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Image.Builder setDimension(Image.Dimension.Builder builderForValue) {
         if (this.dimensionBuilder_ == null) {
            this.dimension_ = builderForValue.build();
            this.onChanged();
         } else {
            this.dimensionBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Image.Builder mergeDimension(Image.Dimension value) {
         if (this.dimensionBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.dimension_ != null && this.dimension_ != Image.Dimension.getDefaultInstance()) {
               this.dimension_ = Image.Dimension.newBuilder(this.dimension_).mergeFrom(value).buildPartial();
            } else {
               this.dimension_ = value;
            }

            this.onChanged();
         } else {
            this.dimensionBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public Image.Builder clearDimension() {
         if (this.dimensionBuilder_ == null) {
            this.dimension_ = null;
            this.onChanged();
         } else {
            this.dimensionBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public Image.Dimension.Builder getDimensionBuilder() {
         this.bitField0_ |= 2;
         this.onChanged();
         return (Image.Dimension.Builder)this.getDimensionFieldBuilder().getBuilder();
      }

      public Image.DimensionOrBuilder getDimensionOrBuilder() {
         if (this.dimensionBuilder_ != null) {
            return (Image.DimensionOrBuilder)this.dimensionBuilder_.getMessageOrBuilder();
         } else {
            return this.dimension_ == null ? Image.Dimension.getDefaultInstance() : this.dimension_;
         }
      }

      private SingleFieldBuilderV3 getDimensionFieldBuilder() {
         if (this.dimensionBuilder_ == null) {
            this.dimensionBuilder_ = new SingleFieldBuilderV3(this.getDimension(), this.getParentForChildren(), this.isClean());
            this.dimension_ = null;
         }

         return this.dimensionBuilder_;
      }

      public boolean hasImageUrl() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getImageUrl() {
         Object ref = this.imageUrl_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.imageUrl_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getImageUrlBytes() {
         Object ref = this.imageUrl_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.imageUrl_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Image.Builder setImageUrl(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.imageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public Image.Builder clearImageUrl() {
         this.bitField0_ &= -5;
         this.imageUrl_ = Image.getDefaultInstance().getImageUrl();
         this.onChanged();
         return this;
      }

      public Image.Builder setImageUrlBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.imageUrl_ = value;
            this.onChanged();
            return this;
         }
      }

      public final Image.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Image.Builder)super.setUnknownFields(unknownFields);
      }

      public final Image.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Image.Builder)super.mergeUnknownFields(unknownFields);
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

   public static final class Dimension extends GeneratedMessageV3 implements Image.DimensionOrBuilder {
      private static final long serialVersionUID = 0L;
      private int bitField0_;
      public static final int WIDTH_FIELD_NUMBER = 3;
      private int width_;
      public static final int HEIGHT_FIELD_NUMBER = 4;
      private int height_;
      private byte memoizedIsInitialized;
      private static final Image.Dimension DEFAULT_INSTANCE = new Image.Dimension();
      /** @deprecated */
      @Deprecated
      public static final Parser PARSER = new AbstractParser() {
         public Image.Dimension parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new Image.Dimension(input, extensionRegistry);
         }
      };

      private Dimension(GeneratedMessageV3.Builder builder) {
         super(builder);
         this.memoizedIsInitialized = -1;
      }

      private Dimension() {
         this.memoizedIsInitialized = -1;
      }

      protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
         return new Image.Dimension();
      }

      public final UnknownFieldSet getUnknownFields() {
         return this.unknownFields;
      }

      private Dimension(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  case 24:
                     this.bitField0_ |= 1;
                     this.width_ = input.readInt32();
                     break;
                  case 32:
                     this.bitField0_ |= 2;
                     this.height_ = input.readInt32();
                     break;
                  default:
                     if (!this.parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                        done = true;
                     }
                  }
               }
            } catch (InvalidProtocolBufferException var11) {
               throw var11.setUnfinishedMessage(this);
            } catch (IOException var12) {
               throw (new InvalidProtocolBufferException(var12)).setUnfinishedMessage(this);
            } finally {
               this.unknownFields = unknownFields.build();
               this.makeExtensionsImmutable();
            }

         }
      }

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Image_Dimension_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Image_Dimension_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.Dimension.class, Image.Dimension.Builder.class);
      }

      public boolean hasWidth() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getWidth() {
         return this.width_;
      }

      public boolean hasHeight() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getHeight() {
         return this.height_;
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
            output.writeInt32(3, this.width_);
         }

         if ((this.bitField0_ & 2) != 0) {
            output.writeInt32(4, this.height_);
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
               size += CodedOutputStream.computeInt32Size(3, this.width_);
            }

            if ((this.bitField0_ & 2) != 0) {
               size += CodedOutputStream.computeInt32Size(4, this.height_);
            }

            size += this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
         }
      }

      public boolean equals(Object obj) {
         if (obj == this) {
            return true;
         } else if (!(obj instanceof Image.Dimension)) {
            return super.equals(obj);
         } else {
            Image.Dimension other = (Image.Dimension)obj;
            if (this.hasWidth() != other.hasWidth()) {
               return false;
            } else if (this.hasWidth() && this.getWidth() != other.getWidth()) {
               return false;
            } else if (this.hasHeight() != other.hasHeight()) {
               return false;
            } else if (this.hasHeight() && this.getHeight() != other.getHeight()) {
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
            if (this.hasWidth()) {
               hash = 37 * hash + 3;
               hash = 53 * hash + this.getWidth();
            }

            if (this.hasHeight()) {
               hash = 37 * hash + 4;
               hash = 53 * hash + this.getHeight();
            }

            hash = 29 * hash + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
         }
      }

      public static Image.Dimension parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data);
      }

      public static Image.Dimension parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data, extensionRegistry);
      }

      public static Image.Dimension parseFrom(ByteString data) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data);
      }

      public static Image.Dimension parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data, extensionRegistry);
      }

      public static Image.Dimension parseFrom(byte[] data) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data);
      }

      public static Image.Dimension parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return (Image.Dimension)PARSER.parseFrom(data, extensionRegistry);
      }

      public static Image.Dimension parseFrom(InputStream input) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseWithIOException(PARSER, input);
      }

      public static Image.Dimension parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
      }

      public static Image.Dimension parseDelimitedFrom(InputStream input) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
      }

      public static Image.Dimension parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
      }

      public static Image.Dimension parseFrom(CodedInputStream input) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseWithIOException(PARSER, input);
      }

      public static Image.Dimension parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         return (Image.Dimension)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
      }

      public Image.Dimension.Builder newBuilderForType() {
         return newBuilder();
      }

      public static Image.Dimension.Builder newBuilder() {
         return DEFAULT_INSTANCE.toBuilder();
      }

      public static Image.Dimension.Builder newBuilder(Image.Dimension prototype) {
         return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
      }

      public Image.Dimension.Builder toBuilder() {
         return this == DEFAULT_INSTANCE ? new Image.Dimension.Builder() : (new Image.Dimension.Builder()).mergeFrom(this);
      }

      protected Image.Dimension.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
         Image.Dimension.Builder builder = new Image.Dimension.Builder(parent);
         return builder;
      }

      public static Image.Dimension getDefaultInstance() {
         return DEFAULT_INSTANCE;
      }

      public static Parser parser() {
         return PARSER;
      }

      public Parser getParserForType() {
         return PARSER;
      }

      public Image.Dimension getDefaultInstanceForType() {
         return DEFAULT_INSTANCE;
      }

      // $FF: synthetic method
      Dimension(GeneratedMessageV3.Builder x0, Object x1) {
         this(x0);
      }

      // $FF: synthetic method
      Dimension(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
         this(x0, x1);
      }

      public static final class Builder extends GeneratedMessageV3.Builder implements Image.DimensionOrBuilder {
         private int bitField0_;
         private int width_;
         private int height_;

         public static final Descriptors.Descriptor getDescriptor() {
            return Mothership.internal_static_Image_Dimension_descriptor;
         }

         protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Mothership.internal_static_Image_Dimension_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.Dimension.class, Image.Dimension.Builder.class);
         }

         private Builder() {
            this.maybeForceBuilderInitialization();
         }

         private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.maybeForceBuilderInitialization();
         }

         private void maybeForceBuilderInitialization() {
            if (Image.Dimension.alwaysUseFieldBuilders) {
            }

         }

         public Image.Dimension.Builder clear() {
            super.clear();
            this.width_ = 0;
            this.bitField0_ &= -2;
            this.height_ = 0;
            this.bitField0_ &= -3;
            return this;
         }

         public Descriptors.Descriptor getDescriptorForType() {
            return Mothership.internal_static_Image_Dimension_descriptor;
         }

         public Image.Dimension getDefaultInstanceForType() {
            return Image.Dimension.getDefaultInstance();
         }

         public Image.Dimension build() {
            Image.Dimension result = this.buildPartial();
            if (!result.isInitialized()) {
               throw newUninitializedMessageException(result);
            } else {
               return result;
            }
         }

         public Image.Dimension buildPartial() {
            Image.Dimension result = new Image.Dimension(this);
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
               result.width_ = this.width_;
               to_bitField0_ |= 1;
            }

            if ((from_bitField0_ & 2) != 0) {
               result.height_ = this.height_;
               to_bitField0_ |= 2;
            }

            result.bitField0_ = to_bitField0_;
            this.onBuilt();
            return result;
         }

         public Image.Dimension.Builder clone() {
            return (Image.Dimension.Builder)super.clone();
         }

         public Image.Dimension.Builder setField(Descriptors.FieldDescriptor field, Object value) {
            return (Image.Dimension.Builder)super.setField(field, value);
         }

         public Image.Dimension.Builder clearField(Descriptors.FieldDescriptor field) {
            return (Image.Dimension.Builder)super.clearField(field);
         }

         public Image.Dimension.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
            return (Image.Dimension.Builder)super.clearOneof(oneof);
         }

         public Image.Dimension.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            return (Image.Dimension.Builder)super.setRepeatedField(field, index, value);
         }

         public Image.Dimension.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            return (Image.Dimension.Builder)super.addRepeatedField(field, value);
         }

         public Image.Dimension.Builder mergeFrom(Message other) {
            if (other instanceof Image.Dimension) {
               return this.mergeFrom((Image.Dimension)other);
            } else {
               super.mergeFrom(other);
               return this;
            }
         }

         public Image.Dimension.Builder mergeFrom(Image.Dimension other) {
            if (other == Image.Dimension.getDefaultInstance()) {
               return this;
            } else {
               if (other.hasWidth()) {
                  this.setWidth(other.getWidth());
               }

               if (other.hasHeight()) {
                  this.setHeight(other.getHeight());
               }

               this.mergeUnknownFields(other.unknownFields);
               this.onChanged();
               return this;
            }
         }

         public final boolean isInitialized() {
            return true;
         }

         public Image.Dimension.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Image.Dimension parsedMessage = null;

            try {
               parsedMessage = (Image.Dimension)Image.Dimension.PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (InvalidProtocolBufferException var8) {
               parsedMessage = (Image.Dimension)var8.getUnfinishedMessage();
               throw var8.unwrapIOException();
            } finally {
               if (parsedMessage != null) {
                  this.mergeFrom(parsedMessage);
               }

            }

            return this;
         }

         public boolean hasWidth() {
            return (this.bitField0_ & 1) != 0;
         }

         public int getWidth() {
            return this.width_;
         }

         public Image.Dimension.Builder setWidth(int value) {
            this.bitField0_ |= 1;
            this.width_ = value;
            this.onChanged();
            return this;
         }

         public Image.Dimension.Builder clearWidth() {
            this.bitField0_ &= -2;
            this.width_ = 0;
            this.onChanged();
            return this;
         }

         public boolean hasHeight() {
            return (this.bitField0_ & 2) != 0;
         }

         public int getHeight() {
            return this.height_;
         }

         public Image.Dimension.Builder setHeight(int value) {
            this.bitField0_ |= 2;
            this.height_ = value;
            this.onChanged();
            return this;
         }

         public Image.Dimension.Builder clearHeight() {
            this.bitField0_ &= -3;
            this.height_ = 0;
            this.onChanged();
            return this;
         }

         public final Image.Dimension.Builder setUnknownFields(UnknownFieldSet unknownFields) {
            return (Image.Dimension.Builder)super.setUnknownFields(unknownFields);
         }

         public final Image.Dimension.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            return (Image.Dimension.Builder)super.mergeUnknownFields(unknownFields);
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

   public interface DimensionOrBuilder extends MessageOrBuilder {
      boolean hasWidth();

      int getWidth();

      boolean hasHeight();

      int getHeight();
   }
}
