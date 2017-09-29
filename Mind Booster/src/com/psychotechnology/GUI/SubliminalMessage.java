package com.psychotechnology.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class SubliminalMessage extends JPanel {

	private static final long serialVersionUID = -7806435918984466627L;
	private JLabel message = new JLabel();
	private Image img;

	public SubliminalMessage() {
		setOpaque(false);
		add(message);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("paintcomponent");
		if (img != null) {
		    Graphics2D g2d = (Graphics2D) g;
		    int x = (this.getWidth() - img.getWidth(null)) / 2;
		    int y = (this.getHeight() - img.getHeight(null)) / 2;
		    g2d.drawImage(img, x, y, this);
		}
	}
	
	public JLabel getMessage() {
		return message;
	}

	public void setMessage(JLabel message) {
		this.message = message;
	}

	public void setImage(Image image) {
		this.img = image;
		repaint();
	}
}
