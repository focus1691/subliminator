package gui.controls.dialogs;

import java.awt.BorderLayout;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	public static final int W = 400, H = 350;
	private MessageController controller;
	private JLabel deleteMsg;
	private JButton deleteBtn;
	private JLabel oldImg, newImg;
	private JTextArea messagesToDelete;
	private JButton delete_image;
	private JButton browseBtn;
	private JButton ok_button;
	private String imgPath;
	private String selectedImage_path;
	private String selectedImage_name;
	private Message message;
	private int selected_message;
	private MessagePanel messagePanel;

	public EditImage(MessageController controller, Message message, MessagePanel messagePanel, int index) {
		super("Edit Image", false, true, false, false);
		this.controller = controller;
		this.message = message;
		this.messagePanel = messagePanel;
		this.imgPath = message.getImagePath();
		selected_message = index;
		initComponents();
		setupUI();
		getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(W, H);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public void initComponents() {
		oldImg = new JLabel();
		if (!imgPath.isEmpty()) {
			Image image = null;
			if (IconFetch.getInstance().getIcon(imgPath) != null)
				image = getScaledImage(IconFetch.getInstance().getIcon(imgPath).getImage(), 250, 200);
			else
				image = getScaledImage(new ImageIcon(imgPath).getImage(), 250, 200);
			oldImg.setIcon(new ImageIcon(image));
		}

		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JRoundRectButton("Yes");
		deleteBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));

		browseBtn = new JRoundRectButton("Browse");
		browseBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		
		delete_image = new JRoundRectButton("Delete");
		delete_image.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		
		browseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(".");
				int result = chooser.showOpenDialog(EditImage.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedImage_path = chooser.getSelectedFile().getAbsolutePath();
					selectedImage_name = chooser.getSelectedFile().getName();
				}
			}
		});

		ok_button = new JRoundRectButton("OK");
		ok_button.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		ok_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (!selectedImage_path.isEmpty()) {
					try {
						Files.copy(new File(selectedImage_path).toPath(), new File(System.getProperty("user.dir")
								+ "/src/com/psychotechnology/images/" + selectedImage_name).toPath());
						String new_image = System.getProperty("user.dir") + "/src/com/psychotechnology/images/"
								+ selectedImage_name;
						message.setPath(new_image);
						controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
								.get(selected_message).setPath(new_image);

						messagePanel.removeMessages();
						messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
						dispose();

					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
					}
				}
			}
		});
		setTitle("Edit image of: " + message.getMessage());
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
		add(oldImg, gc);

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
		add(ok_button, gc);
		
		gc.gridx++;
		add(delete_image, gc);
	}
}
