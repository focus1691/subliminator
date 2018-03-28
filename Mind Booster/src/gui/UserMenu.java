package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.login.LoginListener;
import gui.login.LogoutEvent;

public class UserMenu extends JPopupMenu implements ActionListener {

	private JMenuItem premiumItem, loginItem, logoutItem;
	private LoginListener loginListener;

	public UserMenu() {
		super();
	}

	public void createMenuItemsForUserLoggedIn(boolean isPremium) {
		premiumItem = new JMenuItem("Get Premium");
		logoutItem = new JMenuItem("Logout");
		logoutItem.addActionListener(this);

		if (!isPremium) {
			add(premiumItem);
		}
		add(logoutItem);
	}

	public void createMenuItemsForTempUser() {
		loginItem = new JMenuItem("Login");
		premiumItem = new JMenuItem("Premium");

		add(loginItem);
		add(premiumItem);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == logoutItem) {
			if (loginListener != null) {
				LogoutEvent logoutEvent = new LogoutEvent(this);
				loginListener.logoutEventOccurred(logoutEvent);
			}
		}
	}

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}
}
