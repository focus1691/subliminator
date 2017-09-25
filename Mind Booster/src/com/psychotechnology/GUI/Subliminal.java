package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.MessageLocation;
import com.psychotechnology.util.IconFetch;

public class Subliminal {
	private SubliminalMessage subliminalMessage;
	private JFrame subliminalContainer = new JFrame();
	private MessageLocation messageLocation;
	private Rectangle messageBounds;
	private Dimension screenSize;
	private Rectangle rect1;
	private final int h = 250;
	private final int w = 250;
	private double subliminalHeight;

	String absolutePath;

	public Subliminal(String absolutePath, MessageLocation messageLocation) {
		this.absolutePath = absolutePath;
		this.messageLocation = messageLocation;
		
		initComponents();
		styleUI();
	}

	private void initComponents() {

		// Message window
		subliminalMessage = new SubliminalMessage();
		subliminalContainer = new JFrame();
		subliminalContainer.add(subliminalMessage);
	}

	private void styleUI() {
		// Subliminal Message
		subliminalMessage.getMessage().setFont(new Font("Courier New", Font.BOLD, 36));
		subliminalMessage.getMessage().setBackground(Color.WHITE);
		subliminalMessage.getMessage().setOpaque(true);
		
		subliminalContainer.setFocusable(false);
		subliminalContainer.setUndecorated(true);
		subliminalContainer.setBackground(new Color(0, 255, 0, 0));
		subliminalContainer.setAlwaysOnTop(true);
		subliminalContainer.setSize(500, 700);
		subliminalContainer.setFocusableWindowState(false);
		subliminalContainer.setEnabled(false);
		subliminalContainer.pack();
	}
	
	int c = 0;
	
	public void setMessage(Message message) {
		subliminalMessage.getMessage().setText(message.getMessage());
		Image img = getScaledImage(IconFetch.getInstance().getIcon(message.getImagePath()).getImage(), w, h);
		subliminalMessage.setImage(img);
		
		subliminalContainer.pack();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - subliminalContainer.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - subliminalContainer.getHeight()) / 2);
		subliminalContainer.setLocation(x, y);
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	public void show() {
		subliminalContainer.setVisible(true);
	}
	
	public void hide() {
		subliminalContainer.setVisible(false);
	}
}