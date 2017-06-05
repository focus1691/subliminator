package com.psychotechnology.GUI.Message;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.psychotechnology.GUI.Settings.SettingsPanel;
import com.psychotechnology.Model.Message;

public class MessageListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 5844001513309670611L;

	Border greyFaintBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#ecf1f5"));
	CompoundBorder compoundBorder = new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 0, 4, Color.decode("#2388d9")),
			BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#ecf1f5")));

	public MessageListCellRenderer() {
		setOpaque(true);
		setBorder(new EmptyBorder(1, 1, 1, 1));
	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		
		Message message = (Message) value;
		listCellRendererComponent.setText("  " + message.getMessage());
		
		if (isSelected) {
			String absolutePath = new File(".").getAbsolutePath();
			ImageIcon icon = new ImageIcon(absolutePath + message.getImagePath());
			SettingsPanel.pictureLabel.setImageIcon(icon);
			SettingsPanel.pictureLabel.repaint();

			setBackground(Color.decode("#f5f5f5"));
			setForeground(Color.decode("#0a95dd"));
			listCellRendererComponent.setBorder(compoundBorder);
		} else {
			listCellRendererComponent.setBorder(greyFaintBorder);
		}
		return c;
	}
}