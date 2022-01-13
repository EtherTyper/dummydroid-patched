package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public final class MapEntry extends AbstractMessage {
   private final Object key;
   private final Object value;
   private final MapEntry.Metadata metadata;
   private volatile int cachedSerializedSize;

   private MapEntry(Descriptors.Descriptor descriptor, WireFormat.FieldType keyType, Object defaultKey, WireFormat.FieldType valueType, Object defaultValue) {
      this.cachedSerializedSize = -1;
      this.key = defaultKey;
      this.value = defaultValue;
      this.metadata = new MapEntry.Metadata(descriptor, this, keyType, valueType);
   }

   private MapEntry(MapEntry.Metadata metadata, Object key, Object value) {
      this.cachedSerializedSize = -1;
      this.key = key;
      this.value = value;
      this.metadata = metadata;
   }

   private MapEntry(MapEntry.Metadata metadata, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
      this.cachedSerializedSize = -1;

      try {
         this.metadata = metadata;
         Entry entry = MapEntryLite.parseEntry(input, metadata, extensionRegistry);
         this.key = entry.getKey();
         this.value = entry.getValue();
      } catch (InvalidProtocolBufferException var5) {
         throw var5.setUnfinishedMessage(this);
      } catch (IOException var6) {
         throw (new InvalidProtocolBufferException(var6)).setUnfinishedMessage(this);
      }
   }

   public static MapEntry newDefaultInstance(Descriptors.Descriptor descriptor, WireFormat.FieldType keyType, Object defaultKey, WireFormat.FieldType valueType, Object defaultValue) {
      return new MapEntry(descriptor, keyType, defaultKey, valueType, defaultValue);
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public int getSerializedSize() {
      if (this.cachedSerializedSize != -1) {
         return this.cachedSerializedSize;
      } else {
         int size = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
         this.cachedSerializedSize = size;
         return size;
      }
   }

   public void writeTo(CodedOutputStream output) throws IOException {
      MapEntryLite.writeTo(output, this.metadata, this.key, this.value);
   }

   public boolean isInitialized() {
      return isInitialized(this.metadata, this.value);
   }

   public Parser getParserForType() {
      return this.metadata.parser;
   }

   public MapEntry.Builder newBuilderForType() {
      return new MapEntry.Builder(this.metadata);
   }

   public MapEntry.Builder toBuilder() {
      return new MapEntry.Builder(this.metadata, this.key, this.value, true, true);
   }

   public MapEntry getDefaultInstanceForType() {
      return new MapEntry(this.metadata, this.metadata.defaultKey, this.metadata.defaultValue);
   }

   public Descriptors.Descriptor getDescriptorForType() {
      return this.metadata.descriptor;
   }

   public Map getAllFields() {
      TreeMap result = new TreeMap();
      Iterator var2 = this.metadata.descriptor.getFields().iterator();

      while(var2.hasNext()) {
         Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)var2.next();
         if (this.hasField(field)) {
            result.put(field, this.getField(field));
         }
      }

      return Collections.unmodifiableMap(result);
   }

   private void checkFieldDescriptor(Descriptors.FieldDescriptor field) {
      if (field.getContainingType() != this.metadata.descriptor) {
         throw new RuntimeException("Wrong FieldDescriptor \"" + field.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
      }
   }

   public boolean hasField(Descriptors.FieldDescriptor field) {
      this.checkFieldDescriptor(field);
      return true;
   }

   public Object getField(Descriptors.FieldDescriptor field) {
      this.checkFieldDescriptor(field);
      Object result = field.getNumber() == 1 ? this.getKey() : this.getValue();
      if (field.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
         result = field.getEnumType().findValueByNumberCreatingIfUnknown((Integer)result);
      }

      return result;
   }

   public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
      throw new RuntimeException("There is no repeated field in a map entry message.");
   }

   public UnknownFieldSet getUnknownFields() {
      return UnknownFieldSet.getDefaultInstance();
   }

   private static boolean isInitialized(MapEntry.Metadata metadata, Object value) {
      return metadata.valueType.getJavaType() == WireFormat.JavaType.MESSAGE ? ((MessageLite)value).isInitialized() : true;
   }

   final MapEntry.Metadata getMetadata() {
      return this.metadata;
   }

   // $FF: synthetic method
   MapEntry(MapEntry.Metadata x0, CodedInputStream x1, ExtensionRegistryLite x2, Object x3) throws InvalidProtocolBufferException {
      this(x0, x1, x2);
   }

   // $FF: synthetic method
   MapEntry(MapEntry.Metadata x0, Object x1, Object x2, Object x3) {
      this(x0, x1, x2);
   }

   public static class Builder extends AbstractMessage.Builder {
      private final MapEntry.Metadata metadata;
      private Object key;
      private Object value;
      private boolean hasKey;
      private boolean hasValue;

      private Builder(MapEntry.Metadata metadata) {
         this(metadata, metadata.defaultKey, metadata.defaultValue, false, false);
      }

      private Builder(MapEntry.Metadata metadata, Object key, Object value, boolean hasKey, boolean hasValue) {
         this.metadata = metadata;
         this.key = key;
         this.value = value;
         this.hasKey = hasKey;
         this.hasValue = hasValue;
      }

      public Object getKey() {
         return this.key;
      }

      public Object getValue() {
         return this.value;
      }

      public MapEntry.Builder setKey(Object key) {
         this.key = key;
         this.hasKey = true;
         return this;
      }

      public MapEntry.Builder clearKey() {
         this.key = this.metadata.defaultKey;
         this.hasKey = false;
         return this;
      }

      public MapEntry.Builder setValue(Object value) {
         this.value = value;
         this.hasValue = true;
         return this;
      }

      public MapEntry.Builder clearValue() {
         this.value = this.metadata.defaultValue;
         this.hasValue = false;
         return this;
      }

      public MapEntry build() {
         MapEntry result = this.buildPartial();
         if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
         } else {
            return result;
         }
      }

      public MapEntry buildPartial() {
         return new MapEntry(this.metadata, this.key, this.value);
      }

      public Descriptors.Descriptor getDescriptorForType() {
         return this.metadata.descriptor;
      }

      private void checkFieldDescriptor(Descriptors.FieldDescriptor field) {
         if (field.getContainingType() != this.metadata.descriptor) {
            throw new RuntimeException("Wrong FieldDescriptor \"" + field.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
         }
      }

      public Message.Builder newBuilderForField(Descriptors.FieldDescriptor field) {
         this.checkFieldDescriptor(field);
         if (field.getNumber() == 2 && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return ((Message)this.value).newBuilderForType();
         } else {
            throw new RuntimeException("\"" + field.getFullName() + "\" is not a message value field.");
         }
      }

      public MapEntry.Builder setField(Descriptors.FieldDescriptor field, Object value) {
         this.checkFieldDescriptor(field);
         if (field.getNumber() == 1) {
            this.setKey(value);
         } else {
            if (field.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
               value = ((Descriptors.EnumValueDescriptor)value).getNumber();
            } else if (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && value != null && !this.metadata.defaultValue.getClass().isInstance(value)) {
               value = ((Message)this.metadata.defaultValue).toBuilder().mergeFrom((Message)value).build();
            }

            this.setValue(value);
         }

         return this;
      }

      public MapEntry.Builder clearField(Descriptors.FieldDescriptor field) {
         this.checkFieldDescriptor(field);
         if (field.getNumber() == 1) {
            this.clearKey();
         } else {
            this.clearValue();
         }

         return this;
      }

      public MapEntry.Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
         throw new RuntimeException("There is no repeated field in a map entry message.");
      }

      public MapEntry.Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
         throw new RuntimeException("There is no repeated field in a map entry message.");
      }

      public MapEntry.Builder setUnknownFields(UnknownFieldSet unknownFields) {
         return this;
      }

      public MapEntry getDefaultInstanceForType() {
         return new MapEntry(this.metadata, this.metadata.defaultKey, this.metadata.defaultValue);
      }

      public boolean isInitialized() {
         return MapEntry.isInitialized(this.metadata, this.value);
      }

      public Map getAllFields() {
         TreeMap result = new TreeMap();
         Iterator var2 = this.metadata.descriptor.getFields().iterator();

         while(var2.hasNext()) {
            Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)var2.next();
            if (this.hasField(field)) {
               result.put(field, this.getField(field));
            }
         }

         return Collections.unmodifiableMap(result);
      }

      public boolean hasField(Descriptors.FieldDescriptor field) {
         this.checkFieldDescriptor(field);
         return field.getNumber() == 1 ? this.hasKey : this.hasValue;
      }

      public Object getField(Descriptors.FieldDescriptor field) {
         this.checkFieldDescriptor(field);
         Object result = field.getNumber() == 1 ? this.getKey() : this.getValue();
         if (field.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
            result = field.getEnumType().findValueByNumberCreatingIfUnknown((Integer)result);
         }

         return result;
      }

      public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
         throw new RuntimeException("There is no repeated field in a map entry message.");
      }

      public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
         throw new RuntimeException("There is no repeated field in a map entry message.");
      }

      public UnknownFieldSet getUnknownFields() {
         return UnknownFieldSet.getDefaultInstance();
      }

      public MapEntry.Builder clone() {
         return new MapEntry.Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
      }

      // $FF: synthetic method
      Builder(MapEntry.Metadata x0, Object x1) {
         this(x0);
      }

      // $FF: synthetic method
      Builder(MapEntry.Metadata x0, Object x1, Object x2, boolean x3, boolean x4, Object x5) {
         this(x0, x1, x2, x3, x4);
      }
   }

   private static final class Metadata extends MapEntryLite.Metadata {
      public final Descriptors.Descriptor descriptor;
      public final Parser parser;

      public Metadata(Descriptors.Descriptor descriptor, MapEntry defaultInstance, WireFormat.FieldType keyType, WireFormat.FieldType valueType) {
         super(keyType, defaultInstance.key, valueType, defaultInstance.value);
         this.descriptor = descriptor;
         this.parser = new AbstractParser() {
            public MapEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
               return new MapEntry(Metadata.this, input, extensionRegistry);
            }
         };
      }
   }
}
