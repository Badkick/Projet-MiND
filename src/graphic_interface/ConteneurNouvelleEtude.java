package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
	private static int MAINTENANT = 0;
	private static int APRES = 1;
	private static int RISQUE = 2;
	private static int NB_ONGLETS = 6;
	private final String[] titres_tabs = {"Contraintes d'envirmt.","Structures d'organisation","Organisation du travail","Relations entre acteurs","Identités collectives","Mondes sociaux"};

	// variables générales
	private Fenetre fen;
	private Conteneur precedent;
	private JTabbedPane tabs;
	private Conteneur conteneur;
	private GroupLayout layout;
	private boolean saved=false;
	private String nom;

	// boutons
	private Bouton bouton_back_menu;
	private Bouton bouton_save;
	private Bouton bouton_delete;
	private Bouton bouton_exporter;

	// panels tabs
	private Conteneur[] onglets = new Conteneur[NB_ONGLETS];
	private TabGraphe[] tab_graphes = new TabGraphe[NB_ONGLETS];

	// CONSTRUCTEURS //

	public ConteneurNouvelleEtude(int width, int height, Conteneur precedent, Fenetre fen, String nom) {
		super(width, height, FenetreAccueil.theme.getBackground());
		this.precedent = precedent;
		this.fen = fen;
		this.nom = nom;
		this.conteneur = new Conteneur(width, height);
		//UIManager.put("TabbedPane.contentOpaque", false); // pour rendre les tab transparents
		this.tabs = new JTabbedPane();
		this.layout = new GroupLayout(this.conteneur);
		this.conteneur.setLayout(layout);
		this.conteneur.setOpaque(false);
		this.initialiser();
		this.add(conteneur);
	}

	public ConteneurNouvelleEtude(Dimension dim, Conteneur precedent, Fenetre fen, String nom) {
		this((int)dim.getWidth(),(int)dim.getHeight(),precedent,fen,nom);
	}

	// GETTERS //

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
	
	public TabGraphe[] getTabGraphe(){
		return this.tab_graphes;
	}

	public boolean isSaved()
	{
		return this.saved;		
	}

	public String getNom()
	{
		return this.nom;
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
		for (int i=0;i<NB_ONGLETS;i++){
			this.getTabGraphe()[i].initialiserCases(i+1);
			new VerificationOnglets((CustomTab)this.getTabs().getTabComponentAt(i),tab_graphes[i]).verification();
		}
	}

	private void initialiserBoutons()
	{
		this.bouton_back_menu = new Bouton("Retour au menu", new Dimension(180, 50));
		this.bouton_save = new Bouton("Sauvegarder l'étude", new Dimension(180, 50));
		this.bouton_delete = new Bouton("Supprimer l'étude", new Dimension(180, 50));
		this.bouton_exporter = new Bouton("Présenter l'étude", new Dimension(180, 50));

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
						getFenetre().setTitle(ChangerConteneur.TITRE_INITIAL);
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

				Etude save=FenetreAccueil.etude;
				String repertoire=getNom();

				save();
				
				for(int i=0;i<ConteneurNouvelleEtude.NB_ONGLETS;i++){
					new UpdateEtude(getTabGraphe()[i]).updateEtude(getTabGraphe()[i]);
					new VerificationOnglets((CustomTab)getTabs().getTabComponentAt(i),tab_graphes[i]).verification();
				}
				
				
				try {
					Files.createDirectories(Paths.get("saves"+File.separator+repertoire));
					Communication.messageInformatif("Sauvegarde effectuée avec succès !");
				} catch (IOException e7) {
					// TODO Auto-generated catch block
					e7.printStackTrace();
				}
				
				List<String> lignes_contraintes=Arrays.asList((nullToEmpty(save.getS1().getMtn_contr_tech())),nullToEmpty(save.getS1().getApr_contr_tech()),nullToEmpty(save.getS1().getRis_contr_tech()),nullToEmpty(save.getS1().getMtn_press_envir()),nullToEmpty(save.getS1().getApr_press_envir()),nullToEmpty(save.getS1().getRis_press_envir()),nullToEmpty(save.getS1().getMtn_etabl_prot()),nullToEmpty(save.getS1().getApr_etabl_prot()),nullToEmpty(save.getS1().getRis_etabl_prot()),nullToEmpty(save.getS1().getMtn_mena_mar()),nullToEmpty(save.getS1().getApr_mena_mar()),nullToEmpty(save.getS1().getRis_mena_mar()),nullToEmpty(save.getS1().getCommentaire_risque()));
				Path fichier_contraintes=Paths.get("saves"+File.separator+repertoire+File.separator+"Contraintes.txt");
				try {
					Files.write(fichier_contraintes, lignes_contraintes,Charset.forName("UTF-8"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				List<String> lignes_structures=Arrays.asList(nullToEmpty(save.getS2().getMtn_principale()),nullToEmpty(save.getS2().getApr_principale()),nullToEmpty(save.getS2().getRis_principale()),nullToEmpty_StructureName(save.getS2().getMtn_notees()[0]),nullToEmpty_StructureNote(save.getS2().getMtn_notees()[0]),nullToEmpty_StructureName(save.getS2().getApr_notees()[0]),nullToEmpty_StructureNote(save.getS2().getApr_notees()[0]),nullToEmpty_StructureName(save.getS2().getRis_notees()[0]),nullToEmpty_StructureNote(save.getS2().getRis_notees()[0]),nullToEmpty_StructureName(save.getS2().getMtn_notees()[1]),nullToEmpty_StructureNote(save.getS2().getMtn_notees()[1]),nullToEmpty_StructureName(save.getS2().getApr_notees()[1]),nullToEmpty_StructureNote(save.getS2().getApr_notees()[1]),nullToEmpty_StructureName(save.getS2().getRis_notees()[1]),nullToEmpty_StructureNote(save.getS2().getRis_notees()[1]),nullToEmpty_StructureName(save.getS2().getMtn_notees()[2]),nullToEmpty_StructureNote(save.getS2().getMtn_notees()[2]),nullToEmpty_StructureName(save.getS2().getApr_notees()[2]),nullToEmpty_StructureNote(save.getS2().getApr_notees()[2]),nullToEmpty_StructureName(save.getS2().getRis_notees()[2]),nullToEmpty_StructureNote(save.getS2().getRis_notees()[2]),nullToEmpty_StructureName(save.getS2().getMtn_notees()[3]),nullToEmpty_StructureNote(save.getS2().getMtn_notees()[3]),nullToEmpty_StructureName(save.getS2().getApr_notees()[3]),nullToEmpty_StructureNote(save.getS2().getApr_notees()[3]),nullToEmpty_StructureName(save.getS2().getRis_notees()[3]),nullToEmpty_StructureNote(save.getS2().getRis_notees()[3]));
				Path fichier_structures=Paths.get("saves"+File.separator+repertoire+File.separator+"Structures.txt");
				try {
					Files.write(fichier_structures, lignes_structures,Charset.forName("UTF-8"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				List<String> lignes_organisation=Arrays.asList(nullToEmpty(save.getS3().getMtn_principale()),nullToEmpty(save.getS3().getApr_principale()),nullToEmpty(save.getS3().getRis_principale()),nullToEmpty_OrganisationName(save.getS3().getMtn_notees()[0]),nullToEmpty_OrganisationNote(save.getS3().getMtn_notees()[0]),nullToEmpty_OrganisationName(save.getS3().getApr_notees()[0]),nullToEmpty_OrganisationNote(save.getS3().getApr_notees()[0]),nullToEmpty_OrganisationName(save.getS3().getRis_notees()[0]),nullToEmpty_OrganisationNote(save.getS3().getRis_notees()[0]),nullToEmpty_OrganisationName(save.getS3().getMtn_notees()[1]),nullToEmpty_OrganisationNote(save.getS3().getMtn_notees()[1]),nullToEmpty_OrganisationName(save.getS3().getApr_notees()[1]),nullToEmpty_OrganisationNote(save.getS3().getApr_notees()[1]),nullToEmpty_OrganisationName(save.getS3().getRis_notees()[1]),nullToEmpty_OrganisationNote(save.getS3().getRis_notees()[1]),nullToEmpty_OrganisationName(save.getS3().getMtn_notees()[2]),nullToEmpty_OrganisationNote(save.getS3().getMtn_notees()[2]),nullToEmpty_OrganisationName(save.getS3().getApr_notees()[2]),nullToEmpty_OrganisationNote(save.getS3().getApr_notees()[2]),nullToEmpty_OrganisationName(save.getS3().getRis_notees()[2]),nullToEmpty_OrganisationNote(save.getS3().getRis_notees()[2]),nullToEmpty_OrganisationName(save.getS3().getMtn_notees()[3]),nullToEmpty_OrganisationNote(save.getS3().getMtn_notees()[3]),nullToEmpty_OrganisationName(save.getS3().getApr_notees()[3]),nullToEmpty_OrganisationNote(save.getS3().getApr_notees()[3]),nullToEmpty_OrganisationName(save.getS3().getRis_notees()[3]),nullToEmpty_OrganisationNote(save.getS3().getRis_notees()[3]));
				Path fichier_organisation=Paths.get("saves"+File.separator+repertoire+File.separator+"Organisations.txt");
				try {
					Files.write(fichier_organisation, lignes_organisation,Charset.forName("UTF-8"));
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				List<String> lignes_relations=Arrays.asList(nullToEmpty_ImportanceConsensus(save.getS4().getMtn_consensus()),nullToEmpty_Consensus(save.getS4().getMtn_consensus()),nullToEmpty_PacteConsensus(save.getS4().getMtn_consensus()),nullToEmpty_ImportanceConsensus(save.getS4().getApr_consensus()),nullToEmpty_Consensus(save.getS4().getApr_consensus()),nullToEmpty_PacteConsensus(save.getS4().getApr_consensus()),nullToEmpty_ImportanceConsensus(save.getS4().getRis_consensus()),nullToEmpty_Consensus(save.getS4().getRis_consensus()),nullToEmpty_PacteConsensus(save.getS4().getRis_consensus()),nullToEmpty_ImportanceNegociation(save.getS4().getMtn_negociation()),nullToEmpty_AjustementNegociation(save.getS4().getMtn_negociation()),nullToEmpty_TransformationNegociation(save.getS4().getMtn_negociation()),nullToEmpty_ImportanceNegociation(save.getS4().getApr_negociation()),nullToEmpty_AjustementNegociation(save.getS4().getApr_negociation()),nullToEmpty_TransformationNegociation(save.getS4().getApr_negociation()),nullToEmpty_ImportanceNegociation(save.getS4().getRis_negociation()),nullToEmpty_AjustementNegociation(save.getS4().getRis_negociation()),nullToEmpty_TransformationNegociation(save.getS4().getRis_negociation()),nullToEmpty_ImportanceOpposition(save.getS4().getMtn_opposition()),nullToEmpty_DominationOpposition(save.getS4().getMtn_opposition()),nullToEmpty_ContrePouvoirOpposition(save.getS4().getMtn_opposition()),nullToEmpty_AntagonismeOpposition(save.getS4().getMtn_opposition()),nullToEmpty_ImportanceOpposition(save.getS4().getApr_opposition()),nullToEmpty_DominationOpposition(save.getS4().getApr_opposition()),nullToEmpty_ContrePouvoirOpposition(save.getS4().getApr_opposition()),nullToEmpty_AntagonismeOpposition(save.getS4().getApr_opposition()),nullToEmpty_ImportanceOpposition(save.getS4().getRis_opposition()),nullToEmpty_DominationOpposition(save.getS4().getRis_opposition()),nullToEmpty_ContrePouvoirOpposition(save.getS4().getRis_opposition()),nullToEmpty_AntagonismeOpposition(save.getS4().getRis_opposition()));
				Path fichier_relations=Paths.get("saves"+File.separator+repertoire+File.separator+"Relations.txt");
				try {
					Files.write(fichier_relations, lignes_relations,Charset.forName("UTF-8"));
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}

				List<String> lignes_identites=Arrays.asList(nullToEmpty(save.getS5().getMtn_reglementaire()),nullToEmpty(save.getS5().getApr_reglementaire()),nullToEmpty(save.getS5().getRis_reglementaire()),nullToEmpty(save.getS5().getMtn_mobilite()),nullToEmpty(save.getS5().getApr_mobilite()),nullToEmpty(save.getS5().getRis_mobilite()),nullToEmpty(save.getS5().getMtn_pro_service_public()),nullToEmpty(save.getS5().getApr_pro_service_public()),nullToEmpty(save.getS5().getRis_pro_service_public()),nullToEmpty(save.getS5().getMtn_professionnelle()),nullToEmpty(save.getS5().getApr_professionnelle()),nullToEmpty(save.getS5().getRis_professionnelle()),nullToEmpty(save.getS5().getMtn_communautaire()),nullToEmpty(save.getS5().getApr_communautaire()),nullToEmpty(save.getS5().getRis_communautaire()),nullToEmpty(save.getS5().getMtn_entrepreneuriale()),nullToEmpty(save.getS5().getApr_entrepreneuriale()),nullToEmpty(save.getS5().getRis_entrepreneuriale()));
				Path fichier_identites=Paths.get("saves"+File.separator+repertoire+File.separator+"Identites.txt");
				try {
					Files.write(fichier_identites, lignes_identites,Charset.forName("UTF-8"));
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}

				List<String> lignes_mondes=Arrays.asList(nullToEmpty(save.getS6().getMtn()),nullToEmpty(save.getS6().getApr()),nullToEmpty(save.getS6().getRis()));
				Path fichier_mondes=Paths.get("saves"+File.separator+repertoire+File.separator+"Mondes.txt");
				try {
					Files.write(fichier_mondes, lignes_mondes,Charset.forName("UTF-8"));
				} catch (IOException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}//*/

			}

		});
		

	
		this.getBoutonBack().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(isSaved()){
					getFenetre().setTitle(ChangerConteneur.TITRE_INITIAL);
					getFenetre().setConteneur(getPrecedent());
				}else{
					if(Communication.messageAttentionChoix("Voulez-vous vraiment revenir à l'écran d'accueil ? \n Attention, vous perdrez les données non enregistrées.")==0){
						getFenetre().setTitle(ChangerConteneur.TITRE_INITIAL);
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
			this.getTabs().setTabComponentAt(i, new CustomTab(titres_tabs[i]));
			this.getTabs().getTabComponentAt(i).setForeground(Color.red);
			onglets[i].addComponentListener(new VerificationOnglets((CustomTab)this.getTabs().getTabComponentAt(i),tab_graphes[i]));
			((CustomTab) this.getTabs().getTabComponentAt(i)).setTaille(CustomTab.TAILLE);
		}
	}

	private void initialiserConteneurs()
	{
		for(int i=0;i<NB_ONGLETS;i++)
		{
			this.onglets[i] = new Conteneur(TAILLE_GRAND_CONTENEUR);
			tab_graphes[i] = new TabGraphe(i+1);
			this.onglets[i].add(tab_graphes[i]);
			this.onglets[i].setOpaque(false);
		}
	}

	// pour récupérer le conteneur dans lequel il y a l'image : on pourra ainsi récupérer les boutons et les zones de texte ! A appeler à l'aide des int MAINTENANT, APRES et RISQUE.
	public ConteneurSchema getConteneurSchema(int type, int mode)
	{
		return mode==MAINTENANT ? ((TabGraphe)((Conteneur)this.getTabs().getComponentAt(type-1)).getComponents()[0]).getConteneur_maintenant() :(mode==APRES ? ((TabGraphe)((Conteneur)this.getTabs().getComponentAt(type-1)).getComponents()[0]).getConteneur_apres() : (ConteneurSchema) ((TabGraphe)((Conteneur)this.getTabs().getComponentAt(type-1)).getComponents()[0]).getConteneur_risque());
	}
	
	public String nullToEmpty(Pourcentage p){
		return (p==null ? "" : String.valueOf(p.get()));
	}
	
	public String nullToEmpty(String s){
		return (s==null ? "" : s);
	}
	
	public String nullToEmpty(Structure str){
		return (str==null ? "":String.valueOf(str.getNumero()));
	}
	
	public String nullToEmpty_StructureName(ElementNote<Structure> str){
		return (str==null ||str.getElement()==null ? "" : String.valueOf(str.getElement().getNumero()));
	}
	
	public String nullToEmpty_StructureNote(ElementNote<Structure> str){
		return (str==null ? "" : String.valueOf(str.getNote()));
	}
	
	public String nullToEmpty(Organisation org){
		return (org==null ? "":String.valueOf(org.getNumero()));
	}
	
	public String nullToEmpty_OrganisationName(ElementNote<Organisation> org){
		return (org==null ||org.getElement()==null ? "" : String.valueOf(org.getElement().getNumero()));
	}
	
	public String nullToEmpty_OrganisationNote(ElementNote<Organisation> org){
		return (org==null ? "" : String.valueOf(org.getNote()));
	}
	
	public String nullToEmpty(Entreprise ent){
		return (ent==null ? "":ent.getNom());
	}
	
	public String nullToEmpty_ImportanceConsensus(Consensus cons){
		return (cons==null ? "":nullToEmpty(cons.getImportance()));
	}
	
	public String nullToEmpty_Consensus(Consensus cons){
		return (cons==null ? "":nullToEmpty(cons.getConsensus()));
	}
	
	public String nullToEmpty_PacteConsensus(Consensus cons){
		return (cons==null ? "":nullToEmpty(cons.getPacte()));
	}
	
	public String nullToEmpty_ImportanceNegociation(Negociation neg){
		return (neg==null ? "":nullToEmpty(neg.getImportance()));
	}
	
	public String nullToEmpty_AjustementNegociation(Negociation neg){
		return (neg==null ? "":nullToEmpty(neg.getAjustement()));
	}
	
	public String nullToEmpty_TransformationNegociation(Negociation neg){
		return (neg==null ? "":nullToEmpty(neg.getTransformation()));
	}
	
	public String nullToEmpty_ImportanceOpposition(Opposition opp){
		return (opp==null ? "":nullToEmpty(opp.getImportance()));
	}
	
	public String nullToEmpty_DominationOpposition(Opposition opp){
		return (opp==null ? "":nullToEmpty(opp.getDomination()));
	}
	
	public String nullToEmpty_ContrePouvoirOpposition(Opposition opp){
		return (opp==null ? "":nullToEmpty(opp.getContrePouvoir()));
	}
	
	public String nullToEmpty_AntagonismeOpposition(Opposition opp){
		return (opp==null ? "":nullToEmpty(opp.getAntagonisme()));
	}
}
