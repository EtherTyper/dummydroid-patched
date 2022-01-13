package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.dfemodel.PawnFactory;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.standalone.gui.BackgroundTask;
import de.onyxbits.raccoon.util.TextTool;

abstract class MockTask extends BackgroundTask {
   public static final int WIDTH = 14;
   protected MockDeviceController ctrl;
   protected PawnModel pawn;
   protected Pawn pawnCopy;

   public MockTask(MockDeviceController ctrl) {
      this.ctrl = ctrl;
      this.pawn = ctrl.pawn;
      this.pawnCopy = PawnFactory.copy(ctrl.pawn);
   }

   protected String labled(String key, Object... args) {
      String label = TextTool.fit(Messages.t(key + ".lbl"), 14, ' ', "");
      String text = Messages.t(key + ".txt", args);
      return label + ": " + text;
   }

   protected void log(String txt) {
      this.ctrl.log(txt);
   }
}
