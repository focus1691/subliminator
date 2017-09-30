package com.psychotechnology.GUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PictureLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;

	public PictureLabel(ImageIcon icon) {
		super();
		this.imageIcon = icon;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imageIcon != null) {
			g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public void changeText() {
		this.setText("aaaaa");
	}
}