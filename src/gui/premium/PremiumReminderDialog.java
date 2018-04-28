package gui.premium;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import gui.MainFrame;
import gui.component.OrderButton;
import gui.component.PictureLabel;
import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import utility.FontPicker;

@SuppressWarnings("serial")
public class PremiumReminderDialog extends JDialog {

	private JLabel  title, subheading, description;
	private PictureLabel logo, screen;
	private OrderButton orderButton;
	
	public PremiumReminderDialog() {
		initComponents();
		setupUI();
		
		getContentPane().setBackground(Color.decode("#fefefe"));
		setTitle(MainFrame.appName);
		setIconImage(IconFetch.getInstance().getIcon("/images/icon.png").getImage());
		setPreferredSize(new Dimension(900, 700));
		setMinimumSize(new Dimension(800, 650));
		pack();
		SetScreenLocation.centerFrame(this);
		setModal(true);
		setResizable(false);
		setVisible(false);
	}
	
	private void initComponents() {
		logo = new PictureLabel(IconFetch.getInstance().getIcon("/images/logo-small.png"));
		
		title = new JLabel("<html><u>Buy Subliminator Premium and Unlock up to 5 Messages</u></html>", SwingConstants.CENTER);
		title.setFont(FontPicker.getFont(FontPicker.latoRegular, 22.0f));
		
		subheading = new JLabel("Subliminator Premium Benefits");
		subheading.setFont(FontPicker.getFont(FontPicker.latoRegular, 22.0f));
		subheading.setHorizontalAlignment(SwingConstants.CENTER);
		
		description = new JLabel("<html>Select up to 5 subliminal messages to display<br/>onto your screen at once. 5x the power: let<br/>these messages enter your subconscious mind<br/>while you surf the web.</html>");
		description.setFont(FontPicker.getFont(FontPicker.latoRegular, 16.0f));
		description.setHorizontalAlignment(SwingConstants.CENTER);

		screen = new PictureLabel(IconFetch.getInstance().getIcon("/images/screen-premium.png"));
		
		orderButton = new OrderButton("Subliminator Premium only £19.99");
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					URI uri = new URI("https://www.psychotechnology.com/subliminator/premium");
					Desktop dt = Desktop.getDesktop();
					dt.browse(uri);
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void setupUI() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(40, 0, 0, 0);
		gc.anchor = GridBagConstraints.NORTH;
		gc.fill = GridBagConstraints.NONE;
		add(logo, gc);
		
		gc.weighty++;
		gc.insets = new Insets(75, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.BOTH;
		add(title, gc);
		
		gc.gridy++;
		gc.gridwidth = 1;
		gc.insets = new Insets(40, 40, 0, 0);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.NONE;
		add(screen, gc);
		
		gc.gridwidth = 1;
		gc.gridx++;
		gc.insets = new Insets(40, 30, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.BOTH;
		add(new JSeparator(JSeparator.VERTICAL), gc);
		
		gc.gridx++;
		gc.insets = new Insets(100, 0, 0, 50);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		add(subheading, gc);
		
		gc.insets = new Insets(40, 0, 0, 50);
		gc.fill = GridBagConstraints.BOTH;
		add(description, gc);
		
		gc.gridx = 0;
		gc.gridy++;
		gc.gridheight = 1;
		gc.gridwidth = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(40, 50, 50, 50);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.BOTH;
		add(orderButton, gc);
	}
}
