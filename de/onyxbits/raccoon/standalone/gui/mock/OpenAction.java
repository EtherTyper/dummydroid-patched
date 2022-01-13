package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.standalone.Uplink;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import de.onyxbits.raccoon.standalone.gui.PawnFileFilter;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class OpenAction extends AppAction {
   private static final long serialVersionUID = 1L;
   private static final String ID = OpenAction.class.getSimpleName();
   private PawnModel model;

   public OpenAction(ModuleProvider provider, PawnModel model) {
      super(provider);
      this.putValue("Name", Messages.t(ID + ".name"));
      this.putValue("ShortDescription", Messages.t(ID + ".short_description"));
      this.model = model;
   }

   public void actionPerformed(ActionEvent e) {
      JFileChooser jfc = new JFileChooser();
      File dir = ((Uplink)this.fetch(Uplink.class)).pathOfPawns();
      dir.mkdirs();
      jfc.setCurrentDirectory(dir);
      jfc.setFileFilter(new PawnFileFilter());
      Window src = windowOf((Component)e.getSource());
      if (0 == jfc.showOpenDialog(src)) {
         try {
            FileReader reader = new FileReader(jfc.getSelectedFile());
            Throwable var6 = null;

            try {
               this.model.clear();
               this.model.merge(MockUtil.decodePawn((Reader)reader));
            } catch (Throwable var16) {
               var6 = var16;
               throw var16;
            } finally {
               if (reader != null) {
                  if (var6 != null) {
                     try {
                        reader.close();
                     } catch (Throwable var15) {
                        var6.addSuppressed(var15);
                     }
                  } else {
                     reader.close();
                  }
               }

            }
         } catch (IOException var18) {
            JOptionPane.showMessageDialog(src, var18.getMessage(), Messages.t(ID + ".error"), 0);
         }
      }

   }
}
