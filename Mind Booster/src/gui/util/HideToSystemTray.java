package gui.util;

import java.awt.AWTException;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import gui.MainFrame;

public class HideToSystemTray {

	private JFrame frame;
	private PopupMenu trayPopupMenu;
	private SystemTray systemTray;
	private TrayIcon trayIcon;

	public HideToSystemTray(JFrame frame) {
		this.frame = frame;
		setup();
	}

	private void setup() {
		trayPopupMenu = new PopupMenu();
		systemTray = SystemTray.getSystemTray();

		trayIcon = new TrayIcon(IconFetch.getInstance().getIcon("/images/editItem.png").getImage(),
				MainFrame.appName, trayPopupMenu);
		trayIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				systemTray.remove(trayIcon);
				frame.setVisible(true);
			}
		});
		
		frame.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				if (e.getNewState() == JFrame.ICONIFIED) {
					try {
						System.out.println("Iconified");
						systemTray.add(trayIcon);
						frame.setVisible(false);
					} catch (AWTException ex) {
						System.out.println("unable to add to tray");
					}
				}
				if (e.getNewState() == 7) {
					try {
						System.out.println("7");
						systemTray.add(trayIcon);
						frame.setVisible(false);
					} catch (AWTException ex) {
						System.out.println("unable to add to system tray");
					}
				}
				if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
					System.out.println("maximised");
					systemTray.remove(trayIcon);
					frame.setVisible(true);
					System.out.println("Tray icon removed");
				}
				if (e.getNewState() == JFrame.NORMAL) {
					System.out.println("normal");
					systemTray.remove(trayIcon);
					frame.setVisible(true);
					System.out.println("Tray icon removed");
				}
			}
		});
	}
	
	public void hide() {
		
	}
}
