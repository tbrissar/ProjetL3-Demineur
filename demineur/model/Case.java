package demineur.model;

import java.io.Serializable;

public class Case implements Serializable {

	//genere par l'IDE
	private static final long serialVersionUID = 6240440593106244117L;
	private boolean mined;
	private boolean flagged = false;
	private boolean discovered = false;
	private int nbBombesAdjacentes = 0;
	private boolean bordure;
	
	public Case(boolean mined, boolean bordure) {
		this.mined = mined;
		this.bordure = bordure;
	}

	public boolean getMined() {
		return this.mined;
	}
	
	public boolean getFlagged() {
		return this.flagged;
	}
	
	public boolean getDiscovered() {
		return this.discovered;
	}
	
	public int getNbBombesAdjacentes() {
		return this.nbBombesAdjacentes;
	}
	
	public boolean getBordure() {
		return this.bordure;
	}
	
	public boolean flag() {
		return this.flagged = !(discovered || this.flagged);
	}
	
	public boolean decouverte() {
		return this.discovered = !this.flagged;
	}
	
	public void setMined(boolean mined) {
		this.mined = mined;
	}
	
	public void setBordure(boolean bordure) {
		this.bordure = bordure;
	}
	
	public void ajouterBombeAdjacente() {
		this.nbBombesAdjacentes++;
	}

}
