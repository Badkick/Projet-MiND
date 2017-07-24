package graphic_interface;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class UpdateEtude implements ComponentListener {
	
	private int type;
	private TabGraphe tab;

	public UpdateEtude(TabGraphe tab) {
		this.tab = tab;
		this.type = tab.getConteneur_maintenant().getTypeSchema();
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		this.updateEtude(this.tab, this.type);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateEtude(TabGraphe tab, int type)
	{
		switch(type)
		{
		case 1:
			try {FenetreAccueil.etude.getS1().setMtn_contr_tech(tab.getConteneur_maintenant().getContr_tech());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setMtn_etabl_prot(tab.getConteneur_maintenant().getEtabl_prot());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setMtn_mena_mar(tab.getConteneur_maintenant().getMena_mar());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setMtn_press_envir(tab.getConteneur_maintenant().getPress_envir());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setApr_contr_tech(tab.getConteneur_apres().getContr_tech());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setApr_etabl_prot(tab.getConteneur_apres().getEtabl_prot());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setApr_mena_mar(tab.getConteneur_apres().getMena_mar());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setApr_press_envir(tab.getConteneur_apres().getPress_envir());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setRis_contr_tech(((ConteneurSchema) tab.getConteneur_encore_apres()).getContr_tech());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setRis_etabl_prot(((ConteneurSchema) tab.getConteneur_encore_apres()).getEtabl_prot());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setRis_mena_mar(((ConteneurSchema) tab.getConteneur_encore_apres()).getMena_mar());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setRis_press_envir(((ConteneurSchema) tab.getConteneur_encore_apres()).getPress_envir());} catch(NullPointerException ex) {}
			try {FenetreAccueil.etude.getS1().setCommentaire_risque(tab.getCommentaireRisque());} catch(NullPointerException ex) {}
			break;
		}
	}

}
