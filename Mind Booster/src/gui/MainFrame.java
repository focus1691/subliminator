package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.MessageController;
import controller.NetworkController;
import gui.category.CategoryEvent;
import gui.category.CategoryListener;
import gui.category.CategoryPanel;
import gui.controls.ControlPanel;
import gui.controls.MessageEvent;
import gui.controls.MessageListener;
import gui.message.MessagePanel;
import gui.message.dialogs.AddMessage;
import gui.message.dialogs.DeleteMessage;
import gui.message.dialogs.EditImage;
import gui.message.dialogs.EditMessage;
import gui.settings.SettingsEvent;
import gui.settings.SettingsListener;
import gui.settings.SettingsPanel;
import gui.util.SetScreenLocation;
import model.Message;
import utility.Sorter;

public class MainFrame extends JFrame implements CategoryListener, MessageListener, SettingsListener {

	private static final long serialVersionUID = -4312454251947395385L;
	private MessageController messageController;
	private CategoryPanel categoryPanel;
	private MessagePanel messagePanel;
	private SettingsPanel settingsPanel;
	private ControlPanel controlPanel;

	public MainFrame() {
		
		if (NetworkController.isApplicationRunning() == true) {
			System.exit(1);
		} else {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			} catch (UnsupportedLookAndFeelException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			messageController = new MessageController();

			categoryPanel = new CategoryPanel(messageController);
			categoryPanel.setCategorySelectionListener(this);
			
			messagePanel = new MessagePanel(messageController);
			messagePanel.setMessageStartListener(this);
			
			settingsPanel = new SettingsPanel(messageController.getSpeed(), messageController.getInterval());
			settingsPanel.setSettingsListener(this);
			
			controlPanel = new ControlPanel();
			controlPanel.setMessageStartListener(this);

			setJMenuBar(new CreateMenuBar(messageController, messagePanel));
			setupUI();

			// Window settings
			setPreferredSize(new Dimension(1600, 900));
			setMinimumSize(new Dimension(1200, 750));
			pack();
			SetScreenLocation.centerFrame(this);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	private void setupUI() {
		setTitle("Mind Booster");
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Category Panel on Left
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(categoryPanel, gbc);

		// Message Panel in Middle
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(messagePanel, gbc);

		// Settings Panel on Right
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.8;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(settingsPanel, gbc);

		// Controls Panel on Bottom
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(controlPanel, gbc);
	}

	@Override
	public void categorySelectionEventOccurred(CategoryEvent e) {
		messagePanel.getModel().clear();
		messageController.setCategoryIndex(e.getCategoryIndex());
		messagePanel.setMessageList(messageController.getMessagesFromActiveTenseCategory());
		if (MessageController.messagesOn == false) {
			try {
				messageController.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
				messageController.setCategoryIndex(e.getCategoryIndex());
				messageController.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void messageEventOccurred(MessageEvent event) {
		try {
			messageController.setFonts(settingsPanel.getMessageButtons());
			messageController.setActiveMessages(messagePanel.getSelectedMessages());
			messageController.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void messageSelectionEventOccurred(MessageEvent e) {
		if (e.isAllMessagesSelected() == true) {
			messagePanel.getMessageListSelectionModel().setAllMessagesActive();
		} else {
			messagePanel.getMessageListSelectionModel().clearSelection();
		}
	}

	@Override
	public void addMessageEventOccurred(MessageEvent e) {
		new AddMessage(messageController, messagePanel);
		messageController.save();
	}

	@Override
	public void editMessageEventOccurred(MessageEvent e) {

		if (messagePanel.getMessageListSelectionModel()
				.isSelectedIndex(messagePanel.getMessageListSelectionModel().getLastSelection())) {
			new EditMessage(messageController, messagePanel,
					messagePanel.getMessageListSelectionModel().getLastSelection());
			messageController.save();
		} else {
			JOptionPane.showMessageDialog(this, "You must selected a message to edit.", "Warning",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void deleteMessageEventOccurred(MessageEvent e) {
		int[] selectedMsgs = messagePanel.getMessageList().getSelectedIndices();

		if (selectedMsgs == null) {
			JOptionPane.showMessageDialog(this, "No messages selected.", "Warning", JOptionPane.ERROR_MESSAGE);
		} else {
			Sorter.getInstance().doInsertionSort(selectedMsgs);
			new DeleteMessage(messageController, messagePanel, selectedMsgs);
			messageController.save();
		}
	}

	@Override
	public void editImageEventOccurred(MessageEvent e) {
		// int index =
		// messagePanel.getMessageListSelectionModel().getLeadSelectionIndex();
		int[] selectedMsgs = messagePanel.getMessageList().getSelectedIndices();
		// JOptionPane.showMessageDialog(null,
		// messagePanel.getMessageListSelectionModel().getLastSelection());
		if (messagePanel.getMessageListSelectionModel().getLastSelection() < 0) {
			JOptionPane.showMessageDialog(this, "No messages selected.", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Message message = (Message) messagePanel.getMessageList().getSelectedValue();
		new EditImage(messageController, message, messagePanel,
				messagePanel.getMessageListSelectionModel().getLastSelection());
		messageController.save();
	}

	@Override
	public void settingsEventOccurred(SettingsEvent e) {
		try {
			messageController.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
			messageController.setSpeed(e.getMessageSpeed());
			messageController.setInterval(e.getMessageInterval());
			messageController.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}