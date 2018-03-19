package controller;

import database.Database;
import model.User;
import validation.BCrypt;

public class UserController {

	private User user;
	private Database database;
	private boolean loggedIn = false;
	private final static String versionURL = "http://localhost:1337/PsychoTechnology/version.html";
	private final static String historyURL = "http://localhost:1337/PsychoTechnology/history.html";

	public UserController(Database database) {
		this.database = database;
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
		}
		
		if (BCrypt.checkpw(pass, user.getPassword())) {
			setLoggedIn(true);
			return "";
		}
		return "Incorrect credentials";
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
