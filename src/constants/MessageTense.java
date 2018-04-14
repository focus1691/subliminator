package constants;

/**
 * 
 * @author Joshua Enumerator class to define the message perspective names and
 *         values
 */
public enum MessageTense {
	FIRST_PERSON(0), SECOND_PERSON(1);

	private int tenseVal;

	MessageTense(int tenseVal) {
		this.tenseVal = tenseVal;
	}

	public int getTenseVal() {
		return tenseVal;
	}

	public void setTenseVal(int tenseVal) {
		this.tenseVal = tenseVal;
	}
}
