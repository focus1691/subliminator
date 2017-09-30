package com.psychotechnology.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.psychotechnology.GUI.Subliminal;
import com.psychotechnology.Model.ScreenPosition;

public class SubliminalTask implements Runnable {

	private Controller controller;
	private Subliminal subliminal;
	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
	private volatile boolean shutdown = true;
	private int messageIndex;

	public SubliminalTask(Controller controller, Subliminal subliminal) {
		this.controller = controller;
		this.subliminal = subliminal;
	}
	
	@Override
	public void run() {
		setMessageIndex(controller.randInt(0, controller.getActiveMessages().size() - 1));
		subliminal.setMessage(controller.getActiveMessages().get(messageIndex));
		subliminal.setVisible(true);
		try {
			TimeUnit.MILLISECONDS.sleep(controller.getSpeed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		subliminal.setVisible(false);
	}
	
	public void terminate() {
		subliminal.setVisible(false);
		scheduledExecutorService.shutdown();
	}

	public boolean isShutdown() {
		return shutdown;
	}

	public void setShutdown(boolean shutdown) {
		this.shutdown = shutdown;
	}

	public void setMessageIndex(int messageIndex) {
		this.messageIndex = messageIndex;
	}
	
	public int getMessageIndex() {
		return messageIndex;
	}
}
