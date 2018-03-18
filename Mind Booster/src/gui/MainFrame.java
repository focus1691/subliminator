package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MessageController;
import controller.NetworkController;
import gui.category.CategoryEvent;
import gui.category.CategoryListener;
import gui.category.CategoryPanel;
import gui.controls.ControlPanel;
import gui.controls.MessageEvent;
import gui.controls.MessageListener;
import gui.controls.dialogs.AddMessage;
import gui.controls.dialogs.DeleteMessage;
import gui.controls.dialogs.EditImage;
import gui.controls.dialogs.EditMessage;
import gui.message.MessagePanel;
import gui.settings.SettingsEvent;
import gui.settings.SettingsListener;
import gui.settings.SettingsPanel;
import gui.util.CreateMenuBar;
import gui.util.IconFetch;
import gui.util.MBSystemTray;
import gui.util.SetScreenLocation;
import model.Message;
import utility.FontPicker;
import utility.Sorter;
import validation.ArrayValidator;

public class MainFrame extends JFrame implements CategoryListener, MessageListener, SettingsListener {

	private static final long serialVersionUID = -4312454251947395385L;
	public static final String appName = "Mind Booster";
	public static final int W = 1800, H = 1100, minW = 1400, minH = 1000;
	private MessageController messageController;
	private CategoryPanel categoryPanel;
	private MessagePanel messagePanel;
	private SettingsPanel settingsPanel;
	private ControlPanel controlPanel;
	private JDesktopPane desktopPane;
	private JPanel mainPanel;
	private MBSystemTray hideToSystemTray;
	private JLabel errorMsg;

