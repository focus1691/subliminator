package com.psychotechnology.GUI.Category;

import java.util.EventListener;

/**
 * The LoginListener interface is used to listen to a possible login/logout
 * event.
 * 
 * @author Joshua
 *
 */
public interface CategoryListener extends EventListener {
	/**
	 * The loginEventOccurred abstract method is used by MainFrame to listen to
	 * a possible button click on 'Logout' inside either the admin or user
	 * panel.
	 * 
	 * @param e
	 *            the event of a button click on 'Logout'
	 */
	public void categorySelectionEventOccurred(CategoryEvent e);
}