package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionBoutonSchemas236 implements ActionListener {

	// VARIABLES INSTANCE //

	private boolean selectionne;
	private ConteneurSchema conteneur;
	private Bouton boutonSelected;

	// CONSTRUCTEURS //

	public ActionBoutonSchemas236(ConteneurSchema conteneur, boolean selectionne) {
		this.selectionne = selectionne;
		this.conteneur = conteneur;
	}

	public ActionBoutonSchemas236(ConteneurSchema conteneur) {
		this(conteneur,false);
	}

	// GETTERS //

	public boolean isSelected()
	{
		return this.selectionne;
	}
	
	public Bouton getBoutonSelected()
	{
		return this.boutonSelected;
	}
	
	// SETTERS //
	
	public void setSelected(boolean selected)
	{
		this.selectionne = selected;
	}
	
	public void setBoutonSelected(Bouton bouton)
	{
		this.boutonSelected = bouton;
	}

	// METHODES //

	public void actionPerformed(ActionEvent e) {
		if(!this.isSelected())
		{
			this.selectionne = true;
			((Bouton) e.getSource()).desactiver(FenetreAccueil.theme.getbSchema2Survol());
			this.setBoutonSelected((Bouton)e.getSource());
		}
		else new FenetreChoixNote((Bouton)e.getSource(),this.conteneur);
		ConteneurNouvelleEtude.unsave();
	}
}
