package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

public class LazyField extends LazyFieldLite {
   private final MessageLite defaultInstance;

   public LazyField(MessageLite defaultInstance, ExtensionRegistryLite extensionRegistry, ByteString bytes) {
      super(extensionRegistry, bytes);
      this.defaultInstance = defaultInstance;
   }

   public boolean containsDefaultInstance() {
      return super.containsDefaultInstance() || this.value == this.defaultInstance;
   }

   public MessageLite getValue() {
      return this.getValue(this.defaultInstance);
   }

   public int hashCode() {
      return this.getValue().hashCode();
   }

   public boolean equals(Object obj) {
      return this.getValue().equals(obj);
   }

   public String toString() {
      return this.getValue().toString();
   }

   static class LazyIterator implements Iterator {
      private Iterator iterator;

      public LazyIterator(Iterator iterator) {
         this.iterator = iterator;
      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public Entry next() {
         Entry entry = (Entry)this.iterator.next();
         return (Entry)(entry.getValue() instanceof LazyField ? new LazyField.LazyEntry(entry) : entry);
      }

      public void remove() {
         this.iterator.remove();
      }
   }

   static class LazyEntry implements Entry {
      private Entry entry;

      private LazyEntry(Entry entry) {
         this.entry = entry;
      }

      public Object getKey() {
         return this.entry.getKey();
      }

      public Object getValue() {
         LazyField field = (LazyField)this.entry.getValue();
         return field == null ? null : field.getValue();
      }

      public LazyField getField() {
         return (LazyField)this.entry.getValue();
      }

      public Object setValue(Object value) {
         if (!(value instanceof MessageLite)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
         } else {
            return ((LazyField)this.entry.getValue()).setValue((MessageLite)value);
         }
      }

      // $FF: synthetic method
      LazyEntry(Entry x0, Object x1) {
         this(x0);
      }
   }
}
