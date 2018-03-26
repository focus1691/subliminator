package gui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JButton;

public class JRoundRectButton extends JButton {
	// for mouse detection purposes
	Shape shape;

	public JRoundRectButton(String label) {
		super(label);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.decode("#2973c3"));
		setBackground(Color.WHITE);
		setFocusPainted(false);
	}
	
	protected void paintComponent(Graphics g) {
		final int arcSize = getSize().height;
		g.setColor(Color.WHITE);
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(hints);
		g.fillRoundRect(0, 0, getSize().width, getSize().height, arcSize, arcSize);
		super.paintComponent(g);
	}


}
