package gui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

import utility.FontPicker;

@SuppressWarnings("serial")
public class OrderButton extends JButton {
	
	private Shape shape;
	
	public OrderButton(String title) {
		super(title);

		setForeground(Color.WHITE);
		setBackground(Color.decode("#1975bf"));
		setFocusable(false);
		setOpaque(true);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 27.0f));

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
	
	@Override
	protected void paintComponent(Graphics g) {
		final int arcSize = getSize().height - 20;
		g.setColor(Color.decode("#2973c3"));
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(hints);
		g.fillRoundRect(0, 0, getSize().width, getSize().height, arcSize, arcSize);
		super.paintComponent(g);
	}

	@Override
	public boolean contains(int x, int y) {
		// If the button has changed size, make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

}
