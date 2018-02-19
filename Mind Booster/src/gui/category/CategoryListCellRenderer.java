package gui.category;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import model.Category;
import utility.CustomColor;

public class CategoryListCellRenderer extends DefaultListCellRenderer {
	
	private static final long serialVersionUID = 6638393449640171111L;
	Border faintGreyBorder = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.decode("#ecf1f5"));

	CompoundBorder compoundBorder = new CompoundBorder(
			BorderFactory.createMatteBorder(1, 0, 1, 0, CustomColor.faintGrey),
			BorderFactory.createMatteBorder(0, 10, 0, 0, Color.WHITE));

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		
		Category category = (Category) value;
		listCellRendererComponent.setText("  " + category.getCategoryName());
		
		listCellRendererComponent.setBorder(compoundBorder);
		if (isSelected) {
			c.setBackground(CustomColor.brightBlue);
			setForeground(Color.WHITE);
		}
		return c;
	}
}