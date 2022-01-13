package de.onyxbits.raccoon.standalone.gui;

import java.awt.Component;
import java.awt.EventQueue;

public final class Focus implements Runnable {
   private Component c;

   private Focus() {
   }

   public void run() {
      this.c.requestFocusInWindow();
   }

   public static void on(Component c) {
      Focus af = new Focus();
      af.c = c;
      EventQueue.invokeLater(af);
   }
}
