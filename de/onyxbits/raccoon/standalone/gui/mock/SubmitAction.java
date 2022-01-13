package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import de.onyxbits.raccoon.standalone.gui.IdleListener;
import de.onyxbits.raccoon.standalone.gui.IdleStateEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

class SubmitAction extends AppAction implements IdleListener {
   private static final long serialVersionUID = 1L;
   private static final String ID = SubmitAction.class.getSimpleName();
   protected MockDeviceController ctrl;

   public SubmitAction(ModuleProvider provider) {
      super(provider);
      this.putValue("Name", Messages.t(ID.concat(".name")));
      this.putValue("ShortDescription", Messages.t(ID.concat(".short_description")));
      this.putValue("SwingLargeIconKey", new ImageIcon(Messages.i(ID.concat("_lg.png")), (String)null));
      this.putValue("SmallIcon", new ImageIcon(Messages.i(ID.concat("_sm.png")), (String)null));
   }

   public void actionPerformed(ActionEvent e) {
      if (this.ctrl != null) {
         this.ctrl.clearLog();
         this.ctrl.next();
      }

   }

   public void onIdleStateChange(IdleStateEvent event) {
      this.setEnabled(event.idle);
   }
}
