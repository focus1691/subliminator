package gui.custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import constants.CustomColor;
import gui.JFontChooser;
import gui.util.IconFetch;
import utility.FontPicker;

public class MessageButton extends JPanel {

	private static final long serialVersionUID = -890456094498670386L;
	private Preferences prefs;
	private JPopupMenu menu;
	private JLabel label;
	private Color activeColour;
	private CirclePanel circlePanel;
	private String categoryName;
	private ImageIcon image;
	private double btnToScreenWRatio, btnToScreenHRatio;
	private boolean active = false;
	private boolean locked = true;
	private Font font;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public MessageButton(String categoryName, boolean active, Color activeColour, boolean locked, int x, int y, int w,
			int h) {
		this.categoryName = categoryName;
		this.activeColour = activeColour;
		this.locked = locked;

		prefs = Preferences.userRoot().node(this.getClass().getName());
		setActive(prefs.getBoolean(categoryName, false));

		createMenu();

		font = FontPicker.getFont(FontPicker.latoBlack, 20);

		label = new JLabel(categoryName, JLabel.CENTER);
		label.setForeground(activeColour);
		label.setBackground(Color.WHITE);
		label.setFont(font);
		label.setOpaque(true);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		});

		circlePanel = new CirclePanel(CustomColor.green);
		circlePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActive()) {
					circlePanel.setActiveColour(CustomColor.lightGrey);
					circlePanel.repaint();
					setActive(false);
					prefs.putBoolean(categoryName, false);
				} else {
					circlePanel.setActiveColour(CustomColor.green);
					circlePanel.repaint();
					setActive(true);
					prefs.putBoolean(categoryName, true);
				}
			}
		});

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(label);
		add(circlePanel);

		setBounds(x, y, w, h);
		setOpaque(true);
		setBackground(Color.WHITE);

		if (isActive()) {
			circlePanel.setActiveColour(CustomColor.green);
			setActive(true);
		} else {
			circlePanel.setActiveColour(CustomColor.lightGrey);
			setActive(false);
		}
		if (isLocked()) {
			lock();
		} else {
			unlock();
		}
	}

	private void createMenu() {
		this.menu = new JPopupMenu();

		JMenuItem colourPickerItem = new JMenuItem("Choose Colour");
		colourPickerItem.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		colourPickerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(null, "Pick Color", getBackground());
				label.setForeground(newColor);
				label.repaint();
			}
		});

		JMenuItem fontPickerItem = new JMenuItem("Choose Font");
		fontPickerItem.setFont(FontPicker.getFont(FontPicker.latoBlack, 20));
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
					label.setFont(font);
				}
			}
		});

		this.menu.add(colourPickerItem);
		this.menu.add(fontPickerItem);
	}

	@Override
	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getActiveColour() {
		return activeColour;
	}

	public void setActiveColour(Color activeColour) {
		this.activeColour = activeColour;
	}

	public double getBtnToScreenWRatio() {
		return btnToScreenWRatio;
	}

	public void setBtnToScreenWRatio(double btnToScreenWRatio) {
		this.btnToScreenWRatio = btnToScreenWRatio;
	}

	public double getBtnToScreenHRatio() {
		return btnToScreenHRatio;
	}

	public void setBtnToScreenHRatio(double btnToScreenHRatio) {
		this.btnToScreenHRatio = btnToScreenHRatio;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public boolean isLocked() {
		return locked;
	}

	public void lock() {
		this.locked = true;
		label.setIcon(IconFetch.getInstance().getIcon("/com/psychotechnology/images/lock2.png"));
	}

	public void unlock() {
		this.locked = false;
	}
}