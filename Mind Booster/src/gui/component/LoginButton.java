package gui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import utility.FontPicker;

public class LoginButton extends JButton {

	public LoginButton(String name) {
		super(name);
		setBackground(Color.decode("#1975bf"));
		setForeground(Color.WHITE);
		setOpaque(false);
		setFont(FontPicker.getFont(FontPicker.latoBold, 20));
		setPreferredSize(new Dimension(125, 50));
	}
}
