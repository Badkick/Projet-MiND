package graphic_interface;


import java.util.List;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Conteneur conteneur;// le conteneur principal (JContentPane)
	
	public Fenetre(Conteneur pane, Theme theme) {
		this.conteneur = pane;
		this.configurationBasique(theme);
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
	
	public void configurationBasique(Theme theme)
	{
		this.setSize(1000, 700); // taille de la fen�tre
		this.setTitle("Projet MiND"); // titre de la fen�tre
		this.setLocationRelativeTo(null); // fen�tre au centre
		this.setIconImage(theme.getIcone());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arr�ter le programme lors de la fermeture de la fen�tre
		this.setResizable(false); // fen�tre non recadrable
	}
	
	public void revaliderBoutons()
	{
		List<Bouton> boutons = conteneur.getBoutons(true);
		for(Bouton b : boutons) b.updateCouleur();
	}
	
}
