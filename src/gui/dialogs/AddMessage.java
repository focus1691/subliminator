package gui.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import constants.MessageTense;
import controller.MessageController;
import gui.component.JRoundRectButton;
import gui.message.MessagePanel;
import gui.util.IconFetch;
import model.Message;
import utility.FontPicker;
import validation.MessageValidator;

@SuppressWarnings("serial")
public class AddMessage extends JInternalFrame {

	public static final int W = 600, H = 190;
	private MessageController controller;
	private JLabel errorMsg;
	private JLabel firstPersonLabel, secondPersonLabel;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JRoundRectButton submitBtn;

	public AddMessage(final MessageController controller, final MessagePanel messagePanel) {
		super("Add Message", false, true, false, false);
		this.controller = controller;
		initComponents();
		setupUI();

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();
				boolean is_text_only1 = false;
				boolean is_text_only2 = false;

				if (MessageValidator.isMoreThanThreeChars(msg1) && MessageValidator.isMoreThanThreeChars(msg2)) {
					errorMsg.setVisible(false);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.add(new Message(msg1, "/Images/7.jpg", is_text_only1));
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.add(new Message(msg2, "/Images/7.jpg", is_text_only2));

					messagePanel.removeMessages();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());

					submitBtn.setEnabled(false);
					JOptionPane.showMessageDialog(null,
							"\"" + msg1 + "\"" + " and " + "\"" + msg2 + "\"" + "\n" + "Successfully Added.",
							"Congratulations", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					errorMsg.setText("Enter a Message with More than 3 Characters");
					errorMsg.setVisible(true);
				}
			}
		});
		getContentPane().setBackground(Color.decode("#1975bf"));
		setPreferredSize(new Dimension(W, H));
		pack();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		requestFocus();
	}

	public void initComponents() {
		setTitle("New Messages : " + controller.getActiveCategoryName());

		firstPersonLabel = new JLabel("1st person message:");
		firstPersonLabel.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		firstPersonLabel.setForeground(Color.WHITE);

		secondPersonLabel = new JLabel("2nd person message:");
		secondPersonLabel.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		secondPersonLabel.setForeground(Color.WHITE);

		firstPersonMsg = new JTextField(30);
		firstPersonMsg.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		secondPersonMsg = new JTextField(30);
		secondPersonMsg.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));

		submitBtn = new JRoundRectButton("Add");
		submitBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		submitBtn.setToolTipText("Add this message to " + controller.getActiveCategoryName());

		errorMsg = new JLabel("Error message");
		errorMsg.setFont(FontPicker.getFont(FontPicker.latoBlack, 19.18f));
		errorMsg.setForeground(Color.RED);
		errorMsg.setVisible(false);
	}

	public void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.CENTER;
		add(errorMsg, gc);

		gc.gridy++;
		gc.gridwidth = 1;
		add(firstPersonLabel, gc);

		gc.gridx++;
		add(firstPersonMsg, gc);

		gc.gridx = 0;
		gc.gridy++;
		add(secondPersonLabel, gc);

		gc.gridx++;
		add(secondPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		add(submitBtn, gc);
	}
}