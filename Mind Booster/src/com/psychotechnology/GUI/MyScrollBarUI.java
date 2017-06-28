package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI {

	private final Dimension d = new Dimension();

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new JButton() {
			private static final long serialVersionUID = -6769040454180248987L;

			@Override
			public Dimension getPreferredSize() {
				return d;
			}
		};
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new JButton() {
			private static final long serialVersionUID = 7005267655062012321L;

			@Override
			public Dimension getPreferredSize() {
				return d;
			}
		};
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
		 c.setBackground(Color.decode("#f5f5f5"));
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color color = null;
		JScrollBar sb = (JScrollBar) c;
		if (!sb.isEnabled() || r.width > r.height) {
			return;
		}

		color = Color.decode("#2388d9");

		if (r.getY() < -1) {
			r.y = -1;
		}

		g2.setPaint(color);
		g2.fillRoundRect(r.x, r.y, r.width, r.height - 8, 15, 15);
		g2.setPaint(Color.WHITE);
		g2.drawRoundRect(r.x, r.y, r.width, r.height - 8, 15, 15);
		g2.dispose();
	}

	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, width, height);
		scrollbar.repaint();
	}
}