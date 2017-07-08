package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarreMenu extends JMenuBar {

	private JMenu menuFichier = new JMenu("Fichier");


	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem nouvelleEtude = new JMenuItem("Nouvelle étude");
	private JMenuItem exporterEtude = new JMenuItem("Exporter l'étude en cours");
	private JMenuItem importerEtude = new JMenuItem("Importer une étude");


	public BarreMenu() {	
		this.configNouvelleEtude();
		this.configExporterEtude();
		this.configImporterEtude();
		this.configQuitter();

		this.add(menuFichier);
	}

	private void configQuitter()
	{
		this.quitter.setIcon(Images.importerIcone("icon_quit.png"));
		this.quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		this.menuFichier.add(quitter);
	}
	
	private void configNouvelleEtude()
	{
		this.nouvelleEtude.setIcon(Images.importerIcone("icon_new_doc.png"));
		this.menuFichier.add(nouvelleEtude);
	}
	
	private void configExporterEtude()
	{
		this.exporterEtude.setIcon(Images.importerIcone("icon_export.png"));
		this.menuFichier.add(exporterEtude);
	}
	
	private void configImporterEtude()
	{
		this.importerEtude.setIcon(Images.importerIcone("icon_import.png"));
		this.menuFichier.add(importerEtude);
	}

}
