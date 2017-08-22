package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class BoutonEtude extends ConteneurAvecImage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LARGEUR = 697;
	public static final int HAUTEUR = 80;
	
	// VARIABLES INSTANCE //
	
	private int id;
	private JLabel conteneur_nom;
	private String nom = "";
	private Bouton editer;
	private Bouton supprimer;
	
	// CONTRUCTEURS //

	public BoutonEtude(String nom) {
		super(LARGEUR, HAUTEUR, FenetreAccueil.theme.getSelectionEtude());
		this.nom = nom;
		this.conteneur_nom = new JLabel();
		this.conteneur_nom.setOpaque(false);
		this.conteneur_nom.setText(nom);
		this.conteneur_nom.setPreferredSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMinimumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMaximumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setFont(FenetreAccueil.theme.getPolice());
		this.conteneur_nom.setForeground(FenetreAccueil.theme.getCouleurTexte());
		this.conteneur_nom.setToolTipText(nom);
		this.editer = new Bouton("Editer", new Dimension(100, 50));
		this.supprimer = new Bouton("Supprimer", new Dimension(100, 50));
		
		this.editer.addActionListener(new ChargerEtude(this.getNom()));
		this.supprimer.addActionListener(new SupprimerEtude(this.getNom()));
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addComponent(this.conteneur_nom)
				.addGap(50)
				.addComponent(this.editer)
				.addGap(30)
				.addComponent(this.supprimer)
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup()
				.addComponent(this.conteneur_nom)
				.addGroup(
						layout.createSequentialGroup()
						.addGap(4)
						.addGroup(
								layout.createParallelGroup()
								.addComponent(this.editer)
								.addComponent(this.supprimer)
								)
						)
				);		
	}


	// GETTERS //
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Bouton getEditer() {
		return editer;
	}

	public Bouton getPresenter() {
		return supprimer;
	}
	
	public JLabel getConteneurNom()
	{
		return this.conteneur_nom;
	}
	

	// SETTERS //
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// METHODES //

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(FenetreAccueil.theme.getCouleurTexte());
		g2d.drawImage(this.getImg(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}
