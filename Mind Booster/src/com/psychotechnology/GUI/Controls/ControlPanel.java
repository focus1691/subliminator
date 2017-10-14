package com.psychotechnology.GUI.Controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.psychotechnology.util.IconFetch;

public class ControlPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1990836352559802232L;
	private boolean active = false;
	private JButton startBtn, addBtn, editBtn, deleteBtn, changeBtn;
	private JSeparator separator, separator2, separator3;
	private ButtonGroup messageSelectorGroup;
	private JRadioButton selectBtn, deselectBtn;
	private MessageListener messageListener;

	public ControlPanel() {

		initComponents();
		styleButtons();
		setupUI();

		startBtn.addActionListener(this);
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		changeBtn.addActionListener(this);
		selectBtn.addActionListener(this);
		deselectBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				if (active == false) {
					active = true;
					startBtn.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/stop.jpg"));
				} else {
					active = false;
					startBtn.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/start.jpg"));
				}
				messageListener.messageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == addBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.addMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == editBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.editMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == deleteBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.deleteMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == changeBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.editImageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == selectBtn) {
			MessageEvent messageEvent = new MessageEvent(this, true);
			if (messageListener != null) {
				messageListener.messageSelectionEventOccurred(messageEvent);
			}
		} else if (e.getSource() == deselectBtn) {
			MessageEvent messageEvent = new MessageEvent(this, false);
			if (messageListener != null) {
				messageListener.messageSelectionEventOccurred(messageEvent);
			}
		}
	}
	
	/**
	 * This method initializes Control Panel components
	 */
	private void initComponents() {
		startBtn = new JButton(IconFetch.getInstance().getIcon("/com/psychotechnology/images/start.jpg"));
		startBtn.setToolTipText("Play subliminal messages");
		addBtn = new JButton("Add");
		addBtn.setToolTipText("Add a new message");
		editBtn = new JButton("Edit");
		editBtn.setToolTipText("Edit message");
		deleteBtn = new JButton("Delete");
		deleteBtn.setToolTipText("Delete messages");
		changeBtn = new JButton("Change Image");
		changeBtn.setToolTipText("Change messages");
		separator = new JSeparator(SwingConstants.VERTICAL);
		separator2 = new JSeparator(SwingConstants.VERTICAL);
		separator3 = new JSeparator(SwingConstants.VERTICAL);
		messageSelectorGroup = new ButtonGroup();
		deselectBtn = new JRadioButton("Deselect All");
		selectBtn = new JRadioButton("Select All");
		messageSelectorGroup.add(deselectBtn);
		messageSelectorGroup.add(selectBtn);
	}

	/**
	 * Style and add images to the buttons
	 */
	private void styleButtons() {
		// Start Button
		startBtn.setOpaque(false);
		startBtn.setPreferredSize(new Dimension(185, 70));
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);

		// Add Button
		addBtn.setOpaque(false);
		addBtn.setPreferredSize(new Dimension(100, 40));
		addBtn.setContentAreaFilled(false);
		addBtn.setBorderPainted(false);
		addBtn.setForeground(Color.WHITE);
		addBtn.setIcon(new ImageIcon(this.getClass().getResource("/com/psychotechnology/images/plus.jpg")));
		addBtn.setHorizontalAlignment(SwingConstants.LEFT);

		// Edit Button
		editBtn.setOpaque(false);
		editBtn.setPreferredSize(new Dimension(100, 40));
		editBtn.setContentAreaFilled(false);
		editBtn.setBorderPainted(false);
		editBtn.setForeground(Color.WHITE);
		editBtn.setIcon(new ImageIcon(this.getClass().getResource("/com/psychotechnology/images/edit.jpg")));
		editBtn.setHorizontalAlignment(SwingConstants.LEFT);

		// Delete Button
		deleteBtn.setOpaque(false);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setIcon(new ImageIcon(this.getClass().getResource("/com/psychotechnology/images/delete.jpg")));
		deleteBtn.setHorizontalAlignment(SwingConstants.LEFT);

		// Change Button
		changeBtn.setOpaque(false);
		changeBtn.setContentAreaFilled(false);
		changeBtn.setBorderPainted(false);
		changeBtn.setForeground(Color.WHITE);
		changeBtn.setIcon(new ImageIcon(this.getClass().getResource("/com/psychotechnology/images/change.jpg")));
		changeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		separator.setPreferredSize(new Dimension(1, 30));
		separator.setOpaque(true);
		separator.setBackground(Color.decode("#1060a1"));
		
		separator2.setPreferredSize(new Dimension(1, 30));
		separator2.setOpaque(true);
		separator2.setBackground(Color.decode("#1060a1"));
		
		separator3.setPreferredSize(new Dimension(1, 30));
		separator3.setOpaque(true);
		separator3.setBackground(Color.decode("#1060a1"));

		deselectBtn.setForeground(Color.WHITE);
		deselectBtn.setPreferredSize(new Dimension(100, 30));
		selectBtn.setForeground(Color.WHITE);
		selectBtn.setPreferredSize(new Dimension(100, 30));
	}

	/**
	 * This method uses GridBagLayout to position components onto the Control
	 * Panel
	 */
	private void setupUI() {
		
		JPanel container = new JPanel(new FlowLayout());
		container.add(selectBtn);
		container.add(deselectBtn);
		
		JPanel container2 = new JPanel(new FlowLayout());
		container2.add(addBtn);
		container2.add(separator);
		container2.add(editBtn);
		container2.add(separator2);
		container2.add(deleteBtn);
		container2.add(separator3);
		container2.add(changeBtn);
		
		container.setBackground(Color.decode("#1975bf"));
		container2.setBackground(Color.decode("#1975bf"));
		setBackground(Color.decode("#1975bf"));
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		
		// Start Button
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 2;
		gc.gridwidth = 1;
		gc.weightx = 0.3;
		gc.weighty = 1;
		gc.insets = new Insets(0, 40, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.VERTICAL;
		add(startBtn, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 30, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(container, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 15, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(container2, gc);
	}

	/**
	 * Used by anonymous class in MainFrame to listen for a message start event
	 * 
	 * @param messageListener
	 *            interface object used to alert anonymous class in MainFrame
	 */
	public void setMessageStartListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}
}
