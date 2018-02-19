package gui.message;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import constants.MessageTense;
import controller.MessageController;
import controls.MessageEvent;
import controls.MessageListener;
import gui.BlueCurvedScrollBar;
import model.Message;
import utility.FontPicker;
import utility.IconFetch;
import utility.RoundButton;

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
	private JPopupMenu popupMenu;
	private JMenuItem addItem, editItem, deleteItem, changeItem;
	private MessageController controller;
	private MessageListener messageListener;

	public MessagePanel(MessageController controller) {
		this.controller = controller;
		initComponents();
		styleUI();
		setupUI();

		firstPersonLabel.addMouseListener(this);
		secondPersonLabel.addMouseListener(this);
		firstPersonBtn.addMouseListener(this);
		secondPersonBtn.addMouseListener(this);
		messageList.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((e.getSource() == firstPersonBtn || e.getSource() == firstPersonLabel)
				&& controller.getMessageTense() != MessageTense.FIRST_PERSON) {
			switchPersonMode(MessageTense.FIRST_PERSON);
			firstPersonBtn.setIcon(activeIcon);
			secondPersonBtn.setIcon(inactiveIcon);
		} else if ((e.getSource() == secondPersonBtn || e.getSource() == secondPersonLabel)
				&& controller.getMessageTense() != MessageTense.SECOND_PERSON) {
			switchPersonMode(MessageTense.SECOND_PERSON);
			firstPersonBtn.setIcon(inactiveIcon);
			secondPersonBtn.setIcon(activeIcon);
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
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	private void switchPersonMode(MessageTense messageTense) {
		int[] selectedIndices = messageList.getSelectedIndices();
		model.clear();
		controller.setMessageTense(messageTense);
		firstPersonBtn.setIcon(inactiveIcon);
		secondPersonBtn.setIcon(activeIcon);
		setMessageList(controller.getMessagesFromTenseCategory(messageTense));
		messageListSelectionModel.setMgsSelected(selectedIndices);
	}
	
	private void initComponents() {
		popupMenu = createMessageMenu();
		
		
		setMessageList(controller.getMessagesFromActiveTenseCategory());
		messageListSelectionModel = new MessageListSelectionModel(
				controller.getMessagesFromActiveTenseCategory().size());
		messageList = new JList<Message>(model);
		
		
		header = new JLabel("Select Messages");

		firstPersonLabel = new JLabel("1st Person");
		secondPersonLabel = new JLabel("2nd Person");

		activeIcon = IconFetch.getInstance().getIcon("/images/man-active.jpg");
		inactiveIcon = IconFetch.getInstance().getIcon("/images/man-inactive.jpg");
		
		firstPersonBtn = new RoundButton(activeIcon);
		secondPersonBtn = new RoundButton(inactiveIcon);

		firstPersonBtn.setToolTipText("Message list in first person");
		secondPersonBtn.setToolTipText("Message list in second person");

		scroller = new JScrollPane(messageList);
	}

	private void styleUI() {

		// UI for the header
		header.setFont(FontPicker.getFont(FontPicker.latoBlack, 20));
		header.setLayout(new GridLayout());

		// Message List
		messageList.setFont(FontPicker.getFont(FontPicker.latoRegular, 16));
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

		// Message list: full width, 90% of height
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

		addItem = new JMenuItem("Add");
		addItem.setIcon(IconFetch.getInstance().getIcon("/images/addItem.png"));
		addItem.setMargin(new Insets(5, 0, 0, 0));

		editItem = new JMenuItem("Edit");
		editItem.setIcon(IconFetch.getInstance().getIcon("/images/editItem.png"));
		editItem.setMargin(new Insets(10, 0, 2, 0));

		deleteItem = new JMenuItem("Delete");
		deleteItem.setIcon(IconFetch.getInstance().getIcon("/images/deleteItem.png"));
		deleteItem.setMargin(new Insets(10, 2, 0, 0));

		changeItem = new JMenuItem("Change Image");
		changeItem.setIcon(IconFetch.getInstance().getIcon("/images/changeItem.png"));
		changeItem.setMargin(new Insets(10, 0, 2, 0));

		addItem.addActionListener(this);
		editItem.addActionListener(this);
		deleteItem.addActionListener(this);
		changeItem.addActionListener(this);

		messageMenu.add(addItem);
		messageMenu.add(editItem);
		messageMenu.add(deleteItem);
		messageMenu.add(changeItem);

		return messageMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MessageEvent messageEvent = new MessageEvent(this);
		
		if (messageListener != null) {
			if (e.getSource() == addItem) {
				messageListener.addMessageEventOccurred(messageEvent);
				
			} else if (e.getSource() == editItem) {
				messageListener.editMessageEventOccurred(messageEvent);
				
			} else if (e.getSource() == deleteItem) {
				
				messageListener.deleteMessageEventOccurred(messageEvent);
			} else if (e.getSource() == changeItem) {
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
	
	public void setMessageList(JList<Message> messageList) {
		this.messageList = messageList;
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
