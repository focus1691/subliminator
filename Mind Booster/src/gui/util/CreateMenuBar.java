package gui.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import controller.MessageController;
import gui.message.MessagePanel;
import gui.subliminal.SubliminalFrame;
import utility.FontPicker;

public class CreateMenuBar extends JMenuBar {

	private static final long serialVersionUID = 2825424567069068134L;
	private MessageController controller;
	private MessagePanel messagePanel;

	public CreateMenuBar(MessageController controller, MessagePanel messagePanel) {

		this.controller = controller;
		this.messagePanel = messagePanel;

		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		fileMenu.setForeground(Color.WHITE);
		fileMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
		JMenu settingsMenu = new JMenu("Settings");
		settingsMenu.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		settingsMenu.setForeground(Color.WHITE);
		settingsMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

		// Exit
		fileMenu.add(exitItem());

		// Factory Reset
		settingsMenu.add(factoryResetItem());

		settingsMenu.addSeparator();

		// Message Size
		ButtonGroup bg = new ButtonGroup();
		JRadioButtonMenuItem small = new JRadioButtonMenuItem("    Small");
		JRadioButtonMenuItem medium = new JRadioButtonMenuItem("    Medium");
		JRadioButtonMenuItem large = new JRadioButtonMenuItem("    Large");
		small.setSelected(true);

		bg.add(small);
		bg.add(medium);
		bg.add(large);

		small.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = 200;
				SubliminalFrame.height = 200;
			}
		});

		medium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = 300;
				SubliminalFrame.height = 300;
			}
		});

		large.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubliminalFrame.width = 500;
				SubliminalFrame.height = 500;
			}
		});

		settingsMenu.add(small);
		settingsMenu.add(medium);
		settingsMenu.add(large);

		// Add items to menu bar
		add(fileMenu);
		add(settingsMenu);
	}

	private JMenuItem exitItem() {
		JMenuItem fileMenu = new JMenuItem(new AbstractAction("Exit") {

			private static final long serialVersionUID = -6305470444317273153L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return fileMenu;
	}

	private JMenuItem factoryResetItem() {
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
