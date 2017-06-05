package com.psychotechnology.GUI.Category;

import java.util.EventObject;

public class CategorySelectionEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private int categoryIndex;

	public CategorySelectionEvent(Object source) {
		super(source);
	}

	public CategorySelectionEvent(Object source, int categoryIndex) {
		super(source);
		this.categoryIndex = categoryIndex;
	}

	public int getCategoryIndex() {
		return categoryIndex;
	}

	public void setCategoryIndex(int categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
}
