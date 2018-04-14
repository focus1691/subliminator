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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import constants.MessageTense;
import controller.MessageController;
import gui.component.BlueCurvedScrollBar;
import gui.controls.MessageEvent;
import gui.controls.MessageListener;
import gui.util.IconFetch;
import model.Message;
import utility.FontPicker;

public class MessagePanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = -2216564927731765772L;
	private JLabel header;
	private JScrollPane scroller;
	private JList<Message> messageList;
	private MessageListCellRenderer messageListCellRenderer;
	private MessageListSelectionModel messageListSelectionModel;
	private DefaultListModel<Message> model = new DefaultListModel<>();
	private JLabel firstPersonLabel, secondPersonLabel;
	private ImageIcon activeIcon, inactiveIcon;
	private JPopupMenu popupMenu;
	private JMenuItem addItem, editItem, deleteItem, changeItem;
	private MessageController messageController;
	private MessageListener messageListener;

	public MessagePanel(MessageController messageController) {
		this.messageController = messageController;
		initComponents();
		setupUI();
	}

	private void switchPersonMode(MessageTense messageTense) {
		int[] selectedIndices = messageList.getSelectedIndices();
		model.clear();
		messageController.setMessageTense(messageTense);
		firstPersonLabel.setIcon(inactiveIcon);
		secondPersonLabel.setIcon(activeIcon);
		setMessageList(messageController.getMessagesFromTenseCategory(messageTense));
		messageListSelectionModel.setMgsSelected(selectedIndices);
	}

	private void initComponents() {
		popupMenu = createMessageMenu();

		setMessageList(messageController.getMessagesFromActiveTenseCategory());
		messageListSelectionModel = new MessageListSelectionModel(
				messageController.getMessagesFromActiveTenseCategory().size());

		messageList = new JList<Message>(model);
		messageList.setFont(FontPicker.getFont(FontPicker.latoRegular, 19.8f));
		messageList.setFixedCellHeight(55);
		messageList.setFixedCellWidth(350);
		messageList.setSelectionModel(messageListSelectionModel);
		messageList.addMouseListener(this);

		messageListCellRenderer = new MessageListCellRenderer();
		messageList.setCellRenderer(messageListCellRenderer);

		header = new JLabel("Select Messages");
		header.setFont(FontPicker.getFont(FontPicker.latoBlack, 20));
		header.setLayout(new GridLayout());

		firstPersonLabel = new JLabel("1st Person");
		firstPersonLabel.setFont(FontPicker.getFont(FontPicker.latoRegular, 18.49f));
		firstPersonLabel.setToolTipText("Message list in first person");
		firstPersonLabel.setIcon(IconFetch.getInstance().getIcon("/images/man-active.jpg"));
		firstPersonLabel.setIconTextGap(20);
		firstPersonLabel.addMouseListener(this);

		secondPersonLabel = new JLabel("2nd Person");
		secondPersonLabel.setFont(FontPicker.getFont(FontPicker.latoRegular, 18.49f));
		secondPersonLabel.setToolTipText("Message list in second person");
		firstPersonLabel.setIcon(IconFetch.getInstance().getIcon("/images/man-inactive.jpg"));
		secondPersonLabel.setIconTextGap(20);
		secondPersonLabel.addMouseListener(this);

		activeIcon = IconFetch.getInstance().getIcon("/images/man-active.jpg");
		inactiveIcon = IconFetch.getInstance().getIcon("/images/man-inactive.jpg");

		if (messageController.getMessageTense() == MessageTense.FIRST_PERSON) {
			firstPersonLabel.setIcon(activeIcon);
			secondPersonLabel.setIcon(inactiveIcon);
		} else if (messageController.getMessageTense() == MessageTense.SECOND_PERSON) {
			firstPersonLabel.setIcon(inactiveIcon);
			secondPersonLabel.setIcon(activeIcon);
		}

		scroller = new JScrollPane(messageList);
		scroller.getVerticalScrollBar().setUI(new BlueCurvedScrollBar());
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scroller.getVerticalScrollBar().setBackground(Color.decode("#efeff0"));
		scroller.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scroller.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	private void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		gc.weightx = 0.01;
		gc.weighty = 0.1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(header, gc);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.insets = new Insets(20, 0, 0, 0);
		add(firstPersonLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.insets = new Insets(20, 0, 0, 0);
		add(secondPersonLabel, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		gc.weightx = 0;
		gc.weighty = 0.7;
		gc.insets = new Insets(30, 0, 10, 0);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.BOTH;
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

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((e.getSource() == firstPersonLabel) && messageController.getMessageTense() != MessageTense.FIRST_PERSON) {
			switchPersonMode(MessageTense.FIRST_PERSON);
			firstPersonLabel.setIcon(activeIcon);
			secondPersonLabel.setIcon(inactiveIcon);
		} else if ((e.getSource() == secondPersonLabel)
				&& messageController.getMessageTense() != MessageTense.SECOND_PERSON) {
			switchPersonMode(MessageTense.SECOND_PERSON);
			firstPersonLabel.setIcon(inactiveIcon);
			secondPersonLabel.setIcon(activeIcon);
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

	public JList<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(JList<Message> messageList) {
		this.messageList = messageList;
	}

	public void setMessageList(List<Message> messages) {
		int i;
		for (i = 0; i < messages.size(); i++) {
			model.addElement(messages.get(i));
		}
	}

	public void removeMessages() {
		model.clear();
	}

	public MessageListSelectionModel getMessageListSelectionModel() {
		return messageListSelectionModel;
	}

	public List<Message> getSelectedMessages() {
		int i;

		List<Message> selectedMessages = new ArrayList<Message>();

		for (i = 0; i < messageController.getMessagesFromActiveTenseCategory().size(); i++) {
			if (messageListSelectionModel.isSelectedIndex(i)) {
				Message message = messageController.getMessageFromActiveTenseCategory(i);
				selectedMessages.add(message);
			}
		}
		return selectedMessages;
	}

	public void setMessageStartListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}
}