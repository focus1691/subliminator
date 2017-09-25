package com.psychotechnology.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joshua
 */
public class SubliminalMessage extends JPanel {

	private static final long serialVersionUID = -7806435918984466627L;
	private JLabel message = new JLabel();
	private JLabel image  = new JLabel();
	private ImageIcon icon = new ImageIcon();
	
	public SubliminalMessage() {
		setOpaque(false);
		setLayout(new BorderLayout());
		this.image.setHorizontalAlignment(JLabel.CENTER);
		this.image.setIcon(icon);
		add(message, BorderLayout.NORTH);
		add(image, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	}
	
	public JLabel getMessage() {
		return message;
	}
	
	public void setMessage(JLabel message) {
		this.message = message;
	}
	
	public JLabel getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		icon = new ImageIcon(image);
		this.image.setIcon(icon);
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
