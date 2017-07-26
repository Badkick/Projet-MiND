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
			//try {FenetreAccueil.etude.getS1().setMtn_contr_tech(tab.getConteneur_maintenant().getContr_tech());} catch(NullPointerException ex) {}
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
			try{FenetreAccueil.etude.getS2().setMtn_principale(Structure.getByName(tab.getConteneur_maintenant().getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {}
			try{FenetreAccueil.etude.getS2().setApr_principale(Structure.getByName(tab.getConteneur_apres().getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {}
			try{FenetreAccueil.etude.getS2().setRis_principale(Structure.getByName(((ConteneurSchema) tab.getConteneur_risque()).getAction2().getBoutonSelected().getName()));} catch(NullPointerException ex) {}

			if(tab.getConteneur_maintenant().getAction2().isSelected())
			{
				ConteneurSchema conteneur = tab.getConteneur_maintenant();
				ActionBoutonSchemas23 action = conteneur.getAction2();
				ElementNote<Structure>[] mtn_notees = new ElementNote[4];
				int i=0;
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE DE MARCHE"))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nPROFESSIONNELLE"))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nMECANISTE"))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE CENTRALISEE"))
				{
					mtn_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nENTREPRENEURIALE"))
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
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE DE MARCHE"))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nPROFESSIONNELLE"))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nMECANISTE"))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE CENTRALISEE"))
				{
					apr_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nENTREPRENEURIALE"))
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
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE DE MARCHE"))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_MARCHE, conteneur.getNote_simple_marche());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nPROFESSIONNELLE"))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.PROFESSIONNELLE, conteneur.getNote_professionnelle());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nMECANISTE"))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.MECANISTE, conteneur.getNote_mecaniste());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nSIMPLE CENTRALISEE"))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.SIMPLE_CENTRALISEE, conteneur.getNote_simple_centralisee());
					i++;
				}
				if(!action.getBoutonSelected().getName().equals("Structure\nENTREPRENEURIALE"))
				{
					ris_notees[i] = new ElementNote<Structure>(Structure.ENTREPRENEURIALE, conteneur.getNote_entrepreneuriale());
					i++;
				}
				
				FenetreAccueil.etude.getS2().setRis_notees(ris_notees);
			}
			break;
		}
	}

}
