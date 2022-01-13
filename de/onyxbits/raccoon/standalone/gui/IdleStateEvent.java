package de.onyxbits.raccoon.standalone.gui;

import java.util.EventObject;

public class IdleStateEvent extends EventObject {
   private static final long serialVersionUID = 1L;
   public final boolean idle;

   public IdleStateEvent(Object source, boolean idle) {
      super(source);
      this.idle = idle;
   }
}
