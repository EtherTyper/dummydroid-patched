package de.onyxbits.raccoon.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

public final class ResponseWrapper extends GeneratedMessageV3 implements ResponseWrapperOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int PAYLOAD_FIELD_NUMBER = 1;
   private Payload payload_;
   public static final int COMMANDS_FIELD_NUMBER = 2;
   private ServerCommands commands_;
   public static final int PREFETCH_FIELD_NUMBER = 3;
   private List preFetch_;
   public static final int NOTIFICATION_FIELD_NUMBER = 4;
   private List notification_;
   private byte memoizedIsInitialized;
   private static final ResponseWrapper DEFAULT_INSTANCE = new ResponseWrapper();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ResponseWrapper parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ResponseWrapper(input, extensionRegistry);
      }
   };

   private ResponseWrapper(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ResponseWrapper() {
      this.memoizedIsInitialized = -1;
      this.preFetch_ = Collections.emptyList();
      this.notification_ = Collections.emptyList();
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ResponseWrapper();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ResponseWrapper(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               switch(tag) {
               case 0:
                  done = true;
                  break;
               case 10:
                  Payload.Builder subBuilder = null;
                  if ((this.bitField0_ & 1) != 0) {
                     subBuilder = this.payload_.toBuilder();
                  }

                  this.payload_ = (Payload)input.readMessage(Payload.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.payload_);
                     this.payload_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 1;
                  break;
               case 18:
                  ServerCommands.Builder subBuilder = null;
                  if ((this.bitField0_ & 2) != 0) {
                     subBuilder = this.commands_.toBuilder();
                  }

                  this.commands_ = (ServerCommands)input.readMessage(ServerCommands.PARSER, extensionRegistry);
                  if (subBuilder != null) {
                     subBuilder.mergeFrom(this.commands_);
                     this.commands_ = subBuilder.buildPartial();
                  }

                  this.bitField0_ |= 2;
                  break;
               case 26:
                  if ((mutable_bitField0_ & 4) == 0) {
                     this.preFetch_ = new ArrayList();
                     mutable_bitField0_ |= 4;
                  }

                  this.preFetch_.add(input.readMessage(PreFetch.PARSER, extensionRegistry));
                  break;
               case 34:
                  if ((mutable_bitField0_ & 8) == 0) {
                     this.notification_ = new ArrayList();
                     mutable_bitField0_ |= 8;
                  }

                  this.notification_.add(input.readMessage(Notification.PARSER, extensionRegistry));
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
               this.preFetch_ = Collections.unmodifiableList(this.preFetch_);
            }

            if ((mutable_bitField0_ & 8) != 0) {
               this.notification_ = Collections.unmodifiableList(this.notification_);
            }

            this.unknownFields = unknownFields.build();
            this.makeExtensionsImmutable();
         }

      }
   }

   public static final Descriptors.Descriptor getDescriptor() {
      return Mothership.internal_static_ResponseWrapper_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ResponseWrapper_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponseWrapper.class, ResponseWrapper.Builder.class);
   }

   public boolean hasPayload() {
      return (this.bitField0_ & 1) != 0;
   }

   public Payload getPayload() {
      return this.payload_ == null ? Payload.getDefaultInstance() : this.payload_;
   }

   public PayloadOrBuilder getPayloadOrBuilder() {
      return this.payload_ == null ? Payload.getDefaultInstance() : this.payload_;
   }

   public boolean hasCommands() {
      return (this.bitField0_ & 2) != 0;
   }

   public ServerCommands getCommands() {
      return this.commands_ == null ? ServerCommands.getDefaultInstance() : this.commands_;
   }

   public ServerCommandsOrBuilder getCommandsOrBuilder() {
      return this.commands_ == null ? ServerCommands.getDefaultInstance() : this.commands_;
   }

   public List getPreFetchList() {
      return this.preFetch_;
   }

   public List getPreFetchOrBuilderList() {
      return this.preFetch_;
   }

   public int getPreFetchCount() {
      return this.preFetch_.size();
   }

   public PreFetch getPreFetch(int index) {
      return (PreFetch)this.preFetch_.get(index);
   }

   public PreFetchOrBuilder getPreFetchOrBuilder(int index) {
      return (PreFetchOrBuilder)this.preFetch_.get(index);
   }

   public List getNotificationList() {
      return this.notification_;
   }

   public List getNotificationOrBuilderList() {
      return this.notification_;
   }

   public int getNotificationCount() {
      return this.notification_.size();
   }

   public Notification getNotification(int index) {
      return (Notification)this.notification_.get(index);
   }

   public NotificationOrBuilder getNotificationOrBuilder(int index) {
      return (NotificationOrBuilder)this.notification_.get(index);
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
         output.writeMessage(1, this.getPayload());
      }

      if ((this.bitField0_ & 2) != 0) {
         output.writeMessage(2, this.getCommands());
      }

      int i;
      for(i = 0; i < this.preFetch_.size(); ++i) {
         output.writeMessage(3, (MessageLite)this.preFetch_.get(i));
      }

      for(i = 0; i < this.notification_.size(); ++i) {
         output.writeMessage(4, (MessageLite)this.notification_.get(i));
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
            size += CodedOutputStream.computeMessageSize(1, this.getPayload());
         }

         if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getCommands());
         }

         int i;
         for(i = 0; i < this.preFetch_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.preFetch_.get(i));
         }

         for(i = 0; i < this.notification_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.notification_.get(i));
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ResponseWrapper)) {
         return super.equals(obj);
      } else {
         ResponseWrapper other = (ResponseWrapper)obj;
         if (this.hasPayload() != other.hasPayload()) {
            return false;
         } else if (this.hasPayload() && !this.getPayload().equals(other.getPayload())) {
            return false;
         } else if (this.hasCommands() != other.hasCommands()) {
            return false;
         } else if (this.hasCommands() && !this.getCommands().equals(other.getCommands())) {
            return false;
         } else if (!this.getPreFetchList().equals(other.getPreFetchList())) {
            return false;
         } else if (!this.getNotificationList().equals(other.getNotificationList())) {
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
         if (this.hasPayload()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPayload().hashCode();
         }

         if (this.hasCommands()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getCommands().hashCode();
         }

         if (this.getPreFetchCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getPreFetchList().hashCode();
         }

         if (this.getNotificationCount() > 0) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getNotificationList().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ResponseWrapper parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data);
   }

   public static ResponseWrapper parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ResponseWrapper parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data);
   }

   public static ResponseWrapper parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ResponseWrapper parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data);
   }

   public static ResponseWrapper parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ResponseWrapper)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ResponseWrapper parseFrom(InputStream input) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ResponseWrapper parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ResponseWrapper parseDelimitedFrom(InputStream input) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ResponseWrapper parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ResponseWrapper parseFrom(CodedInputStream input) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ResponseWrapper parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ResponseWrapper)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ResponseWrapper.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ResponseWrapper.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ResponseWrapper.Builder newBuilder(ResponseWrapper prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ResponseWrapper.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ResponseWrapper.Builder() : (new ResponseWrapper.Builder()).mergeFrom(this);
   }

   protected ResponseWrapper.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ResponseWrapper.Builder builder = new ResponseWrapper.Builder(parent);
      return builder;
   }

   public static ResponseWrapper getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ResponseWrapper getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ResponseWrapper(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ResponseWrapper(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ResponseWrapperOrBuilder {
      private int bitField0_;
      private Payload payload_;
      private SingleFieldBuilderV3 payloadBuilder_;
      private ServerCommands commands_;
      private SingleFieldBuilderV3 commandsBuilder_;
      private List preFetch_;
      private RepeatedFieldBuilderV3 preFetchBuilder_;
      private List notification_;
      private RepeatedFieldBuilderV3 notificationBuilder_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ResponseWrapper_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ResponseWrapper_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponseWrapper.class, ResponseWrapper.Builder.class);
      }

      private Builder() {
         this.preFetch_ = Collections.emptyList();
         this.notification_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.preFetch_ = Collections.emptyList();
         this.notification_ = Collections.emptyList();
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ResponseWrapper.alwaysUseFieldBuilders) {
            this.getPayloadFieldBuilder();
            this.getCommandsFieldBuilder();
            this.getPreFetchFieldBuilder();
            this.getNotificationFieldBuilder();
         }

      }

      public ResponseWrapper.Builder clear() {
         super.clear();
         if (this.payloadBuilder_ == null) {
            this.payload_ = null;
         } else {
            this.payloadBuilder_.clear();
         }

         this.bitField0_ &= -2;
         if (this.commandsBuilder_ == null) {
            this.commands_ = null;
         } else {
            this.commandsBuilder_.clear();
         }

         this.bitField0_ &= -3;
         if (this.preFetchBuilder_ == null) {
            this.preFetch_ = Collections.emptyList();
            this.bitField0_ &= -5;
         } else {
            this.preFetchBuilder_.clear();
         }

         if (this.notificationBuilder_ == null) {
            this.notification_ = Collections.emptyList();
            this.bitField0_ &= -9;
         } else {
            this.notificationBuilder_.clear();
         }

         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ResponseWrapper_descriptor;
      }

      public ResponseWrapper getDefaultInstanceForType() {
         return ResponseWrapper.getDefaultInstance();
      }

      public ResponseWrapper build() {
         ResponseWrapper result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ResponseWrapper buildPartial() {
         ResponseWrapper result = new ResponseWrapper(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            if (this.payloadBuilder_ == null) {
               result.payload_ = this.payload_;
            } else {
               result.payload_ = (Payload)this.payloadBuilder_.build();
            }

            to_bitField0_ |= 1;
         }

         if ((from_bitField0_ & 2) != 0) {
            if (this.commandsBuilder_ == null) {
               result.commands_ = this.commands_;
            } else {
               result.commands_ = (ServerCommands)this.commandsBuilder_.build();
            }

            to_bitField0_ |= 2;
         }

         if (this.preFetchBuilder_ == null) {
            if ((this.bitField0_ & 4) != 0) {
               this.preFetch_ = Collections.unmodifiableList(this.preFetch_);
               this.bitField0_ &= -5;
            }

            result.preFetch_ = this.preFetch_;
         } else {
            result.preFetch_ = this.preFetchBuilder_.build();
         }

         if (this.notificationBuilder_ == null) {
            if ((this.bitField0_ & 8) != 0) {
               this.notification_ = Collections.unmodifiableList(this.notification_);
               this.bitField0_ &= -9;
            }

            result.notification_ = this.notification_;
         } else {
            result.notification_ = this.notificationBuilder_.build();
         }

         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ResponseWrapper.Builder clone() {
         return (ResponseWrapper.Builder)super.clone();
      }

      public ResponseWrapper.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ResponseWrapper.Builder)super.setField(field, value);
      }

      public ResponseWrapper.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ResponseWrapper.Builder)super.clearField(field);
      }

      public ResponseWrapper.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ResponseWrapper.Builder)super.clearOneof(oneof);
      }

      public ResponseWrapper.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ResponseWrapper.Builder)super.setRepeatedField(field, index, value);
      }

      public ResponseWrapper.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ResponseWrapper.Builder)super.addRepeatedField(field, value);
      }

      public ResponseWrapper.Builder mergeFrom(Message other) {
         if (other instanceof ResponseWrapper) {
            return this.mergeFrom((ResponseWrapper)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ResponseWrapper.Builder mergeFrom(ResponseWrapper other) {
         if (other == ResponseWrapper.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasPayload()) {
               this.mergePayload(other.getPayload());
            }

            if (other.hasCommands()) {
               this.mergeCommands(other.getCommands());
            }

            if (this.preFetchBuilder_ == null) {
               if (!other.preFetch_.isEmpty()) {
                  if (this.preFetch_.isEmpty()) {
                     this.preFetch_ = other.preFetch_;
                     this.bitField0_ &= -5;
                  } else {
                     this.ensurePreFetchIsMutable();
                     this.preFetch_.addAll(other.preFetch_);
                  }

                  this.onChanged();
               }
            } else if (!other.preFetch_.isEmpty()) {
               if (this.preFetchBuilder_.isEmpty()) {
                  this.preFetchBuilder_.dispose();
                  this.preFetchBuilder_ = null;
                  this.preFetch_ = other.preFetch_;
                  this.bitField0_ &= -5;
                  this.preFetchBuilder_ = ResponseWrapper.alwaysUseFieldBuilders ? this.getPreFetchFieldBuilder() : null;
               } else {
                  this.preFetchBuilder_.addAllMessages(other.preFetch_);
               }
            }

            if (this.notificationBuilder_ == null) {
               if (!other.notification_.isEmpty()) {
                  if (this.notification_.isEmpty()) {
                     this.notification_ = other.notification_;
                     this.bitField0_ &= -9;
                  } else {
                     this.ensureNotificationIsMutable();
                     this.notification_.addAll(other.notification_);
                  }

                  this.onChanged();
               }
            } else if (!other.notification_.isEmpty()) {
               if (this.notificationBuilder_.isEmpty()) {
                  this.notificationBuilder_.dispose();
                  this.notificationBuilder_ = null;
                  this.notification_ = other.notification_;
                  this.bitField0_ &= -9;
                  this.notificationBuilder_ = ResponseWrapper.alwaysUseFieldBuilders ? this.getNotificationFieldBuilder() : null;
               } else {
                  this.notificationBuilder_.addAllMessages(other.notification_);
               }
            }

            this.mergeUnknownFields(other.unknownFields);
            this.onChanged();
            return this;
         }
      }

      public final boolean isInitialized() {
         return true;
      }

      public ResponseWrapper.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ResponseWrapper parsedMessage = null;

         try {
            parsedMessage = (ResponseWrapper)ResponseWrapper.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ResponseWrapper)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasPayload() {
         return (this.bitField0_ & 1) != 0;
      }

      public Payload getPayload() {
         if (this.payloadBuilder_ == null) {
            return this.payload_ == null ? Payload.getDefaultInstance() : this.payload_;
         } else {
            return (Payload)this.payloadBuilder_.getMessage();
         }
      }

      public ResponseWrapper.Builder setPayload(Payload value) {
         if (this.payloadBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.payload_ = value;
            this.onChanged();
         } else {
            this.payloadBuilder_.setMessage(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ResponseWrapper.Builder setPayload(Payload.Builder builderForValue) {
         if (this.payloadBuilder_ == null) {
            this.payload_ = builderForValue.build();
            this.onChanged();
         } else {
            this.payloadBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ResponseWrapper.Builder mergePayload(Payload value) {
         if (this.payloadBuilder_ == null) {
            if ((this.bitField0_ & 1) != 0 && this.payload_ != null && this.payload_ != Payload.getDefaultInstance()) {
               this.payload_ = Payload.newBuilder(this.payload_).mergeFrom(value).buildPartial();
            } else {
               this.payload_ = value;
            }

            this.onChanged();
         } else {
            this.payloadBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 1;
         return this;
      }

      public ResponseWrapper.Builder clearPayload() {
         if (this.payloadBuilder_ == null) {
            this.payload_ = null;
            this.onChanged();
         } else {
            this.payloadBuilder_.clear();
         }

         this.bitField0_ &= -2;
         return this;
      }

      public Payload.Builder getPayloadBuilder() {
         this.bitField0_ |= 1;
         this.onChanged();
         return (Payload.Builder)this.getPayloadFieldBuilder().getBuilder();
      }

      public PayloadOrBuilder getPayloadOrBuilder() {
         if (this.payloadBuilder_ != null) {
            return (PayloadOrBuilder)this.payloadBuilder_.getMessageOrBuilder();
         } else {
            return this.payload_ == null ? Payload.getDefaultInstance() : this.payload_;
         }
      }

      private SingleFieldBuilderV3 getPayloadFieldBuilder() {
         if (this.payloadBuilder_ == null) {
            this.payloadBuilder_ = new SingleFieldBuilderV3(this.getPayload(), this.getParentForChildren(), this.isClean());
            this.payload_ = null;
         }

         return this.payloadBuilder_;
      }

      public boolean hasCommands() {
         return (this.bitField0_ & 2) != 0;
      }

      public ServerCommands getCommands() {
         if (this.commandsBuilder_ == null) {
            return this.commands_ == null ? ServerCommands.getDefaultInstance() : this.commands_;
         } else {
            return (ServerCommands)this.commandsBuilder_.getMessage();
         }
      }

      public ResponseWrapper.Builder setCommands(ServerCommands value) {
         if (this.commandsBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.commands_ = value;
            this.onChanged();
         } else {
            this.commandsBuilder_.setMessage(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public ResponseWrapper.Builder setCommands(ServerCommands.Builder builderForValue) {
         if (this.commandsBuilder_ == null) {
            this.commands_ = builderForValue.build();
            this.onChanged();
         } else {
            this.commandsBuilder_.setMessage(builderForValue.build());
         }

         this.bitField0_ |= 2;
         return this;
      }

      public ResponseWrapper.Builder mergeCommands(ServerCommands value) {
         if (this.commandsBuilder_ == null) {
            if ((this.bitField0_ & 2) != 0 && this.commands_ != null && this.commands_ != ServerCommands.getDefaultInstance()) {
               this.commands_ = ServerCommands.newBuilder(this.commands_).mergeFrom(value).buildPartial();
            } else {
               this.commands_ = value;
            }

            this.onChanged();
         } else {
            this.commandsBuilder_.mergeFrom(value);
         }

         this.bitField0_ |= 2;
         return this;
      }

      public ResponseWrapper.Builder clearCommands() {
         if (this.commandsBuilder_ == null) {
            this.commands_ = null;
            this.onChanged();
         } else {
            this.commandsBuilder_.clear();
         }

         this.bitField0_ &= -3;
         return this;
      }

      public ServerCommands.Builder getCommandsBuilder() {
         this.bitField0_ |= 2;
         this.onChanged();
         return (ServerCommands.Builder)this.getCommandsFieldBuilder().getBuilder();
      }

      public ServerCommandsOrBuilder getCommandsOrBuilder() {
         if (this.commandsBuilder_ != null) {
            return (ServerCommandsOrBuilder)this.commandsBuilder_.getMessageOrBuilder();
         } else {
            return this.commands_ == null ? ServerCommands.getDefaultInstance() : this.commands_;
         }
      }

      private SingleFieldBuilderV3 getCommandsFieldBuilder() {
         if (this.commandsBuilder_ == null) {
            this.commandsBuilder_ = new SingleFieldBuilderV3(this.getCommands(), this.getParentForChildren(), this.isClean());
            this.commands_ = null;
         }

         return this.commandsBuilder_;
      }

      private void ensurePreFetchIsMutable() {
         if ((this.bitField0_ & 4) == 0) {
            this.preFetch_ = new ArrayList(this.preFetch_);
            this.bitField0_ |= 4;
         }

      }

      public List getPreFetchList() {
         return this.preFetchBuilder_ == null ? Collections.unmodifiableList(this.preFetch_) : this.preFetchBuilder_.getMessageList();
      }

      public int getPreFetchCount() {
         return this.preFetchBuilder_ == null ? this.preFetch_.size() : this.preFetchBuilder_.getCount();
      }

      public PreFetch getPreFetch(int index) {
         return this.preFetchBuilder_ == null ? (PreFetch)this.preFetch_.get(index) : (PreFetch)this.preFetchBuilder_.getMessage(index);
      }

      public ResponseWrapper.Builder setPreFetch(int index, PreFetch value) {
         if (this.preFetchBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensurePreFetchIsMutable();
            this.preFetch_.set(index, value);
            this.onChanged();
         } else {
            this.preFetchBuilder_.setMessage(index, value);
         }

         return this;
      }

      public ResponseWrapper.Builder setPreFetch(int index, PreFetch.Builder builderForValue) {
         if (this.preFetchBuilder_ == null) {
            this.ensurePreFetchIsMutable();
            this.preFetch_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.preFetchBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addPreFetch(PreFetch value) {
         if (this.preFetchBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensurePreFetchIsMutable();
            this.preFetch_.add(value);
            this.onChanged();
         } else {
            this.preFetchBuilder_.addMessage(value);
         }

         return this;
      }

      public ResponseWrapper.Builder addPreFetch(int index, PreFetch value) {
         if (this.preFetchBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensurePreFetchIsMutable();
            this.preFetch_.add(index, value);
            this.onChanged();
         } else {
            this.preFetchBuilder_.addMessage(index, value);
         }

         return this;
      }

      public ResponseWrapper.Builder addPreFetch(PreFetch.Builder builderForValue) {
         if (this.preFetchBuilder_ == null) {
            this.ensurePreFetchIsMutable();
            this.preFetch_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.preFetchBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addPreFetch(int index, PreFetch.Builder builderForValue) {
         if (this.preFetchBuilder_ == null) {
            this.ensurePreFetchIsMutable();
            this.preFetch_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.preFetchBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addAllPreFetch(Iterable values) {
         if (this.preFetchBuilder_ == null) {
            this.ensurePreFetchIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.preFetch_);
            this.onChanged();
         } else {
            this.preFetchBuilder_.addAllMessages(values);
         }

         return this;
      }

      public ResponseWrapper.Builder clearPreFetch() {
         if (this.preFetchBuilder_ == null) {
            this.preFetch_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
         } else {
            this.preFetchBuilder_.clear();
         }

         return this;
      }

      public ResponseWrapper.Builder removePreFetch(int index) {
         if (this.preFetchBuilder_ == null) {
            this.ensurePreFetchIsMutable();
            this.preFetch_.remove(index);
            this.onChanged();
         } else {
            this.preFetchBuilder_.remove(index);
         }

         return this;
      }

      public PreFetch.Builder getPreFetchBuilder(int index) {
         return (PreFetch.Builder)this.getPreFetchFieldBuilder().getBuilder(index);
      }

      public PreFetchOrBuilder getPreFetchOrBuilder(int index) {
         return this.preFetchBuilder_ == null ? (PreFetchOrBuilder)this.preFetch_.get(index) : (PreFetchOrBuilder)this.preFetchBuilder_.getMessageOrBuilder(index);
      }

      public List getPreFetchOrBuilderList() {
         return this.preFetchBuilder_ != null ? this.preFetchBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.preFetch_);
      }

      public PreFetch.Builder addPreFetchBuilder() {
         return (PreFetch.Builder)this.getPreFetchFieldBuilder().addBuilder(PreFetch.getDefaultInstance());
      }

      public PreFetch.Builder addPreFetchBuilder(int index) {
         return (PreFetch.Builder)this.getPreFetchFieldBuilder().addBuilder(index, PreFetch.getDefaultInstance());
      }

      public List getPreFetchBuilderList() {
         return this.getPreFetchFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getPreFetchFieldBuilder() {
         if (this.preFetchBuilder_ == null) {
            this.preFetchBuilder_ = new RepeatedFieldBuilderV3(this.preFetch_, (this.bitField0_ & 4) != 0, this.getParentForChildren(), this.isClean());
            this.preFetch_ = null;
         }

         return this.preFetchBuilder_;
      }

      private void ensureNotificationIsMutable() {
         if ((this.bitField0_ & 8) == 0) {
            this.notification_ = new ArrayList(this.notification_);
            this.bitField0_ |= 8;
         }

      }

      public List getNotificationList() {
         return this.notificationBuilder_ == null ? Collections.unmodifiableList(this.notification_) : this.notificationBuilder_.getMessageList();
      }

      public int getNotificationCount() {
         return this.notificationBuilder_ == null ? this.notification_.size() : this.notificationBuilder_.getCount();
      }

      public Notification getNotification(int index) {
         return this.notificationBuilder_ == null ? (Notification)this.notification_.get(index) : (Notification)this.notificationBuilder_.getMessage(index);
      }

      public ResponseWrapper.Builder setNotification(int index, Notification value) {
         if (this.notificationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureNotificationIsMutable();
            this.notification_.set(index, value);
            this.onChanged();
         } else {
            this.notificationBuilder_.setMessage(index, value);
         }

         return this;
      }

      public ResponseWrapper.Builder setNotification(int index, Notification.Builder builderForValue) {
         if (this.notificationBuilder_ == null) {
            this.ensureNotificationIsMutable();
            this.notification_.set(index, builderForValue.build());
            this.onChanged();
         } else {
            this.notificationBuilder_.setMessage(index, builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addNotification(Notification value) {
         if (this.notificationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureNotificationIsMutable();
            this.notification_.add(value);
            this.onChanged();
         } else {
            this.notificationBuilder_.addMessage(value);
         }

         return this;
      }

      public ResponseWrapper.Builder addNotification(int index, Notification value) {
         if (this.notificationBuilder_ == null) {
            if (value == null) {
               throw new NullPointerException();
            }

            this.ensureNotificationIsMutable();
            this.notification_.add(index, value);
            this.onChanged();
         } else {
            this.notificationBuilder_.addMessage(index, value);
         }

         return this;
      }

      public ResponseWrapper.Builder addNotification(Notification.Builder builderForValue) {
         if (this.notificationBuilder_ == null) {
            this.ensureNotificationIsMutable();
            this.notification_.add(builderForValue.build());
            this.onChanged();
         } else {
            this.notificationBuilder_.addMessage(builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addNotification(int index, Notification.Builder builderForValue) {
         if (this.notificationBuilder_ == null) {
            this.ensureNotificationIsMutable();
            this.notification_.add(index, builderForValue.build());
            this.onChanged();
         } else {
            this.notificationBuilder_.addMessage(index, builderForValue.build());
         }

         return this;
      }

      public ResponseWrapper.Builder addAllNotification(Iterable values) {
         if (this.notificationBuilder_ == null) {
            this.ensureNotificationIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.notification_);
            this.onChanged();
         } else {
            this.notificationBuilder_.addAllMessages(values);
         }

         return this;
      }

      public ResponseWrapper.Builder clearNotification() {
         if (this.notificationBuilder_ == null) {
            this.notification_ = Collections.emptyList();
            this.bitField0_ &= -9;
            this.onChanged();
         } else {
            this.notificationBuilder_.clear();
         }

         return this;
      }

      public ResponseWrapper.Builder removeNotification(int index) {
         if (this.notificationBuilder_ == null) {
            this.ensureNotificationIsMutable();
            this.notification_.remove(index);
            this.onChanged();
         } else {
            this.notificationBuilder_.remove(index);
         }

         return this;
      }

      public Notification.Builder getNotificationBuilder(int index) {
         return (Notification.Builder)this.getNotificationFieldBuilder().getBuilder(index);
      }

      public NotificationOrBuilder getNotificationOrBuilder(int index) {
         return this.notificationBuilder_ == null ? (NotificationOrBuilder)this.notification_.get(index) : (NotificationOrBuilder)this.notificationBuilder_.getMessageOrBuilder(index);
      }

      public List getNotificationOrBuilderList() {
         return this.notificationBuilder_ != null ? this.notificationBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.notification_);
      }

      public Notification.Builder addNotificationBuilder() {
         return (Notification.Builder)this.getNotificationFieldBuilder().addBuilder(Notification.getDefaultInstance());
      }

      public Notification.Builder addNotificationBuilder(int index) {
         return (Notification.Builder)this.getNotificationFieldBuilder().addBuilder(index, Notification.getDefaultInstance());
      }

      public List getNotificationBuilderList() {
         return this.getNotificationFieldBuilder().getBuilderList();
      }

      private RepeatedFieldBuilderV3 getNotificationFieldBuilder() {
         if (this.notificationBuilder_ == null) {
            this.notificationBuilder_ = new RepeatedFieldBuilderV3(this.notification_, (this.bitField0_ & 8) != 0, this.getParentForChildren(), this.isClean());
            this.notification_ = null;
         }

         return this.notificationBuilder_;
      }

      public final ResponseWrapper.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ResponseWrapper.Builder)super.setUnknownFields(unknownFields);
      }

      public final ResponseWrapper.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ResponseWrapper.Builder)super.mergeUnknownFields(unknownFields);
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
