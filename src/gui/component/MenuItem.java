package gui.component;

import java.awt.Color;

import javax.swing.JMenuItem;

import utility.FontPicker;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem {

	public MenuItem(String name) {
		super(name);
		setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		setForeground(Color.WHITE);
		setBackground(Color.decode("#1975bf"));
		setOpaque(true);
	}
}
