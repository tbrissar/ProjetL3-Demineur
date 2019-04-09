package demineur.ihm.MyClasses;

import javax.swing.JLabel;

public class MyLabel extends JLabel implements MyStyle{

	private static final long serialVersionUID = -287109030014342254L;
	
	public MyLabel(String s) {
		super(s);
		this.initLabel();
	}
	
	public MyLabel() {
		super();
		this.initLabel();
	}
	
	public void initLabel() {
		this.setBackground(MyStyle.BACKGROUND_COLOR_ONE);
		this.setForeground(MyStyle.DEFAULT_FOREGROUND_COLOR);
		this.setFont(MyStyle.DEFAULT_FONT);
		
	    this.setHorizontalAlignment(JLabel.CENTER);
	    this.setVerticalAlignment(JLabel.CENTER);
	    this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    this.setAlignmentY(JLabel.CENTER_ALIGNMENT);
	    this.setOpaque(true);
	    this.setVisible(true);
	}
}
