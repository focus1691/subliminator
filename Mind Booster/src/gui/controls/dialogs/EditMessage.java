package gui.controls.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.MessageTense;
import controller.MessageController;
import gui.message.MessagePanel;
import gui.util.SetScreenLocation;
import utility.Validator;

public class EditMessage extends JDialog {

	private static final long serialVersionUID = 5470112838506529493L;
	private MessageController controller;
	private JLabel firstPersonLbl, secondPersonLbl;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JButton submitBtn;
	private JCheckBox text_only_1;
	private JCheckBox text_only_2;

	public EditMessage(final MessageController controller, final MessagePanel messagePanel, final int index) {
		this.controller = controller;
		initComponents(index);
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1 = text_only_1.isSelected();
				boolean is_text_only2 = text_only_2.isSelected();

				if (Validator.isMoreThanThreeChars(msg1) && Validator.isMoreThanThreeChars(msg2)) {

					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.get(index).setMessage(msg1);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.get(index).setMessage(msg2);

					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.get(index).setIsTextOnly(is_text_only1);
					;
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.get(index).setIsTextOnly(is_text_only2);

					messagePanel.getModel().clear();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
					dispose();
				}
			}
		});
		SetScreenLocation.centerFrame(this);
		this.getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(400, 225);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents(int index) {
		setTitle("Edit Message");

		firstPersonLbl = new JLabel("1st Person");
		firstPersonLbl.setForeground(Color.WHITE);

		secondPersonLbl = new JLabel("2nd Person");
		secondPersonLbl.setForeground(Color.WHITE);

		firstPersonMsg = new JTextField(30);
		firstPersonMsg.setToolTipText("First Person Message");

		secondPersonMsg = new JTextField(30);
		secondPersonMsg.setToolTipText("Second Person Message");

		firstPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
						.get(index).getMessage());
		secondPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
						.get(index).getMessage());

		submitBtn = new JButton("Change");
		submitBtn.setToolTipText("Edit this message");

		text_only_1 = new JCheckBox("Text Ony?");
		text_only_1.setForeground(Color.WHITE);
		text_only_1.setSelected(
				controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index)
						.getIsTextOnly());

		text_only_2 = new JCheckBox("Text Ony?");
		text_only_2.setForeground(Color.WHITE);
		text_only_2.setSelected(
				controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index)
						.getIsTextOnly());

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

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx++;
		// gc.gridwidth=25;
		add(firstPersonMsg, gc);

		gc.gridx++;
		add(text_only_1, gc);

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLbl, gc);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx++;
		add(secondPersonMsg, gc);

		gc.gridx++;
		add(text_only_2, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		add(submitBtn, gc);
	}
}
