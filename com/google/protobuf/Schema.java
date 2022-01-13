package com.google.protobuf;

import java.io.IOException;

interface Schema {
   void writeTo(Object var1, Writer var2) throws IOException;

   void mergeFrom(Object var1, Reader var2, ExtensionRegistryLite var3) throws IOException;

   void mergeFrom(Object var1, byte[] var2, int var3, int var4, ArrayDecoders.Registers var5) throws IOException;

   void makeImmutable(Object var1);

   boolean isInitialized(Object var1);

   Object newInstance();

   boolean equals(Object var1, Object var2);

   int hashCode(Object var1);

   void mergeFrom(Object var1, Object var2);

   int getSerializedSize(Object var1);
}
