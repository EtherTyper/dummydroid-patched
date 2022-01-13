package de.onyxbits.raccoon.standalone.gui;

import javax.swing.KeyStroke;

public class ContextHelpAction extends WebAction {
   public static final KeyStroke ACCEL = KeyStroke.getKeyStroke(112, 0);
   private static final long serialVersionUID = 1L;
   private static final String ID = ContextHelpAction.class.getSimpleName();
   private ContextHelper contextHelp;

   public ContextHelpAction(ContextHelper ch) {
      super(ch.getContextHelpUrl());
      this.putValue("Name", Messages.t(ID + ".name"));
      this.contextHelp = ch;
   }

   public String getUrl() {
      return this.contextHelp.getContextHelpUrl();
   }
}
