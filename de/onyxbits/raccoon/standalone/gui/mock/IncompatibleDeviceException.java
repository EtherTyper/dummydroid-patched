package de.onyxbits.raccoon.standalone.gui.mock;

class IncompatibleDeviceException extends Exception {
   private static final long serialVersionUID = 1L;
   private static final String ID = IncompatibleDeviceException.class.getSimpleName();

   public IncompatibleDeviceException() {
      super(Messages.t(ID + ".init"));
   }
}
