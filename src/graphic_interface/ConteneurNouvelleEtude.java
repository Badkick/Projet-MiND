package graphic_interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class ConteneurNouvelleEtude extends ConteneurAvecImage {

	// VARIABLES DE CLASSE //

	public static Dimension TAILLE_GRAND_CONTENEUR= new Dimension(972,570);
	public static Dimension TAILLE_PETIT_CONTENEUR= new Dimension(972,540);
	private static boolean MAINTENANT = true;
	private static boolean APRES = false;
	private static int NB_ONGLETS = 6;
	private final String[] titres_tabs = {"Contraintes d'envirmt.","Structures d'organisation","Organisation du travail","Relations entre acteurs","Identités collectives","Mondes sociaux"};

	// variables générales
	private Theme theme;
	private Fenetre fen;
	private Conteneur precedent;
	private JTabbedPane tabs;
	private Conteneur conteneur;
	private GroupLayout layout;
	private boolean saved = true;
	private String nom;
	private Etude etude;

	// boutons
	private Bouton bouton_back_menu;
	private Bouton bouton_save;
	private Bouton bouton_delete;
	private Bouton bouton_exporter;

	// panels tabs
	private Conteneur[] onglets = new Conteneur[NB_ONGLETS];
	private TabGraphe[] tab_graphes = new TabGraphe[NB_ONGLETS];

	// CONSTRUCTEURS //

	public ConteneurNouvelleEtude(int width, int height, Theme theme, Conteneur precedent, Fenetre fen, String nom, Etude etude) {
		super(width, height, theme.getBackground());
		this.theme = theme;
		this.precedent = precedent;
		this.fen = fen;
		this.nom = nom;
		this.etude = etude;
		this.conteneur = new Conteneur(width, height);
		//UIManager.put("TabbedPane.contentOpaque", false); // pour rendre les tab transparents
		this.tabs = new JTabbedPane();
		this.layout = new GroupLayout(this.conteneur);
		this.conteneur.setLayout(layout);
		this.conteneur.setOpaque(false);
		this.initialiser();
		this.add(conteneur);
	}

	public ConteneurNouvelleEtude(Dimension dim, Theme theme, Conteneur precedent, Fenetre fen, String nom, Etude etude) {
		this((int)dim.getWidth(),(int)dim.getHeight(),theme,precedent,fen,nom,etude);
	}

	// GETTERS //

	public Theme getTheme() {
		return theme;
	}

	public Fenetre getFenetre() {
		return fen;
	}

	public Conteneur getPrecedent() {
		return precedent;
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	public Conteneur getConteneur() {
		return conteneur;
	}

	public GroupLayout getLayout() {
		return layout;
	}

	public Bouton getBoutonBack()
	{
		return this.bouton_back_menu;
	}

	public Bouton getBoutonSave()
	{
		return this.bouton_save;
	}

	public Bouton getBoutonDelete()
	{
		return this.bouton_delete;
	}

	public boolean isSaved()
	{
		return this.saved;
	}

	public String getNom()
	{
		return this.nom;
	}
	
	public Etude getEtude()
	{
		return this.etude;
	}

	// SETTERS //

	public void save()
	{
		this.saved = true;
	}

	public void unsave()
	{
		this.saved = false;
	}

	// METHODES //

	private void initialiser()
	{
		this.initialiserConteneurs();
		this.initialiserTabs();
		this.initialiserBoutons();
		this.initialiserLayout();
	}

	private void initialiserBoutons()
	{
		this.bouton_back_menu = new Bouton("Retour au menu", new Dimension(180, 50), theme);
		this.bouton_save = new Bouton("Sauvegarder l'étude", new Dimension(180, 50), theme);
		this.bouton_delete = new Bouton("Supprimer l'étude", new Dimension(180, 50), theme);
		this.bouton_exporter = new Bouton("Présenter l'étude", new Dimension(180, 50), theme);

		this.bouton_exporter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(getConteneurSchema(1,MAINTENANT));
			}
		});

		this.getBoutonBack().addActionListener(this.isSaved() ? new ChangerConteneur(this.getFenetre(),this.getPrecedent()) : new ChangerConteneur(this.getFenetre(),this.getPrecedent(),"Voulez-vous vraiment revenir à l'écran d'accueil ? \n Attention, vous perdrez les données non enregistrées."));
	}

	private void initialiserLayout()
	{
		this.getLayout().setAutoCreateGaps(true);
		this.getLayout().setAutoCreateContainerGaps(true);

		this.getLayout().setHorizontalGroup(
				this.getLayout().createSequentialGroup()
				.addGroup(
						this.getLayout().createParallelGroup()
						.addGroup(
								this.getLayout().createSequentialGroup()
								.addComponent(bouton_back_menu)
								.addComponent(bouton_save)
								.addComponent(bouton_delete)
								.addComponent(bouton_exporter)
								)
						.addComponent(tabs)
						)				
				);

		this.getLayout().setVerticalGroup(
				this.getLayout().createSequentialGroup()
				.addGroup(
						this.getLayout().createParallelGroup()
						.addComponent(bouton_back_menu)
						.addComponent(bouton_save)
						.addComponent(bouton_delete)
						.addComponent(bouton_exporter)
						)
				.addComponent(tabs)
				);
	}

	private void initialiserTabs()
	{
		for(int i=0;i<NB_ONGLETS;i++)
		{
			this.getTabs().add("Schéma "+String.valueOf(i+1), onglets[i]);
			this.getTabs().setTabComponentAt(i, new CustomTab(titres_tabs[i],theme));
			this.getTabs().getTabComponentAt(i).setForeground(Color.red);
			((CustomTab) this.getTabs().getTabComponentAt(i)).setTaille(CustomTab.TAILLE);
		}
	}

	private void initialiserConteneurs()
	{
		for(int i=0;i<NB_ONGLETS;i++)
		{
			this.onglets[i] = new Conteneur(TAILLE_GRAND_CONTENEUR);
			tab_graphes[i] = new TabGraphe(i, theme);
			this.onglets[i].add(tab_graphes[i]);
			this.onglets[i].setOpaque(false);
		}
	}

	// pour récupérer le conteneur dans lequel il y a l'image : on pourra ainsi récupérer les boutons et les zones de texte ! A appeler à l'aide des boolean MAINTENANT et APRES.
	public ConteneurSchema getConteneurSchema(int type, boolean maintenant)
	{
		return maintenant ? ((TabGraphe)((Conteneur)this.getTabs().getComponentAt(type-1)).getComponents()[0]).getConteneur_maintenant() : ((TabGraphe)((Conteneur)this.getTabs().getComponentAt(type-1)).getComponents()[0]).getConteneur_apres();
	}
}
