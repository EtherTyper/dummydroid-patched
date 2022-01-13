package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;

public class PawnFactory {
   private ClientProvider provider;
   private Pawn pawn;

   public PawnFactory(ClientProvider provider, Pawn pawn) {
      if (provider != null && pawn != null) {
         this.provider = provider;
         this.pawn = pawn;
      } else {
         throw new NullPointerException();
      }
   }

   public CheckinPawn createCheckinPawn() {
      return new CheckinPawn(this.pawn, this.provider);
   }

   public DetailsPawn createDetailsPawn() {
      return new DetailsPawn(this.pawn, this.provider);
   }

   public HelloMarketPawn createHelloMarketPawn() {
      return new HelloMarketPawn(this.pawn, this.provider);
   }

   public LoginPawn createLoginPawn() {
      return new LoginPawn(this.pawn, this.provider);
   }

   public FinskyPawn createDfePawn() {
      return new FinskyPawn(this.pawn, this.provider);
   }

   public static Pawn copy(Pawn pawn) {
      return MockUtil.decodePawn(MockUtil.encodePawn(pawn));
   }
}
