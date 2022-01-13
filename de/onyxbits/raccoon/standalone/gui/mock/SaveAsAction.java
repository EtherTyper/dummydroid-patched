package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.standalone.Uplink;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class SaveAsAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = SaveAsAction.class.getSimpleName();
   private PawnModel model;

   public SaveAsAction(ModuleProvider provider, PawnModel pawn) {
      super(provider);
      this.model = pawn;
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.setEnabled(!((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly());
   }

   public void actionPerformed(ActionEvent e) {
      Component parent = windowOf((Component)e.getSource());
      JFileChooser jfc = new JFileChooser();
      File file = ((Uplink)this.fetch(Uplink.class)).pathOfPawn((Pawn)this.model);
      file.getParentFile().mkdirs();
      jfc.setSelectedFile(file);
      if (jfc.showSaveDialog(parent) == 0) {
         try {
            file = jfc.getSelectedFile();
            String alias = file.getName();
            if (alias.toLowerCase().endsWith(".prf")) {
               alias = alias.substring(0, alias.length() - "prf".length() - 1);
            }

            this.model.setAlias(alias);
            ((Uplink)this.fetch(Uplink.class)).savePawn(this.model);
         } catch (IOException var6) {
            JOptionPane.showMessageDialog(windowOf(parent), var6.getMessage(), Messages.t(ID + ".title"), 0);
         }
      }

   }
}
