package de.onyxbits.raccoon.standalone;

import de.onyxbits.raccoon.standalone.base.Module;
import java.io.IOException;

public class RegistrationAdapter implements Module, Registration {
   private Registration permit;

   public RegistrationAdapter() {
   }

   public RegistrationAdapter(Registration permit) {
      this.permit = permit;
   }

   public String getFullName() {
      return this.permit == null ? null : this.permit.getFullName();
   }

   public String getContactEmail() {
      return this.permit == null ? null : this.permit.getContactEmail();
   }

   public String getRegistrationId() {
      return this.permit == null ? null : this.permit.getRegistrationId();
   }

   public boolean isEnabled(String id) {
      return this.permit == null ? false : this.permit.isEnabled(id);
   }

   public void shutdown() {
   }

   public boolean updateRegistration(byte[] data) throws IOException {
      return this.permit != null ? this.permit.updateRegistration(data) : false;
   }
}
