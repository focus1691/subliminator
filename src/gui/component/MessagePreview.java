package gui.component;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MessagePreview extends JLabel {

	public MessagePreview(String categoryName) {
		super(categoryName, SwingConstants.CENTER);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setOpaque(true);
	}
}
