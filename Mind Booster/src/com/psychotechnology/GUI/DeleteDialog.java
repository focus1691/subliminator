package com.psychotechnology.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.Model.MessageTense;

public class DeleteDialog extends JDialog {
	
	private static final long serialVersionUID = 5549429493881002578L;
	private Controller controller;
	private JTextArea messagesToDelete;
	private JPanel panel;
	private JLabel deleteMsg;
	private JButton deleteBtn;

	public DeleteDialog(Controller controller, MessagePanel messagePanel, int[] selectedMsgs) {

		this.controller = controller;
		initComponents();
		setupUI();
		appendMessagesToDelete(selectedMsgs);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMessages(selectedMsgs);
				deleteBtn.setEnabled(false);
				
				
				
				messagePanel.clearMessageList();
				messagePanel.setMessageList(controller.getAllMessagesFromActiveTenseCategory());
			}
		});

		MainFrame.centerFrame(this);
		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void initComponents() {

		panel = new JPanel();
		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JButton("Yes");
		panel.add(deleteMsg);
		panel.add(deleteBtn);

		messagesToDelete = new JTextArea();
	}

	public void setupUI() {
		setSize(400, 350);
		setLayout(new BorderLayout());

		add(panel, BorderLayout.NORTH);
		add(messagesToDelete, BorderLayout.CENTER);
	}

	public void appendMessagesToDelete(int[] selectedMsgs) {
		int i;

		for (i = 0; i < selectedMsgs.length; i++) {
			System.out.println(controller.getMessageFromCategory(controller.getCategoryIndex(), selectedMsgs[i], MessageTense.FIRST_PERSON).getMessage());
			messagesToDelete.append(controller.getMessageFromCategory(controller.getCategoryIndex(), selectedMsgs[i], MessageTense.FIRST_PERSON).getMessage());
			messagesToDelete.append("\\");
			messagesToDelete.append(controller.getMessageFromCategory(controller.getCategoryIndex(), selectedMsgs[i], MessageTense.SECOND_PERSON).getMessage());
			messagesToDelete.append("\n");
		}
	}

	public void deleteMessages(int[] selectedMsgs) {
		int i;

		for (i = selectedMsgs.length - 1; i >= 0; i--) {
			controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON).remove(selectedMsgs[i]);
			controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON).remove(selectedMsgs[i]);
		}
	}
}
