package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.util.IconFetch;

public class EditImage extends JDialog {

	private static final long serialVersionUID = 8614724076980880135L;
	private Controller controller;
	private JLabel deleteMsg;
	private JButton deleteBtn;
	private JLabel oldImg, newImg;
	private JTextArea messagesToDelete;
	
	public EditImage(Controller controller, String imgPath) {
		this.controller = controller;
		
		initComponents(imgPath);
		setupUI();
		
		MainFrame.centerFrame(this);
		setSize(400, 350);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void initComponents(String imgPath) {

		Image image = getScaledImage(IconFetch.getInstance().getIcon(imgPath).getImage(), 200, 200);
		oldImg = new JLabel(new ImageIcon(image));
		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JButton("Yes");

		messagesToDelete = new JTextArea();
	}
	
	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	public void setupUI() {
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth =1;
		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.LINE_START;
		add(deleteMsg, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth =1;
		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.LINE_START;
		add(oldImg, gc);
	}
}
