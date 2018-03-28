package gui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import utility.FontPicker;

public class RegisterButton extends JButton {

	public RegisterButton(String name) {
		super(name);
		setBackground(Color.decode("#00FF00"));
		setForeground(Color.BLACK);
		setOpaque(false);
		setFont(FontPicker.getFont(FontPicker.latoBold, 28));
		setPreferredSize(new Dimension(125, 50));
	}

}
