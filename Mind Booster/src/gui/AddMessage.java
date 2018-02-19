package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import controller.Validation;
import gui.message.MessagePanel;
import model.Message;
import model.MessageTense;

public class AddMessage extends JDialog {
	
	private static final long serialVersionUID = 1447537632437945694L;
	private Controller controller;
	private JLabel firstPersonLabel;
	private JLabel secondPersonLabel;
	private JTextField firstPersonMsg;
	private JTextField secondPersonMsg;
	private JButton submitBtn;
	private JButton fontBtn;
	private Font message_font;
	private Color message_color=new Color(0, 0, 0);
	private JCheckBox text_only_1;
	private JCheckBox text_only_2;

	public AddMessage(final Controller controller, final MessagePanel messagePanel) {
		this.controller = controller;
		initComponents();
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1=text_only_1.isSelected();
				boolean is_text_only2=text_only_2.isSelected();
				
				if (Validation.isMoreThanThreeChars(msg1) && Validation.isMoreThanThreeChars(msg2)) {
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).add(new Message(msg1, "/Images/7.jpg", message_font, message_color, is_text_only1));
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).add(new Message(msg2, "/Images/7.jpg", message_font, message_color, is_text_only2));
					
					messagePanel.getModel().clear();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
					
					submitBtn.setEnabled(false);
					JOptionPane
							.showMessageDialog(null,
									"\"" + msg1 + "\"" + " and " + "\"" + msg2 + "\"" + "\n"
											+ "Successfully Added.",
									"Congratulations", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Enter a Message with More than 3 Characters.",
							"Short Message", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		fontBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFontChooser fontChooser = new JFontChooser();
				int result = fontChooser.showDialog(AddMessage.this);
				if (result == JFontChooser.OK_OPTION)
				{
					Font font = fontChooser.getSelectedFont();
					Color color=fontChooser.getColor();
					System.out.println("Selected Font : " + font+" Selected Color: "+color);
					message_color=color;
					message_font=font;
					firstPersonMsg.setFont(font);
					secondPersonMsg.setFont(font);
					firstPersonMsg.setForeground(color);
					secondPersonMsg.setForeground(color);
				}
			}
			
		});
		
		SetScreenLocation.centerFrame(this);
		setSize(600, 150);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents() {
		setTitle("New Messages : " +  controller.getActiveCategoryName());

		firstPersonLabel = new JLabel("1st person message:");
		secondPersonLabel = new JLabel("2nd person message:");

		firstPersonMsg = new JTextField(20);
		secondPersonMsg = new JTextField(20);

		submitBtn = new JButton("Add");
		fontBtn= new JButton("Font");
		
		text_only_1=new JCheckBox("Text Ony?");
		text_only_2=new JCheckBox("Text Ony?");
	}

	public void setupUI() {
		
		submitBtn.setPreferredSize(new Dimension(75, 50));
		submitBtn.setToolTipText("Add this message to " + controller.getActiveCategoryName());
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(firstPersonLabel, gc);
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx++;
		//gc.gridwidth=25;
		add(firstPersonMsg, gc);
		
		
		gc.gridx++;
		add(text_only_1, gc);		

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLabel, gc);
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx++;
		add(secondPersonMsg, gc);
		
		gc.gridx++;
		add(text_only_2, gc);			

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		add(submitBtn, gc);
		
		gc.gridx++;
		add(fontBtn, gc);
	}
}
