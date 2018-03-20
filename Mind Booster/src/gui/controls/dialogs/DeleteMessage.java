package gui.controls.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import constants.MessageTense;
import controller.MessageController;
import gui.component.BlueCurvedScrollBar;
import gui.message.MessagePanel;

public class DeleteMessage extends JInternalFrame {
	
	private static final long serialVersionUID = 5549429493881002578L;
	public static final int W = 1000, H = 350;
	private MessageController controller;
	private JScrollPane scroller;
	private JTextArea selectedMessagesTxt;
	private JPanel panel;
	private JLabel deleteMsg;
	private JButton deleteBtn;

	public DeleteMessage(final MessageController controller,final MessagePanel messagePanel, final int[] selectedMsgs) {
		super("Delete Message", false, true, false, false);
		this.controller = controller;
		initComponents();
		setupUI();
		appendMessagesToDelete(selectedMsgs);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMessages(selectedMsgs);
				deleteBtn.setEnabled(false);
				
				messagePanel.getModel().clear();
				messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
			}
		});
		getContentPane().setBackground(Color.decode("#1975bf"));
		setSize(W, H);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public void initComponents() {

		panel = new JPanel();
		deleteMsg = new JLabel("Delete Messages?");
		deleteBtn = new JButton("Yes");
		deleteBtn.setToolTipText("Delete the messages below");
		panel.add(deleteMsg);
		panel.add(deleteBtn);

		selectedMessagesTxt = new JTextArea();
		
		scroller = new JScrollPane(selectedMessagesTxt);
	}

	public void setupUI() {
		
		// Vertical ScrollBar
		scroller.getVerticalScrollBar().setUI(new BlueCurvedScrollBar());
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scroller.getVerticalScrollBar().setBackground(Color.decode("#efeff0"));
		scroller.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		// Fonts
		deleteMsg.setFont(new Font("Courier New", Font.BOLD, 20));
		selectedMessagesTxt.setFont(new Font("Courier New", Font.BOLD, 16));
		
		setLayout(new BorderLayout());

		add(panel, BorderLayout.NORTH);
		add(scroller, BorderLayout.CENTER);
	}

	public void appendMessagesToDelete(int[] selectedMsgs) {
		int i;

		for (i = 0; i < selectedMsgs.length; i++) {
			selectedMessagesTxt.append(controller.getMessageFromCategory(controller.getCategoryIndex(), selectedMsgs[i], MessageTense.FIRST_PERSON).getMessage());
			selectedMessagesTxt.append("\\");
			selectedMessagesTxt.append(controller.getMessageFromCategory(controller.getCategoryIndex(), selectedMsgs[i], MessageTense.SECOND_PERSON).getMessage());
			selectedMessagesTxt.append("\n");
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
