package demineur.ihm.Icones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class IconBombe implements Icon{
	
	private int height;
	private int width;
	
	public IconBombe(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	@Override
	public int getIconHeight() {
		return this.height;
	}

	@Override
	public int getIconWidth() {
		return this.width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D bombe = (Graphics2D) g.create();
		Graphics2D meche = (Graphics2D) g.create();

		int h = c.getHeight();
		int w = c.getWidth();
		
		bombe.setColor(Color.black);
		bombe.fillArc((int)(w/3.5), (int)(h/2.25), (int)(w/2.5), (int)(h/2.5), 0, 360);
		
		meche.setColor(Color.yellow);
		meche.setStroke(new BasicStroke(2));
		meche.drawArc((int)(w/14.0), (int)(h/3.0), (int)(w/2.0), (int)(h/4.0), 0, 50);
		
	}


}
