package demineur.ihm.Icones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class IconFlag implements Icon{
	
	private int height;
	private int width;
	
	public IconFlag(int height, int width) {
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
		Graphics2D graphics = (Graphics2D) g.create();
		/*
		Graphics2D graphicsBleu = (Graphics2D) g.create();
		Graphics2D graphicsBlanc = (Graphics2D) g.create();
		Graphics2D graphicsRouge = (Graphics2D) g.create();
		*/

		int h = c.getHeight();
		int w = c.getWidth();
		
		/*
		graphics.setColor(Color.black);
		graphics.fillRect((int)((1.3/4.0)*w), (int)((1.0/5.0)*h), (int)((0.3/5.0)*w), (int)((3.0/5.0)*h));
		
		graphicsBleu.setColor(Color.blue);
		graphicsBleu.fillRect((int)((1.5/4.0)*w), (int)((1.0/5.0)*h), (int)((1.0/5.0)*w/2), (int)((3.0/5.0)*h/2));
		
		graphicsBlanc.setColor(Color.white);
		graphicsBlanc.fillRect((int)((1.85/4.0)*w), (int)((1.0/5.0)*h), (int)((1.0/5.0)*w/2), (int)((3.0/5.0)*h/2));
		
		graphicsRouge.setColor(Color.red);
		graphicsRouge.fillRect((int)((2.2/4.0)*w), (int)((1.0/5.0)*h), (int)((1.0/5.0)*w/2), (int)((3.0/5.0)*h/2));
		*/
		
		graphics.setColor(Color.cyan);
		graphics.setStroke(new BasicStroke(4));
		graphics.fillRect((int)(w/3.8), (int)(h/2.2), (int)(w/2.0), (int)(h/10.0));
		graphics.drawArc((int)(w/4.0), (int)(h/4.0), (int)(w/2.0), (int)(h/2.0), 0, 360);
		
	}

}
