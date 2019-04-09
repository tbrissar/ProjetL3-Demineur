package demineur.ihm.Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import demineur.ihm.Controleur;
import demineur.ihm.MyClasses.MyButton;
import demineur.ihm.MyClasses.MyLabel;
import demineur.ihm.MyClasses.MyPanel;

public class FrameValidation extends JFrame{

	private static final long serialVersionUID = 8066193090596500584L;

	private Controleur cont;
	private int taille;
	private int nbBombes;
	
	public FrameValidation(Controleur cont, int taille, int nbBombes) {
		super();
		
		this.cont = cont;
		this.taille = taille;
		this.nbBombes = nbBombes;
		
		MyLabel label = new MyLabel("Enregistrer les modifications ?");
		
		MyButton buttonValidate = new MyButton("Valider");
		buttonValidate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				FrameValidation.this.cont.initControleurTailleBombe(FrameValidation.this.taille, FrameValidation.this.nbBombes);
				FrameValidation.this.cont.fermerFenetre(FrameValidation.this);
			}
		});
		
		MyButton buttonCancel = new MyButton("Annuler");
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				FrameValidation.this.dispose();
			}
		});
		
		MyPanel panel = new MyPanel();
		panel.add(label, BorderLayout.NORTH);
		panel.add(buttonValidate, BorderLayout.CENTER);
		panel.add(buttonCancel, BorderLayout.SOUTH);
		
		JFrame fenetre = new JFrame("Confirmation");
		fenetre.setSize(200, 150);
		fenetre.setLocation(600, 300);
		fenetre.setMinimumSize(new Dimension (100,100));
		fenetre.setMaximumSize(new Dimension (100,100));
		fenetre.add(panel);
		fenetre.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE) ;
		fenetre.setVisible(true);
	}
}
