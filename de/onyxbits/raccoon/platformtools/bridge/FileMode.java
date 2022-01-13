package de.onyxbits.raccoon.platformtools.bridge;

public class FileMode {
   private static final int SHIFTOWNER = 6;
   private static final int SHIFTGROUP = 3;
   private static final int SHIFTOTHERS = 0;
   private static final int READFLAG = 4;
   private static final int WRITEFLAG = 2;
   private static final int EXECFLAG = 1;
   private int mode;
   private int who = 6;

   public int get() {
      return this.mode;
   }

   public FileMode r() {
      this.mode |= 4 << this.who;
      return this;
   }

   public FileMode w() {
      this.mode |= 2 << this.who;
      return this;
   }

   public FileMode x() {
      this.mode |= 1 << this.who;
      return this;
   }

   public FileMode owner() {
      this.who = 6;
      return this;
   }

   public FileMode group() {
      this.who = 3;
      return this;
   }

   public FileMode others() {
      this.who = 0;
      return this;
   }

   public String toString() {
      char[] tmp = new char[]{'r', 'w', 'x', 'r', 'w', 'x', 'r', 'w', 'x'};
      int mask = 1;

      for(int i = 8; i >= 0; --i) {
         if ((this.mode & mask) == 0) {
            tmp[i] = '-';
         }

         mask <<= 1;
      }

      return new String(tmp);
   }
}
