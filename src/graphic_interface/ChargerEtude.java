package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChargerEtude implements ActionListener {
	
	private String nom;
	private Theme theme ;

	public ChargerEtude(String nom,Theme theme) {
		this.nom=nom;
		this.theme=theme;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// mettre ici ce qui se passera quand on appuiera sur le bouton Modifier
		String contraintes="saves"+File.separator+nom+File.separator+"Contraintes.txt";
		Schema1 schema1=null;
		try {
			BufferedReader aLire_1 = new BufferedReader(new FileReader(contraintes));
			Pourcentage p_1=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_2=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_3=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_4=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_5=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_6=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_7=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			Pourcentage p_8=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
			aLire_1.close();
			schema1=new Schema1(p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8,null,null,null,null);
		}
		catch (IOException e1){
			System.out.println("Une operation sur le fichier Contraintes a leve l'exception "+e1);
		}
		
		String structures="saves"+File.separator+nom+File.separator+"Structures.txt";
		Schema2 schema2=null;
		try {
			BufferedReader aLire_2 = new BufferedReader(new FileReader(structures));
			Structure st_1=Structure.getByName(aLire_2.readLine());
			Structure st_2=Structure.getByName(aLire_2.readLine());
			ElementNote<Structure>[] mtn_notees = new ElementNote[4];
			ElementNote<Structure>[] apr_notees = new ElementNote[4];
			for(int i=0;i<4;i++){
				mtn_notees[i]=new ElementNote(Structure.getByName(aLire_2.readLine()),Integer.valueOf(aLire_2.readLine()));
				apr_notees[i]=new ElementNote(Structure.getByName(aLire_2.readLine()),Integer.valueOf(aLire_2.readLine()));
			}
			aLire_2.close();
			schema2=new Schema2(st_1,st_2,null,mtn_notees,apr_notees,null);
			
		}
		catch (IOException e2){
			System.out.println("Une operation sur le fichier Structures a leve l'exception "+e2);
		}
		
		String organisations="saves"+File.separator+nom+File.separator+"Organisations.txt";
		Schema3 schema3=null;
		try {
			BufferedReader aLire_3 = new BufferedReader(new FileReader(organisations));
			Organisation org_1=Organisation.getByName(aLire_3.readLine());
			Organisation org_2=Organisation.getByName(aLire_3.readLine());
			ElementNote<Organisation>[] mtn_notees = new ElementNote[4];
			ElementNote<Organisation>[] apr_notees = new ElementNote[4];
			for(int i=0;i<4;i++){
				mtn_notees[i]=new ElementNote(Organisation.getByName(aLire_3.readLine()),Integer.valueOf(aLire_3.readLine()));
				apr_notees[i]=new ElementNote(Organisation.getByName(aLire_3.readLine()),Integer.valueOf(aLire_3.readLine()));
			}
			aLire_3.close();
			schema3=new Schema3(org_1,org_2,mtn_notees,apr_notees);
		}
		catch (IOException e3){
			System.out.println("Une operation sur le fichier Organisations a leve l'exception "+e3);
		}
		
		String relations="saves"+File.separator+nom+File.separator+"Relations.txt";
		Schema4 schema4=null;
		try {
			BufferedReader aLire_4 = new BufferedReader(new FileReader(relations));
			Consensus cons_1=new Consensus(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			Consensus cons_2=new Consensus(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			Negociation nego_1=new Negociation(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			Negociation nego_2=new Negociation(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			Opposition opp_1=new Opposition(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			Opposition opp_2=new Opposition(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
			
			aLire_4.close();
			schema4=new Schema4(cons_1,cons_2,nego_1,nego_2,opp_1,opp_2);
			
		}
		catch (IOException e4){
			System.out.println("Une operation sur le fichier Relations a leve l'exception "+e4);
		}
		
		String identites="saves"+File.separator+nom+File.separator+"Identites.txt";
		Schema5 schema5=null;
		try {
			BufferedReader aLire_5 = new BufferedReader(new FileReader(identites));
			Pourcentage p_1=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_2=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_3=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_4=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_5=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_6=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_7=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_8=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_9=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_10=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_11=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			Pourcentage p_12=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
			schema5=new Schema5(p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8,p_9,p_10,p_11,p_12);
			aLire_5.close();
			
		}
		catch (IOException e5){
			System.out.println("Une operation sur le fichier Identites a leve l'exception "+e5);
		}
		
		String mondes="saves"+File.separator+nom+File.separator+"Mondes.txt";
		Schema6 schema6=null;
		try {
			BufferedReader aLire_6 = new BufferedReader(new FileReader(mondes));
			Entreprise e_1=Entreprise.getByName(aLire_6.readLine());
			Entreprise e_2=Entreprise.getByName(aLire_6.readLine());
			
			aLire_6.close();
			schema6=new Schema6(e_1,e_2);
			
		}
		catch (IOException e6){
			System.out.println("Une operation sur le fichier Mondes a leve l'exception "+e6);
		}
		
		Etude etude=new Etude(schema1,schema2,schema3,schema4,schema5,schema6);
		ConteneurAvecImage conteneur_principal = new ConteneurAvecImage(0,0,theme.getBackground());
		conteneur_principal.setTaille(FenetreAccueil.fenetre_principale.getSize());
		ConteneurNouvelleEtude nouvelle_etude = new ConteneurNouvelleEtude(FenetreAccueil.fenetre_principale.getSize(), theme, FenetreAccueil.conteneur_principal, FenetreAccueil.fenetre_principale,nom,etude);
		FenetreAccueil.fenetre_principale.setConteneur(nouvelle_etude,"Projet MiND - "+nom);
	}

}
