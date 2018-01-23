package utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class IconFetch {

	private static IconFetch instance;

	public static IconFetch getInstance() {
		if (instance == null)
			instance = new IconFetch();
		return instance;
	}

	public ImageIcon getIcon(String iconName) {
		java.net.URL imgUrl = getClass().getResource(iconName);
		if (imgUrl != null) {
			return new ImageIcon(imgUrl);
		}
		return null;
	}
	
	public Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
}