package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	// VARIABLES DE CLASSE //

	private static final long serialVersionUID = 1L;
	private String name = "Bouton";
	private Image img;
	private Image img_repos;
	private Image img_clic;
	private Image img_survol;
	private Color couleurTexte;
	private Font police;
	private Dimension taille;

	// CONSTRUCTEURS //

	// constructeur de base
	public Bouton(String nom, Dimension dim)
	{
		this.setText(nom);
		this.name = nom;
		this.police = FenetreAccueil.theme.getPolice();
		this.couleurTexte = FenetreAccueil.theme.getCouleurTexte();
		this.taille = dim;
		
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setMinimumSize(dim);
		
		this.resetImg();

		this.img = img_repos;

		//Gr�ce � cette instruction, notre objet va s'�couter
		//D�s qu'un �v�nement de la souris sera intercept�, il en sera averti
		this.addMouseListener(this);
	}

	// SETTERS //

	public void setName(String nom)
	{
		this.name = nom;
		this.repaint();
	}

	public void setCouleurTexte(Color couleur)
	{
		this.couleurTexte = couleur;
		this.repaint();
	}

	public void setPolice(Font police)
	{
		this.police = police;
		this.repaint();
	}
	
	public void setImage(Image img)
	{
		this.img = img;
		this.repaint();
	}

	public void setImgRepos(File fichier)
	{
		this.img_repos = Images.importerImage(fichier);
		this.repaint();
	}

	public void setImgRepos(String chemin)
	{
		this.img_repos = Images.importerImage(chemin);
		this.repaint();
	}
	
	public void setImgRepos(Image image)
	{
		this.img_repos = image;
		this.repaint();
	}

	public void setImgClic(File fichier)
	{
		this.img_clic = Images.importerImage(fichier);
		this.repaint();
	}

	public void setImgClic(String chemin)
	{
		this.img_clic = Images.importerImage(chemin);
		this.repaint();
	}
	public void setImgClic(Image image)
	{
		this.img_clic = image;
		this.repaint();
	}

	public void setImgSurvol(File fichier)
	{
		this.img_survol = Images.importerImage(fichier);
		this.repaint();
	}

	public void setImgSurvol(String chemin)
	{
		this.img_survol = Images.importerImage(chemin);
		this.repaint();
	}
	
	public void setImgSurvol(Image image)
	{
		this.img_survol = image;
		this.repaint();
	}



	// GETTERS //

	public String getName()
	{
		return this.name;
	}

	public Color getCouleurTexte()
	{
		return this.couleurTexte;
	}

	public Font getPolice()
	{
		return this.police;
	}

	public Image getImgRepos()
	{
		return this.img_repos;
	}

	public Image getImgClic()
	{
		return this.img_clic;
	}

	public Image getImgSurvol()
	{
		return this.img_survol;
	}
	
	public Image getImg()
	{
		return this.img;
	}
	
	public Dimension getTaille()
	{
		return this.taille;
	}

	// METHODES //

	// appel�e � chaque fois qu'une action sur le bouton sera effectu�e
	protected void paintComponent(Graphics g)
	{
		g.setFont(this.getPolice());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.getCouleurTexte());
		g2d.drawImage(this.getImg(), 0, 0, this.getWidth(), this.getHeight(), this);
		int y = (this.getHeight()-(g2d.getFontMetrics().getAscent()+g2d.getFontMetrics().getDescent())*this.getName().split("\n").length)/2;
		for (String line : this.getName().split("\n")) g2d.drawString(line, (this.getWidth()-g2d.getFontMetrics().stringWidth(line))/2, y += g2d.getFontMetrics().getAscent());
	}
	
	// met la couleur du bouton sur repos quand cette m�thode est appel�e
	public void updateCouleur()
	{
		this.setImage(this.getImgRepos());
	}
	
	public void setImgFixe(Image img)
	{
		this.setImgClic(img);
		this.setImgRepos(img);
		this.setImgSurvol(img);
	}
	
	public void resetImg()
	{
		this.setImgClic(FenetreAccueil.theme.getBClic());
		this.setImgRepos(FenetreAccueil.theme.getBRepos());
		this.setImgSurvol(FenetreAccueil.theme.getBSurvol());
	}
	
	public void desactiver()
	{
		this.setEnabled(false);
		this.updateCouleur();
	}
	
	public void desactiver(Image img_desactive)
	{
		this.setImgFixe(img_desactive);
		this.desactiver();
	}
	
	public void activer()
	{
		this.activer(FenetreAccueil.theme.getBRepos(), FenetreAccueil.theme.getBSurvol(), FenetreAccueil.theme.getBClic());
	}
	
	public void activer(Image img_repos, Image img_survol, Image img_clic)
	{
		this.setEnabled(true);
		this.setImgRepos(img_repos);
		this.setImgSurvol(img_survol);
		this.setImgClic(img_clic);
		this.updateCouleur();
	}

	// LISTENERS //	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// CLIC SIMPLE (GAUCHE)

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// SURVOL DU BOUTON
		this.setImage(this.getImgSurvol());

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// BOUTON QUITTE
		this.setImage(this.getImgRepos());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// CLIC GAUCHE (RESTER APPUYE)
		this.setImage(this.getImgClic());
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// RELACHEMENT DU CLIC GAUCHE
		int y = event.getY();
		int x = event.getX();
		this.setImage((y>0 && y<this.getHeight() && x>0 && x<this.getWidth()) ? this.getImgSurvol() : this.getImgRepos());
	}
}
