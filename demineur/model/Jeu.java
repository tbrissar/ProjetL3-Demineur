package demineur.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Jeu implements Serializable{

	//genere par l'IDE
	private static final long serialVersionUID = 4501092497283197759L;
	
	private static int DEFAULT_TAILLE = 15;
	private static int DEFAULT_NB_BOMBES = 20;
	
	private Joueur joueur;
	private Champ champ;
	private boolean termine = false;
	
	public Jeu() {
		this(DEFAULT_TAILLE, DEFAULT_NB_BOMBES);
	}
	
	public Jeu(int taille, int nbBombes) {
		this(taille, nbBombes, new Joueur());
	}
	
	public Jeu(int taille, int nbBombes, Joueur joueur) {
		this.champ = new Champ(taille, nbBombes);
		this.joueur = joueur;
	}
	
	public void sauvegarder(String filename) {
		try {
			File sauvegarde = new File(filename);
			FileOutputStream fos = new FileOutputStream(sauvegarde);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(this);
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Jeu charger(String filename) {
		Jeu j = null;
		
		try {
			File chargement = new File(filename);
			FileInputStream fis = new FileInputStream(chargement);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			j = (Jeu)ois.readObject();
			
			ois.close();
			fis.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return j;
	}
	
	public Champ getChamp() {
		return this.champ;
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	public boolean getTermine() {
		return this.termine;
	}
	
	public void termine() {
		this.termine = true;
	}
}
