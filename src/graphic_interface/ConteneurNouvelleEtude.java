package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.GroupLayout;
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
	private boolean saved=false;
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
	
	public Bouton getBoutonExporter()
	{
		return this.bouton_exporter;
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

		this.getBoutonExporter().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(getConteneurSchema(1,MAINTENANT));
			}
		});

		this.getBoutonDelete().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File etude=new File("saves"+File.separator+getNom());
				if(etude.exists()){
					if(Communication.messageAttentionChoix("Vous êtes sur le point de supprimer cette étude. Confirmez-vous cette requête ?")==0){
						String[] donnees=etude.list();
						for(String s:donnees){
							File currentFile = new File(etude.getPath(),s);
							currentFile.delete();
						}
						etude.delete();
						getFenetre().setConteneur(getPrecedent());
					}
				}
				else{
					Communication.messageErreur("L'étude a déjà été supprimée ou n'a jamais été sauvegardée.");
				}
			}

		});

		this.getBoutonSave().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				Etude save=getEtude();
				String repertoire=getNom();
				
				Communication.messageInformatif("Sauvegarde effectuée avec succès !");

				save();
				try {
					Files.createDirectories(Paths.get("saves"+File.separator+repertoire));
				} catch (IOException e7) {
					// TODO Auto-generated catch block
					e7.printStackTrace();
				}
				/*
				List<String> lignes_contraintes=Arrays.asList(String.valueOf(save.getS1().getMtn_contr_tech().get()),String.valueOf(save.getS1().getApr_contr_tech().get()),String.valueOf(save.getS1().getMtn_press_envir().get()),String.valueOf(save.getS1().getApr_press_envir().get()),String.valueOf(save.getS1().getMtn_etabl_prot().get()),String.valueOf(save.getS1().getApr_etabl_prot().get()),String.valueOf(save.getS1().getMtn_mena_mar().get()),String.valueOf(save.getS1().getApr_mena_mar().get()));
				Path fichier_contraintes=Paths.get("saves"+File.separator+repertoire+File.separator+"Contraintes.txt");
				try {
					Files.write(fichier_contraintes, lignes_contraintes,Charset.forName("UTF-8"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				List<String> lignes_structures=Arrays.asList(save.getS2().getMtn_principale().getNom(),save.getS2().getApr_principale().getNom(),save.getS2().getMtn_notees()[0].getElement().getNom(),String.valueOf(save.getS2().getMtn_notees()[0].getNote()),save.getS2().getApr_notees()[0].getElement().getNom(),String.valueOf(save.getS2().getApr_notees()[0].getNote()),save.getS2().getMtn_notees()[1].getElement().getNom(),String.valueOf(save.getS2().getMtn_notees()[1].getNote()),save.getS2().getApr_notees()[1].getElement().getNom(),String.valueOf(save.getS2().getApr_notees()[1].getNote()),save.getS2().getMtn_notees()[2].getElement().getNom(),String.valueOf(save.getS2().getMtn_notees()[2].getNote()),save.getS2().getApr_notees()[2].getElement().getNom(),String.valueOf(save.getS2().getApr_notees()[2].getNote()),save.getS2().getMtn_notees()[3].getElement().getNom(),String.valueOf(save.getS2().getMtn_notees()[3].getNote()),save.getS2().getApr_notees()[3].getElement().getNom(),String.valueOf(save.getS2().getApr_notees()[3].getNote()));
				Path fichier_structures=Paths.get("saves"+File.separator+repertoire+File.separator+"Structures.txt");
				try {
					Files.write(fichier_structures, lignes_structures,Charset.forName("UTF-8"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				List<String> lignes_organisation=Arrays.asList(save.getS3().getMtn_principale().getNom(),save.getS3().getApr_principale().getNom(),save.getS3().getMtn_notees()[0].getElement().getNom(),String.valueOf(save.getS3().getMtn_notees()[0].getNote()),save.getS3().getApr_notees()[0].getElement().getNom(),String.valueOf(save.getS3().getApr_notees()[0].getNote()),save.getS3().getMtn_notees()[1].getElement().getNom(),String.valueOf(save.getS3().getMtn_notees()[1].getNote()),save.getS3().getApr_notees()[1].getElement().getNom(),String.valueOf(save.getS3().getApr_notees()[1].getNote()),save.getS3().getMtn_notees()[2].getElement().getNom(),String.valueOf(save.getS3().getMtn_notees()[2].getNote()),save.getS3().getApr_notees()[2].getElement().getNom(),String.valueOf(save.getS3().getApr_notees()[2].getNote()),save.getS3().getMtn_notees()[3].getElement().getNom(),String.valueOf(save.getS3().getMtn_notees()[3].getNote()),save.getS3().getApr_notees()[3].getElement().getNom(),String.valueOf(save.getS3().getApr_notees()[3].getNote()));
				Path fichier_organisation=Paths.get("saves"+File.separator+repertoire+File.separator+"Organisations.txt");
				try {
					Files.write(fichier_organisation, lignes_organisation,Charset.forName("UTF-8"));
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				List<String> lignes_relations=Arrays.asList(String.valueOf(save.getS4().getMtn_consensus().getImportance().get()),String.valueOf(save.getS4().getMtn_consensus().getConsensus().get()),String.valueOf(save.getS4().getMtn_consensus().getPacte().get()),String.valueOf(save.getS4().getApr_consensus().getImportance().get()),String.valueOf(save.getS4().getApr_consensus().getConsensus().get()),String.valueOf(save.getS4().getApr_consensus().getPacte().get()),String.valueOf(save.getS4().getMtn_negociation().getImportance().get()),String.valueOf(save.getS4().getMtn_negociation().getAjustement().get()),String.valueOf(save.getS4().getMtn_negociation().getTransformation().get()),String.valueOf(save.getS4().getApr_negociation().getImportance().get()),String.valueOf(save.getS4().getApr_negociation().getAjustement().get()),String.valueOf(save.getS4().getApr_negociation().getTransformation().get()),String.valueOf(save.getS4().getMtn_opposition().getImportance().get()),String.valueOf(save.getS4().getMtn_opposition().getDomination().get()),String.valueOf(save.getS4().getMtn_opposition().getContrePouvoir().get()),String.valueOf(save.getS4().getMtn_opposition().getAntagonisme().get()),String.valueOf(save.getS4().getApr_opposition().getImportance().get()),String.valueOf(save.getS4().getApr_opposition().getDomination().get()),String.valueOf(save.getS4().getApr_opposition().getContrePouvoir().get()),String.valueOf(save.getS4().getApr_opposition().getAntagonisme().get()));
				Path fichier_relations=Paths.get("saves"+File.separator+repertoire+File.separator+"Relations.txt");
				try {
					Files.write(fichier_relations, lignes_relations,Charset.forName("UTF-8"));
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}

				List<String> lignes_identites=Arrays.asList(String.valueOf(save.getS5().getMtn_reglementaire().get()),String.valueOf(save.getS5().getApr_reglementaire().get()),String.valueOf(save.getS5().getMtn_mobilite().get()),String.valueOf(save.getS5().getApr_mobilite().get()),String.valueOf(save.getS5().getMtn_pro_service_public().get()),String.valueOf(save.getS5().getApr_pro_service_public().get()),String.valueOf(save.getS5().getMtn_professionnelle().get()),String.valueOf(save.getS5().getApr_professionnelle().get()),String.valueOf(save.getS5().getMtn_communautaire().get()),String.valueOf(save.getS5().getApr_communautaire().get()),String.valueOf(save.getS5().getMtn_entrepreneuriale().get()),String.valueOf(save.getS5().getApr_entrepreneuriale().get()));
				Path fichier_identites=Paths.get("saves"+File.separator+repertoire+File.separator"Identites.txt");
				try {
					Files.write(fichier_identites, lignes_identites,Charset.forName("UTF-8"));
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}

				List<String> lignes_mondes=Arrays.asList(save.getS6().getMtn().getNom(),save.getS6().getApr().getNom());
				Path fichier_mondes=Paths.get("saves"+File.separator+repertoire+File.separator"Mondes.txt");
				try {
					Files.write(fichier_mondes, lignes_mondes,Charset.forName("UTF-8"));
				} catch (IOException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}*/

			}

		});

	
		this.getBoutonBack().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(isSaved()){
					getFenetre().setConteneur(getPrecedent());
				}else{
					if(Communication.messageAttentionChoix("Voulez-vous vraiment revenir à l'écran d'accueil ? \n Attention, vous perdrez les données non enregistrées.")==0){
						getFenetre().setConteneur(getPrecedent());
					}
				}
			}
			
		});
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
			tab_graphes[i] = new TabGraphe(i+1, theme);
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
