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
		updateEtude(this.tab);
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

	public static void updateEtude(TabGraphe tab)
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

			if(tab.getConteneur_maintenant().getAction2().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas236 action = conteneur.getAction2();
				@SuppressWarnings("unchecked")
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
				ActionBoutonSchemas236 action = conteneur.getAction2();
				@SuppressWarnings("unchecked")
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

			ConteneurSchema conteneur_2 = (ConteneurSchema) tab.getConteneur_risque();
			@SuppressWarnings("unchecked")
			ElementNote<Structure>[] ris_notees_schema2 = new ElementNote[5];
			ris_notees_schema2[0] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur_2.getNote_simple_marche());
			ris_notees_schema2[1] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur_2.getNote_professionnelle());
			ris_notees_schema2[2] = new ElementNote<Structure>(Structure.MECANISTE, conteneur_2.getNote_mecaniste());
			ris_notees_schema2[3] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur_2.getNote_simple_centralisee());
			ris_notees_schema2[4] = new ElementNote<Structure>(Structure.ENTREPRENEURIALE, conteneur_2.getNote_entrepreneuriale());

			FenetreAccueil.etude.getS2().setRis_notees(ris_notees_schema2);
			break;

		case 3:
			try{FenetreAccueil.etude.getS3().setMtn_principale(Organisation.getByName(tab.getConteneur_maintenant().getAction3().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS3().setMtn_principale(null);}
			try{FenetreAccueil.etude.getS3().setApr_principale(Organisation.getByName(tab.getConteneur_apres().getAction3().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS3().setApr_principale(null);}
			if(tab.getConteneur_maintenant().getAction3().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas236 action = conteneur.getAction3();
				@SuppressWarnings("unchecked")
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
				ActionBoutonSchemas236 action = conteneur.getAction3();
				@SuppressWarnings("unchecked")
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

			ConteneurSchema conteneur_ris = (ConteneurSchema) tab.getConteneur_risque();
			@SuppressWarnings("unchecked")
			ElementNote<Organisation>[] ris_notees_schema3 = new ElementNote[5];
			ris_notees_schema3[0] = new ElementNote<Organisation>(Organisation.RATIONNELLE, conteneur_ris.getNote_rationnelle());
			ris_notees_schema3[1] = new ElementNote<Organisation>(Organisation.ARTISANALE, conteneur_ris.getNote_artisanale());
			ris_notees_schema3[2] = new ElementNote<Organisation>(Organisation.PERSONNALISEE, conteneur_ris.getNote_personnalisee());
			ris_notees_schema3[3] = new ElementNote<Organisation>(Organisation.PROFESSIONNELLE_PROCESS, conteneur_ris.getNote_process());
			ris_notees_schema3[4] = new ElementNote<Organisation>(Organisation.FLEXIBLE, conteneur_ris.getNote_flexible());
			FenetreAccueil.etude.getS3().setRis_notees(ris_notees_schema3);
			break;

		case 4:
			FenetreAccueil.etude.getS4().setMtn_consensus(new Consensus(tab.getConteneur_maintenant().getImportance_consensus(),tab.getConteneur_maintenant().getPetit_consensus(),tab.getConteneur_maintenant().getPetit_pacte()));
			FenetreAccueil.etude.getS4().setMtn_negociation(new Negociation(tab.getConteneur_maintenant().getImportance_negociation(), tab.getConteneur_maintenant().getPetit_ajustement(), tab.getConteneur_maintenant().getPetit_transformation()));
			FenetreAccueil.etude.getS4().setMtn_opposition(new Opposition(tab.getConteneur_maintenant().getImportance_opposition(), tab.getConteneur_maintenant().getPetit_domination(), tab.getConteneur_maintenant().getPetit_contrePouvoir(), tab.getConteneur_maintenant().getPetit_antagonisme()));

			FenetreAccueil.etude.getS4().setApr_consensus(new Consensus(tab.getConteneur_apres().getImportance_consensus(),tab.getConteneur_apres().getPetit_consensus(),tab.getConteneur_apres().getPetit_pacte()));
			FenetreAccueil.etude.getS4().setApr_negociation(new Negociation(tab.getConteneur_apres().getImportance_negociation(), tab.getConteneur_apres().getPetit_ajustement(), tab.getConteneur_apres().getPetit_transformation()));
			FenetreAccueil.etude.getS4().setApr_opposition(new Opposition(tab.getConteneur_apres().getImportance_opposition(), tab.getConteneur_apres().getPetit_domination(), tab.getConteneur_apres().getPetit_contrePouvoir(), tab.getConteneur_apres().getPetit_antagonisme()));

			FenetreAccueil.etude.getS4().setRis_consensus(new Consensus(((ConteneurSchema) tab.getConteneur_risque()).getImportance_consensus(),((ConteneurSchema) tab.getConteneur_risque()).getPetit_consensus(),((ConteneurSchema) tab.getConteneur_risque()).getPetit_pacte()));
			FenetreAccueil.etude.getS4().setRis_negociation(new Negociation(((ConteneurSchema) tab.getConteneur_risque()).getImportance_negociation(), ((ConteneurSchema) tab.getConteneur_risque()).getPetit_ajustement(), ((ConteneurSchema) tab.getConteneur_risque()).getPetit_transformation()));
			FenetreAccueil.etude.getS4().setRis_opposition(new Opposition(((ConteneurSchema) tab.getConteneur_risque()).getImportance_opposition(), ((ConteneurSchema) tab.getConteneur_risque()).getPetit_domination(), ((ConteneurSchema) tab.getConteneur_risque()).getPetit_contrePouvoir(), ((ConteneurSchema) tab.getConteneur_risque()).getPetit_antagonisme()));
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
			try{FenetreAccueil.etude.getS6().setMtn(Entreprise.getByName(tab.getConteneur_maintenant().getAction6().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS6().setMtn(null);}
			try{FenetreAccueil.etude.getS6().setApr(Entreprise.getByName(tab.getConteneur_apres().getAction6().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS6().setApr(null);}
			try{FenetreAccueil.etude.getS6().setRis(Entreprise.getByName(((ConteneurSchema) tab.getConteneur_risque()).getAction6().getBoutonSelected().getName()));} catch(NullPointerException ex) {FenetreAccueil.etude.getS6().setRis(null);}

			if(tab.getConteneur_maintenant().getAction6().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas236 action = conteneur.getAction6();
				@SuppressWarnings("unchecked")
				ElementNote<Entreprise>[] mtn_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Entreprise.COMMUNAUTE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Entreprise>(Entreprise.COMMUNAUTE, conteneur.getNote_entrep_communaute());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.DUALE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Entreprise>(Entreprise.DUALE, conteneur.getNote_entrep_duale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.MODERNISEE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Entreprise>(Entreprise.MODERNISEE, conteneur.getNote_entrep_modernisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.CRISE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Entreprise>(Entreprise.CRISE, conteneur.getNote_entrep_crise());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.BUREAUCRATIQUE.getNom()))
				{
					mtn_notees[i] = new ElementNote<Entreprise>(Entreprise.BUREAUCRATIQUE, conteneur.getNote_entrep_bureaucratique());
					i++;
				}

				FenetreAccueil.etude.getS6().setMtn_notee(mtn_notees);
			}

			if(tab.getConteneur_apres().getAction6().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_apres();
				ActionBoutonSchemas236 action = conteneur.getAction6();
				@SuppressWarnings("unchecked")
				ElementNote<Entreprise>[] apr_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Entreprise.COMMUNAUTE.getNom()))
				{
					apr_notees[i] = new ElementNote<Entreprise>(Entreprise.COMMUNAUTE, conteneur.getNote_entrep_communaute());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.DUALE.getNom()))
				{
					apr_notees[i] = new ElementNote<Entreprise>(Entreprise.DUALE, conteneur.getNote_entrep_duale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.MODERNISEE.getNom()))
				{
					apr_notees[i] = new ElementNote<Entreprise>(Entreprise.MODERNISEE, conteneur.getNote_entrep_modernisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.CRISE.getNom()))
				{
					apr_notees[i] = new ElementNote<Entreprise>(Entreprise.CRISE, conteneur.getNote_entrep_crise());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.BUREAUCRATIQUE.getNom()))
				{
					apr_notees[i] = new ElementNote<Entreprise>(Entreprise.BUREAUCRATIQUE, conteneur.getNote_entrep_bureaucratique());
					i++;
				}

				FenetreAccueil.etude.getS6().setApr_notee(apr_notees);
			}

			if(((ConteneurSchema)tab.getConteneur_risque()).getAction6().isSelected())
			{
				ConteneurSchema conteneur = (ConteneurSchema)tab.getConteneur_risque();
				ActionBoutonSchemas236 action = conteneur.getAction6();
				@SuppressWarnings("unchecked")
				ElementNote<Entreprise>[] ris_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals(Entreprise.COMMUNAUTE.getNom()))
				{
					ris_notees[i] = new ElementNote<Entreprise>(Entreprise.COMMUNAUTE, conteneur.getNote_entrep_communaute());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.DUALE.getNom()))
				{
					ris_notees[i] = new ElementNote<Entreprise>(Entreprise.DUALE, conteneur.getNote_entrep_duale());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.MODERNISEE.getNom()))
				{
					ris_notees[i] = new ElementNote<Entreprise>(Entreprise.MODERNISEE, conteneur.getNote_entrep_modernisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.CRISE.getNom()))
				{
					ris_notees[i] = new ElementNote<Entreprise>(Entreprise.CRISE, conteneur.getNote_entrep_crise());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals(Entreprise.BUREAUCRATIQUE.getNom()))
				{
					ris_notees[i] = new ElementNote<Entreprise>(Entreprise.BUREAUCRATIQUE, conteneur.getNote_entrep_bureaucratique());
					i++;
				}

				FenetreAccueil.etude.getS6().setRis_notee(ris_notees);
			}
			break;
		}
	}
}
