package de.onyxbits.raccoon.finsky;

public enum PatchFormat {
   GDIFF(1),
   GZIPPED_GDIFF(2),
   GZIPPED_BSDIFF(3),
   UNKNOWN_4(4),
   UNKNOWN_5(5);

   public final int value;

   private PatchFormat(int value) {
      this.value = value;
   }
}
