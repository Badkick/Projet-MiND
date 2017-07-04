package graphic_interface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders.*;

public class Test {

	public static void main(String[] args)
	{
		ConteneurPrincipal conteneur1 = new ConteneurPrincipal();
		ConteneurPrincipal conteneur2 = new ConteneurPrincipal();
		FenetreModele fen = new FenetreModele(conteneur1);
		conteneur1.setPreferredSize(fen.getSize());
		conteneur2.setPreferredSize(fen.getSize());
		JPanel carte1 = new JPanel();
		PanelTest1 carte2 = new PanelTest1(fen.getSize());
		Bouton bouton1 = new Bouton("Changer de Panel", new Dimension(200, 50));
		Bouton bouton2 = new Bouton("Changer de Panel22", new Dimension(200, 50));

		bouton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setConteneur(conteneur2);
				bouton1.repaint();
				bouton2.repaint();
			}
		});

		bouton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setConteneur(conteneur1);
				bouton1.repaint();
				bouton2.repaint();
			}
		});

		carte1.setPreferredSize(carte2.getPreferredSize());
		carte1.setBackground(Color.WHITE);
		JPanel vide1 = new JPanel();
		vide1.setPreferredSize(new Dimension(200, 200));
		carte1.add(vide1,BorderLayout.NORTH);
		carte1.add(bouton1,BorderLayout.SOUTH);
		conteneur1.add(carte1);

		JPanel vide2 = new JPanel();
		vide2.setPreferredSize(new Dimension(300, 300));
		carte2.setBackground(Color.WHITE);
		carte2.add(vide2,BorderLayout.SOUTH);
		carte2.add(bouton2,BorderLayout.NORTH);
		conteneur2.add(carte2);
		
		fen.setConteneur(conteneur1);

		fen.setVisible(true);
	}
}
