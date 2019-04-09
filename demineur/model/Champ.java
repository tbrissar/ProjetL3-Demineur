package demineur.model;

import java.util.concurrent.ThreadLocalRandom;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Champ implements Serializable{
	
	//genere par L'IDE
	private static final long serialVersionUID = -1020156264364101997L;
	
	private Case cases[][];
	private int taille;
	private int nbBombes;
	private int nbCasesDecouvertes = 0;
		
	public Champ(int taille, int nbBombes) {
		
		int tailleReelle = taille + 2;
		this.taille = taille;
		this.cases = new Case[tailleReelle][tailleReelle];
		this.nbBombes = nbBombes;
		List<Integer> indices_bombes = new LinkedList<Integer>();
		
		int randomNum;
		for(int i = 0; i < nbBombes; i++) {
			do
				randomNum = ThreadLocalRandom.current().nextInt(0, this.taille*this.taille);
			while(indices_bombes.contains(randomNum));
			indices_bombes.add(randomNum);
		}
		
		for(int i = 0; i < tailleReelle; i++)
			for(int j = 0; j < tailleReelle; j++)
				this.cases[i][j] = new Case(false,true);
		
		//on parcourt le champ
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				
				if(indices_bombes.contains(i*this.taille+j)) {
					this.cases[i+1][j+1].setMined(true);
					this.initNbBombesAdjacentes(i, j);
				}
				
				this.cases[i+1][j+1].setBordure(false);
			}
		}			
	}
	
	public Case getCase(int x, int y) {
		return this.cases[x+1][y+1];
	}
	
	public void affiche() {
		for(int i = 0; i < this.taille; i++) {
			for(int j = 0; j < this.taille; j++) {
				Case c = this.cases[i+1][j+1];
					System.out.print("[" 
				+ ((c.getMined() && c.getDiscovered()) ? "M" :
				  (c.getFlagged()) ? "F" :
				  (c.getDiscovered()) ? c.getNbBombesAdjacentes() : " ")
				+ "]");
			}
			System.out.println("");
		}
	}
	
	public void initNbBombesAdjacentes(int i, int j) {
		
		for(int x = i-1; x < i+2; x++)
			for(int y = j-1; y < j+2; y++)
				this.cases[x+1][y+1].ajouterBombeAdjacente();
	}
	
	//renvoie la liste des couples d'indices des cases ayant potentiellement changee d'etat
	public Queue<Integer> avantDecouverte(int i, int j) {
				
		Queue<Integer> listeIndices = new LinkedList<>();
		Case c = this.cases[i+1][j+1];	
		
		if(!c.getFlagged() && !c.getDiscovered()) {
		
			c.decouverte();
			
			this.nbCasesDecouvertes++;
						
			listeIndices.add(i);
			listeIndices.add(j);
			
			int nbFlags = 0;
			
			for(int x = i-1; x < i + 2; x++)
				for(int y = j-1; y < j + 2; y++)
					if(this.cases[x+1][y+1].getFlagged())
						nbFlags++;
			
			if(c.getNbBombesAdjacentes()-nbFlags == 0 && !c.getMined())
				for(int x = i-1; x < i + 2; x++)
					for(int y = j-1; y < j + 2; y++)
						if(!(this.cases[x+1][y+1].getDiscovered()
							|| this.cases[x+1][y+1].getBordure())
							&& !this.cases[x+1][y+1].getFlagged())
							listeIndices.addAll(this.avantDecouverte(x, y));
		}
		return listeIndices;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public int getNbBombes() {
		return this.nbBombes;
	}
	
	public double getPourcentNbCasesDecouvertes() {
		return (1.0 * this.nbCasesDecouvertes) / (this.taille * this.taille - this.nbBombes);
	}
	
	public int getNbCasesDecouvertes() {
		return this.nbCasesDecouvertes;
	}
}
