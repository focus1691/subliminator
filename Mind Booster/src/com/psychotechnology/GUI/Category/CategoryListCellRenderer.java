package com.psychotechnology.GUI.Category;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class CategoryListCellRenderer extends DefaultListCellRenderer {

	Border faintGreyBorder = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.decode("#ecf1f5"));

	CompoundBorder compoundBorder = new CompoundBorder(
			BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#ecf1f5")),
			BorderFactory.createMatteBorder(0, 10, 0, 0, Color.WHITE));

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		listCellRendererComponent.setBorder(compoundBorder);
		if (isSelected) {
			c.setBackground(Color.decode("#4ba7f0"));
			setForeground(Color.WHITE);
		}
		return c;
	}
}