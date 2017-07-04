package graphic_interface;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreModele extends JFrame {

	private Conteneur conteneur;// le conteneur principal (JContentPane)
	
	public FenetreModele(Conteneur pane) {
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
		this.revalidate();
	}


	// METHODES //
	
	public void configurationBasique()
	{
		this.setSize(1000, 700); // taille de la fenêtre
		this.setTitle("Fenêtre modèle"); // titre de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arrêter le programme lors de la fermeture de la fenêtre
		this.setResizable(false); // fenêtre non recadrable
	}
	
}
