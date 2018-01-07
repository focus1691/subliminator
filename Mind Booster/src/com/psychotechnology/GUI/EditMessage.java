package com.psychotechnology.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.Controller.Validation;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.Model.MessageTense;

public class EditMessage extends JDialog {

	private static final long serialVersionUID = 5470112838506529493L;
	private Controller controller;
	private JLabel firstPersonLbl, secondPersonLbl;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JButton submitBtn;
	private JButton fontBtn;
	private Font message_font;
	private Color message_color=new Color(0, 0, 0);
	private JCheckBox text_only_1;
	private JCheckBox text_only_2;
	
	public EditMessage(final Controller controller,final MessagePanel messagePanel, final int index) {
		this.controller = controller;
		initComponents(index);
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1=text_only_1.isSelected();
				boolean is_text_only2=text_only_2.isSelected();

				if (Validation.isMoreThanThreeChars(msg1) && Validation.isMoreThanThreeChars(msg2)) {
					
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setMessage(msg1);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setMessage(msg2);
					
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setFont(message_font);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setFont(message_font);
					
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setColor(message_color);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setColor(message_color);
	
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setColor(message_color);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setColor(message_color);
					
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setIsTextOnly(is_text_only1);;
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setIsTextOnly(is_text_only2);
					
					messagePanel.getModel().clear();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
					dispose();
				}
			}
		});
		fontBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFontChooser fontChooser = new JFontChooser();
				int result = fontChooser.showDialog(EditMessage.this);
				if (result == JFontChooser.OK_OPTION)
				{
					Font font = fontChooser.getSelectedFont();
					Color color=fontChooser.getColor();
					message_color=color;
					System.out.println("Selected Font : " + font+" Selected Color: "+color);
					message_font=font;
					firstPersonMsg.setFont(font);
					secondPersonMsg.setFont(font);
					firstPersonMsg.setForeground(color);
					secondPersonMsg.setForeground(color);
				}
			}
			
		});
		SetScreenLocation.centerFrame(this);
		setSize(400, 225);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents(int index) {
		setTitle("Edit Message");

		firstPersonLbl = new JLabel("1st Person");
		secondPersonLbl = new JLabel("2nd Person");

		firstPersonMsg = new JTextField(30);
		firstPersonMsg.setToolTipText("First Person Message");
		secondPersonMsg = new JTextField(30);
		secondPersonMsg.setToolTipText("Second Person Message");

		firstPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).getMessage());
		secondPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).getMessage());

		firstPersonMsg
		.setFont(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).getFont());
		secondPersonMsg
		.setFont(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).getFont());
		firstPersonMsg
		.setForeground(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).getColor());
		secondPersonMsg
		.setForeground(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).getColor());
		
		submitBtn = new JButton("Change");
		submitBtn.setToolTipText("Edit this message");
		
		fontBtn= new JButton("Font");
		
		text_only_1=new JCheckBox("Text Ony?");
		text_only_1.setSelected(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).getIsTextOnly());
		text_only_2=new JCheckBox("Text Ony?");	
		text_only_2.setSelected(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).getIsTextOnly());

	}

	public void setupUI() {
		
		// Fonts
		firstPersonLbl.setFont(new Font("Courier New", Font.BOLD, 20));
		secondPersonLbl.setFont(new Font("Courier New", Font.BOLD, 20));
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		gc.gridx = 0;
		gc.gridy = 0;
		add(firstPersonLbl, gc);
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridx++;
		//gc.gridwidth=25;
		add(firstPersonMsg, gc);
		
		
		gc.gridx++;
		add(text_only_1, gc);		

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLbl, gc);
		
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
		/*
		gc.gridx = 0;
		gc.gridy = 0;
		//gc.insets = new Insets(10, 0, 10, 0);
		add(firstPersonLbl, gc);

		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridy++;
		//gc.insets = new Insets(0, 0, 10, 0);
		add(firstPersonMsg, gc);
		
		gc.gridx++;
		add(text_only_1, gc);		

		gc.gridy++;
		add(secondPersonLbl, gc);

		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.gridy++;
		add(secondPersonMsg, gc);

		gc.gridx++;
		add(text_only_2, gc);	
		
		gc.gridy++;
		add(submitBtn, gc);
		
		gc.gridx++;
		add(fontBtn, gc);	
		*/
	}
}
