package de.onyxbits.raccoon.standalone.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DeskPane extends JPanel {
   private static final long serialVersionUID = 1L;
   public static final int GAP = 8;
   private static final Image WALLPAPER;
   private static final int WIDTH;
   private static final int HEIGHT;
   static final Color COLOR = new Color(100, 109, 115);

   public DeskPane(LayoutManager layout, boolean isDoubleBuffered) {
      super(layout, isDoubleBuffered);
   }

   public DeskPane(LayoutManager layout) {
      super(layout, true);
   }

   public DeskPane(boolean isDoubleBuffered) {
      super(new FlowLayout(), isDoubleBuffered);
   }

   public DeskPane() {
      super(new FlowLayout(), true);
   }

   public void paintComponent(Graphics gr) {
      super.paintComponent(gr);
      gr.setColor(COLOR);
      gr.fillRect(0, 0, this.getWidth(), this.getHeight());
   }

   static {
      BufferedImage tmp;
      int width;
      int height;
      try {
         InputStream in = Messages.open("wallpaper.png");
         tmp = ImageIO.read(in);
         width = tmp.getWidth((ImageObserver)null);
         height = tmp.getHeight((ImageObserver)null);
      } catch (Exception var4) {
         width = 64;
         height = 64;
         tmp = new BufferedImage(width, height, 2);
      }

      WALLPAPER = tmp;
      WIDTH = width;
      HEIGHT = height;
   }
}
