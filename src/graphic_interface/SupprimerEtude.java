package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupprimerEtude implements ActionListener {

	public SupprimerEtude() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		// à laisser en dernier
		refreshList();
	}
	
	private void refreshList()
	{
		ConteneurListeEtudes liste = new ConteneurListeEtudes(FenetreAccueil.fenetre_principale.getSize(), FenetreAccueil.conteneur_principal, FenetreAccueil.fenetre_principale);
		liste.initialiserListe();
		FenetreAccueil.fenetre_principale.setConteneur(liste);
	}

}
