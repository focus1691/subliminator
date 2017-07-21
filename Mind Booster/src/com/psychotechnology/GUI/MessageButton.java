package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.psychotechnology.util.CustomFont;

public class MessageButton extends JLabel {

	private static final long serialVersionUID = -890456094498670386L;
	private String categoryName;
	private ImageIcon image;
	private int x, y, w, h;
	private double btnToScreenWRatio, btnToScreenHRatio;
	private boolean active = false;
	private Font font = CustomFont.getFont(CustomFont.latoBlack, 20);

	public boolean isActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
		setForeground(Color.decode("#29de31"));
	}
	
	public void setInactive() {
		this.active = false;
		setForeground(Color.GRAY);
		setBackground(Color.WHITE);
	}

	public MessageButton(String categoryName, boolean active, int x, int y, int w, int h) {
		super(categoryName, SwingConstants.CENTER);
		this.active = active;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		setupUI();
	}

	private void setupUI() {
		setHorizontalTextPosition(SwingConstants.CENTER);
		setBounds(x, y, w, h);
		setFont(font);
		setForeground(Color.decode("#29de31"));
		setBackground(Color.WHITE);
		setOpaque(true);
		if (isActive())
			setActive();
		else if (!isActive())
			setInactive();
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