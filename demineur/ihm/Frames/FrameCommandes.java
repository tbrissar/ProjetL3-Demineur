package demineur.ihm.Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import demineur.ihm.MyClasses.MyTextField;
import demineur.ihm.MyClasses.MyTimer;
import demineur.ihm.Panels.PanelJauge;
import demineur.ihm.Controleur;
import demineur.ihm.MyClasses.MyBox;
import demineur.ihm.MyClasses.MyButton;
import demineur.ihm.MyClasses.MyLabel;
import demineur.ihm.MyClasses.MyPanel;
import demineur.ihm.MyClasses.MyStyle;
import demineur.ihm.MyClasses.MySlider;
import demineur.model.Champ;
import demineur.model.Joueur;


public class FrameCommandes extends JFrame implements MyStyle{

	private static final long serialVersionUID = -7165362043047425718L;
	
	private static final int TAILLE_PLATEAU_MIN = 5;
	private static final int TAILLE_PLATEAU_MAX = 25;
	
	private static final int NB_BOMBE_MIN = 5;
	private final int NB_BOMBE_MAX;
	
	private PanelJauge jauge;
	private Controleur cont;
	private int changeTaille;
	private int changeBombe;
	private MyLabel labelTimer;
	private MyTimer timer;
	private int time;
	private MyPanel panelWR;
	
	public FrameCommandes(int width, int height, int taille, Controleur cont, Champ champ) {
		
		super("Commandes");
		
		this.NB_BOMBE_MAX = taille*taille-1;
		this.cont = cont;
		this.changeTaille = taille;
		this.changeBombe = champ.getNbBombes();
		
		this.setLocation(width, 0);
		this.setSize(new Dimension(height, width));
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(300, 300));
		
		//Bloc nom
		MyBox boxNom = new MyBox(BoxLayout.X_AXIS);
		this.initBoxNom(boxNom);
		
		//Bloc changement de la taille
		MyBox boxTaille = new MyBox(BoxLayout.X_AXIS);
		this.initBoxTaille(boxTaille, taille);
		
		//Bloc changement nombre de Bombes
		MyBox boxBombe = new MyBox(BoxLayout.X_AXIS);
		this.initBoxBombe(boxBombe, taille, champ.getNbBombes());
		
		//Bloc timer
		MyBox boxTime = new MyBox(BoxLayout.X_AXIS);
		this.initBoxTime(boxTime);
		
		//Bloc scores
		MyBox boxWR = this.initBoxWR();
		
		//Bloc jauge
		MyBox boxGauge = new MyBox(BoxLayout.X_AXIS);
		this.initBoxJauge(boxGauge, champ);

		//Bloc Reset&Quit
		MyBox boxResetQuit = new MyBox(BoxLayout.X_AXIS);
		this.initBoxResetQuit(boxResetQuit);
		
		MyBox mainBox = new MyBox(BoxLayout.Y_AXIS);
		mainBox.add(boxGauge);
		mainBox.add(boxNom);
		mainBox.add(boxTaille);
		mainBox.add(boxBombe);
		mainBox.add(boxTime);
		mainBox.add(boxWR);
		mainBox.add(boxResetQuit);
		
