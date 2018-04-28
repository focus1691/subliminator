package gui.login;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import gui.component.LoginButton;
import gui.component.RegisterButton;
import gui.component.RoundJPasswordField;
import gui.component.RoundJTextField;
import gui.util.IconFetch;
import gui.util.SetScreenLocation;
import utility.FontPicker;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener {

	public static final int W = 750, H = 750, minW = 700, minH = 700;
	private final String tempPass = "MjMGqzdkMSs4K4PNkN454Ufc";
	private JButton logo;
	private JLabel registerLbl, errorLbl;
	private RoundJTextField userTxt;
	private RoundJPasswordField passTxt;
	private JButton submitBtn, tempLoginBtn, registerBtn;
	private LoginListener loginListener;
	private LoginPanel loginPanel;

	public LoginFrame() {
		loginPanel = new LoginPanel(IconFetch.getInstance().getIcon("/images/login-background.png").getImage());
		initComponents();
		setupUI();
		
		setTitle("Login");
		setIconImage(IconFetch.getInstance().getIcon("/images/icon.png").getImage());
		setContentPane(loginPanel);
		loginPanel.setBackground(Color.decode("#1975be"));
		setPreferredSize(new Dimension(W, H));
		setMinimumSize(new Dimension(minW, minH));
		SetScreenLocation.centerFrame(this);
		setResizable(true);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initComponents() {
		ImageIcon icon = IconFetch.getInstance().getIcon("/images/logo-small.png");

		logo = new JButton();
		logo.setIcon(icon);
		logo.setOpaque(false);
		logo.setContentAreaFilled(false);
		logo.setBorderPainted(false);
		logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					URI uri = new URI("https://www.psychotechnology.com/");
					Desktop dt = Desktop.getDesktop();
					dt.browse(uri);
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		registerLbl = new JLabel("Not registered? Click the button below to register for a FREE account");
		registerLbl.setFont(FontPicker.getFont(FontPicker.latoRegular, 18.0f));
		registerLbl.setForeground(Color.WHITE);

		errorLbl = new JLabel();
		errorLbl.setFont(FontPicker.getFont(FontPicker.robotoRegular, 22.0f));
		errorLbl.setForeground(Color.decode("#B31616"));

		userTxt = new RoundJTextField(15);
		userTxt.setPlaceholder("Username");
		
		userTxt.setFont(FontPicker.getFont(FontPicker.robotoRegular, 32.0f));
		userTxt.setPreferredSize(new Dimension(350, 50));

		passTxt = new RoundJPasswordField(15);
		passTxt.setPlaceholder("Password");
		passTxt.setFont(FontPicker.getFont(FontPicker.robotoRegular, 32.0f));
		passTxt.setPreferredSize(new Dimension(350, 50));

		submitBtn = new LoginButton("Login", Color.decode("#ededed"));
		submitBtn.setForeground(Color.decode("#828282"));
		submitBtn.setBackground(Color.decode("#f4f4f4"));
		submitBtn.addActionListener(this);

		tempLoginBtn = new LoginButton("<html><u>Skip</u></html>", 30.0f, Color.decode("#1975bf"));
		tempLoginBtn.setContentAreaFilled(false);
		tempLoginBtn.addActionListener(this);

		registerBtn = new RegisterButton("Register");
		registerBtn.addActionListener(this);
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
		loginPanel.setLayout(gbl);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.insets = new Insets(10, 0, 0, 0);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;
		loginPanel.add(logo, gc);
		
		JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
		sep.setBackground(Color.decode("#5d9ed3"));
		sep.setForeground(Color.decode("#5d9ed3"));
		
		gc.gridy++;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.NORTH;
		loginPanel.add(sep, gc);

		gc.gridy++;
		gc.insets = new Insets(20, 75, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		loginPanel.add(errorLbl, gc);

		gc.gridy++;
		gc.insets = new Insets(0, 75, 0, 75);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.HORIZONTAL;
		loginPanel.add(userTxt, gc);
		
		gc.gridy++;
		gc.insets = new Insets(25, 75, 0, 75);
		loginPanel.add(passTxt, gc);

		gc.gridy++;
		gc.gridwidth = 2;
		gc.insets = new Insets(25, 0, 0, 0);
		gc.anchor = GridBagConstraints.NORTH;
		gc.fill = GridBagConstraints.NONE;
		loginPanel.add(submitBtn, gc);

		gc.gridy++;
		gc.gridwidth = 2;
		gc.insets = new Insets(0, 0, 20, 0);
		loginPanel.add(tempLoginBtn, gc);

		gc.gridy++;
		gc.gridwidth = 1;
		gc.insets = new Insets(0, 75, 0, 0);
		gc.fill = GridBagConstraints.BOTH;
		loginPanel.add(registerLbl, gc);
		
		gc.gridy++;
		gc.gridwidth = 2;
		gc.insets = new Insets(0, 75, 90, 75);
		loginPanel.add(registerBtn, gc);
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
		} else if (ae.getSource() == tempLoginBtn) {
			if (loginListener != null) {
				LoginEvent loginEvent = new LoginEvent(this, tempPass, "");
				loginListener.loginEventOccurred(loginEvent);
			}
		} else if (ae.getSource() == registerBtn) {
			try {
				URI uri = new URI("https://www.psychotechnology.com/register");
				Desktop dt = Desktop.getDesktop();
				dt.browse(uri);
			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}

	public void setErrorMessage(String errorMsg) {
		errorLbl.setText(errorMsg);
	}
	
	public void setUserAndPassFields(String user, String pass) {
		userTxt.setText(user);
		passTxt.setText(pass);
	}
}
