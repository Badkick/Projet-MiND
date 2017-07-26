package graphic_interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;


public class FenetreAccueil {

	public static ConteneurAvecImage conteneur_principal;
	public static Fenetre fenetre_principale;
	public static Etude etude=new Etude();
	public static Theme theme;
	
	public FenetreAccueil(Theme th) {
		theme = th;
		conteneur_principal = new ConteneurAvecImage(0,0,theme.getBackground());
		fenetre_principale = new Fenetre(conteneur_principal,theme);
		conteneur_principal.setTaille(fenetre_principale.getSize());
		Conteneur conteneur_menu = new Conteneur(fenetre_principale.getSize());
		conteneur_menu.setOpaque(false);
		
		Bouton bouton_nouveau = new Bouton("Nouvelle étude",new Dimension(200,100));
		Bouton bouton_liste = new Bouton("Liste des études", new Dimension(200,100));
		Bouton bouton_quitter = new Bouton("Quitter", new Dimension(200,100));
		
		ConteneurListeEtudes liste = new ConteneurListeEtudes(fenetre_principale.getSize(), conteneur_principal, fenetre_principale);
		
		bouton_nouveau.setToolTipText("Crée une nouvelle étude.");
		bouton_liste.setToolTipText("Affiche la liste des études : permet l'édition d'une étude et l'affichage des études terminées.");
		bouton_quitter.setToolTipText("Quitte le logiciel.");

		GroupLayout layout = new GroupLayout(conteneur_menu);
		conteneur_menu.setLayout(layout);

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

		bouton_liste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				liste.initialiserListe();
				fenetre_principale.setConteneur(liste);
			}
		});

		bouton_nouveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = "";
				try{
					nom = JOptionPane.showInputDialog(null, "Quel nom voulez-vous donner à cette étude ?","Nom de l'étude",JOptionPane.PLAIN_MESSAGE);
					if(nom.equals(null) || nom.equals("") || nom==null) nom = "";
					} catch(java.lang.NullPointerException ex) {
						nom = "";
					}
				if(!nom.equals(""))
				{
					ConteneurNouvelleEtude nouvelle_etude = new ConteneurNouvelleEtude(fenetre_principale.getSize(), conteneur_principal, fenetre_principale,nom);
					ConteneurNouvelleEtude.unsave();
					fenetre_principale.setConteneur(nouvelle_etude,"Projet MiND - "+nom);
				}

			}
		});

		conteneur_principal.add(conteneur_menu);

		fenetre_principale.setConteneur(conteneur_principal);
		fenetre_principale.setVisible(true);
	}
	

}
