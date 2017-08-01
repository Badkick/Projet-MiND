package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChargerEtude implements ActionListener {
	
	private String nom;

	public ChargerEtude(String nom) {
		this.nom=nom;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// mettre ici ce qui se passera quand on appuiera sur le bouton Modifier
		String contraintes="saves"+File.separator+nom+File.separator+"Contraintes.txt";
		Schema1 schema1=null;
		try {
			Pourcentage p_1=null;
			Pourcentage p_2=null;
			Pourcentage r_1=null;
			Pourcentage p_3=null;
			Pourcentage p_4=null;
			Pourcentage r_2=null;
			Pourcentage p_5=null;
			Pourcentage p_6=null;
			Pourcentage r_3=null;
			Pourcentage p_7=null;
			Pourcentage p_8=null;
			Pourcentage r_4=null;
			String risque=null;
			BufferedReader aLire_1 = new BufferedReader(new FileReader(contraintes));
			try{
				p_1=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_2=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				r_1=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_3=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_4=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				r_2=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_5=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_6=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				r_3=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_7=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				p_8=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				r_4=new Pourcentage(Float.parseFloat(aLire_1.readLine()));
			}catch(Exception ex){}
			try{
				risque=aLire_1.readLine();
			}catch(Exception ex){}
			aLire_1.close();
			schema1=new Schema1(p_1,p_2,r_1,p_3,p_4,r_2,p_5,p_6,r_3,p_7,p_8,r_4,risque);
		}
		catch (IOException e1){
			System.out.println("Une operation sur le fichier Contraintes a leve l'exception "+e1);
		}
		
		String structures="saves"+File.separator+nom+File.separator+"Structures.txt";
		Schema2 schema2=null;
		
		try {
			BufferedReader aLire_2 = new BufferedReader(new FileReader(structures));
			Structure st_1=null;
			Structure st_2=null;
			Structure st_ris=null;
			try{
				st_1=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
			}catch(Exception ex){}
			try{
				st_2=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
			}catch(Exception ex){}
			try{
				st_ris=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
			}catch(Exception ex){}
			ElementNote<Structure>[] mtn_notees = new ElementNote[4];
			ElementNote<Structure>[] apr_notees = new ElementNote[4];
			ElementNote<Structure>[] ris_notees = new ElementNote[4];
			for(int i=0;i<4;i++){
				Structure nom_mtn=null;
				Structure nom_apr=null;
				Structure nom_ris=null;
				Integer note_mtn=null;
				Integer note_apr=null;
				Integer note_ris=null;
				try{
					nom_mtn=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
				}catch(Exception ex){}
				try{
					note_mtn=Integer.valueOf(aLire_2.readLine());
				}catch(Exception ex){}
				try{
					mtn_notees[i]=new ElementNote(nom_mtn,note_mtn);
				}catch(NullPointerException ex){mtn_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
				try{
					nom_apr=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
				}catch(Exception ex){}
				try{
					note_apr=Integer.valueOf(aLire_2.readLine());
				}catch(Exception ex){}
				try{
					apr_notees[i]=new ElementNote(nom_apr,note_apr);
				}catch(NullPointerException ex){apr_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
				try{
					nom_ris=Structure.getByNum(Integer.valueOf(aLire_2.readLine()));
				}catch(Exception ex){}
				try{
					note_ris=Integer.valueOf(aLire_2.readLine());
				}catch(Exception ex){}
				try{
					ris_notees[i]=new ElementNote(nom_ris,note_ris);
				}catch(NullPointerException ex){ris_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
			}
			aLire_2.close();
			schema2=new Schema2(st_1,st_2,st_ris,mtn_notees,apr_notees,ris_notees);
			
		}
		catch (IOException e2){
			System.out.println("Une operation sur le fichier Structures a leve l'exception "+e2);
		}
		
		String organisations="saves"+File.separator+nom+File.separator+"Organisations.txt";
		Schema3 schema3=null;
		Organisation org_1=null;
		Organisation org_2=null;
		Organisation org_ris=null;
		try {
			BufferedReader aLire_3 = new BufferedReader(new FileReader(organisations));
			try{
				org_1=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
			}catch(Exception ex){}
			try{
				org_2=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
			}catch(Exception ex){}
			try{
				org_ris=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
			}catch(Exception ex){}
			ElementNote<Organisation>[] mtn_notees = new ElementNote[4];
			ElementNote<Organisation>[] apr_notees = new ElementNote[4];
			ElementNote<Organisation>[] ris_notees = new ElementNote[4];
			for(int i=0;i<4;i++){
				Organisation nom_mtn=null;
				Organisation nom_apr=null;
				Organisation nom_ris=null;
				Integer note_mtn=null;
				Integer note_apr=null;
				Integer note_ris=null;
				try{
					nom_mtn=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
				}catch(Exception ex){}
				try{
					note_mtn=Integer.valueOf(aLire_3.readLine());
				}catch(Exception ex){}
				try{
					mtn_notees[i]=new ElementNote(nom_mtn,note_mtn);
				}catch(NullPointerException ex){mtn_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
				try{
					nom_apr=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
				}catch(Exception ex){}
				try{
					note_apr=Integer.valueOf(aLire_3.readLine());
				}catch(Exception ex){}
				try{
					apr_notees[i]=new ElementNote(nom_apr,note_apr);
				}catch(NullPointerException ex){apr_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
				try{
					nom_ris=Organisation.getByNum(Integer.valueOf(aLire_3.readLine()));
				}catch(Exception ex){}
				try{
					note_ris=Integer.valueOf(aLire_3.readLine());
				}catch(Exception ex){}
				try{
					ris_notees[i]=new ElementNote(nom_ris,note_ris);
				}catch(NullPointerException ex){mtn_notees[i]=new ElementNote(nom_mtn,Integer.MAX_VALUE);}
			}
			aLire_3.close();
			schema3=new Schema3(org_1,org_2,org_ris,mtn_notees,apr_notees,ris_notees);
		}
		catch (IOException e3){
			System.out.println("Une operation sur le fichier Organisations a leve l'exception "+e3);
		}
		
		String relations="saves"+File.separator+nom+File.separator+"Relations.txt";
		Schema4 schema4=null;
		try {
			BufferedReader aLire_4 = new BufferedReader(new FileReader(relations));
			Pourcentage p_1=null;
			Pourcentage p_2=null;
			Pourcentage p_3=null;
			Pourcentage p_4=null;
			Pourcentage p_5=null;
			Pourcentage p_6=null;
			Pourcentage p_7=null;
			Pourcentage p_8=null;
			Pourcentage p_9=null;
			Pourcentage p_10=null;
			Pourcentage p_11=null;
			Pourcentage p_12=null;
			Pourcentage p_13=null;
			Pourcentage p_14=null;
			Pourcentage p_15=null;
			Pourcentage p_16=null;
			Pourcentage p_17=null;
			Pourcentage p_18=null;
			Pourcentage p_19=null;
			Pourcentage p_20=null;
			Pourcentage p_21=null;
			Pourcentage p_22=null;
			Pourcentage p_23=null;
			Pourcentage p_24=null;
			Pourcentage p_25=null;
			Pourcentage p_26=null;
			Pourcentage p_27=null;
			Pourcentage p_28=null;
			Pourcentage p_29=null;
			Pourcentage p_30=null;
			try{
				p_1=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_2=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_3=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Consensus cons_1=new Consensus(p_1,p_2,p_3);
			try{	
				p_4=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_5=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_6=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Consensus cons_2=new Consensus(p_4,p_5,p_6);
			try{
				p_7=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_8=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_9=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Consensus ris_1=new Consensus(p_7,p_8,p_9);
			try{
				p_10=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_11=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_12=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Negociation nego_1=new Negociation(p_10,p_11,p_12);
			try{
				p_13=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_14=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_15=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Negociation nego_2=new Negociation(p_13,p_14,p_15);
			try{
				p_16=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_17=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_18=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Negociation ris_2=new Negociation(p_16,p_17,p_18);
			try{
				p_19=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_20=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_21=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_22=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Opposition opp_1=new Opposition(p_19,p_20,p_21,p_22);
			try{
				p_23=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_24=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_25=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_26=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Opposition opp_2=new Opposition(p_23,p_24,p_25,p_26);
			try{
				p_27=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_28=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_29=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			try{
				p_30=new Pourcentage(Float.parseFloat(aLire_4.readLine()));
			}catch(Exception ex){}
			Opposition ris_3=new Opposition(p_27,p_28,p_29,p_30);
			aLire_4.close();
			schema4=new Schema4(cons_1,cons_2,ris_1, nego_1,nego_2,ris_2, opp_1,opp_2, ris_3);
			
		}
		catch (IOException e4){
			System.out.println("Une operation sur le fichier Relations a leve l'exception "+e4);
		}
		
		String identites="saves"+File.separator+nom+File.separator+"Identites.txt";
		Schema5 schema5=null;
		try {
			BufferedReader aLire_5 = new BufferedReader(new FileReader(identites));
			Pourcentage p_1=null;
			Pourcentage p_2=null;
			Pourcentage p_3=null;
			Pourcentage p_4=null;
			Pourcentage p_5=null;
			Pourcentage p_6=null;
			Pourcentage p_7=null;
			Pourcentage p_8=null;
			Pourcentage p_9=null;
			Pourcentage p_10=null;
			Pourcentage p_11=null;
			Pourcentage p_12=null;
			Pourcentage p_13=null;
			Pourcentage p_14=null;
			Pourcentage p_15=null;
			Pourcentage p_16=null;
			Pourcentage p_17=null;
			Pourcentage p_18=null;
			try{
				p_1=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_2=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_3=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{	
				p_4=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_5=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_6=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_7=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_8=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_9=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_10=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_11=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_12=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_13=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_14=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_15=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_16=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_17=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			try{
				p_18=new Pourcentage(Float.parseFloat(aLire_5.readLine()));
			}catch(Exception ex){}
			
			aLire_5.close();
			schema5=new Schema5(p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8,p_9,p_10,p_11,p_12, p_13, p_14, p_15, p_16, p_17, p_18);
			
		}
		catch (IOException e5){
			System.out.println("Une operation sur le fichier Identites a leve l'exception "+e5);
		}
		
		String mondes="saves"+File.separator+nom+File.separator+"Mondes.txt";
		Schema6 schema6=null;
		Entreprise e_1=null;
		Entreprise e_2=null;
		Entreprise e_3=null;
		try {
			BufferedReader aLire_6 = new BufferedReader(new FileReader(mondes));
			try{
				e_1=Entreprise.getByNum(Integer.valueOf(aLire_6.readLine()));
			}catch(Exception ex){}
			try{
				e_2=Entreprise.getByNum(Integer.valueOf(aLire_6.readLine()));
			}catch(Exception ex){}
			try{
				e_3=Entreprise.getByNum(Integer.valueOf(aLire_6.readLine()));
			}catch(Exception ex){}
			
			aLire_6.close();
			schema6=new Schema6(e_1,e_2,e_3);
			
		}
		catch (IOException e6){
			System.out.println("Une operation sur le fichier Mondes a leve l'exception "+e6);
		}
		
		FenetreAccueil.etude=new Etude(schema1,schema2,schema3,schema4,schema5,schema6);
		FenetreAccueil.conteneur_principal.setTaille(FenetreAccueil.fenetre_principale.getSize());
		ConteneurNouvelleEtude new_etude = new ConteneurNouvelleEtude(FenetreAccueil.fenetre_principale.getSize(), FenetreAccueil.conteneur_principal, FenetreAccueil.fenetre_principale,nom);
		ConteneurNouvelleEtude.save();
		FenetreAccueil.fenetre_principale.setConteneur(new_etude,"Projet MiND - "+nom);
		
	}

}
