package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.ScreenPosition;
import com.psychotechnology.util.IconFetch;

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
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
		if (icon != null) {
			Image img = getScaledImage(icon.getImage(), width, height);
			subliminalMessage.setImage(img);
		}
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
	
}