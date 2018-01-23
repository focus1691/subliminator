package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joshua A container to encapsulate category information. has-a
 *         one-to-many relationship with Message, where a list of messages are
 *         stored in a category object
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 2743373611391306854L;
	private String categoryName;
	private ArrayList<ArrayList<Message>> messages = new ArrayList<ArrayList<Message>>();

	/**
	 * 
	 * @param categoryName
	 *            name of category
	 * @param messages
	 *            list of messages from category
	 */
	public Category(String categoryName, ArrayList<ArrayList<Message>> messages) {
		this.setCategoryName(categoryName);
		this.messages = messages;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String[] getMessageNames(int index) {
		String[] names = new String[0];

		if (messages != null && messages.size() > 0 && messages.get(index) != null) {
			names = new String[messages.get(index).size()];

			int i = 0;

			for (Message msg : messages.get(index)) {
				names[i++] = msg.getMessage();
			}
		}
		return names;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ArrayList<ArrayList<Message>> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<ArrayList<Message>> messages) {
		this.messages = messages;
	}
}
