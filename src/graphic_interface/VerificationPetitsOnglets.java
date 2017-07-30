package graphic_interface;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class VerificationPetitsOnglets implements ComponentListener {

	public static final int SCHEMA1 = 1;
	public static final int SCHEMA2 = 2;
	public static final int SCHEMA3 = 3;
	public static final int SCHEMA4 = 4;
	public static final int SCHEMA5 = 5;
	public static final int SCHEMA6 = 6;

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
		int nbNotes=0;
		switch(type)
		{
		case SCHEMA1 :
			try {
				this.getTab().setForeground((this.getConteneur().getContr_tech().get()+this.getConteneur().getEtabl_prot().get()+this.getConteneur().getMena_mar().get()+this.getConteneur().getPress_envir().get()==100.0) ? Color.black : Color.red);
			} catch(NullPointerException ex) {this.getTab().setForeground(Color.red);}
			break;

		case SCHEMA2 :
			if(this.getConteneur().getNote_entrepreneuriale()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_mecaniste()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_professionnelle()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_simple_centralisee()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_simple_marche()!=Integer.MAX_VALUE) nbNotes++;
			this.getTab().setForeground(nbNotes==4 ? Color.black : Color.red);
			break;

		case SCHEMA3 :
			if(this.getConteneur().getNote_rationnelle()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_artisanale()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_personnalisee()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_process()!=Integer.MAX_VALUE) nbNotes++;
			if(this.getConteneur().getNote_flexible()!=Integer.MAX_VALUE) nbNotes++;
			this.getTab().setForeground(nbNotes==4 ? Color.black : Color.red);
			break;

		case SCHEMA4 :
			try {
				this.getTab().setForeground( ( (this.getConteneur().getImportance_consensus().get()+this.getConteneur().getImportance_negociation().get()+this.getConteneur().getImportance_opposition().get()==100.0)
						&& (this.getConteneur().getPetit_consensus().get()+this.getConteneur().getPetit_pacte().get()==100.0)
						&& (this.getConteneur().getPetit_ajustement().get()+this.getConteneur().getPetit_transformation().get()==100.0)
						&& (this.getConteneur().getPetit_domination().get()+this.getConteneur().getPetit_contrePouvoir().get()+this.getConteneur().getPetit_antagonisme().get()==100.0)
						) ? Color.black : Color.red);
			} catch(NullPointerException ex) {this.getTab().setForeground(Color.red);}
			break;

		case SCHEMA5 :
			try {
				this.getTab().setForeground((this.getConteneur().getReglementaire().get()+this.getConteneur().getMobilite().get()+this.getConteneur().getPro_service_public().get()+this.getConteneur().getProfessionnelle().get()+this.getConteneur().getCommunautaire().get()+this.getConteneur().getEntrepreneuriale().get()==100.0) ? Color.black : Color.red);
			} catch(NullPointerException ex) {this.getTab().setForeground(Color.red);}
			break;

		case SCHEMA6 :

			break;
		}
	}


}
