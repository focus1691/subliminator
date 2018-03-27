package gui.controls.dialogs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import constants.MessageTense;
import controller.MessageController;
import gui.component.JRoundRectButton;
import gui.message.MessagePanel;
import gui.util.IconFetch;
import model.Message;
import utility.FontPicker;

public class EditImage extends JInternalFrame {

	private static final long serialVersionUID = 8614724076980880135L;
	public static final int W = 400, H = 375;
	private MessageController controller;
	private JLabel displayImg;
	private JButton deleteBtn, browseBtn, okBtn;
	private String oldImgPath, selectedImgPath, selectedImageName;
	private Message message;
	private int messageIndex;
	private MessagePanel messagePanel;

	public EditImage(MessageController controller, Message message, MessagePanel messagePanel, int messageIndex) {
		super("Edit Image", false, true, false, false);
		this.controller = controller;
		this.message = message;
		this.messagePanel = messagePanel;
		this.oldImgPath = message.getImagePath();
		this.messageIndex = messageIndex;
		initComponents();
		setupUI();
		getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(W, H);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void initComponents() {
		displayImg = new JLabel();
		displayImg.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0),
				BorderFactory.createEtchedBorder()));
		if (!oldImgPath.isEmpty()) {
			Image image = null;
			if (IconFetch.getInstance().getIcon(oldImgPath) != null) {
				image = getScaledImage(IconFetch.getInstance().getIcon(oldImgPath).getImage(), 250, 275);
			} else {
				image = getScaledImage(new ImageIcon(oldImgPath).getImage(), 250, 275);
			}
			displayImg.setIcon(new ImageIcon(image));
		}
		browseBtn = new JRoundRectButton("Browse");
		browseBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		browseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(".");
				int result = chooser.showOpenDialog(EditImage.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedImgPath = chooser.getSelectedFile().getAbsolutePath();
					selectedImageName = chooser.getSelectedFile().getName();
					Image image = getScaledImage(new ImageIcon(selectedImgPath).getImage(), 250, 285);
					displayImg.setIcon(new ImageIcon(image));
				}
			}
		});

		deleteBtn = new JRoundRectButton("Delete");
		deleteBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		okBtn = new JRoundRectButton("OK");
		okBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (selectedImgPath != null && !selectedImgPath.isEmpty()) {
					try {
						Files.copy(new File(selectedImgPath).toPath(), new File(
								(System.getProperty("user.dir") + "/target/classes/images/" + selectedImageName))
										.toPath());
						String new_image = "/images/" + selectedImageName;
						message.setPath(new_image);
						controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
								.get(messageIndex).setPath(new_image);

						messagePanel.removeMessages();
						messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
						controller.save();
						dispose();

					} catch (Exception err) {
						err.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
					}
				} else {
					dispose();
				}
			}
		});
		setTitle("Edit image of: " + message.getMessage());
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, 250, 275, null);
		g2.dispose();

		return resizedImg;
	}

	public void setupUI() {
		setBackground(Color.decode("#1975bf"));
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.VERTICAL;
		gc.anchor = GridBagConstraints.CENTER;
		add(displayImg, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;
		add(browseBtn, gc);

		gc.gridx++;
		add(okBtn, gc);

		gc.gridx++;
		add(deleteBtn, gc);
	}
}
