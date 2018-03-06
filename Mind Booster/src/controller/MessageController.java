package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import constants.MessageTense;
import constants.ScreenPosition;
import data.InBuiltCategory;
import gui.custom.MessageButton;
import gui.subliminal.PlayMessageTask;
import gui.subliminal.SubliminalFrame;
import model.Category;
import model.Message;

public class MessageController {
	public static boolean messagesOn = false;
	private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	private int startDelay = 0; // ms
	private int speed = 700; // ms
	private int interval = 4; // s
	private int categoryIndex;
	private ArrayList<Category> categories;
	private MessageTense messageTense;
	private SubliminalFrame frame1, frame2, frame3, frame4, frame5;
	private PlayMessageTask topLeftTask, topRightTask, centerTask, botLeftTask, botRightTask;
	private List<Message> activeMessages;
	
	public void setFonts(MessageButton[] messageButtons) {
		frame1.setFont(messageButtons[0].getFont());
		frame1.setColor(messageButtons[0].getActiveColour());
		
		frame2.setFont(messageButtons[1].getFont());
		frame2.setColor(messageButtons[1].getActiveColour());
		
		frame3.setFont(messageButtons[2].getFont());
		frame3.setColor(messageButtons[2].getActiveColour());
		
		frame4.setFont(messageButtons[3].getFont());
		frame4.setColor(messageButtons[3].getActiveColour());
		
		frame5.setFont(messageButtons[4].getFont());
		frame5.setColor(messageButtons[4].getActiveColour());
	}

	public MessageController() {
		
		frame1 = new SubliminalFrame(ScreenPosition.TOPLEFT);
		frame2 = new SubliminalFrame(ScreenPosition.TOPRIGHT);
		frame3 = new SubliminalFrame(ScreenPosition.CENTER);
		frame4 = new SubliminalFrame(ScreenPosition.BOTLEFT);
		frame5 = new SubliminalFrame(ScreenPosition.BOTRIGHT);

		topLeftTask = new PlayMessageTask(this, frame1);
		topRightTask = new PlayMessageTask(this, frame2);
		centerTask = new PlayMessageTask(this, frame3);
		botLeftTask = new PlayMessageTask(this, frame4);
		botRightTask = new PlayMessageTask(this, frame5);
		
		messageTense = MessageTense.FIRST_PERSON;
		categoryIndex = 0;
		activeMessages = new ArrayList<Message>();
		
		loadStoredLists();
	}
	
	

	@SuppressWarnings("unchecked")
	private void loadStoredLists() {
		try {
			FileInputStream fileIn = new FileInputStream("data.cats");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			categories = (ArrayList<Category>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			loadInBuiltCategories();
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
	 * @throws InterruptedException
	 *             check for multithreading exceptions
	 */
	public synchronized void changeMessageActivity(boolean msgLocationsSelected[]) throws InterruptedException {
		messagesOn = (messagesOn == true) ? false : true;
		if (messagesOn) {
			if (scheduledExecutorService.isShutdown()) {
				scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			}
			if (msgLocationsSelected[0] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(topLeftTask, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[1] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(topRightTask, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[2] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(botLeftTask, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[3] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(botRightTask, startDelay, interval, TimeUnit.SECONDS);
			}
			if (msgLocationsSelected[4] == true) {
				scheduledExecutorService.scheduleWithFixedDelay(centerTask, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(topRightTask, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(topLeftTask, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(botRightTask, startDelay, interval, TimeUnit.SECONDS);
				scheduledExecutorService.scheduleWithFixedDelay(botLeftTask, startDelay, interval, TimeUnit.SECONDS);
			}
		} else {
			scheduledExecutorService.shutdown();
			System.gc();
		}
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
	 * @param catIndex
	 *            category index
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
	 * @param catIndex
	 *            category index
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

	public List<Message> getActiveMessages() {
		return activeMessages;
	}

	public void setActiveMessages(List<Message> activeMessages) {
		this.activeMessages = activeMessages;
	}
}
