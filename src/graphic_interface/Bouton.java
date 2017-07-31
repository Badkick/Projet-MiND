package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
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

	// CONSTRUCTEURS //

	// constructeur de base
	public Bouton(String nom, Dimension dim)
	{
		this.setText(nom);
		this.name = nom;
		this.police = FenetreAccueil.theme.getPolice();
		this.couleurTexte = FenetreAccueil.theme.getCouleurTexte();
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setMinimumSize(dim);
		img_repos = FenetreAccueil.theme.getBRepos();
		img_clic = FenetreAccueil.theme.getBClic();
		img_survol = FenetreAccueil.theme.getBSurvol();

		this.img = img_repos;

		//Grâce à cette instruction, notre objet va s'écouter
		//Dès qu'un événement de la souris sera intercepté, il en sera averti
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
	}

	public void setPolice(Font police)
	{
		this.police = police;
	}

	public void setImgRepos(File fichier)
	{
		img_repos = Images.importerImage(fichier);
	}

	public void setImgRepos(String chemin)
	{
		img_repos = Images.importerImage(chemin);
	}
	
	public void setImgRepos(Image image)
	{
		this.img_repos = image;
	}

	public void setImgClic(File fichier)
	{
		img_clic = Images.importerImage(fichier);
	}

	public void setImgClic(String chemin)
	{
		img_clic = Images.importerImage(chemin);
	}
	public void setImgClic(Image image)
	{
		this.img_clic = image;
	}

	public void setImgSurvol(File fichier)
	{
		img_survol = Images.importerImage(fichier);
	}

	public void setImgSurvol(String chemin)
	{
		img_survol = Images.importerImage(chemin);
	}
	
	public void setImgSurvol(Image image)
	{
		this.img_survol = image;
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

	// METHODES //

	// appelée à chaque fois qu'une action sur le bouton sera effectuée
	protected void paintComponent(Graphics g)
	{
		g.setFont(this.getPolice());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.getCouleurTexte());
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		int y = (this.getHeight()-(g2d.getFontMetrics().getAscent()+g2d.getFontMetrics().getDescent())*this.name.split("\n").length)/2;
		for (String line : this.name.split("\n")) g2d.drawString(line, (this.getWidth()-g2d.getFontMetrics().stringWidth(line))/2, y += g2d.getFontMetrics().getAscent());
	}
	
	// met la couleur du bouton sur repos quand cette méthode est appelée
	public void updateCouleur()
	{
		img = this.getImgRepos();
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

	// LISTENERS //	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// CLIC SIMPLE (GAUCHE)

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// SURVOL DU BOUTON
		img=this.getImgSurvol();

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// BOUTON QUITTE
		img=this.getImgRepos();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// CLIC GAUCHE (RESTER APPUYE)
		img=this.getImgClic();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// RELACHEMENT DU CLIC GAUCHE
		int y = event.getY();
		int x = event.getX();
		this.img=(y>0 && y<this.getHeight() && x>0 && x<this.getWidth()) ? this.getImgSurvol() : this.getImgRepos();
	}
}
