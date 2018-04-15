package gui.component;

import java.awt.Color;

import utility.FontPicker;

@SuppressWarnings("serial")
public class BlueGreyRadioItem extends RadioItem {
	
	public BlueGreyRadioItem(String name) {
		super(name);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		setForeground(Color.BLACK);
		setBackground(Color.decode("#dbdbdb"));
		setOpaque(true);
	}

}
