package com.psychotechnology.Controller;

import java.io.File;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.psychotechnology.GUI.Subliminal;
import com.psychotechnology.Model.MessageLocation;
import com.psychotechnology.util.MathFunctions;

public class PlayMessageTask implements Runnable {

	private Controller controller;
	private MathFunctions mathFunctions = new MathFunctions();
	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
	private Subliminal subliminal;
	private volatile boolean shutdown = true;
	private int messageIndex;
	private final String absolutePath = new File(".").getAbsolutePath();

	public PlayMessageTask(Controller controller, MessageLocation messageLocation) {
		this.controller = controller;
		subliminal = new Subliminal(absolutePath, messageLocation);
	}
	
	@Override
	public void run() {
		setMessageIndex(mathFunctions.randInt(0, controller.getActiveMessages().size() - 1));
		subliminal.setMessage(controller.getActiveMessages().get(messageIndex));
		subliminal.show();
		try {
			TimeUnit.MILLISECONDS.sleep(controller.getMessageSpeed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		subliminal.hide();
	}
	
	public void terminate() {
		subliminal.hide();
		scheduledExecutorService.shutdown();
	}

	public int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
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
