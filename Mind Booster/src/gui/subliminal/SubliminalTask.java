package gui.subliminal;

import java.util.concurrent.TimeUnit;

import controller.MessageController;
import utility.RandomNumberGenerator;

public class SubliminalTask implements Runnable {

	private MessageController controller;
	private Subliminal subliminal;
	private int messageIndex;

	public SubliminalTask(MessageController controller, Subliminal subliminal) {
		this.controller = controller;
		this.subliminal = subliminal;
	}

	@Override
	public void run() {
		setMessageIndex(RandomNumberGenerator.randInt(0, controller.getActiveMessages().size() - 1));
		subliminal.setMessage(controller.getActiveMessages().get(messageIndex));
		subliminal.setVisible(true);
		try {
			TimeUnit.MILLISECONDS.sleep(controller.getSpeed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		subliminal.setVisible(false);
	}

	public void setMessageIndex(int messageIndex) {
		this.messageIndex = messageIndex;
	}

	public int getMessageIndex() {
		return messageIndex;
	}
}
