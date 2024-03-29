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

import gui.util.SetScreenLocation;

/**
 *
 * @author Joshua
 */
@SuppressWarnings("serial")
public class SubliminalMessage extends JPanel {

	private String message;
	private Image img;
	private Font font;
	private Color color;
	private Color activeBackground;
	private boolean isBackgroundSelected;
	private boolean isTextOnly;

	public SubliminalMessage() {
		setPreferredSize(new Dimension(new Dimension((int) (SetScreenLocation.screenSize.width * 0.5),
				(int) (SetScreenLocation.screenSize.height * 0.5))));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(new Color(0, 0, 0, 0));
		g2d.clearRect(0, 0, getWidth(), getHeight());

		FontMetrics metrics = g2d.getFontMetrics(font);

		Rectangle2D rect = metrics.getStringBounds(message, g2d);

		int x = getX() + (getWidth() - metrics.stringWidth(message)) / 2;
		int y;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(isBackgroundSelected ? activeBackground
				: new Color(color.getRed(), color.getGreen(), color.getBlue(), 0));
		g2d.setBackground(new Color(0, 0, 0, 0));
		g2d.clearRect(0, 0, getWidth(), getHeight());
		g2d.fillRect(x, 40 - metrics.getAscent(), (int) rect.getWidth(), (int) rect.getHeight());
		g2d.setColor(color);

		if (img != null && !isTextOnly) {
			g2d.drawString(message, x, 40);
			x = (getWidth() - img.getWidth(null)) / 2;
			y = (getHeight() - img.getHeight(null)) / 2;
			g2d.drawImage(img, x, y, this);
		} else {
			y = getHeight() / 2;
			g2d.drawString(message, x, 40);
		}
		repaint();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setImage(Image image) {
		this.img = image;
	}

	@Override
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