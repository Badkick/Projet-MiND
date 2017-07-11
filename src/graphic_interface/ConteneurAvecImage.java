package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class ConteneurAvecImage extends Conteneur{
	
	// VARIABLES DE CLASSE //
	
	private Image img;
	private boolean remplissage;
	
	// CONSTRUCTEURS //
	
	public ConteneurAvecImage(int width, int height, Image img, boolean remplissage)
	{
		super(width,height);
		this.img = img;
		this.remplissage = remplissage;
	}
	
	public ConteneurAvecImage(int width, int height, Image img)
	{
		this(width,height,img,true);
	}
	
	public ConteneurAvecImage(Dimension dim, Image img)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),img,true);
	}
	
	public ConteneurAvecImage(Dimension dim, Image img,boolean remplissage)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),img,remplissage);
	}
	
	// GETTERS //
	
	public Image getImg()
	{
		return this.img;
	}
	
	// SETTERS //
	
	public void setImg(Image img)
	{
		this.img = img;
		this.repaint();
	}
	
	// METHODES //

	public void paintComponent(Graphics g)
	{
		g.drawImage(remplissage ? Images.scaleImage(this.getImg(),this.getWidth(), this.getHeight()) : this.getImg(), 0, 0, this);
	}


}
