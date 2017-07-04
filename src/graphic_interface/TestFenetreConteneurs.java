package graphic_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TestFenetreConteneurs {

	public static void main(String[] args) {
		Image img=null; 
		Image img2=null; 
		Image img3=null;
		try {
			img = ImageIO.read(new File("background.jpg"));
			img2 = ImageIO.read(new File("tardis.jpg"));
			img3 = ImageIO.read(new File("pb.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ConteneurAvecImage conteneur1 = new ConteneurAvecImage(0,0,img);
		ConteneurAvecImage conteneur2 = new ConteneurAvecImage(0,0,img);
		FenetreModele fen = new FenetreModele(conteneur1);
		conteneur1.setSize(fen.getSize());
		conteneur2.setSize(fen.getSize());
		JPanel carte1 = new JPanel();
		JPanel carte2 = new JPanel();
		Bouton bouton1 = new Bouton("Changer de Panel", new Dimension(200, 50));
		Bouton bouton2 = new Bouton("Changer de Panel22", new Dimension(200, 50));

		bouton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setConteneur(conteneur2);
			}
		});

		bouton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setConteneur(conteneur1);
			}
		});

		carte1.setPreferredSize(fen.getSize());
		carte1.setOpaque(false);
		ConteneurAvecImage vide1 = new ConteneurAvecImage(240,360,img2);
		carte1.add(bouton1);
		carte1.add(vide1);
		conteneur1.add(carte1);

		carte2.setPreferredSize(fen.getSize());
		carte2.setOpaque(false);
		ConteneurAvecImage vide2 = new ConteneurAvecImage(200,200,img3);
		carte2.add(bouton2);
		carte2.add(vide2);
		conteneur2.add(carte2);

		fen.setConteneur(conteneur1);

		fen.setVisible(true);
	}

}
