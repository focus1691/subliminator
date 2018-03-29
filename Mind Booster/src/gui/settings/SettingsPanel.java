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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.component.MessageSelectionButton;
import gui.component.PictureLabel;
import gui.util.IconFetch;
import utility.FontPicker;

public class SettingsPanel extends JPanel implements ChangeListener {

	private static final long serialVersionUID = -798661649041437371L;
	public static boolean limitedMessages;
	public static final int maxMessages = 5;
	public static int numMessagesSelected = 0;
	private JLayeredPane screenContainer;
	private JPanel screenPanel;
	private Rectangle screenRect, containerRect;
	private double screenToPanelWRatio, screenToPanelHRatio;
	public static PictureLabel pictureLabel;
	private ImageIcon picturePreview;
	private JPanel picturePanel;
	private MessageSelectionButton[] messageButtons;
	private JSlider speedSlider, intervalSlider;
	private JLabel speedLbl, intervalLbl;
	private SettingsListener settingsListener;

	public SettingsPanel(int speed, int interval) {

		initComponents(speed, interval);
		setupUI();
	}

	public void initComponents(int speed, int interval) {
		screenRect = new Rectangle(0, 0, 800, 560);

		screenPanel = new JPanel();
		screenPanel.setLayout(new BorderLayout());
		screenPanel.setBounds(screenRect);
		screenPanel.add(new PictureLabel(IconFetch.getInstance().getIcon("/images/screen.png")), BorderLayout.CENTER);

		messageButtons = new MessageSelectionButton[5];
		messageButtons[0] = new MessageSelectionButton("Top Left");
		messageButtons[0].setBounds(screenPanel.getWidth() / 8, screenPanel.getHeight() / 8, 215, 80);
		messageButtons[0].setToolTipText("Message top left of screen");

		messageButtons[1] = new MessageSelectionButton("Top Right");
		messageButtons[1].setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 215,
				screenPanel.getHeight() / 8, 215, 80);
		messageButtons[1].setToolTipText("Message top right of screen");

		messageButtons[2] = new MessageSelectionButton("Bot Left");
		messageButtons[2].setBounds(screenPanel.getWidth() / 8, (screenPanel.getHeight() / 2), 215, 80);
		messageButtons[2].setToolTipText("Message bottom left of screen");

		messageButtons[3] = new MessageSelectionButton("Bot Right");
		messageButtons[3].setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 215,
				(screenPanel.getHeight() / 2), 215, 80);
		messageButtons[3].setToolTipText("Message bottom right of screen");

		messageButtons[4] = new MessageSelectionButton("Center");
		messageButtons[4].setBounds((screenPanel.getWidth() / 2) - 100, (screenPanel.getHeight() / 2) - 85, 215, 80);
		messageButtons[4].setToolTipText("Message center of screen");

		screenContainer = new JLayeredPane();
		screenContainer.add(screenPanel, new Integer(0), 0);
		screenContainer.add(messageButtons[0], new Integer(1), 0);
		screenContainer.add(messageButtons[1], new Integer(1), 0);
		screenContainer.add(messageButtons[2], new Integer(1), 0);
		screenContainer.add(messageButtons[3], new Integer(1), 0);
		screenContainer.add(messageButtons[4], new Integer(1), 0);

		picturePanel = new JPanel();
		picturePreview = new ImageIcon();
		pictureLabel = new PictureLabel(picturePreview);

		picturePanel.setLayout(new BorderLayout());
		picturePanel.add(pictureLabel, BorderLayout.CENTER);

		speedLbl = new JLabel("Display Every (ms):");
		speedLbl.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		intervalLbl = new JLabel("Interval (s):");
		intervalLbl.setFont(FontPicker.getFont(FontPicker.latoBold, 16));

		speedSlider = new JSlider(50, 1000);
		speedSlider.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		speedSlider.setToolTipText("Message speed");
		speedSlider.setMinorTickSpacing(1000);
		speedSlider.setMajorTickSpacing(190);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setPreferredSize(new Dimension(375, 75));
		speedSlider.setValue(speed == 0 ? 50 : speed);
		speedSlider.addChangeListener((ChangeListener) this);

		intervalSlider = new JSlider(0, 20);
		intervalSlider.setFont(FontPicker.getFont(FontPicker.latoBold, 16));
		intervalSlider.setToolTipText("Delay between each message in seconds");
		intervalSlider.setMinorTickSpacing(20);
		intervalSlider.setMajorTickSpacing(2);
		intervalSlider.setPaintTicks(true);
		intervalSlider.setPaintLabels(true);
		intervalSlider.setMinimum(2);
		intervalSlider.setPreferredSize(new Dimension(375, 75));
		intervalSlider.setValue(interval == 0 ? 2 : interval);
		intervalSlider.addChangeListener((ChangeListener) this);

		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				Component c = e.getComponent();
				if (containerRect != null) {
					screenRect.setRect(0, 0, (double) screenToPanelWRatio * c.getWidth(),
							(double) screenToPanelHRatio * c.getHeight());
					messageButtons[0].setAlignmentX(250);
					screenPanel.setBounds(screenRect);
					messageButtons[0].setBounds(screenPanel.getWidth() / 8, screenPanel.getHeight() / 8, 215, 80);
					messageButtons[1].setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 215,
							screenPanel.getHeight() / 8, 215, 80);
					messageButtons[2].setBounds(screenPanel.getWidth() / 8, (screenPanel.getHeight() / 2), 215, 80);
					messageButtons[3].setBounds(screenPanel.getWidth() - (screenPanel.getWidth() / 8) - 215,
							(screenPanel.getHeight() / 2), 215, 80);
					messageButtons[4].setBounds((screenPanel.getWidth() / 2) - 100, (screenPanel.getHeight() / 2) - 85,
							215, 80);
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
		gc.insets = new Insets(40, 50, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.BOTH;
		add(screenContainer, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(10, 40, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedLbl, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 40, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(speedSlider, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(140, 40, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(intervalLbl, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(150, 40, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(intervalSlider, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(30, 430, 10, 20);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		add(picturePanel, gc);
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

	public MessageSelectionButton[] getMessageButtons() {
		return messageButtons;
	}

	public void setMessageButtons(MessageSelectionButton[] messageButtons) {
		this.messageButtons = messageButtons;
	}

	public boolean[] getSelectedScreenPositions() {

		boolean msgLocationsSelected[] = new boolean[maxMessages];

		for (int i = 0; i < maxMessages; i++) {
			if (messageButtons[i].isActive()) {
				msgLocationsSelected[i] = true;
			} else {
				msgLocationsSelected[i] = false;
			}
		}
		return msgLocationsSelected;
	}

	public void checkForActiveMessages() {
		for (int i = 0; i < maxMessages; i++) {
			if (messageButtons[i].isActive()) {
				numMessagesSelected++;
			}
		}
	}

	public boolean isMoreThanOneMsgSelected() {
		int count = 0;
		for (int i = 0; i < maxMessages; i++) {
			if (messageButtons[i].isActive()) {
				if (++count > 1) {
					return true;
				}
			}
		}
		return false;
	}

	public void deactivateActiveMessages() {
		for (int i = 0; i < maxMessages; i++) {

			if (messageButtons[i].isActive()) {
				messageButtons[i].switchMessageOff();
				SettingsPanel.numMessagesSelected--;
			}
		}
	}

	public int getSpeed() {
		return speedSlider.getValue();
	}

	public int getInterval() {
		return intervalSlider.getValue();
	}
}