package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class UserAgentAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = UserAgentAction.class.getSimpleName();
   private MutableDevice model;

   public UserAgentAction(ModuleProvider provider, MutableDevice model) {
      super(provider);
      this.model = model;
      this.putValue("Name", Messages.t(ID.concat(".name")));
      this.putValue("ShortDescription", Messages.t(ID.concat(".short_description")));
   }

   public void actionPerformed(ActionEvent e) {
      String ua = MockUtil.toFinskyAgent(this.model);
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         ua = this.model.getRedactedAgent();
      }

      JOptionPane.showInputDialog(windowOf((Component)e.getSource()), Messages.t(ID + ".message"), Messages.t(ID + ".windowtitle"), 1, (Icon)null, (Object[])null, ua);
   }
}
