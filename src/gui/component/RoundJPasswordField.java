package gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class RoundJPasswordField extends JPasswordField {

	private Shape shape;
	private String placeholder;

	public RoundJPasswordField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		final Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		
		super.paintComponent(g);

		if (placeholder.length() == 0 || String.valueOf(getPassword()).length() > 0) {
			return;
		}

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getDisabledTextColor());
		g2d.drawString(placeholder, getInsets().left, g2d.getFontMetrics().getMaxAscent() + getInsets().top);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	@Override
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(final String s) {
		placeholder = s;
	}
}
