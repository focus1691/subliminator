package com.psychotechnology.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.psychotechnology.GUI.SubliminalFrame;
import com.psychotechnology.util.MathFunctions;

public class MessageRunnable implements Runnable {

	private Controller controller;
	private MathFunctions mathFunctions = new MathFunctions();
	private List<Future> future = new ArrayList<Future>();
	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
	private SubliminalFrame subliminalFrame;
	private volatile boolean shutdown = true;
	private int messageIndex;
	private final String absolutePath = new File(".").getAbsolutePath();

	public MessageRunnable(Controller controller) {
		this.controller = controller;
		subliminalFrame = new SubliminalFrame(absolutePath);
	}

	public int getMessageIndex() {
		return messageIndex;
	}

	private Runnable getMessage() {
		return () -> setMessageIndex(mathFunctions.randInt(0, controller.getActiveMessages().size() - 1));
	}

	private Runnable setMessage() {
		return () -> subliminalFrame.setMessageAndImage(controller.getActiveMessages().get(messageIndex));
	}

	private Runnable showMessage() {
		return () -> subliminalFrame.show();
	}

	private Runnable clearMessage() {
		return () -> subliminalFrame.hide();
	}

	@Override
	public void run() {
		Runnable playMessage = showMessage();
		Runnable getMessage = getMessage();
		Runnable setMessage = setMessage();
		Runnable removeMessage = clearMessage();
		future.add(scheduledExecutorService.scheduleAtFixedRate(getMessage, 0, controller.getMessageInterval(),
				TimeUnit.MILLISECONDS));
		future.add(scheduledExecutorService.scheduleAtFixedRate(setMessage, controller.getStartDelay(),
				controller.getMessageInterval(), TimeUnit.MILLISECONDS));
		future.add(scheduledExecutorService.scheduleAtFixedRate(playMessage, controller.getStartDelay(),
				controller.getMessageInterval(), TimeUnit.MILLISECONDS));
		future.add(scheduledExecutorService.scheduleAtFixedRate(removeMessage, controller.getMessageSpeed(),
				controller.getMessageInterval(), TimeUnit.MILLISECONDS));
	}

	public void stop() {
		future.get(0).cancel(true);
		future.get(1).cancel(true);
		future.get(2).cancel(true);
		subliminalFrame.hide();
	}

	public void terminate() {
		scheduledExecutorService.shutdown();
	}

	public int randInt(int min, int max) {

		// NOTE: This will (intentionally) not run as written so that folks
		// copy-pasting have to think about how to initialize their
		// Random instance. Initialization of the Random instance is outside
		// the main scope of the question, but some decent options are to have
		// a field that is initialized once and then re-used as needed or to
		// use ThreadLocalRandom (if using at least Java 1.7).
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;
		System.out.println("random number = " + randomNum);
		return randomNum;
	}

	public List<Future> getFuture() {
		return future;
	}

	public void setFuture(List<Future> future) {
		this.future = future;
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
}
