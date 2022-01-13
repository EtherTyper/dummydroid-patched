package com.google.protobuf;

import java.io.IOException;
import java.util.Map.Entry;

abstract class ExtensionSchema {
   abstract boolean hasExtensions(MessageLite var1);

   abstract FieldSet getExtensions(Object var1);

   abstract void setExtensions(Object var1, FieldSet var2);

   abstract FieldSet getMutableExtensions(Object var1);

   abstract void makeImmutable(Object var1);

   abstract Object parseExtension(Reader var1, Object var2, ExtensionRegistryLite var3, FieldSet var4, Object var5, UnknownFieldSchema var6) throws IOException;

   abstract int extensionNumber(Entry var1);

   abstract void serializeExtension(Writer var1, Entry var2) throws IOException;

   abstract Object findExtensionByNumber(ExtensionRegistryLite var1, MessageLite var2, int var3);

   abstract void parseLengthPrefixedMessageSetItem(Reader var1, Object var2, ExtensionRegistryLite var3, FieldSet var4) throws IOException;

   abstract void parseMessageSetItem(ByteString var1, Object var2, ExtensionRegistryLite var3, FieldSet var4) throws IOException;
}
