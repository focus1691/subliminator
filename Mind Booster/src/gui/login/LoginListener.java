package gui.login;

import java.util.EventListener;

public interface LoginListener extends EventListener {
	
	public void loginEventOccurred(LoginEvent event);
	public void logoutEventOccurred(LoginEvent event);
}
