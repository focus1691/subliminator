package gui.subliminal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class SubliminalMessage extends JPanel {

	private static final long serialVersionUID = -7806435918984466627L;
	private String message;
	private Image img;
	private Font font;
	private Color color;
	private Color activeBackground;
	private boolean isBackgroundSelected;
	private boolean isTextOnly;

	public SubliminalMessage() {
		setOpaque(false);
		setPreferredSize(new Dimension(900, 450));
	}

	static int count = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2d = (Graphics2D) g;

		FontMetrics metrics = g2d.getFontMetrics(font);

		Rectangle2D rect = metrics.getStringBounds(message, g2d);

		int x = getX() + (getWidth() - metrics.stringWidth(message)) / 2;
		int y;

		g.clearRect(0, 0, getWidth(), getHeight());
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setFont(font);
		g2d.setColor(isBackgroundSelected ? activeBackground
				: new Color(color.getRed(), color.getGreen(), color.getBlue(), 0));

		g2d.fillRect(x, 40 - metrics.getAscent(), (int) rect.getWidth(), (int) rect.getHeight());
		g2d.setColor(color);

		if (!message.equals("")) {

			g2d.drawString(message, x, 40);
			repaint();
		}

		if (img != null && !isTextOnly) {
			x = (getWidth() - img.getWidth(null)) / 2;
			y = (getHeight() - img.getHeight(null)) / 2;
			g2d.drawImage(img, x, y, this);
		}
		message = "";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setImage(Image image) {
		this.img = image;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getActiveBackground() {
		return activeBackground;
	}

	public void setActiveBackground(Color activeBackground) {
		this.activeBackground = activeBackground;
	}

	public boolean isBackgroundSelected() {
		return isBackgroundSelected;
	}

	public void setBackgroundSelected(boolean isBackgroundSelected) {
		this.isBackgroundSelected = isBackgroundSelected;
	}

	public void setIsTextOnly(boolean isTextOnly) {
		this.isTextOnly = isTextOnly;
	}
}