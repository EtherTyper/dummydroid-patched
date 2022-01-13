package com.google.protobuf;

import java.lang.reflect.Field;

final class FieldInfo implements Comparable {
   private final Field field;
   private final FieldType type;
   private final Class messageClass;
   private final int fieldNumber;
   private final Field presenceField;
   private final int presenceMask;
   private final boolean required;
   private final boolean enforceUtf8;
   private final OneofInfo oneof;
   private final Field cachedSizeField;
   private final Class oneofStoredType;
   private final Object mapDefaultEntry;
   private final Internal.EnumVerifier enumVerifier;

   public static FieldInfo forField(Field field, int fieldNumber, FieldType fieldType, boolean enforceUtf8) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      Internal.checkNotNull(fieldType, "fieldType");
      if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
         return new FieldInfo(field, fieldNumber, fieldType, (Class)null, (Field)null, 0, false, enforceUtf8, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, (Field)null);
      } else {
         throw new IllegalStateException("Shouldn't be called for repeated message fields.");
      }
   }

   public static FieldInfo forPackedField(Field field, int fieldNumber, FieldType fieldType, Field cachedSizeField) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      Internal.checkNotNull(fieldType, "fieldType");
      if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
         return new FieldInfo(field, fieldNumber, fieldType, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, cachedSizeField);
      } else {
         throw new IllegalStateException("Shouldn't be called for repeated message fields.");
      }
   }

   public static FieldInfo forRepeatedMessageField(Field field, int fieldNumber, FieldType fieldType, Class messageClass) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      Internal.checkNotNull(fieldType, "fieldType");
      Internal.checkNotNull(messageClass, "messageClass");
      return new FieldInfo(field, fieldNumber, fieldType, messageClass, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, (Field)null);
   }

   public static FieldInfo forFieldWithEnumVerifier(Field field, int fieldNumber, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      return new FieldInfo(field, fieldNumber, fieldType, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, enumVerifier, (Field)null);
   }

   public static FieldInfo forPackedFieldWithEnumVerifier(Field field, int fieldNumber, FieldType fieldType, Internal.EnumVerifier enumVerifier, Field cachedSizeField) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      return new FieldInfo(field, fieldNumber, fieldType, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, enumVerifier, cachedSizeField);
   }

   public static FieldInfo forProto2OptionalField(Field field, int fieldNumber, FieldType fieldType, Field presenceField, int presenceMask, boolean enforceUtf8, Internal.EnumVerifier enumVerifier) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      Internal.checkNotNull(fieldType, "fieldType");
      Internal.checkNotNull(presenceField, "presenceField");
      if (presenceField != null && !isExactlyOneBitSet(presenceMask)) {
         throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + presenceMask);
      } else {
         return new FieldInfo(field, fieldNumber, fieldType, (Class)null, presenceField, presenceMask, false, enforceUtf8, (OneofInfo)null, (Class)null, (Object)null, enumVerifier, (Field)null);
      }
   }

   public static FieldInfo forOneofMemberField(int fieldNumber, FieldType fieldType, OneofInfo oneof, Class oneofStoredType, boolean enforceUtf8, Internal.EnumVerifier enumVerifier) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(fieldType, "fieldType");
      Internal.checkNotNull(oneof, "oneof");
      Internal.checkNotNull(oneofStoredType, "oneofStoredType");
      if (!fieldType.isScalar()) {
         throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + fieldNumber + " is of type " + fieldType);
      } else {
         return new FieldInfo((Field)null, fieldNumber, fieldType, (Class)null, (Field)null, 0, false, enforceUtf8, oneof, oneofStoredType, (Object)null, enumVerifier, (Field)null);
      }
   }

   private static void checkFieldNumber(int fieldNumber) {
      if (fieldNumber <= 0) {
         throw new IllegalArgumentException("fieldNumber must be positive: " + fieldNumber);
      }
   }

   public static FieldInfo forProto2RequiredField(Field field, int fieldNumber, FieldType fieldType, Field presenceField, int presenceMask, boolean enforceUtf8, Internal.EnumVerifier enumVerifier) {
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      Internal.checkNotNull(fieldType, "fieldType");
      Internal.checkNotNull(presenceField, "presenceField");
      if (presenceField != null && !isExactlyOneBitSet(presenceMask)) {
         throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + presenceMask);
      } else {
         return new FieldInfo(field, fieldNumber, fieldType, (Class)null, presenceField, presenceMask, true, enforceUtf8, (OneofInfo)null, (Class)null, (Object)null, enumVerifier, (Field)null);
      }
   }

   public static FieldInfo forMapField(Field field, int fieldNumber, Object mapDefaultEntry, Internal.EnumVerifier enumVerifier) {
      Internal.checkNotNull(mapDefaultEntry, "mapDefaultEntry");
      checkFieldNumber(fieldNumber);
      Internal.checkNotNull(field, "field");
      return new FieldInfo(field, fieldNumber, FieldType.MAP, (Class)null, (Field)null, 0, false, true, (OneofInfo)null, (Class)null, mapDefaultEntry, enumVerifier, (Field)null);
   }

   private FieldInfo(Field field, int fieldNumber, FieldType type, Class messageClass, Field presenceField, int presenceMask, boolean required, boolean enforceUtf8, OneofInfo oneof, Class oneofStoredType, Object mapDefaultEntry, Internal.EnumVerifier enumVerifier, Field cachedSizeField) {
      this.field = field;
      this.type = type;
      this.messageClass = messageClass;
      this.fieldNumber = fieldNumber;
      this.presenceField = presenceField;
      this.presenceMask = presenceMask;
      this.required = required;
      this.enforceUtf8 = enforceUtf8;
      this.oneof = oneof;
      this.oneofStoredType = oneofStoredType;
      this.mapDefaultEntry = mapDefaultEntry;
      this.enumVerifier = enumVerifier;
      this.cachedSizeField = cachedSizeField;
   }

   public int getFieldNumber() {
      return this.fieldNumber;
   }

   public Field getField() {
      return this.field;
   }

   public FieldType getType() {
      return this.type;
   }

   public OneofInfo getOneof() {
      return this.oneof;
   }

   public Class getOneofStoredType() {
      return this.oneofStoredType;
   }

   public Internal.EnumVerifier getEnumVerifier() {
      return this.enumVerifier;
   }

   public int compareTo(FieldInfo o) {
      return this.fieldNumber - o.fieldNumber;
   }

   public Class getListElementType() {
      return this.messageClass;
   }

   public Field getPresenceField() {
      return this.presenceField;
   }

   public Object getMapDefaultEntry() {
      return this.mapDefaultEntry;
   }

   public int getPresenceMask() {
      return this.presenceMask;
   }

   public boolean isRequired() {
      return this.required;
   }

   public boolean isEnforceUtf8() {
      return this.enforceUtf8;
   }

   public Field getCachedSizeField() {
      return this.cachedSizeField;
   }

   public Class getMessageFieldClass() {
      switch(this.type) {
      case MESSAGE:
      case GROUP:
         return this.field != null ? this.field.getType() : this.oneofStoredType;
      case MESSAGE_LIST:
      case GROUP_LIST:
         return this.messageClass;
      default:
         return null;
      }
   }

   public static FieldInfo.Builder newBuilder() {
      return new FieldInfo.Builder();
   }

   private static boolean isExactlyOneBitSet(int value) {
      return value != 0 && (value & value - 1) == 0;
   }

   public static final class Builder {
      private Field field;
      private FieldType type;
      private int fieldNumber;
      private Field presenceField;
      private int presenceMask;
      private boolean required;
      private boolean enforceUtf8;
      private OneofInfo oneof;
      private Class oneofStoredType;
      private Object mapDefaultEntry;
      private Internal.EnumVerifier enumVerifier;
      private Field cachedSizeField;

      private Builder() {
      }

      public FieldInfo.Builder withField(Field field) {
         if (this.oneof != null) {
            throw new IllegalStateException("Cannot set field when building a oneof.");
         } else {
            this.field = field;
            return this;
         }
      }

      public FieldInfo.Builder withType(FieldType type) {
         this.type = type;
         return this;
      }

      public FieldInfo.Builder withFieldNumber(int fieldNumber) {
         this.fieldNumber = fieldNumber;
         return this;
      }

      public FieldInfo.Builder withPresence(Field presenceField, int presenceMask) {
         this.presenceField = (Field)Internal.checkNotNull(presenceField, "presenceField");
         this.presenceMask = presenceMask;
         return this;
      }

      public FieldInfo.Builder withOneof(OneofInfo oneof, Class oneofStoredType) {
         if (this.field == null && this.presenceField == null) {
            this.oneof = oneof;
            this.oneofStoredType = oneofStoredType;
            return this;
         } else {
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
         }
      }

      public FieldInfo.Builder withRequired(boolean required) {
         this.required = required;
         return this;
      }

      public FieldInfo.Builder withMapDefaultEntry(Object mapDefaultEntry) {
         this.mapDefaultEntry = mapDefaultEntry;
         return this;
      }

      public FieldInfo.Builder withEnforceUtf8(boolean enforceUtf8) {
         this.enforceUtf8 = enforceUtf8;
         return this;
      }

      public FieldInfo.Builder withEnumVerifier(Internal.EnumVerifier enumVerifier) {
         this.enumVerifier = enumVerifier;
         return this;
      }

      public FieldInfo.Builder withCachedSizeField(Field cachedSizeField) {
         this.cachedSizeField = cachedSizeField;
         return this;
      }

      public FieldInfo build() {
         if (this.oneof != null) {
            return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, this.oneof, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
         } else if (this.mapDefaultEntry != null) {
            return FieldInfo.forMapField(this.field, this.fieldNumber, this.mapDefaultEntry, this.enumVerifier);
         } else if (this.presenceField != null) {
            return this.required ? FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, this.presenceField, this.presenceMask, this.enforceUtf8, this.enumVerifier) : FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, this.presenceField, this.presenceMask, this.enforceUtf8, this.enumVerifier);
         } else if (this.enumVerifier != null) {
            return this.cachedSizeField == null ? FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, this.enumVerifier) : FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, this.enumVerifier, this.cachedSizeField);
         } else {
            return this.cachedSizeField == null ? FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8) : FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, this.cachedSizeField);
         }
      }

      // $FF: synthetic method
      Builder(Object x0) {
         this();
      }
   }
}
