package graphic_interface;


import java.awt.Dimension;

import javax.swing.JPanel;

public class Conteneur extends JPanel {

	// VARIABLES DE CLASSE //
	
	private int height;
	private int width;
	
	
	// CONSTRUCTEURS //
	
	public Conteneur(int width, int height) {
		this.setSize(width, height);
	}
	
	public Conteneur() {}

	// GETTERS //
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Dimension getSize()
	{
		return new Dimension(this.getWidth(),this.getHeight());
	}

	// SETTERS //
	
	public void setHeight(int height) {
		this.setSize(this.getWidth(), height);
	}

	public void setWidth(int width) {
		this.setSize(width, this.getHeight());
	}
	
	public void setSize(int width, int height)
	{
		this.height = height;
		this.width = width;
		this.setPreferredSize(new Dimension(width, height));
	}
	
	public void setSize(Dimension dim)
	{
		this.height = (int) dim.getHeight();
		this.width = (int) dim.getWidth();
		this.setPreferredSize(dim);
	}


}
