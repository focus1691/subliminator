package gui.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
		g.fillOval(getWidth() / 8, getHeight() / 8, 19, 19);
	}
	
	public Color getActiveColour() {
		return activeColour;
	}
	
	public void setActiveColour(Color activeColour) {
		this.activeColour = activeColour;
	}
}