package gui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	private Color activeColour;

	public CirclePanel(Color color) {
		setOpaque(true);
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(26, 26));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(activeColour);
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(hints);
		g.fillOval(getWidth() / 8, getHeight() / 8, 19, 19);
	}

	public Color getActiveColour() {
		return activeColour;
	}

	public void setActiveColour(Color activeColour) {
		this.activeColour = activeColour;
	}
}