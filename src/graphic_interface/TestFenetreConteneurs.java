package graphic_interface;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;

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
			
			Bouton b1 = new Bouton("Nouvelle étude",new Dimension(200,100),theme);
			Bouton b2 = new Bouton("Consulter les études", new Dimension(200,100),theme);
			Bouton b3 = new Bouton("Continuer", new Dimension(200,100),theme);
			Bouton b4 = new Bouton("Quitter", new Dimension(200,100),theme);
			
			GroupLayout layout = new GroupLayout(carte1);
			carte1.setLayout(layout);
			
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			
			layout.setHorizontalGroup(
					layout.createSequentialGroup()
						.addGap(230)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(b1)
								.addGap(50)
								.addComponent(b2))
						.addGap(120)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(b3)
								.addGap(50)
								.addComponent(b4))
					);
			
			layout.setVerticalGroup(
					layout.createSequentialGroup()
						.addGap(105)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addGap(200)
							.addComponent(b1)
							.addGap(50)
							.addComponent(b3))
						.addGap(50)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(b2)
							.addGap(50)
							.addComponent(b4))
					);
			
			b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);					
				}
			});
			

			conteneur1.add(carte1);
			
			break;
		}
		
		fen.setConteneur(conteneur1);
		fen.setJMenuBar(new BarreMenu(theme));
		fen.setVisible(true);
	}

}
