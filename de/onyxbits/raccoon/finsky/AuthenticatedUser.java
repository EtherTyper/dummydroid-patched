package de.onyxbits.raccoon.finsky;

import java.util.Collections;
import java.util.List;

public class AuthenticatedUser {
   public final String firstName;
   public final String lastName;
   public final String email;
   public final String authToken;
   public final List services;
   public final String username;

   public AuthenticatedUser(String username, String firstName, String lastName, String email, List services, String authToken) {
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.services = Collections.unmodifiableList(services);
      this.authToken = authToken;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder(this.username);
      sb.append(": ");
      sb.append(this.firstName);
      sb.append(' ');
      sb.append(this.lastName);
      sb.append('<');
      sb.append(this.email);
      sb.append('>');
      sb.append('\t');
      sb.append(this.services);
      sb.append('\t');
      sb.append(this.authToken);
      return sb.toString();
   }
}
