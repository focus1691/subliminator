package gui.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class SetScreenLocation {
	
	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * A general-purpose method to vertically and horizontally center a window.
	 * http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
	 */
	public static void centerFrame(JFrame frame) {
		int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}
	
	
	public static void centerFrame(JDialog dialog) {
		int x = (int) ((screenSize.getWidth() - dialog.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - dialog.getHeight()) / 2);
		dialog.setLocation(x, y);
	}
	
	public static void center(JDialog message) {
		int x = (int) ((screenSize.getWidth() - message.getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - message.getHeight()) / 2);
		message.setLocation(x, y);
	}

	public static void topLeft(JDialog message) {
		message.setLocation(0, 0);
	}

	public static void topRight(JDialog message) {
		int x = (int) ((screenSize.getWidth() - message.getWidth()));
		message.setLocation(x, 0);
	}

	public static void botLeft(JDialog message) {
		int y = (int) ((screenSize.getHeight() - message.getHeight()));
		message.setLocation(0, y);
	}

	public static void botRight(JDialog message) {
		int x = (int) ((screenSize.getWidth() - message.getWidth()));
		int y = (int) ((screenSize.getHeight() - message.getHeight()));
		message.setLocation(x, y);
	}
}