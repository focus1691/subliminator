package gui.controls;

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

import gui.util.IconFetch;

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
		setupUI();
	}

	private void initComponents() {
		startBtn = new JButton(IconFetch.getInstance().getIcon("/images/start.jpg"));
		startBtn.setOpaque(false);
		startBtn.setPreferredSize(new Dimension(185, 70));
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);
		startBtn.setToolTipText("Play subliminal messages");
		startBtn.addActionListener(this);

		addBtn = new JButton("Add");
		addBtn.setOpaque(false);
		addBtn.setPreferredSize(new Dimension(120, 40));
		addBtn.setContentAreaFilled(false);
		addBtn.setBorderPainted(false);
		addBtn.setForeground(Color.WHITE);
		addBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/plus.jpg")));
		addBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addBtn.setToolTipText("Add a new message");
		addBtn.addActionListener(this);

		editBtn = new JButton("Edit");
		editBtn.setOpaque(false);
		editBtn.setPreferredSize(new Dimension(120, 40));
		editBtn.setContentAreaFilled(false);
		editBtn.setBorderPainted(false);
		editBtn.setForeground(Color.WHITE);
		editBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/edit.jpg")));
		editBtn.setHorizontalAlignment(SwingConstants.LEFT);
		editBtn.setToolTipText("Edit message");
		editBtn.addActionListener(this);

		deleteBtn = new JButton("Delete");
		deleteBtn.setOpaque(false);
		deleteBtn.setPreferredSize(new Dimension(150, 40));
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/delete.jpg")));
		deleteBtn.setHorizontalAlignment(SwingConstants.LEFT);
		deleteBtn.setToolTipText("Delete messages");
		deleteBtn.addActionListener(this);

		changeBtn = new JButton("Change Image");
		changeBtn.setOpaque(false);
		changeBtn.setPreferredSize(new Dimension(220, 40));
		changeBtn.setContentAreaFilled(false);
		changeBtn.setBorderPainted(false);
		changeBtn.setForeground(Color.WHITE);
		changeBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/change.jpg")));
		changeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		changeBtn.setToolTipText("Change messages");
		changeBtn.addActionListener(this);

		separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setPreferredSize(new Dimension(1, 30));
		separator.setOpaque(true);
		separator.setBackground(Color.decode("#1060a1"));

		separator2 = new JSeparator(SwingConstants.VERTICAL);
		separator2.setPreferredSize(new Dimension(1, 30));
		separator2.setOpaque(true);
		separator2.setBackground(Color.decode("#1060a1"));

		separator3 = new JSeparator(SwingConstants.VERTICAL);
		separator3.setPreferredSize(new Dimension(1, 30));
		separator3.setOpaque(true);
		separator3.setBackground(Color.decode("#1060a1"));

		deselectBtn = new JRadioButton("Deselect All");
		deselectBtn.setForeground(Color.WHITE);
		deselectBtn.setPreferredSize(new Dimension(160, 30));
		deselectBtn.addActionListener(this);
		deselectBtn.setRolloverEnabled(false);

		selectBtn = new JRadioButton("Select All");
		selectBtn.setForeground(Color.WHITE);
		selectBtn.setPreferredSize(new Dimension(160, 30));
		selectBtn.addActionListener(this);
		selectBtn.setRolloverEnabled(false);

		messageSelectorGroup = new ButtonGroup();
		messageSelectorGroup.add(deselectBtn);
		messageSelectorGroup.add(selectBtn);
	}

	private void setupUI() {
		setBackground(Color.decode("#1975bf"));

		JPanel upperPane = new JPanel(new FlowLayout());
		upperPane.setBackground(Color.decode("#1975bf"));
		upperPane.add(selectBtn);
		upperPane.add(deselectBtn);

		JPanel lowerPane = new JPanel(new FlowLayout());
		lowerPane.setBackground(Color.decode("#1975bf"));
		lowerPane.add(addBtn);
		lowerPane.add(separator);
		lowerPane.add(editBtn);
		lowerPane.add(separator2);
		lowerPane.add(deleteBtn);
		lowerPane.add(separator3);
		lowerPane.add(changeBtn);

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

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
		add(upperPane, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 15, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(lowerPane, gc);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startBtn) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				if (active == false) {
					active = true;
					showStopButton();
				} else {
					active = false;
					showStartButton();
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

	public void showStopButton() {
		startBtn.setIcon(IconFetch.getInstance().getIcon("/images/stop.jpg"));
	}

	public void showStartButton() {
		startBtn.setIcon(IconFetch.getInstance().getIcon("/images/start.jpg"));
	}

	public void setMessageStartListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}
}
