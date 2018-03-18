package gui.controls.dialogs;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import model.Message;
import utility.FontPicker;
import validation.MessageValidator;

public class AddMessage extends JInternalFrame {

	private static final long serialVersionUID = 1447537632437945694L;
	public static final int W = 600, H = 250, X = 150, Y = 150;
	private MessageController controller;
	private JLabel errorMsg;
	private JLabel firstPersonLabel;
	private JLabel secondPersonLabel;
	private JTextField firstPersonMsg;
	private JTextField secondPersonMsg;
	private JRoundRectButton submitBtn;

	public AddMessage(final MessageController controller, final MessagePanel messagePanel) {
		super("Add Message", true, true, true, true);
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

					messagePanel.getModel().clear();
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
		setSize(W, H);
		setLocation(X, Y);
		pack();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.requestFocus();
	}

	public void initComponents() {
		setTitle("New Messages : " + controller.getActiveCategoryName());

		firstPersonLabel = new JLabel("1st person message:");
		firstPersonLabel.setForeground(Color.WHITE);

		secondPersonLabel = new JLabel("2nd person message:");
		secondPersonLabel.setForeground(Color.WHITE);

		firstPersonMsg = new JTextField(20);
		secondPersonMsg = new JTextField(20);

		submitBtn = new JRoundRectButton("Add");
		submitBtn.setToolTipText("Add this message to " + controller.getActiveCategoryName());
		
		errorMsg = new JLabel();
		errorMsg.setForeground(Color.RED);
		errorMsg.setFont(FontPicker.getFont(FontPicker.latoBold, 18));
	}

	public void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(errorMsg, gc);

		gc.gridy++;
		add(firstPersonLabel, gc);

		gc.gridx++;
		add(firstPersonMsg, gc);

		gc.gridy++;
		gc.gridx = 0;
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
