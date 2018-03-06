package gui.settings;

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
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import constants.CustomColor;
import gui.PictureLabel;
import gui.custom.MessageButton;
import gui.util.IconFetch;
import utility.FontPicker;

public class SettingsPanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = -798661649041437371L;
	private JLayeredPane screenContainer;
	private JPanel screenPanel;
	public static ImageIcon screen, picture;
	public static JPanel picturePanel;
	private MessageButton[] messageButtons;
	private MessageButton msgOne, msgTwo, msgThree, msgFour, msgFive;
	public static PictureLabel pictureLabel;
	private Rectangle screenRect;
	private Rectangle containerRect;
	private double screenToPanelWRatio, screenToPanelHRatio;
	private JSlider speedSlider, intervalSlider;
	private JLabel speedLbl, intervalLbl;
	private SettingsListener settingsListener;
	private MultiMessageListener multiMessageListener;

	public SettingsPanel(int speed, int interval) {
		initComponents(speed, interval);
		setupUI();
		styleUI();

		speedSlider.addChangeListener((ChangeListener) this);
		intervalSlider.addChangeListener((ChangeListener) this);

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
				int duration = intervalSlider.getValue();
				SettingsEvent settingsEvent = new SettingsEvent(this, speed, duration);
				if (settingsListener != null) {
					settingsListener.settingsEventOccurred(settingsEvent);
				}
			}
		} else if (ce.getSource() == intervalSlider) {
			JSlider source = (JSlider) ce.getSource();
			if (!source.getValueIsAdjusting()) {
				int speed = speedSlider.getValue();
				int duration = intervalSlider.getValue();
				SettingsEvent settingsEvent = new SettingsEvent(this, speed, duration);
				if (settingsListener != null) {
					settingsListener.settingsEventOccurred(settingsEvent);
				}
			}
		}
	}

	public void initComponents(int speed, int interval) {

		screenRect = new Rectangle(0, 0, 650, 410);
		screenContainer = new JLayeredPane();

		// The screen
		screenPanel = new JPanel();
		screenPanel.setLayout(new BorderLayout());
		screenPanel.setBounds(screenRect);
		screenPanel.add(new PictureLabel(IconFetch.getInstance().getIcon("/images/screen.png")), BorderLayout.CENTER);

		// Message on the top left of the screen
		msgOne = new MessageButton("Top Left", false, CustomColor.green, true, screenPanel.getWidth() / 8, screenPanel.getHeight() / 8,
				185, 60);

		// Message on the top right of the screen
		msgTwo = new MessageButton("Top Right", false, Color.RED, true,
				screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185, screenPanel.getHeight() / 8, 185, 60);

		// Message on the bottom left of the screen
		msgThree = new MessageButton("Bottom Left", false, Color.ORANGE, true, screenPanel.getWidth() / 8,
				(screenPanel.getHeight() / 2) - 20, 185, 60);

		// Message on the bottom right of the screen
		msgFour = new MessageButton("Bottom Right", false, Color.BLUE, true,
				screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 185, (screenPanel.getHeight() / 2) - 20, 185,
				60);

		// Message in the middle of the screen
		msgFive = new MessageButton("Center", true, Color.MAGENTA, false, (screenPanel.getWidth() / 2) - 100,
				(screenPanel.getHeight() / 2) - 85, 185, 60);
		
		messageButtons = new MessageButton[5];
		messageButtons[0] = msgOne;
		messageButtons[1] = msgTwo;
		messageButtons[2] = msgThree;
		messageButtons[3] = msgFour;
		messageButtons[4] = msgFive;

		msgOne.setToolTipText("Message top left of screen");
		msgTwo.setToolTipText("Message top right of screen");
		msgThree.setToolTipText("Message bottom left of screen");
		msgFour.setToolTipText("Message bottom right of screen");
		msgFive.setToolTipText("Message center of screen");

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
		speedSlider.setToolTipText("Message speed");
		speedSlider.setValue(speed);
		speedLbl = new JLabel("Display Every (ms):");

		intervalSlider = new JSlider(0, 20);
		intervalSlider.setToolTipText("Delay between each message in seconds");
		intervalSlider.setValue(interval);
		intervalLbl = new JLabel("Interval (s):");
	}

	public void styleUI() {
		speedLbl.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		speedSlider.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		speedSlider.setMinorTickSpacing(50);
		speedSlider.setMajorTickSpacing(1000);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setPreferredSize(new Dimension(300, 75));

		intervalLbl.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		intervalSlider.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		intervalSlider.setMinorTickSpacing(20);
		intervalSlider.setMajorTickSpacing(2);
		intervalSlider.setPaintTicks(true);
		intervalSlider.setPaintLabels(true);
		intervalSlider.setPreferredSize(new Dimension(300, 75));
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
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedLbl, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedSlider, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(intervalLbl, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(130, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(intervalSlider, gc); // add component to the ContentPane

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 430, 10, 20);
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
	
	public MessageButton[] getMessageButtons() {
		return messageButtons;
	}

	public void setMessageButtons(MessageButton[] messageButtons) {
		this.messageButtons = messageButtons;
	}

	public boolean[] getMsgLocationsSelected() {

		boolean msgLocationsSelected[] = new boolean[5];
		Arrays.fill(msgLocationsSelected, false);

		if (msgOne.isActive()) {
			msgLocationsSelected[0] = true;
		}
		if (msgTwo.isActive()) {
			msgLocationsSelected[1] = true;
		}
		if (msgThree.isActive()) {
			msgLocationsSelected[2] = true;
		}
		if (msgFour.isActive()) {
			msgLocationsSelected[3] = true;
		}
		if (msgFive.isActive()) {
			msgLocationsSelected[4] = true;
		}
		return msgLocationsSelected;
	}
}
