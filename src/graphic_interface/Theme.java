package graphic_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public enum Theme {
	
	CLASSIC("Classic",0,new Font("Tahoma",Font.PLAIN,16),Color.BLACK);

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
	
	// menus
	private ImageIcon nouveau;
	private ImageIcon importation;
	private ImageIcon exportation;
	private ImageIcon settings;
	private ImageIcon quitter;
	
	// police
	private Font police;
	private Color couleurTexte;
	
	// sélection d'une étude
	private Image selectionEtude;
	
	// CONSTRUCTEURS //
	
	private Theme(String nom, int id,Font police, Color couleurTexte)
	{
		this.nom = nom;
		this.id = id;
		this.police = police;
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
	
	public Image getIcone()
	{
		return this.icone;
	}
	
	public ImageIcon getNouveau() {
		return nouveau;
	}

	public ImageIcon getImportation() {
		return importation;
	}

	public ImageIcon getExportation() {
		return exportation;
	}

	public ImageIcon getSettings() {
		return settings;
	}

	public ImageIcon getQuitter() {
		return quitter;
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
	
	// METHODES //

	private void uploadImages()
	{
		this.background = Images.importerImage(chemin()+"main_background.png");
		this.icone = Images.importerImage(chemin()+"main_icon.png");
		
		this.bRepos = Images.importerImage(chemin()+"button_repos.png");
		this.bSurvol = Images.importerImage(chemin()+"button_survol.png");
		this.bClic = Images.importerImage(chemin()+"button_clic.png");
		
		this.nouveau = Images.importerIcone(chemin()+"icon_new_doc.png");
		this.importation = Images.importerIcone(chemin()+"icon_import.png");
		this.exportation = Images.importerIcone(chemin()+"icon_export.png");
		this.settings = Images.importerIcone(chemin()+"icon_settings.png");
		this.quitter = Images.importerIcone(chemin()+"icon_quit.png");
		
		this.selectionEtude = Images.importerImage(chemin()+"select_etude.png");
	}
	
	private String chemin()
	{
		return "themes"+File.separator+this.getNom()+File.separator;
	}
}
