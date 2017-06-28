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
import com.psychotechnology.GUI.MyScrollBarUI;
import com.psychotechnology.util.CustomFont;

public class CategoryPanel extends JPanel {

	private static final long serialVersionUID = 4919411682587534256L;
	private Controller controller;
	private JScrollPane scroller;
	private JLabel header;
	private JList<Object> categoryList;
	private CategorySelectionListener categorySelectionListener;

	public CategoryPanel(Controller controller) {
		this.controller = controller;
		initComponents();
		setupHeaderUI();
		styleList();
		styleScrollBar();
		setupUI();

		categoryList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					CategorySelectionEvent catgorySelectionEvent = new CategorySelectionEvent(this,
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

	/**
	 * This method sets the UI for the header at the very top of the panel
	 */
	private void setupHeaderUI() {
		header.setFont(CustomFont.getFont(CustomFont.latoBlack, 20));
	}

	/**
	 * This method sets the UI for the Category list
	 */
	private void styleList() {
		categoryList.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		categoryList.setFixedCellHeight(55);
		categoryList.setFixedCellWidth(350);
		categoryList.setCellRenderer(new CategoryListCellRenderer());
		categoryList.setSelectedIndex(0);
	}

	private void styleScrollBar() {
		scroller.getVerticalScrollBar().setUI(new MyScrollBarUI());
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
	 * @param CategorySelectionListener
	 *            interface object used to alert anonymous class in MainFrame
	 */
	public void setCategorySelectionListener(CategorySelectionListener categorySelectionListener) {
		this.categorySelectionListener = categorySelectionListener;
	}
}
