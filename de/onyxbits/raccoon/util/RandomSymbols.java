package de.onyxbits.raccoon.util;

import java.util.concurrent.atomic.AtomicLong;

public class RandomSymbols {
   private AtomicLong seed;
   private char[] range;
   private static final long MULTIPLIER = 25214903917L;
   private static final long ADDEND = 11L;
   private static final long MASK = 281474976710655L;

   public RandomSymbols(long seed) {
      this(seed, "abcdefghijklmnopqrstuvwxyz".toCharArray());
   }

   public RandomSymbols(long seed, char[] range) {
      if (range == null) {
         throw new NullPointerException();
      } else if (range.length == 0) {
         throw new IllegalArgumentException();
      } else {
         this.seed = new AtomicLong(seed);
         this.range = range;
      }
   }

   public char next() {
      int r = this.next(31);
      int bound = this.range.length;
      int m = bound - 1;
      if ((bound & m) == 0) {
         r = (int)((long)bound * (long)r >> 31);
      } else {
         for(int u = r; u - (r = u % bound) + m < 0; u = this.next(31)) {
         }
      }

      return this.range[r];
   }

   private int next(int bits) {
      AtomicLong seed = this.seed;

      long oldseed;
      long nextseed;
      do {
         oldseed = seed.get();
         nextseed = oldseed * 25214903917L + 11L & 281474976710655L;
      } while(!seed.compareAndSet(oldseed, nextseed));

      return (int)(nextseed >>> 48 - bits);
   }
}
