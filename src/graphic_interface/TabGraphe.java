package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabGraphe extends JTabbedPane {

	private static String[] EXPLICATIONS = {"<html>Remplissez les 4 cases de pourcentages pour maintenant <br> et pour après. <br> <br> Pour être valide, le total des 4 pourcentages <br> doit atteindre 100%. </html>",
			"Salut",
			"Je suis",
			"L'ami",
			"De",
			"Bouffi"
	};

	// VARIABLES DE CLASSE //
	private int type;

	private ConteneurSchema conteneur_maintenant;
	private ConteneurSchema conteneur_apres;
	private ConteneurSchema conteneur_risque;
	private Conteneur conteneur_comment;
	private Conteneur conteneur_apercu;
	private Conteneur conteneur_risque_schema1;
	
	private JTextField zoneTexte;

	// CONSTRUCTEUR //

	public TabGraphe(int type) {
		super();
		this.type = type;
		
		this.conteneur_maintenant = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_apres = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_comment = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		//this.conteneur_apercu = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_risque = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);

		this.initialiserCommentRemplir(type);

		if(type!=1)
		{
			this.conteneur_apercu = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
			this.add("Maintenant",this.conteneur_maintenant);
			this.add("Après",this.conteneur_apres);
			this.add("Risque", this.conteneur_risque);
			this.add("Comment remplir ?",this.conteneur_comment);
			this.add("Aperçu",this.conteneur_apercu);
			
			this.setTabComponentAt(2, new CustomTab("Risque"));
			this.getTabComponentAt(2).setForeground(Color.red);
			this.setTabComponentAt(3, new CustomTab("Comment remplir ?"));
			this.setTabComponentAt(4, new CustomTab("Aperçu"));

			this.conteneur_risque.addComponentListener(new Verification100PourCent(this.conteneur_risque, (CustomTab) this.getTabComponentAt(2)));
			this.conteneur_risque.addComponentListener(new UpdateEtude(this));
		}
		else
		{
			this.conteneur_apercu=new ApercuSchema1(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,null);
			this.conteneur_risque_schema1 = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
			this.add("Maintenant",this.conteneur_maintenant);
			this.add("Après",this.conteneur_apres);
			this.add("Encore après", this.conteneur_risque);
			this.add("Risque", this.conteneur_risque_schema1);
			this.add("Comment remplir ?",this.conteneur_comment);
			this.add("Aperçu",this.conteneur_apercu);
			
			this.setTabComponentAt(2, new CustomTab("Encore après"));
			this.getTabComponentAt(2).setForeground(Color.red);
			this.setTabComponentAt(3, new CustomTab("Risque"));
			this.setTabComponentAt(4, new CustomTab("Comment remplir ?"));
			this.setTabComponentAt(5, new CustomTab("Aperçu"));
			
			zoneTexte = new JTextField();
			Dimension tailleZoneTexte = new Dimension(300,300);
			zoneTexte.setPreferredSize(tailleZoneTexte);
			zoneTexte.setMinimumSize(tailleZoneTexte);
			zoneTexte.setMaximumSize(tailleZoneTexte);
			zoneTexte.setFont(FenetreAccueil.theme.getPolice());
			this.conteneur_risque_schema1.add(zoneTexte);
			this.conteneur_risque_schema1.addComponentListener(new UpdateEtude(this));
			
		}
		
		this.setTabComponentAt(0, new CustomTab("Maintenant"));
		this.getTabComponentAt(0).setForeground(Color.red);
		this.setTabComponentAt(1, new CustomTab("Après"));
		this.getTabComponentAt(1).setForeground(Color.red);
		
		this.conteneur_maintenant.addComponentListener(new Verification100PourCent(this.conteneur_maintenant, (CustomTab) this.getTabComponentAt(0)));
		this.conteneur_maintenant.addComponentListener(new UpdateEtude(this));
		this.conteneur_apres.addComponentListener(new Verification100PourCent(this.conteneur_apres, (CustomTab) this.getTabComponentAt(1)));
		this.conteneur_apres.addComponentListener(new UpdateEtude(this));
	}

	// GETTERS //
	
	public ConteneurSchema getConteneur_maintenant() {
		return conteneur_maintenant;
	}

	public ConteneurSchema getConteneur_apres() {
		return conteneur_apres;
	}
	
	public ConteneurSchema getConteneur_encore_apres() {
		return (this.type!=1) ? null : this.conteneur_risque;
	}

	public Conteneur getConteneur_risque() {
		return (this.type!=1) ? this.conteneur_risque : this.conteneur_risque_schema1;
	}

	public Conteneur getConteneur_comment() {
		return conteneur_comment;
	}

	public Conteneur getConteneur_apercu() {
		return conteneur_apercu;
	}
	
	public JTextField getZoneTexte() {
		return zoneTexte;
	}
	
	public String getCommentaireRisque() {
		return this.getZoneTexte().getText();
	}

	// SETTERS //

	// METHODES //

	private void initialiserCommentRemplir(int type)
	{
		JLabel texte = new JLabel(EXPLICATIONS[type-1]);
		texte.setFont(FenetreAccueil.theme.getPoliceExplications());
		this.getConteneur_comment().add(texte);
	}

}
