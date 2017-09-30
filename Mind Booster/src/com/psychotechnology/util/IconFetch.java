package com.psychotechnology.util;

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
}