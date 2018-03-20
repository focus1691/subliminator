package gui.controls.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import constants.MessageTense;
import controller.MessageController;
import gui.component.JRoundRectButton;
import gui.message.MessagePanel;
import validation.MessageValidator;

public class EditMessage extends JInternalFrame {

	private static final long serialVersionUID = 5470112838506529493L;
	public static final int W = 600, H = 150;
	private MessageController controller;
	private JLabel firstPersonLbl, secondPersonLbl;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JRoundRectButton submitBtn;
	private JCheckBox text_only_1;
	private JCheckBox text_only_2;

	public EditMessage(final MessageController controller, final MessagePanel messagePanel, final int index) {
		super("Edit Message", false, true, false, false);
		this.controller = controller;
		initComponents(index);
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1 = text_only_1.isSelected();
				boolean is_text_only2 = text_only_2.isSelected();

				if (MessageValidator.isMoreThanThreeChars(msg1) && MessageValidator.isMoreThanThreeChars(msg2)) {

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
		getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(W, H);
		pack();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.requestFocus();
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

		submitBtn = new JRoundRectButton("Change");
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
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(firstPersonLbl, gc);
		
		gc.gridx++;
		add(firstPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLbl, gc);

		gc.gridx++;
		add(secondPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		add(submitBtn, gc);
	}
}