	public MainFrame() {

		if (NetworkController.isApplicationRunning() == true) {
			System.exit(1);
		} else {
			messageController = new MessageController();

			categoryPanel = new CategoryPanel(messageController);
			categoryPanel.setCategorySelectionListener(this);

			messagePanel = new MessagePanel(messageController);
			messagePanel.setMessageStartListener(this);

			settingsPanel = new SettingsPanel(messageController.getSpeed(), messageController.getInterval());
			settingsPanel.setSettingsListener(this);

			controlPanel = new ControlPanel();
			controlPanel.setMessageStartListener(this);

			hideToSystemTray = new MBSystemTray(this);

			errorMsg = new JLabel();
			errorMsg.setForeground(Color.RED);
			errorMsg.setFont(FontPicker.getFont(FontPicker.latoBold, 18));
			errorMsg.setVisible(false);

			setJMenuBar(new CreateMenuBar(messageController, messagePanel));

			setupUI();

			this.addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent evt) {
					mainPanel.setBounds(0, 0, (int) (getWidth() * 1.0), (int) (getHeight() * 0.915));
				}
			});
			setTitle(appName);
			setIconImage(IconFetch.getInstance().getIcon("/images/icon.png").getImage());
			setPreferredSize(new Dimension(W, H));
			setMinimumSize(new Dimension(minW, minH));
			pack();
			SetScreenLocation.centerFrame(this);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	private void setupUI() {
		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setVisible(true);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(errorMsg, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(categoryPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.4;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(messagePanel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.8;
		gbc.weighty = 0.8;
		gbc.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(settingsPanel, gbc);

		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		gbc.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(controlPanel, gbc);

		desktopPane = new JDesktopPane();
		desktopPane.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
		desktopPane.add(mainPanel);

		setContentPane(desktopPane);
	}

	@Override
	public void categorySelectionEventOccurred(CategoryEvent e) {
		messagePanel.getModel().clear();
		messageController.setCategoryIndex(e.getCategoryIndex());
		messagePanel.setMessageList(messageController.getMessagesFromActiveTenseCategory());
		if (messageController.isMessagesOn() == false) {
			try {
				messageController.startMessageActivity(settingsPanel.getSelectedScreenPositions(),
						settingsPanel.getMessageButtons());
				messageController.setCategoryIndex(e.getCategoryIndex());
				messageController.stopMessageActivity();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void messageEventOccurred(MessageEvent event) {
		try {
			if (messageController.isMessagesOn() == false) {
				if (messagePanel.getSelectedMessages().isEmpty()) {
					errorMsg.setText("No messages selected");
					errorMsg.setVisible(true);
					controlPanel.showStartButton();
				} else {
					if (ArrayValidator.areAllFalse(settingsPanel.getSelectedScreenPositions())) {
						errorMsg.setText("No message locations selected");
						errorMsg.setVisible(true);
						controlPanel.showStartButton();
					} else {
						hideToSystemTray.hide();
						messageController.setSpeed(settingsPanel.getSpeed());
						messageController.setInterval(settingsPanel.getInterval());
						messageController.setActiveMessages(messagePanel.getSelectedMessages());
						messageController.startMessageActivity(settingsPanel.getSelectedScreenPositions(),
								settingsPanel.getMessageButtons());
						messageController.setMessagesOn(true);
						errorMsg.setText("");
						errorMsg.setVisible(false);
					}
				}
			} else if (messageController.isMessagesOn() == true) {
				messageController.stopMessageActivity();
				messageController.setMessagesOn(false);
			}

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
		AddMessage addMessage = new AddMessage(messageController, messagePanel);
		desktopPane.add(addMessage);
		addMessage.setLocation(W / 5, (H - 100) / 5);
		addMessage.setVisible(true);
		messageController.save();
	}

	@Override
	public void editMessageEventOccurred(MessageEvent e) {

		if (messagePanel.getMessageListSelectionModel()
				.isSelectedIndex(messagePanel.getMessageListSelectionModel().getLastSelection())) {
			EditMessage editMessage = new EditMessage(messageController, messagePanel,
					messagePanel.getMessageListSelectionModel().getLastSelection());
			desktopPane.add(editMessage);
			editMessage.setLocation(W / 5, (H - 100) / 5);
			editMessage.setVisible(true);
			errorMsg.setVisible(false);
			messageController.save();
		} else {
			errorMsg.setText("You need to select a message to edit");
			errorMsg.setVisible(true);
		}
	}

	@Override
	public void deleteMessageEventOccurred(MessageEvent e) {
		int[] selectedMsgs = messagePanel.getMessageList().getSelectedIndices();
		
		if (selectedMsgs == null || selectedMsgs.length == 0) {
			errorMsg.setText("You need to select a message to delete");
			errorMsg.setVisible(true);
		} else {
			Sorter.getInstance().doInsertionSort(selectedMsgs);
			DeleteMessage deleteMessage = new DeleteMessage(messageController, messagePanel, selectedMsgs);
			desktopPane.add(deleteMessage);
			deleteMessage.setLocation(W / 5, (H - 100) / 5);
			deleteMessage.setVisible(true);
			errorMsg.setVisible(false);
			messageController.save();
		}
	}

	@Override
	public void editImageEventOccurred(MessageEvent e) {
		int[] selectedMsgs = messagePanel.getMessageList().getSelectedIndices();
		if (messagePanel.getMessageListSelectionModel().getLastSelection() < 0) {
			errorMsg.setText("You need to select a message to edit");
			errorMsg.setVisible(true);
		}
		Message message = (Message) messagePanel.getMessageList().getSelectedValue();
		EditImage editImage = new EditImage(messageController, message, messagePanel,
				messagePanel.getMessageListSelectionModel().getLastSelection());
		desktopPane.add(editImage);
		editImage.setLocation(W / 5, (H - 100) / 5);
		editImage.setVisible(true);
		errorMsg.setVisible(false);
		messageController.save();
	}

	@Override
	public void settingsEventOccurred(SettingsEvent e) {
		messageController.setSpeed(e.getMessageSpeed());
		messageController.setInterval(e.getMessageInterval());
	}
}