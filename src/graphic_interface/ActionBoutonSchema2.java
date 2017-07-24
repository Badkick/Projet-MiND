package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionBoutonSchema2 implements ActionListener {

	// VARIABLES INSTANCE //

	private boolean selectionne;
	private ConteneurSchema conteneur;

	// CONSTRUCTEURS //

	public ActionBoutonSchema2(ConteneurSchema conteneur, boolean selectionne) {
		this.selectionne = selectionne;
		this.conteneur = conteneur;
	}

	public ActionBoutonSchema2(ConteneurSchema conteneur) {
		this(conteneur,false);
	}

	// GETTERS //

	public boolean isSelected()
	{
		return this.selectionne;
	}
	
	// SETTERS //
	
	public void setSelected(boolean selected)
	{
		this.selectionne = selected;
	}

	// METHODES //

	public void actionPerformed(ActionEvent e) {
		if(!this.isSelected())
		{
			this.selectionne = true;
			this.desactiverBouton((Bouton) e.getSource());
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
