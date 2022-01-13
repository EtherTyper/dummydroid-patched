package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapField implements MutabilityOracle {
   private volatile boolean isMutable;
   private volatile MapField.StorageMode mode;
   private MapField.MutatabilityAwareMap mapData;
   private List listData;
   private final MapField.Converter converter;

   private MapField(MapField.Converter converter, MapField.StorageMode mode, Map mapData) {
      this.converter = converter;
      this.isMutable = true;
      this.mode = mode;
      this.mapData = new MapField.MutatabilityAwareMap(this, mapData);
      this.listData = null;
   }

   private MapField(MapEntry defaultEntry, MapField.StorageMode mode, Map mapData) {
      this((MapField.Converter)(new MapField.ImmutableMessageConverter(defaultEntry)), mode, mapData);
   }

   public static MapField emptyMapField(MapEntry defaultEntry) {
      return new MapField(defaultEntry, MapField.StorageMode.MAP, Collections.emptyMap());
   }

   public static MapField newMapField(MapEntry defaultEntry) {
      return new MapField(defaultEntry, MapField.StorageMode.MAP, new LinkedHashMap());
   }

   private Message convertKeyAndValueToMessage(Object key, Object value) {
      return this.converter.convertKeyAndValueToMessage(key, value);
   }

   private void convertMessageToKeyAndValue(Message message, Map map) {
      this.converter.convertMessageToKeyAndValue(message, map);
   }

   private List convertMapToList(MapField.MutatabilityAwareMap mapData) {
      List listData = new ArrayList();
      Iterator var3 = mapData.entrySet().iterator();

      while(var3.hasNext()) {
         Entry entry = (Entry)var3.next();
         listData.add(this.convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
      }

      return listData;
   }

   private MapField.MutatabilityAwareMap convertListToMap(List listData) {
      Map mapData = new LinkedHashMap();
      Iterator var3 = listData.iterator();

      while(var3.hasNext()) {
         Message item = (Message)var3.next();
         this.convertMessageToKeyAndValue(item, mapData);
      }

      return new MapField.MutatabilityAwareMap(this, mapData);
   }

   public Map getMap() {
      if (this.mode == MapField.StorageMode.LIST) {
         synchronized(this) {
            if (this.mode == MapField.StorageMode.LIST) {
               this.mapData = this.convertListToMap(this.listData);
               this.mode = MapField.StorageMode.BOTH;
            }
         }
      }

      return Collections.unmodifiableMap(this.mapData);
   }

   public Map getMutableMap() {
      if (this.mode != MapField.StorageMode.MAP) {
         if (this.mode == MapField.StorageMode.LIST) {
            this.mapData = this.convertListToMap(this.listData);
         }

         this.listData = null;
         this.mode = MapField.StorageMode.MAP;
      }

      return this.mapData;
   }

   public void mergeFrom(MapField other) {
      this.getMutableMap().putAll(MapFieldLite.copy(other.getMap()));
   }

   public void clear() {
      this.mapData = new MapField.MutatabilityAwareMap(this, new LinkedHashMap());
      this.mode = MapField.StorageMode.MAP;
   }

   public boolean equals(Object object) {
      if (!(object instanceof MapField)) {
         return false;
      } else {
         MapField other = (MapField)object;
         return MapFieldLite.equals(this.getMap(), other.getMap());
      }
   }

   public int hashCode() {
      return MapFieldLite.calculateHashCodeForMap(this.getMap());
   }

   public MapField copy() {
      return new MapField(this.converter, MapField.StorageMode.MAP, MapFieldLite.copy(this.getMap()));
   }

   List getList() {
      if (this.mode == MapField.StorageMode.MAP) {
         synchronized(this) {
            if (this.mode == MapField.StorageMode.MAP) {
               this.listData = this.convertMapToList(this.mapData);
               this.mode = MapField.StorageMode.BOTH;
            }
         }
      }

      return Collections.unmodifiableList(this.listData);
   }

   List getMutableList() {
      if (this.mode != MapField.StorageMode.LIST) {
         if (this.mode == MapField.StorageMode.MAP) {
            this.listData = this.convertMapToList(this.mapData);
         }

         this.mapData = null;
         this.mode = MapField.StorageMode.LIST;
      }

      return this.listData;
   }

   Message getMapEntryMessageDefaultInstance() {
      return this.converter.getMessageDefaultInstance();
   }

   public void makeImmutable() {
      this.isMutable = false;
   }

   public boolean isMutable() {
      return this.isMutable;
   }

   public void ensureMutable() {
      if (!this.isMutable()) {
         throw new UnsupportedOperationException();
      }
   }

   private static class MutatabilityAwareMap implements Map {
      private final MutabilityOracle mutabilityOracle;
      private final Map delegate;

      MutatabilityAwareMap(MutabilityOracle mutabilityOracle, Map delegate) {
         this.mutabilityOracle = mutabilityOracle;
         this.delegate = delegate;
      }

      public int size() {
         return this.delegate.size();
      }

      public boolean isEmpty() {
         return this.delegate.isEmpty();
      }

      public boolean containsKey(Object key) {
         return this.delegate.containsKey(key);
      }

      public boolean containsValue(Object value) {
         return this.delegate.containsValue(value);
      }

      public Object get(Object key) {
         return this.delegate.get(key);
      }

      public Object put(Object key, Object value) {
         this.mutabilityOracle.ensureMutable();
         Internal.checkNotNull(key);
         Internal.checkNotNull(value);
         return this.delegate.put(key, value);
      }

      public Object remove(Object key) {
         this.mutabilityOracle.ensureMutable();
         return this.delegate.remove(key);
      }

      public void putAll(Map m) {
         this.mutabilityOracle.ensureMutable();
         Iterator var2 = m.keySet().iterator();

         while(var2.hasNext()) {
            Object key = var2.next();
            Internal.checkNotNull(key);
            Internal.checkNotNull(m.get(key));
         }

         this.delegate.putAll(m);
      }

      public void clear() {
         this.mutabilityOracle.ensureMutable();
         this.delegate.clear();
      }

      public Set keySet() {
         return new MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
      }

      public Collection values() {
         return new MapField.MutatabilityAwareMap.MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
      }

      public Set entrySet() {
         return new MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
      }

      public boolean equals(Object o) {
         return this.delegate.equals(o);
      }

      public int hashCode() {
         return this.delegate.hashCode();
      }

      public String toString() {
         return this.delegate.toString();
      }

      private static class MutatabilityAwareIterator implements Iterator {
         private final MutabilityOracle mutabilityOracle;
         private final Iterator delegate;

         MutatabilityAwareIterator(MutabilityOracle mutabilityOracle, Iterator delegate) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = delegate;
         }

         public boolean hasNext() {
            return this.delegate.hasNext();
         }

         public Object next() {
            return this.delegate.next();
         }

         public void remove() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.remove();
         }

         public boolean equals(Object obj) {
            return this.delegate.equals(obj);
         }

         public int hashCode() {
            return this.delegate.hashCode();
         }

         public String toString() {
            return this.delegate.toString();
         }
      }

      private static class MutatabilityAwareSet implements Set {
         private final MutabilityOracle mutabilityOracle;
         private final Set delegate;

         MutatabilityAwareSet(MutabilityOracle mutabilityOracle, Set delegate) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = delegate;
         }

         public int size() {
            return this.delegate.size();
         }

         public boolean isEmpty() {
            return this.delegate.isEmpty();
         }

         public boolean contains(Object o) {
            return this.delegate.contains(o);
         }

         public Iterator iterator() {
            return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
         }

         public Object[] toArray() {
            return this.delegate.toArray();
         }

         public Object[] toArray(Object[] a) {
            return this.delegate.toArray(a);
         }

         public boolean add(Object e) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.add(e);
         }

         public boolean remove(Object o) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(o);
         }

         public boolean containsAll(Collection c) {
            return this.delegate.containsAll(c);
         }

         public boolean addAll(Collection c) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.addAll(c);
         }

         public boolean retainAll(Collection c) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.retainAll(c);
         }

         public boolean removeAll(Collection c) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.removeAll(c);
         }

         public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
         }

         public boolean equals(Object o) {
            return this.delegate.equals(o);
         }

         public int hashCode() {
            return this.delegate.hashCode();
         }

         public String toString() {
            return this.delegate.toString();
         }
      }

      private static class MutatabilityAwareCollection implements Collection {
         private final MutabilityOracle mutabilityOracle;
         private final Collection delegate;

         MutatabilityAwareCollection(MutabilityOracle mutabilityOracle, Collection delegate) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = delegate;
         }

         public int size() {
            return this.delegate.size();
         }

         public boolean isEmpty() {
            return this.delegate.isEmpty();
         }

         public boolean contains(Object o) {
            return this.delegate.contains(o);
         }

         public Iterator iterator() {
            return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
         }

         public Object[] toArray() {
            return this.delegate.toArray();
         }

         public Object[] toArray(Object[] a) {
            return this.delegate.toArray(a);
         }

         public boolean add(Object e) {
            throw new UnsupportedOperationException();
         }

         public boolean remove(Object o) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(o);
         }

         public boolean containsAll(Collection c) {
            return this.delegate.containsAll(c);
         }

         public boolean addAll(Collection c) {
            throw new UnsupportedOperationException();
         }

         public boolean removeAll(Collection c) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.removeAll(c);
         }

         public boolean retainAll(Collection c) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.retainAll(c);
         }

         public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
         }

         public boolean equals(Object o) {
            return this.delegate.equals(o);
         }

         public int hashCode() {
            return this.delegate.hashCode();
         }

         public String toString() {
            return this.delegate.toString();
         }
      }
   }

   private static class ImmutableMessageConverter implements MapField.Converter {
      private final MapEntry defaultEntry;

      public ImmutableMessageConverter(MapEntry defaultEntry) {
         this.defaultEntry = defaultEntry;
      }

      public Message convertKeyAndValueToMessage(Object key, Object value) {
         return this.defaultEntry.newBuilderForType().setKey(key).setValue(value).buildPartial();
      }

      public void convertMessageToKeyAndValue(Message message, Map map) {
         MapEntry entry = (MapEntry)message;
         map.put(entry.getKey(), entry.getValue());
      }

      public Message getMessageDefaultInstance() {
         return this.defaultEntry;
      }
   }

   private interface Converter {
      Message convertKeyAndValueToMessage(Object var1, Object var2);

      void convertMessageToKeyAndValue(Message var1, Map var2);

      Message getMessageDefaultInstance();
   }

   private static enum StorageMode {
      MAP,
      LIST,
      BOTH;
   }
}
