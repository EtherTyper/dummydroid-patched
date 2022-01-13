package de.onyxbits.raccoon.finsky;

public enum OfferType {
   UNKNOWN(0),
   PURCHASE(1),
   SAMPLE(2),
   RENTAL(3),
   RENTAL_HIGH_DEF(4),
   PREORDER(6),
   PURCHASE_HIGH_DEF(7),
   BUNDLED(8),
   GROUP_LICENSE(9),
   LICENSE(10),
   SUBSCRIPTION_CONTENT(11),
   SUBSCRIPTION(13),
   REWARD(14),
   NONE(12);

   public final int value;

   private OfferType(int n) {
      this.value = n;
   }
}
