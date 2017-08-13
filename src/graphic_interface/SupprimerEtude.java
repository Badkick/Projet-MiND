package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

public class SupprimerEtude implements ActionListener {
	
	private String nom;

	public SupprimerEtude(String nom) {
		this.nom=nom;
	}
	
	public String getNom(){
		return this.nom;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File etude=new File("saves"+File.separator+getNom());
		if(Communication.messageAttentionChoix("Vous êtes sur le point de supprimer cette étude. Confirmez-vous cette requête ?")==JOptionPane.YES_OPTION){
			String[] donnees=etude.list();
			for(String s:donnees){
				File currentFile = new File(etude.getPath(),s);
				currentFile.delete();
			}
			etude.delete();
			
		}
		
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
