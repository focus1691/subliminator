package gui.settings;

import java.util.EventObject;

public class SettingsEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	private int messageSpeed;
	private int messageInterval;

	SettingsEvent(Object source) {
		super(source);
	}

	public SettingsEvent(Object source, int messageSpeed, int messageInterval) {
		super(source);
		this.messageSpeed = messageSpeed;
		this.messageInterval = messageInterval;
	}

	public int getMessageSpeed() {
		return messageSpeed;
	}

	public void setMessageSpeed(int messageSpeed) {
		this.messageSpeed = messageSpeed;
	}

	public int getMessageInterval() {
		return messageInterval;
	}

	public void setMessageInterval(int messageInterval) {
		this.messageInterval = messageInterval;
	}
}
