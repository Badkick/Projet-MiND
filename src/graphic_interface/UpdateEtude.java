package graphic_interface;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class UpdateEtude implements ComponentListener {

	private TabGraphe tab;

	public UpdateEtude(TabGraphe tab) {
		this.tab = tab;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		this.updateEtude(this.tab);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void updateEtude(TabGraphe tab)
	{
		int type = tab.getConteneur_maintenant().getTypeSchema();
		switch(type)
		{
		case 1:
			FenetreAccueil.etude.getS1().setMtn_contr_tech(tab.getConteneur_maintenant().getContr_tech());
			FenetreAccueil.etude.getS1().setMtn_etabl_prot(tab.getConteneur_maintenant().getEtabl_prot());
			FenetreAccueil.etude.getS1().setMtn_mena_mar(tab.getConteneur_maintenant().getMena_mar());
			FenetreAccueil.etude.getS1().setMtn_press_envir(tab.getConteneur_maintenant().getPress_envir());
			
			FenetreAccueil.etude.getS1().setApr_contr_tech(tab.getConteneur_apres().getContr_tech());
			FenetreAccueil.etude.getS1().setApr_etabl_prot(tab.getConteneur_apres().getEtabl_prot());
			FenetreAccueil.etude.getS1().setApr_mena_mar(tab.getConteneur_apres().getMena_mar());
			FenetreAccueil.etude.getS1().setApr_press_envir(tab.getConteneur_apres().getPress_envir());
			
			FenetreAccueil.etude.getS1().setRis_contr_tech(((ConteneurSchema) tab.getConteneur_encore_apres()).getContr_tech());
			FenetreAccueil.etude.getS1().setRis_etabl_prot(((ConteneurSchema) tab.getConteneur_encore_apres()).getEtabl_prot());
			FenetreAccueil.etude.getS1().setRis_mena_mar(((ConteneurSchema) tab.getConteneur_encore_apres()).getMena_mar());
			FenetreAccueil.etude.getS1().setRis_press_envir(((ConteneurSchema) tab.getConteneur_encore_apres()).getPress_envir());
			
			FenetreAccueil.etude.getS1().setCommentaire_risque(tab.getCommentaireRisque());
			break;

		case 2:
			try{FenetreAccueil.etude.getS2().setMtn_principale(Structure.getByName(tab.getConteneur_maintenant().getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS2().setMtn_principale(null);}
			try{FenetreAccueil.etude.getS2().setApr_principale(Structure.getByName(tab.getConteneur_apres().getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS2().setApr_principale(null);}
			try{FenetreAccueil.etude.getS2().setRis_principale(Structure.getByName(((ConteneurSchema) tab.getConteneur_risque()).getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS2().setRis_principale(null);}

			if(tab.getConteneur_maintenant().getAction2().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas23 action = conteneur.getAction2();
				ElementNote<Structure>[] mtn_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_MARCHE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.PROFESSIONNELLE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.MECANISTE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_CENTRALISEE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.ENTREPRENEURIALE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.ENTREPRENEURIALE, conteneur.getNote_entrepreneuriale());
					i++;
				}
				
				FenetreAccueil.etude.getS2().setMtn_notees(mtn_notees);
			}
			
			if(tab.getConteneur_apres().getAction2().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_apres();
				ActionBoutonSchemas23 action = conteneur.getAction2();
				ElementNote<Structure>[] apr_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_MARCHE.getNom()))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.PROFESSIONNELLE.getNom()))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.MECANISTE.getNom()))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_CENTRALISEE.getNom()))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.ENTREPRENEURIALE.getNom()))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.ENTREPRENEURIALE, conteneur.getNote_entrepreneuriale());
					i++;
				}
				
				FenetreAccueil.etude.getS2().setApr_notees(apr_notees);
			}
			
			if(((ConteneurSchema)tab.getConteneur_risque()).getAction2().isSelected())
			{
				ConteneurSchema conteneur = (ConteneurSchema) tab.getConteneur_risque();
				ActionBoutonSchemas23 action = conteneur.getAction2();
				ElementNote<Structure>[] ris_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_MARCHE.getNom()))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.PROFESSIONNELLE.getNom()))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.MECANISTE.getNom()))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.SIMPLE_CENTRALISEE.getNom()))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Structure.ENTREPRENEURIALE.getNom()))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.ENTREPRENEURIALE, conteneur.getNote_entrepreneuriale());
					i++;
				}
				
				FenetreAccueil.etude.getS2().setRis_notees(ris_notees);
			}
			break;
			
		case 3:
			try{FenetreAccueil.etude.getS3().setMtn_principale(Organisation.getByName(tab.getConteneur_maintenant().getAction3().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS3().setMtn_principale(null);}
			try{FenetreAccueil.etude.getS3().setApr_principale(Organisation.getByName(tab.getConteneur_apres().getAction3().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS3().setApr_principale(null);}
			try{FenetreAccueil.etude.getS3().setRis_principale(Organisation.getByName(((ConteneurSchema) tab.getConteneur_risque()).getAction3().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS3().setRis_principale(null);}

			if(tab.getConteneur_maintenant().getAction3().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas23 action = conteneur.getAction3();
				ElementNote<Organisation>[] mtn_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Organisation.RATIONNELLE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Organisation>(Organisation.RATIONNELLE, conteneur.getNote_rationnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.ARTISANALE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Organisation>(Organisation.ARTISANALE, conteneur.getNote_artisanale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PERSONNALISEE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Organisation>(Organisation.PERSONNALISEE, conteneur.getNote_personnalisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PROFESSIONNELLE_PROCESS.getNom()))
				{
					mtn_notees[i] = new ElementNote<Organisation>(Organisation.PROFESSIONNELLE_PROCESS, conteneur.getNote_process());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.FLEXIBLE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Organisation>(Organisation.FLEXIBLE, conteneur.getNote_flexible());
					i++;
				}
				
				FenetreAccueil.etude.getS3().setMtn_notees(mtn_notees);
			}
			
			if(tab.getConteneur_apres().getAction3().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_apres();
				ActionBoutonSchemas23 action = conteneur.getAction3();
				ElementNote<Organisation>[] apr_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Organisation.RATIONNELLE.getNom()))
				{
					apr_notees[i] = new ElementNote<Organisation>(Organisation.RATIONNELLE, conteneur.getNote_rationnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.ARTISANALE.getNom()))
				{
					apr_notees[i] = new ElementNote<Organisation>(Organisation.ARTISANALE, conteneur.getNote_artisanale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PERSONNALISEE.getNom()))
				{
					apr_notees[i] = new ElementNote<Organisation>(Organisation.PERSONNALISEE, conteneur.getNote_personnalisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PROFESSIONNELLE_PROCESS.getNom()))
				{
					apr_notees[i] = new ElementNote<Organisation>(Organisation.PROFESSIONNELLE_PROCESS, conteneur.getNote_process());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.FLEXIBLE.getNom()))
				{
					apr_notees[i] = new ElementNote<Organisation>(Organisation.FLEXIBLE, conteneur.getNote_flexible());
					i++;
				}
				
				FenetreAccueil.etude.getS3().setApr_notees(apr_notees);
			}
			
			if(((ConteneurSchema)tab.getConteneur_risque()).getAction3().isSelected())
			{
				ConteneurSchema conteneur = (ConteneurSchema) tab.getConteneur_risque();
				ActionBoutonSchemas23 action = conteneur.getAction3();
				ElementNote<Organisation>[] ris_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Organisation.RATIONNELLE.getNom()))
				{
					ris_notees[i] = new ElementNote<Organisation>(Organisation.RATIONNELLE, conteneur.getNote_rationnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.ARTISANALE.getNom()))
				{
					ris_notees[i] = new ElementNote<Organisation>(Organisation.ARTISANALE, conteneur.getNote_artisanale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PERSONNALISEE.getNom()))
				{
					ris_notees[i] = new ElementNote<Organisation>(Organisation.PERSONNALISEE, conteneur.getNote_personnalisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.PROFESSIONNELLE_PROCESS.getNom()))
				{
					ris_notees[i] = new ElementNote<Organisation>(Organisation.PROFESSIONNELLE_PROCESS, conteneur.getNote_process());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Organisation.FLEXIBLE.getNom()))
				{
					ris_notees[i] = new ElementNote<Organisation>(Organisation.FLEXIBLE, conteneur.getNote_flexible());
					i++;
				}
				
				FenetreAccueil.etude.getS3().setRis_notees(ris_notees);
			}
			break;
			
		case 4:
			
			break;
			
		case 5:
			FenetreAccueil.etude.getS5().setMtn_reglementaire(tab.getConteneur_maintenant().getReglementaire());
			FenetreAccueil.etude.getS5().setMtn_mobilite(tab.getConteneur_maintenant().getMobilite());
			FenetreAccueil.etude.getS5().setMtn_pro_service_public(tab.getConteneur_maintenant().getPro_service_public());
			FenetreAccueil.etude.getS5().setMtn_professionnelle(tab.getConteneur_maintenant().getProfessionnelle());
			FenetreAccueil.etude.getS5().setMtn_communautaire(tab.getConteneur_maintenant().getCommunautaire());
			FenetreAccueil.etude.getS5().setMtn_entrepreneuriale(tab.getConteneur_maintenant().getEntrepreneuriale());
			
			FenetreAccueil.etude.getS5().setApr_reglementaire(tab.getConteneur_apres().getReglementaire());
			FenetreAccueil.etude.getS5().setApr_mobilite(tab.getConteneur_apres().getMobilite());
			FenetreAccueil.etude.getS5().setApr_pro_service_public(tab.getConteneur_apres().getPro_service_public());
			FenetreAccueil.etude.getS5().setApr_professionnelle(tab.getConteneur_apres().getProfessionnelle());
			FenetreAccueil.etude.getS5().setApr_communautaire(tab.getConteneur_apres().getCommunautaire());
			FenetreAccueil.etude.getS5().setApr_entrepreneuriale(tab.getConteneur_apres().getEntrepreneuriale());
			
			FenetreAccueil.etude.getS5().setRis_reglementaire(((ConteneurSchema) tab.getConteneur_risque()).getReglementaire());
			FenetreAccueil.etude.getS5().setRis_mobilite(((ConteneurSchema) tab.getConteneur_risque()).getMobilite());
			FenetreAccueil.etude.getS5().setRis_pro_service_public(((ConteneurSchema) tab.getConteneur_risque()).getPro_service_public());
			FenetreAccueil.etude.getS5().setRis_professionnelle(((ConteneurSchema) tab.getConteneur_risque()).getProfessionnelle());
			FenetreAccueil.etude.getS5().setRis_communautaire(((ConteneurSchema) tab.getConteneur_risque()).getCommunautaire());
			FenetreAccueil.etude.getS5().setRis_entrepreneuriale(((ConteneurSchema) tab.getConteneur_risque()).getEntrepreneuriale());
			break;
			
		case 6:
			
			break;
		}
	}

}
