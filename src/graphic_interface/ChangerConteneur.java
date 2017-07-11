package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangerConteneur implements ActionListener {

	private Fenetre fen;
	private Conteneur con;
	
	public ChangerConteneur(Fenetre fen, Conteneur con)
	{
		this.fen = fen;
		this.con = con;
	}
	
	public void actionPerformed(ActionEvent e) {
		fen.setConteneur(con);
	}

}
