package gui.controls.dialogs;

import java.awt.Color;
import java.awt.Dimension;
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

import constants.MessageTense;
import controller.MessageController;
import gui.message.MessagePanel;
import gui.util.SetScreenLocation;
import model.Message;
import utility.Validator;

public class AddMessage extends JDialog {

	private static final long serialVersionUID = 1447537632437945694L;
	private MessageController controller;
	private JLabel firstPersonLabel;
	private JLabel secondPersonLabel;
	private JTextField firstPersonMsg;
	private JTextField secondPersonMsg;
	private JButton submitBtn;
	private JCheckBox text_only_1;
	private JCheckBox text_only_2;

	public AddMessage(final MessageController controller, final MessagePanel messagePanel) {
		this.controller = controller;
		initComponents();
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1 = text_only_1.isSelected();
				boolean is_text_only2 = text_only_2.isSelected();

				if (Validator.isMoreThanThreeChars(msg1) && Validator.isMoreThanThreeChars(msg2)) {
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.add(new Message(msg1, "/Images/7.jpg", is_text_only1));
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.add(new Message(msg2, "/Images/7.jpg", is_text_only2));

					messagePanel.getModel().clear();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());

					submitBtn.setEnabled(false);
					JOptionPane.showMessageDialog(null,
							"\"" + msg1 + "\"" + " and " + "\"" + msg2 + "\"" + "\n" + "Successfully Added.",
							"Congratulations", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Enter a Message with More than 3 Characters.", "Short Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SetScreenLocation.centerFrame(this);
		this.getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(600, 150);
		setModal(true);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void initComponents() {
		setTitle("New Messages : " + controller.getActiveCategoryName());

		firstPersonLabel = new JLabel("1st person message:");
		firstPersonLabel.setForeground(Color.WHITE);

		secondPersonLabel = new JLabel("2nd person message:");
		secondPersonLabel.setForeground(Color.WHITE);

		firstPersonMsg = new JTextField(20);
		secondPersonMsg = new JTextField(20);

		submitBtn = new JButton("Add");

		text_only_1 = new JCheckBox("Text Ony?");
		text_only_1.setForeground(Color.WHITE);

		text_only_2 = new JCheckBox("Text Ony?");
		text_only_2.setForeground(Color.WHITE);
	}

	public void setupUI() {

		submitBtn.setPreferredSize(new Dimension(75, 50));
		submitBtn.setToolTipText("Add this message to " + controller.getActiveCategoryName());

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(firstPersonLabel, gc);

		gc.gridx++;
		add(firstPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 0;
		add(secondPersonLabel, gc);

		gc.gridx++;
		add(secondPersonMsg, gc);

		gc.gridy++;
		add(text_only_2, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(submitBtn, gc);
	}
}
