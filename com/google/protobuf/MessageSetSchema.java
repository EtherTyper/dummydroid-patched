package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class MessageSetSchema implements Schema {
   private final MessageLite defaultInstance;
   private final UnknownFieldSchema unknownFieldSchema;
   private final boolean hasExtensions;
   private final ExtensionSchema extensionSchema;

   private MessageSetSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite defaultInstance) {
      this.unknownFieldSchema = unknownFieldSchema;
      this.hasExtensions = extensionSchema.hasExtensions(defaultInstance);
      this.extensionSchema = extensionSchema;
      this.defaultInstance = defaultInstance;
   }

   static MessageSetSchema newSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite defaultInstance) {
      return new MessageSetSchema(unknownFieldSchema, extensionSchema, defaultInstance);
   }

   public Object newInstance() {
      return this.defaultInstance.newBuilderForType().buildPartial();
   }

   public boolean equals(Object message, Object other) {
      Object messageUnknown = this.unknownFieldSchema.getFromMessage(message);
      Object otherUnknown = this.unknownFieldSchema.getFromMessage(other);
      if (!messageUnknown.equals(otherUnknown)) {
         return false;
      } else if (this.hasExtensions) {
         FieldSet messageExtensions = this.extensionSchema.getExtensions(message);
         FieldSet otherExtensions = this.extensionSchema.getExtensions(other);
         return messageExtensions.equals(otherExtensions);
      } else {
         return true;
      }
   }

   public int hashCode(Object message) {
      int hashCode = this.unknownFieldSchema.getFromMessage(message).hashCode();
      if (this.hasExtensions) {
         FieldSet extensions = this.extensionSchema.getExtensions(message);
         hashCode = hashCode * 53 + extensions.hashCode();
      }

      return hashCode;
   }

   public void mergeFrom(Object message, Object other) {
      SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
      if (this.hasExtensions) {
         SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
      }

   }

   public void writeTo(Object message, Writer writer) throws IOException {
      FieldSet extensions = this.extensionSchema.getExtensions(message);
      Iterator iterator = extensions.iterator();

      while(iterator.hasNext()) {
         Entry extension = (Entry)iterator.next();
         FieldSet.FieldDescriptorLite fd = (FieldSet.FieldDescriptorLite)extension.getKey();
         if (fd.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fd.isRepeated() || fd.isPacked()) {
            throw new IllegalStateException("Found invalid MessageSet item.");
         }

         if (extension instanceof LazyField.LazyEntry) {
            writer.writeMessageSetItem(fd.getNumber(), ((LazyField.LazyEntry)extension).getField().toByteString());
         } else {
            writer.writeMessageSetItem(fd.getNumber(), extension.getValue());
         }
      }

      this.writeUnknownFieldsHelper(this.unknownFieldSchema, message, writer);
   }

   private void writeUnknownFieldsHelper(UnknownFieldSchema unknownFieldSchema, Object message, Writer writer) throws IOException {
      unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(message), writer);
   }

   public void mergeFrom(Object message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
      UnknownFieldSetLite unknownFields = ((GeneratedMessageLite)message).unknownFields;
      if (unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
         unknownFields = UnknownFieldSetLite.newInstance();
         ((GeneratedMessageLite)message).unknownFields = unknownFields;
      }

      FieldSet extensions = ((GeneratedMessageLite.ExtendableMessage)message).ensureExtensionsAreMutable();
      GeneratedMessageLite.GeneratedExtension extension = null;

      while(true) {
         while(position < limit) {
            position = ArrayDecoders.decodeVarint32(data, position, registers);
            int startTag = registers.int1;
            if (startTag != WireFormat.MESSAGE_SET_ITEM_TAG) {
               if (WireFormat.getTagWireType(startTag) == 2) {
                  extension = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(startTag));
                  if (extension != null) {
                     position = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass()), data, position, limit, registers);
                     extensions.setField(extension.descriptor, registers.object1);
                  } else {
                     position = ArrayDecoders.decodeUnknownField(startTag, data, position, limit, unknownFields, registers);
                  }
               } else {
                  position = ArrayDecoders.skipField(startTag, data, position, limit, registers);
               }
            } else {
               int typeId = 0;
               ByteString rawBytes = null;

               while(position < limit) {
                  position = ArrayDecoders.decodeVarint32(data, position, registers);
                  int tag = registers.int1;
                  int number = WireFormat.getTagFieldNumber(tag);
                  int wireType = WireFormat.getTagWireType(tag);
                  switch(number) {
                  case 2:
                     if (wireType == 0) {
                        position = ArrayDecoders.decodeVarint32(data, position, registers);
                        typeId = registers.int1;
                        extension = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, typeId);
                        continue;
                     }
                     break;
                  case 3:
                     if (extension != null) {
                        position = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass()), data, position, limit, registers);
                        extensions.setField(extension.descriptor, registers.object1);
                        continue;
                     }

                     if (wireType == 2) {
                        position = ArrayDecoders.decodeBytes(data, position, registers);
                        rawBytes = (ByteString)registers.object1;
                        continue;
                     }
                  }

                  if (tag == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                     break;
                  }

                  position = ArrayDecoders.skipField(tag, data, position, limit, registers);
               }

               if (rawBytes != null) {
                  unknownFields.storeField(WireFormat.makeTag(typeId, 2), rawBytes);
               }
            }
         }

         if (position != limit) {
            throw InvalidProtocolBufferException.parseFailure();
         }

         return;
      }
   }

   public void mergeFrom(Object message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
      this.mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
   }

   private void mergeFromHelper(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, Object message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
      Object unknownFields = unknownFieldSchema.getBuilderFromMessage(message);
      FieldSet extensions = extensionSchema.getMutableExtensions(message);

      try {
         do {
            int number = reader.getFieldNumber();
            if (number == Integer.MAX_VALUE) {
               return;
            }
         } while(this.parseMessageSetItemOrUnknownField(reader, extensionRegistry, extensionSchema, extensions, unknownFieldSchema, unknownFields));

      } finally {
         unknownFieldSchema.setBuilderToMessage(message, unknownFields);
      }
   }

   public void makeImmutable(Object message) {
      this.unknownFieldSchema.makeImmutable(message);
      this.extensionSchema.makeImmutable(message);
   }

   private boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistry, ExtensionSchema extensionSchema, FieldSet extensions, UnknownFieldSchema unknownFieldSchema, Object unknownFields) throws IOException {
      int startTag = reader.getTag();
      if (startTag != WireFormat.MESSAGE_SET_ITEM_TAG) {
         if (WireFormat.getTagWireType(startTag) == 2) {
            Object extension = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(startTag));
            if (extension != null) {
               extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension, extensionRegistry, extensions);
               return true;
            } else {
               return unknownFieldSchema.mergeOneFieldFrom(unknownFields, reader);
            }
         } else {
            return reader.skipField();
         }
      } else {
         int typeId = 0;
         ByteString rawBytes = null;
         Object extension = null;

         while(true) {
            int number = reader.getFieldNumber();
            if (number == Integer.MAX_VALUE) {
               break;
            }

            int tag = reader.getTag();
            if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
               typeId = reader.readUInt32();
               extension = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, typeId);
            } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
               if (extension != null) {
                  extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension, extensionRegistry, extensions);
               } else {
                  rawBytes = reader.readBytes();
               }
            } else if (!reader.skipField()) {
               break;
            }
         }

         if (reader.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
         } else {
            if (rawBytes != null) {
               if (extension != null) {
                  extensionSchema.parseMessageSetItem(rawBytes, extension, extensionRegistry, extensions);
               } else {
                  unknownFieldSchema.addLengthDelimited(unknownFields, typeId, rawBytes);
               }
            }

            return true;
         }
      }
   }

   public final boolean isInitialized(Object message) {
      FieldSet extensions = this.extensionSchema.getExtensions(message);
      return extensions.isInitialized();
   }

   public int getSerializedSize(Object message) {
      int size = 0;
      int size = size + this.getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
      if (this.hasExtensions) {
         size += this.extensionSchema.getExtensions(message).getMessageSetSerializedSize();
      }

      return size;
   }

   private int getUnknownFieldsSerializedSize(UnknownFieldSchema schema, Object message) {
      Object unknowns = schema.getFromMessage(message);
      return schema.getSerializedSizeAsMessageSet(unknowns);
   }
}
