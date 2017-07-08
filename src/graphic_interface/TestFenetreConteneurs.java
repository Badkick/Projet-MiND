package graphic_interface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TestFenetreConteneurs {

	public final static int VANILLA = Integer.MAX_VALUE;
	public final static int SWITCH_CONTENEURS = 0;
	public final static int GROUP_LAYOUT = 1;

	public TestFenetreConteneurs(int type) {
		Image img=Images.importerImage("background.jpg");
		Image img2=Images.importerImage("tardis.jpg"); 
		Image img3=Images.importerImage("pb.jpg");
		
		ConteneurAvecImage conteneur1 = new ConteneurAvecImage(0,0,img);
		
		Fenetre fen = new Fenetre(conteneur1);
		conteneur1.setTaille(fen.getSize());
		Conteneur carte1 = new Conteneur(fen.getSize());
		carte1.setOpaque(false);
		
		switch (type)
		{
		case SWITCH_CONTENEURS:
					
			ConteneurAvecImage conteneur2 = new ConteneurAvecImage(0,0,img);
			
			conteneur2.setTaille(fen.getSize());
			
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

			ConteneurAvecImage vide1 = new ConteneurAvecImage(240,360,img2);
			carte1.add(bouton1);
			carte1.add(vide1);
			conteneur1.add(carte1);

			carte2.setOpaque(false);
			ConteneurAvecImage vide2 = new ConteneurAvecImage(200,200,img3);
			carte2.add(bouton2);
			carte2.add(vide2);
			conteneur2.add(carte2);

			break;
			
		case GROUP_LAYOUT:
			
			Bouton b1 = new Bouton("Créer une étude",new Dimension(200,100));
			Bouton b2 = new Bouton("Poursuivre une étude", new Dimension(200,100));
			Bouton b3 = new Bouton("Quitter", new Dimension(200,100));
			
			GroupLayout layout = new GroupLayout(carte1);
			carte1.setLayout(layout);
			
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			
			layout.setHorizontalGroup(
					layout.createSequentialGroup()
						.addGap(100)
						.addComponent(b1)
						.addGap(100)
						.addComponent(b2)
						.addGap(100)
						.addComponent(b3)
					);
			
			layout.setVerticalGroup(
					layout.createSequentialGroup()
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addGap(560)
							.addComponent(b1)
							.addComponent(b2)
							.addComponent(b3))
					);
			
			b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			conteneur1.add(carte1);
			
			break;
		}
		
		fen.setConteneur(conteneur1);
		fen.setJMenuBar(new BarreMenu());
		fen.setVisible(true);
	}

}
