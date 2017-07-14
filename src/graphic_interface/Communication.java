package graphic_interface;

import javax.swing.JOptionPane;

public class Communication {

	// CLASSE POUR MAXENCE : COMMUNICATION AVEC LA BDD OU LES FICHIERS DE DONNEES, ET POUR EXPORTATION DES PPT













	// Stoppe le programme. Il faudra changer cette méthode, ou ajouter une méthode redémarrer en cas de changement de thème par exemple.
	public static void quitter()
	{
		System.exit(0);
		//if(messageAttentionChoix("Fermeture","Voulez vous vraiment quitter ? \n Attention, tout travail non enregistré sera perdu.")==JOptionPane.YES_OPTION) System.exit(0);
	}

	// Affiche un message d'erreur avec titre en guise de titre et message à l'intérieur.
	public static void messageErreur(String titre, String message)
	{
		JOptionPane.showMessageDialog(null, message, titre, JOptionPane.ERROR_MESSAGE);
	}

	// Affiche un message d'erreur avec "Erreur" en guise de titre et message à l'intérieur.
	public static void messageErreur(String message)
	{
		messageErreur("Erreur", message);
	}

	// Affiche le message message attention avec un choix oui/non, et titre en guise de titre.
	public static int messageAttentionChoix(String titre, String message)
	{
		return JOptionPane.showConfirmDialog(null,message,titre,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	}

	// Affiche le message message attention avec un choix oui/non, et "Attention" en guise de titre.
	public static int messageAttentionChoix(String message)
	{
		return messageAttentionChoix("Attention", message);
	}
	
	// Affiche une fenêtre demandant d'entrer du texte.
	public static String entrerDuTexte(String titre, String message)
	{
		return JOptionPane.showInputDialog(null,message,titre,JOptionPane.PLAIN_MESSAGE);
	}
}
