package com.psychotechnology.GUI.Controls;

import java.util.EventObject;
import java.util.List;

import com.psychotechnology.Model.Message;

public class MessageEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private boolean allMessagesSelected;
	private List<Message> activeMessages;

	public MessageEvent(Object source) {
		super(source);
	}

	public MessageEvent(Object source, boolean allMessagesSelected) {
		super(source);
		this.allMessagesSelected = allMessagesSelected;
	}

	public void setAllMessagesSelected(boolean allMessagesSelected) {
		this.allMessagesSelected = allMessagesSelected;
	}

	public boolean isAllMessagesSelected() {
		return allMessagesSelected;
	}

	public List<Message> getActiveMessages() {
		return activeMessages;
	}

	public void setActiveMessages(List<Message> activeMessages) {
		this.activeMessages = activeMessages;
	}
}
