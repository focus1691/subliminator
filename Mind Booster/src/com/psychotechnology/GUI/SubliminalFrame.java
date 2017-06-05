package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;

import com.psychotechnology.Model.Message;

public class SubliminalFrame {
	JFrame frame = new JFrame();
	JLabel message = new JLabel("");
	JLabel messageImage = new JLabel(new ImageIcon());
	String absolutePath;

	public SubliminalFrame(String absolutePath) {
		this.absolutePath = absolutePath;
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
			c.setBackground(new java.awt.Color(0, 0, 0, 0));
		}

		for (Component c : frame.getContentPane().getComponents()) {
			c.setBackground(new java.awt.Color(0, 0, 0, 0));
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
		int finalHeight = 350;

		System.out.println(absolutePath + msg.getImagePath());
		if (!new File(absolutePath + msg.getImagePath()).exists()) {
			finalHeight = 41;
		}

		rect1.y = (rect1.height - finalHeight) / 2;

		rect1.height = finalHeight;
		frame.setBounds(rect1);
		message.setText(msg.getMessage());
		setMessageLabelLocation();

		if (finalHeight == 350) {
			messageImage.setVisible(true);
			int messageImageHeight = 250;
			int messageImageWidth = 250;

			Image img = new ImageIcon(absolutePath + msg.getImagePath()).getImage();
			img = img.getScaledInstance(messageImageWidth, messageImageHeight, java.awt.Image.SCALE_SMOOTH);
			messageImage.setIcon(new ImageIcon(img));

			System.out.println("a");

			messageImage.setBounds((frame.getWidth() - messageImageWidth) / 2, message.getHeight() + 50,
					messageImageWidth, messageImageHeight);
		} else {
			messageImage.setVisible(false);
		}
	}
}