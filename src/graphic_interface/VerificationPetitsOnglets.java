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

	private CustomTab tab;

	public VerificationPetitsOnglets(CustomTab tab) {
		this.tab = tab;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		verification((ConteneurSchema) e.getComponent(),this.getTab());
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
	public void componentShown(ComponentEvent e) {}

	public CustomTab getTab() {
		return tab;
	}

	public static void verification(ConteneurSchema conteneur, CustomTab tab)
	{
		int type = conteneur.getTypeSchema();
		int nbNotes=0;
		switch(type)
		{
		case SCHEMA1 :
			try {
				tab.setForeground((conteneur.getContr_tech().get()+conteneur.getEtabl_prot().get()+conteneur.getMena_mar().get()+conteneur.getPress_envir().get()==100.0) ? Color.black : Color.red);
			} catch(NullPointerException ex) {tab.setForeground(Color.red);}
			break;

		case SCHEMA2 :
			if(conteneur.getNote_entrepreneuriale()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_mecaniste()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_professionnelle()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_simple_centralisee()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_simple_marche()!=Integer.MAX_VALUE) nbNotes++;
			tab.setForeground(nbNotes==4 ? Color.black : Color.red);
			break;

		case SCHEMA3 :
			if(conteneur.getNote_rationnelle()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_artisanale()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_personnalisee()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_process()!=Integer.MAX_VALUE) nbNotes++;
			if(conteneur.getNote_flexible()!=Integer.MAX_VALUE) nbNotes++;
			tab.setForeground(nbNotes==4 ? Color.black : Color.red);
			break;

		case SCHEMA4 :
			try {
				tab.setForeground( ( (conteneur.getImportance_consensus().get()+conteneur.getImportance_negociation().get()+conteneur.getImportance_opposition().get()==100.0)
						&& (conteneur.getPetit_consensus().get()+conteneur.getPetit_pacte().get()==100.0)
						&& (conteneur.getPetit_ajustement().get()+conteneur.getPetit_transformation().get()==100.0)
						&& (conteneur.getPetit_domination().get()+conteneur.getPetit_contrePouvoir().get()+conteneur.getPetit_antagonisme().get()==100.0)
						) ? Color.black : Color.red);
			} catch(NullPointerException ex) {tab.setForeground(Color.red);}
			break;

		case SCHEMA5 :
			try {
				tab.setForeground((conteneur.getReglementaire().get()+conteneur.getMobilite().get()+conteneur.getPro_service_public().get()+conteneur.getProfessionnelle().get()+conteneur.getCommunautaire().get()+conteneur.getEntrepreneuriale().get()==100.0) ? Color.black : Color.red);
			} catch(NullPointerException ex) {tab.setForeground(Color.red);}
			break;

		case SCHEMA6 :
			try {
				tab.setForeground( (conteneur.getAction6().isSelected()) ? Color.black : Color.red);
			} catch(NullPointerException ex) {tab.setForeground(Color.red);}
			break;
		}
	}


}
