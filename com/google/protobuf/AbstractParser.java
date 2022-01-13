package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser implements Parser {
   private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

   private UninitializedMessageException newUninitializedMessageException(MessageLite message) {
      return message instanceof AbstractMessageLite ? ((AbstractMessageLite)message).newUninitializedMessageException() : new UninitializedMessageException(message);
   }

   private MessageLite checkMessageInitialized(MessageLite message) throws InvalidProtocolBufferException {
      if (message != null && !message.isInitialized()) {
         throw this.newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage(message);
      } else {
         return message;
      }
   }

   public MessageLite parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
      return (MessageLite)this.parsePartialFrom((CodedInputStream)input, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.checkMessageInitialized((MessageLite)this.parsePartialFrom((CodedInputStream)input, extensionRegistry));
   }

   public MessageLite parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
      return this.parseFrom(input, EMPTY_REGISTRY);
   }

   public MessageLite parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      try {
         CodedInputStream input = data.newCodedInput();
         MessageLite message = (MessageLite)this.parsePartialFrom((CodedInputStream)input, extensionRegistry);

         try {
            input.checkLastTagWas(0);
         } catch (InvalidProtocolBufferException var6) {
            throw var6.setUnfinishedMessage(message);
         }

         return message;
      } catch (InvalidProtocolBufferException var7) {
         throw var7;
      }
   }

   public MessageLite parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
      return this.parsePartialFrom(data, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.checkMessageInitialized(this.parsePartialFrom(data, extensionRegistry));
   }

   public MessageLite parseFrom(ByteString data) throws InvalidProtocolBufferException {
      return this.parseFrom(data, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      MessageLite message;
      try {
         CodedInputStream input = CodedInputStream.newInstance(data);
         message = (MessageLite)this.parsePartialFrom((CodedInputStream)input, extensionRegistry);

         try {
            input.checkLastTagWas(0);
         } catch (InvalidProtocolBufferException var6) {
            throw var6.setUnfinishedMessage(message);
         }
      } catch (InvalidProtocolBufferException var7) {
         throw var7;
      }

      return this.checkMessageInitialized(message);
   }

   public MessageLite parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
      return this.parseFrom(data, EMPTY_REGISTRY);
   }

   public MessageLite parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      try {
         CodedInputStream input = CodedInputStream.newInstance(data, off, len);
         MessageLite message = (MessageLite)this.parsePartialFrom((CodedInputStream)input, extensionRegistry);

         try {
            input.checkLastTagWas(0);
         } catch (InvalidProtocolBufferException var8) {
            throw var8.setUnfinishedMessage(message);
         }

         return message;
      } catch (InvalidProtocolBufferException var9) {
         throw var9;
      }
   }

   public MessageLite parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
      return this.parsePartialFrom(data, off, len, EMPTY_REGISTRY);
   }

   public MessageLite parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.parsePartialFrom(data, 0, data.length, extensionRegistry);
   }

   public MessageLite parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
      return this.parsePartialFrom(data, 0, data.length, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.checkMessageInitialized(this.parsePartialFrom(data, off, len, extensionRegistry));
   }

   public MessageLite parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
      return this.parseFrom(data, off, len, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.parseFrom(data, 0, data.length, extensionRegistry);
   }

   public MessageLite parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return this.parseFrom(data, EMPTY_REGISTRY);
   }

   public MessageLite parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      CodedInputStream codedInput = CodedInputStream.newInstance(input);
      MessageLite message = (MessageLite)this.parsePartialFrom((CodedInputStream)codedInput, extensionRegistry);

      try {
         codedInput.checkLastTagWas(0);
         return message;
      } catch (InvalidProtocolBufferException var6) {
         throw var6.setUnfinishedMessage(message);
      }
   }

   public MessageLite parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
      return this.parsePartialFrom(input, EMPTY_REGISTRY);
   }

   public MessageLite parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.checkMessageInitialized(this.parsePartialFrom(input, extensionRegistry));
   }

   public MessageLite parseFrom(InputStream input) throws InvalidProtocolBufferException {
      return this.parseFrom(input, EMPTY_REGISTRY);
   }

   public MessageLite parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      int size;
      try {
         int firstByte = input.read();
         if (firstByte == -1) {
            return null;
         }

         size = CodedInputStream.readRawVarint32(firstByte, input);
      } catch (IOException var5) {
         throw new InvalidProtocolBufferException(var5);
      }

      InputStream limitedInput = new AbstractMessageLite.Builder.LimitedInputStream(input, size);
      return this.parsePartialFrom((InputStream)limitedInput, extensionRegistry);
   }

   public MessageLite parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
      return this.parsePartialDelimitedFrom(input, EMPTY_REGISTRY);
   }

   public MessageLite parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      return this.checkMessageInitialized(this.parsePartialDelimitedFrom(input, extensionRegistry));
   }

   public MessageLite parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
      return this.parseDelimitedFrom(input, EMPTY_REGISTRY);
   }
}
