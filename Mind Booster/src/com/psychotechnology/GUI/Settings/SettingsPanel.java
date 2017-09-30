package com.psychotechnology.GUI.Settings;

import java.util.Arrays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.MessageButton;
import com.psychotechnology.GUI.PictureLabel;
import com.psychotechnology.util.CustomFont;
import com.psychotechnology.util.IconFetch;

public class SettingsPanel extends JPanel implements ChangeListener, MouseListener {

	private static final long serialVersionUID = -798661649041437371L;
	private Controller controller;
	private JLayeredPane screenContainer;
	private JPanel screenPanel;
	public static ImageIcon screen;
	public static ImageIcon picture;
	public static ImageIcon topLeftMsg;
	public static JPanel picturePanel;
	private MessageButton msgOne, msgTwo, msgThree, msgFour, msgFive;
	public static PictureLabel pictureLabel;
	public static PictureLabel topLeftMsgLabel;
	private Rectangle screenRect = new Rectangle(0, 0, 650, 410);
	private Rectangle containerRect;
	private double screenToPanelWRatio;
	private double screenToPanelHRatio;
	private JSlider speedSlider;
	private JSlider durationSlider;
	private JLabel speedLabel;
	private JLabel durationLabel;
	private SettingsListener settingsListener;
	private MultiMessageListener multiMessageListener;
	private String absolutePath = new File(".").getAbsolutePath();

