package de.onyxbits.raccoon.standalone;

import java.io.IOException;

public interface Registration {
   String getFullName();

   String getContactEmail();

   String getRegistrationId();

   boolean isEnabled(String var1);

   boolean updateRegistration(byte[] var1) throws IOException;
}
