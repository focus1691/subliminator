package model;

/**
 * 
 * @author Joshua A container to encapsulate message information, such as
 *         sentence and image path
 */
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 2558270464337340950L;
	private String message;
	private String imagePath;
	private boolean is_text_only;

	/**
	 * 
	 * @param message
	 *            A subliminal message
	 * @param imagePath
	 *            Image location for this message
	 */
	public Message(String message, String imagePath, boolean is_text_only) {
		this.message = message;
		this.imagePath = imagePath;
		this.is_text_only = is_text_only;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setPath(String path) {
		this.imagePath = path;
	}

	public boolean getIsTextOnly() {
		return is_text_only;
	}

	public void setIsTextOnly(boolean is_text_only) {
		this.is_text_only = is_text_only;
	}

	@Override
	public String toString() {
		return message + "\n" + imagePath + "\n";
	}
}
