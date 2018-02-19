package gui.subliminal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private Font message_font;
	private Color message_color;
	private boolean isTextOnly;
	
	public SubliminalMessage() {
		setOpaque(false);
		setPreferredSize(new Dimension(900, 450));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		FontMetrics metrics = g2d.getFontMetrics(new Font("Courier New", Font.BOLD, 24));
		Rectangle2D rect = metrics.getStringBounds(message, g2d);
		int x = this.getX() + (getWidth() - metrics.stringWidth(message)) / 2;
		int y;
		
		g2d.clearRect(0, 0, getWidth(), getHeight());
		
		g2d.setFont(message_font/*new Font("Courier New", Font.BOLD, 24)*/);
		g2d.setColor(Color.WHITE);
        g2d.fillRect(x,
                40 - metrics.getAscent(),
                (int) rect.getWidth(),
                (int) rect.getHeight());
        g2d.setColor(message_color/*Color.RED*/);
		g2d.drawString(message, x, 40);
		
		if (img != null && !isTextOnly) {
			x = (this.getWidth() - img.getWidth(null)) / 2;
			y = (this.getHeight() - img.getHeight(null)) / 2;
			g2d.drawImage(img, x, y, this);
		}
	}
	
	public void setMessage(String message) {
		this.message = message;
		repaint();
	}
	
	public void setImage(Image image) {
		this.img = image;
		repaint();
	}
	public void setFont(Font msgFont) {
		this.message_font = msgFont;
		repaint();
	}	
	public void setColor(Color msgColor) {
		this.message_color = msgColor;
		//System.out.println("Color: "+this.message_color);
		repaint();
	}	
	public void setIsTextOnly(boolean isTextOnly) {
		this.isTextOnly = isTextOnly;
		//System.out.println("Color: "+this.message_color);
		repaint();
	}		
}