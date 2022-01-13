package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.dfemodel.CheckinPawn;
import de.onyxbits.raccoon.dfemodel.HelloMarketPawn;
import de.onyxbits.raccoon.finsky.DefaultClientProvider;
import de.onyxbits.raccoon.finsky.DisplayErrorMessageException;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import java.util.concurrent.ExecutionException;

public class RegisterTask extends MockTask {
   private static final String ID = RegisterTask.class.getSimpleName();
   private static final int SETTLE = 8;

   public RegisterTask(MockDeviceController ctrl) {
      super(ctrl);
      this.log(Messages.t(ID + ".init", 8));
   }

   protected Pawn runInBackground() throws Exception {
      CheckinPawn cpawn = new CheckinPawn(this.pawnCopy, new DefaultClientProvider(this.ctrl.createClient()));
      cpawn.requestRegister();
      Thread.sleep(2000L);
      HelloMarketPawn hpawn = new HelloMarketPawn(cpawn, new DefaultClientProvider(this.ctrl.createClient()));
      hpawn.requestUploadDeviceConfig();
      hpawn.requestAcceptTos(false, false);
      Thread.sleep(8000L);
      return hpawn;
   }

   protected void runInForeground(Pawn result) {
      this.pawn.merge(result);
      StringBuilder sb = new StringBuilder();
      String gsf = this.pawn.getHexGsfId();
      String ua = MockUtil.toFinskyAgent(this.pawn.getDevice());
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         gsf = this.pawn.getRedactedGsfId();
         ua = ((MutableDevice)this.pawn.getDevice()).getRedactedAgent();
      }

      sb.append(this.labled(ID + ".gsfid", new Object[]{gsf}));
      sb.append('\n');
      sb.append(this.labled(ID + ".useragent", new Object[]{ua}));
      this.log(sb.toString());
      this.log(" ");
      this.ctrl.next();
   }

   protected void runInForeground(ExecutionException result) {
      Throwable cause = result.getCause();
      this.log(Messages.t(ID + ".failure"));
      String tmp = result.getMessage();
      if (cause instanceof DisplayErrorMessageException) {
         DisplayErrorMessageException e = (DisplayErrorMessageException)cause;
         tmp = Messages.t(ID + ".displayerrormessage", e.getStatusCode(), e.getErrorMessage());
      }

      this.log(tmp);
      this.log(" ");
      this.ctrl.reset();
   }
}
