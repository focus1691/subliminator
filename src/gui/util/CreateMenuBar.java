package gui.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.MessageController;
import gui.component.BlueGreyMenuItem;
import gui.component.BlueGreyRadioButtonMenuItem;
import gui.controls.ControlPanel;
import gui.message.MessagePanel;
import gui.subliminal.SubliminalFrame;
import utility.FontPicker;

@SuppressWarnings("serial")
public class CreateMenuBar extends JMenuBar {

	private Preferences prefs;
	private MessageController messageController;
	private MessagePanel messagePanel;
	private ControlPanel controlPanel;

	public CreateMenuBar(MessageController messageController, ControlPanel controlPanel, MessagePanel messagePanel) {

		this.messageController = messageController;
		this.controlPanel = controlPanel;
		this.messagePanel = messagePanel;

		prefs = Preferences.userRoot().node(this.getClass().getName());

		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		fileMenu.setForeground(Color.WHITE);
		fileMenu.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 5));
		fileMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		JMenu settingsMenu = new JMenu("Settings");
		settingsMenu.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		settingsMenu.setForeground(Color.WHITE);
		settingsMenu.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 5));
		settingsMenu.getPopupMenu().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// Exit
		fileMenu.add(exitItem());

		// Factory Reset
		settingsMenu.add(factoryResetItem());

		// Message Size
		ButtonGroup bg = new ButtonGroup();
		BlueGreyRadioButtonMenuItem small = new BlueGreyRadioButtonMenuItem("    Small");
		BlueGreyRadioButtonMenuItem medium = new BlueGreyRadioButtonMenuItem("    Medium");
		BlueGreyRadioButtonMenuItem large = new BlueGreyRadioButtonMenuItem("    Large");

		switch (prefs.get("MESSAGE_SIZE", medium.getText())) {
		case "    Small":
			small.setSelected(true);
			break;
		case "    Medium":
			medium.setSelected(true);
			break;
		case "    Large":
			large.setSelected(true);
			break;
		}

		bg.add(small);
		bg.add(medium);
		bg.add(large);

		small.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = SetScreenLocation.screenSize.width / 8;
				SubliminalFrame.height = SetScreenLocation.screenSize.height / 8;
			}
		});

		medium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = SetScreenLocation.screenSize.width / 4;
				SubliminalFrame.height = SetScreenLocation.screenSize.height / 4;
				;
			}
		});

		large.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = SetScreenLocation.screenSize.width / 3;
				SubliminalFrame.height = SetScreenLocation.screenSize.height / 3;
			}
		});

		settingsMenu.add(small);
		settingsMenu.add(medium);
		settingsMenu.add(large);

		// Add items to menu bar
		add(fileMenu);
		add(settingsMenu);

		setOpaque(true);
	}

	private JMenuItem exitItem() {

		BlueGreyMenuItem fileMenu = new BlueGreyMenuItem("Exit");
		fileMenu.setAction(new AbstractAction("Exit") {

			private static final long serialVersionUID = -3143584007710624166L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return fileMenu;
	}

	private JMenuItem factoryResetItem() {
		BlueGreyMenuItem messageResetItem = new BlueGreyMenuItem("    Restore Messages");

		messageResetItem.setAction(new AbstractAction("    Restore Messages") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				final JButton ok = new JButton("ok");
				final JButton cancel = new JButton("cancel");
				int optionType = JOptionPane.CANCEL_OPTION;
				int messageType = JOptionPane.WARNING_MESSAGE;
				final String warningMessage = "This option will remove all custom messages you have created and restore everything to its original state";
				final String title = "Reset Messages";
				final Object[] selValues = { ok, cancel };

				ok.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						messageController.loadInBuiltCategories();
						messageController.save();
						messagePanel.removeMessages();
						messagePanel.setMessageList(messageController.getMessagesFromActiveTenseCategory());
						controlPanel.resetSelection();
						Window w = SwingUtilities.getWindowAncestor(ok);
						if (w != null) {
							w.dispose();
						}
					}
				});
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						Window w = SwingUtilities.getWindowAncestor(cancel);
						if (w != null) {
							w.dispose();
						}
					}
				});
				JOptionPane.showOptionDialog(null, warningMessage, title, optionType, messageType, null, selValues,
						selValues[0]);
			}
		});
		return messageResetItem;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.decode("#1975bf"));
		g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

	}
}