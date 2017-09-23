package com.psychotechnology.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.psychotechnology.util.IconFetch;

/**
 *
 * @author Joshua
 */
public class SubliminalMessage extends JPanel {

	private static final long serialVersionUID = -7806435918984466627L;
	private JLabel message = new JLabel("Test message");
	private JLabel image = new JLabel(IconFetch.getInstance().getIcon("/com/psychotechnology/images/stop.jpg"));

	public SubliminalMessage() {
		setOpaque(false);
		setLayout(new BorderLayout());
		add(message, BorderLayout.NORTH);
		add(image, BorderLayout.CENTER);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
/*		g2d.setColor(Color.RED);
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);		
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);*/
		g2d.setColor(Color.RED);
		g2d.drawString("This is gona be awesome", 70, 20);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	public JLabel getMessage() {
		return message;
	}

	public void setMessage(JLabel message) {
		this.message = message;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}
}
