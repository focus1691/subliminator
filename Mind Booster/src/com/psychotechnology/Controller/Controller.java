package com.psychotechnology.Controller;

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

import com.psychotechnology.Model.Category;
import com.psychotechnology.Model.InBuiltCategory;
import com.psychotechnology.Model.Message;
import com.psychotechnology.Model.ScreenPosition;
import com.psychotechnology.Model.MessageTense;

public class Controller {
	public static boolean messagesOn = false;
	private boolean userPremium = false;
	private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	private int startDelay = 30;
	private int messageSpeed = 50;
	private int messageInterval = 3000;
	private int categoryIndex;
	private ArrayList<Category> categories;
	private MessageTense messageTense;
	private PlayMessageTask topLeftMsg, topRightMsg, centerMsg, botLeftMsg, botRightMsg;
	private List<Message> activeMessages;
	private Network network;
	
	private final static String versionURL = "http://localhost:1337/PsychoTechnology/version.html";
	private final static String historyURL = "http://localhost:1337/PsychoTechnology/history.html";

	public Controller() {
		network = new Network();
		// network.checkIfRunning();
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
		System.out.println("messageSpeed = " + messageSpeed);
		messagesOn = (messagesOn == true) ? false : true;
		if (messagesOn) {
			if (scheduledExecutorService.isShutdown()) {
				scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			}
			if (msgLocationsSelected[0] == true) {
				topLeftMsg = new PlayMessageTask(this, ScreenPosition.TOPLEFT);
				scheduledExecutorService.scheduleWithFixedDelay(topLeftMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
			}
			if (msgLocationsSelected[1] == true) {
				topRightMsg = new PlayMessageTask(this, ScreenPosition.TOPRIGHT);
				scheduledExecutorService.scheduleWithFixedDelay(topRightMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
			}
			if (msgLocationsSelected[2] == true) {
				botLeftMsg = new PlayMessageTask(this, ScreenPosition.BOTLEFT);
				scheduledExecutorService.scheduleWithFixedDelay(botLeftMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
				System.out.println("botLeftMsg");
			}
			if (msgLocationsSelected[3] == true) {
				botRightMsg = new PlayMessageTask(this, ScreenPosition.BOTRIGHT);
				scheduledExecutorService.scheduleWithFixedDelay(botRightMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
			}
			if (msgLocationsSelected[4] == true) {
				centerMsg = new PlayMessageTask(this, ScreenPosition.CENTER);
				scheduledExecutorService.scheduleWithFixedDelay(centerMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
				topLeftMsg = new PlayMessageTask(this, ScreenPosition.TOPLEFT);
				scheduledExecutorService.scheduleWithFixedDelay(topLeftMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
				topRightMsg = new PlayMessageTask(this, ScreenPosition.TOPRIGHT);
				scheduledExecutorService.scheduleWithFixedDelay(topRightMsg, 0, messageInterval, TimeUnit.MILLISECONDS);
			}
		} else {
			 scheduledExecutorService.shutdown();
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
		Controller.messagesOn = messagesOn;
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
	
	public boolean isMessagesRunning() {
		
		if (topLeftMsg != null && topLeftMsg.isShutdown() == false) {
			return false;
		}
		if (topRightMsg != null && topRightMsg.isShutdown() == false) {
			return false;
		}
		if (centerMsg != null && centerMsg.isShutdown() == false) {
			return false;
		}
		if (botLeftMsg != null && botLeftMsg.isShutdown() == false) {
			return false;
		} 
		if (botRightMsg != null && botRightMsg.isShutdown() == false) {
			return false;
		} 
		return true;
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

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}
}
