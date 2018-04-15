package gui.component;

import java.awt.Color;

import javax.swing.JMenuItem;

import utility.FontPicker;

public class BlueGreyMenuItem extends JMenuItem {
	
	public BlueGreyMenuItem(String name) {
		super(name);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		setForeground(Color.BLACK);
		setBackground(Color.decode("#dbdbdb"));
		setOpaque(true);
	}
}
