package com.psychotechnology.GUI.Message;

import javax.swing.DefaultListSelectionModel;

public class MessageListSelectionModel extends DefaultListSelectionModel {

	private static final long serialVersionUID = 1L;
	private int messageCount = 0;
	private int activeMessages = 0;

	public MessageListSelectionModel(int messageCount) {
		this.messageCount = messageCount;
		setSelectionMode(MULTIPLE_INTERVAL_SELECTION);
	}

	@Override
	public void setSelectionInterval(int index0, int index1) {
		if (super.isSelectedIndex(index0)) {
			super.removeSelectionInterval(index0, index1);
			activeMessages--;
		} else {
			super.addSelectionInterval(index0, index1);
			activeMessages++;
		}
	}

	public void setAllMessagesActive() {
		int i;
		for (i = 0; i < messageCount; i++) {
			super.addSelectionInterval(i, i);
		}
		activeMessages = messageCount;
	}

	public int getActiveMessages() {
		return activeMessages;
	}

	public void setActiveMessages(int activeMessages) {
		this.activeMessages = activeMessages;
	}

	public int getLastSelection() {
		return super.getLeadSelectionIndex();
	}

	public int[] getSelectedMsgIndices() {
		int i = 0, j = 0;

		if (activeMessages == 0) {
			return new int[0];
		}

		int[] selectedIndices = new int[activeMessages];
		while (i < messageCount) {
			if (isSelectedIndex(i)) {
				selectedIndices[j] = i;
				j++;
			}
			i++;
		}
		//messageCount -= selectedIndices.length;
		activeMessages = selectedIndices.length;
		return selectedIndices;
	}

	public void setMgsSelected(int[] selectedIndices) {

		int i;

		for (i = 0; i < selectedIndices.length; i++) {
			setSelectionInterval(selectedIndices[i], selectedIndices[i]);
		}
	}
}
