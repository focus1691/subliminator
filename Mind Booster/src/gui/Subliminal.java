package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Message;
import constants.ScreenPosition;
import utility.IconFetch;

public class Subliminal extends JFrame {

	private static final long serialVersionUID = 2931841309711143361L;
	private SubliminalMessage subliminalMessage;
	public static int height = 200;
	public static int width = 200;
	
	public Subliminal(ScreenPosition screenPosition) {
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
		subliminalMessage.setFont(message.getFont());
		subliminalMessage.setColor((message.getColor()==null?new Color(0,0,0):message.getColor()));
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
		if (icon != null) {
			System.out.println("Icon Set!");
			Image img = IconFetch.getInstance().getScaledImage(icon.getImage(), width, height);
			subliminalMessage.setImage(img);
		}else
		{
			System.out.println("Icon not set!");
		}
		subliminalMessage.setIsTextOnly(message.getIsTextOnly());
		
	}

}