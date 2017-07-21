package graphic_interface;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabGraphe extends JTabbedPane {
	
	private static String[] EXPLICATIONS = {"<html>Remplissez les 4 cases de pourcentages pour maintenant <br> et pour apr�s. <br> <br> Pour �tre valide, le total des 4 pourcentages <br> doit atteindre 100%. </html>",
			"Salut",
			"Je suis",
			"L'ami",
			"De",
			"Bouffi"
	};

	// VARIABLES DE CLASSE //
	private Theme theme;

	private ConteneurSchema conteneur_maintenant;
	private ConteneurSchema conteneur_apres;
	private ConteneurSchema conteneur_risque;
	private Conteneur conteneur_comment;
	private Conteneur conteneur_apercu;

	// CONSTRUCTEUR //

	public TabGraphe(int type, Theme theme) {
		super();
		this.conteneur_maintenant = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,theme);
		this.conteneur_apres = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,theme);
		this.conteneur_risque = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,theme);
		this.conteneur_comment = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_apercu = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);

		this.theme = theme;
		
		this.initialiserCommentRemplir(type);

		this.add("Maintenant",this.conteneur_maintenant);
		this.add("Apr�s",this.conteneur_apres);
		this.add("Risque", this.conteneur_risque);
		this.add("Comment remplir ?",this.conteneur_comment);
		this.add("Aper�u",this.conteneur_apercu);

		this.setTabComponentAt(0, new CustomTab("Maintenant",theme));
		this.getTabComponentAt(0).setForeground(Color.red);
		this.setTabComponentAt(1, new CustomTab("Apr�s",theme));
		this.getTabComponentAt(1).setForeground(Color.red);
		this.setTabComponentAt(2, new CustomTab("Risque",theme));
		this.getTabComponentAt(2).setForeground(Color.red);
		this.setTabComponentAt(3, new CustomTab("Comment remplir ?",theme));
		this.setTabComponentAt(4, new CustomTab("Aper�u",theme));
		
		this.conteneur_maintenant.addComponentListener(new Verification100PourCent(type, this.conteneur_maintenant, (CustomTab) this.getTabComponentAt(0)));
		this.conteneur_apres.addComponentListener(new Verification100PourCent(type, this.conteneur_apres, (CustomTab) this.getTabComponentAt(1)));
		this.conteneur_risque.addComponentListener(new Verification100PourCent(type, this.conteneur_risque, (CustomTab) this.getTabComponentAt(2)));
	}

	// GETTERS //

	public Theme getTheme()
	{
		return this.theme;
	}

	public ConteneurSchema getConteneur_maintenant() {
		return conteneur_maintenant;
	}

	public ConteneurSchema getConteneur_apres() {
		return conteneur_apres;
	}
	
	public ConteneurSchema getConteneur_risque()
	{
		return this.conteneur_risque;
	}

	public Conteneur getConteneur_comment() {
		return conteneur_comment;
	}

	public Conteneur getConteneur_apercu() {
		return conteneur_apercu;
	}

	// SETTERS //

	// METHODES //

	private void initialiserCommentRemplir(int type)
	{
		JLabel texte = new JLabel(EXPLICATIONS[type-1]);
		texte.setFont(this.getTheme().getPoliceExplications());
		this.getConteneur_comment().add(texte);
	}

}
