package demineur.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Joueur implements Serializable{

	private static final long serialVersionUID = 443390760728921927L;
	
	private String nom;
	private int score;
	
	public Joueur() {
		this("Anonyme");
	}
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public void saveScores() {
		List<Joueur> previousScores = Joueur.loadScores();
		
		try {
			File highscores = new File("highscores");
			FileOutputStream fos = new FileOutputStream(highscores);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			previousScores.add(this);
			if(previousScores.size() == 11) {
				Joueur jmin = new Joueur();
				jmin.setScore(Integer.MAX_VALUE);
				for(Joueur j : previousScores) {
					if(j.getScore() < jmin.getScore())
						jmin = j;
				}
				previousScores.remove(jmin);
			}
			
			oos.writeObject(previousScores);
			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<Joueur> loadScores() {
		
		List<Joueur> listeScores = new LinkedList<Joueur>();

		try {
			File highscores = new File("highscores");
			FileInputStream fis = new FileInputStream(highscores);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			listeScores = (List<Joueur>)ois.readObject();
			
			ois.close();
			fis.close();
			
		}catch(Exception e){
			//e.printStackTrace();
		}
		
		return listeScores;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getNom() {
		return this.nom;
	}
}
