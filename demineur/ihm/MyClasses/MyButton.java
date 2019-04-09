package demineur.ihm.MyClasses;

import javax.swing.JButton;

public class MyButton extends JButton implements MyStyle{

	private static final long serialVersionUID = 2959123526154481298L;
	
	public MyButton(String s) {
		super(s);
		
		this.setBackground(BACKGROUND_COLOR_TWO);
		this.setForeground(DEFAULT_FOREGROUND_COLOR);
		this.setBorder(DEFAULT_BORDER);
		this.setFont(DEFAULT_FONT);
	}
}
