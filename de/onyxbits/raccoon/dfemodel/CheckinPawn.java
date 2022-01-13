package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.CheckinApi;
import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.finsky.HeaderProvider;
import de.onyxbits.raccoon.finsky.Headers;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.mockup.PawnWrapper;
import de.onyxbits.raccoon.proto.AndroidCheckinResponse;
import java.io.IOException;
import org.apache.http.Header;

public class CheckinPawn extends PawnWrapper implements HeaderProvider {
   private ClientProvider clientProvider;

   public CheckinPawn(Pawn pawn, ClientProvider provider) {
      super(pawn);
      this.clientProvider = provider;
      if (provider == null) {
         throw new NullPointerException();
      }
   }

   public Header headerFor(String name) {
      if ("User-Agent".equals(name) && this.getDevice() != null) {
         String agent = MockUtil.toCheckinAgent(this.getDevice());
         return Headers.agent(agent);
      } else {
         return null;
      }
   }

   public void requestRegister() throws IOException {
      CheckinApi checkinApi = new CheckinApi(this.clientProvider, this);
      String mccmnc = this.getMccMnc();
      if (mccmnc != null && mccmnc.length() > 0) {
         checkinApi.withCellOperator(mccmnc).withSimOperator(mccmnc);
      }

      AndroidCheckinResponse acr = checkinApi.requestId(this.getLocale(), this.getTimezone(), this.getDevice());
      this.setGsfId(acr.getGsfId());
      this.setDeviceCheckinConsistencyToken(acr.getDeviceCheckinConsistencyToken());
      this.setSecurityToken(acr.getSecurityToken());
      this.setLastCheckin(acr.getTimeMsec());
      checkinApi.requestBindId(this.getLocale(), this.getTimezone(), this.getDevice(), this.getUsername(), this.getAuth(), this.getGsfId(), this.getSecurityToken());
   }

   public void requestCheckin() throws IOException {
      CheckinApi api = new CheckinApi(this.clientProvider, this);
      String mccmnc = this.getMccMnc();
      if (mccmnc != null && mccmnc.length() > 0) {
         api.withCellOperator(mccmnc).withSimOperator(mccmnc);
      }

      AndroidCheckinResponse acr = api.requestCheckin(this.getLocale(), this.getTimezone(), this.getDevice(), this.getGsfId(), this.getSecurityToken(), this.getLastCheckin());
      this.setDeviceCheckinConsistencyToken(acr.getDeviceCheckinConsistencyToken());
      this.setSecurityToken(acr.getSecurityToken());
      this.setLastCheckin(acr.getTimeMsec());
   }
}
