package de.onyxbits.raccoon.finsky;

public enum SortType {
   NEWEST(0),
   RATING(1),
   HELPFULLNESS(4);

   public final int value;

   private SortType(int value) {
      this.value = value;
   }
}
