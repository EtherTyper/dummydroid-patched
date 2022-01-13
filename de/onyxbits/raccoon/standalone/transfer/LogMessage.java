package de.onyxbits.raccoon.standalone.transfer;

public class LogMessage {
   public static final int INFO = 0;
   public static final int WARN = 1;
   public static final int FATAL = 2;
   public final int level;
   public final String message;

   public LogMessage(int level, String message) {
      this.level = level;
      this.message = message;
   }
}
