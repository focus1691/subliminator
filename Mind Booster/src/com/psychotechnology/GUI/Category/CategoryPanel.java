package com.psychotechnology.GUI.Category;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.BlueCurvedScrollBar;
import com.psychotechnology.util.CustomFont;

public class CategoryPanel extends JPanel {

	private static final long serialVersionUID = 4919411682587534256L;
	private Controller controller;
	private JScrollPane scroller;
	private JLabel header;
	private JList<Object> categoryList;
	private CategoryListener categorySelectionListener;

	public CategoryPanel(Controller controller) {
		this.controller = controller;
		initComponents();
		styleUI();
		setupUI();

		categoryList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					CategoryEvent catgorySelectionEvent = new CategoryEvent(this,
							categoryList.getSelectedIndex());

					if (categorySelectionListener != null) {
						categorySelectionListener.categorySelectionEventOccurred(catgorySelectionEvent);
					}
				}
			}
		});
	}

	/**
	 * This method initializes all Category Panel components
	 */
	private void initComponents() {
		categoryList = new JList<Object>(controller.getCategoryNames());
		header = new JLabel("Select Categories");
		scroller = new JScrollPane();
		scroller.setViewportView(categoryList);
	}
	
	private void styleUI() {
		// UI for the header
		header.setFont(CustomFont.getFont(CustomFont.latoBlack, 20));
		
		// Category List
		categoryList.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		categoryList.setFixedCellHeight(55);
		categoryList.setFixedCellWidth(350);
		categoryList.setCellRenderer(new CategoryListCellRenderer());
		categoryList.setSelectedIndex(0);
		
		// ScrollBar
		scroller.getVerticalScrollBar().setUI(new BlueCurvedScrollBar());
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		scroller.getVerticalScrollBar().setBackground(Color.decode("#efeff0"));
		scroller.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scroller.setBorder(new EmptyBorder(0, 0, 0, 0));
	}
	
	/**
	 * This method uses GridBagLayout to position components onto the Category
	 * Panel
	 */
	private void setupUI() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		// Add the header to the very top, full-width, with a short height
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

		// Add the Category list, with full width, and 90% of height
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

	/**
	 * Used by anonymous class in MainFrame to listen for Category Selection
	 * Event
	 * 
	 * @param CategoryListener
	 *            interface object used to alert anonymous class in MainFrame
	 */
	public void setCategorySelectionListener(CategoryListener categorySelectionListener) {
		this.categorySelectionListener = categorySelectionListener;
	}
}
