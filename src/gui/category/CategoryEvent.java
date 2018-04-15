package gui.category;

import java.util.EventObject;

@SuppressWarnings("serial")
public class CategoryEvent extends EventObject {

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
