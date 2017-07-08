package graphic_interface;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
		this.setSize(1000, 700); // taille de la fenêtre
		this.setTitle("Projet MiND"); // titre de la fenêtre
		this.setLocationRelativeTo(null); // fenêtre au centre
		this.setIconImage(theme.getIcone());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // arrêter le programme lors de la fermeture de la fenêtre
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Communication.quitter();				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.setResizable(false); // fenêtre non recadrable
	}
	
	public void revaliderBoutons()
	{
		List<Bouton> boutons = conteneur.getBoutons(true);
		for(Bouton b : boutons) b.updateCouleur();
	}
	
}
