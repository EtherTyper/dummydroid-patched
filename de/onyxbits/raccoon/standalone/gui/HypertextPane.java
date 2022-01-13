package de.onyxbits.raccoon.standalone.gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;

public class HypertextPane extends JEditorPane {
   private static final long serialVersionUID = 1L;
   private boolean tooltip;

   public HypertextPane(String txt) {
      super("text/html", txt);
      this.setEditable(false);
   }

   public void paintComponent(Graphics g) {
      Graphics2D graphics2d = (Graphics2D)g;
      Object tmp = graphics2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
      graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      super.paintComponent(g);
      graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, tmp);
   }

   public HypertextPane withTransparency() {
      this.setBackground(new Color(0, 0, 0, 0));
      this.setOpaque(false);
      this.putClientProperty("JEditorPane.honorDisplayProperties", Boolean.TRUE);
      this.setFont(new Font("Dialog", 0, 14));
      return this;
   }

   public HypertextPane withWidth(int width) {
      this.setSize(width, 32767);
      this.revalidate();
      this.setPreferredSize(new Dimension(width, this.getPreferredSize().height));
      return this;
   }

   public HypertextPane withLinkToolTip() {
      this.tooltip = true;
      return this;
   }

   public void fireHyperlinkUpdate(HyperlinkEvent e) {
      if (this.tooltip) {
         if (e.getEventType() == EventType.ENTERED) {
            try {
               this.setToolTipText(e.getURL().toURI().toString());
            } catch (URISyntaxException var6) {
               this.setToolTipText((String)null);
            }
         }

         if (e.getEventType() == EventType.EXITED) {
            this.setToolTipText((String)null);
         }
      }

      if (e.getEventType() == EventType.ACTIVATED) {
         try {
            URI uri = e.getURL().toURI();
            String scheme = uri.getScheme().toLowerCase();
            Desktop desktop = Desktop.getDesktop();

            try {
               if ("http".equals(scheme) || "https".equals(scheme) || "ftp".equals(scheme)) {
                  desktop.browse(uri);
               }

               if ("mailto".equals(scheme)) {
                  desktop.mail(uri);
               }

               if ("file".equals(scheme) || "jar".equals(scheme)) {
                  desktop.open(new File(uri));
               }
            } catch (IOException var7) {
            }
         } catch (Exception var8) {
         }
      }

      super.fireHyperlinkUpdate(e);
   }
}
