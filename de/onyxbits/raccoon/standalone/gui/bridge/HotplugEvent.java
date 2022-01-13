package de.onyxbits.raccoon.standalone.gui.bridge;

import java.util.EventObject;
import java.util.List;

public class HotplugEvent extends EventObject {
   private static final long serialVersionUID = 1L;
   public List removed;
   public List connected;
   public List added;

   public HotplugEvent(Object source, List connected, List removed, List added) {
      super(source);
      this.connected = connected;
      this.removed = removed;
      this.added = added;
   }
}
