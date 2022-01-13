package de.onyxbits.raccoon.standalone.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;

public class WindowBorder extends AbstractBorder {
   private static final long serialVersionUID = 1L;
   private String title;
   private Insets insets;
   private int baseLine;
   private static final Font TITLEFONT = new Font("SansSerif", 1, 16);
   private static final Color TITLECOLOR = new Color(26, 26, 26);
   private static final Color TITLEBACKCOLOR = new Color(223, 223, 255);
   private static final Color TITLEBORDERCOLOR;
   private static final Color BORDERCOLOR;
   private static final int MARGIN = 6;
   RenderingHints HINTS;

   public WindowBorder(String title) {
      this.HINTS = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      this.title = title;
      this.insets = new Insets(0, 2, 2, 2);
   }

   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      g.setColor(TITLEBACKCOLOR);
      g.fillRect(0, 0, width, this.insets.top);
      g.setColor(TITLEBORDERCOLOR);
      g.setColor(BORDERCOLOR);
      g.drawRect(0, this.insets.top, width - 1, height - (this.insets.top - 1));
      g.setColor(TITLECOLOR);
      g.setFont(TITLEFONT);
      ((Graphics2D)g).setRenderingHints(this.HINTS);
      g.drawString(this.title, 6, this.baseLine);
      g.setColor(DeskPane.COLOR);
      g.fillRect(0, 0, 1, 1);
      g.fillRect(width - 1, 0, 1, 1);
      g.fillRect(0, height - 1, 1, 1);
      g.fillRect(width - 1, height - 1, 1, 1);
   }

   public Insets getBorderInsets(Component c) {
      if (this.insets.top == 0) {
         FontMetrics fm = c.getFontMetrics(TITLEFONT);
         this.baseLine = fm.getMaxAscent();
         Insets var10000 = this.insets;
         var10000.top += this.baseLine;
         var10000 = this.insets;
         var10000.top += fm.getMaxDescent();
         var10000 = this.insets;
         var10000.top += 12;
         this.baseLine += 6;
      }

      return this.insets;
   }

   public boolean isBorderOpaque() {
      return false;
   }

   static {
      TITLEBORDERCOLOR = TITLEBACKCOLOR.darker();
      BORDERCOLOR = new Color(204, 204, 204);
   }
}
