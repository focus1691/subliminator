package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.ScreenPosition;
import com.psychotechnology.util.IconFetch;

public class Subliminal extends JFrame {

	private static final long serialVersionUID = 2931841309711143361L;
	private static Dimension screenSize;
	private SubliminalMessage subliminalMessage;
	private final int h = 200;
	private final int w = 200;

	public Subliminal(ScreenPosition screenPosition) {
		initComponents();
		
		// Subliminal Message
		//subliminalMessage.getMessage().setFont(new Font("Courier New", Font.BOLD, 24));
		//subliminalMessage.getMessage().setBackground(Color.WHITE);
		//subliminalMessage.getMessage().setOpaque(true);
		//subliminalMessage.setPreferredSize(new Dimension(600, 300));
		
		setFocusable(false);
		setUndecorated(true);
		setBackground(new Color(0, 255, 0, 0));
		setAlwaysOnTop(true);
		setSize(600, 500);
		setFocusableWindowState(false);
		setEnabled(false);
		pack();

		setMessageLocation(screenPosition);
	}

	private void initComponents() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		subliminalMessage = new SubliminalMessage();
		add(subliminalMessage);
	}

	private void setMessageLocation(ScreenPosition messageLocation) {

		switch (messageLocation) {
		case CENTER:
			setCenter();
			break;
		case TOPLEFT:
			setTopLeft();
			break;
		case TOPRIGHT:
			setTopRight();
			break;
		case BOTLEFT:
			setBotLeft();
			break;
		case BOTRIGHT:
			setBotRight();
			break;
		default:
			break;
		}
	}

	private void setCenter() {
		int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
		int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
		setLocation(x, y);
	}

	private void setTopLeft() {
		setLocation(0, 0);
	}

	private void setTopRight() {
		int x = (int) ((screenSize.getWidth() - getWidth()));
		setLocation(x, 0);
	}

	private void setBotLeft() {
		int y = (int) ((screenSize.getHeight() - getHeight()));
		setLocation(0, y);
	}

	private void setBotRight() {
		int x = (int) ((screenSize.getWidth() - getWidth()));
		int y = (int) ((screenSize.getHeight() - getHeight()));
		setLocation(x, y);
	}

	public void setMessage(Message message) {
		subliminalMessage.setMessage(message.getMessage());
		ImageIcon icon = IconFetch.getInstance().getIcon(message.getImagePath());
		if (icon != null) {
			Image img = getScaledImage(icon.getImage(), w, h);
			subliminalMessage.setImage(img);
		}
		pack();
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