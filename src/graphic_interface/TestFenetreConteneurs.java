package graphic_interface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFenetreConteneurs {

	public static void main(String[] args) {
		Image img=Images.importerImage("background.jpg");
		Image img2=Images.importerImage("tardis.jpg"); 
		Image img3=Images.importerImage("pb.jpg");

		ConteneurAvecImage conteneur1 = new ConteneurAvecImage(0,0,img);
		ConteneurAvecImage conteneur2 = new ConteneurAvecImage(0,0,img);
		FenetreModele fen = new FenetreModele(conteneur1);
		conteneur1.setTaille(fen.getSize());
		conteneur2.setTaille(fen.getSize());
		Conteneur carte1 = new Conteneur(fen.getSize());
		Conteneur carte2 = new Conteneur(fen.getSize());
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

		carte1.setOpaque(false);
		ConteneurAvecImage vide1 = new ConteneurAvecImage(240,360,img2);
		carte1.add(bouton1);
		carte1.add(vide1);
		conteneur1.add(carte1);

		carte2.setOpaque(false);
		ConteneurAvecImage vide2 = new ConteneurAvecImage(200,200,img3);
		carte2.add(bouton2);
		carte2.add(vide2);
		conteneur2.add(carte2);

		fen.setConteneur(conteneur1);

		fen.setVisible(true);
	}

}
