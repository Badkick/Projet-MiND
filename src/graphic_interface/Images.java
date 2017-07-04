package graphic_interface;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	
	public static Image importerImage(File fichier)
	{
		Image img=null;
		try {
			img = ImageIO.read(fichier);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static Image importerImage(String chemin)
	{
		Image img=null;
		try {
			img = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
