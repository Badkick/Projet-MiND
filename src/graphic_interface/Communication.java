package graphic_interface;

import javax.swing.JOptionPane;

public class Communication {

	// CLASSE POUR MAXENCE : COMMUNICATION AVEC LA BDD OU LES FICHIERS DE DONNEES, ET POUR EXPORTATION DES PPT
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Stoppe le programme. Il faudra changer cette m�thode, ou ajouter une m�thode red�marrer en cas de changement de th�me par exemple.
	public static void quitter()
	{
		System.exit(0);
		//if(JOptionPane.showConfirmDialog(null,"Voulez vous vraiment quitter ? \n Attention, tout travail non enregistr� sera perdu.","Fermeture",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION) System.exit(0);
	}
	
	// Affiche un message d'erreur avec titre en guise de titre et message � l'int�rieur.
	public static void messageErreur(String titre, String message)
	{
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.ERROR_MESSAGE);
	}
	
	// Affiche un message d'erreur avec "Erreur" en guise de titre et message � l'int�rieur.
	public static void messageErreur(String message)
	{
		messageErreur("Erreur", message);
	}
}
