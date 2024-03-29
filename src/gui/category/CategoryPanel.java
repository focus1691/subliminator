package gui.category;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MessageController;
import gui.component.BlueCurvedScrollBar;
import model.Category;
import utility.FontPicker;

@SuppressWarnings("serial")
public class CategoryPanel extends JPanel {

	private MessageController controller;
	private JScrollPane scroller;
	private JLabel header;
	private DefaultListModel<Category> model = new DefaultListModel<>();
	private JList<Category> categoryList;
	private CategoryListener categorySelectionListener;

	public CategoryPanel(MessageController controller) {
		this.controller = controller;

		initComponents();
		setupUI();

		categoryList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					CategoryEvent catgorySelectionEvent = new CategoryEvent(this, categoryList.getSelectedIndex());

					if (categorySelectionListener != null) {
						categorySelectionListener.categorySelectionEventOccurred(catgorySelectionEvent);
					}
				}
			}
		});
	}

	private void initComponents() {
		setCategoryList(controller.getCategories());
		categoryList = new JList<Category>(model);
		categoryList.setFont(FontPicker.getFont(FontPicker.latoBold, 18.49f));
		categoryList.setFixedCellHeight(55);
		categoryList.setFixedCellWidth(350);
		categoryList.setCellRenderer(new CategoryListCellRenderer());
		categoryList.setSelectedIndex(controller.getCategoryIndex());

		header = new JLabel("Select Categories");
		header.setFont(FontPicker.getFont(FontPicker.latoBlack, 20));

		scroller = new JScrollPane();
		scroller.setViewportView(categoryList);
		scroller.getVerticalScrollBar().setUI(new BlueCurvedScrollBar());
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scroller.getVerticalScrollBar().setBackground(Color.decode("#efeff0"));
		scroller.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scroller.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	private void setupUI() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.01;
		gc.weighty = 0.1;
		gc.insets = new Insets(20, 75, 30, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.BOTH;
		add(header, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0;
		gc.weighty = 0.9;
		gc.insets = new Insets(0, 0, 10, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.VERTICAL;
		add(scroller, gc);

		setBackground(Color.decode("#efeff0"));
	}

	public void setCategoryList(List<Category> categories) {
		int i;
		for (i = 0; i < categories.size(); i++) {
			model.addElement(categories.get(i));
		}
	}

	public void setCategorySelectionListener(CategoryListener categorySelectionListener) {
		this.categorySelectionListener = categorySelectionListener;
	}
}
