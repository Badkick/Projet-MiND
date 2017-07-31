package graphic_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
			if(type==2){
				this.conteneur_apercu = new ApercuSchema2(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR,null);
			}else{
				this.conteneur_apercu = new Conteneur(ConteneurNouvelleEtude.TAILLE_PETIT_CONTENEUR);
			}
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
			zoneTexte.addCaretListener(new CaretListener() {
				
				@Override
				public void caretUpdate(CaretEvent e) {
					ConteneurNouvelleEtude.unsave();					
				}
			});
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
	
	public void initialiserCases(int type){
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
			try{	
				if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==1){
					this.getConteneur_maintenant().getAction2().setSelected(true);
					this.getConteneur_maintenant().getAction2().setBoutonSelected(this.getConteneur_maintenant().getB_simple_marche());
					this.getConteneur_maintenant().getB_simple_marche().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_professionnelle(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_mecaniste(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==2){
					this.getConteneur_maintenant().getAction2().setSelected(true);
					this.getConteneur_maintenant().getAction2().setBoutonSelected(this.getConteneur_maintenant().getB_professionnelle());
					this.getConteneur_maintenant().getB_professionnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_marche(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_mecaniste(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==3){
					this.getConteneur_maintenant().getAction2().setSelected(true);
					this.getConteneur_maintenant().getAction2().setBoutonSelected(this.getConteneur_maintenant().getB_mecaniste());
					this.getConteneur_maintenant().getB_mecaniste().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_marche(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_professionnelle(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==4){
					this.getConteneur_maintenant().getAction2().setSelected(true);
					this.getConteneur_maintenant().getAction2().setBoutonSelected(this.getConteneur_maintenant().getB_simple_centralisee());
					this.getConteneur_maintenant().getB_simple_centralisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_marche(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_professionnelle(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_mecaniste(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==5){
					this.getConteneur_maintenant().getAction2().setSelected(true);
					this.getConteneur_maintenant().getAction2().setBoutonSelected(this.getConteneur_maintenant().getB_entrepreneuriale());
					this.getConteneur_maintenant().getB_entrepreneuriale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_marche(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_professionnelle(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_mecaniste(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			try{	
				if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
					this.getConteneur_apres().getAction2().setSelected(true);
					this.getConteneur_apres().getAction2().setBoutonSelected(this.getConteneur_apres().getB_simple_marche());
					this.getConteneur_apres().getB_simple_marche().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_professionnelle(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_mecaniste(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
					this.getConteneur_apres().getAction2().setSelected(true);
					this.getConteneur_apres().getAction2().setBoutonSelected(this.getConteneur_apres().getB_professionnelle());
					this.getConteneur_apres().getB_professionnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_marche(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_mecaniste(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
					this.getConteneur_apres().getAction2().setSelected(true);
					this.getConteneur_apres().getAction2().setBoutonSelected(this.getConteneur_apres().getB_mecaniste());
					this.getConteneur_apres().getB_mecaniste().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_marche(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_professionnelle(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
					this.getConteneur_apres().getAction2().setSelected(true);
					this.getConteneur_apres().getAction2().setBoutonSelected(this.getConteneur_apres().getB_simple_centralisee());
					this.getConteneur_apres().getB_simple_centralisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_marche(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_professionnelle(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_mecaniste(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
					this.getConteneur_apres().getAction2().setSelected(true);
					this.getConteneur_apres().getAction2().setBoutonSelected(this.getConteneur_apres().getB_entrepreneuriale());
					this.getConteneur_apres().getB_entrepreneuriale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_marche(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_professionnelle(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_mecaniste(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_simple_centralisee(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			try{	
				ConteneurSchema cont=(ConteneurSchema) this.getConteneur_risque();
				if(FenetreAccueil.etude.getS2().getRis_principale().getNumero()==1){
					cont.getAction2().setSelected(true);
					cont.getAction2().setBoutonSelected(cont.getB_simple_marche());
					cont.getB_simple_marche().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_professionnelle(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_mecaniste(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_centralisee(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getRis_principale().getNumero()==2){
					cont.getAction2().setSelected(true);
					cont.getAction2().setBoutonSelected(cont.getB_professionnelle());
					cont.getB_professionnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_marche(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_mecaniste(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_centralisee(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getRis_principale().getNumero()==3){
					cont.getAction2().setSelected(true);
					cont.getAction2().setBoutonSelected(cont.getB_mecaniste());
					cont.getB_mecaniste().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_marche(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_professionnelle(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_centralisee(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getRis_principale().getNumero()==4){
					cont.getAction2().setSelected(true);
					cont.getAction2().setBoutonSelected(cont.getB_simple_centralisee());
					cont.getB_simple_centralisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_marche(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_professionnelle(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_mecaniste(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_entrepreneuriale(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS2().getRis_principale().getNumero()==5){
					cont.getAction2().setSelected(true);
					cont.getAction2().setBoutonSelected(cont.getB_entrepreneuriale());
					cont.getB_entrepreneuriale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_marche(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_professionnelle(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_mecaniste(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_simple_centralisee(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			break;
		case 3:
			try{	
				if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==1){
					this.getConteneur_maintenant().getAction3().setSelected(true);
					this.getConteneur_maintenant().getAction3().setBoutonSelected(this.getConteneur_maintenant().getB_rationnelle());
					this.getConteneur_maintenant().getB_rationnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_artisanale(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_personnalisee(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_process(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_flexible(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==2){
					this.getConteneur_maintenant().getAction3().setSelected(true);
					this.getConteneur_maintenant().getAction3().setBoutonSelected(this.getConteneur_maintenant().getB_artisanale());
					this.getConteneur_maintenant().getB_artisanale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_rationnelle(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_personnalisee(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_process(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_flexible(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==3){
					this.getConteneur_maintenant().getAction3().setSelected(true);
					this.getConteneur_maintenant().getAction3().setBoutonSelected(this.getConteneur_maintenant().getB_personnalisee());
					this.getConteneur_maintenant().getB_personnalisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_rationnelle(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_artisanale(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_process(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_flexible(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==4){
					this.getConteneur_maintenant().getAction3().setSelected(true);
					this.getConteneur_maintenant().getAction3().setBoutonSelected(this.getConteneur_maintenant().getB_process());
					this.getConteneur_maintenant().getB_process().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_rationnelle(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_artisanale(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_personnalisee(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_flexible(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==5){
					this.getConteneur_maintenant().getAction3().setSelected(true);
					this.getConteneur_maintenant().getAction3().setBoutonSelected(this.getConteneur_maintenant().getB_flexible());
					this.getConteneur_maintenant().getB_flexible().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_rationnelle(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_artisanale(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_personnalisee(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_maintenant().setNote_process(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			try{	
				if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
					this.getConteneur_apres().getAction3().setSelected(true);
					this.getConteneur_apres().getAction3().setBoutonSelected(this.getConteneur_apres().getB_rationnelle());
					this.getConteneur_apres().getB_rationnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_artisanale(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_personnalisee(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_process(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_flexible(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
					this.getConteneur_apres().getAction3().setSelected(true);
					this.getConteneur_apres().getAction3().setBoutonSelected(this.getConteneur_apres().getB_artisanale());
					this.getConteneur_apres().getB_artisanale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_rationnelle(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_personnalisee(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_process(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_flexible(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
					this.getConteneur_apres().getAction3().setSelected(true);
					this.getConteneur_apres().getAction3().setBoutonSelected(this.getConteneur_apres().getB_personnalisee());
					this.getConteneur_apres().getB_personnalisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_rationnelle(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_artisanale(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_process(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_flexible(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
					this.getConteneur_apres().getAction3().setSelected(true);
					this.getConteneur_apres().getAction3().setBoutonSelected(this.getConteneur_apres().getB_process());
					this.getConteneur_apres().getB_process().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_rationnelle(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_artisanale(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_personnalisee(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_flexible(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
					this.getConteneur_apres().getAction3().setSelected(true);
					this.getConteneur_apres().getAction3().setBoutonSelected(this.getConteneur_apres().getB_flexible());
					this.getConteneur_apres().getB_flexible().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_rationnelle(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_artisanale(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_personnalisee(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						this.getConteneur_apres().setNote_process(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			try{	
				ConteneurSchema cont=(ConteneurSchema) this.getConteneur_risque();
				if(FenetreAccueil.etude.getS3().getRis_principale().getNumero()==1){
					cont.getAction3().setSelected(true);
					cont.getAction3().setBoutonSelected(cont.getB_rationnelle());
					cont.getB_rationnelle().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_artisanale(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_personnalisee(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_process(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_flexible(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getRis_principale().getNumero()==2){
					cont.getAction3().setSelected(true);
					cont.getAction3().setBoutonSelected(cont.getB_artisanale());
					cont.getB_artisanale().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_rationnelle(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_personnalisee(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_process(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_flexible(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getRis_principale().getNumero()==3){
					cont.getAction3().setSelected(true);
					cont.getAction3().setBoutonSelected(cont.getB_personnalisee());
					cont.getB_personnalisee().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_rationnelle(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_artisanale(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_process(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_flexible(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getRis_principale().getNumero()==4){
					cont.getAction3().setSelected(true);
					cont.getAction3().setBoutonSelected(cont.getB_process());
					cont.getB_process().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_rationnelle(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_artisanale(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_personnalisee(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_flexible(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote());
					}
				}else if(FenetreAccueil.etude.getS3().getRis_principale().getNumero()==5){
					cont.getAction3().setSelected(true);
					cont.getAction3().setBoutonSelected(cont.getB_flexible());
					cont.getB_flexible().desactiver(FenetreAccueil.theme.getbSchema2Survol());
					if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
						cont.setNote_rationnelle(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
						cont.setNote_artisanale(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
						cont.setNote_personnalisee(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote());
					}
					if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
						cont.setNote_process(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote());
					}
				}
			}catch(NullPointerException ex){}
			break;
		case 4:
			break;
		case 5:
			try{
				this.getConteneur_maintenant().setContr_tech(FenetreAccueil.etude.getS1().getMtn_contr_tech());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setReglementaire(FenetreAccueil.etude.getS5().getMtn_reglementaire());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setMobilite(FenetreAccueil.etude.getS5().getMtn_mobilite());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setPro_service_public(FenetreAccueil.etude.getS5().getMtn_pro_service_public());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setProfessionnelle(FenetreAccueil.etude.getS5().getMtn_professionnelle());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setCommunautaire(FenetreAccueil.etude.getS5().getMtn_communautaire());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_maintenant().setEntrepreneuriale(FenetreAccueil.etude.getS5().getMtn_entrepreneuriale());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setReglementaire(FenetreAccueil.etude.getS5().getApr_reglementaire());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setMobilite(FenetreAccueil.etude.getS5().getApr_mobilite());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setPro_service_public(FenetreAccueil.etude.getS5().getApr_pro_service_public());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setProfessionnelle(FenetreAccueil.etude.getS5().getApr_professionnelle());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setCommunautaire(FenetreAccueil.etude.getS5().getApr_communautaire());
			}catch(NullPointerException ex){}
			try{
				this.getConteneur_apres().setEntrepreneuriale(FenetreAccueil.etude.getS5().getApr_entrepreneuriale());
			}catch(NullPointerException ex){}
			ConteneurSchema cont=(ConteneurSchema) this.getConteneur_risque();
			try{
				cont.setReglementaire(FenetreAccueil.etude.getS5().getRis_reglementaire());
			}catch(NullPointerException ex){}
			try{
				cont.setMobilite(FenetreAccueil.etude.getS5().getRis_mobilite());
			}catch(NullPointerException ex){}
			try{
				cont.setPro_service_public(FenetreAccueil.etude.getS5().getRis_pro_service_public());
			}catch(NullPointerException ex){}
			try{
				cont.setProfessionnelle(FenetreAccueil.etude.getS5().getRis_professionnelle());
			}catch(NullPointerException ex){}
			try{
				cont.setCommunautaire(FenetreAccueil.etude.getS5().getRis_communautaire());
			}catch(NullPointerException ex){}
			try{
				cont.setEntrepreneuriale(FenetreAccueil.etude.getS5().getRis_entrepreneuriale());
			}catch(NullPointerException ex){}
			break;
		case 6:
			break;
		}
	}
	

}
