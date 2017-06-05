package com.psychotechnology.GUI;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class ContentPane extends JPanel {
	
	private static final long serialVersionUID = -7806435918984466627L;

	public ContentPane() {
		setOpaque(false);
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
		g2d.setColor(getBackground());
		g2d.fill(getBounds());
		g2d.dispose();

	}
}
