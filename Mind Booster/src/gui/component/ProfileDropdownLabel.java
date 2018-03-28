package gui.component;

import javax.swing.JLabel;

import utility.FontPicker;

public class ProfileDropdownLabel extends JLabel {

	public ProfileDropdownLabel() {
		super();
		setFont(FontPicker.getFont(FontPicker.latoBold, 18));
	}
}
