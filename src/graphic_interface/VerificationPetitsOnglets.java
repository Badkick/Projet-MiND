package graphic_interface;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class VerificationPetitsOnglets implements ComponentListener {

	public static final int SCHEMA1 = 1;
	
	private int type;
	private ConteneurSchema conteneur;
	private CustomTab tab;
	
	public VerificationPetitsOnglets(ConteneurSchema conteneur, CustomTab tab) {
		this.type = conteneur.getTypeSchema();
		this.conteneur = conteneur;
		this.tab = tab;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		this.verification();
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

	public ConteneurSchema getConteneur() {
		return conteneur;
	}

	public CustomTab getTab() {
		return tab;
	}
	
	public void verification()
	{
		switch(type)
		{
		case SCHEMA1 :
			try {
				if(this.getConteneur().getContr_tech().get()+this.getConteneur().getEtabl_prot().get()+this.getConteneur().getMena_mar().get()+this.getConteneur().getPress_envir().get()==100.0) 
				{
					this.getTab().setForeground(Color.black);
				}
				else this.getTab().setForeground(Color.red);
			} catch(NullPointerException ex) {}
			break;
		}
	}
	

}
