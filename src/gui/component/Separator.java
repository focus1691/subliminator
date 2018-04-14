package gui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Separator extends JSeparator {

	public Separator() {
		super(SwingConstants.VERTICAL);
		setPreferredSize(new Dimension(1, 30));
		setOpaque(true);
		setBackground(Color.decode("#1060a1"));
	}
}
