package de.onyxbits.raccoon.standalone.gui;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.net.URI;
import javax.swing.AbstractAction;

public abstract class WebAction extends AbstractAction {
   private static final long serialVersionUID = 1L;
   private String url;

   public WebAction(String url) {
      this.url = url;
   }

   public String getUrl() {
      return this.url;
   }

   public final void actionPerformed(ActionEvent e) {
      Desktop desktop = Desktop.getDesktop();
      if (desktop.isSupported(Action.BROWSE)) {
         try {
            if (this.getUrl() != null) {
               desktop.browse(new URI(this.getUrl()));
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }
}
