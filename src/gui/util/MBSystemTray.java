package gui.util;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import gui.MainFrame;

public class MBSystemTray {

	private JFrame frame;
	private PopupMenu trayPopupMenu;
	private SystemTray systemTray;
	private TrayIcon trayIcon;

	public MBSystemTray(JFrame frame) {
		this.frame = frame;
		setup();
	}

	private void setup() {
		trayPopupMenu = new PopupMenu();
		systemTray = SystemTray.getSystemTray();

		trayIcon = new TrayIcon(IconFetch.getInstance().getIcon("/images/icon-16x16.png").getImage(), MainFrame.appName,
				trayPopupMenu);
		trayIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				systemTray.remove(trayIcon);
				frame.setVisible(true);
				frame.setState(java.awt.Frame.NORMAL);
				frame.toFront();
			}
		});

		frame.addWindowStateListener(new WindowStateListener() {
			@Override
			public void windowStateChanged(WindowEvent e) {
				if (e.getNewState() == Frame.NORMAL) {
					systemTray.remove(trayIcon);
					frame.setVisible(true);
				}
			}
		});
	}

	public void hide() {
		try {
			systemTray.add(trayIcon);
			frame.setVisible(false);
		} catch (AWTException e) {
			System.err.println("unable to add to tray");
		}
	}
}
