package com.psychotechnology.GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MessageButton extends JButton {
	
	private static final long serialVersionUID = -890456094498670386L;
	private String categoryName;
	private ImageIcon image;
	private double x, y, w, h;
	private double btnToScreenWRatio, btnToScreenHRatio;

	public MessageButton(String categoryName, ImageIcon image, int x, int y, int w, int h) {
		super(categoryName, image);
		setHorizontalTextPosition(SwingConstants.CENTER);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		setBounds(x, y, w, h);
	}
	
	public double getBtnToScreenWRatio() {
		return btnToScreenWRatio;
	}

	public void setBtnToScreenWRatio(double btnToScreenWRatio) {
		this.btnToScreenWRatio = btnToScreenWRatio;
	}

	public double getBtnToScreenHRatio() {
		return btnToScreenHRatio;
	}

	public void setBtnToScreenHRatio(double btnToScreenHRatio) {
		this.btnToScreenHRatio = btnToScreenHRatio;
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