package com.psychotechnology.GUI.Settings;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *
 * @see http://stackoverflow.com/a/12297384/714968
 */
public class CustomSliderUI extends BasicSliderUI {

	private BasicStroke stroke = new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f,
			new float[] { 1f, 2f }, 10f);

	public CustomSliderUI(JSlider b) {
		super(b);
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		super.paint(g, c);
	}

	@Override
	protected Dimension getThumbSize() {
		return new Dimension(12, 16);
	}

	@Override
	public void paintTrack(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke old = g2d.getStroke();
		g2d.setStroke(stroke);
		g2d.setPaint(Color.decode("#2388d9"));
		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			g2d.drawLine(trackRect.x, trackRect.y + trackRect.height / 2, trackRect.x + trackRect.width,
					trackRect.y + trackRect.height / 2);
		} else {
			g2d.drawLine(trackRect.x + trackRect.width / 2, trackRect.y, trackRect.x + trackRect.width / 2,
					trackRect.y + trackRect.height);
		}
		g2d.setStroke(old);
	}

	@Override
	public void paintThumb(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int x1 = thumbRect.x + 2;
		int x2 = thumbRect.x + thumbRect.width - 2;
		int width = thumbRect.width - 4;
		int topY = thumbRect.y + thumbRect.height / 2 - thumbRect.width / 3;
		GeneralPath shape = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		shape.moveTo(x1, topY);
		shape.lineTo(x2, topY);
		shape.lineTo((x1 + x2) / 2, topY + width);
		shape.closePath();
		g2d.setPaint(Color.WHITE);
		g2d.fill(shape);
		drawCenteredCircle(g2d, x1, topY + 3, 30);
		Stroke old = g2d.getStroke();
		g2d.setStroke(new BasicStroke(15f));
		// g2d.draw(shape);
		g2d.setStroke(old);
	}

	public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
		x = x - (r / 2);
		y = y - (r / 2);
		g.fillOval(x, y, r, r);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JSlider slider = new JSlider(0, 100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(25);
		slider.setUI(new CustomSliderUI(slider));

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				slider.getValue();
				// slider.getUI().paint(g, c);
			}

		});

		frame.add(slider);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}