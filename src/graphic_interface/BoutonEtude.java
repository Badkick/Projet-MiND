package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class BoutonEtude extends ConteneurAvecImage {

	public static final int LARGEUR = 697;
	public static final int HAUTEUR = 80;
	
	// VARIABLES INSTANCE //
	
	private Theme theme;
	private int id;
	private JLabel conteneur_nom;
	private String nom = "";
	private Bouton editer;
	private Bouton presenter;
	
	// CONTRUCTEURS //

	public BoutonEtude(Theme theme, String nom) {
		super(LARGEUR, HAUTEUR, theme.getSelectionEtude());
		this.theme = theme;
		this.nom = nom+" Bonjour je suis Hugo et j'habite à Villeneuve les Béziers, une ville bien pourrie askip.";	
		this.conteneur_nom = new JLabel();
		this.conteneur_nom.setOpaque(false);
		this.conteneur_nom.setText(this.nom);
		this.conteneur_nom.setPreferredSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMinimumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMaximumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setFont(this.getTheme().getPolice());
		this.conteneur_nom.setForeground(this.getTheme().getCouleurTexte());
		this.conteneur_nom.setToolTipText(this.getNom());
		this.editer = new Bouton("Modifier", new Dimension(100, 50), theme);
		this.presenter = new Bouton("Présentation", new Dimension(100, 50), theme);
		
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
				.addComponent(this.presenter)
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup()
				.addComponent(this.conteneur_nom)
				.addComponent(this.editer)
				.addComponent(this.presenter)
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
		return presenter;
	}
	
	public Theme getTheme()
	{
		return this.theme;
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

	public void setEditer(Bouton editer) {
		this.editer = editer;
	}

	public void setPresenter(Bouton presenter) {
		this.presenter = presenter;
	}
	
	// METHODES //

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.getTheme().getCouleurTexte());
		g2d.drawImage(this.getImg(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
