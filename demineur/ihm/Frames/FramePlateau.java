package demineur.ihm.Frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import demineur.ihm.Controleur;
import demineur.ihm.Labels.LabelCase;
import demineur.ihm.Panels.PanelCase;
import demineur.model.Champ;

public class FramePlateau extends JFrame{

	private static final long serialVersionUID = 6573707273359729145L;
	
	private LabelCase[][] indexLabels;
	
	public FramePlateau(int taille, int height, int width, Controleur cont, Champ champ) {
		
		super("Plateau");	
		this.setSize(new Dimension(height, width));
		this.setLayout(new GridLayout(taille, taille));
		this.setMinimumSize(new Dimension(300,300));
		
		this.indexLabels = new LabelCase[taille][taille];
		
		for(int i = 0; i < taille; i++) {
			for(int j = 0; j< taille; j++) {
				PanelCase pan = new PanelCase(width/taille-50, height/taille-50, i, j, cont, champ.getCase(i, j));
				this.add(pan);
				this.indexLabels[i][j] = pan.getLabel();
			}
		}
		
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
		this.setVisible(true);
	}
	
	public LabelCase[][] getIndexLabels(){
		return this.indexLabels;
	}
	
	public void updateLabel(int i, int j) {
		this.indexLabels[i][j].update();
	}
}
