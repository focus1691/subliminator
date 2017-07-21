package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;

import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.MessageLocation;

public class SubliminalFrame {
	JFrame frame = new JFrame();
	JLabel message = new JLabel("");
	JLabel messageImage = new JLabel(new ImageIcon());
	private MessageLocation messageLocation;
	private Rectangle messageBounds;
	String absolutePath;

	public SubliminalFrame(String absolutePath, MessageLocation messageLocation) {
		this.absolutePath = absolutePath;
		this.messageLocation = messageLocation;
		messageLocation = MessageLocation.TOPLEFT;
		frame.setFocusable(false);
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 255, 0, 0));
		frame.setAlwaysOnTop(true);
		frame.setFocusableWindowState(false);
		frame.setFocusable(false);
		message.setFont(new Font("Courier New", Font.BOLD, 36));

		message.setText("");
		message.setOpaque(true);
		ContentPane pane = new ContentPane();

		pane.add(message);
		pane.add(messageImage);
		frame.setContentPane(pane);

		frame.setEnabled(false);

		for (Component c : frame.getComponents()) {
			c.setBackground(new Color(0, 0, 0, 0));
		}

		for (Component c : frame.getContentPane().getComponents()) {
			c.setBackground(new Color(0, 0, 0, 0));
		}

		Dimension size = message.getPreferredSize();

		switch (messageLocation) {
		case TOPLEFT:
			messageBounds = new Rectangle(0, 0, size.width, size.height);
			break;
		case TOPRIGHT:
			messageBounds = new Rectangle(frame.getWidth() - size.width, 0, size.width, size.height);
			break;
		case CENTER:
			messageBounds = new Rectangle((frame.getWidth() - size.width) / 2, 0, size.width, size.height);
			break;
		case BOTLEFT:
			messageBounds = new Rectangle(0, frame.getHeight() - size.height, size.width, size.height);
			break;
		case BOTRIGHT:
			messageBounds = new Rectangle(frame.getHeight() - size.height, frame.getHeight() - size.height, size.width,
					size.height);
			break;

		}

		message.setBackground(Color.WHITE);
		frame.pack();
	}

	public void show() {
		if (frame.isVisible() == false) {
			frame.setVisible(true);
		}
	}

	public void hide() {
		if (frame.isVisible() == true) {
			frame.setVisible(false);
			// frame.dispose();
		}
	}

	public void setMessageTopLeft() {
		Dimension size = message.getPreferredSize();

		message.setBounds(0, 0, size.width, size.height);

		if (message.getSize().getWidth() > frame.getSize().getWidth()) {
			Rectangle rect = message.getBounds();
			rect.x = 0;
			rect.width = (int) frame.getSize().getWidth();
			message.setBounds(rect);
		}

		message.setAlignmentX(SwingConstants.CENTER);
	}

	public void setMessageTopRight() {
		Dimension size = message.getPreferredSize();

		message.setBounds(frame.getWidth() - size.width, 0, size.width, size.height);

		if (message.getSize().getWidth() > frame.getSize().getWidth()) {
			Rectangle rect = message.getBounds();
			rect.x = 0;
			rect.width = (int) frame.getSize().getWidth();
			message.setBounds(rect);
		}

		message.setAlignmentX(SwingConstants.CENTER);
	}

	public void setMessageCenter() {
		Dimension size = message.getPreferredSize();

		message.setBounds((frame.getWidth() - size.width) / 2, 0, size.width, size.height);

		if (message.getSize().getWidth() > frame.getSize().getWidth()) {
			Rectangle rect = message.getBounds();
			rect.x = 0;
			rect.width = (int) frame.getSize().getWidth();
			message.setBounds(rect);
		}

		message.setAlignmentX(SwingConstants.CENTER);
	}

	private void setMessageLabelLocation() {

		Dimension size = message.getPreferredSize();

		message.setBounds((frame.getWidth() - size.width) / 2, 0, size.width, size.height);

		if (message.getSize().getWidth() > frame.getSize().getWidth()) {
			Rectangle rect = message.getBounds();
			rect.x = 0;
			rect.width = (int) frame.getSize().getWidth();
			message.setBounds(rect);
		}
		
		message.setAlignmentX(SwingConstants.CENTER);
	}

	public void setMessageAndImage(Message msg) {
		RootPaneContainer root = (RootPaneContainer) frame.getRootPane().getTopLevelAncestor();
		root.getGlassPane().setCursor(Cursor.getDefaultCursor());

		Rectangle rect1;
		rect1 = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double finalHeight = screenSize.getHeight();

		System.out.println(absolutePath + msg.getImagePath());
		if (!new File(absolutePath + msg.getImagePath()).exists()) {
			finalHeight = 41;
		}

		rect1.y = (int) ((rect1.height - finalHeight) / 2);

		rect1.height = (int) finalHeight;
		frame.setBounds(rect1);
		message.setText(msg.getMessage());

		messageImage.setVisible(true);
		int messageImageHeight = 250;
		int messageImageWidth = 250;

		Image img = new ImageIcon(absolutePath + msg.getImagePath()).getImage();
		img = img.getScaledInstance(messageImageWidth, messageImageHeight, Image.SCALE_SMOOTH);
		messageImage.setIcon(new ImageIcon(img));

		System.out.println("a");

		messageImage.setBounds((frame.getWidth() - messageImageWidth) / 2, message.getHeight() + 50, messageImageWidth,
				messageImageHeight);

	}
}