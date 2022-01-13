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

public final class Notification extends GeneratedMessageV3 implements NotificationOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int NOTIFICATIONTYPE_FIELD_NUMBER = 1;
   private int notificationType_;
   public static final int TIMESTAMP_FIELD_NUMBER = 3;
   private long timestamp_;
   public static final int DOCID_FIELD_NUMBER = 4;
   private Docid docid_;
   public static final int DOCTITLE_FIELD_NUMBER = 5;
   private volatile Object docTitle_;
   public static final int USEREMAIL_FIELD_NUMBER = 6;
   private volatile Object userEmail_;
   public static final int APPDATA_FIELD_NUMBER = 7;
   private AndroidAppNotificationData appData_;
   public static final int APPDELIVERYDATA_FIELD_NUMBER = 8;
   private AndroidAppDeliveryData appDeliveryData_;
   public static final int NOTIFICATIONID_FIELD_NUMBER = 13;
   private volatile Object notificationId_;
   private byte memoizedIsInitialized;
   private static final Notification DEFAULT_INSTANCE = new Notification();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public Notification parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new Notification(input, extensionRegistry);
      }
   };

   private Notification(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private Notification() {
      this.memoizedIsInitialized = -1;
      this.docTitle_ = "";
      this.userEmail_ = "";
      this.notificationId_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new Notification();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private Notification(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                  this.notificationType_ = input.readInt32();
                  break;
               case 24:
                  this.bitField0_ |= 2;
                  this.timestamp_ = input.readInt64();
                  break;
               case 34:
                  Docid.Builder subBuilder = null;
                  if ((this.bitField0_ & 4) != 0) {
                     subBuilder = this.docid_.toBuilder();
                  }

                  this.docid_ = (Docid)input.readMessage(Docid.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.docid_);
                     this.docid_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 4;
                  break;
               case 42:
                  bs = input.readBytes();
                  this.bitField0_ |= 8;
                  this.docTitle_ = bs;
                  break;
               case 50:
                  bs = input.readBytes();
                  this.bitField0_ |= 16;
                  this.userEmail_ = bs;
                  break;
               case 58:
                  AndroidAppNotificationData.Builder subBuilder = null;
                  if ((this.bitField0_ & 32) != 0) {
                     subBuilder = this.appData_.toBuilder();
                  }

                  this.appData_ = (AndroidAppNotificationData)input.readMessage(AndroidAppNotificationData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.appData_);
                     this.appData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 32;
                  break;
               case 66:
                  AndroidAppDeliveryData.Builder subBuilder = null;
                  if ((this.bitField0_ & 64) != 0) {
                     subBuilder = this.appDeliveryData_.toBuilder();
                  }

                  this.appDeliveryData_ = (AndroidAppDeliveryData)input.readMessage(AndroidAppDeliveryData.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.appDeliveryData_);
                     this.appDeliveryData_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 64;
                  break;
               case 106:
                  bs = input.readBytes();
                  this.bitField0_ |= 128;
                  this.notificationId_ = bs;
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
      return Mothership.internal_static_Notification_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_Notification_fieldAccessorTable.ensureFieldAccessorsInitialized(Notification.class, Notification.Builder.class);
   }

   public boolean hasNotificationType() {
      return (this.bitField0_ & 1) != 0;
   }

   public int getNotificationType() {
      return this.notificationType_;
   }

   public boolean hasTimestamp() {
      return (this.bitField0_ & 2) != 0;
   }

   public long getTimestamp() {
      return this.timestamp_;
   }

   public boolean hasDocid() {
      return (this.bitField0_ & 4) != 0;
   }

   public Docid getDocid() {
      return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
   }

   public DocidOrBuilder getDocidOrBuilder() {
      return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
   }

   public boolean hasDocTitle() {
      return (this.bitField0_ & 8) != 0;
   }

   public String getDocTitle() {
      Object ref = this.docTitle_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.docTitle_ = s;
         }

         return s;
      }
   }

   public ByteString getDocTitleBytes() {
      Object ref = this.docTitle_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.docTitle_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasUserEmail() {
      return (this.bitField0_ & 16) != 0;
   }

   public String getUserEmail() {
      Object ref = this.userEmail_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.userEmail_ = s;
         }

         return s;
      }
   }

   public ByteString getUserEmailBytes() {
      Object ref = this.userEmail_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.userEmail_ = b;
         return b;
      } else {
         return (ByteString)ref;
      }
   }

   public boolean hasAppData() {
      return (this.bitField0_ & 32) != 0;
   }

   public AndroidAppNotificationData getAppData() {
      return this.appData_ == null ? AndroidAppNotificationData.getDefaultInstance() : this.appData_;
   }

   public AndroidAppNotificationDataOrBuilder getAppDataOrBuilder() {
      return this.appData_ == null ? AndroidAppNotificationData.getDefaultInstance() : this.appData_;
   }

   public boolean hasAppDeliveryData() {
      return (this.bitField0_ & 64) != 0;
   }

   public AndroidAppDeliveryData getAppDeliveryData() {
      return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
   }

   public AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder() {
      return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
   }

   public boolean hasNotificationId() {
      return (this.bitField0_ & 128) != 0;
   }

   public String getNotificationId() {
      Object ref = this.notificationId_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.notificationId_ = s;
         }

         return s;
      }
   }

   public ByteString getNotificationIdBytes() {
      Object ref = this.notificationId_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.notificationId_ = b;
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
         output.writeInt32(1, this.notificationType_);
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeInt64(3, this.timestamp_);
      }

      if ((this.bitField0_ & 4) != 0) {
         output.writeMessage(4, this.getDocid());
      }

      if ((this.bitField0_ & 8) != 0) {
         GeneratedMessageV3.writeString(output, 5, this.docTitle_);
      }

      if ((this.bitField0_ & 16) != 0) {
         GeneratedMessageV3.writeString(output, 6, this.userEmail_);
      }

      if ((this.bitField0_ & 32) != 0) {
         output.writeMessage(7, this.getAppData());
      }

      if ((this.bitField0_ & 64) != 0) {
         output.writeMessage(8, this.getAppDeliveryData());
      }

      if ((this.bitField0_ & 128) != 0) {
         GeneratedMessageV3.writeString(output, 13, this.notificationId_);
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
            size += CodedOutputStream.computeInt32Size(1, this.notificationType_);
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeInt64Size(3, this.timestamp_);
         }

         if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(4, this.getDocid());
         }

         if ((this.bitField0_ & 8) != 0) {
            size += GeneratedMessageV3.computeStringSize(5, this.docTitle_);
         }

         if ((this.bitField0_ & 16) != 0) {
            size += GeneratedMessageV3.computeStringSize(6, this.userEmail_);
         }

         if ((this.bitField0_ & 32) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getAppData());
         }

         if ((this.bitField0_ & 64) != 0) {
            size += CodedOutputStream.computeMessageSize(8, this.getAppDeliveryData());
         }

         if ((this.bitField0_ & 128) != 0) {
            size += GeneratedMessageV3.computeStringSize(13, this.notificationId_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Notification)) {
         return super.equals(obj);
      } else {
         Notification other = (Notification)obj;
         if (this.hasNotificationType() != other.hasNotificationType()) {
            return false;
         } else if (this.hasNotificationType() && this.getNotificationType() != other.getNotificationType()) {
            return false;
         } else if (this.hasTimestamp() != other.hasTimestamp()) {
            return false;
         } else if (this.hasTimestamp() && this.getTimestamp() != other.getTimestamp()) {
            return false;
         } else if (this.hasDocid() != other.hasDocid()) {
            return false;
         } else if (this.hasDocid() && !this.getDocid().equals(other.getDocid())) {
            return false;
         } else if (this.hasDocTitle() != other.hasDocTitle()) {
            return false;
         } else if (this.hasDocTitle() && !this.getDocTitle().equals(other.getDocTitle())) {
            return false;
         } else if (this.hasUserEmail() != other.hasUserEmail()) {
            return false;
         } else if (this.hasUserEmail() && !this.getUserEmail().equals(other.getUserEmail())) {
            return false;
         } else if (this.hasAppData() != other.hasAppData()) {
            return false;
         } else if (this.hasAppData() && !this.getAppData().equals(other.getAppData())) {
            return false;
         } else if (this.hasAppDeliveryData() != other.hasAppDeliveryData()) {
            return false;
         } else if (this.hasAppDeliveryData() && !this.getAppDeliveryData().equals(other.getAppDeliveryData())) {
            return false;
         } else if (this.hasNotificationId() != other.hasNotificationId()) {
            return false;
         } else if (this.hasNotificationId() && !this.getNotificationId().equals(other.getNotificationId())) {
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
         if (this.hasNotificationType()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getNotificationType();
         }

         if (this.hasTimestamp()) {
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getTimestamp());
         }

         if (this.hasDocid()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDocid().hashCode();
         }

         if (this.hasDocTitle()) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getDocTitle().hashCode();
         }

         if (this.hasUserEmail()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getUserEmail().hashCode();
         }

         if (this.hasAppData()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getAppData().hashCode();
         }

         if (this.hasAppDeliveryData()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getAppDeliveryData().hashCode();
         }

         if (this.hasNotificationId()) {
            hash = 37 * hash + 13;
            hash = 53 * hash + this.getNotificationId().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static Notification parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data);
   }

   public static Notification parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Notification parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data);
   }

   public static Notification parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Notification parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data);
   }

   public static Notification parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (Notification)PARSER.parseFrom(data, extensionRegistry);
   }

   public static Notification parseFrom(InputStream input) throws IOException {
      return (Notification)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Notification parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Notification)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static Notification parseDelimitedFrom(InputStream input) throws IOException {
      return (Notification)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static Notification parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Notification)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static Notification parseFrom(CodedInputStream input) throws IOException {
      return (Notification)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static Notification parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (Notification)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public Notification.Builder newBuilderForType() {
      return newBuilder();
   }

   public static Notification.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static Notification.Builder newBuilder(Notification prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public Notification.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new Notification.Builder() : (new Notification.Builder()).mergeFrom(this);
   }

   protected Notification.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      Notification.Builder builder = new Notification.Builder(parent);
      return builder;
   }

   public static Notification getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public Notification getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   Notification(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   Notification(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements NotificationOrBuilder {
      private int bitField0_;
      private int notificationType_;
      private long timestamp_;
      private Docid docid_;
      private SingleFieldBuilderV3 docidBuilder_;
      private Object docTitle_;
      private Object userEmail_;
      private AndroidAppNotificationData appData_;
      private SingleFieldBuilderV3 appDataBuilder_;
      private AndroidAppDeliveryData appDeliveryData_;
      private SingleFieldBuilderV3 appDeliveryDataBuilder_;
      private Object notificationId_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_Notification_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_Notification_fieldAccessorTable.ensureFieldAccessorsInitialized(Notification.class, Notification.Builder.class);
      }

      private Builder() {
         this.docTitle_ = "";
         this.userEmail_ = "";
         this.notificationId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.docTitle_ = "";
         this.userEmail_ = "";
         this.notificationId_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (Notification.alwaysUseFieldBuilders) {
            this.getDocidFieldBuilder();
            this.getAppDataFieldBuilder();
            this.getAppDeliveryDataFieldBuilder();
         }

      }

      public Notification.Builder clear() {
         super.clear();
         this.notificationType_ = 0;
         this.bitField0_ &= -2;
         this.timestamp_ = 0L;
         this.bitField0_ &= -3;
         if (this.docidBuilder_ == null) {
            this.docid_ = null;
         } else {
            this.docidBuilder_.clear();
         }

         this.bitField0_ &= -5;
         this.docTitle_ = "";
         this.bitField0_ &= -9;
         this.userEmail_ = "";
         this.bitField0_ &= -17;
         if (this.appDataBuilder_ == null) {
            this.appData_ = null;
         } else {
            this.appDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = null;
         } else {
            this.appDeliveryDataBuilder_.clear();
         }

         this.bitField0_ &= -65;
         this.notificationId_ = "";
         this.bitField0_ &= -129;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_Notification_descriptor;
      }

      public Notification getDefaultInstanceForType() {
         return Notification.getDefaultInstance();
      }

      public Notification build() {
         Notification result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public Notification buildPartial() {
         Notification result = new Notification(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            result.notificationType_ = this.notificationType_;
            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            result.timestamp_ = this.timestamp_;
            to_bitField0_ |= 2;
         }

         if ((from_bitField0_ & 4) != 0) {
            if (this.docidBuilder_ == null) {
               result.docid_ = this.docid_;
            } else {
               result.docid_ = (Docid)this.docidBuilder_.build();
            }

            to_bitField0_ |= 4;
         }

         if ((from_bitField0_ & 8) != 0) {
            to_bitField0_ |= 8;
         }

         result.docTitle_ = this.docTitle_;
         if ((from_bitField0_ & 16) != 0) {
            to_bitField0_ |= 16;
         }

         result.userEmail_ = this.userEmail_;
         if ((from_bitField0_ & 32) != 0) {
            if (this.appDataBuilder_ == null) {
               result.appData_ = this.appData_;
            } else {
               result.appData_ = (AndroidAppNotificationData)this.appDataBuilder_.build();
            }

            to_bitField0_ |= 32;
         }

         if ((from_bitField0_ & 64) != 0) {
            if (this.appDeliveryDataBuilder_ == null) {
               result.appDeliveryData_ = this.appDeliveryData_;
            } else {
               result.appDeliveryData_ = (AndroidAppDeliveryData)this.appDeliveryDataBuilder_.build();
            }

            to_bitField0_ |= 64;
         }

         if ((from_bitField0_ & 128) != 0) {
            to_bitField0_ |= 128;
         }

         result.notificationId_ = this.notificationId_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public Notification.Builder clone() {
         return (Notification.Builder)super.clone();
      }

      public Notification.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (Notification.Builder)super.setField(field, value);
      }

      public Notification.Builder clearField(Descriptors.FieldDescriptor field) {
         return (Notification.Builder)super.clearField(field);
      }

      public Notification.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (Notification.Builder)super.clearOneof(oneof);
      }

      public Notification.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (Notification.Builder)super.setRepeatedField(field, index, value);
      }

      public Notification.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (Notification.Builder)super.addRepeatedField(field, value);
      }

      public Notification.Builder mergeFrom(Message other) {
         if (other instanceof Notification) {
            return this.mergeFrom((Notification)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public Notification.Builder mergeFrom(Notification other) {
         if (other == Notification.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasNotificationType()) {
               this.setNotificationType(other.getNotificationType());
            }

            if (other.hasTimestamp()) {
               this.setTimestamp(other.getTimestamp());
            }

            if (other.hasDocid()) {
               this.mergeDocid(other.getDocid());
            }

            if (other.hasDocTitle()) {
               this.bitField0_ |= 8;
               this.docTitle_ = other.docTitle_;
               this.onChanged();
            }

            if (other.hasUserEmail()) {
               this.bitField0_ |= 16;
               this.userEmail_ = other.userEmail_;
               this.onChanged();
            }

            if (other.hasAppData()) {
               this.mergeAppData(other.getAppData());
            }

            if (other.hasAppDeliveryData()) {
               this.mergeAppDeliveryData(other.getAppDeliveryData());
            }

            if (other.hasNotificationId()) {
               this.bitField0_ |= 128;
               this.notificationId_ = other.notificationId_;
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

      public Notification.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         Notification parsedMessage = null;

         try {
            parsedMessage = (Notification)Notification.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (Notification)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasNotificationType() {
         return (this.bitField0_ & 1) != 0;
      }

      public int getNotificationType() {
         return this.notificationType_;
      }

      public Notification.Builder setNotificationType(int value) {
         this.bitField0_ |= 1;
         this.notificationType_ = value;
         this.onChanged();
         return this;
      }

      public Notification.Builder clearNotificationType() {
         this.bitField0_ &= -2;
         this.notificationType_ = 0;
         this.onChanged();
         return this;
      }

      public boolean hasTimestamp() {
         return (this.bitField0_ & 2) != 0;
      }

      public long getTimestamp() {
         return this.timestamp_;
      }

      public Notification.Builder setTimestamp(long value) {
         this.bitField0_ |= 2;
         this.timestamp_ = value;
         this.onChanged();
         return this;
      }

      public Notification.Builder clearTimestamp() {
         this.bitField0_ &= -3;
         this.timestamp_ = 0L;
         this.onChanged();
         return this;
      }

      public boolean hasDocid() {
         return (this.bitField0_ & 4) != 0;
      }

      public Docid getDocid() {
         if (this.docidBuilder_ == null) {
            return this.docid_ == null ? Docid.getDefaultInstance() : this.docid_;
         } else {
            return (Docid)this.docidBuilder_.getMessage();
         }
      }

      public Notification.Builder setDocid(Docid value) {
         if (this.docidBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.docid_ = value;
            this.onChanged();
         } else {
            this.docidBuilder_.setMessage(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Notification.Builder setDocid(Docid.Builder builderForValue) {
         if (this.docidBuilder_ == null) {
            this.docid_ = builderForValue.build();
            this.onChanged();
         } else {
            this.docidBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Notification.Builder mergeDocid(Docid value) {
         if (this.docidBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0 && this.docid_ != null && this.docid_ != Docid.getDefaultInstance()) {
               this.docid_ = Docid.newBuilder(this.docid_).mergeFrom(value).buildPartial();
            } else {
               this.docid_ = value;
            }

            this.onChanged();
         } else {
            this.docidBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 4;
         return this;
      }

      public Notification.Builder clearDocid() {
         if (this.docidBuilder_ == null) {
            this.docid_ = null;
            this.onChanged();
         } else {
            this.docidBuilder_.clear();
         }

         this.bitField0_ &= -5;
         return this;
      }

      public Docid.Builder getDocidBuilder() {
         this.bitField0_ |= 4;
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

      public boolean hasDocTitle() {
         return (this.bitField0_ & 8) != 0;
      }

      public String getDocTitle() {
         Object ref = this.docTitle_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.docTitle_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDocTitleBytes() {
         Object ref = this.docTitle_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.docTitle_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Notification.Builder setDocTitle(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.docTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public Notification.Builder clearDocTitle() {
         this.bitField0_ &= -9;
         this.docTitle_ = Notification.getDefaultInstance().getDocTitle();
         this.onChanged();
         return this;
      }

      public Notification.Builder setDocTitleBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 8;
            this.docTitle_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasUserEmail() {
         return (this.bitField0_ & 16) != 0;
      }

      public String getUserEmail() {
         Object ref = this.userEmail_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.userEmail_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getUserEmailBytes() {
         Object ref = this.userEmail_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.userEmail_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Notification.Builder setUserEmail(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.userEmail_ = value;
            this.onChanged();
            return this;
         }
      }

      public Notification.Builder clearUserEmail() {
         this.bitField0_ &= -17;
         this.userEmail_ = Notification.getDefaultInstance().getUserEmail();
         this.onChanged();
         return this;
      }

      public Notification.Builder setUserEmailBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 16;
            this.userEmail_ = value;
            this.onChanged();
            return this;
         }
      }

      public boolean hasAppData() {
         return (this.bitField0_ & 32) != 0;
      }

      public AndroidAppNotificationData getAppData() {
         if (this.appDataBuilder_ == null) {
            return this.appData_ == null ? AndroidAppNotificationData.getDefaultInstance() : this.appData_;
         } else {
            return (AndroidAppNotificationData)this.appDataBuilder_.getMessage();
         }
      }

      public Notification.Builder setAppData(AndroidAppNotificationData value) {
         if (this.appDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.appData_ = value;
            this.onChanged();
         } else {
            this.appDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Notification.Builder setAppData(AndroidAppNotificationData.Builder builderForValue) {
         if (this.appDataBuilder_ == null) {
            this.appData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.appDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Notification.Builder mergeAppData(AndroidAppNotificationData value) {
         if (this.appDataBuilder_ == null) {
            if ((this.bitField0_ & 32) != 0 && this.appData_ != null && this.appData_ != AndroidAppNotificationData.getDefaultInstance()) {
               this.appData_ = AndroidAppNotificationData.newBuilder(this.appData_).mergeFrom(value).buildPartial();
            } else {
               this.appData_ = value;
            }

            this.onChanged();
         } else {
            this.appDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 32;
         return this;
      }

      public Notification.Builder clearAppData() {
         if (this.appDataBuilder_ == null) {
            this.appData_ = null;
            this.onChanged();
         } else {
            this.appDataBuilder_.clear();
         }

         this.bitField0_ &= -33;
         return this;
      }

      public AndroidAppNotificationData.Builder getAppDataBuilder() {
         this.bitField0_ |= 32;
         this.onChanged();
         return (AndroidAppNotificationData.Builder)this.getAppDataFieldBuilder().getBuilder();
      }

      public AndroidAppNotificationDataOrBuilder getAppDataOrBuilder() {
         if (this.appDataBuilder_ != null) {
            return (AndroidAppNotificationDataOrBuilder)this.appDataBuilder_.getMessageOrBuilder();
         } else {
            return this.appData_ == null ? AndroidAppNotificationData.getDefaultInstance() : this.appData_;
         }
      }

      private SingleFieldBuilderV3 getAppDataFieldBuilder() {
         if (this.appDataBuilder_ == null) {
            this.appDataBuilder_ = new SingleFieldBuilderV3(this.getAppData(), this.getParentForChildren(), this.isClean());
            this.appData_ = null;
         }

         return this.appDataBuilder_;
      }

      public boolean hasAppDeliveryData() {
         return (this.bitField0_ & 64) != 0;
      }

      public AndroidAppDeliveryData getAppDeliveryData() {
         if (this.appDeliveryDataBuilder_ == null) {
            return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
         } else {
            return (AndroidAppDeliveryData)this.appDeliveryDataBuilder_.getMessage();
         }
      }

      public Notification.Builder setAppDeliveryData(AndroidAppDeliveryData value) {
         if (this.appDeliveryDataBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.appDeliveryData_ = value;
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.setMessage(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Notification.Builder setAppDeliveryData(AndroidAppDeliveryData.Builder builderForValue) {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = builderForValue.build();
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Notification.Builder mergeAppDeliveryData(AndroidAppDeliveryData value) {
         if (this.appDeliveryDataBuilder_ == null) {
            if ((this.bitField0_ & 64) != 0 && this.appDeliveryData_ != null && this.appDeliveryData_ != AndroidAppDeliveryData.getDefaultInstance()) {
               this.appDeliveryData_ = AndroidAppDeliveryData.newBuilder(this.appDeliveryData_).mergeFrom(value).buildPartial();
            } else {
               this.appDeliveryData_ = value;
            }

            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 64;
         return this;
      }

      public Notification.Builder clearAppDeliveryData() {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryData_ = null;
            this.onChanged();
         } else {
            this.appDeliveryDataBuilder_.clear();
         }

         this.bitField0_ &= -65;
         return this;
      }

      public AndroidAppDeliveryData.Builder getAppDeliveryDataBuilder() {
         this.bitField0_ |= 64;
         this.onChanged();
         return (AndroidAppDeliveryData.Builder)this.getAppDeliveryDataFieldBuilder().getBuilder();
      }

      public AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder() {
         if (this.appDeliveryDataBuilder_ != null) {
            return (AndroidAppDeliveryDataOrBuilder)this.appDeliveryDataBuilder_.getMessageOrBuilder();
         } else {
            return this.appDeliveryData_ == null ? AndroidAppDeliveryData.getDefaultInstance() : this.appDeliveryData_;
         }
      }

      private SingleFieldBuilderV3 getAppDeliveryDataFieldBuilder() {
         if (this.appDeliveryDataBuilder_ == null) {
            this.appDeliveryDataBuilder_ = new SingleFieldBuilderV3(this.getAppDeliveryData(), this.getParentForChildren(), this.isClean());
            this.appDeliveryData_ = null;
         }

         return this.appDeliveryDataBuilder_;
      }

      public boolean hasNotificationId() {
         return (this.bitField0_ & 128) != 0;
      }

      public String getNotificationId() {
         Object ref = this.notificationId_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.notificationId_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getNotificationIdBytes() {
         Object ref = this.notificationId_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.notificationId_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public Notification.Builder setNotificationId(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.notificationId_ = value;
            this.onChanged();
            return this;
         }
      }

      public Notification.Builder clearNotificationId() {
         this.bitField0_ &= -129;
         this.notificationId_ = Notification.getDefaultInstance().getNotificationId();
         this.onChanged();
         return this;
      }

      public Notification.Builder setNotificationIdBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 128;
            this.notificationId_ = value;
            this.onChanged();
            return this;
         }
      }

      public final Notification.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (Notification.Builder)super.setUnknownFields(unknownFields);
      }

      public final Notification.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (Notification.Builder)super.mergeUnknownFields(unknownFields);
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
