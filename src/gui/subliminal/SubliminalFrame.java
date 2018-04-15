package gui.subliminal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import model.Message;

@SuppressWarnings("serial")
public class SubliminalFrame extends JDialog {

	private SubliminalMessage subliminalMessage;
	private boolean active;
	public static int height = 200;
	public static int width = 200;
	private Font font;
	private Color color;
	private Color activeBackground;
	private boolean isBackgroundSelected;

	public SubliminalFrame() {
		subliminalMessage = new SubliminalMessage();
		add(subliminalMessage);

		setFocusable(false);
		setUndecorated(true);
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
		System.out.println(message.getImagePath());
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
		System.out.println(icon);
		if (icon != null) {
			Image img = IconFetch.getInstance().getScaledImage(icon.getImage(), width, height);
			subliminalMessage.setImage(img);
		}
		subliminalMessage.setIsTextOnly(message.getIsTextOnly());
	}

	public Font getFont() {
		return font;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}