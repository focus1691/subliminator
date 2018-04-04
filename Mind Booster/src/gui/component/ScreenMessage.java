package gui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import constants.CustomColor;
import gui.premium.PremiumReminderDialog;
import gui.settings.SettingsPanel;
import gui.util.JFontChooser;
import utility.FontPicker;

public class ScreenMessage extends JPanel {

	private static final long serialVersionUID = -890456094498670386L;
	private final String categoryName;
	private Preferences prefs;
	private JPopupMenu menu;
	private MessagePreview messagePreview;
	private MessageSwitch messageSwitch;
	private ImageIcon image;
	private boolean active = false;
	private JRadioButtonMenuItem bgOff, bgOn;
	private Color activeColour, activeBackground;
	private Font font;

	public ScreenMessage(final String categoryName) {
		this.categoryName = categoryName;

		initComponents();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(messagePreview, BorderLayout.CENTER);
		add(messageSwitch);
		setOpaque(true);
		setBackground(Color.WHITE);
	}

	private void initComponents() {
		prefs = Preferences.userRoot().node(this.getClass().getName());
		active = prefs.getBoolean(categoryName + "active", false);
		activeColour = new Color(prefs.getInt(categoryName + "colorforeground", 000000));
		activeBackground = new Color(prefs.getInt(categoryName + "colorbackground", -1));

		createMenu();

		font = FontPicker.getFont(FontPicker.latoBlack, 36);

		messagePreview = new MessagePreview(categoryName);
		messagePreview.setForeground(activeColour);
		messagePreview.setBackground(activeBackground);
		messagePreview.setFont(font);

		messageSwitch = new MessageSwitch(CustomColor.green);
		messageSwitch.setActiveColour(active ? CustomColor.green : CustomColor.lightGrey);
		messageSwitch.setAlignmentX(Component.CENTER_ALIGNMENT);
		messageSwitch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SettingsPanel.isUserPremium == false) {

					if (SettingsPanel.numMessagesSelected == 1) {
						if (isActive()) {
							switchMessageOff();
							SettingsPanel.numMessagesSelected--;
						} else {
							PremiumReminderDialog premiumReminderDialog = new PremiumReminderDialog();
							premiumReminderDialog.setVisible(true);
						}
					} else if (SettingsPanel.numMessagesSelected == 0) {
						if (isActive()) {
							switchMessageOff();
							SettingsPanel.numMessagesSelected--;
						} else {
							switchMessageOn();
							SettingsPanel.numMessagesSelected++;
						}
					}
				} else if (SettingsPanel.isUserPremium == true) {
					if (isActive()) {
						switchMessageOff();
						SettingsPanel.numMessagesSelected--;
					} else {
						switchMessageOn();
						SettingsPanel.numMessagesSelected++;
					}
				}
			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		});

		if (isActive()) {
			messageSwitch.setActiveColour(CustomColor.green);
			setActive(true);
		} else {
			messageSwitch.setActiveColour(CustomColor.lightGrey);
			setActive(false);
		}
	}

	public void switchMessageOff() {
		setActive(false);
		prefs.putBoolean(categoryName + "active", false);
		messageSwitch.setActiveColour(CustomColor.lightGrey);
		messageSwitch.repaint();
	}

	public void switchMessageOn() {
		setActive(true);
		prefs.putBoolean(categoryName + "active", true);
		messageSwitch.setActiveColour(CustomColor.green);
		messageSwitch.repaint();
	}

	private void createMenu() {
		this.menu = new JPopupMenu();

		bgOff = new RadioItem("Background Off");
		bgOff.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		bgOff.setForeground(Color.BLACK);
		bgOff.setBackground(Color.decode("#dbdbdb"));
		bgOff.setOpaque(true);
		bgOff.setSelected(prefs.getBoolean(categoryName + "bgOff", true));
		bgOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prefs.putBoolean(categoryName + "bgOn", false);
				prefs.putBoolean(categoryName + "bgOff", true);
			}
		});

		bgOn = new RadioItem("Background On");
		bgOn.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		bgOn.setForeground(Color.BLACK);
		bgOn.setBackground(Color.decode("#dbdbdb"));
		bgOn.setOpaque(true);
		bgOn.setSelected(prefs.getBoolean(categoryName + "bgOn", true));
		bgOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prefs.putBoolean(categoryName + "bgOn", true);
				prefs.putBoolean(categoryName + "bgOff", false);
			}
		});

		ButtonGroup bg = new ButtonGroup();
		bg.add(bgOff);
		bg.add(bgOn);

		MenuItem foregroundPickerItem = new MenuItem("Choose Colour");
		foregroundPickerItem.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		foregroundPickerItem.setForeground(Color.BLACK);
		foregroundPickerItem.setBackground(Color.decode("#dbdbdb"));
		foregroundPickerItem.setOpaque(true);
		foregroundPickerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Pick Color", getBackground());
				if (newColor != null) {
					prefs.putInt(categoryName + "colorforeground", newColor.getRGB());
					messagePreview.setForeground(newColor);
					messagePreview.repaint();
				}
			}
		});

		MenuItem backgroundPickerItem = new MenuItem("Choose Background");
		backgroundPickerItem.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		backgroundPickerItem.setForeground(Color.BLACK);
		backgroundPickerItem.setBackground(Color.decode("#dbdbdb"));
		backgroundPickerItem.setOpaque(true);
		backgroundPickerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (bgOn.isSelected()) {
					Color newColor = JColorChooser.showDialog(null, "Pick Color", getBackground());
					if (newColor != null) {
						prefs.putInt(categoryName + "colorbackground", newColor.getRGB());
						messagePreview.setBackground(newColor);
						messagePreview.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Background selector is turned off. Turn it on to change it.",
							"Message Background", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		MenuItem fontPickerItem = new MenuItem("Choose Font");
		fontPickerItem.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		fontPickerItem.setForeground(Color.BLACK);
		fontPickerItem.setBackground(Color.decode("#dbdbdb"));
		fontPickerItem.setOpaque(true);
		fontPickerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFontChooser fontChooser = new JFontChooser();
				fontChooser.setSelectedFontFamily(font.getFamily());
				fontChooser.setSelectedFontSize(font.getSize());
				fontChooser.setSelectedFontStyle(font.getStyle());
				int result = fontChooser.showDialog(null);
				if (result == JFontChooser.OK_OPTION) {
					setFont(fontChooser.getSelectedFont());
					messagePreview.setFont(font);
				}
			}
		});

		menu.add(foregroundPickerItem);
		menu.add(bgOff);
		menu.add(bgOn);
		menu.add(backgroundPickerItem);
		menu.add(fontPickerItem);

		menu.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getActiveColour() {
		return messagePreview.getForeground();
	}

	public void setActiveColour(Color activeColour) {
		this.activeColour = activeColour;
	}

	public boolean isBackgroundSelected() {
		return bgOff.isSelected() ? false : true;
	}

	public Color getActiveBackground() {
		return messagePreview.getBackground();
	}

	public void setActiveBackground(Color activeBackground) {
		this.activeBackground = activeBackground;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
}