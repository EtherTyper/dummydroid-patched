package de.onyxbits.raccoon.standalone.gui;

public class SupportAction extends WebAction {
   private static final String ID = SupportAction.class.getSimpleName();
   private static final long serialVersionUID = 1L;
   private ContextHelper contextHelper;

   public SupportAction(ContextHelper ch) {
      super(ch.getSupportUrl());
      this.putValue("Name", Messages.t(ID + ".name"));
      this.contextHelper = ch;
   }

   public String getUrl() {
      return this.contextHelper.getSupportUrl();
   }
}
