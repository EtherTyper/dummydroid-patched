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

public final class FilterChoice extends GeneratedMessageV3 implements FilterChoiceOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int LEVEL_FIELD_NUMBER = 1;
   private int level_;
   public static final int IMAGEFIFE_FIELD_NUMBER = 2;
   private Image imageFife_;
   public static final int LABEL_FIELD_NUMBER = 3;
   private volatile Object label_;
   public static final int DFEHEADERVALUE_FIELD_NUMBER = 4;
   private volatile Object dfeHeaderValue_;
   public static final int SELECTED_FIELD_NUMBER = 5;
   private boolean selected_;
   public static final int LABELSUMMARY_FIELD_NUMBER = 6;
   private volatile Object labelSummary_;
   private byte memoizedIsInitialized;
   private static final FilterChoice DEFAULT_INSTANCE = new FilterChoice();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public FilterChoice parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new FilterChoice(input, extensionRegistry);
      }
   };

   private FilterChoice(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private FilterChoice() {
      this.memoizedIsInitialized = -1;
      this.label_ = "";
      this.dfeHeaderValue_ = "";
      this.labelSummary_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new FilterChoice();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private FilterChoice(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.level_ = input.readInt32();
                  break;
               case 18:
                  Image.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.imageFife_.toBuilder();
                  }

                  this.imageFife_ = (Image)input.readMessage(Image.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.imageFife_);
                     this.imageFife_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
                  break;
               case 26:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.label_ = bs;
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.dfeHeaderValue_ = bs;
                  break;
               case 40:
                  this.bitField0_ |= 16;
                  this.selected_ = input.readBool();
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.labelSummary_ = bs;
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
      return Mothership.internal_static_FilterChoice_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_FilterChoice_fieldAccessorTable.ensureFieldAccessorsInitialized(FilterChoice.class, FilterChoice.Builder.class);
   }

   public boolean hasLevel() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getLevel() {
      return this.level_;
   }

   public boolean hasImageFife() {
      return (this.bitField0_ & 2) != 0;
   }

   public Image getImageFife() {
      return this.imageFife_ == null ? Image.getDefaultInstance() : this.imageFife_;
   }

   public ImageOrBuilder getImageFifeOrBuilder() {
      return this.imageFife_ == null ? Image.getDefaultInstance() : this.imageFife_;
   }

   public boolean hasLabel() {
      return (this.bitField0_ & 4) != 0;
   }

   public String getLabel() {
      Object ref = this.label_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.label_ = s;
         }

         return s;
      }
   }

   public ByteString getLabelBytes() {
      Object ref = this.label_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.label_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasDfeHeaderValue() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDfeHeaderValue() {
      Object ref = this.dfeHeaderValue_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.dfeHeaderValue_ = s;
         }

         return s;
      }
   }

   public ByteString getDfeHeaderValueBytes() {
      Object ref = this.dfeHeaderValue_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.dfeHeaderValue_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasSelected() {
      return (this.bitField0_ & 16) != 0;
   }

   public boolean getSelected() {
      return this.selected_;
   }

   public boolean hasLabelSummary() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getLabelSummary() {
      Object ref = this.labelSummary_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.labelSummary_ = s;
         }

         return s;
      }
   }

   public ByteString getLabelSummaryBytes() {
      Object ref = this.labelSummary_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.labelSummary_ = b;
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
         output.writeInt32(1, this.level_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeMessage(2, this.getImageFife());
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 3, this.label_);
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.dfeHeaderValue_);
      }

      if ((this.bitField0_ & 16) != 0) {
         output.writeBool(5, this.selected_);
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.labelSummary_);
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
            size += CodedOutputStream.computeInt32Size(1, this.level_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getImageFife());
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(3, this.label_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.dfeHeaderValue_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += CodedOutputStream.computeBoolSize(5, this.selected_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.labelSummary_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof FilterChoice)) {
         return super.equals(obj);
      } else {
         FilterChoice other = (FilterChoice)obj;
         if (this.hasLevel() != other.hasLevel()) {
            return false;
         } else if (this.hasLevel() && this.getLevel() != other.getLevel()) {
            return false;
         } else if (this.hasImageFife() != other.hasImageFife()) {
            return false;
         } else if (this.hasImageFife() && !this.getImageFife().equals(other.getImageFife())) {
            return false;
         } else if (this.hasLabel() != other.hasLabel()) {
            return false;
         } else if (this.hasLabel() && !this.getLabel().equals(other.getLabel())) {
            return false;
         } else if (this.hasDfeHeaderValue() != other.hasDfeHeaderValue()) {
            return false;
         } else if (this.hasDfeHeaderValue() && !this.getDfeHeaderValue().equals(other.getDfeHeaderValue())) {
            return false;
         } else if (this.hasSelected() != other.hasSelected()) {
            return false;
         } else if (this.hasSelected() && this.getSelected() != other.getSelected()) {
            return false;
         } else if (this.hasLabelSummary() != other.hasLabelSummary()) {
            return false;
         } else if (this.hasLabelSummary() && !this.getLabelSummary().equals(other.getLabelSummary())) {
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
         if (this.hasLevel()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getLevel();
         }

         if (this.hasImageFife()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getImageFife().hashCode();
         }

         if (this.hasLabel()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getLabel().hashCode();
         }

         if (this.hasDfeHeaderValue()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDfeHeaderValue().hashCode();
         }

         if (this.hasSelected()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashBoolean(this.getSelected());
         }

         if (this.hasLabelSummary()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getLabelSummary().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static FilterChoice parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data);
   }

   public static FilterChoice parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterChoice parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data);
   }

   public static FilterChoice parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterChoice parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data);
   }

   public static FilterChoice parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterChoice)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterChoice parseFrom(InputStream input) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static FilterChoice parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static FilterChoice parseDelimitedFrom(InputStream input) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static FilterChoice parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static FilterChoice parseFrom(CodedInputStream input) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static FilterChoice parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterChoice)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public FilterChoice.Builder newBuilderForType() {
      return newBuilder();
   }

   public static FilterChoice.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static FilterChoice.Builder newBuilder(FilterChoice prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public FilterChoice.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new FilterChoice.Builder() : (new FilterChoice.Builder()).mergeFrom(this);
   }

   protected FilterChoice.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      FilterChoice.Builder builder = new FilterChoice.Builder(parent);
      return builder;
   }

   public static FilterChoice getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public FilterChoice getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   FilterChoice(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   FilterChoice(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements FilterChoiceOrBuilder {
      private int bitField0_;
      private int level_;
      private Image imageFife_;
      private SingleFieldBuilderV3 imageFifeBuilder_;
      private Object label_;
      private Object dfeHeaderValue_;
      private boolean selected_;
      private Object labelSummary_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_FilterChoice_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_FilterChoice_fieldAccessorTable.ensureFieldAccessorsInitialized(FilterChoice.class, FilterChoice.Builder.class);
      }

      private Builder() {
         this.label_ = "";
         this.dfeHeaderValue_ = "";
         this.labelSummary_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.label_ = "";
         this.dfeHeaderValue_ = "";
         this.labelSummary_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (FilterChoice.alwaysUseFieldBuilders) {
            this.getImageFifeFieldBuilder();
         }

      }

      public FilterChoice.Builder clear() {
         super.clear();
         this.level_ = 0;
         this.bitField0_ &= -2;
         if (this.imageFifeBuilder_ == null) {
            this.imageFife_ = null;
         } else {
            this.imageFifeBuilder_.clear();
         }

         this.bitField0_ &= -3;
         this.label_ = "";
         this.bitField0_ &= -5;
         this.dfeHeaderValue_ = "";
         this.bitField0_ &= -9;
         this.selected_ = false;
         this.bitField0_ &= -17;
         this.labelSummary_ = "";
         this.bitField0_ &= -33;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_FilterChoice_descriptor;
      }

      public FilterChoice getDefaultInstanceForType() {
         return FilterChoice.getDefaultInstance();
      }

      public FilterChoice build() {
         FilterChoice result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public FilterChoice buildPartial() {
         FilterChoice result = new FilterChoice(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.level_ = this.level_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.imageFifeBuilder_ == null) {
               result.imageFife_ = this.imageFife_;
            } else {
               result.imageFife_ = (Image)this.imageFifeBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            to_bitField0_ |= 4;
         }

         result.label_ = this.label_;
         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.dfeHeaderValue_ = this.dfeHeaderValue_;
         if ((from_bitField0_ & 16) != 0) {
            result.selected_ = this.selected_;
            to_bitField0_ |= 16;
         }

         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 32;
         }

         result.labelSummary_ = this.labelSummary_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public FilterChoice.Builder clone() {
         return (FilterChoice.Builder)super.clone();
      }

      public FilterChoice.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (FilterChoice.Builder)super.setField(field, value);
      }

      public FilterChoice.Builder clearField(Descriptors.FieldDescriptor field) {
         return (FilterChoice.Builder)super.clearField(field);
      }

      public FilterChoice.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (FilterChoice.Builder)super.clearOneof(oneof);
      }

      public FilterChoice.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (FilterChoice.Builder)super.setRepeatedField(field, index, value);
      }

      public FilterChoice.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (FilterChoice.Builder)super.addRepeatedField(field, value);
      }

      public FilterChoice.Builder mergeFrom(Message other) {
         if (other instanceof FilterChoice) {
            return this.mergeFrom((FilterChoice)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public FilterChoice.Builder mergeFrom(FilterChoice other) {
         if (other == FilterChoice.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasLevel()) {
               this.setLevel(other.getLevel());
            }

            if (other.hasImageFife()) {
               this.mergeImageFife(other.getImageFife());
            }

            if (other.hasLabel()) {
               this.bitField0_ |= 4;
               this.label_ = other.label_;
               this.onChanged();
            }

            if (other.hasDfeHeaderValue()) {
               this.bitField0_ |= 8;
               this.dfeHeaderValue_ = other.dfeHeaderValue_;
               this.onChanged();
            }

            if (other.hasSelected()) {
               this.setSelected(other.getSelected());
            }

            if (other.hasLabelSummary()) {
               this.bitField0_ |= 32;
               this.labelSummary_ = other.labelSummary_;
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

      public FilterChoice.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         FilterChoice parsedMessage = null;

         try {
            parsedMessage = (FilterChoice)FilterChoice.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (FilterChoice)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasLevel() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getLevel() {
         return this.level_;
      }

      public FilterChoice.Builder setLevel(int value) {
         this.bitField0_ |= 1;
         this.level_ = value;
         this.onChanged();
         return this;
      }

      public FilterChoice.Builder clearLevel() {
         this.bitField0_ &= -2;
         this.level_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasImageFife() {
         return (this.bitField0_ & 2) != 0;
      }

      public Image getImageFife() {
         if (this.imageFifeBuilder_ == null) {
            return this.imageFife_ == null ? Image.getDefaultInstance() : this.imageFife_;
         } else {
            return (Image)this.imageFifeBuilder_.getMessage();
         }
      }

      public FilterChoice.Builder setImageFife(Image value) {
         if (this.imageFifeBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.imageFife_ = value;
            this.onChanged();
         } else {
            this.imageFifeBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public FilterChoice.Builder setImageFife(Image.Builder builderForValue) {
         if (this.imageFifeBuilder_ == null) {
            this.imageFife_ = builderForValue.build();
            this.onChanged();
         } else {
            this.imageFifeBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public FilterChoice.Builder mergeImageFife(Image value) {
         if (this.imageFifeBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.imageFife_ != null && this.imageFife_ != Image.getDefaultInstance()) {
               this.imageFife_ = Image.newBuilder(this.imageFife_).mergeFrom(value).buildPartial();
            } else {
               this.imageFife_ = value;
            }

            this.onChanged();
         } else {
            this.imageFifeBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public FilterChoice.Builder clearImageFife() {
         if (this.imageFifeBuilder_ == null) {
            this.imageFife_ = null;
            this.onChanged();
         } else {
            this.imageFifeBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public Image.Builder getImageFifeBuilder() {
         this.bitField0_ |= 2;
         this.onChanged();
         return (Image.Builder)this.getImageFifeFieldBuilder().getBuilder();
      }

      public ImageOrBuilder getImageFifeOrBuilder() {
         if (this.imageFifeBuilder_ != null) {
            return (ImageOrBuilder)this.imageFifeBuilder_.getMessageOrBuilder();
         } else {
            return this.imageFife_ == null ? Image.getDefaultInstance() : this.imageFife_;
         }
      }

      private SingleFieldBuilderV3 getImageFifeFieldBuilder() {
         if (this.imageFifeBuilder_ == null) {
            this.imageFifeBuilder_ = new SingleFieldBuilderV3(this.getImageFife(), this.getParentForChildren(), this.isClean());
            this.imageFife_ = null;
         }

         return this.imageFifeBuilder_;
      }

      public boolean hasLabel() {
         return (this.bitField0_ & 4) != 0;
      }

      public String getLabel() {
         Object ref = this.label_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.label_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLabelBytes() {
         Object ref = this.label_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.label_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterChoice.Builder setLabel(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.label_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterChoice.Builder clearLabel() {
         this.bitField0_ &= -5;
         this.label_ = FilterChoice.getDefaultInstance().getLabel();
         this.onChanged();
         return this;
      }

      public FilterChoice.Builder setLabelBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 4;
            this.label_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasDfeHeaderValue() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDfeHeaderValue() {
         Object ref = this.dfeHeaderValue_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.dfeHeaderValue_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDfeHeaderValueBytes() {
         Object ref = this.dfeHeaderValue_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.dfeHeaderValue_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterChoice.Builder setDfeHeaderValue(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.dfeHeaderValue_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterChoice.Builder clearDfeHeaderValue() {
         this.bitField0_ &= -9;
         this.dfeHeaderValue_ = FilterChoice.getDefaultInstance().getDfeHeaderValue();
         this.onChanged();
         return this;
      }

      public FilterChoice.Builder setDfeHeaderValueBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.dfeHeaderValue_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasSelected() {
         return (this.bitField0_ & 16) != 0;
      }

      public boolean getSelected() {
         return this.selected_;
      }

      public FilterChoice.Builder setSelected(boolean value) {
         this.bitField0_ |= 16;
         this.selected_ = value;
         this.onChanged();
         return this;
      }

      public FilterChoice.Builder clearSelected() {
         this.bitField0_ &= -17;
         this.selected_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasLabelSummary() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getLabelSummary() {
         Object ref = this.labelSummary_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.labelSummary_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getLabelSummaryBytes() {
         Object ref = this.labelSummary_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.labelSummary_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterChoice.Builder setLabelSummary(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.labelSummary_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterChoice.Builder clearLabelSummary() {
         this.bitField0_ &= -33;
         this.labelSummary_ = FilterChoice.getDefaultInstance().getLabelSummary();
         this.onChanged();
         return this;
      }

      public FilterChoice.Builder setLabelSummaryBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.labelSummary_ = value;
            this.onChanged();
            return this;
         }
      }

      public final FilterChoice.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (FilterChoice.Builder)super.setUnknownFields(unknownFields);
      }

      public final FilterChoice.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (FilterChoice.Builder)super.mergeUnknownFields(unknownFields);
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
