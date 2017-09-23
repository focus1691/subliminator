package com.psychotechnology.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.psychotechnology.Controller.Controller;

public class ChangeImage extends JDialog {

	private static final long serialVersionUID = 8614724076980880135L;
	private Controller controller;
	private JPanel oldImg, newImg;
	
	public ChangeImage(Controller controller) {
		this.controller = controller;
		
		initComponents();
		setupUI();
		
		MainFrame.centerFrame(this);
		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void initComponents() {

		oldImg = new JPanel();
		newImg = new JPanel();
		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JButton("Yes");
		panel.add(deleteMsg);
		panel.add(deleteBtn);

		messagesToDelete = new JTextArea();
	}

	public void setupUI() {
		setSize(400, 350);
		setLayout(new BorderLayout());

		add(panel, BorderLayout.NORTH);
		add(messagesToDelete, BorderLayout.CENTER);
	}
	
}
