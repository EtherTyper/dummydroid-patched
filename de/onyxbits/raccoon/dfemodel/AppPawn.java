package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.AppStreamer;
import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.proto.DeliveryResponse;
import java.io.IOException;
import org.apache.http.client.HttpResponseException;

public class AppPawn extends FinskyPawn {
   private ClientProvider provider;

   public AppPawn(Pawn pawn, ClientProvider provider) {
      super(pawn, provider);
      this.provider = provider;
   }

   public void requestSearch() {
   }

   public void requestPurchase(String pn, int vc) throws HttpResponseException, IOException {
      this.getDfeApi().requestPurchaseApp(pn, vc).getPayload();
   }

   public DeliveryResponse requestDeliver(String pn, int vc) throws HttpResponseException, IOException {
      return this.getDfeApi().requestDeliverApp(pn, vc).getPayload().getDeliveryResponse();
   }

   public AppStreamer requestDownload(String pn, int vc) throws HttpResponseException, IOException {
      DeliveryResponse dr = this.requestDeliver(pn, vc);
      return new AppStreamer(this.provider, MockUtil.toDownloadAgent(this.getDevice()), true, dr.getAppDeliveryData());
   }
}
