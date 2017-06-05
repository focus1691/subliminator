package com.psychotechnology.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.Controller.Validation;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.MessageTense;

public class AddDialog extends JDialog {
	
	private static final long serialVersionUID = 1447537632437945694L;
	private Controller controller;
	private JLabel firstPersonLabel;
	private JLabel secondPersonLabel;
	private JTextField firstPersonMsg;
	private JTextField secondPersonMsg;
	private JButton submitBtn;

	public AddDialog(Controller controller, MessagePanel messagePanel) {
		this.controller = controller;
		initComponents();
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();

				if (Validation.isMoreThanThreeChars(msg1) && Validation.isMoreThanThreeChars(msg2)) {
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).add(new Message(msg1, "/Images/7.jpg"));
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).add(new Message(msg2, "/Images/7.jpg"));
					
					messagePanel.clearMessageList();
					messagePanel.setMessageList(controller.getAllMessagesFromActiveTenseCategory());

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
		
		MainFrame.centerFrame(this);
		setSize(400, 150);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents() {
		setTitle("New Messages : " +  controller.getActiveCategoryName());

		firstPersonLabel = new JLabel("New 1st person message:");
		secondPersonLabel = new JLabel("New 2nd person message:");

		firstPersonMsg = new JTextField(20);
		secondPersonMsg = new JTextField(20);

		submitBtn = new JButton("Add");
	}

	public void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		add(firstPersonLabel, gc);

		gc.gridx++;
		add(firstPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLabel, gc);

		gc.gridx++;
		add(secondPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(submitBtn, gc);
	}
}
