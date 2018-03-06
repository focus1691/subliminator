package gui.custom;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	private Color activeColour;
	
	public CirclePanel(Color color) {
		setOpaque(true);
		setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(activeColour);
		g.fillOval(40, 0, 13, 13);
	}
	
	public Color getActiveColour() {
		return activeColour;
	}
	
	public void setActiveColour(Color activeColour) {
		this.activeColour = activeColour;
	}
}