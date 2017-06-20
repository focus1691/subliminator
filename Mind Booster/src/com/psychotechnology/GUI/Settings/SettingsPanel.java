package com.psychotechnology.GUI.Settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
	private JLayeredPane screenContainer;
	private JPanel screenPanel;
	public static ImageIcon screen;
	public static ImageIcon picture;
	public static ImageIcon topLeftMsg;
	public static JPanel picturePanel;
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
	private String absolutePath = new File(".").getAbsolutePath();

	public SettingsPanel(Controller controller) {
		this.controller = controller;
		initComponents();
		//tupSettingsUI();
		setupUI();
		styleUI();

		speedSlider.addChangeListener((ChangeListener) this);
		durationSlider.addChangeListener((ChangeListener) this);
		
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				Component c = e.getComponent();
				if (containerRect != null) {
			        System.out.println((double) screenToPanelWRatio * c.getWidth());
			        screenRect.setRect(0, 0, (double) screenToPanelWRatio * c.getWidth(), (double) screenToPanelHRatio * c.getHeight());
			        screenPanel.setBounds(screenRect);
			        
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

	/**
	 * This method initializes all Settings Panel components
	 */
	public void initComponents() {
		
		//outerContainer = new JPanel();
		//outerContainer.setLayout(new BorderLayout());
		
		screenContainer = new JLayeredPane();
		//outerContainer.add(screenContainer, BorderLayout.CENTER);
		
		screenPanel = new JPanel();
		screenPanel.setLayout(new BorderLayout());
		screen = IconFetch.getInstance().getIcon("/com/psychotechnology/images/screen.png");
		screenPanel.setLayout(new BorderLayout());
		screenPanel.add(new PictureLabel(screen), BorderLayout.CENTER);
		
		screenContainer.add(screenPanel, JLayeredPane.DEFAULT_LAYER);
		
		ImageIcon messageOne = IconFetch.getInstance().getIcon("/com/psychotechnology/images/bb.png");
		JPanel messageOnePane = new JPanel();
		messageOnePane.setLayout(new BorderLayout());
		
		ImageIcon messageTwo = IconFetch.getInstance().getIcon("/com/psychotechnology/images/bb.png");
		PictureLabel messageTwoImg = new PictureLabel(messageTwo);
		JPanel messageTwoPane = new JPanel();
		messageTwoPane.setLayout(new BorderLayout());
		messageTwoPane.setBounds(150, 25, 150, 50);
		
		messageTwoPane.setOpaque(true);
		messageTwoPane.setBackground(Color.GREEN);
		messageTwoPane.add(messageTwoImg, BorderLayout.CENTER);
		
		screenPanel.setBounds(screenRect);
		screenPanel.setOpaque(true);
		
		messageOnePane.setBounds(400, 25, 150, 50);
		messageOnePane.setOpaque(true);
		messageOnePane.add(new PictureLabel(messageOne), BorderLayout.CENTER);
		
		screenContainer.add(screenPanel, new Integer(0), 0);
		screenContainer.add(messageOnePane, new Integer(1), 0);
		screenContainer.add(messageTwoPane, new Integer(1), 0);
		
		picturePanel = new JPanel();
		picture = new ImageIcon();
		pictureLabel = new PictureLabel(picture);
		picturePanel.setLayout(new BorderLayout());
		picturePanel.add(pictureLabel, BorderLayout.CENTER);

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
		
		/* GridBagLayout settings */
		setLayout(new GridBagLayout());// set LayoutManager
		setBackground(Color.decode("#efeff0"));
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.6;
		gc.insets = new Insets(90, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(screenContainer, gc); // add component to the ContentPane
		//screenPanel.setBackground(Color.WHITE);
		

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 3;
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
		//screenPanel.add(speedLabel, gc);
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
