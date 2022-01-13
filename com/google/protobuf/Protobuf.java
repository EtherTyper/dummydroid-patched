package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf {
   private static final Protobuf INSTANCE = new Protobuf();
   private final SchemaFactory schemaFactory = new ManifestSchemaFactory();
   private final ConcurrentMap schemaCache = new ConcurrentHashMap();

   public static Protobuf getInstance() {
      return INSTANCE;
   }

   public void writeTo(Object message, Writer writer) throws IOException {
      this.schemaFor(message).writeTo(message, writer);
   }

   public void mergeFrom(Object message, Reader reader) throws IOException {
      this.mergeFrom(message, reader, ExtensionRegistryLite.getEmptyRegistry());
   }

   public void mergeFrom(Object message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
      this.schemaFor(message).mergeFrom(message, reader, extensionRegistry);
   }

   public void makeImmutable(Object message) {
      this.schemaFor(message).makeImmutable(message);
   }

   public boolean isInitialized(Object message) {
      return this.schemaFor(message).isInitialized(message);
   }

   public Schema schemaFor(Class messageType) {
      Internal.checkNotNull(messageType, "messageType");
      Schema schema = (Schema)this.schemaCache.get(messageType);
      if (schema == null) {
         schema = this.schemaFactory.createSchema(messageType);
         Schema previous = this.registerSchema(messageType, schema);
         if (previous != null) {
            schema = previous;
         }
      }

      return schema;
   }

   public Schema schemaFor(Object message) {
      return this.schemaFor(message.getClass());
   }

   public Schema registerSchema(Class messageType, Schema schema) {
      Internal.checkNotNull(messageType, "messageType");
      Internal.checkNotNull(schema, "schema");
      return (Schema)this.schemaCache.putIfAbsent(messageType, schema);
   }

   public Schema registerSchemaOverride(Class messageType, Schema schema) {
      Internal.checkNotNull(messageType, "messageType");
      Internal.checkNotNull(schema, "schema");
      return (Schema)this.schemaCache.put(messageType, schema);
   }

   private Protobuf() {
   }

   int getTotalSchemaSize() {
      int result = 0;
      Iterator var2 = this.schemaCache.values().iterator();

      while(var2.hasNext()) {
         Schema schema = (Schema)var2.next();
         if (schema instanceof MessageSchema) {
            result += ((MessageSchema)schema).getSchemaSize();
         }
      }

      return result;
   }
}
