package com.group2022103.flightkiosk.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class DemoScrollBarUI extends BasicScrollBarUI {

    @Override
    protected void configureScrollBarColors() {

        trackColor = Color.white;

        setThumbBounds(0, 0, 3, 10);

    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        c.setPreferredSize(new Dimension(10, 0));

        return super.getPreferredSize(c);

    }

    public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = null;

        if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {

            gp = new GradientPaint(0, 0, new Color(255, 255, 255),

                    trackBounds.height, 0, new Color(255, 255, 255));

        }

        g2.setPaint(gp);

        g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width,

                trackBounds.height);
        if (trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT)

            this.paintDecreaseHighlight(g);

        if (trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT)

            this.paintIncreaseHighlight(g);

    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

        g.translate(thumbBounds.x, thumbBounds.y);

        g.setColor(new Color(30, 144, 255));

        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,

                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.addRenderingHints(rh);

        g2.fillRoundRect(0, 0, 40, thumbBounds.height - 1, 5, 5);

    }

    @Override

    protected JButton createIncreaseButton(int orientation) {

        JButton button = new JButton();

        button.setBorderPainted(false);

        button.setContentAreaFilled(false);

        button.setBorder(null);

        return button;

    }

    @Override

    protected JButton createDecreaseButton(int orientation) {

        JButton button = new JButton();

        button.setBorderPainted(false);

        button.setContentAreaFilled(false);

        button.setFocusable(false);

        button.setBorder(null);

        return button;

    }

}
