package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

class MessageReflection {
   static void writeMessageTo(Message message, Map fields, CodedOutputStream output, boolean alwaysWriteRequiredFields) throws IOException {
      boolean isMessageSet = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
      Iterator var5;
      if (alwaysWriteRequiredFields) {
         fields = new TreeMap((Map)fields);
         var5 = message.getDescriptorForType().getFields().iterator();

         while(var5.hasNext()) {
            Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)var5.next();
            if (field.isRequired() && !((Map)fields).containsKey(field)) {
               ((Map)fields).put(field, message.getField(field));
            }
         }
      }

      var5 = ((Map)fields).entrySet().iterator();

      while(true) {
         while(var5.hasNext()) {
            Entry entry = (Entry)var5.next();
            Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !field.isRepeated()) {
               output.writeMessageSetExtension(field.getNumber(), (Message)value);
            } else {
               FieldSet.writeField(field, value, output);
            }
         }

         UnknownFieldSet unknownFields = message.getUnknownFields();
         if (isMessageSet) {
            unknownFields.writeAsMessageSetTo(output);
         } else {
            unknownFields.writeTo(output);
         }

         return;
      }
   }

   static int getSerializedSize(Message message, Map fields) {
      int size = 0;
      boolean isMessageSet = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
      Iterator var4 = fields.entrySet().iterator();

      while(true) {
         while(var4.hasNext()) {
            Entry entry = (Entry)var4.next();
            Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !field.isRepeated()) {
               size += CodedOutputStream.computeMessageSetExtensionSize(field.getNumber(), (Message)value);
            } else {
               size += FieldSet.computeFieldSize(field, value);
            }
         }

         UnknownFieldSet unknownFields = message.getUnknownFields();
         if (isMessageSet) {
            size += unknownFields.getSerializedSizeAsMessageSet();
         } else {
            size += unknownFields.getSerializedSize();
         }

         return size;
      }
   }

   static String delimitWithCommas(List parts) {
      StringBuilder result = new StringBuilder();

      String part;
      for(Iterator var2 = parts.iterator(); var2.hasNext(); result.append(part)) {
         part = (String)var2.next();
         if (result.length() > 0) {
            result.append(", ");
         }
      }

      return result.toString();
   }

   static boolean isInitialized(MessageOrBuilder message) {
      Iterator var1 = message.getDescriptorForType().getFields().iterator();

      while(var1.hasNext()) {
         Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)var1.next();
         if (field.isRequired() && !message.hasField(field)) {
            return false;
         }
      }

      var1 = message.getAllFields().entrySet().iterator();

      while(true) {
         while(true) {
            Descriptors.FieldDescriptor field;
            Entry entry;
            do {
               if (!var1.hasNext()) {
                  return true;
               }

               entry = (Entry)var1.next();
               field = (Descriptors.FieldDescriptor)entry.getKey();
            } while(field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE);

            if (field.isRepeated()) {
               Iterator var4 = ((List)entry.getValue()).iterator();

               while(var4.hasNext()) {
                  Message element = (Message)var4.next();
                  if (!element.isInitialized()) {
                     return false;
                  }
               }
            } else if (!((Message)entry.getValue()).isInitialized()) {
               return false;
            }
         }
      }
   }

   private static String subMessagePrefix(String prefix, Descriptors.FieldDescriptor field, int index) {
      StringBuilder result = new StringBuilder(prefix);
      if (field.isExtension()) {
         result.append('(').append(field.getFullName()).append(')');
      } else {
         result.append(field.getName());
      }

      if (index != -1) {
         result.append('[').append(index).append(']');
      }

      result.append('.');
      return result.toString();
   }

   private static void findMissingFields(MessageOrBuilder message, String prefix, List results) {
      Iterator var3 = message.getDescriptorForType().getFields().iterator();

      while(var3.hasNext()) {
         Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)var3.next();
         if (field.isRequired() && !message.hasField(field)) {
            results.add(prefix + field.getName());
         }
      }

      var3 = message.getAllFields().entrySet().iterator();

      while(true) {
         while(true) {
            Descriptors.FieldDescriptor field;
            Object value;
            do {
               if (!var3.hasNext()) {
                  return;
               }

               Entry entry = (Entry)var3.next();
               field = (Descriptors.FieldDescriptor)entry.getKey();
               value = entry.getValue();
            } while(field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE);

            if (field.isRepeated()) {
               int i = 0;
               Iterator var8 = ((List)value).iterator();

               while(var8.hasNext()) {
                  Object element = var8.next();
                  findMissingFields((MessageOrBuilder)element, subMessagePrefix(prefix, field, i++), results);
               }
            } else if (message.hasField(field)) {
               findMissingFields((MessageOrBuilder)value, subMessagePrefix(prefix, field, -1), results);
            }
         }
      }
   }

   static List findMissingFields(MessageOrBuilder message) {
      List results = new ArrayList();
      findMissingFields(message, "", results);
      return results;
   }

   static boolean mergeFieldFrom(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MessageReflection.MergeTarget target, int tag) throws IOException {
      if (type.getOptions().getMessageSetWireFormat() && tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
         mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, type, target);
         return true;
      } else {
         int wireType = WireFormat.getTagWireType(tag);
         int fieldNumber = WireFormat.getTagFieldNumber(tag);
         Message defaultInstance = null;
         Descriptors.FieldDescriptor field;
         if (type.isExtensionNumber(fieldNumber)) {
            if (extensionRegistry instanceof ExtensionRegistry) {
               ExtensionRegistry.ExtensionInfo extension = target.findExtensionByNumber((ExtensionRegistry)extensionRegistry, type, fieldNumber);
               if (extension == null) {
                  field = null;
               } else {
                  field = extension.descriptor;
                  defaultInstance = extension.defaultInstance;
                  if (defaultInstance == null && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                     throw new IllegalStateException("Message-typed extension lacked default instance: " + field.getFullName());
                  }
               }
            } else {
               field = null;
            }
         } else if (target.getContainerType() == MessageReflection.MergeTarget.ContainerType.MESSAGE) {
            field = type.findFieldByNumber(fieldNumber);
         } else {
            field = null;
         }

         boolean unknown = false;
         boolean packed = false;
         if (field == null) {
            unknown = true;
         } else if (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), false)) {
            packed = false;
         } else if (field.isPackable() && wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), true)) {
            packed = true;
         } else {
            unknown = true;
         }

         if (unknown) {
            return unknownFields != null ? unknownFields.mergeFieldFrom(tag, input) : input.skipField(tag);
         } else {
            int rawValue;
            if (packed) {
               int length = input.readRawVarint32();
               rawValue = input.pushLimit(length);
               if (field.getLiteType() == WireFormat.FieldType.ENUM) {
                  while(input.getBytesUntilLimit() > 0) {
                     int rawValue = input.readEnum();
                     if (field.getFile().supportsUnknownEnumValue()) {
                        target.addRepeatedField(field, field.getEnumType().findValueByNumberCreatingIfUnknown(rawValue));
                     } else {
                        Object value = field.getEnumType().findValueByNumber(rawValue);
                        if (value == null) {
                           if (unknownFields != null) {
                              unknownFields.mergeVarintField(fieldNumber, rawValue);
                           }
                        } else {
                           target.addRepeatedField(field, value);
                        }
                     }
                  }
               } else {
                  while(input.getBytesUntilLimit() > 0) {
                     Object value = WireFormat.readPrimitiveField(input, field.getLiteType(), target.getUtf8Validation(field));
                     target.addRepeatedField(field, value);
                  }
               }

               input.popLimit(rawValue);
            } else {
               Object value;
               switch(field.getType()) {
               case GROUP:
                  value = target.parseGroup(input, extensionRegistry, field, defaultInstance);
                  break;
               case MESSAGE:
                  value = target.parseMessage(input, extensionRegistry, field, defaultInstance);
                  break;
               case ENUM:
                  rawValue = input.readEnum();
                  if (field.getFile().supportsUnknownEnumValue()) {
                     value = field.getEnumType().findValueByNumberCreatingIfUnknown(rawValue);
                  } else {
                     value = field.getEnumType().findValueByNumber(rawValue);
                     if (value == null) {
                        if (unknownFields != null) {
                           unknownFields.mergeVarintField(fieldNumber, rawValue);
                        }

                        return true;
                     }
                  }
                  break;
               default:
                  value = WireFormat.readPrimitiveField(input, field.getLiteType(), target.getUtf8Validation(field));
               }

               if (field.isRepeated()) {
                  target.addRepeatedField(field, value);
               } else {
                  target.setField(field, value);
               }
            }

            return true;
         }
      }
   }

   private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MessageReflection.MergeTarget target) throws IOException {
      int typeId = 0;
      ByteString rawBytes = null;
      ExtensionRegistry.ExtensionInfo extension = null;

      while(true) {
         int tag = input.readTag();
         if (tag == 0) {
            break;
         }

         if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
            typeId = input.readUInt32();
            if (typeId != 0 && extensionRegistry instanceof ExtensionRegistry) {
               extension = target.findExtensionByNumber((ExtensionRegistry)extensionRegistry, type, typeId);
            }
         } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
            if (typeId != 0 && extension != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
               eagerlyMergeMessageSetExtension(input, extension, extensionRegistry, target);
               rawBytes = null;
            } else {
               rawBytes = input.readBytes();
            }
         } else if (!input.skipField(tag)) {
            break;
         }
      }

      input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
      if (rawBytes != null && typeId != 0) {
         if (extension != null) {
            mergeMessageSetExtensionFromBytes(rawBytes, extension, extensionRegistry, target);
         } else if (rawBytes != null && unknownFields != null) {
            unknownFields.mergeField(typeId, UnknownFieldSet.Field.newBuilder().addLengthDelimited(rawBytes).build());
         }
      }

   }

   private static void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MessageReflection.MergeTarget target) throws IOException {
      Descriptors.FieldDescriptor field = extension.descriptor;
      boolean hasOriginalValue = target.hasField(field);
      if (!hasOriginalValue && !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
         LazyField lazyField = new LazyField(extension.defaultInstance, extensionRegistry, rawBytes);
         target.setField(field, lazyField);
      } else {
         Object value = target.parseMessageFromBytes(rawBytes, extensionRegistry, field, extension.defaultInstance);
         target.setField(field, value);
      }

   }

   private static void eagerlyMergeMessageSetExtension(CodedInputStream input, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MessageReflection.MergeTarget target) throws IOException {
      Descriptors.FieldDescriptor field = extension.descriptor;
      Object value = target.parseMessage(input, extensionRegistry, field, extension.defaultInstance);
      target.setField(field, value);
   }

   static class ExtensionAdapter implements MessageReflection.MergeTarget {
      private final FieldSet extensions;

      ExtensionAdapter(FieldSet extensions) {
         this.extensions = extensions;
      }

      public Descriptors.Descriptor getDescriptorForType() {
         throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
      }

      public Object getField(Descriptors.FieldDescriptor field) {
         return this.extensions.getField(field);
      }

      public boolean hasField(Descriptors.FieldDescriptor field) {
         return this.extensions.hasField(field);
      }

      public MessageReflection.MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
         this.extensions.setField(field, value);
         return this;
      }

      public MessageReflection.MergeTarget clearField(Descriptors.FieldDescriptor field) {
         this.extensions.clearField(field);
         return this;
      }

      public MessageReflection.MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         this.extensions.setRepeatedField(field, index, value);
         return this;
      }

      public MessageReflection.MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         this.extensions.addRepeatedField(field, value);
         return this;
      }

      public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
         return false;
      }

      public MessageReflection.MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
         return this;
      }

      public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
         return null;
      }

      public MessageReflection.MergeTarget.ContainerType getContainerType() {
         return MessageReflection.MergeTarget.ContainerType.EXTENSION_SET;
      }

      public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
         return registry.findImmutableExtensionByName(name);
      }

      public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
         return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
      }

      public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder = defaultInstance.newBuilderForType();
         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         input.readGroup(field.getNumber(), (MessageLite.Builder)subBuilder, registry);
         return subBuilder.buildPartial();
      }

      public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder = defaultInstance.newBuilderForType();
         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         input.readMessage((MessageLite.Builder)subBuilder, registry);
         return subBuilder.buildPartial();
      }

      public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder = defaultInstance.newBuilderForType();
         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         subBuilder.mergeFrom(bytes, registry);
         return subBuilder.buildPartial();
      }

      public MessageReflection.MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
         throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
      }

      public MessageReflection.MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
         throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
      }

      public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
         return descriptor.needsUtf8Check() ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE;
      }

      public Object finish() {
         throw new UnsupportedOperationException("finish() called on FieldSet object");
      }
   }

   static class BuilderAdapter implements MessageReflection.MergeTarget {
      private final Message.Builder builder;

      public Descriptors.Descriptor getDescriptorForType() {
         return this.builder.getDescriptorForType();
      }

      public BuilderAdapter(Message.Builder builder) {
         this.builder = builder;
      }

      public Object getField(Descriptors.FieldDescriptor field) {
         return this.builder.getField(field);
      }

      public boolean hasField(Descriptors.FieldDescriptor field) {
         return this.builder.hasField(field);
      }

      public MessageReflection.MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
         this.builder.setField(field, value);
         return this;
      }

      public MessageReflection.MergeTarget clearField(Descriptors.FieldDescriptor field) {
         this.builder.clearField(field);
         return this;
      }

      public MessageReflection.MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         this.builder.setRepeatedField(field, index, value);
         return this;
      }

      public MessageReflection.MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         this.builder.addRepeatedField(field, value);
         return this;
      }

      public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
         return this.builder.hasOneof(oneof);
      }

      public MessageReflection.MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
         this.builder.clearOneof(oneof);
         return this;
      }

      public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
         return this.builder.getOneofFieldDescriptor(oneof);
      }

      public MessageReflection.MergeTarget.ContainerType getContainerType() {
         return MessageReflection.MergeTarget.ContainerType.MESSAGE;
      }

      public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
         return registry.findImmutableExtensionByName(name);
      }

      public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
         return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
      }

      public Object parseGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder;
         if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
         } else {
            subBuilder = this.builder.newBuilderForField(field);
         }

         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         input.readGroup(field.getNumber(), (MessageLite.Builder)subBuilder, extensionRegistry);
         return subBuilder.buildPartial();
      }

      public Object parseMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder;
         if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
         } else {
            subBuilder = this.builder.newBuilderForField(field);
         }

         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         input.readMessage((MessageLite.Builder)subBuilder, extensionRegistry);
         return subBuilder.buildPartial();
      }

      public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
         Message.Builder subBuilder;
         if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
         } else {
            subBuilder = this.builder.newBuilderForField(field);
         }

         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         subBuilder.mergeFrom(bytes, extensionRegistry);
         return subBuilder.buildPartial();
      }

      public MessageReflection.MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
         Message.Builder subBuilder;
         if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
         } else {
            subBuilder = this.builder.newBuilderForField(field);
         }

         if (!field.isRepeated()) {
            Message originalMessage = (Message)this.getField(field);
            if (originalMessage != null) {
               subBuilder.mergeFrom(originalMessage);
            }
         }

         return new MessageReflection.BuilderAdapter(subBuilder);
      }

      public MessageReflection.MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
         Message.Builder subBuilder;
         if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
         } else {
            subBuilder = this.builder.newBuilderForField(field);
         }

         return new MessageReflection.BuilderAdapter(subBuilder);
      }

      public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
         if (descriptor.needsUtf8Check()) {
            return WireFormat.Utf8Validation.STRICT;
         } else {
            return !descriptor.isRepeated() && this.builder instanceof GeneratedMessage.Builder ? WireFormat.Utf8Validation.LAZY : WireFormat.Utf8Validation.LOOSE;
         }
      }

      public Object finish() {
         return this.builder.buildPartial();
      }
   }

   interface MergeTarget {
      Descriptors.Descriptor getDescriptorForType();

      MessageReflection.MergeTarget.ContainerType getContainerType();

      ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry var1, String var2);

      ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry var1, Descriptors.Descriptor var2, int var3);

      Object getField(Descriptors.FieldDescriptor var1);

      boolean hasField(Descriptors.FieldDescriptor var1);

      MessageReflection.MergeTarget setField(Descriptors.FieldDescriptor var1, Object var2);

      MessageReflection.MergeTarget clearField(Descriptors.FieldDescriptor var1);

      MessageReflection.MergeTarget setRepeatedField(Descriptors.FieldDescriptor var1, int var2, Object var3);

      MessageReflection.MergeTarget addRepeatedField(Descriptors.FieldDescriptor var1, Object var2);

      boolean hasOneof(Descriptors.OneofDescriptor var1);

      MessageReflection.MergeTarget clearOneof(Descriptors.OneofDescriptor var1);

      Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor var1);

      Object parseGroup(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors.FieldDescriptor var3, Message var4) throws IOException;

      Object parseMessage(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors.FieldDescriptor var3, Message var4) throws IOException;

      Object parseMessageFromBytes(ByteString var1, ExtensionRegistryLite var2, Descriptors.FieldDescriptor var3, Message var4) throws IOException;

      WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor var1);

      MessageReflection.MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor var1, Message var2);

      MessageReflection.MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor var1, Message var2);

      Object finish();

      public static enum ContainerType {
         MESSAGE,
         EXTENSION_SET;
      }
   }
}
