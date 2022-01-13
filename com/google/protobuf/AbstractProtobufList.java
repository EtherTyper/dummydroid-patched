package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class AbstractProtobufList extends AbstractList implements Internal.ProtobufList {
   protected static final int DEFAULT_CAPACITY = 10;
   private boolean isMutable = true;

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof List)) {
         return false;
      } else if (!(o instanceof RandomAccess)) {
         return super.equals(o);
      } else {
         List other = (List)o;
         int size = this.size();
         if (size != other.size()) {
            return false;
         } else {
            for(int i = 0; i < size; ++i) {
               if (!this.get(i).equals(other.get(i))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      int size = this.size();
      int hashCode = 1;

      for(int i = 0; i < size; ++i) {
         hashCode = 31 * hashCode + this.get(i).hashCode();
      }

      return hashCode;
   }

   public boolean add(Object e) {
      this.ensureIsMutable();
      return super.add(e);
   }

   public void add(int index, Object element) {
      this.ensureIsMutable();
      super.add(index, element);
   }

   public boolean addAll(Collection c) {
      this.ensureIsMutable();
      return super.addAll(c);
   }

   public boolean addAll(int index, Collection c) {
      this.ensureIsMutable();
      return super.addAll(index, c);
   }

   public void clear() {
      this.ensureIsMutable();
      super.clear();
   }

   public boolean isModifiable() {
      return this.isMutable;
   }

   public final void makeImmutable() {
      this.isMutable = false;
   }

   public Object remove(int index) {
      this.ensureIsMutable();
      return super.remove(index);
   }

   public boolean remove(Object o) {
      this.ensureIsMutable();
      return super.remove(o);
   }

   public boolean removeAll(Collection c) {
      this.ensureIsMutable();
      return super.removeAll(c);
   }

   public boolean retainAll(Collection c) {
      this.ensureIsMutable();
      return super.retainAll(c);
   }

   public Object set(int index, Object element) {
      this.ensureIsMutable();
      return super.set(index, element);
   }

   protected void ensureIsMutable() {
      if (!this.isMutable) {
         throw new UnsupportedOperationException();
      }
   }
}
