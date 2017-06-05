package com.psychotechnology.GUI.Settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.psychotechnology.Controller.Controller;
import com.psychotechnology.GUI.PictureLabel;
import com.psychotechnology.util.CustomFont;
import com.psychotechnology.util.IconFetch;

public class SettingsPanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = -798661649041437371L;
	private Controller controller;
	private JPanel screenPanel;
	private PictureLabel screenLabel;
	public static ImageIcon screen;
	public static JPanel picturePanel;
	public static PictureLabel pictureLabel;
	public static ImageIcon picture;
	private JSlider speedSlider;
	private JSlider durationSlider;
	private JLabel speedLabel;
	private JLabel durationLabel;
	private SettingsListener settingsListener;
	private String absolutePath = new File(".").getAbsolutePath();

	public SettingsPanel(Controller controller) {
		this.controller = controller;
		initComponents();
		setupSettingsUI();
		setupUI();
		styleUI();

		speedSlider.addChangeListener((ChangeListener) this);
		durationSlider.addChangeListener((ChangeListener) this);
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

	/**
	 * This method initializes all Settings Panel components
	 */
	public void initComponents() {
		screenPanel = new JPanel();
		screen = IconFetch.getInstance().getIcon("/com/psychotechnology/images/screen.png");
		screenLabel = new PictureLabel(picture);
		
		picturePanel = new JPanel();
		picture = new ImageIcon();
		pictureLabel = new PictureLabel(picture);

		speedSlider = new JSlider(0, 1000, 50);
		durationSlider = new JSlider(0, 5000, 50);
		speedSlider.setValue(controller.getMessageSpeed());
		durationSlider.setValue(controller.getMessageInterval());
		speedLabel = new JLabel("Display Every (ms):");
		durationLabel = new JLabel("Duration (ms):");

		speedSlider.setUI(new CustomSliderUI(speedSlider));
		durationSlider.setUI(new CustomSliderUI(durationSlider));
	}

	public void styleUI() {
		speedLabel.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		durationLabel.setFont(CustomFont.getFont(CustomFont.latoBold, 16));

		speedSlider.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
		durationSlider.setFont(CustomFont.getFont(CustomFont.latoBold, 16));
	}

	public void setupUI() {
		
		screenPanel.setLayout(new BorderLayout());
		screenPanel.add(pictureLabel, BorderLayout.CENTER);
		
		picturePanel.setLayout(new BorderLayout());
		picturePanel.add(pictureLabel, BorderLayout.CENTER);

		/* GridBagLayout settings */
		setLayout(new GridBagLayout());// set LayoutManager
		setBackground(Color.decode("#efeff0"));
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(90, 0, 30, 30);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(screenPanel, gc); // add component to the ContentPane
		screenPanel.setBackground(Color.WHITE);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.insets = new Insets(0, 0, 10, 30);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(picturePanel, gc); // add component to the ContentPane
	}

	/**
	 * This method sets the UI for the message settings
	 */
	public void setupSettingsUI() {
		speedSlider.setMajorTickSpacing(1000);
		speedSlider.setPaintLabels(true);

		durationSlider.setMajorTickSpacing(5000);
		durationSlider.setPaintLabels(true);

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(3, 10, 3, 10);
		screenPanel.setLayout(gbl);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		screenPanel.add(speedLabel, gc);

		/*
		// Speed Label
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		settingsPanel.add(speedLabel, gc);

		// Speed Slider
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		settingsPanel.add(speedSlider, gc);

		// Duration Label
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		settingsPanel.add(durationLabel, gc);

		// Duration Slider
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 0.1;
		gc.weighty = 0.4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		settingsPanel.add(durationSlider, gc);
		
		*/
	}

	public PictureLabel getPictureLabel() {
		return pictureLabel;
	}

	public void setPictureLabel(PictureLabel pictureLabel) {
		this.pictureLabel = pictureLabel;
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
}
