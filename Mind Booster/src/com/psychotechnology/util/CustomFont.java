package com.psychotechnology.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import com.psychotechnology.GUI.Category.CategoryPanel;

public class CustomFont {

	public final static String latoBlack = "/com/psychotechnology/font/Lato-Black_0.ttf";
	public final static String latoBold = "/com/psychotechnology/font/Lato-Bold_0.ttf";
	public final static String latoRegular = "/com/psychotechnology/font/Lato-Regular_0.ttf";

	public static Font getFont(String dir, int fontSize) {
		Font font = null;
		InputStream is = CategoryPanel.class.getResourceAsStream(dir);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		font = font.deriveFont(Font.PLAIN, fontSize);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		return font;
	}
}
