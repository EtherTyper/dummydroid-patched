package com.google.protobuf;

import java.util.List;
import java.util.Map;

public interface MessageOrBuilder extends MessageLiteOrBuilder {
   Message getDefaultInstanceForType();

   List findInitializationErrors();

   String getInitializationErrorString();

   Descriptors.Descriptor getDescriptorForType();

   Map getAllFields();

   boolean hasOneof(Descriptors.OneofDescriptor var1);

   Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor var1);

   boolean hasField(Descriptors.FieldDescriptor var1);

   Object getField(Descriptors.FieldDescriptor var1);

   int getRepeatedFieldCount(Descriptors.FieldDescriptor var1);

   Object getRepeatedField(Descriptors.FieldDescriptor var1, int var2);

   UnknownFieldSet getUnknownFields();
}
