package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarreMenu extends JMenuBar {
	
	

	private JMenu menuFichier = new JMenu("Fichier");

	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem nouvelleEtude = new JMenuItem("Nouvelle étude");
	private JMenuItem exporterEtude = new JMenuItem("Exporter l'étude en cours");
	private JMenuItem importerEtude = new JMenuItem("Ouvrir une étude");
	
	
	private JMenu menuParametres = new JMenu("Paramètres");
	
	private JMenuItem preferences = new JMenuItem("Préférences");


	public BarreMenu(Theme theme) {	
		this.menuFichier.setForeground(theme.getCouleurTexte());
		this.menuFichier.setFont(theme.getPolice());
		this.menuParametres.setForeground(theme.getCouleurTexte());
		this.menuParametres.setFont(theme.getPolice());
		
		this.configNouvelleEtude(theme);
		this.configImporterEtude(theme);
		this.configExporterEtude(theme);
		this.configQuitter(theme);

		this.configPreferences(theme);
		
		this.add(menuFichier);
		this.add(menuParametres);
	}

	private void configQuitter(Theme theme)
	{
		this.quitter.setFont(theme.getPolice());
		this.quitter.setIcon(theme.getQuitter());
		this.quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Communication.quitter();				
			}
		});
		this.menuFichier.add(quitter);
	}
	
	private void configNouvelleEtude(Theme theme)
	{
		this.nouvelleEtude.setFont(theme.getPolice());
		this.nouvelleEtude.setIcon(theme.getNouveau());
		this.menuFichier.add(nouvelleEtude);
	}
	
	private void configExporterEtude(Theme theme)
	{
		this.exporterEtude.setFont(theme.getPolice());
		this.exporterEtude.setIcon(theme.getExportation());
		this.menuFichier.add(exporterEtude);
	}
	
	private void configImporterEtude(Theme theme)
	{
		this.importerEtude.setFont(theme.getPolice());
		this.importerEtude.setIcon(theme.getImportation());
		this.menuFichier.add(importerEtude);
	}
	
	private void configPreferences(Theme theme)
	{
		this.preferences.setFont(theme.getPolice());
		this.preferences.setIcon(theme.getSettings());
		this.menuParametres.add(preferences);
	}

}
