package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBoutonSchema6 implements ActionListener {

	// VARIABLES INSTANCE //

	private boolean selectionne;
	private BoutonOvaleSchema6 boutonSelected;
	private ConteneurSchema conteneur;
	private BoutonOvaleSchema6[] boutons;

	// CONSTRUCTEURS //

	public ActionBoutonSchema6(ConteneurSchema conteneur, boolean selectionne) {
		this.selectionne = selectionne;
		this.conteneur = conteneur;
		this.boutons = new BoutonOvaleSchema6[5];
		this.boutons[0]=this.getConteneur().getB_entrep_bureaucratique();
		this.boutons[1]=this.getConteneur().getB_entrep_communaute();
		this.boutons[2]=this.getConteneur().getB_entrep_crise();
		this.boutons[3]=this.getConteneur().getB_entrep_duale();
		this.boutons[4]=this.getConteneur().getB_entrep_modernisee();
	}

	public ActionBoutonSchema6(ConteneurSchema conteneur) {
		this(conteneur,false);
	}

	// GETTERS //

	public boolean isSelected()
	{
		return this.selectionne;
	}

	public BoutonOvaleSchema6 getBoutonSelected()
	{
		return this.boutonSelected;
	}
	
	private ConteneurSchema getConteneur()
	{
		return this.conteneur;
	}
	
	public BoutonOvaleSchema6[] getBoutons()
	{
		return this.boutons;
	}

	// SETTERS //

	public void setSelected(boolean selected)
	{
		this.selectionne = selected;
	}

	public void setBoutonSelected(BoutonOvaleSchema6 bouton)
	{
		this.boutonSelected = bouton;
	}
	
	// METHODES //

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.isSelected())
		{
			this.selectionne = true;
			((BoutonOvaleSchema6) e.getSource()).desactiver(FenetreAccueil.theme.getbSchema6Survol());
			this.setBoutonSelected((BoutonOvaleSchema6)e.getSource());
			for(BoutonOvaleSchema6 b : this.getBoutons())
			{
				if(!b.equals((BoutonOvaleSchema6)e.getSource())) b.desactiver(FenetreAccueil.theme.getbSchema6Repos());
			}
			ConteneurNouvelleEtude.unsave();
		}
	}

}
