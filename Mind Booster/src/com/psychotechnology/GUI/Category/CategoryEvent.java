package com.psychotechnology.GUI.Category;

import java.util.EventObject;

public class CategoryEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private int categoryIndex;

	public CategoryEvent(Object source) {
		super(source);
	}

	public CategoryEvent(Object source, int categoryIndex) {
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
