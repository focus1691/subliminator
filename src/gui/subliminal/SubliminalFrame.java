package gui.subliminal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import model.Message;

@SuppressWarnings("serial")
public class SubliminalFrame extends JDialog {

	private Preferences prefs;
	private SubliminalMessage subliminalMessage;
	private boolean active;
	public static int height = 200;
	public static int width = 200;
	private Font font;
	private Color color;
	private Color activeBackground;
	private boolean isBackgroundSelected;

	public SubliminalFrame() {
		prefs = Preferences.userRoot().node(this.getClass().getName());
		SubliminalFrame.width = prefs.getInt("messageW", SetScreenLocation.screenSize.width / 4);
		SubliminalFrame.height = prefs.getInt("messageW", SetScreenLocation.screenSize.height / 4);
		subliminalMessage = new SubliminalMessage();
		setContentPane(subliminalMessage);

		setFocusable(false);
		setUndecorated(true);
		getRootPane().setOpaque(false);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(0, 0, 0, 0));
		setAlwaysOnTop(true);
		setSize(SetScreenLocation.screenSize.width, SetScreenLocation.screenSize.height);
		setFocusableWindowState(false);
		setEnabled(false);
		pack();
	}

	public void setMessage(Message message) {
		subliminalMessage.setMessage(message.getMessage());
		subliminalMessage.setFont(font);
		subliminalMessage.setColor(color == null ? new Color(0, 0, 0) : color);
		subliminalMessage.setActiveBackground(activeBackground);
		subliminalMessage.setBackgroundSelected(isBackgroundSelected);
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
		if (icon != null) {
			Image img = IconFetch.getInstance().getScaledImage(icon.getImage(), width, height);
			subliminalMessage.setImage(img);
		}
		subliminalMessage.setIsTextOnly(message.getIsTextOnly());
	}

	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getActiveBackground() {
		return activeBackground;
	}

	public void setActiveBackground(Color activeBackground) {
		this.activeBackground = activeBackground;
	}

	public boolean isBackgroundSelected() {
		return isBackgroundSelected;
	}

	public void setBackgroundSelected(boolean isBackgroundSelected) {
		this.isBackgroundSelected = isBackgroundSelected;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public void changeMessageSize(int W, int H) {
		prefs.putInt("messageW", W);
		prefs.putInt("messageH", H);
		SubliminalFrame.width = W;
		SubliminalFrame.height = H;
	}
}