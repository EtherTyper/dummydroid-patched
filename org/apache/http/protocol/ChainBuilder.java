package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class ChainBuilder {
   private final LinkedList list = new LinkedList();
   private final Map uniqueClasses = new HashMap();

   public ChainBuilder() {
   }

   private void ensureUnique(Object e) {
      Object previous = this.uniqueClasses.remove(e.getClass());
      if (previous != null) {
         this.list.remove(previous);
      }

      this.uniqueClasses.put(e.getClass(), e);
   }

   public ChainBuilder addFirst(Object e) {
      if (e == null) {
         return this;
      } else {
         this.ensureUnique(e);
         this.list.addFirst(e);
         return this;
      }
   }

   public ChainBuilder addLast(Object e) {
      if (e == null) {
         return this;
      } else {
         this.ensureUnique(e);
         this.list.addLast(e);
         return this;
      }
   }

   public ChainBuilder addAllFirst(Collection c) {
      if (c == null) {
         return this;
      } else {
         Iterator i$ = c.iterator();

         while(i$.hasNext()) {
            Object e = i$.next();
            this.addFirst(e);
         }

         return this;
      }
   }

   public ChainBuilder addAllFirst(Object... c) {
      if (c == null) {
         return this;
      } else {
         Object[] arr$ = c;
         int len$ = c.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object e = arr$[i$];
            this.addFirst(e);
         }

         return this;
      }
   }

   public ChainBuilder addAllLast(Collection c) {
      if (c == null) {
         return this;
      } else {
         Iterator i$ = c.iterator();

         while(i$.hasNext()) {
            Object e = i$.next();
            this.addLast(e);
         }

         return this;
      }
   }

   public ChainBuilder addAllLast(Object... c) {
      if (c == null) {
         return this;
      } else {
         Object[] arr$ = c;
         int len$ = c.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object e = arr$[i$];
            this.addLast(e);
         }

         return this;
      }
   }

   public LinkedList build() {
      return new LinkedList(this.list);
   }
}
