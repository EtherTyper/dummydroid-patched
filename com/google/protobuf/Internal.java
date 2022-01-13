package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.Map.Entry;

public final class Internal {
   static final Charset UTF_8 = Charset.forName("UTF-8");
   static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
   private static final int DEFAULT_BUFFER_SIZE = 4096;
   public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
   public static final ByteBuffer EMPTY_BYTE_BUFFER;
   public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;

   private Internal() {
   }

   static Object checkNotNull(Object obj) {
      if (obj == null) {
         throw new NullPointerException();
      } else {
         return obj;
      }
   }

   static Object checkNotNull(Object obj, String message) {
      if (obj == null) {
         throw new NullPointerException(message);
      } else {
         return obj;
      }
   }

   public static String stringDefaultValue(String bytes) {
      return new String(bytes.getBytes(ISO_8859_1), UTF_8);
   }

   public static ByteString bytesDefaultValue(String bytes) {
      return ByteString.copyFrom(bytes.getBytes(ISO_8859_1));
   }

   public static byte[] byteArrayDefaultValue(String bytes) {
      return bytes.getBytes(ISO_8859_1);
   }

   public static ByteBuffer byteBufferDefaultValue(String bytes) {
      return ByteBuffer.wrap(byteArrayDefaultValue(bytes));
   }

   public static ByteBuffer copyByteBuffer(ByteBuffer source) {
      ByteBuffer temp = source.duplicate();
      temp.clear();
      ByteBuffer result = ByteBuffer.allocate(temp.capacity());
      result.put(temp);
      result.clear();
      return result;
   }

   public static boolean isValidUtf8(ByteString byteString) {
      return byteString.isValidUtf8();
   }

   public static boolean isValidUtf8(byte[] byteArray) {
      return Utf8.isValidUtf8(byteArray);
   }

   public static byte[] toByteArray(String value) {
      return value.getBytes(UTF_8);
   }

   public static String toStringUtf8(byte[] bytes) {
      return new String(bytes, UTF_8);
   }

   public static int hashLong(long n) {
      return (int)(n ^ n >>> 32);
   }

   public static int hashBoolean(boolean b) {
      return b ? 1231 : 1237;
   }

   public static int hashEnum(Internal.EnumLite e) {
      return e.getNumber();
   }

   public static int hashEnumList(List list) {
      int hash = 1;

      Internal.EnumLite e;
      for(Iterator var2 = list.iterator(); var2.hasNext(); hash = 31 * hash + hashEnum(e)) {
         e = (Internal.EnumLite)var2.next();
      }

      return hash;
   }

   public static boolean equals(List a, List b) {
      if (a.size() != b.size()) {
         return false;
      } else {
         for(int i = 0; i < a.size(); ++i) {
            if (!Arrays.equals((byte[])a.get(i), (byte[])b.get(i))) {
               return false;
            }
         }

         return true;
      }
   }

   public static int hashCode(List list) {
      int hash = 1;

      byte[] bytes;
      for(Iterator var2 = list.iterator(); var2.hasNext(); hash = 31 * hash + hashCode(bytes)) {
         bytes = (byte[])var2.next();
      }

      return hash;
   }

   public static int hashCode(byte[] bytes) {
      return hashCode(bytes, 0, bytes.length);
   }

   static int hashCode(byte[] bytes, int offset, int length) {
      int h = partialHash(length, bytes, offset, length);
      return h == 0 ? 1 : h;
   }

   static int partialHash(int h, byte[] bytes, int offset, int length) {
      for(int i = offset; i < offset + length; ++i) {
         h = h * 31 + bytes[i];
      }

      return h;
   }

   public static boolean equalsByteBuffer(ByteBuffer a, ByteBuffer b) {
      return a.capacity() != b.capacity() ? false : a.duplicate().clear().equals(b.duplicate().clear());
   }

   public static boolean equalsByteBuffer(List a, List b) {
      if (a.size() != b.size()) {
         return false;
      } else {
         for(int i = 0; i < a.size(); ++i) {
            if (!equalsByteBuffer((ByteBuffer)a.get(i), (ByteBuffer)b.get(i))) {
               return false;
            }
         }

         return true;
      }
   }

   public static int hashCodeByteBuffer(List list) {
      int hash = 1;

      ByteBuffer bytes;
      for(Iterator var2 = list.iterator(); var2.hasNext(); hash = 31 * hash + hashCodeByteBuffer(bytes)) {
         bytes = (ByteBuffer)var2.next();
      }

      return hash;
   }

   public static int hashCodeByteBuffer(ByteBuffer bytes) {
      int bufferSize;
      if (bytes.hasArray()) {
         bufferSize = partialHash(bytes.capacity(), bytes.array(), bytes.arrayOffset(), bytes.capacity());
         return bufferSize == 0 ? 1 : bufferSize;
      } else {
         bufferSize = bytes.capacity() > 4096 ? 4096 : bytes.capacity();
         byte[] buffer = new byte[bufferSize];
         ByteBuffer duplicated = bytes.duplicate();
         duplicated.clear();

         int h;
         int length;
         for(h = bytes.capacity(); duplicated.remaining() > 0; h = partialHash(h, buffer, 0, length)) {
            length = duplicated.remaining() <= bufferSize ? duplicated.remaining() : bufferSize;
            duplicated.get(buffer, 0, length);
         }

         return h == 0 ? 1 : h;
      }
   }

