package de.onyxbits.raccoon.net;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class OrderedHashtable extends Hashtable {
   private static final long serialVersionUID = 1L;
   private Vector ordered = new Vector();

   public synchronized Object put(Integer key, Object value) {
      super.put(key, value);
      this.ordered.add(key);
      return value;
   }

   public synchronized Enumeration keys() {
      return this.ordered.elements();
   }
}
