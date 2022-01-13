package de.onyxbits.raccoon.dfemodel;

import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.proto.DocV2;
import de.onyxbits.raccoon.proto.ResponseWrapper;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.HttpResponseException;

public class DetailsPawn extends FinskyPawn {
   public DetailsPawn(Pawn pawn, ClientProvider provider) {
      super(pawn, provider);
   }

   public DocV2 requestDetails(String docId) throws HttpResponseException, IOException {
      return this.getDfeApi().requestDetails(docId).getPayload().getDetailsResponse().getDocV2();
   }

   public List requestBulkDetails(List docId) throws HttpResponseException, IOException {
      ResponseWrapper rw = this.getDfeApi().requestBulkDetails(docId, true, true);
      return rw.getPayload().getBulkDetailsResponse().getEntryList();
   }
}
