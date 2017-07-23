package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionBoutonSchema2 implements ActionListener {

	// VARIABLES INSTANCE //

	private boolean selectionne;
	private ConteneurSchema conteneur;
	private Theme theme;

	// CONSTRUCTEURS //

	public ActionBoutonSchema2(ConteneurSchema conteneur, boolean selectionne, Theme theme) {
		this.selectionne = selectionne;
		this.conteneur = conteneur;
		this.theme = theme;
	}

	public ActionBoutonSchema2(ConteneurSchema conteneur, Theme theme) {
		this(conteneur,false,theme);
	}

	// GETTERS //

	public boolean isSelected()
	{
		return this.selectionne;
	}

	// METHODES //

	public void actionPerformed(ActionEvent e) {
		if(!this.isSelected())
		{
			this.selectionne = true;
			this.desactiverBouton((Bouton) e.getSource());
		}
	}
	
	private void desactiverBouton(Bouton b)
	{
		b.setEnabled(false);
		b.setImgFixe(Theme.NIGHT.getbSchema2Survol());
	}
	
	private void activerBouton(Bouton b)
	{
		b.setEnabled(true);
		b.resetImg(theme);
	}

}
