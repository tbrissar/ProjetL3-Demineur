package demineur.ihm.MyClasses;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public interface MyStyle {

	public static final int DEFAULT_BORDER_WIDTH = 2;
	public static final Color DEFAULT_BORDER_COLOR = new Color(170, 0, 170);
	public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(DEFAULT_BORDER_COLOR,DEFAULT_BORDER_WIDTH);
	public static final Color BACKGROUND_COLOR_ONE = new Color(58, 28, 108);
	public static final Color BACKGROUND_COLOR_TWO = new Color(17, 0, 52);
	public static final Color DEFAULT_FOREGROUND_COLOR = Color.cyan;
	public static final Font DEFAULT_FONT = new Font("FonteTextField", Font.PLAIN, 12);
	public static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();
}
