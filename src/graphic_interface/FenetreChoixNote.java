package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FenetreChoixNote extends JFrame {

	private JTextField demande = new JTextField();

	public FenetreChoixNote(Bouton bouton, ConteneurSchema conteneur) {
		FenetreAccueil.fenetre_principale.setEnabled(false);
		this.setSize(new Dimension(170, 90));
		this.setUndecorated(true); // pour ne pas voir l'en-tête !
		this.setResizable(false); // fenêtre non ajustable
		this.setLocationRelativeTo(bouton); // pour que la fenêtre soit centrée sur le bouton
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		demande.setPreferredSize(new Dimension(160,80));
		demande.setToolTipText("Entrez une note entre 0 et 10, puis faites ENTREE pour valider.");
		demande.setFont(new Font("Arial",Font.BOLD,80));
		demande.setHorizontalAlignment(JTextField.CENTER);

		demande.addActionListener(new RecuperationNote(this,bouton, conteneur));

		this.getContentPane().add(demande);
		this.setVisible(true);
	}

	public class RecuperationNote implements ActionListener {

		private FenetreChoixNote fen;
		private Bouton bouton;
		private String[] autorise = {"0","1","2","3","4","5","6","7","8","9","10",""};
		private ConteneurSchema conteneur;

		public RecuperationNote(FenetreChoixNote fen,Bouton bouton, ConteneurSchema conteneur)
		{
			this.fen = fen;
			this.bouton = bouton;
			this.conteneur = conteneur;
		}

		public void actionPerformed(ActionEvent e) {
			boolean ok = false;
			for(String s : this.autorise) ok |= s.equals(e.getActionCommand()); // vérification que l'on ne rentre que des chiffres valides
			if(ok)
			{
				if(e.getActionCommand().equals("")) {
					FenetreAccueil.fenetre_principale.setEnabled(true);
					this.fen.dispose();
				}
				else {
					FenetreAccueil.fenetre_principale.setEnabled(true);
					this.conteneur.setNote(this.bouton, Integer.valueOf(e.getActionCommand()));
					this.fen.dispose(); // on ferme la fenêtre de changement de texte
				}
			}
			else
			{
				((JTextField) e.getSource()).setText("");
			}
		}
	}
}