package graphic_interface;

import java.awt.Color;

import javax.swing.JTabbedPane;

public class TabGraphe extends JTabbedPane {

	// VARIABLES DE CLASSE //
	private Theme theme;
	
	private ConteneurAvecImage conteneur_maintenant;
	private ConteneurAvecImage conteneur_apres;
	private Conteneur conteneur_comment;
	private Conteneur conteneur_apercu;
	
	// CONSTRUCTEUR //
	
	public TabGraphe(int i, Theme theme) {
		super();
		this.conteneur_maintenant = new ConteneurAvecImage(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,theme.getSchemas()[i]);
		this.conteneur_apres = new ConteneurAvecImage(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,theme.getSchemas()[i]);
		this.conteneur_comment = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_apercu = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		
		this.theme = theme;
		
		this.add("Maintenant",this.conteneur_maintenant);
		this.add("Après",this.conteneur_apres);
		this.add("Comment remplir ?",this.conteneur_comment);
		this.add("Aperçu",this.conteneur_apercu);
		
		this.setTabComponentAt(0, new CustomTab("Maintenant",theme));
		this.getTabComponentAt(0).setForeground(Color.red);
		this.setTabComponentAt(1, new CustomTab("Après",theme));
		this.getTabComponentAt(1).setForeground(Color.red);
		this.setTabComponentAt(2, new CustomTab("Comment remplir ?",theme));
		this.setTabComponentAt(3, new CustomTab("Aperçu",theme));
	}
	
	// GETTERS //
	
	public Theme getTheme()
	{
		return this.theme;
	}

	public ConteneurAvecImage getConteneur_maintenant() {
		return conteneur_maintenant;
	}

	public ConteneurAvecImage getConteneur_apres() {
		return conteneur_apres;
	}

	public Conteneur getConteneur_comment() {
		return conteneur_comment;
	}

	public Conteneur getConteneur_apercu() {
		return conteneur_apercu;
	}
	
	// SETTERS //

}
