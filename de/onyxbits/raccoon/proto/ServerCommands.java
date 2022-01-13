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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ServerCommands extends GeneratedMessageV3 implements ServerCommandsOrBuilder {
   private static final long serialVersionUID = 0L;
   private int bitField0_;
   public static final int DISPLAYERRORMESSAGE_FIELD_NUMBER = 2;
   private volatile Object displayErrorMessage_;
   private byte memoizedIsInitialized;
   private static final ServerCommands DEFAULT_INSTANCE = new ServerCommands();
   /** @deprecated */
   @Deprecated
   public static final Parser PARSER = new AbstractParser() {
      public ServerCommands parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
         return new ServerCommands(input, extensionRegistry);
      }
   };

   private ServerCommands(GeneratedMessageV3.Builder builder) {
      super(builder);
      this.memoizedIsInitialized = -1;
   }

   private ServerCommands() {
      this.memoizedIsInitialized = -1;
      this.displayErrorMessage_ = "";
   }

   protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
      return new ServerCommands();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private ServerCommands(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
               case 18:
                  ByteString bs = input.readBytes();
                  this.bitField0_ |= 1;
                  this.displayErrorMessage_ = bs;
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
      return Mothership.internal_static_ServerCommands_descriptor;
   }

   protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return Mothership.internal_static_ServerCommands_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerCommands.class, ServerCommands.Builder.class);
   }

   public boolean hasDisplayErrorMessage() {
      return (this.bitField0_ & 1) != 0;
   }

   public String getDisplayErrorMessage() {
      Object ref = this.displayErrorMessage_;
      if (ref instanceof String) {
         return (String)ref;
      } else {
         ByteString bs = (ByteString)ref;
         String s = bs.toStringUtf8();
         if (bs.isValidUtf8()) {
            this.displayErrorMessage_ = s;
         }

         return s;
      }
   }

   public ByteString getDisplayErrorMessageBytes() {
      Object ref = this.displayErrorMessage_;
      if (ref instanceof String) {
         ByteString b = ByteString.copyFromUtf8((String)ref);
         this.displayErrorMessage_ = b;
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
         GeneratedMessageV3.writeString(output, 2, this.displayErrorMessage_);
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
            size += GeneratedMessageV3.computeStringSize(2, this.displayErrorMessage_);
         }

         size += this.unknownFields.getSerializedSize();
         this.memoizedSize = size;
         return size;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ServerCommands)) {
         return super.equals(obj);
      } else {
         ServerCommands other = (ServerCommands)obj;
         if (this.hasDisplayErrorMessage() != other.hasDisplayErrorMessage()) {
            return false;
         } else if (this.hasDisplayErrorMessage() && !this.getDisplayErrorMessage().equals(other.getDisplayErrorMessage())) {
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
         if (this.hasDisplayErrorMessage()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getDisplayErrorMessage().hashCode();
         }

         hash = 29 * hash + this.unknownFields.hashCode();
         this.memoizedHashCode = hash;
         return hash;
      }
   }

   public static ServerCommands parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data);
   }

   public static ServerCommands parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ServerCommands parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data);
   }

   public static ServerCommands parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ServerCommands parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data);
   }

   public static ServerCommands parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return (ServerCommands)PARSER.parseFrom(data, extensionRegistry);
   }

   public static ServerCommands parseFrom(InputStream input) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ServerCommands parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public static ServerCommands parseDelimitedFrom(InputStream input) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
   }

   public static ServerCommands parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
   }

   public static ServerCommands parseFrom(CodedInputStream input) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseWithIOException(PARSER, input);
   }

   public static ServerCommands parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      return (ServerCommands)GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
   }

   public ServerCommands.Builder newBuilderForType() {
      return newBuilder();
   }

   public static ServerCommands.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static ServerCommands.Builder newBuilder(ServerCommands prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
   }

   public ServerCommands.Builder toBuilder() {
      return this == DEFAULT_INSTANCE ? new ServerCommands.Builder() : (new ServerCommands.Builder()).mergeFrom(this);
   }

   protected ServerCommands.Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
      ServerCommands.Builder builder = new ServerCommands.Builder(parent);
      return builder;
   }

   public static ServerCommands getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public static Parser parser() {
      return PARSER;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public ServerCommands getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   ServerCommands(GeneratedMessageV3.Builder x0, Object x1) {
      this(x0);
   }

   // $FF: synthetic method
   ServerCommands(CodedInputStream x0, ExtensionRegistryLite x1, Object x2) throws InvalidProtocolBufferException {
      this(x0, x1);
   }

   public static final class Builder extends GeneratedMessageV3.Builder implements ServerCommandsOrBuilder {
      private int bitField0_;
      private Object displayErrorMessage_;

      public static final Descriptors.Descriptor getDescriptor() {
         return Mothership.internal_static_ServerCommands_descriptor;
      }

      protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
         return Mothership.internal_static_ServerCommands_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerCommands.class, ServerCommands.Builder.class);
      }

      private Builder() {
         this.displayErrorMessage_ = "";
         this.maybeForceBuilderInitialization();
      }

      private Builder(GeneratedMessageV3.BuilderParent parent) {
         super(parent);
         this.displayErrorMessage_ = "";
         this.maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
         if (ServerCommands.alwaysUseFieldBuilders) {
         }

      }

      public ServerCommands.Builder clear() {
         super.clear();
         this.displayErrorMessage_ = "";
         this.bitField0_ &= -2;
         return this;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return Mothership.internal_static_ServerCommands_descriptor;
      }

      public ServerCommands getDefaultInstanceForType() {
         return ServerCommands.getDefaultInstance();
      }

      public ServerCommands build() {
         ServerCommands result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public ServerCommands buildPartial() {
         ServerCommands result = new ServerCommands(this);
         int from_bitField0_ = this.bitField0_;
         int to_bitField0_ = 0;
         if ((from_bitField0_ & 1) != 0) {
            to_bitField0_ |= 1;
         }

         result.displayErrorMessage_ = this.displayErrorMessage_;
         result.bitField0_ = to_bitField0_;
         this.onBuilt();
         return result;
      }

      public ServerCommands.Builder clone() {
         return (ServerCommands.Builder)super.clone();
      }

      public ServerCommands.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         return (ServerCommands.Builder)super.setField(field, value);
      }

      public ServerCommands.Builder clearField(Descriptors.FieldDescriptor field) {
         return (ServerCommands.Builder)super.clearField(field);
      }

      public ServerCommands.Builder clearOneof(Descriptors.OneofDescriptor oneof) {
         return (ServerCommands.Builder)super.clearOneof(oneof);
      }

      public ServerCommands.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         return (ServerCommands.Builder)super.setRepeatedField(field, index, value);
      }

      public ServerCommands.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         return (ServerCommands.Builder)super.addRepeatedField(field, value);
      }

      public ServerCommands.Builder mergeFrom(Message other) {
         if (other instanceof ServerCommands) {
            return this.mergeFrom((ServerCommands)other);
         } else {
            super.mergeFrom(other);
            return this;
         }
      }

      public ServerCommands.Builder mergeFrom(ServerCommands other) {
         if (other == ServerCommands.getDefaultInstance()) {
            return this;
         } else {
            if (other.hasDisplayErrorMessage()) {
               this.bitField0_ |= 1;
               this.displayErrorMessage_ = other.displayErrorMessage_;
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

      public ServerCommands.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
         ServerCommands parsedMessage = null;

         try {
            parsedMessage = (ServerCommands)ServerCommands.PARSER.parsePartialFrom(input, extensionRegistry);
         } catch (InvalidProtocolBufferException var8) {
            parsedMessage = (ServerCommands)var8.getUnfinishedMessage();
            throw var8.unwrapIOException();
         } finally {
            if (parsedMessage != null) {
               this.mergeFrom(parsedMessage);
            }

         }

         return this;
      }

      public boolean hasDisplayErrorMessage() {
         return (this.bitField0_ & 1) != 0;
      }

      public String getDisplayErrorMessage() {
         Object ref = this.displayErrorMessage_;
         if (!(ref instanceof String)) {
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
               this.displayErrorMessage_ = s;
            }

            return s;
         } else {
            return (String)ref;
         }
      }

      public ByteString getDisplayErrorMessageBytes() {
         Object ref = this.displayErrorMessage_;
         if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.displayErrorMessage_ = b;
            return b;
         } else {
            return (ByteString)ref;
         }
      }

      public ServerCommands.Builder setDisplayErrorMessage(String value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.displayErrorMessage_ = value;
            this.onChanged();
            return this;
         }
      }

      public ServerCommands.Builder clearDisplayErrorMessage() {
         this.bitField0_ &= -2;
         this.displayErrorMessage_ = ServerCommands.getDefaultInstance().getDisplayErrorMessage();
         this.onChanged();
         return this;
      }

      public ServerCommands.Builder setDisplayErrorMessageBytes(ByteString value) {
         if (value == null) {
            throw new NullPointerException();
         } else {
            this.bitField0_ |= 1;
            this.displayErrorMessage_ = value;
            this.onChanged();
            return this;
         }
      }

      public final ServerCommands.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return (ServerCommands.Builder)super.setUnknownFields(unknownFields);
      }

      public final ServerCommands.Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
         return (ServerCommands.Builder)super.mergeUnknownFields(unknownFields);
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
