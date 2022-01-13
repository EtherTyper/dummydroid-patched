package com.google.protobuf;

import java.io.IOException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class MapEntryLite {
   private static final int KEY_FIELD_NUMBER = 1;
   private static final int VALUE_FIELD_NUMBER = 2;
   private final MapEntryLite.Metadata metadata;
   private final Object key;
   private final Object value;

   private MapEntryLite(WireFormat.FieldType keyType, Object defaultKey, WireFormat.FieldType valueType, Object defaultValue) {
      this.metadata = new MapEntryLite.Metadata(keyType, defaultKey, valueType, defaultValue);
      this.key = defaultKey;
      this.value = defaultValue;
   }

   private MapEntryLite(MapEntryLite.Metadata metadata, Object key, Object value) {
      this.metadata = metadata;
      this.key = key;
      this.value = value;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public static MapEntryLite newDefaultInstance(WireFormat.FieldType keyType, Object defaultKey, WireFormat.FieldType valueType, Object defaultValue) {
      return new MapEntryLite(keyType, defaultKey, valueType, defaultValue);
   }

   static void writeTo(CodedOutputStream output, MapEntryLite.Metadata metadata, Object key, Object value) throws IOException {
      FieldSet.writeElement(output, metadata.keyType, 1, key);
      FieldSet.writeElement(output, metadata.valueType, 2, value);
   }

   static int computeSerializedSize(MapEntryLite.Metadata metadata, Object key, Object value) {
      return FieldSet.computeElementSize(metadata.keyType, 1, key) + FieldSet.computeElementSize(metadata.valueType, 2, value);
   }

   static Object parseField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, WireFormat.FieldType type, Object value) throws IOException {
      switch(type) {
      case MESSAGE:
         MessageLite.Builder subBuilder = ((MessageLite)value).toBuilder();
         input.readMessage(subBuilder, extensionRegistry);
         return subBuilder.buildPartial();
      case ENUM:
         return input.readEnum();
      case GROUP:
         throw new RuntimeException("Groups are not allowed in maps.");
      default:
         return FieldSet.readPrimitiveField(input, type, true);
      }
   }

   public void serializeTo(CodedOutputStream output, int fieldNumber, Object key, Object value) throws IOException {
      output.writeTag(fieldNumber, 2);
      output.writeUInt32NoTag(computeSerializedSize(this.metadata, key, value));
      writeTo(output, this.metadata, key, value);
   }

   public int computeMessageSize(int fieldNumber, Object key, Object value) {
      return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, key, value));
   }

   public Entry parseEntry(ByteString bytes, ExtensionRegistryLite extensionRegistry) throws IOException {
      return parseEntry(bytes.newCodedInput(), this.metadata, extensionRegistry);
   }

   static Entry parseEntry(CodedInputStream input, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
      Object key = metadata.defaultKey;
      Object value = metadata.defaultValue;

      while(true) {
         int tag = input.readTag();
         if (tag == 0) {
            break;
         }

         if (tag == WireFormat.makeTag(1, metadata.keyType.getWireType())) {
            key = parseField(input, extensionRegistry, metadata.keyType, key);
         } else if (tag == WireFormat.makeTag(2, metadata.valueType.getWireType())) {
            value = parseField(input, extensionRegistry, metadata.valueType, value);
         } else if (!input.skipField(tag)) {
            break;
         }
      }

      return new SimpleImmutableEntry(key, value);
   }

   public void parseInto(MapFieldLite map, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
      int length = input.readRawVarint32();
      int oldLimit = input.pushLimit(length);
      Object key = this.metadata.defaultKey;
      Object value = this.metadata.defaultValue;

      while(true) {
         int tag = input.readTag();
         if (tag == 0) {
            break;
         }

         if (tag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
            key = parseField(input, extensionRegistry, this.metadata.keyType, key);
         } else if (tag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
            value = parseField(input, extensionRegistry, this.metadata.valueType, value);
         } else if (!input.skipField(tag)) {
            break;
         }
      }

      input.checkLastTagWas(0);
      input.popLimit(oldLimit);
      map.put(key, value);
   }

   MapEntryLite.Metadata getMetadata() {
      return this.metadata;
   }

   static class Metadata {
      public final WireFormat.FieldType keyType;
      public final Object defaultKey;
      public final WireFormat.FieldType valueType;
      public final Object defaultValue;

      public Metadata(WireFormat.FieldType keyType, Object defaultKey, WireFormat.FieldType valueType, Object defaultValue) {
         this.keyType = keyType;
         this.defaultKey = defaultKey;
         this.valueType = valueType;
         this.defaultValue = defaultValue;
      }
   }
}
