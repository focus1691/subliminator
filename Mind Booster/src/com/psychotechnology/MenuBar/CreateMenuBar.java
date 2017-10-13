package com.psychotechnology.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.Subliminal;
import com.psychotechnology.GUI.Message.MessagePanel;
import com.psychotechnology.util.IconFetch;

public class CreateMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 2825424567069068134L;
	private Controller controller;
	private MessagePanel messagePanel;

	public CreateMenuBar(Controller controller, MessagePanel messagePanel) {
		
	this.controller = controller;
	this.messagePanel = messagePanel;
	
	JMenu fileMenu = new JMenu("File");
	fileMenu.setBorder(BorderFactory.createRaisedBevelBorder());
	JMenu settingsMenu = new JMenu("Settings");

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
			Subliminal.width = 200;
			Subliminal.height = 200;
		}
	});
	
	medium.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Subliminal.width = 300;
			Subliminal.height = 300;
			//Subliminal.setSize(900, 750);
		}
	});
	
	large.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Subliminal.width = 500;
			Subliminal.height = 500;
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
		fileMenu.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/exit.png"));

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

		messageResetItem.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/reset.png"));

		return messageResetItem;
	}
	
	private JMenuItem messageSizeItem() {
		
		JMenuItem messageSizeItem = new JMenuItem(new AbstractAction("    Message Size") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		return messageSizeItem;
	}
}
