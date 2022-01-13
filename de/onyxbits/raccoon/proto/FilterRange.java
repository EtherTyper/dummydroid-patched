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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FilterRange extends GeneratedMessageV3 implements FilterRangeOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DOCUMENTTYPE_FIELD_NUMBER = 1;
   private int documentType_;
   public static final int AUTHORITYID_FIELD_NUMBER = 2;
   private int authorityId_;
   public static final int FILTERCHOICE_FIELD_NUMBER = 3;
   private List filterChoice_;
   public static final int LABEL_FIELD_NUMBER = 4;
   private volatile Object label_;
   public static final int ICONFIFE_FIELD_NUMBER = 5;
   private Image iconFife_;
   public static final int SELECTIONDIALOGLABEL_FIELD_NUMBER = 6;
   private volatile Object selectionDialogLabel_;
   public static final int CONFIRMATIONDIALOGTITLE_FIELD_NUMBER = 7;
   private volatile Object confirmationDialogTitle_;
   public static final int CONFIRMATIONDIALOGCONTENT_FIELD_NUMBER = 8;
   private volatile Object confirmationDialogContent_;
   public static final int REPRESENTCHOICEASTOGGLE_FIELD_NUMBER = 9;
   private boolean representChoiceAsToggle_;
   public static final int APPPACKAGENAME_FIELD_NUMBER = 10;
   private volatile Object appPackageName_;
   public static final int MINVERSIONCODE_FIELD_NUMBER = 11;
   private int minVersionCode_;
   private byte memoizedIsInitialized;
   private static final FilterRange DEFAULT_INSTANCE = new FilterRange();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public FilterRange parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new FilterRange(input, extensionRegistry);
      }
   };

   private FilterRange(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private FilterRange() {
      this.memoizedIsInitialized = -1;
      this.filterChoice_ = Collections.emptyList();
      this.label_ = "";
      this.selectionDialogLabel_ = "";
      this.confirmationDialogTitle_ = "";
      this.confirmationDialogContent_ = "";
      this.appPackageName_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new FilterRange();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private FilterRange(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 8:
                  this.bitField0_ |= 1;
                  this.documentType_ = input.readInt32();
                  break;
               case 16:
                  this.bitField0_ |= 2;
                  this.authorityId_ = input.readInt32();
                  break;
               case 26:
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.filterChoice_ = new ArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.filterChoice_.add(input.readMessage(FilterChoice.PARSER, extensionRegistry));
                  break;
               case 34:
                  bs = input.readBytes();
                  this.bitField0_ |= 4;
                  this.label_ = bs;
                  break;
               case 42:
                  Image.Builder subBuilder = null;
                  if ((this.bitField0_ & 8) != 0) {
                     subBuilder = this.iconFife_.toBuilder();
                  }

                  this.iconFife_ = (Image)input.readMessage(Image.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.iconFife_);
                     this.iconFife_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 8;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.selectionDialogLabel_ = bs;
                  break;
               case 58:
                  bs = input.readBytes();
                  this.bitField0_ |= 32;
                  this.confirmationDialogTitle_ = bs;
                  break;
               case 66:
                  bs = input.readBytes();
                  this.bitField0_ |= 64;
                  this.confirmationDialogContent_ = bs;
                  break;
               case 72:
                  this.bitField0_ |= 128;
                  this.representChoiceAsToggle_ = input.readBool();
                  break;
               case 82:
                  bs = input.readBytes();
                  this.bitField0_ |= 256;
                  this.appPackageName_ = bs;
                  break;
               case 88:
                  this.bitField0_ |= 512;
                  this.minVersionCode_ = input.readInt32();
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
               this.filterChoice_ = Collections.unmodifiableList(this.filterChoice_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_FilterRange_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_FilterRange_fieldAccessorTable.ensureFieldAccessorsInitialized(FilterRange.class, FilterRange.Builder.class);
   }

   public boolean hasDocumentType() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getDocumentType() {
      return this.documentType_;
   }

   public boolean hasAuthorityId() {
      return (this.bitField0_ & 2) != 0;
   }

   public int getAuthorityId() {
      return this.authorityId_;
   }

   public List getFilterChoiceList() {
      return this.filterChoice_;
   }

   public List getFilterChoiceOrBuilderList() {
      return this.filterChoice_;
   }

   public int getFilterChoiceCount() {
      return this.filterChoice_.size();
   }

   public FilterChoice getFilterChoice(int index) {
      return (FilterChoice)this.filterChoice_.get(index);
   }

   public FilterChoiceOrBuilder getFilterChoiceOrBuilder(int index) {
      return (FilterChoiceOrBuilder)this.filterChoice_.get(index);
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

   public boolean hasIconFife() {
      return (this.bitField0_ & 8) != 0;
   }

   public Image getIconFife() {
      return this.iconFife_ == null ? Image.getDefaultInstance() : this.iconFife_;
   }

   public ImageOrBuilder getIconFifeOrBuilder() {
      return this.iconFife_ == null ? Image.getDefaultInstance() : this.iconFife_;
   }

   public boolean hasSelectionDialogLabel() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getSelectionDialogLabel() {
      Object ref = this.selectionDialogLabel_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.selectionDialogLabel_ = s;
         }

         return s;
      }
   }

   public ByteString getSelectionDialogLabelBytes() {
      Object ref = this.selectionDialogLabel_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.selectionDialogLabel_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasConfirmationDialogTitle() {
      return (this.bitField0_ & 32) != 0;
   }

   public String getConfirmationDialogTitle() {
      Object ref = this.confirmationDialogTitle_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.confirmationDialogTitle_ = s;
         }

         return s;
      }
   }

   public ByteString getConfirmationDialogTitleBytes() {
      Object ref = this.confirmationDialogTitle_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.confirmationDialogTitle_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasConfirmationDialogContent() {
      return (this.bitField0_ & 64) != 0;
   }

   public String getConfirmationDialogContent() {
      Object ref = this.confirmationDialogContent_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.confirmationDialogContent_ = s;
         }

         return s;
      }
   }

   public ByteString getConfirmationDialogContentBytes() {
      Object ref = this.confirmationDialogContent_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.confirmationDialogContent_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasRepresentChoiceAsToggle() {
      return (this.bitField0_ & 128) != 0;
   }

   public boolean getRepresentChoiceAsToggle() {
      return this.representChoiceAsToggle_;
   }

   public boolean hasAppPackageName() {
      return (this.bitField0_ & 256) != 0;
   }

   public String getAppPackageName() {
      Object ref = this.appPackageName_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.appPackageName_ = s;
         }

         return s;
      }
   }

   public ByteString getAppPackageNameBytes() {
      Object ref = this.appPackageName_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.appPackageName_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasMinVersionCode() {
      return (this.bitField0_ & 512) != 0;
   }

   public int getMinVersionCode() {
      return this.minVersionCode_;
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
         output.writeInt32(1, this.documentType_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt32(2, this.authorityId_);
      }

      for(int i = 0; i < this.filterChoice_.size(); ++i) {
         output.writeMessage(3, (MessageLite)this.filterChoice_.get(i));
      }

      if ((this.bitField0_ & 4) != 0) {
         GeneratedMessageV3.writeString(output, 4, this.label_);
      }

      if ((this.bitField0_ & 8) != 0) {
         output.writeMessage(5, this.getIconFife());
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.selectionDialogLabel_);
      }

      if ((this.bitField0_ & 32) != 0) {
         GeneratedMessageV3.writeString(output, 7, this.confirmationDialogTitle_);
      }

      if ((this.bitField0_ & 64) != 0) {
         GeneratedMessageV3.writeString(output, 8, this.confirmationDialogContent_);
      }

      if ((this.bitField0_ & 128) != 0) {
         output.writeBool(9, this.representChoiceAsToggle_);
      }

      if ((this.bitField0_ & 256) != 0) {
         GeneratedMessageV3.writeString(output, 10, this.appPackageName_);
      }

      if ((this.bitField0_ & 512) != 0) {
         output.writeInt32(11, this.minVersionCode_);
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
            size += CodedOutputStream.computeInt32Size(1, this.documentType_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.authorityId_);
         }

         for(int i = 0; i < this.filterChoice_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.filterChoice_.get(i));
         }

         if ((this.bitField0_ & 4) != 0) {
            size += GeneratedMessageV3.computeStringSize(4, this.label_);
         }

         if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(5, this.getIconFife());
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.selectionDialogLabel_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += GeneratedMessageV3.computeStringSize(7, this.confirmationDialogTitle_);
         }

         if ((this.bitField0_ & 64) != 0) {
            size += GeneratedMessageV3.computeStringSize(8, this.confirmationDialogContent_);
         }

         if ((this.bitField0_ & 128) != 0) {
            size += CodedOutputStream.computeBoolSize(9, this.representChoiceAsToggle_);
         }

         if ((this.bitField0_ & 256) != 0) {
            size += GeneratedMessageV3.computeStringSize(10, this.appPackageName_);
         }

         if ((this.bitField0_ & 512) != 0) {
            size += CodedOutputStream.computeInt32Size(11, this.minVersionCode_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof FilterRange)) {
         return super.equals(obj);
      } else {
         FilterRange other = (FilterRange)obj;
         if (this.hasDocumentType() != other.hasDocumentType()) {
            return false;
         } else if (this.hasDocumentType() && this.getDocumentType() != other.getDocumentType()) {
            return false;
         } else if (this.hasAuthorityId() != other.hasAuthorityId()) {
            return false;
         } else if (this.hasAuthorityId() && this.getAuthorityId() != other.getAuthorityId()) {
            return false;
         } else if (!this.getFilterChoiceList().equals(other.getFilterChoiceList())) {
            return false;
         } else if (this.hasLabel() != other.hasLabel()) {
            return false;
         } else if (this.hasLabel() && !this.getLabel().equals(other.getLabel())) {
            return false;
         } else if (this.hasIconFife() != other.hasIconFife()) {
            return false;
         } else if (this.hasIconFife() && !this.getIconFife().equals(other.getIconFife())) {
            return false;
         } else if (this.hasSelectionDialogLabel() != other.hasSelectionDialogLabel()) {
            return false;
         } else if (this.hasSelectionDialogLabel() && !this.getSelectionDialogLabel().equals(other.getSelectionDialogLabel())) {
            return false;
         } else if (this.hasConfirmationDialogTitle() != other.hasConfirmationDialogTitle()) {
            return false;
         } else if (this.hasConfirmationDialogTitle() && !this.getConfirmationDialogTitle().equals(other.getConfirmationDialogTitle())) {
            return false;
         } else if (this.hasConfirmationDialogContent() != other.hasConfirmationDialogContent()) {
            return false;
         } else if (this.hasConfirmationDialogContent() && !this.getConfirmationDialogContent().equals(other.getConfirmationDialogContent())) {
            return false;
         } else if (this.hasRepresentChoiceAsToggle() != other.hasRepresentChoiceAsToggle()) {
            return false;
         } else if (this.hasRepresentChoiceAsToggle() && this.getRepresentChoiceAsToggle() != other.getRepresentChoiceAsToggle()) {
            return false;
         } else if (this.hasAppPackageName() != other.hasAppPackageName()) {
            return false;
         } else if (this.hasAppPackageName() && !this.getAppPackageName().equals(other.getAppPackageName())) {
            return false;
         } else if (this.hasMinVersionCode() != other.hasMinVersionCode()) {
            return false;
         } else if (this.hasMinVersionCode() && this.getMinVersionCode() != other.getMinVersionCode()) {
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
         if (this.hasDocumentType()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getDocumentType();
         }

         if (this.hasAuthorityId()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getAuthorityId();
         }

         if (this.getFilterChoiceCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getFilterChoiceList().hashCode();
         }

         if (this.hasLabel()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getLabel().hashCode();
         }

         if (this.hasIconFife()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getIconFife().hashCode();
         }

         if (this.hasSelectionDialogLabel()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getSelectionDialogLabel().hashCode();
         }

         if (this.hasConfirmationDialogTitle()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getConfirmationDialogTitle().hashCode();
         }

         if (this.hasConfirmationDialogContent()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getConfirmationDialogContent().hashCode();
         }

         if (this.hasRepresentChoiceAsToggle()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + Internal.hashBoolean(this.getRepresentChoiceAsToggle());
         }

         if (this.hasAppPackageName()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getAppPackageName().hashCode();
         }

         if (this.hasMinVersionCode()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getMinVersionCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static FilterRange parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data);
   }

   public static FilterRange parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data);
   }

   public static FilterRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data);
   }

   public static FilterRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (FilterRange)PARSER.parseFrom(data, extensionRegistry);
   }

   public static FilterRange parseFrom(InputStream input) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static FilterRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static FilterRange parseDelimitedFrom(InputStream input) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static FilterRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static FilterRange parseFrom(CodedInputStream input) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static FilterRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (FilterRange)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public FilterRange.Builder newBuilderForType() {
      return newBuilder();
   }

   public static FilterRange.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static FilterRange.Builder newBuilder(FilterRange prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public FilterRange.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new FilterRange.Builder() : (new FilterRange.Builder()).mergeFrom(this);
   }

   protected FilterRange.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      FilterRange.Builder builder = new FilterRange.Builder(parent);
      return builder;
   }

   public static FilterRange getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public FilterRange getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   FilterRange(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   FilterRange(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements FilterRangeOrBuilder {
      private int bitField0_;
      private int documentType_;
      private int authorityId_;
      private List filterChoice_;
      private RepeatedFieldBuilderV3 filterChoiceBuilder_;
      private Object label_;
      private Image iconFife_;
      private SingleFieldBuilderV3 iconFifeBuilder_;
      private Object selectionDialogLabel_;
      private Object confirmationDialogTitle_;
      private Object confirmationDialogContent_;
      private boolean representChoiceAsToggle_;
      private Object appPackageName_;
      private int minVersionCode_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_FilterRange_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_FilterRange_fieldAccessorTable.ensureFieldAccessorsInitialized(FilterRange.class, FilterRange.Builder.class);
      }

      private Builder() {
         this.filterChoice_ = Collections.emptyList();
         this.label_ = "";
         this.selectionDialogLabel_ = "";
         this.confirmationDialogTitle_ = "";
         this.confirmationDialogContent_ = "";
         this.appPackageName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.filterChoice_ = Collections.emptyList();
         this.label_ = "";
         this.selectionDialogLabel_ = "";
         this.confirmationDialogTitle_ = "";
         this.confirmationDialogContent_ = "";
         this.appPackageName_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (FilterRange.alwaysUseFieldBuilders) {
            this.getFilterChoiceFieldBuilder();
            this.getIconFifeFieldBuilder();
         }

      }

      public FilterRange.Builder clear() {
         super.clear();
         this.documentType_ = 0;
         this.bitField0_ &= -2;
         this.authorityId_ = 0;
         this.bitField0_ &= -3;
         if (this.filterChoiceBuilder_ == null) {
            this.filterChoice_ = Collections.emptyList();
            this.bitField0_ &= -5;
         } else {
            this.filterChoiceBuilder_.clear();
         }

         this.label_ = "";
         this.bitField0_ &= -9;
         if (this.iconFifeBuilder_ == null) {
            this.iconFife_ = null;
         } else {
            this.iconFifeBuilder_.clear();
         }

         this.bitField0_ &= -17;
         this.selectionDialogLabel_ = "";
         this.bitField0_ &= -33;
         this.confirmationDialogTitle_ = "";
         this.bitField0_ &= -65;
         this.confirmationDialogContent_ = "";
         this.bitField0_ &= -129;
         this.representChoiceAsToggle_ = false;
         this.bitField0_ &= -257;
         this.appPackageName_ = "";
         this.bitField0_ &= -513;
         this.minVersionCode_ = 0;
         this.bitField0_ &= -1025;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_FilterRange_descriptor;
      }

      public FilterRange getDefaultInstanceForType() {
         return FilterRange.getDefaultInstance();
      }

      public FilterRange build() {
         FilterRange result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public FilterRange buildPartial() {
         FilterRange result = new FilterRange(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.documentType_ = this.documentType_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.authorityId_ = this.authorityId_;
            to_bitField0_ |= 2;
         }

         if (this.filterChoiceBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0) {
               this.filterChoice_ = Collections.unmodifiableList(this.filterChoice_);
               this.bitField0_ &= -5;
            }

            result.filterChoice_ = this.filterChoice_;
         } else {
            result.filterChoice_ = this.filterChoiceBuilder_.build();
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 4;
         }

         result.label_ = this.label_;
         if ((from_bitField0_ & 16) != 0) {
            if (this.iconFifeBuilder_ == null) {
               result.iconFife_ = this.iconFife_;
            } else {
               result.iconFife_ = (Image)this.iconFifeBuilder_.build();
            }

            to_bitField0_ |= 8;
         }

         if ((from_bitField0_ & 32) != 0) {
            to_bitField0_ |= 16;
         }

         result.selectionDialogLabel_ = this.selectionDialogLabel_;
         if ((from_bitField0_ & 64) != 0) {
            to_bitField0_ |= 32;
         }

         result.confirmationDialogTitle_ = this.confirmationDialogTitle_;
         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 64;
         }

         result.confirmationDialogContent_ = this.confirmationDialogContent_;
         if ((from_bitField0_ & 256) != 0) {
            result.representChoiceAsToggle_ = this.representChoiceAsToggle_;
            to_bitField0_ |= 128;
         }

         if ((from_bitField0_ & 512) != 0) {
            to_bitField0_ |= 256;
         }

         result.appPackageName_ = this.appPackageName_;
         if ((from_bitField0_ & 1024) != 0) {
            result.minVersionCode_ = this.minVersionCode_;
            to_bitField0_ |= 512;
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public FilterRange.Builder clone() {
         return (FilterRange.Builder)super.clone();
      }

      public FilterRange.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (FilterRange.Builder)super.setField(field, value);
      }

      public FilterRange.Builder clearField(Descriptors.FieldDescriptor field) {
         return (FilterRange.Builder)super.clearField(field);
      }

      public FilterRange.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (FilterRange.Builder)super.clearOneof(oneof);
      }

      public FilterRange.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (FilterRange.Builder)super.setRepeatedField(field, index, value);
      }

      public FilterRange.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (FilterRange.Builder)super.addRepeatedField(field, value);
      }

      public FilterRange.Builder mergeFrom(Message other) {
         if (other instanceof FilterRange) {
            return this.mergeFrom((FilterRange)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public FilterRange.Builder mergeFrom(FilterRange other) {
         if (other == FilterRange.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDocumentType()) {
               this.setDocumentType(other.getDocumentType());
            }

            if (other.hasAuthorityId()) {
               this.setAuthorityId(other.getAuthorityId());
            }

            if (this.filterChoiceBuilder_ == null) {
               if (!other.filterChoice_.isEmpty()) {
                  if (this.filterChoice_.isEmpty()) {
                     this.filterChoice_ = other.filterChoice_;
                     this.bitField0_ &= -5;
                  } else {
                     this.ensureFilterChoiceIsMutable();
                     this.filterChoice_.addAll(other.filterChoice_);
                  }

                  this.onChanged();
               }
            } else if (!other.filterChoice_.isEmpty()) {
               if (this.filterChoiceBuilder_.isEmpty()) {
                  this.filterChoiceBuilder_.dispose();
                  this.filterChoiceBuilder_ = null;
                  this.filterChoice_ = other.filterChoice_;
                  this.bitField0_ &= -5;
                  this.filterChoiceBuilder_ = FilterRange.alwaysUseFieldBuilders ? this.getFilterChoiceFieldBuilder() : null;
               } else {
                  this.filterChoiceBuilder_.addAllMessages(other.filterChoice_);
               }
            }

            if (other.hasLabel()) {
               this.bitField0_ |= 8;
               this.label_ = other.label_;
               this.onChanged();
            }

            if (other.hasIconFife()) {
               this.mergeIconFife(other.getIconFife());
            }

            if (other.hasSelectionDialogLabel()) {
               this.bitField0_ |= 32;
               this.selectionDialogLabel_ = other.selectionDialogLabel_;
               this.onChanged();
            }

            if (other.hasConfirmationDialogTitle()) {
               this.bitField0_ |= 64;
               this.confirmationDialogTitle_ = other.confirmationDialogTitle_;
               this.onChanged();
            }

            if (other.hasConfirmationDialogContent()) {
               this.bitField0_ |= 128;
               this.confirmationDialogContent_ = other.confirmationDialogContent_;
               this.onChanged();
            }

            if (other.hasRepresentChoiceAsToggle()) {
               this.setRepresentChoiceAsToggle(other.getRepresentChoiceAsToggle());
            }

            if (other.hasAppPackageName()) {
               this.bitField0_ |= 512;
               this.appPackageName_ = other.appPackageName_;
               this.onChanged();
            }

            if (other.hasMinVersionCode()) {
               this.setMinVersionCode(other.getMinVersionCode());
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public FilterRange.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         FilterRange parsedMessage = null;

         try {
            parsedMessage = (FilterRange)FilterRange.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (FilterRange)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDocumentType() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getDocumentType() {
         return this.documentType_;
      }

      public FilterRange.Builder setDocumentType(int value) {
         this.bitField0_ |= 1;
         this.documentType_ = value;
         this.onChanged();
         return this;
      }

      public FilterRange.Builder clearDocumentType() {
         this.bitField0_ &= -2;
         this.documentType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasAuthorityId() {
         return (this.bitField0_ & 2) != 0;
      }

      public int getAuthorityId() {
         return this.authorityId_;
      }

      public FilterRange.Builder setAuthorityId(int value) {
         this.bitField0_ |= 2;
         this.authorityId_ = value;
         this.onChanged();
         return this;
      }

      public FilterRange.Builder clearAuthorityId() {
         this.bitField0_ &= -3;
         this.authorityId_ = 0;
         this.onChanged();
         return this;
      }

      private void ensureFilterChoiceIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.filterChoice_ = new ArrayList(this.filterChoice_);
            this.bitField0_ |= 4;
         }

      }

      public List getFilterChoiceList() {
         return this.filterChoiceBuilder_ == null ? Collections.unmodifiableList(this.filterChoice_) : this.filterChoiceBuilder_.getMessageList();
      }

      public int getFilterChoiceCount() {
         return this.filterChoiceBuilder_ == null ? this.filterChoice_.size() : this.filterChoiceBuilder_.getCount();
      }

      public FilterChoice getFilterChoice(int index) {
         return this.filterChoiceBuilder_ == null ? (FilterChoice)this.filterChoice_.get(index) : (FilterChoice)this.filterChoiceBuilder_.getMessage(index);
      }

      public FilterRange.Builder setFilterChoice(int index, FilterChoice value) {
         if (this.filterChoiceBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.set(index, value);
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.setMessage(index, value);
         }

         return this;
      }

      public FilterRange.Builder setFilterChoice(int index, FilterChoice.Builder builderForValue) {
         if (this.filterChoiceBuilder_ == null) {
            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public FilterRange.Builder addFilterChoice(FilterChoice value) {
         if (this.filterChoiceBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.add(value);
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.addMessage(value);
         }

         return this;
      }

      public FilterRange.Builder addFilterChoice(int index, FilterChoice value) {
         if (this.filterChoiceBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.add(index, value);
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.addMessage(index, value);
         }

         return this;
      }

      public FilterRange.Builder addFilterChoice(FilterChoice.Builder builderForValue) {
         if (this.filterChoiceBuilder_ == null) {
            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public FilterRange.Builder addFilterChoice(int index, FilterChoice.Builder builderForValue) {
         if (this.filterChoiceBuilder_ == null) {
            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public FilterRange.Builder addAllFilterChoice(Iterable values) {
         if (this.filterChoiceBuilder_ == null) {
            this.ensureFilterChoiceIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.filterChoice_);
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.addAllMessages(values);
         }

         return this;
      }

      public FilterRange.Builder clearFilterChoice() {
         if (this.filterChoiceBuilder_ == null) {
            this.filterChoice_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.clear();
         }

         return this;
      }

      public FilterRange.Builder removeFilterChoice(int index) {
         if (this.filterChoiceBuilder_ == null) {
            this.ensureFilterChoiceIsMutable();
            this.filterChoice_.remove(index);
            this.onChanged();
         } else {
            this.filterChoiceBuilder_.remove(index);
         }

         return this;
      }

      public FilterChoice.Builder getFilterChoiceBuilder(int index) {
         return (FilterChoice.Builder)this.getFilterChoiceFieldBuilder().getBuilder(index);
      }

      public FilterChoiceOrBuilder getFilterChoiceOrBuilder(int index) {
         return this.filterChoiceBuilder_ == null ? (FilterChoiceOrBuilder)this.filterChoice_.get(index) : (FilterChoiceOrBuilder)this.filterChoiceBuilder_.getMessageOrBuilder(index);
      }

      public List getFilterChoiceOrBuilderList() {
         return this.filterChoiceBuilder_ != null ? this.filterChoiceBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.filterChoice_);
      }

      public FilterChoice.Builder addFilterChoiceBuilder() {
         return (FilterChoice.Builder)this.getFilterChoiceFieldBuilder().addBuilder(FilterChoice.getDefaultInstance());
      }

      public FilterChoice.Builder addFilterChoiceBuilder(int index) {
         return (FilterChoice.Builder)this.getFilterChoiceFieldBuilder().addBuilder(index, FilterChoice.getDefaultInstance());
      }

      public List getFilterChoiceBuilderList() {
         return this.getFilterChoiceFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getFilterChoiceFieldBuilder() {
         if (this.filterChoiceBuilder_ == null) {
            this.filterChoiceBuilder_ = new RepeatedFieldBuilderV3(this.filterChoice_, (this.bitField0_ & 4) != 0, this.getParentForChildren(), this.isClean());
            this.filterChoice_ = null;
         }

         return this.filterChoiceBuilder_;
      }

      public boolean hasLabel() {
         return (this.bitField0_ & 8) != 0;
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

      public FilterRange.Builder setLabel(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.label_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterRange.Builder clearLabel() {
         this.bitField0_ &= -9;
         this.label_ = FilterRange.getDefaultInstance().getLabel();
         this.onChanged();
         return this;
      }

      public FilterRange.Builder setLabelBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.label_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasIconFife() {
         return (this.bitField0_ & 16) != 0;
      }

      public Image getIconFife() {
         if (this.iconFifeBuilder_ == null) {
            return this.iconFife_ == null ? Image.getDefaultInstance() : this.iconFife_;
         } else {
            return (Image)this.iconFifeBuilder_.getMessage();
         }
      }

      public FilterRange.Builder setIconFife(Image value) {
         if (this.iconFifeBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.iconFife_ = value;
            this.onChanged();
         } else {
            this.iconFifeBuilder_.setMessage(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public FilterRange.Builder setIconFife(Image.Builder builderForValue) {
         if (this.iconFifeBuilder_ == null) {
            this.iconFife_ = builderForValue.build();
            this.onChanged();
         } else {
            this.iconFifeBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 16;
         return this;
      }

      public FilterRange.Builder mergeIconFife(Image value) {
         if (this.iconFifeBuilder_ == null) {
            if ((this.bitField0_ & 16) != 0 && this.iconFife_ != null && this.iconFife_ != Image.getDefaultInstance()) {
               this.iconFife_ = Image.newBuilder(this.iconFife_).mergeFrom(value).buildPartial();
            } else {
               this.iconFife_ = value;
            }

            this.onChanged();
         } else {
            this.iconFifeBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 16;
         return this;
      }

      public FilterRange.Builder clearIconFife() {
         if (this.iconFifeBuilder_ == null) {
            this.iconFife_ = null;
            this.onChanged();
         } else {
            this.iconFifeBuilder_.clear();
         }

         this.bitField0_ &= -17;
         return this;
      }

      public Image.Builder getIconFifeBuilder() {
         this.bitField0_ |= 16;
         this.onChanged();
         return (Image.Builder)this.getIconFifeFieldBuilder().getBuilder();
      }

      public ImageOrBuilder getIconFifeOrBuilder() {
         if (this.iconFifeBuilder_ != null) {
            return (ImageOrBuilder)this.iconFifeBuilder_.getMessageOrBuilder();
         } else {
            return this.iconFife_ == null ? Image.getDefaultInstance() : this.iconFife_;
         }
      }

      private SingleFieldBuilderV3 getIconFifeFieldBuilder() {
         if (this.iconFifeBuilder_ == null) {
            this.iconFifeBuilder_ = new SingleFieldBuilderV3(this.getIconFife(), this.getParentForChildren(), this.isClean());
            this.iconFife_ = null;
         }

         return this.iconFifeBuilder_;
      }

      public boolean hasSelectionDialogLabel() {
         return (this.bitField0_ & 32) != 0;
      }

      public String getSelectionDialogLabel() {
         Object ref = this.selectionDialogLabel_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.selectionDialogLabel_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getSelectionDialogLabelBytes() {
         Object ref = this.selectionDialogLabel_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.selectionDialogLabel_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterRange.Builder setSelectionDialogLabel(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.selectionDialogLabel_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterRange.Builder clearSelectionDialogLabel() {
         this.bitField0_ &= -33;
         this.selectionDialogLabel_ = FilterRange.getDefaultInstance().getSelectionDialogLabel();
         this.onChanged();
         return this;
      }

      public FilterRange.Builder setSelectionDialogLabelBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 32;
            this.selectionDialogLabel_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasConfirmationDialogTitle() {
         return (this.bitField0_ & 64) != 0;
      }

      public String getConfirmationDialogTitle() {
         Object ref = this.confirmationDialogTitle_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.confirmationDialogTitle_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getConfirmationDialogTitleBytes() {
         Object ref = this.confirmationDialogTitle_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.confirmationDialogTitle_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterRange.Builder setConfirmationDialogTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.confirmationDialogTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterRange.Builder clearConfirmationDialogTitle() {
         this.bitField0_ &= -65;
         this.confirmationDialogTitle_ = FilterRange.getDefaultInstance().getConfirmationDialogTitle();
         this.onChanged();
         return this;
      }

      public FilterRange.Builder setConfirmationDialogTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 64;
            this.confirmationDialogTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasConfirmationDialogContent() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getConfirmationDialogContent() {
         Object ref = this.confirmationDialogContent_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.confirmationDialogContent_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getConfirmationDialogContentBytes() {
         Object ref = this.confirmationDialogContent_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.confirmationDialogContent_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterRange.Builder setConfirmationDialogContent(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.confirmationDialogContent_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterRange.Builder clearConfirmationDialogContent() {
         this.bitField0_ &= -129;
         this.confirmationDialogContent_ = FilterRange.getDefaultInstance().getConfirmationDialogContent();
         this.onChanged();
         return this;
      }

      public FilterRange.Builder setConfirmationDialogContentBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.confirmationDialogContent_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasRepresentChoiceAsToggle() {
         return (this.bitField0_ & 256) != 0;
      }

      public boolean getRepresentChoiceAsToggle() {
         return this.representChoiceAsToggle_;
      }

      public FilterRange.Builder setRepresentChoiceAsToggle(boolean value) {
         this.bitField0_ |= 256;
         this.representChoiceAsToggle_ = value;
         this.onChanged();
         return this;
      }

      public FilterRange.Builder clearRepresentChoiceAsToggle() {
         this.bitField0_ &= -257;
         this.representChoiceAsToggle_ = false;
         this.onChanged();
         return this;
      }

      public boolean hasAppPackageName() {
         return (this.bitField0_ & 512) != 0;
      }

      public String getAppPackageName() {
         Object ref = this.appPackageName_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.appPackageName_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getAppPackageNameBytes() {
         Object ref = this.appPackageName_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.appPackageName_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public FilterRange.Builder setAppPackageName(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.appPackageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public FilterRange.Builder clearAppPackageName() {
         this.bitField0_ &= -513;
         this.appPackageName_ = FilterRange.getDefaultInstance().getAppPackageName();
         this.onChanged();
         return this;
      }

      public FilterRange.Builder setAppPackageNameBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 512;
            this.appPackageName_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasMinVersionCode() {
         return (this.bitField0_ & 1024) != 0;
      }

      public int getMinVersionCode() {
         return this.minVersionCode_;
      }

      public FilterRange.Builder setMinVersionCode(int value) {
         this.bitField0_ |= 1024;
         this.minVersionCode_ = value;
         this.onChanged();
         return this;
      }

      public FilterRange.Builder clearMinVersionCode() {
         this.bitField0_ &= -1025;
         this.minVersionCode_ = 0;
         this.onChanged();
         return this;
      }

      public final FilterRange.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (FilterRange.Builder)super.setUnknownFields(unknownFields);
      }

      public final FilterRange.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (FilterRange.Builder)super.mergeUnknownFields(unknownFields);
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
