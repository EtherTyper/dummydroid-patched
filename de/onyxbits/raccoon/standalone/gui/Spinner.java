package de.onyxbits.raccoon.standalone.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Spinner extends JPanel implements IdleListener, ActionListener {
   private static final long serialVersionUID = 1L;
   private long last;
   private Insets margin;
   private Color[] colors;
   private Timer timer;
   private boolean painted;

   public Spinner() {
      this.colors = new Color[]{Color.RED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.RED.darker().darker()};
      this.setOpaque(false);
      this.margin = new Insets(0, 0, 0, 0);
   }

   public void onIdleStateChange(IdleStateEvent event) {
      if (event.idle) {
         this.getTicker().stop();
      } else {
         this.getTicker().restart();
      }

      this.repaint();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (this.getTicker().isRunning()) {
         Graphics2D gr = (Graphics2D)g;
         gr.setColor(this.colors[0]);
         gr.fillRect(this.margin.left, 0, 6, 6);
         gr.setColor(this.colors[1]);
         gr.fillRect(this.margin.left + 8, 0, 6, 6);
         gr.setColor(this.colors[2]);
         gr.fillRect(this.margin.left + 16, 0, 6, 6);
         Toolkit.getDefaultToolkit().sync();
         this.painted = true;
      }

   }

   public Dimension getPreferredSize() {
      return new Dimension(20 + this.margin.left + this.margin.right, 4 + this.margin.top + this.margin.bottom);
   }

   public Dimension getMinimumSize() {
      return new Dimension(20 + this.margin.left + this.margin.right, 4 + this.margin.top + this.margin.bottom);
   }

   public Dimension getMaximumSize() {
      return new Dimension(20 + this.margin.left + this.margin.right, 4 + this.margin.top + this.margin.bottom);
   }

   public void actionPerformed(ActionEvent e) {
      if (this.isVisible() && this.last + 200L <= System.currentTimeMillis()) {
         if (this.painted) {
            Color tmp = this.colors[5];
            this.colors[5] = this.colors[4];
            this.colors[4] = this.colors[3];
            this.colors[3] = this.colors[2];
            this.colors[2] = this.colors[1];
            this.colors[1] = this.colors[0];
            this.colors[0] = tmp;
            this.painted = false;
         }

         this.last = System.currentTimeMillis();
         this.repaint();
      }

   }

   public Timer getTicker() {
      if (this.timer == null) {
         this.timer = new Timer(10, this);
         this.timer.setCoalesce(true);
      }

      return this.timer;
   }

   public Insets getMargin() {
      return this.margin;
   }

   public void setMargin(Insets margin) {
      this.margin = margin;
   }
}
