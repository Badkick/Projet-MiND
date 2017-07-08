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
	public Bouton(String nom, Font police, Dimension dim, Color couleurTexte)
	{
		this.setText(nom);
		this.name = nom;
		this.police = police;
		this.setPreferredSize(dim);
		img_repos = Images.importerImage("img_repos.png");
		img_clic = Images.importerImage("img_clic.png");
		img_survol = Images.importerImage("img_survol.png");

		this.img = img_repos;

		//Grâce à cette instruction, notre objet va s'écouter
		//Dès qu'un événement de la souris sera intercepté, il en sera averti
		this.addMouseListener(this);
	}

	public Bouton(String nom, Dimension dim)
	{
		this(nom,new Font("Tahoma",Font.BOLD,16),dim,Color.BLACK);
	}

	public Bouton(String nom,Font police,Dimension dim)
	{
		this(nom,police,dim,Color.BLACK);
	}




	// SETTERS //

	public void setName(String nom)
	{
		this.name = nom;
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

	public void setImgClic(File fichier)
	{
		img_clic = Images.importerImage(fichier);
	}

	public void setImgClic(String chemin)
	{
		img_clic = Images.importerImage(chemin);
	}

	public void setImgSurvol(File fichier)
	{
		img_survol = Images.importerImage(fichier);
	}

	public void setImgSurvol(String chemin)
	{
		img_survol = Images.importerImage(chemin);
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
	public void paintComponent(Graphics g)
	{
		g.setFont(this.getPolice());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.getCouleurTexte());
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.drawString(this.name, this.getWidth() /2 - (int)(this.name.length()*4.5), (this.getHeight() / 2) +6);
	}
	
	// met la couleur du bouton sur repos quand cette méthode est appelée
	public void updateCouleur()
	{
		img = this.getImgRepos();
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
		if (y>0 && y<this.getHeight() && x>0 && x<this.getWidth())
		{
			img=this.getImgSurvol();
		}
		else
		{
			img=this.getImgRepos();
		}
	}
}
