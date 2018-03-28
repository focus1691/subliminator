package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;

import controller.UserController;
import gui.component.MenuItem;
import gui.component.ProfileDropdownLabel;
import gui.login.LoginEvent;
import gui.login.LoginFrame;
import gui.login.LoginListener;
import gui.login.LogoutEvent;
import gui.util.IconFetch;
import model.User;

public class UserProfileMenu extends JPopupMenu implements ActionListener, LoginListener {

	private LoginFrame loginFrame;
	private ProfileDropdownLabel profileDropdownLabel;
	private UserController userController;
	private MenuItem premiumItem, loginItem, logoutItem;
	private LoginListener loginListener;

	public UserProfileMenu(UserController userController, ProfileDropdownLabel profileDropdownLabel) {
		super();

		this.userController = userController;
		this.profileDropdownLabel = profileDropdownLabel;

		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	}

	public void createMenuItemsForUserLoggedIn() {
		premiumItem = new MenuItem("Get Premium");
		logoutItem = new MenuItem("Logout");
		logoutItem.addActionListener(this);

		if (userController.isUserPremium() == false) {
			add(premiumItem);
		}
		add(logoutItem);
	}

	public void createMenuItemsForTempUser() {
		loginItem = new MenuItem("Login");
		loginItem.addActionListener(this);
		premiumItem = new MenuItem("Premium");

		add(loginItem);
		add(premiumItem);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == loginItem) {
			loginFrame = new LoginFrame();
			loginFrame.setLoginListener(this);
		} else if (ae.getSource() == logoutItem) {
			if (loginListener != null) {
				LogoutEvent logoutEvent = new LogoutEvent(this);
				loginListener.logoutEventOccurred(logoutEvent);
			}
		}
	}
	
	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}

	@Override
	public void loginEventOccurred(LoginEvent event) {
		String message = userController.login(event.getUser(), event.getPass());

		if (userController.isLoggedIn()) {
			loginFrame.dispose();

			User user = userController.getUser();
			profileDropdownLabel.setText(user.getFirstName() + " " + user.getLastName());

			if (userController.isUserPremium()) {
				profileDropdownLabel.setIcon(IconFetch.getInstance().getIcon("/images/star-gold.png"));
				profileDropdownLabel.setToolTipText("Premium member");
			} else {
				profileDropdownLabel.setIcon(IconFetch.getInstance().getIcon("/images/star-black.png"));
				profileDropdownLabel.setToolTipText("Basic Account");
			}

			removeAll();

			createMenuItemsForUserLoggedIn();
		} else {
			loginFrame.setErrorMessage(message);
		}
	}

	@Override
	public void logoutEventOccurred(LogoutEvent event) {
		// TODO Auto-generated method stub
	}
}
