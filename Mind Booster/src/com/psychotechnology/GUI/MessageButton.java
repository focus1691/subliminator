package com.psychotechnology.GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MessageButton extends JButton {
	
	private static final long serialVersionUID = -890456094498670386L;
	private String categoryName;
	private ImageIcon image;
	private int x, y, w, h;

	public MessageButton(String categoryName, ImageIcon image, int x, int y, int w, int h) {
		super(categoryName, image);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setBounds(x, y, w, h);
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public void setImage(ImageIcon image) {
		this.image = image;
	}
}