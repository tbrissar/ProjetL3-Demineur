package demineur.ihm.MyClasses;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MyStyle{

	private static final long serialVersionUID = -403260058466019091L;

	public MyPanel() {
		super();
		
		this.setLayout(new BorderLayout());
	    this.setBorder(MyStyle.DEFAULT_BORDER);
	    this.setBackground(BACKGROUND_COLOR_ONE);
		
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
	    this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
	    
	    this.setOpaque(true);
	    this.setVisible(true);
	}

}
