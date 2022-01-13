package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public interface Message extends MessageLite, MessageOrBuilder {
   Parser getParserForType();

   boolean equals(Object var1);

   int hashCode();

   String toString();

   Message.Builder newBuilderForType();

   Message.Builder toBuilder();

   public interface Builder extends MessageLite.Builder, MessageOrBuilder {
      Message.Builder clear();

      Message.Builder mergeFrom(Message var1);

      Message build();

      Message buildPartial();

      Message.Builder clone();

      Message.Builder mergeFrom(CodedInputStream var1) throws IOException;

      Message.Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) throws IOException;

      Descriptors.Descriptor getDescriptorForType();

      Message.Builder newBuilderForField(Descriptors.FieldDescriptor var1);

      Message.Builder getFieldBuilder(Descriptors.FieldDescriptor var1);

      Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor var1, int var2);

      Message.Builder setField(Descriptors.FieldDescriptor var1, Object var2);

      Message.Builder clearField(Descriptors.FieldDescriptor var1);

      Message.Builder clearOneof(Descriptors.OneofDescriptor var1);

      Message.Builder setRepeatedField(Descriptors.FieldDescriptor var1, int var2, Object var3);

      Message.Builder addRepeatedField(Descriptors.FieldDescriptor var1, Object var2);

      Message.Builder setUnknownFields(UnknownFieldSet var1);

      Message.Builder mergeUnknownFields(UnknownFieldSet var1);

      Message.Builder mergeFrom(ByteString var1) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(byte[] var1) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(byte[] var1, int var2, int var3) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4) throws InvalidProtocolBufferException;

      Message.Builder mergeFrom(InputStream var1) throws IOException;

      Message.Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2) throws IOException;

      boolean mergeDelimitedFrom(InputStream var1) throws IOException;

      boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2) throws IOException;
   }
}
