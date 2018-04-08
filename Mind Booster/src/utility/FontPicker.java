package utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import gui.category.CategoryPanel;

public class FontPicker {

	public final static String latoBlack = "/font/Lato-Black_0.ttf";
	public final static String latoBold = "/font/Lato-Bold_0.ttf";
	public final static String latoRegular = "/font/Lato-Regular_0.ttf";
	public final static String robotoRegular = "/font/Roboto-Regular.ttf";

	public static Font getFont(String dir, float fontSize) {
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
