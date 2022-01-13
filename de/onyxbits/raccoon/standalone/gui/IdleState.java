package de.onyxbits.raccoon.standalone.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.event.EventListenerList;

public class IdleState {
   private boolean idle;
   private EventListenerList listeners;
   private List enabledIdle;
   private List disabledIdle;

   public IdleState(boolean idle) {
      this.idle = idle;
      this.listeners = new EventListenerList();
      this.enabledIdle = new ArrayList();
      this.disabledIdle = new ArrayList();
   }

   public void setIdle(boolean idle) {
      this.idle = idle;
      IdleStateEvent event = new IdleStateEvent(this, idle);
      Object[] l = this.listeners.getListenerList();

      for(int i = l.length - 2; i >= 0; i -= 2) {
         if (l[i] == IdleListener.class) {
            ((IdleListener)l[i + 1]).onIdleStateChange(event);
         }
      }

      Iterator var6 = this.enabledIdle.iterator();

      Component c;
      while(var6.hasNext()) {
         c = (Component)var6.next();
         c.setEnabled(idle);
      }

      var6 = this.disabledIdle.iterator();

      while(var6.hasNext()) {
         c = (Component)var6.next();
         c.setEnabled(!idle);
      }

   }

   public boolean isIdle() {
      return this.idle;
   }

   public void addIdleListener(IdleListener listener) {
      this.listeners.add(IdleListener.class, listener);
   }

   public void removeIdleListener(IdleListener listener) {
      this.listeners.remove(IdleListener.class, listener);
   }

   public Component enableOnIdle(Component c) {
      this.enabledIdle.add(c);
      return c;
   }

   public Component disableOnIdle(Component c) {
      this.disabledIdle.add(c);
      return c;
   }
}
