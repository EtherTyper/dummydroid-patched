package de.onyxbits.raccoon.standalone.gui.about;

import de.onyxbits.raccoon.standalone.gui.WebAction;

public class LicenseAction extends WebAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = LicenseAction.class.getSimpleName();

   public LicenseAction() {
      super(Messages.t(ID + ".url"));
      this.putValue("Name", Messages.t(ID + ".name"));
   }
}
