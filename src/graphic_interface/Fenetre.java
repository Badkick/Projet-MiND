package graphic_interface;


import java.util.List;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Conteneur conteneur;// le conteneur principal (JContentPane)
	
	public Fenetre(Conteneur pane) {
		this.conteneur = pane;
		this.configurationBasique();
		this.setContentPane(this.getConteneur());
	}

	
	// GETTERS //

	public Conteneur getConteneur() {
		return this.conteneur;
	}

	
	// SETTERS //
	
	public void setConteneur(Conteneur conteneur) {
		this.conteneur = conteneur;
		this.setContentPane(conteneur);
		this.revaliderBoutons();
		this.revalidate();
	}


	// METHODES //
	
	public void configurationBasique()
	{
		this.setSize(1000, 700); // taille de la fenêtre
		this.setTitle("Fenêtre"); // titre de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arrêter le programme lors de la fermeture de la fenêtre
		this.setResizable(false); // fenêtre non recadrable
	}
	
	public void revaliderBoutons()
	{
		List<Bouton> boutons = conteneur.getBoutons(true);
		for(Bouton b : boutons) b.updateCouleur();
	}
	
}