		this.add(mainBox, BorderLayout.CENTER);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
		this.setVisible(true);
	}
	
	public void stopTimer() {
		this.timer.stop();
	}
	
	private void initBoxNom(MyBox boxName) {
		
		MyLabel labelName = new MyLabel("Entrez votre nom : ");

		MyTextField fieldName = new MyTextField();
		fieldName.setText("Enter your name");
		fieldName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				MyTextField textfield = (MyTextField)evt.getSource();
				String s = textfield.getText();
				FrameCommandes.this.cont.getJeu().getJoueur().setNom(s);
			}
		});
		fieldName.setMaximumSize(new Dimension(2000,100));

		boxName.add(labelName);
		boxName.add(fieldName);
	}
	
	private void initBoxJauge(MyBox boxGauge, Champ champ) {
		
		MyLabel labelX = new MyLabel(Integer.toString(champ.getTaille()*champ.getTaille()-champ.getNbBombes()));
		MyBox boxLabelX = new MyBox(BoxLayout.Y_AXIS);
		boxLabelX.add(Box.createGlue());
		boxLabelX.add(labelX);
		
		MyLabel label0 = new MyLabel("0");
		MyBox boxLabel0 = new MyBox(BoxLayout.Y_AXIS);
		boxLabel0.add(Box.createGlue());
		boxLabel0.add(label0);
		
		MyBox boxJauge = new MyBox(BoxLayout.X_AXIS);
		this.jauge =  new PanelJauge(champ, boxJauge.getWidth(), boxJauge.getHeight());
		boxJauge.add(this.jauge);
		
		boxGauge.add(Box.createGlue());
		boxGauge.add(boxLabel0);
		boxGauge.add(this.jauge);
		boxGauge.add(boxLabelX);
		boxGauge.add(Box.createGlue());

	}
	
	private void initBoxTime(MyBox boxTime) {
		
		this.labelTimer = new MyLabel();
		
		this.timer = new MyTimer(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				FrameCommandes.this.time++;
				FrameCommandes.this.labelTimer.setText(Integer.toString(FrameCommandes.this.time));
			}
		});
		
		timer.start();
		
		boxTime.setBorder(BorderFactory.createEmptyBorder());
		boxTime.add(labelTimer);
	}
	
	private void initBoxBombe(MyBox boxBombe, int taille, int nbBombes) {
		
		MyLabel labelBomb = new MyLabel("Entrez le nombre de bombes : ");
		
		MySlider sliderBomb = new MySlider(MySlider.HORIZONTAL, NB_BOMBE_MIN, NB_BOMBE_MAX, nbBombes);
		sliderBomb.setMinorTickSpacing(taille/2);
		sliderBomb.setLabelTable(sliderBomb.createStandardLabels(taille*2));
		sliderBomb.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				MySlider slider = (MySlider) evt.getSource();
				if(!slider.getValueIsAdjusting()) {
					FrameCommandes.this.changeBombe = slider.getValue();
					new FrameValidation(FrameCommandes.this.cont, FrameCommandes.this.changeTaille, FrameCommandes.this.changeBombe);
				}
			}
		});

		boxBombe.add(labelBomb);
		boxBombe.add(sliderBomb);
	}
	
	private void initBoxTaille(MyBox boxDimension, int taille) {
		
		MyLabel labelDimension = new MyLabel("Entrez la taille du plateau : ");
		
		MySlider sliderDimension = new MySlider(MySlider.HORIZONTAL, TAILLE_PLATEAU_MIN, TAILLE_PLATEAU_MAX, taille);
		sliderDimension.setMinorTickSpacing(1);
		sliderDimension.setLabelTable(sliderDimension.createStandardLabels(5));
		sliderDimension.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				MySlider slider = (MySlider)evt.getSource();
				if(!slider.getValueIsAdjusting()) {
					FrameCommandes.this.changeTaille = slider.getValue();
					FrameValidation validation = new FrameValidation(FrameCommandes.this.cont, FrameCommandes.this.changeTaille, FrameCommandes.this.changeBombe);
					validation.dispose();
				}
			}
		});
		
		boxDimension.add(labelDimension);
		boxDimension.add(sliderDimension);
	}
	
	private MyBox initBoxWR() {
		
		this.panelWR = new MyPanel();
		this.panelWR.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.panelWR.setBorder(MyStyle.EMPTY_BORDER);
		
		MyButton buttonWR = new MyButton("Voir les records");
		buttonWR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				FrameCommandes.this.panelWR.removeAll();
				List<Joueur> listeHighscores = Joueur.loadScores();
				for(Joueur joueur : listeHighscores) {
					MyLabel label = new MyLabel(joueur.getNom() + ":" + Integer.toString(joueur.getScore()));
					FrameCommandes.this.panelWR.add(label);
				}
			}
		});
		
		MyBox boxScores = new MyBox(BoxLayout.X_AXIS);
		boxScores.add(panelWR);
		
		MyBox boxWR = new MyBox(BoxLayout.X_AXIS);
		this.panelWR.setMinimumSize(new Dimension(boxWR.getWidth()-buttonWR.getWidth(),200));
		boxWR.add(buttonWR);
		boxWR.add(boxScores);
		
		
		return boxWR;
	}
	
	private void initBoxResetQuit(MyBox boxResetQuit) {
		
		MyButton buttonReset = new MyButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				FrameCommandes.this.cont.initControleurTailleBombe(FrameCommandes.this.changeTaille, FrameCommandes.this.changeBombe);
			}
		});
		
		MyButton buttonQuit = new MyButton("Quit");
		buttonQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		
		boxResetQuit.add(buttonReset);
		boxResetQuit.add(MyBox.createHorizontalGlue());
		boxResetQuit.add(buttonQuit);
	}
	
	public PanelJauge getJauge() {
		return this.jauge;
	}
	
}
