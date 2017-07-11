package graphic_interface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TestFenetreConteneurs {

	public final static int VANILLA = Integer.MAX_VALUE;
	public final static int SWITCH_CONTENEURS = 0;
	public final static int GROUP_LAYOUT = 1;

	public TestFenetreConteneurs(int type, Theme theme) {
		Image img=theme.getBackground();
		Image img2=Images.importerImage("tardis.jpg"); 
		Image img3=Images.importerImage("pb.jpg");

		ConteneurAvecImage conteneur1 = new ConteneurAvecImage(0,0,img);

		Fenetre fen = new Fenetre(conteneur1,theme);
		conteneur1.setTaille(fen.getSize());
		Conteneur carte1 = new Conteneur(fen.getSize());
		carte1.setOpaque(false);

		switch (type)
		{
		case SWITCH_CONTENEURS:

			ConteneurAvecImage conteneur2 = new ConteneurAvecImage(0,0,img);

			conteneur2.setTaille(fen.getSize());

			Conteneur carte2 = new Conteneur(fen.getSize());
			Bouton bouton1 = new Bouton("Changer de Panel", new Dimension(200, 50),theme);
			Bouton bouton2 = new Bouton("Changer de Panel22", new Dimension(200, 50),theme);

			bouton1.addActionListener(new ChangerConteneur(fen, conteneur2));

			bouton2.addActionListener(new ChangerConteneur(fen, conteneur1));

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

			Bouton bouton_nouveau = new Bouton("Nouvelle étude",new Dimension(200,100),theme);
			Bouton bouton_liste = new Bouton("Liste des études", new Dimension(200,100),theme);
			Bouton bouton_quitter = new Bouton("Quitter", new Dimension(200,100),theme);
			
			bouton_nouveau.setToolTipText("Crée une nouvelle étude.");
			bouton_liste.setToolTipText("Affiche la liste des études : permet l'édition d'une étude et l'affichage des études terminées.");
			bouton_quitter.setToolTipText("Quitte le logiciel.");

			GroupLayout layout = new GroupLayout(carte1);
			carte1.setLayout(layout);

			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);

			layout.setHorizontalGroup(
					layout.createSequentialGroup()
					.addGap(235)
					.addGroup(layout.createParallelGroup()
							.addGroup(layout.createSequentialGroup()
									.addComponent(bouton_nouveau)
									.addGap(130)
									.addComponent(bouton_liste))
							.addGroup(layout.createSequentialGroup()
									.addGap(165)
									.addComponent(bouton_quitter)))
					);

			layout.setVerticalGroup(
					layout.createSequentialGroup()
					.addGap(140)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addGap(200)
							.addComponent(bouton_nouveau)
							.addComponent(bouton_liste))
					.addGap(30)
					.addComponent(bouton_quitter)
					);

			bouton_quitter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Communication.quitter();					
				}
			});


			conteneur1.add(carte1);

			break;
		}

		fen.setConteneur(conteneur1);
		//fen.setJMenuBar(new BarreMenu(theme));
		fen.setVisible(true);
	}

}