   public static MessageLite getDefaultInstance(Class clazz) {
      try {
         Method method = clazz.getMethod("getDefaultInstance");
         return (MessageLite)method.invoke(method);
      } catch (Exception var2) {
         throw new RuntimeException("Failed to get default instance for " + clazz, var2);
      }
   }

   static Object mergeMessage(Object destination, Object source) {
      return ((MessageLite)destination).toBuilder().mergeFrom((MessageLite)source).buildPartial();
   }

   static {
      EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
      EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);
   }

   public interface FloatList extends Internal.ProtobufList {
      float getFloat(int var1);

      void addFloat(float var1);

      float setFloat(int var1, float var2);

      Internal.FloatList mutableCopyWithCapacity(int var1);
   }

   public interface DoubleList extends Internal.ProtobufList {
      double getDouble(int var1);

      void addDouble(double var1);

      double setDouble(int var1, double var2);

      Internal.DoubleList mutableCopyWithCapacity(int var1);
   }

   public interface LongList extends Internal.ProtobufList {
      long getLong(int var1);

      void addLong(long var1);

      long setLong(int var1, long var2);

      Internal.LongList mutableCopyWithCapacity(int var1);
   }

   public interface BooleanList extends Internal.ProtobufList {
      boolean getBoolean(int var1);

      void addBoolean(boolean var1);

      boolean setBoolean(int var1, boolean var2);

      Internal.BooleanList mutableCopyWithCapacity(int var1);
   }

   public interface IntList extends Internal.ProtobufList {
      int getInt(int var1);

      void addInt(int var1);

      int setInt(int var1, int var2);

      Internal.IntList mutableCopyWithCapacity(int var1);
   }

   public interface ProtobufList extends List, RandomAccess {
      void makeImmutable();

      boolean isModifiable();

      Internal.ProtobufList mutableCopyWithCapacity(int var1);
   }

   public static class MapAdapter extends AbstractMap {
      private final Map realMap;
      private final Internal.MapAdapter.Converter valueConverter;

      public static Internal.MapAdapter.Converter newEnumConverter(final Internal.EnumLiteMap enumMap, final Internal.EnumLite unrecognizedValue) {
         return new Internal.MapAdapter.Converter() {
            public Internal.EnumLite doForward(Integer value) {
               Internal.EnumLite result = enumMap.findValueByNumber(value);
               return result == null ? unrecognizedValue : result;
            }

            public Integer doBackward(Internal.EnumLite value) {
               return value.getNumber();
            }
         };
      }

      public MapAdapter(Map realMap, Internal.MapAdapter.Converter valueConverter) {
         this.realMap = realMap;
         this.valueConverter = valueConverter;
      }

      public Object get(Object key) {
         Object result = this.realMap.get(key);
         return result == null ? null : this.valueConverter.doForward(result);
      }

      public Object put(Object key, Object value) {
         Object oldValue = this.realMap.put(key, this.valueConverter.doBackward(value));
         return oldValue == null ? null : this.valueConverter.doForward(oldValue);
      }

      public Set entrySet() {
         return new Internal.MapAdapter.SetAdapter(this.realMap.entrySet());
      }

      private class EntryAdapter implements Entry {
         private final Entry realEntry;

         public EntryAdapter(Entry realEntry) {
            this.realEntry = realEntry;
         }

         public Object getKey() {
            return this.realEntry.getKey();
         }

         public Object getValue() {
            return MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
         }

         public Object setValue(Object value) {
            Object oldValue = this.realEntry.setValue(MapAdapter.this.valueConverter.doBackward(value));
            return oldValue == null ? null : MapAdapter.this.valueConverter.doForward(oldValue);
         }

         public boolean equals(Object o) {
            if (o == this) {
               return true;
            } else if (!(o instanceof Entry)) {
               return false;
            } else {
               Entry other = (Entry)o;
               return this.getKey().equals(other.getKey()) && this.getValue().equals(this.getValue());
            }
         }

         public int hashCode() {
            return this.realEntry.hashCode();
         }
      }

      private class IteratorAdapter implements Iterator {
         private final Iterator realIterator;

         public IteratorAdapter(Iterator realIterator) {
            this.realIterator = realIterator;
         }

         public boolean hasNext() {
            return this.realIterator.hasNext();
         }

         public Entry next() {
            return MapAdapter.this.new EntryAdapter((Entry)this.realIterator.next());
         }

         public void remove() {
            this.realIterator.remove();
         }
      }

      private class SetAdapter extends AbstractSet {
         private final Set realSet;

         public SetAdapter(Set realSet) {
            this.realSet = realSet;
         }

         public Iterator iterator() {
            return MapAdapter.this.new IteratorAdapter(this.realSet.iterator());
         }

         public int size() {
            return this.realSet.size();
         }
      }

      public interface Converter {
         Object doForward(Object var1);

         Object doBackward(Object var1);
      }
   }

   public static class ListAdapter extends AbstractList {
      private final List fromList;
      private final Internal.ListAdapter.Converter converter;

      public ListAdapter(List fromList, Internal.ListAdapter.Converter converter) {
         this.fromList = fromList;
         this.converter = converter;
      }

      public Object get(int index) {
         return this.converter.convert(this.fromList.get(index));
      }

      public int size() {
         return this.fromList.size();
      }

      public interface Converter {
         Object convert(Object var1);
      }
   }

   public interface EnumVerifier {
      boolean isInRange(int var1);
   }

   public interface EnumLiteMap {
      Internal.EnumLite findValueByNumber(int var1);
   }

   public interface EnumLite {
      int getNumber();
   }
}
