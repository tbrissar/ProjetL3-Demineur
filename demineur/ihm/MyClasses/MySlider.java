package demineur.ihm.MyClasses;

import javax.swing.JSlider;

public class MySlider extends JSlider implements MyStyle{

	private static final long serialVersionUID = 3471891968221996883L;
	
	public MySlider(int orientation, int min, int max, int value) {
		super(orientation, min, max, value);
		
		this.setFont(MyStyle.DEFAULT_FONT);
		this.setBackground(BACKGROUND_COLOR_ONE);
		this.setForeground(DEFAULT_FOREGROUND_COLOR);
		
		this.setPaintTicks(true);
		this.setPaintLabels(true);
	}
}
