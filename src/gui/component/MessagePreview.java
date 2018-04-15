package gui.component;

import java.awt.Component;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MessagePreview extends JLabel {

	public MessagePreview(String categoryName) {
		super(categoryName, JLabel.CENTER);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setOpaque(true);
	}
}
