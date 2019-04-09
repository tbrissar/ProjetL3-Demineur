package demineur.ihm;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Queue;

import javax.swing.JFrame;

import demineur.ihm.Frames.FrameCommandes;
import demineur.ihm.Frames.FramePlateau;
import demineur.ihm.Labels.LabelCase;
import demineur.model.Champ;
import demineur.model.Jeu;

public class Controleur extends AbstractController implements MouseListener, ActionListener{
	
	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_WIDTH = 600;

	private FramePlateau plateau = null;
	private FrameCommandes commandes = null;
	private Jeu jeu = null;
	
	public Controleur() {
		 this.initControleur();
	}
	
	public Controleur(int width, int height, int taille, int nbBombes) {
		Jeu jeu = new Jeu(taille, nbBombes);
		this.initFrames(width, height, taille, jeu.getChamp());
	}
	
	public void initControleur() {
		this.jeu = new Jeu();
		this.initFrames(DEFAULT_WIDTH, DEFAULT_HEIGHT, jeu.getChamp().getTaille(), jeu.getChamp());
	}
	
	public void initControleurTailleBombe(int taille, int nbBombes) {
		this.jeu = new Jeu(taille, nbBombes);
		this.initFrames(DEFAULT_WIDTH, DEFAULT_HEIGHT, jeu.getChamp().getTaille(), jeu.getChamp());
	}
	
	public void initFrames(int width, int height, int taille, Champ champ) {
		this.fermerFenetre(this.plateau);
		this.plateau = new FramePlateau(taille, width, height, this, champ);
		this.fermerFenetre(this.commandes);
		this.commandes = new FrameCommandes(width, height, taille, this, champ);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!this.jeu.getTermine()) {
			LabelCase src = (LabelCase) e.getSource();
			switch(e.getButton()) {
			
				case MouseEvent.BUTTON1:
					Queue<Integer> listeIndices = this.jeu.getChamp().avantDecouverte(src.getI(), src.getJ());
					
					while(!listeIndices.isEmpty()) {
						
						int i = listeIndices.remove();
						int j =listeIndices.remove();
						
						this.plateau.updateLabel(i, j);
						
						if(this.jeu.getChamp().getCase(i, j).getMined() && !this.jeu.getTermine()) {
							this.defaite();
						}
					}
					this.commandes.getJauge().repaint();
					
					if(this.jeu.getChamp().getPourcentNbCasesDecouvertes() == 1 && !this.jeu.getTermine()){
						this.victoire();
					}
					
					break;
					
				case MouseEvent.BUTTON3:
					this.jeu.getChamp().getCase(src.getI(), src.getJ()).flag();
					src.update();
					break;
			}
			src.repaint();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
	}
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public void defaite() {
		System.out.println("PERDU");
		this.termine();
	}
	
	public void victoire() {
		System.out.println("VICTOIRE");
		this.jeu.getJoueur().setScore(this.jeu.getChamp().getNbBombes()*this.jeu.getChamp().getTaille());
		this.jeu.getJoueur().saveScores();
		this.termine();
	}
	
	public void termine() {
		this.commandes.stopTimer();
		this.jeu.termine();
	}
	
	public void fermerFenetre(JFrame frame) {
		if(frame != null)
			frame.dispose();
	}
	
	public static void main(String argv[]) {
		Controleur cont = new Controleur();
	}

}
