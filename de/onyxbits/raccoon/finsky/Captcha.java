package de.onyxbits.raccoon.finsky;

public class Captcha {
   public String token;
   public byte[] data;
   public String solution;

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("solution: ");
      sb.append(this.solution);
      sb.append("\ntoken: ");
      sb.append(this.token);
      return sb.toString();
   }
}
