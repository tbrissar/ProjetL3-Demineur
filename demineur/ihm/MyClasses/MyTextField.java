package demineur.ihm.MyClasses;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class MyTextField extends JTextField implements MyStyle{

	private static final long serialVersionUID = 3106821209394364410L;

	public MyTextField(int columns) {
		super(columns);
		
		this.setCaretColor(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setBorder(BorderFactory.createLineBorder(MyStyle.BACKGROUND_COLOR_ONE, 15));
		this.setBackground(MyStyle.BACKGROUND_COLOR_ONE);
		this.setForeground(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setFont(MyStyle.DEFAULT_FONT);
	}
	
	public MyTextField()
	{
		super();
		
		this.setCaretColor(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setBorder(BorderFactory.createLineBorder(MyStyle.BACKGROUND_COLOR_ONE, 15));
		this.setBackground(MyStyle.BACKGROUND_COLOR_ONE);
		this.setForeground(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setFont(MyStyle.DEFAULT_FONT);
	}
}
