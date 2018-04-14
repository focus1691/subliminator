package gui.subliminal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import controller.MessageController;
import utility.RandomNumberGenerator;

public class SubliminalTask implements Runnable {

	private MessageController controller;
	private SubliminalFrame subliminal;
	private int messageIndex;

	public SubliminalTask(MessageController controller, SubliminalFrame subliminal) {
		this.controller = controller;
		this.subliminal = subliminal;
	}

	@Override
	public void run() {
		setMessageIndex(RandomNumberGenerator.randInt(0, controller.getActiveMessages().size() - 1));
		subliminal.setMessage(controller.getActiveMessages().get(messageIndex));
		subliminal.setVisible(true);

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				subliminal.setVisible(false);
			}
		};
		Timer timer = new Timer(controller.getSpeed(), taskPerformer);
		timer.setRepeats(false);
		timer.start();
	}

	public void setMessageIndex(int messageIndex) {
		this.messageIndex = messageIndex;
	}

	public int getMessageIndex() {
		return messageIndex;
	}
}