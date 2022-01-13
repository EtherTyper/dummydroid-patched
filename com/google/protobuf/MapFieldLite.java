package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public final class MapFieldLite extends LinkedHashMap {
   private boolean isMutable = true;
   private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite();

   private MapFieldLite() {
   }

   private MapFieldLite(Map mapData) {
      super(mapData);
   }

   public static MapFieldLite emptyMapField() {
      return EMPTY_MAP_FIELD;
   }

   public void mergeFrom(MapFieldLite other) {
      this.ensureMutable();
      if (!other.isEmpty()) {
         this.putAll(other);
      }

   }

   public Set entrySet() {
      return this.isEmpty() ? Collections.emptySet() : super.entrySet();
   }

   public void clear() {
      this.ensureMutable();
      super.clear();
   }

   public Object put(Object key, Object value) {
      this.ensureMutable();
      Internal.checkNotNull(key);
      Internal.checkNotNull(value);
      return super.put(key, value);
   }

   public Object put(Entry entry) {
      return this.put(entry.getKey(), entry.getValue());
   }

   public void putAll(Map m) {
      this.ensureMutable();
      checkForNullKeysAndValues(m);
      super.putAll(m);
   }

   public Object remove(Object key) {
      this.ensureMutable();
      return super.remove(key);
   }

   private static void checkForNullKeysAndValues(Map m) {
      Iterator var1 = m.keySet().iterator();

      while(var1.hasNext()) {
         Object key = var1.next();
         Internal.checkNotNull(key);
         Internal.checkNotNull(m.get(key));
      }

   }

   private static boolean equals(Object a, Object b) {
      return a instanceof byte[] && b instanceof byte[] ? Arrays.equals((byte[])((byte[])a), (byte[])((byte[])b)) : a.equals(b);
   }

   static boolean equals(Map a, Map b) {
      if (a == b) {
         return true;
      } else if (a.size() != b.size()) {
         return false;
      } else {
         Iterator var2 = a.entrySet().iterator();

         Entry entry;
         do {
            if (!var2.hasNext()) {
               return true;
            }

            entry = (Entry)var2.next();
            if (!b.containsKey(entry.getKey())) {
               return false;
            }
         } while(equals(entry.getValue(), b.get(entry.getKey())));

         return false;
      }
   }

   public boolean equals(Object object) {
      return object instanceof Map && equals((Map)this, (Map)((Map)object));
   }

   private static int calculateHashCodeForObject(Object a) {
      if (a instanceof byte[]) {
         return Internal.hashCode((byte[])((byte[])a));
      } else if (a instanceof Internal.EnumLite) {
         throw new UnsupportedOperationException();
      } else {
         return a.hashCode();
      }
   }

   static int calculateHashCodeForMap(Map a) {
      int result = 0;

      Entry entry;
      for(Iterator var2 = a.entrySet().iterator(); var2.hasNext(); result += calculateHashCodeForObject(entry.getKey()) ^ calculateHashCodeForObject(entry.getValue())) {
         entry = (Entry)var2.next();
      }

      return result;
   }

   public int hashCode() {
      return calculateHashCodeForMap(this);
   }

   private static Object copy(Object object) {
      if (object instanceof byte[]) {
         byte[] data = (byte[])((byte[])object);
         return Arrays.copyOf(data, data.length);
      } else {
         return object;
      }
   }

   static Map copy(Map map) {
      Map result = new LinkedHashMap();
      Iterator var2 = map.entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         result.put(entry.getKey(), copy(entry.getValue()));
      }

      return result;
   }

   public MapFieldLite mutableCopy() {
      return this.isEmpty() ? new MapFieldLite() : new MapFieldLite(this);
   }

   public void makeImmutable() {
      this.isMutable = false;
   }

   public boolean isMutable() {
      return this.isMutable;
   }

   private void ensureMutable() {
      if (!this.isMutable()) {
         throw new UnsupportedOperationException();
      }
   }

   static {
      EMPTY_MAP_FIELD.makeImmutable();
   }
}
