package graphic_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
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
	
	private JTextArea zoneTexte;

	// CONSTRUCTEUR //

	public TabGraphe(int type) {
		super();
		this.type = type;
		
		this.conteneur_maintenant = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_apres = new ConteneurSchema(type,ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
		this.conteneur_comment = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
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
			
			zoneTexte = new JTextArea();
			Dimension tailleZoneTexte = new Dimension(300,300);
			zoneTexte.setPreferredSize(tailleZoneTexte);
			zoneTexte.setMinimumSize(tailleZoneTexte);
			zoneTexte.setMaximumSize(tailleZoneTexte);
			zoneTexte.setWrapStyleWord(true);
			zoneTexte.setLineWrap(true);
			zoneTexte.setFont(FenetreAccueil.theme.getPolice().deriveFont(30f));
			this.conteneur_risque_schema1.setLayout(new BorderLayout());
			JLabel titre = new JLabel("Entrez votre commentaire dans la zone ci-dessous :");
			titre.setHorizontalAlignment(CENTER);
			titre.setFont(FenetreAccueil.theme.getPolice().deriveFont(35f));
			this.conteneur_risque_schema1.add(titre,BorderLayout.NORTH);
			this.conteneur_risque_schema1.add(zoneTexte);
			this.conteneur_risque_schema1.addComponentListener(new UpdateEtude(this));
			
		}
		
		this.setTabComponentAt(0, new CustomTab("Maintenant"));
		this.getTabComponentAt(0).setForeground(Color.red);
		this.setTabComponentAt(1, new CustomTab("Après"));
		this.getTabComponentAt(1).setForeground(Color.red);
		
		this.conteneur_maintenant.addComponentListener(new VerificationPetitsOnglets(this.conteneur_maintenant, (CustomTab) this.getTabComponentAt(0)));
		this.conteneur_maintenant.addComponentListener(new UpdateEtude(this));
		this.conteneur_apres.addComponentListener(new VerificationPetitsOnglets(this.conteneur_apres, (CustomTab) this.getTabComponentAt(1)));
		this.conteneur_apres.addComponentListener(new UpdateEtude(this));
		this.conteneur_risque.addComponentListener(new VerificationPetitsOnglets(this.conteneur_risque, (CustomTab) this.getTabComponentAt(2)));
		this.conteneur_risque.addComponentListener(new UpdateEtude(this));
		for (int i=1;i<=6;i++){
			this.initialiserCases(i);
		}
		
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
	
	public JTextArea getZoneTexte() {
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
	
	private void initialiserCases(int type){
		switch(type){
		case 1:
			try{
				this.getConteneur_maintenant().setContr_tech(FenetreAccueil.etude.getS1().getMtn_contr_tech());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setEtabl_prot(FenetreAccueil.etude.getS1().getMtn_etabl_prot());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setMena_mar(FenetreAccueil.etude.getS1().getMtn_mena_mar());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setPress_envir(FenetreAccueil.etude.getS1().getMtn_press_envir());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setContr_tech(FenetreAccueil.etude.getS1().getApr_contr_tech());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setEtabl_prot(FenetreAccueil.etude.getS1().getApr_etabl_prot());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setMena_mar(FenetreAccueil.etude.getS1().getApr_mena_mar());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setPress_envir(FenetreAccueil.etude.getS1().getApr_press_envir());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_encore_apres().setContr_tech(FenetreAccueil.etude.getS1().getRis_contr_tech());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_encore_apres().setEtabl_prot(FenetreAccueil.etude.getS1().getRis_etabl_prot());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_encore_apres().setMena_mar(FenetreAccueil.etude.getS1().getRis_mena_mar());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_encore_apres().setPress_envir(FenetreAccueil.etude.getS1().getRis_press_envir());
			}catch(NullPointerException ex){}
			try{
				this.getZoneTexte().setText(FenetreAccueil.etude.getS1().getCommentaire_risque());
			}catch(NullPointerException ex){}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	

}
