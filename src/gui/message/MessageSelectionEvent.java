package gui.message;

import java.util.EventObject;
import java.util.List;

import constants.MessageTense;
import model.Message;

@SuppressWarnings("serial")
public class MessageSelectionEvent extends EventObject {
	
	private MessageTense messageTense;
	private List<Message> selectedMessages;

	public MessageSelectionEvent(Object source) {
		super(source);
	}

	public MessageSelectionEvent(Object source, List<Message> selectedMessages, MessageTense messageTense) {
		super(source);
		this.selectedMessages = selectedMessages;
		this.messageTense = messageTense;
	}

	public MessageTense getMessageTense() {
		return messageTense;
	}

	public void setMessageTense(MessageTense messageTense) {
		this.messageTense = messageTense;
	}

	public List<Message> getSelectedMessages() {
		return selectedMessages;
	}

	public void setSelectedMessages(List<Message> selectedMessages) {
		this.selectedMessages = selectedMessages;
	}
}
