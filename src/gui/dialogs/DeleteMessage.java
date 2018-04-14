package gui.dialogs;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import utility.FontPicker;

public class DeleteMessage extends JInternalFrame {

	private static final long serialVersionUID = 5549429493881002578L;
	public static final int W = 600, H = 190;
	private MessageController controller;
	private JLabel errorMsg;
	private JLabel firstPersonLbl, secondPersonLbl;
	private JTextField firstPersonMsg, secondPersonMsg;
	private JRoundRectButton deleteBtn;

	public DeleteMessage(final MessageController controller, final MessagePanel messagePanel, final int selectedMsg) {
		super("Delete Messages", false, true, false, false);
		this.controller = controller;
		initComponents(controller, messagePanel, selectedMsg);
		setupUI();
		getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(W, H);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public void initComponents(final MessageController controller, final MessagePanel messagePanel,
			final int selectedMsg) {
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
						.get(selectedMsg).getMessage());
		firstPersonMsg.setEditable(false);

		secondPersonMsg = new JTextField(30);
		secondPersonMsg.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.71f));
		secondPersonMsg.setToolTipText("Second Person Message");
		secondPersonMsg
				.setText(controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
						.get(selectedMsg).getMessage());
		secondPersonMsg.setEditable(false);

		deleteBtn = new JRoundRectButton("Delete");
		deleteBtn.setToolTipText("Delete the messages below");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMessages(selectedMsg);
				deleteBtn.setEnabled(false);

				messagePanel.removeMessages();
				messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
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
		add(deleteBtn, gc);
	}

	public void deleteMessages(int selectedMsg) {
		controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.FIRST_PERSON)
				.remove(selectedMsg);
		controller.getMessagesFromCategory(controller.getCategoryIndex(), MessageTense.SECOND_PERSON)
				.remove(selectedMsg);
	}
}