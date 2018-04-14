package gui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

import utility.FontPicker;

public class LoginButton extends JButton {
	
	private Color color;

	public LoginButton(String name, Color color) {
		super(name);
		this.color = color;
		setBackground(color);
		setForeground(Color.decode("#828282"));
		setOpaque(false);
		setFont(FontPicker.getFont(FontPicker.robotoRegular, 35.0f));
		setPreferredSize(new Dimension(200, 60));
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	public LoginButton(String name, float fontSize, Color color) {
		super(name);
		this.color = color;
		setBackground(color);
		setForeground(Color.WHITE);
		setOpaque(false);
		setFont(FontPicker.getFont(FontPicker.latoBold, fontSize));
		setPreferredSize(new Dimension(125, 50));
	}
	
	protected void paintComponent(Graphics g) {
		final int arcSize = getSize().height;
		g.setColor(color);
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(hints);
		g.fillRoundRect(0, 0, getSize().width, getSize().height, arcSize, arcSize);
		super.paintComponent(g);
	}
}
