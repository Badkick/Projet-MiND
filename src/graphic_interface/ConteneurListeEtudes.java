package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ConteneurListeEtudes extends ConteneurAvecImage {

	// VARIABLES DE CLASSE //
	
	private Theme theme;
	private Conteneur conteneur;
	private Bouton bouton_back_menu;
	private JScrollPane scroll;
	private Conteneur conteneur_etudes;
	private GroupLayout layout;
	private Conteneur precedent;
	private Fenetre fen;
	private List<BoutonEtude> etudes;
	
	// CONSTRUCTEURS //
	
	public ConteneurListeEtudes(int width, int height, Image img, boolean remplissage, Theme theme, Conteneur precedent, Fenetre fen) {
		super(width, height, img, remplissage);
		this.theme = theme;
		this.precedent = precedent;
		this.fen = fen;
		this.etudes = this.importerEtudes();
		this.conteneur = new Conteneur(width,height);
		this.conteneur_etudes = new Conteneur();
		this.scroll = new JScrollPane(this.conteneur_etudes);
		this.layout = new GroupLayout(this.conteneur);
		this.conteneur.setLayout(layout);
		this.conteneur.setOpaque(false);
		this.conteneur_etudes.setOpaque(true);
		this.scroll.setOpaque(false);
		this.bouton_back_menu = new Bouton("Retour au menu", new Dimension(180, 50), theme);
		this.initialiser();
		this.add(conteneur);
	}

	public ConteneurListeEtudes(int width, int height, Image img, Theme theme, Conteneur precedent, Fenetre fen) {
		this(width, height, img,true,theme,precedent,fen);
	}

	public ConteneurListeEtudes(Dimension dim, Image img, Theme theme, Conteneur precedent, Fenetre fen) {
		this((int)dim.getWidth(),(int)dim.getHeight(), img,true,theme,precedent,fen);
	}

	public ConteneurListeEtudes(Dimension dim, Image img, boolean remplissage, Theme theme, Conteneur precedent, Fenetre fen) {
		this((int)dim.getWidth(),(int)dim.getHeight(), img,remplissage,theme,precedent,fen);
	}
	
	// GETTERS //
	
	public Theme getTheme()
	{
		return this.theme;
	}
	
	public Conteneur getConteneur()
	{
		return this.conteneur;
	}
	
	public Bouton getBoutonBack()
	{
		return this.bouton_back_menu;
	}
	
	public JScrollPane getScroll()
	{
		return this.scroll;
	}
	
	public Conteneur getConteneurEtudes()
	{
		return this.conteneur_etudes;
	}
	
	public GroupLayout getLayout()
	{
		return this.layout;
	}
	
	public Conteneur getPrecedent()
	{
		return this.precedent;
	}
	
	public Fenetre getFenetre()
	{
		return this.fen;
	}
	
	public List<BoutonEtude> getEtudes()
	{
		return this.etudes;
	}
	
	// SETTERS //
	
	// METHODES //

	// initialise le conteneur
	private void initialiser()
	{
		
		this.getLayout().setAutoCreateGaps(true);
		this.getLayout().setAutoCreateContainerGaps(true);
		this.getScroll().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getScroll().setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.getScroll().setMaximumSize(new Dimension(700, 525));
		
		this.getLayout().setHorizontalGroup(
				this.getLayout().createSequentialGroup()
				.addGap(150)
				.addGroup(this.getLayout().createParallelGroup()
						.addComponent(this.getScroll())
						.addGap(50)
						.addGroup(this.getLayout().createSequentialGroup()
								.addGap(240)
								.addComponent(this.getBoutonBack())
								)
						)
				.addGap(150)
				);
		
		this.getLayout().setVerticalGroup(
				this.getLayout().createSequentialGroup()
				.addGap(20)
				.addComponent(this.getScroll())
				.addGap(30)
				.addComponent(this.getBoutonBack())
				.addGap(50)
				);
		
		this.getBoutonBack().addActionListener(new ChangerConteneur(this.getFenetre(),this.getPrecedent()));
		
		this.initialiserListe();
	}
	
	// initialise le conteneur à l'intérieur du Scroll Pane (y ajoute tous les BoutonEtude de etudes)
	private void initialiserListe()
	{
		if(!this.getEtudes().isEmpty())
		{
			this.getConteneurEtudes().setTaille(BoutonEtude.LARGEUR, (BoutonEtude.HAUTEUR+5)*this.getEtudes().size());
			for(BoutonEtude e : this.getEtudes()) this.getConteneurEtudes().add(e);
		}
	}
	
	// importe les études enregistrées
	private List<BoutonEtude> importerEtudes()
	{
		List<BoutonEtude> liste = new ArrayList<BoutonEtude>();
		
		for(int i=0;i<1000;i++) liste.add(new BoutonEtude(this.getTheme(),String.valueOf(i))); // test
		
		return liste;
	}
}
