package demineur.ihm.MyClasses;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyTimer extends Timer{

	private static final long serialVersionUID = 7535547933708343922L;

	public MyTimer(ActionListener listener) {
		super(1000, listener);
	}
}
