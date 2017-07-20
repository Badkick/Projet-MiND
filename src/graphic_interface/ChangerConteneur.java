package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ChangerConteneur implements ActionListener {

	public static String TITRE_INITIAL = "Projet MiND";
	
	private Fenetre fen;
	private Conteneur con;
	
	private boolean messageErreur;
	private String titre;
	private String message;
	private String titre_fen = TITRE_INITIAL;
	
	
	public ChangerConteneur(Fenetre fen, Conteneur con, String titre, String message)
	{
		this.fen = fen;
		this.con = con;
		this.messageErreur = true;
		this.titre = titre;
		this.message = message;
	}
	
	public ChangerConteneur(Fenetre fen, Conteneur con, String message)
	{
		this(fen,con,"Attention",message);
	}
	
	public ChangerConteneur(Fenetre fen, Conteneur con)
	{
		this(fen,con,"","");
		this.messageErreur = false;
	}
	
	public ChangerConteneur(String titre_fen, Fenetre fen, Conteneur con, String titre, String message)
	{
		this(fen,con,titre,message);
		this.titre_fen = titre_fen;
	}
	
	public ChangerConteneur(String titre_fen, Fenetre fen, Conteneur con, String message)
	{
		this(fen,con,message);
		this.titre_fen = titre_fen;
	}
	
	public ChangerConteneur(String titre_fen, Fenetre fen, Conteneur con)
	{
		this(fen,con);
		this.titre_fen = titre_fen;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(isErreur() && getTitre().equals(""))
		{
			if(Communication.messageAttentionChoix(getMessage())==JOptionPane.YES_OPTION) fen.setConteneur(con,titre_fen);
		}
		else if (isErreur()) 
		{
			if(Communication.messageAttentionChoix(getTitre(),getMessage())==JOptionPane.YES_OPTION) fen.setConteneur(con,titre_fen);
		}
		else fen.setConteneur(con,titre_fen);
	}
	
	public String getTitre()
	{
		return this.titre;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
	public boolean isErreur()
	{
		return this.messageErreur;
	}

}
