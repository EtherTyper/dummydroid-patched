package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList extends AbstractProtobufList implements RandomAccess {
   private static final ProtobufArrayList EMPTY_LIST = new ProtobufArrayList(new Object[0], 0);
   private Object[] array;
   private int size;

   public static ProtobufArrayList emptyList() {
      return EMPTY_LIST;
   }

   ProtobufArrayList() {
      this((Object[])(new Object[10]), 0);
   }

   private ProtobufArrayList(Object[] array, int size) {
      this.array = array;
      this.size = size;
   }

   public ProtobufArrayList mutableCopyWithCapacity(int capacity) {
      if (capacity < this.size) {
         throw new IllegalArgumentException();
      } else {
         Object[] newArray = Arrays.copyOf(this.array, capacity);
         return new ProtobufArrayList(newArray, this.size);
      }
   }

   public boolean add(Object element) {
      this.ensureIsMutable();
      if (this.size == this.array.length) {
         int length = this.size * 3 / 2 + 1;
         Object[] newArray = Arrays.copyOf(this.array, length);
         this.array = newArray;
      }

      this.array[this.size++] = element;
      ++this.modCount;
      return true;
   }

   public void add(int index, Object element) {
      this.ensureIsMutable();
      if (index >= 0 && index <= this.size) {
         if (this.size < this.array.length) {
            System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
         } else {
            int length = this.size * 3 / 2 + 1;
            Object[] newArray = createArray(length);
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index, newArray, index + 1, this.size - index);
            this.array = newArray;
         }

         this.array[index] = element;
         ++this.size;
         ++this.modCount;
      } else {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(index));
      }
   }

   public Object get(int index) {
      this.ensureIndexInRange(index);
      return this.array[index];
   }

   public Object remove(int index) {
      this.ensureIsMutable();
      this.ensureIndexInRange(index);
      Object value = this.array[index];
      if (index < this.size - 1) {
         System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
      }

      --this.size;
      ++this.modCount;
      return value;
   }

   public Object set(int index, Object element) {
      this.ensureIsMutable();
      this.ensureIndexInRange(index);
      Object toReturn = this.array[index];
      this.array[index] = element;
      ++this.modCount;
      return toReturn;
   }

   public int size() {
      return this.size;
   }

   private static Object[] createArray(int capacity) {
      return (Object[])(new Object[capacity]);
   }

   private void ensureIndexInRange(int index) {
      if (index < 0 || index >= this.size) {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(index));
      }
   }

   private String makeOutOfBoundsExceptionMessage(int index) {
      return "Index:" + index + ", Size:" + this.size;
   }

   static {
      EMPTY_LIST.makeImmutable();
   }
}
