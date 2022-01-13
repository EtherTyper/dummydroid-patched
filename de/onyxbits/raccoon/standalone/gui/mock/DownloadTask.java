package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.dfemodel.AppPawn;
import de.onyxbits.raccoon.dfemodel.DetailsPawn;
import de.onyxbits.raccoon.finsky.ClientProvider;
import de.onyxbits.raccoon.finsky.DefaultClientProvider;
import de.onyxbits.raccoon.proto.AndroidAppDeliveryData;
import de.onyxbits.raccoon.proto.AppDetails;
import de.onyxbits.raccoon.proto.AppFileMetadata;
import de.onyxbits.raccoon.proto.DeliveryResponse;
import de.onyxbits.raccoon.proto.DocV2;
import de.onyxbits.raccoon.proto.SplitDeliveryData;
import de.onyxbits.raccoon.util.TextTool;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class DownloadTask extends MockTask {
   private static final String ID = DownloadTask.class.getSimpleName();
   private String pn;
   private int vc;
   private String name;

   public DownloadTask(MockDeviceController ctrl, String pn) {
      super(ctrl);
      this.pn = pn;
      this.log(Messages.t(ID + ".init", pn));
   }

   protected DeliveryResponse runInBackground() throws Exception {
      ClientProvider cp = new DefaultClientProvider(this.ctrl.createClient());
      DetailsPawn dp = new DetailsPawn(this.pawnCopy, cp);
      AppPawn ap = new AppPawn(this.pawnCopy, cp);
      DocV2 doc = dp.requestDetails(this.pn);
      AppDetails ad = doc.getDetails().getAppDetails();
      if (!ad.hasVersionCode()) {
         throw new IncompatibleDeviceException();
      } else {
         this.vc = ad.getVersionCode();
         this.name = doc.getTitle();
         ap.requestPurchase(this.pn, this.vc);
         return ap.requestDeliver(this.pn, ad.getVersionCode());
      }
   }

   protected void runInForeground(DeliveryResponse result) {
      AndroidAppDeliveryData aadd = result.getAppDeliveryData();
      this.log(this.labled(ID + ".name", new Object[]{this.name}));
      this.log(this.labled(ID + ".size", new Object[]{TextTool.byteCount(aadd.getDownloadSize(), true)}));
      this.log(this.labled(ID + ".versioncode", new Object[]{this.vc}));
      this.log(this.labled(ID + ".baseurl", new Object[]{this.redact(aadd.getDownloadUrl())}));
      Iterator var3 = aadd.getAdditionalFileList().iterator();

      while(var3.hasNext()) {
         AppFileMetadata afmd = (AppFileMetadata)var3.next();
         this.log(this.labled(ID + ".meta." + afmd.getFileType(), new Object[]{this.redact(afmd.getDownloadUrl())}));
      }

      var3 = aadd.getSplitDeliveryDataList().iterator();

      while(var3.hasNext()) {
         SplitDeliveryData sdd = (SplitDeliveryData)var3.next();
         this.log(this.labled(ID + ".split", new Object[]{sdd.getId(), this.redact(sdd.getDownloadUrl())}));
      }

      this.log(" ");
      this.ctrl.next();
   }

   protected void runInForeground(ExecutionException result) {
      this.log(Messages.t(ID + ".failure"));
      this.log(result.getCause().getMessage());
      this.log(" ");
      this.ctrl.reset();
   }

   private String redact(String url) {
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         try {
            URI uri = new URI(url);
            String s = TextTool.redact(uri.getPath());
            return uri.getScheme() + "://" + uri.getHost() + "/" + s;
         } catch (URISyntaxException var4) {
            var4.printStackTrace();
            return "";
         }
      } else {
         return url;
      }
   }
}
