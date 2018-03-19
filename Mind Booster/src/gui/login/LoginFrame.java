package gui.login;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.util.IconFetch;
import utility.FontPicker;

public class LoginFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 6685039386661838526L;
	public static final int W = 750, H = 650, minW = 700, minH = 600;
	private JButton logo;
	private JLabel loginLbl, loginReminderLbl;
	private JLabel userLbl, passLbl;
	private JTextField userTxt;
	private JLabel errorLbl;
	private JPasswordField passTxt;
	private JButton submitBtn, tempLoginBtn;
	private LoginListener loginListener;
	
	public LoginFrame() {
		initComponents();
		setupUI();
		
		setTitle("Login");
		getContentPane().setBackground(Color.decode("#96ffc7"));
		setPreferredSize(new Dimension(W, H));
		setMinimumSize(new Dimension(minW, minH));
		centerFrame(this);
		setResizable(false);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		ImageIcon icon = IconFetch.getInstance().getIcon("/images/logo-small.png");
		
		logo = new JButton();
		logo.setIcon(icon);
		logo.setOpaque(false);
		logo.setContentAreaFilled(false);
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					URI uri = new URI("https://www.psychotechnology.com/");
					Desktop dt = Desktop.getDesktop();
					dt.browse(uri);
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginLbl = new JLabel("Log In");
		loginLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 32));
		
		loginReminderLbl = new JLabel("Please enter your Username and Password");
		loginReminderLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 16));
		loginReminderLbl.setForeground(Color.GRAY);
		
		errorLbl = new JLabel();
		errorLbl.setForeground(Color.RED);
		errorLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 16));
		
		userLbl = new JLabel("Username:");
		userLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 22));
		userLbl.setPreferredSize(new Dimension(350, 20));
		
		passLbl = new JLabel("Password:");
		passLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 22));
		passLbl.setPreferredSize(new Dimension(350, 110));
		
		userTxt = new JTextField(15);
		userTxt.setPreferredSize(new Dimension(350, 40));
		
		passTxt = new JPasswordField(15);
		passTxt.setPreferredSize(new Dimension(350, 40));
		
		submitBtn = new JButton("Login");
		submitBtn.setBackground(Color.decode("#226815"));
		submitBtn.setForeground(Color.BLACK);
		submitBtn.setOpaque(true);
		submitBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		submitBtn.setPreferredSize(new Dimension(125, 50));
		submitBtn.addActionListener(this);
		
		tempLoginBtn = new JButton("Skip");
		tempLoginBtn.setBackground(Color.decode("#226815"));
		tempLoginBtn.setForeground(Color.BLACK);
		tempLoginBtn.setOpaque(true);
		tempLoginBtn.setFont(FontPicker.getFont(FontPicker.latoRegular, 20));
		tempLoginBtn.setPreferredSize(new Dimension(125, 50));
		tempLoginBtn.addActionListener(this);
	}
	
	public void setUsername(String username) {
		userTxt.setText(username);
	}
	
	public void setPassword(String password) {
		passTxt.setText(password);
	}
	
	private void setupUI() {
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gbl);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(40, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;
		add(logo, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(0, 75, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(loginLbl, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(75, 75, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(loginReminderLbl, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(200, 75, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(errorLbl, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(0, 75, 0, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		add(userLbl, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(35, 75, 0, 75);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(userTxt, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(0, 75, 0, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		add(passLbl, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(75, 75, 0, 75);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(passTxt, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridheight = 1;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(0, 75, 0, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		add(submitBtn, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridheight = 1;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(0, 215, 0, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		add(tempLoginBtn, gc);
	}
	
	/**
	 * A general-purpose method to vertically and horizontally center a window.
	 * http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
	 */
	public void centerFrame(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == submitBtn) {
			if (loginListener != null) {
				String user = userTxt.getText();
				String pass = String.valueOf(passTxt.getPassword());
				LoginEvent loginEvent = new LoginEvent(this, user, pass);
				loginListener.loginEventOccurred(loginEvent);
			}
		}
		else if (ae.getSource() == tempLoginBtn) {
			if (loginListener != null) {
				LoginEvent loginEvent = new LoginEvent(this, "MjMGqzdkMSs4K4PNkN454Ufc", "");
				loginListener.loginEventOccurred(loginEvent);
			}
		}
	}
	
	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}
	
	public void setErrorMessage(String errorMsg) {
		errorLbl.setText(errorMsg);
	}
	
	public void destroy() {
		dispose();
	}
}
