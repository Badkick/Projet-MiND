package graphic_interface;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Conteneur extends JPanel {

	// VARIABLES DE CLASSE //

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;


	// CONSTRUCTEURS //

	public Conteneur(int width, int height) {
		this.setTaille(width, height);
	}

	public Conteneur(Dimension dim)
	{
		this.setTaille(dim);
	}

	public Conteneur() {super();}

	// GETTERS //

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return width;
	}

	public Dimension getTaille()
	{
		return new Dimension(this.getWidth(),this.getHeight());
	}

	//récupère les boutons de ce conteneur et de tous les conteneurs fils, si précisé (true)
	public List<Bouton> getBoutons(boolean conteneursFils)
	{		
		return getBoutons(this, conteneursFils);
	}

	private List<Bouton> getBoutons(Conteneur conteneur, boolean conteneursFils)
	{
		List<Bouton> boutons = new ArrayList<Bouton>();
		if(conteneur.getComponents().length!=0)
		{
			for(int i=0;i<conteneur.getComponents().length;i++)
			{
				if(conteneur.getComponents()[i] instanceof Bouton) boutons.add((Bouton) conteneur.getComponents()[i]);
				if(conteneur.getComponents()[i] instanceof Conteneur && conteneursFils) boutons.addAll(getBoutons((Conteneur) conteneur.getComponents()[i],conteneursFils));
			}
		}
		return boutons;
	}

	// SETTERS //

	public void setHeight(int height) {
		this.setTaille(this.getWidth(), height);
	}

	public void setWidth(int width) {
		this.setTaille(width, this.getHeight());
	}

	public void setTaille(int width, int height)
	{
		this.height = height;
		this.width = width;
		this.setPreferredSize(new Dimension(width, height));
	}

	public void setTaille(Dimension dim)
	{
		this.height = (int) dim.getHeight();
		this.width = (int) dim.getWidth();
		this.setPreferredSize(dim);
	}
	
	// METHODES //
	


}
