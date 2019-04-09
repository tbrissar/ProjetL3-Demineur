package demineur.ihm.Panels;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.MatteBorder;

import demineur.ihm.MyClasses.MyPanel;
import demineur.ihm.MyClasses.MyStyle;
import demineur.model.Champ;

public class PanelJauge extends MyPanel{

	private static final long serialVersionUID = -5641787539872305825L;
	
	private Champ champ;

	public PanelJauge(Champ champ, int width, int height) {
		super();
		
		this.champ = champ;
				
		this.setBorder(new MatteBorder(MyStyle.DEFAULT_BORDER_WIDTH,0,MyStyle.DEFAULT_BORDER_WIDTH,0,MyStyle.DEFAULT_BORDER_COLOR));
		this.setBackground(MyStyle.BACKGROUND_COLOR_ONE);
		
		this.setOpaque(true);
		this.setVisible(true);
		this.repaint();
	}	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		int tailleCarre = (1.8*h > w) ? w : (int)(1.8*h);
		
		Graphics2D arc = (Graphics2D) g.create();
		arc.setStroke(new BasicStroke(4));
		arc.setColor(MyStyle.BACKGROUND_COLOR_TWO);
		arc.fillArc((w-tailleCarre)/2,h-(tailleCarre/2),tailleCarre, tailleCarre, 0, 180);
		arc.setColor(MyStyle.DEFAULT_BORDER_COLOR);
		arc.drawArc((w-tailleCarre)/2,h-(tailleCarre/2),tailleCarre, tailleCarre, 0, 180);
		
		Graphics2D aiguille = (Graphics2D) g.create();
		aiguille.setColor(MyStyle.DEFAULT_FOREGROUND_COLOR);
		aiguille.translate(w/2, h-1);
		aiguille.rotate(Math.PI *champ.getPourcentNbCasesDecouvertes()-(Math.PI/2));
		aiguille.fillRect(0, -tailleCarre*5/12, 3, tailleCarre/2); 
		aiguille.drawString(Integer.toString(champ.getNbCasesDecouvertes()), 0,-tailleCarre/2-10);
	}
}
