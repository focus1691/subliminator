package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utility.CustomColor;
import utility.FontPicker;
import utility.IconFetch;

public class MessageButton extends JLabel {

	private static final long serialVersionUID = -890456094498670386L;
	private String categoryName;
	private ImageIcon image;
	private int x, y, w, h;
	private double btnToScreenWRatio, btnToScreenHRatio;
	private boolean active = false;
	private boolean locked = true;
	private Font font = FontPicker.getFont(FontPicker.latoBlack, 20);

	public boolean isActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
		setForeground(CustomColor.green);
	}

	public void setInactive() {
		this.active = false;
		setForeground(CustomColor.lightGrey);
		setBackground(Color.WHITE);
	}

	public MessageButton(String categoryName, boolean active, boolean locked, int x, int y, int w, int h) {
		super(categoryName, SwingConstants.CENTER);
		this.categoryName = categoryName;
		this.active = active;
		this.locked = locked;
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
		setForeground(CustomColor.green);
		setBackground(Color.WHITE);
		setOpaque(true);
		if (isActive()) setActive();
		else setInactive();
		if (isLocked()) lock();
		else unlock();
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

	public boolean isLocked() {
		return locked;
	}

	public void lock() {
		this.locked = true;
		this.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/lock2.png"));
	}
	
	public void unlock() {
		this.locked = false;
	}
}