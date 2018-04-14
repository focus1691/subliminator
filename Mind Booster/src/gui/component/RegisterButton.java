package gui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import utility.FontPicker;

public class RegisterButton extends JButton {

	public RegisterButton(String name) {
		super(name);
		setBackground(Color.decode("#023b6a"));
		setForeground(Color.WHITE);
		setOpaque(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setFont(FontPicker.getFont(FontPicker.robotoRegular, 38.03f));
		setPreferredSize(new Dimension(125, 30));
	}
}
