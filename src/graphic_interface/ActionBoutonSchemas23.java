package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionBoutonSchemas23 implements ActionListener {

	// VARIABLES INSTANCE //

	private boolean selectionne;
	private ConteneurSchema conteneur;
	private Bouton boutonSelected;

	// CONSTRUCTEURS //

	public ActionBoutonSchemas23(ConteneurSchema conteneur, boolean selectionne) {
		this.selectionne = selectionne;
		this.conteneur = conteneur;
	}

	public ActionBoutonSchemas23(ConteneurSchema conteneur) {
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
			this.desactiverBouton((Bouton) e.getSource());
			this.setBoutonSelected((Bouton)e.getSource());
		}
		else
		{
			new FenetreChoixNote((Bouton)e.getSource(),this.conteneur);
		}
	}
	
	public void desactiverBouton(Bouton b)
	{
		b.setEnabled(false);
		b.setImgFixe(Theme.NIGHT.getbSchema2Survol());
		b.updateCouleur();
	}
	
	public void activerBouton(Bouton b)
	{
		b.setEnabled(true);
		b.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
		b.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
		b.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
		b.updateCouleur();
	}

}
