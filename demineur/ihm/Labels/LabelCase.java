package demineur.ihm.Labels;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Icon;

import demineur.ihm.Icones.IconBombe;
import demineur.ihm.Icones.IconFlag;
import demineur.ihm.MyClasses.MyLabel;
import demineur.model.Case;

public class LabelCase extends MyLabel{

	private static final long serialVersionUID = 6273565221639249531L;
	
	private final int ordonnee;
	private final int abcisse;
	private Case c;

	public LabelCase(int width, int height, int i, int j, Case c) {
		super();
		
		this.ordonnee = i;
		this.abcisse = j;
		this.c = c;
		
	    this.update();

	    this.setPreferredSize(new Dimension(width, height));
	    
	}
	
	public int getI() {
		return this.ordonnee;
	}
	
	public int getJ() {
		return this.abcisse;
	}
	
	public void updateIcon(Icon icon) {
		this.setIcon(icon);
	}
	
	public void update() {
		
		Dimension size = this.getSize();
		
		this.updateIcon(null);
				
		if(!this.c.getDiscovered()) {
			this.setBackground(BACKGROUND_COLOR_ONE);
			if(this.c.getFlagged()) {
				this.updateIcon(new IconFlag(size.width, size.height));
			}
		}else {
			this.setBackground(BACKGROUND_COLOR_TWO);
			if(this.c.getMined()) {
				this.updateIcon(new IconBombe(size.width, size.height));
			}else {
				this.setText((this.c.getNbBombesAdjacentes() > 0) ? Integer.toString(this.c.getNbBombesAdjacentes()) : "");
				Font fonte = new Font("FonteNbBombes", Font.PLAIN, 21);
				this.setFont(fonte);
				this.setForeground(DEFAULT_FOREGROUND_COLOR);
			}
		}
		this.revalidate();
	}
}
