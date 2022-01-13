package com.google.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface Reader {
   int READ_DONE = Integer.MAX_VALUE;
   int TAG_UNKNOWN = 0;

   boolean shouldDiscardUnknownFields();

   int getFieldNumber() throws IOException;

   int getTag();

   boolean skipField() throws IOException;

   double readDouble() throws IOException;

   float readFloat() throws IOException;

   long readUInt64() throws IOException;

   long readInt64() throws IOException;

   int readInt32() throws IOException;

   long readFixed64() throws IOException;

   int readFixed32() throws IOException;

   boolean readBool() throws IOException;

   String readString() throws IOException;

   String readStringRequireUtf8() throws IOException;

   Object readMessageBySchemaWithCheck(Schema var1, ExtensionRegistryLite var2) throws IOException;

   Object readMessage(Class var1, ExtensionRegistryLite var2) throws IOException;

   /** @deprecated */
   @Deprecated
   Object readGroup(Class var1, ExtensionRegistryLite var2) throws IOException;

   /** @deprecated */
   @Deprecated
   Object readGroupBySchemaWithCheck(Schema var1, ExtensionRegistryLite var2) throws IOException;

   ByteString readBytes() throws IOException;

   int readUInt32() throws IOException;

   int readEnum() throws IOException;

   int readSFixed32() throws IOException;

   long readSFixed64() throws IOException;

   int readSInt32() throws IOException;

   long readSInt64() throws IOException;

   void readDoubleList(List var1) throws IOException;

   void readFloatList(List var1) throws IOException;

   void readUInt64List(List var1) throws IOException;

   void readInt64List(List var1) throws IOException;

   void readInt32List(List var1) throws IOException;

   void readFixed64List(List var1) throws IOException;

   void readFixed32List(List var1) throws IOException;

   void readBoolList(List var1) throws IOException;

   void readStringList(List var1) throws IOException;

   void readStringListRequireUtf8(List var1) throws IOException;

   void readMessageList(List var1, Schema var2, ExtensionRegistryLite var3) throws IOException;

   void readMessageList(List var1, Class var2, ExtensionRegistryLite var3) throws IOException;

   /** @deprecated */
   @Deprecated
   void readGroupList(List var1, Class var2, ExtensionRegistryLite var3) throws IOException;

   /** @deprecated */
   @Deprecated
   void readGroupList(List var1, Schema var2, ExtensionRegistryLite var3) throws IOException;

   void readBytesList(List var1) throws IOException;

   void readUInt32List(List var1) throws IOException;

   void readEnumList(List var1) throws IOException;

   void readSFixed32List(List var1) throws IOException;

   void readSFixed64List(List var1) throws IOException;

   void readSInt32List(List var1) throws IOException;

   void readSInt64List(List var1) throws IOException;

   void readMap(Map var1, MapEntryLite.Metadata var2, ExtensionRegistryLite var3) throws IOException;
}
