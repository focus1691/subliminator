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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import constants.MessageTense;
import controller.MessageController;
import gui.component.JRoundRectButton;
import gui.message.MessagePanel;
import gui.util.IconFetch;
import utility.FontPicker;
import validation.MessageValidator;

public class EditMessage extends JInternalFrame {

	private static final long serialVersionUID = 5470112838506529493L;
	public static final int W = 600, H = 190;
	private MessageController controller;
	private JLabel errorMsg;
	private JLabel firstPersonLbl, secondPersonLbl;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JRoundRectButton submitBtn;

	public EditMessage(final MessageController controller, final MessagePanel messagePanel, final int index) {
		super("Edit Message", false, true, false, false);
		this.controller = controller;
		initComponents(index, messagePanel);
		setupUI();

		getContentPane().setBackground(Color.decode("#1975bf"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				IconFetch.getInstance().getIcon("/images/cursor.png").getImage(), new Point(0, 0), "custom cursor"));
		setSize(W, H);
		setPreferredSize(new Dimension(W, H));
		pack();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		requestFocus();
	}

	public void initComponents(final int index, final MessagePanel messagePanel) {
		firstPersonLbl = new JLabel("1st Person");
		firstPersonLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		firstPersonLbl.setForeground(Color.WHITE);

		secondPersonLbl = new JLabel("2nd Person");
		secondPersonLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		secondPersonLbl.setForeground(Color.WHITE);

		firstPersonMsg = new JTextField(30);
		firstPersonMsg.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		firstPersonMsg.setToolTipText("First Person Message");
		firstPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
						.get(index).getMessage());

		secondPersonMsg = new JTextField(30);
		secondPersonMsg.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		secondPersonMsg.setToolTipText("Second Person Message");
		secondPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
						.get(index).getMessage());

		submitBtn = new JRoundRectButton("Change");
		submitBtn.setToolTipText("Edit this message");
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg1 = firstPersonMsg.getText();
				String msg2 = secondPersonMsg.getText();

				if (MessageValidator.isMoreThanThreeChars(msg1) && MessageValidator.isMoreThanThreeChars(msg2)) {

					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.get(index).setMessage(msg1);
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.get(index).setMessage(msg2);

					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
							.get(index).setIsTextOnly(false);
					;
					controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
							.get(index).setIsTextOnly(false);

					messagePanel.removeMessages();
					messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
					dispose();
				}
			}
		});

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
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		add(submitBtn, gc);
	}
}