package controller;

import database.Database;
import gui.premium.PremiumCheckerTask;
import model.User;
import validation.BCrypt;

public class UserController {

	private User user;
	private Database database;
	private boolean loggedIn = false;
	private final String tempLoginKey = "MjMGqzdkMSs4K4PNkN454Ufc";
	private PremiumCheckerTask premiumCheckerTask;

	public UserController(Database database) {
		this.database = database;
		user = new User();
		premiumCheckerTask = new PremiumCheckerTask(this);
	}

	public boolean isTempUserSelected(String tempLoginKey) {
		return tempLoginKey.equals(this.tempLoginKey) ? true : false;
	}

	public String login(String email, String pass) {

		if (email.isEmpty()) {
			return "Enter your username";
		}

		if (pass.isEmpty()) {
			return "Enter your password";
		}

		user = database.fetchUser(email);

		if (user == null) {
			return "User not found";
		} else {
			user.setUserPremium(database.isUserPremium(user.getId()));
		}

		if (BCrypt.checkpw(pass, user.getPassword())) {
			user.setPassword(pass);
			setLoggedIn(true);
			return "";
		}
		return "Incorrect credentials";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isUserPremium() {
		return user.isUserPremium();
	}

	public boolean fetchPremiumStatus() {
		return database.isUserPremium(user.getId());
	}

	public void setUserPremium(boolean premiumUser) {
		this.user.setUserPremium(premiumUser);
	}

	public void runPremiumPrompter() {	
		if (!premiumCheckerTask.isAlive()) {
			premiumCheckerTask = new PremiumCheckerTask(this);
			premiumCheckerTask.start();
			premiumCheckerTask.runPremiumReminder();
		}
	}

	public void stopPremiumPrompter() {
		if (!premiumCheckerTask.isInterrupted()) {
			premiumCheckerTask.interrupt();
			premiumCheckerTask.stopPremiumReminder();
		}
	}
	
	public void showPremiumPopup() {
		premiumCheckerTask.showPopup();
	}
}
