package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.RegistrationAdapter;
import de.onyxbits.raccoon.standalone.gui.AbstractActivity;

public class MockDeviceActivity extends AbstractActivity {
   private MockDeviceController ctrl;

   private MockDeviceController getController() {
      if (this.ctrl == null) {
         this.ctrl = new MockDeviceController(this);
      }

      return this.ctrl;
   }

   public void setVisible(boolean visible) {
      this.getController().getWindow().setVisible(visible);
   }

   public void shutdown() {
      if (this.ctrl != null) {
         this.ctrl.shutdown();
      }

   }

   public boolean isEyesOnly() {
      return false;
      // String feature = this.getClass().getPackage().getName();
      // return !((RegistrationAdapter)this.fetch(RegistrationAdapter.class)).isEnabled(feature);
   }
}
