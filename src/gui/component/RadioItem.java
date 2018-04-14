package gui.component;

import java.awt.Color;

import javax.swing.JRadioButtonMenuItem;

import utility.FontPicker;

public class RadioItem extends JRadioButtonMenuItem {

	public RadioItem(String name) {
		super(name);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		setForeground(Color.WHITE);
		setBackground(Color.decode("#1975bf"));
		setOpaque(true);
	}
}
