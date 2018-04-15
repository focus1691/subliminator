package gui.component;

import javax.swing.JLabel;

import gui.util.IconFetch;
import utility.FontPicker;

@SuppressWarnings("serial")
public class ProfileDropdownLabel extends JLabel {

	public ProfileDropdownLabel() {
		super();
		setFont(FontPicker.getFont(FontPicker.latoBold, 18));
	}

	public void setToUnregistered() {
		setText("UNREGISTERED");
		setIcon(IconFetch.getInstance().getIcon("/images/star-black.png"));
	}

	public void setToBasic() {
		setIcon(IconFetch.getInstance().getIcon("/images/star-black.png"));
		setToolTipText("Basic Account");
	}

	public void setToPremium() {
		setIcon(IconFetch.getInstance().getIcon("/images/star-gold.png"));
		setToolTipText("Basic Account");
	}
}
