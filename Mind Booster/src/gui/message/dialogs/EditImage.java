package gui.message.dialogs;

import java.awt.BorderLayout;
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
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import constants.MessageTense;
import controller.MessageController;
import gui.message.MessagePanel;
import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import model.Message;

public class EditImage extends JDialog {

	private static final long serialVersionUID = 8614724076980880135L;
	private MessageController controller;
	private JLabel deleteMsg;
	private JButton deleteBtn;
	private JLabel oldImg, newImg;
	private JTextArea messagesToDelete;
	private JButton delete_image;
	private JButton add_image;
	private JButton ok_button;
	private String imgPath;
	private String selectedImage_path;
	private String selectedImage_name;
	private Message message;
	private int selected_message;
	private MessagePanel messagePanel;
	public EditImage(MessageController controller, Message message, MessagePanel messagePanel, int index) {
		this.controller = controller;
		this.message=message;
		this.messagePanel=messagePanel;
		this.imgPath=message.getImagePath();
		selected_message=index;
		initComponents();
		setupUI();
		System.out.println("Current image: "+this.imgPath);
		SetScreenLocation.centerFrame(this);
		setSize(400, 350);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void initComponents() {

		System.out.println("imgPath: "+imgPath);
		oldImg = new JLabel();
		if(!imgPath.isEmpty())
		{
			Image image =null;
			if(IconFetch.getInstance().getIcon(imgPath)!=null)
				image = getScaledImage(IconFetch.getInstance().getIcon(imgPath).getImage(), 200, 200);
			else
				image = getScaledImage(new ImageIcon(imgPath).getImage(), 200, 200);
			oldImg.setIcon(new ImageIcon(image));
		}
		
		
		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JButton("Yes");
		
		add_image=new JButton("Select an Image");
		delete_image=new JButton("Delete Image");
		add_image.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser=new JFileChooser(".");
				int result=chooser.showOpenDialog(EditImage.this);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					selectedImage_path=chooser.getSelectedFile().getAbsolutePath();
					selectedImage_name=chooser.getSelectedFile().getName();
					oldImg.setIcon(new ImageIcon(getScaledImage(new ImageIcon(selectedImage_path).getImage(), 200, 200)));
					System.out.println("New Path: "+selectedImage_path+"=>"+selectedImage_name);
				}
			}
			
		});

		ok_button=new JButton("OK");
		ok_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!selectedImage_path.isEmpty())
				{
					try
					{
						Files.copy( new File(selectedImage_path).toPath(), new File(System.getProperty("user.dir")+"/src/com/psychotechnology/images/"+selectedImage_name).toPath() );
						String new_image=System.getProperty("user.dir")+"/src/com/psychotechnology/images/"+selectedImage_name;
						message.setPath(new_image);
						//SettingsPanel.pictureLabel.setIcon(new ImageIcon(getScaledImage(new ImageIcon(selectedImage_path).getImage(), 200, 200)));
						//JOptionPane.showMessageDialog(null, "The index: "+controller.getCategoryIndex());
						controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(selected_message).setPath(new_image);
						
						messagePanel.getModel().clear();
						//JOptionPane.showMessageDialog(null, "New Path: "+message.getImagePath());
						messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());						
						dispose();
						
					}catch(Exception err)
					{
						JOptionPane.showMessageDialog(null, "Error: "+err.getMessage());
					}
				}
				//dispose();
			}
			
		});
		setTitle("Edit image of: "+message.getMessage());
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
		
		JPanel current_panel=new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		current_panel.setLayout(gbl);
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth =1;
		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.LINE_START;
		current_panel.add(oldImg, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth =1;
		gc.weightx = 0.5;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.LINE_START;
		current_panel.add(add_image, gc);
		gc.gridx++;
		current_panel.add(ok_button, gc);		
		gc.gridx++;
		current_panel.add(delete_image, gc);
		
		add(BorderLayout.SOUTH, current_panel);
	}
}
