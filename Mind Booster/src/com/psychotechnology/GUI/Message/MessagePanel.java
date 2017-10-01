package com.psychotechnology.GUI.Message;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.BlueCurvedScrollBar;
import com.psychotechnology.GUI.Controls.MessageEvent;
import com.psychotechnology.GUI.Controls.MessageListener;
import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.MessageTense;
import com.psychotechnology.util.CustomFont;
import com.psychotechnology.util.IconFetch;
import com.psychotechnology.util.RoundButton;

public class MessagePanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = -2216564927731765772L;
	private JLabel header;
	private JScrollPane scroller;
	private JList<Message> messageList;
	private MessageListCellRenderer messageListCellRenderer;
	private MessageListSelectionModel messageListSelectionModel;
	private DefaultListModel<Message> model = new DefaultListModel<>();
	private JLabel firstPersonLabel, secondPersonLabel;
	private JButton firstPersonBtn, secondPersonBtn;
	private ImageIcon activeIcon, inactiveIcon;
	private JPopupMenu messageMenu;
	private JMenuItem add, edit, delete, change;
	private Controller controller;
	private MessageListener messageListener;

	public MessagePanel(Controller controller) {
		this.controller = controller;
		initComponents();
		styleUI();
		setupUI();

		firstPersonLabel.addMouseListener(this);
		secondPersonLabel.addMouseListener(this);
		firstPersonBtn.addMouseListener(this);
		secondPersonBtn.addMouseListener(this);

		messageList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {

					@SuppressWarnings("unchecked")
					JList<Message> list = (JList<Message>) e.getSource();
					int row = list.locationToIndex(e.getPoint());
					if (!messageListSelectionModel.isSelectedIndex(row)) {
						list.setSelectedIndex(row);
					} else {
						list.removeSelectionInterval(row, row);
						list.setSelectedIndex(row);
					}

					messageMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((e.getSource() == firstPersonBtn || e.getSource() == firstPersonLabel)
				&& controller.getMessageTense() != MessageTense.FIRST_PERSON) {
			int[] selectedIndices = messageListSelectionModel.getSelectedMsgIndices();
			model.clear();
			controller.setMessageTense(MessageTense.FIRST_PERSON);
			firstPersonBtn.setIcon(activeIcon);
			secondPersonBtn.setIcon(inactiveIcon);
			setMessageList(controller.getMessagesFromTenseCategory(MessageTense.FIRST_PERSON));
			messageListSelectionModel.setMgsSelected(selectedIndices);
		} else if ((e.getSource() == secondPersonBtn || e.getSource() == secondPersonLabel)
				&& controller.getMessageTense() != MessageTense.SECOND_PERSON) {
			int[] selectedIndices = messageListSelectionModel.getSelectedMsgIndices();
			model.clear();
			controller.setMessageTense(MessageTense.SECOND_PERSON);
			firstPersonBtn.setIcon(inactiveIcon);
			secondPersonBtn.setIcon(activeIcon);
			setMessageList(controller.getMessagesFromTenseCategory(MessageTense.SECOND_PERSON));
			messageListSelectionModel.setMgsSelected(selectedIndices);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * This method initializes all Message Panel components
	 */
	private void initComponents() {
		messageMenu = createMessageMenu();
		setMessageList(controller.getMessagesFromActiveTenseCategory());
		messageListSelectionModel = new MessageListSelectionModel(
				controller.getMessagesFromActiveTenseCategory().size());
		messageList = new JList<Message>(model);
		header = new JLabel("Select Messages");

		firstPersonLabel = new JLabel("1st Person");
		secondPersonLabel = new JLabel("2nd Person");

		activeIcon = IconFetch.getInstance().getIcon("/com/psychotechnology/images/man-active.jpg");
		inactiveIcon = IconFetch.getInstance().getIcon("/com/psychotechnology/images/man-inactive.jpg");

		firstPersonBtn = new RoundButton(activeIcon);
		secondPersonBtn = new RoundButton(inactiveIcon);
		
		firstPersonBtn.setToolTipText("Message list in first person");
		secondPersonBtn.setToolTipText("Message list in second person");

		scroller = new JScrollPane(messageList);
	}

	private void styleUI() {

		// UI for the header
		header.setFont(CustomFont.getFont(CustomFont.latoBlack, 20));
		header.setLayout(new GridLayout());

		// Message List
		messageList.setFont(CustomFont.getFont(CustomFont.latoRegular, 16));
		messageList.setFixedCellHeight(55);
		messageList.setFixedCellWidth(350);
		messageList.setSelectionModel(messageListSelectionModel);
		messageListCellRenderer = new MessageListCellRenderer();
		messageList.setCellRenderer(messageListCellRenderer);
		
		// Vertical ScrollBar
		scroller.getVerticalScrollBar().setUI(new BlueCurvedScrollBar());
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scroller.getVerticalScrollBar().setBackground(Color.decode("#efeff0"));
		scroller.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scroller.setBorder(new EmptyBorder(0, 0, 0, 0));
	}
	
	/**
	 * Setup Layout Manager
	 */
	private void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		// Header, top, full-width, short height
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		gc.weightx = 0.5;
		gc.weighty = 0.05;
		gc.insets = new Insets(30, 40, 0, 0);
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(header, gc);

		// 1st person button
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(0, 40, 0, 0);
		add(firstPersonBtn, gc);

		/// 1st person label
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(0, 0, 0, 0);
		add(firstPersonLabel, gc);

		// 2nd person button
		gc.gridx = 2;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(0, 0, 0, 0);
		add(secondPersonBtn, gc);

		// 2nd person label
		gc.gridx = 3;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(0, 0, 0, 0);
		add(secondPersonLabel, gc);

		// Message list: full width, 90% of heights
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		gc.weightx = 0;
		gc.weighty = 0.7;
		gc.insets = new Insets(0, 0, 10, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.VERTICAL;
		add(scroller, gc);

		setBackground(Color.decode("#efeff0"));
	}

	private JPopupMenu createMessageMenu() {

		JPopupMenu messageMenu = new JPopupMenu();
		messageMenu.setBorder(BorderFactory.createRaisedBevelBorder());

		add = new JMenuItem("Add");
		add.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/addItem.png"));
		add.setMargin(new Insets(5, 0, 0, 0));

		edit = new JMenuItem("Edit");
		edit.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/editItem.png"));
		edit.setMargin(new Insets(10, 0, 2, 0));

		delete = new JMenuItem("Delete");
		delete.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/deleteItem.png"));
		delete.setMargin(new Insets(10, 2, 0, 0));

		change = new JMenuItem("Change Image");
		change.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/changeItem.png"));
		change.setMargin(new Insets(10, 0, 2, 0));

		add.addActionListener(this);
		edit.addActionListener(this);
		delete.addActionListener(this);
		change.addActionListener(this);

		messageMenu.add(add);
		messageMenu.add(edit);
		messageMenu.add(delete);
		messageMenu.add(change);

		return messageMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == add) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.addMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == edit) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.editMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == delete) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.deleteMessageEventOccurred(messageEvent);
			}
		} else if (e.getSource() == change) {
			MessageEvent messageEvent = new MessageEvent(this);
			if (messageListener != null) {
				messageListener.editImageEventOccurred(messageEvent);
			}
		}
	}

	/**
	 *
	 * @return All Message objects inside the JList
	 */
	public JList<Message> getMessageList() {
		return messageList;
	}

	/**
	 * Set list with all messages from chosen category
	 * 
	 * @param categoryIndex
	 *            category to retrieve messages from
	 */
	public void setMessageList(List<Message> messages) {
		int i;
		for (i = 0; i < messages.size(); i++) {
			model.addElement(messages.get(i));
		}
	}

	public DefaultListModel<Message> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Message> model) {
		this.model = model;
	}

	/**
	 * 
	 * @return list model
	 */
	public MessageListSelectionModel getMessageListSelectionModel() {
		return messageListSelectionModel;
	}

	/**
	 * 
	 * @return Selected messages
	 */
	public List<Message> getSelectedMessages() {
		int i;

		List<Message> selectedMessages = new ArrayList<Message>();

		for (i = 0; i < controller.getMessagesFromActiveTenseCategory().size(); i++) {
			if (messageListSelectionModel.isSelectedIndex(i)) {
				Message message = controller.getMessageFromActiveTenseCategory(i);
				selectedMessages.add(message);
			}
		}
		return selectedMessages;
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
