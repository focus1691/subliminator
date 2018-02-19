package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {

	private static final long serialVersionUID = 2743373611391306854L;
	private String categoryName;
	private ArrayList<ArrayList<Message>> messages = new ArrayList<ArrayList<Message>>();
	
	public Category(String categoryName, ArrayList<ArrayList<Message>> messages) {
		this.setCategoryName(categoryName);
		this.messages = messages;
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
