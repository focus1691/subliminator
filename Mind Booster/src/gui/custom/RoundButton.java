package gui.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RoundButton extends JButton {

	private static final long serialVersionUID = 4982155778014540129L;
	// Hit detection.
	private Shape shape;

	public RoundButton(ImageIcon image) {
		super(image);

		setBackground(Color.lightGray);
		setFocusable(false);

		/*
		 * These statements enlarge the button so that it becomes a circle
		 * rather than an oval.
		 */
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		/*
		 * This call causes the JButton not to paint the background. This allows
		 * us to paint a round background.
		 */
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.decode("#efeff0"));
		} else {
			g.setColor(Color.decode("#efeff0"));
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	public boolean contains(int x, int y) {
		// If the button has changed size, make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
}