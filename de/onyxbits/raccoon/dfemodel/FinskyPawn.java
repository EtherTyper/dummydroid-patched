package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.finsky.DfeApi;
import de.onyxbits.raccoon.finsky.DfeHeaders;
import de.onyxbits.raccoon.finsky.HeaderProvider;
import de.onyxbits.raccoon.finsky.Headers;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.mockup.PawnWrapper;
import de.onyxbits.raccoon.proto.ResponseWrapper;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;

public class FinskyPawn extends PawnWrapper implements HeaderProvider, DfeHeaders {
   private ClientProvider clientProvider;
   private DfeApi dfeApi;

   public FinskyPawn(Pawn pawn, ClientProvider provider) {
      super(pawn);
      if (provider == null) {
         throw new NullPointerException();
      } else {
         this.clientProvider = provider;
      }
   }

   public DfeApi getDfeApi() {
      if (this.dfeApi == null) {
         this.dfeApi = new DfeApi(this.clientProvider, this);
      }

      return this.dfeApi;
   }

   public Header headerFor(String name) {
      if ("Authorization".equals(name) && this.getAuth() != null) {
         return Headers.auth(this.getAuth());
      } else if ("Accept-Language".equals(name) && this.getLocale() != null) {
         return Headers.lang(this.getLocale());
      } else if ("X-DFE-Device-Id".equals(name) && this.getGsfId() != 0L) {
         return Headers.gsfId(this.getGsfId());
      } else if ("User-Agent".equals(name) && this.getDevice() != null) {
         String agent = MockUtil.toFinskyAgent(this.getDevice());
         return Headers.agent(agent);
      } else if ("X-DFE-MCCMNC".equals(name) && this.getMccMnc() != null) {
         return Headers.mccMnc(this.getMccMnc());
      } else if ("X-DFE-Cookie".equals(name) && this.getDfeCookie() != null) {
         return Headers.dfeCookie(this.getDfeCookie());
      } else {
         return "X-DFE-Device-Checkin-Consistency-Token".equals(name) && this.getDeviceCheckinConsistencyToken() != null ? Headers.checkinConsistency(this.getDeviceCheckinConsistencyToken()) : null;
      }
   }

   public ResponseWrapper requestUrl(String url) throws HttpResponseException, IOException {
      return this.getDfeApi().requestUrl(url);
   }
}
