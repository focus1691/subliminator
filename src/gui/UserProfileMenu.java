package gui;

import java.awt.Color;
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
import gui.settings.SettingsPanel;
import model.User;
import utility.FontPicker;

@SuppressWarnings("serial")
public class UserProfileMenu extends JPopupMenu implements ActionListener, LoginListener {

	private LoginFrame loginFrame;
	private SettingsPanel settingsPanelReference;
	private ProfileDropdownLabel profileDropdownLabel;
	private UserController userController;
	private MenuItem premiumItem, loginItem, logoutItem;
	private LoginListener loginListener;

	public UserProfileMenu(UserController userController, ProfileDropdownLabel profileDropdownLabel,
			SettingsPanel settingsPanelReference) {
		super();

		this.userController = userController;
		this.profileDropdownLabel = profileDropdownLabel;
		this.settingsPanelReference = settingsPanelReference;

		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	}

	public void createMenuItemsForBasicUser() {
		premiumItem = new MenuItem("Get Premium");
		styleMenuItem(premiumItem);

		logoutItem = new MenuItem("Logout");
		styleMenuItem(logoutItem);
		logoutItem.addActionListener(this);

		if (userController.isPremium() == false) {
			add(premiumItem);
		}
		add(logoutItem);
	}

	public void createMenuItemsForPremiumUser() {
		premiumItem = new MenuItem("Get Premium");
		styleMenuItem(premiumItem);
		logoutItem = new MenuItem("Logout");
		styleMenuItem(logoutItem);
		logoutItem.addActionListener(this);

		if (userController.isPremium() == false) {
			add(premiumItem);
		}
		add(logoutItem);
	}

	public void createMenuItemsForTempUser() {
		loginItem = new MenuItem("Login");
		styleMenuItem(loginItem);
		loginItem.addActionListener(this);
		premiumItem = new MenuItem("Premium");
		styleMenuItem(premiumItem);

		add(loginItem);
		add(premiumItem);
	}

	public void removeMenuItems() {
		remove(loginItem);
		remove(premiumItem);
	}
	
	private void styleMenuItem(MenuItem item) {
		item.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		item.setForeground(Color.BLACK);
		item.setBackground(Color.decode("#dbdbdb"));
		item.setOpaque(true);
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

		if (userController.isTempUserSelected(event.getUser())) {
			loginFrame.setErrorMessage("Already logged in as temp user");
		} else {

			String errorMessage = userController.authenticateUser(event.getUser(), event.getPass());

			if (userController.isAuthenticated() == false) {
				loginFrame.setErrorMessage(errorMessage);
			} else {
				loginFrame.dispose();
				removeMenuItems();

				User user = userController.getUser();
				profileDropdownLabel.setText(user.getFirstName() + " " + user.getLastName());

				if (userController.isPremium() == true) {
					profileDropdownLabel.setToPremium();
					createMenuItemsForPremiumUser();
				} else {
					if (settingsPanelReference.isMoreThanOneMsgSelected() == true) {
						settingsPanelReference.deactivateActiveMessages();
					}
					profileDropdownLabel.setToBasic();
					createMenuItemsForBasicUser();
				}
			}
		}
	}

	@Override
	public void logoutEventOccurred(LogoutEvent event) {
		// TODO Auto-generated method stub
	}
}
