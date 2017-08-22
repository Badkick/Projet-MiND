package graphic_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;


public enum Theme {
	
	CLASSIC("Classic",0,new Font("Tahoma",Font.PLAIN,16),Color.BLACK),
	NIGHT("Night",1,new Font("Calibri",Font.PLAIN,16),Color.WHITE);

	// VARIABLES DE CLASSE //
	
	private String nom;
	private int id;
	
	// général
	private Image background;
	private Image icone;
	
	// boutons
	private Image bRepos;
	private Image bSurvol;
	private Image bClic;
	
	private Image bSchema2Repos;
	private Image bSchema2Survol;
	
	private Image bSchema6Repos;
	private Image bSchema6Survol;
	private Image bSchema6Clic;
	
	// police
	private Font police;
	private Color couleurTexte;
	private Font policeExplications;
	
	// sélection d'une étude
	private Image selectionEtude;
	
	// tabs
	private Image tab;
	private Image schema1;
	private Image schema2;
	private Image schema3;
	private Image schema4;
	private Image schema5;
	private Image schema6;
	private Image[] schemas = new Image[6];
	
	// CONSTRUCTEURS //
	
	private Theme(String nom, int id,Font police, Color couleurTexte)
	{
		this.nom = nom;
		this.id = id;
		this.police = police;
		this.policeExplications = new Font("Tahoma", Font.PLAIN, 20);
		this.couleurTexte = couleurTexte;
		
		this.uploadImages();
	}
	
	// GETTERS //

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}
	
	public Image getBackground()
	{
		return this.background;
	}
	
	public Image getBRepos()
	{
		return this.bRepos;
	}
	
	public Image getBSurvol()
	{
		return this.bSurvol;
	}
	
	public Image getBClic()
	{
		return this.bClic;
	}
	
	public Image getbSchema2Repos() {
		return this.bSchema2Repos;
	}

	public Image getbSchema2Survol() {
		return this.bSchema2Survol;
	}
	
	public Image getbSchema2Clic() {
		return this.bSchema2Survol;
	}
	
	public Image getbSchema6Repos() {
		return this.bSchema6Repos;
	}

	public Image getbSchema6Survol() {
		return this.bSchema6Survol;
	}
	
	public Image getbSchema6Clic() {
		return this.bSchema6Clic;
	}

	public Image getIcone()
	{
		return this.icone;
	}
	
	public Font getPolice()
	{
		return this.police;
	}
	
	public Color getCouleurTexte()
	{
		return this.couleurTexte;
	}
	
	public Image getSelectionEtude()
	{
		return this.selectionEtude;
	}
	
	public Image getTab()
	{
		return this.tab;
	}
	
	public Image getSchema1()
	{
		return this.schema1;
	}
	
	public Image getSchema2()
	{
		return this.schema2;
	}
	
	public Image getSchema3()
	{
		return this.schema3;
	}
	
	public Image getSchema4()
	{
		return this.schema4;
	}
	
	public Image getSchema5()
	{
		return this.schema5;
	}
	
	public Image getSchema6()
	{
		return this.schema6;
	}
	
	public Image[] getSchemas()
	{
		return this.schemas;
	}
	
	public Font getPoliceExplications()
	{
		return this.policeExplications;
	}
	
	// METHODES //

	private void uploadImages()
	{
		this.background = Images.importerImage(chemin()+"main_background.png");
		this.icone = Images.importerImage(chemin()+"main_icon.png");
		
		this.bRepos = Images.importerImage(chemin()+"button_repos.png");
		this.bSurvol = Images.importerImage(chemin()+"button_survol.png");
		this.bClic = Images.importerImage(chemin()+"button_clic.png");
		
		this.bSchema2Repos = Images.importerImage(chemin()+"button_schema2_repos.png");
		this.bSchema2Survol = Images.importerImage(chemin()+"button_schema2_survol.png");
		
		this.bSchema6Repos = Images.importerImage(chemin()+"button_schema6_repos.png");
		this.bSchema6Survol = Images.importerImage(chemin()+"button_schema6_survol.png");
		this.bSchema6Clic = Images.importerImage(chemin()+"button_schema6_clic.png");
		
		this.selectionEtude = Images.importerImage(chemin()+"select_etude.png");
		
		this.tab = Images.importerImage(chemin()+"tab.png");
		this.schema1 = Images.importerImage(chemin()+"schema1.png");
		this.schema2 = Images.importerImage(chemin()+"schema2.png");
		this.schema3 = Images.importerImage(chemin()+"schema3.png");
		this.schema4 = Images.importerImage(chemin()+"schema4.png");
		this.schema5 = Images.importerImage(chemin()+"schema5.png");
		this.schema6 = Images.importerImage(chemin()+"schema6.png");
		
		this.schemas[0] = this.getSchema1();
		this.schemas[1] = this.getSchema2();
		this.schemas[2] = this.getSchema3();
		this.schemas[3] = this.getSchema4();
		this.schemas[4] = this.getSchema5();
		this.schemas[5] = this.getSchema6();
	}
	
	private String chemin()
	{
		return "themes"+File.separator+this.getNom()+File.separator;
	}
}
