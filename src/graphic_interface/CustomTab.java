package graphic_interface;

import java.awt.Dimension;

import javax.swing.JLabel;

public class CustomTab extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Dimension TAILLE = new Dimension(140,20);
	private final float TAILLE_POLICE = 12;
	
	public CustomTab(String text) {
		super(text);
		this.setFont(FenetreAccueil.theme.getPolice().deriveFont(TAILLE_POLICE));
	}

	public CustomTab(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.setFont(FenetreAccueil.theme.getPolice().deriveFont(TAILLE_POLICE));
	}
	
	public void setTaille(Dimension taille)
	{
		this.setPreferredSize(taille);
		this.setMaximumSize(taille);
		this.setMinimumSize(taille);
	}
	
	

}
