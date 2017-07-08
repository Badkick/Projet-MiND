package graphic_interface;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class Images {

	
	// classe de méthodes utiles pour le travail sur des images
	
	// redimmensionne une image 
	public static Image scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}
	
	// importe l'image correspondant au File fichier
	public static Image importerImage(File fichier)
	{
		return importerImage(fichier.getPath());
	}
	
	// importe l'image dans chemin (à partir de la racine du projet)
	public static Image importerImage(String chemin)
	{
		Image img=null;
		try {
			img = ImageIO.read(new File(getChemin(chemin)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	// importe une icône à partir du File fichier en 16x16
	public static ImageIcon importerIcone(File fichier)
	{
		return importerIcone(fichier.getPath());
	}
	
	// importe une icône à partir du chemin en 16x16
	public static ImageIcon importerIcone(String chemin)
	{
		return importerIcone(chemin,16,16);
	}
	
	// importe une icône à partir d'une image
	public static ImageIcon importerIcone(Image img)
	{
		return new ImageIcon(Images.scaleImage(img, 16, 16));
	}
	
	//importe une icône à partir du chemin, et la redimensionne comme choisi
	public static ImageIcon importerIcone(String chemin, int width, int height)
	{
		return new ImageIcon(Images.scaleImage(importerImage(chemin), width, height));
	}
	
	//importe une icône à partir du File fichier, et la redimensionne comme choisi
	public static ImageIcon importerIcone(File fichier, int width, int height)
	{
		return importerIcone(fichier.getPath(), width, height);
	}
	
	private static String getChemin(String chemin)
	{
		return "images"+File.separator+chemin;
	}
	
}
