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

import category.CategoryEvent;
import category.CategoryListener;
import category.CategoryPanel;
import controller.Controller;
import controls.ControlPanel;
import controls.MessageEvent;
import controls.MessageListener;
import menu.CreateMenuBar;
import message.MessagePanel;
import model.Message;
import settings.SettingsEvent;
import settings.SettingsListener;
import settings.SettingsPanel;

public class MainFrame extends JFrame implements CategoryListener, MessageListener, SettingsListener {
	
	private static final long serialVersionUID = -4312454251947395385L;
	private Controller controller;
	private CategoryPanel categoryPanel;
	private MessagePanel messagePanel;
	private SettingsPanel settingsPanel;
	private ControlPanel controlPanel;

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
		new MainFrame();
	}

	public MainFrame() {
		initComponents();
		setupUI();
		
		// Listeners for the 4 panels
		categoryPanel.setCategorySelectionListener(this);
		messagePanel.setMessageStartListener(this);
		settingsPanel.setSettingsListener(this);
		controlPanel.setMessageStartListener(this);

		// Window settings
		setPreferredSize(new Dimension(1600, 900));
		setMinimumSize(new Dimension(1200, 750));
		pack();
		SetScreenLocation.centerFrame(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * This method initializes the three main containers, and the controller.
	 */
	private void initComponents() {
		controller = new Controller();
		categoryPanel = new CategoryPanel(controller);
		messagePanel = new MessagePanel(controller);
		settingsPanel = new SettingsPanel(controller.getSpeed(), controller.getInterval());
		controlPanel = new ControlPanel();
		setJMenuBar(new CreateMenuBar(controller, messagePanel));
	}

	/**
	 * This method positions the category (left), message (middle), settings
	 * (right), and controls (bottom full-width) containers onto the window.
	 */
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
		controller.setCategoryIndex(e.getCategoryIndex());
		messagePanel.setMessageList(controller.getMessagesFromActiveTenseCategory());
		if (Controller.messagesOn == false) {
			try {
				controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
				controller.setCategoryIndex(e.getCategoryIndex());
				controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
 
	@Override
	public void messageEventOccurred(MessageEvent event) {
		try {
			if (event.isAllMessagesSelected() == false) {
				
			}
			controller.setActiveMessages(messagePanel.getSelectedMessages());
			controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
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
		new AddMessage(controller, messagePanel);
		controller.save();
	}

	@Override
	public void editMessageEventOccurred(MessageEvent e) {

		if (messagePanel.getMessageListSelectionModel()
				.isSelectedIndex(messagePanel.getMessageListSelectionModel().getLastSelection())) {
			new EditMessage(controller, messagePanel,
					messagePanel.getMessageListSelectionModel().getLastSelection());
			controller.save();
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
			controller.doInsertionSort(selectedMsgs);
			new DeleteMessage(controller, messagePanel, selectedMsgs);
			controller.save();
		}
	}
	
	@Override
	public void editImageEventOccurred(MessageEvent e) {
		//int index = messagePanel.getMessageListSelectionModel().getLeadSelectionIndex();
		int[] selectedMsgs = messagePanel.getMessageList().getSelectedIndices();
		//JOptionPane.showMessageDialog(null, messagePanel.getMessageListSelectionModel().getLastSelection());
		if (messagePanel.getMessageListSelectionModel().getLastSelection() <0) {
			JOptionPane.showMessageDialog(this, "No messages selected.", "Warning", JOptionPane.ERROR_MESSAGE);	
			return;
		}			
		Message message = (Message) messagePanel.getMessageList().getSelectedValue();
		new EditImage(controller, message, messagePanel, messagePanel.getMessageListSelectionModel().getLastSelection());
		controller.save();
	}

	@Override
	public void settingsEventOccurred(SettingsEvent e) {
		try {
			controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
			controller.setSpeed(e.getMessageSpeed());
			controller.setInterval(e.getMessageInterval());
			controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}