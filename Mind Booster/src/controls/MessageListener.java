package controls;

import java.util.EventListener;

/**
 * The LoginListener interface is used to listen to a possible login/logout
 * event.
 * 
 * @author
 *
 */
public interface MessageListener extends EventListener {
	/**
	 * The loginEventOccurred abstract method is used by MainFrame to listen to
	 * a possible button click on 'Logout' inside either the admin or user
	 * panel.
	 * 
	 * @param e
	 *            the event of a button click on 'Logout'
	 */
	public void messageEventOccurred(MessageEvent e);

	public void messageSelectionEventOccurred(MessageEvent e);

	public void addMessageEventOccurred(MessageEvent e);

	public void editMessageEventOccurred(MessageEvent e);

	public void deleteMessageEventOccurred(MessageEvent e);

	public void editImageEventOccurred(MessageEvent e);
}