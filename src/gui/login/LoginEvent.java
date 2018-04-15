package gui.login;

import java.util.EventObject;

@SuppressWarnings("serial")
public class LoginEvent extends EventObject {

	private String user;
	private String pass;

	public LoginEvent(Object source, String user, String pass) {
		super(source);
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
