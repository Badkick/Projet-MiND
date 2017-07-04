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
		this.setSize(1000, 700); // taille de la fen�tre
		this.setTitle("Fen�tre mod�le"); // titre de la fen�tre
		this.setLocationRelativeTo(null); // fen�tre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arr�ter le programme lors de la fermeture de la fen�tre
		this.setResizable(false); // fen�tre non recadrable
	}
	
}
