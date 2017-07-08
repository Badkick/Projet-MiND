package graphic_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public enum Theme {
	
	CLASSIC("Classic",0,new Font("Tahoma",Font.BOLD,16),Color.BLACK);

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
	
	// METHODES //

	private void uploadImages()
	{
		this.background = Images.importerImage(this.getNom()+File.separator+"main_background.png");
		this.icone = Images.importerImage(this.getNom()+File.separator+"main_icon.png");
		
		this.bRepos = Images.importerImage(this.getNom()+File.separator+"button_repos.png");
		this.bSurvol = Images.importerImage(this.getNom()+File.separator+"button_survol.png");
		this.bClic = Images.importerImage(this.getNom()+File.separator+"button_clic.png");
		
		this.nouveau = Images.importerIcone(this.getNom()+File.separator+"icon_new_doc.png");
		this.importation = Images.importerIcone(this.getNom()+File.separator+"icon_import.png");
		this.exportation = Images.importerIcone(this.getNom()+File.separator+"icon_export.png");
		this.settings = Images.importerIcone(this.getNom()+File.separator+"icon_settings.png");
		this.quitter = Images.importerIcone(this.getNom()+File.separator+"icon_quit.png");
	}
}