	public SettingsPanel(Controller controller) {
		this.controller = controller;
		initComponents();
		setupUI();
		styleUI();

		speedSlider.addChangeListener((ChangeListener) this);
		durationSlider.addChangeListener((ChangeListener) this);

		msgOne.addMouseListener(this);
		msgTwo.addMouseListener(this);
		msgThree.addMouseListener(this);
		msgFour.addMouseListener(this);
		msgFive.addMouseListener(this);

		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				Component c = e.getComponent();
				if (containerRect != null) {
					screenRect.setRect(0, 0, (double) screenToPanelWRatio * c.getWidth(),
							(double) screenToPanelHRatio * c.getHeight());
					msgOne.setAlignmentX(250);
					screenPanel.setBounds(screenRect);
					msgOne.setBounds(screenPanel.getWidth() / 8, screenPanel.getHeight() / 8, 185, 60);
					msgTwo.setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185,
							screenPanel.getHeight() / 8, 185, 60);
					msgThree.setBounds(screenPanel.getWidth() / 8, (screenPanel.getHeight() / 2) - 20, 185, 60);
					msgFour.setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185,
							(screenPanel.getHeight() / 2) - 20, 185, 60);
					msgFive.setBounds((screenPanel.getWidth() / 2) - 100, (screenPanel.getHeight() / 2) - 85, 185, 60);
					c.revalidate();
					c.repaint();
				} else {
					containerRect = new Rectangle(c.getX(), c.getY(), c.getWidth(), c.getHeight());
					screenToPanelWRatio = (double) screenPanel.getWidth() / c.getWidth();
					screenToPanelHRatio = (double) screenPanel.getHeight() / c.getHeight();
				}
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		if (ce.getSource() == speedSlider) {
			JSlider source = (JSlider) ce.getSource();
			if (!source.getValueIsAdjusting()) {
				int speed = speedSlider.getValue();
				int duration = durationSlider.getValue();
				SettingsEvent settingsEvent = new SettingsEvent(this, speed, duration);
				if (settingsListener != null) {
					settingsListener.settingsEventOccurred(settingsEvent);
				}
			}
		} else if (ce.getSource() == durationSlider) {
			JSlider source = (JSlider) ce.getSource();
			if (!source.getValueIsAdjusting()) {
				int speed = speedSlider.getValue();
				int duration = durationSlider.getValue();
				SettingsEvent settingsEvent = new SettingsEvent(this, speed, duration);
				if (settingsListener != null) {
					settingsListener.settingsEventOccurred(settingsEvent);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MessageButton msg = (MessageButton) e.getSource();

		if (e.getClickCount() == 1) {
			if (msg.isLocked()) {
				JOptionPane.showMessageDialog(this, "Error", "Warning", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (msg.isActive()) {
				msg.setInactive();
			} else {
				msg.setActive();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method initializes all Settings Panel components
	 */
	public void initComponents() {

		screenContainer = new JLayeredPane();

		// The screen
		screenPanel = new JPanel();
		screenPanel.setLayout(new BorderLayout());
		screenPanel.setBounds(screenRect);
		screenPanel.add(new PictureLabel(IconFetch.getInstance().getIcon("/com/psychotechnology/images/screen.png")),
				BorderLayout.CENTER);

		// Message on the top left of the screen
		msgOne = new MessageButton("Message 1", false, true, screenPanel.getWidth() / 8, screenPanel.getHeight() / 8, 185,
				60);

		// Message on the top right of the screen
		msgTwo = new MessageButton("Message 2", false, true, screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185,
				screenPanel.getHeight() / 8, 185, 60);

		// Message on the bottom left of the screen
		msgThree = new MessageButton("Message 4", false, true, screenPanel.getWidth() / 8, (screenPanel.getHeight() / 2) - 20,
				185, 60);

		// Message on the bottom right of the screen
		msgFour = new MessageButton("Message 5", false, true, screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185,
				(screenPanel.getHeight() / 2) - 20, 185, 60);

		// Message in the middle of the screen
		msgFive = new MessageButton("Message 3", true, false, (screenPanel.getWidth() / 2) - 100,
				(screenPanel.getHeight() / 2) - 85, 185, 60);

		screenContainer.add(screenPanel, new Integer(0), 0);
		screenContainer.add(msgOne, new Integer(1), 0);
		screenContainer.add(msgTwo, new Integer(1), 0);
		screenContainer.add(msgThree, new Integer(1), 0);
		screenContainer.add(msgFour, new Integer(1), 0);
		screenContainer.add(msgFive, new Integer(1), 0);

		picturePanel = new JPanel();
		picture = new ImageIcon();
		pictureLabel = new PictureLabel(picture);
		picturePanel.setLayout(new BorderLayout());
		picturePanel.add(pictureLabel, BorderLayout.CENTER);

		speedSlider = new JSlider(0, 1000);
		speedSlider.setValue(controller.getMessageSpeed());
		speedLabel = new JLabel("Display Every (ms):");
		
		durationSlider = new JSlider(0, 1000);
		durationSlider.setValue(controller.getMessageInterval());
		durationLabel = new JLabel("Duration (ms):");

		speedSlider.setUI(new CustomSliderUI(speedSlider));
		durationSlider.setUI(new CustomSliderUI(durationSlider));
	}

	public void styleUI() {
		speedLabel.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		speedSlider.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		speedSlider.setMinorTickSpacing(50);
		speedSlider.setMajorTickSpacing(1000);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setPreferredSize(new Dimension(300, 75));

		durationLabel.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		durationSlider.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		durationSlider.setMinorTickSpacing(50);
		durationSlider.setMajorTickSpacing(1000);
		durationSlider.setPaintTicks(true);
		durationSlider.setPaintLabels(true);
		durationSlider.setPreferredSize(new Dimension(300, 30));
	}

	public void setupUI() {

		setLayout(new GridBagLayout());
		setBackground(Color.decode("#efeff0"));
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(20, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(screenContainer, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedLabel, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(60, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedSlider, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(durationLabel, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(durationSlider, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(60, 430, 10, 20);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(picturePanel, gc); // add component to the ContentPane
	}

	public PictureLabel getPictureLabel() {
		return pictureLabel;
	}

	public void setPictureLabel(PictureLabel pictureLabel) {
		SettingsPanel.pictureLabel = pictureLabel;
	}

	/**
	 * Used by anonymous class in MainFrame to listen for settings changed
	 * Events
	 * 
	 * @param settingsListener
	 *            interface object used to alert anonymous class in MainFrame
	 */
	public void setSettingsListener(SettingsListener settingsListener) {
		this.settingsListener = settingsListener;
	}

	public void setmultiMessageListener(MultiMessageListener multiMessageListener) {
		this.multiMessageListener = multiMessageListener;
	}

	public boolean[] getMsgLocationsSelected() {

		boolean msgLocationsSelected[] = new boolean[5];
		Arrays.fill(msgLocationsSelected, false);

		if (msgOne.isActive())
			msgLocationsSelected[0] = true;
		if (msgTwo.isActive())
			msgLocationsSelected[1] = true;
		if (msgThree.isActive())
			msgLocationsSelected[2] = true;
		if (msgFour.isActive())
			msgLocationsSelected[3] = true;
		if (msgFive.isActive())
			msgLocationsSelected[4] = true;

		return msgLocationsSelected;
	}
}
