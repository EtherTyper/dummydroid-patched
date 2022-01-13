package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList implements LazyStringList, RandomAccess {
   private final LazyStringList list;

   public UnmodifiableLazyStringList(LazyStringList list) {
      this.list = list;
   }

   public String get(int index) {
      return (String)this.list.get(index);
   }

   public Object getRaw(int index) {
      return this.list.getRaw(index);
   }

   public int size() {
      return this.list.size();
   }

   public ByteString getByteString(int index) {
      return this.list.getByteString(index);
   }

   public void add(ByteString element) {
      throw new UnsupportedOperationException();
   }

   public void set(int index, ByteString element) {
      throw new UnsupportedOperationException();
   }

   public boolean addAllByteString(Collection element) {
      throw new UnsupportedOperationException();
   }

   public byte[] getByteArray(int index) {
      return this.list.getByteArray(index);
   }

   public void add(byte[] element) {
      throw new UnsupportedOperationException();
   }

   public void set(int index, byte[] element) {
      throw new UnsupportedOperationException();
   }

   public boolean addAllByteArray(Collection element) {
      throw new UnsupportedOperationException();
   }

   public ListIterator listIterator(final int index) {
      return new ListIterator() {
         ListIterator iter;

         {
            this.iter = UnmodifiableLazyStringList.this.list.listIterator(index);
         }

         public boolean hasNext() {
            return this.iter.hasNext();
         }

         public String next() {
            return (String)this.iter.next();
         }

         public boolean hasPrevious() {
            return this.iter.hasPrevious();
         }

         public String previous() {
            return (String)this.iter.previous();
         }

         public int nextIndex() {
            return this.iter.nextIndex();
         }

         public int previousIndex() {
            return this.iter.previousIndex();
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }

         public void set(String o) {
            throw new UnsupportedOperationException();
         }

         public void add(String o) {
            throw new UnsupportedOperationException();
         }
      };
   }

   public Iterator iterator() {
      return new Iterator() {
         Iterator iter;

         {
            this.iter = UnmodifiableLazyStringList.this.list.iterator();
         }

         public boolean hasNext() {
            return this.iter.hasNext();
         }

         public String next() {
            return (String)this.iter.next();
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   public List getUnderlyingElements() {
      return this.list.getUnderlyingElements();
   }

   public void mergeFrom(LazyStringList other) {
      throw new UnsupportedOperationException();
   }

   public List asByteArrayList() {
      return Collections.unmodifiableList(this.list.asByteArrayList());
   }

   public List asByteStringList() {
      return Collections.unmodifiableList(this.list.asByteStringList());
   }

   public LazyStringList getUnmodifiableView() {
      return this;
   }
}
