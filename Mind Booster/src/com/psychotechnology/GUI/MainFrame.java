package com.psychotechnology.GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.Category.CategoryPanel;
import com.psychotechnology.GUI.Category.CategoryEvent;
import com.psychotechnology.GUI.Category.CategoryListener;
import com.psychotechnology.GUI.Controls.ControlPanel;
import com.psychotechnology.GUI.Controls.MessageEvent;
import com.psychotechnology.GUI.Controls.MessageListener;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.GUI.Settings.SettingsEvent;
import com.psychotechnology.GUI.Settings.SettingsListener;
import com.psychotechnology.GUI.Settings.SettingsPanel;
import com.psychotechnology.Model.Message;
import com.psychotechnology.util.IconFetch;

public class MainFrame implements CategoryListener, MessageListener, SettingsListener {

	private Controller controller;
	private static JFrame frame;
	private CategoryPanel categoryPanel;
	private MessagePanel messagePanel;
	private SettingsPanel settingsPanel;
	private ControlPanel controlPanel;
	private JMenuBar menuBar;

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
		categoryPanel.setCategorySelectionListener(this);
		controlPanel.setMessageStartListener(this);
		messagePanel.setMessageStartListener(this);
		settingsPanel.setSettingsListener(this);

		// Window settings
		frame.setPreferredSize(new Dimension(1600, 900));
		frame.setMinimumSize(new Dimension(1200, 750));
		frame.pack();
		centerFrame(frame);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * This method initializes the three main containers, and the controller.
	 */
	private void initComponents() {
		controller = new Controller();
		frame = new JFrame();
		menuBar = createMenuBar();
		frame.setJMenuBar(menuBar);
		categoryPanel = new CategoryPanel(controller);
		messagePanel = new MessagePanel(controller);
		settingsPanel = new SettingsPanel(controller);
		controlPanel = new ControlPanel();
	}

	/**
	 * This method positions the category (left), message (middle), settings
	 * (right), and controls (bottom full-width) containers onto the window.
	 */
	private void setupUI() {
		frame.setTitle("Mind Booster");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Add Category Panel to Window
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 0);
		frame.add(categoryPanel, gbc);

		// Add Message Panel to Window
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		frame.add(messagePanel, gbc);

		// Add Settings Panel to Window
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.8;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		frame.add(settingsPanel, gbc);

		// Add Controls Panel to Window
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		gbc.insets = new Insets(0, 0, 0, 0);
		frame.add(controlPanel, gbc);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		JMenu messageMenu = new JMenu("Messages");

		fileMenu.add(createExitItem());

		messageMenu.add(createFactoryResetItem());

		menuBar.add(fileMenu);
		menuBar.add(messageMenu);

		return menuBar;
	}

	private JMenuItem createExitItem() {
		JMenuItem fileMenu = new JMenuItem(new AbstractAction("Exit") {

			private static final long serialVersionUID = -6305470444317273153L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/exit.png"));

		return fileMenu;
	}

	private JMenuItem createFactoryResetItem() {
		JMenuItem messageResetItem = new JMenuItem(new AbstractAction("    Restore Messages") {
			private static final long serialVersionUID = -6305470444317273153L;

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.loadInBuiltCategories();
				controller.save();
				messagePanel.getModel().clear();
				messagePanel.setMessageList(controller.getActiveMessages());
			}
		});

		messageResetItem.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/reset.png"));

		return messageResetItem;
	}

	/**
	 * A general-purpose method to vertically and horizontally center a window.
	 * http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
	 */
	public static void centerFrame(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	/**
	 * A general-purpose method to vertically and horizontally center a window.
	 * http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
	 */
	public static void centerFrame(JDialog dialog) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - dialog.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - dialog.getHeight()) / 2);
		dialog.setLocation(x, y);
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
			JOptionPane.showMessageDialog(frame, "You must selected a message to edit.", "Warning",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void deleteMessageEventOccurred(MessageEvent e) {
		int[] selectedMsgs = messagePanel.getMessageListSelectionModel().getSelectedMsgIndices();
		
		if (selectedMsgs == null) {
			JOptionPane.showMessageDialog(frame, "No messages selected.", "Warning", JOptionPane.ERROR_MESSAGE);
		} else {
			controller.doInsertionSort(selectedMsgs);
			new DeleteMessage(controller, messagePanel, selectedMsgs);
			controller.save();
		}
	}
	
	@Override
	public void editImageEventOccurred(MessageEvent e) {
		int index = messagePanel.getMessageListSelectionModel().getLeadSelectionIndex();
		Message message = (Message) messagePanel.getMessageList().getSelectedValue();
		System.out.println(messagePanel.getMessageList().getSelectedValue());
		new EditImage(controller, message.getImagePath());
	}

	@Override
	public void settingsEventOccurred(SettingsEvent e) {
		try {
			controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
			controller.setMessageSpeed(e.getMessageSpeed());
			controller.setMessageInterval(e.getMessageInterval());
			controller.changeMessageActivity(settingsPanel.getMsgLocationsSelected());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}