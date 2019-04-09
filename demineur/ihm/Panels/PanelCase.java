package demineur.ihm.Panels;

import java.awt.Dimension;
import java.awt.Graphics;

import demineur.ihm.Controleur;
import demineur.ihm.Labels.LabelCase;
import demineur.ihm.MyClasses.MyPanel;
import demineur.model.Case;

public class PanelCase extends MyPanel{

	private static final long serialVersionUID = 2600587628648061463L;
		
	private LabelCase label;

	public PanelCase(int width, int height, int ordonnee, int abcisse, Controleur cont, Case c) {
	    super();
	    
	    this.setPreferredSize (new Dimension(width, height));
	    	    
	    this.label = new LabelCase(width, height, ordonnee, abcisse, c);
	    this.label.addMouseListener(cont);
	    this.add(this.label);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public LabelCase getLabel() {
		return this.label;
	}
}
