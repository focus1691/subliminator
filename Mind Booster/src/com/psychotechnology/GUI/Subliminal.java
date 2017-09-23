package com.psychotechnology.GUI;

import java.awt.Color;
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
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;

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
	private final int messageImageHeight = 250;
	private final int messageImageWidth = 250;
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
		subliminalMessage.getMessage().setSize(new Dimension(800, 400));
	}
	
	public void show() {
		subliminalContainer.setVisible(true);
	}
	
	public void hide() {
		subliminalContainer.setVisible(false);
	}
}