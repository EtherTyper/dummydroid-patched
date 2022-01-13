package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.proto.ResponseWrapper;
import de.onyxbits.raccoon.proto.TocResponse;
import java.io.IOException;

public class HelloMarketPawn extends FinskyPawn {
   public HelloMarketPawn(Pawn pawn, ClientProvider provider) {
      super(pawn, provider);
   }

   public void requestUploadDeviceConfig() throws IOException {
      ResponseWrapper rw = this.getDfeApi().requestUploadDeviceConfig(this.getDevice(), this.getDeviceConfigToken());
      this.setDeviceConfigToken(rw.getPayload().getUploadDeviceConfigResponse().getUploadDeviceConfigToken());
   }

   public boolean requestAcceptTos(boolean emailOptIn, boolean otherOptIn) throws IOException {
      ResponseWrapper rw = this.getDfeApi().requestToc(this.getDeviceConfigToken());
      TocResponse tr = rw.getPayload().getTocResponse();
      this.setDfeCookie(tr.getCookie());
      this.setTosToken(tr.getTosToken());
      this.getDfeApi().requestAcceptTos(this.getTosToken(), this.getDeviceCheckinConsistencyToken(), emailOptIn, otherOptIn);
      return tr.getRequiresUploadDeviceConfig();
   }
}
