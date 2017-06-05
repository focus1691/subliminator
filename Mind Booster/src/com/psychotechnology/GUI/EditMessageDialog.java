package com.psychotechnology.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.Controller.Validation;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.Model.MessageTense;

public class EditMessageDialog extends JDialog {

	private static final long serialVersionUID = 5470112838506529493L;
	private Controller controller;
	private JLabel firstPersonLabel;
	private JLabel secondPersonLabel;
	private JTextField firstPersonMsg;
	private JTextField secondPersonMsg;
	private JButton submitBtn;

	public EditMessageDialog(Controller controller, MessagePanel messagePanel, int index) {
		this.controller = controller;
		initComponents(index);
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();

				if (Validation.isMoreThanThreeChars(msg1) && Validation.isMoreThanThreeChars(msg2)) {
					
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).setMessage(msg1);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).setMessage(msg2);
					
					messagePanel.clearMessageList();
					messagePanel.setMessageList(controller.getAllMessagesFromActiveTenseCategory());
					dispose();
				}
			}
		});

		MainFrame.centerFrame(this);
		setSize(400, 225);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents(int index) {
		setTitle("Edit Message");

		firstPersonLabel = new JLabel("<html><b>1st Person</b></html>");
		secondPersonLabel = new JLabel("<html><b>2nd Person</b></html>");

		firstPersonMsg = new JTextField(30);
		secondPersonMsg = new JTextField(30);

		firstPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).get(index).getMessage());
		secondPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).get(index).getMessage());

		submitBtn = new JButton("Change");
	}

	public void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(10, 0, 10, 0);
		add(firstPersonLabel, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 0, 10, 0);
		add(firstPersonMsg, gc);

		gc.gridy++;
		add(secondPersonLabel, gc);

		gc.gridy++;
		add(secondPersonMsg, gc);

		gc.gridy++;
		add(submitBtn, gc);
	}
}
