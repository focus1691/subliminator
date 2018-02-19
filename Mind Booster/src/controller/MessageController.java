package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import constants.MessageTense;
import constants.ScreenPosition;
import data.InBuiltCategory;
import gui.Subliminal;
import model.Category;
import model.Message;

public class MessageController {
	public static boolean messagesOn = false;
	private boolean userPremium = false;
	private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	private int startDelay = 0; // Milliseconds
	private int speed = 700; // Milliseconds
	private int interval = 4; // Seconds
	private int categoryIndex;
	private ArrayList<Category> categories;
	private MessageTense messageTense;
	private SubliminalTask topLeft, topRight, center, botLeft, botRight;
	//private Subliminal topLeft, topRight, center, botLeft, botRight;
	private List<Message> activeMessages;
	private final static String versionURL = "http://localhost:1337/PsychoTechnology/version.html";
	private final static String historyURL = "http://localhost:1337/PsychoTechnology/history.html";
	
	public MessageController() {
		
		topLeft = new SubliminalTask(this, new Subliminal(ScreenPosition.TOPLEFT));
		topRight = new SubliminalTask(this, new Subliminal(ScreenPosition.TOPRIGHT));
		center = new SubliminalTask(this, new Subliminal(ScreenPosition.CENTER));
		botLeft = new SubliminalTask(this, new Subliminal(ScreenPosition.BOTLEFT));
		botRight = new SubliminalTask(this, new Subliminal(ScreenPosition.BOTRIGHT));
		
		messageTense = MessageTense.FIRST_PERSON;
		categoryIndex = 0;
		activeMessages = new ArrayList<Message>();
		
		load();
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		try {
			FileInputStream fileIn = new FileInputStream("data.cats");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			categories = (ArrayList<Category>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			loadInBuiltCategories();
			save();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
	}

	public void loadInBuiltCategories() {
		categories = new InBuiltCategory().getCateories();
	}

	public void save() {
		if (categories != null) {
			try {
				FileOutputStream fileOut = new FileOutputStream("data.cats");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(categories);
				out.close();
				fileOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	/**
	 * Start/Stop the messages
	 * 
	 * @throws InterruptedException check for multithreading exceptions
	 */
	public synchronized void changeMessageActivity(boolean msgLocationsSelected[]) throws InterruptedException {
		messagesOn = (messagesOn == true) ? false : true;
		if (messagesOn) {
			if (scheduledExecutorService.isShutdown()) {
				scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			}
			if (msgLocationsSelected[0] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(topLeft, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[1] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(topRight, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[2] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(botLeft, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[3] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(botRight, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[4] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(center, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(topRight, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(topLeft, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(botRight, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(botLeft, startDelay, interval, TimeUnit.SECONDS);
			}
		} else {
			 scheduledExecutorService.shutdown();
			 System.gc();
		}
	}
	
	public synchronized int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	public static boolean isMessagesOn() {
		return messagesOn;
	}

	public static void setMessagesOn(boolean messagesOn) {
		MessageController.messagesOn = messagesOn;
	}

	/**
	 * 
	 * @return list of categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}

	/**
	 * 
	 * @return names of all categories
	 */
	public String[] getCategoryNames() {

		int i;
		String[] categoryNames = new String[categories.size()];

		for (i = 0; i < categories.size(); i++) {
			categoryNames[i] = categories.get(i).getCategoryName();
		}
		return categoryNames;
	}

	public String getActiveCategoryName() {

		return categories.get(categoryIndex).getCategoryName();
	}

	/**
	 * 
	 * @param messageIndex
	 * @return A message from the selected category, message index, and tense
	 */
	public Message getMessageFromActiveTenseCategory(int messageIndex) {
		return categories.get(categoryIndex).getMessages().get(messageTense.getTenseVal()).get(messageIndex);
	}

	/**
	 * 
	 * @param catIndex 	category index
	 * @return List of all messages in a selected category
	 */
	public List<Message> getMessagesFromActiveTenseCategory() {
		int i;
		List<Message> messages = new ArrayList<Message>();
		int numMessagesInCategory = categories.get(categoryIndex).getMessages().get(messageTense.getTenseVal()).size();

		for (i = 0; i < numMessagesInCategory; i++) {
			messages.add(categories.get(categoryIndex).getMessages().get(messageTense.getTenseVal()).get(i));
		}
		return messages;
	}
	/**
	 * 
	 * @param catIndex 	category index
	 * @return List of all messages in a selected category
	 */
	public List<Message> getMessagesFromTenseCategory(MessageTense messageTense) {
		int i;
		List<Message> messages = new ArrayList<Message>();
		int numMessagesInCategory = categories.get(categoryIndex).getMessages().get(messageTense.getTenseVal()).size();

		for (i = 0; i < numMessagesInCategory; i++) {
			messages.add(categories.get(categoryIndex).getMessages().get(messageTense.getTenseVal()).get(i));
		}
		return messages;
	}

	public List<Message> getMessagesFromCategory(int categoryIdx, MessageTense tense) {
		return categories.get(categoryIdx).getMessages().get(tense.getTenseVal());
	}

	public Message getMessageFromCategory(int categoryIdx, int msgIdx, MessageTense tense) {
		return categories.get(categoryIdx).getMessages().get(tense.getTenseVal()).get(msgIdx);
	}

	public int[] doInsertionSort(int[] input) {

		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

	public int getStartDelay() {
		return startDelay;
	}

	public void setStartDelay(int startDelay) {
		this.startDelay = startDelay;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getCategoryIndex() {
		return categoryIndex;
	}

	public void setCategoryIndex(int categoryIndex) {
		this.categoryIndex = categoryIndex;
	}

	public MessageTense getMessageTense() {
		return messageTense;
	}

	public void setMessageTense(MessageTense messageTense) {
		this.messageTense = messageTense;
	}
	
	/**
	 * 
	 * @return all selected messages
	 */
	public List<Message> getActiveMessages() {
		return activeMessages;
	}

	/**
	 * 
	 * @param activeMessages list of selected messages
	 */
	public void setActiveMessages(List<Message> activeMessages) {
		this.activeMessages = activeMessages;
	}
}
