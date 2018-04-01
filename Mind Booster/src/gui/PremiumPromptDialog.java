package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JDialog;

import gui.util.IconFetch;
import gui.util.SetScreenLocation;

public class PremiumPromptDialog extends JDialog {
	
	public PremiumPromptDialog() {
		setTitle(MainFrame.appName);
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				IconFetch.getInstance().getIcon("/images/cursor.png").getImage(), new Point(0, 0),
				"custom cursor"));
		setIconImage(IconFetch.getInstance().getIcon("/images/icon.png").getImage());
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(700, 500));
		pack();
		SetScreenLocation.centerFrame(this);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
