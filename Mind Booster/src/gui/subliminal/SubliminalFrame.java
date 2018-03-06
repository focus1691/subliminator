package gui.subliminal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.ScreenPosition;
import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import model.Message;

public class SubliminalFrame extends JFrame {

	private static final long serialVersionUID = 2931841309711143361L;
	private SubliminalMessage subliminalMessage;
	private boolean active;
	public static int height = 200;
	public static int width = 200;
	private Font font;
	private Color color;

	public SubliminalFrame(ScreenPosition screenPosition) {
		initComponents();
		
		setFocusable(false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setAlwaysOnTop(true);
		setSize(SetScreenLocation.screenSize.width, SetScreenLocation.screenSize.height);
		setFocusableWindowState(false);
		setEnabled(false);
		pack();

		setMessageLocation(screenPosition);
	}

	private void initComponents() {
		subliminalMessage = new SubliminalMessage();
		add(subliminalMessage);
	}

	private void setMessageLocation(ScreenPosition messageLocation) {

		switch (messageLocation) {
		case CENTER:
			SetScreenLocation.center(this);
			break;
		case TOPLEFT:
			SetScreenLocation.topLeft(this);
			break;
		case TOPRIGHT:
			SetScreenLocation.topRight(this);
			break;
		case BOTLEFT:
			SetScreenLocation.botLeft(this);
			break;
		case BOTRIGHT:
			SetScreenLocation.botRight(this);
			break;
		default:
			break;
		}
	}

	public void setMessage(Message message) {
		subliminalMessage.setMessage(message.getMessage());
		subliminalMessage.setFont(font);
		subliminalMessage.setColor(color == null ? new Color(0, 0, 0) : color);
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}