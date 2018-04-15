package gui.component;

import java.awt.Color;

import javax.swing.JRadioButtonMenuItem;

import utility.FontPicker;

public class BlueGreyRadioButtonMenuItem extends JRadioButtonMenuItem {
	
	public BlueGreyRadioButtonMenuItem(String name) {
		super(name);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		setForeground(Color.BLACK);
		setBackground(Color.decode("#dbdbdb"));
		setOpaque(true);
	}

}
