package demineur.ihm.MyClasses;

import javax.swing.Box;
import javax.swing.border.MatteBorder;

public class MyBox extends Box implements MyStyle{

	private static final long serialVersionUID = -9048345680290584585L;

	public MyBox(int axis) {
		super(axis);
		
		this.setBackground(MyStyle.BACKGROUND_COLOR_ONE);
		this.setBorder(new MatteBorder(MyStyle.DEFAULT_BORDER_WIDTH, 0, MyStyle.DEFAULT_BORDER_WIDTH, 0, MyStyle.DEFAULT_BORDER_COLOR));
		this.setForeground(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setOpaque(true);
	}
}
