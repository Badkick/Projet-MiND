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
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "Bouton";
	private Image img;

	public Bouton(String nom, Dimension dim)
	{
		this.setText(nom);
		this.name = nom;
		this.setPreferredSize(dim);
		try {
			img = ImageIO.read(new File("bvert.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Grâce à cette instruction, notre objet va s'écouter
		//Dès qu'un événement de la souris sera intercepté, il en sera averti
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		Font police = new Font("Tahoma",Font.BOLD,16);
		g.setFont(police);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.drawString(this.name, this.getWidth() /2 - (int)(this.name.length()*4.5), (this.getHeight() / 2) +6);

	}

	public void setName(String nom)
	{
		this.name = nom;
	}

	public String getName()
	{
		return this.name;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// SURVOL DU BOUTON
		try {
			img = ImageIO.read(new File("bjaune.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// BOUTON QUITTE
		try {
			img = ImageIO.read(new File("bvert.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// CLIC GAUCHE
		try {
			img = ImageIO.read(new File("borange.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// RELACHEMENT DU CLIC GAUCHE
		int y = event.getY();
		int x = event.getX();
		if (y>0 && y<this.getHeight() && x>0 && x<this.getWidth())
		{
			try {
				img = ImageIO.read(new File("bjaune.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				img = ImageIO.read(new File("bvert.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
