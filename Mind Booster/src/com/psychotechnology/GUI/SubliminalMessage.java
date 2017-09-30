package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class SubliminalMessage extends JPanel {

	private static final long serialVersionUID = -7806435918984466627L;
	private String message;
	private Image img;

	public SubliminalMessage() {
		setOpaque(false);
		setPreferredSize(new Dimension(600, 300));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int x, y;
		
	    FontMetrics metrics = g2d.getFontMetrics(new Font("Courier New", Font.BOLD, 24));
	    x = this.getX() + (getWidth() - metrics.stringWidth(message)) / 2;
	    g2d.setFont(new Font("TimesRoman", Font.BOLD, 24));
	    g2d.setColor(Color.BLACK);
	    
	    //g.setFont(new Font("TimesRoman", Font.BOLD, 24));
	   
	    g2d.drawString(message, x, 40);

		if (img != null) {
		    x = (this.getWidth() - img.getWidth(null)) / 2;
		    y = (this.getHeight() - img.getHeight(null)) / 2;
		    g2d.drawImage(img, x, y, this);
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setImage(Image image) {
		this.img = image;
	}
}
